package com.google.android.m4b.maps.p011o;

import android.graphics.Bitmap;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.location.places.Place;
import com.google.android.m4b.maps.bm.m;
import com.google.android.m4b.maps.bq.w;
import com.google.android.m4b.maps.bq.w.a;
import com.google.android.m4b.maps.model.LatLng;
import com.google.android.m4b.maps.p009m.C1485b;

/* renamed from: com.google.android.m4b.maps.o.e */
public final class C1496e implements a {
    private m f1486a;
    private final w f1487b;
    private final C1495d f1488c;

    public C1496e(w wVar, C1495d c1495d) {
        this.f1487b = wVar;
        this.f1488c = c1495d;
    }

    public final void m2385a() {
        this.f1486a = C1496e.m2384a(this.f1487b.a(), this.f1487b.e(), this.f1487b.f(), this.f1487b.h(), this.f1487b.j(), this.f1487b.l(), this.f1487b.n(), this.f1487b.t(), this.f1487b.y(), this.f1487b.A(), this.f1487b.C(), this.f1487b.E());
        this.f1488c.m2374a(this);
        this.f1488c.m2371a();
    }

    public final void m2386a(int i) {
        if ((i & 1) != 0) {
            this.f1486a.a(C1493b.m2363b(this.f1487b.d()));
            this.f1488c.m2375b();
            this.f1488c.m2371a();
        }
        if ((i & 2) != 0) {
            String o = this.f1487b.o();
            String q = this.f1487b.q();
            this.f1488c.m2373a(this.f1486a);
            this.f1486a = C1496e.m2384a(this.f1487b.a(), this.f1487b.e(), this.f1487b.f(), this.f1487b.g(), this.f1487b.i(), this.f1487b.k(), this.f1487b.m(), this.f1487b.t(), this.f1487b.y(), this.f1487b.A(), this.f1487b.C(), this.f1487b.E());
            this.f1486a.a(o);
            this.f1486a.b(q);
            this.f1488c.m2374a(this);
            this.f1488c.m2371a();
        }
        if ((i & 4) != 0) {
            this.f1486a.a(Math.round(this.f1487b.h() * ((float) this.f1486a.h().getWidth())), Math.round(this.f1487b.j() * ((float) this.f1486a.h().getHeight())));
            this.f1488c.m2371a();
        }
        if ((i & 8) != 0) {
            this.f1486a.b(!this.f1487b.A());
            this.f1488c.m2371a();
        }
        if ((i & 16) != 0) {
            this.f1486a.a(this.f1487b.C());
            this.f1488c.m2371a();
        }
        if ((i & 64) != 0) {
            boolean y = this.f1487b.y();
            if (!y) {
                this.f1488c.m2381c(this);
            }
            this.f1486a.c(y);
            this.f1488c.m2371a();
            this.f1488c.m2375b();
        }
        if ((i & Place.TYPE_SUBLOCALITY_LEVEL_2) != 0) {
            this.f1486a.b(this.f1487b.E());
            this.f1488c.m2371a();
        }
        if ((i & AccessibilityNodeInfoCompat.ACTION_PREVIOUS_HTML_ELEMENT) != 0) {
            this.f1488c.m2377b(this);
            this.f1488c.m2371a();
        }
        if ((i & AccessibilityNodeInfoCompat.ACTION_SCROLL_FORWARD) != 0) {
            this.f1488c.m2381c(this);
            this.f1488c.m2371a();
        }
        if ((i & AdRequest.MAX_CONTENT_URL_LENGTH) != 0) {
            this.f1486a.b(Math.round(this.f1487b.l() * ((float) this.f1486a.h().getWidth())), Math.round(this.f1487b.n() * ((float) this.f1486a.h().getHeight())));
            this.f1488c.m2371a();
        }
        if ((i & AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) != 0) {
            this.f1486a.a(this.f1487b.p());
            this.f1488c.m2371a();
        }
        if ((i & 32) != 0) {
            this.f1486a.a(this.f1487b.t());
        }
        if ((i & AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY) != 0) {
            this.f1486a.b(this.f1487b.r());
            this.f1488c.m2371a();
        }
    }

    public final void m2387b() {
        this.f1488c.m2373a(this.f1486a);
        this.f1488c.m2371a();
    }

    private static m m2384a(String str, LatLng latLng, Bitmap bitmap, float f, float f2, float f3, float f4, boolean z, boolean z2, boolean z3, float f5, float f6) {
        m mVar = new m(C1493b.m2363b(latLng), bitmap, null, Math.round(((float) bitmap.getWidth()) * f), Math.round(((float) bitmap.getHeight()) * f2), null, null, false);
        mVar.c(str);
        mVar.a(z);
        mVar.c(z2);
        mVar.b(!z3);
        mVar.a(f5);
        mVar.b(Math.round(((float) bitmap.getWidth()) * f3), Math.round(((float) bitmap.getHeight()) * f4));
        mVar.b(f6);
        return mVar;
    }

    public final void m2388c() {
        w wVar = this.f1487b;
        C1485b e = this.f1486a.e();
        wVar.b(new LatLng(((double) e.m2307a()) * 1.0E-6d, ((double) e.m2308b()) * 1.0E-6d));
    }

    public final boolean m2389d() {
        return this.f1488c.m2378b(this.f1486a);
    }

    public final m m2390e() {
        return this.f1486a;
    }

    public final w m2391f() {
        return this.f1487b;
    }
}
