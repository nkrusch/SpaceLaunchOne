package service;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.util.Log;

import java.util.Date;

import api.OnLoadCallback;

/**
 * The purpose of this service is to periodically sync local app data with external API data.
 */
@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class UpdateJobService extends JobService {

    public static final int UPDATE_DATA_JOB_ID = 1;

    /**
     * Run data synchronization using job service
     */
    @Override
    public boolean onStartJob(JobParameters params) {
        Log.d("SYNC", "starting sync job service...");
        UpdateMethods.UpdateAppData(getApplicationContext(), new OnLoadCallback() {
            @Override
            public void call(Object result) {
                UpdateTime.updateSyncTimestamp(PreferenceManager.getDefaultSharedPreferences(getApplicationContext()));
                Log.d("SYNC", "completed sync job service!");
            }

            @Override
            public void onError(Exception e) {
            }
        });
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}