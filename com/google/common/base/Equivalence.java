package com.google.common.base;

import java.io.Serializable;

public abstract class Equivalence<T> {

    static final class Equals extends Equivalence<Object> implements Serializable {
        static final Equals f1910a;
        private static final long serialVersionUID = 1;

        Equals() {
        }

        static {
            f1910a = new Equals();
        }

        protected boolean m2989b(Object obj, Object obj2) {
            return obj.equals(obj2);
        }

        public int m2988b(Object obj) {
            return obj.hashCode();
        }

        private Object readResolve() {
            return f1910a;
        }
    }

    static final class Identity extends Equivalence<Object> implements Serializable {
        static final Identity f1911a;
        private static final long serialVersionUID = 1;

        Identity() {
        }

        static {
            f1911a = new Identity();
        }

        protected boolean m2991b(Object obj, Object obj2) {
            return false;
        }

        protected int m2990b(Object obj) {
            return System.identityHashCode(obj);
        }

        private Object readResolve() {
            return f1911a;
        }
    }

    protected abstract int m2986b(T t);

    protected abstract boolean m2987b(T t, T t2);

    protected Equivalence() {
    }

    public final boolean m2985a(T t, T t2) {
        if (t == t2) {
            return true;
        }
        if (t == null || t2 == null) {
            return false;
        }
        return m2987b(t, t2);
    }

    public final int m2984a(T t) {
        if (t == null) {
            return 0;
        }
        return m2986b(t);
    }

    public static Equivalence<Object> m2982a() {
        return Equals.f1910a;
    }

    public static Equivalence<Object> m2983b() {
        return Identity.f1911a;
    }
}
