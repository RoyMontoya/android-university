package com.nearsoft.labs.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PlaceListActivity extends AppCompatActivity implements PlaceListListener{

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private PlaceListAdapter mAdapter;
    private List<Place> mPlaceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_list);

        fillPlaceList();

        mRecyclerView = (RecyclerView) findViewById(R.id.place_list);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new PlaceListAdapter(mPlaceList, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void fillPlaceList() {
        mPlaceList = new ArrayList<>();
        mPlaceList.add(new Place("Mai jaus", 29.097437, -111.022033));
        mPlaceList.add(new Place("casa de mandil", 29.097437, -111.022033));
        mPlaceList.add(new Place("la scuela", 29.097437, -111.022033));
        mPlaceList.add(new Place("el mundo perdido", 29.097437, -111.022033));
        mPlaceList.add(new Place("el JJ", 29.097437, -111.022033));
    }

    @Override
    public void onClickPlaceRow(Place place) {
        MapsActivity.start(this, place);
    }
}
