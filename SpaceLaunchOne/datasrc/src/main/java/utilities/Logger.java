package utilities;

import android.util.Log;

import java.io.IOException;

import models.data.BuildConfig;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Application logger displays debugging info in terminal.
 */
public class Logger {

    /**
     * Whether running debug build variant
     */
    private static final boolean DEBUG = BuildConfig.AppDebug;

    /**
     * Tag to use when logging output --> look for this tag in logcat
     */
    private static final String LOG_TAG = "SL1";

    /**
     * Separator for logged messages
     */
    private static final String SEP = "\n========================\n";

    /**
     * Conditionally log errors
     *
     * @param exception the exception to display.
     */
    public static void displayError(Exception exception) {
        if (DEBUG) exception.printStackTrace();
    }

    /**
     * Conditionally log message to terminal.
     * Message will be displayed when running debug build version.
     *
     * @param message the message to display.
     */
    public static void Log(String message) {
        if (DEBUG) Log.d(LOG_TAG, ("  " + SEP + message + SEP));
    }

    /**
     * Log network request outcome.
     *
     * The method will display requested URL, HTTP status code,
     * and either success or error details.
     *
     * @param request  network request object
     * @param response network response object
     */
    public static void requestLog(Call<?> request, Response<?> response) {

        StringBuilder message = new StringBuilder();

        if (request != null)
            message.append("URL: ").append(request.request().url()).append("\n");

        if (response != null) {
            message.append("CODE").append(response.code());

            if (response.isSuccessful())
                message.append("SUCCESS: true");

            else if (response.errorBody() != null) {
                message.append("ERROR: ");
                try {
                    message.append(response.errorBody().string());
                } catch (IOException e) {
                    message.append(e.getMessage());
                }
            } else message.append("unknown error");
        }

        Log(message.toString());
    }
}
