package ru.kachkovsky.restaurants.data;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;
import ru.kachkovsky.restaurants.config.Config;
import ru.kachkovsky.restaurants.data.bean.Example;

public interface RestaurantsApi {

    @GET("api/place/nearbysearch/json?sensor=true&key=" + Config.API_KEY)
    Call<Example> getNearbyPlaces(@Query("type") String type, @Query("location") String location, @Query("radius") int radius);

}
