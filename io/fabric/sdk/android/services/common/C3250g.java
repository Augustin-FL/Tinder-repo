package io.fabric.sdk.android.services.common;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import io.fabric.sdk.android.C3218c;

/* renamed from: io.fabric.sdk.android.services.common.g */
public class C3250g {
    public String m9930a(Context context) {
        Object b = m9931b(context);
        if (TextUtils.isEmpty(b)) {
            b = m9932c(context);
        }
        if (TextUtils.isEmpty(b)) {
            m9933d(context);
        }
        return b;
    }

    protected String m9931b(Context context) {
        String str = null;
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS).metaData;
            if (bundle != null) {
                str = bundle.getString("io.fabric.ApiKey");
                if (str == null) {
                    C3218c.m9728h().m9687a("Fabric", "Falling back to Crashlytics key lookup from Manifest");
                    str = bundle.getString("com.crashlytics.ApiKey");
                }
            }
        } catch (Exception e) {
            C3218c.m9728h().m9687a("Fabric", "Caught non-fatal exception while retrieving apiKey: " + e);
        }
        return str;
    }

    protected String m9932c(Context context) {
        int a = CommonUtils.m9836a(context, "io.fabric.ApiKey", "string");
        if (a == 0) {
            C3218c.m9728h().m9687a("Fabric", "Falling back to Crashlytics key lookup from Strings");
            a = CommonUtils.m9836a(context, "com.crashlytics.ApiKey", "string");
        }
        if (a != 0) {
            return context.getResources().getString(a);
        }
        return null;
    }

    protected void m9933d(Context context) {
        if (C3218c.m9729i() || CommonUtils.m9874i(context)) {
            throw new IllegalArgumentException(m9929a());
        }
        C3218c.m9728h().m9694e("Fabric", m9929a());
    }

    protected String m9929a() {
        return "Fabric could not be initialized, API key missing from AndroidManifest.xml. Add the following tag to your Application element \n\t<meta-data android:name=\"io.fabric.ApiKey\" android:value=\"YOUR_API_KEY\"/>";
    }
}
