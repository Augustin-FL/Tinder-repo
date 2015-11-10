package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.C2090g;
import com.squareup.okhttp.C2092h;
import com.squareup.okhttp.C2210m;
import com.squareup.okhttp.C2210m.C2209a;
import com.squareup.okhttp.C2227u.C2226a;
import com.squareup.okhttp.internal.C2113d;
import com.squareup.okhttp.internal.C2157k;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;
import okio.C2071q;
import okio.C2076r;
import okio.C2201s;
import okio.C3332d;
import okio.C3333e;
import okio.C3334c;
import okio.C3336i;
import okio.C3342l;

/* renamed from: com.squareup.okhttp.internal.http.e */
public final class C2130e {
    private final C2092h f3256a;
    private final C2090g f3257b;
    private final Socket f3258c;
    private final C3333e f3259d;
    private final C3332d f3260e;
    private int f3261f;
    private int f3262g;

    /* renamed from: com.squareup.okhttp.internal.http.e.a */
    private abstract class C2124a implements C2076r {
        protected final C3336i f3238a;
        protected boolean f3239b;
        final /* synthetic */ C2130e f3240c;

        private C2124a(C2130e c2130e) {
            this.f3240c = c2130e;
            this.f3238a = new C3336i(this.f3240c.f3259d.m4902a());
        }

        public C2201s m5151a() {
            return this.f3238a;
        }

        protected final void m5152a(boolean z) throws IOException {
            if (this.f3240c.f3261f != 5) {
                throw new IllegalStateException("state: " + this.f3240c.f3261f);
            }
            this.f3240c.m5163a(this.f3238a);
            this.f3240c.f3261f = 0;
            if (z && this.f3240c.f3262g == 1) {
                this.f3240c.f3262g = 0;
                C2113d.f3215b.m5114a(this.f3240c.f3256a, this.f3240c.f3257b);
            } else if (this.f3240c.f3262g == 2) {
                this.f3240c.f3261f = 6;
                this.f3240c.f3257b.m4967d().close();
            }
        }

        protected final void m5153b() {
            C2157k.m5357a(this.f3240c.f3257b.m4967d());
            this.f3240c.f3261f = 6;
        }
    }

    /* renamed from: com.squareup.okhttp.internal.http.e.b */
    private final class C2125b implements C2071q {
        final /* synthetic */ C2130e f3241a;
        private final C3336i f3242b;
        private boolean f3243c;

        private C2125b(C2130e c2130e) {
            this.f3241a = c2130e;
            this.f3242b = new C3336i(this.f3241a.f3260e.m4893a());
        }

        public C2201s m5154a() {
            return this.f3242b;
        }

        public void a_(C3334c c3334c, long j) throws IOException {
            if (this.f3243c) {
                throw new IllegalStateException("closed");
            } else if (j != 0) {
                this.f3241a.f3260e.m10176j(j);
                this.f3241a.f3260e.m10166b("\r\n");
                this.f3241a.f3260e.a_(c3334c, j);
                this.f3241a.f3260e.m10166b("\r\n");
            }
        }

        public synchronized void flush() throws IOException {
            if (!this.f3243c) {
                this.f3241a.f3260e.flush();
            }
        }

        public synchronized void close() throws IOException {
            if (!this.f3243c) {
                this.f3243c = true;
                this.f3241a.f3260e.m10166b("0\r\n\r\n");
                this.f3241a.m5163a(this.f3242b);
                this.f3241a.f3261f = 3;
            }
        }
    }

    /* renamed from: com.squareup.okhttp.internal.http.e.c */
    private class C2126c extends C2124a {
        final /* synthetic */ C2130e f3244d;
        private long f3245e;
        private boolean f3246f;
        private final C2137g f3247g;

        C2126c(C2130e c2130e, C2137g c2137g) throws IOException {
            this.f3244d = c2130e;
            super(null);
            this.f3245e = -1;
            this.f3246f = true;
            this.f3247g = c2137g;
        }

        public long m5156a(C3334c c3334c, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.b) {
                throw new IllegalStateException("closed");
            } else if (!this.f3246f) {
                return -1;
            } else {
                if (this.f3245e == 0 || this.f3245e == -1) {
                    m5155c();
                    if (!this.f3246f) {
                        return -1;
                    }
                }
                long a = this.f3244d.f3259d.m4901a(c3334c, Math.min(j, this.f3245e));
                if (a == -1) {
                    m5153b();
                    throw new IOException("unexpected end of stream");
                }
                this.f3245e -= a;
                return a;
            }
        }

        private void m5155c() throws IOException {
            if (this.f3245e != -1) {
                this.f3244d.f3259d.m10194s();
            }
            try {
                this.f3245e = this.f3244d.f3259d.m10193p();
                String trim = this.f3244d.f3259d.m10194s().trim();
                if (this.f3245e < 0 || !(trim.isEmpty() || trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f3245e + trim + "\"");
                } else if (this.f3245e == 0) {
                    this.f3246f = false;
                    C2209a c2209a = new C2209a();
                    this.f3244d.m5175a(c2209a);
                    this.f3247g.m5222a(c2209a.m5681a());
                    m5152a(true);
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        public void close() throws IOException {
            if (!this.b) {
                if (this.f3246f && !C2157k.m5359a((C2076r) this, 100, TimeUnit.MILLISECONDS)) {
                    m5153b();
                }
                this.b = true;
            }
        }
    }

    /* renamed from: com.squareup.okhttp.internal.http.e.d */
    private final class C2127d implements C2071q {
        final /* synthetic */ C2130e f3248a;
        private final C3336i f3249b;
        private boolean f3250c;
        private long f3251d;

        private C2127d(C2130e c2130e, long j) {
            this.f3248a = c2130e;
            this.f3249b = new C3336i(this.f3248a.f3260e.m4893a());
            this.f3251d = j;
        }

        public C2201s m5157a() {
            return this.f3249b;
        }

        public void a_(C3334c c3334c, long j) throws IOException {
            if (this.f3250c) {
                throw new IllegalStateException("closed");
            }
            C2157k.m5354a(c3334c.m10210b(), 0, j);
            if (j > this.f3251d) {
                throw new ProtocolException("expected " + this.f3251d + " bytes but received " + j);
            }
            this.f3248a.f3260e.a_(c3334c, j);
            this.f3251d -= j;
        }

        public void flush() throws IOException {
            if (!this.f3250c) {
                this.f3248a.f3260e.flush();
            }
        }

        public void close() throws IOException {
            if (!this.f3250c) {
                this.f3250c = true;
                if (this.f3251d > 0) {
                    throw new ProtocolException("unexpected end of stream");
                }
                this.f3248a.m5163a(this.f3249b);
                this.f3248a.f3261f = 3;
            }
        }
    }

    /* renamed from: com.squareup.okhttp.internal.http.e.e */
    private class C2128e extends C2124a {
        final /* synthetic */ C2130e f3252d;
        private long f3253e;

        public C2128e(C2130e c2130e, long j) throws IOException {
            this.f3252d = c2130e;
            super(null);
            this.f3253e = j;
            if (this.f3253e == 0) {
                m5152a(true);
            }
        }

        public long m5158a(C3334c c3334c, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.b) {
                throw new IllegalStateException("closed");
            } else if (this.f3253e == 0) {
                return -1;
            } else {
                long a = this.f3252d.f3259d.m4901a(c3334c, Math.min(this.f3253e, j));
                if (a == -1) {
                    m5153b();
                    throw new ProtocolException("unexpected end of stream");
                }
                this.f3253e -= a;
                if (this.f3253e == 0) {
                    m5152a(true);
                }
                return a;
            }
        }

        public void close() throws IOException {
            if (!this.b) {
                if (!(this.f3253e == 0 || C2157k.m5359a((C2076r) this, 100, TimeUnit.MILLISECONDS))) {
                    m5153b();
                }
                this.b = true;
            }
        }
    }

    /* renamed from: com.squareup.okhttp.internal.http.e.f */
    private class C2129f extends C2124a {
        final /* synthetic */ C2130e f3254d;
        private boolean f3255e;

        private C2129f(C2130e c2130e) {
            this.f3254d = c2130e;
            super(null);
        }

        public long m5159a(C3334c c3334c, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.b) {
                throw new IllegalStateException("closed");
            } else if (this.f3255e) {
                return -1;
            } else {
                long a = this.f3254d.f3259d.m4901a(c3334c, j);
                if (a != -1) {
                    return a;
                }
                this.f3255e = true;
                m5152a(false);
                return -1;
            }
        }

        public void close() throws IOException {
            if (!this.b) {
                if (!this.f3255e) {
                    m5153b();
                }
                this.b = true;
            }
        }
    }

    public C2130e(C2092h c2092h, C2090g c2090g, Socket socket) throws IOException {
        this.f3261f = 0;
        this.f3262g = 0;
        this.f3256a = c2092h;
        this.f3257b = c2090g;
        this.f3258c = socket;
        this.f3259d = C3342l.m10280a(C3342l.m10288b(socket));
        this.f3260e = C3342l.m10279a(C3342l.m10283a(socket));
    }

    public void m5173a(int i, int i2) {
        if (i != 0) {
            this.f3259d.m4902a().m5627a((long) i, TimeUnit.MILLISECONDS);
        }
        if (i2 != 0) {
            this.f3260e.m4893a().m5627a((long) i2, TimeUnit.MILLISECONDS);
        }
    }

    public void m5172a() {
        this.f3262g = 1;
        if (this.f3261f == 0) {
            this.f3262g = 0;
            C2113d.f3215b.m5114a(this.f3256a, this.f3257b);
        }
    }

    public void m5179b() throws IOException {
        this.f3262g = 2;
        if (this.f3261f == 0) {
            this.f3261f = 6;
            this.f3257b.m4967d().close();
        }
    }

    public boolean m5180c() {
        return this.f3261f == 6;
    }

    public void m5177a(Object obj) throws IOException {
        C2113d.f3215b.m5113a(this.f3257b, obj);
    }

    public void m5181d() throws IOException {
        this.f3260e.flush();
    }

    public long m5182e() {
        return this.f3259d.m10182c().m10210b();
    }

    public boolean m5183f() {
        int soTimeout;
        try {
            soTimeout = this.f3258c.getSoTimeout();
            this.f3258c.setSoTimeout(1);
            if (this.f3259d.m10185g()) {
                this.f3258c.setSoTimeout(soTimeout);
                return false;
            }
            this.f3258c.setSoTimeout(soTimeout);
            return true;
        } catch (SocketTimeoutException e) {
            return true;
        } catch (IOException e2) {
            return false;
        } catch (Throwable th) {
            this.f3258c.setSoTimeout(soTimeout);
        }
    }

    public void m5176a(C2210m c2210m, String str) throws IOException {
        if (this.f3261f != 0) {
            throw new IllegalStateException("state: " + this.f3261f);
        }
        this.f3260e.m10166b(str).m10166b("\r\n");
        int a = c2210m.m5687a();
        for (int i = 0; i < a; i++) {
            this.f3260e.m10166b(c2210m.m5688a(i)).m10166b(": ").m10166b(c2210m.m5691b(i)).m10166b("\r\n");
        }
        this.f3260e.m10166b("\r\n");
        this.f3261f = 1;
    }

    public C2226a m5184g() throws IOException {
        if (this.f3261f == 1 || this.f3261f == 3) {
            C2226a a;
            C2150q a2;
            do {
                try {
                    a2 = C2150q.m5319a(this.f3259d.m10194s());
                    a = new C2226a().m5839a(a2.f3332a).m5838a(a2.f3333b).m5845a(a2.f3334c);
                    C2209a c2209a = new C2209a();
                    m5175a(c2209a);
                    c2209a.m5680a(C2142j.f3302d, a2.f3332a.toString());
                    a.m5841a(c2209a.m5681a());
                } catch (Throwable e) {
                    IOException iOException = new IOException("unexpected end of stream on " + this.f3257b + " (recycle count=" + C2113d.f3215b.m5119b(this.f3257b) + ")");
                    iOException.initCause(e);
                    throw iOException;
                }
            } while (a2.f3333b == 100);
            this.f3261f = 4;
            return a;
        }
        throw new IllegalStateException("state: " + this.f3261f);
    }

    public void m5175a(C2209a c2209a) throws IOException {
        while (true) {
            String s = this.f3259d.m10194s();
            if (s.length() != 0) {
                C2113d.f3215b.m5116a(c2209a, s);
            } else {
                return;
            }
        }
    }

    public C2071q m5185h() {
        if (this.f3261f != 1) {
            throw new IllegalStateException("state: " + this.f3261f);
        }
        this.f3261f = 2;
        return new C2125b();
    }

    public C2071q m5170a(long j) {
        if (this.f3261f != 1) {
            throw new IllegalStateException("state: " + this.f3261f);
        }
        this.f3261f = 2;
        return new C2127d(j, null);
    }

    public void m5174a(C2145m c2145m) throws IOException {
        if (this.f3261f != 1) {
            throw new IllegalStateException("state: " + this.f3261f);
        }
        this.f3261f = 3;
        c2145m.m5285a(this.f3260e);
    }

    public C2076r m5178b(long j) throws IOException {
        if (this.f3261f != 4) {
            throw new IllegalStateException("state: " + this.f3261f);
        }
        this.f3261f = 5;
        return new C2128e(this, j);
    }

    public C2076r m5171a(C2137g c2137g) throws IOException {
        if (this.f3261f != 4) {
            throw new IllegalStateException("state: " + this.f3261f);
        }
        this.f3261f = 5;
        return new C2126c(this, c2137g);
    }

    public C2076r m5186i() throws IOException {
        if (this.f3261f != 4) {
            throw new IllegalStateException("state: " + this.f3261f);
        }
        this.f3261f = 5;
        return new C2129f();
    }

    private void m5163a(C3336i c3336i) {
        C2201s a = c3336i.m10258a();
        c3336i.m10257a(C2201s.f3530b);
        a.m5629f();
        a.p_();
    }
}
