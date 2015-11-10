package com.google.common.collect;

import java.io.Serializable;
import java.util.Map.Entry;

abstract class ImmutableMapEntrySet<K, V> extends ImmutableSet<Entry<K, V>> {

    private static class EntrySetSerializedForm<K, V> implements Serializable {
        private static final long serialVersionUID = 0;
        final ImmutableMap<K, V> f2283a;

        EntrySetSerializedForm(ImmutableMap<K, V> immutableMap) {
            this.f2283a = immutableMap;
        }

        Object readResolve() {
            return this.f2283a.m3632b();
        }
    }

    abstract ImmutableMap<K, V> m3788e();

    ImmutableMapEntrySet() {
    }

    public int size() {
        return m3788e().size();
    }

    public boolean contains(Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        Object obj2 = m3788e().get(entry.getKey());
        if (obj2 == null || !obj2.equals(entry.getValue())) {
            return false;
        }
        return true;
    }

    boolean m3787a() {
        return m3788e().m3635e();
    }

    Object writeReplace() {
        return new EntrySetSerializedForm(m3788e());
    }
}
