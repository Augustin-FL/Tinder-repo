package com.google.android.m4b.maps.ay;

import com.facebook.stetho.BuildConfig;
import java.io.DataInput;

/* renamed from: com.google.android.m4b.maps.ay.w */
public final class C1458w {
    private final C1455t f1332a;
    private final String f1333b;
    private final int f1334c;

    public C1458w(C1455t c1455t, String str, int i) {
        this.f1332a = c1455t;
        this.f1333b = str;
        this.f1334c = i;
    }

    public static C1458w m2111a(DataInput dataInput, ae aeVar) {
        int a;
        C1455t b;
        String a2;
        if (aeVar.m1459a() == 11) {
            a = am.m1577a(dataInput);
            C1456u b2 = aeVar.m1462b(a);
            if (b2 != null) {
                b = b2.m2108b();
                a2 = b2.m2107a();
            } else {
                b = C1455t.m2090a();
                a2 = BuildConfig.FLAVOR;
            }
        } else {
            b = aeVar.m1460a(am.m1577a(dataInput));
            a = am.m1577a(dataInput);
            a2 = aeVar.m1463c(a);
        }
        return new C1458w(b, a2, a);
    }

    public final C1455t m2112a() {
        return this.f1332a;
    }

    public final String m2113b() {
        return this.f1333b;
    }

    public final int m2114c() {
        return this.f1334c;
    }
}
