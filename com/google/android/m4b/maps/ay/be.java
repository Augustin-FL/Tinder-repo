package com.google.android.m4b.maps.ay;

import com.facebook.stetho.BuildConfig;
import com.google.android.m4b.maps.ay.bd.C1421a;
import com.google.android.m4b.maps.ch.a;
import com.google.common.base.C1647e;

public final class be implements bd {
    private final String f1183a;

    /* renamed from: com.google.android.m4b.maps.ay.be.a */
    public static class C1429a {
        private String f1182a;

        public final C1429a m1772a(String str) {
            this.f1182a = str;
            return this;
        }

        public final be m1773a() {
            return new be(this.f1182a);
        }
    }

    public final /* synthetic */ int compareTo(Object obj) {
        bd bdVar = (bd) obj;
        return bdVar == null ? 1 : toString().compareTo(bdVar.toString());
    }

    protected be(String str) {
        this.f1183a = str;
    }

    public final C1421a m1774a() {
        return C1421a.HIGHLIGHT;
    }

    public final boolean m1777a(bd bdVar) {
        return equals(bdVar);
    }

    public final String toString() {
        return this.f1183a == null ? BuildConfig.FLAVOR : this.f1183a;
    }

    public final int hashCode() {
        return C1647e.m3071a(this.f1183a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            if (this.f1183a != null) {
                return false;
            }
            return true;
        } else if (obj instanceof be) {
            return C1647e.m3074a(this.f1183a, ((be) obj).f1183a);
        } else {
            return false;
        }
    }

    public final boolean m1776a(ah ahVar) {
        return (ahVar != ah.f1051s || this.f1183a == null || "0x0:0x0".equals(this.f1183a)) ? false : true;
    }

    public final void m1775a(a aVar) {
        aVar.b(9, this.f1183a);
    }
}
