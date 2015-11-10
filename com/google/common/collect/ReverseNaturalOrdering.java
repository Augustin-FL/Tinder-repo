package com.google.common.collect;

import com.google.common.base.C1650g;
import java.io.Serializable;

final class ReverseNaturalOrdering extends C1757u<Comparable> implements Serializable {
    static final ReverseNaturalOrdering f2477a;
    private static final long serialVersionUID = 0;

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m4223a((Comparable) obj, (Comparable) obj2);
    }

    static {
        f2477a = new ReverseNaturalOrdering();
    }

    public int m4223a(Comparable comparable, Comparable comparable2) {
        C1650g.m3080a((Object) comparable);
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    public <S extends Comparable> C1757u<S> m4224a() {
        return C1757u.m3621b();
    }

    private Object readResolve() {
        return f2477a;
    }

    public String toString() {
        return "Ordering.natural().reverse()";
    }

    private ReverseNaturalOrdering() {
    }
}
