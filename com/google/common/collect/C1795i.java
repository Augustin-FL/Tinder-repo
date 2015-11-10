package com.google.common.collect;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/* renamed from: com.google.common.collect.i */
public abstract class C1795i<K, V> extends C1794j<K, V> implements ConcurrentMap<K, V> {
    protected abstract ConcurrentMap<K, V> m3898a();

    protected /* synthetic */ Object m3899b() {
        return m3898a();
    }

    protected /* synthetic */ Map m3900c() {
        return m3898a();
    }

    protected C1795i() {
    }

    public V putIfAbsent(K k, V v) {
        return m3898a().putIfAbsent(k, v);
    }

    public boolean remove(Object obj, Object obj2) {
        return m3898a().remove(obj, obj2);
    }

    public V replace(K k, V v) {
        return m3898a().replace(k, v);
    }

    public boolean replace(K k, V v, V v2) {
        return m3898a().replace(k, v, v2);
    }
}
