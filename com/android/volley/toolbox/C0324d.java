package com.android.volley.toolbox;

import com.android.volley.C0290a.C0289a;
import com.android.volley.C0301g;
import java.util.Map;
import org.apache.http.HttpHeaders;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;
import org.apache.http.protocol.HTTP;

/* renamed from: com.android.volley.toolbox.d */
public class C0324d {
    public static C0289a m328a(C0301g c0301g) {
        long a;
        long j;
        long a2;
        Object obj = null;
        long j2 = 0;
        long currentTimeMillis = System.currentTimeMillis();
        Map map = c0301g.f245c;
        String str = (String) map.get(HTTP.DATE_HEADER);
        if (str != null) {
            a = C0324d.m327a(str);
        } else {
            a = 0;
        }
        str = (String) map.get(HttpHeaders.CACHE_CONTROL);
        if (str != null) {
            String[] split = str.split(",");
            long j3 = 0;
            for (String trim : split) {
                String trim2 = trim2.trim();
                if (trim2.equals("no-cache") || trim2.equals("no-store")) {
                    return null;
                }
                if (trim2.startsWith("max-age=")) {
                    try {
                        j3 = Long.parseLong(trim2.substring(8));
                    } catch (Exception e) {
                    }
                } else if (trim2.equals("must-revalidate") || trim2.equals("proxy-revalidate")) {
                    j3 = 0;
                }
            }
            j = j3;
            obj = 1;
        } else {
            j = 0;
        }
        str = (String) map.get(HttpHeaders.EXPIRES);
        if (str != null) {
            a2 = C0324d.m327a(str);
        } else {
            a2 = 0;
        }
        str = (String) map.get(HttpHeaders.ETAG);
        if (obj != null) {
            j2 = (1000 * j) + currentTimeMillis;
        } else if (a > 0 && a2 >= a) {
            j2 = (a2 - a) + currentTimeMillis;
        }
        C0289a c0289a = new C0289a();
        c0289a.f213a = c0301g.f244b;
        c0289a.f214b = str;
        c0289a.f217e = j2;
        c0289a.f216d = c0289a.f217e;
        c0289a.f215c = a;
        c0289a.f218f = map;
        return c0289a;
    }

    public static long m327a(String str) {
        try {
            return DateUtils.parseDate(str).getTime();
        } catch (DateParseException e) {
            return 0;
        }
    }

    public static String m329a(Map<String, String> map) {
        String str = (String) map.get(HTTP.CONTENT_TYPE);
        if (str != null) {
            String[] split = str.split(";");
            for (int i = 1; i < split.length; i++) {
                String[] split2 = split[i].trim().split("=");
                if (split2.length == 2 && split2[0].equals("charset")) {
                    return split2[1];
                }
            }
        }
        return HTTP.ISO_8859_1;
    }
}
