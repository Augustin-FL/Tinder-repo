package com.android.volley.toolbox;

import com.android.volley.C0301g;
import com.android.volley.C0307i;
import com.android.volley.C0307i.C0305a;
import com.android.volley.C0307i.C0306b;
import com.android.volley.ParseError;
import org.json.JSONObject;

/* renamed from: com.android.volley.toolbox.j */
public class C0337j extends C0335k<JSONObject> {
    public C0337j(int i, String str, JSONObject jSONObject, C0306b<JSONObject> c0306b, C0305a c0305a) {
        super(i, str, jSONObject == null ? null : jSONObject.toString(), c0306b, c0305a);
    }

    public C0337j(String str, JSONObject jSONObject, C0306b<JSONObject> c0306b, C0305a c0305a) {
        this(jSONObject == null ? 0 : 1, str, jSONObject, c0306b, c0305a);
    }

    protected C0307i<JSONObject> m377a(C0301g c0301g) {
        try {
            if (c0301g.f244b.length == 0) {
                c0301g = new C0301g(c0301g.f243a, "{}".getBytes("UTF8"), c0301g.f245c, c0301g.f246d);
            }
            return C0307i.m281a(new JSONObject(new String(c0301g.f244b, C0324d.m329a(c0301g.f245c))), C0324d.m328a(c0301g));
        } catch (Throwable e) {
            return C0307i.m280a(new ParseError(e));
        } catch (Throwable e2) {
            return C0307i.m280a(new ParseError(e2));
        }
    }
}
