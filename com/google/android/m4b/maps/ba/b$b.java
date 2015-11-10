package com.google.android.m4b.maps.ba;

import android.os.Process;
import com.google.android.m4b.maps.ae.c;
import com.google.android.m4b.maps.ah.C1327d;
import com.google.android.m4b.maps.bg.b;
import com.google.android.m4b.maps.bh.p;

class b$b extends b {
    private volatile boolean f1369a;
    private volatile boolean f1370b;
    private /* synthetic */ b f1371c;

    b$b(b bVar) {
        this.c = bVar;
        super("CacheCommitter:" + bVar.getName());
        if (b.d(bVar) < 0) {
            this.b = true;
        } else {
            start();
        }
    }

    public final void m2159f() {
        try {
            Process.setThreadPriority(p.d() + 1);
        } catch (SecurityException e) {
            C1327d.m1084a(getName(), "Could not set thread priority: " + e);
        }
        c b = this.c.a.b();
        if (b != null) {
            if (this.a || !b.e(this.c)) {
                do {
                    this.a = false;
                    try {
                        for (int d = b.d(this.c); d > 0; d -= 1000) {
                            sleep(1000);
                            if (b.e(this.c)) {
                                break;
                            }
                        }
                    } catch (InterruptedException e2) {
                        return;
                    }
                } while (this.a);
                b.a(this.c, false);
                b.d_();
            } else {
                b.a(this.c, false);
                b.d_();
            }
            this.b = true;
            b.f(this.c);
        }
    }

    final void m2157a() {
        this.a = true;
    }

    final boolean m2158b() {
        return this.b;
    }
}
