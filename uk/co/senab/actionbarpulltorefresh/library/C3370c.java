package uk.co.senab.actionbarpulltorefresh.library;

import com.google.android.gms.location.LocationStatusCodes;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3373a;

/* renamed from: uk.co.senab.actionbarpulltorefresh.library.c */
public final class C3370c {
    private static final int f7358h;
    C3367a f7359a;
    int f7360b;
    C2359b f7361c;
    float f7362d;
    boolean f7363e;
    int f7364f;
    boolean f7365g;

    /* renamed from: uk.co.senab.actionbarpulltorefresh.library.c.a */
    public static class C3369a {
        final C3370c f7357a;

        public C3369a() {
            this.f7357a = new C3370c();
        }

        public C3369a m10411a(int i) {
            this.f7357a.f7360b = i;
            return this;
        }

        public C3369a m10412a(C2359b c2359b) {
            this.f7357a.f7361c = c2359b;
            return this;
        }

        public C3369a m10410a(float f) {
            this.f7357a.f7362d = f;
            return this;
        }

        public C3370c m10413a() {
            return this.f7357a;
        }
    }

    static {
        f7358h = C3373a.default_header;
    }

    public static C3369a m10414a() {
        return new C3369a();
    }

    C3370c() {
        this.f7359a = null;
        this.f7360b = f7358h;
        this.f7361c = null;
        this.f7362d = 0.5f;
        this.f7363e = false;
        this.f7364f = LocationStatusCodes.GEOFENCE_NOT_AVAILABLE;
        this.f7365g = true;
    }
}
