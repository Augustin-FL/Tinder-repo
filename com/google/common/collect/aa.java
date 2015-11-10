package com.google.common.collect;

import com.google.common.base.C1650g;
import java.util.Comparator;
import java.util.SortedSet;

final class aa {
    public static boolean m4259a(Comparator<?> comparator, Iterable<?> iterable) {
        Object a;
        C1650g.m3080a((Object) comparator);
        C1650g.m3080a((Object) iterable);
        if (iterable instanceof SortedSet) {
            a = m4258a((SortedSet) iterable);
        } else if (!(iterable instanceof C1760z)) {
            return false;
        } else {
            a = ((C1760z) iterable).comparator();
        }
        return comparator.equals(a);
    }

    public static <E> Comparator<? super E> m4258a(SortedSet<E> sortedSet) {
        Comparator<? super E> comparator = sortedSet.comparator();
        if (comparator == null) {
            return C1757u.m3621b();
        }
        return comparator;
    }
}
