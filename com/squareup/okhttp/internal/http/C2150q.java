package com.squareup.okhttp.internal.http;

import com.facebook.stetho.BuildConfig;
import com.squareup.okhttp.C2227u;
import com.squareup.okhttp.Protocol;
import java.io.IOException;
import java.net.ProtocolException;

/* renamed from: com.squareup.okhttp.internal.http.q */
public final class C2150q {
    public final Protocol f3332a;
    public final int f3333b;
    public final String f3334c;

    public C2150q(Protocol protocol, int i, String str) {
        this.f3332a = protocol;
        this.f3333b = i;
        this.f3334c = str;
    }

    public static C2150q m5318a(C2227u c2227u) {
        return new C2150q(c2227u.m5864b(), c2227u.m5865c(), c2227u.m5866d());
    }

    public static C2150q m5319a(String str) throws IOException {
        Protocol protocol;
        int i = 9;
        if (str.startsWith("HTTP/1.")) {
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int charAt = str.charAt(7) - 48;
            if (charAt == 0) {
                protocol = Protocol.HTTP_1_0;
            } else if (charAt == 1) {
                protocol = Protocol.HTTP_1_1;
            } else {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else if (str.startsWith("ICY ")) {
            protocol = Protocol.HTTP_1_0;
            i = 4;
        } else {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        if (str.length() < i + 3) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        try {
            String str2;
            int parseInt = Integer.parseInt(str.substring(i, i + 3));
            String str3 = BuildConfig.FLAVOR;
            if (str.length() <= i + 3) {
                str2 = str3;
            } else if (str.charAt(i + 3) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            } else {
                str2 = str.substring(i + 4);
            }
            return new C2150q(protocol, parseInt, str2);
        } catch (NumberFormatException e) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f3332a == Protocol.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        stringBuilder.append(' ').append(this.f3333b);
        if (this.f3334c != null) {
            stringBuilder.append(' ').append(this.f3334c);
        }
        return stringBuilder.toString();
    }
}
