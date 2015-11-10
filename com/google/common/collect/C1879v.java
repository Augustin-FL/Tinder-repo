package com.google.common.collect;

import java.lang.reflect.Array;

/* renamed from: com.google.common.collect.v */
class C1879v {
    static <T> T[] m4350a(T[] tArr) {
        return (Object[]) tArr.clone();
    }

    static <T> T[] m4351a(T[] tArr, int i) {
        return (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i);
    }
}
