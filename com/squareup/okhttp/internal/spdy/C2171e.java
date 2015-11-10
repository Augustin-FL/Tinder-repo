package com.squareup.okhttp.internal.spdy;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.widget.RecyclerView.SmoothScroller.Action;
import com.facebook.stetho.BuildConfig;
import com.squareup.okhttp.internal.spdy.C2160a.C2159a;
import com.squareup.okhttp.internal.spdy.C2165d.C2163a;
import com.squareup.okhttp.internal.spdy.C2165d.C2164b;
import com.tinder.views.RangeSeekBar;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.ByteString;
import okio.C2076r;
import okio.C2201s;
import okio.C3332d;
import okio.C3333e;
import okio.C3334c;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.squareup.okhttp.internal.spdy.e */
public final class C2171e implements C2170o {
    private static final Logger f3423a;
    private static final ByteString f3424b;

    /* renamed from: com.squareup.okhttp.internal.spdy.e.a */
    static final class C2166a implements C2076r {
        int f3404a;
        byte f3405b;
        int f3406c;
        int f3407d;
        short f3408e;
        private final C3333e f3409f;

        public C2166a(C3333e c3333e) {
            this.f3409f = c3333e;
        }

        public long m5422a(C3334c c3334c, long j) throws IOException {
            while (this.f3407d == 0) {
                this.f3409f.m10184g((long) this.f3408e);
                this.f3408e = (short) 0;
                if ((this.f3405b & 4) != 0) {
                    return -1;
                }
                m5421b();
            }
            long a = this.f3409f.m4901a(c3334c, Math.min(j, (long) this.f3407d));
            if (a == -1) {
                return -1;
            }
            this.f3407d = (int) (((long) this.f3407d) - a);
            return a;
        }

        public C2201s m5423a() {
            return this.f3409f.m4902a();
        }

        public void close() throws IOException {
        }

        private void m5421b() throws IOException {
            int i = this.f3406c;
            int a = C2171e.m5463b(this.f3409f);
            this.f3407d = a;
            this.f3404a = a;
            byte j = (byte) (this.f3409f.m10187j() & RangeSeekBar.INVALID_POINTER_ID);
            this.f3405b = (byte) (this.f3409f.m10187j() & RangeSeekBar.INVALID_POINTER_ID);
            if (C2171e.f3423a.isLoggable(Level.FINE)) {
                C2171e.f3423a.fine(C2167b.m5425a(true, this.f3406c, this.f3404a, j, this.f3405b));
            }
            this.f3406c = this.f3409f.m10189l() & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            if (j != 9) {
                throw C2171e.m5468d("%s != TYPE_CONTINUATION", Byte.valueOf(j));
            } else if (this.f3406c != i) {
                throw C2171e.m5468d("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }
    }

    /* renamed from: com.squareup.okhttp.internal.spdy.e.b */
    static final class C2167b {
        private static final String[] f3410a;
        private static final String[] f3411b;
        private static final String[] f3412c;

        C2167b() {
        }

        static String m5425a(boolean z, int i, int i2, byte b, byte b2) {
            String format = b < f3410a.length ? f3410a[b] : String.format("0x%02x", new Object[]{Byte.valueOf(b)});
            String a = C2167b.m5424a(b, b2);
            String str = "%s 0x%08x %5d %-13s %s";
            Object[] objArr = new Object[5];
            objArr[0] = z ? "<<" : ">>";
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = format;
            objArr[4] = a;
            return String.format(str, objArr);
        }

        static String m5424a(byte b, byte b2) {
            if (b2 == null) {
                return BuildConfig.FLAVOR;
            }
            switch (b) {
                case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                case C3374b.SmoothProgressBar_spb_progressiveStop_speed /*7*/:
                case C3374b.SmoothProgressBar_spb_interpolator /*8*/:
                    return f3412c[b2];
                case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                case C3374b.SmoothProgressBar_spb_progressiveStart_speed /*6*/:
                    return b2 == 1 ? "ACK" : f3412c[b2];
                default:
                    String str = b2 < f3411b.length ? f3411b[b2] : f3412c[b2];
                    if (b == 5 && (b2 & 4) != 0) {
                        return str.replace("HEADERS", "PUSH_PROMISE");
                    }
                    if (b != null || (b2 & 32) == 0) {
                        return str;
                    }
                    return str.replace("PRIORITY", "COMPRESSED");
            }
        }

        static {
            int i = 0;
            f3410a = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
            f3411b = new String[64];
            f3412c = new String[AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY];
            for (int i2 = 0; i2 < f3412c.length; i2++) {
                f3412c[i2] = String.format("%8s", new Object[]{Integer.toBinaryString(i2)}).replace(' ', '0');
            }
            f3411b[0] = BuildConfig.FLAVOR;
            f3411b[1] = "END_STREAM";
            int[] iArr = new int[]{1};
            f3411b[8] = "PADDED";
            for (int i3 : iArr) {
                f3411b[i3 | 8] = f3411b[i3] + "|PADDED";
            }
            f3411b[4] = "END_HEADERS";
            f3411b[32] = "PRIORITY";
            f3411b[36] = "END_HEADERS|PRIORITY";
            for (int i4 : new int[]{4, 32, 36}) {
                for (int i5 : iArr) {
                    f3411b[i5 | i4] = f3411b[i5] + '|' + f3411b[i4];
                    f3411b[(i5 | i4) | 8] = f3411b[i5] + '|' + f3411b[i4] + "|PADDED";
                }
            }
            while (i < f3411b.length) {
                if (f3411b[i] == null) {
                    f3411b[i] = f3412c[i];
                }
                i++;
            }
        }
    }

    /* renamed from: com.squareup.okhttp.internal.spdy.e.c */
    static final class C2168c implements C2160a {
        final C2163a f3413a;
        private final C3333e f3414b;
        private final C2166a f3415c;
        private final boolean f3416d;

        C2168c(C3333e c3333e, int i, boolean z) {
            this.f3414b = c3333e;
            this.f3416d = z;
            this.f3415c = new C2166a(this.f3414b);
            this.f3413a = new C2163a(i, this.f3415c);
        }

        public void m5437a() throws IOException {
            if (!this.f3416d) {
                ByteString c = this.f3414b.m10181c((long) C2171e.f3424b.m10157f());
                if (C2171e.f3423a.isLoggable(Level.FINE)) {
                    C2171e.f3423a.fine(String.format("<< CONNECTION %s", new Object[]{c.m10155d()}));
                }
                if (!C2171e.f3424b.equals(c)) {
                    throw C2171e.m5468d("Expected a connection header but was %s", c.m10150a());
                }
            }
        }

        public boolean m5438a(C2159a c2159a) throws IOException {
            try {
                this.f3414b.m10180a(9);
                int a = C2171e.m5463b(this.f3414b);
                if (a < 0 || a > AccessibilityNodeInfoCompat.ACTION_COPY) {
                    throw C2171e.m5468d("FRAME_SIZE_ERROR: %s", Integer.valueOf(a));
                }
                byte j = (byte) (this.f3414b.m10187j() & RangeSeekBar.INVALID_POINTER_ID);
                byte j2 = (byte) (this.f3414b.m10187j() & RangeSeekBar.INVALID_POINTER_ID);
                int l = this.f3414b.m10189l() & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                if (C2171e.f3423a.isLoggable(Level.FINE)) {
                    C2171e.f3423a.fine(C2167b.m5425a(true, l, a, j, j2));
                }
                switch (j) {
                    case C3374b.SmoothProgressBar_spbStyle /*0*/:
                        m5429b(c2159a, a, j2, l);
                        return true;
                    case C3374b.SmoothProgressBar_spb_color /*1*/:
                        m5428a(c2159a, a, j2, l);
                        return true;
                    case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                        m5430c(c2159a, a, j2, l);
                        return true;
                    case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                        m5431d(c2159a, a, j2, l);
                        return true;
                    case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                        m5432e(c2159a, a, j2, l);
                        return true;
                    case C3374b.SmoothProgressBar_spb_speed /*5*/:
                        m5433f(c2159a, a, j2, l);
                        return true;
                    case C3374b.SmoothProgressBar_spb_progressiveStart_speed /*6*/:
                        m5434g(c2159a, a, j2, l);
                        return true;
                    case C3374b.SmoothProgressBar_spb_progressiveStop_speed /*7*/:
                        m5435h(c2159a, a, j2, l);
                        return true;
                    case C3374b.SmoothProgressBar_spb_interpolator /*8*/:
                        m5436i(c2159a, a, j2, l);
                        return true;
                    default:
                        this.f3414b.m10184g((long) a);
                        return true;
                }
            } catch (IOException e) {
                return false;
            }
        }

        private void m5428a(C2159a c2159a, int i, byte b, int i2) throws IOException {
            if (i2 == 0) {
                throw C2171e.m5468d("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
            }
            short j;
            boolean z = (b & 1) != 0;
            if ((b & 8) != 0) {
                j = (short) (this.f3414b.m10187j() & RangeSeekBar.INVALID_POINTER_ID);
            } else {
                j = (short) 0;
            }
            if ((b & 32) != 0) {
                m5427a(c2159a, i2);
                i -= 5;
            }
            c2159a.m5379a(false, z, i2, -1, m5426a(C2171e.m5462b(i, b, j), j, b, i2), HeadersMode.HTTP_20_HEADERS);
        }

        private List<C2162c> m5426a(int i, short s, byte b, int i2) throws IOException {
            C2166a c2166a = this.f3415c;
            this.f3415c.f3407d = i;
            c2166a.f3404a = i;
            this.f3415c.f3408e = s;
            this.f3415c.f3405b = b;
            this.f3415c.f3406c = i2;
            this.f3413a.m5409a();
            return this.f3413a.m5411b();
        }

        private void m5429b(C2159a c2159a, int i, byte b, int i2) throws IOException {
            boolean z;
            short s = (short) 1;
            short s2 = (short) 0;
            if ((b & 1) != 0) {
                z = true;
            } else {
                z = false;
            }
            if ((b & 32) == 0) {
                s = (short) 0;
            }
            if (s != (short) 0) {
                throw C2171e.m5468d("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
            }
            if ((b & 8) != 0) {
                s2 = (short) (this.f3414b.m10187j() & RangeSeekBar.INVALID_POINTER_ID);
            }
            c2159a.m5377a(z, i2, this.f3414b, C2171e.m5462b(i, b, s2));
            this.f3414b.m10184g((long) s2);
        }

        private void m5430c(C2159a c2159a, int i, byte b, int i2) throws IOException {
            if (i != 5) {
                throw C2171e.m5468d("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
            } else if (i2 == 0) {
                throw C2171e.m5468d("TYPE_PRIORITY streamId == 0", new Object[0]);
            } else {
                m5427a(c2159a, i2);
            }
        }

        private void m5427a(C2159a c2159a, int i) throws IOException {
            int l = this.f3414b.m10189l();
            c2159a.m5371a(i, l & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, (this.f3414b.m10187j() & RangeSeekBar.INVALID_POINTER_ID) + 1, (Action.UNDEFINED_DURATION & l) != 0);
        }

        private void m5431d(C2159a c2159a, int i, byte b, int i2) throws IOException {
            if (i != 4) {
                throw C2171e.m5468d("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
            } else if (i2 == 0) {
                throw C2171e.m5468d("TYPE_RST_STREAM streamId == 0", new Object[0]);
            } else {
                ErrorCode b2 = ErrorCode.m5365b(this.f3414b.m10189l());
                if (b2 == null) {
                    throw C2171e.m5468d("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(r0));
                } else {
                    c2159a.m5374a(i2, b2);
                }
            }
        }

        private void m5432e(C2159a c2159a, int i, byte b, int i2) throws IOException {
            if (i2 != 0) {
                throw C2171e.m5468d("TYPE_SETTINGS streamId != 0", new Object[0]);
            } else if ((b & 1) != 0) {
                if (i != 0) {
                    throw C2171e.m5468d("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                }
                c2159a.m5380b();
            } else if (i % 6 != 0) {
                throw C2171e.m5468d("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
            } else {
                C2182k c2182k = new C2182k();
                for (int i3 = 0; i3 < i; i3 += 6) {
                    int k = this.f3414b.m10188k();
                    int l = this.f3414b.m10189l();
                    switch (k) {
                        case C3374b.SmoothProgressBar_spb_color /*1*/:
                        case C3374b.SmoothProgressBar_spb_progressiveStart_speed /*6*/:
                            break;
                        case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                            if (!(l == 0 || l == 1)) {
                                throw C2171e.m5468d("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                            }
                        case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                            k = 4;
                            break;
                        case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                            k = 7;
                            if (l >= 0) {
                                break;
                            }
                            throw C2171e.m5468d("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                        case C3374b.SmoothProgressBar_spb_speed /*5*/:
                            if (l >= AccessibilityNodeInfoCompat.ACTION_COPY && l <= ViewCompat.MEASURED_SIZE_MASK) {
                                break;
                            }
                            throw C2171e.m5468d("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(l));
                        default:
                            throw C2171e.m5468d("PROTOCOL_ERROR invalid settings id: %s", Short.valueOf(k));
                    }
                    c2182k.m5498a(k, 0, l);
                }
                c2159a.m5378a(false, c2182k);
                if (c2182k.m5504c() >= 0) {
                    this.f3413a.m5410a(c2182k.m5504c());
                }
            }
        }

        private void m5433f(C2159a c2159a, int i, byte b, int i2) throws IOException {
            short s = (short) 0;
            if (i2 == 0) {
                throw C2171e.m5468d("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
            }
            if ((b & 8) != 0) {
                s = (short) (this.f3414b.m10187j() & RangeSeekBar.INVALID_POINTER_ID);
            }
            c2159a.m5372a(i2, this.f3414b.m10189l() & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, m5426a(C2171e.m5462b(i - 4, b, s), s, b, i2));
        }

        private void m5434g(C2159a c2159a, int i, byte b, int i2) throws IOException {
            boolean z = true;
            if (i != 8) {
                throw C2171e.m5468d("TYPE_PING length != 8: %s", Integer.valueOf(i));
            } else if (i2 != 0) {
                throw C2171e.m5468d("TYPE_PING streamId != 0", new Object[0]);
            } else {
                int l = this.f3414b.m10189l();
                int l2 = this.f3414b.m10189l();
                if ((b & 1) == 0) {
                    z = false;
                }
                c2159a.m5376a(z, l, l2);
            }
        }

        private void m5435h(C2159a c2159a, int i, byte b, int i2) throws IOException {
            if (i < 8) {
                throw C2171e.m5468d("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
            } else if (i2 != 0) {
                throw C2171e.m5468d("TYPE_GOAWAY streamId != 0", new Object[0]);
            } else {
                int l = this.f3414b.m10189l();
                int i3 = i - 8;
                ErrorCode b2 = ErrorCode.m5365b(this.f3414b.m10189l());
                if (b2 == null) {
                    throw C2171e.m5468d("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(r0));
                }
                ByteString byteString = ByteString.f7266b;
                if (i3 > 0) {
                    byteString = this.f3414b.m10181c((long) i3);
                }
                c2159a.m5375a(l, b2, byteString);
            }
        }

        private void m5436i(C2159a c2159a, int i, byte b, int i2) throws IOException {
            if (i != 4) {
                throw C2171e.m5468d("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
            }
            long l = ((long) this.f3414b.m10189l()) & 2147483647L;
            if (l == 0) {
                throw C2171e.m5468d("windowSizeIncrement was 0", Long.valueOf(l));
            } else {
                c2159a.m5373a(i2, l);
            }
        }

        public void close() throws IOException {
            this.f3414b.close();
        }
    }

    /* renamed from: com.squareup.okhttp.internal.spdy.e.d */
    static final class C2169d implements C2161b {
        private final C3332d f3417a;
        private final boolean f3418b;
        private final C3334c f3419c;
        private final C2164b f3420d;
        private int f3421e;
        private boolean f3422f;

        C2169d(C3332d c3332d, boolean z) {
            this.f3417a = c3332d;
            this.f3418b = z;
            this.f3419c = new C3334c();
            this.f3420d = new C2164b(this.f3419c);
            this.f3421e = AccessibilityNodeInfoCompat.ACTION_COPY;
        }

        public synchronized void m5452b() throws IOException {
            if (this.f3422f) {
                throw new IOException("closed");
            }
            this.f3417a.flush();
        }

        public synchronized void m5447a(C2182k c2182k) throws IOException {
            if (this.f3422f) {
                throw new IOException("closed");
            }
            this.f3421e = c2182k.m5506d(this.f3421e);
            m5442a(0, 0, (byte) 4, (byte) 1);
            this.f3417a.flush();
        }

        public synchronized void m5440a() throws IOException {
            if (this.f3422f) {
                throw new IOException("closed");
            } else if (this.f3418b) {
                if (C2171e.f3423a.isLoggable(Level.FINE)) {
                    C2171e.f3423a.fine(String.format(">> CONNECTION %s", new Object[]{C2171e.f3424b.m10155d()}));
                }
                this.f3417a.m10169c(C2171e.f3424b.m10158g());
                this.f3417a.flush();
            }
        }

        public synchronized void m5451a(boolean z, boolean z2, int i, int i2, List<C2162c> list) throws IOException {
            if (z2) {
                throw new UnsupportedOperationException();
            } else if (this.f3422f) {
                throw new IOException("closed");
            } else {
                m5449a(z, i, (List) list);
            }
        }

        public synchronized void m5443a(int i, int i2, List<C2162c> list) throws IOException {
            if (this.f3422f) {
                throw new IOException("closed");
            } else if (this.f3419c.m10210b() != 0) {
                throw new IllegalStateException();
            } else {
                this.f3420d.m5414a((List) list);
                long b = this.f3419c.m10210b();
                int min = (int) Math.min((long) (this.f3421e - 4), b);
                m5442a(i, min + 4, (byte) 5, b == ((long) min) ? (byte) 4 : (byte) 0);
                this.f3417a.m10173f(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED & i2);
                this.f3417a.a_(this.f3419c, (long) min);
                if (b > ((long) min)) {
                    m5439b(i, b - ((long) min));
                }
            }
        }

        void m5449a(boolean z, int i, List<C2162c> list) throws IOException {
            if (this.f3422f) {
                throw new IOException("closed");
            } else if (this.f3419c.m10210b() != 0) {
                throw new IllegalStateException();
            } else {
                this.f3420d.m5414a((List) list);
                long b = this.f3419c.m10210b();
                int min = (int) Math.min((long) this.f3421e, b);
                byte b2 = b == ((long) min) ? (byte) 4 : (byte) 0;
                if (z) {
                    b2 = (byte) (b2 | 1);
                }
                m5442a(i, min, (byte) 1, b2);
                this.f3417a.a_(this.f3419c, (long) min);
                if (b > ((long) min)) {
                    m5439b(i, b - ((long) min));
                }
            }
        }

        private void m5439b(int i, long j) throws IOException {
            while (j > 0) {
                int min = (int) Math.min((long) this.f3421e, j);
                j -= (long) min;
                m5442a(i, min, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
                this.f3417a.a_(this.f3419c, (long) min);
            }
        }

        public synchronized void m5445a(int i, ErrorCode errorCode) throws IOException {
            if (this.f3422f) {
                throw new IOException("closed");
            } else if (errorCode.f3376t == -1) {
                throw new IllegalArgumentException();
            } else {
                m5442a(i, 4, (byte) 3, (byte) 0);
                this.f3417a.m10173f(errorCode.f3375s);
                this.f3417a.flush();
            }
        }

        public int m5454c() {
            return this.f3421e;
        }

        public synchronized void m5450a(boolean z, int i, C3334c c3334c, int i2) throws IOException {
            if (this.f3422f) {
                throw new IOException("closed");
            }
            byte b = (byte) 0;
            if (z) {
                b = (byte) 1;
            }
            m5441a(i, b, c3334c, i2);
        }

        void m5441a(int i, byte b, C3334c c3334c, int i2) throws IOException {
            m5442a(i, i2, (byte) 0, b);
            if (i2 > 0) {
                this.f3417a.a_(c3334c, (long) i2);
            }
        }

        public synchronized void m5453b(C2182k c2182k) throws IOException {
            synchronized (this) {
                if (this.f3422f) {
                    throw new IOException("closed");
                }
                m5442a(0, c2182k.m5502b() * 6, (byte) 4, (byte) 0);
                for (int i = 0; i < 10; i++) {
                    if (c2182k.m5501a(i)) {
                        int i2;
                        if (i == 4) {
                            i2 = 3;
                        } else if (i == 7) {
                            i2 = 4;
                        } else {
                            i2 = i;
                        }
                        this.f3417a.m10174g(i2);
                        this.f3417a.m10173f(c2182k.m5503b(i));
                    }
                }
                this.f3417a.flush();
            }
        }

        public synchronized void m5448a(boolean z, int i, int i2) throws IOException {
            byte b = (byte) 0;
            synchronized (this) {
                if (this.f3422f) {
                    throw new IOException("closed");
                }
                if (z) {
                    b = (byte) 1;
                }
                m5442a(0, 8, (byte) 6, b);
                this.f3417a.m10173f(i);
                this.f3417a.m10173f(i2);
                this.f3417a.flush();
            }
        }

        public synchronized void m5446a(int i, ErrorCode errorCode, byte[] bArr) throws IOException {
            if (this.f3422f) {
                throw new IOException("closed");
            } else if (errorCode.f3375s == -1) {
                throw C2171e.m5467c("errorCode.httpCode == -1", new Object[0]);
            } else {
                m5442a(0, bArr.length + 8, (byte) 7, (byte) 0);
                this.f3417a.m10173f(i);
                this.f3417a.m10173f(errorCode.f3375s);
                if (bArr.length > 0) {
                    this.f3417a.m10169c(bArr);
                }
                this.f3417a.flush();
            }
        }

        public synchronized void m5444a(int i, long j) throws IOException {
            if (this.f3422f) {
                throw new IOException("closed");
            } else if (j == 0 || j > 2147483647L) {
                throw C2171e.m5467c("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
            } else {
                m5442a(i, 4, (byte) 8, (byte) 0);
                this.f3417a.m10173f((int) j);
                this.f3417a.flush();
            }
        }

        public synchronized void close() throws IOException {
            this.f3422f = true;
            this.f3417a.close();
        }

        void m5442a(int i, int i2, byte b, byte b2) throws IOException {
            if (C2171e.f3423a.isLoggable(Level.FINE)) {
                C2171e.f3423a.fine(C2167b.m5425a(false, i, i2, b, b2));
            }
            if (i2 > this.f3421e) {
                throw C2171e.m5467c("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(this.f3421e), Integer.valueOf(i2));
            } else if ((Action.UNDEFINED_DURATION & i) != 0) {
                throw C2171e.m5467c("reserved bit set: %s", Integer.valueOf(i));
            } else {
                C2171e.m5466b(this.f3417a, i2);
                this.f3417a.m10175h(b & RangeSeekBar.INVALID_POINTER_ID);
                this.f3417a.m10175h(b2 & RangeSeekBar.INVALID_POINTER_ID);
                this.f3417a.m10173f(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED & i);
            }
        }
    }

    static {
        f3423a = Logger.getLogger(C2167b.class.getName());
        f3424b = ByteString.m10145a("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    }

    public C2160a m5469a(C3333e c3333e, boolean z) {
        return new C2168c(c3333e, AccessibilityNodeInfoCompat.ACTION_SCROLL_FORWARD, z);
    }

    public C2161b m5470a(C3332d c3332d, boolean z) {
        return new C2169d(c3332d, z);
    }

    private static IllegalArgumentException m5467c(String str, Object... objArr) {
        throw new IllegalArgumentException(String.format(str, objArr));
    }

    private static IOException m5468d(String str, Object... objArr) throws IOException {
        throw new IOException(String.format(str, objArr));
    }

    private static int m5462b(int i, byte b, short s) throws IOException {
        if ((b & 8) != 0) {
            short s2 = i - 1;
        }
        if (s <= s2) {
            return (short) (s2 - s);
        }
        throw C2171e.m5468d("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(s2));
    }

    private static int m5463b(C3333e c3333e) throws IOException {
        return (((c3333e.m10187j() & RangeSeekBar.INVALID_POINTER_ID) << 16) | ((c3333e.m10187j() & RangeSeekBar.INVALID_POINTER_ID) << 8)) | (c3333e.m10187j() & RangeSeekBar.INVALID_POINTER_ID);
    }

    private static void m5466b(C3332d c3332d, int i) throws IOException {
        c3332d.m10175h((i >>> 16) & RangeSeekBar.INVALID_POINTER_ID);
        c3332d.m10175h((i >>> 8) & RangeSeekBar.INVALID_POINTER_ID);
        c3332d.m10175h(i & RangeSeekBar.INVALID_POINTER_ID);
    }
}
