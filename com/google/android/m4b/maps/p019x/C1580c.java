package com.google.android.m4b.maps.p019x;

import com.google.android.m4b.maps.ay.C1440g;
import com.google.android.m4b.maps.ay.ac;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/* renamed from: com.google.android.m4b.maps.x.c */
public final class C1580c {
    private static Set<ac> m2838a(C1575g c1575g, Set<ac> set, C1440g c1440g) {
        Set<ac> b = Sets.m4235b();
        for (ac a : set) {
            ac a2 = c1575g.m2810a(a2, c1440g);
            if (a2 != null) {
                b.add(a2);
            }
        }
        return b;
    }

    public static LinkedHashSet<ac> m2837a(C1575g c1575g, int i, Collection<ac> collection, C1440g c1440g, int i2, LinkedHashSet<ac> linkedHashSet) {
        Set set;
        int i3;
        int c;
        int i4;
        int i5;
        int i6;
        int c2;
        if (linkedHashSet == null) {
            linkedHashSet = Sets.m4235b();
        }
        Set<ac> b = Sets.m4236b(collection);
        Set b2 = Sets.m4235b();
        if (b.isEmpty()) {
            set = b2;
        } else {
            Object obj;
            ac acVar = (ac) b.iterator().next();
            int b3 = acVar.m1449b();
            i3 = 1 << b3;
            int i7 = i3 - 1;
            int i8 = i3 >> 1;
            c = acVar.m1450c();
            i4 = c;
            for (ac c3 : b) {
                i4 = Math.min(i4, c3.m1450c());
            }
            for (ac c32 : b) {
                if (c32.m1450c() - i4 >= i8) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            i5 = 0;
            i6 = i3;
            int i9 = 0;
            int i10 = i3;
            for (ac c322 : b) {
                c2 = c322.m1450c();
                if (obj != null && c2 < i8) {
                    c2 += i3;
                }
                i10 = Math.min(i10, c2);
                i9 = Math.max(i9, c2);
                i6 = Math.min(i6, c322.m1451d());
                i5 = Math.max(i5, c322.m1451d());
            }
            b2.add(acVar.m1443a(b3, i10 & i7, i6));
            b2.add(acVar.m1443a(b3, i10 & i7, i5));
            b2.add(acVar.m1443a(b3, i9 & i7, i6));
            b2.add(acVar.m1443a(b3, i9 & i7, i5));
            set = b2;
        }
        Set a = C1580c.m2838a(c1575g, b, c1440g);
        Set a2 = C1580c.m2838a(c1575g, set, c1440g);
        i4 = 0;
        c = 1;
        while (!r6.isEmpty() && i2 > 0 && c <= i && i4 < 3) {
            if (((ac) r6.iterator().next()).m1449b() <= 13 && ((i4 <= 0 && r6.size() <= 2) || ((i4 < 2 && c >= 4) || (i4 < 3 && c >= 6)))) {
                i5 = i2;
                for (ac acVar2 : r6) {
                    if (i5 == 0) {
                        break;
                    }
                    int i11;
                    if (linkedHashSet.add(acVar2)) {
                        i11 = i5 - 1;
                    } else {
                        i11 = i5;
                    }
                    i5 = i11;
                }
                if (i2 != i5) {
                    i4++;
                    i2 = i5;
                } else {
                    i2 = i5;
                }
            }
            Collection collection2;
            if (collection2 != null && (r6.size() <= 2 || c >= 3)) {
                r6.addAll(collection2);
                collection2 = null;
            }
            if (r6.size() <= 2) {
                Set b4 = Sets.m4235b();
                for (ac acVar22 : r6) {
                    c2 = 1 << acVar22.m1449b();
                    int i12 = c2 - 1;
                    for (i6 = -1; i6 <= 1; i6++) {
                        for (i3 = -1; i3 <= 1; i3++) {
                            int d = acVar22.m1451d() + i3;
                            if (d >= 0 && d < c2) {
                                b4.add(acVar22.m1443a(acVar22.m1449b(), ((acVar22.m1450c() + i6) + c2) & i12, d));
                            }
                        }
                    }
                }
                a = b4;
            }
            if (a2 != null) {
                a2 = C1580c.m2838a(c1575g, a2, c1440g);
            }
            a = C1580c.m2838a(c1575g, a, c1440g);
            c++;
        }
        return linkedHashSet;
    }
}
