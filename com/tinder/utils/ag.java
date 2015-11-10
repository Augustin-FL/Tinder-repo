package com.tinder.utils;

import com.android.volley.C0307i.C0305a;
import com.android.volley.C0307i.C0306b;
import com.android.volley.Request.Priority;
import com.tinder.p029a.C2237d;
import org.json.JSONObject;

public class ag extends C2237d {
    private Priority f6532a;

    public ag(Priority priority, int i, String str, JSONObject jSONObject, C0306b<JSONObject> c0306b, C0305a c0305a, String str2) {
        super(i, str, jSONObject, c0306b, c0305a, str2);
        this.f6532a = priority;
    }

    public Priority m9234s() {
        if (this.f6532a == null) {
            return super.m243s();
        }
        return this.f6532a;
    }
}
