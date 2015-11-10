package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: okio.m */
final class C3344m implements C3332d {
    public final C3334c f7301a;
    public final C2071q f7302b;
    private boolean f7303c;

    /* renamed from: okio.m.1 */
    class C33431 extends OutputStream {
        final /* synthetic */ C3344m f7300a;

        C33431(C3344m c3344m) {
            this.f7300a = c3344m;
        }

        public void write(int i) throws IOException {
            if (this.f7300a.f7303c) {
                throw new IOException("closed");
            }
            this.f7300a.f7301a.m10211b((byte) i);
            this.f7300a.m10306w();
        }

        public void write(byte[] bArr, int i, int i2) throws IOException {
            if (this.f7300a.f7303c) {
                throw new IOException("closed");
            }
            this.f7300a.f7301a.m10213b(bArr, i, i2);
            this.f7300a.m10306w();
        }

        public void flush() throws IOException {
            if (!this.f7300a.f7303c) {
                this.f7300a.flush();
            }
        }

        public void close() throws IOException {
            this.f7300a.close();
        }

        public String toString() {
            return this.f7300a + ".outputStream()";
        }
    }

    public C3344m(C2071q c2071q, C3334c c3334c) {
        if (c2071q == null) {
            throw new IllegalArgumentException("sink == null");
        }
        this.f7301a = c3334c;
        this.f7302b = c2071q;
    }

    public C3344m(C2071q c2071q) {
        this(c2071q, new C3334c());
    }

    public C3334c m10296c() {
        return this.f7301a;
    }

    public void a_(C3334c c3334c, long j) throws IOException {
        if (this.f7303c) {
            throw new IllegalStateException("closed");
        }
        this.f7301a.a_(c3334c, j);
        m10306w();
    }

    public C3332d m10295b(ByteString byteString) throws IOException {
        if (this.f7303c) {
            throw new IllegalStateException("closed");
        }
        this.f7301a.m10204a(byteString);
        return m10306w();
    }

    public C3332d m10294b(String str) throws IOException {
        if (this.f7303c) {
            throw new IllegalStateException("closed");
        }
        this.f7301a.m10202a(str);
        return m10306w();
    }

    public C3332d m10297c(byte[] bArr) throws IOException {
        if (this.f7303c) {
            throw new IllegalStateException("closed");
        }
        this.f7301a.m10212b(bArr);
        return m10306w();
    }

    public C3332d m10298c(byte[] bArr, int i, int i2) throws IOException {
        if (this.f7303c) {
            throw new IllegalStateException("closed");
        }
        this.f7301a.m10213b(bArr, i, i2);
        return m10306w();
    }

    public long m10292a(C2076r c2076r) throws IOException {
        if (c2076r == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long a = c2076r.m4901a(this.f7301a, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH);
            if (a == -1) {
                return j;
            }
            j += a;
            m10306w();
        }
    }

    public C3332d m10303h(int i) throws IOException {
        if (this.f7303c) {
            throw new IllegalStateException("closed");
        }
        this.f7301a.m10211b(i);
        return m10306w();
    }

    public C3332d m10302g(int i) throws IOException {
        if (this.f7303c) {
            throw new IllegalStateException("closed");
        }
        this.f7301a.m10218c(i);
        return m10306w();
    }

    public C3332d m10301f(int i) throws IOException {
        if (this.f7303c) {
            throw new IllegalStateException("closed");
        }
        this.f7301a.m10223d(i);
        return m10306w();
    }

    public C3332d m10305k(long j) throws IOException {
        if (this.f7303c) {
            throw new IllegalStateException("closed");
        }
        this.f7301a.m10234h(j);
        return m10306w();
    }

    public C3332d m10304j(long j) throws IOException {
        if (this.f7303c) {
            throw new IllegalStateException("closed");
        }
        this.f7301a.m10237i(j);
        return m10306w();
    }

    public C3332d m10306w() throws IOException {
        if (this.f7303c) {
            throw new IllegalStateException("closed");
        }
        long i = this.f7301a.m10236i();
        if (i > 0) {
            this.f7302b.a_(this.f7301a, i);
        }
        return this;
    }

    public C3332d m10300f() throws IOException {
        if (this.f7303c) {
            throw new IllegalStateException("closed");
        }
        long b = this.f7301a.m10210b();
        if (b > 0) {
            this.f7302b.a_(this.f7301a, b);
        }
        return this;
    }

    public OutputStream m10299d() {
        return new C33431(this);
    }

    public void flush() throws IOException {
        if (this.f7303c) {
            throw new IllegalStateException("closed");
        }
        if (this.f7301a.f7280b > 0) {
            this.f7302b.a_(this.f7301a, this.f7301a.f7280b);
        }
        this.f7302b.flush();
    }

    public void close() throws IOException {
        if (!this.f7303c) {
            Throwable th = null;
            try {
                if (this.f7301a.f7280b > 0) {
                    this.f7302b.a_(this.f7301a, this.f7301a.f7280b);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f7302b.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.f7303c = true;
            if (th != null) {
                C3350t.m10341a(th);
            }
        }
    }

    public C2201s m10293a() {
        return this.f7302b.m4893a();
    }

    public String toString() {
        return "buffer(" + this.f7302b + ")";
    }
}
