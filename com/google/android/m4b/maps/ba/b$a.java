package com.google.android.m4b.maps.ba;

import android.util.Pair;
import com.facebook.stetho.BuildConfig;
import com.google.android.m4b.maps.ag.b;
import com.google.android.m4b.maps.ay.aa;
import com.google.common.collect.C1876q;
import java.util.Map;

public abstract class b$a extends b {
    private final b$d[] f1346a;
    private int f1347b;
    private b f1348c;
    private final Map<Pair<Long, String>, Integer> f1349d;

    protected abstract aa m2135b(int i);

    static /* synthetic */ boolean m2130a(b$a com_google_android_m4b_maps_ba_b_a, int i) {
        return 2 + com_google_android_m4b_maps_ba_b_a.b <= com_google_android_m4b_maps_ba_b_a.a.length;
    }

    protected b$a(int i) {
        this.a = new b$d[8];
        this.b = 0;
        this.d = C1876q.m4328a();
    }

    protected final void m2133a(Pair<Long, String> pair, b$d com_google_android_m4b_maps_ba_b_d) {
        if (pair.second == null) {
            pair = new Pair(pair.first, BuildConfig.FLAVOR);
        }
        if (this.d.get(pair) != null) {
            throw new IllegalArgumentException("Duplicate tile key: " + pair + ", already exists in batch for " + com_google_android_m4b_maps_ba_b_d);
        }
        this.d.put(pair, Integer.valueOf(this.b));
        b$d[] com_google_android_m4b_maps_ba_b_dArr = this.a;
        int i = this.b;
        this.b = i + 1;
        com_google_android_m4b_maps_ba_b_dArr[i] = com_google_android_m4b_maps_ba_b_d;
    }

    public final int m2138k() {
        return this.b;
    }

    public final b$d m2131a(int i) {
        return this.a[i];
    }

    public final Integer m2132a(Pair<Long, String> pair) {
        if (pair.second == null) {
            pair = new Pair(pair.first, BuildConfig.FLAVOR);
        }
        return (Integer) this.d.get(pair);
    }

    protected final boolean m2139l() {
        return this.b == this.a.length;
    }

    protected int m2137j() {
        return -1;
    }

    protected byte[] m2136c(int i) {
        return null;
    }

    protected boolean m2134a(b$d com_google_android_m4b_maps_ba_b_d) {
        return true;
    }
}
