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

    @GET("launch?format=json&mode=list")
    Call<Launches> all_launches(@Query("offset") int offset, @Query("limit") int limit);

    @GET("launch?format=json&fields=id,name,rocket,location,net,status")
    Call<Launches> launches(@Query("next") int next);

    @GET("launch/{id}?format=json&mode=verbose")
    Call<Launches> launch(@Path("id") int id);

    @GET("mission/?format=json&mode=verbose")
    Call<Missions> missions(@Query("limit") int limit);

    @GET("agency?format=json&mode=verbose")
    Call<Agencies> agencies(@Query("next") int next, @Query("offset") int offset);

    @GET("location?format=json&mode=verbose")
    Call<Locations> locations(@Query("next") int next, @Query("offset") int offset);

    @GET("pad?format=json&mode=verbose")
    Call<Pads> pads(@Query("next") int next, @Query("offset") int offset);

    @GET("pad?format=json&locationid={id}&mode=verbose")
    Call<Pads> locationPads(@Path("id") int id);

}
