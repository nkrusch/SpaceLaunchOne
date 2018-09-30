package api;

import models.Launches;
import models.Missions;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

interface ILaunchLibrary {
    @GET("launch?mode=verbose")
    Call<Launches> all_launches(@Query("startdate") String start, @Query("limit") int limit);

    @GET("launch?fields=id,name,rocket,location,net,status")
    Call<Launches> launches(@Query("next") int next, @Query("offset") int offset);

    @GET("launch/{id}?mode=verbose")
    Call<Launches> launch(@Path("id") int id);

    @GET("mission/?mode=verbose")
    Call<Missions> missions(@Query("limit") int limit);

}
