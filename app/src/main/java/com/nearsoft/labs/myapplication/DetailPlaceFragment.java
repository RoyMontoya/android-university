package com.nearsoft.labs.myapplication;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nearsoft.labs.myapplication.Model.Place;
import com.squareup.picasso.Picasso;

public class DetailPlaceFragment extends Fragment {
    private Place mPlace;
    public static final String PLACE_EXTRA_KEY = "place_extra_key";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        mPlace = getActivity().getIntent().getExtras().getParcelable(PLACE_EXTRA_KEY);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_detail_place, container, false);
        ImageView placePhoto = (ImageView) v.findViewById(R.id.place_imageview);
        TextView placeName = (TextView) v.findViewById(R.id.place_name_textview);
        TextView placeRanking = (TextView) v.findViewById(R.id.place_rank_textview);
        Button mapButton = (Button) v.findViewById(R.id.map_button);

        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MapsActivity.start(getActivity(), mPlace);
            }
        });

        Picasso.with(getActivity()).load(mPlace.getImageUrl()).into(placePhoto);
        placeName.setText(mPlace.getName());
        placeRanking.setText(String.valueOf(mPlace.getRanking()));

        //tarea cambiar el ranking por estrellas


        return v;
    }

}
