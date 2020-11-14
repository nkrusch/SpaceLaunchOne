package service;

import android.content.SharedPreferences;

import java.util.Date;

import utilities.Logger;

public class UpdateTime extends Logger {

    public static final String SYNC_KEY = "application_data_sync";

    /**
     * Set the last sync timestamp
     */
    public static void updateSyncTimestamp(SharedPreferences sharedPref) {
        sharedPref.edit().putLong(SYNC_KEY, new Date().getTime()).apply();
        Log("sync completed");
    }

    /**
     * Get the last sync timestamp
     */
    public static Long getDataSyncTimestamp(SharedPreferences sharedPref) {
        return sharedPref.getLong(SYNC_KEY, 0);
    }
}
