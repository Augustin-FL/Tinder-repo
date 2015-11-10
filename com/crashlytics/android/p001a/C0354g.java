package com.crashlytics.android.p001a;

import com.facebook.internal.NativeProtocol;
import java.io.IOException;
import org.json.JSONObject;

/* renamed from: com.crashlytics.android.a.g */
class C0354g {
    C0354g() {
    }

    public C0353f m438a(JSONObject jSONObject) throws IOException {
        if (jSONObject == null) {
            return null;
        }
        return new C0353f(jSONObject.optString(NativeProtocol.WEB_DIALOG_URL, null), jSONObject.optString("version_string", null), jSONObject.optString("display_version", null), jSONObject.optString("build_version", null), jSONObject.optString("identifier", null), jSONObject.optString("instance_identifier", null));
    }
}
