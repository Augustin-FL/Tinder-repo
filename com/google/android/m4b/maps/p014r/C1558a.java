package com.google.android.m4b.maps.p014r;

import java.util.LinkedList;

/* renamed from: com.google.android.m4b.maps.r.a */
public abstract class C1558a<T> {
    protected final LinkedList<T> f1750a;
    protected int f1751b;
    public T f1752c;
    public int f1753d;
    private final C1559c<T> f1754e;
    private final int f1755f;
    private final int f1756g;
    private final int f1757h;
    private int f1758i;

    public C1558a(int i, int i2, C1559c<T> c1559c) {
        this.f1750a = new LinkedList();
        this.f1757h = i2;
        this.f1755f = 1 << i2;
        this.f1756g = this.f1755f - 1;
        this.f1754e = c1559c;
        this.f1758i = m2762d(i);
        m2764a();
    }

    public final void m2764a() {
        this.f1751b = 0;
        this.f1753d = 0;
        this.f1752c = m2763a(0);
    }

    private int m2762d(int i) {
        return ((this.f1756g & i) != 0 ? 1 : 0) + (i >> this.f1757h);
    }

    public final T m2763a(int i) {
        if (i > this.f1758i) {
            throw new IndexOutOfBoundsException("Index out of bound : " + i + "(index) > " + this.f1758i + "(size)");
        }
        while (i >= this.f1750a.size()) {
            this.f1750a.add(this.f1754e.m2772b());
        }
        return this.f1750a.get(i);
    }

    public final void m2767b(int i) {
        if (i >= this.f1755f) {
            int i2 = this.f1756g & i;
            this.f1751b++;
            if (this.f1751b != this.f1758i) {
                Object obj = this.f1752c;
                this.f1752c = m2763a(this.f1751b);
                if (i2 != 0) {
                    System.arraycopy(obj, this.f1755f, this.f1752c, 0, i2);
                }
            }
            this.f1753d = i2;
            return;
        }
        this.f1753d = i;
    }

    public final void m2765a(T t, int i) {
        m2764a();
        int i2 = 0;
        while (i2 < i) {
            int i3 = this.f1755f;
            if (this.f1755f + i2 > i) {
                i3 = i - i2;
            }
            System.arraycopy(t, i2, m2763a(this.f1751b), 0, i3);
            i2 += i3;
            if (i3 == this.f1755f) {
                this.f1751b++;
                this.f1753d = 0;
            } else {
                this.f1753d = i3;
            }
        }
    }

    public final void m2769c(int i) {
        this.f1758i = Math.max(m2762d(i), this.f1758i);
    }

    public final int m2766b() {
        return this.f1750a.size() << this.f1757h;
    }

    public final void m2768c() {
        this.f1754e.m2771a(this.f1750a);
        this.f1750a.clear();
    }
}
