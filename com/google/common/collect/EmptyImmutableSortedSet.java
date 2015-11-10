package com.google.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

class EmptyImmutableSortedSet<E> extends ImmutableSortedSet<E> {
    public /* synthetic */ Iterator iterator() {
        return m3755b();
    }

    EmptyImmutableSortedSet(Comparator<? super E> comparator) {
        super(comparator);
    }

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return true;
    }

    public boolean contains(Object obj) {
        return false;
    }

    public boolean containsAll(Collection<?> collection) {
        return collection.isEmpty();
    }

    public ac<E> m3755b() {
        return C1868o.m4289a();
    }

    public ac<E> m3757e() {
        return C1868o.m4289a();
    }

    boolean m3753a() {
        return false;
    }

    public ImmutableList<E> m3756c() {
        return ImmutableList.m3656g();
    }

    public Object[] toArray() {
        return C1878t.f2526a;
    }

    public <T> T[] toArray(T[] tArr) {
        return m3756c().toArray(tArr);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Set) {
            return ((Set) obj).isEmpty();
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "[]";
    }

    public E first() {
        throw new NoSuchElementException();
    }

    public E last() {
        throw new NoSuchElementException();
    }

    ImmutableSortedSet<E> m3751a(E e, boolean z) {
        return this;
    }

    ImmutableSortedSet<E> m3752a(E e, boolean z, E e2, boolean z2) {
        return this;
    }

    ImmutableSortedSet<E> m3754b(E e, boolean z) {
        return this;
    }

    int m3750a(Object obj) {
        return -1;
    }
}
