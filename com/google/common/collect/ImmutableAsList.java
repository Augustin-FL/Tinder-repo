package com.google.common.collect;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

abstract class ImmutableAsList<E> extends ImmutableList<E> {

    static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final ImmutableCollection<?> f2252a;

        SerializedForm(ImmutableCollection<?> immutableCollection) {
            this.f2252a = immutableCollection;
        }

        Object readResolve() {
            return this.f2252a.m3648c();
        }
    }

    abstract ImmutableCollection<E> m3762e();

    ImmutableAsList() {
    }

    public boolean contains(Object obj) {
        return m3762e().contains(obj);
    }

    public int size() {
        return m3762e().size();
    }

    public boolean isEmpty() {
        return m3762e().isEmpty();
    }

    boolean m3761a() {
        return m3762e().m3646a();
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    Object writeReplace() {
        return new SerializedForm(m3762e());
    }
}
