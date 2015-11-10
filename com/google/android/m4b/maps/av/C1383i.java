package com.google.android.m4b.maps.av;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.m4b.maps.ag.e;
import com.google.android.m4b.maps.ag.r;
import com.google.android.m4b.maps.av.C1376e.C1375a;
import com.google.common.collect.C1872p;
import com.tinder.views.RangeSeekBar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.google.android.m4b.maps.av.i */
public final class C1383i {
    private float f949A;
    private float f950B;
    private float f951C;
    private boolean f952D;
    private boolean f953E;
    private boolean f954F;
    private boolean f955G;
    private C1380g f956H;
    private Context f957a;
    private MotionEvent f958b;
    private MotionEvent f959c;
    private final List<C1376e> f960d;
    private final List<C1376e> f961e;
    private final C1376e f962f;
    private final C1376e f963g;
    private final C1376e f964h;
    private final LinkedList<C1367h> f965i;
    private long f966j;
    private float f967k;
    private float f968l;
    private float f969m;
    private float f970n;
    private float f971o;
    private float f972p;
    private float f973q;
    private float f974r;
    private float f975s;
    private float f976t;
    private float f977u;
    private float f978v;
    private float f979w;
    private float f980x;
    private float f981y;
    private float f982z;

    /* renamed from: com.google.android.m4b.maps.av.i.b */
    public interface C1377b extends OnDoubleTapListener, OnGestureListener {
        boolean m1334a(C1383i c1383i);

        boolean m1335a(C1383i c1383i, boolean z);

        boolean m1336b(C1383i c1383i);

        boolean m1337b(C1383i c1383i, boolean z);

        void m1338c(C1383i c1383i);

        void m1339c(C1383i c1383i, boolean z);

        boolean m1340d(C1383i c1383i);

        boolean m1341e(C1383i c1383i);

        void m1342f(C1383i c1383i);

        boolean m1343g(C1383i c1383i);

        boolean m1344h(C1383i c1383i);

        void m1345i(C1383i c1383i);
    }

    /* renamed from: com.google.android.m4b.maps.av.i.1 */
    static /* synthetic */ class C13811 {
        static final /* synthetic */ int[] f948a;

        static {
            f948a = new int[C1375a.values().length];
            try {
                f948a[C1375a.NO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f948a[C1375a.MAYBE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f948a[C1375a.YES.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* renamed from: com.google.android.m4b.maps.av.i.a */
    public interface C1382a extends OnDoubleTapListener, OnGestureListener {
        boolean m1368a(C1369j c1369j);

        boolean m1369a(C1371l c1371l);

        boolean m1370a(C1373p c1373p);
    }

    public C1383i(Context context, C1377b c1377b) {
        this.f960d = C1872p.m4309a();
        this.f961e = C1872p.m4309a();
        this.f965i = new LinkedList();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f957a = context;
        this.f949A = (float) viewConfiguration.getScaledEdgeSlop();
        List list = this.f960d;
        C1376e c1389q = new C1389q(c1377b);
        this.f963g = c1389q;
        list.add(c1389q);
        if (e.a().k()) {
            list = this.f960d;
            c1389q = new C1384k(c1377b);
            this.f964h = c1389q;
            list.add(c1389q);
            r.a("MD", "T");
        } else {
            list = this.f960d;
            c1389q = new C1388o(c1377b);
            this.f964h = c1389q;
            list.add(c1389q);
            r.a("MD", "F");
        }
        list = this.f960d;
        c1389q = new C1385m(c1377b);
        this.f962f = c1389q;
        list.add(c1389q);
        this.f960d.add(new C1390s(c1377b));
        this.f956H = new C1380g(context, c1377b);
        this.f956H.m1366a(true);
        this.f956H.m1365a((OnDoubleTapListener) c1377b);
    }

    public final boolean m1379a(MotionEvent motionEvent) {
        int i = 0;
        int action = motionEvent.getAction();
        int i2 = (RangeSeekBar.ACTION_POINTER_INDEX_MASK & action) >> 8;
        int i3;
        if (this.f955G) {
            boolean z;
            if (this.f961e.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                switch (action) {
                    case C3374b.SmoothProgressBar_spb_color /*1*/:
                    case C3374b.SmoothProgressBar_spb_progressiveStart_speed /*6*/:
                    case 262:
                        m1375b(motionEvent);
                        if (i2 == 0) {
                            i = motionEvent.getPointerCount() - 1;
                        }
                        this.f967k = motionEvent.getX(i);
                        this.f968l = motionEvent.getY(i);
                        if (!this.f952D) {
                            m1376g();
                        }
                        m1377h();
                        break;
                    case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                        m1375b(motionEvent);
                        m1372a(this.f959c, null);
                        if (this.f981y / this.f982z > 0.67f) {
                            i3 = 0;
                            for (C1376e e : this.f961e) {
                                i3 = e.m1332e(this) | i3;
                            }
                            if (i3 != 0) {
                                this.f958b = MotionEvent.obtain(motionEvent);
                                break;
                            }
                        }
                        break;
                    case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                        if (!this.f952D) {
                            m1376g();
                        }
                        m1377h();
                        break;
                    default:
                        break;
                }
            }
            m1372a(MotionEvent.obtain(motionEvent), null);
        } else if (action == 5 || action == 261 || action == 0) {
            DisplayMetrics displayMetrics = this.f957a.getResources().getDisplayMetrics();
            this.f950B = ((float) displayMetrics.widthPixels) - this.f949A;
            this.f951C = ((float) displayMetrics.heightPixels) - this.f949A;
            m1377h();
            this.f958b = MotionEvent.obtain(motionEvent);
            m1375b(motionEvent);
            r1 = this.f949A;
            r4 = this.f950B;
            r5 = this.f951C;
            r3 = motionEvent.getRawX();
            r6 = motionEvent.getRawY();
            r7 = C1383i.m1371a(motionEvent, motionEvent.getPointerCount() - 1);
            r8 = C1383i.m1374b(motionEvent, motionEvent.getPointerCount() - 1);
            action = (r3 < r1 || r6 < r1 || r3 > r4 || r6 > r5) ? true : 0;
            if (r7 < r1 || r8 < r1 || r7 > r4 || r8 > r5) {
                i3 = true;
            } else {
                i3 = 0;
            }
            if (action != 0 && i3 != 0) {
                this.f967k = GroundOverlayOptions.NO_DIMENSION;
                this.f968l = GroundOverlayOptions.NO_DIMENSION;
                this.f952D = true;
            } else if (action != 0) {
                this.f967k = motionEvent.getX(motionEvent.getPointerCount() - 1);
                this.f968l = motionEvent.getY(motionEvent.getPointerCount() - 1);
                this.f952D = true;
            } else if (i3 != 0) {
                this.f967k = motionEvent.getX(0);
                this.f968l = motionEvent.getY(0);
                this.f952D = true;
            } else {
                this.f955G = true;
            }
        } else if (action == 2 && this.f952D) {
            r1 = this.f949A;
            r4 = this.f950B;
            r5 = this.f951C;
            r3 = motionEvent.getRawX();
            r6 = motionEvent.getRawY();
            r7 = C1383i.m1371a(motionEvent, motionEvent.getPointerCount() - 1);
            r8 = C1383i.m1374b(motionEvent, motionEvent.getPointerCount() - 1);
            action = (r3 < r1 || r6 < r1 || r3 > r4 || r6 > r5) ? true : 0;
            if (r7 < r1 || r8 < r1 || r7 > r4 || r8 > r5) {
                i3 = true;
            } else {
                i3 = 0;
            }
            if (action != 0 && i3 != 0) {
                this.f967k = GroundOverlayOptions.NO_DIMENSION;
                this.f968l = GroundOverlayOptions.NO_DIMENSION;
            } else if (action != 0) {
                this.f967k = motionEvent.getX(motionEvent.getPointerCount() - 1);
                this.f968l = motionEvent.getY(motionEvent.getPointerCount() - 1);
            } else if (i3 != 0) {
                this.f967k = motionEvent.getX(0);
                this.f968l = motionEvent.getY(0);
            } else {
                this.f952D = false;
                this.f955G = true;
            }
        } else if ((action == 6 || action == 262 || action == 1) && this.f952D) {
            if (i2 == 0) {
                i = motionEvent.getPointerCount() - 1;
            }
            this.f967k = motionEvent.getX(i);
            this.f968l = motionEvent.getY(i);
        }
        this.f956H.m1367a(motionEvent);
        return true;
    }

    private static boolean m1373a(C1376e c1376e) {
        return c1376e != null && c1376e.m1324a();
    }

    private void m1376g() {
        for (C1376e c : this.f961e) {
            c.m1328c(this);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1372a(android.view.MotionEvent r11, java.lang.StringBuilder r12) {
        /*
        r10 = this;
        r5 = 1;
        r8 = 0;
        r1 = r11.getAction();
        r0 = r10.f965i;
        r0 = r0.isEmpty();
        if (r0 == 0) goto L_0x0014;
    L_0x000e:
        r2 = r11.getEventTime();
        r10.f966j = r2;
    L_0x0014:
        r0 = r10.f965i;
        r2 = new com.google.android.m4b.maps.av.a;
        r2.<init>(r11);
        r0.addLast(r2);
        r0 = r10.f965i;
        r0 = r0.size();
        r2 = 20;
        if (r0 <= r2) goto L_0x0033;
    L_0x0028:
        r0 = r10.f965i;
        r0 = r0.removeFirst();
        r0 = (com.google.android.m4b.maps.av.C1367h) r0;
        r0.m1293e();
    L_0x0033:
        r0 = r10.f965i;
        r0 = r0.getFirst();
        r0 = (com.google.android.m4b.maps.av.C1367h) r0;
        r2 = r0.m1288a();
        r0 = r10.f965i;
        r0 = r0.getLast();
        r0 = (com.google.android.m4b.maps.av.C1367h) r0;
        r6 = r0.m1288a();
        r2 = r6 - r2;
        r6 = 250; // 0xfa float:3.5E-43 double:1.235E-321;
        r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r0 < 0) goto L_0x006b;
    L_0x0053:
        r0 = r5;
    L_0x0054:
        if (r0 == 0) goto L_0x006d;
    L_0x0056:
        r0 = r10.f965i;
        r0 = r0.size();
        r2 = 3;
        if (r0 <= r2) goto L_0x006d;
    L_0x005f:
        r0 = r10.f965i;
        r0 = r0.removeFirst();
        r0 = (com.google.android.m4b.maps.av.C1367h) r0;
        r0.m1293e();
        goto L_0x0033;
    L_0x006b:
        r0 = r8;
        goto L_0x0054;
    L_0x006d:
        switch(r1) {
            case 1: goto L_0x0071;
            case 3: goto L_0x00ac;
            case 6: goto L_0x0071;
            case 262: goto L_0x0071;
            default: goto L_0x0070;
        };
    L_0x0070:
        r5 = r8;
    L_0x0071:
        r0 = r10.f955G;
        if (r0 == 0) goto L_0x00a4;
    L_0x0075:
        r0 = r10.f960d;
        r0 = r0.iterator();
    L_0x007b:
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x00a4;
    L_0x0081:
        r1 = r0.next();
        r1 = (com.google.android.m4b.maps.av.C1376e) r1;
        r2 = r1.m1324a();
        if (r2 != 0) goto L_0x007b;
    L_0x008d:
        r9 = com.google.android.m4b.maps.av.C1383i.C13811.f948a;
        r2 = r10.f966j;
        r4 = r10.f965i;
        r6 = r10.f961e;
        r7 = 0;
        r2 = r1.m1323a(r2, r4, r5, r6, r7);
        r2 = r2.ordinal();
        r2 = r9[r2];
        switch(r2) {
            case 1: goto L_0x007b;
            case 2: goto L_0x00a4;
            case 3: goto L_0x00af;
            default: goto L_0x00a3;
        };
    L_0x00a3:
        goto L_0x007b;
    L_0x00a4:
        if (r5 == 0) goto L_0x00ab;
    L_0x00a6:
        r10.m1376g();
        r10.f955G = r8;
    L_0x00ab:
        return;
    L_0x00ac:
        r10.f955G = r8;
        goto L_0x0070;
    L_0x00af:
        r2 = r1.m1325a(r10);
        if (r2 == 0) goto L_0x007b;
    L_0x00b5:
        r2 = r10.f961e;
        r2.add(r1);
        goto L_0x007b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.m4b.maps.av.i.a(android.view.MotionEvent, java.lang.StringBuilder):void");
    }

    private static float m1371a(MotionEvent motionEvent, int i) {
        return (motionEvent.getRawX() - motionEvent.getX()) + motionEvent.getX(i);
    }

    private static float m1374b(MotionEvent motionEvent, int i) {
        return (motionEvent.getRawY() - motionEvent.getY()) + motionEvent.getY(i);
    }

    private void m1375b(MotionEvent motionEvent) {
        this.f959c = MotionEvent.obtain(motionEvent);
        this.f974r = GroundOverlayOptions.NO_DIMENSION;
        this.f975s = GroundOverlayOptions.NO_DIMENSION;
        this.f978v = GroundOverlayOptions.NO_DIMENSION;
        this.f979w = 0.0f;
        this.f953E = false;
        this.f954F = false;
        MotionEvent motionEvent2 = this.f958b;
        float x = motionEvent2.getX(0);
        float y = motionEvent2.getY(0);
        float x2 = motionEvent2.getX(motionEvent2.getPointerCount() - 1);
        float y2 = motionEvent2.getY(motionEvent2.getPointerCount() - 1);
        float x3 = motionEvent.getX(0);
        float y3 = motionEvent.getY(0);
        x2 -= x;
        y2 -= y;
        float x4 = motionEvent.getX(motionEvent.getPointerCount() - 1) - x3;
        float y4 = motionEvent.getY(motionEvent.getPointerCount() - 1) - y3;
        this.f970n = x2;
        this.f971o = y2;
        this.f972p = x4;
        this.f973q = y4;
        this.f976t = y;
        this.f977u = y3;
        this.f967k = (x4 * 0.5f) + x3;
        this.f968l = (y4 * 0.5f) + y3;
        this.f969m = x + (x2 * 0.5f);
        motionEvent.getEventTime();
        motionEvent2.getEventTime();
        this.f981y = motionEvent.getPressure(0) + motionEvent.getPressure(motionEvent.getPointerCount() - 1);
        this.f982z = motionEvent2.getPressure(motionEvent2.getPointerCount() - 1) + motionEvent2.getPressure(0);
    }

    private void m1377h() {
        this.f958b = null;
        this.f959c = null;
        this.f952D = false;
        this.f955G = false;
        this.f961e.clear();
        Iterator it = this.f965i.iterator();
        while (it.hasNext()) {
            ((C1367h) it.next()).m1293e();
        }
        this.f965i.clear();
        for (C1376e c1376e : this.f960d) {
            if (c1376e.m1324a()) {
                c1376e.m1328c(this);
            }
        }
    }

    public final float m1378a() {
        return this.f967k;
    }

    public final float m1380b() {
        return this.f968l;
    }

    public final float m1381c() {
        return this.f969m;
    }

    public final float m1382d() {
        if (!C1383i.m1373a(this.f962f) || this.f959c.getPointerCount() != this.f958b.getPointerCount()) {
            return 1.0f;
        }
        if (this.f978v == GroundOverlayOptions.NO_DIMENSION) {
            float f;
            float f2;
            if (this.f974r == GroundOverlayOptions.NO_DIMENSION) {
                f = this.f972p;
                f2 = this.f973q;
                this.f974r = (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
            }
            f = this.f974r;
            if (this.f975s == GroundOverlayOptions.NO_DIMENSION) {
                f2 = this.f970n;
                float f3 = this.f971o;
                this.f975s = (float) Math.sqrt((double) ((f2 * f2) + (f3 * f3)));
            }
            this.f978v = f / this.f975s;
        }
        return this.f978v;
    }

    public final float m1383e() {
        if (!C1383i.m1373a(this.f963g)) {
            return 0.0f;
        }
        if (!this.f953E) {
            this.f979w = (this.f977u - this.f976t) * 0.25f;
            this.f953E = true;
        }
        return this.f979w;
    }

    public final float m1384f() {
        if (!C1383i.m1373a(this.f964h) || this.f959c.getPointerCount() != this.f958b.getPointerCount()) {
            return 0.0f;
        }
        if (!this.f954F) {
            this.f980x = C1376e.m1321a(C1367h.m1286a(this.f958b.getX(0), this.f958b.getY(0), this.f958b.getX(this.f958b.getPointerCount() - 1), this.f958b.getY(this.f958b.getPointerCount() - 1)), C1367h.m1286a(this.f959c.getX(0), this.f959c.getY(0), this.f959c.getX(this.f959c.getPointerCount() - 1), this.f959c.getY(this.f959c.getPointerCount() - 1)));
            this.f954F = true;
        }
        return this.f980x;
    }
}
