package com.google.android.m4b.maps.ay;

public abstract class as {
    protected boolean f1116a;

    public abstract C1440g m1649a(int i);

    public abstract void m1650a(int i, C1440g[] c1440gArr);

    public abstract boolean m1651a(C1440g c1440g);

    public abstract C1420n m1654c();

    public abstract int m1655h();

    public ar m1648a() {
        return ar.m1671a(m1654c().m1747a());
    }

    public boolean m1652a(C1420n c1420n) {
        if (!m1648a().m1678b(c1420n.m1747a())) {
            return false;
        }
        for (int i = 0; i < c1420n.m1750b(); i++) {
            if (!m1651a(c1420n.m1746a(i))) {
                return false;
            }
        }
        if (m1647c(c1420n)) {
            return false;
        }
        return true;
    }

    public boolean m1653b(C1420n c1420n) {
        if (!m1648a().m1678b(c1420n.m1747a())) {
            return false;
        }
        if (m1651a(c1420n.m1746a(0)) || c1420n.m1748a(m1649a(0)) || m1647c(c1420n)) {
            return true;
        }
        return false;
    }

    private boolean m1647c(C1420n c1420n) {
        int h = m1655h();
        int b = c1420n.m1750b();
        if (h == 0 || b == 0) {
            return false;
        }
        C1440g[] c1440gArr = new C1440g[2];
        C1440g h2 = c1420n.m1752h();
        for (int i = 0; i < h; i++) {
            m1650a(i, c1440gArr);
            int i2 = 0;
            C1440g c1440g = h2;
            while (i2 < b) {
                C1440g a = c1420n.m1746a(i2);
                if (C1442i.m1991a(c1440gArr[0], c1440gArr[1], c1440g, a)) {
                    return true;
                }
                i2++;
                c1440g = a;
            }
        }
        return false;
    }
}
