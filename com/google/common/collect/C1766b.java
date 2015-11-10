package com.google.common.collect;

import com.google.common.base.C1647e;
import java.util.Map.Entry;

/* renamed from: com.google.common.collect.b */
abstract class C1766b<K, V> implements Entry<K, V> {
    public abstract K getKey();

    public abstract V getValue();

    C1766b() {
    }

    public V setValue(V v) {
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
