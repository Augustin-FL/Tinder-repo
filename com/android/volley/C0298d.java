package com.android.volley;

import android.os.Handler;
import java.util.concurrent.Executor;

/* renamed from: com.android.volley.d */
public class C0298d implements C0297j {
    private final Executor f237a;

    /* renamed from: com.android.volley.d.1 */
    class C02951 implements Executor {
        final /* synthetic */ Handler f231a;
        final /* synthetic */ C0298d f232b;

        C02951(C0298d c0298d, Handler handler) {
            this.f232b = c0298d;
            this.f231a = handler;
        }

        public void execute(Runnable runnable) {
            this.f231a.post(runnable);
        }
    }

    /* renamed from: com.android.volley.d.a */
    private class C0296a implements Runnable {
        final /* synthetic */ C0298d f233a;
        private final Request f234b;
        private final C0307i f235c;
        private final Runnable f236d;

        public C0296a(C0298d c0298d, Request request, C0307i c0307i, Runnable runnable) {
            this.f233a = c0298d;
            this.f234b = request;
            this.f235c = c0307i;
            this.f236d = runnable;
        }

        public void run() {
            if (this.f234b.m232h()) {
                this.f234b.m226b("canceled-at-delivery");
                return;
            }
            if (this.f235c.m282a()) {
                this.f234b.m225b(this.f235c.f259a);
            } else {
                this.f234b.m224b(this.f235c.f261c);
            }
            if (this.f235c.f262d) {
                this.f234b.m221a("intermediate-response");
            } else {
                this.f234b.m226b("done");
            }
            if (this.f236d != null) {
                this.f236d.run();
            }
        }
    }

    public C0298d(Handler handler) {
        this.f237a = new C02951(this, handler);
    }

    public void m266a(Request<?> request, C0307i<?> c0307i) {
        m267a(request, c0307i, null);
    }

    public void m267a(Request<?> request, C0307i<?> c0307i, Runnable runnable) {
        request.m246v();
        request.m221a("post-response");
        this.f237a.execute(new C0296a(this, request, c0307i, runnable));
    }

    public void m265a(Request<?> request, VolleyError volleyError) {
        request.m221a("post-error");
        this.f237a.execute(new C0296a(this, request, C0307i.m280a(volleyError), null));
    }
}
