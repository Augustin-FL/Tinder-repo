package com.android.volley.toolbox;

import com.android.volley.C0301g;
import com.android.volley.C0307i;
import com.android.volley.C0307i.C0305a;
import com.android.volley.C0307i.C0306b;
import com.android.volley.Request;
import java.io.UnsupportedEncodingException;

/* renamed from: com.android.volley.toolbox.m */
public class C0339m extends Request<String> {
    private final C0306b<String> f336a;

    protected /* synthetic */ void m380b(Object obj) {
        m381c((String) obj);
    }

    public C0339m(int i, String str, C0306b<String> c0306b, C0305a c0305a) {
        super(i, str, c0305a);
        this.f336a = c0306b;
    }

    protected void m381c(String str) {
        this.f336a.m279a(str);
    }

    protected C0307i<String> m379a(C0301g c0301g) {
        Object str;
        try {
            str = new String(c0301g.f244b, C0324d.m329a(c0301g.f245c));
        } catch (UnsupportedEncodingException e) {
            str = new String(c0301g.f244b);
        }
        return C0307i.m281a(str, C0324d.m328a(c0301g));
    }
}
