package com.google.common.collect;

import com.google.common.base.C1650g;
import java.util.NoSuchElementException;

/* renamed from: com.google.common.collect.a */
abstract class C1771a<E> extends ad<E> {
    private final int f2270a;
    private int f2271b;

    protected abstract E m3799a(int i);

    protected C1771a(int i) {
        this(i, 0);
    }

    protected C1771a(int i, int i2) {
        C1650g.m3088b(i2, i);
        this.f2270a = i;
        this.f2271b = i2;
    }

    public final boolean hasNext() {
        return this.f2271b < this.f2270a;
    }

    public final E next() {
        if (hasNext()) {
            int i = this.f2271b;
            this.f2271b = i + 1;
            return m3799a(i);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.f2271b;
    }

    public final boolean hasPrevious() {
        return this.f2271b > 0;
    }

    public final E previous() {
        if (hasPrevious()) {
            int i = this.f2271b - 1;
            this.f2271b = i;
            return m3799a(i);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.f2271b - 1;
    }
}
