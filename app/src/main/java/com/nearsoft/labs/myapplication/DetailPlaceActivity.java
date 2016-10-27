package com.nearsoft.labs.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nearsoft.labs.myapplication.model.Place;

public class DetailPlaceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_place);

        DetailPlaceFragment fragment = new DetailPlaceFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.detail_container, fragment).commit();



    }

    public static void start(Activity context, Place place) {
        Intent intent = new Intent(context, DetailPlaceActivity.class);
        intent.putExtra(MapsActivity.PLACE_EXTRA_KEY, place);
        context.startActivity(intent);
    }
}
