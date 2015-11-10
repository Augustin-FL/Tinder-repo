package com.google.android.m4b.maps.p021z;

import com.google.android.m4b.maps.ay.C1420n;
import com.google.android.m4b.maps.ay.C1440g;
import com.google.android.m4b.maps.ay.C1448m;
import com.google.android.m4b.maps.ay.ak;
import com.google.android.m4b.maps.ay.au;
import com.google.android.m4b.maps.ay.ax;
import com.google.android.m4b.maps.ay.ay;
import com.google.common.collect.C1872p;
import java.util.List;

/* renamed from: com.google.android.m4b.maps.z.g */
public final class C1602g implements ax {
    private final ax f1850a;

    /* renamed from: com.google.android.m4b.maps.z.g.a */
    public static class C1601a {
        private final List<ak> f1849a;

        public C1601a() {
            this.f1849a = C1872p.m4309a();
        }

        public final void m2902a(au auVar) {
            this.f1849a.add(auVar.m1691a());
        }

        public final C1602g m2901a() {
            return new C1602g(this.f1849a);
        }
    }

    public C1602g(List<ak> list) {
        int i = 0;
        for (ak a : list) {
            i = a.m1570a() + i;
        }
        ax ayVar = new ay(i);
        for (ak a2 : list) {
            a2.m1573a(ayVar);
        }
        this.f1850a = ayVar;
    }

    public final C1448m m2903a() {
        return this.f1850a.m1724a();
    }

    public final boolean m2904a(C1440g c1440g) {
        return this.f1850a.m1725a(c1440g);
    }

    public final boolean m2905a(C1420n c1420n) {
        return this.f1850a.m1726a(c1420n);
    }
}
