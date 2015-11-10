package com.squareup.okhttp;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

/* renamed from: com.squareup.okhttp.w */
public final class C2228w {
    final C2067a f3650a;
    final Proxy f3651b;
    final InetSocketAddress f3652c;

    public C2228w(C2067a c2067a, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (c2067a == null) {
            throw new NullPointerException("address == null");
        } else if (proxy == null) {
            throw new NullPointerException("proxy == null");
        } else if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        } else {
            this.f3650a = c2067a;
            this.f3651b = proxy;
            this.f3652c = inetSocketAddress;
        }
    }

    public C2067a m5875a() {
        return this.f3650a;
    }

    public Proxy m5876b() {
        return this.f3651b;
    }

    public InetSocketAddress m5877c() {
        return this.f3652c;
    }

    public boolean m5878d() {
        return this.f3650a.f3048e != null && this.f3651b.type() == Type.HTTP;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2228w)) {
            return false;
        }
        C2228w c2228w = (C2228w) obj;
        if (this.f3650a.equals(c2228w.f3650a) && this.f3651b.equals(c2228w.f3651b) && this.f3652c.equals(c2228w.f3652c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f3650a.hashCode() + 527) * 31) + this.f3651b.hashCode()) * 31) + this.f3652c.hashCode();
    }
}
