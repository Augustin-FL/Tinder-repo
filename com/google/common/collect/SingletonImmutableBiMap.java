package com.google.common.collect;

import java.util.Map.Entry;

final class SingletonImmutableBiMap<K, V> extends ImmutableBiMap<K, V> {
    final transient K f2481a;
    final transient V f2482b;
    transient ImmutableBiMap<V, K> f2483c;

    SingletonImmutableBiMap(K k, V v) {
        this.f2481a = k;
        this.f2482b = v;
    }

    private SingletonImmutableBiMap(K k, V v, ImmutableBiMap<V, K> immutableBiMap) {
        this.f2481a = k;
        this.f2482b = v;
        this.f2483c = immutableBiMap;
    }

    SingletonImmutableBiMap(Entry<K, V> entry) {
        this(entry.getKey(), entry.getValue());
    }

    public V get(Object obj) {
        return this.f2481a.equals(obj) ? this.f2482b : null;
    }

    public int size() {
        return 1;
    }

    public boolean containsKey(Object obj) {
        return this.f2481a.equals(obj);
    }

    public boolean containsValue(Object obj) {
        return this.f2482b.equals(obj);
    }

    boolean m4240e() {
        return false;
    }

    ImmutableSet<Entry<K, V>> m4239c() {
        return ImmutableSet.m3676b(C1876q.m4332a(this.f2481a, this.f2482b));
    }

    ImmutableSet<K> m4238a() {
        return ImmutableSet.m3676b(this.f2481a);
    }

    public ImmutableBiMap<V, K> i_() {
        ImmutableBiMap<V, K> immutableBiMap = this.f2483c;
        if (immutableBiMap != null) {
            return immutableBiMap;
        }
        immutableBiMap = new SingletonImmutableBiMap(this.f2482b, this.f2481a, this);
        this.f2483c = immutableBiMap;
        return immutableBiMap;
    }
}
