package com.google.android.m4b.maps.p020y;

import com.google.android.m4b.maps.ag.g;

/* renamed from: com.google.android.m4b.maps.y.a */
public abstract class C1589a {
    private static C1589a f1817a;

    /* renamed from: com.google.android.m4b.maps.y.a.b */
    public static abstract class C1585b {
        private long f1809a;
        private long f1810b;

        public C1585b() {
            this.f1809a = System.currentTimeMillis();
            this.f1810b = -1;
        }
    }

    /* renamed from: com.google.android.m4b.maps.y.a.a */
    public static class C1586a extends C1585b {
        private final String f1811a;
        private int f1812b;
        private int f1813c;

        public C1586a(String str, g gVar) {
            this.f1811a = str;
            if (gVar != null) {
                this.f1812b = gVar.i();
                this.f1813c = gVar.hashCode();
            }
        }
    }

    /* renamed from: com.google.android.m4b.maps.y.a.c */
    public static class C1587c extends C1585b {
        private final String f1814a;
        private final String f1815b;

        public C1587c(String str, String str2) {
            this.f1814a = str;
            this.f1815b = str2;
        }
    }

    /* renamed from: com.google.android.m4b.maps.y.a.d */
    public static class C1588d extends C1585b {
        private final Throwable f1816a;

        public C1588d(Throwable th) {
            this.f1816a = th;
        }
    }

    public abstract void m2849a(C1585b c1585b);

    public static void m2848b(C1585b c1585b) {
        C1589a c1589a = f1817a;
        if (c1589a != null) {
            c1589a.m2849a(c1585b);
        }
    }
}
