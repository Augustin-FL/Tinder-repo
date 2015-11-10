package com.google.common.util.concurrent;

import com.google.common.base.C1430c;
import com.google.common.base.C1650g;
import com.google.common.collect.C1757u;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: com.google.common.util.concurrent.d */
public final class C1919d {
    private static final C1911b<C1908e<Object>, Object> f2580a;
    private static final C1757u<Constructor<?>> f2581b;

    /* renamed from: com.google.common.util.concurrent.d.1 */
    static class C19141 implements C1911b<I, O> {
    }

    /* renamed from: com.google.common.util.concurrent.d.2 */
    static class C19152 implements C1911b<C1908e<Object>, Object> {
        C19152() {
        }
    }

    /* renamed from: com.google.common.util.concurrent.d.3 */
    static class C19163 implements C1430c<Constructor<?>, Boolean> {
        C19163() {
        }

        public Boolean m4470a(Constructor<?> constructor) {
            return Boolean.valueOf(Arrays.asList(constructor.getParameterTypes()).contains(String.class));
        }
    }

    /* renamed from: com.google.common.util.concurrent.d.a */
    private static abstract class C1917a<V> implements C1908e<V> {
        private static final Logger f2578a;

        public abstract V get() throws ExecutionException;

        private C1917a() {
        }

        static {
            f2578a = Logger.getLogger(C1917a.class.getName());
        }

        public void m4472a(Runnable runnable, Executor executor) {
            C1650g.m3081a((Object) runnable, (Object) "Runnable was null.");
            C1650g.m3081a((Object) executor, (Object) "Executor was null.");
            try {
                executor.execute(runnable);
            } catch (Throwable e) {
                f2578a.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, e);
            }
        }

        public boolean cancel(boolean z) {
            return false;
        }

        public V get(long j, TimeUnit timeUnit) throws ExecutionException {
            C1650g.m3080a((Object) timeUnit);
            return get();
        }

        public boolean isCancelled() {
            return false;
        }

        public boolean isDone() {
            return true;
        }
    }

    /* renamed from: com.google.common.util.concurrent.d.b */
    private static class C1918b<V> extends C1917a<V> {
        private final V f2579a;

        C1918b(V v) {
            super();
            this.f2579a = v;
        }

        public V get() {
            return this.f2579a;
        }
    }

    public static <V> C1908e<V> m4473a(V v) {
        return new C1918b(v);
    }

    static {
        f2580a = new C19152();
        f2581b = C1757u.m3621b().m3624a(new C19163()).m3623a();
    }
}
