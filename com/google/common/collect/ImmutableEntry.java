package com.google.common.collect;

import java.io.Serializable;

class ImmutableEntry<K, V> extends C1766b<K, V> implements Serializable {
    private static final long serialVersionUID = 0;
    private final K f2259a;
    private final V f2260b;

    ImmutableEntry(K k, V v) {
        this.f2259a = k;
        this.f2260b = v;
    }

    public K getKey() {
        return this.f2259a;
    }

    public V getValue() {
        return this.f2260b;
    }

    public final V setValue(V v) {
        throw new UnsupportedOperationException();
    }
}
