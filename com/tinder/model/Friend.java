package com.tinder.model;

public class Friend {
    private final String mFacebookId;
    private final String mFirstName;
    private final String mImageUrl;

    public Friend(String str, String str2, String str3, String str4) {
        this.mFacebookId = str;
        this.mFirstName = str2;
        this.mImageUrl = str3;
    }

    public String getFacebookId() {
        return this.mFacebookId;
    }

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public String getFirstName() {
        return this.mFirstName;
    }
}
