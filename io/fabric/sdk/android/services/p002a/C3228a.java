package io.fabric.sdk.android.services.p002a;

import android.content.Context;

/* renamed from: io.fabric.sdk.android.services.a.a */
public abstract class C3228a<T> implements C3227c<T> {
    private final C3227c<T> f7000a;

    protected abstract T m9796a(Context context);

    protected abstract void m9798a(Context context, T t);

    public C3228a(C3227c<T> c3227c) {
        this.f7000a = c3227c;
    }

    public final synchronized T m9797a(Context context, C0355d<T> c0355d) throws Exception {
        T a;
        a = m9796a(context);
        if (a == null) {
            a = this.f7000a != null ? this.f7000a.m9794a(context, c0355d) : c0355d.m439c(context);
            m9795b(context, a);
        }
        return a;
    }

    private void m9795b(Context context, T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        m9798a(context, (Object) t);
    }
}
