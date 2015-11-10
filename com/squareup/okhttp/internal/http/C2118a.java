package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.C2068b;
import com.squareup.okhttp.C2089f;
import com.squareup.okhttp.C2205j;
import com.squareup.okhttp.C2222s;
import com.squareup.okhttp.C2227u;
import com.squareup.okhttp.internal.C2157k;
import java.io.IOException;
import java.net.Authenticator;
import java.net.Authenticator.RequestorType;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.util.List;
import org.apache.http.HttpHeaders;

/* renamed from: com.squareup.okhttp.internal.http.a */
public final class C2118a implements C2068b {
    public static final C2068b f3223a;

    static {
        f3223a = new C2118a();
    }

    public C2222s m5139a(Proxy proxy, C2227u c2227u) throws IOException {
        List k = c2227u.m5873k();
        C2222s a = c2227u.m5861a();
        URL a2 = a.m5810a();
        int size = k.size();
        for (int i = 0; i < size; i++) {
            C2089f c2089f = (C2089f) k.get(i);
            if ("Basic".equalsIgnoreCase(c2089f.m4955a())) {
                PasswordAuthentication requestPasswordAuthentication = Authenticator.requestPasswordAuthentication(a2.getHost(), m5138a(proxy, a2), C2157k.m5347a(a2), a2.getProtocol(), c2089f.m4956b(), c2089f.m4955a(), a2, RequestorType.SERVER);
                if (requestPasswordAuthentication != null) {
                    return a.m5817g().m5799a(HttpHeaders.AUTHORIZATION, C2205j.m5670a(requestPasswordAuthentication.getUserName(), new String(requestPasswordAuthentication.getPassword()))).m5801a();
                }
            }
        }
        return null;
    }

    public C2222s m5140b(Proxy proxy, C2227u c2227u) throws IOException {
        List k = c2227u.m5873k();
        C2222s a = c2227u.m5861a();
        URL a2 = a.m5810a();
        int size = k.size();
        for (int i = 0; i < size; i++) {
            C2089f c2089f = (C2089f) k.get(i);
            if ("Basic".equalsIgnoreCase(c2089f.m4955a())) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) proxy.address();
                PasswordAuthentication requestPasswordAuthentication = Authenticator.requestPasswordAuthentication(inetSocketAddress.getHostName(), m5138a(proxy, a2), inetSocketAddress.getPort(), a2.getProtocol(), c2089f.m4956b(), c2089f.m4955a(), a2, RequestorType.PROXY);
                if (requestPasswordAuthentication != null) {
                    return a.m5817g().m5799a(HttpHeaders.PROXY_AUTHORIZATION, C2205j.m5670a(requestPasswordAuthentication.getUserName(), new String(requestPasswordAuthentication.getPassword()))).m5801a();
                }
            }
        }
        return null;
    }

    private InetAddress m5138a(Proxy proxy, URL url) throws IOException {
        if (proxy == null || proxy.type() == Type.DIRECT) {
            return InetAddress.getByName(url.getHost());
        }
        return ((InetSocketAddress) proxy.address()).getAddress();
    }
}
