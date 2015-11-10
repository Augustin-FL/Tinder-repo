package com.google.common.collect;

import com.google.common.base.C1650g;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public final class Sets {

    /* renamed from: com.google.common.collect.Sets.a */
    static abstract class C1738a<E> extends AbstractSet<E> {
        C1738a() {
        }

        public boolean removeAll(Collection<?> collection) {
            return Sets.m4233a((Set) this, (Collection) collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return super.retainAll((Collection) C1650g.m3080a((Object) collection));
        }
    }

    private static class SetFromMap<E> extends AbstractSet<E> implements Serializable, Set<E> {
        private static final long serialVersionUID = 0;
        private final Map<E, Boolean> f2479a;
        private transient Set<E> f2480b;

        SetFromMap(Map<E, Boolean> map) {
            C1650g.m3086a(map.isEmpty(), (Object) "Map is non-empty");
            this.f2479a = map;
            this.f2480b = map.keySet();
        }

        public void clear() {
            this.f2479a.clear();
        }

        public int size() {
            return this.f2479a.size();
        }

        public boolean isEmpty() {
            return this.f2479a.isEmpty();
        }

        public boolean contains(Object obj) {
            return this.f2479a.containsKey(obj);
        }

        public boolean remove(Object obj) {
            return this.f2479a.remove(obj) != null;
        }

        public boolean add(E e) {
            return this.f2479a.put(e, Boolean.TRUE) == null;
        }

        public Iterator<E> iterator() {
            return this.f2480b.iterator();
        }

        public Object[] toArray() {
            return this.f2480b.toArray();
        }

        public <T> T[] toArray(T[] tArr) {
            return this.f2480b.toArray(tArr);
        }

        public String toString() {
            return this.f2480b.toString();
        }

        public int hashCode() {
            return this.f2480b.hashCode();
        }

        public boolean equals(Object obj) {
            return this == obj || this.f2480b.equals(obj);
        }

        public boolean containsAll(Collection<?> collection) {
            return this.f2480b.containsAll(collection);
        }

        public boolean removeAll(Collection<?> collection) {
            return this.f2480b.removeAll(collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return this.f2480b.retainAll(collection);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.f2480b = this.f2479a.keySet();
        }
    }

    public static <E> HashSet<E> m4227a() {
        return new HashSet();
    }

    public static <E> HashSet<E> m4228a(int i) {
        return new HashSet(C1876q.m4333b(i));
    }

    public static <E> HashSet<E> m4229a(Iterable<? extends E> iterable) {
        return iterable instanceof Collection ? new HashSet(C1851f.m4265a((Iterable) iterable)) : m4230a(iterable.iterator());
    }

    public static <E> HashSet<E> m4230a(Iterator<? extends E> it) {
        HashSet<E> a = m4227a();
        while (it.hasNext()) {
            a.add(it.next());
        }
        return a;
    }

    public static <E> LinkedHashSet<E> m4235b() {
        return new LinkedHashSet();
    }

    public static <E> LinkedHashSet<E> m4236b(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new LinkedHashSet(C1851f.m4265a((Iterable) iterable));
        }
        LinkedHashSet<E> b = m4235b();
        for (Object add : iterable) {
            b.add(add);
        }
        return b;
    }

    public static <E> Set<E> m4237c() {
        return m4231a(C1876q.m4340d());
    }

    public static <E> Set<E> m4231a(Map<E, Boolean> map) {
        return new SetFromMap(map);
    }

    static int m4226a(Set<?> set) {
        int i = 0;
        for (Object next : set) {
            int hashCode;
            if (next != null) {
                hashCode = next.hashCode();
            } else {
                hashCode = 0;
            }
            i = ((i + hashCode) ^ -1) ^ -1;
        }
        return i;
    }

    static boolean m4232a(Set<?> set, Object obj) {
        boolean z = true;
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            if (!(set.size() == set2.size() && set.containsAll(set2))) {
                z = false;
            }
            return z;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    static boolean m4234a(Set<?> set, Iterator<?> it) {
        boolean z = false;
        while (it.hasNext()) {
            z |= set.remove(it.next());
        }
        return z;
    }

    static boolean m4233a(Set<?> set, Collection<?> collection) {
        C1650g.m3080a((Object) collection);
        if (collection instanceof C1877s) {
            collection = ((C1877s) collection).m4343a();
        }
        if (!(collection instanceof Set) || collection.size() <= set.size()) {
            return m4234a((Set) set, collection.iterator());
        }
        Iterator it = set.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                z = true;
                it.remove();
            }
        }
        return z;
    }
}
