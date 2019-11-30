package service;

import android.content.Context;

import androidx.annotation.Nullable;

import android.util.ArrayMap;
import android.util.Log;
import android.util.SparseArray;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import api.ImageResolver;
import api.LaunchLibrary;
import api.OnLoadCallback;
import local.Agency;
import local.AgencyMission;
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
 * Update application database
 */
@SuppressWarnings("SameParameterValue")
public class UpdateMethods {

    public static void UpdateAppData(Context context, final OnLoadCallback callback) {
        Log.d("UPDATE", "updating app data....");
        final AppDatabase db = AppDatabase.getInstance(context);
        LaunchData.updateAllLaunches(db, Integer.MAX_VALUE, 0, callback);
        //AgencyData.updateAgencies(new Agencies(), db, Integer.MAX_VALUE, 0, 50, callback);
        //LocationData.updateLocations(new Locations(), db, Integer.MAX_VALUE, 0, 50, callback);
        //PadData.updatePads(new Pads(), db, Integer.MAX_VALUE, 0, 50, callback);
    }

    public static void UpdateLaunchDetails(Context context, final int id, @Nullable final OnLoadCallback callback) {
        Log.d("UPDATE", "updating launch details...." + id);
        LaunchData.updateSingleLaunchDetails(AppDatabase.getInstance(context), id, callback);
    }

    private static void handleError(Exception e, @Nullable final OnLoadCallback callback) {
        if (callback != null) callback.call(false);
    }

    static class LaunchData {

        /**
         * Go through list of launches and update the database.
         * Provide callback method to get notified when this process completes
         */
        static void processLaunches(final AppDatabase db, final Launches result, final OnLoadCallback<Boolean> callback, Boolean fetchImages) {

            if (result == null || result.getLaunches() == null) {
                if (callback != null) callback.call(false);
                return;
            }

            final Details[] details = new Details[result.getLaunches().size()];
            final Launch[] launches = new Launch[result.getLaunches().size()];
            final ArrayMap<Integer, Rocket> rockets = new ArrayMap<>();
            final ArrayMap<Integer, Agency> agencies = new ArrayMap<>();
            final ArrayMap<Integer, Location> locations = new ArrayMap<>();
            final ArrayMap<Integer, Pad> pads = new ArrayMap<>();
            final ArrayMap<Integer, Mission> missions = new ArrayMap<>();
            final ArrayMap<String, AgencyMission> amRefX = new ArrayMap<>();
            final ArrayMap<String, LocationAgency> laRefX = new ArrayMap<>();

            // map data
            for (int i = 0; i < result.getLaunches().size(); i++) {

                final models.Launch l = result.getLaunches().get(i);
                final models.Rocket r = l.getRocket();
                final models.Location loc = l.getLocation();
                final models.Agency a = l.getLsp();

                details[i] = Details.Map(l);
                launches[i] = Launch.Map(l);

                if (r != null) {
                    int rocketId = r.getId();
                    int launchId = l.getId();

                    if (rockets.containsKey(rocketId) && rockets.get(rocketId) != null) {
                        Objects.requireNonNull(rockets.get(rocketId)).addLaunchId(launchId);
                    } else {
                        r.addLaunchId(launchId);
                        rockets.put(rocketId, r);
                    }
                }

                if (a != null && a.getId() > 0 && !agencies.containsKey(a.getId())) {
                    a.setIslsp(1);
                    agencies.put(a.getId(), Agency.Map(a));
                }

                if (loc != null) {

                    if (!locations.containsKey(loc.getId()))
                        locations.put(loc.getId(), Location.Map(loc));

                    Pad.Map(pads, loc.getPads());

                    LocationAgency.Map(laRefX, loc.getId(), loc.getPads(), a);

                    if (loc.getPads() != null)
                        for (models.Pad pad : loc.getPads())
                            if (pad.getAgencies() != null && pad.getAgencies().length > 0)
                                for (models.Agency ag : pad.getAgencies())
                                    if (ag != null && ag.getId() > 0 && !agencies.containsKey(ag.getId()))
                                        agencies.put(ag.getId(), Agency.Map(ag));
                }

                Mission.Map(missions, l.getId(), l.getMissions());
                AgencyMission.Map(amRefX, l.getMissions());

                if (l.getMissions() != null)
                    for (models.Mission mis : l.getMissions())
                        if (mis.getAgencies() != null && mis.getAgencies().length > 0)
                            for (models.Agency ag : mis.getAgencies())
                                if (ag != null && ag.getId() > 0 && !agencies.containsKey(ag.getId()))
                                    agencies.put(ag.getId(), Agency.Map(ag));
            }

            Log.d("UPDATE",
                    "\nlaunches: " + launches.length + "\n" +
                            "details: " + details.length + "\n" +
                            "missions: " + missions.size() + "\n" +
                            "am ref X: " + amRefX.size() + "\n" +
                            "la ref X: " + laRefX.size() + "\n" +
                            "agencies: " + agencies.size() + "\n" +
                            "locations: " + locations.size() + "\n" +
                            "pads: " + pads.size() + "\n" +
                            "rockets: " + rockets.size());

            // save
            db.dao().insertAll(launches);
            db.dao().insertAll(details);
            db.dao().insertAll(missions.values().toArray(new Mission[0]));
            db.dao().insertAll(amRefX.values().toArray(new AgencyMission[0]));
            db.dao().insertAll(agencies.values().toArray(new Agency[0]));
            db.dao().insertAll(locations.values().toArray(new Location[0]));
            db.dao().insertAll(pads.values().toArray(new Pad[0]));
            db.dao().insertAll(laRefX.values().toArray(new LocationAgency[0]));

            if (rockets.size() == 0 || !fetchImages) {
                if (callback != null) callback.call(true);
                return;
            }

            // async fetch rocket images
            final int rocketCount = rockets.size();
            final List<Integer> images = new LinkedList<>();

            for (int j = 0; j < rockets.size(); j++) {
                final int rocketId = rockets.keyAt(j);
                final Rocket rocket = rockets.valueAt(j);
                new ImageResolver().resolveImage(rocket, new OnLoadCallback<String>() {
                    @Override
                    public void call(String image) {

                        images.add(rocketId);
                        if (!(image == null || image.isEmpty())) {
                            for (int launchId : rocket.getLaunchIds())
                                db.dao().updateImage(launchId, image);
                        }
                        if (images.size() == rocketCount && callback != null) {
                            Log.d("UPDATE", "done fetching images... " + rocketCount);
                            callback.call(true);
                        }
                    }

                    @Override
                    public void onError(Exception e) {
                        handleError(e, callback);
                    }
                });
            }
        }

        /**
         * Fetch list of launches from the API endpoint
         */
        private static void updateAllLaunches(final AppDatabase db, int size, int offset, final OnLoadCallback<Boolean> callback) {
            LaunchLibrary.allLaunches(BuildConfig.HistoryStart, size, new OnLoadCallback<Launches>() {
                @Override
                public void call(final Launches result) {
                    processLaunches(db, result, callback, true);
                }

                @Override
                public void onError(Exception e) {
                    handleError(e, callback);
                }
            });
        }

        /**
         * Fetch the latest launch details for single launch from the API endpoint
         */
        private static void updateSingleLaunchDetails(final AppDatabase db, final int id, final OnLoadCallback<Boolean> callback) {
            LaunchLibrary.getLaunch(id, new OnLoadCallback<models.Launch>() {
                @Override
                public void call(models.Launch result) {
                    processLaunches(db, new Launches(result), callback, false);
                }

                @Override
                public void onError(Exception e) {
                    handleError(e, callback);
                }
            });
        }
    }

    static class AgencyData {

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
         * These results are paged so recursively iterate over all agencies, or until:
         * all data has been fetched OR no more new data is available OR max number of attempts have been exhausted
         */
        private static void updateAgencies(final Agencies allAgencies, final AppDatabase db,
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
                    handleError(e, callback);
                }
            });
        }
    }

    static class LocationData {

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
         * These results are paged so recursively iterate over all locations, or until:
         * all data has been fetched OR no more new data is available OR max number of attempts have been exhausted
         */
        private static void updateLocations(final Locations allLocations, final AppDatabase db,
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
                    handleError(e, callback);
                }
            });
        }

    }

    static class PadData {

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
            final List<Pad> pads = new LinkedList<>();
            for (int i = 0; i < padData.size(); i++) {
                models.Pad p = padData.get(i);
                pads.add(Pad.Map(p));
                if (p.getAgencies() != null)
                    for (models.Agency a : p.getAgencies()) {
                        if (!lax.containsKey(a.getId()))
                            lax.put(a.getId(), new LocationAgency(p.getLocationid(), a.getId()));
                    }
            }
            db.dao().insertAll(pads.toArray(new Pad[0]));
            if (lax.keySet().size() > 0)
                db.dao().insertAll(lax.values().toArray(new LocationAgency[0]));
            if (callback != null) callback.call(true);
        }

        /**
         * These results are paged so recursively iterate over all pads, or until:
         * all data has been fetched OR no more new data is available OR max number of attempts have been exhausted
         */
        private static void updatePads(final Pads allPads, final AppDatabase db,
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
                    handleError(e, callback);
                }
            });
        }
    }
}
