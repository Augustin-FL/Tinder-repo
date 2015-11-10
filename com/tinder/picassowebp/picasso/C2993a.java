package com.tinder.picassowebp.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tinder.picassowebp.picasso.Picasso.LoadedFrom;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* renamed from: com.tinder.picassowebp.picasso.a */
abstract class C2993a<T> {
    final Picasso f6347a;
    final C3026s f6348b;
    final WeakReference<T> f6349c;
    final boolean f6350d;
    final boolean f6351e;
    final int f6352f;
    final Drawable f6353g;
    final String f6354h;
    boolean f6355i;
    boolean f6356j;

    /* renamed from: com.tinder.picassowebp.picasso.a.a */
    static class C2992a<T> extends WeakReference<T> {
        final C2993a f6346a;

        public C2992a(C2993a c2993a, T t, ReferenceQueue<? super T> referenceQueue) {
            super(t, referenceQueue);
            this.f6346a = c2993a;
        }
    }

    abstract void m8998a();

    abstract void m8999a(Bitmap bitmap, LoadedFrom loadedFrom);

    C2993a(Picasso picasso, T t, C3026s c3026s, boolean z, boolean z2, int i, Drawable drawable, String str) {
        this.f6347a = picasso;
        this.f6348b = c3026s;
        this.f6349c = new C2992a(this, t, picasso.f6339i);
        this.f6350d = z;
        this.f6351e = z2;
        this.f6352f = i;
        this.f6353g = drawable;
        this.f6354h = str;
    }

    void m9000b() {
        this.f6356j = true;
    }

    C3026s m9001c() {
        return this.f6348b;
    }

    T m9002d() {
        return this.f6349c.get();
    }

    String m9003e() {
        return this.f6354h;
    }

    boolean m9004f() {
        return this.f6356j;
    }

    boolean m9005g() {
        return this.f6355i;
    }

    Picasso m9006h() {
        return this.f6347a;
    }
}
