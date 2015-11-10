package com.google.android.m4b.maps.p019x;

import com.google.android.m4b.maps.ay.C1440g;
import com.google.android.m4b.maps.ay.ac;
import com.google.android.m4b.maps.ay.ag;
import com.google.android.m4b.maps.ay.ah;
import com.google.android.m4b.maps.bg.i;
import com.google.android.m4b.maps.bh.t;
import com.google.android.m4b.maps.bh.u;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.m4b.maps.x.j */
public abstract class C1577j implements C1575g {
    protected final ah f1789a;
    protected final ag f1790b;
    protected final u f1791c;

    public C1577j(ah ahVar, ag agVar) {
        this(ahVar, i.c(), agVar);
    }

    private C1577j(ah ahVar, u uVar, ag agVar) {
        this.f1789a = ahVar;
        this.f1791c = uVar;
        this.f1790b = agVar;
        if (uVar == null) {
            throw new RuntimeException("Null zoom table");
        }
    }

    public final ac m2827a(ac acVar, C1440g c1440g) {
        int a = m2825b(c1440g).a(acVar.m1449b());
        if (a < 0) {
            return null;
        }
        return acVar.m1442a(a);
    }

    public final List<ac> m2829b(ac acVar, C1440g c1440g) {
        List arrayList = new ArrayList();
        int b = m2825b(c1440g).b(acVar.m1449b());
        if (b >= 0) {
            int b2 = b - acVar.m1449b();
            int i = 1 << b2;
            for (int i2 = 0; i2 < i; i2++) {
                for (int i3 = 0; i3 < i; i3++) {
                    arrayList.add(acVar.m1443a(b, (acVar.m1450c() << b2) + i3, (acVar.m1451d() << b2) + i2));
                }
            }
        }
        return arrayList;
    }

    public final List<ac> m2828a(int i, C1440g c1440g) {
        List<ac> arrayList = new ArrayList();
        t b = m2825b(c1440g);
        for (int i2 = 0; i2 <= 2; i2++) {
            if (b.c(i2)) {
                int i3 = 1 << i2;
                for (int i4 = 0; i4 < i3; i4++) {
                    for (int i5 = 0; i5 < i3; i5++) {
                        arrayList.add(new ac(i2, i4, i5, this.f1790b.m1472a()));
                    }
                }
            }
        }
        return arrayList;
    }

    private t m2825b(C1440g c1440g) {
        return this.f1791c.a(c1440g, this.f1789a);
    }

    public float m2826a(C1440g c1440g) {
        return (float) m2825b(c1440g).a();
    }
}
