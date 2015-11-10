package com.google.common.base;

import com.facebook.stetho.BuildConfig;
import java.util.Arrays;

/* renamed from: com.google.common.base.e */
public final class C1647e {

    /* renamed from: com.google.common.base.e.a */
    public static final class C1646a {
        private final String f1954a;
        private C1645a f1955b;
        private C1645a f1956c;
        private boolean f1957d;

        /* renamed from: com.google.common.base.e.a.a */
        private static final class C1645a {
            String f1951a;
            Object f1952b;
            C1645a f1953c;

            private C1645a() {
            }
        }

        private C1646a(String str) {
            this.f1955b = new C1645a();
            this.f1956c = this.f1955b;
            this.f1957d = false;
            this.f1954a = (String) C1650g.m3080a((Object) str);
        }

        public C1646a m3069a(String str, Object obj) {
            return m3064b(str, obj);
        }

        public C1646a m3070a(String str, boolean z) {
            return m3064b(str, String.valueOf(z));
        }

        public C1646a m3066a(String str, float f) {
            return m3064b(str, String.valueOf(f));
        }

        public C1646a m3067a(String str, int i) {
            return m3064b(str, String.valueOf(i));
        }

        public C1646a m3068a(String str, long j) {
            return m3064b(str, String.valueOf(j));
        }

        public C1646a m3065a(Object obj) {
            return m3063b(obj);
        }

        public String toString() {
            boolean z = this.f1957d;
            String str = BuildConfig.FLAVOR;
            StringBuilder append = new StringBuilder(32).append(this.f1954a).append('{');
            String str2 = str;
            C1645a c1645a = this.f1955b.f1953c;
            while (c1645a != null) {
                if (!z || c1645a.f1952b != null) {
                    append.append(str2);
                    str2 = ", ";
                    if (c1645a.f1951a != null) {
                        append.append(c1645a.f1951a).append('=');
                    }
                    append.append(c1645a.f1952b);
                }
                c1645a = c1645a.f1953c;
            }
            return append.append('}').toString();
        }

        private C1645a m3062a() {
            C1645a c1645a = new C1645a();
            this.f1956c.f1953c = c1645a;
            this.f1956c = c1645a;
            return c1645a;
        }

        private C1646a m3063b(Object obj) {
            m3062a().f1952b = obj;
            return this;
        }

        private C1646a m3064b(String str, Object obj) {
            C1645a a = m3062a();
            a.f1952b = obj;
            a.f1951a = (String) C1650g.m3080a((Object) str);
            return this;
        }
    }

    public static boolean m3074a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int m3071a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static C1646a m3072a(Object obj) {
        return new C1646a(null);
    }

    private static String m3073a(Class<?> cls) {
        String replaceAll = cls.getName().replaceAll("\\$[0-9]+", "\\$");
        int lastIndexOf = replaceAll.lastIndexOf(36);
        if (lastIndexOf == -1) {
            lastIndexOf = replaceAll.lastIndexOf(46);
        }
        return replaceAll.substring(lastIndexOf + 1);
    }

    public static <T> T m3075b(T t, T t2) {
        return t != null ? t : C1650g.m3080a((Object) t2);
    }
}
