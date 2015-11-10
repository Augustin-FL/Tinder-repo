package com.tinder.picassowebp.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tinder.picassowebp.picasso.Picasso.LoadedFrom;

/* renamed from: com.tinder.picassowebp.picasso.y */
final class C3035y extends C2993a<C2281x> {
    C3035y(Picasso picasso, C2281x c2281x, C3026s c3026s, boolean z, int i, Drawable drawable, String str) {
        super(picasso, c2281x, c3026s, z, false, i, drawable, str);
    }

    void m9150a(Bitmap bitmap, LoadedFrom loadedFrom) {
        if (bitmap == null) {
            throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[]{this}));
        }
        C2281x c2281x = (C2281x) m9002d();
        if (c2281x != null) {
            c2281x.onBitmapLoaded(bitmap, loadedFrom);
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Target callback must not recycle bitmap!");
            }
        }
    }

    void m9149a() {
        C2281x c2281x = (C2281x) m9002d();
        if (c2281x == null) {
            return;
        }
        if (this.f != 0) {
            c2281x.onBitmapFailed(this.a.f6333c.getResources().getDrawable(this.f));
        } else {
            c2281x.onBitmapFailed(this.g);
        }
    }
}
