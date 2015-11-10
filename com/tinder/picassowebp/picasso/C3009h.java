package com.tinder.picassowebp.picasso;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* renamed from: com.tinder.picassowebp.picasso.h */
class C3009h implements OnPreDrawListener {
    final C3029t f6369a;
    final WeakReference<ImageView> f6370b;
    C2311e f6371c;

    C3009h(C3029t c3029t, ImageView imageView, C2311e c2311e) {
        this.f6369a = c3029t;
        this.f6370b = new WeakReference(imageView);
        this.f6371c = c2311e;
        imageView.getViewTreeObserver().addOnPreDrawListener(this);
    }

    public boolean onPreDraw() {
        ImageView imageView = (ImageView) this.f6370b.get();
        if (imageView != null) {
            ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                int width = imageView.getWidth();
                int height = imageView.getHeight();
                if (width > 0 && height > 0) {
                    viewTreeObserver.removeOnPreDrawListener(this);
                    this.f6369a.m9119a().m9129b(width, height).m9125a(imageView, this.f6371c);
                }
            }
        }
        return true;
    }

    void m9053a() {
        this.f6371c = null;
        ImageView imageView = (ImageView) this.f6370b.get();
        if (imageView != null) {
            ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this);
            }
        }
    }
}
