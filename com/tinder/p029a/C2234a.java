package com.tinder.p029a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.android.volley.AuthFailureError;
import com.android.volley.C0307i.C0305a;
import com.android.volley.C0307i.C0306b;
import com.android.volley.C0310l;
import com.android.volley.toolbox.C0339m;
import com.facebook.stetho.BuildConfig;
import com.tinder.utils.C3095y;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/* renamed from: com.tinder.a.a */
public class C2234a extends C0339m {
    private final Map<String, String> f3653a;
    private String f3654b;

    public C2234a(int i, String str, Map<String, String> map, String str2, C0306b<String> c0306b, C0305a c0305a) {
        super(i, str, c0306b, c0305a);
        this.f3653a = map;
        this.f3654b = str2;
        C3095y.m9471a("url=" + str + ", mPayload=" + str2);
    }

    public Map<String, String> m5891i() throws AuthFailureError {
        return this.f3653a != null ? this.f3653a : super.m233i();
    }

    @NonNull
    public String m5892p() {
        return "application/x-www-form-urlencoded";
    }

    @Nullable
    public byte[] m5893q() {
        C3095y.m9471a("Returning " + this.f3654b);
        try {
            if (this.f3654b == null) {
                this.f3654b = BuildConfig.FLAVOR;
            }
            return this.f3654b.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            C0310l.m290d("Unsupported Encoding while trying to get the bytes of %s using %s", this.f3654b, "utf-8");
            return null;
        }
    }
}
