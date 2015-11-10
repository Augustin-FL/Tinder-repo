package com.google.android.m4b.maps.p014r;

import java.lang.ref.SoftReference;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.google.android.m4b.maps.r.c */
public abstract class C1559c<T> {
    private final int f1759a;
    private final LinkedList<SoftReference<T>> f1760b;
    private int f1761c;
    private int f1762d;

    protected abstract T m2770a();

    public C1559c(int i, String str) {
        this.f1760b = new LinkedList();
        this.f1759a = i;
    }

    public final void m2771a(List<T> list) {
        synchronized (this.f1760b) {
            for (Object next : list) {
                if (this.f1760b.size() == this.f1759a) {
                    this.f1760b.removeFirst();
                }
                this.f1760b.add(new SoftReference(next));
            }
        }
    }

    public final T m2772b() {
        synchronized (this.f1760b) {
            if (!this.f1760b.isEmpty()) {
                T t = ((SoftReference) this.f1760b.removeLast()).get();
                if (t != null) {
                    this.f1762d++;
                    return t;
                }
            }
            this.f1761c++;
            return m2770a();
        }
    }
}
