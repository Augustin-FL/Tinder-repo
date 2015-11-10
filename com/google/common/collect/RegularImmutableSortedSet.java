package com.google.common.collect;

import com.google.common.base.C1650g;
import com.google.common.collect.SortedLists.KeyAbsentBehavior;
import com.google.common.collect.SortedLists.KeyPresentBehavior;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

final class RegularImmutableSortedSet<E> extends ImmutableSortedSet<E> {
    private final transient ImmutableList<E> f2476c;

    public /* synthetic */ Iterator iterator() {
        return m4217b();
    }

    RegularImmutableSortedSet(ImmutableList<E> immutableList, Comparator<? super E> comparator) {
        super(comparator);
        this.f2476c = immutableList;
        C1650g.m3085a(!immutableList.isEmpty());
    }

    public ac<E> m4217b() {
        return this.f2476c.m3661b();
    }

    public ac<E> m4219e() {
        return this.f2476c.j_().m3661b();
    }

    public boolean isEmpty() {
        return false;
    }

    public int size() {
        return this.f2476c.size();
    }

    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return m4210e(obj) >= 0;
        } catch (ClassCastException e) {
            return false;
        }
    }

    public boolean containsAll(Collection<?> collection) {
        if (!aa.m4259a(comparator(), collection) || collection.size() <= 1) {
            return super.containsAll(collection);
        }
        Iterator b = m4217b();
        Iterator it = collection.iterator();
        Object next = it.next();
        while (b.hasNext()) {
            try {
                int a = m3738a(b.next(), next);
                if (a == 0) {
                    if (!it.hasNext()) {
                        return true;
                    }
                    next = it.next();
                } else if (a > 0) {
                    return false;
                }
            } catch (NullPointerException e) {
                return false;
            } catch (ClassCastException e2) {
                return false;
            }
        }
        return false;
    }

    private int m4210e(Object obj) throws ClassCastException {
        return Collections.binarySearch(this.f2476c, obj, m4222i());
    }

    boolean m4215a() {
        return this.f2476c.m3646a();
    }

    public Object[] toArray() {
        return this.f2476c.toArray();
    }

    public <T> T[] toArray(T[] tArr) {
        return this.f2476c.toArray(tArr);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (size() != set.size()) {
            return false;
        }
        if (!aa.m4259a(this.a, set)) {
            return containsAll(set);
        }
        Iterator it = set.iterator();
        try {
            Iterator b = m4217b();
            while (b.hasNext()) {
                Object next = b.next();
                Object next2 = it.next();
                if (next2 != null) {
                    if (m3738a(next, next2) != 0) {
                    }
                }
                return false;
            }
            return true;
        } catch (ClassCastException e) {
            return false;
        } catch (NoSuchElementException e2) {
            return false;
        }
    }

    public E first() {
        return this.f2476c.get(0);
    }

    public E last() {
        return this.f2476c.get(size() - 1);
    }

    ImmutableSortedSet<E> m4213a(E e, boolean z) {
        return m4212a(0, m4218e(e, z));
    }

    int m4218e(E e, boolean z) {
        return SortedLists.m4257a(this.f2476c, C1650g.m3080a((Object) e), comparator(), z ? KeyPresentBehavior.FIRST_AFTER : KeyPresentBehavior.FIRST_PRESENT, KeyAbsentBehavior.NEXT_HIGHER);
    }

    ImmutableSortedSet<E> m4214a(E e, boolean z, E e2, boolean z2) {
        return m4216b(e, z).m3739a((Object) e2, z2);
    }

    ImmutableSortedSet<E> m4216b(E e, boolean z) {
        return m4212a(m4220f(e, z), size());
    }

    int m4220f(E e, boolean z) {
        return SortedLists.m4257a(this.f2476c, C1650g.m3080a((Object) e), comparator(), z ? KeyPresentBehavior.FIRST_PRESENT : KeyPresentBehavior.FIRST_AFTER, KeyAbsentBehavior.NEXT_HIGHER);
    }

    Comparator<Object> m4222i() {
        return this.a;
    }

    ImmutableSortedSet<E> m4212a(int i, int i2) {
        if (i == 0 && i2 == size()) {
            return this;
        }
        if (i < i2) {
            return new RegularImmutableSortedSet(this.f2476c.m3658a(i, i2), this.a);
        }
        return ImmutableSortedSet.m3732a(this.a);
    }

    int m4211a(Object obj) {
        if (obj == null) {
            return -1;
        }
        try {
            int a = SortedLists.m4257a(this.f2476c, obj, m4222i(), KeyPresentBehavior.ANY_PRESENT, KeyAbsentBehavior.INVERTED_INSERTION_INDEX);
            if (a < 0) {
                a = -1;
            }
            return a;
        } catch (ClassCastException e) {
            return -1;
        }
    }

    ImmutableList<E> m4221f() {
        return new ImmutableSortedAsList(this, this.f2476c);
    }
}
