package com.google.android.m4b.maps.au;

import com.google.android.m4b.maps.au.C1344a.C1343b;
import java.util.Arrays;

/* renamed from: com.google.android.m4b.maps.au.g */
class C1361g extends C1344a {
    private double[] f896b;

    static C1361g m1228a(double[] dArr) {
        return new C1361g(dArr);
    }

    static C1361g m1229a(double[] dArr, int[] iArr) {
        if (dArr.length % 2 != 0 || iArr.length < 2 || iArr[0] != 0 || iArr[iArr.length - 1] != dArr.length / 2) {
            throw new IllegalArgumentException("ChainStartIndices for PolygonVertexList.create invalid.");
        } else if (iArr.length == 2) {
            return new C1361g(dArr);
        } else {
            return new C1362h(dArr, iArr);
        }
    }

    protected C1361g(double[] dArr) {
        if (dArr.length % 2 != 0) {
            throw new IllegalArgumentException("Cannot create PolygonVertexList from incomplete array.");
        }
        this.a = dArr.length / 2;
        this.f896b = dArr;
    }

    public final C1347m m1238b() {
        return new C1347m((C1344a) this);
    }

    public final C1348j m1241c() {
        return new C1348j(this);
    }

    public final double m1233a(int i) {
        return this.f896b[i * 2];
    }

    public final double m1237b(int i) {
        return this.f896b[(i * 2) + 1];
    }

    public int m1240c(int i) {
        return m1138h(i - 1);
    }

    public int m1243d(int i) {
        return m1138h(i + 1);
    }

    public final C1343b m1244e(int i) {
        int c = m1240c(i);
        int d = m1243d(i);
        double a = m1127a(c, i, d);
        Object obj = a < 0.0d ? 1 : null;
        double d2 = this.f896b[i * 2];
        double d3 = this.f896b[c * 2];
        Object obj2 = d3 < d2 ? 1 : null;
        Object obj3 = d3 == d2 ? 1 : null;
        Object obj4 = d3 > d2 ? 1 : null;
        double d4 = this.f896b[d * 2];
        Object obj5 = d4 < d2 ? 1 : null;
        Object obj6 = d4 == d2 ? 1 : null;
        Object obj7 = d4 > d2 ? 1 : null;
        if (obj3 == null || obj6 == null) {
            if (a == 0.0d && !(obj3 == null && obj6 == null)) {
                obj = obj3 != null ? this.f896b[(c * 2) + 1] < this.f896b[(i * 2) + 1] ? obj7 : obj5 : this.f896b[(d * 2) + 1] < this.f896b[(i * 2) + 1] ? obj2 : obj4;
            }
            if (obj != null) {
                if (obj4 != null && (obj7 != null || obj6 != null)) {
                    return C1343b.SPLIT_VERTEX;
                }
                if (!(obj2 == null || (obj5 == null && obj6 == null))) {
                    return C1343b.MERGE_VERTEX;
                }
            } else if ((obj4 != null || obj3 != null) && obj7 != null) {
                return C1343b.START_VERTEX;
            } else {
                if (!((obj2 == null && obj3 == null) || obj5 == null)) {
                    return C1343b.END_VERTEX;
                }
            }
            if ((obj2 == null && obj3 == null) || (obj7 == null && obj6 == null)) {
                return C1343b.LEFT_VERTEX;
            }
            return C1343b.RIGHT_VERTEX;
        } else if (this.f896b[(d * 2) + 1] >= this.f896b[(i * 2) + 1]) {
            return this.f896b[(c * 2) + 1] > this.f896b[(i * 2) + 1] ? C1343b.START_VERTEX : C1343b.RIGHT_VERTEX;
        } else {
            if (this.f896b[(c * 2) + 1] < this.f896b[(i * 2) + 1]) {
                return C1343b.END_VERTEX;
            }
            return C1343b.LEFT_VERTEX;
        }
    }

    public int m1234a() {
        return 0;
    }

    public final double m1242d() {
        double d = 0.0d;
        for (int i = 0; i < m1234a() + 1; i++) {
            d += m1232i(i);
        }
        return d;
    }

    private double m1232i(int i) {
        int g = m1137g(i);
        int g2 = m1137g(i + 1);
        if (g2 - g < 3) {
            return 0.0d;
        }
        double d = this.f896b[(g2 - 1) * 2];
        double d2 = this.f896b[((g2 - 1) * 2) + 1];
        double d3 = 0.0d;
        double d4 = 0.0d;
        int i2 = g;
        double d5 = 0.0d;
        while (i2 < g2) {
            double d6 = this.f896b[i2 * 2] - d;
            double d7 = this.f896b[(i2 * 2) + 1] - d2;
            d4 = ((d5 * d7) - (d3 * d6)) + d4;
            i2++;
            d3 = d7;
            d5 = d6;
        }
        return d4 / 2.0d;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m1245e() {
        /*
        r14 = this;
        r0 = 0;
        r8 = r0;
    L_0x0002:
        r0 = r14.a;
        if (r8 >= r0) goto L_0x0074;
    L_0x0006:
        r2 = r14.m1240c(r8);
        r9 = r14.m1243d(r8);
        r0 = r14.m1127a(r2, r8, r9);
        r4 = 0;
        r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r0 != 0) goto L_0x0070;
    L_0x0018:
        r0 = r14.m1233a(r2);
        r2 = r14.m1237b(r2);
        r4 = r14.m1233a(r8);
        r6 = r14.m1237b(r8);
        r10 = r14.m1233a(r9);
        r12 = r14.m1237b(r9);
        r9 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r9 == 0) goto L_0x0038;
    L_0x0034:
        r9 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1));
        if (r9 != 0) goto L_0x0040;
    L_0x0038:
        r9 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r9 != 0) goto L_0x0074;
    L_0x003c:
        r9 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1));
        if (r9 != 0) goto L_0x0074;
    L_0x0040:
        r9 = com.google.android.m4b.maps.au.C1366l.m1285a(r0, r2, r4, r6);
        if (r9 < 0) goto L_0x0050;
    L_0x0046:
        r0 = com.google.android.m4b.maps.au.C1366l.m1285a(r0, r2, r4, r6);
        if (r0 != 0) goto L_0x006b;
    L_0x004c:
        r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r0 >= 0) goto L_0x006b;
    L_0x0050:
        r0 = 1;
        r9 = r0;
    L_0x0052:
        r0 = r10;
        r2 = r12;
        r0 = com.google.android.m4b.maps.au.C1366l.m1285a(r0, r2, r4, r6);
        if (r0 < 0) goto L_0x0066;
    L_0x005a:
        r0 = r10;
        r2 = r12;
        r0 = com.google.android.m4b.maps.au.C1366l.m1285a(r0, r2, r4, r6);
        if (r0 >= 0) goto L_0x006e;
    L_0x0062:
        r0 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1));
        if (r0 >= 0) goto L_0x006e;
    L_0x0066:
        r0 = 1;
    L_0x0067:
        if (r9 != r0) goto L_0x0070;
    L_0x0069:
        r0 = 1;
    L_0x006a:
        return r0;
    L_0x006b:
        r0 = 0;
        r9 = r0;
        goto L_0x0052;
    L_0x006e:
        r0 = 0;
        goto L_0x0067;
    L_0x0070:
        r0 = r8 + 1;
        r8 = r0;
        goto L_0x0002;
    L_0x0074:
        r0 = 0;
        goto L_0x006a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.m4b.maps.au.g.e():boolean");
    }

    public final boolean m1246f() {
        return m1232i(0) <= 0.0d;
    }

    public final boolean m1247g() {
        for (int i = 1; i < m1234a() + 1; i++) {
            if (m1232i(i) >= 0.0d) {
                return true;
            }
        }
        return false;
    }

    public final boolean m1248h() {
        C1348j c = m1241c();
        C1346b c1346b = new C1346b(this);
        for (int i = 0; i < c.c; i++) {
            boolean z;
            int j = c.m1191j(i);
            int d = c.m1178d(j);
            int e = c.m1180e(j);
            if (c.m1186g(d, j) == 0 || c.m1186g(j, e) == 0) {
                z = true;
            } else {
                C1343b e2 = m1244e(j);
                z = (e2 == C1343b.LEFT_VERTEX && (c1346b.m1155a(d, j) || c1346b.m1159b(j, e))) || ((e2 == C1343b.RIGHT_VERTEX && (c1346b.m1155a(j, e) || c1346b.m1159b(d, j))) || ((e2 == C1343b.SPLIT_VERTEX && (c1346b.m1155a(d, j) || c1346b.m1155a(j, e))) || ((e2 == C1343b.MERGE_VERTEX && (c1346b.m1159b(j, e) || c1346b.m1159b(d, j))) || ((e2 == C1343b.START_VERTEX && (c1346b.m1155a(j, e) || c1346b.m1155a(d, j))) || (e2 == C1343b.END_VERTEX && (c1346b.m1159b(d, j) || c1346b.m1159b(j, e)))))));
            }
            if (z) {
                return true;
            }
        }
        for (j = 0; j < this.a; j++) {
            int i2 = j + 1;
            while (i2 < this.a) {
                if (m1129a(j, i2) == 0) {
                    int c2 = m1240c(j);
                    int d2 = m1243d(j);
                    if (!(c2 == i2 || d2 == i2)) {
                        int c3 = m1240c(j);
                        int d3 = m1243d(j);
                        e = m1240c(i2);
                        d = m1243d(i2);
                        boolean z2 = (m1129a(c3, j) == 0 || m1129a(j, d3) == 0 || m1129a(e, i2) == 0 || m1129a(i2, d) == 0 || m1231b(j, c3, d3) || m1231b(j, c3, e) || m1231b(j, c3, d) || m1231b(j, d3, e) || m1231b(j, d3, d) || m1231b(j, e, d)) ? false : m1230a(c3, j, d3, e) && m1230a(c3, j, d3, d) && m1131a(j, d3, c3, d, e);
                        if (!z2) {
                            if (!m1131a(j, c2, m1240c(i2), d2, m1243d(i2))) {
                            }
                        }
                    }
                    return true;
                }
                i2++;
            }
        }
        return false;
    }

    private boolean m1230a(int i, int i2, int i3, int i4) {
        if (m1127a(i, i2, i3) < 0.0d) {
            if (m1127a(i, i2, i4) >= 0.0d || m1127a(i2, i3, i4) >= 0.0d) {
                return true;
            }
            return false;
        } else if (m1127a(i, i2, i4) <= 0.0d || m1127a(i2, i3, i4) <= 0.0d) {
            return false;
        } else {
            return true;
        }
    }

    private boolean m1231b(int i, int i2, int i3) {
        if (m1129a(i2, i3) == 0) {
            return true;
        }
        if (m1129a(i, i2) == 0 || m1129a(i, i3) == 0) {
            return false;
        }
        if (m1129a(i, i2) != m1129a(i, i3)) {
            return false;
        }
        if (m1127a(i, i2, i3) != 0.0d) {
            return false;
        }
        return true;
    }

    final void m1235a(int i, double[] dArr, int i2, int i3) {
        System.arraycopy(this.f896b, i * 2, dArr, i2 * 2, i3 * 2);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1361g)) {
            return false;
        }
        C1361g c1361g = (C1361g) obj;
        if (c1361g.m1236a((Object) this) && Arrays.equals(this.f896b, c1361g.f896b)) {
            return true;
        }
        return false;
    }

    protected boolean m1236a(Object obj) {
        return obj instanceof C1361g;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f896b);
    }

    public String toString() {
        return m1239b(0, m1137g(1));
    }

    protected final String m1239b(int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[(");
        stringBuilder.append(this.f896b[i * 2]);
        stringBuilder.append(", ");
        stringBuilder.append(this.f896b[(i * 2) + 1]);
        stringBuilder.append(")");
        for (int i3 = i + 1; i3 < i2; i3++) {
            stringBuilder.append(", (");
            stringBuilder.append(this.f896b[i3 * 2]);
            stringBuilder.append(", ");
            stringBuilder.append(this.f896b[(i3 * 2) + 1]);
            stringBuilder.append(")");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
