package com.google.android.m4b.maps.p021z;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.m4b.maps.al.b;
import com.google.android.m4b.maps.am.c;
import com.google.android.m4b.maps.am.e;
import com.google.android.m4b.maps.ay.C1440g;
import com.google.android.m4b.maps.bh.ab;
import com.google.android.m4b.maps.bh.ag.a;
import com.google.android.m4b.maps.bh.j;
import com.google.android.m4b.maps.bq.bv;
import com.google.android.m4b.maps.p009m.C1480a;
import com.google.android.m4b.maps.p009m.C1480a.C1483c;
import com.google.common.base.C1647e;
import com.google.common.base.C1650g;
import com.google.common.collect.C1876q;
import com.google.common.collect.ImmutableSet;
import com.tinder.views.RangeSeekBar;
import java.util.Map;
import java.util.Set;
import javax.microedition.khronos.opengles.GL10;

/* renamed from: com.google.android.m4b.maps.z.f */
public final class C1600f implements j {
    private final Map<C1483c, bv> f1842a;
    private Set<? extends C1480a> f1843b;
    private final float f1844c;
    private long f1845d;
    private int f1846e;
    private float f1847f;
    private boolean f1848g;

    public final /* synthetic */ int compareTo(Object obj) {
        j jVar = (j) obj;
        return jVar instanceof C1600f ? Float.compare(this.f1844c, ((C1600f) jVar).f1844c) : 0;
    }

    C1600f(bv bvVar) {
        this.f1842a = C1876q.m4328a();
        this.f1845d = 0;
        this.f1846e = 0;
        this.f1847f = 0.0f;
        this.f1848g = false;
        this.f1844c = (float) bvVar.f();
        m2895a(bvVar);
    }

    private C1600f(float f) {
        this.f1842a = C1876q.m4328a();
        this.f1845d = 0;
        this.f1846e = 0;
        this.f1847f = 0.0f;
        this.f1848g = false;
        this.f1844c = f;
    }

    public final boolean m2895a(bv bvVar) {
        C1650g.m3085a(((float) bvVar.f()) == this.f1844c);
        if (this.f1843b != null || ((float) bvVar.f()) != this.f1844c) {
            return false;
        }
        this.f1842a.put(bvVar.b(), bvVar);
        return true;
    }

    public final Set<? extends C1480a> m2891a() {
        if (this.f1843b == null) {
            this.f1843b = ImmutableSet.m3672a(this.f1842a.keySet());
        }
        return this.f1843b;
    }

    final C1600f m2890a(C1483c c1483c) {
        if (!this.f1842a.containsKey(c1483c)) {
            return this;
        }
        C1600f c1600f = new C1600f((float) ((bv) this.f1842a.get(c1483c)).f());
        for (bv bvVar : this.f1842a.values()) {
            if (!bvVar.b().equals(c1483c)) {
                c1600f.m2895a(bvVar);
            }
        }
        return c1600f;
    }

    public final float m2896b() {
        return this.f1844c;
    }

    private boolean m2888g() {
        return this.f1846e != 0 && this.f1847f < 1.0f;
    }

    public final boolean m2897c() {
        return m2888g() && (this.f1846e & 3) != 0;
    }

    public final float m2889a(b bVar, C1440g c1440g) {
        float l = bVar.l();
        float m = bVar.m();
        int i = this.f1846e;
        float f = this.f1847f;
        float f2 = this.f1844c;
        m = f2 > 0.0f ? C1600f.m2887a(m, 18.0f, 20.0f, 3.0f, 0.0f) : f2 < 0.0f ? C1600f.m2887a(m, 18.0f, 20.0f, -3.0f, GroundOverlayOptions.NO_DIMENSION) : 0.0f;
        m = C1600f.m2887a(l, 0.0f, 10.0f, 0.0f, m);
        float a = C1600f.m2886a(f);
        if ((i & 2) != 0) {
            m += a * 100.0f;
        } else if ((i & 1) != 0) {
            m += (1.0f - a) * 100.0f;
        }
        return m * ((float) c1440g.m1956e());
    }

    public final void m2893a(e eVar, b bVar, ab abVar, C1440g c1440g) {
        int a;
        GL10 x = eVar.x();
        x.glPushMatrix();
        float r = bVar.r() * m2889a(bVar, c1440g);
        x.glTranslatef(0.0f, 0.0f, r);
        int i = this.f1846e;
        float a2 = C1600f.m2886a(this.f1847f);
        if ((i & 4) == 0) {
            a2 = (i & 8) != 0 ? 1.0f - a2 : 1.0f;
        }
        if ((i & 16) != 0) {
            a2 = C1600f.m2887a(a2, 0.0f, 1.0f, 0.6f, 1.0f);
            a = c.a(1.0f, a2, a2, a2);
        } else {
            a = c.a(a2, a2, a2, a2);
        }
        c.a(x, a);
        a b = abVar.c().b();
        boolean z = b == a.f || b == a.g || (b == a.h && r < 0.0f);
        this.f1848g = z;
        if (this.f1848g) {
            eVar.v();
            x.glStencilOp(7680, 7680, 7680);
            x.glStencilFunc(514, RangeSeekBar.INVALID_POINTER_ID, AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        }
    }

    public final void m2894a(e eVar, ab abVar) {
        GL10 x = eVar.x();
        if (this.f1848g) {
            eVar.w();
        }
        c.a(x, -1);
        x.glPopMatrix();
    }

    public final void m2892a(int i) {
        long b = com.google.android.m4b.maps.ag.e.a().h().b();
        this.f1846e = i;
        this.f1845d = b;
        this.f1847f = 0.0f;
    }

    public final void m2898d() {
        this.f1846e = 0;
        this.f1847f = 0.0f;
    }

    public final boolean m2899e() {
        float f = 0.0f;
        float b = ((float) (com.google.android.m4b.maps.ag.e.a().h().b() - this.f1845d)) / 500.0f;
        if (b >= 0.0f) {
            f = b > 1.0f ? 1.0f : b;
        }
        this.f1847f = f;
        return m2888g();
    }

    public final Set<C1483c> m2900f() {
        return this.f1842a.keySet();
    }

    private static float m2887a(float f, float f2, float f3, float f4, float f5) {
        if (f <= f2) {
            return f4;
        }
        if (f >= f3) {
            return f5;
        }
        return f4 + (((f - f2) / (f3 - f2)) * (f5 - f4));
    }

    private static float m2886a(float f) {
        return (f * f) * (3.0f - (2.0f * f));
    }

    public final String toString() {
        return C1647e.m3072a((Object) this).m3066a("height", this.f1844c).m3068a("animationStartTimeMs", this.f1845d).m3066a("animationPosition", this.f1847f).m3067a("animationType", this.f1846e).m3069a("featureIds", this.f1843b).toString();
    }
}
