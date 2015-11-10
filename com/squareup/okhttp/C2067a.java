package com.squareup.okhttp;

import com.squareup.okhttp.internal.C2157k;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: com.squareup.okhttp.a */
public final class C2067a {
    final Proxy f3044a;
    final String f3045b;
    final int f3046c;
    final SocketFactory f3047d;
    final SSLSocketFactory f3048e;
    final HostnameVerifier f3049f;
    final C2088e f3050g;
    final C2068b f3051h;
    final List<Protocol> f3052i;
    final List<C2095i> f3053j;
    final ProxySelector f3054k;

    public C2067a(String str, int i, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, C2088e c2088e, C2068b c2068b, Proxy proxy, List<Protocol> list, List<C2095i> list2, ProxySelector proxySelector) {
        if (str == null) {
            throw new NullPointerException("uriHost == null");
        } else if (i <= 0) {
            throw new IllegalArgumentException("uriPort <= 0: " + i);
        } else if (c2068b == null) {
            throw new IllegalArgumentException("authenticator == null");
        } else if (list == null) {
            throw new IllegalArgumentException("protocols == null");
        } else if (proxySelector == null) {
            throw new IllegalArgumentException("proxySelector == null");
        } else {
            this.f3044a = proxy;
            this.f3045b = str;
            this.f3046c = i;
            this.f3047d = socketFactory;
            this.f3048e = sSLSocketFactory;
            this.f3049f = hostnameVerifier;
            this.f3050g = c2088e;
            this.f3051h = c2068b;
            this.f3052i = C2157k.m5348a((List) list);
            this.f3053j = C2157k.m5348a((List) list2);
            this.f3054k = proxySelector;
        }
    }

    public String m4868a() {
        return this.f3045b;
    }

    public int m4869b() {
        return this.f3046c;
    }

    public SocketFactory m4870c() {
        return this.f3047d;
    }

    public SSLSocketFactory m4871d() {
        return this.f3048e;
    }

    public HostnameVerifier m4872e() {
        return this.f3049f;
    }

    public C2068b m4873f() {
        return this.f3051h;
    }

    public List<Protocol> m4874g() {
        return this.f3052i;
    }

    public List<C2095i> m4875h() {
        return this.f3053j;
    }

    public Proxy m4876i() {
        return this.f3044a;
    }

    public ProxySelector m4877j() {
        return this.f3054k;
    }

    public C2088e m4878k() {
        return this.f3050g;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2067a)) {
            return false;
        }
        C2067a c2067a = (C2067a) obj;
        if (C2157k.m5358a(this.f3044a, c2067a.f3044a) && this.f3045b.equals(c2067a.f3045b) && this.f3046c == c2067a.f3046c && C2157k.m5358a(this.f3048e, c2067a.f3048e) && C2157k.m5358a(this.f3049f, c2067a.f3049f) && C2157k.m5358a(this.f3050g, c2067a.f3050g) && C2157k.m5358a(this.f3051h, c2067a.f3051h) && C2157k.m5358a(this.f3052i, c2067a.f3052i) && C2157k.m5358a(this.f3053j, c2067a.f3053j) && C2157k.m5358a(this.f3054k, c2067a.f3054k)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        int hashCode2 = ((((((this.f3044a != null ? this.f3044a.hashCode() : 0) + 527) * 31) + this.f3045b.hashCode()) * 31) + this.f3046c) * 31;
        if (this.f3048e != null) {
            hashCode = this.f3048e.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.f3049f != null) {
            hashCode = this.f3049f.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode = (hashCode + hashCode2) * 31;
        if (this.f3050g != null) {
            i = this.f3050g.hashCode();
        }
        return ((((((((hashCode + i) * 31) + this.f3051h.hashCode()) * 31) + this.f3052i.hashCode()) * 31) + this.f3053j.hashCode()) * 31) + this.f3054k.hashCode();
    }
}
