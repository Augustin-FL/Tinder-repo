package com.android.volley;

import android.net.TrafficStats;
import android.os.Build.VERSION;
import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* renamed from: com.android.volley.f */
public class C0300f extends Thread {
    private final BlockingQueue<Request> f238a;
    private final C0299e f239b;
    private final C0290a f240c;
    private final C0297j f241d;
    private volatile boolean f242e;

    public C0300f(BlockingQueue<Request> blockingQueue, C0299e c0299e, C0290a c0290a, C0297j c0297j) {
        this.f242e = false;
        this.f238a = blockingQueue;
        this.f239b = c0299e;
        this.f240c = c0290a;
        this.f241d = c0297j;
    }

    public void m269a() {
        this.f242e = true;
        interrupt();
    }

    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                Request request = (Request) this.f238a.take();
                try {
                    request.m221a("network-queue-take");
                    if (request.m232h()) {
                        request.m226b("network-discard-cancelled");
                    } else {
                        if (VERSION.SDK_INT >= 14) {
                            TrafficStats.setThreadStatsTag(request.m227c());
                        }
                        C0301g performRequest = this.f239b.performRequest(request);
                        request.m221a("network-http-complete");
                        if (performRequest.f246d && request.m247w()) {
                            request.m226b("not-modified");
                        } else {
                            C0307i a = request.m215a(performRequest);
                            request.m221a("network-parse-complete");
                            if (request.m242r() && a.f260b != null) {
                                this.f240c.m252a(request.m229e(), a.f260b);
                                request.m221a("network-cache-written");
                            }
                            request.m246v();
                            this.f241d.m263a(request, a);
                        }
                    }
                } catch (VolleyError e) {
                    m268a(request, e);
                } catch (Throwable e2) {
                    C0310l.m287a(e2, "Unhandled exception %s", e2.toString());
                    this.f241d.m262a(request, new VolleyError(e2));
                }
            } catch (InterruptedException e3) {
                if (this.f242e) {
                    return;
                }
            }
        }
    }

    private void m268a(Request<?> request, VolleyError volleyError) {
        this.f241d.m262a((Request) request, request.m214a(volleyError));
    }
}
