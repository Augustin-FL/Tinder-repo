package com.tinder.p029a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.android.volley.AuthFailureError;
import com.android.volley.C0307i.C0305a;
import com.android.volley.C0307i.C0306b;
import com.android.volley.toolbox.C0336i;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tinder.a.c */
public class C2236c extends C0336i {
    private final Map<String, String> f3655a;

    public C2236c(int i, String str, JSONObject jSONObject, C0306b<JSONArray> c0306b, C0305a c0305a, String str2) {
        super(i, str, c0306b, jSONObject, c0305a);
        this.f3655a = new HashMap();
        m5894c(str2);
    }

    public C2236c(String str, C0306b<JSONArray> c0306b, C0305a c0305a, String str2) {
        super(str, c0306b, c0305a);
        this.f3655a = new HashMap();
        m5894c(str2);
    }

    private void m5894c(@Nullable String str) {
        this.f3655a.put(HTTP.USER_AGENT, C2239e.f3684a);
        this.f3655a.put("os-version", C2239e.ad);
        this.f3655a.put("app-version", C2239e.ae);
        this.f3655a.put("platform", "android");
        if (str != null) {
            this.f3655a.put("X-Auth-Token", str);
        }
    }

    @NonNull
    public Map<String, String> m5895i() throws AuthFailureError {
        return this.f3655a;
    }
}
