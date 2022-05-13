package services;

import android.app.IntentService;
import android.content.Intent;

import androidx.annotation.Nullable;
import api.AsyncCallback;
import local.AppDataMethods;
import models.data.BuildConfig;
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

    /**
     * Launch the app data initialization process.
     */
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent != null && ACTION_INITIALIZE.equals(intent.getAction())) {
            AppDataMethods.init(this, BuildConfig.InitialLoadSize, resultHandler());
        }
    }

    /**
     * Broadcast that service handler action has finished.
     * This broadcast will occur always, independent of action succeeding or failing.
     *
     * @param result Whether initialization completed successfully.
     */
    private void onActionCompleted(boolean result) {
        Intent intent = new Intent();
        intent.setAction(ACTION_INITIALIZE);
        intent.putExtra(ACTION_OUTCOME, result);
        sendBroadcast(intent);
    }

    private AsyncCallback<ProcessResult> resultHandler() {
        return new AsyncCallback<>() {
            @Override
            public void onSuccess(ProcessResult result) {
                onActionCompleted(result.isSuccess());
            }

            @Override
            public void onError(Exception e) {
                onActionCompleted(false);
            }
        };
    }
}
