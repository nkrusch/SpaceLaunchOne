package api;

import ll2.models.LaunchList;
import models.Agencies;
import models.Launches;
import models.Locations;
import models.Missions;
import models.Pads;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

interface ILaunchLibrary {

    @GET("launch?format=json&mode=list")
    Call<Launches> all_launches(@Query("offset") int offset, @Query("limit") int limit);

    @GET("launch/upcoming?format=json&offset=0&ordering=net")
    Call<LaunchList> upcoming_launches(@Query("limit") int next);

    @GET("launch/{id}?format=json&mode=verbose")
    Call<Launches> launch(@Path("id") int id);

    @GET("mission/?format=json&mode=list")
    Call<Missions> missions(@Query("limit") int limit);

    @GET("agency?format=json&mode=list")
    Call<Agencies> agencies(@Query("next") int next, @Query("offset") int offset);

    @GET("location?format=json&mode=list")
    Call<Locations> locations(@Query("next") int next, @Query("offset") int offset);

    @GET("pad?format=json&mode=list")
    Call<Pads> pads(@Query("next") int next, @Query("offset") int offset);

}
