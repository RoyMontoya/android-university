package com.nearsoft.labs.myapplication.Model;/*
 * Copyright MDLive.  All rights reserved.
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Place implements Parcelable {
    @SerializedName("name")
    private String name;
    @SerializedName("long")
    private double longitude;
    @SerializedName("lat")
    private double latitude;
    @SerializedName("image_url")
    private String imageUrl;
    @SerializedName("ranking")
    private int ranking;

    public Place(String name, double longitude, double latitude) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    protected Place(Parcel in) {
        name = in.readString();
        longitude = in.readDouble();
        latitude = in.readDouble();
        imageUrl = in.readString();
        ranking = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeDouble(longitude);
        dest.writeDouble(latitude);
        dest.writeString(imageUrl);
        dest.writeInt(ranking);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Place> CREATOR = new Creator<Place>() {
        @Override
        public Place createFromParcel(Parcel in) {
            return new Place(in);
        }

        @Override
        public Place[] newArray(int size) {
            return new Place[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }


}
