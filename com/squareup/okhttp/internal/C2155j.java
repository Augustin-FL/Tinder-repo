package com.squareup.okhttp.internal;

import com.squareup.okhttp.C2228w;
import java.util.LinkedHashSet;
import java.util.Set;

/* renamed from: com.squareup.okhttp.internal.j */
public final class C2155j {
    private final Set<C2228w> f3350a;

    public C2155j() {
        this.f3350a = new LinkedHashSet();
    }

    public synchronized void m5341a(C2228w c2228w) {
        this.f3350a.add(c2228w);
    }

    public synchronized void m5342b(C2228w c2228w) {
        this.f3350a.remove(c2228w);
    }

    public synchronized boolean m5343c(C2228w c2228w) {
        return this.f3350a.contains(c2228w);
    }
}
