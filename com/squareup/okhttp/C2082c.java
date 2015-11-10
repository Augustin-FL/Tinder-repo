package com.squareup.okhttp;

import com.squareup.okhttp.C2210m.C2209a;
import com.squareup.okhttp.C2222s.C2221a;
import com.squareup.okhttp.C2227u.C2226a;
import com.squareup.okhttp.internal.C2069e;
import com.squareup.okhttp.internal.C2110b;
import com.squareup.okhttp.internal.C2110b.C2105a;
import com.squareup.okhttp.internal.C2110b.C2107c;
import com.squareup.okhttp.internal.C2157k;
import com.squareup.okhttp.internal.http.C2074b;
import com.squareup.okhttp.internal.http.C2121c;
import com.squareup.okhttp.internal.http.C2138h;
import com.squareup.okhttp.internal.http.C2142j;
import com.squareup.okhttp.internal.http.C2150q;
import com.squareup.okhttp.internal.p027b.C2108a;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okio.ByteString;
import okio.C2071q;
import okio.C2072g;
import okio.C2076r;
import okio.C2077h;
import okio.C3332d;
import okio.C3333e;
import okio.C3334c;
import okio.C3342l;
import org.apache.http.protocol.HTTP;

/* renamed from: com.squareup.okhttp.c */
public final class C2082c {
    final C2069e f3080a;
    private final C2110b f3081b;
    private int f3082c;
    private int f3083d;
    private int f3084e;
    private int f3085f;
    private int f3086g;

    /* renamed from: com.squareup.okhttp.c.1 */
    class C20701 implements C2069e {
        final /* synthetic */ C2082c f3055a;

        C20701(C2082c c2082c) {
            this.f3055a = c2082c;
        }

        public C2227u m4888a(C2222s c2222s) throws IOException {
            return this.f3055a.m4933a(c2222s);
        }

        public C2074b m4887a(C2227u c2227u) throws IOException {
            return this.f3055a.m4919a(c2227u);
        }

        public void m4892b(C2222s c2222s) throws IOException {
            this.f3055a.m4932c(c2222s);
        }

        public void m4891a(C2227u c2227u, C2227u c2227u2) throws IOException {
            this.f3055a.m4927a(c2227u, c2227u2);
        }

        public void m4889a() {
            this.f3055a.m4920a();
        }

        public void m4890a(C2121c c2121c) {
            this.f3055a.m4926a(c2121c);
        }
    }

    /* renamed from: com.squareup.okhttp.c.a */
    private final class C2075a implements C2074b {
        final /* synthetic */ C2082c f3060a;
        private final C2105a f3061b;
        private C2071q f3062c;
        private boolean f3063d;
        private C2071q f3064e;

        /* renamed from: com.squareup.okhttp.c.a.1 */
        class C20731 extends C2072g {
            final /* synthetic */ C2082c f3057a;
            final /* synthetic */ C2105a f3058b;
            final /* synthetic */ C2075a f3059c;

            C20731(C2075a c2075a, C2071q c2071q, C2082c c2082c, C2105a c2105a) {
                this.f3059c = c2075a;
                this.f3057a = c2082c;
                this.f3058b = c2105a;
                super(c2071q);
            }

            public void close() throws IOException {
                synchronized (this.f3059c.f3060a) {
                    if (this.f3059c.f3063d) {
                        return;
                    }
                    this.f3059c.f3063d = true;
                    this.f3059c.f3060a.f3082c = this.f3059c.f3060a.f3082c + 1;
                    super.close();
                    this.f3058b.m5027a();
                }
            }
        }

        public C2075a(C2082c c2082c, C2105a c2105a) throws IOException {
            this.f3060a = c2082c;
            this.f3061b = c2105a;
            this.f3062c = c2105a.m5026a(1);
            this.f3064e = new C20731(this, this.f3062c, c2082c, c2105a);
        }

        public void m4899a() {
            synchronized (this.f3060a) {
                if (this.f3063d) {
                    return;
                }
                this.f3063d = true;
                this.f3060a.f3083d = this.f3060a.f3083d + 1;
                C2157k.m5355a(this.f3062c);
                try {
                    this.f3061b.m5028b();
                } catch (IOException e) {
                }
            }
        }

        public C2071q m4900b() {
            return this.f3064e;
        }
    }

    /* renamed from: com.squareup.okhttp.c.b */
    private static class C2080b extends C2079v {
        private final C2107c f3068a;
        private final C3333e f3069b;
        private final String f3070c;
        private final String f3071d;

        /* renamed from: com.squareup.okhttp.c.b.1 */
        class C20781 extends C2077h {
            final /* synthetic */ C2107c f3066a;
            final /* synthetic */ C2080b f3067b;

            C20781(C2080b c2080b, C2076r c2076r, C2107c c2107c) {
                this.f3067b = c2080b;
                this.f3066a = c2107c;
                super(c2076r);
            }

            public void close() throws IOException {
                this.f3066a.close();
                super.close();
            }
        }

        public C2080b(C2107c c2107c, String str, String str2) {
            this.f3068a = c2107c;
            this.f3070c = str;
            this.f3071d = str2;
            this.f3069b = C3342l.m10280a(new C20781(this, c2107c.m5045a(1), c2107c));
        }

        public long m4909a() {
            long j = -1;
            try {
                if (this.f3071d != null) {
                    j = Long.parseLong(this.f3071d);
                }
            } catch (NumberFormatException e) {
            }
            return j;
        }

        public C3333e m4910b() {
            return this.f3069b;
        }
    }

    /* renamed from: com.squareup.okhttp.c.c */
    private static final class C2081c {
        private final String f3072a;
        private final C2210m f3073b;
        private final String f3074c;
        private final Protocol f3075d;
        private final int f3076e;
        private final String f3077f;
        private final C2210m f3078g;
        private final C2207l f3079h;

        public C2081c(C2076r c2076r) throws IOException {
            int i = 0;
            try {
                C3333e a = C3342l.m10280a(c2076r);
                this.f3072a = a.m10194s();
                this.f3074c = a.m10194s();
                C2209a c2209a = new C2209a();
                int a2 = C2082c.m4929b(a);
                for (int i2 = 0; i2 < a2; i2++) {
                    c2209a.m5679a(a.m10194s());
                }
                this.f3073b = c2209a.m5681a();
                C2150q a3 = C2150q.m5319a(a.m10194s());
                this.f3075d = a3.f3332a;
                this.f3076e = a3.f3333b;
                this.f3077f = a3.f3334c;
                C2209a c2209a2 = new C2209a();
                int a4 = C2082c.m4929b(a);
                while (i < a4) {
                    c2209a2.m5679a(a.m10194s());
                    i++;
                }
                this.f3078g = c2209a2.m5681a();
                if (m4913a()) {
                    String s = a.m10194s();
                    if (s.length() > 0) {
                        throw new IOException("expected \"\" but was \"" + s + "\"");
                    }
                    this.f3079h = C2207l.m5671a(a.m10194s(), m4911a(a), m4911a(a));
                } else {
                    this.f3079h = null;
                }
                c2076r.close();
            } catch (Throwable th) {
                c2076r.close();
            }
        }

        public C2081c(C2227u c2227u) {
            this.f3072a = c2227u.m5861a().m5813c();
            this.f3073b = C2142j.m5275c(c2227u);
            this.f3074c = c2227u.m5861a().m5814d();
            this.f3075d = c2227u.m5864b();
            this.f3076e = c2227u.m5865c();
            this.f3077f = c2227u.m5866d();
            this.f3078g = c2227u.m5868f();
            this.f3079h = c2227u.m5867e();
        }

        public void m4915a(C2105a c2105a) throws IOException {
            int i;
            int i2 = 0;
            C3332d a = C3342l.m10279a(c2105a.m5026a(0));
            a.m10166b(this.f3072a);
            a.m10175h(10);
            a.m10166b(this.f3074c);
            a.m10175h(10);
            a.m10177k((long) this.f3073b.m5687a());
            a.m10175h(10);
            int a2 = this.f3073b.m5687a();
            for (i = 0; i < a2; i++) {
                a.m10166b(this.f3073b.m5688a(i));
                a.m10166b(": ");
                a.m10166b(this.f3073b.m5691b(i));
                a.m10175h(10);
            }
            a.m10166b(new C2150q(this.f3075d, this.f3076e, this.f3077f).toString());
            a.m10175h(10);
            a.m10177k((long) this.f3078g.m5687a());
            a.m10175h(10);
            i = this.f3078g.m5687a();
            while (i2 < i) {
                a.m10166b(this.f3078g.m5688a(i2));
                a.m10166b(": ");
                a.m10166b(this.f3078g.m5691b(i2));
                a.m10175h(10);
                i2++;
            }
            if (m4913a()) {
                a.m10175h(10);
                a.m10166b(this.f3079h.m5673a());
                a.m10175h(10);
                m4912a(a, this.f3079h.m5674b());
                m4912a(a, this.f3079h.m5676d());
            }
            a.close();
        }

        private boolean m4913a() {
            return this.f3072a.startsWith("https://");
        }

        private List<Certificate> m4911a(C3333e c3333e) throws IOException {
            int a = C2082c.m4929b(c3333e);
            if (a == -1) {
                return Collections.emptyList();
            }
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                List<Certificate> arrayList = new ArrayList(a);
                for (int i = 0; i < a; i++) {
                    String s = c3333e.m10194s();
                    C3334c c3334c = new C3334c();
                    c3334c.m10204a(ByteString.m10147b(s));
                    arrayList.add(instance.generateCertificate(c3334c.m10233h()));
                }
                return arrayList;
            } catch (CertificateException e) {
                throw new IOException(e.getMessage());
            }
        }

        private void m4912a(C3332d c3332d, List<Certificate> list) throws IOException {
            try {
                c3332d.m10177k((long) list.size());
                c3332d.m10175h(10);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    c3332d.m10166b(ByteString.m10146a(((Certificate) list.get(i)).getEncoded()).m10153b());
                    c3332d.m10175h(10);
                }
            } catch (CertificateEncodingException e) {
                throw new IOException(e.getMessage());
            }
        }

        public boolean m4916a(C2222s c2222s, C2227u c2227u) {
            return this.f3072a.equals(c2222s.m5813c()) && this.f3074c.equals(c2222s.m5814d()) && C2142j.m5269a(c2227u, this.f3073b, c2222s);
        }

        public C2227u m4914a(C2222s c2222s, C2107c c2107c) {
            String a = this.f3078g.m5689a(HTTP.CONTENT_TYPE);
            String a2 = this.f3078g.m5689a(HTTP.CONTENT_LEN);
            return new C2226a().m5842a(new C2221a().m5797a(this.f3072a).m5798a(this.f3074c, null).m5795a(this.f3073b).m5801a()).m5839a(this.f3075d).m5838a(this.f3076e).m5845a(this.f3077f).m5841a(this.f3078g).m5844a(new C2080b(c2107c, a, a2)).m5840a(this.f3079h).m5847a();
        }
    }

    public C2082c(File file, long j) {
        this.f3080a = new C20701(this);
        this.f3081b = C2110b.m5065a(C2108a.f3183a, file, 201105, 2, j);
    }

    private static String m4930b(C2222s c2222s) {
        return C2157k.m5361b(c2222s.m5813c());
    }

    C2227u m4933a(C2222s c2222s) {
        try {
            Closeable a = this.f3081b.m5089a(C2082c.m4930b(c2222s));
            if (a == null) {
                return null;
            }
            try {
                C2081c c2081c = new C2081c(a.m5045a(0));
                C2227u a2 = c2081c.m4914a(c2222s, (C2107c) a);
                if (c2081c.m4916a(c2222s, a2)) {
                    return a2;
                }
                C2157k.m5355a(a2.m5869g());
                return null;
            } catch (IOException e) {
                C2157k.m5355a(a);
                return null;
            }
        } catch (IOException e2) {
            return null;
        }
    }

    private C2074b m4919a(C2227u c2227u) throws IOException {
        C2105a c2105a;
        String d = c2227u.m5861a().m5814d();
        if (C2138h.m5238a(c2227u.m5861a().m5814d())) {
            try {
                m4932c(c2227u.m5861a());
                return null;
            } catch (IOException e) {
                return null;
            }
        } else if (!d.equals("GET") || C2142j.m5274b(c2227u)) {
            return null;
        } else {
            C2081c c2081c = new C2081c(c2227u);
            try {
                C2105a b = this.f3081b.m5091b(C2082c.m4930b(c2227u.m5861a()));
                if (b == null) {
                    return null;
                }
                try {
                    c2081c.m4915a(b);
                    return new C2075a(this, b);
                } catch (IOException e2) {
                    c2105a = b;
                    m4925a(c2105a);
                    return null;
                }
            } catch (IOException e3) {
                c2105a = null;
                m4925a(c2105a);
                return null;
            }
        }
    }

    private void m4932c(C2222s c2222s) throws IOException {
        this.f3081b.m5094c(C2082c.m4930b(c2222s));
    }

    private void m4927a(C2227u c2227u, C2227u c2227u2) {
        C2081c c2081c = new C2081c(c2227u2);
        try {
            C2105a a = ((C2080b) c2227u.m5869g()).f3068a.m5044a();
            if (a != null) {
                c2081c.m4915a(a);
                a.m5027a();
            }
        } catch (IOException e) {
            m4925a(null);
        }
    }

    private void m4925a(C2105a c2105a) {
        if (c2105a != null) {
            try {
                c2105a.m5028b();
            } catch (IOException e) {
            }
        }
    }

    private synchronized void m4926a(C2121c c2121c) {
        this.f3086g++;
        if (c2121c.f3236a != null) {
            this.f3084e++;
        } else if (c2121c.f3237b != null) {
            this.f3085f++;
        }
    }

    private synchronized void m4920a() {
        this.f3085f++;
    }

    private static int m4929b(C3333e c3333e) throws IOException {
        try {
            long o = c3333e.m10192o();
            String s = c3333e.m10194s();
            if (o >= 0 && o <= 2147483647L && s.isEmpty()) {
                return (int) o;
            }
            throw new IOException("expected an int but was \"" + o + s + "\"");
        } catch (NumberFormatException e) {
            throw new IOException(e.getMessage());
        }
    }
}
