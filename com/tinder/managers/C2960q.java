package com.tinder.managers;

import android.text.TextUtils;
import com.android.volley.C0294c;
import com.android.volley.C0307i.C0306b;
import com.android.volley.Request;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.search.SearchAuth.StatusCodes;
import com.tinder.p029a.C2237d;
import com.tinder.p029a.C2239e;
import com.tinder.utils.C3071j;
import com.tinder.utils.C3095y;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tinder.managers.q */
public class C2960q {

    /* renamed from: com.tinder.managers.q.1 */
    static class C29591 implements C0306b<JSONObject> {
        C29591() {
        }

        public void m8888a(JSONObject jSONObject) {
            C3095y.m9471a("Feedback success " + jSONObject.toString());
        }
    }

    public static void m8889a(String str, int i) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) {
            C3095y.m9479c("Feedback body is empty after trim. NO OP");
            return;
        }
        String trim = str.trim();
        String d = C3071j.m9374d();
        String e = C3071j.m9375e();
        String c = C3071j.m9373c();
        String f = C3071j.m9376f();
        String y = ManagerApp.m7934y();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_DESCRIPTION, trim);
            jSONObject.put("model", d);
            jSONObject.put("dataProvider", e);
            jSONObject.put("manufacturer", c);
            jSONObject.put("osVersion", f);
            jSONObject.put("tiVersion", y);
            if (i > 0) {
                jSONObject.put("stars", i);
            }
            C3095y.m9471a("Sending feedback request");
            Request c2237d = new C2237d(1, C2239e.f3682Y, jSONObject, new C29591(), null, C2821b.m8123b());
            c2237d.m219a(new C0294c(StatusCodes.AUTH_DISABLED, 3, 3.0f));
            ManagerApp.m7915f().m5900a(c2237d);
        } catch (JSONException e2) {
            C3095y.m9479c(e2.toString());
        }
    }
}
