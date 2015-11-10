package io.fabric.sdk.android;

import android.content.Context;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.concurrency.C0412i;
import io.fabric.sdk.android.services.concurrency.C3281b;
import java.io.File;
import java.util.Collection;

/* renamed from: io.fabric.sdk.android.h */
public abstract class C0347h<Result> implements Comparable<C0347h> {
    C3218c f352e;
    C3224g<Result> f353f;
    Context f354g;
    C3215f<Result> f355h;
    IdManager f356i;

    public abstract String m408a();

    public abstract String m411b();

    protected abstract Result m414f();

    public /* synthetic */ int compareTo(Object obj) {
        return m407a((C0347h) obj);
    }

    public C0347h() {
        this.f353f = new C3224g(this);
    }

    void m409a(Context context, C3218c c3218c, C3215f<Result> c3215f, IdManager idManager) {
        this.f352e = c3218c;
        this.f354g = new C3219d(context, m411b(), m404D());
        this.f355h = c3215f;
        this.f356i = idManager;
    }

    final void m415z() {
        this.f353f.m9764a(this.f352e.m9740f(), (Void) null);
    }

    protected boolean a_() {
        return true;
    }

    protected void m410a(Result result) {
    }

    protected void m412b(Result result) {
    }

    protected IdManager m401A() {
        return this.f356i;
    }

    public Context m402B() {
        return this.f354g;
    }

    public C3218c m403C() {
        return this.f352e;
    }

    public String m404D() {
        return ".Fabric" + File.separator + m411b();
    }

    public int m407a(C0347h c0347h) {
        if (m413b(c0347h)) {
            return 1;
        }
        if (c0347h.m413b(this)) {
            return -1;
        }
        if (m405E() && !c0347h.m405E()) {
            return 1;
        }
        if (m405E() || !c0347h.m405E()) {
            return 0;
        }
        return -1;
    }

    boolean m413b(C0347h c0347h) {
        C3281b c3281b = (C3281b) getClass().getAnnotation(C3281b.class);
        if (c3281b != null) {
            for (Object equals : c3281b.m9995a()) {
                if (equals.equals(c0347h.getClass())) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean m405E() {
        return ((C3281b) getClass().getAnnotation(C3281b.class)) != null;
    }

    protected Collection<C0412i> m406F() {
        return this.f353f.m9767c();
    }
}
