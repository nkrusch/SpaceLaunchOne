package io.github.nkrusch.spacelaunchone.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.preference.PreferenceManager;

import androidx.appcompat.app.AppCompatActivity;
import service.UpdateIntentService;
import service.UpdateTime;
import utilities.Logger;

import static service.UpdateTime.SYNC_KEY;

/**
 * This class provides necessary methods for activities
 * to interact with the sync services.
 */
public abstract class SyncActivity extends AppCompatActivity {

    private final String TAG = SyncActivity.class.getSimpleName();
    private DataSyncReceiver syncReceiver;
    private boolean receiverRegistered;

    /**
     * Implement this method to perform some actions after sync finishes.
     */
    protected void onReceiveHandler() {
    }

    protected void onStop() {
        super.onStop();
        unregisterReceiver();
    }

    /**
     * Unregister broadcast receiver
     */
    private void unregisterReceiver() {
        if (syncReceiver == null || !receiverRegistered) return;
        try {
            unregisterReceiver(syncReceiver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Get timestamp (UTC) when sync last occurred
     */
    protected Long getDataSyncTimeStamp() {
        return UpdateTime.getDataSyncTimestamp(PreferenceManager.getDefaultSharedPreferences(this));
    }

    /**
     * Listen to broadcasts from application services
     */
    private class DataSyncReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (SYNC_KEY.equals(intent.getAction())) {
                UpdateTime.updateSyncTimestamp(PreferenceManager.getDefaultSharedPreferences(context));
                unregisterReceiver();
                onReceiveHandler();
            }
        }
    }

    /**
     * Call this method to synchronize application data immediately
     */
    protected void requestImmediateSync() {
        if (!InitActivity.isInitialized(this)) {
            Logger.Log("Initializing, will not launch another");
            return;
        }
        if (syncReceiver != null) {
            Logger.Log("Pending sync already running, will not launch another");
            return;
        }
        Logger.Log( "Starting immediate sync...");
        syncReceiver = new DataSyncReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(SYNC_KEY);
        registerReceiver(syncReceiver, intentFilter);
        receiverRegistered = true;

        Intent initIntent = new Intent();
        initIntent.setAction(SYNC_KEY);
        initIntent.setClass(this, UpdateIntentService.class);
        startService(initIntent);
    }
}
