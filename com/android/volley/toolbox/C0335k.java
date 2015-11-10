package com.android.volley.toolbox;

import com.android.volley.C0301g;
import com.android.volley.C0307i;
import com.android.volley.C0307i.C0305a;
import com.android.volley.C0307i.C0306b;
import com.android.volley.C0310l;
import com.android.volley.Request;
import java.io.UnsupportedEncodingException;

/* renamed from: com.android.volley.toolbox.k */
public abstract class C0335k<T> extends Request<T> {
    private static final String f332a;
    private final C0306b<T> f333b;
    private final String f334c;

    protected abstract C0307i<T> m370a(C0301g c0301g);

    static {
        f332a = String.format("application/json; charset=%s", new Object[]{"utf-8"});
    }

    public C0335k(int i, String str, String str2, C0306b<T> c0306b, C0305a c0305a) {
        super(i, str, c0305a);
        this.f333b = c0306b;
        this.f334c = str2;
    }

    protected void m371b(T t) {
        this.f333b.m279a(t);
    }

    public String m372l() {
        return m374p();
    }

    public byte[] m373m() {
        return m375q();
    }

    public String m374p() {
        return f332a;
    }

    public byte[] m375q() {
        byte[] bArr = null;
        try {
            if (this.f334c != null) {
                bArr = this.f334c.getBytes("utf-8");
            }
        } catch (UnsupportedEncodingException e) {
            C0310l.m290d("Unsupported Encoding while trying to get the bytes of %s using %s", this.f334c, "utf-8");
        }
        return bArr;
    }
}
