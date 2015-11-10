package com.google.android.m4b.maps.ay;

import java.io.DataInput;
import java.util.ArrayList;

/* renamed from: com.google.android.m4b.maps.ay.v */
public final class C1457v {
    private final ArrayList<C1456u> f1331a;

    public C1457v() {
        this.f1331a = new ArrayList();
    }

    public static C1457v m2109a(DataInput dataInput, C1459x c1459x) {
        C1457v c1457v = new C1457v();
        int a = am.m1577a(dataInput);
        for (int i = 0; i < a; i++) {
            c1457v.f1331a.add(new C1456u(dataInput.readUTF().intern(), c1459x.m2116a(am.m1577a(dataInput))));
        }
        return c1457v;
    }

    public final C1456u m2110a(int i) {
        if (i >= this.f1331a.size()) {
            return null;
        }
        return (C1456u) this.f1331a.get(i);
    }
}
