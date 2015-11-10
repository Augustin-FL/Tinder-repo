package com.google.common.cache;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import sun.misc.Unsafe;

abstract class Striped64 extends Number {
    static final C1732c f2153a;
    static final int f2154b;
    private static final Unsafe f2155f;
    private static final long f2156g;
    private static final long f2157h;
    volatile transient C1730a[] f2158c;
    volatile transient long f2159d;
    volatile transient int f2160e;

    /* renamed from: com.google.common.cache.Striped64.1 */
    static class C17281 implements PrivilegedExceptionAction<Unsafe> {
        C17281() {
        }

        public /* synthetic */ Object run() throws Exception {
            return m3551a();
        }

        public Unsafe m3551a() throws Exception {
            Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return (Unsafe) declaredField.get(null);
        }
    }

    /* renamed from: com.google.common.cache.Striped64.a */
    static final class C1730a {
        private static final Unsafe f2167b;
        private static final long f2168c;
        volatile long f2169a;

        /* renamed from: com.google.common.cache.Striped64.a.1 */
        static class C17291 implements PrivilegedExceptionAction<Unsafe> {
            C17291() {
            }

            public /* synthetic */ Object run() throws Exception {
                return m3552a();
            }

            public Unsafe m3552a() throws Exception {
                Class cls = Unsafe.class;
                for (Field field : cls.getDeclaredFields()) {
                    field.setAccessible(true);
                    Object obj = field.get(null);
                    if (cls.isInstance(obj)) {
                        return (Unsafe) cls.cast(obj);
                    }
                }
                throw new NoSuchFieldError("the Unsafe");
            }
        }

        C1730a(long j) {
            this.f2169a = j;
        }

        final boolean m3554a(long j, long j2) {
            return f2167b.compareAndSwapLong(this, f2168c, j, j2);
        }

        static {
            try {
                f2167b = C1730a.m3553a();
                f2168c = f2167b.objectFieldOffset(C1730a.class.getDeclaredField("value"));
            } catch (Throwable e) {
                throw new Error(e);
            }
        }

        private static Unsafe m3553a() {
            Unsafe unsafe;
            try {
                unsafe = Unsafe.getUnsafe();
            } catch (SecurityException e) {
                try {
                    unsafe = (Unsafe) AccessController.doPrivileged(new C17291());
                } catch (PrivilegedActionException e2) {
                    throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
                }
            }
            return unsafe;
        }
    }

    /* renamed from: com.google.common.cache.Striped64.b */
    static final class C1731b {
        static final Random f2170a;
        int f2171b;

        static {
            f2170a = new Random();
        }

        C1731b() {
            int nextInt = f2170a.nextInt();
            if (nextInt == 0) {
                nextInt = 1;
            }
            this.f2171b = nextInt;
        }
    }

    /* renamed from: com.google.common.cache.Striped64.c */
    static final class C1732c extends ThreadLocal<C1731b> {
        C1732c() {
        }

        public /* synthetic */ Object initialValue() {
            return m3555a();
        }

        public C1731b m3555a() {
            return new C1731b();
        }
    }

    abstract long m3537a(long j, long j2);

    static {
        f2153a = new C1732c();
        f2154b = Runtime.getRuntime().availableProcessors();
        try {
            f2155f = m3536a();
            Class cls = Striped64.class;
            f2156g = f2155f.objectFieldOffset(cls.getDeclaredField("base"));
            f2157h = f2155f.objectFieldOffset(cls.getDeclaredField("busy"));
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    Striped64() {
    }

    final boolean m3539b(long j, long j2) {
        return f2155f.compareAndSwapLong(this, f2156g, j, j2);
    }

    final boolean m3540c() {
        return f2155f.compareAndSwapInt(this, f2157h, 0, 1);
    }

    final void m3538a(long j, C1731b c1731b, boolean z) {
        int i = c1731b.f2171b;
        Object obj = null;
        while (true) {
            Object obj2;
            C1730a[] c1730aArr = this.f2158c;
            if (c1730aArr != null) {
                int length = c1730aArr.length;
                if (length > 0) {
                    C1730a c1730a = c1730aArr[(length - 1) & i];
                    C1730a[] c1730aArr2;
                    if (c1730a != null) {
                        if (z) {
                            long j2 = c1730a.f2169a;
                            if (c1730a.m3554a(j2, m3537a(j2, j))) {
                                break;
                            } else if (length >= f2154b || this.f2158c != c1730aArr) {
                                obj = null;
                            } else if (obj == null) {
                                obj = 1;
                            } else if (this.f2160e == 0 && m3540c()) {
                                try {
                                    if (this.f2158c == c1730aArr) {
                                        c1730aArr2 = new C1730a[(length << 1)];
                                        for (int i2 = 0; i2 < length; i2++) {
                                            c1730aArr2[i2] = c1730aArr[i2];
                                        }
                                        this.f2158c = c1730aArr2;
                                    }
                                    this.f2160e = 0;
                                    obj = null;
                                } catch (Throwable th) {
                                    this.f2160e = 0;
                                }
                            }
                        } else {
                            z = true;
                        }
                    } else {
                        if (this.f2160e == 0) {
                            C1730a c1730a2 = new C1730a(j);
                            if (this.f2160e == 0 && m3540c()) {
                                obj2 = null;
                                try {
                                    c1730aArr2 = this.f2158c;
                                    if (c1730aArr2 != null) {
                                        int length2 = c1730aArr2.length;
                                        if (length2 > 0) {
                                            length2 = (length2 - 1) & i;
                                            if (c1730aArr2[length2] == null) {
                                                c1730aArr2[length2] = c1730a2;
                                                obj2 = 1;
                                            }
                                        }
                                    }
                                    this.f2160e = 0;
                                    if (obj2 != null) {
                                        break;
                                    }
                                } catch (Throwable th2) {
                                    this.f2160e = 0;
                                }
                            }
                        }
                        obj = null;
                    }
                    i ^= i << 13;
                    i ^= i >>> 17;
                    i ^= i << 5;
                }
            }
            if (this.f2160e == 0 && this.f2158c == c1730aArr && m3540c()) {
                obj2 = null;
                try {
                    if (this.f2158c == c1730aArr) {
                        C1730a[] c1730aArr3 = new C1730a[2];
                        c1730aArr3[i & 1] = new C1730a(j);
                        this.f2158c = c1730aArr3;
                        obj2 = 1;
                    }
                    this.f2160e = 0;
                    if (obj2 != null) {
                        break;
                    }
                } catch (Throwable th3) {
                    this.f2160e = 0;
                }
            } else {
                long j3 = this.f2159d;
                if (m3539b(j3, m3537a(j3, j))) {
                    break;
                }
            }
        }
        c1731b.f2171b = i;
    }

    private static Unsafe m3536a() {
        Unsafe unsafe;
        try {
            unsafe = Unsafe.getUnsafe();
        } catch (SecurityException e) {
            try {
                unsafe = (Unsafe) AccessController.doPrivileged(new C17281());
            } catch (PrivilegedActionException e2) {
                throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
            }
        }
        return unsafe;
    }
}
