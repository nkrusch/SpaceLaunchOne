package utilities;

import android.content.Context;
import android.content.SharedPreferences;

import api.OnLoadCallback;
import local.AppDataMethods;
import service.InitTime;
import service.SyncTime;

public class DataUtilities {

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

    public static void waitAndUpdate(Context ctx, OnLoadCallback<Boolean> callback) {
        DataUtilities.waitForInit(ctx);
        final SharedPreferences pref = pref(ctx);
        final int offset = SyncTime.getDataSyncOffset(pref);
        AppDataMethods.sync(ctx, offset, new OnLoadCallback<ProcessResult>() {
            @Override
            public void call(ProcessResult result) {
                SyncTime.updateSyncData(pref, result.nextOffset);
                if (callback != null) callback.call(result.success);
            }

            @Override
            public void onError(Exception e) {
                if (callback != null) callback.onError(e);
            }
        });
    }
}
