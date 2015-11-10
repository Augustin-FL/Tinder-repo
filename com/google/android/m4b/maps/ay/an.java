package com.google.android.m4b.maps.ay;

import android.util.FloatMath;

public final class an {
    private float f1084a;
    private float f1085b;

    public an() {
        this.f1084a = 0.0f;
        this.f1085b = 0.0f;
    }

    public final an m1583a(an anVar) {
        this.f1084a = anVar.f1084a;
        this.f1085b = anVar.f1085b;
        return this;
    }

    public final an m1584a(C1440g c1440g, C1440g c1440g2) {
        this.f1084a = (float) (c1440g2.f1264a - c1440g.f1264a);
        this.f1085b = (float) (c1440g2.f1265b - c1440g.f1265b);
        return this;
    }

    public final an m1587b(an anVar) {
        this.f1084a += anVar.f1084a;
        this.f1085b += anVar.f1085b;
        return this;
    }

    public static C1440g m1580a(C1440g c1440g, an anVar, C1440g c1440g2) {
        c1440g2.m1955d(c1440g.f1264a + Math.round(anVar.f1084a), c1440g.f1265b + Math.round(anVar.f1085b));
        return c1440g2;
    }

    public final an m1582a(float f) {
        this.f1084a *= f;
        this.f1085b *= f;
        return this;
    }

    public final an m1581a() {
        this.f1084a = -this.f1084a;
        this.f1085b = -this.f1085b;
        return this;
    }

    public final float m1588c(an anVar) {
        return (this.f1084a * anVar.f1084a) + (this.f1085b * anVar.f1085b);
    }

    public final float m1586b() {
        return FloatMath.sqrt(m1588c(this));
    }

    public final an m1589c() {
        float b = m1586b();
        if (b == 0.0f) {
            this.f1084a = 0.0f;
            this.f1085b = 0.0f;
        } else {
            this.f1084a /= b;
            this.f1085b /= b;
        }
        return this;
    }

    public final an m1590d() {
        float f = this.f1084a;
        this.f1084a = -this.f1085b;
        this.f1085b = f;
        return this;
    }

    public final boolean m1591d(an anVar) {
        return (this.f1084a * anVar.f1085b) - (anVar.f1084a * this.f1085b) < 0.0f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        an anVar = (an) obj;
        if (this.f1084a == anVar.f1084a && this.f1085b == anVar.f1085b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.f1084a) ^ Float.floatToIntBits(this.f1085b);
    }

    public final boolean m1585a(float f, float f2) {
        return this.f1084a == 0.0f && this.f1085b == 0.0f;
    }

    public final String toString() {
        return "(" + this.f1084a + "," + this.f1085b + ")";
    }
}
