package io.github.nkrusch.spacelaunchone.app;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Build;
import android.preference.PreferenceManager;
import android.util.Log;

import java.util.Date;

import androidx.annotation.RequiresApi;
import io.github.nkrusch.spacelaunchone.BuildConfig;
import io.github.nkrusch.spacelaunchone.R;
import service.UpdateJobService;
import service.UpdateTime;

import static service.UpdateJobService.UPDATE_DATA_JOB_ID;


/**
 * This class provides job service scheduling and other utility methods related to syncing data
 */
public class SyncUtility {

    private static final String TAG = "SYNC";
    private static final int MS_IN_HOUR = 60 * 60 * 1000;

    /**
     * Get interval how often to run data synchronization
     */
    private static Long getSyncInterval(Context context) {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        String pref = sharedPref.getString(context.getResources().getString(R.string.sync_frequency), null);
        int SYNC_INTERVAL_HOURS = (pref == null) ? BuildConfig.UpdateInterval : Integer.parseInt(pref);
        final long interval_milliseconds = SYNC_INTERVAL_HOURS * MS_IN_HOUR;
        Log.d(TAG, "sync interval: " + SYNC_INTERVAL_HOURS);
        return interval_milliseconds;
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    static void scheduleJob(Context context) {
        scheduleJob(context, false, -1);
    }

    /**
     * Use job service on newer devices
     */
    @SuppressWarnings("ConstantConditions")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    public static void scheduleJob(Context context, boolean overridePrevious, int intervalHours) {
        final long interval_milliseconds = overridePrevious ? intervalHours * MS_IN_HOUR : getSyncInterval(context);
        ComponentName componentName = new ComponentName(context, UpdateJobService.class);
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService(Context.JOB_SCHEDULER_SERVICE);

        JobInfo previous = null;
        for (JobInfo ji : jobScheduler.getAllPendingJobs()) {
            if (ji.getId() == UPDATE_DATA_JOB_ID) {
                previous = ji;
                break;
            }
        }
        if (previous != null && !overridePrevious) {
            Log.d(TAG, "already scheduled, will not reschedule");
            return;
        }
        jobScheduler.cancel(UPDATE_DATA_JOB_ID);
        JobInfo jobInfo = new JobInfo.Builder(UPDATE_DATA_JOB_ID, componentName)
                .setRequiresCharging(false)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                .setPeriodic(interval_milliseconds)
                .build();
        int resultCode = jobScheduler.schedule(jobInfo);
        Log.d(TAG, resultCode == JobScheduler.RESULT_SUCCESS ? "Job scheduled!" : "Job not scheduled");
    }

    /**
     * Check if sync should occur on pre-lollipop devices
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static boolean shouldRunPeriodicSyncPreLollipop(Context context) {
        Long intervalMilliseconds = getSyncInterval(context);
        Long lastSync = UpdateTime.getDataSyncTimestamp(PreferenceManager.getDefaultSharedPreferences(context));
        Long elapsedTimeSinceLastCheck = new Date().getTime() - lastSync;

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return elapsedTimeSinceLastCheck > intervalMilliseconds && Utilities.isNetworkAvailable(cm);
    }
}
