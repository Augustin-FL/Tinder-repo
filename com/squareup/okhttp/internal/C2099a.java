package com.squareup.okhttp.internal;

import com.squareup.okhttp.C2095i;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

/* renamed from: com.squareup.okhttp.internal.a */
public final class C2099a {
    private final List<C2095i> f3156a;
    private int f3157b;
    private boolean f3158c;
    private boolean f3159d;

    public C2099a(List<C2095i> list) {
        this.f3157b = 0;
        this.f3156a = list;
    }

    public C2095i m5017a(SSLSocket sSLSocket) throws IOException {
        C2095i c2095i;
        int i = this.f3157b;
        int size = this.f3156a.size();
        for (int i2 = i; i2 < size; i2++) {
            c2095i = (C2095i) this.f3156a.get(i2);
            if (c2095i.m5003a(sSLSocket)) {
                this.f3157b = i2 + 1;
                break;
            }
        }
        c2095i = null;
        if (c2095i == null) {
            throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f3159d + ", modes=" + this.f3156a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
        }
        this.f3158c = m5016b(sSLSocket);
        C2113d.f3215b.m5115a(c2095i, sSLSocket, this.f3159d);
        return c2095i;
    }

    public boolean m5018a(IOException iOException) {
        boolean z = true;
        this.f3159d = true;
        if ((iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        if (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        if (!(((iOException instanceof SSLHandshakeException) || (iOException instanceof SSLProtocolException)) && this.f3158c)) {
            z = false;
        }
        return z;
    }

    private boolean m5016b(SSLSocket sSLSocket) {
        for (int i = this.f3157b; i < this.f3156a.size(); i++) {
            if (((C2095i) this.f3156a.get(i)).m5003a(sSLSocket)) {
                return true;
            }
        }
        return false;
    }
}
