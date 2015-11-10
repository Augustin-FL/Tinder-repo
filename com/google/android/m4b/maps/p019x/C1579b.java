package com.google.android.m4b.maps.p019x;

import com.google.android.m4b.maps.ay.ac;
import com.google.android.m4b.maps.ay.ag;
import com.google.android.m4b.maps.ay.ah;
import com.google.android.m4b.maps.bh.m.b;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.m4b.maps.x.b */
public class C1579b extends C1578f {
    private final b f1798d;

    public C1579b(ag agVar) {
        super(ah.f1040h, agVar);
        this.f1798d = new b();
    }

    public final List<ac> m2836a(com.google.android.m4b.maps.al.b bVar) {
        List<ac> a = super.m2833a(bVar);
        this.f1798d.a(bVar.d());
        Collections.sort(a, this.f1798d);
        if (a.size() > 16) {
            return a.subList(0, 16);
        }
        return a;
    }
}
