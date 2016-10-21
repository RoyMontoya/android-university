package com.nearsoft.labs.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.nearsoft.labs.myapplication.Model.Place;
import com.nearsoft.labs.myapplication.Model.Places;
import com.nearsoft.labs.myapplication.Retrofit.PlacesService;
import com.nearsoft.labs.myapplication.adapters.PlaceListAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlaceListActivity extends AppCompatActivity implements PlaceListListener, Callback<Places> {
        private static final String SERVICE_URL = "http://demo2355296.mockable.io/";

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
        DetailPlaceActivity.start(this, place);
    }

    private void setList() {
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.place_list);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        PlaceListAdapter mAdapter = new PlaceListAdapter(mPlaceList, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onResponse(Call<Places> call, Response<Places> response) {
        mPlaceList = response.body().places;
        setList();
    }

    @Override
    public void onFailure(Call<Places> call, Throwable t) {
        Log.d(PlaceListActivity.class.getSimpleName(), t.getMessage());
    }
}
