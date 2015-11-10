package com.google.android.m4b.maps.ay;

/* renamed from: com.google.android.m4b.maps.ay.n */
public abstract class C1420n implements ax {
    public abstract C1440g m1746a(int i);

    public abstract boolean m1748a(C1440g c1440g);

    public abstract int m1750b();

    public C1440g m1752h() {
        return m1746a(m1750b() - 1);
    }

    public C1448m m1747a() {
        int i = m1746a(0).f1264a;
        int i2 = m1746a(0).f1265b;
        int i3 = i;
        int i4 = i;
        i = i2;
        for (int i5 = 1; i5 < m1750b(); i5++) {
            i4 = Math.min(i4, m1746a(i5).f1264a);
            i3 = Math.max(i3, m1746a(i5).f1264a);
            i = Math.min(i, m1746a(i5).f1265b);
            i2 = Math.max(i2, m1746a(i5).f1265b);
        }
        return new C1448m(new C1440g(i4, i), new C1440g(i3, i2));
    }

    public boolean m1751b(C1420n c1420n) {
        if (!m1747a().m2047a(c1420n.m1747a())) {
            return false;
        }
        for (int i = 0; i < c1420n.m1750b(); i++) {
            if (!m1748a(c1420n.m1746a(i))) {
                return false;
            }
        }
        if (m1745c(c1420n)) {
            return false;
        }
        return true;
    }

    public boolean m1749a(C1420n c1420n) {
        if (!m1747a().m2047a(c1420n.m1747a())) {
            return false;
        }
        if (m1748a(c1420n.m1746a(0)) || c1420n.m1748a(m1746a(0)) || m1745c(c1420n)) {
            return true;
        }
        return false;
    }

    private boolean m1745c(C1420n c1420n) {
        int b = m1750b();
        int b2 = c1420n.m1750b();
        if (b == 0 || b2 == 0) {
            return false;
        }
        C1440g h = m1752h();
        C1440g h2 = c1420n.m1752h();
        int i = 0;
        C1440g c1440g = h;
        while (i < b) {
            C1440g a = m1746a(i);
            int i2 = 0;
            C1440g c1440g2 = h2;
            while (i2 < b2) {
                C1440g a2 = c1420n.m1746a(i2);
                if (C1442i.m1991a(c1440g, a, c1440g2, a2)) {
                    return true;
                }
                i2++;
                c1440g2 = a2;
            }
            i++;
            c1440g = a;
        }
        return false;
    }
}
