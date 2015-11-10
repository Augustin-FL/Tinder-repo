package com.google.android.m4b.maps.p021z;

import com.facebook.appevents.AppEventsConstants;
import com.google.android.m4b.maps.aa.C1313a;
import com.google.android.m4b.maps.ay.C1420n;
import com.google.android.m4b.maps.ay.C1440g;
import com.google.android.m4b.maps.ay.C1448m;
import com.google.android.m4b.maps.ay.ax;
import com.google.android.m4b.maps.p009m.C1480a;
import com.google.android.m4b.maps.p009m.C1480a.C1483c;
import com.google.android.m4b.maps.p009m.C1487d;
import com.google.common.collect.C1872p;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/* renamed from: com.google.android.m4b.maps.z.a */
public final class C1590a {
    private final C1483c f1818a;
    private final ax f1819b;
    private final C1440g f1820c;
    private final Set<C1480a> f1821d;

    public C1590a(C1483c c1483c, ax axVar, C1440g c1440g, String[] strArr) {
        this.f1818a = c1483c;
        this.f1819b = axVar;
        if (c1440g == null) {
            c1440g = axVar.m1724a().m2052e();
        }
        this.f1820c = c1440g;
        this.f1821d = Sets.m4227a();
        for (String a : strArr) {
            this.f1821d.add(C1480a.m2294a(a));
        }
    }

    public final C1483c m2852a() {
        return this.f1818a;
    }

    public final C1448m m2855b() {
        return this.f1819b.m1724a();
    }

    public final boolean m2854a(C1420n c1420n) {
        return this.f1819b.m1726a(c1420n);
    }

    public final C1440g m2856c() {
        return this.f1820c;
    }

    static C1440g m2850a(String str) {
        C1313a a = C1313a.m1011a(str);
        if (a != null) {
            return C1440g.m1934b(a.m1014a(), a.m1015b());
        }
        if (!str.startsWith("0x1:0x")) {
            return null;
        }
        String str2;
        String substring;
        if (str.length() <= 14) {
            str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            substring = str.substring(6);
        } else {
            str2 = str.substring(6, str.length() - 8);
            substring = str.substring(str.length() - 8);
        }
        try {
            return new C1440g(C1487d.m2313b(str2), C1487d.m2313b(substring));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1590a)) {
            return false;
        }
        C1590a c1590a = (C1590a) obj;
        if (c1590a.f1818a.equals(this.f1818a) && c1590a.f1819b.equals(this.f1819b) && c1590a.f1820c.equals(this.f1820c) && c1590a.f1821d.equals(this.f1821d)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.f1819b.hashCode() * 31) + this.f1820c.hashCode()) * 31) + this.f1821d.hashCode()) * 31) + this.f1818a.hashCode();
    }

    public final String toString() {
        return "[" + this.f1818a + " : " + this.f1819b + " : " + this.f1820c + " : " + this.f1821d + "]";
    }

    public static Collection<C1590a> m2851a(Collection<C1590a> collection, C1420n c1420n) {
        if (collection.isEmpty()) {
            return collection;
        }
        List b = C1872p.m4318b();
        for (C1590a c1590a : collection) {
            if (c1590a.m2854a(c1420n)) {
                b.add(c1590a);
            }
        }
        return b;
    }

    final void m2853a(Set<C1480a> set) {
        set.addAll(this.f1821d);
        this.f1821d.clear();
    }
}
