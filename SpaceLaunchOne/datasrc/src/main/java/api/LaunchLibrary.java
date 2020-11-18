package api;

import android.annotation.SuppressLint;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import androidx.annotation.NonNull;
import apimodels.LaunchDetailed;
import apimodels.LaunchListDetailed;
import apimodels.data.BuildConfig;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import utilities.AppExecutors;
import utilities.Logger;

public class LaunchLibrary extends Logger {

    private interface methodRunner<T> {
        T run(ILaunchLibrary service) throws IOException;
    }

    private static OkHttpClient.Builder getUnsafeOkHttpClient() {
        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @SuppressLint("TrustAllX509TrustManager")
                        @Override
                        public void checkClientTrusted(
                                java.security.cert.X509Certificate[] chain, String authType) {
                        }

                        @SuppressLint("TrustAllX509TrustManager")
                        @Override
                        public void checkServerTrusted(
                                java.security.cert.X509Certificate[] chain, String authType) {
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
            builder.hostnameVerifier((hostname, session) -> true);
            return builder;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Perform network call
     *
     * @param exec     - method to execute
     * @param callback - handler to process result
     */
    @SuppressWarnings("unchecked")
    private static <T> void makeRequest(
            @NonNull final methodRunner<?> exec,
            @NonNull final OnLoadCallback<T> callback) {
        AppExecutors.getInstance().networkIO().execute(() -> {
            ILaunchLibrary request = new Retrofit.Builder()
                    .baseUrl(BuildConfig.ApiBasepath)
                    .client(getUnsafeOkHttpClient().build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ILaunchLibrary.class);
            try {
                callback.call((T) exec.run(request));
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
    private static void getLaunches(Call<LaunchListDetailed> request, @NonNull LaunchListDetailed result) {
        Response<LaunchListDetailed> resp = null;
        try {
            resp = request.execute();
            requestLog(request, resp);
        } catch (IOException e) {
            displayError(e);
        }
        if (resp != null && resp.isSuccessful() && resp.body() != null &&
                resp.body().getResults() != null) {
            List<LaunchDetailed> list = new LinkedList<>();
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
     * @param callback - handler to process result
     */
    public static void initialLaunches(final int count, @NonNull final OnLoadCallback<LaunchListDetailed> callback) {
        makeRequest((methodRunner<LaunchListDetailed>) service -> {
            LaunchListDetailed result = new LaunchListDetailed();
            result.setResults(new LinkedList<>());
            getLaunches(service.upcoming_launches(count), result);
            getLaunches(service.past_launches(count), result);
            return result;
        }, callback);
    }

    /**
     * Get information about a single launch
     *
     * @param id       - launch id
     * @param callback - handler to process result
     */
    public static void getSingleLaunch(final String id, @NonNull final OnLoadCallback<LaunchDetailed> callback) {
        makeRequest((methodRunner<LaunchDetailed>) service -> {
            Call<LaunchDetailed> request = service.launch(id);
            Response<LaunchDetailed> resp = request.execute();
            requestLog(request, resp);
            return resp.body();
        }, callback);
    }

    /**
     * Get updates on launch data
     *
     * @param offset   - offset from start of results
     * @param callback - handler to process result
     */
    public static void allLaunches(final int offset, @NonNull final
    OnLoadCallback<LaunchListDetailed> callback) {
        makeRequest((methodRunner<LaunchListDetailed>) service -> {
            Call<LaunchListDetailed> request = service.all_launches(offset);
            Response<LaunchListDetailed> resp = service.all_launches(offset).execute();
            requestLog(request, resp);
            return resp.body();
        }, callback);
    }
}
