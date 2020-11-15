package service;

import android.content.SharedPreferences;

import java.util.Date;

import utilities.Logger;

public class InitTime extends Logger {

    private final static String INIT_KEY = "application_dataset_initialized";

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
        Long timestamp = sharedPref.getLong(INIT_KEY, 0);
        Log("init time: "+timestamp);
        return timestamp;
    }
}