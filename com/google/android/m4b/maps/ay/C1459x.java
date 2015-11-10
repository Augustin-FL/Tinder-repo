package com.google.android.m4b.maps.ay;

import java.io.DataInput;
import java.util.ArrayList;

/* renamed from: com.google.android.m4b.maps.ay.x */
public final class C1459x {
    private final ArrayList<C1455t> f1335a;

    public C1459x() {
        this.f1335a = new ArrayList();
    }

    public static C1459x m2115a(DataInput dataInput, int i) {
        C1459x c1459x = new C1459x();
        int a = am.m1577a(dataInput);
        for (int i2 = 0; i2 < a; i2++) {
            c1459x.f1335a.add(C1455t.m2091a(i2, dataInput, i));
        }
        return c1459x;
    }

    public final C1455t m2116a(int i) {
        if (i >= this.f1335a.size() || i < 0) {
            return C1455t.m2090a();
        }
        return (C1455t) this.f1335a.get(i);
    }
}
