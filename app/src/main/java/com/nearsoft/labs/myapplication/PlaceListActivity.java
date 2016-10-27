package com.nearsoft.labs.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.nearsoft.labs.myapplication.adapter.PlaceListAdapter;
import com.nearsoft.labs.myapplication.model.Place;
import com.nearsoft.labs.myapplication.model.Places;
import com.nearsoft.labs.myapplication.retrofit.PlaceService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlaceListActivity extends AppCompatActivity implements PlaceListListener, Callback<Places> {

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
                .baseUrl("http://demo2355296.mockable.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PlaceService service = retrofit.create(PlaceService.class);

        Call<Places> call = service.getPlaces();
        call.enqueue(this);

    }


    private void setPlacesList() {
        mRecyclerView = (RecyclerView) findViewById(R.id.place_list);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new PlaceListAdapter(mPlaceList, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onClickPlaceRow(Place place) {
        DetailPlaceActivity.start(this, place);
    }

    @Override
    public void onResponse(Call<Places> call, Response<Places> response) {
        mPlaceList = response.body().places;
        setPlacesList();
    }

    @Override
    public void onFailure(Call<Places> call, Throwable t) {
        Toast.makeText(this, t.getMessage(), Toast.LENGTH_LONG).show();
    }
}
