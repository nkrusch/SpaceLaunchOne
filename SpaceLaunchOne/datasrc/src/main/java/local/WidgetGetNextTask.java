package local;

import android.content.Context;
import android.os.AsyncTask;

import java.util.Date;

/**
 * This task is used by the application widget to get the next upcoming launch from the local database
 */
public class WidgetGetNextTask extends AsyncTask<Context, Void, Launch> {

    private static final int MIN_RECENT = apimodels.data.BuildConfig.MinRecentLimit;

    public interface onLoadComplete {
        void call(Launch result);
    }

    private final onLoadComplete callback;

    public WidgetGetNextTask(onLoadComplete callback) {
        this.callback = callback;
    }

    @Override
    protected Launch doInBackground(final Context... context) {
        long currentTimeMs = new Date(System.currentTimeMillis()).getTime();
        Context ctx = context[0];
        AppDatabase db = AppDatabase.getInstance(ctx);
        Launch launch = db.dao().getNextLaunch(currentTimeMs);
        if (launch == null) {
            return null;
        }
        Long launchDate = db.dao().getLaunchDateUTC(launch.getLuuid());
        Long current = new Date().getTime();
        boolean isRecent = Math.abs(current - launchDate) < MIN_RECENT;
        if (isRecent) UpdateAppData.updateLaunchDetails(ctx, launch.getLuuid(), null);
        return launch;
    }

    @Override
    protected void onPostExecute(Launch result) {
        try {
            callback.call(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
