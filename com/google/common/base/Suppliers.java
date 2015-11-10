package com.google.common.base;

import java.io.Serializable;

public final class Suppliers {

    private static class SupplierOfInstance<T> implements C1625l<T>, Serializable {
        private static final long serialVersionUID = 0;
        final T f1920a;

        SupplierOfInstance(T t) {
            this.f1920a = t;
        }

        public T m3004a() {
            return this.f1920a;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof SupplierOfInstance)) {
                return false;
            }
            return C1647e.m3074a(this.f1920a, ((SupplierOfInstance) obj).f1920a);
        }

        public int hashCode() {
            return C1647e.m3071a(this.f1920a);
        }

        public String toString() {
            return "Suppliers.ofInstance(" + this.f1920a + ")";
        }
    }

    public static <T> C1625l<T> m3005a(T t) {
        return new SupplierOfInstance(t);
    }
}
