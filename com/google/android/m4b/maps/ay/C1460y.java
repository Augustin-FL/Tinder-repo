package com.google.android.m4b.maps.ay;

import java.io.DataInput;

/* renamed from: com.google.android.m4b.maps.ay.y */
public final class C1460y {
    private static C1460y f1336c;
    private final int f1337a;
    private final C1454s f1338b;

    static {
        f1336c = new C1460y(0, C1454s.m2081a());
    }

    public C1460y(int i, C1454s c1454s) {
        this.f1337a = i;
        this.f1338b = c1454s;
    }

    public static C1460y m2118a(DataInput dataInput, int i) {
        return new C1460y(dataInput.readInt(), C1454s.m2082a(dataInput));
    }

    public static C1460y m2117a() {
        return f1336c;
    }

    public final int m2119b() {
        return this.f1337a;
    }

    public final int hashCode() {
        return (this.f1338b == null ? 0 : this.f1338b.hashCode()) + ((this.f1337a + 31) * 31);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        C1460y c1460y = (C1460y) obj;
        if (this.f1337a != c1460y.f1337a) {
            return false;
        }
        if (this.f1338b == null) {
            if (c1460y.f1338b != null) {
                return false;
            }
            return true;
        } else if (this.f1338b.equals(c1460y.f1338b)) {
            return true;
        } else {
            return false;
        }
    }
}
