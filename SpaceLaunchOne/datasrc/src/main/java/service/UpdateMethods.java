package service;

import android.content.Context;

import androidx.annotation.Nullable;

import android.util.Log;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import api.ImageResolver;
import api.LaunchLibrary;
import api.OnLoadCallback;
import local.Agency;
import local.AppDatabase;
import local.Details;
import local.Launch;
import local.Location;
import local.LocationAgency;
import local.Mission;
import local.Pad;
import models.Agencies;
import models.Launches;
import models.Locations;
import models.Pads;
import models.Rocket;
import models.data.BuildConfig;

/**
 * These methods are executed to sync application database
 */
@SuppressWarnings("SameParameterValue")
public class UpdateMethods {

    UpdateMethods(Context context, final OnLoadCallback callback) {
        final AppDatabase db = AppDatabase.getInstance(context);
        Log.d("UPDATE", "updating launches....");
        updateLaunches(db, Integer.MAX_VALUE, 0, callback);
        updateAgencies(new Agencies(), db, Integer.MAX_VALUE, 0, 50, callback);
        updateLocations(new Locations(), db, Integer.MAX_VALUE, 0, 50, callback);
        updatePads(new Pads(), db, Integer.MAX_VALUE, 0, 50, callback);
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
    static void processLaunches(final AppDatabase db, final Launches result, final OnLoadCallback<Boolean> callback) {
        if (result == null || result.getLaunches() == null || result.getLaunches().size() == 0) {
            if (callback != null) callback.call(false);
            return;
        }
        final Map<Integer, Rocket> rockets = new HashMap<>();
        final Map<Integer, String> images = new HashMap<>();
        final List<models.Launch> launches = result.getLaunches();

        for (models.Launch l : launches) {
            if (l.getRocket() != null && !rockets.containsKey(l.getRocket().getId()))
                rockets.put(l.getRocket().getId(), l.getRocket());
        }

        final int uniqueRockets = rockets.keySet().size();

        for (final Integer id : rockets.keySet()) {
            new ImageResolver().resolveImage(Objects.requireNonNull(rockets.get(id)),
                    new OnLoadCallback<String>() {
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
     * Update agency data in the database
     */
    private static void processAgencies(final AppDatabase db, final Agencies result, final OnLoadCallback<Boolean> callback) {
        if (result == null || result.getAgencies() == null || result.getAgencies().size() == 0) {
            if (callback != null) callback.call(false);
            return;
        }
        final List<models.Agency> agencyData = result.getAgencies();
        final Agency[] agencies = new Agency[agencyData.size()];
        for (int i = 0; i < agencyData.size(); i++) {
            agencies[i] = Agency.Map(agencyData.get(i));
        }
        db.dao().insertAll(agencies);
        if (callback != null) callback.call(true);
    }

    /**
     * Update location data in the database
     */
    private static void processLocations(final AppDatabase db, final Locations result, final OnLoadCallback<Boolean> callback) {
        if (result == null || result.getLocations() == null || result.getLocations().size() == 0) {
            if (callback != null) callback.call(false);
            return;
        }
        final List<models.Location> locData = result.getLocations();
        final Location[] locations = new Location[locData.size()];
        for (int i = 0; i < locData.size(); i++) {
            locations[i] = Location.Map(locData.get(i));
        }
        db.dao().insertAll(locations);
        if (callback != null) callback.call(true);
    }

    /**
     * Update pad data in the database
     */
    private static void processPads(final AppDatabase db, final Pads result, final OnLoadCallback<Boolean> callback) {
        if (result == null || result.getPads() == null || result.getPads().size() == 0) {
            if (callback != null) callback.call(false);
            return;
        }
        final List<models.Pad> padData = result.getPads();
        final HashMap<Integer, LocationAgency> lax = new HashMap<>();
        final Pad[] pads = new Pad[padData.size()];
        for (int i = 0; i < padData.size(); i++) {
            models.Pad p = padData.get(i);
            pads[i] = Pad.Map(p);
            if (p.getAgencies() != null)
                for (models.Agency a : p.getAgencies()) {
                    if (!lax.containsKey(a.getId()))
                        lax.put(a.getId(), new LocationAgency(p.getLocationid(), a.getId()));
                }
        }
        db.dao().insertAll(pads);
        if (lax.keySet().size() > 0)
            db.dao().insertAll(lax.values().toArray(new LocationAgency[0]));
        if (callback != null) callback.call(true);
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
                        Details details = Details.Map(resp);
                        local.Launch summary = local.Launch.Map(resp);
                        List<Mission> missions = Mission.Map(id, resp.getMissions());
                        db.dao().insertFullRecord(summary, details, missions);

                        final int locId = resp.getLocation().getId();
                        List<LocationAgency> lax = new LinkedList<>();
                        lax.add(new LocationAgency(locId, resp.getLsp().getId()));
                        for (models.Pad p : resp.getLocation().getPads()) {
                            for (models.Agency a : p.getAgencies())
                                lax.add(new LocationAgency(locId, a.getId()));
                        }
                        db.dao().insertAll(lax.toArray(new LocationAgency[0]));
                        if (callback != null) callback.call(true);
                    }

                    @Override
                    public void onError(Exception e) {
                        if (callback != null) callback.call(false);
                    }
                });
            }

            @Override
            public void onError(Exception e) {
                if (callback != null) callback.call(false);
            }
        });
    }

    /**
     * These results are paged so recursively iterate over all agencies, or until:
     * all data has been fetched OR no more new data is available OR max number of attempts have been exhausted
     */
    private void updateAgencies(final Agencies allAgencies, final AppDatabase db,
                                final int size, final int offset, final int maxAttempts,
                                final OnLoadCallback<Boolean> callback) {
        LaunchLibrary.allAgencies(size, offset, new OnLoadCallback<Agencies>() {
            @Override
            public void call(Agencies result) {
                if (result.getAgencies() != null)
                    allAgencies.getAgencies().addAll(result.getAgencies());

                if (result.getCount() == 0 || maxAttempts < 0 || allAgencies.getAgencies().size() >= result.getTotal() ||
                        result.getCount() + result.getOffset() >= result.getTotal()) {
                    processAgencies(db, allAgencies, callback);
                } else {
                    updateAgencies(allAgencies, db, size, result.getOffset() + result.getCount(),
                            maxAttempts - 1, callback);
                }
            }

            @Override
            public void onError(Exception e) {
                if (callback != null) callback.onError(e);
            }
        });
    }

    /**
     * These results are paged so recursively iterate over all locations, or until:
     * all data has been fetched OR no more new data is available OR max number of attempts have been exhausted
     */
    private void updateLocations(final Locations allLocations, final AppDatabase db,
                                 final int size, final int offset, final int maxAttempts,
                                 final OnLoadCallback<Boolean> callback) {
        LaunchLibrary.allLocations(size, offset, new OnLoadCallback<Locations>() {
            @Override
            public void call(Locations result) {
                if (result.getLocations() != null)
                    allLocations.getLocations().addAll(result.getLocations());

                if (result.getCount() == 0 || maxAttempts < 0 || allLocations.getLocations().size() >= result.getTotal() ||
                        result.getCount() + result.getOffset() >= result.getTotal()) {
                    processLocations(db, allLocations, callback);
                } else {
                    updateLocations(allLocations, db, size, result.getOffset() + result.getCount(),
                            maxAttempts - 1, callback);
                }
            }

            @Override
            public void onError(Exception e) {
                if (callback != null) callback.onError(e);
            }
        });
    }

    /**
     * These results are paged so recursively iterate over all pads, or until:
     * all data has been fetched OR no more new data is available OR max number of attempts have been exhausted
     */
    private void updatePads(final Pads allPads, final AppDatabase db,
                            final int size, final int offset, final int maxAttempts,
                            final OnLoadCallback<Boolean> callback) {
        LaunchLibrary.allPads(size, offset, new OnLoadCallback<Pads>() {
            @Override
            public void call(Pads result) {
                if (result.getPads() != null)
                    allPads.getPads().addAll(result.getPads());
                if (result.getCount() == 0 || maxAttempts < 0 || allPads.getPads().size() >= result.getTotal() ||
                        result.getCount() + result.getOffset() >= result.getTotal()) {
                    processPads(db, allPads, callback);
                } else {
                    updatePads(allPads, db, size, result.getOffset() + result.getCount(),
                            maxAttempts - 1, callback);
                }
            }

            @Override
            public void onError(Exception e) {
                if (callback != null) callback.onError(e);
            }
        });
    }

}
