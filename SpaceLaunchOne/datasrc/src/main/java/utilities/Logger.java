package utilities;

import android.util.Log;

import apimodels.data.BuildConfig;

public class Logger {

    private static final boolean DEBUG = BuildConfig.AppDebug;

    public static void displayError(Exception e) {
        if (DEBUG) e.printStackTrace();
    }

    public static void Log(String msg) {
        final String DIV = "\n========================\n";
        final String TAG = "SL-1";
        Log.d(TAG, ("  " + DIV + msg + DIV));
    }
}
