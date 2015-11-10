package com.squareup.okhttp.internal;

import com.squareup.okhttp.C2090g;
import com.squareup.okhttp.C2092h;
import com.squareup.okhttp.C2095i;
import com.squareup.okhttp.C2210m.C2209a;
import com.squareup.okhttp.C2217q;
import com.squareup.okhttp.C2222s;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.http.C2137g;
import com.squareup.okhttp.internal.http.C2139r;
import com.squareup.okhttp.internal.http.RouteException;
import java.io.IOException;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;

/* renamed from: com.squareup.okhttp.internal.d */
public abstract class C2113d {
    public static final Logger f3214a;
    public static C2113d f3215b;

    public abstract C2069e m5110a(C2217q c2217q);

    public abstract C2139r m5111a(C2090g c2090g, C2137g c2137g) throws IOException;

    public abstract void m5112a(C2090g c2090g, Protocol protocol);

    public abstract void m5113a(C2090g c2090g, Object obj) throws IOException;

    public abstract void m5114a(C2092h c2092h, C2090g c2090g);

    public abstract void m5115a(C2095i c2095i, SSLSocket sSLSocket, boolean z);

    public abstract void m5116a(C2209a c2209a, String str);

    public abstract void m5117a(C2217q c2217q, C2090g c2090g, C2137g c2137g, C2222s c2222s) throws RouteException;

    public abstract boolean m5118a(C2090g c2090g);

    public abstract int m5119b(C2090g c2090g);

    public abstract C2155j m5120b(C2217q c2217q);

    public abstract void m5121b(C2090g c2090g, C2137g c2137g);

    public abstract C2115g m5122c(C2217q c2217q);

    public abstract boolean m5123c(C2090g c2090g);

    static {
        f3214a = Logger.getLogger(C2217q.class.getName());
    }
}
