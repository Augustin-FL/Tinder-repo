package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

/* renamed from: com.google.common.util.concurrent.f */
public class C1920f<V> extends FutureTask<V> implements C1908e<V> {
    private final C1913c f2582a;

    public static <V> C1920f<V> m4475a(Callable<V> callable) {
        return new C1920f(callable);
    }

    public static <V> C1920f<V> m4474a(Runnable runnable, V v) {
        return new C1920f(runnable, v);
    }

    C1920f(Callable<V> callable) {
        super(callable);
        this.f2582a = new C1913c();
    }

    C1920f(Runnable runnable, V v) {
        super(runnable, v);
        this.f2582a = new C1913c();
    }

    public void m4476a(Runnable runnable, Executor executor) {
        this.f2582a.m4469a(runnable, executor);
    }

    protected void done() {
        this.f2582a.m4468a();
    }
}
