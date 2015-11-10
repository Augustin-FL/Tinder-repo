package com.tinder.model;

import android.support.annotation.NonNull;
import com.tinder.enums.PhotoSizeMoment;

public class PhotoMoment extends Photo {
    public static final int NUM_PROCESSED_PHOTOS = 5;
    private String[] mProcessedFiles;

    public PhotoMoment(String str, String[] strArr) {
        this.mPhotoId = str;
        this.mProcessedFiles = strArr;
    }

    public String getProcessedFile(@NonNull PhotoSizeMoment photoSizeMoment) {
        return this.mProcessedFiles[photoSizeMoment.ordinal()];
    }
}
