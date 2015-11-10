package io.fabric.sdk.android;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.facebook.appevents.AppEventsConstants;
import io.fabric.sdk.android.services.common.C3250g;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.DeliveryMechanism;
import io.fabric.sdk.android.services.network.C3295c;
import io.fabric.sdk.android.services.network.C3296b;
import io.fabric.sdk.android.services.settings.C3303d;
import io.fabric.sdk.android.services.settings.C3304e;
import io.fabric.sdk.android.services.settings.C3307h;
import io.fabric.sdk.android.services.settings.C3316n;
import io.fabric.sdk.android.services.settings.C3321q;
import io.fabric.sdk.android.services.settings.C3322s;
import io.fabric.sdk.android.services.settings.C3325x;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import org.apache.http.entity.mime.MIME;

/* renamed from: io.fabric.sdk.android.l */
class C3226l extends C0347h<Boolean> {
    private final C3295c f6989a;
    private PackageManager f6990b;
    private String f6991c;
    private PackageInfo f6992d;
    private String f6993j;
    private String f6994k;
    private String f6995l;
    private String f6996m;
    private String f6997n;
    private final Future<Map<String, C3225j>> f6998o;
    private final Collection<C0347h> f6999p;

    protected /* synthetic */ Object m9793f() {
        return m9791d();
    }

    public C3226l(Future<Map<String, C3225j>> future, Collection<C0347h> collection) {
        this.f6989a = new C3296b();
        this.f6998o = future;
        this.f6999p = collection;
    }

    public String m9788a() {
        return "1.3.6.79";
    }

    protected boolean a_() {
        try {
            this.f6995l = m401A().m9899h();
            this.f6990b = m402B().getPackageManager();
            this.f6991c = m402B().getPackageName();
            this.f6992d = this.f6990b.getPackageInfo(this.f6991c, 0);
            this.f6993j = Integer.toString(this.f6992d.versionCode);
            this.f6994k = this.f6992d.versionName == null ? "0.0" : this.f6992d.versionName;
            this.f6996m = this.f6990b.getApplicationLabel(m402B().getApplicationInfo()).toString();
            this.f6997n = Integer.toString(m402B().getApplicationInfo().targetSdkVersion);
            return true;
        } catch (Throwable e) {
            C3218c.m9728h().m9695e("Fabric", "Failed init", e);
            return false;
        }
    }

    protected Boolean m9791d() {
        boolean a;
        String k = CommonUtils.m9876k(m402B());
        C3322s g = m9787g();
        if (g != null) {
            try {
                Map map;
                if (this.f6998o != null) {
                    map = (Map) this.f6998o.get();
                } else {
                    map = new HashMap();
                }
                a = m9784a(k, g.f7248a, m9789a(map, this.f6999p).values());
            } catch (Throwable e) {
                C3218c.m9728h().m9695e("Fabric", "Error performing auto configuration.", e);
            }
            return Boolean.valueOf(a);
        }
        a = false;
        return Boolean.valueOf(a);
    }

    private C3322s m9787g() {
        try {
            C3321q.m10135a().m10137a(this, this.i, this.f6989a, this.f6993j, this.f6994k, m9792e()).m10140c();
            return C3321q.m10135a().m10139b();
        } catch (Throwable e) {
            C3218c.m9728h().m9695e("Fabric", "Error dealing with settings", e);
            return null;
        }
    }

    Map<String, C3225j> m9789a(Map<String, C3225j> map, Collection<C0347h> collection) {
        for (C0347h c0347h : collection) {
            if (!map.containsKey(c0347h.m411b())) {
                map.put(c0347h.m411b(), new C3225j(c0347h.m411b(), c0347h.m408a(), MIME.ENC_BINARY));
            }
        }
        return map;
    }

    public String m9790b() {
        return "io.fabric.sdk.android:fabric";
    }

    private boolean m9784a(String str, C3304e c3304e, Collection<C3225j> collection) {
        if ("new".equals(c3304e.f7207b)) {
            if (m9785b(str, c3304e, collection)) {
                return C3321q.m10135a().m10141d();
            }
            C3218c.m9728h().m9695e("Fabric", "Failed to create app with Crashlytics service.", null);
            return false;
        } else if ("configured".equals(c3304e.f7207b)) {
            return C3321q.m10135a().m10141d();
        } else {
            if (!c3304e.f7210e) {
                return true;
            }
            C3218c.m9728h().m9687a("Fabric", "Server says an update is required - forcing a full App update.");
            m9786c(str, c3304e, collection);
            return true;
        }
    }

    private boolean m9785b(String str, C3304e c3304e, Collection<C3225j> collection) {
        return new C3307h(this, m9792e(), c3304e.f7208c, this.f6989a).m10103a(m9782a(C3316n.m10133a(m402B(), str), (Collection) collection));
    }

    private boolean m9786c(String str, C3304e c3304e, Collection<C3225j> collection) {
        return m9783a(c3304e, C3316n.m10133a(m402B(), str), (Collection) collection);
    }

    private boolean m9783a(C3304e c3304e, C3316n c3316n, Collection<C3225j> collection) {
        return new C3325x(this, m9792e(), c3304e.f7208c, this.f6989a).m10143a(m9782a(c3316n, (Collection) collection));
    }

    private C3303d m9782a(C3316n c3316n, Collection<C3225j> collection) {
        return new C3303d(new C3250g().m9930a(m402B()), m401A().m9894c(), this.f6994k, this.f6993j, CommonUtils.m9849a(CommonUtils.m9878m(r0)), this.f6996m, DeliveryMechanism.m9880a(this.f6995l).m9881a(), this.f6997n, AppEventsConstants.EVENT_PARAM_VALUE_NO, c3316n, collection);
    }

    String m9792e() {
        return CommonUtils.m9863b(m402B(), "com.crashlytics.ApiEndpoint");
    }
}
