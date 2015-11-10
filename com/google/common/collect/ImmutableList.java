package com.google.common.collect;

import com.google.common.base.C1650g;
import com.google.common.collect.ImmutableCollection.C1765a;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public abstract class ImmutableList<E> extends ImmutableCollection<E> implements List<E>, RandomAccess {

    /* renamed from: com.google.common.collect.ImmutableList.1 */
    class C17721 extends C1771a<E> {
        final /* synthetic */ ImmutableList f2272a;

        C17721(ImmutableList immutableList, int i, int i2) {
            this.f2272a = immutableList;
            super(i, i2);
        }

        protected E m3800a(int i) {
            return this.f2272a.get(i);
        }
    }

    private static class ReverseImmutableList<E> extends ImmutableList<E> {
        private final transient ImmutableList<E> f2275a;
        private final transient int f2276c;

        /* renamed from: com.google.common.collect.ImmutableList.ReverseImmutableList.1 */
        class C17731 extends ad<E> {
            final /* synthetic */ ad f2273a;
            final /* synthetic */ ReverseImmutableList f2274b;

            C17731(ReverseImmutableList reverseImmutableList, ad adVar) {
                this.f2274b = reverseImmutableList;
                this.f2273a = adVar;
            }

            public boolean hasNext() {
                return this.f2273a.hasPrevious();
            }

            public boolean hasPrevious() {
                return this.f2273a.hasNext();
            }

            public E next() {
                return this.f2273a.previous();
            }

            public int nextIndex() {
                return this.f2274b.m3802b(this.f2273a.previousIndex());
            }

            public E previous() {
                return this.f2273a.next();
            }

            public int previousIndex() {
                return this.f2274b.m3802b(this.f2273a.nextIndex());
            }
        }

        public /* synthetic */ Iterator iterator() {
            return super.m3661b();
        }

        public /* synthetic */ ListIterator listIterator() {
            return super.m3663d();
        }

        public /* synthetic */ ListIterator listIterator(int i) {
            return m3805a(i);
        }

        public /* synthetic */ List subList(int i, int i2) {
            return m3804a(i, i2);
        }

        ReverseImmutableList(ImmutableList<E> immutableList) {
            this.f2275a = immutableList;
            this.f2276c = immutableList.size();
        }

        private int m3802b(int i) {
            return (this.f2276c - 1) - i;
        }

        private int m3803c(int i) {
            return this.f2276c - i;
        }

        public ImmutableList<E> j_() {
            return this.f2275a;
        }

        public boolean contains(Object obj) {
            return this.f2275a.contains(obj);
        }

        public boolean containsAll(Collection<?> collection) {
            return this.f2275a.containsAll(collection);
        }

        public int indexOf(Object obj) {
            int lastIndexOf = this.f2275a.lastIndexOf(obj);
            return lastIndexOf >= 0 ? m3802b(lastIndexOf) : -1;
        }

        public int lastIndexOf(Object obj) {
            int indexOf = this.f2275a.indexOf(obj);
            return indexOf >= 0 ? m3802b(indexOf) : -1;
        }

        public ImmutableList<E> m3804a(int i, int i2) {
            C1650g.m3084a(i, i2, this.f2276c);
            return this.f2275a.m3658a(m3803c(i2), m3803c(i)).j_();
        }

        public E get(int i) {
            C1650g.m3078a(i, this.f2276c);
            return this.f2275a.get(m3802b(i));
        }

        public ad<E> m3805a(int i) {
            C1650g.m3088b(i, this.f2276c);
            return new C17731(this, this.f2275a.m3659a(m3803c(i)));
        }

        public int size() {
            return this.f2276c;
        }

        public boolean isEmpty() {
            return this.f2275a.isEmpty();
        }

        boolean m3806a() {
            return this.f2275a.m3646a();
        }
    }

    private static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] f2277a;

        SerializedForm(Object[] objArr) {
            this.f2277a = objArr;
        }

        Object readResolve() {
            return ImmutableList.m3652a(this.f2277a);
        }
    }

    class SubList extends ImmutableList<E> {
        final transient int f2278a;
        final transient int f2279c;
        final /* synthetic */ ImmutableList f2280d;

        public /* synthetic */ Iterator iterator() {
            return super.m3661b();
        }

        public /* synthetic */ ListIterator listIterator() {
            return super.m3663d();
        }

        public /* synthetic */ ListIterator listIterator(int i) {
            return super.m3659a(i);
        }

        public /* synthetic */ List subList(int i, int i2) {
            return m3807a(i, i2);
        }

        SubList(ImmutableList immutableList, int i, int i2) {
            this.f2280d = immutableList;
            this.f2278a = i;
            this.f2279c = i2;
        }

        public int size() {
            return this.f2279c;
        }

        public E get(int i) {
            C1650g.m3078a(i, this.f2279c);
            return this.f2280d.get(this.f2278a + i);
        }

        public ImmutableList<E> m3807a(int i, int i2) {
            C1650g.m3084a(i, i2, this.f2279c);
            return this.f2280d.m3658a(this.f2278a + i, this.f2278a + i2);
        }

        boolean m3808a() {
            return true;
        }
    }

    /* renamed from: com.google.common.collect.ImmutableList.a */
    public static final class C1774a<E> extends C1765a<E> {
        private Object[] f2281a;
        private int f2282b;

        public /* synthetic */ C1765a m3809a(Iterable iterable) {
            return m3814b(iterable);
        }

        public /* synthetic */ C1765a m3810a(Object obj) {
            return m3815b(obj);
        }

        public /* synthetic */ C1765a m3811a(Iterator it) {
            return m3816b(it);
        }

        public C1774a() {
            this(4);
        }

        C1774a(int i) {
            this.f2281a = new Object[i];
            this.f2282b = 0;
        }

        C1774a<E> m3812a(int i) {
            if (this.f2281a.length < i) {
                this.f2281a = C1878t.m4349b(this.f2281a, C1765a.m3780a(this.f2281a.length, i));
            }
            return this;
        }

        public C1774a<E> m3815b(E e) {
            C1650g.m3080a((Object) e);
            m3812a(this.f2282b + 1);
            Object[] objArr = this.f2281a;
            int i = this.f2282b;
            this.f2282b = i + 1;
            objArr[i] = e;
            return this;
        }

        public C1774a<E> m3814b(Iterable<? extends E> iterable) {
            if (iterable instanceof Collection) {
                Collection collection = (Collection) iterable;
                m3812a(collection.size() + this.f2282b);
            }
            super.m3781a((Iterable) iterable);
            return this;
        }

        public C1774a<E> m3816b(Iterator<? extends E> it) {
            super.m3783a((Iterator) it);
            return this;
        }

        public ImmutableList<E> m3813a() {
            switch (this.f2282b) {
                case C3374b.SmoothProgressBar_spbStyle /*0*/:
                    return ImmutableList.m3656g();
                case C3374b.SmoothProgressBar_spb_color /*1*/:
                    return ImmutableList.m3650a(this.f2281a[0]);
                default:
                    if (this.f2282b == this.f2281a.length) {
                        return new RegularImmutableList(this.f2281a);
                    }
                    return new RegularImmutableList(C1878t.m4349b(this.f2281a, this.f2282b));
            }
        }
    }

    public /* synthetic */ Iterator iterator() {
        return m3661b();
    }

    public /* synthetic */ ListIterator listIterator() {
        return m3663d();
    }

    public /* synthetic */ ListIterator listIterator(int i) {
        return m3659a(i);
    }

    public /* synthetic */ List subList(int i, int i2) {
        return m3658a(i, i2);
    }

    public static <E> ImmutableList<E> m3656g() {
        return EmptyImmutableList.f2236a;
    }

    public static <E> ImmutableList<E> m3650a(E e) {
        return new SingletonImmutableList(e);
    }

    public static <E> ImmutableList<E> m3651a(Collection<? extends E> collection) {
        if (!(collection instanceof ImmutableCollection)) {
            return m3653b((Collection) collection);
        }
        Collection c = ((ImmutableCollection) collection).m3648c();
        if (c.m3646a()) {
            return m3653b(c);
        }
        return c;
    }

    public static <E> ImmutableList<E> m3652a(E[] eArr) {
        switch (eArr.length) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                return m3656g();
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                return new SingletonImmutableList(eArr[0]);
            default:
                return m3655c((Object[]) eArr.clone());
        }
    }

    static <E> ImmutableList<E> m3654b(Object[] objArr) {
        switch (objArr.length) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                return m3656g();
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                return new SingletonImmutableList(objArr[0]);
            default:
                return m3655c(objArr);
        }
    }

    private static <E> ImmutableList<E> m3653b(Collection<? extends E> collection) {
        return m3654b(collection.toArray());
    }

    private static <E> ImmutableList<E> m3655c(Object... objArr) {
        for (int i = 0; i < objArr.length; i++) {
            C1878t.m4344a(objArr[i], i);
        }
        return new RegularImmutableList(objArr);
    }

    ImmutableList() {
    }

    public ac<E> m3661b() {
        return m3663d();
    }

    public ad<E> m3663d() {
        return m3659a(0);
    }

    public ad<E> m3659a(int i) {
        return new C17721(this, size(), i);
    }

    public int indexOf(Object obj) {
        return obj == null ? -1 : C1872p.m4316b(this, obj);
    }

    public int lastIndexOf(Object obj) {
        return obj == null ? -1 : C1872p.m4320c(this, obj);
    }

    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    public ImmutableList<E> m3658a(int i, int i2) {
        C1650g.m3084a(i, i2, size());
        switch (i2 - i) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                return m3656g();
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                return m3650a(get(i));
            default:
                return m3660b(i, i2);
        }
    }

    ImmutableList<E> m3660b(int i, int i2) {
        return new SubList(this, i, i2 - i);
    }

    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> m3662c() {
        return this;
    }

    public ImmutableList<E> j_() {
        return new ReverseImmutableList(this);
    }

    public boolean equals(Object obj) {
        return C1872p.m4314a(this, obj);
    }

    public int hashCode() {
        return C1872p.m4315b((List) this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    Object writeReplace() {
        return new SerializedForm(toArray());
    }

    public static <E> C1774a<E> m3657h() {
        return new C1774a();
    }
}
