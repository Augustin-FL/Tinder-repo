package com.google.android.m4b.maps.ay;

import com.google.android.m4b.maps.p009m.C1480a;
import com.google.android.m4b.maps.p009m.C1480a.C1482b;
import java.io.DataInput;

public class ao {
    protected final C1480a f1086a;
    protected final bb f1087b;
    protected final int f1088c;
    protected final int f1089d;

    /* renamed from: com.google.android.m4b.maps.ay.ao.a */
    public static class C1410a extends ao {
        public C1410a(bb bbVar, int i, int i2) {
            super(null, bbVar, i | 1, i2);
        }

        public final bb m1594a() {
            return this.b;
        }

        public final boolean m1595b() {
            return C1436d.m1887a(this.c, 2);
        }

        public final int m1596c() {
            return this.d;
        }

        public final boolean m1597d() {
            return C1436d.m1887a(this.c, 4);
        }
    }

    /* renamed from: com.google.android.m4b.maps.ay.ao.b */
    public static class C1411b extends ao {
        public C1411b(int i, bb bbVar) {
            super(null, bbVar, 0, 0);
        }

        public final bb m1598a() {
            return this.b;
        }
    }

    /* renamed from: com.google.android.m4b.maps.ay.ao.c */
    public static class C1412c extends ao {
        public C1412c(C1480a c1480a) {
            super(c1480a, null, c1480a instanceof C1482b ? 2 : 0, -1);
        }

        public final C1480a m1599a() {
            return this.a;
        }
    }

    /* renamed from: com.google.android.m4b.maps.ay.ao.d */
    public static class C1413d extends ao {
        public C1413d(int i) {
            super(null, null, 0, 0);
        }
    }

    protected ao(C1480a c1480a, bb bbVar, int i, int i2) {
        this.f1086a = c1480a;
        this.f1087b = bbVar;
        this.f1088c = i;
        this.f1089d = i2;
    }

    public static ao m1592a(DataInput dataInput, ae aeVar) {
        int readUnsignedByte = dataInput.readUnsignedByte();
        if (aeVar.m1459a() == 11) {
            int a = am.m1577a(dataInput);
            if (C1436d.m1887a(readUnsignedByte, 1)) {
                return new C1411b(a, ap.m1620a(dataInput, aeVar));
            }
            return new C1413d(a);
        }
        int i = -1;
        if (C1436d.m1887a(readUnsignedByte, 1)) {
            bb a2 = ap.m1620a(dataInput, aeVar);
            if (C1436d.m1887a(readUnsignedByte, 2)) {
                i = am.m1577a(dataInput);
            }
            return new C1410a(a2, readUnsignedByte, i);
        }
        C1480a b;
        if (C1436d.m1887a(readUnsignedByte, 2)) {
            b = C1480a.m2296b(dataInput);
        } else {
            b = C1480a.m2293a(dataInput);
        }
        return new C1412c(b);
    }
}
