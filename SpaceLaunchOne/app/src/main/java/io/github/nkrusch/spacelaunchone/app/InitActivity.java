package io.github.nkrusch.spacelaunchone.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import java.util.Date;

import androidx.appcompat.app.AppCompatActivity;
import service.InitIntentService;
import service.InitTime;

import static service.InitIntentService.ACTION_INITIALIZE;
import static service.InitIntentService.ACTION_OUTCOME;

/**
 * This class provides necessary methods to initialize application data.
 * This initialization is only necessary on the first launch.
 */
public abstract class InitActivity extends AppCompatActivity {

    private DataInitReceiver serviceReciver;
    private boolean registeredReceiver;

    /**
     * Implement this method to perform some actions after initialization finishes.
     */
    protected abstract void onReceiveHandler();

    /**
     * Listen to broadcasts from application services
     */
    private class DataInitReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (!ACTION_INITIALIZE.equals(intent.getAction())) return;
            SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
            boolean success = intent.getBooleanExtra(ACTION_OUTCOME, false);
            if (success) InitTime.setInitTimestamp(sharedPref);
            onReceiveHandler();
        }
    }

    /**
     * Unregister broadcast received
     */
    protected void onStop() {
        super.onStop();
        if (serviceReciver == null || !registeredReceiver) return;
        try {
            unregisterReceiver(serviceReciver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Check if init has completed t/f
     */
    public static boolean isInitialized(Context context) {
        return InitTime.getInitTimestamp(PreferenceManager.getDefaultSharedPreferences(context)) > 0;
    }

    /**
     * Run app initialization service
     */
    protected void initAppData() {
        serviceReciver = new DataInitReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_INITIALIZE);
        registerReceiver(serviceReciver, intentFilter);
        registeredReceiver = true;

        Intent initIntent = new Intent();
        initIntent.setAction(ACTION_INITIALIZE);
        initIntent.setClass(this, InitIntentService.class);
        startService(initIntent);
    }
}