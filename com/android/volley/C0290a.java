package com.android.volley;

import java.util.Collections;
import java.util.Map;

/* renamed from: com.android.volley.a */
public interface C0290a {

    /* renamed from: com.android.volley.a.a */
    public static class C0289a {
        public byte[] f213a;
        public String f214b;
        public long f215c;
        public long f216d;
        public long f217e;
        public Map<String, String> f218f;

        public C0289a() {
            this.f218f = Collections.emptyMap();
        }

        public boolean m248a() {
            return this.f216d < System.currentTimeMillis();
        }

        public boolean m249b() {
            return this.f217e < System.currentTimeMillis();
        }
    }

    C0289a m250a(String str);

    void m251a();

    void m252a(String str, C0289a c0289a);
}
