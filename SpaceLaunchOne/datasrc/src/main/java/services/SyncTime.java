package services;

import android.content.SharedPreferences;

import java.util.Date;

public class SyncTime {

    public static final String SYNC_KEY = "application_data_sync";
    public static final String SYNC_OFFSET = "data_sync_page";

    /**
     * Update sync preferences.
     *
     * @param sharedPref  Reference to shared preferences.
     * @param offset  Last fetched page.
     */
    public static void updateSyncData(SharedPreferences sharedPref, int offset) {
        sharedPref.edit().putLong(SYNC_KEY, new Date().getTime()).apply();
        sharedPref.edit().putInt(SYNC_OFFSET, Math.max(offset, 0)).apply();
    }

    /**
     * Last datetime when sync was completed.
     *
     * @param sharedPref  Reference to shared preferences.
     */
    public static Long getDataSyncTimestamp(SharedPreferences sharedPref) {
        return sharedPref.getLong(SYNC_KEY, 0);
    }

    /**
     * Last page that was fetched from API.
     *
     * @param sharedPref  Reference to shared preferences.
     */
    public static int getDataSyncOffset(SharedPreferences sharedPref) {
        return sharedPref.getInt(SYNC_OFFSET, 0);
    }
}
