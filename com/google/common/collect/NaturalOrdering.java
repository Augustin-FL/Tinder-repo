package com.google.common.collect;

import com.google.common.base.C1650g;
import java.io.Serializable;

final class NaturalOrdering extends C1757u<Comparable> implements Serializable {
    static final NaturalOrdering f2446a;
    private static final long serialVersionUID = 0;

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m4158a((Comparable) obj, (Comparable) obj2);
    }

    static {
        f2446a = new NaturalOrdering();
    }

    public int m4158a(Comparable comparable, Comparable comparable2) {
        C1650g.m3080a((Object) comparable);
        C1650g.m3080a((Object) comparable2);
        if (comparable == comparable2) {
            return 0;
        }
        return comparable.compareTo(comparable2);
    }

    public <S extends Comparable> C1757u<S> m4159a() {
        return ReverseNaturalOrdering.f2477a;
    }

    private Object readResolve() {
        return f2446a;
    }

    public String toString() {
        return "Ordering.natural()";
    }

    private NaturalOrdering() {
    }
}
