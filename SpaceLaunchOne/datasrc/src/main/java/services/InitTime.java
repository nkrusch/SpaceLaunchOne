package services;

import android.content.SharedPreferences;

import java.util.Date;

import utilities.Logger;

public class InitTime {

    private final static String INIT_KEY = "app_data_init";

    /**
     * Set the last sync timestamp
     */
    public static void setInitTimestamp(SharedPreferences sharedPref) {
        sharedPref.edit().putLong(INIT_KEY, new Date().getTime()).apply();
        Logger.Log("init completed");
    }

    /**
     * Get the last sync timestamp
     */
    public static Long getInitTimestamp(SharedPreferences sharedPref) {
        return sharedPref.getLong(INIT_KEY, 0);
    }

    /**
     * True if initialization has been completed.
     */
    public static boolean isInitDone(SharedPreferences sharedPref) {
        return getInitTimestamp(sharedPref) > 0;
    }
}
