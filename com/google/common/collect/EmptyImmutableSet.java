package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

final class EmptyImmutableSet extends ImmutableSet<Object> {
    static final EmptyImmutableSet f2238a;
    private static final long serialVersionUID = 0;

    public /* synthetic */ Iterator iterator() {
        return m3683b();
    }

    static {
        f2238a = new EmptyImmutableSet();
    }

    private EmptyImmutableSet() {
    }

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return true;
    }

    public boolean contains(Object obj) {
        return false;
    }

    public boolean containsAll(Collection<?> collection) {
        return collection.isEmpty();
    }

    public ac<Object> m3683b() {
        return C1868o.m4289a();
    }

    boolean m3682a() {
        return false;
    }

    public Object[] toArray() {
        return C1878t.f2526a;
    }

    public <T> T[] toArray(T[] tArr) {
        return m3684c().toArray(tArr);
    }

    public ImmutableList<Object> m3684c() {
        return ImmutableList.m3656g();
    }

    public boolean equals(Object obj) {
        if (obj instanceof Set) {
            return ((Set) obj).isEmpty();
        }
        return false;
    }

    public final int hashCode() {
        return 0;
    }

    boolean m3685d() {
        return true;
    }

    public String toString() {
        return "[]";
    }

    Object readResolve() {
        return f2238a;
    }
}
