package com.google.android.m4b.maps.p011o;

import android.graphics.Bitmap;
import android.view.View;
import com.google.android.m4b.maps.ah.C1327d;
import com.google.android.m4b.maps.bq.a;
import com.google.android.m4b.maps.bq.k;
import com.google.android.m4b.maps.by.d;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.m4b.maps.o.r */
public final class C1519r extends a {

    /* renamed from: com.google.android.m4b.maps.o.r.1 */
    class C15181 implements Runnable {
        private /* synthetic */ d f1571a;
        private /* synthetic */ Bitmap f1572b;
        private /* synthetic */ C1519r f1573c;

        C15181(C1519r c1519r, d dVar, Bitmap bitmap) {
            this.f1573c = c1519r;
            this.f1571a = dVar;
            this.f1572b = bitmap;
        }

        public final void run() {
            this.f1573c.a(this.f1571a, this.f1572b);
        }
    }

    public C1519r(View view, k kVar, boolean z, Executor executor) {
        super(view, (View) kVar, z, executor);
    }

    protected final void m2556a(Bitmap bitmap, d dVar) {
        this.b.execute(new C15181(this, dVar, C1327d.m1078a(((k) this.a).a(bitmap))));
    }
}
