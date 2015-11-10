package com.tinder.picassowebp.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tinder.picassowebp.picasso.Picasso.LoadedFrom;

/* renamed from: com.tinder.picassowebp.picasso.x */
public interface C2281x {
    void onBitmapFailed(Drawable drawable);

    void onBitmapLoaded(Bitmap bitmap, LoadedFrom loadedFrom);

    void onPrepareLoad(Drawable drawable);
}
