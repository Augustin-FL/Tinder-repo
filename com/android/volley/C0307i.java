package com.android.volley;

import com.android.volley.C0290a.C0289a;

/* renamed from: com.android.volley.i */
public class C0307i<T> {
    public final T f259a;
    public final C0289a f260b;
    public final VolleyError f261c;
    public boolean f262d;

    /* renamed from: com.android.volley.i.a */
    public interface C0305a {
        void onErrorResponse(VolleyError volleyError);
    }

    /* renamed from: com.android.volley.i.b */
    public interface C0306b<T> {
        void m279a(T t);
    }

    private C0307i(T t, C0289a c0289a) {
        this.f262d = false;
        this.f259a = t;
        this.f260b = c0289a;
        this.f261c = null;
    }

    private C0307i(VolleyError volleyError) {
        this.f262d = false;
        this.f259a = null;
        this.f260b = null;
        this.f261c = volleyError;
    }

    public static <T> C0307i<T> m281a(T t, C0289a c0289a) {
        return new C0307i(t, c0289a);
    }

    public static <T> C0307i<T> m280a(VolleyError volleyError) {
        return new C0307i(volleyError);
    }

    public boolean m282a() {
        return this.f261c == null;
    }
}
