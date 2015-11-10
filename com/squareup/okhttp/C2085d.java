package com.squareup.okhttp;

import com.facebook.stetho.BuildConfig;
import com.squareup.okhttp.internal.http.C2122d;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpHeaders;

/* renamed from: com.squareup.okhttp.d */
public final class C2085d {
    public static final C2085d f3094a;
    public static final C2085d f3095b;
    String f3096c;
    private final boolean f3097d;
    private final boolean f3098e;
    private final int f3099f;
    private final int f3100g;
    private final boolean f3101h;
    private final boolean f3102i;
    private final boolean f3103j;
    private final int f3104k;
    private final int f3105l;
    private final boolean f3106m;
    private final boolean f3107n;

    /* renamed from: com.squareup.okhttp.d.a */
    public static final class C2084a {
        boolean f3087a;
        boolean f3088b;
        int f3089c;
        int f3090d;
        int f3091e;
        boolean f3092f;
        boolean f3093g;

        public C2084a() {
            this.f3089c = -1;
            this.f3090d = -1;
            this.f3091e = -1;
        }

        public C2084a m4934a() {
            this.f3087a = true;
            return this;
        }

        public C2084a m4935a(int i, TimeUnit timeUnit) {
            if (i < 0) {
                throw new IllegalArgumentException("maxStale < 0: " + i);
            }
            long toSeconds = timeUnit.toSeconds((long) i);
            this.f3090d = toSeconds > 2147483647L ? ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : (int) toSeconds;
            return this;
        }

        public C2084a m4936b() {
            this.f3092f = true;
            return this;
        }

        public C2085d m4937c() {
            return new C2085d();
        }
    }

    static {
        f3094a = new C2084a().m4934a().m4937c();
        f3095b = new C2084a().m4936b().m4935a(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, TimeUnit.SECONDS).m4937c();
    }

    private C2085d(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, String str) {
        this.f3097d = z;
        this.f3098e = z2;
        this.f3099f = i;
        this.f3100g = i2;
        this.f3101h = z3;
        this.f3102i = z4;
        this.f3103j = z5;
        this.f3104k = i3;
        this.f3105l = i4;
        this.f3106m = z6;
        this.f3107n = z7;
        this.f3096c = str;
    }

    private C2085d(C2084a c2084a) {
        this.f3097d = c2084a.f3087a;
        this.f3098e = c2084a.f3088b;
        this.f3099f = c2084a.f3089c;
        this.f3100g = -1;
        this.f3101h = false;
        this.f3102i = false;
        this.f3103j = false;
        this.f3104k = c2084a.f3090d;
        this.f3105l = c2084a.f3091e;
        this.f3106m = c2084a.f3092f;
        this.f3107n = c2084a.f3093g;
    }

    public boolean m4940a() {
        return this.f3097d;
    }

    public boolean m4941b() {
        return this.f3098e;
    }

    public int m4942c() {
        return this.f3099f;
    }

    public boolean m4943d() {
        return this.f3101h;
    }

    public boolean m4944e() {
        return this.f3102i;
    }

    public boolean m4945f() {
        return this.f3103j;
    }

    public int m4946g() {
        return this.f3104k;
    }

    public int m4947h() {
        return this.f3105l;
    }

    public boolean m4948i() {
        return this.f3106m;
    }

    public static C2085d m4938a(C2210m c2210m) {
        String b;
        boolean z = false;
        int i = -1;
        int i2 = -1;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        int i3 = -1;
        int i4 = -1;
        boolean z5 = false;
        boolean z6 = false;
        Object obj = 1;
        int a = c2210m.m5687a();
        int i5 = 0;
        String str = null;
        boolean z7 = false;
        while (i5 < a) {
            boolean z8;
            String a2 = c2210m.m5688a(i5);
            b = c2210m.m5691b(i5);
            if (a2.equalsIgnoreCase(HttpHeaders.CACHE_CONTROL)) {
                if (str != null) {
                    obj = null;
                } else {
                    str = b;
                }
            } else if (a2.equalsIgnoreCase(HttpHeaders.PRAGMA)) {
                obj = null;
            } else {
                z8 = z7;
                i5++;
                z7 = z8;
            }
            z8 = z7;
            int i6 = 0;
            while (i6 < b.length()) {
                String str2;
                int a3 = C2122d.m5149a(b, i6, "=,;");
                String trim = b.substring(i6, a3).trim();
                if (a3 == b.length() || b.charAt(a3) == ',' || b.charAt(a3) == ';') {
                    i6 = a3 + 1;
                    str2 = null;
                } else {
                    i6 = C2122d.m5148a(b, a3 + 1);
                    String trim2;
                    if (i6 >= b.length() || b.charAt(i6) != '\"') {
                        a3 = C2122d.m5149a(b, i6, ",;");
                        trim2 = b.substring(i6, a3).trim();
                        i6 = a3;
                        str2 = trim2;
                    } else {
                        i6++;
                        a3 = C2122d.m5149a(b, i6, "\"");
                        trim2 = b.substring(i6, a3);
                        i6 = a3 + 1;
                        str2 = trim2;
                    }
                }
                if ("no-cache".equalsIgnoreCase(trim)) {
                    z8 = true;
                } else {
                    if ("no-store".equalsIgnoreCase(trim)) {
                        z = true;
                    } else {
                        if ("max-age".equalsIgnoreCase(trim)) {
                            i = C2122d.m5150b(str2, -1);
                        } else {
                            if ("s-maxage".equalsIgnoreCase(trim)) {
                                i2 = C2122d.m5150b(str2, -1);
                            } else {
                                if ("private".equalsIgnoreCase(trim)) {
                                    z2 = true;
                                } else {
                                    if ("public".equalsIgnoreCase(trim)) {
                                        z3 = true;
                                    } else {
                                        if ("must-revalidate".equalsIgnoreCase(trim)) {
                                            z4 = true;
                                        } else {
                                            if ("max-stale".equalsIgnoreCase(trim)) {
                                                i3 = C2122d.m5150b(str2, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                                            } else {
                                                if ("min-fresh".equalsIgnoreCase(trim)) {
                                                    i4 = C2122d.m5150b(str2, -1);
                                                } else {
                                                    if ("only-if-cached".equalsIgnoreCase(trim)) {
                                                        z5 = true;
                                                    } else {
                                                        if ("no-transform".equalsIgnoreCase(trim)) {
                                                            z6 = true;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            i5++;
            z7 = z8;
        }
        if (obj == null) {
            b = null;
        } else {
            b = str;
        }
        return new C2085d(z7, z, i, i2, z2, z3, z4, i3, i4, z5, z6, b);
    }

    public String toString() {
        String str = this.f3096c;
        if (str != null) {
            return str;
        }
        str = m4939j();
        this.f3096c = str;
        return str;
    }

    private String m4939j() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.f3097d) {
            stringBuilder.append("no-cache, ");
        }
        if (this.f3098e) {
            stringBuilder.append("no-store, ");
        }
        if (this.f3099f != -1) {
            stringBuilder.append("max-age=").append(this.f3099f).append(", ");
        }
        if (this.f3100g != -1) {
            stringBuilder.append("s-maxage=").append(this.f3100g).append(", ");
        }
        if (this.f3101h) {
            stringBuilder.append("private, ");
        }
        if (this.f3102i) {
            stringBuilder.append("public, ");
        }
        if (this.f3103j) {
            stringBuilder.append("must-revalidate, ");
        }
        if (this.f3104k != -1) {
            stringBuilder.append("max-stale=").append(this.f3104k).append(", ");
        }
        if (this.f3105l != -1) {
            stringBuilder.append("min-fresh=").append(this.f3105l).append(", ");
        }
        if (this.f3106m) {
            stringBuilder.append("only-if-cached, ");
        }
        if (this.f3107n) {
            stringBuilder.append("no-transform, ");
        }
        if (stringBuilder.length() == 0) {
            return BuildConfig.FLAVOR;
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        return stringBuilder.toString();
    }
}
