package okio;

import java.io.IOException;

/* renamed from: okio.g */
public abstract class C2072g implements C2071q {
    private final C2071q f3056a;

    public C2072g(C2071q c2071q) {
        if (c2071q == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f3056a = c2071q;
    }

    public void a_(C3334c c3334c, long j) throws IOException {
        this.f3056a.a_(c3334c, j);
    }

    public void flush() throws IOException {
        this.f3056a.flush();
    }

    public C2201s m4894a() {
        return this.f3056a.m4893a();
    }

    public void close() throws IOException {
        this.f3056a.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f3056a.toString() + ")";
    }
}
