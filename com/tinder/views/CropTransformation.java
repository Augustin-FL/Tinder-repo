package com.tinder.views;

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.support.annotation.NonNull;
import com.tinder.picassowebp.picasso.C3036z;

public class CropTransformation implements C3036z {
    private int mHeight;
    private int mWidth;

    public CropTransformation(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
    }

    public Bitmap transform(Bitmap bitmap) {
        return ThumbnailUtils.extractThumbnail(bitmap, this.mWidth, this.mHeight, 2);
    }

    @NonNull
    public String key() {
        return "CropTransformation";
    }
}
