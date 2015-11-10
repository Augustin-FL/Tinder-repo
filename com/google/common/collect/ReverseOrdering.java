package com.google.common.collect;

import com.google.common.base.C1650g;
import java.io.Serializable;

final class ReverseOrdering<T> extends C1757u<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final C1757u<? super T> f2478a;

    ReverseOrdering(C1757u<? super T> c1757u) {
        this.f2478a = (C1757u) C1650g.m3080a((Object) c1757u);
    }

    public int compare(T t, T t2) {
        return this.f2478a.compare(t2, t);
    }

    public <S extends T> C1757u<S> m4225a() {
        return this.f2478a;
    }

    public int hashCode() {
        return -this.f2478a.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ReverseOrdering)) {
            return false;
        }
        return this.f2478a.equals(((ReverseOrdering) obj).f2478a);
    }

    public String toString() {
        return this.f2478a + ".reverse()";
    }
}
