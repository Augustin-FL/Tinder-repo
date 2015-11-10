package com.google.common.collect;

import com.google.common.base.C1626a;
import com.google.common.base.C1647e;
import com.google.common.base.C1647e.C1646a;
import com.google.common.base.C1650g;
import com.google.common.base.C1660m;
import com.google.common.base.Equivalence;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

public final class MapMaker extends GenericMapMaker<Object, Object> {
    boolean f2319b;
    int f2320c;
    int f2321d;
    int f2322e;
    Strength f2323f;
    Strength f2324g;
    long f2325h;
    long f2326i;
    RemovalCause f2327j;
    Equivalence<Object> f2328k;
    C1660m f2329l;

    /* renamed from: com.google.common.collect.MapMaker.a */
    interface C1761a<K, V> {
        void m3758a(RemovalNotification<K, V> removalNotification);
    }

    static class NullConcurrentMap<K, V> extends AbstractMap<K, V> implements Serializable, ConcurrentMap<K, V> {
        private static final long serialVersionUID = 0;
        private final C1761a<K, V> f2310a;
        private final RemovalCause f2311b;

        NullConcurrentMap(MapMaker mapMaker) {
            this.f2310a = mapMaker.m3760a();
            this.f2311b = mapMaker.f2327j;
        }

        public boolean containsKey(Object obj) {
            return false;
        }

        public boolean containsValue(Object obj) {
            return false;
        }

        public V get(Object obj) {
            return null;
        }

        void m3868a(K k, V v) {
            this.f2310a.m3758a(new RemovalNotification(k, v, this.f2311b));
        }

        public V put(K k, V v) {
            C1650g.m3080a((Object) k);
            C1650g.m3080a((Object) v);
            m3868a(k, v);
            return null;
        }

        public V putIfAbsent(K k, V v) {
            return put(k, v);
        }

        public V remove(Object obj) {
            return null;
        }

        public boolean remove(Object obj, Object obj2) {
            return false;
        }

        public V replace(K k, V v) {
            C1650g.m3080a((Object) k);
            C1650g.m3080a((Object) v);
            return null;
        }

        public boolean replace(K k, V v, V v2) {
            C1650g.m3080a((Object) k);
            C1650g.m3080a((Object) v2);
            return false;
        }

        public Set<Entry<K, V>> entrySet() {
            return Collections.emptySet();
        }
    }

    enum RemovalCause {
        EXPLICIT {
        },
        REPLACED {
        },
        COLLECTED {
        },
        EXPIRED {
        },
        SIZE {
        };
    }

    static final class RemovalNotification<K, V> extends ImmutableEntry<K, V> {
        private static final long serialVersionUID = 0;
        private final RemovalCause f2318a;

        RemovalNotification(K k, V v, RemovalCause removalCause) {
            super(k, v);
            this.f2318a = removalCause;
        }
    }

    public MapMaker() {
        this.f2320c = -1;
        this.f2321d = -1;
        this.f2322e = -1;
        this.f2325h = -1;
        this.f2326i = -1;
    }

    MapMaker m3873a(Equivalence<Object> equivalence) {
        boolean z;
        if (this.f2328k == null) {
            z = true;
        } else {
            z = false;
        }
        C1650g.m3093b(z, "key equivalence was already set to %s", this.f2328k);
        this.f2328k = (Equivalence) C1650g.m3080a((Object) equivalence);
        this.f2319b = true;
        return this;
    }

    Equivalence<Object> m3875b() {
        return (Equivalence) C1647e.m3075b(this.f2328k, m3882e().m4003a());
    }

    public MapMaker m3871a(int i) {
        boolean z;
        boolean z2 = true;
        if (this.f2320c == -1) {
            z = true;
        } else {
            z = false;
        }
        C1650g.m3093b(z, "initial capacity was already set to %s", Integer.valueOf(this.f2320c));
        if (i < 0) {
            z2 = false;
        }
        C1650g.m3085a(z2);
        this.f2320c = i;
        return this;
    }

    int m3879c() {
        return this.f2320c == -1 ? 16 : this.f2320c;
    }

    @Deprecated
    MapMaker m3876b(int i) {
        boolean z = false;
        C1650g.m3093b(this.f2322e == -1, "maximum size was already set to %s", Integer.valueOf(this.f2322e));
        if (i >= 0) {
            z = true;
        }
        C1650g.m3086a(z, (Object) "maximum size must not be negative");
        this.f2322e = i;
        this.f2319b = true;
        if (this.f2322e == 0) {
            this.f2327j = RemovalCause.SIZE;
        }
        return this;
    }

    public MapMaker m3880c(int i) {
        boolean z;
        boolean z2 = true;
        if (this.f2321d == -1) {
            z = true;
        } else {
            z = false;
        }
        C1650g.m3093b(z, "concurrency level was already set to %s", Integer.valueOf(this.f2321d));
        if (i <= 0) {
            z2 = false;
        }
        C1650g.m3085a(z2);
        this.f2321d = i;
        return this;
    }

    int m3881d() {
        return this.f2321d == -1 ? 4 : this.f2321d;
    }

    MapMaker m3874a(Strength strength) {
        boolean z = false;
        C1650g.m3093b(this.f2323f == null, "Key strength was already set to %s", this.f2323f);
        this.f2323f = (Strength) C1650g.m3080a((Object) strength);
        if (this.f2323f != Strength.SOFT) {
            z = true;
        }
        C1650g.m3086a(z, (Object) "Soft keys are not supported");
        if (strength != Strength.STRONG) {
            this.f2319b = true;
        }
        return this;
    }

    Strength m3882e() {
        return (Strength) C1647e.m3075b(this.f2323f, Strength.STRONG);
    }

    MapMaker m3878b(Strength strength) {
        C1650g.m3093b(this.f2324g == null, "Value strength was already set to %s", this.f2324g);
        this.f2324g = (Strength) C1650g.m3080a((Object) strength);
        if (strength != Strength.STRONG) {
            this.f2319b = true;
        }
        return this;
    }

    Strength m3883f() {
        return (Strength) C1647e.m3075b(this.f2324g, Strength.STRONG);
    }

    @Deprecated
    MapMaker m3872a(long j, TimeUnit timeUnit) {
        m3869c(j, timeUnit);
        this.f2325h = timeUnit.toNanos(j);
        if (j == 0 && this.f2327j == null) {
            this.f2327j = RemovalCause.EXPIRED;
        }
        this.f2319b = true;
        return this;
    }

    private void m3869c(long j, TimeUnit timeUnit) {
        boolean z;
        C1650g.m3093b(this.f2325h == -1, "expireAfterWrite was already set to %s ns", Long.valueOf(this.f2325h));
        if (this.f2326i == -1) {
            z = true;
        } else {
            z = false;
        }
        C1650g.m3093b(z, "expireAfterAccess was already set to %s ns", Long.valueOf(this.f2326i));
        if (j >= 0) {
            z = true;
        } else {
            z = false;
        }
        C1650g.m3087a(z, "duration cannot be negative: %s %s", Long.valueOf(j), timeUnit);
    }

    long m3884g() {
        return this.f2325h == -1 ? 0 : this.f2325h;
    }

    @Deprecated
    MapMaker m3877b(long j, TimeUnit timeUnit) {
        m3869c(j, timeUnit);
        this.f2326i = timeUnit.toNanos(j);
        if (j == 0 && this.f2327j == null) {
            this.f2327j = RemovalCause.EXPIRED;
        }
        this.f2319b = true;
        return this;
    }

    long m3885h() {
        return this.f2326i == -1 ? 0 : this.f2326i;
    }

    C1660m m3886i() {
        return (C1660m) C1647e.m3075b(this.f2329l, C1660m.m3120b());
    }

    @Deprecated
    <K, V> GenericMapMaker<K, V> m3870a(C1761a<K, V> c1761a) {
        C1650g.m3091b(this.a == null);
        this.f2251a = (C1761a) C1650g.m3080a((Object) c1761a);
        this.f2319b = true;
        return this;
    }

    public <K, V> ConcurrentMap<K, V> m3887j() {
        if (this.f2319b) {
            return this.f2327j == null ? new MapMakerInternalMap(this) : new NullConcurrentMap(this);
        } else {
            return new ConcurrentHashMap(m3879c(), 0.75f, m3881d());
        }
    }

    public String toString() {
        C1646a a = C1647e.m3072a((Object) this);
        if (this.f2320c != -1) {
            a.m3067a("initialCapacity", this.f2320c);
        }
        if (this.f2321d != -1) {
            a.m3067a("concurrencyLevel", this.f2321d);
        }
        if (this.f2322e != -1) {
            a.m3067a("maximumSize", this.f2322e);
        }
        if (this.f2325h != -1) {
            a.m3069a("expireAfterWrite", this.f2325h + "ns");
        }
        if (this.f2326i != -1) {
            a.m3069a("expireAfterAccess", this.f2326i + "ns");
        }
        if (this.f2323f != null) {
            a.m3069a("keyStrength", C1626a.m3008a(this.f2323f.toString()));
        }
        if (this.f2324g != null) {
            a.m3069a("valueStrength", C1626a.m3008a(this.f2324g.toString()));
        }
        if (this.f2328k != null) {
            a.m3065a("keyEquivalence");
        }
        if (this.a != null) {
            a.m3065a("removalListener");
        }
        return a.toString();
    }
}
