package com.google.common.collect;

import com.google.common.base.C1650g;
import java.util.Iterator;
import java.util.Map.Entry;

final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {
    private static final long serialVersionUID = 0;
    private final transient C1837a<K, V>[] f2465a;
    private final transient C1837a<K, V>[] f2466b;
    private final transient int f2467c;

    private class EntrySet extends ImmutableMapEntrySet<K, V> {
        final /* synthetic */ RegularImmutableMap f2463a;

        public /* synthetic */ Iterator iterator() {
            return m4186b();
        }

        private EntrySet(RegularImmutableMap regularImmutableMap) {
            this.f2463a = regularImmutableMap;
        }

        ImmutableMap<K, V> m4187e() {
            return this.f2463a;
        }

        public ac<Entry<K, V>> m4186b() {
            return m3648c().m3661b();
        }

        ImmutableList<Entry<K, V>> m4188f() {
            return new RegularImmutableAsList((ImmutableCollection) this, this.f2463a.f2465a);
        }
    }

    /* renamed from: com.google.common.collect.RegularImmutableMap.a */
    private interface C1837a<K, V> extends Entry<K, V> {
        C1837a<K, V> m4189a();
    }

    private static final class NonTerminalEntry<K, V> extends ImmutableEntry<K, V> implements C1837a<K, V> {
        final C1837a<K, V> f2464a;

        NonTerminalEntry(K k, V v, C1837a<K, V> c1837a) {
            super(k, v);
            this.f2464a = c1837a;
        }

        public C1837a<K, V> m4190a() {
            return this.f2464a;
        }
    }

    private static final class TerminalEntry<K, V> extends ImmutableEntry<K, V> implements C1837a<K, V> {
        TerminalEntry(K k, V v) {
            super(k, v);
        }

        public C1837a<K, V> m4191a() {
            return null;
        }
    }

    RegularImmutableMap(Entry<?, ?>... entryArr) {
        int length = entryArr.length;
        this.f2465a = m4193a(length);
        int a = C1856m.m4277a(length, 1.2d);
        this.f2466b = m4193a(a);
        this.f2467c = a - 1;
        for (int i = 0; i < length; i++) {
            Entry entry = entryArr[i];
            Object key = entry.getKey();
            int a2 = this.f2467c & C1856m.m4276a(key.hashCode());
            C1837a c1837a = this.f2466b[a2];
            C1837a a3 = m4192a(key, entry.getValue(), c1837a);
            this.f2466b[a2] = a3;
            this.f2465a[i] = a3;
            for (a3 = c1837a; a3 != null; a3 = a3.m4189a()) {
                boolean z;
                if (key.equals(a3.getKey())) {
                    z = false;
                } else {
                    z = true;
                }
                C1650g.m3087a(z, "duplicate key: %s", key);
            }
        }
    }

    private C1837a<K, V>[] m4193a(int i) {
        return new C1837a[i];
    }

    private static <K, V> C1837a<K, V> m4192a(K k, V v, C1837a<K, V> c1837a) {
        return c1837a == null ? new TerminalEntry(k, v) : new NonTerminalEntry(k, v, c1837a);
    }

    public V get(Object obj) {
        if (obj == null) {
            return null;
        }
        for (C1837a c1837a = this.f2466b[C1856m.m4276a(obj.hashCode()) & this.f2467c]; c1837a != null; c1837a = c1837a.m4189a()) {
            if (obj.equals(c1837a.getKey())) {
                return c1837a.getValue();
            }
        }
        return null;
    }

    public int size() {
        return this.f2465a.length;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean containsValue(Object obj) {
        if (obj == null) {
            return false;
        }
        for (Entry value : this.f2465a) {
            if (value.getValue().equals(obj)) {
                return true;
            }
        }
        return false;
    }

    boolean m4196e() {
        return false;
    }

    ImmutableSet<Entry<K, V>> m4195c() {
        return new EntrySet();
    }
}
