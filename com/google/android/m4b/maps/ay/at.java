package com.google.android.m4b.maps.ay;

import com.facebook.stetho.BuildConfig;
import com.google.android.m4b.maps.ay.bd.C1421a;
import com.google.android.m4b.maps.ch.a;
import com.google.common.base.C1647e;

public final class at implements bd {
    private final String f1136a;

    /* renamed from: com.google.android.m4b.maps.ay.at.a */
    public static class C1417a {
        private String f1135a;

        public final C1417a m1685a(String str) {
            this.f1135a = str;
            return this;
        }

        public final at m1686a() {
            return new at(this.f1135a);
        }
    }

    public final /* synthetic */ int compareTo(Object obj) {
        bd bdVar = (bd) obj;
        return bdVar == null ? 1 : toString().compareTo(bdVar.toString());
    }

    protected at(String str) {
        this.f1136a = str;
    }

    public final C1421a m1687a() {
        return C1421a.ALTERNATE_PAINTFE;
    }

    public final boolean m1690a(bd bdVar) {
        return equals(bdVar);
    }

    public final String toString() {
        return this.f1136a == null ? BuildConfig.FLAVOR : this.f1136a;
    }

    public final int hashCode() {
        return C1647e.m3071a(this.f1136a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            if (this.f1136a != null) {
                return false;
            }
            return true;
        } else if (obj instanceof at) {
            return C1647e.m3074a(this.f1136a, ((at) obj).f1136a);
        } else {
            return false;
        }
    }

    public final boolean m1689a(ah ahVar) {
        return this.f1136a != null;
    }

    public final void m1688a(a aVar) {
        aVar.b(13, this.f1136a);
    }
}
