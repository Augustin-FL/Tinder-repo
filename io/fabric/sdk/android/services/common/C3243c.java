package io.fabric.sdk.android.services.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.facebook.stetho.BuildConfig;
import io.fabric.sdk.android.C3218c;
import io.fabric.sdk.android.services.p035c.C3238c;
import io.fabric.sdk.android.services.p035c.C3239d;

/* renamed from: io.fabric.sdk.android.services.common.c */
class C3243c {
    private final Context f7068a;
    private final C3238c f7069b;

    /* renamed from: io.fabric.sdk.android.services.common.c.1 */
    class C32421 extends C0478h {
        final /* synthetic */ C3241b f7066a;
        final /* synthetic */ C3243c f7067b;

        C32421(C3243c c3243c, C3241b c3241b) {
            this.f7067b = c3243c;
            this.f7066a = c3241b;
        }

        public void m9908a() {
            C3241b a = this.f7067b.m9914e();
            if (!this.f7066a.equals(a)) {
                C3218c.m9728h().m9687a("Fabric", "Asychronously getting Advertising Info and storing it to preferences");
                this.f7067b.m9912b(a);
            }
        }
    }

    public C3243c(Context context) {
        this.f7068a = context.getApplicationContext();
        this.f7069b = new C3239d(context, "TwitterAdvertisingInfoPreferences");
    }

    public C3241b m9915a() {
        C3241b b = m9916b();
        if (m9913c(b)) {
            C3218c.m9728h().m9687a("Fabric", "Using AdvertisingInfo from Preference Store");
            m9910a(b);
            return b;
        }
        b = m9914e();
        m9912b(b);
        return b;
    }

    private void m9910a(C3241b c3241b) {
        new Thread(new C32421(this, c3241b)).start();
    }

    @SuppressLint({"CommitPrefEdits"})
    private void m9912b(C3241b c3241b) {
        if (m9913c(c3241b)) {
            this.f7069b.m9828a(this.f7069b.m9829b().putString("advertising_id", c3241b.f7064a).putBoolean("limit_ad_tracking_enabled", c3241b.f7065b));
        } else {
            this.f7069b.m9828a(this.f7069b.m9829b().remove("advertising_id").remove("limit_ad_tracking_enabled"));
        }
    }

    protected C3241b m9916b() {
        return new C3241b(this.f7069b.m9827a().getString("advertising_id", BuildConfig.FLAVOR), this.f7069b.m9827a().getBoolean("limit_ad_tracking_enabled", false));
    }

    public C3244f m9917c() {
        return new C3245d(this.f7068a);
    }

    public C3244f m9918d() {
        return new C3249e(this.f7068a);
    }

    private boolean m9913c(C3241b c3241b) {
        return (c3241b == null || TextUtils.isEmpty(c3241b.f7064a)) ? false : true;
    }

    private C3241b m9914e() {
        C3241b a = m9917c().m9919a();
        if (m9913c(a)) {
            C3218c.m9728h().m9687a("Fabric", "Using AdvertisingInfo from Reflection Provider");
        } else {
            a = m9918d().m9919a();
            if (m9913c(a)) {
                C3218c.m9728h().m9687a("Fabric", "Using AdvertisingInfo from Service Provider");
            } else {
                C3218c.m9728h().m9687a("Fabric", "AdvertisingInfo not present");
            }
        }
        return a;
    }
}
