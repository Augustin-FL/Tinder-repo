package com.tinder.managers;

import android.support.annotation.NonNull;
import com.android.volley.C0294c;
import com.android.volley.C0307i.C0305a;
import com.android.volley.C0307i.C0306b;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.tinder.p029a.C2237d;
import com.tinder.p029a.C2239e;
import com.tinder.p030d.bj;
import com.tinder.utils.C3095y;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tinder.managers.r */
public class C2963r {

    /* renamed from: com.tinder.managers.r.1 */
    class C29611 implements C0306b<JSONObject> {
        final /* synthetic */ bj f6270a;
        final /* synthetic */ C2963r f6271b;

        C29611(C2963r c2963r, bj bjVar) {
            this.f6271b = c2963r;
            this.f6270a = bjVar;
        }

        public void m8891a(@NonNull JSONObject jSONObject) {
            C3095y.m9471a("tutorial: " + jSONObject);
            this.f6270a.m6719a();
        }
    }

    /* renamed from: com.tinder.managers.r.2 */
    class C29622 implements C0305a {
        final /* synthetic */ bj f6272a;
        final /* synthetic */ C2963r f6273b;

        C29622(C2963r c2963r, bj bjVar) {
            this.f6273b = c2963r;
            this.f6272a = bjVar;
        }

        public void onErrorResponse(@NonNull VolleyError volleyError) {
            this.f6272a.m6720b();
            C3095y.m9471a("tutorial: " + volleyError.getMessage());
        }
    }

    public void m8893a(String str, bj bjVar) {
        List arrayList = new ArrayList(1);
        arrayList.add(str);
        m8894a(arrayList, bjVar);
    }

    public void m8894a(List<String> list, bj bjVar) {
        C3095y.m9471a("Attempting tutorial server confirmation");
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            for (String put : list) {
                jSONArray.put(put);
            }
            jSONObject.put("tutorials", jSONArray);
        } catch (JSONException e) {
            C3095y.m9479c(e.getMessage());
        }
        String str = C2239e.aa;
        C0306b c29611 = new C29611(this, bjVar);
        C0305a c29622 = new C29622(this, bjVar);
        ManagerApp.m7911b();
        Request c2237d = new C2237d(1, str, jSONObject, c29611, c29622, C2821b.m8123b());
        c2237d.m219a(new C0294c(5000, 1, 1.0f));
        ManagerApp.m7915f().m5900a(c2237d);
    }

    public void m8892a() {
        ManagerApp.m7914e().m8864o(true);
        ManagerApp.m7914e().m8865p(true);
    }
}
