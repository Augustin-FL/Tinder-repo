package com.google.common.reflect;

import com.google.common.base.C1650g;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* renamed from: com.google.common.reflect.c */
abstract class C1888c<T> {
    C1888c() {
    }

    final Type m4357a() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        C1650g.m3087a(genericSuperclass instanceof ParameterizedType, "%s isn't parameterized", genericSuperclass);
        return ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
    }
}
