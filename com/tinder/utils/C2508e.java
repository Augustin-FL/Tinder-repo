package com.tinder.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tinder.picassowebp.picasso.C2281x;
import com.tinder.picassowebp.picasso.Picasso.LoadedFrom;

/* renamed from: com.tinder.utils.e */
public class C2508e implements C2281x {
    private final ImageView f4534a;

    public C2508e(ImageView imageView) {
        this.f4534a = imageView;
        this.f4534a.setTag(this);
    }

    public void onBitmapLoaded(Bitmap bitmap, LoadedFrom loadedFrom) {
        this.f4534a.setImageBitmap(bitmap);
    }

    public void onBitmapFailed(Drawable drawable) {
    }

    public void onPrepareLoad(Drawable drawable) {
    }
}
