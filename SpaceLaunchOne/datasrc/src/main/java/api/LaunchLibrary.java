package api;

import android.support.annotation.NonNull;

import java.io.IOException;

import models.Launch;
import models.Launches;
import models.Missions;
import models.data.BuildConfig;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LaunchLibrary {

    private static final String RESOURCE_BASE = BuildConfig.ApiBasepath;

    private interface methodRunner<T> {
        T run(ILaunchLibrary service) throws IOException;
    }

    private static void makeRequest(@NonNull final methodRunner exec, @NonNull final OnLoadCallback callback) {
        AppExecutors.getInstance().networkIO().execute(new Runnable() {
            @Override
            public void run() {
                ILaunchLibrary service = new Retrofit.Builder()
                        .baseUrl(RESOURCE_BASE)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build().create(ILaunchLibrary.class);
                try {
                    callback.call(exec.run(service));
                } catch (Exception e) {
                    e.printStackTrace();
                    callback.onError(e);
                }
            }
        });
    }

    public static void loadLaunches(final int count, final int offset, @NonNull final OnLoadCallback callback) {
        makeRequest(new methodRunner<Launches>() {
            @Override
            public Launches run(ILaunchLibrary service) throws IOException {
                return service.launches(count, offset).execute().body();
            }
        }, callback);
    }

    public static void allLaunches(final String start, final int count,  @NonNull final OnLoadCallback callback) {
        makeRequest(new methodRunner<Launches>() {
            @Override
            public Launches run(ILaunchLibrary service) throws IOException {
                return service.all_launches(start, count).execute().body();
            }
        }, callback);
    }

    public static void loadMissions(final int count, @NonNull final OnLoadCallback callback) {
        makeRequest(new methodRunner<Missions>() {
            @Override
            public Missions run(ILaunchLibrary service) throws IOException {
                return service.missions(count).execute().body();
            }
        }, callback);
    }

    public static void getLaunch(final int id, @NonNull final OnLoadCallback callback) {
        makeRequest(new methodRunner<Launch>() {
            @Override
            public Launch run(ILaunchLibrary service) throws IOException {
                Launches result = service.launch(id).execute().body();
                return (result != null && result.getCount() > 0) ?
                        result.getLaunches().get(0) : null;
            }
        }, callback);
    }
}
