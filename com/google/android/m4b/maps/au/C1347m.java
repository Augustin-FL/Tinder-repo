package com.google.android.m4b.maps.au;

import com.google.android.m4b.maps.au.C1344a.C1343b;

/* renamed from: com.google.android.m4b.maps.au.m */
class C1347m {
    protected C1344a f864a;
    protected int[] f865b;
    int f866c;

    public final C1347m m1176c() {
        return new C1347m(this.f864a);
    }

    protected C1347m(double[] dArr) {
        this.f864a = C1361g.m1228a(dArr);
        this.f865b = new int[4];
        this.f866c = 0;
    }

    protected C1347m(C1344a c1344a) {
        this.f864a = c1344a;
        this.f865b = new int[4];
        this.f866c = 0;
    }

    protected C1347m(C1344a c1344a, int[] iArr) {
        this.f864a = c1344a;
        this.f865b = iArr;
        this.f866c = iArr.length;
    }

    public final double m1170b(int i) {
        return this.f864a.m1126a(i);
    }

    public final double m1174c(int i) {
        return this.f864a.m1132b(i);
    }

    public final int m1186g(int i, int i2) {
        return this.f864a.m1129a(i, i2);
    }

    public final int m1178d(int i) {
        return this.f864a.m1133c(i);
    }

    public final int m1180e(int i) {
        return this.f864a.m1134d(i);
    }

    public final int m1177d() {
        return this.f864a.m1128a();
    }

    public final int m1179e() {
        return this.f864a.f858a;
    }

    public final double m1166a(int i, int i2, int i3) {
        return this.f864a.m1127a(i, i2, i3);
    }

    public final C1343b m1183f(int i) {
        return this.f864a.m1135e(i);
    }

    public final double m1185g(int i) {
        return this.f864a.m1126a(m1191j(i));
    }

    public final double m1187h(int i) {
        return this.f864a.m1132b(m1191j(i));
    }

    public final boolean m1189i(int i) {
        return m1191j(i) == -1;
    }

    public final int m1191j(int i) {
        return this.f865b[m1163o(i)];
    }

    private int m1162n(int i) {
        return this.f864a.m1138h(m1191j(i - 1));
    }

    public final int m1182f() {
        return this.f864a.m1138h(m1191j(this.f866c - 2));
    }

    public final int m1188h(int i, int i2) {
        int h = this.f864a.m1138h(i);
        while (i2 < this.f866c) {
            if (m1191j(i2) == h) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public final boolean m1190i(int i, int i2) {
        return this.f864a.m1138h(m1191j(i2)) == this.f864a.m1138h(i);
    }

    public final boolean m1192k(int i) {
        return m1162n(i) == this.f864a.m1134d(m1191j(i));
    }

    public final boolean m1193l(int i) {
        return m1162n(i) == this.f864a.m1133c(m1191j(i));
    }

    public final double m1171b(int i, int i2, int i3) {
        return (-(((this.f864a.m1126a(this.f865b[i]) - this.f864a.m1126a(this.f865b[i2])) * (this.f864a.m1132b(this.f865b[i3]) - this.f864a.m1132b(this.f865b[i2]))) - ((this.f864a.m1132b(this.f865b[i]) - this.f864a.m1132b(this.f865b[i2])) * (this.f864a.m1126a(this.f865b[i3]) - this.f864a.m1126a(this.f865b[i2]))))) / 2.0d;
    }

    public final double m1175c(int i, int i2, int i3) {
        C1344a c1344a = this.f864a;
        return (-(((c1344a.m1126a(i) - c1344a.m1126a(i2)) * (c1344a.m1132b(i3) - c1344a.m1132b(i2))) - ((c1344a.m1126a(i3) - c1344a.m1126a(i2)) * (c1344a.m1132b(i) - c1344a.m1132b(i2))))) / 2.0d;
    }

    public void m1167a() {
        this.f866c = 0;
    }

    public void m1173b(int... iArr) {
        m1165q(iArr.length);
        for (int p : iArr) {
            this.f865b[this.f866c] = m1164p(p);
            this.f866c++;
        }
    }

    public void m1181e(int i, int i2) {
        m1165q(1);
        System.arraycopy(this.f865b, i, this.f865b, i + 1, this.f866c - i);
        this.f865b[i] = m1164p(i2);
        this.f866c++;
    }

    public void m1184f(int i, int i2) {
        this.f865b[m1163o(i)] = m1164p(i2);
    }

    public void m1172b() {
        this.f866c--;
    }

    public void m1168a(int i) {
        System.arraycopy(this.f865b, i + 1, this.f865b, i, (this.f866c - i) - 1);
        this.f866c--;
    }

    private int m1163o(int i) {
        if (this.f866c == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i2 = i % this.f866c;
        return i2 < 0 ? i2 + this.f866c : i2;
    }

    private int m1164p(int i) {
        if (i == -1) {
            return -1;
        }
        return this.f864a.m1138h(i);
    }

    private void m1165q(int i) {
        if (this.f865b.length < this.f866c + i) {
            Object obj = new int[(this.f866c + Math.max(i, (int) ((((double) this.f865b.length) * 1.5d) + 1.0d)))];
            System.arraycopy(this.f865b, 0, obj, 0, this.f865b.length);
            this.f865b = obj;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1347m)) {
            return false;
        }
        C1347m c1347m = (C1347m) obj;
        if (c1347m.m1169a((Object) this) && this.f864a.equals(c1347m.f864a)) {
            boolean z;
            int[] iArr = this.f865b;
            int i = this.f866c;
            int[] iArr2 = c1347m.f865b;
            int i2 = c1347m.f866c;
            if (i == -1) {
                i = iArr.length;
            }
            if (i2 == -1) {
                i2 = iArr2.length;
            }
            if (i != i2 || iArr == null || iArr2 == null || iArr.length < i || iArr2.length < i) {
                z = false;
            } else {
                for (i2 = 0; i2 < i; i2++) {
                    if (iArr[i2] != iArr2[i2]) {
                        z = false;
                        break;
                    }
                }
                z = true;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    protected boolean m1169a(Object obj) {
        return obj instanceof C1347m;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = this.f864a.hashCode();
        int[] iArr = this.f865b;
        int i2 = this.f866c;
        if (iArr != null) {
            i = 1;
            int i3 = 0;
            while (i3 < i2) {
                int i4 = iArr[i3] + (i * 31);
                i3++;
                i = i4;
            }
        }
        return (i * 31) + hashCode;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        stringBuilder.append(m1194m(5));
        stringBuilder.append(",");
        stringBuilder.append(this.f866c);
        stringBuilder.append(",\n");
        stringBuilder.append(this.f864a);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    final String m1194m(int i) {
        int i2 = this.f866c - 1;
        if (i2 == -1) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        int i3 = 0;
        while (true) {
            stringBuilder.append(String.format("%" + i + "s", new Object[]{Integer.valueOf(this.f865b[i3])}));
            if (i3 == i2) {
                return stringBuilder.append(']').toString();
            }
            stringBuilder.append(", ");
            i3++;
        }
    }
}
