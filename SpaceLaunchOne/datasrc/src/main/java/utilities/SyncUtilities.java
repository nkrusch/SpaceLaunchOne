package utilities;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import api.OnLoadCallback;
import apimodels.data.BuildConfig;
import local.AppDataMethods;
import service.InitTime;
import service.SyncTime;

public class SyncUtilities {

    private static SharedPreferences pref(Context ctx) {
        return androidx.preference.PreferenceManager
                .getDefaultSharedPreferences(ctx);
    }

    private static void waitForInit(Context ctx) {
        int count = 0;
        while (count < 10) {
            if (InitTime.isInitDone(pref(ctx))) break;
            count++;
            try {
                Logger.Log("Thread sleep....");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Logger.displayError(e);
            }
        }
    }

    private static void runUpdate(
            final int counter,
            final Context ctx,
            final int offset,
            @NonNull final OnLoadCallback<Boolean> callback) {
        AppDataMethods.sync(ctx, offset, new OnLoadCallback<ProcessResult>() {
            @Override
            public void call(ProcessResult result) {
                SyncTime.updateSyncData(pref(ctx), result.nextOffset);
                if (result.isSuccess() && counter < BuildConfig.PageCount)
                    runUpdate(counter + 1, ctx, result.getNextOffset(), callback);
                else callback.call(result.isSuccess());
            }
            @Override
            public void onError(Exception e) {
                callback.onError(e);
            }
        });
    }

    public static void waitAndUpdate(Context ctx, @NonNull OnLoadCallback<Boolean> callback) {
        SyncUtilities.waitForInit(ctx);
        final SharedPreferences pref = pref(ctx);
        final int offset = SyncTime.getDataSyncOffset(pref);
        runUpdate(1, ctx, offset, callback);
    }
}
