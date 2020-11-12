package service;

import android.content.Context;
import android.util.ArrayMap;
import android.util.Log;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import androidx.annotation.Nullable;
import utilities.ImageResolver;
import api.LaunchLibrary;
import api.OnLoadCallback;
import ll2.models.AgencySerializerMini;
import ll2.models.LaunchList;
import ll2.models.LaunchSerializerCommon;
import ll2.models.RocketSerializerCommon;
import local.Agency;
import local.AgencyMission;
import local.AppDatabase;
import local.Details;
import local.Launch;
import local.Location;
import local.LocationAgency;
import local.Mission;
import local.Pad;
import local.Rocket;

/**
 * Update application database
 */
@SuppressWarnings("SameParameterValue")
public class UpdateMethods {

    private static final String TAG = "API/UPDATE";

    public static void UpdateAppData(Context context, final OnLoadCallback callback) {
        Log.d("UPDATE", "updating app data....");
        final AppDatabase db = AppDatabase.getInstance(context);
        LaunchData.updateAllLaunches(db, Integer.MAX_VALUE, callback);
    }

    public static void UpdateLaunchDetails(Context context, final String id, @Nullable final OnLoadCallback callback) {
        Log.d("UPDATE", "updating launch details...." + id);
        LaunchData.updateSingleLaunchDetails(AppDatabase.getInstance(context), id, callback);
    }

    private static void handleError(Exception e, @Nullable final OnLoadCallback callback) {
        Log.d(TAG, "ERROR: " + e.getMessage());
        if (callback != null) callback.call(false);
    }

    static class LaunchData {

        /**
         * Go through list of launches and update the database.
         * Provide callback method to get notified when this process completes
         */
        static void processLaunches(
                final AppDatabase db,
                final LaunchList result,
                final OnLoadCallback<Boolean> callback
        ) {

            if (result == null || result.getResults() == null) {
                if (callback != null) callback.call(false);
                return;
            }
            Log.d(TAG, "PROCESSING: " + result.getResults().size());

            final Details[] details = new Details[result.getResults().size()];
            final Launch[] launches = new Launch[result.getResults().size()];
            final ArrayMap<Integer, Rocket> rockets = new ArrayMap<>();
            final ArrayMap<Integer, Agency> agencies = new ArrayMap<>();
            final ArrayMap<Integer, Location> locations = new ArrayMap<>();
            final ArrayMap<Integer, Pad> pads = new ArrayMap<>();
            final ArrayMap<Integer, Mission> missions = new ArrayMap<>();
            final ArrayMap<String, AgencyMission> amRefX = new ArrayMap<>();
            final ArrayMap<String, LocationAgency> laRefX = new ArrayMap<>();

            // map data
            for (int i = 0; i < result.getResults().size(); i++) {

                final LaunchSerializerCommon l = result.getResults().get(i);
                final RocketSerializerCommon r = l.getRocket();
                final ll2.models.Pad loc = l.getPad();
                final AgencySerializerMini a = l.getLaunchServiceProvider();
                final boolean valid_agency = a != null;

                details[i] = Details.Map(l);
                launches[i] = Launch.Map(l);

                if (r != null) {
                    int rocketId = r.getId();
                    String launchId = l.getLaunchLibraryId();

                    if (rockets.containsKey(rocketId) && rockets.get(rocketId) != null) {
                        Objects.requireNonNull(rockets.get(rocketId)).addLaunchId(launchId);
                    } else {
                        Rocket rocket = Rocket.Map(r, l.getImage());
                        rocket.addLaunchId(launchId);
                        rockets.put(rocketId, rocket);
                    }
                }

                if (valid_agency) {
                    if (!agencies.containsKey(a.getId())) {
                        agencies.put(a.getId(), Agency.Map(a));
                    } else if (Objects.requireNonNull(agencies.get(a.getId())).getIslsp() == 0) {
                        Objects.requireNonNull(agencies.get(a.getId())).setIslsp(1);
                    }
                }

                if (loc != null) {
                    if (!locations.containsKey(loc.getLocation().getId()))
                        locations.put(loc.getId(), Location.Map(loc.getLocation()));

                    Pad.Map(pads, loc.getLocation().getId(), loc);

                    LocationAgency.Map(laRefX, loc.getLocation().getId(), loc, a);
                    if (valid_agency && !agencies.containsKey(loc.getAgencyId()))
                        agencies.put(loc.getAgencyId(), Agency.Map(a));
                }

                if (l.getMission() != null) {
                    final int mid = l.getMission().getId();
                    if (!missions.containsKey(mid)) {
                        missions.put(mid, Mission.Map(l.getLaunchLibraryId(), l.getMission()));
                    }
                    if (valid_agency) {
                        String akey = AgencyMission.key(mid, a.getId());
                        if (!amRefX.containsKey(akey))
                            amRefX.put(akey, new AgencyMission(l.getMission().getId(), a.getId()));
                    }
                }
            }

            if (launches.length > 1) Log.d(TAG, " \n" +
                    "========================\n" +
                    "| Launches:  |  " + String.format("%5d  |\n", launches.length) +
                    "| Details:   |  " + String.format("%5d  |\n", details.length) +
                    "| Missions:  |  " + String.format("%5d  |\n", missions.size()) +
                    "| Ag-x-mis:  |  " + String.format("%5d  |\n", amRefX.size()) +
                    "| Loc-x-ag:  |  " + String.format("%5d  |\n", laRefX.size()) +
                    "| Agencies:  |  " + String.format("%5d  |\n", agencies.size()) +
                    "| Locations: |  " + String.format("%5d  |\n", locations.size()) +
                    "| Pads:      |  " + String.format("%5d  |\n", pads.size()) +
                    "| Rockets:   |  " + String.format("%5d  |\n", rockets.size()) +
                    "========================");

            else if (launches.length == 1) Log.d(TAG, " \n" +
                    "\nLAUNCH\n==========\n" + Arrays.toString(launches).replaceAll("\\[|\\]", "") +
                    "\n\nDETAILS\n==========\n" + Arrays.toString(details).replaceAll("\\[|\\]", "") +
                    "\n\nMISSIONS\n==========\n" + Arrays.toString(missions.values().toArray()).replaceAll("\\[|\\]", "") +
                    "\n\nAGENCY X MISSION\n==========\n" + Arrays.toString(amRefX.values().toArray()).replaceAll("\\[|\\]", "") +
                    "\n\nLOCATION X AGENCY\n==========\n" + Arrays.toString(laRefX.values().toArray()).replaceAll("\\[|\\]", "") +
                    "\n\nAGENCIES\n==========\n" + Arrays.toString(agencies.values().toArray()).replaceAll("\\[|\\]", "") +
                    "\n\nLOCATIONS\n==========\n" + Arrays.toString(locations.values().toArray()).replaceAll("\\[|\\]", "") +
                    "\n\nPADS\n==========\n" + Arrays.toString((pads.values().toArray())).replaceAll("\\[|\\]", "") +
                    "\n\nROCKETS\n==========\n" + Arrays.toString(rockets.values().toArray()).replaceAll("\\[|\\]", "") + "\n");
            else
                Log.d(TAG, " \n" +
                        "========================\n" +
                        "No launches!\n" +
                        "========================");

            // save
            db.dao().insertAll(launches);
            db.dao().insertAll(details);
            db.dao().insertAll(missions.values().toArray(new Mission[0]));
            db.dao().insertAll(amRefX.values().toArray(new AgencyMission[0]));
            db.dao().insertAll(laRefX.values().toArray(new LocationAgency[0]));
            db.dao().insertAll(locations.values().toArray(new Location[0]));
            db.dao().insertAll(agencies.values().toArray(new Agency[0]));
            db.dao().insertAll(rockets.values().toArray(new Rocket[0]));
            db.dao().insertAll(pads.values().toArray(new Pad[0]));

            if (rockets.size() == 0) {
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
                            for (String launchId : rocket.getLaunchIds())
                                db.dao().updateImage(launchId, image);
                        }
                        if (images.size() == rocketCount && callback != null) {
                            Log.d(TAG, "done!");
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
        private static void updateAllLaunches(final AppDatabase db, int size, final OnLoadCallback<Boolean> callback) {
            // TODO: iterate over pages
            // TODO: fetch agencies
            LaunchLibrary.allLaunches(0, size, new OnLoadCallback<LaunchList>() {
                @Override
                public void call(final LaunchList result) {

                    processLaunches(db, result, callback);
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
        private static void updateSingleLaunchDetails(final AppDatabase db, final String id, final OnLoadCallback<Boolean> callback) {
            LaunchLibrary.getLaunch(id, new OnLoadCallback<models.Launch>() {
                @Override
                public void call(models.Launch result) {
                    // TODO: fix this
                    //processLaunches(db, new Launches(result), callback);
                }

                @Override
                public void onError(Exception e) {
                    handleError(e, callback);
                }
            });
        }
    }
}
