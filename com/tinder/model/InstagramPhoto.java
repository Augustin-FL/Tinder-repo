package com.tinder.model;

import java.io.Serializable;

public class InstagramPhoto extends Photo implements Serializable {
    private String mLink;
    private long mTimestamp;
    private String mUrlLarge;
    private String mUrlSmall;

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public void setTimestamp(long j) {
        this.mTimestamp = j;
    }

    public String getLink() {
        return this.mLink;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public String getUrlLarge() {
        return this.mUrlLarge;
    }

    public void setUrlLarge(String str) {
        this.mUrlLarge = str;
    }

    public String getUrlSmall() {
        return this.mUrlSmall;
    }

    public void setUrlSmall(String str) {
        this.mUrlSmall = str;
    }

    public void setPhotoId(String str) {
        this.mPhotoId = str;
    }

    public String getUrl() {
        return this.mUrlLarge != null ? this.mUrlLarge : this.mUrlSmall;
    }
}
