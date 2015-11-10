package com.google.common.collect;

import com.google.common.base.C1650g;
import com.google.common.collect.ImmutableCollection.C1765a;
import com.google.common.collect.ImmutableSet.C1779a;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;

public abstract class ImmutableSortedSet<E> extends ImmutableSortedSetFauxverideShim<E> implements C1760z<E>, SortedSet<E> {
    private static final Comparator<Comparable> f2246c;
    private static final ImmutableSortedSet<Comparable> f2247d;
    final transient Comparator<? super E> f2248a;

    private static class SerializedForm<E> implements Serializable {
        private static final long serialVersionUID = 0;
        final Comparator<? super E> f2307a;
        final Object[] f2308b;

        public SerializedForm(Comparator<? super E> comparator, Object[] objArr) {
            this.f2307a = comparator;
            this.f2308b = objArr;
        }

        Object readResolve() {
            return new C1784a(this.f2307a).m3863b(this.f2308b).m3864b();
        }
    }

    /* renamed from: com.google.common.collect.ImmutableSortedSet.a */
    public static final class C1784a<E> extends C1779a<E> {
        private final Comparator<? super E> f2309c;

        public /* synthetic */ C1765a m3855a(Iterable iterable) {
            return m3865c(iterable);
        }

        public /* synthetic */ C1765a m3856a(Object obj) {
            return m3866c(obj);
        }

        public /* synthetic */ C1765a m3857a(Iterator it) {
            return m3867c(it);
        }

        public /* synthetic */ C1779a m3858a(Object[] objArr) {
            return m3863b(objArr);
        }

        public /* synthetic */ ImmutableSet m3859a() {
            return m3864b();
        }

        public /* synthetic */ C1779a m3860b(Iterable iterable) {
            return m3865c(iterable);
        }

        public /* synthetic */ C1779a m3861b(Object obj) {
            return m3866c(obj);
        }

        public /* synthetic */ C1779a m3862b(Iterator it) {
            return m3867c(it);
        }

        public C1784a(Comparator<? super E> comparator) {
            this.f2309c = (Comparator) C1650g.m3080a((Object) comparator);
        }

        public C1784a<E> m3866c(E e) {
            super.m3836b((Object) e);
            return this;
        }

        public C1784a<E> m3863b(E... eArr) {
            super.m3833a((Object[]) eArr);
            return this;
        }

        public C1784a<E> m3865c(Iterable<? extends E> iterable) {
            super.m3835b((Iterable) iterable);
            return this;
        }

        public C1784a<E> m3867c(Iterator<? extends E> it) {
            super.m3837b((Iterator) it);
            return this;
        }

        public ImmutableSortedSet<E> m3864b() {
            ImmutableSortedSet<E> b = ImmutableSortedSet.m3735b(this.f2309c, this.b, this.a);
            this.b = b.size();
            return b;
        }
    }

    abstract int m3737a(Object obj);

    abstract ImmutableSortedSet<E> m3739a(E e, boolean z);

    abstract ImmutableSortedSet<E> m3740a(E e, boolean z, E e2, boolean z2);

    abstract ImmutableSortedSet<E> m3742b(E e, boolean z);

    public abstract ac<E> m3744b();

    public abstract ac<E> m3749e();

    public /* synthetic */ SortedSet headSet(Object obj) {
        return m3745c(obj);
    }

    public /* synthetic */ Iterator iterator() {
        return m3744b();
    }

    public /* synthetic */ SortedSet subSet(Object obj, Object obj2) {
        return m3741b(obj, obj2);
    }

    public /* synthetic */ SortedSet tailSet(Object obj) {
        return m3747d(obj);
    }

    static {
        f2246c = C1757u.m3621b();
        f2247d = new EmptyImmutableSortedSet(f2246c);
    }

    private static <E> ImmutableSortedSet<E> m3736i() {
        return f2247d;
    }

    static <E> ImmutableSortedSet<E> m3732a(Comparator<? super E> comparator) {
        if (f2246c.equals(comparator)) {
            return m3736i();
        }
        return new EmptyImmutableSortedSet(comparator);
    }

    public static <E> ImmutableSortedSet<E> m3733a(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        C1650g.m3080a((Object) comparator);
        if (aa.m4259a(comparator, iterable) && (iterable instanceof ImmutableSortedSet)) {
            ImmutableSortedSet<E> immutableSortedSet = (ImmutableSortedSet) iterable;
            if (!immutableSortedSet.m3646a()) {
                return immutableSortedSet;
            }
        }
        Object[] c = C1859n.m4283c(iterable);
        return m3735b(comparator, c.length, c);
    }

    public static <E> ImmutableSortedSet<E> m3734a(Comparator<? super E> comparator, Collection<? extends E> collection) {
        return m3733a((Comparator) comparator, (Iterable) collection);
    }

    static <E> int m3730a(Comparator<? super E> comparator, int i, E... eArr) {
        int i2 = 0;
        if (i != 0) {
            int i3;
            for (i3 = 0; i3 < i; i3++) {
                C1878t.m4344a(eArr[i3], i3);
            }
            Arrays.sort(eArr, 0, i, comparator);
            i3 = 1;
            i2 = 1;
            while (i3 < i) {
                int i4;
                Object obj = eArr[i3];
                if (comparator.compare(obj, eArr[i2 - 1]) != 0) {
                    i4 = i2 + 1;
                    eArr[i2] = obj;
                } else {
                    i4 = i2;
                }
                i3++;
                i2 = i4;
            }
            Arrays.fill(eArr, i2, i, null);
        }
        return i2;
    }

    static <E> ImmutableSortedSet<E> m3735b(Comparator<? super E> comparator, int i, E... eArr) {
        int a = m3730a((Comparator) comparator, i, (Object[]) eArr);
        if (a == 0) {
            return m3732a((Comparator) comparator);
        }
        Object[] b;
        if (a < eArr.length) {
            b = C1878t.m4349b(eArr, a);
        }
        return new RegularImmutableSortedSet(ImmutableList.m3654b(b), comparator);
    }

    int m3738a(Object obj, Object obj2) {
        return m3731a(this.f2248a, obj, obj2);
    }

    static int m3731a(Comparator<?> comparator, Object obj, Object obj2) {
        return comparator.compare(obj, obj2);
    }

    ImmutableSortedSet(Comparator<? super E> comparator) {
        this.f2248a = comparator;
    }

    public Comparator<? super E> comparator() {
        return this.f2248a;
    }

    public ImmutableSortedSet<E> m3745c(E e) {
        return m3746c(e, false);
    }

    public ImmutableSortedSet<E> m3746c(E e, boolean z) {
        return m3739a(C1650g.m3080a((Object) e), z);
    }

    public ImmutableSortedSet<E> m3741b(E e, E e2) {
        return m3743b(e, true, e2, false);
    }

    public ImmutableSortedSet<E> m3743b(E e, boolean z, E e2, boolean z2) {
        C1650g.m3080a((Object) e);
        C1650g.m3080a((Object) e2);
        C1650g.m3085a(this.f2248a.compare(e, e2) <= 0);
        return m3740a(e, z, e2, z2);
    }

    public ImmutableSortedSet<E> m3747d(E e) {
        return m3748d(e, true);
    }

    public ImmutableSortedSet<E> m3748d(E e, boolean z) {
        return m3742b(C1650g.m3080a((Object) e), z);
    }

    public E first() {
        return m3744b().next();
    }

    public E last() {
        return m3749e().next();
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    Object writeReplace() {
        return new SerializedForm(this.f2248a, toArray());
    }
}
