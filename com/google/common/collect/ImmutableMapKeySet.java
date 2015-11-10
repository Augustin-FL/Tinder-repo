package com.google.common.collect;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map.Entry;

final class ImmutableMapKeySet<K, V> extends ImmutableSet<K> {
    private final ImmutableMap<K, V> f2287a;

    /* renamed from: com.google.common.collect.ImmutableMapKeySet.1 */
    class C17751 extends ImmutableAsList<K> {
        final /* synthetic */ ImmutableList f2284a;
        final /* synthetic */ ImmutableMapKeySet f2285c;

        C17751(ImmutableMapKeySet immutableMapKeySet, ImmutableList immutableList) {
            this.f2285c = immutableMapKeySet;
            this.f2284a = immutableList;
        }

        public K get(int i) {
            return ((Entry) this.f2284a.get(i)).getKey();
        }

        ImmutableCollection<K> m3817e() {
            return this.f2285c;
        }
    }

    private static class KeySetSerializedForm<K> implements Serializable {
        private static final long serialVersionUID = 0;
        final ImmutableMap<K, ?> f2286a;

        KeySetSerializedForm(ImmutableMap<K, ?> immutableMap) {
            this.f2286a = immutableMap;
        }

        Object readResolve() {
            return this.f2286a.m3634d();
        }
    }

    public /* synthetic */ Iterator iterator() {
        return m3819b();
    }

    ImmutableMapKeySet(ImmutableMap<K, V> immutableMap) {
        this.f2287a = immutableMap;
    }

    public int size() {
        return this.f2287a.size();
    }

    public ac<K> m3819b() {
        return m3648c().m3661b();
    }

    public boolean contains(Object obj) {
        return this.f2287a.containsKey(obj);
    }

    ImmutableList<K> m3820f() {
        return new C17751(this, this.f2287a.m3632b().m3648c());
    }

    boolean m3818a() {
        return true;
    }

    Object writeReplace() {
        return new KeySetSerializedForm(this.f2287a);
    }
}
