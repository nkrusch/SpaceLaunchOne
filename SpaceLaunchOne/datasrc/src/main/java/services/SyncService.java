package services;

import android.annotation.TargetApi;
import android.app.IntentService;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.Nullable;
import api.AsyncCallback;
import utilities.Logger;
import utilities.SyncUtilities;

import static services.SyncTime.SYNC_KEY;

/**
 * The purpose of this service is to periodically update local app
 * data by requesting updates from external API.
 * <p>
 * This operation assumes external data is always correct and
 * local maybe stale, thus local state will be overwritten.
 * <p>
 * Two implementations of this service exist, targeting different
 * operating system versions.
 */
public class SyncService {

    /**
     * Arbitrarily selected identifier for this this service.
     */
    public static final int UPDATE_DATA_JOB_ID = 1896;

    /**
     * Launch the sync operation.
     *
     * @param context  Context reference.
     * @param callback Handler for sync result.
     */
    private static void launchSyncAction(Context context, AsyncCallback<Boolean> callback) {
        Runnable r = () -> SyncUtilities.waitAndUpdate(context, callback);
        new Thread(r).start();
    }

    /**
     * Sync service for OS versions that support JobService.
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static class UpdateJobService extends JobService {

        @Override
        public boolean onStartJob(JobParameters params) {
            launchSyncAction(getApplicationContext(), resultHandler());
            return true;
        }

        private AsyncCallback<Boolean> resultHandler() {
            return new AsyncCallback<>() {
                @Override
                public void onSuccess(Boolean result) {
                    Logger.Log("completed sync job service!");
                }

                @Override
                public void onError(Exception e) {
                    Logger.displayError(e);
                }
            };
        }

        @Override
        public boolean onStopJob(JobParameters params) {
            return false;
        }
    }

    /**
     * This service performs the same operations as {@link UpdateJobService}.
     * This intent service if for targeting API versions where JobService
     * is not available.
     */
    public static class UpdateIntentService extends IntentService {

        public UpdateIntentService() {
            super("Update service");
        }

        public UpdateIntentService(String name) {
            super(name);
        }

        @Override
        protected void onHandleIntent(@Nullable Intent intent) {
            if (intent != null && SYNC_KEY.equals(intent.getAction())) {
                launchSyncAction(getApplicationContext(), resultHandler());
            }
        }

        private AsyncCallback<Boolean> resultHandler() {
            return new AsyncCallback<>() {
                @Override
                public void onSuccess(Boolean result) {
                    onActionCompleted();
                }

                @Override
                public void onError(Exception e) {
                    Logger.displayError(e);
                    onActionCompleted();
                }
            };
        }

        /**
         * Broadcast that service data update action has finished.
         * This broadcast occurs always, independent of whether
         * service completed successfully or failed.
         */
        private void onActionCompleted() {
            Intent intent = new Intent();
            intent.setAction(SYNC_KEY);
            sendBroadcast(intent);
        }
    }
}
