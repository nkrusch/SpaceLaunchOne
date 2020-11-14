package utilities;

import android.util.Log;

import models.data.BuildConfig;

public class Logger {

    private static final boolean DEBUG = BuildConfig.AppDebug;

    protected static void displayError(Exception e) {
        if (DEBUG) e.printStackTrace();
    }

    public static void Log(String msg) {
        final String DIV = "\n========================\n";
        final String TAG = "DATA";
        Log.d(TAG, ("  " + DIV + msg + DIV));
    }
}
