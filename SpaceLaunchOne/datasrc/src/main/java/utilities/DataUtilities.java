package utilities;

import android.content.Context;
import android.content.SharedPreferences;

import api.OnLoadCallback;
import local.UpdateAppData;
import service.InitTime;

public class DataUtilities {

    private static void waitForInit(Context ctx) {
        SharedPreferences pref = androidx.preference.PreferenceManager
                .getDefaultSharedPreferences(ctx);
        int count = 0;
        while (count < 10) {
            if (InitTime.isInitDone(pref)) break;
            count++;
            try {
                Logger.Log("Thread sleep....");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Logger.displayError(e);
            }
        }
    }

    public static void waitAndUpdate(Context ctx, OnLoadCallback callback) {
        DataUtilities.waitForInit(ctx);
        UpdateAppData.sync(ctx, callback);
    }
}
