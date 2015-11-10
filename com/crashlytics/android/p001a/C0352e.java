package com.crashlytics.android.p001a;

import com.facebook.share.internal.ShareConstants;
import io.fabric.sdk.android.C0347h;
import io.fabric.sdk.android.C3218c;
import io.fabric.sdk.android.services.common.C0351a;
import io.fabric.sdk.android.services.network.C3295c;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpHeaders;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

/* renamed from: com.crashlytics.android.a.e */
class C0352e extends C0351a {
    private final C0354g f370b;

    public C0352e(C0347h c0347h, String str, String str2, C3295c c3295c, C0354g c0354g) {
        super(c0347h, str, str2, c3295c, HttpMethod.GET);
        this.f370b = c0354g;
    }

    public C0353f m437a(String str, String str2, C0350d c0350d) {
        HttpRequest a;
        Throwable e;
        Throwable th;
        C0353f c0353f = null;
        try {
            Map a2 = m436a(c0350d);
            try {
                a = m435a(m432a(a2), str, str2);
                C3218c.m9728h().m9687a("Beta", "Checking for updates from " + m433a());
                C3218c.m9728h().m9687a("Beta", "Checking for updates query params are: " + a2);
                if (a.m10057c()) {
                    C3218c.m9728h().m9687a("Beta", "Checking for updates was successful");
                    c0353f = this.f370b.m438a(new JSONObject(a.m10062e()));
                    if (a != null) {
                        C3218c.m9728h().m9687a("Fabric", "Checking for updates request ID: " + a.m10053b("X-REQUEST-ID"));
                    }
                } else {
                    C3218c.m9728h().m9694e("Beta", "Checking for updates failed. Response code: " + a.m10051b());
                    if (a != null) {
                        C3218c.m9728h().m9687a("Fabric", "Checking for updates request ID: " + a.m10053b("X-REQUEST-ID"));
                    }
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    C3218c.m9728h().m9695e("Beta", "Error while checking for updates from " + m433a(), e);
                    if (a != null) {
                        C3218c.m9728h().m9687a("Fabric", "Checking for updates request ID: " + a.m10053b("X-REQUEST-ID"));
                    }
                    return c0353f;
                } catch (Throwable th2) {
                    th = th2;
                    if (a != null) {
                        C3218c.m9728h().m9687a("Fabric", "Checking for updates request ID: " + a.m10053b("X-REQUEST-ID"));
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
            C3218c.m9728h().m9695e("Beta", "Error while checking for updates from " + m433a(), e);
            if (a != null) {
                C3218c.m9728h().m9687a("Fabric", "Checking for updates request ID: " + a.m10053b("X-REQUEST-ID"));
            }
            return c0353f;
        } catch (Throwable e4) {
            a = null;
            th = e4;
            if (a != null) {
                C3218c.m9728h().m9687a("Fabric", "Checking for updates request ID: " + a.m10053b("X-REQUEST-ID"));
            }
            throw th;
        }
        return c0353f;
    }

    private HttpRequest m435a(HttpRequest httpRequest, String str, String str2) {
        return httpRequest.m10041a(HttpHeaders.ACCEPT, "application/json").m10041a(HTTP.USER_AGENT, "Crashlytics Android SDK/" + this.a.m408a()).m10041a("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa").m10041a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").m10041a("X-CRASHLYTICS-API-CLIENT-VERSION", this.a.m408a()).m10041a("X-CRASHLYTICS-API-KEY", str).m10041a("X-CRASHLYTICS-D", str2);
    }

    private Map<String, String> m436a(C0350d c0350d) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("build_version", c0350d.f360a);
        hashMap.put("display_version", c0350d.f361b);
        hashMap.put("instance", c0350d.f362c);
        hashMap.put(ShareConstants.FEED_SOURCE_PARAM, "3");
        return hashMap;
    }
}
