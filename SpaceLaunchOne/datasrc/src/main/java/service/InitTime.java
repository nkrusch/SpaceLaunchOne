package service;

import android.content.SharedPreferences;

import java.util.Date;

import utilities.Logger;

public class InitTime extends Logger {

    // change this key name when moving from v.2 -> v.3 to fire off init event
    private final static String INIT_KEY = "app_data_init";

    /**
     * Set the last sync timestamp
     */
    public static void setInitTimestamp(SharedPreferences sharedPref) {
        sharedPref.edit().putLong(INIT_KEY, new Date().getTime()).apply();
        Log("init completed");
    }

    /**
     * Get the last sync timestamp
     */
    public static Long getInitTimestamp(SharedPreferences sharedPref) {
        return sharedPref.getLong(INIT_KEY, 0);
    }

    public static boolean isInitDone(SharedPreferences sharedPref) {
        return getInitTimestamp(sharedPref) > 0;
    }
}
