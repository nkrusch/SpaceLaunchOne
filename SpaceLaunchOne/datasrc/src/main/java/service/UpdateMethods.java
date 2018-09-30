package service;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import api.ImageResolver;
import api.LaunchLibrary;
import api.OnLoadCallback;
import local.AppDatabase;
import local.Details;
import local.Launch;
import local.Mission;
import models.Launches;
import models.Rocket;
import models.data.BuildConfig;

/**
 * These methods are executed to sync application database
 */
@SuppressWarnings("SameParameterValue")
public class UpdateMethods {

    public UpdateMethods(Context context, final OnLoadCallback callback) {
        final AppDatabase db = AppDatabase.getInstance(context);
        Log.d("UPDATE", "updating launches....");
        updateLaunches(db, Integer.MAX_VALUE, 0, callback);
    }

    public static void UpdateDetails(Context context, final int id, @Nullable final OnLoadCallback callback) {
        final AppDatabase db = AppDatabase.getInstance(context);
        Log.d("UPDATE", "updating launch details...." + id);
        updateLaunchDetails(db, id, callback);
    }

    /**
     * Go through list of launches and update the database.
     * Provide callback method to get notified when this process completes
     */
    public static void processLaunches(final AppDatabase db, final Launches result, final OnLoadCallback<Boolean> callback) {
        if (result == null || result.getLaunches() == null || result.getLaunches().size() == 0) {
            if (callback != null) callback.call(false);
            return;
        }
        final Map<Integer, Rocket> rockets = new HashMap<>();
        final Map<Integer, String> images = new HashMap<>();
        final List<models.Launch> launches = result.getLaunches();

        for (models.Launch l : result.getLaunches()) {
            if (l.getRocket() != null && !rockets.containsKey(l.getRocket().getId()))
                rockets.put(l.getRocket().getId(), l.getRocket());
        }

        final int uniqueRockets = rockets.keySet().size();

        for (final Integer id : rockets.keySet()) {
            new ImageResolver().resolveImage(rockets.get(id), new OnLoadCallback<String>() {
                @Override
                public void call(String result) {
                    images.put(id, result);
                    if (images.keySet().size() == uniqueRockets) {
                        final Launch[] summaries = new Launch[launches.size()];
                        final Details[] details = new Details[launches.size()];
                        final List<Mission> missions = new LinkedList<>();

                        for (int i = 0; i < launches.size(); i++) {
                            models.Launch l = launches.get(i);
                            String image = images.get(l.getRocket().getId());

                            summaries[i] = Launch.Map(l);
                            summaries[i].setImage(image);
                            details[i] = Details.Map(l);
                            missions.addAll(Mission.Map(l.getId(), l.getMissions()));
                        }
                        db.dao().insertAll(summaries);
                        db.dao().insertAll(details);
                        db.dao().insertAll(missions);
                        if (callback != null) callback.call(true);
                    }
                }
                @Override
                public void onError(Exception e) {
                    if (callback != null) callback.call(false);
                }
            });
        }
    }

    /**
     * Fetch list of launches from the API endpoint
     */
    private void updateLaunches(final AppDatabase db, int size, int offset, final OnLoadCallback<Boolean> callback) {
        LaunchLibrary.allLaunches(BuildConfig.HistoryStart, size, new OnLoadCallback<Launches>() {
            @Override
            public void call(final Launches result) {
                processLaunches(db, result, callback);
            }

            @Override
            public void onError(Exception e) {
                if (callback != null) callback.call(false);
            }
        });
    }

    /**
     * Fetch the latest launch details for single launch from the API endpoint
     */
    private static void updateLaunchDetails(final AppDatabase db, final int id, final OnLoadCallback<Boolean> callback) {
        LaunchLibrary.getLaunch(id, new OnLoadCallback<models.Launch>() {
            @Override
            public void call(models.Launch result) {
                if (result == null) return;
                final models.Launch resp = result;
                new ImageResolver().resolveImage(result.getRocket(), new OnLoadCallback<String>() {
                    @Override
                    public void call(String result) {
                        if (result != null) resp.setImage(result);
                        new ImageResolver().resolveImage(resp.getLsp(), new OnLoadCallback<String>() {
                            @Override
                            public void call(String result) {
                                resp.getLsp().setImage(result);
                                Details details = Details.Map(resp);
                                local.Launch summary = local.Launch.Map(resp);
                                List<Mission> missions = Mission.Map(id, resp.getMissions());
                                db.dao().insertFullRecord(summary, details, missions);
                            }

                            @Override
                            public void onError(Exception e) {
                            }
                        });
                    }

                    @Override
                    public void onError(Exception e) {
                    }
                });
            }

            @Override
            public void onError(Exception e) {
            }
        });
    }
}
