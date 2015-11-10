package com.tinder.model;

public class GlobalConfig {
    public static final int DEFAULT_LIKES_PERCENT_REMAINING = 100;
    public static final int DEFAULT_RECS_INTERVAL = 4000;
    public static final int DEFAULT_UPDATES_INTERVAL = 4000;
    private int mAdSwipeLimit;
    private boolean mIsMixpanelEnabled;
    private boolean mIsPlusEnabled;
    private boolean mIsSparksEnabled;
    private int mRecsInterval;
    private boolean mShouldFetchConnections;
    private boolean mSuperlikeEnabled;
    private boolean mSuperlikeLimited;
    private int mUpdatesInterval;
    private boolean mVersionIsRateable;

    public boolean shouldFetchConnections() {
        return this.mShouldFetchConnections;
    }

    public void setShouldFetchConnections(boolean z) {
        this.mShouldFetchConnections = z;
    }

    public int getUpdatesInterval() {
        return this.mUpdatesInterval;
    }

    public void setUpdatesInterval(int i) {
        this.mUpdatesInterval = i;
    }

    public int getRecsInterval() {
        return this.mRecsInterval;
    }

    public void setRecsInterval(int i) {
        this.mRecsInterval = i;
    }

    public boolean isSparksEnabled() {
        return this.mIsSparksEnabled;
    }

    public void setSparksEnabled(boolean z) {
        this.mIsSparksEnabled = z;
    }

    public boolean isMixpanelEnabled() {
        return this.mIsMixpanelEnabled;
    }

    public void setMixpanelEnabled(boolean z) {
        this.mIsMixpanelEnabled = z;
    }

    public boolean isPlusEnabled() {
        return this.mIsPlusEnabled;
    }

    public void setPlusEnabled(boolean z) {
        this.mIsPlusEnabled = z;
    }

    public int getAdSwipeLimit() {
        return this.mAdSwipeLimit;
    }

    public void setAdSwipeLimit(int i) {
        this.mAdSwipeLimit = i;
    }

    public void setIsVersionRateable(boolean z) {
        this.mVersionIsRateable = z;
    }

    public boolean isVersionRateable() {
        return this.mVersionIsRateable;
    }

    public boolean isSuperlikeEnabled() {
        return this.mSuperlikeEnabled;
    }

    public void setSuperlikeEnabled(boolean z) {
        this.mSuperlikeEnabled = z;
    }

    public boolean isSuperlikeLimited() {
        return this.mSuperlikeLimited;
    }

    public void setSuperlikeLimited(boolean z) {
        this.mSuperlikeLimited = z;
    }
}
