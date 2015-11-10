package io.fabric.sdk.android.services.network;

import io.fabric.sdk.android.C3218c;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* renamed from: io.fabric.sdk.android.services.network.f */
class C3298f implements X509TrustManager {
    private final TrustManager[] f7173a;
    private final C3299g f7174b;
    private final long f7175c;
    private final List<byte[]> f7176d;
    private final Set<X509Certificate> f7177e;

    public C3298f(C3299g c3299g, C0432e c0432e) {
        this.f7176d = new LinkedList();
        this.f7177e = Collections.synchronizedSet(new HashSet());
        this.f7173a = m10091a(c3299g);
        this.f7174b = c3299g;
        this.f7175c = c0432e.m714d();
        for (String a : c0432e.m713c()) {
            this.f7176d.add(m10090a(a));
        }
    }

    private TrustManager[] m10091a(C3299g c3299g) {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance("X509");
            instance.init(c3299g.f7178a);
            return instance.getTrustManagers();
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        } catch (KeyStoreException e2) {
            throw new AssertionError(e2);
        }
    }

    private boolean m10089a(X509Certificate x509Certificate) throws CertificateException {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(x509Certificate.getPublicKey().getEncoded());
            for (byte[] equals : this.f7176d) {
                if (Arrays.equals(equals, digest)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable e) {
            throw new CertificateException(e);
        }
    }

    private void m10088a(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        for (TrustManager trustManager : this.f7173a) {
            ((X509TrustManager) trustManager).checkServerTrusted(x509CertificateArr, str);
        }
    }

    private void m10087a(X509Certificate[] x509CertificateArr) throws CertificateException {
        if (this.f7175c == -1 || System.currentTimeMillis() - this.f7175c <= 15552000000L) {
            X509Certificate[] a = C3293a.m10077a(x509CertificateArr, this.f7174b);
            int length = a.length;
            int i = 0;
            while (i < length) {
                if (!m10089a(a[i])) {
                    i++;
                } else {
                    return;
                }
            }
            throw new CertificateException("No valid pins found in chain!");
        }
        C3218c.m9728h().m9692d("Fabric", "Certificate pins are stale, (" + (System.currentTimeMillis() - this.f7175c) + " millis vs " + 15552000000L + " millis) " + "falling back to system trust.");
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        throw new CertificateException("Client certificates not supported!");
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        if (!this.f7177e.contains(x509CertificateArr[0])) {
            m10088a(x509CertificateArr, str);
            m10087a(x509CertificateArr);
            this.f7177e.add(x509CertificateArr[0]);
        }
    }

    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }

    private byte[] m10090a(String str) {
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }
}
