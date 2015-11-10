package com.crashlytics.android.p001a;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.facebook.stetho.BuildConfig;
import io.fabric.sdk.android.C0347h;
import io.fabric.sdk.android.C3218c;
import io.fabric.sdk.android.services.common.C0348k;
import io.fabric.sdk.android.services.common.C3266p;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.common.IdManager.DeviceIdentifierType;
import io.fabric.sdk.android.services.network.C3296b;
import io.fabric.sdk.android.services.p002a.C3229b;
import io.fabric.sdk.android.services.p035c.C3239d;
import io.fabric.sdk.android.services.settings.C3305f;
import io.fabric.sdk.android.services.settings.C3321q;
import io.fabric.sdk.android.services.settings.C3322s;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.crashlytics.android.a.c */
public class C0349c extends C0347h<Boolean> implements C0348k {
    private final C3229b<String> f357a;
    private final C0356h f358b;
    private C0341j f359c;

    public C0349c() {
        this.f357a = new C3229b();
        this.f358b = new C0356h();
    }

    protected /* synthetic */ Object m427f() {
        return m425d();
    }

    @TargetApi(14)
    protected boolean a_() {
        this.f359c = m420a(VERSION.SDK_INT, (Application) m402B().getApplicationContext());
        return true;
    }

    protected Boolean m425d() {
        C3218c.m9728h().m9687a("Beta", "Beta kit initializing...");
        Context B = m402B();
        IdManager A = m401A();
        if (TextUtils.isEmpty(m418a(B, A.m9899h()))) {
            C3218c.m9728h().m9687a("Beta", "A Beta device token was not found for this app");
            return Boolean.valueOf(false);
        }
        C3218c.m9728h().m9687a("Beta", "Beta device token is present, checking for app updates.");
        C3305f h = m419h();
        C0350d a = m417a(B);
        if (m422a(h, a)) {
            this.f359c.m384a(B, this, A, h, a, new C3239d(this), new C3266p(), new C3296b(C3218c.m9728h()));
        }
        return Boolean.valueOf(true);
    }

    @TargetApi(14)
    C0341j m420a(int i, Application application) {
        if (i >= 14) {
            return new C0346b(m403C().m9739e(), m403C().m9740f());
        }
        return new C0357i();
    }

    public Map<DeviceIdentifierType, String> m426e() {
        CharSequence a = m418a(m402B(), m401A().m9899h());
        Map<DeviceIdentifierType, String> hashMap = new HashMap();
        if (!TextUtils.isEmpty(a)) {
            hashMap.put(DeviceIdentifierType.FONT_TOKEN, a);
        }
        return hashMap;
    }

    public String m424b() {
        return "com.crashlytics.sdk.android:beta";
    }

    public String m421a() {
        return "1.1.3.61";
    }

    @TargetApi(11)
    boolean m423a(String str, int i) {
        if (i < 11) {
            return str == null;
        } else {
            return "io.crash.air".equals(str);
        }
    }

    boolean m422a(C3305f c3305f, C0350d c0350d) {
        return (c3305f == null || TextUtils.isEmpty(c3305f.f7212a) || c0350d == null) ? false : true;
    }

    private String m418a(Context context, String str) {
        if (m423a(str, VERSION.SDK_INT)) {
            C3218c.m9728h().m9687a("Beta", "App was possibly installed by Beta. Getting device token");
            try {
                String str2 = (String) this.f357a.m9797a(context, this.f358b);
                if (BuildConfig.FLAVOR.equals(str2)) {
                    str2 = null;
                }
                return str2;
            } catch (Throwable e) {
                C3218c.m9728h().m9695e("Beta", "Failed to load the Beta device token", e);
                return null;
            }
        }
        C3218c.m9728h().m9687a("Beta", "App was not installed by Beta. Skipping device token");
        return null;
    }

    private C3305f m419h() {
        C3322s b = C3321q.m10135a().m10139b();
        if (b != null) {
            return b.f7253f;
        }
        return null;
    }

    private C0350d m417a(Context context) {
        InputStream open;
        C0350d a;
        Throwable th;
        Throwable e;
        Object obj;
        Throwable th2;
        C0350d c0350d;
        InputStream inputStream = null;
        try {
            open = context.getAssets().open("crashlytics-build.properties");
            if (open != null) {
                try {
                    a = C0350d.m429a(open);
                } catch (Throwable e2) {
                    th = e2;
                    obj = inputStream;
                    th2 = th;
                    try {
                        C3218c.m9728h().m9695e("Beta", "Error reading Beta build properties", th2);
                        if (open != null) {
                            try {
                                open.close();
                            } catch (Throwable th22) {
                                C3218c.m9728h().m9695e("Beta", "Error closing Beta build properties asset", th22);
                            }
                        }
                        return c0350d;
                    } catch (Throwable th3) {
                        e2 = th3;
                        if (open != null) {
                            try {
                                open.close();
                            } catch (Throwable th222) {
                                C3218c.m9728h().m9695e("Beta", "Error closing Beta build properties asset", th222);
                            }
                        }
                        throw e2;
                    }
                }
                try {
                    C3218c.m9728h().m9687a("Beta", a.f363d + " build properties: " + a.f361b + " (" + a.f360a + ")" + " - " + a.f362c);
                    c0350d = a;
                } catch (Throwable e22) {
                    th = e22;
                    c0350d = a;
                    th222 = th;
                    C3218c.m9728h().m9695e("Beta", "Error reading Beta build properties", th222);
                    if (open != null) {
                        open.close();
                    }
                    return c0350d;
                }
            }
            obj = inputStream;
            if (open != null) {
                try {
                    open.close();
                } catch (Throwable th2222) {
                    C3218c.m9728h().m9695e("Beta", "Error closing Beta build properties asset", th2222);
                }
            }
        } catch (Throwable e222) {
            open = inputStream;
            InputStream inputStream2 = inputStream;
            th2222 = e222;
            c0350d = inputStream2;
            C3218c.m9728h().m9695e("Beta", "Error reading Beta build properties", th2222);
            if (open != null) {
                open.close();
            }
            return c0350d;
        } catch (Throwable th4) {
            e222 = th4;
            open = inputStream;
            if (open != null) {
                open.close();
            }
            throw e222;
        }
        return c0350d;
    }

    String m428g() {
        return CommonUtils.m9863b(m402B(), "com.crashlytics.ApiEndpoint");
    }
}
