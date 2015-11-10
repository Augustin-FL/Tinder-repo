package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.internal.C2157k;
import java.io.IOException;
import java.net.ProtocolException;
import okio.C2071q;
import okio.C2201s;
import okio.C3334c;

/* renamed from: com.squareup.okhttp.internal.http.m */
public final class C2145m implements C2071q {
    private boolean f3306a;
    private final int f3307b;
    private final C3334c f3308c;

    public C2145m(int i) {
        this.f3308c = new C3334c();
        this.f3307b = i;
    }

    public C2145m() {
        this(-1);
    }

    public void close() throws IOException {
        if (!this.f3306a) {
            this.f3306a = true;
            if (this.f3308c.m10210b() < ((long) this.f3307b)) {
                throw new ProtocolException("content-length promised " + this.f3307b + " bytes, but received " + this.f3308c.m10210b());
            }
        }
    }

    public void a_(C3334c c3334c, long j) throws IOException {
        if (this.f3306a) {
            throw new IllegalStateException("closed");
        }
        C2157k.m5354a(c3334c.m10210b(), 0, j);
        if (this.f3307b == -1 || this.f3308c.m10210b() <= ((long) this.f3307b) - j) {
            this.f3308c.a_(c3334c, j);
            return;
        }
        throw new ProtocolException("exceeded content-length limit of " + this.f3307b + " bytes");
    }

    public void flush() throws IOException {
    }

    public C2201s m5284a() {
        return C2201s.f3530b;
    }

    public long m5286b() throws IOException {
        return this.f3308c.m10210b();
    }

    public void m5285a(C2071q c2071q) throws IOException {
        C3334c c3334c = new C3334c();
        this.f3308c.m10205a(c3334c, 0, this.f3308c.m10210b());
        c2071q.a_(c3334c, c3334c.m10210b());
    }
}
