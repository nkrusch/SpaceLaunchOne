package service;

import android.content.SharedPreferences;

import java.util.Date;

import utilities.Logger;

public class SyncTime extends Logger {

    public static final String SYNC_KEY = "application_data_sync";

    public static final String SYNC_OFFSET = "data_sync_page";

    public static void updateSyncData(SharedPreferences sharedPref, int offset) {
        sharedPref.edit().putLong(SYNC_KEY, new Date().getTime()).apply();
        sharedPref.edit().putInt(SYNC_OFFSET, Math.max(offset, 0)).apply();
    }

    public static Long getDataSyncTimestamp(SharedPreferences sharedPref) {
        return sharedPref.getLong(SYNC_KEY, 0);
    }

    public static int getDataSyncOffset(SharedPreferences sharedPref) {
        return sharedPref.getInt(SYNC_OFFSET, 0);
    }
}
