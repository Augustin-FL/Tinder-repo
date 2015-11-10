package io.fabric.sdk.android.services.settings;

import com.facebook.share.internal.ShareConstants;
import io.fabric.sdk.android.C0347h;
import io.fabric.sdk.android.C3218c;
import io.fabric.sdk.android.services.common.C0351a;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.network.C3295c;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.json.JSONObject;

/* renamed from: io.fabric.sdk.android.services.settings.l */
class C3314l extends C0351a implements C3313w {
    public C3314l(C0347h c0347h, String str, String str2, C3295c c3295c) {
        this(c0347h, str, str2, c3295c, HttpMethod.GET);
    }

    C3314l(C0347h c0347h, String str, String str2, C3295c c3295c, HttpMethod httpMethod) {
        super(c0347h, str, str2, c3295c, httpMethod);
    }

    public JSONObject m10131a(C3324v c3324v) {
        HttpRequest httpRequest = null;
        try {
            Map b = m10129b(c3324v);
            httpRequest = m10127a(m432a(b), c3324v);
            C3218c.m9728h().m9687a("Fabric", "Requesting settings from " + m433a());
            C3218c.m9728h().m9687a("Fabric", "Settings query params were: " + b);
            JSONObject a = m10130a(httpRequest);
            return a;
        } finally {
            if (httpRequest != null) {
                C3218c.m9728h().m9687a("Fabric", "Settings request ID: " + httpRequest.m10053b("X-REQUEST-ID"));
            }
        }
    }

    JSONObject m10130a(HttpRequest httpRequest) {
        int b = httpRequest.m10051b();
        C3218c.m9728h().m9687a("Fabric", "Settings result was: " + b);
        if (m10132a(b)) {
            return m10128a(httpRequest.m10062e());
        }
        C3218c.m9728h().m9694e("Fabric", "Failed to retrieve settings from " + m433a());
        return null;
    }

    boolean m10132a(int i) {
        return i == HttpStatus.SC_OK || i == HttpStatus.SC_CREATED || i == HttpStatus.SC_ACCEPTED || i == HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION;
    }

    private JSONObject m10128a(String str) {
        try {
            return new JSONObject(str);
        } catch (Throwable e) {
            C3218c.m9728h().m9688a("Fabric", "Failed to parse settings JSON from " + m433a(), e);
            C3218c.m9728h().m9687a("Fabric", "Settings response " + str);
            return null;
        }
    }

    private Map<String, String> m10129b(C3324v c3324v) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("build_version", c3324v.f7262e);
        hashMap.put("display_version", c3324v.f7261d);
        hashMap.put(ShareConstants.FEED_SOURCE_PARAM, Integer.toString(c3324v.f7263f));
        if (c3324v.f7264g != null) {
            hashMap.put("icon_hash", c3324v.f7264g);
        }
        String str = c3324v.f7260c;
        if (!CommonUtils.m9868c(str)) {
            hashMap.put("instance", str);
        }
        return hashMap;
    }

    private HttpRequest m10127a(HttpRequest httpRequest, C3324v c3324v) {
        return httpRequest.m10041a("X-CRASHLYTICS-API-KEY", c3324v.f7258a).m10041a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").m10041a("X-CRASHLYTICS-D", c3324v.f7259b).m10041a("X-CRASHLYTICS-API-CLIENT-VERSION", this.a.m408a()).m10041a(HttpHeaders.ACCEPT, "application/json");
    }
}
