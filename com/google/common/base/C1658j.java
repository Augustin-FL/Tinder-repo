package com.google.common.base;

import java.util.concurrent.TimeUnit;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.google.common.base.j */
public final class C1658j {
    private final C1660m f1973a;
    private boolean f1974b;
    private long f1975c;
    private long f1976d;

    /* renamed from: com.google.common.base.j.1 */
    static /* synthetic */ class C16571 {
        static final /* synthetic */ int[] f1972a;

        static {
            f1972a = new int[TimeUnit.values().length];
            try {
                f1972a[TimeUnit.NANOSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1972a[TimeUnit.MICROSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1972a[TimeUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f1972a[TimeUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public C1658j() {
        this(C1660m.m3120b());
    }

    public C1658j(C1660m c1660m) {
        this.f1973a = (C1660m) C1650g.m3081a((Object) c1660m, (Object) "ticker");
    }

    public C1658j m3116a() {
        C1650g.m3092b(!this.f1974b, (Object) "This stopwatch is already running; it cannot be started more than once.");
        this.f1974b = true;
        this.f1976d = this.f1973a.m3121a();
        return this;
    }

    private long m3113b() {
        return this.f1974b ? (this.f1973a.m3121a() - this.f1976d) + this.f1975c : this.f1975c;
    }

    public long m3115a(TimeUnit timeUnit) {
        return timeUnit.convert(m3113b(), TimeUnit.NANOSECONDS);
    }

    public String toString() {
        return m3117a(4);
    }

    @Deprecated
    public String m3117a(int i) {
        long b = m3113b();
        double convert = ((double) b) / ((double) TimeUnit.NANOSECONDS.convert(1, C1658j.m3112a(b)));
        return String.format("%." + i + "g %s", new Object[]{Double.valueOf(convert), C1658j.m3114b(r2)});
    }

    private static TimeUnit m3112a(long j) {
        if (TimeUnit.SECONDS.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.SECONDS;
        }
        if (TimeUnit.MILLISECONDS.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.MILLISECONDS;
        }
        if (TimeUnit.MICROSECONDS.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.MICROSECONDS;
        }
        return TimeUnit.NANOSECONDS;
    }

    private static String m3114b(TimeUnit timeUnit) {
        switch (C16571.f1972a[timeUnit.ordinal()]) {
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                return "ns";
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                return "\u03bcs";
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                return "ms";
            case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                return "s";
            default:
                throw new AssertionError();
        }
    }
}
