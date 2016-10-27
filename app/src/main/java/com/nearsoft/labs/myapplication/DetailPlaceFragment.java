package com.nearsoft.labs.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nearsoft.labs.myapplication.model.Place;
import com.squareup.picasso.Picasso;


public class DetailPlaceFragment extends Fragment {
    private Place mPlace;

    public DetailPlaceFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPlace = getActivity().getIntent().getParcelableExtra(MapsActivity.PLACE_EXTRA_KEY);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_detail_place, container, false);

        ImageView placeImageView = (ImageView) v.findViewById(R.id.place_image_view);
        TextView placeNameTextView = (TextView) v.findViewById(R.id.place_name_attribute);
        TextView placeRankingTextView = (TextView) v.findViewById(R.id.place_ranking_attribute);
        Button mapButton = (Button) v.findViewById(R.id.map_button);

        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MapsActivity.start(getActivity(), mPlace);
            }
        });



        Picasso.with(getActivity())
                .load(mPlace.getImageUrl())
                .into(placeImageView);
        placeNameTextView.setText(mPlace.getName());
        placeRankingTextView.setText(String.valueOf(mPlace.getRanking()));



        return v;
    }

}
