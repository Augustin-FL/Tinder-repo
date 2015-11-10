package com.google.common.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;

/* renamed from: com.google.common.reflect.a */
class C1884a extends AccessibleObject implements Member {
    private final AccessibleObject f2528a;
    private final Member f2529b;

    public final boolean isAnnotationPresent(Class<? extends Annotation> cls) {
        return this.f2528a.isAnnotationPresent(cls);
    }

    public final <A extends Annotation> A getAnnotation(Class<A> cls) {
        return this.f2528a.getAnnotation(cls);
    }

    public final Annotation[] getAnnotations() {
        return this.f2528a.getAnnotations();
    }

    public final Annotation[] getDeclaredAnnotations() {
        return this.f2528a.getDeclaredAnnotations();
    }

    public final void setAccessible(boolean z) throws SecurityException {
        this.f2528a.setAccessible(z);
    }

    public final boolean isAccessible() {
        return this.f2528a.isAccessible();
    }

    public Class<?> getDeclaringClass() {
        return this.f2529b.getDeclaringClass();
    }

    public final String getName() {
        return this.f2529b.getName();
    }

    public final int getModifiers() {
        return this.f2529b.getModifiers();
    }

    public final boolean isSynthetic() {
        return this.f2529b.isSynthetic();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1884a)) {
            return false;
        }
        return this.f2529b.equals(((C1884a) obj).f2529b);
    }

    public int hashCode() {
        return this.f2529b.hashCode();
    }

    public String toString() {
        return this.f2529b.toString();
    }
}
