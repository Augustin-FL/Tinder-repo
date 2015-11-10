package com.google.common.collect;

import com.google.common.base.C1650g;
import com.google.common.collect.ImmutableCollection.C1765a;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    private static final int f2237a;

    static abstract class ArrayImmutableSet<E> extends ImmutableSet<E> {
        final transient Object[] f2297a;

        public /* synthetic */ Iterator iterator() {
            return m3827b();
        }

        ArrayImmutableSet(Object[] objArr) {
            this.f2297a = objArr;
        }

        public int size() {
            return this.f2297a.length;
        }

        public boolean isEmpty() {
            return false;
        }

        public ac<E> m3827b() {
            return m3648c().m3661b();
        }

        public Object[] toArray() {
            return m3648c().toArray();
        }

        public <T> T[] toArray(T[] tArr) {
            return m3648c().toArray(tArr);
        }

        public boolean containsAll(Collection<?> collection) {
            if (collection == this) {
                return true;
            }
            if (!(collection instanceof ArrayImmutableSet)) {
                return super.containsAll(collection);
            }
            if (collection.size() > size()) {
                return false;
            }
            for (Object contains : ((ArrayImmutableSet) collection).f2297a) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        boolean m3826a() {
            return false;
        }

        ImmutableList<E> m3828f() {
            return new RegularImmutableAsList((ImmutableCollection) this, this.f2297a);
        }
    }

    private static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] f2298a;

        SerializedForm(Object[] objArr) {
            this.f2298a = objArr;
        }

        Object readResolve() {
            return ImmutableSet.m3674a(this.f2298a);
        }
    }

    /* renamed from: com.google.common.collect.ImmutableSet.a */
    public static class C1779a<E> extends C1765a<E> {
        Object[] f2299a;
        int f2300b;

        public /* synthetic */ C1765a m3829a(Iterable iterable) {
            return m3835b(iterable);
        }

        public /* synthetic */ C1765a m3830a(Object obj) {
            return m3836b(obj);
        }

        public /* synthetic */ C1765a m3831a(Iterator it) {
            return m3837b(it);
        }

        public C1779a() {
            this(4);
        }

        C1779a(int i) {
            boolean z;
            if (i >= 0) {
                z = true;
            } else {
                z = false;
            }
            C1650g.m3087a(z, "capacity must be >= 0 but was %s", Integer.valueOf(i));
            this.f2299a = new Object[i];
            this.f2300b = 0;
        }

        C1779a<E> m3832a(int i) {
            if (this.f2299a.length < i) {
                this.f2299a = C1878t.m4349b(this.f2299a, C1765a.m3780a(this.f2299a.length, i));
            }
            return this;
        }

        public C1779a<E> m3836b(E e) {
            m3832a(this.f2300b + 1);
            Object[] objArr = this.f2299a;
            int i = this.f2300b;
            this.f2300b = i + 1;
            objArr[i] = C1650g.m3080a((Object) e);
            return this;
        }

        public C1779a<E> m3833a(E... eArr) {
            for (int i = 0; i < eArr.length; i++) {
                C1878t.m4344a(eArr[i], i);
            }
            m3832a(this.f2300b + eArr.length);
            System.arraycopy(eArr, 0, this.f2299a, this.f2300b, eArr.length);
            this.f2300b += eArr.length;
            return this;
        }

        public C1779a<E> m3835b(Iterable<? extends E> iterable) {
            if (iterable instanceof Collection) {
                Collection collection = (Collection) iterable;
                m3832a(collection.size() + this.f2300b);
            }
            super.m3781a((Iterable) iterable);
            return this;
        }

        public C1779a<E> m3837b(Iterator<? extends E> it) {
            super.m3783a((Iterator) it);
            return this;
        }

        public ImmutableSet<E> m3834a() {
            ImmutableSet<E> a = ImmutableSet.m3675b(this.f2300b, this.f2299a);
            this.f2300b = a.size();
            return a;
        }
    }

    public abstract ac<E> m3680b();

    public /* synthetic */ Iterator iterator() {
        return m3680b();
    }

    public static <E> ImmutableSet<E> m3678g() {
        return EmptyImmutableSet.f2238a;
    }

    public static <E> ImmutableSet<E> m3676b(E e) {
        return new SingletonImmutableSet(e);
    }

    private static <E> ImmutableSet<E> m3675b(int i, Object... objArr) {
        switch (i) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                return m3678g();
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                return m3676b(objArr[0]);
            default:
                int a = m3669a(i);
                Object[] objArr2 = new Object[a];
                int i2 = a - 1;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                while (i3 < i) {
                    Object a2 = C1878t.m4344a(objArr[i3], i3);
                    int hashCode = a2.hashCode();
                    int a3 = C1856m.m4276a(hashCode);
                    while (true) {
                        int i6 = a3 & i2;
                        Object obj = objArr2[i6];
                        if (obj == null) {
                            a3 = i4 + 1;
                            objArr[i4] = a2;
                            objArr2[i6] = a2;
                            i4 = i5 + hashCode;
                        } else if (obj.equals(a2)) {
                            a3 = i4;
                            i4 = i5;
                        } else {
                            a3++;
                        }
                        i3++;
                        i5 = i4;
                        i4 = a3;
                    }
                }
                Arrays.fill(objArr, i4, i, null);
                if (i4 == 1) {
                    return new SingletonImmutableSet(objArr[0], i5);
                }
                if (a != m3669a(i4)) {
                    return m3675b(i4, objArr);
                }
                if (i4 < objArr.length) {
                    objArr = C1878t.m4349b(objArr, i4);
                }
                return new RegularImmutableSet(objArr, i5, objArr2, i2);
        }
    }

    static {
        f2237a = (int) Math.floor(7.516192768E8d);
    }

    static int m3669a(int i) {
        if (i < f2237a) {
            int highestOneBit = Integer.highestOneBit(i - 1) << 1;
            while (((double) highestOneBit) * 0.7d < ((double) i)) {
                highestOneBit <<= 1;
            }
            return highestOneBit;
        }
        C1650g.m3086a(i < 1073741824, (Object) "collection too large");
        return 1073741824;
    }

    public static <E> ImmutableSet<E> m3674a(E[] eArr) {
        switch (eArr.length) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                return m3678g();
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                return m3676b(eArr[0]);
            default:
                return m3675b(eArr.length, (Object[]) eArr.clone());
        }
    }

    public static <E> ImmutableSet<E> m3671a(Iterable<? extends E> iterable) {
        return iterable instanceof Collection ? m3672a(C1851f.m4265a((Iterable) iterable)) : m3673a(iterable.iterator());
    }

    public static <E> ImmutableSet<E> m3673a(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return m3678g();
        }
        Object next = it.next();
        if (it.hasNext()) {
            return new C1779a().m3836b(next).m3837b((Iterator) it).m3834a();
        }
        return m3676b(next);
    }

    public static <E> ImmutableSet<E> m3672a(Collection<? extends E> collection) {
        if ((collection instanceof ImmutableSet) && !(collection instanceof ImmutableSortedSet)) {
            ImmutableSet<E> immutableSet = (ImmutableSet) collection;
            if (!immutableSet.m3646a()) {
                return immutableSet;
            }
        } else if (collection instanceof EnumSet) {
            return ImmutableEnumSet.m3796a(EnumSet.copyOf((EnumSet) collection));
        }
        return m3677b((Collection) collection);
    }

    private static <E> ImmutableSet<E> m3677b(Collection<? extends E> collection) {
        Object[] toArray = collection.toArray();
        switch (toArray.length) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                return m3678g();
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                return m3676b(toArray[0]);
            default:
                return m3675b(toArray.length, toArray);
        }
    }

    ImmutableSet() {
    }

    boolean m3681d() {
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof ImmutableSet) && m3681d() && ((ImmutableSet) obj).m3681d() && hashCode() != obj.hashCode()) {
            return false;
        }
        return Sets.m4232a((Set) this, obj);
    }

    public int hashCode() {
        return Sets.m4226a((Set) this);
    }

    Object writeReplace() {
        return new SerializedForm(toArray());
    }

    public static <E> C1779a<E> m3679h() {
        return new C1779a();
    }
}
