package com.google.android.m4b.maps.ay;

import com.google.android.m4b.maps.ay.bd.C1421a;
import com.google.android.m4b.maps.ch.a;
import com.google.android.m4b.maps.p009m.C1480a.C1483c;
import com.google.android.m4b.maps.p009m.C1486c;
import com.google.common.base.C1647e;

public final class bj implements bd {
    private final C1486c f1207a;

    /* renamed from: com.google.android.m4b.maps.ay.bj.a */
    public static class C1433a {
        private C1486c f1206a;

        public final C1433a m1814a(C1486c c1486c) {
            this.f1206a = c1486c;
            return this;
        }

        public final bj m1815a() {
            return new bj(this.f1206a);
        }
    }

    public final /* synthetic */ int compareTo(Object obj) {
        bd bdVar = (bd) obj;
        return bdVar == null ? 1 : toString().compareTo(bdVar.toString());
    }

    protected bj(C1486c c1486c) {
        this.f1207a = c1486c;
    }

    public final C1421a m1817a() {
        return C1421a.INDOOR;
    }

    public final C1483c m1821b() {
        return this.f1207a.m2309a();
    }

    public final boolean m1820a(bd bdVar) {
        return true;
    }

    public final String toString() {
        return this.f1207a.m2309a().toString();
    }

    public final int hashCode() {
        return (this.f1207a == null ? 0 : this.f1207a.m2309a().hashCode()) + 31;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            if (this.f1207a != null) {
                return false;
            }
            return true;
        } else if (obj instanceof bj) {
            return C1647e.m3074a(this.f1207a.m2309a(), ((bj) obj).f1207a.m2309a());
        } else {
            return false;
        }
    }

    public final boolean m1819a(ah ahVar) {
        return ahVar == ah.f1046n && this.f1207a != null;
    }

    public final void m1818a(a aVar) {
        aVar.b(6, this.f1207a.m2309a().toString());
    }

    public final C1486c m1822c() {
        return this.f1207a;
    }

    public static bj m1816a(C1486c c1486c) {
        return new C1433a().m1814a(c1486c).m1815a();
    }
}
