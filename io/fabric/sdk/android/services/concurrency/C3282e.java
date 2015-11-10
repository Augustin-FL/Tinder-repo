package io.fabric.sdk.android.services.concurrency;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* renamed from: io.fabric.sdk.android.services.concurrency.e */
public class C3282e<V> extends FutureTask<V> implements C0410a<C0412i>, C0411f, C0412i {
    final Object f7136b;

    public /* synthetic */ void m10003c(Object obj) {
        m9998a((C0412i) obj);
    }

    public C3282e(Callable<V> callable) {
        super(callable);
        this.f7136b = m9997a((Object) callable);
    }

    public C3282e(Runnable runnable, V v) {
        super(runnable, v);
        this.f7136b = m9997a((Object) runnable);
    }

    public int compareTo(Object obj) {
        return ((C0411f) m9996a()).compareTo(obj);
    }

    public void m9998a(C0412i c0412i) {
        ((C0410a) ((C0411f) m9996a())).m632c(c0412i);
    }

    public Collection<C0412i> m10002c() {
        return ((C0410a) ((C0411f) m9996a())).m631c();
    }

    public boolean m10004d() {
        return ((C0410a) ((C0411f) m9996a())).m633d();
    }

    public Priority m10000b() {
        return ((C0411f) m9996a()).m634b();
    }

    public void m10001b(boolean z) {
        ((C0412i) ((C0411f) m9996a())).m636b(z);
    }

    public boolean m10005f() {
        return ((C0412i) ((C0411f) m9996a())).m637f();
    }

    public void m9999a(Throwable th) {
        ((C0412i) ((C0411f) m9996a())).m635a(th);
    }

    public <T extends C0410a<C0412i> & C0411f & C0412i> T m9996a() {
        return (C0410a) this.f7136b;
    }

    protected <T extends C0410a<C0412i> & C0411f & C0412i> T m9997a(Object obj) {
        if (C0413g.m638a(obj)) {
            return (C0410a) obj;
        }
        return new C0413g();
    }
}
