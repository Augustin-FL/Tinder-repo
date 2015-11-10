package com.google.android.m4b.maps.ab;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.m4b.maps.as.b;
import com.google.android.m4b.maps.ay.C1440g;
import com.google.android.m4b.maps.ay.C1446k;
import com.google.android.m4b.maps.ay.C1446k.C1445a;
import com.google.android.m4b.maps.ay.ac;
import com.google.android.m4b.maps.ay.ah;
import com.google.android.m4b.maps.ay.am;
import com.google.android.m4b.maps.ay.ba;
import com.google.android.m4b.maps.ba.i;
import com.google.android.m4b.maps.bg.e;
import com.google.android.m4b.maps.ch.a;
import com.google.android.m4b.maps.ch.c;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* renamed from: com.google.android.m4b.maps.ab.b */
public final class C1317b implements ba {
    private final ac f769a;
    private final int f770b;
    private final long f771c;
    private final C1318c[] f772d;

    private C1317b(ac acVar, a aVar, long j) {
        this.f769a = acVar;
        this.f770b = aVar.d(1);
        this.f771c = j;
        this.f772d = new C1318c[aVar.j(2)];
        m1037a(aVar, m1039a(aVar));
        m1040b(aVar);
    }

    public static C1317b m1036a(ac acVar, byte[] bArr, int i, long j) {
        int i2 = i + 10;
        byte[] bArr2 = new byte[32];
        i.a(acVar.m1450c(), acVar.m1451d(), acVar.m1449b(), C1317b.m1035a(bArr, i), bArr2);
        i iVar = new i();
        iVar.b(bArr2, AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY);
        iVar.a(bArr, i2, bArr.length - i2);
        int length = bArr.length - i2;
        Inflater inflater = new Inflater(true);
        try {
            e.a a = e.a(bArr, i2, length);
            byte[] a2 = a.a();
            length = a.b();
            a aVar = new a(b.a);
            aVar.a(new ByteArrayInputStream(a2), length);
            C1317b c1317b = new C1317b(acVar, aVar, j);
            inflater.end();
            return c1317b;
        } catch (DataFormatException e) {
            throw new IOException(e.getMessage());
        } catch (Throwable th) {
            inflater.end();
        }
    }

    public static int m1035a(byte[] bArr, int i) {
        com.google.android.m4b.maps.ci.a aVar = new com.google.android.m4b.maps.ci.a(bArr);
        aVar.skipBytes(i);
        int readInt = aVar.readInt();
        if (readInt != 1162889042) {
            throw new IOException("FORMAT_MAGIC expected. Found: " + readInt);
        }
        readInt = aVar.readUnsignedShort();
        if (readInt == 1) {
            return aVar.readInt();
        }
        throw new IOException("Version mismatch: 1 expected, " + readInt + " found");
    }

    private C1440g[] m1039a(a aVar) {
        C1440g[] c1440gArr = new C1440g[this.f772d.length];
        int j = aVar.j(4);
        for (int i = 0; i < j; i++) {
            a c = aVar.c(4, i);
            C1440g a = C1440g.m1924a(c.d(1), c.d(2));
            int[] a2 = C1317b.m1038a(c.c(3));
            for (int i2 : a2) {
                c1440gArr[i2] = a;
            }
        }
        return c1440gArr;
    }

    private void m1037a(a aVar, C1440g[] c1440gArr) {
        for (int i = 0; i < this.f772d.length / 2; i++) {
            C1319d[] c1319dArr;
            int i2;
            int a;
            DataInput dataInput;
            int i3 = i * 2;
            int i4 = (i * 2) + 1;
            a c = aVar.c(2, i3);
            int a2 = c.a(c, 2);
            a c2 = aVar.c(2, i4);
            int a3 = c.a(c2, 2);
            byte[] bArr = null;
            a c3 = aVar.c(3, i);
            if (c3.i(1)) {
                bArr = c3.c(1);
            }
            int a4 = c.a(c3, 2, 0);
            int a5 = c.a(c3, 3, 0);
            int j = c.j(3);
            boolean z = a5 == 1;
            if (j > 0) {
                c1319dArr = new C1319d[j];
                for (i2 = 0; i2 < j; i2++) {
                    a c4 = aVar.c(5, c.b(3, i2));
                    String str = null;
                    if (c4.i(2)) {
                        str = c4.g(2).intern();
                    }
                    c1319dArr[i2] = new C1319d(c4.g(1).intern(), str, z);
                }
            } else {
                c1319dArr = new C1319d[]{C1318c.f773a};
            }
            C1440g c1440g = c1440gArr[i4];
            C1440g c1440g2 = c1440gArr[i3];
            if (bArr != null) {
                DataInput dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
                DataInput dataInput2 = dataInputStream;
                a = am.m1577a(dataInputStream);
                dataInput = dataInput2;
            } else {
                dataInput = null;
                a = 0;
            }
            C1445a c1445a = new C1445a(a + 2);
            if (c1440g != null) {
                c1445a.m2006a(c1440g);
            }
            int i5 = 0;
            int i6 = 0;
            for (i2 = 0; i2 < a; i2++) {
                i5 += am.m1579b(dataInput);
                i6 += am.m1579b(dataInput);
                c1445a.m2006a(C1440g.m1939c(i5, i6));
            }
            if (c1440g2 != null) {
                c1445a.m2006a(c1440g2);
            }
            C1446k c5 = c1445a.m2008c();
            if (c1440g == null && c1440g2 == null) {
                throw new IOException("Both polyline endpoints are missing for segment: " + this.f772d[i3] + " in tile: " + this.f769a);
            }
            int i7;
            int i8;
            if (c1440g == null) {
                a = 2;
                i7 = 5;
            } else if (c1440g2 == null) {
                a = 1;
                i7 = 6;
            } else {
                i7 = 4;
                a = 0;
            }
            if ((c.a(c, 4, 0) & 1) != 0) {
                j = a | 8;
            } else {
                j = a;
            }
            if ((c.a(c2, 4, 0) & 1) != 0) {
                i8 = i7 | 8;
            } else {
                i8 = i7;
            }
            this.f772d[i3] = new C1318c(C1318c.m1051a(this.f769a, i3), c1319dArr, c5, j, a2, a5, a4);
            this.f772d[i4] = new C1318c(C1318c.m1051a(this.f769a, i4), c1319dArr, c5, i8, a3, a5, a4);
            if (c5.m2020b() < 2) {
                throw new IOException("Segment polyline had fewer than two points for segment: " + this.f772d[i3] + " in tile: " + this.f769a);
            }
        }
    }

    private void m1040b(a aVar) {
        int j = aVar.j(4);
        C1440g c1440g = new C1440g();
        c1440g = new C1440g();
        for (int i = 0; i < j; i++) {
            a c = aVar.c(4, i);
            int[] a = C1317b.m1038a(c.c(3));
            int[] a2 = C1317b.m1038a(c.c(4));
            int i2 = 0;
            Object obj = new C1316a[a.length];
            int i3;
            for (int i4 = 0; i4 < a.length; i4 = i3 + 1) {
                C1318c c1318c = this.f772d[a[i4]];
                int i5 = 0;
                i3 = i4;
                i4 = 0;
                while (i4 < a.length) {
                    if (i2 >= a2.length) {
                        i4 = a.length;
                        i3 = i4;
                    } else {
                        int i6 = a2[i2];
                        if (i6 != 0) {
                            int i7 = i5 + 1;
                            obj[i5] = new C1316a(this.f772d[a[i4] ^ 1], i6);
                            i5 = i7;
                        }
                    }
                    i4++;
                    i2++;
                }
                C1316a[] c1316aArr = new C1316a[i5];
                System.arraycopy(obj, 0, c1316aArr, 0, c1316aArr.length);
                c1318c.m1054a(c1316aArr);
            }
        }
    }

    private static int[] m1038a(byte[] bArr) {
        DataInput dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        int a = am.m1577a(dataInputStream);
        int[] iArr = new int[a];
        for (int i = 0; i < a; i++) {
            iArr[i] = am.m1577a(dataInputStream);
        }
        return iArr;
    }

    public final boolean m1042a(com.google.android.m4b.maps.cf.b bVar) {
        return this.f771c >= 0 && bVar.b() > this.f771c;
    }

    public final ac m1041a() {
        return this.f769a;
    }

    public final int m1045c() {
        return this.f770b;
    }

    public final ah m1043b() {
        return ah.f1041i;
    }

    public final int m1047d() {
        return -1;
    }

    public final boolean m1044b(com.google.android.m4b.maps.cf.b bVar) {
        return false;
    }

    public final void m1046c(com.google.android.m4b.maps.cf.b bVar) {
    }

    public final long m1050p() {
        return -1;
    }

    public final long m1049k() {
        return this.f771c;
    }

    public final boolean m1048e() {
        return false;
    }
}
