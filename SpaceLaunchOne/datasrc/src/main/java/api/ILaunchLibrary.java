package api;

import apimodels.LaunchDetailed;
import apimodels.LaunchListDetailed;
import apimodels.data.BuildConfig;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

interface ILaunchLibrary {

    @GET("launch?format=json&mode=list&ordering=-net&mode=detailed&limit=" + BuildConfig.PageSize + "&net__gt=" + BuildConfig.HistoryStartDate)
    Call<LaunchListDetailed> all_launches(@Query("offset") int offset);

    @GET("launch/upcoming/?format=json&offset=0&ordering=net&mode=detailed")
    Call<LaunchListDetailed> upcoming_launches(@Query("limit") int limit);

    @GET("launch/previous/?format=json&offset=0&ordering=-net&mode=detailed")
    Call<LaunchListDetailed> past_launches(@Query("limit") int limit);

    @GET("launch/{id}?format=json&mode=detailed")
    Call<LaunchDetailed> launch(@Path("id") String id);

}
