package com.google.common.cache;

import com.google.common.base.C1625l;
import java.util.concurrent.atomic.AtomicLong;

final class LongAddables {
    private static final C1625l<C1722f> f2152a;

    /* renamed from: com.google.common.cache.LongAddables.1 */
    static class C17201 implements C1625l<C1722f> {
        C17201() {
        }

        public /* synthetic */ Object m3527a() {
            return m3528b();
        }

        public C1722f m3528b() {
            return new LongAdder();
        }
    }

    /* renamed from: com.google.common.cache.LongAddables.2 */
    static class C17212 implements C1625l<C1722f> {
        C17212() {
        }

        public /* synthetic */ Object m3529a() {
            return m3530b();
        }

        public C1722f m3530b() {
            return new PureJavaLongAddable();
        }
    }

    private static final class PureJavaLongAddable extends AtomicLong implements C1722f {
        private PureJavaLongAddable() {
        }

        public void m3533a() {
            getAndIncrement();
        }

        public void m3534a(long j) {
            getAndAdd(j);
        }
    }

    static {
        C1625l c17201;
        try {
            LongAdder longAdder = new LongAdder();
            c17201 = new C17201();
        } catch (Throwable th) {
            c17201 = new C17212();
        }
        f2152a = c17201;
    }

    public static C1722f m3535a() {
        return (C1722f) f2152a.m3003a();
    }
}
