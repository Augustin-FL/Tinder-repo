package com.google.android.m4b.maps.aj;

import android.view.animation.LinearInterpolator;
import com.google.android.m4b.maps.ay.C1439f;
import com.google.android.m4b.maps.ay.C1440g;
import com.google.common.base.C1647e;
import com.google.common.base.C1650g;

/* renamed from: com.google.android.m4b.maps.aj.h */
public class C1339h {
    private final C1340j f840a;
    private final C1337f f841b;
    private final C1338g f842c;
    private final C1338g f843d;

    public C1339h() {
        this.f840a = new C1340j(new C1333d(0.99f));
        this.f842c = new C1338g(new C1333d(0.99f));
        this.f841b = new C1337f(new C1331b(1.0f));
        this.f840a.setDuration(5000);
        this.f841b.setDuration(5000);
        this.f842c.setDuration(5000);
        this.f843d = new C1338g(new LinearInterpolator());
        this.f843d.m1114a(0);
        this.f843d.m1114a(2);
        this.f843d.setDuration(1000);
        this.f843d.setRepeatCount(-1);
        this.f843d.start();
    }

    public synchronized boolean m1117a(C1439f c1439f) {
        boolean z;
        if (this.f840a.isInitialized()) {
            C1650g.m3080a((Object) c1439f);
            c1439f.m1908a((C1440g) this.f840a.m1099b(), this.f841b.m1112b(), this.f842c.m1116b());
            c1439f.m1905a((float) this.f843d.m1116b());
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public synchronized void m1118b(C1439f c1439f) {
        if (!(this.f840a.isInitialized() && C1647e.m3074a(c1439f.m1904a(), this.f840a.m1095a()))) {
            this.f840a.m1103d(c1439f.m1904a());
            this.f840a.start();
        }
        if (!(this.f841b.isInitialized() && c1439f.m1910b() == this.f841b.m1110a())) {
            this.f841b.m1111a(c1439f.m1910b());
            this.f841b.start();
        }
        if (!(this.f842c.isInitialized() && c1439f.m1911c() == this.f842c.m1113a())) {
            this.f842c.m1114a(c1439f.m1911c());
            this.f842c.start();
        }
    }
}
