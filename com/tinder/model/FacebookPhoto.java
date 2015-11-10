package com.tinder.model;

public class FacebookPhoto {
    private String mId;
    private String mSourceUrl;
    private String mThumb;

    public FacebookPhoto(String str, String str2, String str3) {
        this.mThumb = str;
        this.mId = str2;
        this.mSourceUrl = str3;
    }

    public String getThumb() {
        return this.mThumb;
    }

    public void setThumb(String str) {
        this.mThumb = str;
    }

    public String getId() {
        return this.mId;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public String getSourceUrl() {
        return this.mSourceUrl;
    }

    public void setSourceUrl(String str) {
        this.mSourceUrl = str;
    }
}
