package com.google.common.collect;

import java.util.Collection;
import java.util.Set;

/* renamed from: com.google.common.collect.l */
public abstract class C1855l<E> extends C1854h<E> implements Set<E> {
    protected abstract Set<E> m4275c();

    protected /* synthetic */ Collection m4273a() {
        return m4275c();
    }

    protected /* synthetic */ Object m4274b() {
        return m4275c();
    }

    protected C1855l() {
    }

    public boolean equals(Object obj) {
        return obj == this || m4275c().equals(obj);
    }

    public int hashCode() {
        return m4275c().hashCode();
    }
}
