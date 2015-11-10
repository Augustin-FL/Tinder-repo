package com.google.common.collect;

import com.google.common.base.C1650g;
import java.util.Iterator;

abstract class ab<F, T> implements Iterator<T> {
    final Iterator<? extends F> f2497b;

    abstract T m4260a(F f);

    ab(Iterator<? extends F> it) {
        this.f2497b = (Iterator) C1650g.m3080a((Object) it);
    }

    public final boolean hasNext() {
        return this.f2497b.hasNext();
    }

    public final T next() {
        return m4260a(this.f2497b.next());
    }

    public final void remove() {
        this.f2497b.remove();
    }
}
