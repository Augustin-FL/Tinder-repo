package com.google.android.m4b.maps.aj;

import com.facebook.internal.NativeProtocol;
import com.google.android.m4b.maps.am.e;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.google.android.m4b.maps.aj.e */
public final class C1336e {
    private final C1338g f831a;

    /* renamed from: com.google.android.m4b.maps.aj.e.1 */
    static /* synthetic */ class C13341 {
        static final /* synthetic */ int[] f826a;

        static {
            f826a = new int[C1335a.values().length];
            try {
                f826a[C1335a.FADE_IN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f826a[C1335a.FADE_OUT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f826a[C1335a.FADE_BETWEEN.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* renamed from: com.google.android.m4b.maps.aj.e.a */
    public enum C1335a {
        FADE_IN,
        FADE_OUT,
        FADE_BETWEEN
    }

    public C1336e(long j, C1335a c1335a) {
        this(0, 500, c1335a);
    }

    public C1336e(long j, long j2, C1335a c1335a) {
        this(j, j2, c1335a, 0, 0);
    }

    public C1336e(long j, long j2, C1335a c1335a, int i, int i2) {
        this.f831a = new C1338g(new C1332c(((float) j) / ((float) (j + j2))));
        this.f831a.setDuration(j + j2);
        switch (C13341.f826a[c1335a.ordinal()]) {
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                this.f831a.m1114a(0);
                this.f831a.m1114a((int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                this.f831a.m1114a((int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
                this.f831a.m1114a(0);
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                this.f831a.m1114a(i);
                this.f831a.m1114a(i2);
            default:
        }
    }

    public final int m1108a(e eVar) {
        long e = eVar.e();
        if (!this.f831a.hasStarted()) {
            this.f831a.start();
        }
        this.f831a.m1115a(e);
        int b = this.f831a.m1116b();
        if (!this.f831a.hasEnded()) {
            eVar.b();
        }
        return b;
    }

    public final void m1109a() {
        this.f831a.start();
    }
}
