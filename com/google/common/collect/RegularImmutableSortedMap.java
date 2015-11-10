package com.google.common.collect;

import com.google.common.base.C1650g;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class RegularImmutableSortedMap<K, V> extends ImmutableSortedMap<K, V> {
    private final transient RegularImmutableSortedSet<K> f2474a;
    private final transient ImmutableList<V> f2475b;

    private class EntrySet extends ImmutableMapEntrySet<K, V> {
        final /* synthetic */ RegularImmutableSortedMap f2473a;

        /* renamed from: com.google.common.collect.RegularImmutableSortedMap.EntrySet.1 */
        class C18391 extends ImmutableAsList<Entry<K, V>> {
            final /* synthetic */ EntrySet f2471a;
            private final ImmutableList<K> f2472c;

            C18391(EntrySet entrySet) {
                this.f2471a = entrySet;
                this.f2472c = this.f2471a.f2473a.k_().m3648c();
            }

            public /* synthetic */ Object get(int i) {
                return m4198b(i);
            }

            public Entry<K, V> m4198b(int i) {
                return C1876q.m4332a(this.f2472c.get(i), this.f2471a.f2473a.f2475b.get(i));
            }

            ImmutableCollection<Entry<K, V>> m4199e() {
                return this.f2471a;
            }
        }

        private EntrySet(RegularImmutableSortedMap regularImmutableSortedMap) {
            this.f2473a = regularImmutableSortedMap;
        }

        public /* synthetic */ Iterator iterator() {
            return m4200b();
        }

        public ac<Entry<K, V>> m4200b() {
            return m3648c().m3661b();
        }

        ImmutableList<Entry<K, V>> m4202f() {
            return new C18391(this);
        }

        ImmutableMap<K, V> m4201e() {
            return this.f2473a;
        }
    }

    public /* synthetic */ ImmutableSet m4208d() {
        return k_();
    }

    public /* synthetic */ Set keySet() {
        return k_();
    }

    public /* synthetic */ Collection values() {
        return m4209f();
    }

    RegularImmutableSortedMap(RegularImmutableSortedSet<K> regularImmutableSortedSet, ImmutableList<V> immutableList) {
        this.f2474a = regularImmutableSortedSet;
        this.f2475b = immutableList;
    }

    ImmutableSet<Entry<K, V>> m4207c() {
        return new EntrySet();
    }

    public ImmutableSortedSet<K> k_() {
        return this.f2474a;
    }

    public ImmutableCollection<V> m4209f() {
        return this.f2475b;
    }

    public V get(Object obj) {
        int a = this.f2474a.m4211a(obj);
        return a == -1 ? null : this.f2475b.get(a);
    }

    private ImmutableSortedMap<K, V> m4204a(int i, int i2) {
        if (i == 0 && i2 == size()) {
            return this;
        }
        if (i == i2) {
            return ImmutableSortedMap.m3706a(comparator());
        }
        return ImmutableSortedMap.m3705a(this.f2474a.m4212a(i, i2), this.f2475b.m3658a(i, i2));
    }

    public ImmutableSortedMap<K, V> m4205a(K k, boolean z) {
        return m4204a(0, this.f2474a.m4218e(C1650g.m3080a((Object) k), z));
    }

    public ImmutableSortedMap<K, V> m4206b(K k, boolean z) {
        return m4204a(this.f2474a.m4220f(C1650g.m3080a((Object) k), z), size());
    }
}
