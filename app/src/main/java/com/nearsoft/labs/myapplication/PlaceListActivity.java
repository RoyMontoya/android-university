package com.nearsoft.labs.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.nearsoft.labs.myapplication.Model.Place;
import com.nearsoft.labs.myapplication.Retrofit.Places;
import com.nearsoft.labs.myapplication.Retrofit.PlacesService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlaceListActivity extends AppCompatActivity implements PlaceListListener, Callback<Places> {
    //    private static final String SERVICE_URL = "http://demo2355296.mockable.io/";
    private static final String SERVICE_URL = "https://androidschool.herokuapp.com/";

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private PlaceListAdapter mAdapter;
    private List<Place> mPlaceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_list);

        fillPlaceList();
    }

    private void fillPlaceList() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(SERVICE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PlacesService service = retrofit.create(PlacesService.class);

        Call<Places> call = service.placesList();
        call.enqueue(this);
    }

    @Override
    public void onClickPlaceRow(Place place) {
        MapsActivity.start(this, place);
    }

    @Override
    public void onResponse(Call<Places> call, Response<Places> response) {
        mPlaceList = response.body().places;
        setList();
    }

    private void setList() {
        mRecyclerView = (RecyclerView) findViewById(R.id.place_list);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new PlaceListAdapter(mPlaceList, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onFailure(Call<Places> call, Throwable t) {
        Log.d(PlaceListActivity.class.getSimpleName(), t.getMessage());
    }
}
