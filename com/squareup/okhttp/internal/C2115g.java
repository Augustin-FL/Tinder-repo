package com.squareup.okhttp.internal;

import java.net.InetAddress;
import java.net.UnknownHostException;

/* renamed from: com.squareup.okhttp.internal.g */
public interface C2115g {
    public static final C2115g f3217a;

    /* renamed from: com.squareup.okhttp.internal.g.1 */
    static class C21161 implements C2115g {
        C21161() {
        }

        public InetAddress[] m5126a(String str) throws UnknownHostException {
            if (str != null) {
                return InetAddress.getAllByName(str);
            }
            throw new UnknownHostException("host == null");
        }
    }

    InetAddress[] m5125a(String str) throws UnknownHostException;

    static {
        f3217a = new C21161();
    }
}
