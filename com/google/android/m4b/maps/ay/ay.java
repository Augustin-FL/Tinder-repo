package com.google.android.m4b.maps.ay;

import android.support.v7.widget.RecyclerView.SmoothScroller.Action;
import com.google.common.collect.C1872p;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public final class ay implements ax {
    private static C1448m f1168c;
    private List<ax> f1169a;
    private C1448m f1170b;

    static {
        C1440g c1440g = new C1440g(Action.UNDEFINED_DURATION, Action.UNDEFINED_DURATION);
        f1168c = new C1448m(c1440g, c1440g);
    }

    public ay() {
        this.f1169a = C1872p.m4309a();
        this.f1170b = f1168c;
    }

    public ay(int i) {
        this.f1169a = C1872p.m4321c(i);
        this.f1170b = f1168c;
    }

    public ay(ax... axVarArr) {
        this(Arrays.asList(axVarArr));
    }

    private ay(Collection<? extends ax> collection) {
        this(collection.size());
        for (ax a : collection) {
            m1728a(a);
        }
    }

    public final void m1728a(ax axVar) {
        C1448m a = axVar.m1724a();
        if (a != f1168c) {
            if (this.f1170b == f1168c) {
                this.f1170b = new C1448m(C1440g.m1925a(a.f1297a), C1440g.m1925a(a.f1298b));
            } else {
                this.f1170b.m2045a(a);
            }
            this.f1169a.add(axVar);
        }
    }

    public final C1448m m1727a() {
        return this.f1170b;
    }

    public final boolean m1729a(C1440g c1440g) {
        if (!this.f1170b.m2046a(c1440g)) {
            return false;
        }
        for (int i = 0; i < this.f1169a.size(); i++) {
            if (((ax) this.f1169a.get(i)).m1725a(c1440g)) {
                return true;
            }
        }
        return false;
    }

    public final boolean m1730a(C1420n c1420n) {
        if (!this.f1170b.m2047a(c1420n.m1747a())) {
            return false;
        }
        for (int i = 0; i < this.f1169a.size(); i++) {
            if (((ax) this.f1169a.get(i)).m1726a(c1420n)) {
                return true;
            }
        }
        return false;
    }
}
