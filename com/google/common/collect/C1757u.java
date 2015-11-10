package com.google.common.collect;

import com.google.common.base.C1430c;
import com.google.common.base.C1650g;
import java.util.Arrays;
import java.util.Comparator;

/* renamed from: com.google.common.collect.u */
public abstract class C1757u<T> implements Comparator<T> {
    public abstract int compare(T t, T t2);

    public static <C extends Comparable> C1757u<C> m3621b() {
        return NaturalOrdering.f2446a;
    }

    public static <T> C1757u<T> m3620a(Comparator<T> comparator) {
        return comparator instanceof C1757u ? (C1757u) comparator : new ComparatorOrdering(comparator);
    }

    protected C1757u() {
    }

    public <S extends T> C1757u<S> m3623a() {
        return new ReverseOrdering(this);
    }

    public <F> C1757u<F> m3624a(C1430c<F, ? extends T> c1430c) {
        return new ByFunctionOrdering(c1430c, this);
    }

    public <E extends T> ImmutableList<E> m3622a(Iterable<E> iterable) {
        Object[] c = C1859n.m4283c(iterable);
        for (Object a : c) {
            C1650g.m3080a(a);
        }
        Arrays.sort(c, this);
        return ImmutableList.m3654b(c);
    }
}
