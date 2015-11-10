package com.google.android.m4b.maps.p011o;

import android.os.Handler;
import android.os.RemoteException;
import com.google.android.m4b.maps.bq.br;
import com.google.android.m4b.maps.bq.bs;
import com.google.android.m4b.maps.bq.bu;
import com.google.android.m4b.maps.bq.bw;
import com.google.android.m4b.maps.bq.bx;
import com.google.android.m4b.maps.by.x;
import com.google.android.m4b.maps.model.RuntimeRemoteException;
import com.google.android.m4b.maps.p009m.C1480a.C1483c;
import com.google.android.m4b.maps.p009m.C1486c;
import com.google.android.m4b.maps.p021z.C1608i;
import com.google.common.base.C1650g;
import com.google.common.collect.Sets;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.google.android.m4b.maps.o.i */
public final class C1505i implements bw {
    private static long f1506a;
    private static final AtomicLong f1507b;
    private final C1608i f1508c;
    private final long f1509d;
    private x f1510e;
    private final Set<bx> f1511f;
    private final bx f1512g;
    private final Handler f1513h;
    private final bu f1514i;

    /* renamed from: com.google.android.m4b.maps.o.i.1 */
    class C15041 implements bx {
        final /* synthetic */ C1505i f1505a;

        /* renamed from: com.google.android.m4b.maps.o.i.1.1 */
        class C15021 implements Runnable {
            private /* synthetic */ C15041 f1502a;

            C15021(C15041 c15041) {
                this.f1502a = c15041;
            }

            public final void run() {
                synchronized (this.f1502a.f1505a) {
                    try {
                        if (this.f1502a.f1505a.f1510e != null) {
                            this.f1502a.f1505a.f1510e.a();
                        }
                        for (bx a : this.f1502a.f1505a.f1511f) {
                            a.a();
                        }
                    } catch (RemoteException e) {
                        throw new RuntimeRemoteException(e);
                    }
                }
            }
        }

        /* renamed from: com.google.android.m4b.maps.o.i.1.2 */
        class C15032 implements Runnable {
            private /* synthetic */ bs f1503a;
            private /* synthetic */ C15041 f1504b;

            C15032(C15041 c15041, bs bsVar) {
                this.f1504b = c15041;
                this.f1503a = bsVar;
            }

            public final void run() {
                synchronized (this.f1504b.f1505a) {
                    try {
                        if (this.f1504b.f1505a.f1510e != null) {
                            this.f1504b.f1505a.f1510e.a(new br(this.f1504b.f1505a, this.f1503a, this.f1504b.f1505a.f1514i));
                        }
                        for (bx a : this.f1504b.f1505a.f1511f) {
                            a.a(this.f1503a);
                        }
                    } catch (RemoteException e) {
                        throw new RuntimeRemoteException(e);
                    }
                }
            }
        }

        C15041(C1505i c1505i) {
            this.f1505a = c1505i;
        }

        public final void m2426a() {
            if (this.f1505a.m2446e()) {
                this.f1505a.f1513h.post(new C15021(this));
            }
        }

        public final void m2427a(bs bsVar) {
            if (this.f1505a.m2446e()) {
                this.f1505a.f1513h.post(new C15032(this, bsVar));
            }
        }
    }

    static {
        f1506a = -1;
        f1507b = new AtomicLong(0);
    }

    public static C1505i m2429a(C1608i c1608i, Handler handler, bu buVar) {
        C1505i c1505i = new C1505i(c1608i, handler, buVar);
        c1505i.f1508c.m2934a(c1505i.f1512g);
        return c1505i;
    }

    private C1505i(C1608i c1608i, Handler handler, bu buVar) {
        this.f1509d = f1507b.getAndIncrement();
        this.f1511f = Sets.m4227a();
        this.f1512g = new C15041(this);
        this.f1508c = (C1608i) C1650g.m3080a((Object) c1608i);
        this.f1513h = (Handler) C1650g.m3080a((Object) handler);
        this.f1514i = (bu) C1650g.m3080a((Object) buVar);
    }

    public final boolean m2438a() {
        if (f1506a != this.f1509d && f1506a != -1) {
            return false;
        }
        f1506a = this.f1509d;
        return true;
    }

    public final void m2440b() {
        if (f1506a == this.f1509d) {
            f1506a = -1;
        }
    }

    public final bs m2442c() {
        if (m2446e()) {
            return this.f1508c.m2945c();
        }
        return null;
    }

    public final int m2433a(bs bsVar) {
        if (!m2446e()) {
            return -1;
        }
        C1486c a = this.f1508c.m2931a(bsVar.a());
        return a != null ? bsVar.b(a) : C1608i.m2925c(bsVar);
    }

    public final int m2439b(bs bsVar) {
        if (!m2446e()) {
            return -1;
        }
        C1608i c1608i = this.f1508c;
        return C1608i.m2925c(bsVar);
    }

    public final boolean m2443c(bs bsVar) {
        if (!m2446e()) {
            return false;
        }
        C1608i c1608i = this.f1508c;
        return C1608i.m2926d(bsVar);
    }

    public final synchronized void m2436a(x xVar) {
        this.f1510e = xVar;
    }

    public final boolean m2445d() {
        if (m2446e()) {
            return this.f1508c.m2948d();
        }
        return false;
    }

    public final boolean m2446e() {
        return this.f1509d == f1506a;
    }

    public final C1608i m2447f() {
        return this.f1508c;
    }

    public final void m2435a(bx bxVar) {
        this.f1511f.add(bxVar);
    }

    public final void m2441b(bx bxVar) {
        this.f1511f.remove(bxVar);
    }

    public final C1486c m2434a(C1483c c1483c) {
        if (m2446e()) {
            return this.f1508c.m2931a(c1483c);
        }
        return null;
    }

    public final void m2444d(bs bsVar) {
        if (m2446e()) {
            this.f1508c.m2933a(bsVar);
        }
    }

    public final void m2437a(C1486c c1486c) {
        if (m2446e()) {
            this.f1508c.m2936a(c1486c);
        }
    }
}
