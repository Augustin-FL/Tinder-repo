package com.tinder.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tinder.managers.C2807a;
import java.util.HashMap;

public class SparksEvent {
    private final String mName;
    @NonNull
    private final HashMap<String, Object> mParams;
    private final long mTimestamp;

    public SparksEvent(String str) {
        this.mName = str;
        this.mParams = new HashMap();
        this.mTimestamp = System.currentTimeMillis();
    }

    public SparksEvent(String str, long j, @Nullable HashMap<String, Object> hashMap) {
        this.mName = str;
        this.mTimestamp = j;
        this.mParams = hashMap == null ? new HashMap() : new HashMap(hashMap);
    }

    @NonNull
    public SparksEvent put(String str, Object obj) {
        this.mParams.put(str, obj);
        return this;
    }

    public String getName() {
        return this.mName;
    }

    @NonNull
    public HashMap<String, Object> getParams() {
        return this.mParams;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public void fire() {
        if (this.mName != null) {
            C2807a.m8056a(this);
            return;
        }
        throw new IllegalStateException("Name is null in SparksEvent");
    }

    public String toString() {
        return "SparksEvent{mName='" + this.mName + '\'' + '}';
    }
}
