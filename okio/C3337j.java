package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* renamed from: okio.j */
public final class C3337j implements C2076r {
    private int f7285a;
    private final C3333e f7286b;
    private final Inflater f7287c;
    private final C3338k f7288d;
    private final CRC32 f7289e;

    public C3337j(C2076r c2076r) {
        this.f7285a = 0;
        this.f7289e = new CRC32();
        if (c2076r == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.f7287c = new Inflater(true);
        this.f7286b = C3342l.m10280a(c2076r);
        this.f7288d = new C3338k(this.f7286b, this.f7287c);
    }

    public long m10268a(C3334c c3334c, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (j == 0) {
            return 0;
        } else {
            if (this.f7285a == 0) {
                m10266b();
                this.f7285a = 1;
            }
            if (this.f7285a == 1) {
                long j2 = c3334c.f7280b;
                long a = this.f7288d.m10271a(c3334c, j);
                if (a != -1) {
                    m10265a(c3334c, j2, a);
                    return a;
                }
                this.f7285a = 2;
            }
            if (this.f7285a == 2) {
                m10267c();
                this.f7285a = 3;
                if (!this.f7286b.m10185g()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    private void m10266b() throws IOException {
        Object obj;
        long a;
        this.f7286b.m10180a(10);
        byte b = this.f7286b.m10182c().m10209b(3);
        if (((b >> 1) & 1) == 1) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            m10265a(this.f7286b.m10182c(), 0, 10);
        }
        m10264a("ID1ID2", 8075, this.f7286b.m10188k());
        this.f7286b.m10184g(8);
        if (((b >> 2) & 1) == 1) {
            this.f7286b.m10180a(2);
            if (obj != null) {
                m10265a(this.f7286b.m10182c(), 0, 2);
            }
            short m = this.f7286b.m10182c().m10243m();
            this.f7286b.m10180a((long) m);
            if (obj != null) {
                m10265a(this.f7286b.m10182c(), 0, (long) m);
            }
            this.f7286b.m10184g((long) m);
        }
        if (((b >> 3) & 1) == 1) {
            a = this.f7286b.m10179a((byte) 0);
            if (a == -1) {
                throw new EOFException();
            }
            if (obj != null) {
                m10265a(this.f7286b.m10182c(), 0, 1 + a);
            }
            this.f7286b.m10184g(1 + a);
        }
        if (((b >> 4) & 1) == 1) {
            a = this.f7286b.m10179a((byte) 0);
            if (a == -1) {
                throw new EOFException();
            }
            if (obj != null) {
                m10265a(this.f7286b.m10182c(), 0, 1 + a);
            }
            this.f7286b.m10184g(1 + a);
        }
        if (obj != null) {
            m10264a("FHCRC", this.f7286b.m10190m(), (short) ((int) this.f7289e.getValue()));
            this.f7289e.reset();
        }
    }

    private void m10267c() throws IOException {
        m10264a("CRC", this.f7286b.m10191n(), (int) this.f7289e.getValue());
        m10264a("ISIZE", this.f7286b.m10191n(), this.f7287c.getTotalOut());
    }

    public C2201s m10269a() {
        return this.f7286b.m4902a();
    }

    public void close() throws IOException {
        this.f7288d.close();
    }

    private void m10265a(C3334c c3334c, long j, long j2) {
        C3347o c3347o = c3334c.f7279a;
        while (j >= ((long) (c3347o.f7310c - c3347o.f7309b))) {
            j -= (long) (c3347o.f7310c - c3347o.f7309b);
            c3347o = c3347o.f7313f;
        }
        while (j2 > 0) {
            int i = (int) (((long) c3347o.f7309b) + j);
            int min = (int) Math.min((long) (c3347o.f7310c - i), j2);
            this.f7289e.update(c3347o.f7308a, i, min);
            j2 -= (long) min;
            c3347o = c3347o.f7313f;
            j = 0;
        }
    }

    private void m10264a(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i)}));
        }
    }
}
