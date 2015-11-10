package com.google.android.m4b.maps.ah;

import android.os.Looper;
import com.google.android.m4b.maps.e.b;
import com.google.android.m4b.maps.e.c;
import com.google.common.collect.C1876q;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.m4b.maps.ah.a */
public final class C1324a {
    private static volatile boolean f802a;
    private static final Map<C1323c, LinkedList<C1321a>> f803b;

    /* renamed from: com.google.android.m4b.maps.ah.a.1 */
    static class C13201 implements Runnable {
        private /* synthetic */ List f784a;
        private /* synthetic */ C1323c f785b;

        C13201(List list, C1323c c1323c) {
            this.f784a = list;
            this.f785b = c1323c;
        }

        public final void run() {
            for (C1321a c1321a : this.f784a) {
                C1324a.m1057a(this.f785b, c1321a);
                c1321a.run();
            }
        }
    }

    /* renamed from: com.google.android.m4b.maps.ah.a.a */
    public static abstract class C1321a implements Runnable {
        private final boolean f786a;
        private final boolean f787b;
        private final C1322b f788c;

        public C1321a() {
            this(false, false);
        }

        private C1321a(boolean z, boolean z2) {
            this(false, false, null);
        }

        private C1321a(boolean z, boolean z2, C1322b c1322b) {
            this.f786a = z;
            this.f787b = z2;
            this.f788c = null;
        }

        public final void run() {
            if ((!this.f787b || !C1324a.f802a) && this.f788c != null) {
                synchronized (this.f788c) {
                }
            }
        }
    }

    /* renamed from: com.google.android.m4b.maps.ah.a.b */
    public enum C1322b {
        ORIENTATION_PROVIDER_ACTIVITY_RESUME,
        START_MOTION_RECOGNIZER
    }

    /* renamed from: com.google.android.m4b.maps.ah.a.c */
    public enum C1323c {
        STARTUP_GMM("GMM startup", true),
        STARTUP_DRIVEABOUT("Driveabout startup", true),
        STARTUP_COMMON("GMM or Driveabout startup", true),
        TERMS_AND_CONDITIONS("Term and conditions", true),
        ON_RESUME("On resume", false),
        GENERAL("General", false),
        GENERAL_ONE_TIME("General one time", true);
        
        private String f800h;
        private final boolean f801i;

        private C1323c(String str, boolean z) {
            this.f800h = str;
            this.f801i = z;
        }

        public final String toString() {
            return this.f800h + "[oneTime = " + this.f801i + "]";
        }
    }

    static /* synthetic */ void m1057a(C1323c c1323c, C1321a c1321a) {
        Looper.getMainLooper().getThread();
        Thread.currentThread();
    }

    static {
        int i = 0;
        f802a = false;
        f803b = Collections.synchronizedMap(C1876q.m4328a());
        C1323c[] values = C1323c.values();
        int length = values.length;
        while (i < length) {
            f803b.put(values[i], new LinkedList());
            i++;
        }
    }

    public static void m1056a() {
        f802a = false;
    }

    public static void m1059b() {
        f802a = true;
    }

    public static void m1058a(C1323c c1323c, c cVar) {
        synchronized (c1323c) {
            List list = (List) f803b.get(c1323c);
            if (list == null) {
                return;
            }
            List linkedList = new LinkedList(list);
            synchronized (c1323c) {
                if (c1323c.f801i) {
                    f803b.remove(c1323c);
                } else {
                    list = (List) f803b.get(c1323c);
                    if (list != null) {
                        list.clear();
                    }
                }
            }
            if (!linkedList.isEmpty()) {
                new b(cVar, new C13201(linkedList, c1323c)).d();
            }
        }
    }
}
