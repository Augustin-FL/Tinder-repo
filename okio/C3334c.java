package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.facebook.internal.NativeProtocol;
import com.facebook.stetho.BuildConfig;
import com.tinder.views.RangeSeekBar;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: okio.c */
public final class C3334c implements Cloneable, C3332d, C3333e {
    private static final byte[] f7278c;
    C3347o f7279a;
    long f7280b;

    /* renamed from: okio.c.1 */
    class C33301 extends OutputStream {
        final /* synthetic */ C3334c f7276a;

        C33301(C3334c c3334c) {
            this.f7276a = c3334c;
        }

        public void write(int i) {
            this.f7276a.m10211b((byte) i);
        }

        public void write(byte[] bArr, int i, int i2) {
            this.f7276a.m10213b(bArr, i, i2);
        }

        public void flush() {
        }

        public void close() {
        }

        public String toString() {
            return this + ".outputStream()";
        }
    }

    /* renamed from: okio.c.2 */
    class C33312 extends InputStream {
        final /* synthetic */ C3334c f7277a;

        C33312(C3334c c3334c) {
            this.f7277a = c3334c;
        }

        public int read() {
            if (this.f7277a.f7280b > 0) {
                return this.f7277a.m10238j() & RangeSeekBar.INVALID_POINTER_ID;
            }
            return -1;
        }

        public int read(byte[] bArr, int i, int i2) {
            return this.f7277a.m10195a(bArr, i, i2);
        }

        public int available() {
            return (int) Math.min(this.f7277a.f7280b, 2147483647L);
        }

        public void close() {
        }

        public String toString() {
            return this.f7277a + ".inputStream()";
        }
    }

    public /* synthetic */ C3332d m10214b(String str) throws IOException {
        return m10202a(str);
    }

    public /* synthetic */ C3332d m10215b(ByteString byteString) throws IOException {
        return m10204a(byteString);
    }

    public /* synthetic */ C3332d m10219c(byte[] bArr) throws IOException {
        return m10212b(bArr);
    }

    public /* synthetic */ C3332d m10220c(byte[] bArr, int i, int i2) throws IOException {
        return m10213b(bArr, i, i2);
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return m10252v();
    }

    public /* synthetic */ C3332d m10228f(int i) throws IOException {
        return m10223d(i);
    }

    public /* synthetic */ C3332d m10230g(int i) throws IOException {
        return m10218c(i);
    }

    public /* synthetic */ C3332d m10235h(int i) throws IOException {
        return m10211b(i);
    }

    public /* synthetic */ C3332d m10239j(long j) throws IOException {
        return m10237i(j);
    }

    public /* synthetic */ C3332d m10240k(long j) throws IOException {
        return m10234h(j);
    }

    public /* synthetic */ C3332d m10253w() throws IOException {
        return m10225e();
    }

    static {
        f7278c = new byte[]{(byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102};
    }

    public long m10210b() {
        return this.f7280b;
    }

    public C3334c m10217c() {
        return this;
    }

    public OutputStream m10221d() {
        return new C33301(this);
    }

    public C3334c m10225e() {
        return this;
    }

    public C3332d m10227f() {
        return this;
    }

    public boolean m10232g() {
        return this.f7280b == 0;
    }

    public void m10207a(long j) throws EOFException {
        if (this.f7280b < j) {
            throw new EOFException();
        }
    }

    public InputStream m10233h() {
        return new C33312(this);
    }

    public C3334c m10205a(C3334c c3334c, long j, long j2) {
        if (c3334c == null) {
            throw new IllegalArgumentException("out == null");
        }
        C3350t.m10340a(this.f7280b, j, j2);
        if (j2 != 0) {
            c3334c.f7280b += j2;
            C3347o c3347o = this.f7279a;
            while (j >= ((long) (c3347o.f7310c - c3347o.f7309b))) {
                j -= (long) (c3347o.f7310c - c3347o.f7309b);
                c3347o = c3347o.f7313f;
            }
            while (j2 > 0) {
                C3347o c3347o2 = new C3347o(c3347o);
                c3347o2.f7309b = (int) (((long) c3347o2.f7309b) + j);
                c3347o2.f7310c = Math.min(c3347o2.f7309b + ((int) j2), c3347o2.f7310c);
                if (c3334c.f7279a == null) {
                    c3347o2.f7314g = c3347o2;
                    c3347o2.f7313f = c3347o2;
                    c3334c.f7279a = c3347o2;
                } else {
                    c3334c.f7279a.f7314g.m10330a(c3347o2);
                }
                j2 -= (long) (c3347o2.f7310c - c3347o2.f7309b);
                c3347o = c3347o.f7313f;
                j = 0;
            }
        }
        return this;
    }

    public long m10236i() {
        long j = this.f7280b;
        if (j == 0) {
            return 0;
        }
        C3347o c3347o = this.f7279a.f7314g;
        if (c3347o.f7310c >= AccessibilityNodeInfoCompat.ACTION_PREVIOUS_HTML_ELEMENT || !c3347o.f7312e) {
            return j;
        }
        return j - ((long) (c3347o.f7310c - c3347o.f7309b));
    }

    public byte m10238j() {
        if (this.f7280b == 0) {
            throw new IllegalStateException("size == 0");
        }
        C3347o c3347o = this.f7279a;
        int i = c3347o.f7309b;
        int i2 = c3347o.f7310c;
        int i3 = i + 1;
        byte b = c3347o.f7308a[i];
        this.f7280b--;
        if (i3 == i2) {
            this.f7279a = c3347o.m10328a();
            C3348p.m10334a(c3347o);
        } else {
            c3347o.f7309b = i3;
        }
        return b;
    }

    public byte m10209b(long j) {
        C3350t.m10340a(this.f7280b, j, 1);
        C3347o c3347o = this.f7279a;
        while (true) {
            int i = c3347o.f7310c - c3347o.f7309b;
            if (j < ((long) i)) {
                return c3347o.f7308a[c3347o.f7309b + ((int) j)];
            }
            j -= (long) i;
            c3347o = c3347o.f7313f;
        }
    }

    public short m10241k() {
        if (this.f7280b < 2) {
            throw new IllegalStateException("size < 2: " + this.f7280b);
        }
        C3347o c3347o = this.f7279a;
        int i = c3347o.f7309b;
        int i2 = c3347o.f7310c;
        if (i2 - i < 2) {
            return (short) (((m10238j() & RangeSeekBar.INVALID_POINTER_ID) << 8) | (m10238j() & RangeSeekBar.INVALID_POINTER_ID));
        }
        byte[] bArr = c3347o.f7308a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        i = ((bArr[i] & RangeSeekBar.INVALID_POINTER_ID) << 8) | (bArr[i3] & RangeSeekBar.INVALID_POINTER_ID);
        this.f7280b -= 2;
        if (i4 == i2) {
            this.f7279a = c3347o.m10328a();
            C3348p.m10334a(c3347o);
        } else {
            c3347o.f7309b = i4;
        }
        return (short) i;
    }

    public int m10242l() {
        if (this.f7280b < 4) {
            throw new IllegalStateException("size < 4: " + this.f7280b);
        }
        C3347o c3347o = this.f7279a;
        int i = c3347o.f7309b;
        int i2 = c3347o.f7310c;
        if (i2 - i < 4) {
            return ((((m10238j() & RangeSeekBar.INVALID_POINTER_ID) << 24) | ((m10238j() & RangeSeekBar.INVALID_POINTER_ID) << 16)) | ((m10238j() & RangeSeekBar.INVALID_POINTER_ID) << 8)) | (m10238j() & RangeSeekBar.INVALID_POINTER_ID);
        }
        byte[] bArr = c3347o.f7308a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        i = ((bArr[i] & RangeSeekBar.INVALID_POINTER_ID) << 24) | ((bArr[i3] & RangeSeekBar.INVALID_POINTER_ID) << 16);
        i3 = i4 + 1;
        i |= (bArr[i4] & RangeSeekBar.INVALID_POINTER_ID) << 8;
        i4 = i3 + 1;
        i |= bArr[i3] & RangeSeekBar.INVALID_POINTER_ID;
        this.f7280b -= 4;
        if (i4 == i2) {
            this.f7279a = c3347o.m10328a();
            C3348p.m10334a(c3347o);
            return i;
        }
        c3347o.f7309b = i4;
        return i;
    }

    public short m10243m() {
        return C3350t.m10339a(m10241k());
    }

    public int m10244n() {
        return C3350t.m10338a(m10242l());
    }

    public long m10245o() {
        if (this.f7280b == 0) {
            throw new IllegalStateException("size == 0");
        }
        long j = 0;
        int i = 0;
        Object obj = null;
        Object obj2 = null;
        long j2 = -7;
        do {
            C3347o c3347o = this.f7279a;
            byte[] bArr = c3347o.f7308a;
            int i2 = c3347o.f7309b;
            int i3 = c3347o.f7310c;
            while (i2 < i3) {
                int i4 = bArr[i2];
                if (i4 >= 48 && i4 <= 57) {
                    int i5 = 48 - i4;
                    if (j >= -922337203685477580L) {
                        if (j == -922337203685477580L) {
                            if (((long) i5) < j2) {
                            }
                        }
                        j = (j * 10) + ((long) i5);
                    }
                    C3334c b = new C3334c().m10234h(j).m10211b(i4);
                    if (obj == null) {
                        b.m10238j();
                    }
                    throw new NumberFormatException("Number too large: " + b.m10248r());
                } else if (i4 != 45 || i != 0) {
                    if (i != 0) {
                        obj2 = 1;
                        if (i2 != i3) {
                            this.f7279a = c3347o.m10328a();
                            C3348p.m10334a(c3347o);
                        } else {
                            c3347o.f7309b = i2;
                        }
                        if (obj2 == null) {
                            break;
                        }
                    } else {
                        throw new NumberFormatException("Expected leading [0-9] or '-' character but was 0x" + Integer.toHexString(i4));
                    }
                } else {
                    obj = 1;
                    j2--;
                }
                i2++;
                i++;
            }
            if (i2 != i3) {
                c3347o.f7309b = i2;
            } else {
                this.f7279a = c3347o.m10328a();
                C3348p.m10334a(c3347o);
            }
            if (obj2 == null) {
                break;
            }
        } while (this.f7279a != null);
        this.f7280b -= (long) i;
        if (obj != null) {
            return j;
        }
        return -j;
    }

    public long m10246p() {
        if (this.f7280b == 0) {
            throw new IllegalStateException("size == 0");
        }
        long j = 0;
        int i = 0;
        Object obj = null;
        do {
            C3347o c3347o = this.f7279a;
            byte[] bArr = c3347o.f7308a;
            int i2 = c3347o.f7309b;
            int i3 = c3347o.f7310c;
            int i4 = i2;
            while (i4 < i3) {
                int i5 = bArr[i4];
                if (i5 >= 48 && i5 <= 57) {
                    i2 = i5 - 48;
                } else if (i5 >= 97 && i5 <= 102) {
                    i2 = (i5 - 97) + 10;
                } else if (i5 < 65 || i5 > 70) {
                    if (i != 0) {
                        obj = 1;
                        if (i4 != i3) {
                            this.f7279a = c3347o.m10328a();
                            C3348p.m10334a(c3347o);
                        } else {
                            c3347o.f7309b = i4;
                        }
                        if (obj == null) {
                            break;
                        }
                    } else {
                        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(i5));
                    }
                } else {
                    i2 = (i5 - 65) + 10;
                }
                if ((-1152921504606846976L & j) != 0) {
                    throw new NumberFormatException("Number too large: " + new C3334c().m10237i(j).m10211b(i5).m10248r());
                }
                i++;
                i4++;
                j = ((long) i2) | (j << 4);
            }
            if (i4 != i3) {
                c3347o.f7309b = i4;
            } else {
                this.f7279a = c3347o.m10328a();
                C3348p.m10334a(c3347o);
            }
            if (obj == null) {
                break;
            }
        } while (this.f7279a != null);
        this.f7280b -= (long) i;
        return j;
    }

    public ByteString m10247q() {
        return new ByteString(m10250t());
    }

    public ByteString m10216c(long j) throws EOFException {
        return new ByteString(m10229f(j));
    }

    public String m10248r() {
        try {
            return m10200a(this.f7280b, C3350t.f7317a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String m10222d(long j) throws EOFException {
        return m10200a(j, C3350t.f7317a);
    }

    public String m10200a(long j, Charset charset) throws EOFException {
        C3350t.m10340a(this.f7280b, 0, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        } else if (j == 0) {
            return BuildConfig.FLAVOR;
        } else {
            C3347o c3347o = this.f7279a;
            if (((long) c3347o.f7309b) + j > ((long) c3347o.f7310c)) {
                return new String(m10229f(j), charset);
            }
            String str = new String(c3347o.f7308a, c3347o.f7309b, (int) j, charset);
            c3347o.f7309b = (int) (((long) c3347o.f7309b) + j);
            this.f7280b -= j;
            if (c3347o.f7309b != c3347o.f7310c) {
                return str;
            }
            this.f7279a = c3347o.m10328a();
            C3348p.m10334a(c3347o);
            return str;
        }
    }

    public String m10249s() throws EOFException {
        long a = m10196a((byte) 10);
        if (a != -1) {
            return m10224e(a);
        }
        C3334c c3334c = new C3334c();
        m10205a(c3334c, 0, Math.min(32, this.f7280b));
        throw new EOFException("\\n not found: size=" + m10210b() + " content=" + c3334c.m10247q().m10155d() + "...");
    }

    String m10224e(long j) throws EOFException {
        if (j <= 0 || m10209b(j - 1) != 13) {
            String d = m10222d(j);
            m10231g(1);
            return d;
        }
        d = m10222d(j - 1);
        m10231g(2);
        return d;
    }

    public byte[] m10250t() {
        try {
            return m10229f(this.f7280b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public byte[] m10229f(long j) throws EOFException {
        C3350t.m10340a(this.f7280b, 0, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        byte[] bArr = new byte[((int) j)];
        m10208a(bArr);
        return bArr;
    }

    public void m10208a(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int a = m10195a(bArr, i, bArr.length - i);
            if (a == -1) {
                throw new EOFException();
            }
            i += a;
        }
    }

    public int m10195a(byte[] bArr, int i, int i2) {
        C3350t.m10340a((long) bArr.length, (long) i, (long) i2);
        C3347o c3347o = this.f7279a;
        if (c3347o == null) {
            return -1;
        }
        int min = Math.min(i2, c3347o.f7310c - c3347o.f7309b);
        System.arraycopy(c3347o.f7308a, c3347o.f7309b, bArr, i, min);
        c3347o.f7309b += min;
        this.f7280b -= (long) min;
        if (c3347o.f7309b != c3347o.f7310c) {
            return min;
        }
        this.f7279a = c3347o.m10328a();
        C3348p.m10334a(c3347o);
        return min;
    }

    public void m10251u() {
        try {
            m10231g(this.f7280b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public void m10231g(long j) throws EOFException {
        while (j > 0) {
            if (this.f7279a == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, (long) (this.f7279a.f7310c - this.f7279a.f7309b));
            this.f7280b -= (long) min;
            j -= (long) min;
            C3347o c3347o = this.f7279a;
            c3347o.f7309b = min + c3347o.f7309b;
            if (this.f7279a.f7309b == this.f7279a.f7310c) {
                C3347o c3347o2 = this.f7279a;
                this.f7279a = c3347o2.m10328a();
                C3348p.m10334a(c3347o2);
            }
        }
    }

    public C3334c m10204a(ByteString byteString) {
        if (byteString == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        byteString.m10151a(this);
        return this;
    }

    public C3334c m10202a(String str) {
        return m10203a(str, 0, str.length());
    }

    public C3334c m10203a(String str, int i, int i2) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        } else {
            while (i < i2) {
                int i3;
                char charAt = str.charAt(i);
                if (charAt < '\u0080') {
                    int i4;
                    C3347o e = m10226e(1);
                    byte[] bArr = e.f7308a;
                    int i5 = e.f7310c - i;
                    int min = Math.min(i2, 2048 - i5);
                    i3 = i + 1;
                    bArr[i5 + i] = (byte) charAt;
                    while (i3 < min) {
                        char charAt2 = str.charAt(i3);
                        if (charAt2 >= '\u0080') {
                            break;
                        }
                        i4 = i3 + 1;
                        bArr[i3 + i5] = (byte) charAt2;
                        i3 = i4;
                    }
                    i4 = (i3 + i5) - e.f7310c;
                    e.f7310c += i4;
                    this.f7280b += (long) i4;
                } else if (charAt < '\u0800') {
                    m10211b((charAt >> 6) | 192);
                    m10211b((charAt & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
                    i3 = i + 1;
                } else if (charAt < '\ud800' || charAt > '\udfff') {
                    m10211b((charAt >> 12) | 224);
                    m10211b(((charAt >> 6) & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
                    m10211b((charAt & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
                    i3 = i + 1;
                } else {
                    i3 = i + 1 < i2 ? str.charAt(i + 1) : 0;
                    if (charAt > '\udbff' || i3 < 56320 || i3 > 57343) {
                        m10211b(63);
                        i++;
                    } else {
                        i3 = ((i3 & -56321) | ((charAt & -55297) << 10)) + NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
                        m10211b((i3 >> 18) | 240);
                        m10211b(((i3 >> 12) & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
                        m10211b(((i3 >> 6) & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
                        m10211b((i3 & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
                        i3 = i + 2;
                    }
                }
                i = i3;
            }
            return this;
        }
    }

    public C3334c m10201a(int i) {
        if (i < AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) {
            m10211b(i);
        } else if (i < AccessibilityNodeInfoCompat.ACTION_PREVIOUS_HTML_ELEMENT) {
            m10211b((i >> 6) | 192);
            m10211b((i & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        } else if (i < NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) {
            if (i < 55296 || i > 57343) {
                m10211b((i >> 12) | 224);
                m10211b(((i >> 6) & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
                m10211b((i & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
            } else {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
            }
        } else if (i <= 1114111) {
            m10211b((i >> 18) | 240);
            m10211b(((i >> 12) & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
            m10211b(((i >> 6) & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
            m10211b((i & 63) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    public C3334c m10212b(byte[] bArr) {
        if (bArr != null) {
            return m10213b(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    public C3334c m10213b(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        C3350t.m10340a((long) bArr.length, (long) i, (long) i2);
        int i3 = i + i2;
        while (i < i3) {
            C3347o e = m10226e(1);
            int min = Math.min(i3 - i, 2048 - e.f7310c);
            System.arraycopy(bArr, i, e.f7308a, e.f7310c, min);
            i += min;
            e.f7310c = min + e.f7310c;
        }
        this.f7280b += (long) i2;
        return this;
    }

    public long m10199a(C2076r c2076r) throws IOException {
        if (c2076r == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long a = c2076r.m4901a(this, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH);
            if (a == -1) {
                return j;
            }
            j += a;
        }
    }

    public C3334c m10211b(int i) {
        C3347o e = m10226e(1);
        byte[] bArr = e.f7308a;
        int i2 = e.f7310c;
        e.f7310c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f7280b++;
        return this;
    }

    public C3334c m10218c(int i) {
        C3347o e = m10226e(2);
        byte[] bArr = e.f7308a;
        int i2 = e.f7310c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & RangeSeekBar.INVALID_POINTER_ID);
        i2 = i3 + 1;
        bArr[i3] = (byte) (i & RangeSeekBar.INVALID_POINTER_ID);
        e.f7310c = i2;
        this.f7280b += 2;
        return this;
    }

    public C3334c m10223d(int i) {
        C3347o e = m10226e(4);
        byte[] bArr = e.f7308a;
        int i2 = e.f7310c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & RangeSeekBar.INVALID_POINTER_ID);
        i2 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & RangeSeekBar.INVALID_POINTER_ID);
        i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & RangeSeekBar.INVALID_POINTER_ID);
        i2 = i3 + 1;
        bArr[i3] = (byte) (i & RangeSeekBar.INVALID_POINTER_ID);
        e.f7310c = i2;
        this.f7280b += 4;
        return this;
    }

    public C3334c m10234h(long j) {
        if (j == 0) {
            return m10211b(48);
        }
        long j2;
        Object obj;
        if (j < 0) {
            j2 = -j;
            if (j2 < 0) {
                return m10202a("-9223372036854775808");
            }
            obj = 1;
        } else {
            obj = null;
            j2 = j;
        }
        int i = j2 < 100000000 ? j2 < 10000 ? j2 < 100 ? j2 < 10 ? 1 : 2 : j2 < 1000 ? 3 : 4 : j2 < 1000000 ? j2 < 100000 ? 5 : 6 : j2 < 10000000 ? 7 : 8 : j2 < 1000000000000L ? j2 < 10000000000L ? j2 < 1000000000 ? 9 : 10 : j2 < 100000000000L ? 11 : 12 : j2 < 1000000000000000L ? j2 < 10000000000000L ? 13 : j2 < 100000000000000L ? 14 : 15 : j2 < 100000000000000000L ? j2 < 10000000000000000L ? 16 : 17 : j2 < 1000000000000000000L ? 18 : 19;
        if (obj != null) {
            i++;
        }
        C3347o e = m10226e(i);
        byte[] bArr = e.f7308a;
        int i2 = e.f7310c + i;
        while (j2 != 0) {
            i2--;
            bArr[i2] = f7278c[(int) (j2 % 10)];
            j2 /= 10;
        }
        if (obj != null) {
            bArr[i2 - 1] = (byte) 45;
        }
        e.f7310c += i;
        this.f7280b = ((long) i) + this.f7280b;
        return this;
    }

    public C3334c m10237i(long j) {
        if (j == 0) {
            return m10211b(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        C3347o e = m10226e(numberOfTrailingZeros);
        byte[] bArr = e.f7308a;
        int i = e.f7310c;
        for (int i2 = (e.f7310c + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = f7278c[(int) (15 & j)];
            j >>>= 4;
        }
        e.f7310c += numberOfTrailingZeros;
        this.f7280b = ((long) numberOfTrailingZeros) + this.f7280b;
        return this;
    }

    C3347o m10226e(int i) {
        if (i < 1 || i > AccessibilityNodeInfoCompat.ACTION_PREVIOUS_HTML_ELEMENT) {
            throw new IllegalArgumentException();
        } else if (this.f7279a == null) {
            this.f7279a = C3348p.m10333a();
            C3347o c3347o = this.f7279a;
            C3347o c3347o2 = this.f7279a;
            r0 = this.f7279a;
            c3347o2.f7314g = r0;
            c3347o.f7313f = r0;
            return r0;
        } else {
            r0 = this.f7279a.f7314g;
            if (r0.f7310c + i > AccessibilityNodeInfoCompat.ACTION_PREVIOUS_HTML_ELEMENT || !r0.f7312e) {
                return r0.m10330a(C3348p.m10333a());
            }
            return r0;
        }
    }

    public void a_(C3334c c3334c, long j) {
        if (c3334c == null) {
            throw new IllegalArgumentException("source == null");
        } else if (c3334c == this) {
            throw new IllegalArgumentException("source == this");
        } else {
            C3350t.m10340a(c3334c.f7280b, 0, j);
            while (j > 0) {
                C3347o c3347o;
                if (j < ((long) (c3334c.f7279a.f7310c - c3334c.f7279a.f7309b))) {
                    c3347o = this.f7279a != null ? this.f7279a.f7314g : null;
                    if (c3347o != null && c3347o.f7312e) {
                        if ((((long) c3347o.f7310c) + j) - ((long) (c3347o.f7311d ? 0 : c3347o.f7309b)) <= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) {
                            c3334c.f7279a.m10331a(c3347o, (int) j);
                            c3334c.f7280b -= j;
                            this.f7280b += j;
                            return;
                        }
                    }
                    c3334c.f7279a = c3334c.f7279a.m10329a((int) j);
                }
                C3347o c3347o2 = c3334c.f7279a;
                long j2 = (long) (c3347o2.f7310c - c3347o2.f7309b);
                c3334c.f7279a = c3347o2.m10328a();
                if (this.f7279a == null) {
                    this.f7279a = c3347o2;
                    c3347o2 = this.f7279a;
                    c3347o = this.f7279a;
                    C3347o c3347o3 = this.f7279a;
                    c3347o.f7314g = c3347o3;
                    c3347o2.f7313f = c3347o3;
                } else {
                    this.f7279a.f7314g.m10330a(c3347o2).m10332b();
                }
                c3334c.f7280b -= j2;
                this.f7280b += j2;
                j -= j2;
            }
        }
    }

    public long m10198a(C3334c c3334c, long j) {
        if (c3334c == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.f7280b == 0) {
            return -1;
        } else {
            if (j > this.f7280b) {
                j = this.f7280b;
            }
            c3334c.a_(this, j);
            return j;
        }
    }

    public long m10196a(byte b) {
        return m10197a(b, 0);
    }

    public long m10197a(byte b, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        C3347o c3347o = this.f7279a;
        if (c3347o == null) {
            return -1;
        }
        long j2 = 0;
        do {
            int i = c3347o.f7310c - c3347o.f7309b;
            if (j >= ((long) i)) {
                j -= (long) i;
            } else {
                byte[] bArr = c3347o.f7308a;
                long j3 = (long) c3347o.f7310c;
                for (long j4 = ((long) c3347o.f7309b) + j; j4 < j3; j4++) {
                    if (bArr[(int) j4] == b) {
                        return (j2 + j4) - ((long) c3347o.f7309b);
                    }
                }
                j = 0;
            }
            j2 += (long) i;
            c3347o = c3347o.f7313f;
        } while (c3347o != this.f7279a);
        return -1;
    }

    public void flush() {
    }

    public void close() {
    }

    public C2201s m10206a() {
        return C2201s.f3530b;
    }

    public boolean equals(Object obj) {
        long j = 0;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3334c)) {
            return false;
        }
        C3334c c3334c = (C3334c) obj;
        if (this.f7280b != c3334c.f7280b) {
            return false;
        }
        if (this.f7280b == 0) {
            return true;
        }
        C3347o c3347o = this.f7279a;
        C3347o c3347o2 = c3334c.f7279a;
        int i = c3347o.f7309b;
        int i2 = c3347o2.f7309b;
        while (j < this.f7280b) {
            long min = (long) Math.min(c3347o.f7310c - i, c3347o2.f7310c - i2);
            int i3 = 0;
            while (((long) i3) < min) {
                int i4 = i + 1;
                byte b = c3347o.f7308a[i];
                i = i2 + 1;
                if (b != c3347o2.f7308a[i2]) {
                    return false;
                }
                i3++;
                i2 = i;
                i = i4;
            }
            if (i == c3347o.f7310c) {
                c3347o = c3347o.f7313f;
                i = c3347o.f7309b;
            }
            if (i2 == c3347o2.f7310c) {
                c3347o2 = c3347o2.f7313f;
                i2 = c3347o2.f7309b;
            }
            j += min;
        }
        return true;
    }

    public int hashCode() {
        C3347o c3347o = this.f7279a;
        if (c3347o == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = c3347o.f7309b;
            while (i2 < c3347o.f7310c) {
                int i3 = c3347o.f7308a[i2] + (i * 31);
                i2++;
                i = i3;
            }
            c3347o = c3347o.f7313f;
        } while (c3347o != this.f7279a);
        return i;
    }

    public String toString() {
        if (this.f7280b == 0) {
            return "Buffer[size=0]";
        }
        if (this.f7280b <= 16) {
            ByteString q = m10252v().m10247q();
            return String.format("Buffer[size=%s data=%s]", new Object[]{Long.valueOf(this.f7280b), q.m10155d()});
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(this.f7279a.f7308a, this.f7279a.f7309b, this.f7279a.f7310c - this.f7279a.f7309b);
            for (C3347o c3347o = this.f7279a.f7313f; c3347o != this.f7279a; c3347o = c3347o.f7313f) {
                instance.update(c3347o.f7308a, c3347o.f7309b, c3347o.f7310c - c3347o.f7309b);
            }
            return String.format("Buffer[size=%s md5=%s]", new Object[]{Long.valueOf(this.f7280b), ByteString.m10146a(instance.digest()).m10155d()});
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError();
        }
    }

    public C3334c m10252v() {
        C3334c c3334c = new C3334c();
        if (this.f7280b == 0) {
            return c3334c;
        }
        c3334c.f7279a = new C3347o(this.f7279a);
        C3347o c3347o = c3334c.f7279a;
        C3347o c3347o2 = c3334c.f7279a;
        C3347o c3347o3 = c3334c.f7279a;
        c3347o2.f7314g = c3347o3;
        c3347o.f7313f = c3347o3;
        for (c3347o = this.f7279a.f7313f; c3347o != this.f7279a; c3347o = c3347o.f7313f) {
            c3334c.f7279a.f7314g.m10330a(new C3347o(c3347o));
        }
        c3334c.f7280b = this.f7280b;
        return c3334c;
    }
}
