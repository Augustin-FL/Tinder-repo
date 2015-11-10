package okio;

import java.io.IOException;

/* renamed from: okio.h */
public abstract class C2077h implements C2076r {
    private final C2076r f3065a;

    public C2077h(C2076r c2076r) {
        if (c2076r == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f3065a = c2076r;
    }

    public long m4903a(C3334c c3334c, long j) throws IOException {
        return this.f3065a.m4901a(c3334c, j);
    }

    public C2201s m4904a() {
        return this.f3065a.m4902a();
    }

    public void close() throws IOException {
        this.f3065a.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f3065a.toString() + ")";
    }
}
