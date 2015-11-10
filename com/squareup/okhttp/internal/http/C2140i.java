package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.C2079v;
import com.squareup.okhttp.C2222s;
import com.squareup.okhttp.C2227u;
import com.squareup.okhttp.C2227u.C2226a;
import java.io.IOException;
import okio.C2071q;
import okio.C2076r;
import okio.C3342l;
import org.apache.http.protocol.HTTP;

/* renamed from: com.squareup.okhttp.internal.http.i */
public final class C2140i implements C2139r {
    private final C2137g f3297a;
    private final C2130e f3298b;

    public C2140i(C2137g c2137g, C2130e c2130e) {
        this.f3297a = c2137g;
        this.f3298b = c2130e;
    }

    public C2071q m5252a(C2222s c2222s, long j) throws IOException {
        if (HTTP.CHUNK_CODING.equalsIgnoreCase(c2222s.m5809a(HTTP.TRANSFER_ENCODING))) {
            return this.f3298b.m5185h();
        }
        if (j != -1) {
            return this.f3298b.m5170a(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    public void m5253a() throws IOException {
        this.f3298b.m5181d();
    }

    public void m5255a(C2145m c2145m) throws IOException {
        this.f3298b.m5174a(c2145m);
    }

    public void m5256a(C2222s c2222s) throws IOException {
        this.f3297a.m5223b();
        this.f3298b.m5176a(c2222s.m5815e(), C2144l.m5281a(c2222s, this.f3297a.m5231i().m4966c().m5876b().type(), this.f3297a.m5231i().m4975l()));
    }

    public C2226a m5257b() throws IOException {
        return this.f3298b.m5184g();
    }

    public void m5258c() throws IOException {
        if (m5259d()) {
            this.f3298b.m5172a();
        } else {
            this.f3298b.m5179b();
        }
    }

    public boolean m5259d() {
        if ("close".equalsIgnoreCase(this.f3297a.m5229g().m5809a(HTTP.CONN_DIRECTIVE)) || "close".equalsIgnoreCase(this.f3297a.m5230h().m5862a(HTTP.CONN_DIRECTIVE)) || this.f3298b.m5180c()) {
            return false;
        }
        return true;
    }

    public C2079v m5251a(C2227u c2227u) throws IOException {
        return new C2143k(c2227u.m5868f(), C3342l.m10280a(m5250b(c2227u)));
    }

    private C2076r m5250b(C2227u c2227u) throws IOException {
        if (!C2137g.m5205a(c2227u)) {
            return this.f3298b.m5178b(0);
        }
        if (HTTP.CHUNK_CODING.equalsIgnoreCase(c2227u.m5862a(HTTP.TRANSFER_ENCODING))) {
            return this.f3298b.m5171a(this.f3297a);
        }
        long a = C2142j.m5263a(c2227u);
        if (a != -1) {
            return this.f3298b.m5178b(a);
        }
        return this.f3298b.m5186i();
    }

    public void m5254a(C2137g c2137g) throws IOException {
        this.f3298b.m5177a((Object) c2137g);
    }
}
