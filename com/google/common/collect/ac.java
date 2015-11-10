package com.google.common.collect;

import java.util.Iterator;

public abstract class ac<E> implements Iterator<E> {
    protected ac() {
    }

    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
