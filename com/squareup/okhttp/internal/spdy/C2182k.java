package com.squareup.okhttp.internal.spdy;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.Arrays;

/* renamed from: com.squareup.okhttp.internal.spdy.k */
public final class C2182k {
    private int f3442a;
    private int f3443b;
    private int f3444c;
    private final int[] f3445d;

    public C2182k() {
        this.f3445d = new int[10];
    }

    void m5499a() {
        this.f3444c = 0;
        this.f3443b = 0;
        this.f3442a = 0;
        Arrays.fill(this.f3445d, 0);
    }

    C2182k m5498a(int i, int i2, int i3) {
        if (i < this.f3445d.length) {
            int i4 = 1 << i;
            this.f3442a |= i4;
            if ((i2 & 1) != 0) {
                this.f3443b |= i4;
            } else {
                this.f3443b &= i4 ^ -1;
            }
            if ((i2 & 2) != 0) {
                this.f3444c = i4 | this.f3444c;
            } else {
                this.f3444c = (i4 ^ -1) & this.f3444c;
            }
            this.f3445d[i] = i3;
        }
        return this;
    }

    boolean m5501a(int i) {
        if (((1 << i) & this.f3442a) != 0) {
            return true;
        }
        return false;
    }

    int m5503b(int i) {
        return this.f3445d[i];
    }

    int m5505c(int i) {
        int i2 = 0;
        if (m5509g(i)) {
            i2 = 2;
        }
        if (m5508f(i)) {
            return i2 | 1;
        }
        return i2;
    }

    int m5502b() {
        return Integer.bitCount(this.f3442a);
    }

    int m5504c() {
        return (2 & this.f3442a) != 0 ? this.f3445d[1] : -1;
    }

    int m5506d(int i) {
        return (32 & this.f3442a) != 0 ? this.f3445d[5] : i;
    }

    int m5507e(int i) {
        return (AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS & this.f3442a) != 0 ? this.f3445d[7] : i;
    }

    boolean m5508f(int i) {
        if (((1 << i) & this.f3443b) != 0) {
            return true;
        }
        return false;
    }

    boolean m5509g(int i) {
        if (((1 << i) & this.f3444c) != 0) {
            return true;
        }
        return false;
    }

    void m5500a(C2182k c2182k) {
        for (int i = 0; i < 10; i++) {
            if (c2182k.m5501a(i)) {
                m5498a(i, c2182k.m5505c(i), c2182k.m5503b(i));
            }
        }
    }
}
