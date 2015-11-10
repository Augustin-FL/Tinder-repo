package okio;

import java.io.IOException;
import java.util.zip.Deflater;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* renamed from: okio.f */
public final class C3335f implements C2071q {
    private final C3332d f7281a;
    private final Deflater f7282b;
    private boolean f7283c;

    public C3335f(C2071q c2071q, Deflater deflater) {
        this(C3342l.m10279a(c2071q), deflater);
    }

    C3335f(C3332d c3332d, Deflater deflater) {
        if (c3332d == null) {
            throw new IllegalArgumentException("source == null");
        } else if (deflater == null) {
            throw new IllegalArgumentException("inflater == null");
        } else {
            this.f7281a = c3332d;
            this.f7282b = deflater;
        }
    }

    public void a_(C3334c c3334c, long j) throws IOException {
        C3350t.m10340a(c3334c.f7280b, 0, j);
        while (j > 0) {
            C3347o c3347o = c3334c.f7279a;
            int min = (int) Math.min(j, (long) (c3347o.f7310c - c3347o.f7309b));
            this.f7282b.setInput(c3347o.f7308a, c3347o.f7309b, min);
            m10254a(false);
            c3334c.f7280b -= (long) min;
            c3347o.f7309b += min;
            if (c3347o.f7309b == c3347o.f7310c) {
                c3334c.f7279a = c3347o.m10328a();
                C3348p.m10334a(c3347o);
            }
            j -= (long) min;
        }
    }

    @IgnoreJRERequirement
    private void m10254a(boolean z) throws IOException {
        C3334c c = this.f7281a.m10168c();
        while (true) {
            C3347o e = c.m10226e(1);
            int deflate = z ? this.f7282b.deflate(e.f7308a, e.f7310c, 2048 - e.f7310c, 2) : this.f7282b.deflate(e.f7308a, e.f7310c, 2048 - e.f7310c);
            if (deflate > 0) {
                e.f7310c += deflate;
                c.f7280b += (long) deflate;
                this.f7281a.m10178w();
            } else if (this.f7282b.needsInput()) {
                break;
            }
        }
        if (e.f7309b == e.f7310c) {
            c.f7279a = e.m10328a();
            C3348p.m10334a(e);
        }
    }

    public void flush() throws IOException {
        m10254a(true);
        this.f7281a.flush();
    }

    void m10256b() throws IOException {
        this.f7282b.finish();
        m10254a(false);
    }

    public void close() throws IOException {
        if (!this.f7283c) {
            Throwable th;
            Throwable th2 = null;
            try {
                m10256b();
            } catch (Throwable th3) {
                th2 = th3;
            }
            try {
                this.f7282b.end();
                th = th2;
            } catch (Throwable th4) {
                th = th4;
                if (th2 != null) {
                    th = th2;
                }
            }
            try {
                this.f7281a.close();
            } catch (Throwable th22) {
                if (th == null) {
                    th = th22;
                }
            }
            this.f7283c = true;
            if (th != null) {
                C3350t.m10341a(th);
            }
        }
    }

    public C2201s m10255a() {
        return this.f7281a.m4893a();
    }

    public String toString() {
        return "DeflaterSink(" + this.f7281a + ")";
    }
}
