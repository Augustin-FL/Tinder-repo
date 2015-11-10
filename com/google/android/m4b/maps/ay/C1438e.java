package com.google.android.m4b.maps.ay;

import com.google.android.m4b.maps.ah.C1327d;
import com.google.android.m4b.maps.ay.ao.C1410a;
import com.google.android.m4b.maps.ay.ao.C1411b;
import com.google.android.m4b.maps.ay.ao.C1412c;
import com.google.android.m4b.maps.ay.ao.C1413d;
import com.google.android.m4b.maps.ay.ap.C1414a;
import com.google.android.m4b.maps.ay.ap.C1415b;
import com.google.android.m4b.maps.cf.b;
import com.google.android.m4b.maps.p009m.C1480a;
import com.google.common.collect.C1872p;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: com.google.android.m4b.maps.ay.e */
public final class C1438e extends ap {
    private final List<bb> f1247a;
    private List<bb> f1248b;
    private Set<C1480a> f1249c;
    private List<String> f1250d;
    private List<String> f1251e;
    private long f1252f;

    /* renamed from: com.google.android.m4b.maps.ay.e.a */
    class C1437a implements C1415b {
        private int f1244a;
        private int f1245b;
        private /* synthetic */ C1438e f1246c;

        private C1437a(C1438e c1438e) {
            this.f1246c = c1438e;
            this.f1244a = 0;
            this.f1245b = 0;
        }

        public final /* synthetic */ Object next() {
            List a = this.f1246c.f1248b;
            int i = this.f1244a;
            this.f1244a = i + 1;
            return (bb) a.get(i);
        }

        public final boolean hasNext() {
            return this.f1244a < this.f1246c.f1248b.size();
        }

        public final void remove() {
            throw new UnsupportedOperationException("remove() not supported");
        }

        public final bb m1888a() {
            return (bb) this.f1246c.f1248b.get(this.f1244a);
        }

        public final void m1889b() {
            this.f1245b = this.f1244a;
        }

        public final void m1890c() {
            this.f1244a = this.f1245b;
        }
    }

    public static ap m1891a(ap apVar, ap apVar2) {
        long k;
        int i = 0;
        long k2 = apVar.m1641k();
        if (k2 < 0 || (apVar2.m1641k() >= 0 && apVar2.m1641k() < k2)) {
            k = apVar2.m1641k();
        } else {
            k = k2;
        }
        if (apVar2.m1645o() == 0 && k == apVar.m1641k()) {
            return apVar;
        }
        if (apVar2.m1645o() > 0) {
            apVar = C1438e.m1894b(apVar);
            apVar.f1249c = new HashSet();
            ArrayList arrayList = new ArrayList();
            ArrayList a = C1872p.m4309a();
            ArrayList a2 = C1872p.m4309a();
            for (int i2 = 0; i2 < apVar2.m1645o(); i2++) {
                ao b = apVar2.m1631b(i2);
                if (b instanceof C1410a) {
                    arrayList.add((C1410a) b);
                } else if (b instanceof C1412c) {
                    apVar.f1249c.add(((C1412c) b).m1599a());
                } else if (b instanceof C1411b) {
                    a.add((C1411b) b);
                } else if (b instanceof C1413d) {
                    a2.add((C1413d) b);
                } else {
                    throw new IllegalArgumentException("Wrong modifier: " + b);
                }
            }
            Iterator it = apVar.f1248b.iterator();
            while (it.hasNext()) {
                if (apVar.f1249c.contains(((bb) it.next()).m1542d())) {
                    it.remove();
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                int i3;
                C1410a c1410a = (C1410a) it2.next();
                for (i3 = 0; i3 < c1410a.m1594a().m1545k().length; i3++) {
                    int[] k3 = c1410a.m1594a().m1545k();
                    k3[i3] = k3[i3] + apVar.f1250d.size();
                }
                if (!c1410a.m1595b() || c1410a.m1596c() >= apVar.f1247a.size()) {
                    if (c1410a.m1596c() >= apVar.f1247a.size()) {
                        C1327d.m1084a("MutableVectorTile", "Invalid plane index on tile " + apVar2.m1630b() + " at " + apVar2.m1627a());
                    }
                    apVar.f1248b.add(c1410a.m1594a());
                } else {
                    i3 = apVar.f1248b.indexOf((bb) apVar.f1247a.get(c1410a.m1596c()));
                    if (i3 < 0) {
                        apVar.f1248b.add(c1410a.m1594a());
                    } else if (c1410a.m1597d()) {
                        apVar.f1248b.add(i3, c1410a.m1594a());
                    } else {
                        apVar.f1248b.add(i3 + 1, c1410a.m1594a());
                    }
                }
            }
            Iterator it3 = a2.iterator();
            while (it3.hasNext()) {
                it3.next();
            }
            it = a.iterator();
            while (it.hasNext()) {
                apVar.f1248b.add(0, ((C1411b) it.next()).m1598a());
            }
            String[] f = apVar2.m1637f();
            while (i < f.length) {
                if (!apVar.f1251e.contains(f[i])) {
                    apVar.f1251e.add(f[i]);
                }
                i++;
            }
            apVar.f1250d.addAll(Arrays.asList(apVar2.m1638g()));
            apVar.f1252f = k;
            return apVar;
        } else if (!(apVar instanceof C1438e)) {
            return new C1414a().m1602a(apVar.m1627a()).m1608b(apVar.m1633c()).m1600a(apVar.m1635d()).m1606a(apVar.m1637f()).m1610b(apVar.m1638g()).m1611c(apVar.m1643m()).m1605a(apVar.m1644n()).m1603a(apVar.m1630b()).m1601a(k).m1609b(apVar.m1646p()).m1607a();
        } else {
            ((C1438e) apVar).f1252f = k;
            return apVar;
        }
    }

    private static C1438e m1894b(ap apVar) {
        return apVar instanceof C1438e ? (C1438e) apVar : new C1438e(apVar);
    }

    private C1438e(ap apVar) {
        super(null, null, apVar.m1627a(), apVar.m1633c(), apVar.m1642l(), apVar.m1635d(), null, null, apVar.m1643m(), null, apVar.m1630b(), null, -1, apVar.m1646p());
        this.f1249c = Sets.m4227a();
        this.f1252f = -1;
        this.f1247a = Collections.unmodifiableList(Arrays.asList(apVar.m1644n()));
        this.f1248b = new ArrayList();
        C1415b i = apVar.m1640i();
        while (i.hasNext()) {
            this.f1248b.add(i.next());
        }
        this.f1250d = new ArrayList();
        if (apVar.m1638g() != null) {
            this.f1250d.addAll(Arrays.asList(apVar.m1638g()));
        }
        this.f1251e = new ArrayList();
        if (apVar.m1637f() != null) {
            this.f1251e.addAll(Arrays.asList(apVar.m1637f()));
        }
        this.f1252f = apVar.m1641k();
    }

    public static ap m1893b(ap apVar, ap apVar2) {
        ap b = C1438e.m1894b(apVar);
        for (bb bbVar : apVar2.m1644n()) {
            if (bbVar.m1541b() == 6) {
                for (int i = 0; i < b.f1248b.size(); i++) {
                    if (((bb) b.f1248b.get(i)).m1541b() == 6) {
                        b.f1248b.set(i, bbVar);
                        break;
                    }
                }
                b.f1248b.add(bbVar);
            } else {
                b.f1248b.add(bbVar);
            }
        }
        return C1438e.m1891a(b, apVar2);
    }

    public final String[] m1897f() {
        return (String[]) this.f1251e.toArray(new String[this.f1251e.size()]);
    }

    public final String[] m1898g() {
        return (String[]) this.f1250d.toArray(new String[this.f1250d.size()]);
    }

    public final int m1899h() {
        return this.f1248b.size();
    }

    public final bb m1895a(int i) {
        return (bb) this.f1248b.get(i);
    }

    public final C1415b m1900i() {
        return new C1437a();
    }

    public final Set<C1480a> m1901j() {
        return Collections.unmodifiableSet(this.f1249c);
    }

    public final long m1902k() {
        return this.f1252f;
    }

    public final boolean m1896a(b bVar) {
        return this.f1252f >= 0 && bVar.b() > this.f1252f;
    }
}
