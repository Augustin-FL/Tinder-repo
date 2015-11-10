package com.google.android.m4b.maps.p011o;

import android.os.Handler;
import android.os.Looper;
import com.google.android.m4b.maps.ag.g;
import com.google.android.m4b.maps.ag.h;
import com.google.android.m4b.maps.ag.i;
import com.google.android.m4b.maps.ag.j;
import com.google.android.m4b.maps.ay.ac;
import com.google.android.m4b.maps.ay.af;
import com.google.android.m4b.maps.ay.al;
import com.google.android.m4b.maps.ay.bd.C1421a;
import com.google.android.m4b.maps.ay.br;
import com.google.android.m4b.maps.bo.f;
import com.google.android.m4b.maps.ch.a;
import com.google.android.m4b.maps.ch.c;
import com.google.common.base.C1659k;
import com.google.common.collect.C1872p;
import com.google.common.p023b.C1617a;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/* renamed from: com.google.android.m4b.maps.o.k */
public final class C1509k implements i {
    private static final a f1529a;
    private final Collection<j> f1530b;
    private final ScheduledExecutorService f1531c;
    private final h f1532d;
    private final Handler f1533e;

    /* renamed from: com.google.android.m4b.maps.o.k.1 */
    class C15071 implements Runnable {
        private /* synthetic */ g f1523a;
        private /* synthetic */ C1509k f1524b;

        C15071(C1509k c1509k, g gVar) {
            this.f1524b = c1509k;
            this.f1523a = gVar;
        }

        public final void run() {
            for (j a : this.f1524b.m2465b()) {
                a.a(this.f1523a);
            }
        }
    }

    /* renamed from: com.google.android.m4b.maps.o.k.a */
    class C1508a implements Runnable {
        private g f1525a;
        private a f1526b;
        private int f1527c;
        private /* synthetic */ C1509k f1528d;

        public C1508a(C1509k c1509k, g gVar) {
            this.f1528d = c1509k;
            this.f1527c = 0;
            this.f1525a = gVar;
            this.f1526b = C1509k.m2467d(gVar);
        }

        public final void run() {
            a aVar = new a(f.f);
            for (int i = 0; i < this.f1526b.j(9); i++) {
                a c = this.f1526b.c(9, i);
                try {
                    af afVar = new af();
                    afVar.m1470a(C1421a.MAPS_ENGINE.m1763a(c));
                    a a = al.m1576a(c.e(30));
                    a b = ((br) new ac(a.d(4) - 1, a.d(2), a.d(3), afVar).m1446a(C1421a.MAPS_ENGINE)).m1879b();
                    HttpResponse execute = new DefaultHttpClient().execute(new HttpGet(String.format("https://mapsengine.google.com/%s/maptile/maps?v=%s&authToken=%s&x=%d&y=%d&z=%d&s=", new Object[]{b.g(1), C1659k.m3118a(C1508a.m2457a(b, "v")), C1659k.m3118a(C1508a.m2457a(b, "authToken")), Integer.valueOf(r5.m1450c()), Integer.valueOf(r5.m1451d()), Integer.valueOf(r5.m1449b())})));
                    if (execute.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                        byte[] a2 = C1617a.m2978a(execute.getEntity().getContent());
                        a = new a(f.e);
                        a.a(1, c);
                        a.a(2, a2);
                        aVar.a(9, a);
                    } else {
                        C1508a.m2458a(aVar, c);
                    }
                } catch (IOException e) {
                    r4 = (long) (200.0d * Math.pow(2.0d, (double) this.f1527c));
                    long pow;
                    if (pow < 60000) {
                        this.f1528d.f1531c.schedule(this, pow, TimeUnit.MILLISECONDS);
                        this.f1527c++;
                        return;
                    }
                    C1508a.m2458a(aVar, c);
                }
            }
            aVar.a(1, C1509k.f1529a);
            try {
                this.f1525a.a(c.b(aVar));
            } catch (IOException e2) {
                this.f1528d.m2463b(this.f1525a);
            }
            this.f1528d.f1533e.post(new C15071(this.f1528d, this.f1525a));
        }

        private static void m2458a(a aVar, a aVar2) {
            a aVar3 = new a(f.e);
            aVar3.a(1, aVar2);
            aVar.a(9, aVar3);
        }

        private static String m2457a(a aVar, String str) {
            int j = aVar.j(2);
            for (int i = 0; i < j; i++) {
                a c = aVar.c(2, i);
                if (c.g(1) == str) {
                    return c.g(2);
                }
            }
            return null;
        }
    }

    static {
        a aVar = new a(f.d);
        f1529a = aVar;
        aVar.a(1, 0);
        f1529a.a(2, 0);
    }

    public C1509k(h hVar, ScheduledExecutorService scheduledExecutorService) {
        this.f1530b = C1872p.m4309a();
        this.f1532d = (h) com.google.android.m4b.maps.bt.i.a(hVar);
        this.f1531c = (ScheduledExecutorService) com.google.android.m4b.maps.bt.i.a(scheduledExecutorService);
        this.f1533e = new Handler(Looper.getMainLooper());
    }

    private synchronized j[] m2465b() {
        j[] jVarArr;
        jVarArr = new j[this.f1530b.size()];
        this.f1530b.toArray(jVarArr);
        return jVarArr;
    }

    private void m2463b(g gVar) {
        for (j b : m2465b()) {
            b.b(gVar);
        }
    }

    public final void m2471c(g gVar) {
        Object obj = 1;
        if (gVar.i() != 108) {
            m2463b(gVar);
            return;
        }
        try {
            String g = C1509k.m2467d(gVar).c(9, 0).f(29).g(1);
            if (g == null || !(g.startsWith("ft:cw:") || g.startsWith("vdb:"))) {
                obj = null;
            }
            if (obj != null) {
                this.f1532d.c(gVar);
            } else {
                this.f1531c.execute(new C1508a(this, gVar));
            }
        } catch (IOException e) {
            m2463b(gVar);
        }
    }

    private static a m2467d(g gVar) {
        com.google.android.m4b.maps.ag.c cVar = new com.google.android.m4b.maps.ag.c();
        gVar.a(cVar);
        return c.a(f.c, new DataInputStream(new ByteArrayInputStream(cVar.a())));
    }

    public final void m2470a(j jVar) {
        this.f1530b.add(jVar);
        this.f1532d.a(jVar);
    }

    public final void m2468a(int i, byte[] bArr, boolean z, boolean z2) {
        this.f1532d.a(i, bArr, z, z2);
    }

    public final void m2469a(int i, byte[] bArr, boolean z, boolean z2, boolean z3) {
        this.f1532d.a(i, bArr, z, z2, z3);
    }

    public final String m2474m() {
        return this.f1532d.m();
    }

    public final long m2473l() {
        return this.f1532d.l();
    }

    public final void m2472j() {
        this.f1532d.j();
    }
}
