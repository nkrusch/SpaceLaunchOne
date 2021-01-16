package io.github.nkrusch.spacelaunchone.features.splash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import androidx.appcompat.app.AppCompatActivity;
import io.github.nkrusch.spacelaunchone.app.Utilities;
import service.InitIntentService;
import service.InitTime;

import static service.InitIntentService.ACTION_INITIALIZE;
import static service.InitIntentService.ACTION_OUTCOME;

/**
 * This class provides necessary base methods to initialize application data.
 * This initialization is only necessary on the first launch.
 */
public abstract class InitActivity extends AppCompatActivity {

    private DataInitReceiver dataInitReceiver;
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
            boolean success = intent.getBooleanExtra(ACTION_OUTCOME, false);
            if (success) InitTime.setInitTimestamp(Utilities.pref(context));
            onReceiveHandler();
        }
    }

    /**
     * Unregister broadcast receiver
     */
    protected void onStop() {
        super.onStop();
        if (dataInitReceiver == null || !registeredReceiver) return;
        try {
            unregisterReceiver(dataInitReceiver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Run app initialization service
     */
    protected void initAppData() {
        dataInitReceiver = new DataInitReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_INITIALIZE);
        registerReceiver(dataInitReceiver, intentFilter);
        registeredReceiver = true;

        Intent initIntent = new Intent();
        initIntent.setAction(ACTION_INITIALIZE);
        initIntent.setClass(this, InitIntentService.class);
        startService(initIntent);
    }
}