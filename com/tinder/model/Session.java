package com.tinder.model;

import com.tinder.managers.ManagerApp;

public class Session {
    String mAppVersion;
    long mOpenDate;

    public Session(long j, String str) {
        this.mOpenDate = j;
        this.mAppVersion = str;
    }

    public static Session getInstance() {
        return new Session(System.currentTimeMillis(), ManagerApp.f5582e);
    }

    public long getOpenDate() {
        return this.mOpenDate;
    }

    public String getAppVersion() {
        return this.mAppVersion;
    }
}
