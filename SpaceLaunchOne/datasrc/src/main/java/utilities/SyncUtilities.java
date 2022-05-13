package utilities;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import api.AsyncCallback;
import local.AppDataMethods;
import models.data.BuildConfig;
import services.InitTime;
import services.SyncTime;

public class SyncUtilities {

    private static SharedPreferences pref(Context ctx) {
        return androidx.preference.PreferenceManager
                .getDefaultSharedPreferences(ctx);
    }

    private static void waitForInit(Context ctx) {
        for (int i = 0; i < 10; i++) {
            if (InitTime.isInitDone(pref(ctx))) break;
            try {
                Logger.Log("Waiting for init....");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Logger.displayError(e);
            }
        }
    }


    private static void runUpdate(
            final int counter, final Context ctx, final int offset,
            @NonNull final AsyncCallback<Boolean> callback
    ) {
        AppDataMethods.sync(ctx, offset, new AsyncCallback<>() {
            @Override
            public void onSuccess(ProcessResult result) {
                SyncTime.updateSyncData(pref(ctx), result.nextOffset);
                if (result.isSuccess() && counter < BuildConfig.PageCount)
                    runUpdate(counter + 1, ctx, result.getNextOffset(), callback);
                else callback.onSuccess(result.isSuccess());
            }

            @Override
            public void onError(Exception e) {
                callback.onError(e);
            }
        });
    }

    public static void waitAndUpdate(Context ctx, @NonNull AsyncCallback<Boolean> callback) {
        SyncUtilities.waitForInit(ctx);
        final SharedPreferences pref = pref(ctx);
        final int offset = SyncTime.getDataSyncOffset(pref);
        runUpdate(1, ctx, offset, callback);
    }
}
