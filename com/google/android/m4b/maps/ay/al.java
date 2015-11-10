package com.google.android.m4b.maps.ay;

import com.google.android.m4b.maps.bo.f;
import com.google.android.m4b.maps.ch.a;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public final class al {
    public static long m1575a(int i, int i2, int i3) {
        int i4 = i3 * 2;
        long j = 0;
        for (int i5 = 0; i5 < i4; i5 += 2) {
            int i6 = i & 1;
            int i7 = i2 & 1;
            if (i6 == 0 && i7 == 0) {
                j |= 0 << i5;
            } else if (i6 == 0 && i7 == 1) {
                j |= 1 << i5;
            } else if (i6 == 1 && i7 == 1) {
                j |= 2 << i5;
            } else {
                j |= 3 << i5;
            }
            i >>= 1;
            i2 >>= 1;
        }
        if (i == 0 && i2 == 0 && i4 <= 62) {
            return j | (1 << i4);
        }
        throw new IllegalArgumentException(String.format("Invalid map tile proto X = %d, Y = %d, zoom = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}));
    }

    public static a m1576a(long j) {
        int i = 0;
        long j2 = j;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (j2 > 1) {
            switch ((int) (3 & j2)) {
                case C3374b.SmoothProgressBar_spb_color /*1*/:
                    i4 |= i2;
                    break;
                case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                    i |= i2;
                    i4 |= i2;
                    break;
                case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                    i |= i2;
                    break;
                default:
                    break;
            }
            j2 >>= 2;
            i2 <<= 1;
            i3++;
        }
        if (j2 != 1) {
            throw new IllegalArgumentException("Invalid TUVW " + Long.toBinaryString(j));
        }
        a aVar = new a(f.g);
        aVar.f(2, i);
        aVar.f(3, i4);
        aVar.f(4, i3);
        return aVar;
    }
}
