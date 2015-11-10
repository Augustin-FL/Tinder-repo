package com.google.common.collect;

import com.google.common.base.C1650g;
import java.io.Serializable;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map.Entry;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

final class ImmutableEnumMap<K extends Enum<K>, V> extends ImmutableMap<K, V> {
    private final transient EnumMap<K, V> f2266a;

    /* renamed from: com.google.common.collect.ImmutableEnumMap.1 */
    class C17671 extends ImmutableSet<K> {
        final /* synthetic */ ImmutableEnumMap f2261a;

        C17671(ImmutableEnumMap immutableEnumMap) {
            this.f2261a = immutableEnumMap;
        }

        public /* synthetic */ Iterator iterator() {
            return m3785b();
        }

        public boolean contains(Object obj) {
            return this.f2261a.f2266a.containsKey(obj);
        }

        public int size() {
            return this.f2261a.size();
        }

        public ac<K> m3785b() {
            return C1868o.m4291a(this.f2261a.f2266a.keySet().iterator());
        }

        boolean m3784a() {
            return true;
        }
    }

    /* renamed from: com.google.common.collect.ImmutableEnumMap.2 */
    class C17692 extends ImmutableMapEntrySet<K, V> {
        final /* synthetic */ ImmutableEnumMap f2264a;

        /* renamed from: com.google.common.collect.ImmutableEnumMap.2.1 */
        class C17681 extends ac<Entry<K, V>> {
            final /* synthetic */ C17692 f2262a;
            private final Iterator<Entry<K, V>> f2263b;

            C17681(C17692 c17692) {
                this.f2262a = c17692;
                this.f2263b = this.f2262a.f2264a.f2266a.entrySet().iterator();
            }

            public /* synthetic */ Object next() {
                return m3786a();
            }

            public boolean hasNext() {
                return this.f2263b.hasNext();
            }

            public Entry<K, V> m3786a() {
                Entry entry = (Entry) this.f2263b.next();
                return C1876q.m4332a(entry.getKey(), entry.getValue());
            }
        }

        C17692(ImmutableEnumMap immutableEnumMap) {
            this.f2264a = immutableEnumMap;
        }

        public /* synthetic */ Iterator iterator() {
            return m3789b();
        }

        ImmutableMap<K, V> m3790e() {
            return this.f2264a;
        }

        public ac<Entry<K, V>> m3789b() {
            return new C17681(this);
        }
    }

    private static class EnumSerializedForm<K extends Enum<K>, V> implements Serializable {
        private static final long serialVersionUID = 0;
        final EnumMap<K, V> f2265a;

        EnumSerializedForm(EnumMap<K, V> enumMap) {
            this.f2265a = enumMap;
        }

        Object readResolve() {
            return new ImmutableEnumMap(null);
        }
    }

    static <K extends Enum<K>, V> ImmutableMap<K, V> m3791a(EnumMap<K, V> enumMap) {
        switch (enumMap.size()) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                return ImmutableMap.m3629i();
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                Entry entry = (Entry) C1859n.m4282b(enumMap.entrySet());
                return ImmutableMap.m3627b(entry.getKey(), entry.getValue());
            default:
                return new ImmutableEnumMap(enumMap);
        }
    }

    private ImmutableEnumMap(EnumMap<K, V> enumMap) {
        this.f2266a = enumMap;
        C1650g.m3085a(!enumMap.isEmpty());
    }

    ImmutableSet<K> m3793a() {
        return new C17671(this);
    }

    public int size() {
        return this.f2266a.size();
    }

    public boolean containsKey(Object obj) {
        return this.f2266a.containsKey(obj);
    }

    public V get(Object obj) {
        return this.f2266a.get(obj);
    }

    ImmutableSet<Entry<K, V>> m3794c() {
        return new C17692(this);
    }

    boolean m3795e() {
        return false;
    }

    Object writeReplace() {
        return new EnumSerializedForm(this.f2266a);
    }
}
