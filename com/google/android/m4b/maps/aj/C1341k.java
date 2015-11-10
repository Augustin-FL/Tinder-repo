package com.google.android.m4b.maps.aj;

import android.view.animation.LinearInterpolator;
import com.facebook.internal.NativeProtocol;
import com.google.android.m4b.maps.am.e;

/* renamed from: com.google.android.m4b.maps.aj.k */
public final class C1341k {
    private static final Integer[] f844b;
    private static final int f845c;
    private final C1330a<Integer> f846a;

    static {
        f844b = new Integer[]{Integer.valueOf(0), Integer.valueOf(164), Integer.valueOf(655), Integer.valueOf(1469), Integer.valueOf(2598), Integer.valueOf(4030), Integer.valueOf(5752), Integer.valueOf(7747), Integer.valueOf(9997), Integer.valueOf(12479), Integer.valueOf(15169), Integer.valueOf(18042), Integer.valueOf(21071), Integer.valueOf(24224), Integer.valueOf(27474), Integer.valueOf(30787), Integer.valueOf(34133), Integer.valueOf(37478), Integer.valueOf(40792), Integer.valueOf(44041), Integer.valueOf(47195), Integer.valueOf(50223), Integer.valueOf(53096), Integer.valueOf(55787), Integer.valueOf(58269), Integer.valueOf(60518), Integer.valueOf(62514), Integer.valueOf(64236), Integer.valueOf(65668), Integer.valueOf(66796), Integer.valueOf(67610), Integer.valueOf(68102), Integer.valueOf(68266), Integer.valueOf(68102), Integer.valueOf(67610), Integer.valueOf(66796), Integer.valueOf(65668), Integer.valueOf(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST)};
        f845c = 296;
    }

    public C1341k() {
        this.f846a = new C1330a(new LinearInterpolator(), f844b);
        this.f846a.setDuration((long) f845c);
    }

    public final int m1123a(e eVar) {
        long e = eVar.e();
        if (!this.f846a.hasStarted()) {
            this.f846a.start();
        }
        this.f846a.m1100b(e);
        int intValue = ((Integer) this.f846a.m1099b()).intValue();
        if (!this.f846a.hasEnded()) {
            eVar.b();
        }
        return intValue;
    }
}
