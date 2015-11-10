package com.google.common.collect;

import com.google.common.base.C1650g;
import com.google.common.collect.AbstractMapBasedMultimap$f.a;
import com.google.common.collect.C1876q.C1739a;
import com.google.common.collect.C1876q.C1744b;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

abstract class AbstractMapBasedMultimap<K, V> extends C1756c<K, V> implements Serializable {
    private static final long serialVersionUID = 2447537837011683357L;
    private transient Map<K, Collection<V>> f2225a;
    private transient int f2226b;

    /* renamed from: com.google.common.collect.AbstractMapBasedMultimap.a */
    private class C1742a extends AbstractMap<K, Collection<V>> {
        final transient Map<K, Collection<V>> f2199a;
        transient Set<Entry<K, Collection<V>>> f2200b;
        final /* synthetic */ AbstractMapBasedMultimap f2201c;

        /* renamed from: com.google.common.collect.AbstractMapBasedMultimap.a.a */
        class C1740a extends C1739a<K, Collection<V>> {
            final /* synthetic */ C1742a f2195a;

            C1740a(C1742a c1742a) {
                this.f2195a = c1742a;
            }

            Map<K, Collection<V>> m3565a() {
                return this.f2195a;
            }

            public Iterator<Entry<K, Collection<V>>> iterator() {
                return new C1741b(this.f2195a);
            }

            public boolean contains(Object obj) {
                return C1851f.m4266a(this.f2195a.f2199a.entrySet(), obj);
            }

            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                this.f2195a.f2201c.m3610c(((Entry) obj).getKey());
                return true;
            }
        }

        /* renamed from: com.google.common.collect.AbstractMapBasedMultimap.a.b */
        class C1741b implements Iterator<Entry<K, Collection<V>>> {
            final Iterator<Entry<K, Collection<V>>> f2196a;
            Collection<V> f2197b;
            final /* synthetic */ C1742a f2198c;

            C1741b(C1742a c1742a) {
                this.f2198c = c1742a;
                this.f2196a = this.f2198c.f2199a.entrySet().iterator();
            }

            public /* synthetic */ Object next() {
                return m3566a();
            }

            public boolean hasNext() {
                return this.f2196a.hasNext();
            }

            public Entry<K, Collection<V>> m3566a() {
                Entry entry = (Entry) this.f2196a.next();
                this.f2197b = (Collection) entry.getValue();
                return this.f2198c.m3568a(entry);
            }

            public void remove() {
                this.f2196a.remove();
                AbstractMapBasedMultimap.m3608b(this.f2198c.f2201c, this.f2197b.size());
                this.f2197b.clear();
            }
        }

        public /* synthetic */ Object get(Object obj) {
            return m3567a(obj);
        }

        public /* synthetic */ Object remove(Object obj) {
            return m3569b(obj);
        }

        C1742a(AbstractMapBasedMultimap abstractMapBasedMultimap, Map<K, Collection<V>> map) {
            this.f2201c = abstractMapBasedMultimap;
            this.f2199a = map;
        }

        public Set<Entry<K, Collection<V>>> entrySet() {
            Set<Entry<K, Collection<V>>> set = this.f2200b;
            if (set != null) {
                return set;
            }
            set = new C1740a(this);
            this.f2200b = set;
            return set;
        }

        public boolean containsKey(Object obj) {
            return C1876q.m4337b(this.f2199a, obj);
        }

        public Collection<V> m3567a(Object obj) {
            Collection collection = (Collection) C1876q.m4327a(this.f2199a, obj);
            if (collection == null) {
                return null;
            }
            return this.f2201c.m3613a(obj, collection);
        }

        public Set<K> keySet() {
            return this.f2201c.m3598g();
        }

        public int size() {
            return this.f2199a.size();
        }

        public Collection<V> m3569b(Object obj) {
            Collection collection = (Collection) this.f2199a.remove(obj);
            if (collection == null) {
                return null;
            }
            Collection<V> a = this.f2201c.m3611a();
            a.addAll(collection);
            AbstractMapBasedMultimap.m3608b(this.f2201c, collection.size());
            collection.clear();
            return a;
        }

        public boolean equals(Object obj) {
            return this == obj || this.f2199a.equals(obj);
        }

        public int hashCode() {
            return this.f2199a.hashCode();
        }

        public String toString() {
            return this.f2199a.toString();
        }

        public void clear() {
            if (this.f2199a == this.f2201c.f2225a) {
                this.f2201c.m3617c();
            } else {
                C1868o.m4303d(new C1741b(this));
            }
        }

        Entry<K, Collection<V>> m3568a(Entry<K, Collection<V>> entry) {
            Object key = entry.getKey();
            return C1876q.m4332a(key, this.f2201c.m3613a(key, (Collection) entry.getValue()));
        }
    }

    /* renamed from: com.google.common.collect.AbstractMapBasedMultimap.b */
    private class C1745b extends C1744b<K, Collection<V>> {
        final Map<K, Collection<V>> f2205a;
        final /* synthetic */ AbstractMapBasedMultimap f2206b;

        /* renamed from: com.google.common.collect.AbstractMapBasedMultimap.b.1 */
        class C17431 implements Iterator<K> {
            Entry<K, Collection<V>> f2202a;
            final /* synthetic */ Iterator f2203b;
            final /* synthetic */ C1745b f2204c;

            C17431(C1745b c1745b, Iterator it) {
                this.f2204c = c1745b;
                this.f2203b = it;
            }

            public boolean hasNext() {
                return this.f2203b.hasNext();
            }

            public K next() {
                this.f2202a = (Entry) this.f2203b.next();
                return this.f2202a.getKey();
            }

            public void remove() {
                C1868o.m4296a(this.f2202a != null);
                Collection collection = (Collection) this.f2202a.getValue();
                this.f2203b.remove();
                AbstractMapBasedMultimap.m3608b(this.f2204c.f2206b, collection.size());
                collection.clear();
            }
        }

        C1745b(AbstractMapBasedMultimap abstractMapBasedMultimap, Map<K, Collection<V>> map) {
            this.f2206b = abstractMapBasedMultimap;
            this.f2205a = map;
        }

        Map<K, Collection<V>> m3571a() {
            return this.f2205a;
        }

        public Iterator<K> iterator() {
            return new C17431(this, this.f2205a.entrySet().iterator());
        }

        public boolean remove(Object obj) {
            int i;
            Collection collection = (Collection) this.f2205a.remove(obj);
            if (collection != null) {
                int size = collection.size();
                collection.clear();
                AbstractMapBasedMultimap.m3608b(this.f2206b, size);
                i = size;
            } else {
                i = 0;
            }
            return i > 0;
        }

        public void clear() {
            C1868o.m4303d(iterator());
        }

        public boolean containsAll(Collection<?> collection) {
            return this.f2205a.keySet().containsAll(collection);
        }

        public boolean equals(Object obj) {
            return this == obj || this.f2205a.keySet().equals(obj);
        }

        public int hashCode() {
            return this.f2205a.keySet().hashCode();
        }
    }

    /* renamed from: com.google.common.collect.AbstractMapBasedMultimap.f */
    private class C1746f extends AbstractCollection<V> {
        final K f2207b;
        Collection<V> f2208c;
        final C1746f f2209d;
        final Collection<V> f2210e;
        final /* synthetic */ AbstractMapBasedMultimap f2211f;

        /* renamed from: com.google.common.collect.AbstractMapBasedMultimap.f.a */
        class C1751a implements Iterator<V> {
            final Iterator<V> f2217a;
            final Collection<V> f2218b;
            final /* synthetic */ C1746f f2219c;

            C1751a(C1746f c1746f) {
                this.f2219c = c1746f;
                this.f2218b = this.f2219c.f2208c;
                this.f2217a = c1746f.f2211f.m3603a(c1746f.f2208c);
            }

            C1751a(C1746f c1746f, Iterator<V> it) {
                this.f2219c = c1746f;
                this.f2218b = this.f2219c.f2208c;
                this.f2217a = it;
            }

            void m3583a() {
                this.f2219c.m3572a();
                if (this.f2219c.f2208c != this.f2218b) {
                    throw new ConcurrentModificationException();
                }
            }

            public boolean hasNext() {
                m3583a();
                return this.f2217a.hasNext();
            }

            public V next() {
                m3583a();
                return this.f2217a.next();
            }

            public void remove() {
                this.f2217a.remove();
                this.f2219c.f2211f.f2226b = this.f2219c.f2211f.f2226b - 1;
                this.f2219c.m3573b();
            }

            Iterator<V> m3584b() {
                m3583a();
                return this.f2217a;
            }
        }

        C1746f(AbstractMapBasedMultimap abstractMapBasedMultimap, K k, Collection<V> collection, C1746f c1746f) {
            this.f2211f = abstractMapBasedMultimap;
            this.f2207b = k;
            this.f2208c = collection;
            this.f2209d = c1746f;
            this.f2210e = c1746f == null ? null : c1746f.m3576e();
        }

        void m3572a() {
            if (this.f2209d != null) {
                this.f2209d.m3572a();
                if (this.f2209d.m3576e() != this.f2210e) {
                    throw new ConcurrentModificationException();
                }
            } else if (this.f2208c.isEmpty()) {
                Collection collection = (Collection) this.f2211f.f2225a.get(this.f2207b);
                if (collection != null) {
                    this.f2208c = collection;
                }
            }
        }

        void m3573b() {
            if (this.f2209d != null) {
                this.f2209d.m3573b();
            } else if (this.f2208c.isEmpty()) {
                this.f2211f.f2225a.remove(this.f2207b);
            }
        }

        K m3574c() {
            return this.f2207b;
        }

        void m3575d() {
            if (this.f2209d != null) {
                this.f2209d.m3575d();
            } else {
                this.f2211f.f2225a.put(this.f2207b, this.f2208c);
            }
        }

        public int size() {
            m3572a();
            return this.f2208c.size();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            m3572a();
            return this.f2208c.equals(obj);
        }

        public int hashCode() {
            m3572a();
            return this.f2208c.hashCode();
        }

        public String toString() {
            m3572a();
            return this.f2208c.toString();
        }

        Collection<V> m3576e() {
            return this.f2208c;
        }

        public Iterator<V> iterator() {
            m3572a();
            return new C1751a(this);
        }

        public boolean add(V v) {
            m3572a();
            boolean isEmpty = this.f2208c.isEmpty();
            boolean add = this.f2208c.add(v);
            if (add) {
                this.f2211f.f2226b = this.f2211f.f2226b + 1;
                if (isEmpty) {
                    m3575d();
                }
            }
            return add;
        }

        C1746f m3577f() {
            return this.f2209d;
        }

        public boolean addAll(Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = this.f2208c.addAll(collection);
            if (!addAll) {
                return addAll;
            }
            AbstractMapBasedMultimap.m3600a(this.f2211f, this.f2208c.size() - size);
            if (size != 0) {
                return addAll;
            }
            m3575d();
            return addAll;
        }

        public boolean contains(Object obj) {
            m3572a();
            return this.f2208c.contains(obj);
        }

        public boolean containsAll(Collection<?> collection) {
            m3572a();
            return this.f2208c.containsAll(collection);
        }

        public void clear() {
            int size = size();
            if (size != 0) {
                this.f2208c.clear();
                AbstractMapBasedMultimap.m3608b(this.f2211f, size);
                m3573b();
            }
        }

        public boolean remove(Object obj) {
            m3572a();
            boolean remove = this.f2208c.remove(obj);
            if (remove) {
                this.f2219c.f2211f.f2226b = this.f2211f.f2226b - 1;
                m3573b();
            }
            return remove;
        }

        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean removeAll = this.f2208c.removeAll(collection);
            if (!removeAll) {
                return removeAll;
            }
            AbstractMapBasedMultimap.m3600a(this.f2211f, this.f2208c.size() - size);
            m3573b();
            return removeAll;
        }

        public boolean retainAll(Collection<?> collection) {
            C1650g.m3080a((Object) collection);
            int size = size();
            boolean retainAll = this.f2208c.retainAll(collection);
            if (retainAll) {
                AbstractMapBasedMultimap.m3600a(this.f2211f, this.f2208c.size() - size);
                m3573b();
            }
            return retainAll;
        }
    }

    /* renamed from: com.google.common.collect.AbstractMapBasedMultimap.g */
    private class C1747g extends C1746f implements List<V> {
        final /* synthetic */ AbstractMapBasedMultimap f2212g;

        /* renamed from: com.google.common.collect.AbstractMapBasedMultimap.g.a */
        private class C1752a extends a implements ListIterator<V> {
            final /* synthetic */ C1747g f2220d;

            C1752a(C1747g c1747g) {
                this.f2220d = c1747g;
                super(c1747g);
            }

            public C1752a(C1747g c1747g, int i) {
                this.f2220d = c1747g;
                super(c1747g, c1747g.m3578g().listIterator(i));
            }

            private ListIterator<V> m3585c() {
                return (ListIterator) b();
            }

            public boolean hasPrevious() {
                return m3585c().hasPrevious();
            }

            public V previous() {
                return m3585c().previous();
            }

            public int nextIndex() {
                return m3585c().nextIndex();
            }

            public int previousIndex() {
                return m3585c().previousIndex();
            }

            public void set(V v) {
                m3585c().set(v);
            }

            public void add(V v) {
                boolean isEmpty = this.f2220d.isEmpty();
                m3585c().add(v);
                this.f2211f.f2226b = this.f2220d.f2212g.f2226b + 1;
                if (isEmpty) {
                    this.f2220d.m3575d();
                }
            }
        }

        C1747g(AbstractMapBasedMultimap abstractMapBasedMultimap, K k, List<V> list, C1746f c1746f) {
            this.f2212g = abstractMapBasedMultimap;
            super(abstractMapBasedMultimap, k, list, c1746f);
        }

        List<V> m3578g() {
            return (List) m3576e();
        }

        public boolean addAll(int i, Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = m3578g().addAll(i, collection);
            if (!addAll) {
                return addAll;
            }
            AbstractMapBasedMultimap.m3600a(this.f2212g, m3576e().size() - size);
            if (size != 0) {
                return addAll;
            }
            m3575d();
            return addAll;
        }

        public V get(int i) {
            m3572a();
            return m3578g().get(i);
        }

        public V set(int i, V v) {
            m3572a();
            return m3578g().set(i, v);
        }

        public void add(int i, V v) {
            m3572a();
            boolean isEmpty = m3576e().isEmpty();
            m3578g().add(i, v);
            this.f2211f.f2226b = this.f2212g.f2226b + 1;
            if (isEmpty) {
                m3575d();
            }
        }

        public V remove(int i) {
            m3572a();
            V remove = m3578g().remove(i);
            this.f2219c.f2211f.f2226b = this.f2212g.f2226b - 1;
            m3573b();
            return remove;
        }

        public int indexOf(Object obj) {
            m3572a();
            return m3578g().indexOf(obj);
        }

        public int lastIndexOf(Object obj) {
            m3572a();
            return m3578g().lastIndexOf(obj);
        }

        public ListIterator<V> listIterator() {
            m3572a();
            return new C1752a(this);
        }

        public ListIterator<V> listIterator(int i) {
            m3572a();
            return new C1752a(this, i);
        }

        public List<V> subList(int i, int i2) {
            C1746f f;
            m3572a();
            AbstractMapBasedMultimap abstractMapBasedMultimap = this.f2212g;
            Object c = m3574c();
            List subList = m3578g().subList(i, i2);
            if (m3577f() != null) {
                f = m3577f();
            }
            return abstractMapBasedMultimap.m3605a(c, subList, f);
        }
    }

    /* renamed from: com.google.common.collect.AbstractMapBasedMultimap.c */
    private class C1748c extends C1747g implements RandomAccess {
        final /* synthetic */ AbstractMapBasedMultimap f2213a;

        C1748c(AbstractMapBasedMultimap abstractMapBasedMultimap, K k, List<V> list, C1746f c1746f) {
            this.f2213a = abstractMapBasedMultimap;
            super(abstractMapBasedMultimap, k, list, c1746f);
        }
    }

    /* renamed from: com.google.common.collect.AbstractMapBasedMultimap.d */
    private class C1749d extends C1742a implements SortedMap<K, Collection<V>> {
        SortedSet<K> f2214d;
        final /* synthetic */ AbstractMapBasedMultimap f2215e;

        public /* synthetic */ Set keySet() {
            return m3580b();
        }

        C1749d(AbstractMapBasedMultimap abstractMapBasedMultimap, SortedMap<K, Collection<V>> sortedMap) {
            this.f2215e = abstractMapBasedMultimap;
            super(abstractMapBasedMultimap, sortedMap);
        }

        SortedMap<K, Collection<V>> m3579a() {
            return (SortedMap) this.a;
        }

        public Comparator<? super K> comparator() {
            return m3579a().comparator();
        }

        public K firstKey() {
            return m3579a().firstKey();
        }

        public K lastKey() {
            return m3579a().lastKey();
        }

        public SortedMap<K, Collection<V>> headMap(K k) {
            return new C1749d(this.f2215e, m3579a().headMap(k));
        }

        public SortedMap<K, Collection<V>> subMap(K k, K k2) {
            return new C1749d(this.f2215e, m3579a().subMap(k, k2));
        }

        public SortedMap<K, Collection<V>> tailMap(K k) {
            return new C1749d(this.f2215e, m3579a().tailMap(k));
        }

        public SortedSet<K> m3580b() {
            SortedSet<K> sortedSet = this.f2214d;
            if (sortedSet != null) {
                return sortedSet;
            }
            sortedSet = m3581c();
            this.f2214d = sortedSet;
            return sortedSet;
        }

        SortedSet<K> m3581c() {
            return new C1750e(this.f2215e, m3579a());
        }
    }

    /* renamed from: com.google.common.collect.AbstractMapBasedMultimap.e */
    private class C1750e extends C1745b implements SortedSet<K> {
        final /* synthetic */ AbstractMapBasedMultimap f2216c;

        C1750e(AbstractMapBasedMultimap abstractMapBasedMultimap, SortedMap<K, Collection<V>> sortedMap) {
            this.f2216c = abstractMapBasedMultimap;
            super(abstractMapBasedMultimap, sortedMap);
        }

        SortedMap<K, Collection<V>> m3582b() {
            return (SortedMap) this.a;
        }

        public Comparator<? super K> comparator() {
            return m3582b().comparator();
        }

        public K first() {
            return m3582b().firstKey();
        }

        public SortedSet<K> headSet(K k) {
            return new C1750e(this.f2216c, m3582b().headMap(k));
        }

        public K last() {
            return m3582b().lastKey();
        }

        public SortedSet<K> subSet(K k, K k2) {
            return new C1750e(this.f2216c, m3582b().subMap(k, k2));
        }

        public SortedSet<K> tailSet(K k) {
            return new C1750e(this.f2216c, m3582b().tailMap(k));
        }
    }

    /* renamed from: com.google.common.collect.AbstractMapBasedMultimap.h */
    private class C1753h extends C1746f implements Set<V> {
        final /* synthetic */ AbstractMapBasedMultimap f2221a;

        C1753h(AbstractMapBasedMultimap abstractMapBasedMultimap, K k, Set<V> set) {
            this.f2221a = abstractMapBasedMultimap;
            super(abstractMapBasedMultimap, k, set, null);
        }

        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean a = Sets.m4233a((Set) this.c, (Collection) collection);
            if (!a) {
                return a;
            }
            AbstractMapBasedMultimap.m3600a(this.f2221a, this.c.size() - size);
            m3573b();
            return a;
        }
    }

    /* renamed from: com.google.common.collect.AbstractMapBasedMultimap.i */
    private class C1754i extends C1746f implements SortedSet<V> {
        final /* synthetic */ AbstractMapBasedMultimap f2222a;

        C1754i(AbstractMapBasedMultimap abstractMapBasedMultimap, K k, SortedSet<V> sortedSet, C1746f c1746f) {
            this.f2222a = abstractMapBasedMultimap;
            super(abstractMapBasedMultimap, k, sortedSet, c1746f);
        }

        SortedSet<V> m3586g() {
            return (SortedSet) m3576e();
        }

        public Comparator<? super V> comparator() {
            return m3586g().comparator();
        }

        public V first() {
            m3572a();
            return m3586g().first();
        }

        public V last() {
            m3572a();
            return m3586g().last();
        }

        public SortedSet<V> headSet(V v) {
            C1746f f;
            m3572a();
            AbstractMapBasedMultimap abstractMapBasedMultimap = this.f2222a;
            Object c = m3574c();
            SortedSet headSet = m3586g().headSet(v);
            if (m3577f() != null) {
                f = m3577f();
            }
            return new C1754i(abstractMapBasedMultimap, c, headSet, f);
        }

        public SortedSet<V> subSet(V v, V v2) {
            C1746f f;
            m3572a();
            AbstractMapBasedMultimap abstractMapBasedMultimap = this.f2222a;
            Object c = m3574c();
            SortedSet subSet = m3586g().subSet(v, v2);
            if (m3577f() != null) {
                f = m3577f();
            }
            return new C1754i(abstractMapBasedMultimap, c, subSet, f);
        }

        public SortedSet<V> tailSet(V v) {
            C1746f f;
            m3572a();
            AbstractMapBasedMultimap abstractMapBasedMultimap = this.f2222a;
            Object c = m3574c();
            SortedSet tailSet = m3586g().tailSet(v);
            if (m3577f() != null) {
                f = m3577f();
            }
            return new C1754i(abstractMapBasedMultimap, c, tailSet, f);
        }
    }

    abstract Collection<V> m3611a();

    static /* synthetic */ int m3600a(AbstractMapBasedMultimap abstractMapBasedMultimap, int i) {
        int i2 = abstractMapBasedMultimap.f2226b + i;
        abstractMapBasedMultimap.f2226b = i2;
        return i2;
    }

    static /* synthetic */ int m3608b(AbstractMapBasedMultimap abstractMapBasedMultimap, int i) {
        int i2 = abstractMapBasedMultimap.f2226b - i;
        abstractMapBasedMultimap.f2226b = i2;
        return i2;
    }

    protected AbstractMapBasedMultimap(Map<K, Collection<V>> map) {
        C1650g.m3085a(map.isEmpty());
        this.f2225a = map;
    }

    Collection<V> m3612a(K k) {
        return m3611a();
    }

    public int m3615b() {
        return this.f2226b;
    }

    public boolean m3614a(K k, V v) {
        Collection collection = (Collection) this.f2225a.get(k);
        if (collection == null) {
            collection = m3612a((Object) k);
            if (collection.add(v)) {
                this.f2226b++;
                this.f2225a.put(k, collection);
                return true;
            }
            throw new AssertionError("New Collection violated the Collection spec");
        } else if (!collection.add(v)) {
            return false;
        } else {
            this.f2226b++;
            return true;
        }
    }

    public void m3617c() {
        for (Collection clear : this.f2225a.values()) {
            clear.clear();
        }
        this.f2225a.clear();
        this.f2226b = 0;
    }

    public Collection<V> m3616b(K k) {
        Collection collection = (Collection) this.f2225a.get(k);
        if (collection == null) {
            collection = m3612a((Object) k);
        }
        return m3613a((Object) k, collection);
    }

    Collection<V> m3613a(K k, Collection<V> collection) {
        if (collection instanceof SortedSet) {
            return new C1754i(this, k, (SortedSet) collection, null);
        }
        if (collection instanceof Set) {
            return new C1753h(this, k, (Set) collection);
        }
        if (collection instanceof List) {
            return m3605a(k, (List) collection, null);
        }
        return new C1746f(this, k, collection, null);
    }

    private List<V> m3605a(K k, List<V> list, C1746f c1746f) {
        return list instanceof RandomAccess ? new C1748c(this, k, list, c1746f) : new C1747g(this, k, list, c1746f);
    }

    private Iterator<V> m3603a(Collection<V> collection) {
        return collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    Set<K> m3618d() {
        return this.f2225a instanceof SortedMap ? new C1750e(this, (SortedMap) this.f2225a) : new C1745b(this, this.f2225a);
    }

    private int m3610c(Object obj) {
        Collection collection = (Collection) C1876q.m4338c(this.f2225a, obj);
        int i = 0;
        if (collection != null) {
            i = collection.size();
            collection.clear();
            this.f2226b -= i;
        }
        return i;
    }

    Map<K, Collection<V>> m3619e() {
        return this.f2225a instanceof SortedMap ? new C1749d(this, (SortedMap) this.f2225a) : new C1742a(this, this.f2225a);
    }
}
