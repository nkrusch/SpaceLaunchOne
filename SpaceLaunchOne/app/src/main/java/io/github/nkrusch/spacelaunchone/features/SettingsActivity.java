package io.github.nkrusch.spacelaunchone.features;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import io.github.nkrusch.spacelaunchone.R;
import io.github.nkrusch.spacelaunchone.app.SyncActivity;
import io.github.nkrusch.spacelaunchone.app.Utilities;
import io.github.nkrusch.spacelaunchone.features.settings.SettingsFragment;

/**
 * Application settings
 */
public class SettingsActivity extends SyncActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSettingsFragment();
    }

    /**
     * Show settings fragment as content of this activity
     */
    private void setSettingsFragment() {
        SettingsFragment s = SettingsFragment.newInstance(getDataSyncTimeStamp());
        final ConnectivityManager cm = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        final View view = findViewById(android.R.id.content);

        s.setSyncHandler(new SettingsFragment.onSyncRequest() {
            @Override
            public void run() {
                boolean canSync = Utilities.isNetworkAvailable(cm);
                int messageRes = canSync ? R.string.pref_sync_started : R.string.offline_message;
                if (canSync) requestImmediateSync();
                Snackbar.make(view, messageRes, Snackbar.LENGTH_LONG).show();
            }
        });
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, s)
                .commit();
    }

    /**
     * If user syncs app data, replace the settings fragment to
     * reload the sync timestamp
     */
    @Override
    protected void onReceiveHandler() {
        setSettingsFragment();
    }

    /**
     * Handle up action; this activity can be be launched
     * from multiple activities so use finish to navigate backwards in the back stack
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

