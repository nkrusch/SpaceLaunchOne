package utilities;

import android.util.Log;

import models.data.BuildConfig;

public class Logger {

    private static final boolean DEBUG = BuildConfig.AppDebug;
    private static String TAG = "API";

    protected static void displayError(Exception e) {
        if (DEBUG) e.printStackTrace();
    }

    public static void Log(String msg) {
        final String DIV = "\n========================\n";
        Log.d(TAG, "\n" + DIV + msg + DIV);
    }
}
