package com.squareup.okhttp.internal;

/* renamed from: com.squareup.okhttp.internal.f */
public abstract class C2114f implements Runnable {
    protected final String f3216a;

    protected abstract void m5124a();

    public C2114f(String str, Object... objArr) {
        this.f3216a = String.format(str, objArr);
    }

    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f3216a);
        try {
            m5124a();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
