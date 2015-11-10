package com.android.volley.toolbox;

import com.android.volley.C0301g;
import com.android.volley.C0307i;
import com.android.volley.C0307i.C0305a;
import com.android.volley.C0307i.C0306b;
import com.android.volley.ParseError;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.android.volley.toolbox.i */
public class C0336i extends C0335k<JSONArray> {
    public C0336i(String str, C0306b<JSONArray> c0306b, C0305a c0305a) {
        super(0, str, null, c0306b, c0305a);
    }

    public C0336i(int i, String str, C0306b<JSONArray> c0306b, JSONObject jSONObject, C0305a c0305a) {
        super(i, str, jSONObject.toString(), c0306b, c0305a);
    }

    protected C0307i<JSONArray> m376a(C0301g c0301g) {
        try {
            return C0307i.m281a(new JSONArray(new String(c0301g.f244b, C0324d.m329a(c0301g.f245c))), C0324d.m328a(c0301g));
        } catch (Throwable e) {
            return C0307i.m280a(new ParseError(e));
        } catch (Throwable e2) {
            return C0307i.m280a(new ParseError(e2));
        }
    }
}
