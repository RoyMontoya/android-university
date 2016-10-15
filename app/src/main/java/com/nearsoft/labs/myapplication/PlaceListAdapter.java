package com.nearsoft.labs.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/*
 * Copyright MDLive.  All rights reserved.
 */
public class PlaceListAdapter extends RecyclerView.Adapter<PlaceListAdapter.ViewHolder> {

    private final List<Place> mPlaceList;

    PlaceListAdapter(List<Place> placeList) {
        this.mPlaceList = placeList;
    }

    @Override
    public PlaceListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.place_info_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PlaceListAdapter.ViewHolder holder, int position) {
        String placeName = mPlaceList.get(position).getName();
        holder.placeTitleTextView.setText(placeName);
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