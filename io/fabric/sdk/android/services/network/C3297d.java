package io.fabric.sdk.android.services.network;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/* renamed from: io.fabric.sdk.android.services.network.d */
public final class C3297d {
    public static final SSLSocketFactory m10086a(C0432e c0432e) throws KeyManagementException, NoSuchAlgorithmException {
        SSLContext instance = SSLContext.getInstance("TLS");
        C3298f c3298f = new C3298f(new C3299g(c0432e.m711a(), c0432e.m712b()), c0432e);
        instance.init(null, new TrustManager[]{c3298f}, null);
        return instance.getSocketFactory();
    }
}
