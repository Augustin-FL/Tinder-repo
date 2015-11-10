package com.google.android.m4b.maps.ay;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.m4b.maps.ah.C1325b;
import com.google.android.m4b.maps.ba.i;
import com.google.android.m4b.maps.bg.e;
import com.google.android.m4b.maps.bg.j;
import com.google.android.m4b.maps.cf.b;
import com.google.android.m4b.maps.ci.a;
import com.google.android.m4b.maps.p009m.C1480a;
import com.google.android.m4b.maps.p013q.C1555g;
import java.io.DataInput;
import java.io.IOException;
import java.util.Iterator;
import java.util.zip.DataFormatException;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class ap implements ba {
    private final ac f1104a;
    private final int f1105b;
    private final byte f1106c;
    private final bb[] f1107d;
    private final long f1108e;
    private final String[] f1109f;
    private final String[] f1110g;
    private final int f1111h;
    private final ah f1112i;
    private final ao[] f1113j;
    private final int f1114k;
    private long f1115l;

    /* renamed from: com.google.android.m4b.maps.ay.ap.a */
    public static class C1414a {
        private ac f1090a;
        private int f1091b;
        private int f1092c;
        private bb[] f1093d;
        private C1459x f1094e;
        private long f1095f;
        private String[] f1096g;
        private String[] f1097h;
        private int f1098i;
        private ah f1099j;
        private long f1100k;

        public C1414a() {
            this.f1092c = -1;
            this.f1095f = -1;
            this.f1098i = -1;
            this.f1099j = ah.f1033a;
            this.f1100k = -1;
        }

        public final C1414a m1604a(C1459x c1459x) {
            this.f1094e = c1459x;
            return this;
        }

        public final C1414a m1601a(long j) {
            this.f1095f = j;
            return this;
        }

        public final C1414a m1600a(int i) {
            this.f1092c = i;
            return this;
        }

        public final C1414a m1609b(long j) {
            this.f1100k = j;
            return this;
        }

        public final C1414a m1602a(ac acVar) {
            this.f1090a = acVar;
            return this;
        }

        public final C1414a m1608b(int i) {
            this.f1091b = i;
            return this;
        }

        public final C1414a m1606a(String[] strArr) {
            this.f1096g = strArr;
            return this;
        }

        public final C1414a m1610b(String[] strArr) {
            this.f1097h = strArr;
            return this;
        }

        public final C1414a m1611c(int i) {
            this.f1098i = i;
            return this;
        }

        public final C1414a m1605a(bb[] bbVarArr) {
            this.f1093d = bbVarArr;
            return this;
        }

        public final C1414a m1603a(ah ahVar) {
            this.f1099j = ahVar;
            return this;
        }

        public final ap m1607a() {
            return new ap(this.f1094e, null, this.f1090a, this.f1091b, (byte) 0, this.f1092c, this.f1096g == null ? new String[0] : this.f1096g, this.f1097h == null ? new String[0] : this.f1097h, this.f1098i, this.f1093d == null ? new bb[0] : this.f1093d, this.f1099j, null, this.f1095f, this.f1100k);
        }
    }

    /* renamed from: com.google.android.m4b.maps.ay.ap.b */
    public interface C1415b extends Iterator<bb> {
        bb m1612a();

        void m1613b();

        void m1614c();
    }

    /* renamed from: com.google.android.m4b.maps.ay.ap.c */
    class C1416c implements C1415b {
        private int f1101a;
        private int f1102b;
        private /* synthetic */ ap f1103c;

        private C1416c(ap apVar) {
            this.f1103c = apVar;
            this.f1101a = 0;
            this.f1102b = 0;
        }

        public final /* synthetic */ Object next() {
            bb[] a = this.f1103c.f1107d;
            int i = this.f1101a;
            this.f1101a = i + 1;
            return a[i];
        }

        public final boolean hasNext() {
            return this.f1101a < this.f1103c.f1107d.length;
        }

        public final void remove() {
            throw new UnsupportedOperationException("remove() not supported");
        }

        public final bb m1615a() {
            return this.f1103c.f1107d[this.f1101a];
        }

        public final void m1616b() {
            this.f1102b = this.f1101a;
        }

        public final void m1617c() {
            this.f1101a = this.f1102b;
        }
    }

    protected ap(C1459x c1459x, String[] strArr, ac acVar, int i, byte b, int i2, String[] strArr2, String[] strArr3, int i3, bb[] bbVarArr, ah ahVar, ao[] aoVarArr, long j, long j2) {
        this.f1104a = acVar;
        this.f1105b = i;
        this.f1106c = b;
        this.f1109f = strArr2;
        this.f1110g = strArr3;
        this.f1111h = i3;
        this.f1107d = bbVarArr;
        this.f1112i = ahVar;
        this.f1113j = aoVarArr;
        this.f1114k = i2;
        this.f1108e = j;
        this.f1115l = j2;
    }

    private static ap m1618a(ac acVar, DataInput dataInput, int i, byte b, int i2, int i3, ah ahVar, long j, long j2) {
        m1621a(dataInput);
        ac a = ac.m1435a(dataInput);
        if (a.m1450c() == acVar.m1450c() && a.m1451d() == acVar.m1451d() && a.m1449b() == acVar.m1449b()) {
            int i4;
            String[] strArr;
            C1457v a2;
            int readUnsignedByte = dataInput.readUnsignedByte();
            if (readUnsignedByte > 0) {
                readUnsignedByte += 2000;
            }
            int a3 = am.m1577a(dataInput);
            String[] strArr2 = new String[a3];
            for (i4 = 0; i4 < a3; i4++) {
                strArr2[i4] = dataInput.readUTF().intern();
            }
            a3 = am.m1577a(dataInput);
            String[] strArr3 = new String[a3];
            for (i4 = 0; i4 < a3; i4++) {
                strArr3[i4] = dataInput.readUTF().intern();
            }
            if (i == 11) {
                a3 = am.m1577a(dataInput);
                for (i4 = 0; i4 < a3; i4++) {
                    dataInput.readUTF();
                }
            }
            C1459x a4 = C1459x.m2115a(dataInput, i);
            if (i == 11) {
                strArr = new String[0];
                a2 = C1457v.m2109a(dataInput, a4);
            } else {
                a2 = null;
                a3 = am.m1577a(dataInput);
                strArr = new String[a3];
                for (i4 = 0; i4 < a3; i4++) {
                    strArr[i4] = dataInput.readUTF().intern();
                }
            }
            ae aeVar = new ae(i, acVar, a4, strArr, a2);
            int a5 = am.m1577a(dataInput);
            bb[] bbVarArr = new bb[a5];
            for (a3 = 0; a3 < a5; a3++) {
                bbVarArr[a3] = m1620a(dataInput, aeVar);
            }
            a5 = am.m1577a(dataInput);
            ao[] aoVarArr = new ao[a5];
            for (a3 = 0; a3 < a5; a3++) {
                aoVarArr[a3] = ao.m1592a(dataInput, aeVar);
            }
            return new ap(a4, strArr, acVar, i2, b, i3, strArr2, strArr3, readUnsignedByte, bbVarArr, ahVar, aoVarArr, j, j2);
        }
        throw new IOException("Expected tile coords: " + acVar + " but received " + a);
    }

    public static ap m1619a(ac acVar, byte[] bArr, int i, ah ahVar, long j, long j2) {
        DataInput aVar = new a(bArr);
        aVar.skipBytes(i);
        int readInt = aVar.readInt();
        int readInt2 = aVar.readInt();
        m1621a(aVar);
        int readUnsignedShort = aVar.readUnsignedShort();
        if (readUnsignedShort == 10 || readUnsignedShort == 11) {
            int readInt3 = aVar.readInt();
            long readLong = aVar.readLong();
            int readUnsignedByte = aVar.readUnsignedByte();
            long[] jArr = new long[]{(long) readInt, (long) readInt2, (long) readUnsignedShort, (long) readInt3, readLong, (long) readUnsignedByte};
            readUnsignedByte = (int) jArr[0];
            int i2 = (int) jArr[1];
            readInt3 = (int) jArr[2];
            int i3 = (int) jArr[3];
            readLong = jArr[4];
            byte b = (byte) ((int) jArr[5]);
            int i4 = i + 27;
            int length = bArr.length - i4;
            i iVar = new i();
            byte[] bArr2 = new byte[40];
            i.a(acVar.m1450c(), acVar.m1451d(), acVar.m1449b(), readInt3, i3, readLong, bArr2);
            iVar.a(bArr2, AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY);
            iVar.a(bArr, i4, length);
            try {
                e.a a = e.a(bArr, i4, length);
                byte[] a2 = a.a();
                readInt = a.b();
                a aVar2 = new a(a2);
                ap a3 = m1618a(acVar, aVar2, readInt3, b, readUnsignedByte, i2, ahVar, j, j2);
                if (aVar2.a() != readInt) {
                    throw new IOException("Byte stream not fully read for: " + a3.f1104a);
                }
                j.a(a2);
                return a3;
            } catch (DataFormatException e) {
                throw new IOException(e.getMessage());
            }
        }
        throw new IOException("Version mismatch: 10 or 11 expected, " + readUnsignedShort + " found");
    }

    static bb m1620a(DataInput dataInput, ae aeVar) {
        C1449o c1449o;
        C1480a c1480a = null;
        int i = 0;
        int a = am.m1577a(dataInput);
        if (aeVar.m1459a() == 11) {
            int a2 = am.m1577a(dataInput);
            dataInput.skipBytes(am.m1577a(dataInput));
            c1449o = new C1449o(a2);
        } else {
            c1449o = new C1449o(-1);
        }
        int a3;
        C1458w a4;
        switch (a) {
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                if (aeVar.m1459a() == 10) {
                    a3 = am.m1577a(dataInput);
                    while (i < a3) {
                        am.m1577a(dataInput);
                        i++;
                    }
                }
                return new az(c1449o.m2056a(), C1455t.m2090a());
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                C1446k a5 = C1446k.m2011a(dataInput, aeVar.m1461b());
                a4 = C1458w.m2111a(dataInput, aeVar);
                int a6 = am.m1577a(dataInput);
                bk[] bkVarArr = new bk[a6];
                for (a3 = 0; a3 < a6; a3++) {
                    bkVarArr[a3] = bk.m1837a(dataInput, aeVar, a4);
                }
                int a7 = am.m1577a(dataInput);
                byte readByte = dataInput.readByte();
                a3 = dataInput.readInt();
                if (C1436d.m1887a(1, a3)) {
                    c1480a = C1480a.m2293a(dataInput);
                } else if (C1436d.m1887a(2, a3)) {
                    c1480a = C1480a.m2296b(dataInput);
                }
                int i2 = a3 >>> 2;
                a3 = am.m1577a(dataInput);
                int[] iArr = new int[a3];
                while (i < a3) {
                    iArr[i] = am.m1577a(dataInput);
                    i++;
                }
                return new C1450p(c1449o.m2056a(), c1480a, a5, bkVarArr, a4.m2112a(), a4.m2114c(), a4.m2113b(), a7, readByte, i2, iArr);
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                ak a8 = ak.m1568a(dataInput, aeVar.m1461b());
                byte[] bArr = new byte[a8.m1570a()];
                dataInput.readFully(bArr);
                a4 = C1458w.m2111a(dataInput, aeVar);
                byte readByte2 = dataInput.readByte();
                int readInt = dataInput.readInt();
                if (C1436d.m1887a(1, readInt)) {
                    c1480a = C1480a.m2293a(dataInput);
                } else if (C1436d.m1887a(2, readInt)) {
                    c1480a = C1480a.m2296b(dataInput);
                }
                a3 = am.m1577a(dataInput);
                int[] iArr2 = new int[a3];
                while (i < a3) {
                    iArr2[i] = am.m1577a(dataInput);
                    i++;
                }
                return new au(c1449o.m2056a(), c1480a, a8, bArr, a4.m2112a(), a4.m2114c(), a4.m2113b(), readByte2, readInt, iArr2);
            case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                return av.m1704a(dataInput, aeVar, c1449o);
            case C3374b.SmoothProgressBar_spb_speed /*5*/:
                C1446k a9 = C1446k.m2011a(dataInput, aeVar.m1461b());
                C1458w a10 = C1458w.m2111a(dataInput, aeVar);
                byte readByte3 = dataInput.readByte();
                int readInt2 = dataInput.readInt();
                a3 = am.m1577a(dataInput);
                int[] iArr3 = new int[a3];
                while (i < a3) {
                    iArr3[i] = am.m1577a(dataInput);
                    i++;
                }
                return new bo(c1449o.m2056a(), a9, a10.m2112a(), a10.m2114c(), a10.m2113b(), readByte3, readInt2, iArr3);
            case C3374b.SmoothProgressBar_spb_progressiveStart_speed /*6*/:
                int a11 = am.m1577a(dataInput);
                byte[] bArr2 = new byte[dataInput.readInt()];
                dataInput.readFully(bArr2);
                byte readByte4 = dataInput.readByte();
                a3 = am.m1577a(dataInput);
                int[] iArr4 = new int[a3];
                while (i < a3) {
                    iArr4[i] = am.m1577a(dataInput);
                    i++;
                }
                return new C1447l(c1449o.m2056a(), a11, bArr2, readByte4, C1455t.m2090a(), iArr4);
            case C3374b.SmoothProgressBar_spb_progressiveStop_speed /*7*/:
                return C1441h.m1967a(dataInput, aeVar, c1449o);
            case C3374b.SmoothProgressBar_spb_interpolator /*8*/:
                return bm.m1848a(dataInput, aeVar, c1449o);
            case C3374b.SmoothProgressBar_spb_reversed /*9*/:
                return ai.m1547a(dataInput, aeVar, c1449o);
            case C3374b.SmoothProgressBar_spb_colors /*11*/:
                return bn.m1861b(dataInput, aeVar, c1449o);
            default:
                throw new IOException("Unknown feature type: " + a);
        }
    }

    public final ac m1627a() {
        return this.f1104a;
    }

    public final int m1633c() {
        return this.f1105b;
    }

    public final byte m1642l() {
        return this.f1106c;
    }

    private boolean m1624j() {
        return (this.f1106c & 2) != 0;
    }

    public final boolean m1636e() {
        if (C1555g.m2747c() == null || C1555g.m2747c().m2759c()) {
            boolean z;
            if ((this.f1106c & 1) != 0) {
                z = true;
            } else {
                z = false;
            }
            if (z || !m1624j()) {
                return true;
            }
            return false;
        } else if (m1624j()) {
            return false;
        } else {
            return true;
        }
    }

    public String[] m1637f() {
        return this.f1109f;
    }

    public final int m1643m() {
        return this.f1111h;
    }

    public String[] m1638g() {
        return this.f1110g;
    }

    public int m1639h() {
        return this.f1107d.length;
    }

    public bb m1628a(int i) {
        return this.f1107d[i];
    }

    protected final bb[] m1644n() {
        return this.f1107d;
    }

    public C1415b m1640i() {
        return new C1416c();
    }

    public final int m1645o() {
        return this.f1113j != null ? this.f1113j.length : 0;
    }

    public final ao m1631b(int i) {
        return this.f1113j != null ? this.f1113j[i] : null;
    }

    private static void m1621a(DataInput dataInput) {
        int readInt = dataInput.readInt();
        if (readInt != 1146241364) {
            throw new IOException("TILE_MAGIC expected. Found: " + readInt);
        }
    }

    public long m1641k() {
        return this.f1108e;
    }

    public boolean m1629a(b bVar) {
        return this.f1108e >= 0 && bVar.b() > this.f1108e;
    }

    public final ah m1630b() {
        return this.f1112i;
    }

    public final int m1635d() {
        return this.f1114k;
    }

    public final boolean m1632b(b bVar) {
        return this.f1115l >= 0 && bVar.b() > this.f1115l;
    }

    public final long m1646p() {
        return this.f1115l;
    }

    public final void m1634c(b bVar) {
        if (m1626r() > 0) {
            this.f1115l = bVar.b() + m1626r();
        } else {
            this.f1115l = -1;
        }
    }

    private static long m1626r() {
        C1325b.m1061a();
        return (!C1325b.m1066f() || C1555g.m2747c() == null) ? -1 : C1555g.m2747c().m2757a();
    }

    public static int m1625q() {
        if (m1626r() == -1) {
            return -1;
        }
        return (int) (m1626r() / 3600000);
    }

    public static boolean m1622a(aa aaVar) {
        return (aaVar.m1027b() == ah.f1049q && ((ap) aaVar).m1645o() == 0) || (aaVar instanceof C1419b);
    }
}
