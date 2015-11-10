package com.tinder.picassowebp.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tinder.picassowebp.picasso.Picasso.LoadedFrom;

/* renamed from: com.tinder.picassowebp.picasso.l */
class C3017l extends C2993a<ImageView> {
    C2311e f6390k;

    C3017l(Picasso picasso, ImageView imageView, C3026s c3026s, boolean z, boolean z2, int i, Drawable drawable, String str, C2311e c2311e) {
        super(picasso, imageView, c3026s, z, z2, i, drawable, str);
        this.f6390k = c2311e;
    }

    public void m9080a(Bitmap bitmap, LoadedFrom loadedFrom) {
        if (bitmap == null) {
            throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[]{this}));
        }
        ImageView imageView = (ImageView) this.c.get();
        if (imageView != null) {
            Bitmap bitmap2 = bitmap;
            LoadedFrom loadedFrom2 = loadedFrom;
            C3022q.m9100a(imageView, this.a.f6333c, bitmap2, loadedFrom2, this.e, this.a.f6340j);
            if (this.f6390k != null) {
                this.f6390k.m6287a();
            }
        }
    }

    public void m9079a() {
        ImageView imageView = (ImageView) this.c.get();
        if (imageView != null) {
            if (this.f != 0) {
                imageView.setImageResource(this.f);
            } else if (this.g != null) {
                imageView.setImageDrawable(this.g);
            }
            if (this.f6390k != null) {
                this.f6390k.m6288b();
            }
        }
    }

    void m9081b() {
        super.m9000b();
        if (this.f6390k != null) {
            this.f6390k = null;
        }
    }
}
