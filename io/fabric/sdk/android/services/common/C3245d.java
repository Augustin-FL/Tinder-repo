package io.fabric.sdk.android.services.common;

import android.content.Context;
import io.fabric.sdk.android.C3218c;

/* renamed from: io.fabric.sdk.android.services.common.d */
class C3245d implements C3244f {
    private final Context f7070a;

    public C3245d(Context context) {
        this.f7070a = context.getApplicationContext();
    }

    boolean m9924a(Context context) {
        try {
            if (((Integer) Class.forName("com.google.android.gms.common.GooglePlayServicesUtil").getMethod("isGooglePlayServicesAvailable", new Class[]{Context.class}).invoke(null, new Object[]{context})).intValue() == 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public C3241b m9923a() {
        if (m9924a(this.f7070a)) {
            return new C3241b(m9920b(), m9921c());
        }
        return null;
    }

    private String m9920b() {
        try {
            return (String) Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("getId", new Class[0]).invoke(m9922d(), new Object[0]);
        } catch (Exception e) {
            C3218c.m9728h().m9692d("Fabric", "Could not call getId on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            return null;
        }
    }

    private boolean m9921c() {
        try {
            return ((Boolean) Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(m9922d(), new Object[0])).booleanValue();
        } catch (Exception e) {
            C3218c.m9728h().m9692d("Fabric", "Could not call isLimitAdTrackingEnabled on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            return false;
        }
    }

    private Object m9922d() {
        Object obj = null;
        try {
            obj = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", new Class[]{Context.class}).invoke(null, new Object[]{this.f7070a});
        } catch (Exception e) {
            C3218c.m9728h().m9692d("Fabric", "Could not call getAdvertisingIdInfo on com.google.android.gms.ads.identifier.AdvertisingIdClient");
        }
        return obj;
    }
}
