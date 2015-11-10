package com.google.android.m4b.maps.ba;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.m4b.maps.ae.d;
import com.google.android.m4b.maps.ah.C1325b;
import com.google.android.m4b.maps.ah.C1327d;
import com.google.android.m4b.maps.ay.ac;
import com.google.android.m4b.maps.ay.af;
import com.google.android.m4b.maps.ay.ah;
import com.google.android.m4b.maps.ay.al;
import com.google.android.m4b.maps.ay.bd;
import com.google.android.m4b.maps.ay.bd.C1421a;
import com.google.android.m4b.maps.bg.i;
import com.google.android.m4b.maps.bh.p;
import com.google.android.m4b.maps.bo.f;
import com.google.android.m4b.maps.ch.a;
import com.google.android.m4b.maps.ch.c;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;
import org.apache.http.protocol.HttpRequestExecutor;

/* renamed from: com.google.android.m4b.maps.ba.a */
public abstract class C1464a extends b {
    private volatile boolean f1360e;
    private final int f1361f;
    private final List<Integer> f1362g;
    private final int f1363h;
    private final int f1364i;
    private final float f1365j;

    /* renamed from: com.google.android.m4b.maps.ba.a.a */
    public abstract class C1462a extends b$a {
        protected int f1350a;
        protected byte[][] f1351b;
        private /* synthetic */ C1464a f1352c;

        protected C1462a(C1464a c1464a) {
            this.f1352c = c1464a;
            super(8);
            this.f1351b = new byte[8][];
        }

        protected int m2147j() {
            return this.f1350a;
        }

        public final int m2146i() {
            return 108;
        }

        public final void m2142a(DataOutput dataOutput) {
            a aVar = new a(f.b);
            a aVar2 = new a(f.c);
            aVar2.b(1, aVar);
            aVar.f(1, this.f1352c.f1361f);
            aVar.f(4, this.f1352c.f1364i);
            aVar.f(5, m2141m().m2148a());
            if (this.f1352c.f1365j > 1.0f) {
                aVar.a(6, this.f1352c.f1365j);
            }
            for (Integer intValue : this.f1352c.f1362g) {
                aVar.a(2, intValue.intValue());
            }
            if (false) {
                aVar.a(3, 2);
            }
            if (p.a()) {
                aVar.a(3, 0);
            }
            C1325b.m1061a();
            if (C1325b.m1066f()) {
                aVar.a(3, 4);
            }
            if (i.a().d()) {
                aVar.a(3, 3);
            }
            if (m2141m() != C1463b.UNKNOWN) {
                aVar.f(5, m2141m().m2148a());
            }
            aVar.a(3, 6);
            if (this.f1352c.c == ah.f1056x) {
                aVar.a(3, 7);
            }
            int k = m2138k();
            for (int i = 0; i < k; i++) {
                b$d a = m2131a(i);
                ac acVar = a.a;
                a aVar3 = new a(f.g);
                aVar3.a(30, al.m1575a(acVar.m1450c(), acVar.m1451d(), acVar.m1449b() + this.f1352c.f1363h));
                aVar3.f(2, 0);
                aVar3.f(3, 0);
                aVar3.f(4, 0);
                aVar3.f(1, a.h.f1065y);
                aVar3.f(7, a.h.f1066z);
                acVar.m1447a(a.h, aVar3);
                C1325b.m1061a();
                if (C1325b.m1066f()) {
                    aVar3.f(8, a.i);
                }
                aVar2.a(9, aVar3);
            }
            c.a(dataOutput, aVar2);
        }

        private C1463b m2141m() {
            C1463b c1463b = C1463b.UNKNOWN;
            for (int i = 0; i < m2138k(); i++) {
                C1463b c1463b2 = m2131a(i).d;
                if (c1463b == C1463b.UNKNOWN || c1463b2.m2148a() < c1463b.m2148a()) {
                    c1463b = c1463b2;
                }
            }
            return c1463b;
        }

        protected byte[] m2145a(int i, int i2) {
            return new byte[i];
        }

        protected final boolean m2143a(b$d com_google_android_m4b_maps_ba_b_d) {
            if (m2138k() == 0) {
                return true;
            }
            if (m2131a(0).a.m1449b() == com_google_android_m4b_maps_ba_b_d.a.m1449b() && m2131a(0).a.m1457j() == com_google_android_m4b_maps_ba_b_d.a.m1457j()) {
                return true;
            }
            return false;
        }

        private void m2140a(InputStream inputStream) {
            int k = m2138k();
            int i = 0;
            while (true) {
                a aVar = new a(null);
                if (c.a(f.f, inputStream, aVar) != -1) {
                    a f = aVar.f(1);
                    int d = f.i(8) ? f.d(8) : -1;
                    Object c = aVar.c(2);
                    int length = c != null ? c.length : 0;
                    Object a = m2145a(length, d);
                    if (c != null) {
                        System.arraycopy(c, 0, a, a.length - length, length);
                    }
                    if (i < k) {
                        a a2;
                        if (f.i(30)) {
                            a2 = al.m1576a(f.e(30));
                        } else {
                            a2 = f;
                        }
                        int d2 = a2.d(2);
                        int d3 = a2.d(3);
                        int d4 = a2.d(4) - this.f1352c.f1363h;
                        af afVar = new af();
                        for (C1421a a3 : C1421a.values()) {
                            bd a4 = a3.m1763a(f);
                            if (a4 != null) {
                                afVar.m1470a(a4);
                            }
                        }
                        Integer a5 = m2132a(C1327d.m1079a(ah.m1497a(f.d(1)), new ac(d4, d2, d3, afVar)));
                        if (a5 == null) {
                            C1327d.m1084a(this.f1352c.getName(), "Received wrong tile");
                        } else if (length != 0) {
                            this.f1351b[a5.intValue()] = a;
                        }
                    }
                    i++;
                } else {
                    return;
                }
            }
        }

        public final boolean m2144a(DataInput dataInput) {
            InputStream a = c.a(dataInput);
            try {
                a aVar = new a(null);
                c.a(f.f, a, aVar);
                this.f1350a = aVar.d(1);
                int d = aVar.d(2);
                if (d != 0) {
                    C1327d.m1084a(this.f1352c.getName(), "Received tile response code: " + d);
                }
                m2140a(a);
                return true;
            } finally {
                a.close();
            }
        }
    }

    /* renamed from: com.google.android.m4b.maps.ba.a.b */
    public enum C1463b {
        UNKNOWN(-1),
        NORMAL(1),
        PREFETCH_OFFLINE_MAP(4),
        PREFETCH_ROUTE(6),
        PREFETCH_AREA(12);
        
        private final int f1359f;

        private C1463b(int i) {
            this.f1359f = i;
        }

        public final int m2148a() {
            return this.f1359f;
        }
    }

    protected C1464a(com.google.android.m4b.maps.ag.i iVar, String str, ah ahVar, int i, List<Integer> list, int i2, int i3, float f, boolean z, Locale locale, boolean z2, File file, d dVar) {
        super(iVar, ahVar, str, ahVar.m1508b(), C1327d.m1090b() ? ahVar.m1505a(str, z2, dVar) : null, ahVar == ah.f1036d ? LocationStatusCodes.GEOFENCE_NOT_AVAILABLE : HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE, z, i3, locale, file);
        this.f1360e = false;
        this.f1361f = AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
        this.f1362g = list;
        this.f1364i = i2;
        if (!list.contains(Integer.valueOf(7))) {
            if (!list.contains(Integer.valueOf(10))) {
                if (!list.contains(Integer.valueOf(11))) {
                    if (!list.contains(Integer.valueOf(12))) {
                        if (!list.contains(Integer.valueOf(9))) {
                            int i4 = AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
                            int i5 = 0;
                            while (i4 > AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) {
                                i4 >>= 1;
                                i5++;
                            }
                            while (i4 < AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) {
                                i4 <<= 1;
                                i5--;
                            }
                            this.f1363h = i5;
                            this.f1365j = f;
                        }
                    }
                }
            }
        }
        this.f1363h = 0;
        this.f1365j = f;
    }
}
