package com.google.common.collect;

import java.util.NoSuchElementException;

/* renamed from: com.google.common.collect.d */
public abstract class C1695d<T> extends ac<T> {
    private T f2063a;

    protected abstract T m3357a(T t);

    protected C1695d(T t) {
        this.f2063a = t;
    }

    public final boolean hasNext() {
        return this.f2063a != null;
    }

    public final T next() {
        if (hasNext()) {
            try {
                T t = this.f2063a;
                return t;
            } finally {
                this.f2063a = m3357a(this.f2063a);
            }
        } else {
            throw new NoSuchElementException();
        }
    }
}
