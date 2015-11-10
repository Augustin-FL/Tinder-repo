package io.fabric.sdk.android.services.settings;

import android.annotation.SuppressLint;
import android.content.SharedPreferences.Editor;
import com.facebook.stetho.BuildConfig;
import io.fabric.sdk.android.C0347h;
import io.fabric.sdk.android.C3218c;
import io.fabric.sdk.android.services.common.C3254j;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.p035c.C3238c;
import io.fabric.sdk.android.services.p035c.C3239d;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: io.fabric.sdk.android.services.settings.j */
class C3310j implements C3309r {
    private final C3324v f7215a;
    private final C3311u f7216b;
    private final C3254j f7217c;
    private final C3306g f7218d;
    private final C3313w f7219e;
    private final C0347h f7220f;
    private final C3238c f7221g;

    public C3310j(C0347h c0347h, C3324v c3324v, C3254j c3254j, C3311u c3311u, C3306g c3306g, C3313w c3313w) {
        this.f7220f = c0347h;
        this.f7215a = c3324v;
        this.f7217c = c3254j;
        this.f7216b = c3311u;
        this.f7218d = c3306g;
        this.f7219e = c3313w;
        this.f7221g = new C3239d(this.f7220f);
    }

    public C3322s m10110a() {
        return m10111a(SettingsCacheBehavior.USE_CACHE);
    }

    public C3322s m10111a(SettingsCacheBehavior settingsCacheBehavior) {
        Throwable th;
        C3322s c3322s;
        Throwable th2;
        C3322s c3322s2 = null;
        try {
            if (!(C3218c.m9729i() || m10115d())) {
                c3322s2 = m10109b(settingsCacheBehavior);
            }
            if (c3322s2 == null) {
                try {
                    JSONObject a = this.f7219e.m10126a(this.f7215a);
                    if (a != null) {
                        c3322s2 = this.f7216b.m10116a(this.f7217c, a);
                        this.f7218d.m10102a(c3322s2.f7254g, a);
                        m10108a(a, "Loaded settings: ");
                        m10112a(m10113b());
                    }
                } catch (Throwable e) {
                    th = e;
                    c3322s = c3322s2;
                    th2 = th;
                    C3218c.m9728h().m9695e("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", th2);
                    return c3322s;
                }
            }
            c3322s = c3322s2;
            if (c3322s == null) {
                try {
                    c3322s = m10109b(SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION);
                } catch (Exception e2) {
                    th2 = e2;
                    C3218c.m9728h().m9695e("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", th2);
                    return c3322s;
                }
            }
        } catch (Throwable e3) {
            th = e3;
            c3322s = null;
            th2 = th;
            C3218c.m9728h().m9695e("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", th2);
            return c3322s;
        }
        return c3322s;
    }

    private C3322s m10109b(SettingsCacheBehavior settingsCacheBehavior) {
        Throwable th;
        C3322s c3322s = null;
        try {
            if (SettingsCacheBehavior.SKIP_CACHE_LOOKUP.equals(settingsCacheBehavior)) {
                return null;
            }
            JSONObject a = this.f7218d.m10101a();
            if (a != null) {
                C3322s a2 = this.f7216b.m10116a(this.f7217c, a);
                if (a2 != null) {
                    m10108a(a, "Loaded cached settings: ");
                    long a3 = this.f7217c.m9935a();
                    if (SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION.equals(settingsCacheBehavior) || !a2.m10142a(a3)) {
                        try {
                            C3218c.m9728h().m9687a("Fabric", "Returning cached settings.");
                            return a2;
                        } catch (Throwable e) {
                            Throwable th2 = e;
                            c3322s = a2;
                            th = th2;
                            C3218c.m9728h().m9695e("Fabric", "Failed to get cached settings", th);
                            return c3322s;
                        }
                    }
                    C3218c.m9728h().m9687a("Fabric", "Cached settings have expired.");
                    return null;
                }
                C3218c.m9728h().m9695e("Fabric", "Failed to transform cached settings data.", null);
                return null;
            }
            C3218c.m9728h().m9687a("Fabric", "No cached settings data found.");
            return null;
        } catch (Exception e2) {
            th = e2;
            C3218c.m9728h().m9695e("Fabric", "Failed to get cached settings", th);
            return c3322s;
        }
    }

    private void m10108a(JSONObject jSONObject, String str) throws JSONException {
        C3218c.m9728h().m9687a("Fabric", str + jSONObject.toString());
    }

    String m10113b() {
        return CommonUtils.m9849a(CommonUtils.m9878m(this.f7220f.m402B()));
    }

    String m10114c() {
        return this.f7221g.m9827a().getString("existing_instance_identifier", BuildConfig.FLAVOR);
    }

    @SuppressLint({"CommitPrefEdits"})
    boolean m10112a(String str) {
        Editor b = this.f7221g.m9829b();
        b.putString("existing_instance_identifier", str);
        return this.f7221g.m9828a(b);
    }

    boolean m10115d() {
        return !m10114c().equals(m10113b());
    }
}
