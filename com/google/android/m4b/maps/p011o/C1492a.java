package com.google.android.m4b.maps.p011o;

import android.os.Handler;
import android.os.RemoteException;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.m4b.maps.al.c;
import com.google.android.m4b.maps.ay.C1440g;
import com.google.android.m4b.maps.bh.e;
import com.google.android.m4b.maps.bh.q;
import com.google.android.m4b.maps.bq.bh;
import com.google.android.m4b.maps.bq.bh.a;
import com.google.android.m4b.maps.bq.bu;
import com.google.android.m4b.maps.bq.k;
import com.google.android.m4b.maps.by.o;
import com.google.android.m4b.maps.by.w;
import com.google.android.m4b.maps.model.CameraPosition;
import com.google.android.m4b.maps.model.LatLng;
import com.google.android.m4b.maps.model.LatLngBounds;
import com.google.android.m4b.maps.model.RuntimeRemoteException;
import com.google.common.base.C1650g;
import com.google.common.collect.C1872p;
import java.util.Collection;

/* renamed from: com.google.android.m4b.maps.o.a */
public class C1492a implements e, q.e, bh {
    private static final double f1469b;
    private static /* synthetic */ boolean f1470j;
    private final C1535v f1471c;
    private final k f1472d;
    private final Handler f1473e;
    private o f1474f;
    private w f1475g;
    private Collection<w> f1476h;
    private int f1477i;

    /* renamed from: com.google.android.m4b.maps.o.a.1 */
    class C14911 implements Runnable {
        private /* synthetic */ c f1467a;
        private /* synthetic */ C1492a f1468b;

        C14911(C1492a c1492a, c cVar) {
            this.f1468b = c1492a;
            this.f1467a = cVar;
        }

        public final void run() {
            C1492a.m2328a(this.f1468b, C1493b.m2359a(this.f1468b.f1471c.m2656a(this.f1467a, (float) GroundOverlayOptions.NO_DIMENSION)));
        }
    }

    static {
        boolean z;
        if (C1492a.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        f1470j = z;
        f1469b = 1.0d / Math.log(2.0d);
    }

    static /* synthetic */ void m2328a(C1492a c1492a, CameraPosition cameraPosition) {
        if (c1492a.f1476h != null) {
            for (w a : c1492a.f1476h) {
                try {
                    a.a(cameraPosition);
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
        }
        if (c1492a.f1474f != null) {
            try {
                c1492a.m2331f().a();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }
        if (c1492a.f1475g != null) {
            try {
                c1492a.f1475g.a(cameraPosition);
            } catch (RemoteException e22) {
                throw new RuntimeRemoteException(e22);
            }
        }
    }

    private static int m2325a(int i) {
        if (i == -1) {
            return 330;
        }
        return i < 0 ? 0 : i;
    }

    private static int m2329b(int i) {
        if (i == -1) {
            return -1;
        }
        return i < 0 ? 0 : i;
    }

    public C1492a(k kVar, C1535v c1535v, Handler handler) {
        this.f1472d = kVar;
        this.f1471c = c1535v;
        this.f1473e = handler;
    }

    private void m2330e() {
        e eVar;
        q.e eVar2;
        Object obj = (this.f1474f == null && this.f1475g == null && this.f1476h == null) ? null : 1;
        C1535v c1535v = this.f1471c;
        if (obj != null) {
            eVar = this;
        } else {
            eVar = null;
        }
        c1535v.m2661a(eVar);
        C1535v c1535v2 = this.f1471c;
        if (obj == null) {
            eVar2 = null;
        }
        c1535v2.m2662a(eVar2);
    }

    private o m2331f() {
        o oVar = this.f1474f;
        this.f1474f = null;
        m2330e();
        return oVar;
    }

    public final void m2341a(w wVar) {
        this.f1475g = wVar;
        m2330e();
    }

    public final void m2349b(w wVar) {
        if (this.f1476h == null) {
            this.f1476h = C1872p.m4309a();
        }
        this.f1476h.add(wVar);
        m2330e();
    }

    public final void m2352c(w wVar) {
        this.f1476h.remove(wVar);
        if (this.f1476h.isEmpty()) {
            this.f1476h = null;
        }
        m2330e();
    }

    public final void m2340a(a aVar, int i, o oVar, bu buVar) {
        boolean z = true;
        boolean z2 = i != 0 || oVar == null;
        C1650g.m3086a(z2, (Object) "Callback supplied with instantaneous camera movement");
        if (this.f1477i != 0) {
            z = false;
        }
        C1650g.m3092b(z, (Object) "Camera moved during a cancellation");
        aVar.a(this, i, buVar);
        if (f1470j || this.f1477i == 0) {
            this.f1474f = oVar;
            m2330e();
            return;
        }
        throw new AssertionError();
    }

    public final void m2334a() {
        C1650g.m3092b(this.f1477i == 0, (Object) "Camera stopped during a cancellation");
        this.f1471c.m2657a(0.0f, 0.0f);
    }

    public final void m2339a(c cVar) {
        this.f1473e.post(new C14911(this, cVar));
    }

    public final void m2347b() {
        if (this.f1474f != null) {
            this.f1477i++;
            try {
                m2331f().b();
                this.f1477i--;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            } catch (Throwable th) {
                this.f1477i--;
            }
        }
    }

    public final CameraPosition m2350c() {
        return C1493b.m2359a(this.f1471c.m2665c());
    }

    public final CameraPosition m2333a(LatLngBounds latLngBounds) {
        return C1493b.m2359a(C1492a.m2326a(latLngBounds, (double) (this.f1472d.getWidth() - this.f1471c.m2655a()), (double) (this.f1472d.getHeight() - this.f1471c.m2663b()), (double) this.f1472d.getResources().getDisplayMetrics().density));
    }

    public final void m2336a(float f, int i) {
        this.f1471c.m2653a(f, C1492a.m2325a(i));
    }

    public final void m2348b(float f, int i) {
        this.f1471c.m2664b(Math.min(m2332a(m2350c().a), Math.max(this.f1471c.m2666d(), this.f1471c.m2667e())) + f, C1492a.m2325a(-1));
    }

    public final void m2337a(float f, int i, int i2, int i3) {
        this.f1471c.m2652a(f, (float) i, (float) i2, C1492a.m2325a(i3));
    }

    public final void m2351c(float f, int i) {
        this.f1471c.m2664b(f, C1492a.m2325a(i));
    }

    public final void m2335a(float f, float f2, int i) {
        C1535v c1535v = this.f1471c;
        c a = q.a(this.f1471c.m2665c(), this.f1472d.x(), f, f2);
        int b = C1492a.m2329b(i);
        this.f1471c.m2659a(a, b, b);
    }

    public final void m2342a(CameraPosition cameraPosition, int i) {
        int b = C1492a.m2329b(i);
        this.f1471c.m2659a(new c(C1493b.m2358a(cameraPosition.a), cameraPosition.b, cameraPosition.c, cameraPosition.d, 0.0f), b, b);
    }

    public final void m2344a(LatLng latLng, int i) {
        c c = this.f1471c.m2665c();
        c cVar = new c(C1493b.m2358a(latLng), c.a(), c.d(), c.e(), c.f());
        int b = C1492a.m2329b(i);
        this.f1471c.m2659a(cVar, b, b);
    }

    public final void m2343a(LatLng latLng, float f, int i) {
        c c = this.f1471c.m2665c();
        c cVar = new c(C1493b.m2358a(latLng), f, c.d(), c.e(), c.f());
        int b = C1492a.m2329b(i);
        this.f1471c.m2659a(cVar, b, b);
    }

    public final void m2345a(LatLngBounds latLngBounds, int i, int i2) {
        int width = this.f1472d.getWidth();
        int height = this.f1472d.getHeight();
        boolean z = (width == 0 || height == 0) ? false : true;
        C1650g.m3092b(z, (Object) "Error using newLatLngBounds(LatLngBounds, int): Map size can't be 0. Most likely, layout has not yet occured for the map view.  Either wait until layout has occurred or use newLatLngBounds(LatLngBounds, int, int, int) which allows you to specify the map's dimensions.");
        m2346a(latLngBounds, width, height, i, i2);
    }

    public final void m2346a(LatLngBounds latLngBounds, int i, int i2, int i3, int i4) {
        double d = ((double) i) - ((double) (i3 * 2));
        double d2 = ((double) i2) - ((double) (i3 * 2));
        boolean z = d > 0.0d && d2 > 0.0d;
        C1650g.m3092b(z, (Object) "View size is too small after padding");
        c a = C1492a.m2326a(latLngBounds, d - ((double) this.f1471c.m2655a()), d2 - ((double) this.f1471c.m2663b()), (double) this.f1472d.getResources().getDisplayMetrics().density);
        int b = C1492a.m2329b(i4);
        this.f1471c.m2659a(a, b, b);
    }

    private static c m2326a(LatLngBounds latLngBounds, double d, double d2, double d3) {
        int f;
        double d4 = 256.0d * d3;
        C1440g b = C1493b.m2363b(latLngBounds.b);
        C1440g b2 = C1493b.m2363b(latLngBounds.a);
        if (b.m1958f() < b2.m1958f()) {
            f = (1073741824 - b2.m1958f()) + b.m1958f();
        } else {
            f = b.m1958f() - b2.m1958f();
        }
        int g = b.m1960g() - b2.m1960g();
        d4 = 30.0d - (Math.log(Math.max((((double) f) * d4) / d, (d4 * ((double) g)) / d2)) * f1469b);
        return new c(new C1440g(((f / 2) + b2.m1958f()) % 1073741824, b2.m1960g() + (g / 2)), (float) d4, 0.0f, 0.0f, 0.0f);
    }

    public final float m2332a(LatLng latLng) {
        return this.f1471c.m2654a(C1493b.m2363b(latLng));
    }

    public final float m2353d() {
        return this.f1471c.m2666d();
    }

    public final void m2338a(int i, int i2, int i3, int i4) {
        this.f1471c.m2658a(i, i2, i3, i4);
    }
}
