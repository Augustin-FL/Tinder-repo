package com.google.common.collect;

import java.util.Map.Entry;
import java.util.Set;

final class EmptyImmutableBiMap extends ImmutableBiMap<Object, Object> {
    static final EmptyImmutableBiMap f2233a;

    public /* synthetic */ Set entrySet() {
        return m3642b();
    }

    public /* synthetic */ Set keySet() {
        return m3644d();
    }

    static {
        f2233a = new EmptyImmutableBiMap();
    }

    private EmptyImmutableBiMap() {
    }

    public ImmutableBiMap<Object, Object> i_() {
        return this;
    }

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return true;
    }

    public Object get(Object obj) {
        return null;
    }

    public ImmutableSet<Entry<Object, Object>> m3642b() {
        return ImmutableSet.m3678g();
    }

    ImmutableSet<Entry<Object, Object>> m3643c() {
        throw new AssertionError("should never be called");
    }

    public ImmutableSet<Object> m3644d() {
        return ImmutableSet.m3678g();
    }

    boolean m3645e() {
        return false;
    }

    Object readResolve() {
        return f2233a;
    }
}
