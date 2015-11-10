package com.google.android.m4b.maps.au;

/* renamed from: com.google.android.m4b.maps.au.d */
public final class C1350d {
    private final C1361g f868a;

    C1350d(C1361g c1361g) {
        this.f868a = c1361g;
    }

    public final double m1211a() {
        return this.f868a.m1242d();
    }

    public final boolean m1212b() {
        return this.f868a.m1246f();
    }

    public final boolean m1213c() {
        return this.f868a.m1247g();
    }

    public final boolean m1214d() {
        return this.f868a.m1245e();
    }

    public final boolean m1215e() {
        return this.f868a.m1248h();
    }

    final C1361g m1216f() {
        return this.f868a;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        stringBuilder.append(this.f868a.toString());
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C1350d) {
            return ((C1350d) obj).f868a.equals(this.f868a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f868a.hashCode();
    }
}
