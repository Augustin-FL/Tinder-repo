package com.google.android.gms.internal;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.tinder.views.RangeSeekBar;

public class zzro {
    private final byte[] zzbbN;
    private int zzbbO;
    private int zzbbP;

    public zzro(byte[] bArr) {
        int i;
        this.zzbbN = new byte[AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY];
        for (i = 0; i < AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY; i++) {
            this.zzbbN[i] = (byte) i;
        }
        i = 0;
        for (int i2 = 0; i2 < AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY; i2++) {
            i = ((i + this.zzbbN[i2]) + bArr[i2 % bArr.length]) & RangeSeekBar.INVALID_POINTER_ID;
            byte b = this.zzbbN[i2];
            this.zzbbN[i2] = this.zzbbN[i];
            this.zzbbN[i] = b;
        }
        this.zzbbO = 0;
        this.zzbbP = 0;
    }

    public void zzy(byte[] bArr) {
        int i = this.zzbbO;
        int i2 = this.zzbbP;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & RangeSeekBar.INVALID_POINTER_ID;
            i2 = (i2 + this.zzbbN[i]) & RangeSeekBar.INVALID_POINTER_ID;
            byte b = this.zzbbN[i];
            this.zzbbN[i] = this.zzbbN[i2];
            this.zzbbN[i2] = b;
            bArr[i3] = (byte) (bArr[i3] ^ this.zzbbN[(this.zzbbN[i] + this.zzbbN[i2]) & RangeSeekBar.INVALID_POINTER_ID]);
        }
        this.zzbbO = i;
        this.zzbbP = i2;
    }
}
