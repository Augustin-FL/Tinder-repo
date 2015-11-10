package com.google.common.collect;

import com.google.common.base.C1640d.C1643a;
import com.google.common.base.C1647e;
import com.google.common.base.C1650g;
import com.google.common.collect.Sets.C1738a;
import java.util.Collection;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentMap;

/* renamed from: com.google.common.collect.q */
public final class C1876q {
    static final C1643a f2525a;

    /* renamed from: com.google.common.collect.q.a */
    static abstract class C1739a<K, V> extends C1738a<Entry<K, V>> {
        abstract Map<K, V> m3564a();

        C1739a() {
        }

        public int size() {
            return m3564a().size();
        }

        public void clear() {
            m3564a().clear();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            Object key = entry.getKey();
            Object obj2 = m3564a().get(key);
            if (!C1647e.m3074a(obj2, entry.getValue())) {
                return false;
            }
            if (obj2 != null || m3564a().containsKey(key)) {
                return true;
            }
            return false;
        }

        public boolean isEmpty() {
            return m3564a().isEmpty();
        }

        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            return m3564a().keySet().remove(((Entry) obj).getKey());
        }

        public boolean removeAll(Collection<?> collection) {
            boolean removeAll;
            try {
                removeAll = super.removeAll((Collection) C1650g.m3080a((Object) collection));
            } catch (UnsupportedOperationException e) {
                removeAll = true;
                for (Object remove : collection) {
                    removeAll |= remove(remove);
                }
            }
            return removeAll;
        }

        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) C1650g.m3080a((Object) collection));
            } catch (UnsupportedOperationException e) {
                Collection a = Sets.m4228a(collection.size());
                for (Object next : collection) {
                    if (contains(next)) {
                        a.add(((Entry) next).getKey());
                    }
                }
                return m3564a().keySet().retainAll(a);
            }
        }
    }

    /* renamed from: com.google.common.collect.q.b */
    static abstract class C1744b<K, V> extends C1738a<K> {
        abstract Map<K, V> m3570a();

        C1744b() {
        }

        public Iterator<K> iterator() {
            return C1876q.m4331a(m3570a().entrySet().iterator());
        }

        public int size() {
            return m3570a().size();
        }

        public boolean isEmpty() {
            return m3570a().isEmpty();
        }

        public boolean contains(Object obj) {
            return m3570a().containsKey(obj);
        }

        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            m3570a().remove(obj);
            return true;
        }

        public void clear() {
            m3570a().clear();
        }
    }

    /* renamed from: com.google.common.collect.q.1 */
    static class C18731 extends ab<Entry<K, V>, K> {
        C18731(Iterator it) {
            super(it);
        }

        K m4323a(Entry<K, V> entry) {
            return entry.getKey();
        }
    }

    /* renamed from: com.google.common.collect.q.2 */
    static class C18742 extends ab<Entry<K, V>, V> {
        C18742(Iterator it) {
            super(it);
        }

        V m4325a(Entry<K, V> entry) {
            return entry.getValue();
        }
    }

    /* renamed from: com.google.common.collect.q.3 */
    static class C18753 extends ac<V> {
        final /* synthetic */ ac f2524a;

        C18753(ac acVar) {
            this.f2524a = acVar;
        }

        public boolean hasNext() {
            return this.f2524a.hasNext();
        }

        public V next() {
            return ((Entry) this.f2524a.next()).getValue();
        }
    }

    public static <K, V> HashMap<K, V> m4328a() {
        return new HashMap();
    }

    public static <K, V> HashMap<K, V> m4329a(int i) {
        return new HashMap(C1876q.m4333b(i));
    }

    static int m4333b(int i) {
        if (i < 3) {
            C1650g.m3085a(i >= 0);
            return i + 1;
        } else if (i < 1073741824) {
            return (i / 3) + i;
        } else {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }

    public static <K, V> HashMap<K, V> m4330a(Map<? extends K, ? extends V> map) {
        return new HashMap(map);
    }

    public static <K, V> LinkedHashMap<K, V> m4336b() {
        return new LinkedHashMap();
    }

    public static <K, V> ConcurrentMap<K, V> m4339c() {
        return new MapMaker().m3887j();
    }

    public static <K, V> IdentityHashMap<K, V> m4340d() {
        return new IdentityHashMap();
    }

    public static <K, V> Entry<K, V> m4332a(K k, V v) {
        return new ImmutableEntry(k, v);
    }

    static {
        f2525a = C1851f.f2500a.m3055c("=");
    }

    static <V> V m4327a(Map<?, V> map, Object obj) {
        V v = null;
        C1650g.m3080a((Object) map);
        try {
            v = map.get(obj);
        } catch (ClassCastException e) {
        } catch (NullPointerException e2) {
        }
        return v;
    }

    static boolean m4337b(Map<?, ?> map, Object obj) {
        boolean z = false;
        C1650g.m3080a((Object) map);
        try {
            z = map.containsKey(obj);
        } catch (ClassCastException e) {
        } catch (NullPointerException e2) {
        }
        return z;
    }

    static <V> V m4338c(Map<?, V> map, Object obj) {
        V v = null;
        C1650g.m3080a((Object) map);
        try {
            v = map.remove(obj);
        } catch (ClassCastException e) {
        } catch (NullPointerException e2) {
        }
        return v;
    }

    static boolean m4341d(Map<?, ?> map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        return map.entrySet().equals(((Map) obj).entrySet());
    }

    static String m4334b(Map<?, ?> map) {
        StringBuilder append = C1851f.m4264a(map.size()).append('{');
        f2525a.m3061a(append, (Map) map);
        return append.append('}').toString();
    }

    static boolean m4342e(Map<?, ?> map, Object obj) {
        return C1868o.m4298a(C1876q.m4335b(map.entrySet().iterator()), obj);
    }

    static <K, V> Iterator<K> m4331a(Iterator<Entry<K, V>> it) {
        return new C18731(it);
    }

    static <K, V> Iterator<V> m4335b(Iterator<Entry<K, V>> it) {
        return new C18742(it);
    }

    static <K, V> ac<V> m4326a(ac<Entry<K, V>> acVar) {
        return new C18753(acVar);
    }
}
