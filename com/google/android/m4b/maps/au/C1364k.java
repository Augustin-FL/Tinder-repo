package com.google.android.m4b.maps.au;

/* renamed from: com.google.android.m4b.maps.au.k */
public class C1364k {
    private static final C1364k f900a;
    private final C1347m f901b;
    private int f902c;

    /* renamed from: com.google.android.m4b.maps.au.k.a */
    final class C1365a extends C1364k {
        public C1365a() {
            super((byte) 0);
        }

        public final boolean m1280a(int i, int i2, int i3) {
            throw new UnsupportedOperationException("Cannot add triangle to immutable empty mesh");
        }

        public final double m1281c() {
            return 0.0d;
        }

        public final int m1282d() {
            return 0;
        }

        public final int m1283e() {
            return 0;
        }

        public final boolean equals(Object obj) {
            if (this == obj || super.equals(obj)) {
                return true;
            }
            if ((obj instanceof C1364k) && ((C1364k) obj).m1278d() == 0) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return 0;
        }
    }

    static {
        f900a = new C1365a();
    }

    public static C1364k m1270a(C1347m c1347m) {
        return new C1364k(c1347m.m1176c());
    }

    public static C1364k m1269a() {
        return f900a;
    }

    private C1364k(C1347m c1347m) {
        this.f902c = 0;
        this.f901b = c1347m;
    }

    public boolean m1273a(int i, int i2, int i3) {
        if (this.f901b.m1175c(i, i2, i3) > 0.0d) {
            this.f901b.m1173b(i, i2, i3);
            return true;
        }
        this.f902c++;
        return false;
    }

    public final boolean m1274a(C1350d c1350d) {
        double a = c1350d.m1211a();
        double c = m1277c();
        return Math.abs(a - c) <= 0.001d * a || a == c || (Double.isNaN(a) && Double.isNaN(c));
    }

    public final void m1276b() {
        this.f902c++;
    }

    public double m1277c() {
        double d = 0.0d;
        for (int i = 0; i < this.f901b.f866c; i += 3) {
            d += this.f901b.m1171b(i, i + 1, i + 2);
        }
        return d;
    }

    public int m1278d() {
        return this.f901b == null ? 0 : this.f901b.f866c / 3;
    }

    public int m1279e() {
        return this.f901b == null ? 0 : this.f901b.m1179e();
    }

    public final double m1271a(int i) {
        if (i >= 0 && i < this.f901b.m1179e()) {
            return this.f901b.m1170b(i);
        }
        throw new IllegalArgumentException();
    }

    public final double m1275b(int i) {
        if (i >= 0 && i < this.f901b.m1179e()) {
            return this.f901b.m1174c(i);
        }
        throw new IllegalArgumentException();
    }

    public final int m1272a(int i, int i2) {
        if (i >= 0 && i < m1278d() && i2 >= 0 && i2 < 3) {
            return this.f901b.m1191j((i * 3) + i2);
        }
        throw new IllegalArgumentException();
    }

    public String toString() {
        int i;
        int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nint[] triangles = {\n    ");
        int i3 = this.f901b.f866c;
        for (i = 0; i < i3; i += 3) {
            stringBuilder.append(this.f901b.m1191j(i));
            stringBuilder.append(", ");
            stringBuilder.append(this.f901b.m1191j(i + 1));
            stringBuilder.append(", ");
            stringBuilder.append(this.f901b.m1191j(i + 2));
            if (i == this.f901b.f866c - 3) {
                stringBuilder.append("\n};\n\n");
            } else {
                stringBuilder.append(",\n    ");
            }
        }
        i = this.f901b.m1179e();
        while (i2 < i) {
            stringBuilder.append("cutVertices.add(new Vertex2d(");
            stringBuilder.append(this.f901b.m1170b(i2));
            stringBuilder.append(", ");
            stringBuilder.append(this.f901b.m1174c(i2));
            stringBuilder.append("));\n");
            i2++;
        }
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        if (obj instanceof C1364k) {
            return ((C1364k) obj).f901b.equals(this.f901b);
        }
        return false;
    }

    public int hashCode() {
        return this.f901b.hashCode();
    }
}
