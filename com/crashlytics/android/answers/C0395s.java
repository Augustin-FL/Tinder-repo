package com.crashlytics.android.answers;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import io.fabric.sdk.android.services.p003b.C0394c;
import java.io.IOException;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

/* renamed from: com.crashlytics.android.answers.s */
class C0395s implements C0394c<SessionEvent> {
    C0395s() {
    }

    public byte[] m562a(SessionEvent sessionEvent) throws IOException {
        return m564b(sessionEvent).toString().getBytes(HTTP.UTF_8);
    }

    @TargetApi(9)
    public JSONObject m564b(SessionEvent sessionEvent) throws IOException {
        try {
            JSONObject jSONObject = new JSONObject();
            C0393r c0393r = sessionEvent.f401a;
            jSONObject.put("appBundleId", c0393r.f468a);
            jSONObject.put("executionId", c0393r.f469b);
            jSONObject.put("installationId", c0393r.f470c);
            jSONObject.put("androidId", c0393r.f471d);
            jSONObject.put("advertisingId", c0393r.f472e);
            jSONObject.put("limitAdTrackingEnabled", c0393r.f473f);
            jSONObject.put("betaDeviceToken", c0393r.f474g);
            jSONObject.put("buildId", c0393r.f475h);
            jSONObject.put("osVersion", c0393r.f476i);
            jSONObject.put("deviceModel", c0393r.f477j);
            jSONObject.put("appVersionCode", c0393r.f478k);
            jSONObject.put("appVersionName", c0393r.f479l);
            jSONObject.put("timestamp", sessionEvent.f402b);
            jSONObject.put("type", sessionEvent.f403c.toString());
            jSONObject.put("details", new JSONObject(sessionEvent.f404d));
            jSONObject.put("customType", sessionEvent.f405e);
            jSONObject.put("customAttributes", new JSONObject(sessionEvent.f406f));
            jSONObject.put("predefinedType", sessionEvent.f407g);
            jSONObject.put("predefinedAttributes", new JSONObject(sessionEvent.f408h));
            return jSONObject;
        } catch (Throwable e) {
            if (VERSION.SDK_INT >= 9) {
                throw new IOException(e.getMessage(), e);
            }
            throw new IOException(e.getMessage());
        }
    }
}
