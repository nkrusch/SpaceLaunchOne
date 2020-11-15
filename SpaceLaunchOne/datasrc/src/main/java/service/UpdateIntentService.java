package service;

import android.app.IntentService;
import android.content.Intent;

import androidx.annotation.Nullable;
import api.OnLoadCallback;
import utilities.SyncUtilities;
import utilities.Logger;

import static service.SyncTime.SYNC_KEY;

/**
 * This service performs the same operations as {@link UpdateJobService}.
 * This intent service if for targeting API versions where JobService is not available.
 */
public class UpdateIntentService extends IntentService {

    public UpdateIntentService() {
        super("Update service");
    }

    public UpdateIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent != null && SYNC_KEY.equals(intent.getAction())) {
            Runnable r = () -> SyncUtilities.waitAndUpdate(
                    getApplicationContext(),
                    new OnLoadCallback<Boolean>() {
                        @Override
                        public void call(Boolean result) {
                            onActionCompleted();
                        }

                        @Override
                        public void onError(Exception e) {
                            Logger.displayError(e);
                            onActionCompleted();
                        }
                    });
            new Thread(r).start();
        }
    }

    /**
     * Broadcast that service data update action has finished;
     */
    private void onActionCompleted() {
        Intent intent = new Intent();
        intent.setAction(SYNC_KEY);
        sendBroadcast(intent);
    }
}
