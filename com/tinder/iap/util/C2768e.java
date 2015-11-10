package com.tinder.iap.util;

import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tinder.iap.util.e */
public class C2768e {
    String f5550a;
    String f5551b;
    String f5552c;
    String f5553d;
    long f5554e;
    int f5555f;
    String f5556g;
    String f5557h;
    String f5558i;
    String f5559j;

    public C2768e(String str, String str2, String str3) throws JSONException {
        this.f5550a = str;
        this.f5558i = str2;
        JSONObject jSONObject = new JSONObject(this.f5558i);
        this.f5551b = jSONObject.optString("orderId");
        this.f5552c = jSONObject.optString("packageName");
        this.f5553d = jSONObject.optString("productId");
        this.f5554e = jSONObject.optLong("purchaseTime");
        this.f5555f = jSONObject.optInt("purchaseState");
        this.f5556g = jSONObject.optString("developerPayload");
        this.f5557h = jSONObject.optString("token", jSONObject.optString("purchaseToken"));
        this.f5559j = str3;
    }

    public String m7878a() {
        return this.f5550a;
    }

    public String m7879b() {
        return this.f5553d;
    }

    public String m7880c() {
        return this.f5557h;
    }

    public String m7881d() {
        return this.f5558i;
    }

    public String m7882e() {
        return this.f5559j;
    }

    @NonNull
    public String toString() {
        return "PurchaseInfo(type:" + this.f5550a + "):" + this.f5558i;
    }
}
