package com.nearsoft.labs.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nearsoft.labs.myapplication.Model.Place;

import java.util.List;

/*
 * Copyright MDLive.  All rights reserved.
 */
public class PlaceListAdapter extends RecyclerView.Adapter<PlaceListAdapter.ViewHolder> {

    private final List<Place> mPlaceList;
    private PlaceListListener mPlaceListListener;

    PlaceListAdapter(List<Place> placeList, PlaceListListener placeListListener) {
        mPlaceList = placeList;
        mPlaceListListener = placeListListener;
    }

    @Override
    public PlaceListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.place_info_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PlaceListAdapter.ViewHolder holder, int position) {
        final Place place = mPlaceList.get(position);
        holder.placeTitleTextView.setText(place.getName());
        holder.placeTitleTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPlaceListListener.onClickPlaceRow(place);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPlaceList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView placeTitleTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            placeTitleTextView = (TextView) itemView.findViewById(R.id.place_row_title);
        }
    }

}