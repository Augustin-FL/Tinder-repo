package com.google.android.m4b.maps.ay;

import com.google.android.m4b.maps.ay.bd.C1421a;
import com.google.android.m4b.maps.ch.a;
import com.google.common.base.C1647e;

public final class br implements bd {
    private final a f1243a;

    public final /* synthetic */ int compareTo(Object obj) {
        bd bdVar = (bd) obj;
        return bdVar == null ? 1 : toString().compareTo(bdVar.toString());
    }

    public br(a aVar) {
        this.f1243a = aVar;
    }

    public final C1421a m1875a() {
        return C1421a.MAPS_ENGINE;
    }

    public final boolean m1878a(bd bdVar) {
        return equals(bdVar);
    }

    public final boolean m1877a(ah ahVar) {
        return ahVar == ah.f1056x || ahVar == ah.f1055w;
    }

    public final void m1876a(a aVar) {
        aVar.b(29, this.f1243a);
    }

    public final a m1879b() {
        return this.f1243a;
    }

    public final String toString() {
        return this.f1243a.toString();
    }

    public final int hashCode() {
        return C1647e.m3071a(this.f1243a.toString());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof br)) {
            return false;
        }
        return C1647e.m3074a(this.f1243a.toString(), ((br) obj).f1243a.toString());
    }
}
