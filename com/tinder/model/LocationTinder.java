package com.tinder.model;

public class LocationTinder {
    private int mId;
    private long mLatitude;
    private long mLongitude;
    private String mName;

    public LocationTinder(int i, String str, long j, long j2) {
        this.mId = i;
        this.mName = str;
        this.mLatitude = j;
        this.mLongitude = j2;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public long getLatitude() {
        return this.mLatitude;
    }

    public void setLatitude(long j) {
        this.mLatitude = j;
    }

    public long getLongitude() {
        return this.mLongitude;
    }

    public void setLongitude(long j) {
        this.mLongitude = j;
    }

    public int getId() {
        return this.mId;
    }

    public void setId(int i) {
        this.mId = i;
    }
}
