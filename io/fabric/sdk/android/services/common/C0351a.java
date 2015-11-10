package io.fabric.sdk.android.services.common;

import com.google.android.gms.search.SearchAuth.StatusCodes;
import io.fabric.sdk.android.C0347h;
import io.fabric.sdk.android.services.network.C3295c;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.http.protocol.HTTP;

/* renamed from: io.fabric.sdk.android.services.common.a */
public abstract class C0351a {
    private static final Pattern f364b;
    protected final C0347h f365a;
    private final String f366c;
    private final C3295c f367d;
    private final HttpMethod f368e;
    private final String f369f;

    static {
        f364b = Pattern.compile("http(s?)://[^\\/]+", 2);
    }

    public C0351a(C0347h c0347h, String str, String str2, C3295c c3295c, HttpMethod httpMethod) {
        if (str2 == null) {
            throw new IllegalArgumentException("url must not be null.");
        } else if (c3295c == null) {
            throw new IllegalArgumentException("requestFactory must not be null.");
        } else {
            this.f365a = c0347h;
            this.f369f = str;
            this.f366c = m431a(str2);
            this.f367d = c3295c;
            this.f368e = httpMethod;
        }
    }

    protected String m433a() {
        return this.f366c;
    }

    protected HttpRequest m434b() {
        return m432a(Collections.emptyMap());
    }

    protected HttpRequest m432a(Map<String, String> map) {
        return this.f367d.m10078a(this.f368e, m433a(), map).m10048a(false).m10038a((int) StatusCodes.AUTH_DISABLED).m10041a(HTTP.USER_AGENT, "Crashlytics Android SDK/" + this.f365a.m408a()).m10041a("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
    }

    private String m431a(String str) {
        if (CommonUtils.m9868c(this.f369f)) {
            return str;
        }
        return f364b.matcher(str).replaceFirst(this.f369f);
    }
}
