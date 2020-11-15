package service;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;

import api.OnLoadCallback;
import utilities.DataUtilities;
import utilities.Logger;

/**
 * The purpose of this service is to periodically
 * update local app data by requesting updates from external API.
 * This is 1-way operation where external is always correct and
 * local maybe stale.
 */
@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class UpdateJobService extends JobService {

    public static final int UPDATE_DATA_JOB_ID = 1896;

    @Override
    public boolean onStartJob(JobParameters params) {
        final SharedPreferences pref = PreferenceManager
                .getDefaultSharedPreferences(getApplicationContext());
        Runnable r = () -> DataUtilities.waitAndUpdate(
                getApplicationContext(),
                new OnLoadCallback() {
                    @Override
                    public void call(Object result) {
                        UpdateTime.updateSyncTimestamp(pref);
                        Logger.Log("completed sync job service!");
                    }

                    @Override
                    public void onError(Exception e) {
                        Logger.displayError(e);
                    }
                });
        new Thread(r).start();
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}