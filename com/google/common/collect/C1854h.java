package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;

/* renamed from: com.google.common.collect.h */
public abstract class C1854h<E> extends C1682k implements Collection<E> {
    protected abstract Collection<E> m4271a();

    protected /* synthetic */ Object m4272b() {
        return m4271a();
    }

    protected C1854h() {
    }

    public Iterator<E> iterator() {
        return m4271a().iterator();
    }

    public int size() {
        return m4271a().size();
    }

    public boolean removeAll(Collection<?> collection) {
        return m4271a().removeAll(collection);
    }

    public boolean isEmpty() {
        return m4271a().isEmpty();
    }

    public boolean contains(Object obj) {
        return m4271a().contains(obj);
    }

    public boolean add(E e) {
        return m4271a().add(e);
    }

    public boolean remove(Object obj) {
        return m4271a().remove(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return m4271a().containsAll(collection);
    }

    public boolean addAll(Collection<? extends E> collection) {
        return m4271a().addAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return m4271a().retainAll(collection);
    }

    public void clear() {
        m4271a().clear();
    }

    public Object[] toArray() {
        return m4271a().toArray();
    }

    public <T> T[] toArray(T[] tArr) {
        return m4271a().toArray(tArr);
    }
}
