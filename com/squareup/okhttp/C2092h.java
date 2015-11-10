package com.squareup.okhttp;

import com.squareup.okhttp.internal.C2151i;
import com.squareup.okhttp.internal.C2157k;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.squareup.okhttp.h */
public final class C2092h {
    private static final C2092h f3125a;
    private final int f3126b;
    private final long f3127c;
    private final LinkedList<C2090g> f3128d;
    private Executor f3129e;
    private final Runnable f3130f;

    /* renamed from: com.squareup.okhttp.h.1 */
    class C20911 implements Runnable {
        final /* synthetic */ C2092h f3124a;

        C20911(C2092h c2092h) {
            this.f3124a = c2092h;
        }

        public void run() {
            this.f3124a.m4980c();
        }
    }

    static {
        String property = System.getProperty("http.keepAlive");
        String property2 = System.getProperty("http.keepAliveDuration");
        String property3 = System.getProperty("http.maxConnections");
        long parseLong = property2 != null ? Long.parseLong(property2) : 300000;
        if (property != null && !Boolean.parseBoolean(property)) {
            f3125a = new C2092h(0, parseLong);
        } else if (property3 != null) {
            f3125a = new C2092h(Integer.parseInt(property3), parseLong);
        } else {
            f3125a = new C2092h(5, parseLong);
        }
    }

    public C2092h(int i, long j) {
        this.f3128d = new LinkedList();
        this.f3129e = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), C2157k.m5352a("OkHttp ConnectionPool", true));
        this.f3130f = new C20911(this);
        this.f3126b = i;
        this.f3127c = (j * 1000) * 1000;
    }

    public static C2092h m4978a() {
        return f3125a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.squareup.okhttp.C2090g m4982a(com.squareup.okhttp.C2067a r9) {
        /*
        r8 = this;
        monitor-enter(r8);
        r2 = 0;
        r0 = r8.f3128d;	 Catch:{ all -> 0x0083 }
        r1 = r8.f3128d;	 Catch:{ all -> 0x0083 }
        r1 = r1.size();	 Catch:{ all -> 0x0083 }
        r3 = r0.listIterator(r1);	 Catch:{ all -> 0x0083 }
    L_0x000e:
        r0 = r3.hasPrevious();	 Catch:{ all -> 0x0083 }
        if (r0 == 0) goto L_0x0086;
    L_0x0014:
        r0 = r3.previous();	 Catch:{ all -> 0x0083 }
        r0 = (com.squareup.okhttp.C2090g) r0;	 Catch:{ all -> 0x0083 }
        r1 = r0.m4966c();	 Catch:{ all -> 0x0083 }
        r1 = r1.m5875a();	 Catch:{ all -> 0x0083 }
        r1 = r1.equals(r9);	 Catch:{ all -> 0x0083 }
        if (r1 == 0) goto L_0x000e;
    L_0x0028:
        r1 = r0.m4968e();	 Catch:{ all -> 0x0083 }
        if (r1 == 0) goto L_0x000e;
    L_0x002e:
        r4 = java.lang.System.nanoTime();	 Catch:{ all -> 0x0083 }
        r6 = r0.m4972i();	 Catch:{ all -> 0x0083 }
        r4 = r4 - r6;
        r6 = r8.f3127c;	 Catch:{ all -> 0x0083 }
        r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r1 >= 0) goto L_0x000e;
    L_0x003d:
        r3.remove();	 Catch:{ all -> 0x0083 }
        r1 = r0.m4974k();	 Catch:{ all -> 0x0083 }
        if (r1 != 0) goto L_0x0051;
    L_0x0046:
        r1 = com.squareup.okhttp.internal.C2151i.m5320a();	 Catch:{ SocketException -> 0x0060 }
        r4 = r0.m4967d();	 Catch:{ SocketException -> 0x0060 }
        r1.m5324a(r4);	 Catch:{ SocketException -> 0x0060 }
    L_0x0051:
        if (r0 == 0) goto L_0x005e;
    L_0x0053:
        r1 = r0.m4974k();	 Catch:{ all -> 0x0083 }
        if (r1 == 0) goto L_0x005e;
    L_0x0059:
        r1 = r8.f3128d;	 Catch:{ all -> 0x0083 }
        r1.addFirst(r0);	 Catch:{ all -> 0x0083 }
    L_0x005e:
        monitor-exit(r8);
        return r0;
    L_0x0060:
        r1 = move-exception;
        r0 = r0.m4967d();	 Catch:{ all -> 0x0083 }
        com.squareup.okhttp.internal.C2157k.m5357a(r0);	 Catch:{ all -> 0x0083 }
        r0 = com.squareup.okhttp.internal.C2151i.m5320a();	 Catch:{ all -> 0x0083 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0083 }
        r4.<init>();	 Catch:{ all -> 0x0083 }
        r5 = "Unable to tagSocket(): ";
        r4 = r4.append(r5);	 Catch:{ all -> 0x0083 }
        r1 = r4.append(r1);	 Catch:{ all -> 0x0083 }
        r1 = r1.toString();	 Catch:{ all -> 0x0083 }
        r0.m5323a(r1);	 Catch:{ all -> 0x0083 }
        goto L_0x000e;
    L_0x0083:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
    L_0x0086:
        r0 = r2;
        goto L_0x0051;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.h.a(com.squareup.okhttp.a):com.squareup.okhttp.g");
    }

    void m4983a(C2090g c2090g) {
        if (c2090g.m4974k() || !c2090g.m4963a()) {
            return;
        }
        if (c2090g.m4968e()) {
            try {
                C2151i.m5320a().m5330b(c2090g.m4967d());
                synchronized (this) {
                    m4981c(c2090g);
                    c2090g.m4976m();
                    c2090g.m4970g();
                }
                return;
            } catch (SocketException e) {
                C2151i.m5320a().m5323a("Unable to untagSocket(): " + e);
                C2157k.m5357a(c2090g.m4967d());
                return;
            }
        }
        C2157k.m5357a(c2090g.m4967d());
    }

    private void m4981c(C2090g c2090g) {
        boolean isEmpty = this.f3128d.isEmpty();
        this.f3128d.addFirst(c2090g);
        if (isEmpty) {
            this.f3129e.execute(this.f3130f);
        } else {
            notifyAll();
        }
    }

    void m4984b(C2090g c2090g) {
        if (!c2090g.m4974k()) {
            throw new IllegalArgumentException();
        } else if (c2090g.m4968e()) {
            synchronized (this) {
                m4981c(c2090g);
            }
        }
    }

    private void m4980c() {
        do {
        } while (m4985b());
    }

    boolean m4985b() {
        synchronized (this) {
            if (this.f3128d.isEmpty()) {
                return false;
            }
            int i;
            long j;
            List arrayList = new ArrayList();
            int i2 = 0;
            long nanoTime = System.nanoTime();
            long j2 = this.f3127c;
            ListIterator listIterator = this.f3128d.listIterator(this.f3128d.size());
            while (listIterator.hasPrevious()) {
                C2090g c2090g = (C2090g) listIterator.previous();
                long i3 = (c2090g.m4972i() + this.f3127c) - nanoTime;
                long j3;
                if (i3 <= 0 || !c2090g.m4968e()) {
                    listIterator.remove();
                    arrayList.add(c2090g);
                    j3 = j2;
                    i = i2;
                    j = j3;
                } else if (c2090g.m4971h()) {
                    int i4 = i2 + 1;
                    j = Math.min(j2, i3);
                    i = i4;
                } else {
                    j3 = j2;
                    i = i2;
                    j = j3;
                }
                i2 = i;
                j2 = j;
            }
            ListIterator listIterator2 = this.f3128d.listIterator(this.f3128d.size());
            while (listIterator2.hasPrevious() && i2 > this.f3126b) {
                int i5;
                c2090g = (C2090g) listIterator2.previous();
                if (c2090g.m4971h()) {
                    arrayList.add(c2090g);
                    listIterator2.remove();
                    i5 = i2 - 1;
                } else {
                    i5 = i2;
                }
                i2 = i5;
            }
            if (arrayList.isEmpty()) {
                try {
                    j = j2 / 1000000;
                    wait(j, (int) (j2 - (1000000 * j)));
                    return true;
                } catch (InterruptedException e) {
                }
            }
            i = arrayList.size();
            for (i2 = 0; i2 < i; i2++) {
                C2157k.m5357a(((C2090g) arrayList.get(i2)).m4967d());
            }
            return true;
        }
    }
}
