package service;

import android.app.IntentService;
import android.content.Intent;

import androidx.annotation.Nullable;
import api.LaunchLibrary;
import api.OnLoadCallback;
import apimodels.LaunchList;
import local.AppDatabase;
import apimodels.data.BuildConfig;

/**
 * This intent service fetches remote data one time when application first runs.
 * This service fetches just enough data to render the main activity.
 */
public class InitIntentService extends IntentService {

    public final static String ACTION_OUTCOME = "action_init_succeeded";
    public final static String ACTION_INITIALIZE = "action_initialize";

    public InitIntentService() {
        super("Initialization service");
    }

    public InitIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent != null && ACTION_INITIALIZE.equals(intent.getAction())) {

            final AppDatabase db = AppDatabase.getInstance(this);

            LaunchLibrary.initialLaunches(BuildConfig.InitialLoadSize, new OnLoadCallback<LaunchList>() {
                @Override
                public void call(LaunchList result) {
                    UpdateMethods.processLaunches(db, result, new OnLoadCallback<Boolean>() {
                        @Override
                        public void call(Boolean result) {
                            onActionCompleted(ACTION_INITIALIZE, result);
                        }
                        @Override
                        public void onError(Exception e) {
                            onActionCompleted(ACTION_INITIALIZE, false);
                        }
                    });
                }

                @Override
                public void onError(Exception e) {
                    onActionCompleted(ACTION_INITIALIZE, false);
                }
            });
        }
    }

    /**
     * Broadcast that service data update action has finished;
     */
    @SuppressWarnings("SameParameterValue")
    private void onActionCompleted(String action, boolean result) {
        Intent intent = new Intent();
        intent.setAction(action);
        intent.putExtra(ACTION_OUTCOME, result);
        sendBroadcast(intent);
    }
}
