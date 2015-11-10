package com.android.volley;

import android.os.Process;
import com.android.volley.C0290a.C0289a;
import java.util.concurrent.BlockingQueue;

/* renamed from: com.android.volley.b */
public class C0292b extends Thread {
    private static final boolean f221a;
    private final BlockingQueue<Request> f222b;
    private final BlockingQueue<Request> f223c;
    private final C0290a f224d;
    private final C0297j f225e;
    private volatile boolean f226f;

    /* renamed from: com.android.volley.b.1 */
    class C02911 implements Runnable {
        final /* synthetic */ Request f219a;
        final /* synthetic */ C0292b f220b;

        C02911(C0292b c0292b, Request request) {
            this.f220b = c0292b;
            this.f219a = request;
        }

        public void run() {
            try {
                this.f220b.f223c.put(this.f219a);
            } catch (InterruptedException e) {
            }
        }
    }

    static {
        f221a = C0310l.f270b;
    }

    public C0292b(BlockingQueue<Request> blockingQueue, BlockingQueue<Request> blockingQueue2, C0290a c0290a, C0297j c0297j) {
        this.f226f = false;
        this.f222b = blockingQueue;
        this.f223c = blockingQueue2;
        this.f224d = c0290a;
        this.f225e = c0297j;
    }

    public void m254a() {
        this.f226f = true;
        interrupt();
    }

    public void run() {
        if (f221a) {
            C0310l.m286a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f224d.m251a();
        while (true) {
            try {
                Request request = (Request) this.f222b.take();
                request.m221a("cache-queue-take");
                if (request.m232h()) {
                    request.m226b("cache-discard-canceled");
                } else {
                    C0289a a = this.f224d.m250a(request.m229e());
                    if (a == null) {
                        request.m221a("cache-miss");
                        this.f223c.put(request);
                    } else if (a.m248a()) {
                        request.m221a("cache-hit-expired");
                        request.m217a(a);
                        this.f223c.put(request);
                    } else {
                        request.m221a("cache-hit");
                        C0307i a2 = request.m215a(new C0301g(a.f213a, a.f218f));
                        request.m221a("cache-hit-parsed");
                        if (a.m249b()) {
                            request.m221a("cache-hit-refresh-needed");
                            request.m217a(a);
                            a2.f262d = true;
                            this.f225e.m264a(request, a2, new C02911(this, request));
                        } else {
                            this.f225e.m263a(request, a2);
                        }
                    }
                }
            } catch (InterruptedException e) {
                if (this.f226f) {
                    return;
                }
            }
        }
    }
}
