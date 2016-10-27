package com.nearsoft.labs.myapplication.retrofit;

import com.nearsoft.labs.myapplication.model.Places;

import retrofit2.Call;
import retrofit2.http.GET;

/*
 * Copyright MDLive. All Rights reserved.
 */
public interface PlaceService {

    @GET("places")
    Call<Places> getPlaces();


}
