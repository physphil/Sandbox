package com.physphil.android.sandbox.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by pshadlyn on 8/5/2015.
 */
public class Player implements Parcelable {
    private int id;
    private String name;
    private int number;

    public Player(int id, String name, int number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
