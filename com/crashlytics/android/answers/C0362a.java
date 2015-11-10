package com.crashlytics.android.answers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build.VERSION;
import io.fabric.sdk.android.C0347h;
import io.fabric.sdk.android.C3211a;
import io.fabric.sdk.android.C3218c;
import io.fabric.sdk.android.services.common.C3251i.C3252a;
import io.fabric.sdk.android.services.common.C3251i.C3253b;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.network.C3296b;
import io.fabric.sdk.android.services.p035c.C3237b;
import io.fabric.sdk.android.services.p035c.C3239d;
import io.fabric.sdk.android.services.settings.C3321q;
import io.fabric.sdk.android.services.settings.C3322s;
import java.io.File;

/* renamed from: com.crashlytics.android.answers.a */
public class C0362a extends C0347h<Boolean> {
    C0372e f410a;
    C0392p f411b;
    C3211a f412c;
    private String f413d;
    private String f414j;
    private long f415k;

    protected /* synthetic */ Object m472f() {
        return m470d();
    }

    public void m466a(C3253b c3253b) {
        if (this.f411b != null) {
            this.f411b.m560b(c3253b.m9934a());
        }
    }

    public void m465a(C3252a c3252a) {
        if (this.f411b != null) {
            this.f411b.m558a(c3252a.m9934a());
        }
    }

    @SuppressLint({"NewApi"})
    protected boolean a_() {
        try {
            Context B = m402B();
            this.f410a = new C0372e(new C3239d(B, "settings"));
            this.f412c = new C3211a(B);
            PackageInfo packageInfo = B.getPackageManager().getPackageInfo(B.getPackageName(), 0);
            this.f413d = Integer.toString(packageInfo.versionCode);
            this.f414j = packageInfo.versionName == null ? "0.0" : packageInfo.versionName;
            if (VERSION.SDK_INT >= 9) {
                this.f415k = packageInfo.firstInstallTime;
            } else {
                this.f415k = new File(B.getPackageManager().getApplicationInfo(B.getPackageName(), 0).sourceDir).lastModified();
            }
            m463a(B);
            return true;
        } catch (Throwable e) {
            C3218c.m9728h().m9695e("Answers", "Error retrieving app properties", e);
            return false;
        }
    }

    protected Boolean m470d() {
        try {
            C3322s b = C3321q.m10135a().m10139b();
            if (b == null) {
                C3218c.m9728h().m9694e("Answers", "Failed to retrieve settings");
                return Boolean.valueOf(false);
            } else if (b.f7251d.f7225d) {
                C3218c.m9728h().m9687a("Answers", "Analytics collection enabled");
                this.f411b.m557a(b.f7252e, m471e());
                return Boolean.valueOf(true);
            } else {
                C3218c.m9728h().m9687a("Answers", "Analytics collection disabled");
                this.f412c.m9683a();
                this.f411b.m559b();
                return Boolean.valueOf(false);
            }
        } catch (Throwable e) {
            C3218c.m9728h().m9695e("Answers", "Error dealing with settings", e);
            return Boolean.valueOf(false);
        }
    }

    public String m468b() {
        return "com.crashlytics.sdk.android:answers";
    }

    public String m464a() {
        return "1.3.2.79";
    }

    private void m463a(Context context) {
        try {
            C0396t c0396t = new C0396t(context, m401A(), this.f413d, this.f414j);
            C0369b c0369b = new C0369b(this, context, new C0370c(context, new C3237b(this)), c0396t, new C3296b(C3218c.m9728h()));
            c0369b.m486b();
            this.f411b = new C0392p(c0369b);
            this.f412c.m9684a(new C0371d(this.f411b));
            if (m467a(this.f415k)) {
                C3218c.m9728h().m9687a("Answers", "New app install detected");
                this.f411b.m555a();
                this.f410a.m497a();
            }
        } catch (Throwable e) {
            C3218c.m9728h().m9695e("Answers", "Failed to initialize", e);
        }
    }

    String m471e() {
        return CommonUtils.m9863b(m402B(), "com.crashlytics.ApiEndpoint");
    }

    boolean m467a(long j) {
        return !this.f410a.m498b() && m469b(j);
    }

    boolean m469b(long j) {
        return System.currentTimeMillis() - j < 3600000;
    }
}
