package com.google.common.collect;

import com.google.common.base.C1650g;
import com.google.common.collect.ImmutableMap.C1762a;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public abstract class ImmutableBiMap<K, V> extends ImmutableMap<K, V> implements C1758e<K, V> {

    private static class SerializedForm extends SerializedForm {
        private static final long serialVersionUID = 0;

        SerializedForm(ImmutableBiMap<?, ?> immutableBiMap) {
            super(immutableBiMap);
        }

        Object readResolve() {
            return m3763a(new C1763a());
        }
    }

    /* renamed from: com.google.common.collect.ImmutableBiMap.a */
    public static final class C1763a<K, V> extends C1762a<K, V> {
        public /* synthetic */ C1762a m3771b(Object obj, Object obj2) {
            return m3768a(obj, obj2);
        }

        public /* synthetic */ C1762a m3772b(Map map) {
            return m3769a(map);
        }

        public /* synthetic */ ImmutableMap m3773b() {
            return m3770a();
        }

        public C1763a<K, V> m3768a(K k, V v) {
            super.m3765b(k, v);
            return this;
        }

        public C1763a<K, V> m3769a(Map<? extends K, ? extends V> map) {
            super.m3766b(map);
            return this;
        }

        public ImmutableBiMap<K, V> m3770a() {
            return ImmutableBiMap.m3638a(this.a);
        }
    }

    public abstract ImmutableBiMap<V, K> i_();

    public /* synthetic */ ImmutableCollection m3640f() {
        return m3641h();
    }

    public /* synthetic */ Collection values() {
        return m3641h();
    }

    public static <K, V> ImmutableBiMap<K, V> m3639g() {
        return EmptyImmutableBiMap.f2233a;
    }

    public static <K, V> ImmutableBiMap<K, V> m3637a(K k, V v) {
        C1650g.m3082a((Object) k, "null key in entry: null=%s", v);
        C1650g.m3082a((Object) v, "null value in entry: %s=null", k);
        return new SingletonImmutableBiMap(k, v);
    }

    static <K, V> ImmutableBiMap<K, V> m3638a(Collection<? extends Entry<? extends K, ? extends V>> collection) {
        switch (collection.size()) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                return m3639g();
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                Entry entry = (Entry) C1859n.m4282b(collection);
                return new SingletonImmutableBiMap(entry.getKey(), entry.getValue());
            default:
                return new RegularImmutableBiMap(collection);
        }
    }

    ImmutableBiMap() {
    }

    public ImmutableSet<V> m3641h() {
        return i_().m3634d();
    }

    Object writeReplace() {
        return new SerializedForm(this);
    }
}
