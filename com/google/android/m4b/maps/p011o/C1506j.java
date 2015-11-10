package com.google.android.m4b.maps.p011o;

import android.os.Handler;
import android.os.RemoteException;
import com.google.android.m4b.maps.bh.h;
import com.google.android.m4b.maps.bq.j;
import com.google.android.m4b.maps.bq.k;
import com.google.android.m4b.maps.by.ab;
import com.google.android.m4b.maps.model.RuntimeRemoteException;
import com.google.common.base.C1650g;
import com.google.common.collect.C1872p;
import java.util.List;

/* renamed from: com.google.android.m4b.maps.o.j */
public final class C1506j extends h implements j, Runnable {
    private final Handler f1515a;
    private ab f1516b;
    private ab f1517c;
    private boolean f1518d;
    private boolean f1519e;
    private boolean f1520f;
    private boolean f1521g;
    private boolean f1522h;

    static {
        j.class.getSimpleName();
    }

    private C1506j(Handler handler) {
        this.f1518d = false;
        this.f1519e = false;
        this.f1520f = false;
        this.f1521g = false;
        this.f1522h = false;
        C1650g.m3081a((Object) handler, (Object) "Handler is null");
        this.f1515a = handler;
    }

    public static C1506j m2448a(k kVar, Handler handler) {
        C1506j c1506j = new C1506j(handler);
        kVar.a(c1506j);
        return c1506j;
    }

    public final void m2451a(ab abVar) {
        synchronized (this) {
            this.f1516b = abVar;
        }
        if (m2449f()) {
            run();
        }
    }

    public final void m2454b(ab abVar) {
        synchronized (this) {
            this.f1517c = abVar;
        }
        if (m2449f()) {
            run();
        }
    }

    private synchronized boolean m2449f() {
        boolean z;
        z = (this.f1518d || this.f1519e || this.f1520f || this.f1521g || !this.f1522h) ? false : true;
        return z;
    }

    public final synchronized void m2450a() {
        this.f1518d = true;
    }

    public final synchronized void m2453b() {
        this.f1518d = false;
        this.f1519e = true;
    }

    public final synchronized void m2455c() {
        this.f1519e = false;
        this.f1520f = true;
    }

    protected final synchronized void m2456d() {
        this.f1520f = false;
        this.f1521g = true;
    }

    protected final synchronized boolean m2452a(boolean z) {
        this.f1521g = false;
        this.f1522h = z;
        if (m2449f() && !(this.f1516b == null && this.f1517c == null)) {
            this.f1515a.post(this);
        }
        return false;
    }

    public final void run() {
        List<ab> a = C1872p.m4309a();
        synchronized (this) {
            if (this.f1516b != null) {
                a.add(this.f1516b);
                this.f1516b = null;
            }
            if (this.f1517c != null) {
                a.add(this.f1517c);
                this.f1517c = null;
            }
        }
        for (ab a2 : a) {
            try {
                a2.a();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
    }
}
