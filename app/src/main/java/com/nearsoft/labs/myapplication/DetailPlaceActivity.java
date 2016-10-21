package com.nearsoft.labs.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManagerNonConfig;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nearsoft.labs.myapplication.Model.Place;

public class DetailPlaceActivity extends AppCompatActivity {
    private Place mPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_place);

        DetailPlaceFragment fragment = new DetailPlaceFragment();
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.container, fragment)
                .commit();
    }

    public static void start(Activity context, Place place){
        Intent intent = new Intent(context, DetailPlaceActivity.class);
        intent.putExtra(DetailPlaceFragment.PLACE_EXTRA_KEY, place);
        context.startActivity(intent);
    }

}
