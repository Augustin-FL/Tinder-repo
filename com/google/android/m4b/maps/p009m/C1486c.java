package com.google.android.m4b.maps.p009m;

import com.google.android.m4b.maps.p009m.C1480a.C1483c;

/* renamed from: com.google.android.m4b.maps.m.c */
public final class C1486c {
    private final C1483c f1445a;
    private final int f1446b;

    public C1486c(C1483c c1483c, int i) {
        this.f1445a = c1483c;
        this.f1446b = i;
    }

    public final C1483c m2309a() {
        return this.f1445a;
    }

    public final int m2310b() {
        return this.f1446b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C1486c) {
            return this.f1445a.equals(((C1486c) obj).f1445a);
        }
        if (obj instanceof C1483c) {
            return this.f1445a.equals(obj);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1445a.hashCode();
    }

    public final String toString() {
        return "{" + getClass().getSimpleName() + ":mId=" + this.f1445a + ", mLevelNumberE3=" + this.f1446b + "}";
    }
}
