package com.tinder.model;

public class FacebookAlbum {
    private int mCount;
    private String mId;
    private String mName;
    private String mThumbId;
    private String mThumbUrl;

    public FacebookAlbum(String str, String str2, String str3, String str4, int i) {
        this.mId = str;
        this.mName = str2;
        this.mThumbId = str3;
        this.mThumbUrl = str4;
        this.mCount = i;
    }

    public String getId() {
        return this.mId;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public String getThumbId() {
        return this.mThumbId;
    }

    public void setThumbId(String str) {
        this.mThumbId = str;
    }

    public String getThumbUrl() {
        return this.mThumbUrl;
    }

    public void setThumbUrl(String str) {
        this.mThumbUrl = str;
    }

    public int getCount() {
        return this.mCount;
    }

    public void setCount(int i) {
        this.mCount = i;
    }
}
