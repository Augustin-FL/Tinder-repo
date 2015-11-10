package com.android.volley;

public class VolleyError extends Exception {
    public final C0301g f189a;

    public VolleyError() {
        this.f189a = null;
    }

    public VolleyError(C0301g c0301g) {
        this.f189a = c0301g;
    }

    public VolleyError(String str) {
        super(str);
        this.f189a = null;
    }

    public VolleyError(Throwable th) {
        super(th);
        this.f189a = null;
    }
}
