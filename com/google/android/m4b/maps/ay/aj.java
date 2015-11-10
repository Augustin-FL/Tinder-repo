package com.google.android.m4b.maps.ay;

import com.facebook.stetho.BuildConfig;
import com.google.android.m4b.maps.ay.bd.C1421a;
import com.google.android.m4b.maps.ch.a;
import com.google.android.m4b.maps.p009m.C1480a;
import com.google.common.base.C1647e;
import com.google.common.collect.Sets;
import java.util.Arrays;
import java.util.Set;

public final class aj implements bd {
    private final C1480a f1080a;
    private final Integer[] f1081b;

    /* renamed from: com.google.android.m4b.maps.ay.aj.a */
    public static class C1409a {
        private static final Integer[] f1077a;
        private C1480a f1078b;
        private Set<Integer> f1079c;

        public C1409a() {
            this.f1079c = Sets.m4227a();
        }

        static {
            f1077a = new Integer[0];
        }

        public final C1409a m1558a(C1480a c1480a) {
            this.f1078b = c1480a;
            return this;
        }

        public final C1409a m1557a(int i) {
            this.f1079c.add(Integer.valueOf(i));
            return this;
        }

        public final aj m1559a() {
            if (this.f1079c.contains(Integer.valueOf(-1))) {
                this.f1079c.clear();
            }
            return new aj(this.f1078b, (Integer[]) this.f1079c.toArray(f1077a));
        }
    }

    public final /* synthetic */ int compareTo(Object obj) {
        bd bdVar = (bd) obj;
        return bdVar == null ? 1 : toString().compareTo(bdVar.toString());
    }

    protected aj(C1480a c1480a, Integer[] numArr) {
        this.f1080a = c1480a;
        Arrays.sort(numArr);
        this.f1081b = numArr;
    }

    public final C1421a m1564a() {
        return C1421a.TRANSIT;
    }

    public final boolean m1567a(bd bdVar) {
        return equals(bdVar);
    }

    public final boolean m1566a(ah ahVar) {
        return ahVar == ah.f1045m && !(this.f1080a == null && this.f1081b.length == 0);
    }

    public final void m1565a(a aVar) {
        if (this.f1080a != null) {
            aVar.b(9, this.f1080a.m2297a());
        }
        for (Integer intValue : this.f1081b) {
            aVar.a(12, intValue.intValue());
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f1080a == null ? BuildConfig.FLAVOR : this.f1080a.toString());
        stringBuilder.append("|");
        for (Integer intValue : this.f1081b) {
            stringBuilder.append(intValue.intValue());
            stringBuilder.append(",");
        }
        return stringBuilder.toString();
    }

    public final int hashCode() {
        int hashCode = (this.f1080a == null ? 0 : this.f1080a.hashCode()) + 31;
        if (this.f1081b.length > 0) {
            return (hashCode * 31) + Arrays.hashCode(this.f1081b);
        }
        return hashCode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            if (this.f1080a == null && this.f1081b.length == 0) {
                return true;
            }
            return false;
        } else if (!(obj instanceof aj)) {
            return false;
        } else {
            aj ajVar = (aj) obj;
            if (C1647e.m3074a(this.f1080a, ajVar.f1080a) && Arrays.equals(this.f1081b, ajVar.f1081b)) {
                return true;
            }
            return false;
        }
    }
}
