package com.tinder.model;

import android.support.annotation.Nullable;
import com.tinder.utils.C3095y;
import java.util.ArrayList;
import java.util.List;

public class UserMeta {
    @Nullable
    private ClientConfig mClientConfig;
    private GlobalConfig mGlobalConfig;
    private List<Group> mGroups;
    @Nullable
    private InstagramDataSet mInstagramDataSet;
    private boolean mIsTraveling;
    private int mLikesPercentRemaining;
    private List<TinderPurchase> mListPurchases;
    private long mMillisRateLimitedUntil;
    private SuperlikeStatus mSuperlikeStatus;
    private TinderLocation mTinderPassport;
    private List<TinderReportNotification> mTinderReportNotifications;
    private List<String> mTutorials;

    public UserMeta() {
        this.mTinderReportNotifications = new ArrayList();
        this.mInstagramDataSet = new InstagramDataSet();
        this.mGroups = new ArrayList();
        this.mSuperlikeStatus = new SuperlikeStatus();
        this.mTutorials = new ArrayList();
    }

    public GlobalConfig getGlobalConfig() {
        return this.mGlobalConfig;
    }

    public void setGlobalConfig(GlobalConfig globalConfig) {
        this.mGlobalConfig = globalConfig;
    }

    public TinderLocation getTinderPassport() {
        return this.mTinderPassport;
    }

    public void setTinderPassport(TinderLocation tinderLocation) {
        this.mTinderPassport = tinderLocation;
    }

    public List<TinderPurchase> getListPurchases() {
        return this.mListPurchases;
    }

    public void setListPurchases(List<TinderPurchase> list) {
        this.mListPurchases = list;
    }

    public int getLikesPercentRemaining() {
        return this.mLikesPercentRemaining;
    }

    public void setLikesPercentRemaining(int i) {
        this.mLikesPercentRemaining = i;
    }

    public long getMillisRateLimitedUntil() {
        return this.mMillisRateLimitedUntil;
    }

    public void setMillisRateLimitedUntil(long j) {
        this.mMillisRateLimitedUntil = j;
    }

    public boolean isTraveling() {
        return this.mIsTraveling;
    }

    public void setTraveling(boolean z) {
        this.mIsTraveling = z;
    }

    public List<TinderReportNotification> getTinderReportNotifications() {
        return this.mTinderReportNotifications;
    }

    public void setTinderReportNotifications(List<TinderReportNotification> list) {
        this.mTinderReportNotifications = list;
    }

    @Nullable
    public InstagramDataSet getInstagramDataSet() {
        return this.mInstagramDataSet;
    }

    public void setInstagramDataSet(@Nullable InstagramDataSet instagramDataSet) {
        String format;
        if (instagramDataSet != null) {
            format = String.format("instagram setData: photo size:[%d] instagram setData: fetch time: [%S]", new Object[]{Integer.valueOf(instagramDataSet.getInstagramPhotos().size()), instagramDataSet.getLastFetchTime()});
        } else {
            format = "instagram setData:null";
        }
        C3095y.m9471a(format);
        this.mInstagramDataSet = instagramDataSet;
    }

    public List<Group> getGroups() {
        return this.mGroups;
    }

    public void setGroups(List<Group> list) {
        this.mGroups = list;
    }

    public SuperlikeStatus getSuperlikeStatus() {
        return this.mSuperlikeStatus;
    }

    public void setSuperlikeStatus(SuperlikeStatus superlikeStatus) {
        this.mSuperlikeStatus = superlikeStatus;
    }

    @Nullable
    public ClientConfig getClientConfig() {
        return this.mClientConfig;
    }

    public void setClientConfig(@Nullable ClientConfig clientConfig) {
        this.mClientConfig = clientConfig;
    }

    public List<String> getTutorials() {
        return this.mTutorials;
    }

    public void setTutorials(List<String> list) {
        this.mTutorials = list;
    }
}
