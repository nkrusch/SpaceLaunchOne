package utilities;

import android.util.Log;

import java.io.IOException;

import apimodels.data.BuildConfig;
import retrofit2.Call;
import retrofit2.Response;

public class Logger {

    private static final boolean DEBUG = BuildConfig.AppDebug;

    public static void displayError(Exception e) {
        if (DEBUG) e.printStackTrace();
    }

    public static void Log(String msg) {
        final String DIV = "\n========================\n";
        final String TAG = "SL-1";
        if (DEBUG) Log.d(TAG, ("  " + DIV + msg + DIV));
    }

    public static void requestLog(Call<?> request, Response<?> resp) {
        try {
            if (DEBUG) Log("URL: " + request.request().url().toString() +
                    "\nSUCCESS: " + resp.isSuccessful() +
                    "\nERROR: " + (resp.errorBody() != null ? resp.errorBody().string() : "None"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
