package ru.kachkovsky.restaurants.data;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import ru.kachkovsky.restaurants.data.bean.Example;

public class RestaurantsRequest {


    public static Call<Example> request(double latitude, double longitude, int radius) {
        String url = "https://maps.googleapis.com/maps/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RestaurantsApi service = retrofit.create(RestaurantsApi.class);

        return service.getNearbyPlaces("restaurant", latitude + "," + longitude, radius);

    }
}
