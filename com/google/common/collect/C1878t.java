package com.google.common.collect;

import java.util.Collection;

/* renamed from: com.google.common.collect.t */
public final class C1878t {
    static final Object[] f2526a;

    static {
        f2526a = new Object[0];
    }

    public static <T> T[] m4348a(T[] tArr, int i) {
        return C1879v.m4351a(tArr, i);
    }

    static <T> T[] m4349b(T[] tArr, int i) {
        Object a = C1878t.m4348a((Object[]) tArr, i);
        System.arraycopy(tArr, 0, a, 0, Math.min(tArr.length, i));
        return a;
    }

    static <T> T[] m4347a(Collection<?> collection, T[] tArr) {
        Object[] a;
        int size = collection.size();
        if (tArr.length < size) {
            a = C1878t.m4348a((Object[]) tArr, size);
        }
        C1878t.m4345a((Iterable) collection, a);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    static Object[] m4346a(Collection<?> collection) {
        return C1878t.m4345a((Iterable) collection, new Object[collection.size()]);
    }

    private static Object[] m4345a(Iterable<?> iterable, Object[] objArr) {
        int i = 0;
        for (Object obj : iterable) {
            int i2 = i + 1;
            objArr[i] = obj;
            i = i2;
        }
        return objArr;
    }

    static Object m4344a(Object obj, int i) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("at index " + i);
    }
}
