package com.facebook.stetho.common;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class ReflectionUtil {
    private static final Object[] sEmptyArray;

    static {
        sEmptyArray = new Object[0];
    }

    private ReflectionUtil() {
    }

    public static Class<?> tryGetClassForName(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public static Field tryGetDeclaredField(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable e) {
            LogUtil.m934d(e, "Could not retrieve %s field from %s", str, cls);
            return null;
        }
    }

    public static Method getMethod(Class<?> cls, String str) {
        try {
            return cls.getMethod(str, new Class[0]);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static Method tryGetMethod(Class<?> cls, String str) {
        try {
            return cls.getMethod(str, new Class[0]);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    public static Object invokeMethod(Method method, Object obj) {
        Throwable e;
        try {
            return method.invoke(obj, sEmptyArray);
        } catch (IllegalAccessException e2) {
            e = e2;
            throw new RuntimeException(e);
        } catch (InvocationTargetException e3) {
            e = e3;
            throw new RuntimeException(e);
        }
    }

    public static Object getFieldValue(Field field, Object obj) {
        try {
            return field.get(obj);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
