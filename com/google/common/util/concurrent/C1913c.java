package com.google.common.util.concurrent;

import com.google.common.base.C1650g;
import com.google.common.collect.C1872p;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: com.google.common.util.concurrent.c */
public final class C1913c {
    static final Logger f2575a;
    private final Queue<C1912a> f2576b;
    private boolean f2577c;

    /* renamed from: com.google.common.util.concurrent.c.a */
    private static class C1912a {
        final Runnable f2573a;
        final Executor f2574b;

        C1912a(Runnable runnable, Executor executor) {
            this.f2573a = runnable;
            this.f2574b = executor;
        }

        void m4467a() {
            try {
                this.f2574b.execute(this.f2573a);
            } catch (Throwable e) {
                C1913c.f2575a.log(Level.SEVERE, "RuntimeException while executing runnable " + this.f2573a + " with executor " + this.f2574b, e);
            }
        }
    }

    static {
        f2575a = Logger.getLogger(C1913c.class.getName());
    }

    public C1913c() {
        this.f2576b = C1872p.m4318b();
        this.f2577c = false;
    }

    public void m4469a(Runnable runnable, Executor executor) {
        C1650g.m3081a((Object) runnable, (Object) "Runnable was null.");
        C1650g.m3081a((Object) executor, (Object) "Executor was null.");
        Object obj = null;
        synchronized (this.f2576b) {
            if (this.f2577c) {
                obj = 1;
            } else {
                this.f2576b.add(new C1912a(runnable, executor));
            }
        }
        if (obj != null) {
            new C1912a(runnable, executor).m4467a();
        }
    }

    public void m4468a() {
        synchronized (this.f2576b) {
            if (this.f2577c) {
                return;
            }
            this.f2577c = true;
            while (!this.f2576b.isEmpty()) {
                ((C1912a) this.f2576b.poll()).m4467a();
            }
        }
    }
}
