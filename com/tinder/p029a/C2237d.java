package com.tinder.p029a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.android.volley.AuthFailureError;
import com.android.volley.C0304h;
import com.android.volley.C0307i.C0305a;
import com.android.volley.C0307i.C0306b;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.C0337j;
import com.tinder.utils.C3093w;
import com.tinder.utils.C3095y;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpHeaders;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

/* renamed from: com.tinder.a.d */
public class C2237d extends C0337j {
    private final Map<String, String> f3656a;

    public C2237d(int i, String str, JSONObject jSONObject, C0306b<JSONObject> c0306b, C0305a c0305a, @Nullable String str2) {
        super(i, str, jSONObject, c0306b, c0305a);
        this.f3656a = new HashMap();
        C3095y.m9471a("url=" + str);
        C3095y.m9471a("jsonObject=" + jSONObject);
        C3095y.m9471a("token=" + str2);
        this.f3656a.put(HTTP.USER_AGENT, C2239e.f3684a);
        this.f3656a.put("os-version", C2239e.ad);
        this.f3656a.put("app-version", C2239e.ae);
        this.f3656a.put("platform", "android");
        this.f3656a.put(HttpHeaders.ACCEPT_LANGUAGE, C3093w.m9461a());
        if (str2 != null) {
            this.f3656a.put("X-Auth-Token", str2);
        }
    }

    @NonNull
    public void m5896a(C0304h c0304h) {
        super.m218a(c0304h);
    }

    public Map<String, String> m5898i() throws AuthFailureError {
        return this.f3656a;
    }

    public void m5897b(VolleyError volleyError) {
        super.m224b(volleyError);
    }
}
