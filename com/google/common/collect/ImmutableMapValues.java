package com.google.common.collect;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map.Entry;

final class ImmutableMapValues<K, V> extends ImmutableCollection<V> {
    private final ImmutableMap<K, V> f2291a;

    /* renamed from: com.google.common.collect.ImmutableMapValues.1 */
    class C17761 extends ImmutableAsList<V> {
        final /* synthetic */ ImmutableList f2288a;
        final /* synthetic */ ImmutableMapValues f2289c;

        C17761(ImmutableMapValues immutableMapValues, ImmutableList immutableList) {
            this.f2289c = immutableMapValues;
            this.f2288a = immutableList;
        }

        public V get(int i) {
            return ((Entry) this.f2288a.get(i)).getValue();
        }

        ImmutableCollection<V> m3821e() {
            return this.f2289c;
        }
    }

    private static class SerializedForm<V> implements Serializable {
        private static final long serialVersionUID = 0;
        final ImmutableMap<?, V> f2290a;

        SerializedForm(ImmutableMap<?, V> immutableMap) {
            this.f2290a = immutableMap;
        }

        Object readResolve() {
            return this.f2290a.m3636f();
        }
    }

    public /* synthetic */ Iterator iterator() {
        return m3823b();
    }

    ImmutableMapValues(ImmutableMap<K, V> immutableMap) {
        this.f2291a = immutableMap;
    }

    public int size() {
        return this.f2291a.size();
    }

    public ac<V> m3823b() {
        return C1876q.m4326a(this.f2291a.m3632b().m3680b());
    }

    public boolean contains(Object obj) {
        return this.f2291a.containsValue(obj);
    }

    boolean m3822a() {
        return true;
    }

    ImmutableList<V> m3824f() {
        return new C17761(this, this.f2291a.m3632b().m3648c());
    }

    Object writeReplace() {
        return new SerializedForm(this.f2291a);
    }
}
