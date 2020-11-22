package io.github.nkrusch.spacelaunchone.features.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.SystemClock;
import android.widget.RemoteViews;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import androidx.annotation.RequiresApi;
import io.github.nkrusch.spacelaunchone.R;
import io.github.nkrusch.spacelaunchone.app.Utilities;
import io.github.nkrusch.spacelaunchone.features.DetailsLaunchActivity;
import io.github.nkrusch.spacelaunchone.features.MainActivity;
import local.WidgetGetNextTask;
import service.InitTime;
import utilities.AppExecutors;

import static android.view.View.VISIBLE;
import static io.github.nkrusch.spacelaunchone.features.DetailsLaunchActivity.EXTRA_WIDGET_LAUNCHER;

/**
 * This app widget loads details about next upcomng launch and
 * displays a countdown to that launch in app widget.
 * This widget user Chronometer with countdown, which is not available below API 24
 */
@SuppressWarnings("SpellCheckingInspection")
@RequiresApi(24)
public class CountdownWidget extends AppWidgetProvider {

    private String launchId = null;
    private Long TargetDate = null;
    private String launchEventName;
    private boolean isLoading = false;

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    private void onUpdate(Context context) {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        ComponentName thisAppWidget = new ComponentName(context.getPackageName(), CountdownWidget.class.getName());
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(thisAppWidget);
        onUpdate(context, appWidgetManager, appWidgetIds);
    }

    /**
     * Update widget state
     */
    private void updateAppWidget(final Context context, final AppWidgetManager appWidgetManager, final int appWidgetId) {
        final RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.countdown_widget);

        // ensure details loaded
        if (TargetDate == null && !isLoading)
            loadNextLaunchDetails(context);

        // set launch name
        views.setTextViewText(R.id.launch_name, launchEventName);

        // set time
        if (TargetDate != null)
            setTime(appWidgetManager, appWidgetId, views);

        // set image
        setImage(context, appWidgetManager, appWidgetId, views);

        // bind click action
        bindClickAction(context, appWidgetId, views);

        // update view
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    /**
     * Load next launch details then update widget.
     * Also check if app has been initialized before fetching launch details
     * because otherwise the database read will not work. Ideally, user launches
     * app at least once before trying to add widget but in case they don't, this way
     * the widget does not crash.
     */
    private void loadNextLaunchDetails(final Context context) {
        final String unavailable = context.getResources().getString(R.string.widget_unavailable);

        if (InitTime.isInitDone(Utilities.pref(context))) {
            launchEventName = context.getResources().getString(R.string.widget_loading);
            isLoading = true;
            onUpdate(context);
            new WidgetGetNextTask(result -> {
                if (launchId == null && result == null) {
                    launchEventName = unavailable;
                } else {
                    launchId = result.getLuuid();
                    launchEventName = result.getName();
                    TargetDate = result.getLaunchDateUTC();
                }
                onUpdate(context);
                isLoading = false;
            }).execute(context);
        } else {
            launchEventName = unavailable;
            isLoading = true;
            onUpdate(context);
            isLoading = false;
        }
    }

    /**
     * Load the widget image
     */
    private void setImage(
            final Context context, final AppWidgetManager appWidgetManager,
            final int appWidgetId, final RemoteViews views) {
        AppExecutors.getInstance().MainThread().execute(() -> {
            try {
                TypedArray imgs = context.getResources().obtainTypedArray(R.array.next_launch_images);
                int dailyImageIndex = Calendar.getInstance().get(Calendar.DAY_OF_YEAR) % imgs.length();
                Bitmap bm = BitmapFactory.decodeResource(context.getResources(), imgs.getResourceId(dailyImageIndex, -1));
                float ratio = bm.getHeight() / (float) (Math.max(1, bm.getWidth()));
                int imageWidth = 200;
                int imageHeight = Math.round(ratio * imageWidth);
                Bitmap scaledBm = Bitmap.createScaledBitmap(bm, imageWidth, imageHeight, false);
                views.setImageViewBitmap(R.id.widget_image, scaledBm);
                views.setViewVisibility(R.id.widget_image, VISIBLE);
                imgs.recycle();
                appWidgetManager.updateAppWidget(appWidgetId, views);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Set widget time value
     */
    private void setTime(final AppWidgetManager appWidgetManager, final int appWidgetId, final RemoteViews views) {
        AppExecutors.getInstance().MainThread().execute(() -> {
            long totalTime = SystemClock.elapsedRealtime() + (TargetDate - new Date().getTime());
            int[] parts = Utilities.fullTimeDiff(TargetDate);
            long remaining = totalTime, days = parts[0], hours = parts[1];
            String format = null;
            if (days > 0) {
                remaining = totalTime - (days * 24 * 60 * 60 * 1000);
                String formatDays = String.format(Locale.US, "%02d", days);
                format = formatDays + ":" + (hours == 0 ? "00:" : hours < 10 ? "0" : "") + "%s";
            }
            views.setChronometer(R.id.timer, remaining, format, true);
            views.setChronometerCountDown(R.id.timer, true);
            appWidgetManager.updateAppWidget(appWidgetId, views);
        });
    }

    /**
     * Set action that happens when user clicks widget
     */
    private void bindClickAction(Context context, int appWidgetId, RemoteViews views) {
        Intent intent = launchId != null ?
                DetailsLaunchActivity.launchDetails(context, launchId, launchEventName) :
                new Intent(context, MainActivity.class);
        intent.putExtra(EXTRA_WIDGET_LAUNCHER, 1);
        intent.setData(Uri.withAppendedPath(Uri.parse("myapp://widget/#id" + appWidgetId),
                UUID.randomUUID().toString()));
        views.setOnClickPendingIntent(R.id.widget_container, PendingIntent.getActivity(
                context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT));
    }
}
