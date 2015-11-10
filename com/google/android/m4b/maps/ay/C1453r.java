package com.google.android.m4b.maps.ay;

import com.facebook.stetho.BuildConfig;
import com.google.android.m4b.maps.ay.bd.C1421a;
import com.google.android.m4b.maps.ch.a;
import com.google.common.base.C1647e;

/* renamed from: com.google.android.m4b.maps.ay.r */
public final class C1453r implements bd {
    private final String f1313a;

    /* renamed from: com.google.android.m4b.maps.ay.r.a */
    public static class C1452a {
        private String f1312a;

        public final C1452a m2075a(String str) {
            this.f1312a = str;
            return this;
        }

        public final C1453r m2076a() {
            return new C1453r(this.f1312a);
        }
    }

    public final /* synthetic */ int compareTo(Object obj) {
        bd bdVar = (bd) obj;
        return bdVar == null ? 1 : toString().compareTo(bdVar.toString());
    }

    protected C1453r(String str) {
        this.f1313a = str;
    }

    public final C1421a m2077a() {
        return C1421a.SPOTLIGHT;
    }

    public final boolean m2080a(bd bdVar) {
        return equals(bdVar);
    }

    public final String toString() {
        return this.f1313a == null ? BuildConfig.FLAVOR : this.f1313a;
    }

    public final int hashCode() {
        return (this.f1313a == null ? 0 : this.f1313a.hashCode()) + 31;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            if (this.f1313a != null) {
                return false;
            }
            return true;
        } else if (!(obj instanceof C1453r)) {
            return false;
        } else {
            return C1647e.m3074a(this.f1313a, ((C1453r) obj).f1313a);
        }
    }

    public final boolean m2079a(ah ahVar) {
        return ahVar == ah.f1050r && this.f1313a != null;
    }

    public final void m2078a(a aVar) {
        aVar.b(10, this.f1313a);
    }
}
