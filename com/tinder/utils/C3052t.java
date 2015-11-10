package com.tinder.utils;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.android.volley.AuthFailureError;
import com.android.volley.C0301g;
import com.android.volley.C0307i;
import com.android.volley.C0307i.C0305a;
import com.android.volley.C0307i.C0306b;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.C0324d;
import com.google.gson.stream.JsonReader;
import com.tinder.p029a.C2239e;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpHeaders;
import org.apache.http.protocol.HTTP;

/* renamed from: com.tinder.utils.t */
public abstract class C3052t<T> extends Request<T> {
    @NonNull
    protected final C0306b<T> f6558a;
    private final Map<String, String> f6559b;

    @NonNull
    public abstract T m9250a(JsonReader jsonReader) throws Exception;

    public C3052t(int i, @NonNull String str, @Nullable String str2, @NonNull C0306b<T> c0306b, @NonNull C0305a c0305a) {
        super(i, str, c0305a);
        this.f6559b = new HashMap(6);
        this.f6558a = c0306b;
        this.f6559b.put(HTTP.USER_AGENT, C2239e.f3684a);
        this.f6559b.put("os-version", C2239e.ad);
        this.f6559b.put("app-version", C2239e.ae);
        this.f6559b.put("platform", "android");
        this.f6559b.put(HttpHeaders.ACCEPT_LANGUAGE, C3093w.m9461a());
        if (str2 != null) {
            this.f6559b.put("X-Auth-Token", str2);
        }
    }

    @NonNull
    public Map<String, String> m9252i() throws AuthFailureError {
        return this.f6559b;
    }

    protected C0307i<T> m9249a(@NonNull C0301g c0301g) {
        JsonReader jsonReader;
        Throwable th;
        Object obj = null;
        try {
            jsonReader = new JsonReader(new InputStreamReader(new ByteArrayInputStream(c0301g.f244b), HTTP.UTF_8));
        } catch (Throwable e) {
            C3095y.m9474a("Failed to decode response data as UTF-8", e);
            jsonReader = null;
        }
        try {
            th = null;
            obj = m9250a(jsonReader);
        } catch (Exception e2) {
            th = e2;
        }
        if (jsonReader != null) {
            try {
                jsonReader.close();
            } catch (Throwable e3) {
                C3095y.m9474a("Failed to close reader.", e3);
            }
        }
        if (obj != null) {
            return C0307i.m281a(obj, C0324d.m328a(c0301g));
        }
        if (th != null) {
            return C0307i.m280a(new VolleyError(th));
        }
        return C0307i.m280a(new VolleyError("Unknown error"));
    }

    protected void m9251b(T t) {
        this.f6558a.m279a(t);
    }
}
