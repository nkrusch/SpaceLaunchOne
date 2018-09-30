package service;

import android.content.SharedPreferences;
import android.util.Log;

import java.util.Date;

public class UpdateTime {

    public static final String SYNC_KEY = "application_data_sync";

    /**
     * Set the last sync timestamp
     */
    public static void updateSyncTimestamp(SharedPreferences sharedPref) {
        sharedPref.edit().putLong(SYNC_KEY, new Date().getTime()).apply();
        Log.d("SYNC", "marked sync completed");
    }

    /**
     * Get the last sync timestamp
     */
    public static Long getDataSyncTimestamp(SharedPreferences sharedPref) {
        return sharedPref.getLong(SYNC_KEY, 0);
    }
}
