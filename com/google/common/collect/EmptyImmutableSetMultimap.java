package com.google.common.collect;

class EmptyImmutableSetMultimap extends ImmutableSetMultimap<Object, Object> {
    static final EmptyImmutableSetMultimap f2242a;
    private static final long serialVersionUID = 0;

    static {
        f2242a = new EmptyImmutableSetMultimap();
    }

    private EmptyImmutableSetMultimap() {
        super(ImmutableMap.m3629i(), 0, null);
    }

    private Object readResolve() {
        return f2242a;
    }
}
