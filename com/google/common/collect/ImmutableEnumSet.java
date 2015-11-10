package com.google.common.collect;

import java.io.Serializable;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

final class ImmutableEnumSet<E extends Enum<E>> extends ImmutableSet<E> {
    private final transient EnumSet<E> f2268a;
    private transient int f2269c;

    private static class EnumSerializedForm<E extends Enum<E>> implements Serializable {
        private static final long serialVersionUID = 0;
        final EnumSet<E> f2267a;

        EnumSerializedForm(EnumSet<E> enumSet) {
            this.f2267a = enumSet;
        }

        Object readResolve() {
            return new ImmutableEnumSet(null);
        }
    }

    public /* synthetic */ Iterator iterator() {
        return m3798b();
    }

    static <E extends Enum<E>> ImmutableSet<E> m3796a(EnumSet<E> enumSet) {
        switch (enumSet.size()) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                return ImmutableSet.m3678g();
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                return ImmutableSet.m3676b(C1859n.m4282b(enumSet));
            default:
                return new ImmutableEnumSet(enumSet);
        }
    }

    private ImmutableEnumSet(EnumSet<E> enumSet) {
        this.f2268a = enumSet;
    }

    boolean m3797a() {
        return false;
    }

    public ac<E> m3798b() {
        return C1868o.m4291a(this.f2268a.iterator());
    }

    public int size() {
        return this.f2268a.size();
    }

    public boolean contains(Object obj) {
        return this.f2268a.contains(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return this.f2268a.containsAll(collection);
    }

    public boolean isEmpty() {
        return this.f2268a.isEmpty();
    }

    public Object[] toArray() {
        return this.f2268a.toArray();
    }

    public <T> T[] toArray(T[] tArr) {
        return this.f2268a.toArray(tArr);
    }

    public boolean equals(Object obj) {
        return obj == this || this.f2268a.equals(obj);
    }

    public int hashCode() {
        int i = this.f2269c;
        if (i != 0) {
            return i;
        }
        i = this.f2268a.hashCode();
        this.f2269c = i;
        return i;
    }

    public String toString() {
        return this.f2268a.toString();
    }

    Object writeReplace() {
        return new EnumSerializedForm(this.f2268a);
    }
}
