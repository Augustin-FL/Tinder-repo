package io.fabric.sdk.android.services.settings;

import android.content.Context;
import io.fabric.sdk.android.C0347h;
import io.fabric.sdk.android.C3218c;
import io.fabric.sdk.android.services.common.C3250g;
import io.fabric.sdk.android.services.common.C3266p;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.DeliveryMechanism;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.network.C3295c;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: io.fabric.sdk.android.services.settings.q */
public class C3321q {
    private final AtomicReference<C3322s> f7244a;
    private final CountDownLatch f7245b;
    private C3309r f7246c;
    private boolean f7247d;

    /* renamed from: io.fabric.sdk.android.services.settings.q.b */
    public interface C0419b<T> {
        T m652b(C3322s c3322s);
    }

    /* renamed from: io.fabric.sdk.android.services.settings.q.a */
    static class C3320a {
        private static final C3321q f7243a;

        static {
            f7243a = new C3321q();
        }
    }

    public static C3321q m10135a() {
        return C3320a.f7243a;
    }

    private C3321q() {
        this.f7244a = new AtomicReference();
        this.f7245b = new CountDownLatch(1);
        this.f7247d = false;
    }

    public synchronized C3321q m10137a(C0347h c0347h, IdManager idManager, C3295c c3295c, String str, String str2, String str3) {
        C3321q c3321q;
        if (this.f7247d) {
            c3321q = this;
        } else {
            if (this.f7246c == null) {
                Context B = c0347h.m402B();
                String c = idManager.m9894c();
                String a = new C3250g().m9930a(B);
                String h = idManager.m9899h();
                C3266p c3266p = new C3266p();
                C3312k c3312k = new C3312k();
                C3308i c3308i = new C3308i(c0347h);
                String k = CommonUtils.m9876k(B);
                String str4 = str3;
                C3314l c3314l = new C3314l(c0347h, str4, String.format(Locale.US, "https://settings.crashlytics.com/spi/v2/platforms/android/apps/%s/settings", new Object[]{c}), c3295c);
                h = str2;
                String str5 = str;
                this.f7246c = new C3310j(c0347h, new C3324v(a, idManager.m9891a(a, c), CommonUtils.m9849a(CommonUtils.m9878m(B)), h, str5, DeliveryMechanism.m9880a(h).m9881a(), k), c3266p, c3312k, c3308i, c3314l);
            }
            this.f7247d = true;
            c3321q = this;
        }
        return c3321q;
    }

    public <T> T m10138a(C0419b<T> c0419b, T t) {
        C3322s c3322s = (C3322s) this.f7244a.get();
        return c3322s == null ? t : c0419b.m652b(c3322s);
    }

    public C3322s m10139b() {
        try {
            this.f7245b.await();
            return (C3322s) this.f7244a.get();
        } catch (InterruptedException e) {
            C3218c.m9728h().m9694e("Fabric", "Interrupted while waiting for settings data.");
            return null;
        }
    }

    public synchronized boolean m10140c() {
        C3322s a;
        a = this.f7246c.m10106a();
        m10136a(a);
        return a != null;
    }

    public synchronized boolean m10141d() {
        C3322s a;
        a = this.f7246c.m10107a(SettingsCacheBehavior.SKIP_CACHE_LOOKUP);
        m10136a(a);
        if (a == null) {
            C3218c.m9728h().m9695e("Fabric", "Failed to force reload of settings from Crashlytics.", null);
        }
        return a != null;
    }

    private void m10136a(C3322s c3322s) {
        this.f7244a.set(c3322s);
        this.f7245b.countDown();
    }
}
