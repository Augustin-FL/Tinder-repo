package com.google.android.m4b.maps.ay;

import com.google.android.m4b.maps.bg.c;
import java.util.ArrayList;
import java.util.List;

public final class bp {
    private final List<bq> f1237a;
    private final byte[] f1238b;
    private c f1239c;

    public bp(List<bq> list, byte[] bArr) {
        this.f1237a = list;
        this.f1238b = bArr;
    }

    public final List<bq> m1870a() {
        return this.f1237a;
    }

    public final c m1871b() {
        if (!(this.f1239c != null || this.f1237a.isEmpty() || this.f1238b.length == 0)) {
            List arrayList = new ArrayList(this.f1237a.size());
            for (bq a : this.f1237a) {
                arrayList.add(a.m1872a());
            }
            this.f1239c = new c(arrayList, this.f1238b);
        }
        return this.f1239c;
    }
}
