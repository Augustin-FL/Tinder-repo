package com.google.common.collect;

import com.google.common.base.C1650g;
import com.google.common.collect.ImmutableList.C1774a;
import com.google.common.collect.ImmutableMap.C1762a;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;

public abstract class ImmutableSortedMap<K, V> extends ImmutableSortedMapFauxverideShim<K, V> implements SortedMap<K, V> {
    private static final Comparator<Comparable> f2243a;
    private static final ImmutableSortedMap<Comparable, Object> f2244b;
    private static final long serialVersionUID = 0;

    /* renamed from: com.google.common.collect.ImmutableSortedMap.1 */
    static class C17821 implements Comparator<Entry<K, V>> {
        final /* synthetic */ Comparator f2304a;

        C17821(Comparator comparator) {
            this.f2304a = comparator;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m3848a((Entry) obj, (Entry) obj2);
        }

        public int m3848a(Entry<K, V> entry, Entry<K, V> entry2) {
            return this.f2304a.compare(entry.getKey(), entry2.getKey());
        }
    }

    private static class SerializedForm extends SerializedForm {
        private static final long serialVersionUID = 0;
        private final Comparator<Object> f2305a;

        SerializedForm(ImmutableSortedMap<?, ?> immutableSortedMap) {
            super(immutableSortedMap);
            this.f2305a = immutableSortedMap.comparator();
        }

        Object readResolve() {
            return m3763a(new C1783a(this.f2305a));
        }
    }

    /* renamed from: com.google.common.collect.ImmutableSortedMap.a */
    public static class C1783a<K, V> extends C1762a<K, V> {
        private final Comparator<? super K> f2306b;

        public /* synthetic */ C1762a m3852b(Object obj, Object obj2) {
            return m3849a(obj, obj2);
        }

        public /* synthetic */ C1762a m3853b(Map map) {
            return m3850a(map);
        }

        public /* synthetic */ ImmutableMap m3854b() {
            return m3851a();
        }

        public C1783a(Comparator<? super K> comparator) {
            this.f2306b = (Comparator) C1650g.m3080a((Object) comparator);
        }

        public C1783a<K, V> m3849a(K k, V v) {
            this.a.add(ImmutableMap.m3628c(k, v));
            return this;
        }

        public C1783a<K, V> m3850a(Map<? extends K, ? extends V> map) {
            for (Entry entry : map.entrySet()) {
                m3849a(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public ImmutableSortedMap<K, V> m3851a() {
            ImmutableSortedMap.m3710c(this.a, this.f2306b);
            ImmutableSortedMap.m3711d(this.a, this.f2306b);
            return ImmutableSortedMap.m3707a(this.f2306b, this.a);
        }
    }

    public abstract ImmutableSortedMap<K, V> m3715a(K k, boolean z);

    public abstract ImmutableSortedMap<K, V> m3719b(K k, boolean z);

    public abstract ImmutableCollection<V> m3722f();

    public abstract ImmutableSortedSet<K> k_();

    public /* synthetic */ ImmutableSet m3720d() {
        return k_();
    }

    public /* synthetic */ Set entrySet() {
        return m3717b();
    }

    public /* synthetic */ SortedMap headMap(Object obj) {
        return m3713a(obj);
    }

    public /* synthetic */ Set keySet() {
        return k_();
    }

    public /* synthetic */ SortedMap subMap(Object obj, Object obj2) {
        return m3714a(obj, obj2);
    }

    public /* synthetic */ SortedMap tailMap(Object obj) {
        return m3718b(obj);
    }

    public /* synthetic */ Collection values() {
        return m3722f();
    }

    static {
        f2243a = C1757u.m3621b();
        f2244b = new EmptyImmutableSortedMap(f2243a);
    }

    static <K, V> ImmutableSortedMap<K, V> m3706a(Comparator<? super K> comparator) {
        if (C1757u.m3621b().equals(comparator)) {
            return m3712g();
        }
        return new EmptyImmutableSortedMap(comparator);
    }

    static <K, V> ImmutableSortedMap<K, V> m3707a(Comparator<? super K> comparator, Collection<? extends Entry<? extends K, ? extends V>> collection) {
        if (collection.isEmpty()) {
            return m3706a((Comparator) comparator);
        }
        C1774a h = ImmutableList.m3657h();
        C1774a h2 = ImmutableList.m3657h();
        for (Entry entry : collection) {
            h.m3815b(entry.getKey());
            h2.m3815b(entry.getValue());
        }
        return new RegularImmutableSortedMap(new RegularImmutableSortedSet(h.m3813a(), comparator), h2.m3813a());
    }

    static <K, V> ImmutableSortedMap<K, V> m3705a(ImmutableSortedSet<K> immutableSortedSet, ImmutableList<V> immutableList) {
        if (immutableSortedSet.isEmpty()) {
            return m3706a(immutableSortedSet.comparator());
        }
        return new RegularImmutableSortedMap((RegularImmutableSortedSet) immutableSortedSet, immutableList);
    }

    public static <K, V> ImmutableSortedMap<K, V> m3712g() {
        return f2244b;
    }

    private static <K, V> void m3710c(List<Entry<K, V>> list, Comparator<? super K> comparator) {
        Collections.sort(list, new C17821(comparator));
    }

    private static <K, V> void m3711d(List<Entry<K, V>> list, Comparator<? super K> comparator) {
        for (int i = 1; i < list.size(); i++) {
            if (comparator.compare(((Entry) list.get(i - 1)).getKey(), ((Entry) list.get(i)).getKey()) == 0) {
                throw new IllegalArgumentException("Duplicate keys in mappings " + list.get(i - 1) + " and " + list.get(i));
            }
        }
    }

    ImmutableSortedMap() {
    }

    public int size() {
        return m3722f().size();
    }

    public boolean containsValue(Object obj) {
        return m3722f().contains(obj);
    }

    boolean m3721e() {
        return k_().m3646a() || m3722f().m3646a();
    }

    public ImmutableSet<Entry<K, V>> m3717b() {
        return super.m3632b();
    }

    public Comparator<? super K> comparator() {
        return k_().comparator();
    }

    public K firstKey() {
        return k_().first();
    }

    public K lastKey() {
        return k_().last();
    }

    public ImmutableSortedMap<K, V> m3713a(K k) {
        return m3715a((Object) k, false);
    }

    public ImmutableSortedMap<K, V> m3714a(K k, K k2) {
        return m3716a(k, true, k2, false);
    }

    public ImmutableSortedMap<K, V> m3716a(K k, boolean z, K k2, boolean z2) {
        boolean z3;
        C1650g.m3080a((Object) k);
        C1650g.m3080a((Object) k2);
        if (comparator().compare(k, k2) <= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        C1650g.m3087a(z3, "expected fromKey <= toKey but %s > %s", k, k2);
        return m3715a((Object) k2, z2).m3719b((Object) k, z);
    }

    public ImmutableSortedMap<K, V> m3718b(K k) {
        return m3719b((Object) k, true);
    }

    Object writeReplace() {
        return new SerializedForm(this);
    }
}
