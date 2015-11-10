package com.google.android.m4b.maps.au;

import com.google.android.m4b.maps.au.C1344a.C1342a;
import com.google.android.m4b.maps.ca.b;
import com.google.android.m4b.maps.ca.c;

/* renamed from: com.google.android.m4b.maps.au.j */
class C1348j extends C1347m implements c {
    C1348j(C1361g c1361g) {
        super((C1344a) c1361g);
        m1195a((C1344a) c1361g);
    }

    protected C1348j(double[] dArr) {
        super(dArr);
        m1195a(this.a);
    }

    private C1348j(double[] dArr, int[] iArr) {
        super(C1361g.m1228a(dArr), iArr);
    }

    private void m1195a(C1344a c1344a) {
        this.c = c1344a.f858a;
        this.b = new int[this.c];
        for (int i = 0; i < this.c; i++) {
            this.b[i] = i;
        }
        b.a().a(this, 0, this.c - 1);
    }

    public final C1348j m1199b(int i, int i2) {
        if (this.a.m1128a() != 0) {
            throw new NullPointerException("Cannot create a sorted sublist when there are holes.");
        } else if (i > i2) {
            r1 = new double[((((i2 + 1) + m1179e()) - i) * 2)];
            this.a.m1130a(0, r1, 0, i2 + 1);
            this.a.m1130a(i, r1, i2 + 1, m1179e() - i);
            return new C1348j(r1, m1196a(i, i2));
        } else {
            int i3 = (i2 - i) + 1;
            r1 = new double[(i3 * 2)];
            this.a.m1130a(i, r1, 0, i3);
            return new C1348j(r1, m1196a(i, i2));
        }
    }

    private int[] m1196a(int i, int i2) {
        int i3 = 0;
        int[] iArr;
        if (i > i2) {
            int i4 = (i - i2) - 1;
            iArr = new int[(this.c - i4)];
            for (int i5 : this.b) {
                if (i5 <= i2) {
                    iArr[i3] = i5;
                    i3++;
                }
                if (i5 >= i) {
                    iArr[i3] = i5 - i4;
                    i3++;
                }
            }
            return iArr;
        }
        iArr = new int[((i2 - i) + 1)];
        for (int i6 : this.b) {
            if (i6 >= i && i6 <= i2) {
                iArr[i3] = i6 - i;
                i3++;
            }
        }
        return iArr;
    }

    public final boolean m1202c(int i, int i2) {
        int a = this.a.m1129a(this.b[i], this.b[i2]);
        if (a == 0) {
            a = this.b[i];
            int i3 = this.b[i2];
            int[] iArr = new int[]{a, this.a.m1134d(a)};
            int[] iArr2 = new int[]{i3, this.a.m1134d(i3)};
            int[] iArr3 = new int[]{a, this.a.m1133c(a)};
            int[] iArr4 = new int[]{i3, this.a.m1133c(i3)};
            C1342a c1342a = new C1342a(this.a, a);
            boolean z;
            if (c1342a.m1124a(iArr, iArr2) < 0) {
                z = true;
            } else {
                z = false;
            }
            if (c1342a.m1124a(iArr3, iArr4) < 0) {
                if (c1342a.m1124a(iArr3, iArr2) < 0 || r0) {
                    return true;
                }
                return false;
            } else if (c1342a.m1124a(iArr, iArr4) >= 0 || !r0) {
                return false;
            } else {
                return true;
            }
        } else if (a < 0) {
            return true;
        } else {
            return false;
        }
    }

    public final void m1203d(int i, int i2) {
        int i3 = this.b[i];
        this.b[i] = this.b[i2];
        this.b[i2] = i3;
    }

    public final void m1197a() {
        throw new UnsupportedOperationException("SortedVertexMapping is immutable.");
    }

    public final void m1201b(int... iArr) {
        throw new UnsupportedOperationException("SortedVertexMapping is immutable.");
    }

    public final void m1204e(int i, int i2) {
        throw new UnsupportedOperationException("SortedVertexMapping is immutable.");
    }

    public final void m1205f(int i, int i2) {
        throw new UnsupportedOperationException("SortedVertexMapping is immutable.");
    }

    public final void m1200b() {
        throw new UnsupportedOperationException("SortedVertexMapping is immutable.");
    }

    public final void m1198a(int i) {
        throw new UnsupportedOperationException("SortedVertexMapping is immutable.");
    }
}
