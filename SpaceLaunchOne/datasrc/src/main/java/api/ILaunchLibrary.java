package api;

import models.LaunchDetailed;
import models.LaunchListDetailed;
import models.data.BuildConfig;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Define the Launch Library API methods callable from the app.
 * <p>
 * See <a href="https://thespacedevs.com/llapi">Launch Library 2 API</a> for documentation.
 * </p>
 */
interface ILaunchLibrary {

    /**
     * Get list of launches whose launch date is greater than history start date.
     * This enables fetching future and past launches, independent of current datetime.
     *
     * @param offset  The initial index from which to return the results.
     * @return List of launches.
     */
    @GET("launch?format=json&mode=list&ordering=-net&mode=detailed&" +
            "limit=" + BuildConfig.PageSize + "&net__gt=" + BuildConfig.HistoryStartDate)
    Call<LaunchListDetailed> all_launches(@Query("offset") int offset);

    /**
     * Get a list of future launches, occurring after current datetime.
     *
     * @param limit  Number of results to return per page.
     * @return List of launches.
     */
    @GET("launch/upcoming/?format=json&offset=0&ordering=net&mode=detailed")
    Call<LaunchListDetailed> upcoming_launches(@Query("limit") int limit);

    /**
     * Get a list of past launches that occurred before current datetime.
     *
     * @param limit  Number of results to return per page.
     * @return List of launches.
     */
    @GET("launch/previous/?format=json&offset=0&ordering=-net&mode=detailed")
    Call<LaunchListDetailed> past_launches(@Query("limit") int limit);

    /**
     * Get details of a specified single launch.
     *
     * @param id  Launch id.
     * @return Details of launch event.
     */
    @GET("launch/{id}?format=json&mode=detailed")
    Call<LaunchDetailed> launch(@Path("id") String id);

}
