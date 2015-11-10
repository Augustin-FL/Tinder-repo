package com.squareup.okhttp;

import com.squareup.okhttp.internal.C2157k;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* renamed from: com.squareup.okhttp.l */
public final class C2207l {
    private final String f3556a;
    private final List<Certificate> f3557b;
    private final List<Certificate> f3558c;

    private C2207l(String str, List<Certificate> list, List<Certificate> list2) {
        this.f3556a = str;
        this.f3557b = list;
        this.f3558c = list2;
    }

    public static C2207l m5672a(SSLSession sSLSession) {
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        Object[] peerCertificates;
        List a;
        List a2;
        try {
            peerCertificates = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException e) {
            peerCertificates = null;
        }
        if (peerCertificates != null) {
            a = C2157k.m5349a(peerCertificates);
        } else {
            a = Collections.emptyList();
        }
        Object[] localCertificates = sSLSession.getLocalCertificates();
        if (localCertificates != null) {
            a2 = C2157k.m5349a(localCertificates);
        } else {
            a2 = Collections.emptyList();
        }
        return new C2207l(cipherSuite, a, a2);
    }

    public static C2207l m5671a(String str, List<Certificate> list, List<Certificate> list2) {
        if (str != null) {
            return new C2207l(str, C2157k.m5348a((List) list), C2157k.m5348a((List) list2));
        }
        throw new IllegalArgumentException("cipherSuite == null");
    }

    public String m5673a() {
        return this.f3556a;
    }

    public List<Certificate> m5674b() {
        return this.f3557b;
    }

    public Principal m5675c() {
        return !this.f3557b.isEmpty() ? ((X509Certificate) this.f3557b.get(0)).getSubjectX500Principal() : null;
    }

    public List<Certificate> m5676d() {
        return this.f3558c;
    }

    public Principal m5677e() {
        return !this.f3558c.isEmpty() ? ((X509Certificate) this.f3558c.get(0)).getSubjectX500Principal() : null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2207l)) {
            return false;
        }
        C2207l c2207l = (C2207l) obj;
        if (this.f3556a.equals(c2207l.f3556a) && this.f3557b.equals(c2207l.f3557b) && this.f3558c.equals(c2207l.f3558c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f3556a.hashCode() + 527) * 31) + this.f3557b.hashCode()) * 31) + this.f3558c.hashCode();
    }
}
