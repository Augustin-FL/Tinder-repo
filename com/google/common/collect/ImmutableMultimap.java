package com.google.common.collect;

import com.google.common.collect.C1883x.C1882a;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public abstract class ImmutableMultimap<K, V> extends C1756c<K, V> implements Serializable {
    private static final long serialVersionUID = 0;
    final transient ImmutableMap<K, ? extends ImmutableCollection<V>> f2239b;
    final transient int f2240c;

    private static class BuilderMultimap<K, V> extends AbstractMapBasedMultimap<K, V> {
        private static final long serialVersionUID = 0;

        BuilderMultimap() {
            super(new LinkedHashMap());
        }

        Collection<V> m3825a() {
            return C1872p.m4309a();
        }
    }

    /* renamed from: com.google.common.collect.ImmutableMultimap.a */
    public static class C1777a<K, V> {
        C1755r<K, V> f2292a;
        Comparator<? super K> f2293b;
        Comparator<? super V> f2294c;

        public C1777a() {
            this.f2292a = new BuilderMultimap();
        }
    }

    /* renamed from: com.google.common.collect.ImmutableMultimap.b */
    static class C1778b {
        static final C1882a<ImmutableMultimap> f2295a;
        static final C1882a<ImmutableMultimap> f2296b;

        static {
            f2295a = C1883x.m4355a(ImmutableMultimap.class, "map");
            f2296b = C1883x.m4355a(ImmutableMultimap.class, "size");
        }
    }

    public abstract ImmutableCollection<V> m3686a(K k);

    public /* synthetic */ Collection m3691b(Object obj) {
        return m3686a(obj);
    }

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public /* bridge */ /* synthetic */ boolean m3694f() {
        return super.m3597f();
    }

    public /* synthetic */ Set m3695g() {
        return m3692c();
    }

    public /* synthetic */ Map m3696h() {
        return m3697i();
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    ImmutableMultimap(ImmutableMap<K, ? extends ImmutableCollection<V>> immutableMap, int i) {
        this.f2239b = immutableMap;
        this.f2240c = i;
    }

    @Deprecated
    public boolean m3689a(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public boolean m3688a(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    boolean m3687a() {
        return this.f2239b.m3635e();
    }

    public int m3690b() {
        return this.f2240c;
    }

    public ImmutableSet<K> m3692c() {
        return this.f2239b.m3634d();
    }

    public ImmutableMap<K, Collection<V>> m3697i() {
        return this.f2239b;
    }

    Map<K, Collection<V>> m3693e() {
        throw new AssertionError("should never be called");
    }
}
