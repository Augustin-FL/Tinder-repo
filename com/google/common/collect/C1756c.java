package com.google.common.collect;

import com.google.common.base.C1650g;
import com.google.common.collect.C1876q.C1744b;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.common.collect.c */
abstract class C1756c<K, V> implements C1755r<K, V> {
    private transient Set<K> f2223a;
    private transient Map<K, Collection<V>> f2224b;

    /* renamed from: com.google.common.collect.c.1 */
    class C18491 extends C1744b<K, Collection<V>> {
        final /* synthetic */ C1756c f2498a;

        C18491(C1756c c1756c) {
            this.f2498a = c1756c;
        }

        Map<K, Collection<V>> m4261a() {
            return this.f2498a.m3599h();
        }
    }

    abstract Map<K, Collection<V>> m3596e();

    C1756c() {
    }

    public boolean m3597f() {
        return m3589b() == 0;
    }

    public boolean m3594a(K k, V v) {
        return m3590b(k).add(v);
    }

    public boolean m3593a(K k, Iterable<? extends V> iterable) {
        C1650g.m3080a((Object) iterable);
        return iterable.iterator().hasNext() && C1859n.m4281a(m3590b(k), (Iterable) iterable);
    }

    public Set<K> m3598g() {
        Set<K> set = this.f2223a;
        if (set != null) {
            return set;
        }
        set = m3595d();
        this.f2223a = set;
        return set;
    }

    Set<K> m3595d() {
        return new C18491(this);
    }

    public Map<K, Collection<V>> m3599h() {
        Map<K, Collection<V>> map = this.f2224b;
        if (map != null) {
            return map;
        }
        map = m3596e();
        this.f2224b = map;
        return map;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1755r)) {
            return false;
        }
        return m3599h().equals(((C1755r) obj).m3592h());
    }

    public int hashCode() {
        return m3599h().hashCode();
    }

    public String toString() {
        return m3599h().toString();
    }
}
