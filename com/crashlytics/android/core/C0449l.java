package com.crashlytics.android.core;

import io.fabric.sdk.android.C0347h;
import io.fabric.sdk.android.C3218c;
import io.fabric.sdk.android.services.common.C0351a;
import io.fabric.sdk.android.services.common.C3265o;
import io.fabric.sdk.android.services.network.C3295c;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.Map.Entry;
import org.apache.http.protocol.HTTP;

/* renamed from: com.crashlytics.android.core.l */
class C0449l extends C0351a implements C0448k {
    public C0449l(C0347h c0347h, String str, String str2, C3295c c3295c) {
        super(c0347h, str, str2, c3295c, HttpMethod.POST);
    }

    public boolean m785a(C0447j c0447j) {
        HttpRequest b = m784b(m783a(m434b(), c0447j), c0447j);
        C3218c.m9728h().m9687a("CrashlyticsCore", "Sending report to: " + m433a());
        int b2 = b.m10051b();
        C3218c.m9728h().m9687a("CrashlyticsCore", "Create report request ID: " + b.m10053b("X-REQUEST-ID"));
        C3218c.m9728h().m9687a("CrashlyticsCore", "Result was: " + b2);
        return C3265o.m9974a(b2) == 0;
    }

    private HttpRequest m783a(HttpRequest httpRequest, C0447j c0447j) {
        HttpRequest a = httpRequest.m10041a("X-CRASHLYTICS-API-KEY", c0447j.f627a).m10041a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").m10041a("X-CRASHLYTICS-API-CLIENT-VERSION", C0427e.m671e().m677a());
        HttpRequest httpRequest2 = a;
        for (Entry a2 : c0447j.f628b.m874e().entrySet()) {
            httpRequest2 = httpRequest2.m10047a(a2);
        }
        return httpRequest2;
    }

    private HttpRequest m784b(HttpRequest httpRequest, C0447j c0447j) {
        C0476u c0476u = c0447j.f628b;
        return httpRequest.m10044a("report[file]", c0476u.m871b(), HTTP.OCTET_STREAM_TYPE, c0476u.m873d()).m10061e("report[identifier]", c0476u.m872c());
    }
}
