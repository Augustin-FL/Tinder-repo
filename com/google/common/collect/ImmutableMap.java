package com.google.common.collect;

import com.google.common.base.C1650g;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public abstract class ImmutableMap<K, V> implements Serializable, Map<K, V> {
    private transient ImmutableSet<Entry<K, V>> f2230a;
    private transient ImmutableSet<K> f2231b;
    private transient ImmutableCollection<V> f2232c;

    static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final Object[] f2253a;
        private final Object[] f2254b;

        SerializedForm(ImmutableMap<?, ?> immutableMap) {
            this.f2253a = new Object[immutableMap.size()];
            this.f2254b = new Object[immutableMap.size()];
            Iterator it = immutableMap.m3632b().iterator();
            int i = 0;
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                this.f2253a[i] = entry.getKey();
                this.f2254b[i] = entry.getValue();
                i++;
            }
        }

        Object readResolve() {
            return m3763a(new C1762a());
        }

        Object m3763a(C1762a<Object, Object> c1762a) {
            for (int i = 0; i < this.f2253a.length; i++) {
                c1762a.m3765b(this.f2253a[i], this.f2254b[i]);
            }
            return c1762a.m3767b();
        }
    }

    /* renamed from: com.google.common.collect.ImmutableMap.a */
    public static class C1762a<K, V> {
        final ArrayList<Entry<K, V>> f2255a;

        public C1762a() {
            this.f2255a = C1872p.m4309a();
        }

        public C1762a<K, V> m3765b(K k, V v) {
            this.f2255a.add(ImmutableMap.m3628c(k, v));
            return this;
        }

        public C1762a<K, V> m3766b(Map<? extends K, ? extends V> map) {
            this.f2255a.ensureCapacity(this.f2255a.size() + map.size());
            for (Entry entry : map.entrySet()) {
                m3765b(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public ImmutableMap<K, V> m3767b() {
            return C1762a.m3764a(this.f2255a);
        }

        private static <K, V> ImmutableMap<K, V> m3764a(List<Entry<K, V>> list) {
            switch (list.size()) {
                case C3374b.SmoothProgressBar_spbStyle /*0*/:
                    return ImmutableMap.m3629i();
                case C3374b.SmoothProgressBar_spb_color /*1*/:
                    return new SingletonImmutableBiMap((Entry) C1859n.m4282b(list));
                default:
                    return new RegularImmutableMap((Entry[]) list.toArray(new Entry[list.size()]));
            }
        }
    }

    abstract ImmutableSet<Entry<K, V>> m3633c();

    abstract boolean m3635e();

    public abstract V get(Object obj);

    public /* synthetic */ Set entrySet() {
        return m3632b();
    }

    public /* synthetic */ Set keySet() {
        return m3634d();
    }

    public /* synthetic */ Collection values() {
        return m3636f();
    }

    public static <K, V> ImmutableMap<K, V> m3629i() {
        return ImmutableBiMap.m3639g();
    }

    public static <K, V> ImmutableMap<K, V> m3627b(K k, V v) {
        return ImmutableBiMap.m3637a(k, v);
    }

    public static <K, V> C1762a<K, V> m3630j() {
        return new C1762a();
    }

    static <K, V> Entry<K, V> m3628c(K k, V v) {
        C1650g.m3082a((Object) k, "null key in entry: null=%s", v);
        C1650g.m3082a((Object) v, "null value in entry: %s=null", k);
        return C1876q.m4332a((Object) k, (Object) v);
    }

    public static <K, V> ImmutableMap<K, V> m3626a(Map<? extends K, ? extends V> map) {
        int i = 0;
        if ((map instanceof ImmutableMap) && !(map instanceof ImmutableSortedMap)) {
            ImmutableMap<K, V> immutableMap = (ImmutableMap) map;
            if (!immutableMap.m3635e()) {
                return immutableMap;
            }
        } else if (map instanceof EnumMap) {
            EnumMap enumMap = (EnumMap) map;
            for (Entry entry : enumMap.entrySet()) {
                C1650g.m3080a(entry.getKey());
                C1650g.m3080a(entry.getValue());
            }
            return ImmutableEnumMap.m3791a(new EnumMap(enumMap));
        }
        Entry[] entryArr = (Entry[]) map.entrySet().toArray(new Entry[0]);
        switch (entryArr.length) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                return m3629i();
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                return new SingletonImmutableBiMap(m3628c(entryArr[0].getKey(), entryArr[0].getValue()));
        }
        while (i < entryArr.length) {
            entryArr[i] = m3628c(entryArr[i].getKey(), entryArr[i].getValue());
            i++;
        }
        return new RegularImmutableMap(entryArr);
    }

    ImmutableMap() {
    }

    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    public boolean containsValue(Object obj) {
        return obj != null && C1876q.m4342e(this, obj);
    }

    public ImmutableSet<Entry<K, V>> m3632b() {
        ImmutableSet<Entry<K, V>> immutableSet = this.f2230a;
        if (immutableSet != null) {
            return immutableSet;
        }
        immutableSet = m3633c();
        this.f2230a = immutableSet;
        return immutableSet;
    }

    public ImmutableSet<K> m3634d() {
        ImmutableSet<K> immutableSet = this.f2231b;
        if (immutableSet != null) {
            return immutableSet;
        }
        immutableSet = m3631a();
        this.f2231b = immutableSet;
        return immutableSet;
    }

    ImmutableSet<K> m3631a() {
        return new ImmutableMapKeySet(this);
    }

    public ImmutableCollection<V> m3636f() {
        ImmutableCollection<V> immutableCollection = this.f2232c;
        if (immutableCollection != null) {
            return immutableCollection;
        }
        immutableCollection = new ImmutableMapValues(this);
        this.f2232c = immutableCollection;
        return immutableCollection;
    }

    public boolean equals(Object obj) {
        return C1876q.m4341d(this, obj);
    }

    public int hashCode() {
        return m3632b().hashCode();
    }

    public String toString() {
        return C1876q.m4334b((Map) this);
    }

    Object writeReplace() {
        return new SerializedForm(this);
    }
}
