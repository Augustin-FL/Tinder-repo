package io.fabric.sdk.android.services.settings;

import io.fabric.sdk.android.C0347h;
import io.fabric.sdk.android.C3218c;
import io.fabric.sdk.android.C3225j;
import io.fabric.sdk.android.services.common.C0351a;
import io.fabric.sdk.android.services.common.C3265o;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.network.C3295c;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Locale;
import org.apache.http.protocol.HTTP;

/* renamed from: io.fabric.sdk.android.services.settings.a */
abstract class C3300a extends C0351a {
    public C3300a(C0347h c0347h, String str, String str2, C3295c c3295c, HttpMethod httpMethod) {
        super(c0347h, str, str2, c3295c, httpMethod);
    }

    public boolean m10099a(C3303d c3303d) {
        HttpRequest b = m10097b(m10096a(m434b(), c3303d), c3303d);
        C3218c.m9728h().m9687a("Fabric", "Sending app info to " + m433a());
        if (c3303d.f7204j != null) {
            C3218c.m9728h().m9687a("Fabric", "App icon hash is " + c3303d.f7204j.f7226a);
            C3218c.m9728h().m9687a("Fabric", "App icon size is " + c3303d.f7204j.f7228c + "x" + c3303d.f7204j.f7229d);
        }
        int b2 = b.m10051b();
        C3218c.m9728h().m9687a("Fabric", ("POST".equals(b.m10075p()) ? "Create" : "Update") + " app request ID: " + b.m10053b("X-REQUEST-ID"));
        C3218c.m9728h().m9687a("Fabric", "Result was " + b2);
        if (C3265o.m9974a(b2) == 0) {
            return true;
        }
        return false;
    }

    private HttpRequest m10096a(HttpRequest httpRequest, C3303d c3303d) {
        return httpRequest.m10041a("X-CRASHLYTICS-API-KEY", c3303d.f7195a).m10041a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").m10041a("X-CRASHLYTICS-API-CLIENT-VERSION", this.a.m408a());
    }

    private HttpRequest m10097b(HttpRequest httpRequest, C3303d c3303d) {
        HttpRequest e = httpRequest.m10061e("app[identifier]", c3303d.f7196b).m10061e("app[name]", c3303d.f7200f).m10061e("app[display_version]", c3303d.f7197c).m10061e("app[build_version]", c3303d.f7198d).m10040a("app[source]", Integer.valueOf(c3303d.f7201g)).m10061e("app[minimum_sdk_version]", c3303d.f7202h).m10061e("app[built_sdk_version]", c3303d.f7203i);
        if (!CommonUtils.m9868c(c3303d.f7199e)) {
            e.m10061e("app[instance_identifier]", c3303d.f7199e);
        }
        if (c3303d.f7204j != null) {
            Closeable closeable = null;
            try {
                closeable = this.a.m402B().getResources().openRawResource(c3303d.f7204j.f7227b);
                e.m10061e("app[icon][hash]", c3303d.f7204j.f7226a).m10045a("app[icon][data]", "icon.png", HTTP.OCTET_STREAM_TYPE, (InputStream) closeable).m10040a("app[icon][width]", Integer.valueOf(c3303d.f7204j.f7228c)).m10040a("app[icon][height]", Integer.valueOf(c3303d.f7204j.f7229d));
            } catch (Throwable e2) {
                C3218c.m9728h().m9695e("Fabric", "Failed to find app icon with resource ID: " + c3303d.f7204j.f7227b, e2);
            } finally {
                String str = "Failed to close app icon InputStream.";
                CommonUtils.m9855a(closeable, str);
            }
        }
        if (c3303d.f7205k != null) {
            for (C3225j c3225j : c3303d.f7205k) {
                e.m10061e(m10098a(c3225j), c3225j.m9780b());
                e.m10061e(m10100b(c3225j), c3225j.m9781c());
            }
        }
        return e;
    }

    String m10098a(C3225j c3225j) {
        return String.format(Locale.US, "app[build][libraries][%s][version]", new Object[]{c3225j.m9779a()});
    }

    String m10100b(C3225j c3225j) {
        return String.format(Locale.US, "app[build][libraries][%s][type]", new Object[]{c3225j.m9779a()});
    }
}
