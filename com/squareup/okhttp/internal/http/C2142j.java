package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.C2068b;
import com.squareup.okhttp.C2089f;
import com.squareup.okhttp.C2210m;
import com.squareup.okhttp.C2210m.C2209a;
import com.squareup.okhttp.C2222s;
import com.squareup.okhttp.C2222s.C2221a;
import com.squareup.okhttp.C2227u;
import com.squareup.okhttp.internal.C2151i;
import com.squareup.okhttp.internal.C2157k;
import java.io.IOException;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;

/* renamed from: com.squareup.okhttp.internal.http.j */
public final class C2142j {
    static final String f3299a;
    public static final String f3300b;
    public static final String f3301c;
    public static final String f3302d;
    private static final Comparator<String> f3303e;

    /* renamed from: com.squareup.okhttp.internal.http.j.1 */
    static class C21411 implements Comparator<String> {
        C21411() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m5260a((String) obj, (String) obj2);
        }

        public int m5260a(String str, String str2) {
            if (str == str2) {
                return 0;
            }
            if (str == null) {
                return -1;
            }
            if (str2 == null) {
                return 1;
            }
            return String.CASE_INSENSITIVE_ORDER.compare(str, str2);
        }
    }

    static {
        f3303e = new C21411();
        f3299a = C2151i.m5320a().m5328b();
        f3300b = f3299a + "-Sent-Millis";
        f3301c = f3299a + "-Received-Millis";
        f3302d = f3299a + "-Selected-Protocol";
    }

    public static long m5262a(C2222s c2222s) {
        return C2142j.m5261a(c2222s.m5815e());
    }

    public static long m5263a(C2227u c2227u) {
        return C2142j.m5261a(c2227u.m5868f());
    }

    public static long m5261a(C2210m c2210m) {
        return C2142j.m5271b(c2210m.m5689a(HTTP.CONTENT_LEN));
    }

    private static long m5271b(String str) {
        long j = -1;
        if (str != null) {
            try {
                j = Long.parseLong(str);
            } catch (NumberFormatException e) {
            }
        }
        return j;
    }

    public static Map<String, List<String>> m5267a(C2210m c2210m, String str) {
        Map treeMap = new TreeMap(f3303e);
        int a = c2210m.m5687a();
        for (int i = 0; i < a; i++) {
            String a2 = c2210m.m5688a(i);
            String b = c2210m.m5691b(i);
            List arrayList = new ArrayList();
            List list = (List) treeMap.get(a2);
            if (list != null) {
                arrayList.addAll(list);
            }
            arrayList.add(b);
            treeMap.put(a2, Collections.unmodifiableList(arrayList));
        }
        if (str != null) {
            treeMap.put(null, Collections.unmodifiableList(Collections.singletonList(str)));
        }
        return Collections.unmodifiableMap(treeMap);
    }

    public static void m5268a(C2221a c2221a, Map<String, List<String>> map) {
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (("Cookie".equalsIgnoreCase(str) || "Cookie2".equalsIgnoreCase(str)) && !((List) entry.getValue()).isEmpty()) {
                c2221a.m5803b(str, C2142j.m5266a((List) entry.getValue()));
            }
        }
    }

    private static String m5266a(List<String> list) {
        if (list.size() == 1) {
            return (String) list.get(0);
        }
        StringBuilder stringBuilder = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuilder.append("; ");
            }
            stringBuilder.append((String) list.get(i));
        }
        return stringBuilder.toString();
    }

    public static boolean m5269a(C2227u c2227u, C2210m c2210m, C2222s c2222s) {
        for (String str : C2142j.m5277d(c2227u)) {
            if (!C2157k.m5358a(c2210m.m5693c(str), c2222s.m5812b(str))) {
                return false;
            }
        }
        return true;
    }

    public static boolean m5274b(C2227u c2227u) {
        return C2142j.m5273b(c2227u.m5868f());
    }

    public static boolean m5273b(C2210m c2210m) {
        return C2142j.m5276c(c2210m).contains("*");
    }

    private static Set<String> m5277d(C2227u c2227u) {
        return C2142j.m5276c(c2227u.m5868f());
    }

    public static Set<String> m5276c(C2210m c2210m) {
        Set<String> emptySet = Collections.emptySet();
        int a = c2210m.m5687a();
        for (int i = 0; i < a; i++) {
            if (HttpHeaders.VARY.equalsIgnoreCase(c2210m.m5688a(i))) {
                String b = c2210m.m5691b(i);
                if (emptySet.isEmpty()) {
                    emptySet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                }
                for (String trim : b.split(",")) {
                    emptySet.add(trim.trim());
                }
            }
        }
        return emptySet;
    }

    public static C2210m m5275c(C2227u c2227u) {
        return C2142j.m5264a(c2227u.m5871i().m5861a().m5815e(), c2227u.m5868f());
    }

    public static C2210m m5264a(C2210m c2210m, C2210m c2210m2) {
        Set c = C2142j.m5276c(c2210m2);
        if (c.isEmpty()) {
            return new C2209a().m5681a();
        }
        C2209a c2209a = new C2209a();
        int a = c2210m.m5687a();
        for (int i = 0; i < a; i++) {
            String a2 = c2210m.m5688a(i);
            if (c.contains(a2)) {
                c2209a.m5680a(a2, c2210m.m5691b(i));
            }
        }
        return c2209a.m5681a();
    }

    static boolean m5270a(String str) {
        return (HTTP.CONN_DIRECTIVE.equalsIgnoreCase(str) || HTTP.CONN_KEEP_ALIVE.equalsIgnoreCase(str) || HttpHeaders.PROXY_AUTHENTICATE.equalsIgnoreCase(str) || HttpHeaders.PROXY_AUTHORIZATION.equalsIgnoreCase(str) || HttpHeaders.TE.equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || HTTP.TRANSFER_ENCODING.equalsIgnoreCase(str) || HttpHeaders.UPGRADE.equalsIgnoreCase(str)) ? false : true;
    }

    public static List<C2089f> m5272b(C2210m c2210m, String str) {
        List<C2089f> arrayList = new ArrayList();
        int a = c2210m.m5687a();
        for (int i = 0; i < a; i++) {
            if (str.equalsIgnoreCase(c2210m.m5688a(i))) {
                String b = c2210m.m5691b(i);
                int i2 = 0;
                while (i2 < b.length()) {
                    int a2 = C2122d.m5149a(b, i2, " ");
                    String trim = b.substring(i2, a2).trim();
                    a2 = C2122d.m5148a(b, a2);
                    if (!b.regionMatches(true, a2, "realm=\"", 0, "realm=\"".length())) {
                        break;
                    }
                    i2 = "realm=\"".length() + a2;
                    a2 = C2122d.m5149a(b, i2, "\"");
                    String substring = b.substring(i2, a2);
                    i2 = C2122d.m5148a(b, C2122d.m5149a(b, a2 + 1, ",") + 1);
                    arrayList.add(new C2089f(trim, substring));
                }
            }
        }
        return arrayList;
    }

    public static C2222s m5265a(C2068b c2068b, C2227u c2227u, Proxy proxy) throws IOException {
        if (c2227u.m5865c() == HttpStatus.SC_PROXY_AUTHENTICATION_REQUIRED) {
            return c2068b.m4880b(proxy, c2227u);
        }
        return c2068b.m4879a(proxy, c2227u);
    }
}
