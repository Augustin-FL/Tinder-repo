package com.crashlytics.android.core;

import com.facebook.appevents.AppEventsConstants;
import io.fabric.sdk.android.C3218c;
import io.fabric.sdk.android.services.common.C0478h;
import io.fabric.sdk.android.services.common.C3250g;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.crashlytics.android.core.v */
class C0480v {
    static final Map<String, String> f680a;
    private static final FilenameFilter f681b;
    private static final short[] f682c;
    private final Object f683d;
    private final C0448k f684e;
    private Thread f685f;

    /* renamed from: com.crashlytics.android.core.v.1 */
    static class C04771 implements FilenameFilter {
        C04771() {
        }

        public boolean accept(File file, String str) {
            return str.endsWith(".cls") && !str.contains("Session");
        }
    }

    /* renamed from: com.crashlytics.android.core.v.a */
    private class C0479a extends C0478h {
        final /* synthetic */ C0480v f678a;
        private final float f679b;

        C0479a(C0480v c0480v, float f) {
            this.f678a = c0480v;
            this.f679b = f;
        }

        public void m877a() {
            try {
                m876b();
            } catch (Throwable e) {
                C3218c.m9728h().m9695e("CrashlyticsCore", "An unexpected error occurred while attempting to upload crash reports.", e);
            }
            this.f678a.f685f = null;
        }

        private void m876b() {
            C3218c.m9728h().m9687a("CrashlyticsCore", "Starting report processing in " + this.f679b + " second(s)...");
            if (this.f679b > 0.0f) {
                try {
                    Thread.sleep((long) (this.f679b * 1000.0f));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            C0427e e2 = C0427e.m671e();
            C0446i m = e2.m694m();
            List<C0476u> a = this.f678a.m880a();
            if (!m.m775a()) {
                if (a.isEmpty() || e2.m705x()) {
                    List list = a;
                    int i = 0;
                    while (!r0.isEmpty() && !C0427e.m671e().m694m().m775a()) {
                        C3218c.m9728h().m9687a("CrashlyticsCore", "Attempting to send " + r0.size() + " report(s)");
                        for (C0476u a2 : r0) {
                            this.f678a.m882a(a2);
                        }
                        List a3 = this.f678a.m880a();
                        if (a3.isEmpty()) {
                            list = a3;
                        } else {
                            int i2 = i + 1;
                            long j = (long) C0480v.f682c[Math.min(i, C0480v.f682c.length - 1)];
                            C3218c.m9728h().m9687a("CrashlyticsCore", "Report submisson: scheduling delayed retry in " + j + " seconds");
                            try {
                                Thread.sleep(j * 1000);
                                i = i2;
                                list = a3;
                            } catch (InterruptedException e3) {
                                Thread.currentThread().interrupt();
                                return;
                            }
                        }
                    }
                    return;
                }
                C3218c.m9728h().m9687a("CrashlyticsCore", "User declined to send. Removing " + a.size() + " Report(s).");
                for (C0476u a22 : a) {
                    a22.m870a();
                }
            }
        }
    }

    static {
        f681b = new C04771();
        f680a = Collections.singletonMap("X-CRASHLYTICS-INVALID-SESSION", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        f682c = new short[]{(short) 10, (short) 20, (short) 30, (short) 60, (short) 120, (short) 300};
    }

    public C0480v(C0448k c0448k) {
        this.f683d = new Object();
        if (c0448k == null) {
            throw new IllegalArgumentException("createReportCall must not be null.");
        }
        this.f684e = c0448k;
    }

    public synchronized void m881a(float f) {
        if (this.f685f == null) {
            this.f685f = new Thread(new C0479a(this, f), "Crashlytics Report Uploader");
            this.f685f.start();
        }
    }

    boolean m882a(C0476u c0476u) {
        boolean z = false;
        synchronized (this.f683d) {
            try {
                boolean a = this.f684e.m782a(new C0447j(new C3250g().m9930a(C0427e.m671e().m402B()), c0476u));
                C3218c.m9728h().m9691c("CrashlyticsCore", "Crashlytics report upload " + (a ? "complete: " : "FAILED: ") + c0476u.m871b());
                if (a) {
                    c0476u.m870a();
                    z = true;
                }
            } catch (Throwable e) {
                C3218c.m9728h().m9695e("CrashlyticsCore", "Error occurred sending report " + c0476u, e);
            }
        }
        return z;
    }

    List<C0476u> m880a() {
        C3218c.m9728h().m9687a("CrashlyticsCore", "Checking for crash reports...");
        synchronized (this.f683d) {
            File[] listFiles = C0427e.m671e().m702u().listFiles(f681b);
        }
        List<C0476u> linkedList = new LinkedList();
        for (File file : listFiles) {
            C3218c.m9728h().m9687a("CrashlyticsCore", "Found crash report " + file.getPath());
            linkedList.add(new C0482x(file));
        }
        if (linkedList.isEmpty()) {
            C3218c.m9728h().m9687a("CrashlyticsCore", "No reports found.");
        }
        return linkedList;
    }
}
