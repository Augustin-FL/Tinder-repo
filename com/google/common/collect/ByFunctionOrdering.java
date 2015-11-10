package com.google.common.collect;

import com.google.common.base.C1430c;
import com.google.common.base.C1647e;
import com.google.common.base.C1650g;
import java.io.Serializable;

final class ByFunctionOrdering<F, T> extends C1757u<F> implements Serializable {
    private static final long serialVersionUID = 0;
    final C1430c<F, ? extends T> f2227a;
    final C1757u<T> f2228b;

    ByFunctionOrdering(C1430c<F, ? extends T> c1430c, C1757u<T> c1757u) {
        this.f2227a = (C1430c) C1650g.m3080a((Object) c1430c);
        this.f2228b = (C1757u) C1650g.m3080a((Object) c1757u);
    }

    public int compare(F f, F f2) {
        return this.f2228b.compare(this.f2227a.m1805a(f), this.f2227a.m1805a(f2));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByFunctionOrdering)) {
            return false;
        }
        ByFunctionOrdering byFunctionOrdering = (ByFunctionOrdering) obj;
        if (this.f2227a.equals(byFunctionOrdering.f2227a) && this.f2228b.equals(byFunctionOrdering.f2228b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return C1647e.m3071a(this.f2227a, this.f2228b);
    }

    public String toString() {
        return this.f2228b + ".onResultOf(" + this.f2227a + ")";
    }
}
