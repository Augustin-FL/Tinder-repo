package com.google.android.m4b.maps.p011o;

import android.content.Context;
import com.google.android.m4b.maps.C1477h.C1474g;
import com.google.android.m4b.maps.ag.h;
import com.google.android.m4b.maps.ag.q;
import com.google.android.m4b.maps.ay.ah;
import com.google.android.m4b.maps.bh.p;
import com.google.android.m4b.maps.bq.bg;
import com.google.android.m4b.maps.bq.bg.a;
import com.google.android.m4b.maps.bq.c;
import com.google.android.m4b.maps.bq.m;
import com.google.android.m4b.maps.p010n.C1490c;
import com.google.android.m4b.maps.p013q.C1555g;

/* renamed from: com.google.android.m4b.maps.o.f */
public final class C1498f {
    private static boolean f1489a;

    /* renamed from: com.google.android.m4b.maps.o.f.1 */
    static class C14971 implements a {
        C14971() {
        }

        public final void m2392a() {
            p.e();
        }
    }

    public static synchronized void m2393a(Context context, m mVar) {
        synchronized (C1498f.class) {
            if (!f1489a) {
                f1489a = true;
                C1490c c1490c = new C1490c(context);
                ah[] ahVarArr = new ah[]{ah.f1033a, ah.f1036d, ah.f1038f, ah.f1037e, ah.f1047o, ah.f1046n};
                h a = mVar.a();
                p.a(context, c.a(), ahVarArr, context.getPackageName(), C1474g.dav_k2, c1490c, a);
                q.a().b();
                bg bgVar = new bg(mVar, context.getSharedPreferences("MapviewInitializerPreferences", 0), new C14971());
                a.a(bgVar);
                bgVar.a(C1555g.m2744b().m2726a());
            }
        }
    }
}
