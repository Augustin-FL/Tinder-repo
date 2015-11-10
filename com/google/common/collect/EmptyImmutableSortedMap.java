package com.google.common.collect;

import com.google.common.base.C1650g;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.Set;

final class EmptyImmutableSortedMap<K, V> extends ImmutableSortedMap<K, V> {
    private final transient ImmutableSortedSet<K> f2245a;

    public /* synthetic */ ImmutableSet m3727d() {
        return k_();
    }

    public /* synthetic */ Set entrySet() {
        return m3724b();
    }

    public /* synthetic */ Set keySet() {
        return k_();
    }

    public /* synthetic */ Collection values() {
        return m3729f();
    }

    EmptyImmutableSortedMap(Comparator<? super K> comparator) {
        this.f2245a = ImmutableSortedSet.m3732a((Comparator) comparator);
    }

    public V get(Object obj) {
        return null;
    }

    public ImmutableSortedSet<K> k_() {
        return this.f2245a;
    }

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return true;
    }

    public ImmutableCollection<V> m3729f() {
        return ImmutableList.m3656g();
    }

    public String toString() {
        return "{}";
    }

    boolean m3728e() {
        return false;
    }

    public ImmutableSet<Entry<K, V>> m3724b() {
        return ImmutableSet.m3678g();
    }

    ImmutableSet<Entry<K, V>> m3726c() {
        throw new AssertionError("should never be called");
    }

    public ImmutableSortedMap<K, V> m3723a(K k, boolean z) {
        C1650g.m3080a((Object) k);
        return this;
    }

    public ImmutableSortedMap<K, V> m3725b(K k, boolean z) {
        C1650g.m3080a((Object) k);
        return this;
    }
}
