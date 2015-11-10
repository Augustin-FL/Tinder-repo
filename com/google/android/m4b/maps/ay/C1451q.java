package com.google.android.m4b.maps.ay;

import com.facebook.stetho.BuildConfig;
import com.google.android.m4b.maps.ay.bd.C1421a;
import com.google.android.m4b.maps.ch.a;
import com.google.common.base.C1647e;

/* renamed from: com.google.android.m4b.maps.ay.q */
public final class C1451q implements bd {
    private final a f1311a;

    public final /* synthetic */ int compareTo(Object obj) {
        bd bdVar = (bd) obj;
        return bdVar == null ? 1 : toString().compareTo(bdVar.toString());
    }

    public C1451q(a aVar) {
        this.f1311a = aVar;
    }

    public final C1421a m2071a() {
        return C1421a.SPOTLIGHT_DIFFTILE;
    }

    public final boolean m2074a(bd bdVar) {
        return equals(bdVar);
    }

    public final String toString() {
        if (this.f1311a == null) {
            return BuildConfig.FLAVOR;
        }
        return this.f1311a.toString().substring(0, 20);
    }

    public final int hashCode() {
        return (this.f1311a == null ? BuildConfig.FLAVOR : this.f1311a.toString()).hashCode();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            if (this.f1311a != null) {
                return false;
            }
            return true;
        } else if (!(obj instanceof C1451q)) {
            return false;
        } else {
            return C1647e.m3074a(this.f1311a.toString(), ((C1451q) obj).f1311a.toString());
        }
    }

    public final boolean m2073a(ah ahVar) {
        return ahVar == ah.f1054v && this.f1311a != null;
    }

    public final void m2072a(a aVar) {
        aVar.b(27, this.f1311a);
    }
}
