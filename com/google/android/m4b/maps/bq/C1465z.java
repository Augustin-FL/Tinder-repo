package com.google.android.m4b.maps.bq;

import android.content.Context;
import android.content.res.Resources;
import android.location.Location;
import android.os.RemoteException;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.m4b.maps.ag.h;
import com.google.android.m4b.maps.bq.z.1;
import com.google.android.m4b.maps.bv.b;
import com.google.android.m4b.maps.bv.d;
import com.google.android.m4b.maps.by.ag;
import com.google.android.m4b.maps.by.ah;
import com.google.android.m4b.maps.by.s;
import com.google.android.m4b.maps.by.z.a;
import com.google.android.m4b.maps.model.CameraPosition;
import com.google.android.m4b.maps.model.LatLng;
import com.google.android.m4b.maps.model.LatLngBounds;
import com.google.android.m4b.maps.model.RuntimeRemoteException;
import com.google.common.base.C1650g;

/* renamed from: com.google.android.m4b.maps.bq.z */
public final class C1465z extends a implements OnClickListener {
    private final bh f1415a;
    private final s f1416b;
    private final y f1417c;
    private final Context f1418d;
    private final Resources f1419e;
    private final C1465z.a f1420f;
    private Location f1421g;
    private s f1422h;
    private final bu f1423i;
    private boolean f1424j;
    private boolean f1425k;
    private ah f1426l;
    private ag f1427m;

    public C1465z(Context context, Resources resources, bh bhVar, y yVar, C1465z.a aVar, s sVar, bu buVar) {
        this.f1418d = (Context) C1650g.m3080a((Object) context);
        this.f1415a = (bh) C1650g.m3080a((Object) bhVar);
        this.f1417c = (y) C1650g.m3080a((Object) yVar);
        this.f1420f = (C1465z.a) C1650g.m3080a((Object) aVar);
        this.f1416b = (s) C1650g.m3080a((Object) sVar);
        this.f1422h = (s) C1650g.m3080a((Object) sVar);
        this.f1423i = (bu) C1650g.m3080a((Object) buVar);
        this.f1419e = (Resources) C1650g.m3080a((Object) resources);
        this.f1425k = true;
    }

    public final void m2256a() {
        if (!this.f1424j) {
            this.f1424j = true;
            this.f1420f.a();
            try {
                this.f1422h.a(this);
                m2255f();
                if (this.f1421g != null) {
                    m2257a(d.a(this.f1421g));
                }
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
    }

    public final void m2262b() {
        if (this.f1424j) {
            this.f1424j = false;
            m2255f();
            try {
                this.f1422h.d();
                this.f1420f.b();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
    }

    public final boolean m2263c() {
        return this.f1424j;
    }

    public final void m2261a(boolean z) {
        if (this.f1425k != z) {
            this.f1425k = z;
            m2255f();
        }
    }

    private void m2255f() {
        OnClickListener onClickListener;
        boolean z = this.f1425k && this.f1424j;
        this.f1417c.a(z);
        y yVar = this.f1417c;
        if (!z) {
            onClickListener = null;
        }
        yVar.a(onClickListener);
    }

    public final boolean m2264d() {
        return this.f1425k;
    }

    public final void m2257a(b bVar) {
        Location location = (Location) d.a(bVar);
        this.f1420f.a(location);
        if (this.f1426l != null) {
            try {
                this.f1426l.a(d.a(new Location(location)));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f1421g = location;
    }

    @Deprecated
    public final Location m2265e() {
        C1650g.m3092b(this.f1424j, (Object) "MyLocation layer not enabled");
        return this.f1421g;
    }

    public final void m2260a(s sVar) {
        if (this.f1424j) {
            try {
                this.f1422h.d();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        if (sVar == null) {
            sVar = this.f1416b;
        }
        this.f1422h = sVar;
        if (this.f1424j) {
            try {
                this.f1422h.a(this);
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }
    }

    @Deprecated
    public final void m2259a(ah ahVar) {
        this.f1426l = ahVar;
    }

    public final void m2258a(ag agVar) {
        this.f1427m = agVar;
    }

    public final void onClick(View view) {
        this.f1423i.a(bu.a.bg);
        if (this.f1427m != null) {
            try {
                if (this.f1427m.a()) {
                    return;
                }
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        C1650g.m3092b(this.f1424j, (Object) "MyLocation layer not enabled");
        if (this.f1421g != null) {
            LatLng latLng = new LatLng(this.f1421g.getLatitude(), this.f1421g.getLongitude());
            this.f1415a.a(CameraPosition.a(this.f1415a.c()).a(latLng).a(m2253a(latLng, this.f1421g.getAccuracy())).a(), -1);
        }
        if (ac.a(this.f1418d) && this.f1421g != null) {
            latLng = new LatLng(this.f1421g.getLatitude(), this.f1421g.getLongitude());
            aj ajVar = new aj(latLng, m2253a(latLng, this.f1421g.getAccuracy()));
            ajVar.a(new 1(this, view));
            h.a().c(ajVar);
        }
    }

    private float m2253a(LatLng latLng, float f) {
        float f2 = this.f1415a.c().b;
        if (f2 <= 10.0f) {
            f2 = 15.0f;
        }
        bh bhVar = this.f1415a;
        double d = (double) f;
        double a = bn.a(d);
        d = bn.a(latLng, d);
        float f3 = bhVar.a(new LatLngBounds(new LatLng(latLng.a - a, latLng.b - d), new LatLng(latLng.a + a, latLng.b + d))).b;
        return f3 == GroundOverlayOptions.NO_DIMENSION ? f2 : Math.min(f2, f3);
    }
}
