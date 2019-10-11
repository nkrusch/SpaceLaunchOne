package service;

import android.app.IntentService;
import android.content.Intent;
import androidx.annotation.Nullable;

import api.OnLoadCallback;

import static service.UpdateTime.SYNC_KEY;

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
        if (intent != null && SYNC_KEY.equals(intent.getAction()))
            new UpdateMethods(getApplicationContext(), new OnLoadCallback() {
                @Override
                public void call(Object result) {
                    onActionCompleted();
                }

                @Override
                public void onError(Exception e) {

                }
            });
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
