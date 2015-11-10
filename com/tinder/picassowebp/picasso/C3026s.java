package com.tinder.picassowebp.picasso;

import android.graphics.Bitmap.Config;
import android.net.Uri;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tinder.picassowebp.picasso.s */
public final class C3026s {
    private static final long f6426o;
    public final Uri f6427a;
    public final int f6428b;
    public final List<C3036z> f6429c;
    public final int f6430d;
    public final int f6431e;
    public final boolean f6432f;
    public final boolean f6433g;
    public final float f6434h;
    public final float f6435i;
    public final float f6436j;
    public final boolean f6437k;
    public final Config f6438l;
    int f6439m;
    long f6440n;

    /* renamed from: com.tinder.picassowebp.picasso.s.a */
    public static final class C3025a {
        private Uri f6414a;
        private int f6415b;
        private int f6416c;
        private int f6417d;
        private boolean f6418e;
        private boolean f6419f;
        private float f6420g;
        private float f6421h;
        private float f6422i;
        private boolean f6423j;
        private List<C3036z> f6424k;
        private Config f6425l;

        C3025a(Uri uri, int i) {
            this.f6414a = uri;
            this.f6415b = i;
        }

        boolean m9105a() {
            return (this.f6414a == null && this.f6415b == 0) ? false : true;
        }

        boolean m9106b() {
            return this.f6416c != 0;
        }

        public C3025a m9103a(int i, int i2) {
            if (i <= 0) {
                throw new IllegalArgumentException("Width must be positive number.");
            } else if (i2 <= 0) {
                throw new IllegalArgumentException("Height must be positive number.");
            } else {
                this.f6416c = i;
                this.f6417d = i2;
                return this;
            }
        }

        public C3025a m9107c() {
            if (this.f6419f) {
                throw new IllegalStateException("Center crop can not be used after calling centerInside");
            }
            this.f6418e = true;
            return this;
        }

        public C3025a m9104a(C3036z c3036z) {
            if (c3036z == null) {
                throw new IllegalArgumentException("Transformation must not be null.");
            }
            if (this.f6424k == null) {
                this.f6424k = new ArrayList(2);
            }
            this.f6424k.add(c3036z);
            return this;
        }

        public C3026s m9108d() {
            if (this.f6419f && this.f6418e) {
                throw new IllegalStateException("Center crop and center inside can not be used together.");
            } else if (this.f6418e && this.f6416c == 0) {
                throw new IllegalStateException("Center crop requires calling resize.");
            } else if (!this.f6419f || this.f6416c != 0) {
                return new C3026s(this.f6415b, this.f6424k, this.f6416c, this.f6417d, this.f6418e, this.f6419f, this.f6420g, this.f6421h, this.f6422i, this.f6423j, this.f6425l, null);
            } else {
                throw new IllegalStateException("Center inside requires calling resize.");
            }
        }
    }

    static {
        f6426o = TimeUnit.SECONDS.toNanos(5);
    }

    private C3026s(Uri uri, int i, List<C3036z> list, int i2, int i3, boolean z, boolean z2, float f, float f2, float f3, boolean z3, Config config) {
        this.f6427a = uri;
        this.f6428b = i;
        if (list == null) {
            this.f6429c = null;
        } else {
            this.f6429c = Collections.unmodifiableList(list);
        }
        this.f6430d = i2;
        this.f6431e = i3;
        this.f6432f = z;
        this.f6433g = z2;
        this.f6434h = f;
        this.f6435i = f2;
        this.f6436j = f3;
        this.f6437k = z3;
        this.f6438l = config;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Request{");
        if (this.f6428b > 0) {
            stringBuilder.append(this.f6428b);
        } else {
            stringBuilder.append(this.f6427a);
        }
        if (!(this.f6429c == null || this.f6429c.isEmpty())) {
            for (C3036z key : this.f6429c) {
                stringBuilder.append(' ').append(key.key());
            }
        }
        if (this.f6430d > 0) {
            stringBuilder.append(" resize(").append(this.f6430d).append(',').append(this.f6431e).append(')');
        }
        if (this.f6432f) {
            stringBuilder.append(" centerCrop");
        }
        if (this.f6433g) {
            stringBuilder.append(" centerInside");
        }
        if (this.f6434h != 0.0f) {
            stringBuilder.append(" rotation(").append(this.f6434h);
            if (this.f6437k) {
                stringBuilder.append(" @ ").append(this.f6435i).append(',').append(this.f6436j);
            }
            stringBuilder.append(')');
        }
        if (this.f6438l != null) {
            stringBuilder.append(' ').append(this.f6438l);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    String m9109a() {
        long nanoTime = System.nanoTime() - this.f6440n;
        if (nanoTime > f6426o) {
            return m9110b() + '+' + TimeUnit.NANOSECONDS.toSeconds(nanoTime) + 's';
        }
        return m9110b() + '+' + TimeUnit.NANOSECONDS.toMillis(nanoTime) + "ms";
    }

    String m9110b() {
        return "[R" + this.f6439m + ']';
    }

    String m9111c() {
        if (this.f6427a != null) {
            return this.f6427a.getPath();
        }
        return Integer.toHexString(this.f6428b);
    }

    public boolean m9112d() {
        return this.f6430d != 0;
    }

    boolean m9113e() {
        return m9114f() || m9115g();
    }

    boolean m9114f() {
        return (this.f6430d == 0 && this.f6434h == 0.0f) ? false : true;
    }

    boolean m9115g() {
        return this.f6429c != null;
    }
}
