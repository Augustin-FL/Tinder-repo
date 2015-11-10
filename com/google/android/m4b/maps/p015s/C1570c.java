package com.google.android.m4b.maps.p015s;

import android.support.v4.view.InputDeviceCompat;
import com.tinder.views.RangeSeekBar;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.google.android.m4b.maps.s.c */
public final class C1570c {
    private static final byte[][] f1773a;
    private static final int[] f1774b;

    static {
        f1773a = new byte[][]{new byte[]{(byte) 16, (byte) 11, (byte) 12, (byte) 14, (byte) 12, (byte) 10, (byte) 16, (byte) 14, (byte) 13, (byte) 14, (byte) 18, (byte) 17, (byte) 16, (byte) 19, (byte) 24, (byte) 40, (byte) 26, (byte) 24, (byte) 22, (byte) 22, (byte) 24, (byte) 49, (byte) 35, (byte) 37, (byte) 29, (byte) 40, (byte) 58, (byte) 51, (byte) 61, (byte) 60, (byte) 57, (byte) 51, (byte) 56, (byte) 55, (byte) 64, (byte) 72, (byte) 92, (byte) 78, (byte) 64, (byte) 68, (byte) 87, (byte) 69, (byte) 55, (byte) 56, (byte) 80, (byte) 109, (byte) 81, (byte) 87, (byte) 95, (byte) 98, (byte) 103, (byte) 104, (byte) 103, (byte) 62, (byte) 77, (byte) 113, (byte) 121, (byte) 112, (byte) 100, (byte) 120, (byte) 92, (byte) 101, (byte) 103, (byte) 99}, new byte[]{(byte) 17, (byte) 18, (byte) 18, (byte) 24, (byte) 21, (byte) 24, (byte) 47, (byte) 26, (byte) 26, (byte) 47, (byte) 99, (byte) 66, (byte) 56, (byte) 66, (byte) 99, (byte) 99, (byte) 99, (byte) 99, (byte) 99, (byte) 99, (byte) 99, (byte) 99, (byte) 99, (byte) 99, (byte) 99, (byte) 99, (byte) 99, (byte) 99, (byte) 99, (byte) 99, (byte) 99, (byte) 99, (byte) 99, (byte) 99, (byte) 99, (byte) 99, (byte) 99, (byte) 99, (byte) 99, (byte) 99, (byte) 99, (byte) 99, (byte) 99, (byte) 99, (byte) 99, (byte) 99, (byte) 99, (byte) 99, (byte) 99, (byte) 99, (byte) 99, (byte) 99, (byte) 99, (byte) 99, (byte) 99, (byte) 99, (byte) 99, (byte) 99, (byte) 99, (byte) 99, (byte) 99, (byte) 99, (byte) 99, (byte) 99}};
        f1774b = new int[]{-1, 1677721601, 838860801, 559240577, 419430401, 335544321, 279620289, 239674513, 209715201, 186413505, 167772161, 152520145, 139810145, 129055513, 119837257, 111848105, 104857601, 98689505, 93206753, 88301137, 83886081, 79891505, 76260073, 72944417, 69905073, 67108865, 64527757, 62137837, 59918629, 57852473, 55924053, 54120053, 52428801, 50840049, 49344753, 47934905, 46603377, 45343829, 44150569, 43018505, 41943041, 40920041, 39945753, 39016781, 38130037, 37282705, 36472209, 35696205, 34952537, 34239217, InputDeviceCompat.SOURCE_HDMI, 32883345, 32212257, 31541169, 30870077, 30198989, 29527901, 28856813, 28185725, 27514637, 26843545, 26172457, 25501369, 24830281, 24159193, 23488105, 22817013, 22145925, 21474837, 20803749, 20132661, 19461573, 18790481, 18119393, 17448305, 16777217, 16106129, 15435041, 14763953, 14092861, 13421773, 12750685, 12079597, 11408509, 10737421, 10066329, 9395241, 8724153, 8053065, 7381977, 6710889, 6039797, 5368709, 4697621, 4026533, 3355445, 2684357, 2013265, 1342177, 671089, 1};
    }

    public static synchronized byte[] m2791a(int i, int i2, int i3) {
        byte[] bArr;
        synchronized (C1570c.class) {
            bArr = new byte[64];
            byte[] bArr2 = f1773a[i];
            for (int i4 = 0; i4 < 64; i4++) {
                int i5;
                int i6 = bArr2[i4] & RangeSeekBar.INVALID_POINTER_ID;
                switch (i3) {
                    case C3374b.SmoothProgressBar_spbStyle /*0*/:
                        if (i6 != 99 || i2 != 36) {
                            i5 = (int) ((((((long) i6) * ((long) f1774b[i2])) / 16777216) + 1) / 2);
                            break;
                        }
                        i5 = 138;
                        break;
                        break;
                    case C3374b.SmoothProgressBar_spb_color /*1*/:
                        i5 = (((i2 < 50 ? Math.min(5000 / i2, 5000) : Math.max(200 - (i2 * 2), 0)) * i6) + 50) / 100;
                        break;
                    default:
                        throw new IllegalArgumentException("qualityAlgorithm");
                }
                if (i5 <= 0) {
                    i5 = 1;
                } else if (i5 > RangeSeekBar.INVALID_POINTER_ID) {
                    i5 = RangeSeekBar.INVALID_POINTER_ID;
                }
                bArr[i4] = (byte) i5;
            }
        }
        return bArr;
    }

    private static byte[] m2793a(byte[] bArr, int i, int i2) {
        if (bArr[0] == -1 && bArr[1] == -40) {
            Object obj = new byte[i2];
            System.arraycopy(bArr, 0, obj, 0, i2);
            return obj;
        } else if (bArr[0] == 67 && bArr[1] == 74 && bArr[2] == 80 && bArr[3] == 71) {
            int i3 = bArr[4] & RangeSeekBar.INVALID_POINTER_ID;
            int i4 = (bArr[6] & RangeSeekBar.INVALID_POINTER_ID) | ((bArr[5] & RangeSeekBar.INVALID_POINTER_ID) << 8);
            int i5 = (bArr[8] & RangeSeekBar.INVALID_POINTER_ID) | ((bArr[7] & RangeSeekBar.INVALID_POINTER_ID) << 8);
            int i6 = bArr[9] & RangeSeekBar.INVALID_POINTER_ID;
            int i7 = bArr[10] & RangeSeekBar.INVALID_POINTER_ID;
            try {
                int a = C1568a.m2783a(i3);
                Object obj2 = new byte[((a + i2) - 11)];
                C1569b c1569b = new C1569b(i3, i4, i5, i6, i7, a);
                int i8 = i2 - 11;
                i4 = c1569b.m2786a();
                i5 = c1569b.m2787b();
                i6 = c1569b.m2788c();
                i7 = c1569b.m2789d();
                a = c1569b.m2790e();
                if (i4 != 0) {
                    throw new IllegalArgumentException("variant");
                }
                System.arraycopy(bArr, 11, obj2, C1568a.m2783a(i4) + 0, i8);
                C1568a.m2784a(obj2, 0, i4, i5, i6, i7, a);
                return obj2;
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Unknown variant " + i3);
            }
        } else {
            throw new IllegalArgumentException("Input is not in compact JPEG format");
        }
    }

    public static byte[] m2792a(byte[] bArr) {
        return C1570c.m2793a(bArr, 0, bArr.length);
    }
}
