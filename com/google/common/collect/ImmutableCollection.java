package com.google.common.collect;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public abstract class ImmutableCollection<E> implements Serializable, Collection<E> {
    static final ImmutableCollection<Object> f2234b;
    private transient ImmutableList<E> f2235a;

    private static class ArrayImmutableCollection<E> extends ImmutableCollection<E> {
        private final E[] f2256a;

        public /* synthetic */ Iterator iterator() {
            return m3775b();
        }

        ArrayImmutableCollection(E[] eArr) {
            this.f2256a = eArr;
        }

        public int size() {
            return this.f2256a.length;
        }

        public boolean isEmpty() {
            return false;
        }

        public ac<E> m3775b() {
            return C1868o.m4293a(this.f2256a);
        }

        ImmutableList<E> m3776f() {
            return this.f2256a.length == 1 ? new SingletonImmutableList(this.f2256a[0]) : new RegularImmutableList(this.f2256a);
        }

        boolean m3774a() {
            return false;
        }
    }

    private static class EmptyImmutableCollection extends ImmutableCollection<Object> {
        private static final Object[] f2257a;

        private EmptyImmutableCollection() {
        }

        public /* synthetic */ Iterator iterator() {
            return m3778b();
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

        public ac<Object> m3778b() {
            return C1868o.f2517a;
        }

        static {
            f2257a = new Object[0];
        }

        public Object[] toArray() {
            return f2257a;
        }

        public <T> T[] toArray(T[] tArr) {
            if (tArr.length > 0) {
                tArr[0] = null;
            }
            return tArr;
        }

        ImmutableList<Object> m3779f() {
            return ImmutableList.m3656g();
        }

        boolean m3777a() {
            return false;
        }
    }

    private static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] f2258a;

        SerializedForm(Object[] objArr) {
            this.f2258a = objArr;
        }

        Object readResolve() {
            return this.f2258a.length == 0 ? ImmutableCollection.f2234b : new ArrayImmutableCollection(C1879v.m4350a(this.f2258a));
        }
    }

    /* renamed from: com.google.common.collect.ImmutableCollection.a */
    public static abstract class C1765a<E> {
        public abstract C1765a<E> m3782a(E e);

        static int m3780a(int i, int i2) {
            if (i2 < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int i3 = ((i >> 1) + i) + 1;
            if (i3 < i2) {
                i3 = Integer.highestOneBit(i2 - 1) << 1;
            }
            if (i3 < 0) {
                return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
            return i3;
        }

        C1765a() {
        }

        public C1765a<E> m3781a(Iterable<? extends E> iterable) {
            for (Object a : iterable) {
                m3782a(a);
            }
            return this;
        }

        public C1765a<E> m3783a(Iterator<? extends E> it) {
            while (it.hasNext()) {
                m3782a(it.next());
            }
            return this;
        }
    }

    abstract boolean m3646a();

    public abstract ac<E> m3647b();

    public /* synthetic */ Iterator iterator() {
        return m3647b();
    }

    static {
        f2234b = new EmptyImmutableCollection();
    }

    ImmutableCollection() {
    }

    public Object[] toArray() {
        return C1878t.m4346a(this);
    }

    public <T> T[] toArray(T[] tArr) {
        return C1878t.m4347a((Collection) this, (Object[]) tArr);
    }

    public boolean contains(Object obj) {
        return obj != null && C1868o.m4298a(m3647b(), obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return C1851f.m4267a((Collection) this, (Collection) collection);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public String toString() {
        return C1851f.m4263a((Collection) this);
    }

    @Deprecated
    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> m3648c() {
        ImmutableList<E> immutableList = this.f2235a;
        if (immutableList != null) {
            return immutableList;
        }
        immutableList = m3649f();
        this.f2235a = immutableList;
        return immutableList;
    }

    ImmutableList<E> m3649f() {
        switch (size()) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                return ImmutableList.m3656g();
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                return ImmutableList.m3650a(m3647b().next());
            default:
                return new RegularImmutableAsList(this, toArray());
        }
    }

    Object writeReplace() {
        return new SerializedForm(toArray());
    }
}
