package com.tinder.model;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.facebook.stetho.BuildConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class InstagramDataSet implements Serializable {
    private List<InstagramPhoto> mInstagramPhotos;
    private String mLastFetchTime;
    private int mMediaCount;
    private String mProfilePictureUrl;
    private boolean mTokenRevoked;
    private String mUserName;

    public InstagramDataSet() {
        this.mInstagramPhotos = new ArrayList();
    }

    public String getUserName() {
        return this.mUserName;
    }

    public void setUserName(String str) {
        this.mUserName = str;
    }

    public String getProfilePictureUrl() {
        return this.mProfilePictureUrl;
    }

    public void setProfilePictureUrl(String str) {
        this.mProfilePictureUrl = str;
    }

    public int getMediaCount() {
        return this.mMediaCount;
    }

    public void setMediaCount(int i) {
        this.mMediaCount = i;
    }

    public List<InstagramPhoto> getInstagramPhotos() {
        return this.mInstagramPhotos;
    }

    public void setInstagramPhotos(List<InstagramPhoto> list) {
        this.mInstagramPhotos = list;
    }

    public boolean hasPhotos() {
        return !this.mInstagramPhotos.isEmpty();
    }

    @NonNull
    public String getLastFetchTime() {
        return TextUtils.equals("null", this.mLastFetchTime) ? BuildConfig.FLAVOR : this.mLastFetchTime;
    }

    public void setLastFetchTime(String str) {
        this.mLastFetchTime = str;
    }

    public boolean isTokenRevoked() {
        return this.mTokenRevoked;
    }

    public void setTokenRevoked(boolean z) {
        this.mTokenRevoked = z;
    }
}
