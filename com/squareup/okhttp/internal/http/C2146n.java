package com.squareup.okhttp.internal.http;

import android.support.v4.internal.view.SupportMenu;
import com.squareup.okhttp.C2067a;
import com.squareup.okhttp.C2217q;
import com.squareup.okhttp.C2222s;
import com.squareup.okhttp.C2228w;
import com.squareup.okhttp.internal.C2113d;
import com.squareup.okhttp.internal.C2115g;
import com.squareup.okhttp.internal.C2155j;
import com.squareup.okhttp.internal.C2157k;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/* renamed from: com.squareup.okhttp.internal.http.n */
public final class C2146n {
    private final C2067a f3309a;
    private final URI f3310b;
    private final C2115g f3311c;
    private final C2217q f3312d;
    private final C2155j f3313e;
    private Proxy f3314f;
    private InetSocketAddress f3315g;
    private List<Proxy> f3316h;
    private int f3317i;
    private List<InetSocketAddress> f3318j;
    private int f3319k;
    private final List<C2228w> f3320l;

    private C2146n(C2067a c2067a, URI uri, C2217q c2217q) {
        this.f3316h = Collections.emptyList();
        this.f3318j = Collections.emptyList();
        this.f3320l = new ArrayList();
        this.f3309a = c2067a;
        this.f3310b = uri;
        this.f3312d = c2217q;
        this.f3313e = C2113d.f3215b.m5120b(c2217q);
        this.f3311c = C2113d.f3215b.m5122c(c2217q);
        m5290a(uri, c2067a.m4876i());
    }

    public static C2146n m5287a(C2067a c2067a, C2222s c2222s, C2217q c2217q) throws IOException {
        return new C2146n(c2067a, c2222s.m5811b(), c2217q);
    }

    public boolean m5298a() {
        return m5293e() || m5291c() || m5295g();
    }

    public C2228w m5299b() throws IOException {
        if (!m5293e()) {
            if (m5291c()) {
                this.f3314f = m5292d();
            } else if (m5295g()) {
                return m5296h();
            } else {
                throw new NoSuchElementException();
            }
        }
        this.f3315g = m5294f();
        C2228w c2228w = new C2228w(this.f3309a, this.f3314f, this.f3315g);
        if (!this.f3313e.m5343c(c2228w)) {
            return c2228w;
        }
        this.f3320l.add(c2228w);
        return m5299b();
    }

    public void m5297a(C2228w c2228w, IOException iOException) {
        if (!(c2228w.m5876b().type() == Type.DIRECT || this.f3309a.m4877j() == null)) {
            this.f3309a.m4877j().connectFailed(this.f3310b, c2228w.m5876b().address(), iOException);
        }
        this.f3313e.m5341a(c2228w);
    }

    private void m5290a(URI uri, Proxy proxy) {
        if (proxy != null) {
            this.f3316h = Collections.singletonList(proxy);
        } else {
            this.f3316h = new ArrayList();
            Collection select = this.f3312d.m5768e().select(uri);
            if (select != null) {
                this.f3316h.addAll(select);
            }
            this.f3316h.removeAll(Collections.singleton(Proxy.NO_PROXY));
            this.f3316h.add(Proxy.NO_PROXY);
        }
        this.f3317i = 0;
    }

    private boolean m5291c() {
        return this.f3317i < this.f3316h.size();
    }

    private Proxy m5292d() throws IOException {
        if (m5291c()) {
            List list = this.f3316h;
            int i = this.f3317i;
            this.f3317i = i + 1;
            Proxy proxy = (Proxy) list.get(i);
            m5289a(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f3309a.m4868a() + "; exhausted proxy configurations: " + this.f3316h);
    }

    private void m5289a(Proxy proxy) throws IOException {
        String a;
        int a2;
        this.f3318j = new ArrayList();
        if (proxy.type() == Type.DIRECT || proxy.type() == Type.SOCKS) {
            a = this.f3309a.m4868a();
            a2 = C2157k.m5346a(this.f3310b);
        } else {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                String a3 = C2146n.m5288a(inetSocketAddress);
                int port = inetSocketAddress.getPort();
                a = a3;
                a2 = port;
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
        }
        if (a2 < 1 || a2 > SupportMenu.USER_MASK) {
            throw new SocketException("No route to " + a + ":" + a2 + "; port is out of range");
        }
        for (InetAddress inetSocketAddress2 : this.f3311c.m5125a(a)) {
            this.f3318j.add(new InetSocketAddress(inetSocketAddress2, a2));
        }
        this.f3319k = 0;
    }

    static String m5288a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }

    private boolean m5293e() {
        return this.f3319k < this.f3318j.size();
    }

    private InetSocketAddress m5294f() throws IOException {
        if (m5293e()) {
            List list = this.f3318j;
            int i = this.f3319k;
            this.f3319k = i + 1;
            return (InetSocketAddress) list.get(i);
        }
        throw new SocketException("No route to " + this.f3309a.m4868a() + "; exhausted inet socket addresses: " + this.f3318j);
    }

    private boolean m5295g() {
        return !this.f3320l.isEmpty();
    }

    private C2228w m5296h() {
        return (C2228w) this.f3320l.remove(0);
    }
}
