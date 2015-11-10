package com.google.android.m4b.maps.p021z;

import com.google.android.m4b.maps.aa.C1313a;
import com.google.android.m4b.maps.ay.C1440g;
import com.google.android.m4b.maps.ay.C1448m;
import com.google.android.m4b.maps.ay.ac;
import com.google.android.m4b.maps.ay.ar;
import com.google.android.m4b.maps.p009m.C1480a;
import com.google.android.m4b.maps.p009m.C1480a.C1483c;
import com.google.android.m4b.maps.p021z.C1595c.C1594a;
import com.google.common.collect.C1755r;
import com.google.common.collect.C1872p;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.ImmutableSetMultimap.C1781a;
import com.google.common.collect.Sets;
import java.io.BufferedReader;
import java.io.Reader;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* renamed from: com.google.android.m4b.maps.z.e */
public final class C1599e implements C1595c {
    private final C1755r<ac, C1590a> f1840b;
    private final Set<C1480a> f1841c;

    public static C1599e m2881a(Reader reader, ar arVar) {
        BufferedReader bufferedReader = new BufferedReader(reader);
        Collection b = C1872p.m4318b();
        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
            Object obj;
            readLine = readLine.trim();
            if (readLine.length() == 0) {
                obj = null;
            } else {
                Object split = readLine.split("\\s+");
                if (split.length < 3) {
                    obj = null;
                } else {
                    C1483c b2 = C1483c.m2303b(split[0]);
                    C1313a a = C1313a.m1011a(split[1]);
                    C1313a a2 = C1313a.m1011a(split[2]);
                    if (b2 == null || a == null || a2 == null) {
                        obj = null;
                    } else {
                        C1440g a3;
                        int i;
                        if (split.length > 3) {
                            a3 = C1590a.m2850a(split[3]);
                            i = a3 != null ? 4 : 3;
                        } else {
                            i = 3;
                            a3 = null;
                        }
                        C1440g b3 = C1440g.m1934b(a.m1014a(), a.m1015b());
                        C1440g b4 = C1440g.m1934b(a2.m1014a(), a2.m1015b());
                        Object obj2 = new String[(split.length - i)];
                        System.arraycopy(split, i, obj2, 0, obj2.length);
                        obj = new C1590a(b2, C1448m.m2041a(b3, b4), a3, obj2);
                    }
                }
            }
            if (obj != null) {
                b.add(obj);
            }
        }
        return new C1599e(b, arVar);
    }

    public C1599e() {
        this.f1840b = ImmutableSetMultimap.m3700j();
        this.f1841c = ImmutableSet.m3678g();
    }

    private C1599e(Collection<C1590a> collection, ar arVar) {
        C1781a k = ImmutableSetMultimap.m3701k();
        Collection a = Sets.m4227a();
        for (C1590a c1590a : collection) {
            ar a2 = ar.m1671a(c1590a.m2855b());
            double e = ((double) a2.m1681e()) / a2.m1682f().m1956e();
            if (((double) a2.m1680d()) / a2.m1682f().m1956e() < 7000.0d && e < 7000.0d) {
                c1590a.m2853a((Set) a);
                if (arVar == null || arVar.m1678b(c1590a.m2855b())) {
                    Iterator it = ac.m1436a(a2, 15).iterator();
                    while (it.hasNext()) {
                        k.m3841a((ac) it.next(), c1590a);
                    }
                }
            }
        }
        this.f1841c = ImmutableSet.m3672a(a);
        this.f1840b = k.m3842a();
    }

    public final Collection<C1590a> m2882a(ac acVar) {
        ac a = acVar.m1441a();
        int b = a.m1449b();
        if (b < 15) {
            return ImmutableSet.m3678g();
        }
        if (b == 15) {
            return this.f1840b.m3590b(a);
        }
        return C1590a.m2851a(this.f1840b.m3590b(a.m1442a(15)), a.m1456i());
    }

    public final boolean m2884a(C1480a c1480a) {
        return this.f1841c.contains(c1480a);
    }

    public final void m2883a(C1594a c1594a) {
    }

    public final void m2885b(C1594a c1594a) {
    }
}
