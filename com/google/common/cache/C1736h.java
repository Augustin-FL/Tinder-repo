package com.google.common.cache;

import com.google.common.base.C1647e;
import com.google.common.base.C1650g;
import java.util.Map.Entry;

/* renamed from: com.google.common.cache.h */
public final class C1736h<K, V> implements Entry<K, V> {
    private final K f2184a;
    private final V f2185b;
    private final RemovalCause f2186c;

    C1736h(K k, V v, RemovalCause removalCause) {
        this.f2184a = k;
        this.f2185b = v;
        this.f2186c = (RemovalCause) C1650g.m3080a((Object) removalCause);
    }

    public K getKey() {
        return this.f2184a;
    }

    public V getValue() {
        return this.f2185b;
    }

    public final V setValue(V v) {
        throw new UnsupportedOperationException();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        if (C1647e.m3074a(getKey(), entry.getKey()) && C1647e.m3074a(getValue(), entry.getValue())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        Object key = getKey();
        Object value = getValue();
        int hashCode = key == null ? 0 : key.hashCode();
        if (value != null) {
            i = value.hashCode();
        }
        return i ^ hashCode;
    }

    public String toString() {
        return getKey() + "=" + getValue();
    }
}
