package com.google.common.collect;

import java.util.Comparator;

final class ImmutableSortedAsList<E> extends RegularImmutableAsList<E> implements C1760z<E> {
    /* synthetic */ ImmutableCollection m3846e() {
        return m3847i();
    }

    ImmutableSortedAsList(ImmutableSortedSet<E> immutableSortedSet, ImmutableList<E> immutableList) {
        super((ImmutableCollection) immutableSortedSet, (ImmutableList) immutableList);
    }

    ImmutableSortedSet<E> m3847i() {
        return (ImmutableSortedSet) super.m3844e();
    }

    public Comparator<? super E> comparator() {
        return m3847i().comparator();
    }

    public int indexOf(Object obj) {
        int a = m3847i().m3737a(obj);
        return (a < 0 || !get(a).equals(obj)) ? -1 : a;
    }

    public int lastIndexOf(Object obj) {
        return indexOf(obj);
    }

    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    ImmutableList<E> m3845b(int i, int i2) {
        return new RegularImmutableSortedSet(super.m3660b(i, i2), comparator()).m3648c();
    }
}
