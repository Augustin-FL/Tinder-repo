package com.squareup.okhttp.internal.spdy;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.facebook.share.internal.ShareConstants;
import com.facebook.stetho.BuildConfig;
import com.tinder.views.RangeSeekBar;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import okio.C2076r;
import okio.C3333e;
import okio.C3334c;
import okio.C3342l;
import org.apache.http.HttpHost;

/* renamed from: com.squareup.okhttp.internal.spdy.d */
final class C2165d {
    private static final C2162c[] f3402a;
    private static final Map<ByteString, Integer> f3403b;

    /* renamed from: com.squareup.okhttp.internal.spdy.d.a */
    static final class C2163a {
        C2162c[] f3393a;
        int f3394b;
        int f3395c;
        int f3396d;
        private final List<C2162c> f3397e;
        private final C3333e f3398f;
        private int f3399g;
        private int f3400h;

        C2163a(int i, C2076r c2076r) {
            this.f3397e = new ArrayList();
            this.f3393a = new C2162c[8];
            this.f3394b = this.f3393a.length - 1;
            this.f3395c = 0;
            this.f3396d = 0;
            this.f3399g = i;
            this.f3400h = i;
            this.f3398f = C3342l.m10280a(c2076r);
        }

        void m5410a(int i) {
            this.f3399g = i;
            this.f3400h = i;
            m5399d();
        }

        private void m5399d() {
            if (this.f3400h >= this.f3396d) {
                return;
            }
            if (this.f3400h == 0) {
                m5400e();
            } else {
                m5396b(this.f3396d - this.f3400h);
            }
        }

        private void m5400e() {
            this.f3397e.clear();
            Arrays.fill(this.f3393a, null);
            this.f3394b = this.f3393a.length - 1;
            this.f3395c = 0;
            this.f3396d = 0;
        }

        private int m5396b(int i) {
            int i2 = 0;
            if (i > 0) {
                for (int length = this.f3393a.length - 1; length >= this.f3394b && i > 0; length--) {
                    i -= this.f3393a[length].f3392j;
                    this.f3396d -= this.f3393a[length].f3392j;
                    this.f3395c--;
                    i2++;
                }
                System.arraycopy(this.f3393a, this.f3394b + 1, this.f3393a, (this.f3394b + 1) + i2, this.f3395c);
                this.f3394b += i2;
            }
            return i2;
        }

        void m5409a() throws IOException {
            while (!this.f3398f.m10185g()) {
                int j = this.f3398f.m10187j() & RangeSeekBar.INVALID_POINTER_ID;
                if (j == AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) {
                    throw new IOException("index == 0");
                } else if ((j & AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) == AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) {
                    m5397c(m5408a(j, (int) TransportMediator.KEYCODE_MEDIA_PAUSE) - 1);
                } else if (j == 64) {
                    m5405g();
                } else if ((j & 64) == 64) {
                    m5403f(m5408a(j, 63) - 1);
                } else if ((j & 32) == 32) {
                    this.f3400h = m5408a(j, 31);
                    if (this.f3400h < 0 || this.f3400h > this.f3399g) {
                        throw new IOException("Invalid dynamic table size update " + this.f3400h);
                    }
                    m5399d();
                } else if (j == 16 || j == 0) {
                    m5402f();
                } else {
                    m5401e(m5408a(j, 15) - 1);
                }
            }
        }

        public List<C2162c> m5411b() {
            List arrayList = new ArrayList(this.f3397e);
            this.f3397e.clear();
            return arrayList;
        }

        private void m5397c(int i) throws IOException {
            if (m5407h(i)) {
                this.f3397e.add(C2165d.f3402a[i]);
                return;
            }
            int d = m5398d(i - C2165d.f3402a.length);
            if (d < 0 || d > this.f3393a.length - 1) {
                throw new IOException("Header index too large " + (i + 1));
            }
            this.f3397e.add(this.f3393a[d]);
        }

        private int m5398d(int i) {
            return (this.f3394b + 1) + i;
        }

        private void m5401e(int i) throws IOException {
            this.f3397e.add(new C2162c(m5404g(i), m5412c()));
        }

        private void m5402f() throws IOException {
            this.f3397e.add(new C2162c(C2165d.m5419b(m5412c()), m5412c()));
        }

        private void m5403f(int i) throws IOException {
            m5395a(-1, new C2162c(m5404g(i), m5412c()));
        }

        private void m5405g() throws IOException {
            m5395a(-1, new C2162c(C2165d.m5419b(m5412c()), m5412c()));
        }

        private ByteString m5404g(int i) {
            if (m5407h(i)) {
                return C2165d.f3402a[i].f3390h;
            }
            return this.f3393a[m5398d(i - C2165d.f3402a.length)].f3390h;
        }

        private boolean m5407h(int i) {
            return i >= 0 && i <= C2165d.f3402a.length - 1;
        }

        private void m5395a(int i, C2162c c2162c) {
            this.f3397e.add(c2162c);
            int i2 = c2162c.f3392j;
            if (i != -1) {
                i2 -= this.f3393a[m5398d(i)].f3392j;
            }
            if (i2 > this.f3400h) {
                m5400e();
                return;
            }
            int b = m5396b((this.f3396d + i2) - this.f3400h);
            if (i == -1) {
                if (this.f3395c + 1 > this.f3393a.length) {
                    Object obj = new C2162c[(this.f3393a.length * 2)];
                    System.arraycopy(this.f3393a, 0, obj, this.f3393a.length, this.f3393a.length);
                    this.f3394b = this.f3393a.length - 1;
                    this.f3393a = obj;
                }
                b = this.f3394b;
                this.f3394b = b - 1;
                this.f3393a[b] = c2162c;
                this.f3395c++;
            } else {
                this.f3393a[(b + m5398d(i)) + i] = c2162c;
            }
            this.f3396d = i2 + this.f3396d;
        }

        private int m5406h() throws IOException {
            return this.f3398f.m10187j() & RangeSeekBar.INVALID_POINTER_ID;
        }

        int m5408a(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            i3 = 0;
            while (true) {
                int h = m5406h();
                if ((h & AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) == 0) {
                    return (h << i3) + i2;
                }
                i2 += (h & TransportMediator.KEYCODE_MEDIA_PAUSE) << i3;
                i3 += 7;
            }
        }

        ByteString m5412c() throws IOException {
            int h = m5406h();
            Object obj = (h & AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) == AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS ? 1 : null;
            h = m5408a(h, (int) TransportMediator.KEYCODE_MEDIA_PAUSE);
            if (obj != null) {
                return ByteString.m10146a(C2173f.m5474a().m5477a(this.f3398f.m10183f((long) h)));
            }
            return this.f3398f.m10181c((long) h);
        }
    }

    /* renamed from: com.squareup.okhttp.internal.spdy.d.b */
    static final class C2164b {
        private final C3334c f3401a;

        C2164b(C3334c c3334c) {
            this.f3401a = c3334c;
        }

        void m5414a(List<C2162c> list) throws IOException {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ByteString e = ((C2162c) list.get(i)).f3390h.m10156e();
                Integer num = (Integer) C2165d.f3403b.get(e);
                if (num != null) {
                    m5413a(num.intValue() + 1, 15, 0);
                    m5415a(((C2162c) list.get(i)).f3391i);
                } else {
                    this.f3401a.m10211b(0);
                    m5415a(e);
                    m5415a(((C2162c) list.get(i)).f3391i);
                }
            }
        }

        void m5413a(int i, int i2, int i3) throws IOException {
            if (i < i2) {
                this.f3401a.m10211b(i3 | i);
                return;
            }
            this.f3401a.m10211b(i3 | i2);
            int i4 = i - i2;
            while (i4 >= AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) {
                this.f3401a.m10211b((i4 & TransportMediator.KEYCODE_MEDIA_PAUSE) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
                i4 >>>= 7;
            }
            this.f3401a.m10211b(i4);
        }

        void m5415a(ByteString byteString) throws IOException {
            m5413a(byteString.m10157f(), TransportMediator.KEYCODE_MEDIA_PAUSE, 0);
            this.f3401a.m10204a(byteString);
        }
    }

    static {
        f3402a = new C2162c[]{new C2162c(C2162c.f3387e, BuildConfig.FLAVOR), new C2162c(C2162c.f3384b, "GET"), new C2162c(C2162c.f3384b, "POST"), new C2162c(C2162c.f3385c, "/"), new C2162c(C2162c.f3385c, "/index.html"), new C2162c(C2162c.f3386d, HttpHost.DEFAULT_SCHEME_NAME), new C2162c(C2162c.f3386d, "https"), new C2162c(C2162c.f3383a, "200"), new C2162c(C2162c.f3383a, "204"), new C2162c(C2162c.f3383a, "206"), new C2162c(C2162c.f3383a, "304"), new C2162c(C2162c.f3383a, "400"), new C2162c(C2162c.f3383a, "404"), new C2162c(C2162c.f3383a, "500"), new C2162c("accept-charset", BuildConfig.FLAVOR), new C2162c("accept-encoding", "gzip, deflate"), new C2162c("accept-language", BuildConfig.FLAVOR), new C2162c("accept-ranges", BuildConfig.FLAVOR), new C2162c("accept", BuildConfig.FLAVOR), new C2162c("access-control-allow-origin", BuildConfig.FLAVOR), new C2162c("age", BuildConfig.FLAVOR), new C2162c("allow", BuildConfig.FLAVOR), new C2162c("authorization", BuildConfig.FLAVOR), new C2162c("cache-control", BuildConfig.FLAVOR), new C2162c("content-disposition", BuildConfig.FLAVOR), new C2162c("content-encoding", BuildConfig.FLAVOR), new C2162c("content-language", BuildConfig.FLAVOR), new C2162c("content-length", BuildConfig.FLAVOR), new C2162c("content-location", BuildConfig.FLAVOR), new C2162c("content-range", BuildConfig.FLAVOR), new C2162c("content-type", BuildConfig.FLAVOR), new C2162c("cookie", BuildConfig.FLAVOR), new C2162c("date", BuildConfig.FLAVOR), new C2162c("etag", BuildConfig.FLAVOR), new C2162c("expect", BuildConfig.FLAVOR), new C2162c("expires", BuildConfig.FLAVOR), new C2162c("from", BuildConfig.FLAVOR), new C2162c("host", BuildConfig.FLAVOR), new C2162c("if-match", BuildConfig.FLAVOR), new C2162c("if-modified-since", BuildConfig.FLAVOR), new C2162c("if-none-match", BuildConfig.FLAVOR), new C2162c("if-range", BuildConfig.FLAVOR), new C2162c("if-unmodified-since", BuildConfig.FLAVOR), new C2162c("last-modified", BuildConfig.FLAVOR), new C2162c(ShareConstants.WEB_DIALOG_PARAM_LINK, BuildConfig.FLAVOR), new C2162c("location", BuildConfig.FLAVOR), new C2162c("max-forwards", BuildConfig.FLAVOR), new C2162c("proxy-authenticate", BuildConfig.FLAVOR), new C2162c("proxy-authorization", BuildConfig.FLAVOR), new C2162c("range", BuildConfig.FLAVOR), new C2162c("referer", BuildConfig.FLAVOR), new C2162c("refresh", BuildConfig.FLAVOR), new C2162c("retry-after", BuildConfig.FLAVOR), new C2162c("server", BuildConfig.FLAVOR), new C2162c("set-cookie", BuildConfig.FLAVOR), new C2162c("strict-transport-security", BuildConfig.FLAVOR), new C2162c("transfer-encoding", BuildConfig.FLAVOR), new C2162c("user-agent", BuildConfig.FLAVOR), new C2162c("vary", BuildConfig.FLAVOR), new C2162c("via", BuildConfig.FLAVOR), new C2162c("www-authenticate", BuildConfig.FLAVOR)};
        f3403b = C2165d.m5420c();
    }

    private static Map<ByteString, Integer> m5420c() {
        Map linkedHashMap = new LinkedHashMap(f3402a.length);
        for (int i = 0; i < f3402a.length; i++) {
            if (!linkedHashMap.containsKey(f3402a[i].f3390h)) {
                linkedHashMap.put(f3402a[i].f3390h, Integer.valueOf(i));
            }
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    private static ByteString m5419b(ByteString byteString) throws IOException {
        int i = 0;
        int f = byteString.m10157f();
        while (i < f) {
            byte a = byteString.m10149a(i);
            if (a < 65 || a > 90) {
                i++;
            } else {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.m10150a());
            }
        }
        return byteString;
    }
}
