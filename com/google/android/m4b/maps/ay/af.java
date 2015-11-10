package com.google.android.m4b.maps.ay;

import com.facebook.stetho.BuildConfig;
import com.google.android.m4b.maps.ay.bd.C1421a;
import com.google.android.m4b.maps.ch.a;
import com.google.common.collect.C1876q;
import java.util.Map;
import java.util.Set;

public final class af implements Comparable<af> {
    private final Map<C1421a, bd> f1013a;

    public final /* synthetic */ int compareTo(Object obj) {
        return m1465a((af) obj);
    }

    public af() {
        this.f1013a = C1876q.m4328a();
    }

    public af(af afVar) {
        this.f1013a = C1876q.m4330a(afVar.f1013a);
    }

    public final bd m1467a(C1421a c1421a) {
        return (bd) this.f1013a.get(c1421a);
    }

    public static bd m1464a(af afVar, C1421a c1421a) {
        if (afVar == null) {
            return null;
        }
        return afVar.m1467a(c1421a);
    }

    public final Set<C1421a> m1468a() {
        return this.f1013a.keySet();
    }

    public final void m1470a(bd bdVar) {
        this.f1013a.put(bdVar.m1560a(), bdVar);
    }

    public final int hashCode() {
        int hashCode = (this.f1013a == null || this.f1013a.isEmpty()) ? 0 : this.f1013a.hashCode();
        return hashCode + 31;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return this.f1013a.isEmpty();
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return this.f1013a.equals(((af) obj).f1013a);
    }

    public final String toString() {
        return this.f1013a.isEmpty() ? BuildConfig.FLAVOR : this.f1013a.toString();
    }

    public final int m1465a(af afVar) {
        for (C1421a c1421a : C1421a.values()) {
            bd a = m1467a(c1421a);
            bd a2 = afVar.m1467a(c1421a);
            if (a != null) {
                int compareTo = a.compareTo(a2);
                if (compareTo != 0) {
                    return compareTo;
                }
            } else if (a2 != null) {
                return -1;
            }
        }
        return 0;
    }

    public final void m1469a(ah ahVar, a aVar) {
        for (bd bdVar : this.f1013a.values()) {
            if (bdVar.m1562a(ahVar)) {
                bdVar.m1561a(aVar);
            }
        }
    }

    public final boolean m1471b() {
        return this.f1013a.isEmpty();
    }

    public final af m1466a(ah ahVar) {
        af afVar = new af();
        for (bd bdVar : this.f1013a.values()) {
            if (bdVar.m1562a(ahVar)) {
                afVar.m1470a(bdVar);
            }
        }
        return afVar;
    }
}
