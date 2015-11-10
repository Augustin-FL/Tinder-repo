package com.squareup.okhttp;

import com.squareup.okhttp.internal.C2157k;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import okio.ByteString;

/* renamed from: com.squareup.okhttp.e */
public final class C2088e {
    public static final C2088e f3109a;
    private final Map<String, Set<ByteString>> f3110b;

    /* renamed from: com.squareup.okhttp.e.a */
    public static final class C2087a {
        private final Map<String, Set<ByteString>> f3108a;

        public C2087a() {
            this.f3108a = new LinkedHashMap();
        }

        public C2088e m4950a() {
            return new C2088e();
        }
    }

    static {
        f3109a = new C2087a().m4950a();
    }

    private C2088e(C2087a c2087a) {
        this.f3110b = C2157k.m5351a(c2087a.f3108a);
    }

    public void m4954a(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        int i = 0;
        Set<ByteString> a = m4953a(str);
        if (a != null) {
            int size = list.size();
            int i2 = 0;
            while (i2 < size) {
                if (!a.contains(C2088e.m4952a((X509Certificate) list.get(i2)))) {
                    i2++;
                } else {
                    return;
                }
            }
            StringBuilder append = new StringBuilder().append("Certificate pinning failure!").append("\n  Peer certificate chain:");
            size = list.size();
            while (i < size) {
                Certificate certificate = (X509Certificate) list.get(i);
                append.append("\n    ").append(C2088e.m4951a(certificate)).append(": ").append(certificate.getSubjectDN().getName());
                i++;
            }
            append.append("\n  Pinned certificates for ").append(str).append(":");
            for (ByteString b : a) {
                append.append("\n    sha1/").append(b.m10153b());
            }
            throw new SSLPeerUnverifiedException(append.toString());
        }
    }

    Set<ByteString> m4953a(String str) {
        Collection collection;
        Set<ByteString> set = (Set) this.f3110b.get(str);
        int indexOf = str.indexOf(46);
        if (indexOf != str.lastIndexOf(46)) {
            collection = (Set) this.f3110b.get("*." + str.substring(indexOf + 1));
        } else {
            collection = null;
        }
        if (set == null && collection == null) {
            return null;
        }
        if (set != null && collection != null) {
            Set<ByteString> linkedHashSet = new LinkedHashSet();
            linkedHashSet.addAll(set);
            linkedHashSet.addAll(collection);
            return linkedHashSet;
        } else if (set == null) {
            return collection;
        } else {
            return set;
        }
    }

    public static String m4951a(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha1/" + C2088e.m4952a((X509Certificate) certificate).m10153b();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    private static ByteString m4952a(X509Certificate x509Certificate) {
        return C2157k.m5353a(ByteString.m10146a(x509Certificate.getPublicKey().getEncoded()));
    }
}
