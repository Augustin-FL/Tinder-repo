package com.google.common.collect;

import com.google.common.base.C1650g;
import java.util.List;
import java.util.ListIterator;

class RegularImmutableList<E> extends ImmutableList<E> {
    private final transient int f2460a;
    private final transient int f2461c;
    private final transient Object[] f2462d;

    public /* synthetic */ ListIterator listIterator(int i) {
        return m4183a(i);
    }

    RegularImmutableList(Object[] objArr, int i, int i2) {
        this.f2460a = i;
        this.f2461c = i2;
        this.f2462d = objArr;
    }

    RegularImmutableList(Object[] objArr) {
        this(objArr, 0, objArr.length);
    }

    public int size() {
        return this.f2461c;
    }

    public boolean isEmpty() {
        return false;
    }

    boolean m4184a() {
        return (this.f2460a == 0 && this.f2461c == this.f2462d.length) ? false : true;
    }

    public Object[] toArray() {
        Object obj = new Object[size()];
        System.arraycopy(this.f2462d, this.f2460a, obj, 0, this.f2461c);
        return obj;
    }

    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.f2461c) {
            tArr = C1878t.m4348a((Object[]) tArr, this.f2461c);
        } else if (tArr.length > this.f2461c) {
            tArr[this.f2461c] = null;
        }
        System.arraycopy(this.f2462d, this.f2460a, tArr, 0, this.f2461c);
        return tArr;
    }

    public E get(int i) {
        C1650g.m3078a(i, this.f2461c);
        return this.f2462d[this.f2460a + i];
    }

    ImmutableList<E> m4185b(int i, int i2) {
        return new RegularImmutableList(this.f2462d, this.f2460a + i, i2 - i);
    }

    public ad<E> m4183a(int i) {
        return C1868o.m4294a(this.f2462d, this.f2460a, this.f2461c, i);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List<Object> list = (List) obj;
        if (size() != list.size()) {
            return false;
        }
        int i = this.f2460a;
        int i2;
        if (obj instanceof RegularImmutableList) {
            RegularImmutableList regularImmutableList = (RegularImmutableList) obj;
            i2 = regularImmutableList.f2460a;
            while (i2 < regularImmutableList.f2460a + regularImmutableList.f2461c) {
                int i3 = i + 1;
                if (!this.f2462d[i].equals(regularImmutableList.f2462d[i2])) {
                    return false;
                }
                i2++;
                i = i3;
            }
        } else {
            for (Object equals : list) {
                i2 = i + 1;
                if (!this.f2462d[i].equals(equals)) {
                    return false;
                }
                i = i2;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder append = C1851f.m4264a(size()).append('[').append(this.f2462d[this.f2460a]);
        for (int i = this.f2460a + 1; i < this.f2460a + this.f2461c; i++) {
            append.append(", ").append(this.f2462d[i]);
        }
        return append.append(']').toString();
    }
}
