package com.google.android.m4b.maps.ay;

import com.google.android.m4b.maps.p009m.C1486c;
import com.google.common.base.C1647e;
import com.google.common.base.C1647e.C1646a;

/* renamed from: com.google.android.m4b.maps.ay.f */
public final class C1439f {
    private C1440g f1253a;
    private float f1254b;
    private int f1255c;
    private C1440g f1256d;
    private float f1257e;
    private boolean f1258f;
    private C1486c f1259g;
    private boolean f1260h;
    private float f1261i;
    private boolean f1262j;
    private float f1263k;

    public C1439f() {
        m1903l();
    }

    public C1439f(C1440g c1440g, float f, int i) {
        m1908a(c1440g, f, i);
    }

    public final C1440g m1904a() {
        return this.f1253a;
    }

    public final float m1910b() {
        return this.f1254b;
    }

    public final int m1911c() {
        return this.f1255c;
    }

    public final C1440g m1912d() {
        return (C1440g) C1647e.m3075b(this.f1256d, this.f1253a);
    }

    public final void m1907a(C1440g c1440g) {
        this.f1256d = c1440g;
    }

    public final boolean m1913e() {
        return this.f1258f;
    }

    public final void m1909a(boolean z) {
        this.f1258f = z;
    }

    public final C1486c m1914f() {
        return this.f1259g;
    }

    public final boolean m1915g() {
        return this.f1260h;
    }

    public final float m1916h() {
        return this.f1261i;
    }

    public final boolean m1917i() {
        return this.f1262j;
    }

    public final float m1918j() {
        return this.f1263k;
    }

    public final void m1905a(float f) {
        this.f1263k = Math.min(1.0f, Math.max(0.0f, f));
    }

    public final void m1906a(C1439f c1439f) {
        if (c1439f == null) {
            m1903l();
            return;
        }
        m1908a(c1439f.f1253a, c1439f.f1254b, c1439f.f1255c);
        this.f1256d = c1439f.f1256d == null ? null : new C1440g(c1439f.f1256d);
        this.f1257e = c1439f.f1257e;
        this.f1258f = c1439f.f1258f;
        this.f1259g = c1439f.f1259g;
        this.f1260h = c1439f.f1260h;
        this.f1261i = c1439f.f1261i;
        this.f1262j = c1439f.f1262j;
        this.f1263k = c1439f.f1263k;
    }

    public final void m1908a(C1440g c1440g, float f, int i) {
        this.f1253a = c1440g == null ? null : new C1440g(c1440g);
        this.f1254b = f;
        this.f1255c = i;
    }

    private void m1903l() {
        this.f1253a = null;
        this.f1254b = 0.0f;
        this.f1255c = -1;
        this.f1256d = null;
        this.f1257e = 0.0f;
        this.f1258f = false;
        this.f1259g = null;
        this.f1260h = false;
        this.f1261i = 0.0f;
        this.f1262j = false;
        this.f1263k = 1.0f;
    }

    public final boolean m1919k() {
        return this.f1253a != null;
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
        C1439f c1439f = (C1439f) obj;
        if (C1647e.m3074a(this.f1253a, c1439f.f1253a) && this.f1254b == c1439f.f1254b && this.f1255c == c1439f.f1255c && C1647e.m3074a(this.f1256d, c1439f.f1256d) && this.f1257e == c1439f.f1257e && this.f1258f == c1439f.f1258f && C1647e.m3074a(this.f1259g, c1439f.f1259g) && this.f1260h == c1439f.f1260h && this.f1261i == c1439f.f1261i && this.f1262j == c1439f.f1262j && this.f1263k == c1439f.f1263k) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return C1647e.m3071a(this.f1253a, Float.valueOf(this.f1254b), Integer.valueOf(this.f1255c), Float.valueOf(this.f1257e), Boolean.valueOf(this.f1258f), this.f1259g, Boolean.valueOf(this.f1260h), Float.valueOf(this.f1261i), Boolean.valueOf(this.f1262j), Float.valueOf(this.f1263k));
    }

    public final String toString() {
        C1646a a = C1647e.m3072a((Object) this);
        a.m3069a("@", this.f1253a.m1966j());
        a.m3067a("Accuracy", this.f1255c);
        if (this.f1256d != null) {
            a.m3069a("Accuracy point", this.f1256d.m1966j());
        }
        a.m3066a("Accuracy emphasis", this.f1257e);
        a.m3070a("Use bearing", this.f1258f);
        if (this.f1258f) {
            a.m3066a("Bearing", this.f1254b);
        }
        a.m3066a("Brightness", this.f1263k);
        a.m3066a("Height", this.f1261i);
        a.m3069a("Level", this.f1259g);
        a.m3070a("Stale", this.f1262j);
        return a.toString();
    }
}
