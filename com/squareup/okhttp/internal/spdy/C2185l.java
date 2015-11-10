package com.squareup.okhttp.internal.spdy;

import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView.SmoothScroller.Action;
import com.squareup.okhttp.internal.C2157k;
import com.squareup.okhttp.internal.spdy.C2160a.C2159a;
import com.tinder.views.RangeSeekBar;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.util.List;
import java.util.zip.Deflater;
import okio.ByteString;
import okio.C3332d;
import okio.C3333e;
import okio.C3334c;
import okio.C3335f;
import okio.C3342l;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.squareup.okhttp.internal.spdy.l */
public final class C2185l implements C2170o {
    static final byte[] f3454a;

    /* renamed from: com.squareup.okhttp.internal.spdy.l.a */
    static final class C2183a implements C2160a {
        private final C3333e f3446a;
        private final boolean f3447b;
        private final C2178h f3448c;

        C2183a(C3333e c3333e, boolean z) {
            this.f3446a = c3333e;
            this.f3448c = new C2178h(this.f3446a);
            this.f3447b = z;
        }

        public void m5519a() {
        }

        public boolean m5520a(C2159a c2159a) throws IOException {
            boolean z = false;
            try {
                int l = this.f3446a.m10189l();
                int l2 = this.f3446a.m10189l();
                int i = (ViewCompat.MEASURED_STATE_MASK & l2) >>> 24;
                l2 &= ViewCompat.MEASURED_SIZE_MASK;
                int i2;
                if ((Action.UNDEFINED_DURATION & l) != 0) {
                    int i3 = (2147418112 & l) >>> 16;
                    i2 = SupportMenu.USER_MASK & l;
                    if (i3 != 3) {
                        throw new ProtocolException("version != 3: " + i3);
                    }
                    switch (i2) {
                        case C3374b.SmoothProgressBar_spb_color /*1*/:
                            m5511a(c2159a, i, l2);
                            return true;
                        case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                            m5512b(c2159a, i, l2);
                            return true;
                        case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                            m5513c(c2159a, i, l2);
                            return true;
                        case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                            m5518h(c2159a, i, l2);
                            return true;
                        case C3374b.SmoothProgressBar_spb_progressiveStart_speed /*6*/:
                            m5516f(c2159a, i, l2);
                            return true;
                        case C3374b.SmoothProgressBar_spb_progressiveStop_speed /*7*/:
                            m5517g(c2159a, i, l2);
                            return true;
                        case C3374b.SmoothProgressBar_spb_interpolator /*8*/:
                            m5514d(c2159a, i, l2);
                            return true;
                        case C3374b.SmoothProgressBar_spb_reversed /*9*/:
                            m5515e(c2159a, i, l2);
                            return true;
                        default:
                            this.f3446a.m10184g((long) l2);
                            return true;
                    }
                }
                i2 = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED & l;
                if ((i & 1) != 0) {
                    z = true;
                }
                c2159a.m5377a(z, i2, this.f3446a, l2);
                return true;
            } catch (IOException e) {
                return false;
            }
        }

        private void m5511a(C2159a c2159a, int i, int i2) throws IOException {
            boolean z;
            boolean z2 = true;
            int l = this.f3446a.m10189l();
            int i3 = l & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            int l2 = this.f3446a.m10189l() & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            this.f3446a.m10188k();
            List a = this.f3448c.m5485a(i2 - 10);
            if ((i & 1) != 0) {
                z = true;
            } else {
                z = false;
            }
            if ((i & 2) == 0) {
                z2 = false;
            }
            c2159a.m5379a(z2, z, i3, l2, a, HeadersMode.SPDY_SYN_STREAM);
        }

        private void m5512b(C2159a c2159a, int i, int i2) throws IOException {
            boolean z;
            int l = this.f3446a.m10189l() & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            List a = this.f3448c.m5485a(i2 - 4);
            if ((i & 1) != 0) {
                z = true;
            } else {
                z = false;
            }
            c2159a.m5379a(false, z, l, -1, a, HeadersMode.SPDY_REPLY);
        }

        private void m5513c(C2159a c2159a, int i, int i2) throws IOException {
            if (i2 != 8) {
                throw C2183a.m5510a("TYPE_RST_STREAM length: %d != 8", Integer.valueOf(i2));
            }
            int l = this.f3446a.m10189l() & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            ErrorCode a = ErrorCode.m5364a(this.f3446a.m10189l());
            if (a == null) {
                throw C2183a.m5510a("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(r1));
            } else {
                c2159a.m5374a(l, a);
            }
        }

        private void m5514d(C2159a c2159a, int i, int i2) throws IOException {
            c2159a.m5379a(false, false, this.f3446a.m10189l() & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, -1, this.f3448c.m5485a(i2 - 4), HeadersMode.SPDY_HEADERS);
        }

        private void m5515e(C2159a c2159a, int i, int i2) throws IOException {
            if (i2 != 8) {
                throw C2183a.m5510a("TYPE_WINDOW_UPDATE length: %d != 8", Integer.valueOf(i2));
            }
            int l = this.f3446a.m10189l() & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            long l2 = (long) (this.f3446a.m10189l() & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            if (l2 == 0) {
                throw C2183a.m5510a("windowSizeIncrement was 0", Long.valueOf(l2));
            } else {
                c2159a.m5373a(l, l2);
            }
        }

        private void m5516f(C2159a c2159a, int i, int i2) throws IOException {
            boolean z = true;
            if (i2 != 4) {
                throw C2183a.m5510a("TYPE_PING length: %d != 4", Integer.valueOf(i2));
            }
            boolean z2;
            int l = this.f3446a.m10189l();
            boolean z3 = this.f3447b;
            if ((l & 1) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z3 != z2) {
                z = false;
            }
            c2159a.m5376a(z, l, 0);
        }

        private void m5517g(C2159a c2159a, int i, int i2) throws IOException {
            if (i2 != 8) {
                throw C2183a.m5510a("TYPE_GOAWAY length: %d != 8", Integer.valueOf(i2));
            }
            int l = this.f3446a.m10189l() & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            ErrorCode c = ErrorCode.m5366c(this.f3446a.m10189l());
            if (c == null) {
                throw C2183a.m5510a("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(r1));
            } else {
                c2159a.m5375a(l, c, ByteString.f7266b);
            }
        }

        private void m5518h(C2159a c2159a, int i, int i2) throws IOException {
            boolean z = true;
            int l = this.f3446a.m10189l();
            if (i2 != (l * 8) + 4) {
                throw C2183a.m5510a("TYPE_SETTINGS length: %d != 4 + 8 * %d", Integer.valueOf(i2), Integer.valueOf(l));
            }
            C2182k c2182k = new C2182k();
            for (int i3 = 0; i3 < l; i3++) {
                int l2 = this.f3446a.m10189l();
                int i4 = (ViewCompat.MEASURED_STATE_MASK & l2) >>> 24;
                c2182k.m5498a(l2 & ViewCompat.MEASURED_SIZE_MASK, i4, this.f3446a.m10189l());
            }
            if ((i & 1) == 0) {
                z = false;
            }
            c2159a.m5378a(z, c2182k);
        }

        private static IOException m5510a(String str, Object... objArr) throws IOException {
            throw new IOException(String.format(str, objArr));
        }

        public void close() throws IOException {
            this.f3448c.m5486a();
        }
    }

    /* renamed from: com.squareup.okhttp.internal.spdy.l.b */
    static final class C2184b implements C2161b {
        private final C3332d f3449a;
        private final C3334c f3450b;
        private final C3332d f3451c;
        private final boolean f3452d;
        private boolean f3453e;

        C2184b(C3332d c3332d, boolean z) {
            this.f3449a = c3332d;
            this.f3452d = z;
            Deflater deflater = new Deflater();
            deflater.setDictionary(C2185l.f3454a);
            this.f3450b = new C3334c();
            this.f3451c = C3342l.m10279a(new C3335f(this.f3450b, deflater));
        }

        public void m5528a(C2182k c2182k) {
        }

        public void m5523a(int i, int i2, List<C2162c> list) throws IOException {
        }

        public synchronized void m5522a() {
        }

        public synchronized void m5532b() throws IOException {
            if (this.f3453e) {
                throw new IOException("closed");
            }
            this.f3449a.flush();
        }

        public synchronized void m5531a(boolean z, boolean z2, int i, int i2, List<C2162c> list) throws IOException {
            int i3 = 0;
            synchronized (this) {
                if (this.f3453e) {
                    throw new IOException("closed");
                }
                m5521a((List) list);
                int b = (int) (10 + this.f3450b.m10210b());
                int i4 = z ? 1 : 0;
                if (z2) {
                    i3 = 2;
                }
                i3 |= i4;
                this.f3449a.m10173f(-2147287039);
                this.f3449a.m10173f(((i3 & RangeSeekBar.INVALID_POINTER_ID) << 24) | (b & ViewCompat.MEASURED_SIZE_MASK));
                this.f3449a.m10173f(i & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                this.f3449a.m10173f(i2 & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                this.f3449a.m10174g(0);
                this.f3449a.m10165a(this.f3450b);
                this.f3449a.flush();
            }
        }

        public synchronized void m5526a(int i, ErrorCode errorCode) throws IOException {
            if (this.f3453e) {
                throw new IOException("closed");
            } else if (errorCode.f3376t == -1) {
                throw new IllegalArgumentException();
            } else {
                this.f3449a.m10173f(-2147287037);
                this.f3449a.m10173f(8);
                this.f3449a.m10173f(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED & i);
                this.f3449a.m10173f(errorCode.f3376t);
                this.f3449a.flush();
            }
        }

        public int m5534c() {
            return 16383;
        }

        public synchronized void m5530a(boolean z, int i, C3334c c3334c, int i2) throws IOException {
            m5524a(i, z ? 1 : 0, c3334c, i2);
        }

        void m5524a(int i, int i2, C3334c c3334c, int i3) throws IOException {
            if (this.f3453e) {
                throw new IOException("closed");
            } else if (((long) i3) > 16777215) {
                throw new IllegalArgumentException("FRAME_TOO_LARGE max size is 16Mib: " + i3);
            } else {
                this.f3449a.m10173f(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED & i);
                this.f3449a.m10173f(((i2 & RangeSeekBar.INVALID_POINTER_ID) << 24) | (ViewCompat.MEASURED_SIZE_MASK & i3));
                if (i3 > 0) {
                    this.f3449a.a_(c3334c, (long) i3);
                }
            }
        }

        private void m5521a(List<C2162c> list) throws IOException {
            if (this.f3450b.m10210b() != 0) {
                throw new IllegalStateException();
            }
            this.f3451c.m10173f(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ByteString byteString = ((C2162c) list.get(i)).f3390h;
                this.f3451c.m10173f(byteString.m10157f());
                this.f3451c.m10167b(byteString);
                byteString = ((C2162c) list.get(i)).f3391i;
                this.f3451c.m10173f(byteString.m10157f());
                this.f3451c.m10167b(byteString);
            }
            this.f3451c.flush();
        }

        public synchronized void m5533b(C2182k c2182k) throws IOException {
            if (this.f3453e) {
                throw new IOException("closed");
            }
            int b = c2182k.m5502b();
            int i = (b * 8) + 4;
            this.f3449a.m10173f(-2147287036);
            this.f3449a.m10173f((i & ViewCompat.MEASURED_SIZE_MASK) | 0);
            this.f3449a.m10173f(b);
            for (b = 0; b <= 10; b++) {
                if (c2182k.m5501a(b)) {
                    this.f3449a.m10173f(((c2182k.m5505c(b) & RangeSeekBar.INVALID_POINTER_ID) << 24) | (b & ViewCompat.MEASURED_SIZE_MASK));
                    this.f3449a.m10173f(c2182k.m5503b(b));
                }
            }
            this.f3449a.flush();
        }

        public synchronized void m5529a(boolean z, int i, int i2) throws IOException {
            boolean z2 = true;
            synchronized (this) {
                if (this.f3453e) {
                    throw new IOException("closed");
                }
                boolean z3;
                boolean z4 = this.f3452d;
                if ((i & 1) == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z4 == z3) {
                    z2 = false;
                }
                if (z != z2) {
                    throw new IllegalArgumentException("payload != reply");
                }
                this.f3449a.m10173f(-2147287034);
                this.f3449a.m10173f(4);
                this.f3449a.m10173f(i);
                this.f3449a.flush();
            }
        }

        public synchronized void m5527a(int i, ErrorCode errorCode, byte[] bArr) throws IOException {
            if (this.f3453e) {
                throw new IOException("closed");
            } else if (errorCode.f3377u == -1) {
                throw new IllegalArgumentException("errorCode.spdyGoAwayCode == -1");
            } else {
                this.f3449a.m10173f(-2147287033);
                this.f3449a.m10173f(8);
                this.f3449a.m10173f(i);
                this.f3449a.m10173f(errorCode.f3377u);
                this.f3449a.flush();
            }
        }

        public synchronized void m5525a(int i, long j) throws IOException {
            if (this.f3453e) {
                throw new IOException("closed");
            } else if (j == 0 || j > 2147483647L) {
                throw new IllegalArgumentException("windowSizeIncrement must be between 1 and 0x7fffffff: " + j);
            } else {
                this.f3449a.m10173f(-2147287031);
                this.f3449a.m10173f(8);
                this.f3449a.m10173f(i);
                this.f3449a.m10173f((int) j);
                this.f3449a.flush();
            }
        }

        public synchronized void close() throws IOException {
            this.f3453e = true;
            C2157k.m5356a(this.f3449a, this.f3451c);
        }
    }

    static {
        try {
            f3454a = "\u0000\u0000\u0000\u0007options\u0000\u0000\u0000\u0004head\u0000\u0000\u0000\u0004post\u0000\u0000\u0000\u0003put\u0000\u0000\u0000\u0006delete\u0000\u0000\u0000\u0005trace\u0000\u0000\u0000\u0006accept\u0000\u0000\u0000\u000eaccept-charset\u0000\u0000\u0000\u000faccept-encoding\u0000\u0000\u0000\u000faccept-language\u0000\u0000\u0000\raccept-ranges\u0000\u0000\u0000\u0003age\u0000\u0000\u0000\u0005allow\u0000\u0000\u0000\rauthorization\u0000\u0000\u0000\rcache-control\u0000\u0000\u0000\nconnection\u0000\u0000\u0000\fcontent-base\u0000\u0000\u0000\u0010content-encoding\u0000\u0000\u0000\u0010content-language\u0000\u0000\u0000\u000econtent-length\u0000\u0000\u0000\u0010content-location\u0000\u0000\u0000\u000bcontent-md5\u0000\u0000\u0000\rcontent-range\u0000\u0000\u0000\fcontent-type\u0000\u0000\u0000\u0004date\u0000\u0000\u0000\u0004etag\u0000\u0000\u0000\u0006expect\u0000\u0000\u0000\u0007expires\u0000\u0000\u0000\u0004from\u0000\u0000\u0000\u0004host\u0000\u0000\u0000\bif-match\u0000\u0000\u0000\u0011if-modified-since\u0000\u0000\u0000\rif-none-match\u0000\u0000\u0000\bif-range\u0000\u0000\u0000\u0013if-unmodified-since\u0000\u0000\u0000\rlast-modified\u0000\u0000\u0000\blocation\u0000\u0000\u0000\fmax-forwards\u0000\u0000\u0000\u0006pragma\u0000\u0000\u0000\u0012proxy-authenticate\u0000\u0000\u0000\u0013proxy-authorization\u0000\u0000\u0000\u0005range\u0000\u0000\u0000\u0007referer\u0000\u0000\u0000\u000bretry-after\u0000\u0000\u0000\u0006server\u0000\u0000\u0000\u0002te\u0000\u0000\u0000\u0007trailer\u0000\u0000\u0000\u0011transfer-encoding\u0000\u0000\u0000\u0007upgrade\u0000\u0000\u0000\nuser-agent\u0000\u0000\u0000\u0004vary\u0000\u0000\u0000\u0003via\u0000\u0000\u0000\u0007warning\u0000\u0000\u0000\u0010www-authenticate\u0000\u0000\u0000\u0006method\u0000\u0000\u0000\u0003get\u0000\u0000\u0000\u0006status\u0000\u0000\u0000\u0006200 OK\u0000\u0000\u0000\u0007version\u0000\u0000\u0000\bHTTP/1.1\u0000\u0000\u0000\u0003url\u0000\u0000\u0000\u0006public\u0000\u0000\u0000\nset-cookie\u0000\u0000\u0000\nkeep-alive\u0000\u0000\u0000\u0006origin100101201202205206300302303304305306307402405406407408409410411412413414415416417502504505203 Non-Authoritative Information204 No Content301 Moved Permanently400 Bad Request401 Unauthorized403 Forbidden404 Not Found500 Internal Server Error501 Not Implemented503 Service UnavailableJan Feb Mar Apr May Jun Jul Aug Sept Oct Nov Dec 00:00:00 Mon, Tue, Wed, Thu, Fri, Sat, Sun, GMTchunked,text/html,image/png,image/jpg,image/gif,application/xml,application/xhtml+xml,text/plain,text/javascript,publicprivatemax-age=gzip,deflate,sdchcharset=utf-8charset=iso-8859-1,utf-,*,enq=0.".getBytes(C2157k.f3355c.name());
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError();
        }
    }

    public C2160a m5535a(C3333e c3333e, boolean z) {
        return new C2183a(c3333e, z);
    }

    public C2161b m5536a(C3332d c3332d, boolean z) {
        return new C2184b(c3332d, z);
    }
}
