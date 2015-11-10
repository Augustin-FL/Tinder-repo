package com.tinder.model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.io.Serializable;

public class CommonConnection implements Serializable {
    private int mDegree;
    @Nullable
    private String mId;
    @Nullable
    private String mImgLarge;
    @Nullable
    private String mImgMedium;
    @Nullable
    private String mImgSmall;
    @Nullable
    private String mName;

    public CommonConnection(@Nullable String str, int i, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        this.mId = str;
        this.mDegree = i;
        this.mName = str2;
        this.mImgSmall = str3;
        this.mImgMedium = str4;
        this.mImgLarge = str5;
    }

    @Nullable
    public String getId() {
        return this.mId;
    }

    public int getDegree() {
        return this.mDegree;
    }

    @Nullable
    public String getName() {
        return this.mName;
    }

    @Nullable
    public String getImgSmall() {
        return this.mImgSmall;
    }

    @Nullable
    public String getImgMedium() {
        return this.mImgMedium;
    }

    @Nullable
    public String getImgLarge() {
        return this.mImgLarge;
    }

    @Nullable
    public String getImgForDensity(@NonNull Context context) {
        return getImgForDensity(context.getResources().getDisplayMetrics().density);
    }

    @Nullable
    public String getImgForDensity(float f) {
        if (((double) f) <= 0.75d) {
            return this.mImgSmall;
        }
        if (f <= 1.0f) {
            return this.mImgSmall;
        }
        if (((double) f) <= 1.5d) {
            return this.mImgMedium;
        }
        if (((double) f) <= 2.0d) {
            return this.mImgMedium;
        }
        if (((double) f) <= 3.0d) {
            return this.mImgLarge;
        }
        return this.mImgLarge;
    }
}
