package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import com.tinder.views.RangeSeekBar;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: okio.n */
final class C3346n implements C3333e {
    public final C3334c f7305a;
    public final C2076r f7306b;
    private boolean f7307c;

    /* renamed from: okio.n.1 */
    class C33451 extends InputStream {
        final /* synthetic */ C3346n f7304a;

        C33451(C3346n c3346n) {
            this.f7304a = c3346n;
        }

        public int read() throws IOException {
            if (this.f7304a.f7307c) {
                throw new IOException("closed");
            } else if (this.f7304a.f7305a.f7280b == 0 && this.f7304a.f7306b.m4901a(this.f7304a.f7305a, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) == -1) {
                return -1;
            } else {
                return this.f7304a.f7305a.m10238j() & RangeSeekBar.INVALID_POINTER_ID;
            }
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            if (this.f7304a.f7307c) {
                throw new IOException("closed");
            }
            C3350t.m10340a((long) bArr.length, (long) i, (long) i2);
            if (this.f7304a.f7305a.f7280b == 0 && this.f7304a.f7306b.m4901a(this.f7304a.f7305a, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) == -1) {
                return -1;
            }
            return this.f7304a.f7305a.m10195a(bArr, i, i2);
        }

        public int available() throws IOException {
            if (!this.f7304a.f7307c) {
                return (int) Math.min(this.f7304a.f7305a.f7280b, 2147483647L);
            }
            throw new IOException("closed");
        }

        public void close() throws IOException {
            this.f7304a.close();
        }

        public String toString() {
            return this.f7304a + ".inputStream()";
        }
    }

    public C3346n(C2076r c2076r, C3334c c3334c) {
        if (c2076r == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.f7305a = c3334c;
        this.f7306b = c2076r;
    }

    public C3346n(C2076r c2076r) {
        this(c2076r, new C3334c());
    }

    public C3334c m10315c() {
        return this.f7305a;
    }

    public long m10310a(C3334c c3334c, long j) throws IOException {
        if (c3334c == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.f7307c) {
            throw new IllegalStateException("closed");
        } else if (this.f7305a.f7280b == 0 && this.f7306b.m4901a(this.f7305a, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) == -1) {
            return -1;
        } else {
            return this.f7305a.m10198a(c3334c, Math.min(j, this.f7305a.f7280b));
        }
    }

    public boolean m10318g() throws IOException {
        if (!this.f7307c) {
            return this.f7305a.m10232g() && this.f7306b.m4901a(this.f7305a, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) == -1;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public void m10312a(long j) throws IOException {
        if (!m10313b(j)) {
            throw new EOFException();
        }
    }

    public boolean m10313b(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.f7307c) {
            throw new IllegalStateException("closed");
        } else {
            while (this.f7305a.f7280b < j) {
                if (this.f7306b.m4901a(this.f7305a, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) == -1) {
                    return false;
                }
            }
            return true;
        }
    }

    public byte m10320j() throws IOException {
        m10312a(1);
        return this.f7305a.m10238j();
    }

    public ByteString m10314c(long j) throws IOException {
        m10312a(j);
        return this.f7305a.m10216c(j);
    }

    public byte[] m10316f(long j) throws IOException {
        m10312a(j);
        return this.f7305a.m10229f(j);
    }

    public String m10327s() throws IOException {
        long a = m10308a((byte) 10);
        if (a != -1) {
            return this.f7305a.m10224e(a);
        }
        C3334c c3334c = new C3334c();
        this.f7305a.m10205a(c3334c, 0, Math.min(32, this.f7305a.m10210b()));
        throw new EOFException("\\n not found: size=" + this.f7305a.m10210b() + " content=" + c3334c.m10247q().m10155d() + "...");
    }

    public short m10321k() throws IOException {
        m10312a(2);
        return this.f7305a.m10241k();
    }

    public short m10323m() throws IOException {
        m10312a(2);
        return this.f7305a.m10243m();
    }

    public int m10322l() throws IOException {
        m10312a(4);
        return this.f7305a.m10242l();
    }

    public int m10324n() throws IOException {
        m10312a(4);
        return this.f7305a.m10244n();
    }

    public long m10325o() throws IOException {
        m10312a(1);
        int i = 0;
        while (m10313b((long) (i + 1))) {
            byte b = this.f7305a.m10209b((long) i);
            if ((b < 48 || b > 57) && !(i == 0 && b == 45)) {
                if (i == 0) {
                    throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", new Object[]{Byte.valueOf(b)}));
                }
                return this.f7305a.m10245o();
            }
            i++;
        }
        return this.f7305a.m10245o();
    }

    public long m10326p() throws IOException {
        m10312a(1);
        for (int i = 0; m10313b((long) (i + 1)); i++) {
            byte b = this.f7305a.m10209b((long) i);
            if ((b < 48 || b > 57) && ((b < 97 || b > 102) && (b < 65 || b > 70))) {
                if (i == 0) {
                    throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[]{Byte.valueOf(b)}));
                }
                return this.f7305a.m10246p();
            }
        }
        return this.f7305a.m10246p();
    }

    public void m10317g(long j) throws IOException {
        if (this.f7307c) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            if (this.f7305a.f7280b == 0 && this.f7306b.m4901a(this.f7305a, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j, this.f7305a.m10210b());
            this.f7305a.m10231g(min);
            j -= min;
        }
    }

    public long m10308a(byte b) throws IOException {
        return m10309a(b, 0);
    }

    public long m10309a(byte b, long j) throws IOException {
        if (this.f7307c) {
            throw new IllegalStateException("closed");
        }
        while (j >= this.f7305a.f7280b) {
            if (this.f7306b.m4901a(this.f7305a, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) == -1) {
                return -1;
            }
        }
        do {
            long a = this.f7305a.m10197a(b, j);
            if (a != -1) {
                return a;
            }
            j = this.f7305a.f7280b;
        } while (this.f7306b.m4901a(this.f7305a, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) != -1);
        return -1;
    }

    public InputStream m10319h() {
        return new C33451(this);
    }

    public void close() throws IOException {
        if (!this.f7307c) {
            this.f7307c = true;
            this.f7306b.close();
            this.f7305a.m10251u();
        }
    }

    public C2201s m10311a() {
        return this.f7306b.m4902a();
    }

    public String toString() {
        return "buffer(" + this.f7306b + ")";
    }
}
