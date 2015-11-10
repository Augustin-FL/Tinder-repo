package com.google.android.m4b.maps.au;

import java.util.Comparator;

/* renamed from: com.google.android.m4b.maps.au.a */
abstract class C1344a {
    protected int f858a;

    /* renamed from: com.google.android.m4b.maps.au.a.a */
    public static class C1342a implements Comparator<int[]> {
        private final C1344a f847a;
        private final double f848b;
        private final double f849c;

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return m1124a((int[]) obj, (int[]) obj2);
        }

        public C1342a(C1344a c1344a, int i) {
            this.f847a = c1344a;
            this.f848b = c1344a.m1126a(i);
            this.f849c = c1344a.m1132b(i);
        }

        public final int m1124a(int[] iArr, int[] iArr2) {
            double a = this.f847a.m1126a(iArr[1]);
            double b = this.f847a.m1132b(iArr[1]);
            double a2 = this.f847a.m1126a(iArr2[1]);
            double b2 = this.f847a.m1132b(iArr2[1]);
            if (this.f848b == a && this.f849c == b) {
                return -1;
            }
            if (this.f848b == a2 && this.f849c == b2) {
                return 1;
            }
            Object obj;
            double a3;
            Object obj2 = (C1366l.m1285a(a, b, this.f848b, this.f849c) < 0 || (C1366l.m1285a(a, b, this.f848b, this.f849c) == 0 && b < this.f849c)) ? 1 : null;
            if (C1366l.m1285a(a2, b2, this.f848b, this.f849c) >= 0) {
                if (C1366l.m1285a(a2, b2, this.f848b, this.f849c) >= 0 || b2 >= this.f849c) {
                    obj = null;
                    if (obj2 != obj) {
                        return obj2 == null ? -1 : 1;
                    } else {
                        a3 = C1366l.m1284a(this.f848b, this.f849c, a2, b2, a, b);
                        if (a3 == 0.0d) {
                            return a3 <= 0.0d ? 1 : -1;
                        } else {
                            if (C1366l.m1285a(a, b, a2, b2) <= 0) {
                                return 1;
                            }
                            return -1;
                        }
                    }
                }
            }
            obj = 1;
            if (obj2 != obj) {
                a3 = C1366l.m1284a(this.f848b, this.f849c, a2, b2, a, b);
                if (a3 == 0.0d) {
                    if (a3 <= 0.0d) {
                    }
                } else if (C1366l.m1285a(a, b, a2, b2) <= 0) {
                    return -1;
                } else {
                    return 1;
                }
            } else if (obj2 == null) {
            }
        }
    }

    /* renamed from: com.google.android.m4b.maps.au.a.b */
    public enum C1343b {
        SPLIT_VERTEX,
        MERGE_VERTEX,
        RIGHT_VERTEX,
        LEFT_VERTEX,
        START_VERTEX,
        END_VERTEX,
        INTERSECTION_VERTEX
    }

    public abstract double m1126a(int i);

    public abstract int m1128a();

    abstract void m1130a(int i, double[] dArr, int i2, int i3);

    public abstract double m1132b(int i);

    public abstract int m1133c(int i);

    public abstract int m1134d(int i);

    public abstract C1343b m1135e(int i);

    C1344a() {
    }

    public final int m1129a(int i, int i2) {
        return C1366l.m1285a(m1126a(i), m1132b(i), m1126a(i2), m1132b(i2));
    }

    public final double m1127a(int i, int i2, int i3) {
        return C1366l.m1284a(m1126a(i), m1132b(i), m1126a(i2), m1132b(i2), m1126a(i3), m1132b(i3));
    }

    public final boolean m1131a(int i, int i2, int i3, int i4, int i5) {
        if (m1129a(i, i2) == 0 || m1129a(i, i3) == 0 || m1129a(i, i4) == 0 || m1129a(i, i5) == 0) {
            return false;
        }
        if ((m1125b(i2, i, i3) == 0 && m1125b(i4, i, i5) == 0) || (m1125b(i2, i, i5) == 0 && m1125b(i4, i, i3) == 0)) {
            return false;
        }
        if (m1125b(i2, i, i4) == 0 && m1125b(i3, i, i5) == 0) {
            return (m1129a(i2, i) == m1129a(i4, i) || m1129a(i3, i) == m1129a(i5, i)) ? false : true;
        } else {
            if (m1125b(i2, i, i4) == 0) {
                return (m1129a(i2, i) == m1129a(i4, i) || m1125b(i2, i, i3) == m1125b(i2, i, i5)) ? false : true;
            } else {
                if (m1125b(i3, i, i5) == 0) {
                    return (m1129a(i3, i) == m1129a(i5, i) || m1125b(i3, i, i2) == m1125b(i3, i, i4)) ? false : true;
                } else {
                    int i6;
                    int i7;
                    int i8;
                    int i9;
                    if (m1125b(i2, i, i3) == 0) {
                        i6 = i5;
                        i7 = i4;
                        i8 = i3;
                        i9 = i2;
                    } else {
                        i6 = -1;
                        i7 = -1;
                        i8 = -1;
                        i9 = -1;
                    }
                    if (m1125b(i2, i, i5) == 0) {
                        i6 = i3;
                        i7 = i4;
                        i8 = i5;
                        i9 = i2;
                    }
                    if (m1125b(i3, i, i4) == 0) {
                        i6 = i2;
                        i7 = i5;
                        i8 = i4;
                        i9 = i3;
                    }
                    if (m1125b(i4, i, i5) == 0) {
                        i6 = i3;
                        i7 = i2;
                        i8 = i5;
                        i9 = i4;
                    }
                    if (i9 != -1) {
                        return m1129a(i, i9) != m1129a(i, i8) && m1125b(i9, i, i7) == m1125b(i9, i, i6) && m1125b(i7, i, i9) == m1125b(i7, i, i6);
                    } else {
                        if (m1125b(i2, i, i3) == m1125b(i2, i, i5)) {
                            return m1125b(i2, i, i3) == m1125b(i2, i, i4) && m1125b(i4, i, i3) != m1125b(i4, i, i5);
                        } else {
                            if (m1125b(i2, i, i4) != m1125b(i2, i, i3)) {
                                i3 = i5;
                            }
                            if (m1125b(i3, i, i2) != m1125b(i3, i, i4)) {
                                return true;
                            }
                            return false;
                        }
                    }
                }
            }
        }
    }

    private int m1125b(int i, int i2, int i3) {
        double a = m1127a(i, i2, i3);
        if (a > 0.0d) {
            return 1;
        }
        return a == 0.0d ? 0 : -1;
    }

    public int m1136f(int i) {
        if (i >= 0 && i < this.f858a) {
            return 0;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int m1137g(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return this.f858a;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    protected final int m1138h(int i) {
        if (this.f858a == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i2 = i % this.f858a;
        return i2 < 0 ? i2 + this.f858a : i2;
    }
}
