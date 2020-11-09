package api;

import android.util.Log;

import java.io.IOException;

import androidx.annotation.NonNull;
import ll2.models.LaunchList;
import models.Launch;
import models.Launches;
import models.data.BuildConfig;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LaunchLibrary {

    private static final String RESOURCE_BASE = BuildConfig.ApiBasepath;
    private static final boolean DEBUG = BuildConfig.AppDebug;
    private static final String TAG = "API";

    private interface methodRunner<T> {
        T run(ILaunchLibrary service) throws IOException;
    }

    private static void d(String msg) {
        if (DEBUG) Log.d(TAG, msg);
    }

    private static void makeRequest(@NonNull final methodRunner exec, @NonNull final OnLoadCallback callback) {
        AppExecutors.getInstance().networkIO().execute(() -> {
            ILaunchLibrary request = new Retrofit.Builder()
                    .baseUrl(RESOURCE_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ILaunchLibrary.class);
            try {
                callback.call(exec.run(request));
            } catch (Exception e) {
                e.printStackTrace();
                callback.onError(e);
            }
        });
    }

    public static void initialLaunches(final int count, @NonNull final OnLoadCallback callback) {
        makeRequest((methodRunner<LaunchList>) service -> {
            d("INIT URL: " + service.upcoming_launches(count).request().url());
            Response<LaunchList> res = service.upcoming_launches(count).execute();
            if (res.isSuccessful() && res.body() != null) {
                d("SUCCESS\nCOUNT: " + res.body().getCount() +
                        "\nSIZE:" + res.body().getResults().size());
            } else {
                d("ERROR BODY: " + res.errorBody());
            }
            return res.body();
        }, callback);
    }

    public static void getLaunch(final int id, @NonNull final OnLoadCallback callback) {
        makeRequest((methodRunner<Launch>) service -> {
            Launches result = service.launch(id).execute().body();
            return (result != null && result.getCount() > 0) ?
                    result.getResults().get(0) : null;
        }, callback);
    }

    public static void allLaunches(final int offset, final int count, @NonNull final OnLoadCallback callback) {
        makeRequest((methodRunner<Launches>) service -> {
            Log.d("UPDATE", "URL: " + service.all_launches(offset, count).request().url().toString());
            Response<Launches> temp = service.all_launches(offset, count).execute();
            Log.d("UPDATE", "SUCCESS?: " + temp.isSuccessful());
            if (!temp.isSuccessful())
                Log.d("UPDATE", "ERROR BODY: " + temp.errorBody().string());
            Log.d("UPDATE", "RAW BODY: " +
                    temp.body().getCount() + "\n" +
                    temp.body().getResults().size() + "\n" +
                    temp.body().getNext() + "\n" +
                    temp.body().getPrevious());
            return temp.body();
        }, callback);
    }

}
