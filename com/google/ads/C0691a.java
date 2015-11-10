package com.google.ads;

import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import com.google.android.gms.ads.AdSize;
import org.apache.http.HttpStatus;

@Deprecated
/* renamed from: com.google.ads.a */
public final class C0691a {
    public static final C0691a f720a;
    public static final C0691a f721b;
    public static final C0691a f722c;
    public static final C0691a f723d;
    public static final C0691a f724e;
    public static final C0691a f725f;
    private final AdSize f726g;

    static {
        f720a = new C0691a(-1, -2, "mb");
        f721b = new C0691a(320, 50, "mb");
        f722c = new C0691a(HttpStatus.SC_MULTIPLE_CHOICES, Callback.DEFAULT_SWIPE_ANIMATION_DURATION, "as");
        f723d = new C0691a(468, 60, "as");
        f724e = new C0691a(728, 90, "as");
        f725f = new C0691a(160, 600, "as");
    }

    private C0691a(int i, int i2, String str) {
        this(new AdSize(i, i2));
    }

    public C0691a(AdSize adSize) {
        this.f726g = adSize;
    }

    public int m951a() {
        return this.f726g.getWidth();
    }

    public int m952b() {
        return this.f726g.getHeight();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0691a)) {
            return false;
        }
        return this.f726g.equals(((C0691a) obj).f726g);
    }

    public int hashCode() {
        return this.f726g.hashCode();
    }

    public String toString() {
        return this.f726g.toString();
    }
}
