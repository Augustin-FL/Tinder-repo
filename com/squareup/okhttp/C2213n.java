package com.squareup.okhttp;

import android.support.v4.internal.view.SupportMenu;
import android.support.v4.media.TransportMediator;
import com.facebook.stetho.BuildConfig;
import com.tinder.views.RangeSeekBar;
import com.viewpagerindicator.C3169d.C3168f;
import java.net.IDN;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import okio.C3334c;
import org.apache.http.HttpHost;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.protocol.HTTP;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.squareup.okhttp.n */
public final class C2213n {
    private static final char[] f3569a;
    private final String f3570b;
    private final String f3571c;
    private final String f3572d;
    private final String f3573e;
    private final int f3574f;
    private final List<String> f3575g;
    private final List<String> f3576h;
    private final String f3577i;
    private final String f3578j;

    /* renamed from: com.squareup.okhttp.n.a */
    public static final class C2212a {
        String f3561a;
        String f3562b;
        String f3563c;
        String f3564d;
        int f3565e;
        final List<String> f3566f;
        List<String> f3567g;
        String f3568h;

        public C2212a() {
            this.f3562b = BuildConfig.FLAVOR;
            this.f3563c = BuildConfig.FLAVOR;
            this.f3565e = -1;
            this.f3566f = new ArrayList();
            this.f3566f.add(BuildConfig.FLAVOR);
        }

        int m5709a() {
            return this.f3565e != -1 ? this.f3565e : C2213n.m5714a(this.f3561a);
        }

        public C2212a m5710a(String str) {
            this.f3567g = str != null ? C2213n.m5727b(C2213n.m5720a(str, " \"'<>#", true, true)) : null;
            return this;
        }

        public C2213n m5712b() {
            if (this.f3561a == null) {
                throw new IllegalStateException("scheme == null");
            } else if (this.f3564d != null) {
                return new C2213n();
            } else {
                throw new IllegalStateException("host == null");
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f3561a);
            stringBuilder.append("://");
            if (!(this.f3562b.isEmpty() && this.f3563c.isEmpty())) {
                stringBuilder.append(this.f3562b);
                if (!this.f3563c.isEmpty()) {
                    stringBuilder.append(':');
                    stringBuilder.append(this.f3563c);
                }
                stringBuilder.append('@');
            }
            if (this.f3564d.indexOf(58) != -1) {
                stringBuilder.append('[');
                stringBuilder.append(this.f3564d);
                stringBuilder.append(']');
            } else {
                stringBuilder.append(this.f3564d);
            }
            int a = m5709a();
            if (a != C2213n.m5714a(this.f3561a)) {
                stringBuilder.append(':');
                stringBuilder.append(a);
            }
            C2213n.m5722a(stringBuilder, this.f3566f);
            if (this.f3567g != null) {
                stringBuilder.append('?');
                C2213n.m5728b(stringBuilder, this.f3567g);
            }
            if (this.f3568h != null) {
                stringBuilder.append('#');
                stringBuilder.append(this.f3568h);
            }
            return stringBuilder.toString();
        }

        C2213n m5711a(C2213n c2213n, String str) {
            int f;
            int b = m5697b(str, 0, str.length());
            int c = m5699c(str, b, str.length());
            if (C2212a.m5702d(str, b, c) != -1) {
                if (str.regionMatches(true, b, "https:", 0, 6)) {
                    this.f3561a = "https";
                    b += "https:".length();
                } else {
                    if (!str.regionMatches(true, b, "http:", 0, 5)) {
                        return null;
                    }
                    this.f3561a = HttpHost.DEFAULT_SCHEME_NAME;
                    b += "http:".length();
                }
            } else if (c2213n == null) {
                return null;
            } else {
                this.f3561a = c2213n.f3570b;
            }
            int e = C2212a.m5704e(str, b, c);
            if (e >= 2 || c2213n == null || !c2213n.f3570b.equals(this.f3561a)) {
                Object obj = null;
                Object obj2 = null;
                int i = b + e;
                while (true) {
                    Object obj3;
                    Object obj4;
                    int a = C2213n.m5725b(str, i, c, "@/\\?#");
                    switch (a != c ? str.charAt(a) : '\uffff') {
                        case ContentLengthStrategy.IDENTITY /*-1*/:
                        case C3168f.Theme_actionModeSelectAllDrawable /*35*/:
                        case C3168f.Theme_spinnerDropDownItemStyle /*47*/:
                        case C3168f.Theme_editTextBackground /*63*/:
                        case C3168f.Theme_alertDialogTheme /*92*/:
                            f = C2212a.m5705f(str, i, a);
                            if (f + 1 < a) {
                                this.f3564d = C2212a.m5706g(str, i, f);
                                this.f3565e = C2212a.m5708i(str, f + 1, a);
                                if (this.f3565e == -1) {
                                    return null;
                                }
                            }
                            this.f3564d = C2212a.m5706g(str, i, f);
                            this.f3565e = C2213n.m5714a(this.f3561a);
                            if (this.f3564d != null) {
                                b = a;
                                break;
                            }
                            return null;
                        case C3168f.Theme_textAppearanceSearchResultTitle /*64*/:
                            if (obj == null) {
                                b = C2213n.m5725b(str, i, a, ":");
                                String a2 = C2213n.m5719a(str, i, b, " \"':;<=>@[]^`{}|/\\?#", true, false);
                                if (obj2 != null) {
                                    a2 = this.f3562b + "%40" + a2;
                                }
                                this.f3562b = a2;
                                if (b != a) {
                                    obj = 1;
                                    this.f3563c = C2213n.m5719a(str, b + 1, a, " \"':;<=>@[]\\^`{}|/\\?#", true, false);
                                }
                                obj2 = 1;
                            } else {
                                this.f3563c += "%40" + C2213n.m5719a(str, i, a, " \"':;<=>@[]\\^`{}|/\\?#", true, false);
                            }
                            b = a + 1;
                            obj3 = obj;
                            obj4 = obj2;
                            continue;
                        default:
                            obj3 = obj;
                            b = i;
                            obj4 = obj2;
                            continue;
                    }
                    obj = obj3;
                    obj2 = obj4;
                    i = b;
                }
            } else {
                this.f3562b = c2213n.m5735d();
                this.f3563c = c2213n.m5736e();
                this.f3564d = c2213n.f3573e;
                this.f3565e = c2213n.f3574f;
                this.f3566f.clear();
                this.f3566f.addAll(c2213n.m5737f());
                if (b == c || str.charAt(b) == '#') {
                    m5710a(c2213n.m5738g());
                }
            }
            f = C2213n.m5725b(str, b, c, "?#");
            m5694a(str, b, f);
            if (f >= c || str.charAt(f) != '?') {
                b = f;
            } else {
                b = C2213n.m5725b(str, f, c, "#");
                this.f3567g = C2213n.m5727b(C2213n.m5719a(str, f + 1, b, " \"'<>#", true, true));
            }
            if (b < c && str.charAt(b) == '#') {
                this.f3568h = C2213n.m5719a(str, b + 1, c, BuildConfig.FLAVOR, true, false);
            }
            return m5712b();
        }

        private void m5694a(String str, int i, int i2) {
            if (i != i2) {
                char charAt = str.charAt(i);
                if (charAt == '/' || charAt == '\\') {
                    this.f3566f.clear();
                    this.f3566f.add(BuildConfig.FLAVOR);
                    i++;
                } else {
                    this.f3566f.set(this.f3566f.size() - 1, BuildConfig.FLAVOR);
                }
                int i3 = i;
                while (i3 < i2) {
                    int a = C2213n.m5725b(str, i3, i2, "/\\");
                    boolean z = a < i2;
                    m5695a(str, i3, a, z, true);
                    if (z) {
                        a++;
                    }
                    i3 = a;
                }
            }
        }

        private void m5695a(String str, int i, int i2, boolean z, boolean z2) {
            String a = C2213n.m5719a(str, i, i2, " \"<>^`{}|/\\?#", z2, false);
            if (!m5698b(a)) {
                if (m5701c(a)) {
                    m5700c();
                    return;
                }
                if (((String) this.f3566f.get(this.f3566f.size() - 1)).isEmpty()) {
                    this.f3566f.set(this.f3566f.size() - 1, a);
                } else {
                    this.f3566f.add(a);
                }
                if (z) {
                    this.f3566f.add(BuildConfig.FLAVOR);
                }
            }
        }

        private boolean m5698b(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private boolean m5701c(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        private void m5700c() {
            if (!((String) this.f3566f.remove(this.f3566f.size() - 1)).isEmpty() || this.f3566f.isEmpty()) {
                this.f3566f.add(BuildConfig.FLAVOR);
            } else {
                this.f3566f.set(this.f3566f.size() - 1, BuildConfig.FLAVOR);
            }
        }

        private int m5697b(String str, int i, int i2) {
            int i3 = i;
            while (i3 < i2) {
                switch (str.charAt(i3)) {
                    case C3374b.SmoothProgressBar_spb_reversed /*9*/:
                    case C3374b.SmoothProgressBar_spb_mirror_mode /*10*/:
                    case C3374b.SmoothProgressBar_spb_progressiveStart_activated /*12*/:
                    case C3374b.SmoothProgressBar_spb_background /*13*/:
                    case HTTP.SP /*32*/:
                        i3++;
                    default:
                        return i3;
                }
            }
            return i2;
        }

        private int m5699c(String str, int i, int i2) {
            int i3 = i2 - 1;
            while (i3 >= i) {
                switch (str.charAt(i3)) {
                    case C3374b.SmoothProgressBar_spb_reversed /*9*/:
                    case C3374b.SmoothProgressBar_spb_mirror_mode /*10*/:
                    case C3374b.SmoothProgressBar_spb_progressiveStart_activated /*12*/:
                    case C3374b.SmoothProgressBar_spb_background /*13*/:
                    case HTTP.SP /*32*/:
                        i3--;
                    default:
                        return i3 + 1;
                }
            }
            return i;
        }

        private static int m5702d(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            if ((charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z')) {
                return -1;
            }
            int i3 = i + 1;
            while (i3 < i2) {
                char charAt2 = str.charAt(i3);
                if ((charAt2 >= 'a' && charAt2 <= 'z') || ((charAt2 >= 'A' && charAt2 <= 'Z') || charAt2 == '+' || charAt2 == '-' || charAt2 == '.')) {
                    i3++;
                } else if (charAt2 == ':') {
                    return i3;
                } else {
                    return -1;
                }
            }
            return -1;
        }

        private static int m5704e(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static int m5705f(java.lang.String r3, int r4, int r5) {
            /*
            r0 = r4;
        L_0x0001:
            if (r0 >= r5) goto L_0x001a;
        L_0x0003:
            r1 = r3.charAt(r0);
            switch(r1) {
                case 58: goto L_0x001b;
                case 91: goto L_0x000d;
                default: goto L_0x000a;
            };
        L_0x000a:
            r0 = r0 + 1;
            goto L_0x0001;
        L_0x000d:
            r0 = r0 + 1;
            if (r0 >= r5) goto L_0x000a;
        L_0x0011:
            r1 = r3.charAt(r0);
            r2 = 93;
            if (r1 != r2) goto L_0x000d;
        L_0x0019:
            goto L_0x000a;
        L_0x001a:
            r0 = r5;
        L_0x001b:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.n.a.f(java.lang.String, int, int):int");
        }

        private static String m5706g(String str, int i, int i2) {
            String a = C2213n.m5718a(str, i, i2);
            if (a.startsWith("[") && a.endsWith("]")) {
                InetAddress h = C2212a.m5707h(a, 1, a.length() - 1);
                if (h != null) {
                    return h.getHostAddress();
                }
                return null;
            }
            a = C2212a.m5703d(a);
            if (a == null) {
                return null;
            }
            int length = a.length();
            if (C2213n.m5725b(a, 0, length, "\u0000\t\n\r #%/:?@[\\]") == length) {
                return a;
            }
            return null;
        }

        private static InetAddress m5707h(String str, int i, int i2) {
            byte[] bArr = new byte[16];
            int i3 = i;
            int i4 = -1;
            int i5 = -1;
            int i6 = 0;
            while (i3 < i2) {
                if (i6 == bArr.length) {
                    return null;
                }
                int a;
                if (i3 + 2 > i2 || !str.regionMatches(i3, "::", 0, 2)) {
                    if (i6 != 0) {
                        if (str.regionMatches(i3, ":", 0, 1)) {
                            i3++;
                        } else if (!str.regionMatches(i3, ".", 0, 1)) {
                            return null;
                        } else {
                            if (!C2212a.m5696a(str, i4, i2, bArr, i6 - 2)) {
                                return null;
                            }
                            i6 += 2;
                        }
                    }
                } else if (i5 != -1) {
                    return null;
                } else {
                    i3 += 2;
                    i5 = i6 + 2;
                    if (i3 == i2) {
                        i6 = i5;
                        break;
                    }
                    i6 = i5;
                }
                i4 = 0;
                int i7 = i3;
                while (i7 < i2) {
                    a = C2213n.m5713a(str.charAt(i7));
                    if (a == -1) {
                        break;
                    }
                    i4 = (i4 << 4) + a;
                    i7++;
                }
                a = i7 - i3;
                if (a == 0 || a > 4) {
                    return null;
                }
                a = i6 + 1;
                bArr[i6] = (byte) ((i4 >>> 8) & RangeSeekBar.INVALID_POINTER_ID);
                i6 = a + 1;
                bArr[a] = (byte) (i4 & RangeSeekBar.INVALID_POINTER_ID);
                i4 = i3;
                i3 = i7;
            }
            if (i6 != bArr.length) {
                if (i5 == -1) {
                    return null;
                }
                System.arraycopy(bArr, i5, bArr, bArr.length - (i6 - i5), i6 - i5);
                Arrays.fill(bArr, i5, (bArr.length - i6) + i5, (byte) 0);
            }
            try {
                return InetAddress.getByAddress(bArr);
            } catch (UnknownHostException e) {
                throw new AssertionError();
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static boolean m5696a(java.lang.String r7, int r8, int r9, byte[] r10, int r11) {
            /*
            r1 = 0;
            r0 = r8;
            r4 = r11;
        L_0x0003:
            if (r0 >= r9) goto L_0x004a;
        L_0x0005:
            r2 = r10.length;
            if (r4 != r2) goto L_0x000a;
        L_0x0008:
            r0 = r1;
        L_0x0009:
            return r0;
        L_0x000a:
            if (r4 == r11) goto L_0x0018;
        L_0x000c:
            r2 = r7.charAt(r0);
            r3 = 46;
            if (r2 == r3) goto L_0x0016;
        L_0x0014:
            r0 = r1;
            goto L_0x0009;
        L_0x0016:
            r0 = r0 + 1;
        L_0x0018:
            r2 = r1;
            r3 = r0;
        L_0x001a:
            if (r3 >= r9) goto L_0x0028;
        L_0x001c:
            r5 = r7.charAt(r3);
            r6 = 48;
            if (r5 < r6) goto L_0x0028;
        L_0x0024:
            r6 = 57;
            if (r5 <= r6) goto L_0x002e;
        L_0x0028:
            r0 = r3 - r0;
            if (r0 != 0) goto L_0x0042;
        L_0x002c:
            r0 = r1;
            goto L_0x0009;
        L_0x002e:
            if (r2 != 0) goto L_0x0034;
        L_0x0030:
            if (r0 == r3) goto L_0x0034;
        L_0x0032:
            r0 = r1;
            goto L_0x0009;
        L_0x0034:
            r2 = r2 * 10;
            r2 = r2 + r5;
            r2 = r2 + -48;
            r5 = 255; // 0xff float:3.57E-43 double:1.26E-321;
            if (r2 <= r5) goto L_0x003f;
        L_0x003d:
            r0 = r1;
            goto L_0x0009;
        L_0x003f:
            r3 = r3 + 1;
            goto L_0x001a;
        L_0x0042:
            r0 = r4 + 1;
            r2 = (byte) r2;
            r10[r4] = r2;
            r4 = r0;
            r0 = r3;
            goto L_0x0003;
        L_0x004a:
            r0 = r11 + 4;
            if (r4 == r0) goto L_0x0050;
        L_0x004e:
            r0 = r1;
            goto L_0x0009;
        L_0x0050:
            r0 = 1;
            goto L_0x0009;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.n.a.a(java.lang.String, int, int, byte[], int):boolean");
        }

        private static String m5703d(String str) {
            try {
                String toLowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
                if (toLowerCase.isEmpty()) {
                    return null;
                }
                return toLowerCase;
            } catch (IllegalArgumentException e) {
                return null;
            }
        }

        private static int m5708i(String str, int i, int i2) {
            try {
                int parseInt = Integer.parseInt(C2213n.m5719a(str, i, i2, BuildConfig.FLAVOR, false, false));
                return (parseInt <= 0 || parseInt > SupportMenu.USER_MASK) ? -1 : parseInt;
            } catch (NumberFormatException e) {
                return -1;
            }
        }
    }

    static {
        f3569a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    private C2213n(C2212a c2212a) {
        String str = null;
        this.f3570b = c2212a.f3561a;
        this.f3571c = C2213n.m5731d(c2212a.f3562b);
        this.f3572d = C2213n.m5731d(c2212a.f3563c);
        this.f3573e = c2212a.f3564d;
        this.f3574f = c2212a.m5709a();
        this.f3575g = m5721a(c2212a.f3566f);
        this.f3576h = c2212a.f3567g != null ? m5721a(c2212a.f3567g) : null;
        if (c2212a.f3568h != null) {
            str = C2213n.m5731d(c2212a.f3568h);
        }
        this.f3577i = str;
        this.f3578j = c2212a.toString();
    }

    public URL m5732a() {
        try {
            return new URL(this.f3578j);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public URI m5733b() {
        try {
            return new URI(this.f3578j);
        } catch (URISyntaxException e) {
            throw new IllegalStateException("not valid as a java.net.URI: " + this.f3578j);
        }
    }

    public boolean m5734c() {
        return this.f3570b.equals("https");
    }

    public String m5735d() {
        if (this.f3571c.isEmpty()) {
            return BuildConfig.FLAVOR;
        }
        int length = this.f3570b.length() + 3;
        return this.f3578j.substring(length, C2213n.m5725b(this.f3578j, length, this.f3578j.length(), ":@"));
    }

    public String m5736e() {
        if (this.f3572d.isEmpty()) {
            return BuildConfig.FLAVOR;
        }
        return this.f3578j.substring(this.f3578j.indexOf(58, this.f3570b.length() + 3) + 1, this.f3578j.indexOf(64));
    }

    public static int m5714a(String str) {
        if (str.equals(HttpHost.DEFAULT_SCHEME_NAME)) {
            return 80;
        }
        if (str.equals("https")) {
            return 443;
        }
        return -1;
    }

    static void m5722a(StringBuilder stringBuilder, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            stringBuilder.append('/');
            stringBuilder.append((String) list.get(i));
        }
    }

    public List<String> m5737f() {
        int indexOf = this.f3578j.indexOf(47, this.f3570b.length() + 3);
        int b = C2213n.m5725b(this.f3578j, indexOf, this.f3578j.length(), "?#");
        List<String> arrayList = new ArrayList();
        while (indexOf < b) {
            int i = indexOf + 1;
            indexOf = C2213n.m5725b(this.f3578j, i, b, "/");
            arrayList.add(this.f3578j.substring(i, indexOf));
        }
        return arrayList;
    }

    public String m5738g() {
        if (this.f3576h == null) {
            return null;
        }
        int indexOf = this.f3578j.indexOf(63) + 1;
        return this.f3578j.substring(indexOf, C2213n.m5725b(this.f3578j, indexOf + 1, this.f3578j.length(), "#"));
    }

    static void m5728b(StringBuilder stringBuilder, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = (String) list.get(i);
            String str2 = (String) list.get(i + 1);
            if (i > 0) {
                stringBuilder.append('&');
            }
            stringBuilder.append(str);
            if (str2 != null) {
                stringBuilder.append('=');
                stringBuilder.append(str2);
            }
        }
    }

    static List<String> m5727b(String str) {
        List<String> arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int indexOf = str.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i, indexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            }
            i = indexOf + 1;
        }
        return arrayList;
    }

    public static C2213n m5730c(String str) {
        return new C2212a().m5711a(null, str);
    }

    public static C2213n m5716a(URL url) {
        return C2213n.m5730c(url.toString());
    }

    public boolean equals(Object obj) {
        return (obj instanceof C2213n) && ((C2213n) obj).f3578j.equals(this.f3578j);
    }

    public int hashCode() {
        return this.f3578j.hashCode();
    }

    public String toString() {
        return this.f3578j;
    }

    private static int m5725b(String str, int i, int i2, String str2) {
        for (int i3 = i; i3 < i2; i3++) {
            if (str2.indexOf(str.charAt(i3)) != -1) {
                return i3;
            }
        }
        return i2;
    }

    static String m5731d(String str) {
        return C2213n.m5718a(str, 0, str.length());
    }

    private List<String> m5721a(List<String> list) {
        List arrayList = new ArrayList(list.size());
        for (String str : list) {
            arrayList.add(str != null ? C2213n.m5731d(str) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static String m5718a(String str, int i, int i2) {
        for (int i3 = i; i3 < i2; i3++) {
            if (str.charAt(i3) == '%') {
                C3334c c3334c = new C3334c();
                c3334c.m10203a(str, i, i3);
                C2213n.m5723a(c3334c, str, i3, i2);
                return c3334c.m10248r();
            }
        }
        return str.substring(i, i2);
    }

    static void m5723a(C3334c c3334c, String str, int i, int i2) {
        int i3 = i;
        while (i3 < i2) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt == 37 && i3 + 2 < i2) {
                int a = C2213n.m5713a(str.charAt(i3 + 1));
                int a2 = C2213n.m5713a(str.charAt(i3 + 2));
                if (!(a == -1 || a2 == -1)) {
                    c3334c.m10211b((a << 4) + a2);
                    i3 += 2;
                    i3 += Character.charCount(codePointAt);
                }
            }
            c3334c.m10201a(codePointAt);
            i3 += Character.charCount(codePointAt);
        }
    }

    static int m5713a(char c) {
        if (c >= '0' && c <= '9') {
            return c - 48;
        }
        if (c >= 'a' && c <= 'f') {
            return (c - 97) + 10;
        }
        if (c < 'A' || c > 'F') {
            return -1;
        }
        return (c - 65) + 10;
    }

    static String m5719a(String str, int i, int i2, String str2, boolean z, boolean z2) {
        int i3 = i;
        while (i3 < i2) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt < 32 || codePointAt >= TransportMediator.KEYCODE_MEDIA_PAUSE || str2.indexOf(codePointAt) != -1 || ((codePointAt == 37 && !z) || (z2 && codePointAt == 43))) {
                C3334c c3334c = new C3334c();
                c3334c.m10203a(str, i, i3);
                C2213n.m5724a(c3334c, str, i3, i2, str2, z, z2);
                return c3334c.m10248r();
            }
            i3 += Character.charCount(codePointAt);
        }
        return str.substring(i, i2);
    }

    static void m5724a(C3334c c3334c, String str, int i, int i2, String str2, boolean z, boolean z2) {
        C3334c c3334c2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!(z && (codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13))) {
                if (z2 && codePointAt == 43) {
                    c3334c.m10202a(z ? "%20" : "%2B");
                } else if (codePointAt < 32 || codePointAt >= TransportMediator.KEYCODE_MEDIA_PAUSE || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && !z)) {
                    if (c3334c2 == null) {
                        c3334c2 = new C3334c();
                    }
                    c3334c2.m10201a(codePointAt);
                    while (!c3334c2.m10232g()) {
                        int j = c3334c2.m10238j() & RangeSeekBar.INVALID_POINTER_ID;
                        c3334c.m10211b(37);
                        c3334c.m10211b(f3569a[(j >> 4) & 15]);
                        c3334c.m10211b(f3569a[j & 15]);
                    }
                } else {
                    c3334c.m10201a(codePointAt);
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    static String m5720a(String str, String str2, boolean z, boolean z2) {
        return C2213n.m5719a(str, 0, str.length(), str2, z, z2);
    }
}
