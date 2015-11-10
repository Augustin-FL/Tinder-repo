package com.google.android.m4b.maps.au;

import com.google.android.m4b.maps.au.C1344a.C1343b;
import com.google.common.collect.C1872p;
import java.util.LinkedList;
import java.util.List;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.google.android.m4b.maps.au.e */
public final class C1357e {

    /* renamed from: com.google.android.m4b.maps.au.e.1 */
    static /* synthetic */ class C13511 {
        static final /* synthetic */ int[] f869a;
        static final /* synthetic */ int[] f870b;

        static {
            f870b = new int[C1354a.values().length];
            try {
                f870b[C1354a.EMPTY_MESH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f870b[C1354a.TESSELLATE_MONOTONE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f870b[C1354a.CUT_AND_TESSELLATE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            f869a = new int[C1343b.values().length];
            try {
                f869a[C1343b.LEFT_VERTEX.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f869a[C1343b.RIGHT_VERTEX.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f869a[C1343b.SPLIT_VERTEX.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f869a[C1343b.MERGE_VERTEX.ordinal()] = 4;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f869a[C1343b.START_VERTEX.ordinal()] = 5;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f869a[C1343b.END_VERTEX.ordinal()] = 6;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    /* renamed from: com.google.android.m4b.maps.au.e.b */
    public static class C1352b extends Exception {
        public C1352b(String str, Throwable th) {
            super(str, th);
        }
    }

    /* renamed from: com.google.android.m4b.maps.au.e.a */
    public static class C1353a extends C1352b {
        public C1353a(String str) {
            super(str, null);
        }
    }

    /* renamed from: com.google.android.m4b.maps.au.e.c */
    static class C1355c {
        public C1354a f875a;
        public C1348j f876b;
        public C1346b f877c;
        public int f878d;
        public int f879e;
        public C1343b f880f;
        public List<Object> f881g;
        public int[] f882h;
        public int f883i;

        /* renamed from: com.google.android.m4b.maps.au.e.c.a */
        public enum C1354a {
            EMPTY_MESH,
            TESSELLATE_MONOTONE,
            CUT_AND_TESSELLATE
        }

        private C1355c() {
        }

        public final C1355c m1217a(C1354a c1354a, C1348j c1348j, C1346b c1346b, int i, int i2, C1343b c1343b, List<Object> list) {
            this.f875a = c1354a;
            this.f876b = c1348j;
            this.f877c = c1346b;
            this.f878d = i;
            this.f879e = i2;
            this.f880f = c1343b;
            this.f881g = list;
            return this;
        }
    }

    /* renamed from: com.google.android.m4b.maps.au.e.d */
    public enum C1356d {
        CCW_OUTLINE,
        CW_HOLES,
        NON_SELF_INTERSECTING,
        NO_LINES_STICKING_OUT
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.m4b.maps.au.C1364k m1219a(com.google.android.m4b.maps.au.C1350d r12) {
        /*
        r6 = 0;
        r3 = 3;
        r0 = 0;
        r2 = r12.m1216f();	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        r1 = r2.m1234a();	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        if (r1 != 0) goto L_0x008d;
    L_0x000e:
        r0 = r2.a;	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        r1 = 5;
        if (r0 >= r1) goto L_0x0083;
    L_0x0013:
        r0 = r2.a;	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        if (r0 < r3) goto L_0x001f;
    L_0x0017:
        r0 = r2.m1242d();	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r0 != 0) goto L_0x0024;
    L_0x001f:
        r0 = com.google.android.m4b.maps.au.C1364k.m1269a();	 Catch:{ b -> 0x0037, Exception -> 0x005c }
    L_0x0023:
        return r0;
    L_0x0024:
        r0 = r2.m1238b();	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        r0 = com.google.android.m4b.maps.au.C1364k.m1270a(r0);	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        r1 = r2.a;	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        if (r1 != r3) goto L_0x0039;
    L_0x0030:
        r1 = 0;
        r2 = 1;
        r3 = 2;
        r0.m1273a(r1, r2, r3);	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        goto L_0x0023;
    L_0x0037:
        r0 = move-exception;
        throw r0;
    L_0x0039:
        r1 = 0;
        r3 = 1;
        r4 = 2;
        r4 = r2.m1127a(r1, r3, r4);	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r1 >= 0) goto L_0x0076;
    L_0x0044:
        r1 = 2;
        r3 = 3;
        r4 = 0;
        r2 = r2.m1127a(r1, r3, r4);	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        r1 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r1 >= 0) goto L_0x0076;
    L_0x004f:
        r1 = 0;
        r2 = 1;
        r3 = 2;
        r0.m1273a(r1, r2, r3);	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        r1 = 2;
        r2 = 3;
        r3 = 0;
        r0.m1273a(r1, r2, r3);	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        goto L_0x0023;
    L_0x005c:
        r0 = move-exception;
        r1 = new com.google.android.m4b.maps.au.e$b;
        r2 = new java.lang.StringBuilder;
        r3 = "Error when tessellating polygon: ";
        r2.<init>(r3);
        r3 = r0.getMessage();
        r2 = r2.append(r3);
        r2 = r2.toString();
        r1.<init>(r2, r0);
        throw r1;
    L_0x0076:
        r1 = 3;
        r2 = 0;
        r3 = 1;
        r0.m1273a(r1, r2, r3);	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        r1 = 1;
        r2 = 2;
        r3 = 3;
        r0.m1273a(r1, r2, r3);	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        goto L_0x0023;
    L_0x0083:
        r0 = r2.m1241c();	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        r1 = 0;
        r0 = com.google.android.m4b.maps.au.C1357e.m1220a(r0, r1);	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        goto L_0x0023;
    L_0x008d:
        r1 = new com.google.android.m4b.maps.au.c;	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        r1.<init>(r2);	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        r3 = r1.m1177d();	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        if (r3 != 0) goto L_0x009f;
    L_0x0098:
        r0 = r1;
    L_0x0099:
        r1 = 0;
        r0 = com.google.android.m4b.maps.au.C1357e.m1220a(r0, r1);	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        goto L_0x0023;
    L_0x009f:
        r4 = new com.google.android.m4b.maps.au.b;	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        r4.<init>(r1);	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        r2 = r3 * 2;
        r5 = new int[r2];	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        r2 = r0;
    L_0x00a9:
        r6 = r1.c;	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        if (r2 >= r6) goto L_0x010a;
    L_0x00ad:
        r6 = r1.m1191j(r2);	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        r7 = r1.m1178d(r6);	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        r8 = r1.m1180e(r6);	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        r9 = r1.m1183f(r6);	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        r10 = com.google.android.m4b.maps.au.C1357e.C13511.f869a;	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        r11 = r9.ordinal();	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        r10 = r10[r11];	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        switch(r10) {
            case 1: goto L_0x00cb;
            case 2: goto L_0x00d2;
            case 3: goto L_0x00d9;
            case 4: goto L_0x00f8;
            case 5: goto L_0x00ff;
            case 6: goto L_0x0103;
            default: goto L_0x00c8;
        };	 Catch:{ b -> 0x0037, Exception -> 0x005c }
    L_0x00c8:
        r2 = r2 + 1;
        goto L_0x00a9;
    L_0x00cb:
        r4.m1152a(r7, r6, r9);	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        r4.m1157b(r6, r8, r9);	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        goto L_0x00c8;
    L_0x00d2:
        r4.m1152a(r6, r8, r9);	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        r4.m1157b(r7, r6, r9);	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        goto L_0x00c8;
    L_0x00d9:
        r9 = r4.m1151a(r6);	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        r10 = r1.m1209a(r6, r9);	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        if (r10 == 0) goto L_0x00f4;
    L_0x00e3:
        r5[r0] = r6;	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        r10 = r0 + 1;
        r5[r10] = r9;	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        r0 = r0 + 2;
        r9 = r3 * 2;
        if (r0 != r9) goto L_0x00f4;
    L_0x00ef:
        r0 = r1.m1208a(r5);	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        goto L_0x0099;
    L_0x00f4:
        r4.m1158b(r7, r6, r8);	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        goto L_0x00c8;
    L_0x00f8:
        r4.m1157b(r6, r8, r9);	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        r4.m1157b(r7, r6, r9);	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        goto L_0x00c8;
    L_0x00ff:
        r4.m1154a(r7, r6, r8);	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        goto L_0x00c8;
    L_0x0103:
        r4.m1157b(r7, r6, r9);	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        r4.m1157b(r6, r8, r9);	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        goto L_0x00c8;
    L_0x010a:
        r0 = new java.lang.NullPointerException;	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        r1 = "Tesselation could not cut all holes open.";
        r0.<init>(r1);	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        throw r0;	 Catch:{ b -> 0x0037, Exception -> 0x005c }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.m4b.maps.au.e.a(com.google.android.m4b.maps.au.d):com.google.android.m4b.maps.au.k");
    }

    public static C1356d m1223b(C1350d c1350d) {
        if (c1350d.m1212b()) {
            return C1356d.CCW_OUTLINE;
        }
        if (c1350d.m1213c()) {
            return C1356d.CW_HOLES;
        }
        if (c1350d.m1214d()) {
            return C1356d.NO_LINES_STICKING_OUT;
        }
        if (c1350d.m1215e()) {
            return C1356d.NON_SELF_INTERSECTING;
        }
        return null;
    }

    private static C1364k m1220a(C1348j c1348j, List<Object> list) {
        C1355c a = C1357e.m1218a(c1348j, new C1346b((C1347m) c1348j), 0, null, null);
        switch (C13511.f870b[a.f875a.ordinal()]) {
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                return C1364k.m1269a();
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                C1364k a2 = C1364k.m1270a(a.f876b);
                C1357e.m1221a(a.f876b, a2, null, 0);
                return a2;
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                C1347m c1347m = a.f876b;
                C1346b c1346b = a.f877c;
                int i = a.f878d;
                int i2 = a.f879e;
                C1343b c1343b = a.f880f;
                List list2 = a.f881g;
                C1364k a3 = C1364k.m1270a(c1347m);
                LinkedList b = C1872p.m4318b();
                Object obj = null;
                int i3 = 0;
                int[] iArr = null;
                C1355c c1355c = null;
                C1355c c1355c2 = null;
                List list3 = list2;
                C1343b c1343b2 = c1343b;
                C1346b c1346b2 = c1346b;
                C1347m c1347m2 = c1347m;
                int i4 = i2;
                int i5 = i;
                while (obj == null) {
                    int d;
                    int i6;
                    int e;
                    int i7;
                    int i8;
                    C1348j c1348j2;
                    C1346b c1346b3;
                    C1346b c1346b4;
                    C1348j c1348j3;
                    C1355c c1355c3;
                    C1347m c1347m3;
                    C1346b c1346b5;
                    C1343b c1343b3;
                    List list4;
                    int[] iArr2;
                    if (list3 != null) {
                        list3.add(new double[]{c1347m2.m1170b(i5), c1347m2.m1174c(i5), c1347m2.m1170b(i4), c1347m2.m1174c(i4)});
                    }
                    int i9 = i5 > i4 ? i4 : i5;
                    int i10 = i5 > i4 ? i5 : i4;
                    i2 = 0;
                    int i11 = 0;
                    Object obj2 = null;
                    if (c1347m2.m1186g(i9, i10) == 0) {
                        obj2 = 1;
                        d = c1347m2.m1178d(i10);
                        i6 = i9;
                        e = c1347m2.m1180e(i10);
                        i7 = i9;
                        i8 = d;
                    } else {
                        if (c1347m2.m1186g(i9, c1347m2.m1178d(i10)) == 0) {
                            obj2 = 1;
                            i8 = c1347m2.m1178d(i10);
                            i6 = i9;
                            e = i10;
                            i7 = i9;
                        } else {
                            if (c1347m2.m1186g(i9, c1347m2.m1180e(i10)) == 0) {
                                obj2 = 1;
                                i6 = i9;
                                e = c1347m2.m1180e(i10);
                                i7 = i9;
                                i8 = i10;
                            } else {
                                if (c1347m2.m1186g(c1347m2.m1178d(i9), i10) == 0) {
                                    obj2 = 1;
                                    i6 = c1347m2.m1178d(i9);
                                    e = i10;
                                    i7 = i9;
                                    i8 = i10;
                                } else {
                                    if (c1347m2.m1186g(c1347m2.m1180e(i9), i10) == 0) {
                                        obj2 = 1;
                                        i6 = i9;
                                        e = i10;
                                        i7 = c1347m2.m1180e(i9);
                                        i8 = i10;
                                    } else {
                                        i6 = i9;
                                        e = i10;
                                        i8 = i10;
                                        i7 = i9;
                                    }
                                }
                            }
                        }
                    }
                    if (obj2 == null) {
                        C1348j b2 = c1347m2.m1199b(i9, i10);
                        C1346b a4 = c1346b2.m1153a(b2, i9, i10);
                        int h = b2.m1188h(i5 - i9, 0);
                        C1348j b3 = c1347m2.m1199b(i10, i9);
                        C1346b a5 = c1346b2.m1153a(b3, i10, i9);
                        int i12 = (i10 - i9) - 1;
                        int i13 = i4 <= i9 ? i4 : i4 - i12;
                        int i14 = i5 <= i9 ? i5 : i5 - i12;
                        int h2 = b3.m1188h(i14, 0);
                        int d2 = c1347m2.m1178d(i5);
                        i8 = c1347m2.m1180e(i5);
                        C1348j c1348j4;
                        switch (C13511.f869a[c1343b2.ordinal()]) {
                            case C3374b.SmoothProgressBar_spb_color /*1*/:
                                if (d2 < i9 || d2 > i10) {
                                    if (b2.m1183f(i5 - i9) == C1343b.END_VERTEX) {
                                        c1348j2 = b3;
                                        i2 = h + 1;
                                        c1346b3 = a4;
                                        i11 = h2 + 1;
                                        c1346b4 = a5;
                                        c1348j3 = b2;
                                        break;
                                    }
                                    throw new NullPointerException("Impossible case in cutAndTessellate.");
                                }
                                i8 = h + 1;
                                if (b3.m1183f(i14) == C1343b.END_VERTEX) {
                                    c1346b3 = a4;
                                    i11 = h2 + 1;
                                    c1346b4 = a5;
                                    c1348j3 = b2;
                                    c1348j4 = b3;
                                    i2 = i8;
                                    c1348j2 = c1348j4;
                                    break;
                                }
                                throw new NullPointerException("Impossible case in cutAndTessellate.");
                            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                                if (d2 >= i9 && d2 <= i10) {
                                    if (b2.m1183f(i5 - i9) == C1343b.END_VERTEX) {
                                        c1348j2 = b3;
                                        i2 = h + 1;
                                        c1346b3 = a4;
                                        i11 = h2 + 1;
                                        c1346b4 = a5;
                                        c1348j3 = b2;
                                        break;
                                    }
                                    throw new NullPointerException("Impossible case in cutAndTessellate.");
                                }
                                i8 = h + 1;
                                if (b3.m1183f(i14) == C1343b.END_VERTEX) {
                                    c1346b3 = a4;
                                    i11 = h2 + 1;
                                    c1346b4 = a5;
                                    c1348j3 = b2;
                                    c1348j4 = b3;
                                    i2 = i8;
                                    c1348j2 = c1348j4;
                                    break;
                                }
                                throw new NullPointerException("Impossible case in cutAndTessellate.");
                            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                                a4.m1161d(i4 - i9, i5 - i9);
                                a5.m1161d(i13, i14);
                                c1346b4 = a5;
                                c1346b3 = a4;
                                c1348j2 = b3;
                                c1348j3 = b2;
                                i11 = h2;
                                i2 = h;
                                break;
                            case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                                if (d2 >= i9 && d2 <= i10) {
                                    if (!c1346b2.m1160c(d2, i5)) {
                                        if (b2.m1183f(i5 - i9) == C1343b.END_VERTEX) {
                                            c1348j2 = b3;
                                            i2 = h + 1;
                                            c1346b3 = a4;
                                            i11 = h2 + 1;
                                            c1346b4 = a5;
                                            c1348j3 = b2;
                                            break;
                                        }
                                        throw new NullPointerException("Impossible case in cutAndTessellate.");
                                    }
                                    a4.m1161d(i4 - i9, i5 - i9);
                                    if (b3.m1183f(i14) == C1343b.END_VERTEX) {
                                        c1346b3 = a4;
                                        c1348j2 = b3;
                                        i11 = h2 + 1;
                                        i2 = h;
                                        c1346b4 = a5;
                                        c1348j3 = b2;
                                        break;
                                    }
                                    throw new NullPointerException("Impossible case in cutAndTessellate.");
                                } else if (!c1346b2.m1160c(d2, i5)) {
                                    if (b3.m1183f(i14) == C1343b.END_VERTEX) {
                                        c1348j2 = b3;
                                        i2 = h + 1;
                                        c1346b3 = a4;
                                        i11 = h2 + 1;
                                        c1346b4 = a5;
                                        c1348j3 = b2;
                                        break;
                                    }
                                    throw new NullPointerException("Impossible case in cutAndTessellate.");
                                } else if (b2.m1183f(i5 - i9) == C1343b.END_VERTEX) {
                                    i10 = h + 1;
                                    a5.m1161d(i13, i14);
                                    c1346b3 = a4;
                                    c1348j2 = b3;
                                    i11 = h2;
                                    i2 = i10;
                                    c1346b4 = a5;
                                    c1348j3 = b2;
                                    break;
                                } else {
                                    throw new NullPointerException("Impossible case in cutAndTessellate.");
                                }
                                break;
                            case C3374b.SmoothProgressBar_spb_speed /*5*/:
                                throw new NullPointerException("Impossible case in cutAndTessellate.");
                            case C3374b.SmoothProgressBar_spb_progressiveStart_speed /*6*/:
                                if (i8 < i9 || i8 > i10) {
                                    if (a5.m1160c(i8 <= i9 ? i8 : i8 - i12, i14)) {
                                        if (i8 > i9) {
                                            i8 -= i12;
                                        }
                                        if (a5.m1157b(i8, i14, C1343b.END_VERTEX) != -1) {
                                            throw new NullPointerException("Impossible case in cutAndTessellate.");
                                        }
                                    }
                                    throw new NullPointerException("Impossible case in cutAndTessellate.");
                                } else if (!a4.m1160c(i8 - i9, i5 - i9)) {
                                    throw new NullPointerException("Impossible case in cutAndTessellate.");
                                } else if (a4.m1157b(i8 - i9, i5 - i9, C1343b.END_VERTEX) != -1) {
                                    throw new NullPointerException("Impossible case in cutAndTessellate.");
                                }
                                c1348j2 = b3;
                                i2 = h + 1;
                                c1346b3 = a4;
                                i11 = h2 + 1;
                                c1346b4 = a5;
                                c1348j3 = b2;
                                break;
                            default:
                                c1346b4 = a5;
                                c1346b3 = a4;
                                c1348j2 = b3;
                                c1348j3 = b2;
                                i11 = h2;
                                i2 = h;
                                break;
                        }
                    }
                    c1348j3 = c1347m2.m1199b(i7, i8);
                    c1348j2 = c1347m2.m1199b(e, i6);
                    c1346b3 = new C1346b((C1347m) c1348j3);
                    c1346b4 = new C1346b((C1347m) c1348j2);
                    a3.m1276b();
                    C1355c a6 = C1357e.m1218a(c1348j3, c1346b3, i2, list3, c1355c2);
                    C1355c a7 = C1357e.m1218a(c1348j2, c1346b4, i11, list3, c1355c);
                    if (iArr != null) {
                        i11 = c1348j3.m1179e();
                        if (a6.f882h == null || a6.f882h.length < i11) {
                            a6.f882h = new int[i11];
                        }
                        for (d = 0; d < i11; d++) {
                            a6.f882h[d] = iArr[i7 + d];
                        }
                    } else {
                        a6.f882h = null;
                        a6.f883i = i3 + i7;
                    }
                    d = c1348j2.m1179e();
                    if (a7.f882h == null || a7.f882h.length < d) {
                        a7.f882h = new int[d];
                    }
                    if (iArr != null) {
                        System.arraycopy(iArr, 0, a7.f882h, 0, i6 + 1);
                        if (e < iArr.length) {
                            System.arraycopy(iArr, e, a7.f882h, i6 + 1, (d - i6) - 1);
                        }
                    } else {
                        for (i8 = 0; i8 < i6 + 1; i8++) {
                            a7.f882h[i8] = i8 + i3;
                        }
                        i11 = ((e - i6) - 1) + i3;
                        for (i8 = i6 + 1; i8 < d; i8++) {
                            a7.f882h[i8] = i8 + i11;
                        }
                    }
                    if (a6.f875a != C1354a.CUT_AND_TESSELLATE || a7.f875a == C1354a.CUT_AND_TESSELLATE) {
                        C1355c c1355c4 = a7;
                        a7 = a6;
                        a6 = c1355c4;
                    }
                    switch (C13511.f870b[a7.f875a.ordinal()]) {
                        case C3374b.SmoothProgressBar_spb_color /*1*/:
                            c1355c3 = a7;
                            break;
                        case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                            C1357e.m1221a(a7.f876b, a3, a7.f882h, a7.f883i);
                            c1355c3 = a7;
                            break;
                        case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                            b.add(a7);
                            c1355c3 = null;
                            break;
                        default:
                            throw new C1353a("Unknown subdivide result in tessellation");
                    }
                    switch (C13511.f870b[a6.f875a.ordinal()]) {
                        case C3374b.SmoothProgressBar_spb_color /*1*/:
                            break;
                        case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                            C1357e.m1221a(a6.f876b, a3, a6.f882h, 0);
                            break;
                        case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                            c1347m3 = a6.f876b;
                            c1346b5 = a6.f877c;
                            i2 = a6.f878d;
                            i11 = a6.f879e;
                            c1343b3 = a6.f880f;
                            list4 = a6.f881g;
                            iArr2 = a6.f882h;
                            i3 = a6.f883i;
                            iArr = iArr2;
                            c1355c = a6;
                            c1355c2 = c1355c3;
                            list3 = list4;
                            c1343b2 = c1343b3;
                            c1346b2 = c1346b5;
                            c1347m2 = c1347m3;
                            i4 = i11;
                            i5 = i2;
                            continue;
                        default:
                            throw new C1353a("Unknown subdivide result in tessellation");
                    }
                    if (b.isEmpty()) {
                        obj = 1;
                        c1355c = a6;
                        c1355c2 = c1355c3;
                    } else {
                        a7 = (C1355c) b.poll();
                        c1347m3 = a7.f876b;
                        c1346b5 = a7.f877c;
                        i2 = a7.f878d;
                        i11 = a7.f879e;
                        c1343b3 = a7.f880f;
                        list4 = a7.f881g;
                        iArr2 = a7.f882h;
                        i3 = a7.f883i;
                        iArr = iArr2;
                        c1355c = a6;
                        c1355c2 = c1355c3;
                        list3 = list4;
                        c1343b2 = c1343b3;
                        c1346b2 = c1346b5;
                        c1347m2 = c1347m3;
                        i4 = i11;
                        i5 = i2;
                    }
                }
                return a3;
            default:
                throw new C1353a("Unknown subdivide result in tessellation");
        }
    }

    private static C1355c m1218a(C1348j c1348j, C1346b c1346b, int i, List<Object> list, C1355c c1355c) {
        C1355c c1355c2;
        if (c1355c == null) {
            c1355c2 = new C1355c();
        } else {
            c1355c2 = c1355c;
        }
        if (c1348j.m1179e() < 3) {
            return c1355c2.m1217a(C1354a.EMPTY_MESH, null, null, 0, 0, null, null);
        }
        while (i < c1348j.c) {
            int j = c1348j.m1191j(i);
            int d = c1348j.m1178d(j);
            int e = c1348j.m1180e(j);
            C1343b f = c1348j.m1183f(j);
            int a;
            switch (C13511.f869a[f.ordinal()]) {
                case C3374b.SmoothProgressBar_spb_color /*1*/:
                    a = c1346b.m1152a(d, j, f);
                    if (a == -1) {
                        a = c1346b.m1157b(j, e, f);
                        if (a == -1) {
                            break;
                        }
                        return c1355c2.m1217a(C1354a.CUT_AND_TESSELLATE, c1348j, c1346b, j, a, f, list);
                    }
                    return c1355c2.m1217a(C1354a.CUT_AND_TESSELLATE, c1348j, c1346b, j, a, f, list);
                case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                    a = c1346b.m1152a(j, e, f);
                    if (a == -1) {
                        a = c1346b.m1157b(d, j, f);
                        if (a == -1) {
                            break;
                        }
                        return c1355c2.m1217a(C1354a.CUT_AND_TESSELLATE, c1348j, c1346b, j, a, f, list);
                    }
                    return c1355c2.m1217a(C1354a.CUT_AND_TESSELLATE, c1348j, c1346b, j, a, f, list);
                case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                    return c1355c2.m1217a(C1354a.CUT_AND_TESSELLATE, c1348j, c1346b, j, c1346b.m1156b(j), f, list);
                case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                    a = c1346b.m1157b(j, e, f);
                    if (a == -1) {
                        a = c1346b.m1157b(d, j, f);
                        if (a == -1) {
                            break;
                        }
                        return c1355c2.m1217a(C1354a.CUT_AND_TESSELLATE, c1348j, c1346b, j, a, f, list);
                    }
                    return c1355c2.m1217a(C1354a.CUT_AND_TESSELLATE, c1348j, c1346b, j, a, f, list);
                case C3374b.SmoothProgressBar_spb_speed /*5*/:
                    c1346b.m1154a(d, j, e);
                    break;
                case C3374b.SmoothProgressBar_spb_progressiveStart_speed /*6*/:
                    a = c1346b.m1157b(d, j, f);
                    if (a == -1) {
                        a = c1346b.m1157b(j, e, f);
                        if (a == -1) {
                            break;
                        }
                        return c1355c2.m1217a(C1354a.CUT_AND_TESSELLATE, c1348j, c1346b, j, a, f, list);
                    }
                    return c1355c2.m1217a(C1354a.CUT_AND_TESSELLATE, c1348j, c1346b, j, a, f, list);
                default:
                    break;
            }
            i++;
        }
        return c1355c2.m1217a(C1354a.TESSELLATE_MONOTONE, c1348j, null, 0, 0, null, null);
    }

    private static void m1221a(C1348j c1348j, C1364k c1364k, int[] iArr, int i) {
        int e = c1348j.m1179e();
        if (e >= 3) {
            C1347m c = c1348j.m1176c();
            int j = c1348j.m1191j(0);
            int j2 = c1348j.m1191j(1);
            c.m1173b(j);
            c.m1173b(j2);
            int i2 = 2;
            while (i2 < e) {
                int j3 = c1348j.m1191j(i2);
                int f;
                if (c1348j.m1192k(i2)) {
                    f = c.m1182f();
                    while (c.f866c > 1 && c1348j.m1166a(j3, j2, f) > 0.0d) {
                        C1357e.m1222a(c1364k, j3, j2, f, iArr, i);
                        c.m1172b();
                        j2 = f;
                        f = c.m1182f();
                    }
                    c.m1173b(j3);
                } else if (c1348j.m1193l(i2)) {
                    f = c.m1182f();
                    int i3 = j2;
                    while (c.f866c > 1 && c1348j.m1166a(f, i3, j3) > 0.0d) {
                        C1357e.m1222a(c1364k, f, i3, j3, iArr, i);
                        c.m1172b();
                        i3 = f;
                        f = c.m1182f();
                    }
                    c.m1173b(j3);
                } else {
                    f = c.m1191j(0);
                    int i4 = 1;
                    while (i4 < c.f866c) {
                        j2 = c.m1191j(i4);
                        if (c1348j.m1166a(f, j2, j3) < 0.0d) {
                            C1357e.m1222a(c1364k, j3, j2, f, iArr, i);
                        } else {
                            C1357e.m1222a(c1364k, f, j2, j3, iArr, i);
                        }
                        i4++;
                        f = j2;
                    }
                    c.m1167a();
                    c.m1173b(f);
                    c.m1173b(j3);
                }
                i2++;
                j2 = j3;
            }
        }
    }

    private static void m1222a(C1364k c1364k, int i, int i2, int i3, int[] iArr, int i4) {
        if (iArr != null) {
            c1364k.m1273a(iArr[i], iArr[i2], iArr[i3]);
        } else {
            c1364k.m1273a(i + i4, i2 + i4, i3 + i4);
        }
    }
}
