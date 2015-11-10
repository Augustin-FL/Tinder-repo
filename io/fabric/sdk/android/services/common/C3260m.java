package io.fabric.sdk.android.services.common;

import android.content.Context;
import com.facebook.stetho.BuildConfig;
import io.fabric.sdk.android.C3218c;
import io.fabric.sdk.android.services.p002a.C0355d;
import io.fabric.sdk.android.services.p002a.C3229b;

/* renamed from: io.fabric.sdk.android.services.common.m */
public class C3260m {
    private final C0355d<String> f7085a;
    private final C3229b<String> f7086b;

    /* renamed from: io.fabric.sdk.android.services.common.m.1 */
    class C32591 implements C0355d<String> {
        final /* synthetic */ C3260m f7084a;

        C32591(C3260m c3260m) {
            this.f7084a = c3260m;
        }

        public /* synthetic */ Object m9944c(Context context) throws Exception {
            return m9943a(context);
        }

        public String m9943a(Context context) throws Exception {
            String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
            return installerPackageName == null ? BuildConfig.FLAVOR : installerPackageName;
        }
    }

    public C3260m() {
        this.f7085a = new C32591(this);
        this.f7086b = new C3229b();
    }

    public String m9945a(Context context) {
        try {
            String str = (String) this.f7086b.m9797a(context, this.f7085a);
            if (BuildConfig.FLAVOR.equals(str)) {
                return null;
            }
            return str;
        } catch (Throwable e) {
            C3218c.m9728h().m9695e("Fabric", "Failed to determine installer package name", e);
            return null;
        }
    }
}
