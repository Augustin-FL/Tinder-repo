package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.C2067a;
import com.squareup.okhttp.C2090g;
import com.squareup.okhttp.C2092h;
import com.squareup.okhttp.C2207l;
import com.squareup.okhttp.C2222s;
import com.squareup.okhttp.C2222s.C2221a;
import com.squareup.okhttp.C2227u;
import com.squareup.okhttp.C2228w;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.C2151i;
import com.squareup.okhttp.internal.C2157k;
import java.io.IOException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocket;
import okio.C2076r;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;

/* renamed from: com.squareup.okhttp.internal.http.o */
public class C2148o {
    private final C2090g f3325a;
    private final C2092h f3326b;

    /* renamed from: com.squareup.okhttp.internal.http.o.a */
    public static class C2147a {
        public final C2228w f3321a;
        public final Socket f3322b;
        public final Protocol f3323c;
        public final C2207l f3324d;

        public C2147a(C2228w c2228w, Socket socket) {
            this.f3321a = c2228w;
            this.f3322b = socket;
            this.f3323c = null;
            this.f3324d = null;
        }

        public C2147a(C2228w c2228w, SSLSocket sSLSocket, Protocol protocol, C2207l c2207l) {
            this.f3321a = c2228w;
            this.f3322b = sSLSocket;
            this.f3323c = protocol;
            this.f3324d = c2207l;
        }
    }

    public C2148o(C2090g c2090g, C2092h c2092h) {
        this.f3325a = c2090g;
        this.f3326b = c2092h;
    }

    public C2147a m5304a(int i, int i2, C2228w c2228w) throws RouteException {
        return new C2147a(c2228w, m5302b(i2, i, c2228w));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.squareup.okhttp.internal.http.C2148o.C2147a m5303a(int r12, int r13, int r14, com.squareup.okhttp.C2222s r15, com.squareup.okhttp.C2228w r16, java.util.List<com.squareup.okhttp.C2095i> r17, boolean r18) throws com.squareup.okhttp.internal.http.RouteException {
        /*
        r11 = this;
        r8 = r16.m5875a();
        r9 = new com.squareup.okhttp.internal.a;
        r0 = r17;
        r9.<init>(r0);
        r1 = 0;
        r7 = r1;
    L_0x000d:
        r0 = r16;
        r6 = r11.m5302b(r13, r12, r0);
        r1 = r16.m5878d();
        if (r1 == 0) goto L_0x0022;
    L_0x0019:
        r1 = r11;
        r2 = r13;
        r3 = r14;
        r4 = r15;
        r5 = r16;
        r1.m5301a(r2, r3, r4, r5, r6);
    L_0x0022:
        r2 = 0;
        r1 = r8.m4871d();	 Catch:{ IOException -> 0x0122 }
        r3 = r8.m4868a();	 Catch:{ IOException -> 0x0122 }
        r4 = r8.m4869b();	 Catch:{ IOException -> 0x0122 }
        r5 = 1;
        r1 = r1.createSocket(r6, r3, r4, r5);	 Catch:{ IOException -> 0x0122 }
        r1 = (javax.net.ssl.SSLSocket) r1;	 Catch:{ IOException -> 0x0122 }
        r3 = r9.m5017a(r1);	 Catch:{ IOException -> 0x00de }
        r4 = com.squareup.okhttp.internal.C2151i.m5320a();	 Catch:{ IOException -> 0x00de }
        r2 = 0;
        r5 = r3.m5005c();	 Catch:{ all -> 0x00fb }
        if (r5 == 0) goto L_0x0050;
    L_0x0045:
        r5 = r8.m4868a();	 Catch:{ all -> 0x00fb }
        r10 = r8.m4874g();	 Catch:{ all -> 0x00fb }
        r4.m5327a(r1, r5, r10);	 Catch:{ all -> 0x00fb }
    L_0x0050:
        r1.startHandshake();	 Catch:{ all -> 0x00fb }
        r5 = r1.getSession();	 Catch:{ all -> 0x00fb }
        r5 = com.squareup.okhttp.C2207l.m5672a(r5);	 Catch:{ all -> 0x00fb }
        r3 = r3.m5005c();	 Catch:{ all -> 0x00fb }
        if (r3 == 0) goto L_0x006b;
    L_0x0061:
        r3 = r4.m5329b(r1);	 Catch:{ all -> 0x00fb }
        if (r3 == 0) goto L_0x006b;
    L_0x0067:
        r2 = com.squareup.okhttp.Protocol.m4866a(r3);	 Catch:{ all -> 0x00fb }
    L_0x006b:
        r4.m5326a(r1);	 Catch:{ IOException -> 0x00de }
        r3 = r8.m4872e();	 Catch:{ IOException -> 0x00de }
        r4 = r8.m4868a();	 Catch:{ IOException -> 0x00de }
        r10 = r1.getSession();	 Catch:{ IOException -> 0x00de }
        r3 = r3.verify(r4, r10);	 Catch:{ IOException -> 0x00de }
        if (r3 != 0) goto L_0x0100;
    L_0x0080:
        r2 = r1.getSession();	 Catch:{ IOException -> 0x00de }
        r2 = r2.getPeerCertificates();	 Catch:{ IOException -> 0x00de }
        r3 = 0;
        r2 = r2[r3];	 Catch:{ IOException -> 0x00de }
        r2 = (java.security.cert.X509Certificate) r2;	 Catch:{ IOException -> 0x00de }
        r3 = new javax.net.ssl.SSLPeerUnverifiedException;	 Catch:{ IOException -> 0x00de }
        r4 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00de }
        r4.<init>();	 Catch:{ IOException -> 0x00de }
        r5 = "Hostname ";
        r4 = r4.append(r5);	 Catch:{ IOException -> 0x00de }
        r5 = r8.m4868a();	 Catch:{ IOException -> 0x00de }
        r4 = r4.append(r5);	 Catch:{ IOException -> 0x00de }
        r5 = " not verified:";
        r4 = r4.append(r5);	 Catch:{ IOException -> 0x00de }
        r5 = "\n    certificate: ";
        r4 = r4.append(r5);	 Catch:{ IOException -> 0x00de }
        r5 = com.squareup.okhttp.C2088e.m4951a(r2);	 Catch:{ IOException -> 0x00de }
        r4 = r4.append(r5);	 Catch:{ IOException -> 0x00de }
        r5 = "\n    DN: ";
        r4 = r4.append(r5);	 Catch:{ IOException -> 0x00de }
        r5 = r2.getSubjectDN();	 Catch:{ IOException -> 0x00de }
        r5 = r5.getName();	 Catch:{ IOException -> 0x00de }
        r4 = r4.append(r5);	 Catch:{ IOException -> 0x00de }
        r5 = "\n    subjectAltNames: ";
        r4 = r4.append(r5);	 Catch:{ IOException -> 0x00de }
        r2 = com.squareup.okhttp.internal.p028c.C2112b.m5103a(r2);	 Catch:{ IOException -> 0x00de }
        r2 = r4.append(r2);	 Catch:{ IOException -> 0x00de }
        r2 = r2.toString();	 Catch:{ IOException -> 0x00de }
        r3.<init>(r2);	 Catch:{ IOException -> 0x00de }
        throw r3;	 Catch:{ IOException -> 0x00de }
    L_0x00de:
        r2 = move-exception;
        r3 = r2;
        r4 = r1;
    L_0x00e1:
        if (r18 == 0) goto L_0x0117;
    L_0x00e3:
        r1 = r9.m5018a(r3);
        if (r1 == 0) goto L_0x0117;
    L_0x00e9:
        r1 = 1;
        r2 = r1;
    L_0x00eb:
        com.squareup.okhttp.internal.C2157k.m5357a(r4);
        com.squareup.okhttp.internal.C2157k.m5357a(r6);
        if (r7 != 0) goto L_0x011a;
    L_0x00f3:
        r1 = new com.squareup.okhttp.internal.http.RouteException;
        r1.<init>(r3);
    L_0x00f8:
        if (r2 != 0) goto L_0x011f;
    L_0x00fa:
        throw r1;
    L_0x00fb:
        r2 = move-exception;
        r4.m5326a(r1);	 Catch:{ IOException -> 0x00de }
        throw r2;	 Catch:{ IOException -> 0x00de }
    L_0x0100:
        r3 = r8.m4878k();	 Catch:{ IOException -> 0x00de }
        r4 = r8.m4868a();	 Catch:{ IOException -> 0x00de }
        r10 = r5.m5674b();	 Catch:{ IOException -> 0x00de }
        r3.m4954a(r4, r10);	 Catch:{ IOException -> 0x00de }
        r3 = new com.squareup.okhttp.internal.http.o$a;	 Catch:{ IOException -> 0x00de }
        r0 = r16;
        r3.<init>(r0, r1, r2, r5);	 Catch:{ IOException -> 0x00de }
        return r3;
    L_0x0117:
        r1 = 0;
        r2 = r1;
        goto L_0x00eb;
    L_0x011a:
        r7.m5137a(r3);
        r1 = r7;
        goto L_0x00f8;
    L_0x011f:
        r7 = r1;
        goto L_0x000d;
    L_0x0122:
        r1 = move-exception;
        r3 = r1;
        r4 = r2;
        goto L_0x00e1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.http.o.a(int, int, int, com.squareup.okhttp.s, com.squareup.okhttp.w, java.util.List, boolean):com.squareup.okhttp.internal.http.o$a");
    }

    private Socket m5302b(int i, int i2, C2228w c2228w) throws RouteException {
        C2151i a = C2151i.m5320a();
        try {
            Socket createSocket;
            Proxy b = c2228w.m5876b();
            C2067a a2 = c2228w.m5875a();
            if (b.type() == Type.DIRECT || b.type() == Type.HTTP) {
                createSocket = a2.m4870c().createSocket();
            } else {
                createSocket = new Socket(b);
            }
            createSocket.setSoTimeout(i);
            a.m5325a(createSocket, c2228w.m5877c(), i2);
            return createSocket;
        } catch (IOException e) {
            throw new RouteException(e);
        }
    }

    private void m5301a(int i, int i2, C2222s c2222s, C2228w c2228w, Socket socket) throws RouteException {
        try {
            C2222s a = m5300a(c2222s);
            C2130e c2130e = new C2130e(this.f3326b, this.f3325a, socket);
            c2130e.m5173a(i, i2);
            URL a2 = a.m5810a();
            String str = "CONNECT " + a2.getHost() + ":" + C2157k.m5347a(a2) + " HTTP/1.1";
            do {
                c2130e.m5176a(a.m5815e(), str);
                c2130e.m5181d();
                C2227u a3 = c2130e.m5184g().m5842a(a).m5847a();
                long a4 = C2142j.m5263a(a3);
                if (a4 == -1) {
                    a4 = 0;
                }
                C2076r b = c2130e.m5178b(a4);
                C2157k.m5362b(b, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, TimeUnit.MILLISECONDS);
                b.close();
                switch (a3.m5865c()) {
                    case HttpStatus.SC_OK /*200*/:
                        if (c2130e.m5182e() > 0) {
                            throw new IOException("TLS tunnel buffered too many bytes!");
                        }
                        return;
                    case HttpStatus.SC_PROXY_AUTHENTICATION_REQUIRED /*407*/:
                        a = C2142j.m5265a(c2228w.m5875a().m4873f(), a3, c2228w.m5876b());
                        break;
                    default:
                        throw new IOException("Unexpected response code for CONNECT: " + a3.m5865c());
                }
                throw new RouteException(e);
            } while (a != null);
            throw new IOException("Failed to authenticate with proxy");
        } catch (IOException e) {
            throw new RouteException(e);
        }
    }

    private C2222s m5300a(C2222s c2222s) throws IOException {
        String host = c2222s.m5810a().getHost();
        int a = C2157k.m5347a(c2222s.m5810a());
        C2221a a2 = new C2221a().m5800a(new URL("https", host, a, "/")).m5799a(HTTP.TARGET_HOST, a == C2157k.m5344a("https") ? host : host + ":" + a).m5799a("Proxy-Connection", HTTP.CONN_KEEP_ALIVE);
        host = c2222s.m5809a(HTTP.USER_AGENT);
        if (host != null) {
            a2.m5799a(HTTP.USER_AGENT, host);
        }
        host = c2222s.m5809a(HttpHeaders.PROXY_AUTHORIZATION);
        if (host != null) {
            a2.m5799a(HttpHeaders.PROXY_AUTHORIZATION, host);
        }
        return a2.m5801a();
    }
}
