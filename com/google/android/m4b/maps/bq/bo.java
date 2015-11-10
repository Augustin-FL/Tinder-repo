package com.google.android.m4b.maps.bq;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import com.facebook.stetho.BuildConfig;
import com.google.android.m4b.maps.GoogleMapOptions;
import com.google.android.m4b.maps.by.aa;
import com.google.android.m4b.maps.by.ab;
import com.google.android.m4b.maps.by.ac;
import com.google.android.m4b.maps.by.ad;
import com.google.android.m4b.maps.by.ae;
import com.google.android.m4b.maps.by.af;
import com.google.android.m4b.maps.by.ag;
import com.google.android.m4b.maps.by.ah;
import com.google.android.m4b.maps.by.h;
import com.google.android.m4b.maps.by.i;
import com.google.android.m4b.maps.by.o;
import com.google.android.m4b.maps.by.q.a;
import com.google.android.m4b.maps.by.r;
import com.google.android.m4b.maps.by.s;
import com.google.android.m4b.maps.by.v;
import com.google.android.m4b.maps.by.w;
import com.google.android.m4b.maps.by.x;
import com.google.android.m4b.maps.by.y;
import com.google.android.m4b.maps.cf.b;
import com.google.android.m4b.maps.model.CameraPosition;
import com.google.android.m4b.maps.model.CircleOptions;
import com.google.android.m4b.maps.model.GroundOverlayOptions;
import com.google.android.m4b.maps.model.MapsEngineLayerOptions;
import com.google.android.m4b.maps.model.MarkerOptions;
import com.google.android.m4b.maps.model.PolygonOptions;
import com.google.android.m4b.maps.model.PolylineOptions;
import com.google.android.m4b.maps.model.TileOverlayOptions;
import com.google.android.m4b.maps.model.a.c;
import com.google.android.m4b.maps.model.a.d;
import com.google.android.m4b.maps.model.a.g;
import com.google.android.m4b.maps.model.a.j;
import com.google.android.m4b.maps.model.a.k;
import com.google.android.m4b.maps.p011o.C1529s;
import com.google.android.m4b.maps.p011o.C1545x;
import com.google.android.m4b.maps.p013q.C1548b;
import com.google.android.m4b.maps.p013q.C1555g;
import com.google.common.base.C1650g;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public final class bo extends a implements h, v {
    private static final boolean f1384a;
    private final ba.a f1385A;
    private a f1386B;
    private boolean f1387C;
    private boolean f1388D;
    private v f1389E;
    private final bh f1390b;
    private final k f1391c;
    private final be f1392d;
    private final x f1393e;
    private final aa f1394f;
    private final ab f1395g;
    private final g f1396h;
    private final C1465z f1397i;
    private final az f1398j;
    private final bf f1399k;
    private final j f1400l;
    private final av f1401m;
    private final View f1402n;
    private final bu f1403o;
    private final GoogleMapOptions f1404p;
    private final bl f1405q;
    private final bw f1406r;
    private final ScheduledExecutorService f1407s;
    private final ak f1408t;
    private int f1409u;
    private h f1410v;
    private int f1411w;
    private int f1412x;
    private int f1413y;
    private int f1414z;

    public final /* synthetic */ d m2182C() {
        this.f1401m.b();
        this.f1403o.b(bu.a.bC);
        bs c = this.f1406r.c();
        return c != null ? new br(this.f1406r, c, this.f1403o) : null;
    }

    static {
        int i = com.google.android.m4b.maps.bt.a.a;
        f1384a = true;
    }

    public static bo m2166a(LayoutInflater layoutInflater, GoogleMapOptions googleMapOptions, boolean z) {
        String str = BuildConfig.FLAVOR;
        C1650g.m3080a((Object) googleMapOptions);
        C1548b d = C1555g.m2749d();
        boolean z2 = d != null && d.m2721b();
        bm bmVar = new bm(new b(), "map_start_up", z2);
        bmVar.a();
        bl.a a = bmVar.a("init");
        bl.a a2 = bmVar.a("map_load");
        Context context = layoutInflater.getContext();
        Context applicationContext = context.getApplicationContext();
        Resources a3 = c.a();
        m mVar = new m(applicationContext);
        mVar.a();
        applicationContext = b.a(applicationContext, mVar);
        bu b = ax.b();
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(10);
        az azVar = new az(applicationContext, a3);
        bf bfVar = new bf(applicationContext, a3);
        be a4 = be.a(applicationContext);
        View a5 = azVar.a();
        boolean a6 = m2168a(googleMapOptions);
        k a7 = au.a(z) ? C1529s.m2576a(applicationContext, a3, mVar, newScheduledThreadPool, a5, b, str, a6) : C1545x.m2687a(applicationContext, a3, mVar, newScheduledThreadPool, a5, b, str, a6);
        a5 = a7.f();
        if ((a5 instanceof SurfaceView) && googleMapOptions.j() != null) {
            ((SurfaceView) a5).setZOrderOnTop(googleMapOptions.j().booleanValue());
        }
        bh g = a7.g();
        x a8 = x.a(a7.h(), a4, applicationContext, a3, b);
        ab i = a7.i();
        aa aaVar = new aa();
        s sVar = new s(context, a3, i, aaVar, a4, b);
        i.a(sVar);
        h a9 = h.a(applicationContext);
        C1465z c1465z = new C1465z(applicationContext, a3, g, bfVar.c(), a7.j(), a9, b);
        bw k = a7.k();
        ak l = a7.l();
        j m = a7.m();
        m.b(new 2(bmVar, a2));
        View frameLayout = new FrameLayout(applicationContext);
        frameLayout.addView(a5);
        frameLayout.addView(azVar.a());
        frameLayout.addView(bfVar.a());
        frameLayout.addView(sVar.d());
        bo boVar = new bo(frameLayout, a7, a4, a8, a9, c1465z, i, aaVar, g, azVar, bfVar, sVar, m, av.a(), b, googleMapOptions, bmVar, a3, k, l, newScheduledThreadPool);
        ab abVar = boVar.f1395g;
        boVar.f1391c.n().a(new 3(boVar));
        if (boVar.f1404p.o() != null) {
            boVar.m2227g(boVar.f1404p.o().booleanValue());
        } else {
            boVar.m2174q(f1384a);
        }
        boVar.m2172o(true);
        boVar.m2171n(true);
        if (boVar.f1404p.n() != null) {
            boVar.m2225f(boVar.f1404p.n().booleanValue());
        } else {
            boVar.m2173p(f1384a);
        }
        if (boVar.f1404p.l() != -1) {
            boVar.m2191a(boVar.f1404p.l());
        }
        if (boVar.f1404p.q() != null) {
            boVar.m2232j(boVar.f1404p.q().booleanValue());
        } else {
            boVar.m2177t(true);
        }
        if (boVar.f1404p.p() != null) {
            boVar.m2231i(boVar.f1404p.p().booleanValue());
        } else {
            boVar.m2176s(true);
        }
        if (boVar.f1404p.r() != null) {
            boVar.m2234k(boVar.f1404p.r().booleanValue());
        } else {
            boVar.m2178u(true);
        }
        if (boVar.f1404p.s() != null) {
            boVar.m2236l(boVar.f1404p.s().booleanValue());
        } else {
            boVar.m2179v(true);
        }
        boVar.m2175r(f1384a);
        b.a(bu.a.a);
        ah.a(applicationContext).a(1);
        bmVar.a(a);
        return boVar;
    }

    private bo(View view, k kVar, be beVar, x xVar, g gVar, C1465z c1465z, ab abVar, aa aaVar, bh bhVar, az azVar, bf bfVar, s sVar, j jVar, av avVar, bu buVar, GoogleMapOptions googleMapOptions, bl blVar, Resources resources, bw bwVar, ak akVar, ScheduledExecutorService scheduledExecutorService) {
        this.f1409u = 1;
        this.f1411w = 0;
        this.f1412x = 0;
        this.f1413y = 0;
        this.f1414z = 0;
        this.f1385A = new 1(this);
        this.f1388D = true;
        this.f1402n = view;
        this.f1391c = kVar;
        this.f1392d = beVar;
        this.f1393e = xVar;
        this.f1396h = gVar;
        this.f1397i = c1465z;
        this.f1395g = abVar;
        this.f1394f = aaVar;
        this.f1390b = bhVar;
        this.f1398j = azVar;
        this.f1399k = bfVar;
        this.f1400l = jVar;
        this.f1401m = avVar;
        this.f1403o = buVar;
        this.f1404p = googleMapOptions;
        this.f1405q = blVar;
        this.f1406r = bwVar;
        this.f1408t = akVar;
        this.f1407s = scheduledExecutorService;
    }

    public final void m2193a(Bundle bundle) {
        bl.a a = this.f1405q.a("on_create");
        CameraPosition cameraPosition = (CameraPosition) i.a(bundle, "camera");
        if (cameraPosition == null) {
            cameraPosition = this.f1404p.m() != null ? this.f1404p.m() : bh.a;
        }
        this.f1390b.a(cameraPosition, 0);
        this.f1405q.a(a);
    }

    public final void m2190a() {
        this.f1403o.a();
        this.f1391c.c();
    }

    public final void m2214b() {
        bl.a a = this.f1405q.a("on_resume");
        this.f1391c.a();
        this.f1396h.b();
        this.f1405q.a(a);
    }

    public final void m2218c() {
        this.f1396h.c();
        this.f1391c.b();
    }

    public final void m2220d() {
        this.f1391c.w();
    }

    public final void m2215b(Bundle bundle) {
        i.a(bundle, "MapOptions", this.f1404p);
        i.a(bundle, "camera", this.f1390b.c());
    }

    public final CameraPosition m2222e() {
        this.f1401m.b();
        return this.f1390b.c();
    }

    public final float m2224f() {
        this.f1401m.b();
        return this.f1390b.a(this.f1390b.c().a);
    }

    public final float m2226g() {
        this.f1401m.b();
        return this.f1390b.d();
    }

    public final void m2194a(com.google.android.m4b.maps.bv.b bVar) {
        this.f1401m.b();
        this.f1403o.b(bu.a.as);
        this.f1390b.a((bh.a) com.google.android.m4b.maps.bv.d.a(bVar), 0, null, this.f1403o);
    }

    public final void m2216b(com.google.android.m4b.maps.bv.b bVar) {
        this.f1401m.b();
        this.f1403o.b(bu.a.ap);
        this.f1390b.a((bh.a) com.google.android.m4b.maps.bv.d.a(bVar), -1, null, this.f1403o);
    }

    public final void m2196a(com.google.android.m4b.maps.bv.b bVar, o oVar) {
        this.f1401m.b();
        this.f1403o.b(bu.a.aq);
        this.f1390b.a((bh.a) com.google.android.m4b.maps.bv.d.a(bVar), -1, oVar, this.f1403o);
    }

    public final void m2195a(com.google.android.m4b.maps.bv.b bVar, int i, o oVar) {
        this.f1401m.b();
        this.f1403o.b(bu.a.ar);
        bh.a aVar = (bh.a) com.google.android.m4b.maps.bv.d.a(bVar);
        C1650g.m3086a(i > 0, (Object) "durationMs must be positive");
        this.f1390b.a(aVar, i, oVar, this.f1403o);
    }

    public final void m2228h() {
        this.f1401m.b();
        this.f1403o.b(bu.a.at);
        this.f1390b.a();
    }

    public final void m2209a(w wVar) {
        this.f1401m.b();
        this.f1403o.b(bu.a.aS);
        this.f1390b.a(wVar);
    }

    public final void m2197a(aa aaVar) {
        this.f1401m.b();
        this.f1403o.b(bu.a.aU);
        this.f1391c.a(aaVar);
    }

    public final void m2199a(ac acVar) {
        this.f1401m.b();
        this.f1403o.b(bu.a.aV);
        this.f1391c.a(acVar);
    }

    public final j m2188a(PolylineOptions polylineOptions) {
        this.f1401m.b();
        this.f1403o.b(bu.a.w);
        af afVar = new af(polylineOptions, this.f1394f, this.f1403o);
        afVar.a(this.f1395g.a(afVar, false));
        this.f1394f.a(afVar);
        return afVar;
    }

    public final com.google.android.m4b.maps.model.a.i m2187a(PolygonOptions polygonOptions) {
        this.f1401m.b();
        this.f1403o.b(bu.a.E);
        ae aeVar = new ae(polygonOptions, this.f1394f, this.f1403o);
        aeVar.a(this.f1395g.a(aeVar, true));
        this.f1394f.a(aeVar);
        return aeVar;
    }

    public final com.google.android.m4b.maps.model.a.b m2183a(CircleOptions circleOptions) {
        this.f1401m.b();
        this.f1403o.b(bu.a.O);
        bj bjVar = new bj(circleOptions, this.f1394f, this.f1403o);
        bjVar.a(this.f1395g.a(bjVar, true));
        this.f1394f.a(bjVar);
        return bjVar;
    }

    public final com.google.android.m4b.maps.model.a.h m2186a(MarkerOptions markerOptions) {
        this.f1401m.b();
        this.f1403o.b(bu.a.b);
        return this.f1393e.a(markerOptions);
    }

    public final void m2201a(ae aeVar) {
        this.f1401m.b();
        this.f1403o.b(bu.a.aW);
        this.f1393e.a(aeVar);
    }

    public final void m2202a(af afVar) {
        this.f1401m.b();
        this.f1403o.b(bu.a.aX);
        this.f1393e.a(afVar);
    }

    public final void m2211a(y yVar) {
        this.f1401m.b();
        this.f1403o.b(bu.a.aR);
        this.f1393e.a(yVar);
    }

    public final void m2198a(ab abVar) {
        this.f1401m.b();
        this.f1403o.b(bu.a.aY);
        this.f1400l.a(abVar);
    }

    public final void m2206a(r rVar) {
        this.f1401m.b();
        this.f1403o.b(bu.a.q);
        this.f1393e.a(rVar);
    }

    public final c m2184a(GroundOverlayOptions groundOverlayOptions) {
        this.f1401m.b();
        this.f1403o.b(bu.a.X);
        bp bpVar = new bp(groundOverlayOptions, this.f1394f, this.f1392d, this.f1403o);
        bpVar.a(this.f1395g.a(bpVar));
        this.f1394f.a(bpVar);
        return bpVar;
    }

    public final k m2189a(TileOverlayOptions tileOverlayOptions) {
        this.f1401m.b();
        this.f1403o.b(bu.a.ag);
        aw awVar = new aw(tileOverlayOptions, this.f1394f, this.f1403o);
        awVar.a(this.f1395g.a(awVar));
        this.f1394f.a(awVar);
        return awVar;
    }

    public final g m2185a(MapsEngineLayerOptions mapsEngineLayerOptions) {
        this.f1401m.b();
        this.f1403o.b(bu.a.ag);
        u a = u.a(mapsEngineLayerOptions, this, this.f1407s, com.google.android.m4b.maps.ag.h.a(), this.f1394f, this.f1403o);
        a.a(this.f1395g.a(a));
        this.f1394f.a(a);
        return a;
    }

    public final void m2200a(ad adVar) {
        this.f1401m.b();
        this.f1403o.b(bu.a.ao);
        this.f1395g.a(adVar);
    }

    public final void m2208a(v vVar) {
        this.f1401m.b();
        this.f1403o.b(bu.a.bW);
        this.f1389E = vVar;
    }

    public final String m2230i() {
        if (this.f1389E != null) {
            return this.f1389E.i();
        }
        return null;
    }

    public final void m2212a(String str) {
        if (this.f1389E != null) {
            this.f1389E.a(str);
        }
    }

    public final void m2210a(x xVar) {
        this.f1401m.b();
        this.f1403o.b(bu.a.aT);
        this.f1406r.a(xVar);
    }

    public final void m2192a(int i, int i2, int i3, int i4) {
        if (i < 0) {
            i = 0;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i4 < 0) {
            i4 = 0;
        }
        this.f1411w = i;
        this.f1412x = i2;
        this.f1413y = i3;
        this.f1414z = i4;
        this.f1401m.b();
        this.f1403o.b(bu.a.bV);
        this.f1390b.a(i, i2, i3, i4);
        this.f1391c.setPadding(i, i2, i3, i4);
        this.f1399k.a(i, i2, i3, i4);
        this.f1398j.a(i, i2, i3, i4);
    }

    public final boolean m2233j() {
        this.f1401m.b();
        return this.f1391c.o();
    }

    public final void m2213a(boolean z) {
        this.f1401m.b();
        this.f1403o.b(z ? bu.a.aI : bu.a.aH);
        this.f1391c.a(z);
    }

    public final boolean m2235k() {
        this.f1401m.b();
        return this.f1391c.p();
    }

    public final boolean m2217b(boolean z) {
        this.f1401m.b();
        this.f1403o.b(z ? bu.a.bw : bu.a.bx);
        return m2171n(z);
    }

    private boolean m2171n(boolean z) {
        boolean b = this.f1391c.b(z);
        if (b) {
            if (this.f1388D) {
                this.f1399k.d().a(0);
            }
            this.f1399k.d().a(this.f1406r);
        } else {
            this.f1399k.d().a(null);
            this.f1399k.d().a(8);
        }
        return b;
    }

    public final void m2219c(boolean z) {
        this.f1401m.b();
        this.f1403o.b(z ? bu.a.by : bu.a.bz);
        if (this.f1391c.p()) {
            if (z) {
                this.f1399k.d().a(0);
            } else {
                this.f1399k.d().a(8);
            }
        }
        this.f1388D = z;
    }

    public final boolean m2237l() {
        this.f1401m.b();
        return this.f1388D;
    }

    public final boolean m2239m() {
        this.f1401m.b();
        return this.f1391c.q();
    }

    public final void m2221d(boolean z) {
        this.f1401m.b();
        this.f1403o.b(z ? bu.a.aM : bu.a.aL);
        m2172o(z);
    }

    private void m2172o(boolean z) {
        this.f1391c.c(z);
    }

    public final boolean m2240n() {
        this.f1401m.b();
        return this.f1397i.m2263c();
    }

    public final void m2223e(boolean z) {
        this.f1401m.b();
        if (z) {
            this.f1403o.b(bu.a.aK);
            this.f1397i.m2256a();
            return;
        }
        this.f1403o.b(bu.a.aJ);
        this.f1397i.m2262b();
    }

    @Deprecated
    public final Location m2241o() {
        this.f1401m.b();
        return this.f1397i.m2265e();
    }

    public final void m2207a(s sVar) {
        if (sVar != null) {
            this.f1403o.b(bu.a.aO);
        } else {
            this.f1403o.b(bu.a.aN);
        }
        this.f1401m.b();
        this.f1397i.m2260a(sVar);
    }

    @Deprecated
    public final void m2204a(ah ahVar) {
        this.f1401m.b();
        this.f1403o.b(bu.a.aP);
        this.f1397i.m2259a(ahVar);
    }

    public final void m2203a(ag agVar) {
        this.f1401m.b();
        this.f1403o.b(bu.a.aQ);
        this.f1397i.m2258a(agVar);
    }

    public final int m2242p() {
        this.f1401m.b();
        return this.f1409u;
    }

    public final void m2191a(int i) {
        boolean z;
        boolean z2 = true;
        this.f1401m.b();
        this.f1403o.b(bu.a.aG);
        switch (i) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                z = false;
                break;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                z = true;
                break;
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                z = false;
                break;
            case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                z = true;
                break;
            default:
                z = false;
                break;
        }
        this.f1391c.a(i);
        k kVar = this.f1391c;
        if (i == 0) {
            z2 = false;
        }
        kVar.j(z2);
        this.f1398j.a(z);
        this.f1409u = i;
    }

    public final void m2243q() {
        this.f1401m.b();
        this.f1403o.b(bu.a.aF);
        this.f1393e.a();
        this.f1394f.a();
    }

    public final com.google.android.m4b.maps.by.c m2244r() {
        this.f1401m.b();
        return new ag(this.f1403o, this.f1391c.a(this.f1411w, this.f1412x, this.f1413y, this.f1414z));
    }

    public final h m2245s() {
        this.f1401m.b();
        if (this.f1410v == null) {
            this.f1410v = new 4(this);
        }
        return this.f1410v;
    }

    public final void m2225f(boolean z) {
        this.f1401m.b();
        this.f1403o.b(z ? bu.a.bf : bu.a.bc);
        m2173p(z);
    }

    private void m2173p(boolean z) {
        if (this.f1387C != z) {
            this.f1387C = z;
            ba b = this.f1399k.b();
            if (z) {
                this.f1386B = new a(this.f1390b, b);
                this.f1386B.a(m2222e());
                this.f1390b.b(this.f1386B);
                b.a(this.f1385A);
            } else {
                b.a(null);
                this.f1390b.c(this.f1386B);
                this.f1386B = null;
            }
            b.a(z);
        }
    }

    public final void m2227g(boolean z) {
        this.f1401m.b();
        this.f1403o.b(z ? bu.a.bd : bu.a.ba);
        m2174q(z);
    }

    private void m2174q(boolean z) {
        this.f1391c.d(z);
    }

    public final void m2229h(boolean z) {
        this.f1401m.b();
        this.f1403o.b(z ? bu.a.be : bu.a.bb);
        m2175r(z);
    }

    private void m2175r(boolean z) {
        this.f1397i.m2261a(z);
    }

    public final void m2231i(boolean z) {
        this.f1401m.b();
        this.f1403o.b(z ? bu.a.bj : bu.a.bk);
        m2176s(z);
    }

    private void m2176s(boolean z) {
        this.f1391c.f(z);
    }

    public final void m2232j(boolean z) {
        this.f1401m.b();
        this.f1403o.b(z ? bu.a.bl : bu.a.bm);
        m2177t(z);
    }

    private void m2177t(boolean z) {
        this.f1391c.g(z);
    }

    public final void m2234k(boolean z) {
        this.f1401m.b();
        this.f1403o.b(z ? bu.a.bp : bu.a.bq);
        m2178u(z);
    }

    private void m2178u(boolean z) {
        this.f1391c.h(z);
    }

    public final void m2236l(boolean z) {
        this.f1401m.b();
        this.f1403o.b(z ? bu.a.bn : bu.a.bo);
        m2179v(z);
    }

    private void m2179v(boolean z) {
        this.f1391c.i(z);
    }

    public final void m2238m(boolean z) {
        this.f1401m.b();
        this.f1403o.b(z ? bu.a.br : bu.a.bs);
        m2176s(z);
        m2177t(z);
        m2178u(z);
        m2179v(z);
    }

    public final boolean m2246t() {
        return this.f1387C;
    }

    public final boolean m2247u() {
        return this.f1391c.r();
    }

    public final boolean m2248v() {
        return this.f1397i.m2264d();
    }

    public final boolean m2249w() {
        return this.f1391c.z();
    }

    public final boolean m2250x() {
        return this.f1391c.A();
    }

    public final boolean m2251y() {
        return this.f1391c.B();
    }

    public final boolean m2252z() {
        return this.f1391c.C();
    }

    public final void m2205a(com.google.android.m4b.maps.by.d dVar, com.google.android.m4b.maps.bv.b bVar) {
        C1650g.m3081a((Object) dVar, (Object) "Callback method is null.");
        Bitmap bitmap = (Bitmap) (bVar != null ? com.google.android.m4b.maps.bv.d.a(bVar) : null);
        this.f1403o.b(bitmap == null ? bu.a.bF : bu.a.bG);
        new Thread(new 5(this, bitmap, dVar)).start();
    }

    public final View m2180A() {
        this.f1401m.b();
        return this.f1402n;
    }

    public final boolean m2181B() {
        return m2168a(this.f1404p);
    }

    private static boolean m2168a(GoogleMapOptions googleMapOptions) {
        if (googleMapOptions.k() != null) {
            return googleMapOptions.k().booleanValue();
        }
        return false;
    }
}
