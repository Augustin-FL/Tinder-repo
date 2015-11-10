package com.mixpanel.android.p025a;

import android.graphics.Bitmap;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.tinder.views.RangeSeekBar;
import java.lang.reflect.Array;

/* renamed from: com.mixpanel.android.a.c */
public class C1992c {
    public static void m4589a(Bitmap bitmap, int i) {
        if (i >= 1) {
            int i2;
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8;
            int i9;
            int i10;
            int i11;
            int i12;
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int[] iArr = new int[(width * height)];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            int i13 = width - 1;
            int i14 = height - 1;
            int i15 = width * height;
            int i16 = (i + i) + 1;
            int[] iArr2 = new int[i15];
            int[] iArr3 = new int[i15];
            int[] iArr4 = new int[i15];
            int[] iArr5 = new int[Math.max(width, height)];
            i15 = (i16 + 1) >> 1;
            int i17 = i15 * i15;
            int[] iArr6 = new int[(i17 * AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY)];
            for (i15 = 0; i15 < i17 * AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY; i15++) {
                iArr6[i15] = i15 / i17;
            }
            int i18 = 0;
            int[][] iArr7 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{i16, 3});
            int i19 = i + 1;
            int i20 = 0;
            for (i2 = 0; i2 < height; i2++) {
                int[] iArr8;
                i17 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
                i6 = 0;
                i7 = 0;
                i8 = 0;
                i9 = 0;
                i10 = 0;
                for (i11 = -i; i11 <= i; i11++) {
                    i12 = iArr[Math.min(i13, Math.max(i11, 0)) + i18];
                    iArr8 = iArr7[i11 + i];
                    iArr8[0] = (16711680 & i12) >> 16;
                    iArr8[1] = (RangeSeekBar.ACTION_POINTER_INDEX_MASK & i12) >> 8;
                    iArr8[2] = i12 & RangeSeekBar.INVALID_POINTER_ID;
                    i12 = i19 - Math.abs(i11);
                    i9 += iArr8[0] * i12;
                    i8 += iArr8[1] * i12;
                    i7 += i12 * iArr8[2];
                    if (i11 > 0) {
                        i3 += iArr8[0];
                        i10 += iArr8[1];
                        i17 += iArr8[2];
                    } else {
                        i6 += iArr8[0];
                        i5 += iArr8[1];
                        i4 += iArr8[2];
                    }
                }
                i12 = i9;
                i9 = i8;
                i8 = i7;
                i11 = i18;
                i18 = i;
                for (i7 = 0; i7 < width; i7++) {
                    iArr2[i11] = iArr6[i12];
                    iArr3[i11] = iArr6[i9];
                    iArr4[i11] = iArr6[i8];
                    i12 -= i6;
                    i9 -= i5;
                    i8 -= i4;
                    iArr8 = iArr7[((i18 - i) + i16) % i16];
                    i6 -= iArr8[0];
                    i5 -= iArr8[1];
                    i4 -= iArr8[2];
                    if (i2 == 0) {
                        iArr5[i7] = Math.min((i7 + i) + 1, i13);
                    }
                    int i21 = iArr[iArr5[i7] + i20];
                    iArr8[0] = (16711680 & i21) >> 16;
                    iArr8[1] = (RangeSeekBar.ACTION_POINTER_INDEX_MASK & i21) >> 8;
                    iArr8[2] = i21 & RangeSeekBar.INVALID_POINTER_ID;
                    i3 += iArr8[0];
                    i10 += iArr8[1];
                    i17 += iArr8[2];
                    i12 += i3;
                    i9 += i10;
                    i8 += i17;
                    i18 = (i18 + 1) % i16;
                    iArr8 = iArr7[i18 % i16];
                    i6 += iArr8[0];
                    i5 += iArr8[1];
                    i4 += iArr8[2];
                    i3 -= iArr8[0];
                    i10 -= iArr8[1];
                    i17 -= iArr8[2];
                    i11++;
                }
                i18 = i11;
                i20 += width;
            }
            for (i7 = 0; i7 < width; i7++) {
                i10 = 0;
                i17 = (-i) * width;
                i4 = 0;
                i5 = 0;
                i6 = 0;
                i18 = 0;
                i12 = -i;
                i11 = 0;
                i8 = 0;
                i9 = 0;
                i3 = 0;
                while (i12 <= i) {
                    i2 = Math.max(0, i17) + i7;
                    int[] iArr9 = iArr7[i12 + i];
                    iArr9[0] = iArr2[i2];
                    iArr9[1] = iArr3[i2];
                    iArr9[2] = iArr4[i2];
                    int abs = i19 - Math.abs(i12);
                    i20 = (iArr2[i2] * abs) + i9;
                    i9 = (iArr3[i2] * abs) + i8;
                    i8 = (iArr4[i2] * abs) + i11;
                    if (i12 > 0) {
                        i4 += iArr9[0];
                        i3 += iArr9[1];
                        i10 += iArr9[2];
                    } else {
                        i18 += iArr9[0];
                        i6 += iArr9[1];
                        i5 += iArr9[2];
                    }
                    if (i12 < i14) {
                        i17 += width;
                    }
                    i12++;
                    i11 = i8;
                    i8 = i9;
                    i9 = i20;
                }
                i12 = i8;
                i20 = i9;
                i9 = i11;
                i11 = i7;
                i17 = i10;
                i10 = i3;
                i3 = i4;
                i4 = i5;
                i5 = i6;
                i6 = i18;
                i18 = i;
                for (i8 = 0; i8 < height; i8++) {
                    iArr[i11] = ((ViewCompat.MEASURED_STATE_MASK | (iArr6[i20] << 16)) | (iArr6[i12] << 8)) | iArr6[i9];
                    i20 -= i6;
                    i12 -= i5;
                    i9 -= i4;
                    int[] iArr10 = iArr7[((i18 - i) + i16) % i16];
                    i6 -= iArr10[0];
                    i5 -= iArr10[1];
                    i4 -= iArr10[2];
                    if (i7 == 0) {
                        iArr5[i8] = Math.min(i8 + i19, i14) * width;
                    }
                    i13 = iArr5[i8] + i7;
                    iArr10[0] = iArr2[i13];
                    iArr10[1] = iArr3[i13];
                    iArr10[2] = iArr4[i13];
                    i3 += iArr10[0];
                    i10 += iArr10[1];
                    i17 += iArr10[2];
                    i20 += i3;
                    i12 += i10;
                    i9 += i17;
                    i18 = (i18 + 1) % i16;
                    iArr10 = iArr7[i18];
                    i6 += iArr10[0];
                    i5 += iArr10[1];
                    i4 += iArr10[2];
                    i3 -= iArr10[0];
                    i10 -= iArr10[1];
                    i17 -= iArr10[2];
                    i11 += width;
                }
            }
            bitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        }
    }
}
