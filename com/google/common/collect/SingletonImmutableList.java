package com.google.common.collect;

import com.google.common.base.C1650g;
import java.util.Iterator;
import java.util.List;

final class SingletonImmutableList<E> extends ImmutableList<E> {
    final transient E f2484a;

    public /* synthetic */ Iterator iterator() {
        return m4243b();
    }

    public /* synthetic */ List subList(int i, int i2) {
        return m4241a(i, i2);
    }

    SingletonImmutableList(E e) {
        this.f2484a = C1650g.m3080a((Object) e);
    }

    public E get(int i) {
        C1650g.m3078a(i, 1);
        return this.f2484a;
    }

    public int indexOf(Object obj) {
        return this.f2484a.equals(obj) ? 0 : -1;
    }

    public ac<E> m4243b() {
        return C1868o.m4290a(this.f2484a);
    }

    public int lastIndexOf(Object obj) {
        return indexOf(obj);
    }

    public int size() {
        return 1;
    }

    public ImmutableList<E> m4241a(int i, int i2) {
        C1650g.m3084a(i, i2, 1);
        return i == i2 ? ImmutableList.m3656g() : this;
    }

    public ImmutableList<E> j_() {
        return this;
    }

    public boolean contains(Object obj) {
        return this.f2484a.equals(obj);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list = (List) obj;
        if (list.size() == 1 && this.f2484a.equals(list.get(0))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f2484a.hashCode() + 31;
    }

    public String toString() {
        String obj = this.f2484a.toString();
        return new StringBuilder(obj.length() + 2).append('[').append(obj).append(']').toString();
    }

    public boolean isEmpty() {
        return false;
    }

    boolean m4242a() {
        return false;
    }

    public Object[] toArray() {
        return new Object[]{this.f2484a};
    }

    public <T> T[] toArray(T[] tArr) {
        if (tArr.length == 0) {
            tArr = C1878t.m4348a((Object[]) tArr, 1);
        } else if (tArr.length > 1) {
            tArr[1] = null;
        }
        tArr[0] = this.f2484a;
        return tArr;
    }
}
