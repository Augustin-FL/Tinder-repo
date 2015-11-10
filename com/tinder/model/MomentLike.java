package com.tinder.model;

import android.support.annotation.Nullable;
import com.facebook.stetho.BuildConfig;

public class MomentLike extends BaseMessage<MomentLike> {
    @Nullable
    private String mLikedById;
    private String mMomentByUserId;
    @Nullable
    private String mMomentId;
    @Nullable
    private String mThumbUrl;

    public MomentLike(String str, String str2, String str3, String str4, long j) {
        super(str, j);
        this.mMomentId = null;
        this.mLikedById = null;
        this.mThumbUrl = null;
        this.mMomentByUserId = BuildConfig.FLAVOR;
        this.mMomentId = str2;
        this.mLikedById = str3;
        this.mThumbUrl = str4;
    }

    public String getMomentByUserId() {
        return this.mMomentByUserId;
    }

    public void setMomentByUserId(String str) {
        this.mMomentByUserId = str;
    }

    @Nullable
    public String getMomentId() {
        return this.mMomentId;
    }

    @Nullable
    public String getLikedbyId() {
        return this.mLikedById;
    }

    @Nullable
    public String getThumbUrl() {
        return this.mThumbUrl;
    }

    @Nullable
    public String getMixedId() {
        return this.mMomentId + this.mLikedById;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MomentLike momentLike = (MomentLike) obj;
        if (this.mMomentId == null ? momentLike.mMomentId != null : !this.mMomentId.equals(momentLike.mMomentId)) {
            return false;
        }
        if (this.mLikedById != null) {
            if (this.mLikedById.equals(momentLike.mLikedById)) {
                return true;
            }
        } else if (momentLike.mLikedById == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        if (this.mMomentId != null) {
            hashCode = this.mMomentId.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode *= 31;
        if (this.mLikedById != null) {
            i = this.mLikedById.hashCode();
        }
        return hashCode + i;
    }

    public String getId() {
        return this.mMomentId + this.mLikedById;
    }

    public String toString() {
        return "Message{id='" + getId() + '\'' + ", date='" + getCreationDate() + '\'' + '}';
    }
}
