package service;

import android.app.IntentService;
import android.content.Intent;

import androidx.annotation.Nullable;
import api.OnLoadCallback;
import apimodels.data.BuildConfig;
import local.AppDataMethods;
import utilities.ProcessResult;

/**
 * This intent service fetches remote data one time when application first runs.
 * This service fetches just enough data to render the main activity.
 * When complete, it broadcasts the result as either true/false
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
            AppDataMethods.init(this, BuildConfig.InitialLoadSize,
                    new OnLoadCallback<ProcessResult>() {
                        @Override
                        public void call(ProcessResult result) {
                            onActionCompleted(ACTION_INITIALIZE, result.isSuccess());
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
