package io.github.nkrusch.spacelaunchone.app;

import android.content.Context;
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

/**
 * This class provides different utility methods for the app activities and fragments
 */
@SuppressWarnings("SpellCheckingInspection")
public class Utilities {

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
        Transformation t = new Transformation().gravity("face");
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
        Transformation t = new Transformation().gravity("face").width(size).height(size);
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
        return MediaManager.get().url().transformation(new Transformation()
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
        Long diff = Math.max(0, utc - current);
        if (diff < 0) return new int[]{0, 0, 0, 0};

        final int MS = 1000;
        final int MINS = MS * 60;
        final int HOURS = MINS * 60;
        final int DAYS = HOURS * 24;
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

    public static int countryIcon(String countryCode) {
        if (countryCode == null || countryCode.isEmpty())
            return R.drawable.ic_earth;

        if (countryCode.indexOf(",") > 0 || countryCode.indexOf("/") > 0) {
            for (String c : countryCode.split(",|/")) {
                int test = countryIcon(c);
                if (test != R.drawable.ic_earth)
                    return test;
            }
            return R.drawable.ic_earth;
        }

        switch (countryCode.toUpperCase()) {
            case "USA":
            case "US":
                return R.drawable.flag_usa;
            case "CHN":
                return R.drawable.flag_chn;
            case "IND":
                return R.drawable.flag_ind;
            case "FRA":
                return R.drawable.flag_fra;
            case "JPN":
                return R.drawable.flag_jpn;
            case "KOR":
                return R.drawable.flag_kor;
            case "NZL":
                return R.drawable.flag_nzl;
            case "RUS":
                return R.drawable.flag_rus;
            case "IRN":
                return R.drawable.flag_irn;
            case "GUF":
                return R.drawable.flag_guf;
            case "KAZ":
                return R.drawable.flag_kaz;
            case "ENG":
            case "GBR":
                return R.drawable.flag_gbr;
            case "ITA":
                return R.drawable.flag_ita;
            case "CAN":
            case "CA":
                return R.drawable.flag_can;
            case "THA":
                return R.drawable.flag_tha;
            case "TUR":
                return R.drawable.flag_tur;
            case "IDN":
                return R.drawable.flag_idn;
            case "ESP":
                return R.drawable.flag_esp;
            case "ARG":
                return R.drawable.flag_arg;
            case "UKR":
                return R.drawable.flag_ukr;
            case "AUT":
                return R.drawable.flag_aut;
            case "AUS":
                return R.drawable.flag_aus;
            case "ISR":
                return R.drawable.flag_isr;
            case "MEX":
                return R.drawable.flag_mex;
            case "MYS":
                return R.drawable.flag_mys;
            case "DNK":
                return R.drawable.flag_dnk;
            case "SAU":
                return R.drawable.flag_sau;
            case "SWE":
                return R.drawable.flag_swe;
            case "NLD":
                return R.drawable.flag_nld;
            case "BRA":
                return R.drawable.flag_bra;
            case "ALB":
                return R.drawable.flag_alb;
            case "ARE":
            case "UAE":
                return R.drawable.flag_uae;
            case "VNM":
                return R.drawable.flag_vnm;
            case "CHE":
                return R.drawable.flag_che;
            case "NOR":
                return R.drawable.flag_nor;
            case "POL":
                return R.drawable.flag_pol;
            case "DEU":
            case "GER":
                return R.drawable.flag_deu;
            case "BGD":
                return R.drawable.flag_bgd;
            case "PRK":
                return R.drawable.flag_prk;
            case "HRV":
                return R.drawable.flag_hrv;
            case "PRT":
                return R.drawable.flag_prt;
            case "BOL":
                return R.drawable.flag_bol;
            case "URY":
                return R.drawable.flag_ury;
            case "DZA":
                return R.drawable.flag_dza;
            case "VEN":
                return R.drawable.flag_ven;
            case "EGY":
                return R.drawable.flag_egy;
            case "BEL":
                return R.drawable.flag_bel;
            case "ZAF":
                return R.drawable.flag_zaf;
            case "SGP":
                return R.drawable.flag_sin;
            case "PAK":
                return R.drawable.flag_pak;
            case "PER":
                return R.drawable.flag_per;
            case "BGR":
                return R.drawable.flag_bgr;
            case "LUX":
                return R.drawable.flag_lux;
            case "COL":
                return R.drawable.flag_col;
            case "TUN":
                return R.drawable.flag_tun;
            case "HUN":
                return R.drawable.flag_hun;
            case "LTU":
                return R.drawable.flag_ltu;
            case "AZE":
                return R.drawable.flag_aze;
            case "LKA":
                return R.drawable.flag_lka;
            case "BMU":
                return R.drawable.flag_bmu;
            case "BLR":
                return R.drawable.flag_blr;
            case "MNG":
                return R.drawable.flag_mng;
            case "MAR":
                return R.drawable.flag_mar;
            case "GRC":
                return R.drawable.flag_grc;
            case "UZB":
                return R.drawable.flag_uzb;
            case "ROU":
                return R.drawable.flag_rou;
            case "TKM":
                return R.drawable.flag_tkm;
            case "CZE":
                return R.drawable.flag_cze;
            case "MUS":
                return R.drawable.flag_mus;
            case "TWN":
                return R.drawable.flag_twn;
            case "NGA":
                return R.drawable.flag_nga;
            case "FIN":
                return R.drawable.flag_fin;
            case "KEN":
                return R.drawable.flag_ken;
            case "MHL":
                return R.drawable.flag_mhl;
            default:
                return R.drawable.ic_earth;
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

}
