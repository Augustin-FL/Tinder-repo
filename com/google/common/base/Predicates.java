package com.google.common.base;

import java.io.Serializable;

public final class Predicates {
    private static final C1640d f1919a;

    private static class IsEqualToPredicate<T> implements C1620h<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final T f1912a;

        private IsEqualToPredicate(T t) {
            this.f1912a = t;
        }

        public boolean m2993a(T t) {
            return this.f1912a.equals(t);
        }

        public int hashCode() {
            return this.f1912a.hashCode();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof IsEqualToPredicate)) {
                return false;
            }
            return this.f1912a.equals(((IsEqualToPredicate) obj).f1912a);
        }

        public String toString() {
            return "IsEqualTo(" + this.f1912a + ")";
        }
    }

    private static class NotPredicate<T> implements C1620h<T>, Serializable {
        private static final long serialVersionUID = 0;
        final C1620h<T> f1913a;

        NotPredicate(C1620h<T> c1620h) {
            this.f1913a = (C1620h) C1650g.m3080a((Object) c1620h);
        }

        public boolean m2994a(T t) {
            return !this.f1913a.m2992a(t);
        }

        public int hashCode() {
            return this.f1913a.hashCode() ^ -1;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof NotPredicate)) {
                return false;
            }
            return this.f1913a.equals(((NotPredicate) obj).f1913a);
        }

        public String toString() {
            return "Not(" + this.f1913a.toString() + ")";
        }
    }

    enum ObjectPredicate implements C1620h<Object> {
        ALWAYS_TRUE {
            public boolean m2996a(Object obj) {
                return true;
            }
        },
        ALWAYS_FALSE {
            public boolean m2997a(Object obj) {
                return false;
            }
        },
        IS_NULL {
            public boolean m2998a(Object obj) {
                return obj == null;
            }
        },
        NOT_NULL {
            public boolean m2999a(Object obj) {
                return obj != null;
            }
        };

        <T> C1620h<T> m2995a() {
            return this;
        }
    }

    public static <T> C1620h<T> m3000a() {
        return ObjectPredicate.IS_NULL.m2995a();
    }

    public static <T> C1620h<T> m3001a(C1620h<T> c1620h) {
        return new NotPredicate(c1620h);
    }

    public static <T> C1620h<T> m3002a(T t) {
        return t == null ? m3000a() : new IsEqualToPredicate(null);
    }

    static {
        f1919a = C1640d.m3043a(",");
    }
}
