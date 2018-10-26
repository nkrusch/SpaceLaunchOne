package io.github.nkrusch.spacelaunchone.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.Nullable;
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
}
