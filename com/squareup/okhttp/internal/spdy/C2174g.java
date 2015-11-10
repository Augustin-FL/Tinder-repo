package com.squareup.okhttp.internal.spdy;

import java.io.IOException;

/* renamed from: com.squareup.okhttp.internal.spdy.g */
public interface C2174g {
    public static final C2174g f3432a;

    /* renamed from: com.squareup.okhttp.internal.spdy.g.1 */
    static class C21751 implements C2174g {
        C21751() {
        }

        public void m5479a(C2204n c2204n) throws IOException {
            c2204n.m5658a(ErrorCode.REFUSED_STREAM);
        }
    }

    void m5478a(C2204n c2204n) throws IOException;

    static {
        f3432a = new C21751();
    }
}
