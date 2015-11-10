package com.google.common.collect;

import com.google.common.base.C1650g;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

class RegularImmutableBiMap<K, V> extends ImmutableBiMap<K, V> {
    private final transient BiMapEntry<K, V>[] f2454a;
    private final transient BiMapEntry<K, V>[] f2455b;
    private final transient BiMapEntry<K, V>[] f2456c;
    private final transient int f2457d;
    private final transient int f2458e;
    private transient ImmutableBiMap<V, K> f2459f;

    /* renamed from: com.google.common.collect.RegularImmutableBiMap.1 */
    class C18341 extends ImmutableMapEntrySet<K, V> {
        final /* synthetic */ RegularImmutableBiMap f2447a;

        C18341(RegularImmutableBiMap regularImmutableBiMap) {
            this.f2447a = regularImmutableBiMap;
        }

        public /* synthetic */ Iterator iterator() {
            return m4160b();
        }

        ImmutableMap<K, V> m4162e() {
            return this.f2447a;
        }

        public ac<Entry<K, V>> m4160b() {
            return m3648c().m3661b();
        }

        ImmutableList<Entry<K, V>> m4163f() {
            return new RegularImmutableAsList((ImmutableCollection) this, this.f2447a.f2456c);
        }

        boolean m4161d() {
            return true;
        }

        public int hashCode() {
            return this.f2447a.f2458e;
        }
    }

    private static class BiMapEntry<K, V> extends ImmutableEntry<K, V> {
        BiMapEntry(K k, V v) {
            super(k, v);
        }

        BiMapEntry<K, V> m4164a() {
            return null;
        }

        BiMapEntry<K, V> m4165b() {
            return null;
        }
    }

    private final class Inverse extends ImmutableBiMap<V, K> {
        final /* synthetic */ RegularImmutableBiMap f2450a;

        final class InverseEntrySet extends ImmutableMapEntrySet<V, K> {
            final /* synthetic */ Inverse f2449a;

            /* renamed from: com.google.common.collect.RegularImmutableBiMap.Inverse.InverseEntrySet.1 */
            class C18351 extends ImmutableAsList<Entry<V, K>> {
                final /* synthetic */ InverseEntrySet f2448a;

                C18351(InverseEntrySet inverseEntrySet) {
                    this.f2448a = inverseEntrySet;
                }

                public /* synthetic */ Object get(int i) {
                    return m4166b(i);
                }

                public Entry<V, K> m4166b(int i) {
                    Entry entry = this.f2448a.f2449a.f2450a.f2456c[i];
                    return C1876q.m4332a(entry.getValue(), entry.getKey());
                }

                ImmutableCollection<Entry<V, K>> m4167e() {
                    return this.f2448a;
                }
            }

            InverseEntrySet(Inverse inverse) {
                this.f2449a = inverse;
            }

            public /* synthetic */ Iterator iterator() {
                return m4168b();
            }

            ImmutableMap<V, K> m4170e() {
                return this.f2449a;
            }

            boolean m4169d() {
                return true;
            }

            public int hashCode() {
                return this.f2449a.f2450a.f2458e;
            }

            public ac<Entry<V, K>> m4168b() {
                return m3648c().m3661b();
            }

            ImmutableList<Entry<V, K>> m4171f() {
                return new C18351(this);
            }
        }

        private Inverse(RegularImmutableBiMap regularImmutableBiMap) {
            this.f2450a = regularImmutableBiMap;
        }

        public int size() {
            return i_().size();
        }

        public ImmutableBiMap<K, V> i_() {
            return this.f2450a;
        }

        public K get(Object obj) {
            if (obj == null) {
                return null;
            }
            for (BiMapEntry biMapEntry = this.f2450a.f2455b[C1856m.m4276a(obj.hashCode()) & this.f2450a.f2457d]; biMapEntry != null; biMapEntry = biMapEntry.m4165b()) {
                if (obj.equals(biMapEntry.getValue())) {
                    return biMapEntry.getKey();
                }
            }
            return null;
        }

        ImmutableSet<Entry<V, K>> m4172c() {
            return new InverseEntrySet(this);
        }

        boolean m4173e() {
            return false;
        }

        Object writeReplace() {
            return new InverseSerializedForm(this.f2450a);
        }
    }

    private static class InverseSerializedForm<K, V> implements Serializable {
        private static final long serialVersionUID = 1;
        private final ImmutableBiMap<K, V> f2451a;

        InverseSerializedForm(ImmutableBiMap<K, V> immutableBiMap) {
            this.f2451a = immutableBiMap;
        }

        Object readResolve() {
            return this.f2451a.i_();
        }
    }

    private static class NonTerminalBiMapEntry<K, V> extends BiMapEntry<K, V> {
        private final BiMapEntry<K, V> f2452a;
        private final BiMapEntry<K, V> f2453b;

        NonTerminalBiMapEntry(K k, V v, BiMapEntry<K, V> biMapEntry, BiMapEntry<K, V> biMapEntry2) {
            super(k, v);
            this.f2452a = biMapEntry;
            this.f2453b = biMapEntry2;
        }

        BiMapEntry<K, V> m4174a() {
            return this.f2452a;
        }

        BiMapEntry<K, V> m4175b() {
            return this.f2453b;
        }
    }

    RegularImmutableBiMap(Collection<? extends Entry<? extends K, ? extends V>> collection) {
        int size = collection.size();
        int a = C1856m.m4277a(size, 1.2d);
        this.f2457d = a - 1;
        BiMapEntry[] a2 = m4176a(a);
        BiMapEntry[] a3 = m4176a(a);
        BiMapEntry[] a4 = m4176a(size);
        int i = 0;
        a = 0;
        for (Entry entry : collection) {
            BiMapEntry biMapEntry;
            Object a5 = C1650g.m3080a(entry.getKey());
            Object a6 = C1650g.m3080a(entry.getValue());
            int hashCode = a5.hashCode();
            int hashCode2 = a6.hashCode();
            int a7 = C1856m.m4276a(hashCode) & this.f2457d;
            int a8 = C1856m.m4276a(hashCode2) & this.f2457d;
            BiMapEntry biMapEntry2 = a2[a7];
            for (biMapEntry = biMapEntry2; biMapEntry != null; biMapEntry = biMapEntry.m4164a()) {
                if (a5.equals(biMapEntry.getKey())) {
                    throw new IllegalArgumentException("Multiple entries with same key: " + entry + " and " + biMapEntry);
                }
            }
            BiMapEntry biMapEntry3 = a3[a8];
            for (biMapEntry = biMapEntry3; biMapEntry != null; biMapEntry = biMapEntry.m4165b()) {
                if (a6.equals(biMapEntry.getValue())) {
                    throw new IllegalArgumentException("Multiple entries with same value: " + entry + " and " + biMapEntry);
                }
            }
            BiMapEntry biMapEntry4 = (biMapEntry2 == null && biMapEntry3 == null) ? new BiMapEntry(a5, a6) : new NonTerminalBiMapEntry(a5, a6, biMapEntry2, biMapEntry3);
            a2[a7] = biMapEntry4;
            a3[a8] = biMapEntry4;
            int i2 = i + 1;
            a4[i] = biMapEntry4;
            a = (hashCode ^ hashCode2) + a;
            i = i2;
        }
        this.f2454a = a2;
        this.f2455b = a3;
        this.f2456c = a4;
        this.f2458e = a;
    }

    private static <K, V> BiMapEntry<K, V>[] m4176a(int i) {
        return new BiMapEntry[i];
    }

    public V get(Object obj) {
        if (obj == null) {
            return null;
        }
        for (BiMapEntry biMapEntry = this.f2454a[C1856m.m4276a(obj.hashCode()) & this.f2457d]; biMapEntry != null; biMapEntry = biMapEntry.m4164a()) {
            if (obj.equals(biMapEntry.getKey())) {
                return biMapEntry.getValue();
            }
        }
        return null;
    }

    ImmutableSet<Entry<K, V>> m4181c() {
        return new C18341(this);
    }

    boolean m4182e() {
        return false;
    }

    public int size() {
        return this.f2456c.length;
    }

    public ImmutableBiMap<V, K> i_() {
        ImmutableBiMap<V, K> immutableBiMap = this.f2459f;
        if (immutableBiMap != null) {
            return immutableBiMap;
        }
        immutableBiMap = new Inverse();
        this.f2459f = immutableBiMap;
        return immutableBiMap;
    }
}
