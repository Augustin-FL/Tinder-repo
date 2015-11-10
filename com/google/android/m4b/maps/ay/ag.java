package com.google.android.m4b.maps.ay;

import com.google.android.m4b.maps.ay.bd.C1421a;
import com.google.common.base.C1647e;

public class ag {
    private final af f1014a;

    public ag() {
        this.f1014a = new af();
    }

    public boolean m1474a(af afVar, C1421a c1421a) {
        bd a = af.m1464a(afVar, c1421a);
        bd a2 = af.m1464a(this.f1014a, c1421a);
        if (a2 == null) {
            return a == null || a.m1563a(a2);
        } else {
            return a2.m1563a(a);
        }
    }

    public boolean m1473a(af afVar) {
        if (afVar == null) {
            afVar = new af();
        }
        for (C1421a a : afVar.m1468a()) {
            if (!m1474a(afVar, a)) {
                return false;
            }
        }
        return true;
    }

    public af m1472a() {
        af afVar;
        synchronized (this.f1014a) {
            afVar = new af(this.f1014a);
        }
        return afVar;
    }

    public boolean m1475a(bd bdVar) {
        boolean z = false;
        if (bdVar != null) {
            synchronized (this.f1014a) {
                if (C1647e.m3074a(this.f1014a.m1467a(bdVar.m1560a()), bdVar)) {
                } else {
                    this.f1014a.m1470a(bdVar);
                    z = true;
                }
            }
        }
        return z;
    }

    public long m1476b() {
        long hashCode;
        synchronized (this.f1014a) {
            hashCode = (long) this.f1014a.hashCode();
        }
        return hashCode;
    }
}
