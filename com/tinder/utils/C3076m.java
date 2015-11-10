package com.tinder.utils;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v4.util.LruCache;
import com.tinder.picassowebp.picasso.C3005d;

/* renamed from: com.tinder.utils.m */
public class C3076m implements C3005d {
    private LruCache<String, Bitmap> f6620b;

    public C3076m(int i) {
        this.f6620b = new LruCache(i);
    }

    public Bitmap m9396a(@NonNull String str) {
        return (Bitmap) this.f6620b.get(str);
    }

    public void m9397a(@NonNull String str, @NonNull Bitmap bitmap) {
        this.f6620b.put(str, bitmap);
    }

    public int m9395a() {
        return this.f6620b.size();
    }

    public int m9398b() {
        return this.f6620b.maxSize();
    }
}
