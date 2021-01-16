package io.github.nkrusch.spacelaunchone.features.settings;

import android.os.Build;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.SwitchPreference;
import android.view.View;
import android.widget.ListView;

import com.onesignal.OneSignal;

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
    private static String PREF_NOTIFICATIONS;
    private static String PREF_TIMEZONE;
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

    /**
     * set handler for when data sync is requested from preferences
     */
    public void setSyncHandler(onSyncRequest handler) {
        mSyncHandler = handler;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.app_settings);

        PREF_LAST_SYNC = getString(R.string.dataset_last_sync);
        PREF_FREQUENCY_KEY = getString(R.string.sync_frequency);
        PREF_NOTIFICATIONS = getString(R.string.notifications_preference);
        PREF_TIMEZONE = getString(R.string.pref_timezone_key);

        hasInitialized = false;
        initSyncFrequencyPreference();
        initSyncNowPreference();
        initNotificationPreference();
        initTimezonePreference();
        hasInitialized = true;
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        View rootView = getView();
        ListView list = rootView.findViewById(android.R.id.list);
        if (list != null) list.setDivider(null);
        androidx.preference.PreferenceManager
                .setDefaultValues(rootView.getContext(), R.xml.app_settings, false);
    }

    /**
     * Bind preference change listeners for preference with list of options
     */
    private static void bindPreferenceSummaryToValue(Preference preference) {
        Preference.OnPreferenceChangeListener mSummaryToValueListener =
                SettingsFragment::handlePreferenceChange;
        Object value = PreferenceManager
                .getDefaultSharedPreferences(preference.getContext())
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
        if (preference.getKey().equals(PREF_FREQUENCY_KEY) && hasInitialized) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                SyncUtility.scheduleJob(preference.getContext(), true,
                        Integer.parseInt(stringValue));
        }

        return true;
    }

    /**
     * Bind sync frequency preference
     */
    private void initSyncFrequencyPreference() {
        bindPreferenceSummaryToValue(findPreference(PREF_FREQUENCY_KEY));
    }

    /**
     * Set last sync timestamp and bind click handler
     */
    private void initSyncNowPreference() {
        long syncTime = this.getArguments().getLong(EXTRA_SYNC_TS, -1);
        int resId = syncTime > 0 ? R.string.last_sync_timestamp : R.string.last_sync_never_occurred;
        String mLastSync = getResources().getString(resId, Utilities.localTimeLabel(syncTime));
        findPreference(PREF_LAST_SYNC).setSummary(mLastSync + "");
        findPreference(PREF_LAST_SYNC).setOnPreferenceClickListener(
                preference -> {
                    if (mSyncHandler != null) mSyncHandler.run();
                    return true;
                });
    }

    /**
     * Bind notification preference change handler
     */
    private void initNotificationPreference() {
        findPreference(PREF_NOTIFICATIONS).setOnPreferenceChangeListener(
                (preference, newValue) -> {
                    SwitchPreference switchPref = (SwitchPreference) preference;
                    OneSignal.setSubscription(!switchPref.isChecked());
                    return true;
                });
    }

    /**
     * Bind timezone preference change handler
     */
    private void initTimezonePreference() {
        bindPreferenceSummaryToValue(findPreference(PREF_TIMEZONE));
        findPreference(PREF_TIMEZONE).setOnPreferenceChangeListener(
                (preference, newValue) -> {
                    findPreference(PREF_TIMEZONE).setSummary(newValue.toString());
                    return true;
                });
    }
}
