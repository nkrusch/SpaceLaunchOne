package service;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build;

import api.OnLoadCallback;
import utilities.Logger;
import utilities.SyncUtilities;

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
        Runnable r = () -> SyncUtilities.waitAndUpdate(
                getApplicationContext(),
                new OnLoadCallback<Boolean>() {
                    @Override
                    public void call(Boolean result) {
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