package io.github.nkrusch.spacelaunchone.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;

import com.cloudinary.Transformation;
import com.cloudinary.android.MediaManager;
import com.cloudinary.utils.StringUtils;
import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import androidx.annotation.Nullable;
import io.github.nkrusch.spacelaunchone.R;
import utilities.ImageResolver;

/**
 * This class provides different utility methods for the app activities and fragments
 */
@SuppressWarnings("SpellCheckingInspection")
public class Utilities {

    @SuppressLint("ResourceType")
    public static String getStatusColor(Resources res, int status) {
        switch (status) {
            case 1:
                return res.getString(R.color.statusGreen); // go
            case 2:
                return "#ff0000"; // no go
            case 3:
                return "#4CAF50"; // success
            case 4:
                return "#FFFF0000"; // fail
            case 5:
                return "#CD4EED"; // hold
            case 6:
                return "#42bcf4"; // in flight
            case 7:
                return "#FFA726"; // partial fail
            default:
                return "#00FFFFFF"; // unknown
        }
    }

    /**
     * Shorthand for determining device orientation
     */
    public static boolean isPortrait(Context context) {
        return context.getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_PORTRAIT;
    }

    /**
     * Convert dp to pixel values
     *
     * @param dp device dp value
     * @param r  resource reference
     * @return pixel value
     */
    public static int dpToPixel(float dp, Resources r) {
        DisplayMetrics metrics = r.getDisplayMetrics();
        float px = dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return Math.round(px);
    }

    public static void showSnackBar(Activity activity, int message, int length) {
        Snackbar mySnackbar = Snackbar.make(
                activity.findViewById(android.R.id.content),
                message, length);
        mySnackbar.show();
    }

    /**
     * Get image url matching specified width
     *
     * @param url   image url
     * @param width image width
     * @return resized image url
     */
    public static String sizedWidth(String url, int width) {
        return sizedImage(url, width, 0);
    }

    /**
     * Get image url matching specified height
     *
     * @param url    image url
     * @param height image height
     * @return resized image url
     */
    public static String sizedHeight(String url, int height) {
        return sizedImage(url, 0, height);
    }

    /**
     * Get image url transformed to desired width/height
     *
     * @param url    image url
     * @param width  image width
     * @param height image height
     * @return updated image url
     */
    private static String sizedImage(String url, int width, int height) {
        if (url == null || url.length() == 0) return null;
        Transformation<?> t = new Transformation<>().gravity("face");
        t = (width > 0) ? t.width(width) : t.height(height);
        return MediaManager.get().url().transformation(t.crop("thumb")
                .fetchFormat("auto")).type("fetch").generate(url);
    }

    /**
     * Get image url transformed to desired width/height
     *
     * @param url  image url
     * @param size image width and height
     * @return updated image url
     */
    public static String squareImage(String url, int size) {
        if (url == null || url.length() == 0) return null;
        Transformation<?> t = new Transformation<>().gravity("face").width(size).height(size);
        return MediaManager.get().url().transformation(t.crop("fill")
                .fetchFormat("auto")).type("fetch").generate(url);
    }

    /**
     * Generate rounded image optimized to specified size
     *
     * @param url    raw image url
     * @param radius output image radius
     * @return scaled and rounded image
     */
    public static String roundImage(String url, int radius) {
        if (url == null || url.length() == 0) return null;
        return MediaManager.get().url().transformation(new Transformation<>()
                .width(radius * 2).height(radius * 2).crop("thumb").chain()
                .radius(radius).crop("thumb")).type("fetch").generate(url);
    }

    /**
     * Get device display size
     *
     * @param wm window manager reference
     * @return width, height
     */
    public static Pair<Integer, Integer> display(WindowManager wm) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        return new Pair<>(width, height);
    }

    /**
     * show simplified time string indicating time until some future event
     * for example: 1 year, 3 days, 2 months etc.
     *
     * @param utc UTC timestamp
     * @param r   Resource reference
     */
    public static String shortTimeDiff(Long utc, Resources r) {
        int[] all = fullTimeDiff(utc);
        int days = all[0], hours = all[1], mins = all[2], secs = all[3];
        if (days > 360) {
            int years = (int) Math.floor(days / 360.0);
            return r.getQuantityString(R.plurals.years, years, years);
        }
        if (days > 99) {
            int months = (int) Math.floor(days / 30.0);
            return r.getQuantityString(R.plurals.months, months, months);
        }
        if (days > 0)
            return r.getQuantityString(R.plurals.days, days, days);
        if (hours > 0)
            return r.getQuantityString(R.plurals.hours, hours, hours);
        if (mins > 0)
            return r.getQuantityString(R.plurals.minutes, mins, mins);
        if (secs > 0)
            return r.getQuantityString(R.plurals.seconds, secs, secs);
        return r.getString(R.string.past);
    }

    /**
     * Get time remaining until some future event
     *
     * @param utc event timestamp in UTC
     * @return [days, hours, minutes, seconds] if event has already
     * passed all values will be zero i.e. [0,0,0,0]
     */
    public static int[] fullTimeDiff(Long utc) {
        Long current = new Date(System.currentTimeMillis()).getTime();
        long diff = Math.max(0, utc - current);
        if (diff < 0) return new int[]{0, 0, 0, 0};

        final double MS = 1000;
        final double MINS = MS * 60;
        final double HOURS = MINS * 60;
        final double DAYS = HOURS * 24;
        int days = ((Double) Math.floor(diff / DAYS)).intValue();
        int hours = ((Double) Math.floor(diff / HOURS % 24)).intValue();
        int mins = ((Double) Math.floor(diff / MINS % 60)).intValue();
        int secs = ((Double) Math.floor(diff / MS % 60)).intValue();
        return new int[]{days, hours, mins, secs};
    }

    /**
     * Convert utc timestamp to date string
     */
    public static String timeLabel(Long utc) {
        Date current = new Date(utc);
        String pattern = "dd MMMM yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        // do not display year if date occurs in current year
        int year = Calendar.getInstance().get(Calendar.YEAR);
        return simpleDateFormat.format(current).replace(year + "", "").trim();
    }

    /**
     * Convert utc timestamp to UTC datetime string
     */
    public static String fullTimeLabel(Long utc) {
        return fullTimeLabel(utc, null);
    }

    public static String fullTimeLabelwithYear(Long utc) {
        return fullTimeLabel(utc, "dd MMMM yyyy, HH:mm 'UTC'");
    }

    /**
     * Convert utc timestamp to UTC datetime string
     *
     * @param utc     UTC timestamp
     * @param pattern date string patter
     */
    @SuppressWarnings("SameParameterValue")
    private static String fullTimeLabel(Long utc, String pattern) {
        Date current = new Date(utc);
        pattern = pattern == null ? "dd MMMM, HH:mm 'UTC'" : pattern;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(current);
    }

    /**
     * Convert UTC time to user's relative timestamp
     *
     * @param utc UTC timestamp
     */
    public static String localTimeLabel(Long utc) {
        return localTimeLabel(utc, null);
    }

    /**
     * Convert UTC time to user's relative timestamp
     *
     * @param utc     UTC timestamp
     * @param pattern datetime pattern
     */
    public static String localTimeLabel(Long utc, String pattern) {
        Date current = new Date(utc);
        pattern = pattern == null ? "d MMMM 'at' HH:mm" : pattern;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.getDefault());
        return simpleDateFormat.format(current);
    }

    /**
     * Check if network is available
     *
     * @param manager ConnectivityManager reference
     */
    public static boolean isNetworkAvailable(@Nullable ConnectivityManager manager) {
        if (manager == null) return false;
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        boolean isAvailable = false;
        if (networkInfo != null && networkInfo.isConnected()) {
            isAvailable = true;
        }
        return isAvailable;
    }

    /**
     * String helper returning first non-null-or-empty String value
     *
     * @param params Collection of Strings to choose from
     * @return first non-empty string or empty String
     */
    public static String coalesce(String... params) {
        for (String param : params)
            if (!StringUtils.isEmpty(param))
                return param;
        return "";
    }

    /**
     * Merge array and string as list
     */
    public static <T> List<T> merge(T[] first, T second) {
        List<T> result = new LinkedList<>();
        if (first != null) result.addAll(Arrays.asList(first));
        if (second != null) result.add(second);
        return result;
    }

    /**
     * Clamp integer value within min-max range. If value is between min and max
     * this function will return value. If value is less than min, this function
     * will return min. If value is above max, this function will return max.
     */
    public static int clamp(int min, int max, int value) {
        return Math.max(min, Math.min(max, value));
    }

    public static boolean isVisible(final View view, int screenWidth, int screenHeight) {
        if (view == null) {
            return false;
        }
        if (!view.isShown()) {
            return false;
        }
        final Rect actualPosition = new Rect();
        view.getGlobalVisibleRect(actualPosition);
        final Rect screen = new Rect(0, 0, screenWidth, screenHeight);
        return actualPosition.intersect(screen);
    }

    public static String countryIcon(String countryCode) {
        if (countryCode == null || countryCode.trim().isEmpty()) return null;

        if (countryCode.indexOf(",") > 0 || countryCode.indexOf("/") > 0) {
            for (String c : countryCode.split("[,/]")) {
                String test = countryIcon(c);
                if (test != null) return test;
            }
            return null;
        }

        String tmp = countryCode.trim().toLowerCase();
        switch (tmp) {
            case "us":
                tmp = "usa";
                break;
            case "eng":
                tmp = "gbr";
                break;
            case "ca":
                tmp = "can";
                break;
            case "are":
                tmp = "uae";
                break;
            case "ger":
                tmp = "deu";
                break;
            case "sgp":
                tmp = "sin";
                break;
        }

        return ImageResolver.countryFlag(tmp);
    }

    public static String countryName(String countryCode) {
        switch ((countryCode + "").trim().toUpperCase()) {

            case "USA":
            case "US":
                return "United States";
            case "CHN":
                return "China";
            case "IND":
                return "India";
            case "FRA":
                return "France";
            case "JPN":
                return "Japan";
            case "KOR":
                return "South Korea";
            case "IRN":
                return "Iran";
            case "ITA":
                return "Italy";
            case "NZL":
                return "New Zealand";
            case "RUS":
                return "Russia";
            case "SAU":
                return "Saudi Arabia";
            case "ARE":
            case "UAE":
                return "United Arab Emirates";
            case "GUF":
                return "French Guiana";
            case "KAZ":
                return "Kazakhstan";
            case "ENG":
            case "GBR":
                return "Great Britain";
            case "CAN":
            case "CA":
                return "Canada";
            case "THA":
                return "Thailand";
            case "TUR":
                return "Turkey";
            case "IDN":
                return "Indonesia";
            case "ESP":
                return "Spain";
            case "ARG":
                return "Argentina";
            case "UKR":
                return "Ukraine";
            case "AUT":
                return "Austria";
            case "AUS":
                return "Australia";
            case "ISR":
                return "Israel";
            case "MEX":
                return "Mexico";
            case "MYS":
                return "Malaysia";
            case "DNK":
                return "Denmark";
            case "SWE":
                return "Sweden";
            case "NLD":
                return "Netherlands";
            case "BRA":
                return "Brazil";
            case "ALB":
                return "Albania";
            case "VNM":
                return "Vietnam";
            case "CHE":
                return "Switzerland";
            case "NOR":
                return "Norway";
            case "POL":
                return "Poland";
            case "DEU":
            case "GER":
                return "Germany";
            case "BGD":
                return "Bangladesh";
            case "PRK":
                return "North Korea";
            case "HRV":
                return "Croatia";
            case "PRT":
                return "Portugal";
            case "BOL":
                return "Bolivia";
            case "URY":
                return "Uruguay";
            case "DZA":
                return "Algeria";
            case "VEN":
                return "Venezuela";
            case "EGY":
                return "Egypt";
            case "BEL":
                return "Belgium";
            case "ZAF":
                return "South Africa";
            case "SGP":
                return "Singapore";
            case "PAK":
                return "Pakistan";
            case "PER":
                return "Peru";
            case "BGR":
                return "Bulgaria";
            case "LUX":
                return "Luxembourg";
            case "COL":
                return "Colombia";
            case "TUN":
                return "Tunisia";
            case "HUN":
                return "Hungary";
            case "LTU":
                return "Lithuania";
            case "AZE":
                return "Azerbaijan";
            case "LKA":
                return "Sri Lanka";
            case "BMU":
                return "Bermuda";
            case "BLR":
                return "Belarus";
            case "MNG":
                return "Mongolia";
            case "MAR":
                return "Morocco";
            case "GRC":
                return "Greece";
            case "UZB":
                return "Uzbekistan";
            case "ROU":
                return "Romania";
            case "TKM":
                return "Turkmenistan";
            case "CZE":
                return "Czechia";
            case "MUS":
                return "Mauritius";
            case "TWN":
                return "Taiwan";
            case "NGA":
                return "Nigeria";
            case "FIN":
                return "Finland";
            case "KEN":
                return "Kenya";
            case "MHL":
                return "Marshall Islands";
            case "UNK":
                return "Unknown";
            default:
                return countryCode;
        }
    }

    public static String getLocationShortName(String name) {
        if (name != null) {
            int splitAt = name.indexOf(",");
            if (splitAt > 0)
                return name.substring(0, splitAt).trim();
        }
        return name;
    }

    public static String getAgencyCountries(String countryCode, int maxCount, Resources res) {

        if (countryCode == null || countryCode.isEmpty()) return "";

        if (!countryCode.contains(",") && !countryCode.contains("/"))
            return countryName(countryCode);

        String[] countries = countryCode.split("[,/]");
        if (countries.length > maxCount)
            return res.getQuantityString(R.plurals.many_countries, countries.length, countries.length);

        StringBuilder tmp = new StringBuilder();
        int counter = 0;
        for (String c : countries) {
            if (counter++ > 0) tmp.append(", ");
            tmp.append(countryName(c));
        }
        return tmp.toString();
    }

    public static String getShortName(String name) {
        if (name != null) {
            int splitAt = name.indexOf(",");
            if (splitAt > 0)
                return name.substring(0, splitAt).trim();
        }
        return name;
    }

    public static String getPlaceName(String name) {
        if (name != null) {
            int splitAt = name.indexOf(",");
            if (splitAt > 0 && splitAt < name.length() - 1)
                return name.substring(splitAt + 1).trim();
        }
        return "";
    }

    public static int statusImage(int status) {
        switch (status) {
            case 1:
                return R.drawable.ic_status_green;
            case 2:
                return R.drawable.ic_status_red;
            case 3:
                return R.drawable.ic_status_success;
            case 4:
                return R.drawable.ic_status_fail;
            case 5:
                return R.drawable.ic_status_on_hold;
            case 6:
                return R.drawable.ic_status_in_flight;
            case 7:
                return R.drawable.ic_status_partial_fail;
            default:
                return R.drawable.ic_status;
        }
    }

    public static SharedPreferences pref(Context ctx) {
        return androidx.preference.PreferenceManager.getDefaultSharedPreferences(ctx);
    }
}
