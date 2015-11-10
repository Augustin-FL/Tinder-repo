package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: com.google.common.collect.j */
public abstract class C1794j<K, V> extends C1682k implements Map<K, V> {
    protected abstract Map<K, V> m3897c();

    protected /* synthetic */ Object m3896b() {
        return m3897c();
    }

    protected C1794j() {
    }

    public int size() {
        return m3897c().size();
    }

    public boolean isEmpty() {
        return m3897c().isEmpty();
    }

    public V remove(Object obj) {
        return m3897c().remove(obj);
    }

    public void clear() {
        m3897c().clear();
    }

    public boolean containsKey(Object obj) {
        return m3897c().containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return m3897c().containsValue(obj);
    }

    public V get(Object obj) {
        return m3897c().get(obj);
    }

    public V put(K k, V v) {
        return m3897c().put(k, v);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        m3897c().putAll(map);
    }

    public Set<K> keySet() {
        return m3897c().keySet();
    }

    public Collection<V> values() {
        return m3897c().values();
    }

    public Set<Entry<K, V>> entrySet() {
        return m3897c().entrySet();
    }

    public boolean equals(Object obj) {
        return obj == this || m3897c().equals(obj);
    }

    public int hashCode() {
        return m3897c().hashCode();
    }
}
