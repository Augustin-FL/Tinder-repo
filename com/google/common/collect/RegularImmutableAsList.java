package com.google.common.collect;

import java.util.ListIterator;

class RegularImmutableAsList<E> extends ImmutableAsList<E> {
    private final ImmutableCollection<E> f2302a;
    private final ImmutableList<? extends E> f2303c;

    public /* synthetic */ ListIterator listIterator(int i) {
        return m3843a(i);
    }

    RegularImmutableAsList(ImmutableCollection<E> immutableCollection, ImmutableList<? extends E> immutableList) {
        this.f2302a = immutableCollection;
        this.f2303c = immutableList;
    }

    RegularImmutableAsList(ImmutableCollection<E> immutableCollection, Object[] objArr) {
        this((ImmutableCollection) immutableCollection, ImmutableList.m3654b(objArr));
    }

    ImmutableCollection<E> m3844e() {
        return this.f2302a;
    }

    public ad<E> m3843a(int i) {
        return this.f2303c.m3659a(i);
    }

    public Object[] toArray() {
        return this.f2303c.toArray();
    }

    public <T> T[] toArray(T[] tArr) {
        return this.f2303c.toArray(tArr);
    }

    public int indexOf(Object obj) {
        return this.f2303c.indexOf(obj);
    }

    public int lastIndexOf(Object obj) {
        return this.f2303c.lastIndexOf(obj);
    }

    public boolean equals(Object obj) {
        return this.f2303c.equals(obj);
    }

    public int hashCode() {
        return this.f2303c.hashCode();
    }

    public E get(int i) {
        return this.f2303c.get(i);
    }
}
