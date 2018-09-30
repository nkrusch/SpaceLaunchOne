package io.github.nkrusch.spacelaunchone.features.settings;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ListView;

import io.github.nkrusch.spacelaunchone.R;
import io.github.nkrusch.spacelaunchone.app.SyncUtility;
import io.github.nkrusch.spacelaunchone.app.Utilities;

/**
 * Settings activity allows
 * - changing data sync schedule
 * - running the sync method immediately
 * - reading about this app
 */
public class SettingsFragment extends PreferenceFragment {

    private static final String EXTRA_SYNC_TS = "last_sync_timestamp";
    private static String PREF_FREQUENCY_KEY;
    private static String PREF_LAST_SYNC;
    private onSyncRequest mSyncHandler;
    private static boolean hasInitialized;

    public interface onSyncRequest {
        void run();
    }

    public static SettingsFragment newInstance(long lastSyncTime) {
        SettingsFragment f = new SettingsFragment();
        Bundle args = new Bundle();
        args.putLong(EXTRA_SYNC_TS, lastSyncTime);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PREF_FREQUENCY_KEY = getString(R.string.sync_frequency);
        PREF_LAST_SYNC = getString(R.string.dataset_last_sync);
        Long syncTime = this.getArguments().getLong(EXTRA_SYNC_TS, -1);
        hasInitialized = false;

        addPreferencesFromResource(R.xml.app_settings);
        bindPreferenceSummaryToValue(findPreference(PREF_FREQUENCY_KEY));
        displayLastSyncTime(syncTime);
        bindSyncHandler();
        hasInitialized = true;
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        View rootView = getView();
        ListView list = rootView.findViewById(android.R.id.list);
        if (list != null) list.setDivider(null);
    }

    /**
     * set handler for when data sync is requested from preferences
     */
    public void setSyncHandler(onSyncRequest handler) {
        mSyncHandler = handler;
    }

    /**
     * Update sync job schedule
     */
    private static void onSyncFrequencyChange(Context ctx, Object newValue) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            SyncUtility.scheduleJob(ctx, true, Integer.parseInt(newValue.toString()));
    }

    /**
     * Add callback when user requests immediate sync
     */
    private void bindSyncHandler() {
        android.preference.Preference startSync = findPreference(PREF_LAST_SYNC);
        startSync.setOnPreferenceClickListener(new android.preference.Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(android.preference.Preference preference) {
                if (mSyncHandler != null) mSyncHandler.run();
                return true;
            }
        });
    }

    /**
     * Display timestamp when data sync last executed
     */
    private void displayLastSyncTime(Long syncTime) {
        int resId = syncTime > 0 ? R.string.last_sync_timestamp : R.string.last_sync_never_occurred;
        String mLastSync = getResources().getString(resId, Utilities.localTimeLabel(syncTime));
        findPreference(PREF_LAST_SYNC).setSummary(mLastSync + "");
    }

    /**
     * Bind preference change listeners
     */
    private static void bindPreferenceSummaryToValue(Preference preference) {
        Preference.OnPreferenceChangeListener mSummaryToValueListener = new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                return handlePreferenceChange(preference, newValue);
            }
        };
        Object value = PreferenceManager.getDefaultSharedPreferences(preference.getContext())
                .getString(preference.getKey(), "");

        preference.setOnPreferenceChangeListener(mSummaryToValueListener);
        mSummaryToValueListener.onPreferenceChange(preference, value);
    }

    @SuppressWarnings("SameReturnValue")
    private static boolean handlePreferenceChange(android.preference.Preference preference, Object value) {
        String stringValue = value.toString();
        if (preference instanceof ListPreference) {
            ListPreference listPreference = (ListPreference) preference;
            int index = listPreference.findIndexOfValue(stringValue);

            preference.setSummary(index >= 0 ? listPreference.getEntries()[index] : null);
        } else {
            preference.setSummary(stringValue);
        }
        if (preference.getKey().equals(PREF_FREQUENCY_KEY) && hasInitialized)
            onSyncFrequencyChange(preference.getContext(), value);

        return true;
    }

}
