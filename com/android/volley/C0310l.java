package com.android.volley;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* renamed from: com.android.volley.l */
public class C0310l {
    public static String f269a;
    public static final boolean f270b;

    /* renamed from: com.android.volley.l.a */
    static class C0309a {
        public static final boolean f266a;
        private final List<C0308a> f267b;
        private boolean f268c;

        /* renamed from: com.android.volley.l.a.a */
        private static class C0308a {
            public final String f263a;
            public final long f264b;
            public final long f265c;

            public C0308a(String str, long j, long j2) {
                this.f263a = str;
                this.f264b = j;
                this.f265c = j2;
            }
        }

        C0309a() {
            this.f267b = new ArrayList();
            this.f268c = false;
        }

        static {
            f266a = C0310l.f270b;
        }

        public synchronized void m285a(String str, long j) {
            if (this.f268c) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.f267b.add(new C0308a(str, j, SystemClock.elapsedRealtime()));
        }

        public synchronized void m284a(String str) {
            this.f268c = true;
            if (m283a() > 0) {
                long j = ((C0308a) this.f267b.get(0)).f265c;
                C0310l.m288b("(%-4d ms) %s", Long.valueOf(r2), str);
                long j2 = j;
                for (C0308a c0308a : this.f267b) {
                    C0310l.m288b("(+%-4d) [%2d] %s", Long.valueOf(c0308a.f265c - j2), Long.valueOf(c0308a.f264b), c0308a.f263a);
                    j2 = c0308a.f265c;
                }
            }
        }

        protected void finalize() throws Throwable {
            if (!this.f268c) {
                m284a("Request on the loose");
                C0310l.m289c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }

        private long m283a() {
            if (this.f267b.size() == 0) {
                return 0;
            }
            return ((C0308a) this.f267b.get(this.f267b.size() - 1)).f265c - ((C0308a) this.f267b.get(0)).f265c;
        }
    }

    static {
        f269a = "Volley";
        f270b = Log.isLoggable(f269a, 2);
    }

    public static void m286a(String str, Object... objArr) {
        if (f270b) {
            Log.v(f269a, C0310l.m291e(str, objArr));
        }
    }

    public static void m288b(String str, Object... objArr) {
        Log.d(f269a, C0310l.m291e(str, objArr));
    }

    public static void m289c(String str, Object... objArr) {
        Log.e(f269a, C0310l.m291e(str, objArr));
    }

    public static void m287a(Throwable th, String str, Object... objArr) {
        Log.e(f269a, C0310l.m291e(str, objArr), th);
    }

    public static void m290d(String str, Object... objArr) {
        Log.wtf(f269a, C0310l.m291e(str, objArr));
    }

    private static String m291e(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        String str3 = "<unknown>";
        for (int i = 2; i < stackTrace.length; i++) {
            if (!stackTrace[i].getClass().equals(C0310l.class)) {
                str3 = stackTrace[i].getClassName();
                str3 = str3.substring(str3.lastIndexOf(46) + 1);
                str2 = str3.substring(str3.lastIndexOf(36) + 1) + "." + stackTrace[i].getMethodName();
                break;
            }
        }
        str2 = str3;
        return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), str2, str});
    }
}
