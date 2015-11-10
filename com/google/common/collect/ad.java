package com.google.common.collect;

import java.util.ListIterator;

public abstract class ad<E> extends ac<E> implements ListIterator<E> {
    protected ad() {
    }

    @Deprecated
    public final void add(E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void set(E e) {
        throw new UnsupportedOperationException();
    }
}
