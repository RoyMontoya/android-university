package com.nearsoft.labs.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PlaceListActivity extends AppCompatActivity {

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

        mAdapter = new PlaceListAdapter(mPlaceList);
        mRecyclerView.setAdapter(mAdapter);

        //TODO: go to https://developers.google.com/maps/documentation/android-api/ to get a key
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    private void fillPlaceList() {
        mPlaceList = new ArrayList<>();
        mPlaceList.add(new Place("Mai jaus"));
        mPlaceList.add(new Place("casa de mandil"));
        mPlaceList.add(new Place("la scuela"));
        mPlaceList.add(new Place("el mundo perdido"));
        mPlaceList.add(new Place("el JJ"));
    }
}
