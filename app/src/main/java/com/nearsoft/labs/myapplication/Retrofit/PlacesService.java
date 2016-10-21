package com.nearsoft.labs.myapplication.Retrofit;

import com.nearsoft.labs.myapplication.Model.Places;

import retrofit2.Call;
import retrofit2.http.GET;


public interface PlacesService {

    @GET("places")
    Call<Places> placesList();
}
