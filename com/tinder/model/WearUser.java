package com.tinder.model;

import android.support.annotation.NonNull;
import com.facebook.stetho.BuildConfig;
import com.google.android.gms.wearable.Asset;
import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WearUser implements Serializable {
    @Expose
    private String mAbout;
    @Expose
    private String mAge;
    private Asset mAsset;
    @Expose
    private List<String> mFriendNames;
    @Expose
    private String mId;
    @Expose
    private List<String> mInterestNames;
    @Expose
    private String mName;
    @Expose
    @NonNull
    private String mPhotoUrl;

    /* renamed from: com.tinder.model.WearUser.1 */
    class C29691 extends ArrayList<String> {
        C29691(int i) {
            super(i);
            add(BuildConfig.FLAVOR);
        }
    }

    /* renamed from: com.tinder.model.WearUser.2 */
    class C29702 extends ArrayList<String> {
        C29702(int i) {
            super(i);
            add(BuildConfig.FLAVOR);
        }
    }

    public WearUser(String str, String str2, String str3, String str4, List<String> list, List<String> list2) {
        this.mName = BuildConfig.FLAVOR;
        this.mPhotoUrl = BuildConfig.FLAVOR;
        this.mAge = BuildConfig.FLAVOR;
        this.mAbout = BuildConfig.FLAVOR;
        this.mId = BuildConfig.FLAVOR;
        this.mInterestNames = new C29691(0);
        this.mFriendNames = new C29702(0);
        this.mId = str;
        this.mName = str2;
        this.mAge = str3;
        this.mAbout = str4;
        this.mInterestNames = list;
        this.mFriendNames = list2;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    @NonNull
    public String getPhotoUrl() {
        return this.mPhotoUrl;
    }

    public String getAge() {
        return this.mAge;
    }

    public List<String> getInterestNames() {
        return this.mInterestNames;
    }

    public List<String> getFriendNames() {
        return this.mFriendNames;
    }

    public String getAbout() {
        return this.mAbout;
    }

    public int getFriendCount() {
        return this.mFriendNames == null ? 0 : this.mFriendNames.size();
    }

    public int getInterestCount() {
        return this.mInterestNames == null ? 0 : this.mInterestNames.size();
    }

    public Asset getAsset() {
        return this.mAsset;
    }

    public void setAsset(Asset asset) {
        this.mAsset = asset;
    }

    @NonNull
    public String toString() {
        return "WearUser [id=" + this.mId + ", " + "age=" + this.mAge + ", name=" + this.mName + ", " + "interestNames=" + this.mInterestNames + ", " + "friendNames=" + this.mFriendNames + "]";
    }
}
