package com.google.common.collect;

import com.google.common.base.C1650g;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

final class EmptyImmutableList extends ImmutableList<Object> {
    static final EmptyImmutableList f2236a;
    private static final long serialVersionUID = 0;

    public /* synthetic */ Iterator iterator() {
        return m3667b();
    }

    public /* synthetic */ ListIterator listIterator() {
        return m3668d();
    }

    public /* synthetic */ ListIterator listIterator(int i) {
        return m3665a(i);
    }

    public /* synthetic */ List subList(int i, int i2) {
        return m3664a(i, i2);
    }

    static {
        f2236a = new EmptyImmutableList();
    }

    private EmptyImmutableList() {
    }

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return true;
    }

    boolean m3666a() {
        return false;
    }

    public boolean contains(Object obj) {
        return false;
    }

    public boolean containsAll(Collection<?> collection) {
        return collection.isEmpty();
    }

    public ac<Object> m3667b() {
        return m3668d();
    }

    public Object[] toArray() {
        return C1878t.f2526a;
    }

    public <T> T[] toArray(T[] tArr) {
        if (tArr.length > 0) {
            tArr[0] = null;
        }
        return tArr;
    }

    public Object get(int i) {
        C1650g.m3078a(i, 0);
        throw new AssertionError("unreachable");
    }

    public int indexOf(Object obj) {
        return -1;
    }

    public int lastIndexOf(Object obj) {
        return -1;
    }

    public ImmutableList<Object> m3664a(int i, int i2) {
        C1650g.m3084a(i, i2, 0);
        return this;
    }

    public ImmutableList<Object> j_() {
        return this;
    }

    public ad<Object> m3668d() {
        return C1868o.f2517a;
    }

    public ad<Object> m3665a(int i) {
        C1650g.m3088b(i, 0);
        return C1868o.f2517a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof List) {
            return ((List) obj).isEmpty();
        }
        return false;
    }

    public int hashCode() {
        return 1;
    }

    public String toString() {
        return "[]";
    }

    Object readResolve() {
        return f2236a;
    }
}
