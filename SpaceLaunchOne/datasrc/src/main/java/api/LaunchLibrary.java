package api;

import android.util.Log;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import androidx.annotation.NonNull;
import ll2.models.LaunchList;
import ll2.models.LaunchSerializerCommon;
import models.Launch;
import models.Launches;
import models.data.BuildConfig;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LaunchLibrary extends ApiDebugger {

    private static final String RESOURCE_BASE = BuildConfig.ApiBasepath;

    private interface methodRunner<T> {
        T run(ILaunchLibrary service) throws IOException;
    }

    public static OkHttpClient.Builder getUnsafeOkHttpClient() {
        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0]);
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            return builder;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Perform network call
     *
     * @param exec     - method to execute
     * @param callback
     */
    private static void makeRequest(@NonNull final methodRunner exec, @NonNull final OnLoadCallback callback) {
        AppExecutors.getInstance().networkIO().execute(() -> {
            ILaunchLibrary request = new Retrofit.Builder()
                    .baseUrl(RESOURCE_BASE)
                    .client(getUnsafeOkHttpClient().build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ILaunchLibrary.class);
            try {
                callback.call(exec.run(request));
            } catch (Exception e) {
                displayError(e);
                callback.onError(e);
            }
        });
    }

    /**
     * This method attempts to get launches from API
     *
     * @param request - specified API endpoint
     * @param result  - LaunchList for appending results if successful
     */
    private static void getLaunches(Call<LaunchList> request, @NonNull LaunchList result) {
        Response<LaunchList> resp = null;
        try {
            resp = request.execute();
        } catch (IOException e) {
            displayError(e);
        }
        httpRequestDetails(request.request().url().toString());
        if (resp != null &&
                resp.isSuccessful() &&
                resp.body() != null &&
                resp.body().getResults() != null) {
            List<LaunchSerializerCommon> list = new LinkedList<>();
            list.addAll(result.getResults());
            list.addAll(resp.body().getResults());
            result.setResults(list);
        }
    }

    /**
     * This method gets N upcoming and past launches. Not possible to request before and after in
     * single request, so getting data over two individual requests, then merging.
     *
     * @param count    - number of launches to fetch when initializing
     * @param callback
     */
    public static void initialLaunches(final int count, @NonNull final OnLoadCallback callback) {
        makeRequest((methodRunner<LaunchList>) service -> {
            LaunchList result = new LaunchList();
            result.setResults(new LinkedList<>());
            getLaunches(service.upcoming_launches(count), result);
            getLaunches(service.past_launches(count), result);
            return result;
        }, callback);
    }

    public static void getLaunch(final String id, @NonNull final OnLoadCallback callback) {
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
