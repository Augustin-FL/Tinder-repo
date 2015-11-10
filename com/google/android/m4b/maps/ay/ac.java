package com.google.android.m4b.maps.ay;

import com.google.android.m4b.maps.ay.bd.C1421a;
import com.google.android.m4b.maps.ch.a;
import java.io.DataInput;
import java.io.DataOutput;
import java.util.ArrayList;

public class ac implements Comparable<ac> {
    final int f999a;
    final int f1000b;
    final int f1001c;
    private final int f1002d;
    private final int f1003e;
    private final int f1004f;
    private final af f1005g;
    private ac f1006h;
    private C1448m f1007i;

    public /* synthetic */ int compareTo(Object obj) {
        ac acVar = (ac) obj;
        if (this.f1002d != acVar.f1002d) {
            return this.f1002d - acVar.f1002d;
        }
        if (this.f1003e == acVar.f1003e) {
            return this.f1004f == acVar.f1004f ? this.f1005g.m1465a(acVar.f1005g) : this.f1004f - acVar.f1004f;
        } else {
            return this.f1003e - acVar.f1003e;
        }
    }

    public ac(int i, int i2, int i3, af afVar) {
        this.f1006h = null;
        this.f1002d = i;
        this.f1003e = i2;
        this.f1004f = i3;
        if (afVar == null) {
            afVar = new af();
        }
        this.f1005g = afVar;
        this.f1001c = 18 - i;
        int i4 = 1073741824 >> i;
        this.f999a = (this.f1003e * i4) - 536870912;
        this.f1000b = -((i4 * (this.f1004f + 1)) - 536870912);
    }

    public ac(int i, int i2, int i3) {
        this(i, i2, i3, null);
    }

    public final ac m1443a(int i, int i2, int i3) {
        return new ac(i, i2, i3, this.f1005g);
    }

    public final ac m1441a() {
        if (this.f1006h == null) {
            this.f1006h = new ac(this.f1002d, this.f1003e, this.f1004f, null);
        }
        return this.f1006h;
    }

    public static ac m1434a(int i, C1440g c1440g) {
        int i2 = c1440g.f1264a;
        int i3 = c1440g.f1265b;
        if (i3 <= -536870912 || i3 > 536870912) {
            return null;
        }
        i2 = (i2 + 536870912) >> 0;
        int i4 = ((-i3) + 536870912) >> 0;
        if (i2 < 0) {
            i2 += 1073741824;
        } else if (i2 >= 1073741824) {
            i2 -= 1073741824;
        }
        return new ac(30, i2, i4);
    }

    private static ac m1433a(int i, int i2, int i3, af afVar) {
        int i4 = 0;
        if (i <= 0) {
            return new ac(0, 0, 0);
        }
        if (i > 30) {
            i = 30;
        }
        int i5 = 30 - i;
        int i6 = (i2 + 536870912) >> i5;
        i5 = ((-i3) + 536870912) >> i5;
        int i7 = 1 << i;
        if (i6 < 0) {
            i6 += i7;
        } else if (i6 >= i7) {
            i6 -= i7;
        }
        if (i5 >= 0) {
            i4 = i5 >= i7 ? i7 - 1 : i5;
        }
        return new ac(i, i6, i4, afVar);
    }

    public static ac m1439b(int i, C1440g c1440g) {
        return m1433a(15, c1440g.f1264a, c1440g.f1265b, null);
    }

    private static ac m1438b(int i, int i2, int i3, af afVar) {
        if (i <= 0) {
            return new ac(0, 0, 0);
        }
        if (i > 30) {
            i = 30;
        }
        int i4 = 30 - i;
        return new ac(i, (i2 + 536870912) >> i4, ((-i3) + 536870912) >> i4, afVar);
    }

    public final int m1449b() {
        return this.f1002d;
    }

    public final int m1450c() {
        return this.f1003e;
    }

    public final int m1451d() {
        return this.f1004f;
    }

    public final int m1452e() {
        return this.f999a;
    }

    public final int m1453f() {
        return this.f1000b;
    }

    public final C1440g m1454g() {
        return new C1440g(this.f999a, this.f1000b);
    }

    public final C1440g m1455h() {
        int i = 1073741824 >> this.f1002d;
        return new C1440g(this.f999a + i, i + this.f1000b);
    }

    public final C1448m m1456i() {
        if (this.f1007i == null) {
            int i = 1073741824 >> this.f1002d;
            this.f1007i = new C1448m(new C1440g(this.f999a, this.f1000b), new C1440g(this.f999a + i, i + this.f1000b));
        }
        return this.f1007i;
    }

    public final ac m1442a(int i) {
        int i2 = this.f1002d - i;
        return i2 <= 0 ? this : m1443a(i, this.f1003e >> i2, this.f1004f >> i2);
    }

    public final void m1448a(DataOutput dataOutput) {
        am.m1578a(dataOutput, this.f1002d);
        am.m1578a(dataOutput, this.f1003e);
        am.m1578a(dataOutput, this.f1004f);
    }

    public static ac m1435a(DataInput dataInput) {
        return new ac(am.m1577a(dataInput), am.m1577a(dataInput), am.m1577a(dataInput));
    }

    public static ArrayList<ac> m1436a(ar arVar, int i) {
        return m1437a(arVar, 15, null);
    }

    public static ArrayList<ac> m1437a(ar arVar, int i, af afVar) {
        int i2 = 0;
        if (i < 0) {
            return new ArrayList(0);
        }
        int i3;
        ac a = m1433a(i, arVar.m1682f().f1264a, arVar.m1683g().f1265b, afVar);
        ac a2 = m1433a(i, arVar.m1683g().f1264a - 1, arVar.m1682f().f1265b + 1, afVar);
        int i4 = a.f1003e;
        int i5 = a.f1004f;
        int i6 = a2.f1003e;
        int i7 = a2.f1004f;
        int i8 = 1 << i;
        if (i4 > i6) {
            i3 = (((i8 - i4) + i6) + 1) * ((i7 - i5) + 1);
        } else {
            i3 = ((i6 - i4) + 1) * ((i7 - i5) + 1);
        }
        if (i3 < 0) {
            return new ArrayList();
        }
        ArrayList<ac> arrayList = new ArrayList(i3);
        if (i3 <= 2) {
            arrayList.add(a);
            if (i3 != 2) {
                return arrayList;
            }
            arrayList.add(a2);
            return arrayList;
        } else if (i4 > i6) {
            while (i4 < i8) {
                for (i3 = i5; i3 <= i7; i3++) {
                    arrayList.add(new ac(i, i4, i3, afVar));
                }
                i4++;
            }
            while (i2 <= i6) {
                for (i4 = i5; i4 <= i7; i4++) {
                    arrayList.add(new ac(i, i2, i4, afVar));
                }
                i2++;
            }
            return arrayList;
        } else {
            while (i4 <= i6) {
                for (i2 = i5; i2 <= i7; i2++) {
                    arrayList.add(new ac(i, i4, i2, afVar));
                }
                i4++;
            }
            return arrayList;
        }
    }

    public static ArrayList<ac> m1440b(ar arVar, int i) {
        ac b = m1438b(i, arVar.m1682f().f1264a, arVar.m1683g().f1265b, null);
        ac b2 = m1438b(i, arVar.m1683g().f1264a - 1, arVar.m1682f().f1265b + 1, null);
        int i2 = b.f1003e;
        int i3 = b.f1004f;
        int i4 = b2.f1003e;
        int i5 = b2.f1004f;
        if (!C1440g.m1940e(b.f999a, b.f1000b) && !C1440g.m1940e(b2.f999a, b2.f1000b)) {
            return new ArrayList();
        }
        int i6 = 1 << i;
        ArrayList<ac> arrayList = new ArrayList();
        int i7;
        if (i2 > i4) {
            while (i2 < i6) {
                for (i7 = i3; i7 < 0; i7++) {
                    arrayList.add(new ac(i, i2, i7, null));
                }
                for (i7 = i6; i7 <= i5; i7++) {
                    arrayList.add(new ac(i, i2, i7, null));
                }
                i2++;
            }
            for (i7 = 0; i7 <= i4; i7++) {
                for (i2 = i3; i2 < 0; i2++) {
                    arrayList.add(new ac(i, i7, i2, null));
                }
                for (i2 = i6; i2 <= i5; i2++) {
                    arrayList.add(new ac(i, i7, i2, null));
                }
            }
            return arrayList;
        }
        while (i2 <= i4) {
            for (i7 = i3; i7 < 0; i7++) {
                arrayList.add(new ac(i, i2, i7, null));
            }
            for (i7 = i6; i7 <= i5; i7++) {
                arrayList.add(new ac(i, i2, i7, null));
            }
            i2++;
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ac)) {
            return false;
        }
        ac acVar = (ac) obj;
        if (this.f1003e == acVar.f1003e && this.f1004f == acVar.f1004f && this.f1002d == acVar.f1002d) {
            return this.f1005g.equals(acVar.f1005g);
        }
        return false;
    }

    public int hashCode() {
        int i = (((this.f1002d * 31) + this.f1003e) * 31) + this.f1004f;
        if (this.f1005g.m1471b()) {
            return i;
        }
        return (i * 31) + this.f1005g.hashCode();
    }

    public final bd m1446a(C1421a c1421a) {
        return this.f1005g.m1467a(c1421a);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        stringBuilder.append(this.f1002d).append(",").append(this.f1003e).append(",").append(this.f1004f).append(",").append(this.f1005g).append("]");
        return stringBuilder.toString();
    }

    public ac m1444a(af afVar) {
        return new ac(this.f1002d, this.f1003e, this.f1004f, afVar);
    }

    public final ac m1445a(ah ahVar) {
        return m1444a(this.f1005g.m1466a(ahVar));
    }

    public final void m1447a(ah ahVar, a aVar) {
        this.f1005g.m1469a(ahVar, aVar);
    }

    public final af m1457j() {
        return this.f1005g;
    }
}
