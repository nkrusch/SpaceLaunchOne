package api;

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

    @GET("launch?mode=verbose")
    Call<Launches> all_launches(@Query("startdate") String start, @Query("limit") int limit);

    @GET("launch?fields=id,name,rocket,location,net,status")
    Call<Launches> launches(@Query("next") int next);

    @GET("launch/{id}?mode=verbose")
    Call<Launches> launch(@Path("id") int id);

    @GET("mission/?mode=verbose")
    Call<Missions> missions(@Query("limit") int limit);

    @GET("agency?mode=verbose")
    Call<Agencies> agencies(@Query("next") int next, @Query("offset") int offset);

    @GET("location?mode=verbose")
    Call<Locations> locations(@Query("next") int next, @Query("offset") int offset);

    @GET("pad?mode=verbose")
    Call<Pads> pads(@Query("next") int next, @Query("offset") int offset);

    @GET("pad?locationid={id}&mode=verbose")
    Call<Pads> locationPads(@Path("id") int id);

}
