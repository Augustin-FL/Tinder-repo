package io.fabric.sdk.android.services.concurrency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: io.fabric.sdk.android.services.concurrency.g */
public class C0413g implements C0410a<C0412i>, C0411f, C0412i {
    private final List<C0412i> f536a;
    private final AtomicBoolean f537b;
    private final AtomicReference<Throwable> f538c;

    public C0413g() {
        this.f536a = new ArrayList();
        this.f537b = new AtomicBoolean(false);
        this.f538c = new AtomicReference(null);
    }

    public /* synthetic */ void m644c(Object obj) {
        m639a((C0412i) obj);
    }

    public synchronized Collection<C0412i> m643c() {
        return Collections.unmodifiableCollection(this.f536a);
    }

    public synchronized void m639a(C0412i c0412i) {
        this.f536a.add(c0412i);
    }

    public boolean m645d() {
        for (C0412i f : m643c()) {
            if (!f.m637f()) {
                return false;
            }
        }
        return true;
    }

    public synchronized void m642b(boolean z) {
        this.f537b.set(z);
    }

    public boolean m646f() {
        return this.f537b.get();
    }

    public Priority m641b() {
        return Priority.NORMAL;
    }

    public void m640a(Throwable th) {
        this.f538c.set(th);
    }

    public int compareTo(Object obj) {
        return Priority.m9990a(this, obj);
    }

    public static boolean m638a(Object obj) {
        try {
            C0410a c0410a = (C0410a) obj;
            C0412i c0412i = (C0412i) obj;
            C0411f c0411f = (C0411f) obj;
            if (c0410a == null || c0412i == null || c0411f == null) {
                return false;
            }
            return true;
        } catch (ClassCastException e) {
            return false;
        }
    }
}
