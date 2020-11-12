package api;

import android.util.Log;

import models.data.BuildConfig;
import retrofit2.Response;

public class ApiDebugger {

    private static final boolean DEBUG = BuildConfig.AppDebug;
    private static String TAG = "API";

    protected static void displayError(Exception e) {
        if (DEBUG) e.printStackTrace();
    }

    private static void Log(String msg) {
        final String DIV = "\n========================\n";
        Log.d(TAG, "\n" + DIV + msg + DIV);
    }

    protected static void httpRequestDetails(String url) {
        Log("URL: " + url);
    }
}
