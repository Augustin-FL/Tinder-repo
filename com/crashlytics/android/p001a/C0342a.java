package com.crashlytics.android.p001a;

import android.annotation.SuppressLint;
import android.content.Context;
import io.fabric.sdk.android.C3218c;
import io.fabric.sdk.android.services.common.C3250g;
import io.fabric.sdk.android.services.common.C3254j;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.network.C3295c;
import io.fabric.sdk.android.services.p035c.C3238c;
import io.fabric.sdk.android.services.settings.C3305f;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.crashlytics.android.a.a */
abstract class C0342a implements C0341j {
    private final AtomicBoolean f337a;
    private final AtomicBoolean f338b;
    private Context f339c;
    private C0349c f340d;
    private IdManager f341e;
    private C3305f f342f;
    private C0350d f343g;
    private C3238c f344h;
    private C3254j f345i;
    private C3295c f346j;
    private long f347k;

    public C0342a() {
        this(false);
    }

    public C0342a(boolean z) {
        this.f337a = new AtomicBoolean();
        this.f347k = 0;
        this.f338b = new AtomicBoolean(z);
    }

    public void m387a(Context context, C0349c c0349c, IdManager idManager, C3305f c3305f, C0350d c0350d, C3238c c3238c, C3254j c3254j, C3295c c3295c) {
        this.f339c = context;
        this.f340d = c0349c;
        this.f341e = idManager;
        this.f342f = c3305f;
        this.f343g = c0350d;
        this.f344h = c3238c;
        this.f345i = c3254j;
        this.f346j = c3295c;
        if (m389b()) {
            m390c();
        }
    }

    protected boolean m388a() {
        this.f338b.set(true);
        return this.f337a.get();
    }

    boolean m389b() {
        this.f337a.set(true);
        return this.f338b.get();
    }

    @SuppressLint({"CommitPrefEdits"})
    protected void m390c() {
        synchronized (this.f344h) {
            if (this.f344h.m9827a().contains("last_update_check")) {
                this.f344h.m9828a(this.f344h.m9829b().remove("last_update_check"));
            }
        }
        long a = this.f345i.m9935a();
        long j = ((long) this.f342f.f7213b) * 1000;
        C3218c.m9728h().m9687a("Beta", "Check for updates delay: " + j);
        C3218c.m9728h().m9687a("Beta", "Check for updates last check time: " + m391d());
        j += m391d();
        C3218c.m9728h().m9687a("Beta", "Check for updates current time: " + a + ", next check time: " + j);
        if (a >= j) {
            try {
                m385e();
            } finally {
                m386a(a);
            }
        } else {
            C3218c.m9728h().m9687a("Beta", "Check for updates next check time was not passed");
        }
    }

    private void m385e() {
        C3218c.m9728h().m9687a("Beta", "Performing update check");
        String a = new C3250g().m9930a(this.f339c);
        new C0352e(this.f340d, this.f340d.m428g(), this.f342f.f7212a, this.f346j, new C0354g()).m437a(a, this.f341e.m9891a(a, this.f343g.f363d), this.f343g);
    }

    void m386a(long j) {
        this.f347k = j;
    }

    long m391d() {
        return this.f347k;
    }
}
