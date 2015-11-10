package com.tinder.model;

import android.support.annotation.Nullable;
import com.tinder.enums.PhotoSizeUser;
import com.tinder.utils.C3095y;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PhotoUser extends Photo implements Serializable {
    private String mFacebookId;
    private int mHeight;
    private String mImageUrl;
    private boolean mIsMain;
    private int mOriginX;
    private int mOriginY;
    private List<ProcessedPhoto> mProcessedPhotos;
    private int mWidth;
    private float mXDistancePercent;
    private float mXOffsetPercent;
    private float mYDistancePercent;
    private float mYOffsetPercent;

    public PhotoUser(String str, String str2, int i, int i2, float f, float f2, float f3, float f4, int i3, int i4, List<ProcessedPhoto> list) {
        this.mProcessedPhotos = new ArrayList(4);
        this.mImageUrl = str;
        this.mPhotoId = str2;
        this.mWidth = i;
        this.mHeight = i2;
        this.mXDistancePercent = f;
        this.mYDistancePercent = f2;
        this.mXOffsetPercent = f3;
        this.mYOffsetPercent = f4;
        this.mOriginX = i3;
        this.mOriginY = i4;
        this.mProcessedPhotos = list;
    }

    public PhotoUser(String str, String str2, List<ProcessedPhoto> list) {
        this.mProcessedPhotos = new ArrayList(4);
        this.mImageUrl = str;
        this.mPhotoId = str2;
        this.mProcessedPhotos = list;
    }

    public PhotoUser(String str, String str2) {
        this.mProcessedPhotos = new ArrayList(4);
        this.mFacebookId = str;
        this.mImageUrl = str2;
    }

    public PhotoUser(String str) {
        this.mProcessedPhotos = new ArrayList(4);
        this.mPhotoId = str;
    }

    public PhotoUser(String str, ArrayList<ProcessedPhoto> arrayList) {
        this.mProcessedPhotos = new ArrayList(4);
        this.mPhotoId = str;
        this.mProcessedPhotos = arrayList;
    }

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public String getPhotoId() {
        return this.mPhotoId;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public String getFacebookId() {
        return this.mFacebookId;
    }

    public void setFacebookId(String str) {
        this.mFacebookId = str;
    }

    public void setIsMain(boolean z) {
        this.mIsMain = z;
    }

    public boolean isMain() {
        return this.mIsMain;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public float getXDistancePercent() {
        return this.mXDistancePercent;
    }

    public void setXDistancePercent(float f) {
        this.mXDistancePercent = f;
    }

    public float getYDistancePercent() {
        return this.mYDistancePercent;
    }

    public void setYDistancePercent(float f) {
        this.mYDistancePercent = f;
    }

    public float getXOffsetPercent() {
        return this.mXOffsetPercent;
    }

    public void setXOffsetPercent(float f) {
        this.mXOffsetPercent = f;
    }

    public float getYOffsetPercent() {
        return this.mYOffsetPercent;
    }

    public void setYOffsetPercent(float f) {
        this.mYOffsetPercent = f;
    }

    public List<ProcessedPhoto> getProcessedPhotos() {
        return this.mProcessedPhotos;
    }

    public int getOriginX() {
        return this.mOriginX;
    }

    public int getOriginY() {
        return this.mOriginY;
    }

    @Nullable
    public ProcessedPhoto getProcessedPhoto(PhotoSizeUser photoSizeUser) {
        if (this.mProcessedPhotos != null) {
            for (ProcessedPhoto processedPhoto : this.mProcessedPhotos) {
                if (processedPhoto.getPhotoSize() == photoSizeUser) {
                    return processedPhoto;
                }
            }
        }
        C3095y.m9479c("Failed to find match for photo size: " + photoSizeUser);
        return null;
    }

    public void addProcessedPhoto(ProcessedPhoto processedPhoto) {
        this.mProcessedPhotos.add(processedPhoto);
    }

    public String toString() {
        return "PhotoUser{mFacebookId='" + this.mFacebookId + '\'' + ", mImageUrl='" + this.mImageUrl + '\'' + '}';
    }
}
