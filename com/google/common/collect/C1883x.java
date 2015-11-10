package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map.Entry;

/* renamed from: com.google.common.collect.x */
final class C1883x {

    /* renamed from: com.google.common.collect.x.a */
    static final class C1882a<T> {
        private final Field f2527a;

        private C1882a(Field field) {
            this.f2527a = field;
            field.setAccessible(true);
        }

        void m4354a(T t, Object obj) {
            try {
                this.f2527a.set(t, obj);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }

        void m4353a(T t, int i) {
            try {
                this.f2527a.set(t, Integer.valueOf(i));
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
    }

    static <K, V> void m4356a(C1755r<K, V> c1755r, ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(c1755r.m3592h().size());
        for (Entry entry : c1755r.m3592h().entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeInt(((Collection) entry.getValue()).size());
            for (Object writeObject : (Collection) entry.getValue()) {
                objectOutputStream.writeObject(writeObject);
            }
        }
    }

    static <T> C1882a<T> m4355a(Class<T> cls, String str) {
        try {
            return new C1882a(null);
        } catch (NoSuchFieldException e) {
            throw new AssertionError(e);
        }
    }
}
