package com.nearsoft.labs.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.nearsoft.labs.myapplication.Model.Place;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final String PLACE_EXTRA_KEY = "place_extra_key";
    private GoogleMap mMap;
    private Place mPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mPlace = getIntent().getParcelableExtra(PLACE_EXTRA_KEY);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(mPlace.getLongitude(), mPlace.getLatitude());
        mMap.addMarker(new MarkerOptions().position(sydney).title(mPlace.getName()));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 15));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);
    }

    public static void start(Activity context, Place place) {
        Intent intent = new Intent(context, MapsActivity.class);
        intent.putExtra(PLACE_EXTRA_KEY, place);
        context.startActivity(intent);
    }
}
