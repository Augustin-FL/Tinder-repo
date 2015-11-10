package com.mixpanel.android.p025a;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.tinder.views.RangeSeekBar;

/* renamed from: com.mixpanel.android.a.b */
public class C1991b {
    private static char[] f2726a;
    private static byte[] f2727b;

    static {
        int i;
        int i2 = 0;
        f2726a = new char[64];
        char c = 'A';
        int i3 = 0;
        while (c <= 'Z') {
            i = i3 + 1;
            f2726a[i3] = c;
            c = (char) (c + 1);
            i3 = i;
        }
        c = 'a';
        while (c <= 'z') {
            i = i3 + 1;
            f2726a[i3] = c;
            c = (char) (c + 1);
            i3 = i;
        }
        c = '0';
        while (c <= '9') {
            i = i3 + 1;
            f2726a[i3] = c;
            c = (char) (c + 1);
            i3 = i;
        }
        i = i3 + 1;
        f2726a[i3] = '+';
        i3 = i + 1;
        f2726a[i] = '/';
        f2727b = new byte[AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS];
        for (int i4 = 0; i4 < f2727b.length; i4++) {
            f2727b[i4] = (byte) -1;
        }
        while (i2 < 64) {
            f2727b[f2726a[i2]] = (byte) i2;
            i2++;
        }
    }

    public static String m4586a(String str) {
        return new String(C1991b.m4587a(str.getBytes()));
    }

    public static char[] m4587a(byte[] bArr) {
        return C1991b.m4588a(bArr, bArr.length);
    }

    public static char[] m4588a(byte[] bArr, int i) {
        int i2 = ((i * 4) + 2) / 3;
        char[] cArr = new char[(((i + 2) / 3) * 4)];
        int i3 = 0;
        int i4 = 0;
        while (i4 < i) {
            int i5;
            char c;
            int i6 = i4 + 1;
            int i7 = bArr[i4] & RangeSeekBar.INVALID_POINTER_ID;
            if (i6 < i) {
                i5 = bArr[i6] & RangeSeekBar.INVALID_POINTER_ID;
                i6++;
            } else {
                i5 = 0;
            }
            if (i6 < i) {
                i4 = i6 + 1;
                i6 = bArr[i6] & RangeSeekBar.INVALID_POINTER_ID;
            } else {
                i4 = i6;
                i6 = 0;
            }
            int i8 = i7 >>> 2;
            i7 = ((i7 & 3) << 4) | (i5 >>> 4);
            i5 = ((i5 & 15) << 2) | (i6 >>> 6);
            int i9 = i6 & 63;
            i6 = i3 + 1;
            cArr[i3] = f2726a[i8];
            i3 = i6 + 1;
            cArr[i6] = f2726a[i7];
            if (i3 < i2) {
                c = f2726a[i5];
            } else {
                c = '=';
            }
            cArr[i3] = c;
            i5 = i3 + 1;
            if (i5 < i2) {
                c = f2726a[i9];
            } else {
                c = '=';
            }
            cArr[i5] = c;
            i3 = i5 + 1;
        }
        return cArr;
    }
}
