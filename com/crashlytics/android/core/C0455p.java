package com.crashlytics.android.core;

import android.content.Context;
import com.facebook.internal.NativeProtocol;
import io.fabric.sdk.android.C3218c;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.File;
import java.util.Set;

/* renamed from: com.crashlytics.android.core.p */
class C0455p {
    private static final C0454a f631a;
    private final Context f632b;
    private final File f633c;
    private C0452o f634d;

    /* renamed from: com.crashlytics.android.core.p.a */
    private static final class C0454a implements C0452o {
        private C0454a() {
        }

        public void m803a(long j, String str) {
        }

        public C0406b m802a() {
            return null;
        }

        public void m804b() {
        }

        public void m805c() {
        }
    }

    static {
        f631a = new C0454a();
    }

    public C0455p(Context context, File file) {
        this(context, file, null);
    }

    public C0455p(Context context, File file, String str) {
        this.f632b = context;
        this.f633c = new File(file, "log-files");
        this.f634d = f631a;
        m813a(str);
    }

    public final void m813a(String str) {
        this.f634d.m800b();
        this.f634d = f631a;
        if (str != null) {
            if (m809d()) {
                m812a(m807b(str), (int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
            } else {
                C3218c.m9728h().m9687a("CrashlyticsCore", "Preferences requested no custom logs. Aborting log file creation.");
            }
        }
    }

    public void m811a(long j, String str) {
        this.f634d.m799a(j, str);
    }

    public C0406b m810a() {
        return this.f634d.m798a();
    }

    public void m815b() {
        this.f634d.m801c();
    }

    public void m814a(Set<String> set) {
        File[] listFiles = this.f633c.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (!set.contains(m806a(file))) {
                    file.delete();
                }
            }
        }
    }

    void m812a(File file, int i) {
        this.f634d = new C0475t(file, i);
    }

    private File m807b(String str) {
        m808c();
        return new File(this.f633c, "crashlytics-userlog-" + str + ".temp");
    }

    private String m806a(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".temp");
        return lastIndexOf == -1 ? name : name.substring("crashlytics-userlog-".length(), lastIndexOf);
    }

    private void m808c() {
        if (!this.f633c.exists()) {
            this.f633c.mkdirs();
        }
    }

    private boolean m809d() {
        return CommonUtils.m9858a(this.f632b, "com.crashlytics.CollectCustomLogs", true);
    }
}
