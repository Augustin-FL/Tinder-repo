package com.squareup.okhttp.internal.spdy;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import com.google.android.gms.location.places.Place;
import com.tinder.views.RangeSeekBar;
import com.viewpagerindicator.C3169d.C3168f;
import org.apache.http.HttpStatus;

/* renamed from: com.squareup.okhttp.internal.spdy.f */
class C2173f {
    private static final int[] f3428a;
    private static final byte[] f3429b;
    private static final C2173f f3430c;
    private final C2172a f3431d;

    /* renamed from: com.squareup.okhttp.internal.spdy.f.a */
    private static final class C2172a {
        private final C2172a[] f3425a;
        private final int f3426b;
        private final int f3427c;

        C2172a() {
            this.f3425a = new C2172a[AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY];
            this.f3426b = 0;
            this.f3427c = 0;
        }

        C2172a(int i, int i2) {
            this.f3425a = null;
            this.f3426b = i;
            int i3 = i2 & 7;
            if (i3 == 0) {
                i3 = 8;
            }
            this.f3427c = i3;
        }
    }

    static {
        f3428a = new int[]{8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, Place.TYPE_POSTAL_CODE_PREFIX, Place.TYPE_POSTAL_TOWN, 4090, 8185, 21, 248, 2042, Place.TYPE_PREMISE, Place.TYPE_ROOM, 249, 2043, Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, Place.TYPE_ROUTE, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, HttpStatus.SC_SWITCHING_PROTOCOLS, HttpStatus.SC_PROCESSING, C3168f.Theme_radioButtonStyle, C3168f.Theme_ratingBarStyle, C3168f.Theme_spinnerStyle, C3168f.Theme_switchStyle, 107, 108, 109, 110, 111, 112, 113, 114, 252, 115, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};
        f3429b = new byte[]{(byte) 13, (byte) 23, (byte) 28, (byte) 28, (byte) 28, (byte) 28, (byte) 28, (byte) 28, (byte) 28, (byte) 24, (byte) 30, (byte) 28, (byte) 28, (byte) 30, (byte) 28, (byte) 28, (byte) 28, (byte) 28, (byte) 28, (byte) 28, (byte) 28, (byte) 28, (byte) 30, (byte) 28, (byte) 28, (byte) 28, (byte) 28, (byte) 28, (byte) 28, (byte) 28, (byte) 28, (byte) 28, (byte) 6, (byte) 10, (byte) 10, (byte) 12, (byte) 13, (byte) 6, (byte) 8, (byte) 11, (byte) 10, (byte) 10, (byte) 8, (byte) 11, (byte) 8, (byte) 6, (byte) 6, (byte) 6, (byte) 5, (byte) 5, (byte) 5, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 7, (byte) 8, (byte) 15, (byte) 6, (byte) 12, (byte) 10, (byte) 13, (byte) 6, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 8, (byte) 7, (byte) 8, (byte) 13, (byte) 19, (byte) 13, (byte) 14, (byte) 6, (byte) 15, (byte) 5, (byte) 6, (byte) 5, (byte) 6, (byte) 5, (byte) 6, (byte) 6, (byte) 6, (byte) 5, (byte) 7, (byte) 7, (byte) 6, (byte) 6, (byte) 6, (byte) 5, (byte) 6, (byte) 7, (byte) 6, (byte) 5, (byte) 5, (byte) 6, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 15, (byte) 11, (byte) 14, (byte) 13, (byte) 28, (byte) 20, (byte) 22, (byte) 20, (byte) 20, (byte) 22, (byte) 22, (byte) 22, (byte) 23, (byte) 22, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 24, (byte) 23, (byte) 24, (byte) 24, (byte) 22, (byte) 23, (byte) 24, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 21, (byte) 22, (byte) 23, (byte) 22, (byte) 23, (byte) 23, (byte) 24, (byte) 22, (byte) 21, (byte) 20, (byte) 22, (byte) 22, (byte) 23, (byte) 23, (byte) 21, (byte) 23, (byte) 22, (byte) 22, (byte) 24, (byte) 21, (byte) 22, (byte) 23, (byte) 23, (byte) 21, (byte) 21, (byte) 22, (byte) 21, (byte) 23, (byte) 22, (byte) 23, (byte) 23, (byte) 20, (byte) 22, (byte) 22, (byte) 22, (byte) 23, (byte) 22, (byte) 22, (byte) 23, (byte) 26, (byte) 26, (byte) 20, (byte) 19, (byte) 22, (byte) 23, (byte) 22, (byte) 25, (byte) 26, (byte) 26, (byte) 26, (byte) 27, (byte) 27, (byte) 26, (byte) 24, (byte) 25, (byte) 19, (byte) 21, (byte) 26, (byte) 27, (byte) 27, (byte) 26, (byte) 27, (byte) 24, (byte) 21, (byte) 21, (byte) 26, (byte) 26, (byte) 28, (byte) 27, (byte) 27, (byte) 27, (byte) 20, (byte) 24, (byte) 20, (byte) 21, (byte) 22, (byte) 21, (byte) 21, (byte) 23, (byte) 22, (byte) 22, (byte) 25, (byte) 25, (byte) 24, (byte) 24, (byte) 26, (byte) 23, (byte) 26, (byte) 27, (byte) 26, (byte) 26, (byte) 27, (byte) 27, (byte) 27, (byte) 27, (byte) 27, (byte) 28, (byte) 27, (byte) 27, (byte) 27, (byte) 27, (byte) 27, (byte) 26};
        f3430c = new C2173f();
    }

    public static C2173f m5474a() {
        return f3430c;
    }

    private C2173f() {
        this.f3431d = new C2172a();
        m5476b();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    byte[] m5477a(byte[] r7) throws java.io.IOException {
        /*
        r6 = this;
        r0 = 0;
        r4 = new java.io.ByteArrayOutputStream;
        r4.<init>();
        r1 = r6.f3431d;
        r2 = r0;
        r3 = r1;
        r1 = r0;
    L_0x000b:
        r5 = r7.length;
        if (r0 >= r5) goto L_0x0050;
    L_0x000e:
        r5 = r7[r0];
        r5 = r5 & 255;
        r2 = r2 << 8;
        r2 = r2 | r5;
        r1 = r1 + 8;
    L_0x0017:
        r5 = 8;
        if (r1 < r5) goto L_0x003f;
    L_0x001b:
        r5 = r1 + -8;
        r5 = r2 >>> r5;
        r5 = r5 & 255;
        r3 = r3.f3425a;
        r3 = r3[r5];
        r5 = r3.f3425a;
        if (r5 != 0) goto L_0x003c;
    L_0x002d:
        r5 = r3.f3426b;
        r4.write(r5);
        r3 = r3.f3427c;
        r1 = r1 - r3;
        r3 = r6.f3431d;
        goto L_0x0017;
    L_0x003c:
        r1 = r1 + -8;
        goto L_0x0017;
    L_0x003f:
        r0 = r0 + 1;
        goto L_0x000b;
    L_0x0042:
        r3 = r0.f3426b;
        r4.write(r3);
        r0 = r0.f3427c;
        r1 = r1 - r0;
        r3 = r6.f3431d;
    L_0x0050:
        if (r1 <= 0) goto L_0x006a;
    L_0x0052:
        r0 = 8 - r1;
        r0 = r2 << r0;
        r0 = r0 & 255;
        r3 = r3.f3425a;
        r0 = r3[r0];
        r3 = r0.f3425a;
        if (r3 != 0) goto L_0x006a;
    L_0x0064:
        r3 = r0.f3427c;
        if (r3 <= r1) goto L_0x0042;
    L_0x006a:
        r0 = r4.toByteArray();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.spdy.f.a(byte[]):byte[]");
    }

    private void m5476b() {
        for (int i = 0; i < f3429b.length; i++) {
            m5475a(i, f3428a[i], f3429b[i]);
        }
    }

    private void m5475a(int i, int i2, byte b) {
        int i3;
        C2172a c2172a = new C2172a(i, b);
        C2172a c2172a2 = this.f3431d;
        while (b > 8) {
            b = (byte) (b - 8);
            i3 = (i2 >>> b) & RangeSeekBar.INVALID_POINTER_ID;
            if (c2172a2.f3425a == null) {
                throw new IllegalStateException("invalid dictionary: prefix not unique");
            }
            if (c2172a2.f3425a[i3] == null) {
                c2172a2.f3425a[i3] = new C2172a();
            }
            c2172a2 = c2172a2.f3425a[i3];
        }
        i3 = 8 - b;
        int i4 = (i2 << i3) & RangeSeekBar.INVALID_POINTER_ID;
        int i5 = 1 << i3;
        for (i3 = i4; i3 < i4 + i5; i3++) {
            c2172a2.f3425a[i3] = c2172a;
        }
    }
}
