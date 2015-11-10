package com.google.android.m4b.maps.au;

/* renamed from: com.google.android.m4b.maps.au.l */
public final class C1366l {
    private double f903a;
    private double f904b;

    public static int m1285a(double d, double d2, double d3, double d4) {
        int compare = Double.compare(d, d3);
        if (compare == 0) {
            return Double.compare(d2, d4);
        }
        return compare;
    }

    public static double m1284a(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = ((d3 - d) * (d6 - d2)) - ((d5 - d) * (d4 - d2));
        return Math.abs(d7) < (((((d - d5) * (d - d5)) + ((d2 - d6) * (d2 - d6))) + ((d - d3) * (d - d3))) + ((d2 - d4) * (d2 - d4))) * 1.0E-10d ? 0.0d : d7;
    }

    public final String toString() {
        return "(" + this.f903a + "," + this.f904b + ")";
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1366l)) {
            return false;
        }
        C1366l c1366l = (C1366l) obj;
        if (c1366l.f903a == this.f903a && c1366l.f904b == this.f904b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f903a) ^ (Double.doubleToLongBits(this.f904b) * 31);
        return ((int) (doubleToLongBits >> 32)) ^ ((int) doubleToLongBits);
    }
}
