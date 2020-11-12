package api;

import ll2.models.Agency;
import ll2.models.LaunchDetailed;
import ll2.models.LaunchList;
import ll2.models.Location;
import ll2.models.Pad;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

interface ILaunchLibrary {

    @GET("launch?format=json&mode=list")
    Call<LaunchList> all_launches(@Query("offset") int offset, @Query("limit") int limit);

    @GET("launch/upcoming/?format=json&offset=0&ordering=net")
    Call<LaunchList> upcoming_launches(@Query("limit") int limit);

    @GET("launch/previous/?format=json&offset=0&ordering=-net")
    Call<LaunchList> past_launches(@Query("limit") int limit);

    @GET("launch/{id}?format=json")
    Call<LaunchDetailed> launch(@Path("id") String id);

    @GET("agency?format=json&mode=list")
    Call<Agency> agencies(@Query("limit") int limit, @Query("offset") int offset);

    @GET("location?format=json&mode=list")
    Call<Location> locations(@Query("limit") int limit, @Query("offset") int offset);

    @GET("pad?format=json&mode=list")
    Call<Pad> pads(@Query("limit") int limit, @Query("offset") int offset);

}
