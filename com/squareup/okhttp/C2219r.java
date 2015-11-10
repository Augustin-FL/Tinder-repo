package com.squareup.okhttp;

import com.squareup.okhttp.internal.p026a.C2097b;
import com.squareup.okhttp.internal.p026a.C2098c;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import org.apache.http.HttpHost;

/* renamed from: com.squareup.okhttp.r */
public final class C2219r implements Cloneable, URLStreamHandlerFactory {
    private final C2217q f3611a;

    /* renamed from: com.squareup.okhttp.r.1 */
    class C22181 extends URLStreamHandler {
        final /* synthetic */ String f3609a;
        final /* synthetic */ C2219r f3610b;

        C22181(C2219r c2219r, String str) {
            this.f3610b = c2219r;
            this.f3609a = str;
        }

        protected URLConnection openConnection(URL url) {
            return this.f3610b.m5787a(url);
        }

        protected URLConnection openConnection(URL url, Proxy proxy) {
            return this.f3610b.m5788a(url, proxy);
        }

        protected int getDefaultPort() {
            if (this.f3609a.equals(HttpHost.DEFAULT_SCHEME_NAME)) {
                return 80;
            }
            if (this.f3609a.equals("https")) {
                return 443;
            }
            throw new AssertionError();
        }
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return m5789b();
    }

    public C2219r(C2217q c2217q) {
        this.f3611a = c2217q;
    }

    public C2217q m5786a() {
        return this.f3611a;
    }

    public C2219r m5789b() {
        return new C2219r(this.f3611a.m5785v());
    }

    public HttpURLConnection m5787a(URL url) {
        return m5788a(url, this.f3611a.m5767d());
    }

    HttpURLConnection m5788a(URL url, Proxy proxy) {
        String protocol = url.getProtocol();
        C2217q u = this.f3611a.m5784u();
        u.m5758a(proxy);
        if (protocol.equals(HttpHost.DEFAULT_SCHEME_NAME)) {
            return new C2097b(url, u);
        }
        if (protocol.equals("https")) {
            return new C2098c(url, u);
        }
        throw new IllegalArgumentException("Unexpected protocol: " + protocol);
    }

    public URLStreamHandler createURLStreamHandler(String str) {
        if (str.equals(HttpHost.DEFAULT_SCHEME_NAME) || str.equals("https")) {
            return new C22181(this, str);
        }
        return null;
    }
}
