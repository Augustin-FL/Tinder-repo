package com.tinder.model;

import android.support.annotation.NonNull;
import com.tinder.enums.PhotoSizeUser;
import java.io.Serializable;

public class ProcessedPhoto implements Serializable {
    private final String mImageUrl;
    private String mPhotoId;
    @NonNull
    private final PhotoSizeUser mPhotoSizeUser;
    private final int mSizeHeight;
    private final int mSizeWidth;
    private String mUserId;

    public ProcessedPhoto(String str, String str2, String str3, int i, int i2) {
        this.mPhotoId = str;
        this.mUserId = str2;
        this.mImageUrl = str3;
        this.mSizeWidth = i;
        this.mSizeHeight = i2;
        if (this.mSizeWidth <= 84) {
            this.mPhotoSizeUser = PhotoSizeUser.XSMALL;
        } else if (this.mSizeWidth <= 172) {
            this.mPhotoSizeUser = PhotoSizeUser.SMALL;
        } else if (this.mSizeWidth <= 320) {
            this.mPhotoSizeUser = PhotoSizeUser.MED;
        } else if (this.mSizeWidth <= 640) {
            this.mPhotoSizeUser = PhotoSizeUser.LARGE;
        } else {
            this.mPhotoSizeUser = PhotoSizeUser.XLARGE;
        }
    }

    @NonNull
    public PhotoSizeUser getPhotoSize() {
        return this.mPhotoSizeUser;
    }

    public String getUserId() {
        return this.mUserId;
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public int getWidth() {
        return this.mSizeWidth;
    }

    public int getHeight() {
        return this.mSizeHeight;
    }

    public String getPhotoId() {
        return this.mPhotoId;
    }

    public void setPhotoId(String str) {
        this.mPhotoId = str;
    }
}
