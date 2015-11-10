package com.google.common.reflect;

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;

/* renamed from: com.google.common.reflect.b */
public abstract class C1885b<T, R> extends C1884a implements GenericDeclaration {

    /* renamed from: com.google.common.reflect.b.a */
    static class C1886a<T> extends C1885b<T, Object> {
        private final Method f2530a;

        public final TypeVariable<?>[] getTypeParameters() {
            return this.f2530a.getTypeParameters();
        }
    }

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public final Class<? super T> getDeclaringClass() {
        return super.getDeclaringClass();
    }
}
