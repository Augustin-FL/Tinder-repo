package com.tinder.picassowebp.picasso;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.tinder.picassowebp.picasso.C3026s.C3025a;
import com.tinder.picassowebp.picasso.Picasso.LoadedFrom;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.tinder.picassowebp.picasso.t */
public class C3029t {
    private static int f6444a;
    private final Picasso f6445b;
    private final C3025a f6446c;
    private boolean f6447d;
    private boolean f6448e;
    private boolean f6449f;
    private int f6450g;
    private int f6451h;
    private Drawable f6452i;
    private Drawable f6453j;

    /* renamed from: com.tinder.picassowebp.picasso.t.1 */
    static class C30271 implements Runnable {
        final /* synthetic */ AtomicInteger f6441a;
        final /* synthetic */ CountDownLatch f6442b;

        C30271(AtomicInteger atomicInteger, CountDownLatch countDownLatch) {
            this.f6441a = atomicInteger;
            this.f6442b = countDownLatch;
        }

        public void run() {
            this.f6441a.set(C3029t.m9118f());
            this.f6442b.countDown();
        }
    }

    /* renamed from: com.tinder.picassowebp.picasso.t.2 */
    static class C30282 implements Runnable {
        final /* synthetic */ InterruptedException f6443a;

        C30282(InterruptedException interruptedException) {
            this.f6443a = interruptedException;
        }

        public void run() {
            throw new RuntimeException(this.f6443a);
        }
    }

    static {
        f6444a = 0;
    }

    C3029t(Picasso picasso, Uri uri, int i) {
        if (picasso.f6342l) {
            throw new IllegalStateException("Picasso instance already shut down. Cannot submit new requests.");
        }
        this.f6445b = picasso;
        this.f6446c = new C3025a(uri, i);
    }

    private static int m9118f() {
        if (ab.m9030b()) {
            int i = f6444a;
            f6444a = i + 1;
            return i;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        AtomicInteger atomicInteger = new AtomicInteger();
        Picasso.f6331a.post(new C30271(atomicInteger, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            Picasso.f6331a.post(new C30282(e));
        }
        return atomicInteger.get();
    }

    public C3029t m9120a(int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Placeholder image resource invalid.");
        } else if (this.f6452i != null) {
            throw new IllegalStateException("Placeholder image already set.");
        } else {
            this.f6450g = i;
            return this;
        }
    }

    public C3029t m9122a(Drawable drawable) {
        if (this.f6450g != 0) {
            throw new IllegalStateException("Placeholder image already set.");
        }
        this.f6452i = drawable;
        return this;
    }

    public C3029t m9128b(int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Error image resource invalid.");
        } else if (this.f6453j != null) {
            throw new IllegalStateException("Error image already set.");
        } else {
            this.f6451h = i;
            return this;
        }
    }

    C3029t m9119a() {
        this.f6449f = false;
        return this;
    }

    public C3029t m9121a(int i, int i2) {
        Resources resources = this.f6445b.f6333c.getResources();
        return m9129b(resources.getDimensionPixelSize(i), resources.getDimensionPixelSize(i2));
    }

    public C3029t m9129b(int i, int i2) {
        this.f6446c.m9103a(i, i2);
        return this;
    }

    public C3029t m9127b() {
        this.f6446c.m9107c();
        return this;
    }

    public C3029t m9123a(C3036z c3036z) {
        this.f6446c.m9104a(c3036z);
        return this;
    }

    public C3029t m9130c() {
        this.f6447d = true;
        return this;
    }

    public void m9131d() {
        long nanoTime = System.nanoTime();
        if (this.f6449f) {
            throw new IllegalStateException("Fit cannot be used with fetch.");
        } else if (this.f6446c.m9105a()) {
            C3026s a = m9116a(nanoTime);
            this.f6445b.m8997b(new C3015j(this.f6445b, a, this.f6447d, ab.m9023a(a, new StringBuilder())));
        }
    }

    public void m9126a(C2281x c2281x) {
        long nanoTime = System.nanoTime();
        ab.m9024a();
        if (c2281x == null) {
            throw new IllegalArgumentException("Target must not be null.");
        } else if (this.f6449f) {
            throw new IllegalStateException("Fit cannot be used with a Target.");
        } else {
            Drawable drawable = this.f6450g != 0 ? this.f6445b.f6333c.getResources().getDrawable(this.f6450g) : this.f6452i;
            if (this.f6446c.m9105a()) {
                C3026s a = m9116a(nanoTime);
                String a2 = ab.m9022a(a);
                if (!this.f6447d) {
                    Bitmap b = this.f6445b.m8996b(a2);
                    if (b != null) {
                        this.f6445b.m8995a(c2281x);
                        c2281x.onBitmapLoaded(b, LoadedFrom.MEMORY);
                        return;
                    }
                }
                c2281x.onPrepareLoad(drawable);
                this.f6445b.m8993a(new C3035y(this.f6445b, c2281x, a, this.f6447d, this.f6451h, this.f6453j, a2));
                return;
            }
            this.f6445b.m8995a(c2281x);
            c2281x.onPrepareLoad(drawable);
        }
    }

    public void m9124a(ImageView imageView) {
        m9125a(imageView, null);
    }

    public void m9125a(ImageView imageView, C2311e c2311e) {
        long nanoTime = System.nanoTime();
        ab.m9024a();
        if (imageView == null) {
            throw new IllegalArgumentException("Target must not be null.");
        } else if (this.f6446c.m9105a()) {
            if (this.f6449f) {
                if (this.f6446c.m9106b()) {
                    throw new IllegalStateException("Fit cannot be used with resize.");
                }
                int width = imageView.getWidth();
                int height = imageView.getHeight();
                if (width == 0 || height == 0) {
                    C3022q.m9099a(imageView, this.f6450g, this.f6452i);
                    this.f6445b.m8992a(imageView, new C3009h(this, imageView, c2311e));
                    return;
                }
                this.f6446c.m9103a(width, height);
            }
            C3026s a = m9116a(nanoTime);
            String a2 = ab.m9022a(a);
            if (!this.f6447d) {
                Bitmap b = this.f6445b.m8996b(a2);
                if (b != null) {
                    this.f6445b.m8991a(imageView);
                    C3022q.m9100a(imageView, this.f6445b.f6333c, b, LoadedFrom.MEMORY, this.f6448e, this.f6445b.f6340j);
                    if (this.f6445b.f6341k) {
                        ab.m9027a("Main", "completed", a.m9110b(), "from " + LoadedFrom.MEMORY);
                    }
                    if (c2311e != null) {
                        c2311e.m6287a();
                        return;
                    }
                    return;
                }
            }
            C3022q.m9099a(imageView, this.f6450g, this.f6452i);
            this.f6445b.m8993a(new C3017l(this.f6445b, imageView, a, this.f6447d, this.f6448e, this.f6451h, this.f6453j, a2, c2311e));
        } else {
            this.f6445b.m8991a(imageView);
            C3022q.m9099a(imageView, this.f6450g, this.f6452i);
        }
    }

    private C3026s m9116a(long j) {
        int f = C3029t.m9118f();
        C3026s d = this.f6446c.m9108d();
        d.f6439m = f;
        d.f6440n = j;
        boolean z = this.f6445b.f6341k;
        if (z) {
            ab.m9027a("Main", "created", d.m9110b(), d.toString());
        }
        C3026s a = this.f6445b.m8986a(d);
        if (a != d) {
            a.f6439m = f;
            a.f6440n = j;
            if (z) {
                ab.m9027a("Main", "changed", a.m9109a(), "into " + a);
            }
        }
        return a;
    }
}
