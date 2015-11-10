package com.google.common.collect;

final class RegularImmutableSet<E> extends ArrayImmutableSet<E> {
    final transient Object[] f2468c;
    private final transient int f2469d;
    private final transient int f2470e;

    RegularImmutableSet(Object[] objArr, int i, Object[] objArr2, int i2) {
        super(objArr);
        this.f2468c = objArr2;
        this.f2469d = i2;
        this.f2470e = i;
    }

    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        int a = C1856m.m4276a(obj.hashCode());
        while (true) {
            Object obj2 = this.f2468c[this.f2469d & a];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            a++;
        }
    }

    public int hashCode() {
        return this.f2470e;
    }

    boolean m4197d() {
        return true;
    }
}
