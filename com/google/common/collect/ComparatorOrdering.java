package com.google.common.collect;

import com.google.common.base.C1650g;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

final class ComparatorOrdering<T> extends C1757u<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final Comparator<T> f2229a;

    ComparatorOrdering(Comparator<T> comparator) {
        this.f2229a = (Comparator) C1650g.m3080a((Object) comparator);
    }

    public int compare(T t, T t2) {
        return this.f2229a.compare(t, t2);
    }

    public <E extends T> ImmutableList<E> m3625a(Iterable<E> iterable) {
        Object[] c = C1859n.m4283c(iterable);
        for (Object a : c) {
            C1650g.m3080a(a);
        }
        Arrays.sort(c, this.f2229a);
        return ImmutableList.m3654b(c);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ComparatorOrdering)) {
            return false;
        }
        return this.f2229a.equals(((ComparatorOrdering) obj).f2229a);
    }

    public int hashCode() {
        return this.f2229a.hashCode();
    }

    public String toString() {
        return this.f2229a.toString();
    }
}
