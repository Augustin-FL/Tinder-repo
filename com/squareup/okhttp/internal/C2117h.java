package com.squareup.okhttp.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: com.squareup.okhttp.internal.h */
class C2117h<T> {
    private final Class<?> f3218a;
    private final String f3219b;
    private final Class[] f3220c;

    public C2117h(Class<?> cls, String str, Class... clsArr) {
        this.f3218a = cls;
        this.f3219b = str;
        this.f3220c = clsArr;
    }

    public boolean m5130a(T t) {
        return m5127a(t.getClass()) != null;
    }

    public Object m5129a(T t, Object... objArr) throws InvocationTargetException {
        Object obj = null;
        Method a = m5127a(t.getClass());
        if (a != null) {
            try {
                obj = a.invoke(t, objArr);
            } catch (IllegalAccessException e) {
            }
        }
        return obj;
    }

    public Object m5131b(T t, Object... objArr) {
        try {
            return m5129a(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public Object m5132c(T t, Object... objArr) throws InvocationTargetException {
        Object a = m5127a(t.getClass());
        if (a == null) {
            throw new AssertionError("Method " + this.f3219b + " not supported for object " + t);
        }
        try {
            return a.invoke(t, objArr);
        } catch (Throwable e) {
            AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + a);
            assertionError.initCause(e);
            throw assertionError;
        }
    }

    public Object m5133d(T t, Object... objArr) {
        try {
            return m5132c(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    private Method m5127a(Class<?> cls) {
        if (this.f3219b == null) {
            return null;
        }
        Method a = C2117h.m5128a(cls, this.f3219b, this.f3220c);
        if (a == null || this.f3218a == null || this.f3218a.isAssignableFrom(a.getReturnType())) {
            return a;
        }
        return null;
    }

    private static Method m5128a(Class<?> cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) == 0) {
                    return null;
                }
                return method;
            } catch (NoSuchMethodException e) {
                return method;
            }
        } catch (NoSuchMethodException e2) {
            return null;
        }
    }
}
