package com.google.common.collect;

import com.google.common.base.C1647e;
import com.google.common.base.C1650g;
import com.google.common.p024c.C1662a;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* renamed from: com.google.common.collect.p */
public final class C1872p {

    /* renamed from: com.google.common.collect.p.b */
    private static class C1869b<T> extends AbstractList<T> {
        private final List<T> f2519a;

        /* renamed from: com.google.common.collect.p.b.1 */
        class C18711 implements ListIterator<T> {
            boolean f2520a;
            boolean f2521b;
            final /* synthetic */ ListIterator f2522c;
            final /* synthetic */ C1869b f2523d;

            C18711(C1869b c1869b, ListIterator listIterator) {
                this.f2523d = c1869b;
                this.f2522c = listIterator;
            }

            public void add(T t) {
                this.f2522c.add(t);
                this.f2522c.previous();
                this.f2520a = false;
                this.f2521b = false;
            }

            public boolean hasNext() {
                return this.f2522c.hasPrevious();
            }

            public boolean hasPrevious() {
                return this.f2522c.hasNext();
            }

            public T next() {
                if (hasNext()) {
                    this.f2520a = true;
                    this.f2521b = true;
                    return this.f2522c.previous();
                }
                throw new NoSuchElementException();
            }

            public int nextIndex() {
                return this.f2523d.m4306b(this.f2522c.nextIndex());
            }

            public T previous() {
                if (hasPrevious()) {
                    this.f2520a = true;
                    this.f2521b = true;
                    return this.f2522c.next();
                }
                throw new NoSuchElementException();
            }

            public int previousIndex() {
                return nextIndex() - 1;
            }

            public void remove() {
                C1650g.m3091b(this.f2520a);
                this.f2522c.remove();
                this.f2521b = false;
                this.f2520a = false;
            }

            public void set(T t) {
                C1650g.m3091b(this.f2521b);
                this.f2522c.set(t);
            }
        }

        C1869b(List<T> list) {
            this.f2519a = (List) C1650g.m3080a((Object) list);
        }

        List<T> m4307a() {
            return this.f2519a;
        }

        private int m4304a(int i) {
            int size = size();
            C1650g.m3078a(i, size);
            return (size - 1) - i;
        }

        private int m4306b(int i) {
            int size = size();
            C1650g.m3088b(i, size);
            return size - i;
        }

        public void add(int i, T t) {
            this.f2519a.add(m4306b(i), t);
        }

        public void clear() {
            this.f2519a.clear();
        }

        public T remove(int i) {
            return this.f2519a.remove(m4304a(i));
        }

        protected void removeRange(int i, int i2) {
            subList(i, i2).clear();
        }

        public T set(int i, T t) {
            return this.f2519a.set(m4304a(i), t);
        }

        public T get(int i) {
            return this.f2519a.get(m4304a(i));
        }

        public boolean isEmpty() {
            return this.f2519a.isEmpty();
        }

        public int size() {
            return this.f2519a.size();
        }

        public boolean contains(Object obj) {
            return this.f2519a.contains(obj);
        }

        public boolean containsAll(Collection<?> collection) {
            return this.f2519a.containsAll(collection);
        }

        public List<T> subList(int i, int i2) {
            C1650g.m3084a(i, i2, size());
            return C1872p.m4313a(this.f2519a.subList(m4306b(i2), m4306b(i)));
        }

        public int indexOf(Object obj) {
            int lastIndexOf = this.f2519a.lastIndexOf(obj);
            return lastIndexOf >= 0 ? m4304a(lastIndexOf) : -1;
        }

        public int lastIndexOf(Object obj) {
            int indexOf = this.f2519a.indexOf(obj);
            return indexOf >= 0 ? m4304a(indexOf) : -1;
        }

        public Iterator<T> iterator() {
            return listIterator();
        }

        public ListIterator<T> listIterator(int i) {
            return new C18711(this, this.f2519a.listIterator(m4306b(i)));
        }
    }

    /* renamed from: com.google.common.collect.p.a */
    private static class C1870a<T> extends C1869b<T> implements RandomAccess {
        C1870a(List<T> list) {
            super(list);
        }
    }

    public static <E> ArrayList<E> m4309a() {
        return new ArrayList();
    }

    public static <E> ArrayList<E> m4312a(E... eArr) {
        C1650g.m3080a((Object) eArr);
        Object arrayList = new ArrayList(C1872p.m4308a(eArr.length));
        Collections.addAll(arrayList, eArr);
        return arrayList;
    }

    static int m4308a(int i) {
        C1650g.m3085a(i >= 0);
        return C1662a.m3123a((5 + ((long) i)) + ((long) (i / 10)));
    }

    public static <E> ArrayList<E> m4310a(Iterable<? extends E> iterable) {
        C1650g.m3080a((Object) iterable);
        return iterable instanceof Collection ? new ArrayList(C1851f.m4265a((Iterable) iterable)) : C1872p.m4311a(iterable.iterator());
    }

    public static <E> ArrayList<E> m4311a(Iterator<? extends E> it) {
        C1650g.m3080a((Object) it);
        ArrayList<E> a = C1872p.m4309a();
        while (it.hasNext()) {
            a.add(it.next());
        }
        return a;
    }

    public static <E> ArrayList<E> m4317b(int i) {
        C1650g.m3085a(i >= 0);
        return new ArrayList(i);
    }

    public static <E> ArrayList<E> m4321c(int i) {
        return new ArrayList(C1872p.m4308a(i));
    }

    public static <E> LinkedList<E> m4318b() {
        return new LinkedList();
    }

    public static <E> LinkedList<E> m4319b(Iterable<? extends E> iterable) {
        LinkedList<E> b = C1872p.m4318b();
        for (Object add : iterable) {
            b.add(add);
        }
        return b;
    }

    public static <T> List<T> m4313a(List<T> list) {
        if (list instanceof C1869b) {
            return ((C1869b) list).m4307a();
        }
        if (list instanceof RandomAccess) {
            return new C1870a(list);
        }
        return new C1869b(list);
    }

    static int m4315b(List<?> list) {
        int i = 1;
        for (Object next : list) {
            i = (((next == null ? 0 : next.hashCode()) + (i * 31)) ^ -1) ^ -1;
        }
        return i;
    }

    static boolean m4314a(List<?> list, Object obj) {
        if (obj == C1650g.m3080a((Object) list)) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list2 = (List) obj;
        if (list.size() == list2.size() && C1868o.m4299a(list.iterator(), list2.iterator())) {
            return true;
        }
        return false;
    }

    static int m4316b(List<?> list, Object obj) {
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (C1647e.m3074a(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    static int m4320c(List<?> list, Object obj) {
        ListIterator listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (C1647e.m3074a(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }
}
