package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.Inflater;

/* renamed from: okio.k */
public final class C3338k implements C2076r {
    private final C3333e f7290a;
    private final Inflater f7291b;
    private int f7292c;
    private boolean f7293d;

    public C3338k(C2076r c2076r, Inflater inflater) {
        this(C3342l.m10280a(c2076r), inflater);
    }

    C3338k(C3333e c3333e, Inflater inflater) {
        if (c3333e == null) {
            throw new IllegalArgumentException("source == null");
        } else if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        } else {
            this.f7290a = c3333e;
            this.f7291b = inflater;
        }
    }

    public long m10271a(C3334c c3334c, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.f7293d) {
            throw new IllegalStateException("closed");
        } else if (j == 0) {
            return 0;
        } else {
            boolean b;
            do {
                b = m10273b();
                try {
                    C3347o e = c3334c.m10226e(1);
                    int inflate = this.f7291b.inflate(e.f7308a, e.f7310c, 2048 - e.f7310c);
                    if (inflate > 0) {
                        e.f7310c += inflate;
                        c3334c.f7280b += (long) inflate;
                        return (long) inflate;
                    } else if (this.f7291b.finished() || this.f7291b.needsDictionary()) {
                        m10270c();
                        if (e.f7309b == e.f7310c) {
                            c3334c.f7279a = e.m10328a();
                            C3348p.m10334a(e);
                        }
                        return -1;
                    }
                } catch (Throwable e2) {
                    throw new IOException(e2);
                }
            } while (!b);
            throw new EOFException("source exhausted prematurely");
        }
    }

    public boolean m10273b() throws IOException {
        if (!this.f7291b.needsInput()) {
            return false;
        }
        m10270c();
        if (this.f7291b.getRemaining() != 0) {
            throw new IllegalStateException("?");
        } else if (this.f7290a.m10185g()) {
            return true;
        } else {
            C3347o c3347o = this.f7290a.m10182c().f7279a;
            this.f7292c = c3347o.f7310c - c3347o.f7309b;
            this.f7291b.setInput(c3347o.f7308a, c3347o.f7309b, this.f7292c);
            return false;
        }
    }

    private void m10270c() throws IOException {
        if (this.f7292c != 0) {
            int remaining = this.f7292c - this.f7291b.getRemaining();
            this.f7292c -= remaining;
            this.f7290a.m10184g((long) remaining);
        }
    }

    public C2201s m10272a() {
        return this.f7290a.m4902a();
    }

    public void close() throws IOException {
        if (!this.f7293d) {
            this.f7291b.end();
            this.f7293d = true;
            this.f7290a.close();
        }
    }
}
