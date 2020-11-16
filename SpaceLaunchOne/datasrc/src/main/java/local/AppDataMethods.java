package local;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.ArrayMap;

import java.util.LinkedList;
import java.util.List;

import androidx.annotation.Nullable;
import api.LaunchLibrary;
import api.OnLoadCallback;
import apimodels.AgencySerializerDetailedCommon;
import apimodels.LaunchDetailed;
import apimodels.LaunchListDetailed;
import apimodels.LauncherConfigDetail;
import apimodels.RocketDetailed;
import utilities.ImageResolver;
import utilities.Logger;
import utilities.ProcessResult;

/**
 * Update application database
 */
@SuppressWarnings("SameParameterValue")
public class AppDataMethods extends Logger {

    private static void handleError(Exception e, @Nullable final OnLoadCallback callback) {
        displayError(e);
        if (callback != null) callback.call(false);
    }

    public static void init(Context context, int count, final OnLoadCallback<ProcessResult> callback) {
        Log("Initializing app data...");
        final AppDatabase db = AppDatabase.getInstance(context);
        LaunchLibrary.initialLaunches(count, new OnLoadCallback<LaunchListDetailed>() {
            @Override
            public void call(LaunchListDetailed result) {
                AppDataMethods.processLaunches(db, result, 0, callback);
            }

            @Override
            public void onError(Exception e) {
                callback.onError(e);
            }
        });
    }

    public static void sync(Context context, int offset, final OnLoadCallback<ProcessResult> callback) {
        Log("Updating app data.... offset: " + offset);
        final AppDatabase db = AppDatabase.getInstance(context);
        updateAllLaunches(db, offset, callback);
    }

    public static void updateLaunchDetails(Context context, final String id, @Nullable final OnLoadCallback callback) {
        Log("Getting launch id: " + id);
        final AppDatabase db = AppDatabase.getInstance(context);
        LaunchLibrary.getSingleLaunch(id, new OnLoadCallback<LaunchDetailed>() {
            @Override
            public void call(LaunchDetailed result) {
                processSingleLaunch(db, result, callback);
            }

            @Override
            public void onError(Exception e) {
                handleError(e, callback);
            }
        });
    }

    private static void updateAllLaunches(final AppDatabase db, final int offset, final OnLoadCallback<ProcessResult> callback) {
        LaunchLibrary.allLaunches(offset, new OnLoadCallback<LaunchListDetailed>() {
            @Override
            public void call(final LaunchListDetailed result) {
                processLaunches(db, result, offset, callback);
            }

            @Override
            public void onError(Exception e) {
                handleError(e, callback);
            }
        });
    }

    private static void processSingleLaunch(
            final AppDatabase db,
            final LaunchDetailed launch,
            final OnLoadCallback<Boolean> callback) {

        if (launch == null) {
            if (callback != null) callback.call(false);
            return;
        }

        Details details = Details.Map(launch);
        Launch launches = Launch.Map(launch);
        LocationAgency laRefX = null;
        Location location = null;
        Rocket rocket = null;
        Agency agency = null;
        Pad pad = null;

        if (launch.getRocket() != null && launch.getRocket().getConfiguration() != null) {
            rocket = Rocket.Map(launch.getRocket().getConfiguration());
        }
        if (launch.getLaunchServiceProvider() != null) {
            agency = Agency.Map(launch.getLaunchServiceProvider());
        }
        if (launch.getPad() != null && launch.getPad().getLocation() != null) {
            pad = Pad.Map(launch.getPad());
            location = Location.Map(launch.getPad().getLocation());
        }
        if (location != null && agency != null) {
            laRefX = new LocationAgency(location.getLid(), agency.getAid());
        }

        Log(String.format("" +
                "\nLAUNCH\n%s\n" +
                "\nDETAILS\n%s\n" +
                "\nAGENCY\n%s\n" +
                "\nROCKET\n%s\n" +
                "\nLOCATION\n%s\n" +
                "\nLOCATION X AGENCY\n%s\n" +
                "\nPAD\n%s\n", launches, details, agency, rocket, location, laRefX, pad));

        // save
        db.dao().insertAll(launches);
        db.dao().insertAll(details);
        db.dao().insertAll(laRefX);
        db.dao().insertAll(location);
        db.dao().insertAll(agency);
        db.dao().insertAll(rocket);
        db.dao().insertAll(pad);

    }

    @SuppressLint("DefaultLocale")
    private static void processLaunches(
            final AppDatabase db,
            final LaunchListDetailed result,
            final int offset,
            final OnLoadCallback<ProcessResult> callback) {

        ProcessResult out = new ProcessResult();
        if (result == null || result.getResults() == null) {
            out.setResult(false, result, offset);
            if (callback != null) callback.call(out);
            return;
        }
        Log("PROCESSING: " + result.getResults().size());

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

            final LaunchDetailed l = result.getResults().get(i);
            final RocketDetailed r = l.getRocket();
            final AgencySerializerDetailedCommon a = l.getLaunchServiceProvider();
            final apimodels.Pad p = l.getPad();
            final String launchId = l.getId().toString();

            details[i] = Details.Map(l);
            launches[i] = Launch.Map(l);

            if (r != null && r.getConfiguration() != null) {
                final LauncherConfigDetail c = r.getConfiguration();
                final int rocketId = c.getId();
                if (!rockets.containsKey(rocketId)) {
                    Rocket rocket = Rocket.Map(c);
                    rocket.addLaunchId(launchId);
                    rockets.put(rocketId, rocket);
                } else {
                    rockets.get(rocketId).addLaunchId(launchId);
                }
            }

            if (a != null) {
                final int agencyId = a.getId();
                if (!agencies.containsKey(agencyId)) {
                    agencies.put(agencyId, Agency.Map(a));
                } else {
                    agencies.get(agencyId).setIslsp(1);
                }
            }

            if (p != null && p.getLocation() != null) {
                final int padId = p.getId();
                final int locationId = p.getLocation().getId();
                if (!locations.containsKey(locationId)) {
                    locations.put(locationId, Location.Map(p.getLocation()));
                }
                if (!pads.containsKey(padId)) {
                    pads.put(padId, Pad.Map(p));
                }
                if (a != null) {
                    LocationAgency.Map(laRefX, locationId, a.getId());
                }
            }

            if (l.getMission() != null) {
                final int mid = l.getMission().getId();
                if (!missions.containsKey(mid)) {
                    missions.put(mid, Mission.Map(launchId, l.getMission()));
                }
                if (a != null) {
                    String amKey = AgencyMission.key(mid, a.getId());
                    if (!amRefX.containsKey(amKey))
                        amRefX.put(amKey, new AgencyMission(mid, a.getId()));
                }
            }
        }

        Log("" +
                "| Launches:  |  " + String.format("%5d  |\n", launches.length) +
                "| Details:   |  " + String.format("%5d  |\n", details.length) +
                "| Missions:  |  " + String.format("%5d  |\n", missions.size()) +
                "| Ag-x-mis:  |  " + String.format("%5d  |\n", amRefX.size()) +
                "| Loc-x-ag:  |  " + String.format("%5d  |\n", laRefX.size()) +
                "| Agencies:  |  " + String.format("%5d  |\n", agencies.size()) +
                "| Locations: |  " + String.format("%5d  |\n", locations.size()) +
                "| Pads:      |  " + String.format("%5d  |\n", pads.size()) +
                "| Rockets:   |  " + String.format("%5d  |", rockets.size()));

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
            out.setResult(true, result, offset);
            if (callback != null) callback.call(out);
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
                        out.setResult(true, result, offset);
                        callback.call(out);
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
