package com.tinder.model;

public class InstagramAuthError {
    private String mError;
    private int mStatus;

    public InstagramAuthError(int i, String str) {
        this.mStatus = i;
        this.mError = str;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public String getError() {
        return this.mError;
    }
}
