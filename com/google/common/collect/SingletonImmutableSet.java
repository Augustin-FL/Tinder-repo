package com.google.common.collect;

import com.google.common.base.C1650g;
import java.util.Iterator;
import java.util.Set;

final class SingletonImmutableSet<E> extends ImmutableSet<E> {
    final transient E f2485a;
    private transient int f2486c;

    public /* synthetic */ Iterator iterator() {
        return m4245b();
    }

    SingletonImmutableSet(E e) {
        this.f2485a = C1650g.m3080a((Object) e);
    }

    SingletonImmutableSet(E e, int i) {
        this.f2485a = e;
        this.f2486c = i;
    }

    public int size() {
        return 1;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean contains(Object obj) {
        return this.f2485a.equals(obj);
    }

    public ac<E> m4245b() {
        return C1868o.m4290a(this.f2485a);
    }

    boolean m4244a() {
        return false;
    }

    public Object[] toArray() {
        return new Object[]{this.f2485a};
    }

    public <T> T[] toArray(T[] tArr) {
        if (tArr.length == 0) {
            tArr = C1878t.m4348a((Object[]) tArr, 1);
        } else if (tArr.length > 1) {
            tArr[1] = null;
        }
        tArr[0] = this.f2485a;
        return tArr;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (set.size() == 1 && this.f2485a.equals(set.iterator().next())) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = this.f2486c;
        if (i != 0) {
            return i;
        }
        i = this.f2485a.hashCode();
        this.f2486c = i;
        return i;
    }

    boolean m4246d() {
        return this.f2486c != 0;
    }

    public String toString() {
        String obj = this.f2485a.toString();
        return new StringBuilder(obj.length() + 2).append('[').append(obj).append(']').toString();
    }
}
