package ru.kachkovsky.restaurants.data;

import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import ru.kachkovsky.restaurants.data.bean.Example;

import static android.R.attr.type;

public class RestaurantsRequest {


    public static Call<Example> request(double latitude,double longitude,int radius) {
        String url = "https://maps.googleapis.com/maps/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RestaurantsApi service = retrofit.create(RestaurantsApi.class);

        return service.getNearbyPlaces("restaurant", latitude + "," + longitude, radius);

    }
}
