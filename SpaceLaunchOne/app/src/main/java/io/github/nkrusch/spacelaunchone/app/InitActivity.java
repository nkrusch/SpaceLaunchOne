package io.github.nkrusch.spacelaunchone.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;

import java.util.Date;

import service.InitIntentService;

import static service.InitIntentService.ACTION_INITIALIZE;
import static service.InitIntentService.ACTION_OUTCOME;

/**
 * This class provides necessary methods to initialize application data.
 * This initialization is only necessary on the first launch.
 */
public abstract class InitActivity extends AppCompatActivity {

    private final static String INIT_KEY = "application_dataset_initialized";
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
            if (success) sharedPref.edit().putLong(INIT_KEY, new Date().getTime()).apply();
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
     * Get timestamp (UTC) when init was completed
     */
    public static boolean isInitialized(Context context) {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        Long ts = sharedPref.getLong(INIT_KEY, 0);
        Log.d("INIT", ts + "");
        return ts > 0;
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