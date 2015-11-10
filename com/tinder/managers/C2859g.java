package com.tinder.managers;

import android.support.annotation.NonNull;
import com.android.volley.C0294c;
import com.android.volley.C0307i.C0305a;
import com.android.volley.C0307i.C0306b;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.crashlytics.android.C0359a;
import com.facebook.share.internal.ShareConstants;
import com.tinder.model.Message;
import com.tinder.p029a.C2237d;
import com.tinder.p029a.C2239e;
import com.tinder.p030d.C2438x;
import com.tinder.p030d.ag;
import com.tinder.p031b.C2393f;
import com.tinder.utils.C3070i;
import com.tinder.utils.C3095y;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tinder.managers.g */
public class C2859g {
    private static C2393f f5877a;

    /* renamed from: com.tinder.managers.g.1 */
    static class C28561 implements C0306b<JSONObject> {
        final /* synthetic */ Message f5872a;
        final /* synthetic */ ag f5873b;

        C28561(Message message, ag agVar) {
            this.f5872a = message;
            this.f5873b = agVar;
        }

        public void m8298a(@NonNull JSONObject jSONObject) {
            C3095y.m9471a("jsonObjectResponse=" + jSONObject);
            try {
                Message a = C2859g.m8303a(jSONObject, this.f5872a.getMatchId());
                C2859g.f5877a.m6518b(a);
                ManagerApp.m7925p().m8271a(a);
                this.f5873b.m6647a(this.f5872a, a);
            } catch (Exception e) {
                C3095y.m9479c("matches error: " + e + ", " + e.getMessage());
                C0359a.m446a(e.toString());
                this.f5873b.m6648b(this.f5872a);
            }
        }
    }

    /* renamed from: com.tinder.managers.g.2 */
    static class C28582 implements C0305a {
        final /* synthetic */ ag f5875a;
        final /* synthetic */ Message f5876b;

        /* renamed from: com.tinder.managers.g.2.1 */
        class C28571 implements C2438x {
            final /* synthetic */ C28582 f5874a;

            C28571(C28582 c28582) {
                this.f5874a = c28582;
            }

            public void m8299a() {
                C3095y.m9469a();
            }

            public void m8300b() {
                C3095y.m9469a();
            }

            public void m8301c() {
                C3095y.m9469a();
            }
        }

        C28582(ag agVar, Message message) {
            this.f5875a = agVar;
            this.f5876b = message;
        }

        public void onErrorResponse(@NonNull VolleyError volleyError) {
            C3095y.m9479c("error sending message: " + volleyError + ", " + volleyError.getMessage());
            ManagerApp.m7911b().m8138a(volleyError.getMessage(), new C28571(this));
            this.f5875a.m6648b(this.f5876b);
        }
    }

    public C2859g() {
        C3095y.m9469a();
        f5877a = new C2393f();
    }

    public static void m8304a(@NonNull ag agVar, @NonNull Message message) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, message.getText());
        } catch (JSONException e) {
            C3095y.m9479c(e.toString());
        }
        String str = C2239e.f3698o + message.getMatchId();
        C0306b c28561 = new C28561(message, agVar);
        C0305a c28582 = new C28582(agVar, message);
        ManagerApp.m7911b();
        Request c2237d = new C2237d(1, str, jSONObject, c28561, c28582, C2821b.m8123b());
        c2237d.m219a(new C0294c(20000, 0, 1.0f));
        ManagerApp.m7915f().m5900a(c2237d);
    }

    @NonNull
    public static Message m8303a(@NonNull JSONObject jSONObject, String str) throws JSONException {
        String string = jSONObject.getString("created_date");
        return new Message(str, string, jSONObject.getString("from"), jSONObject.getString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE), true, C3070i.m9362a(string));
    }
}
