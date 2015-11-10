package com.google.android.m4b.maps.by;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.m4b.maps.GoogleMapOptions;
import com.google.android.m4b.maps.StreetViewPanoramaOptions;
import com.google.android.m4b.maps.bq.an;
import com.google.android.m4b.maps.bq.ar;
import com.google.android.m4b.maps.bq.au;
import com.google.android.m4b.maps.bq.ay;
import com.google.android.m4b.maps.bq.bc;
import com.google.android.m4b.maps.bq.bi;
import com.google.android.m4b.maps.bq.c;
import com.google.android.m4b.maps.bq.i;
import com.google.android.m4b.maps.bq.l;
import com.google.android.m4b.maps.bv.b;
import com.google.android.m4b.maps.bv.d;
import com.google.android.m4b.maps.by.p.a;
import com.google.android.m4b.maps.f;

/* renamed from: com.google.android.m4b.maps.by.m */
public class C1467m extends a {
    public final void m2279a(b bVar) {
        m2280a(bVar, 0);
    }

    public final void m2280a(b bVar, int i) {
        au.a(4, "Google Play services client version: " + i);
        c.a((Resources) d.a(bVar));
        ay.a(i);
        k.a(i);
        f.a(this);
    }

    public final t m2281b(b bVar) {
        Context context = (Activity) d.a(bVar);
        C1467m.m2275a(context);
        return i.a(context);
    }

    public final u m2278a(b bVar, GoogleMapOptions googleMapOptions) {
        Context context = (Context) d.a(bVar);
        C1467m.m2275a(context);
        return new l(context, googleMapOptions);
    }

    public final f m2283c(b bVar) {
        Context context = (Activity) d.a(bVar);
        C1467m.m2275a(context);
        return an.a(context);
    }

    public final g m2276a(b bVar, StreetViewPanoramaOptions streetViewPanoramaOptions) {
        Context context = (Context) d.a(bVar);
        C1467m.m2275a(context);
        return new ar(context, streetViewPanoramaOptions);
    }

    public final n m2277a() {
        return new bi();
    }

    public final com.google.android.m4b.maps.model.a.a m2282b() {
        return new bc();
    }

    private static void m2275a(Context context) {
        try {
            au.a(4, "Google Play services package version: " + context.getPackageManager().getPackageInfo(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, 0).versionCode);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }
}
