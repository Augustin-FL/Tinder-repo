package com.google.android.m4b.maps.au;

import java.util.Arrays;

/* renamed from: com.google.android.m4b.maps.au.h */
final class C1362h extends C1361g {
    private int[] f897b;

    protected C1362h(double[] dArr, int[] iArr) {
        super(dArr);
        this.f897b = iArr;
    }

    public final int m1253c(int i) {
        int f = m1255f(i);
        if (m1249c(i - 1, f)) {
            return i - 1;
        }
        return this.f897b[f + 1] - 1;
    }

    public final int m1254d(int i) {
        int f = m1255f(i);
        if (m1249c(i + 1, f)) {
            return i + 1;
        }
        return this.f897b[f];
    }

    public final int m1255f(int i) {
        if (i < 0 || i >= this.a) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i2 = 0;
        while (i >= this.f897b[i2]) {
            i2++;
        }
        return i2 - 1;
    }

    public final int m1256g(int i) {
        return this.f897b[i];
    }

    public final int m1251a() {
        return this.f897b.length - 2;
    }

    private boolean m1249c(int i, int i2) {
        return i >= this.f897b[i2] && i < this.f897b[i2 + 1];
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1362h)) {
            return false;
        }
        C1362h c1362h = (C1362h) obj;
        if ((this instanceof C1362h) && super.equals(obj) && Arrays.equals(this.f897b, c1362h.f897b)) {
            return true;
        }
        return false;
    }

    protected final boolean m1252a(Object obj) {
        return obj instanceof C1362h;
    }

    public final int hashCode() {
        return super.hashCode() + (Arrays.hashCode(this.f897b) * 31);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        stringBuilder.append(super.toString());
        stringBuilder.append(";");
        stringBuilder.append(m1250i());
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private String m1250i() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < this.f897b.length - 1; i++) {
            stringBuilder.append("\nHole ");
            stringBuilder.append(i);
            stringBuilder.append(":");
            stringBuilder.append(m1239b(this.f897b[i], this.f897b[i + 1]));
        }
        return stringBuilder.toString();
    }
}
