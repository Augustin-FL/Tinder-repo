package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.C2222s;
import com.squareup.okhttp.Protocol;
import java.net.Proxy.Type;
import java.net.URL;

/* renamed from: com.squareup.okhttp.internal.http.l */
public final class C2144l {
    static String m5281a(C2222s c2222s, Type type, Protocol protocol) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c2222s.m5814d());
        stringBuilder.append(' ');
        if (C2144l.m5283a(c2222s, type)) {
            stringBuilder.append(c2222s.m5810a());
        } else {
            stringBuilder.append(C2144l.m5282a(c2222s.m5810a()));
        }
        stringBuilder.append(' ');
        stringBuilder.append(C2144l.m5280a(protocol));
        return stringBuilder.toString();
    }

    private static boolean m5283a(C2222s c2222s, Type type) {
        return !c2222s.m5819i() && type == Type.HTTP;
    }

    public static String m5282a(URL url) {
        String file = url.getFile();
        if (file == null) {
            return "/";
        }
        if (file.startsWith("/")) {
            return file;
        }
        return "/" + file;
    }

    public static String m5280a(Protocol protocol) {
        return protocol == Protocol.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1";
    }
}
