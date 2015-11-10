package com.squareup.okhttp.internal.spdy;

import java.io.IOException;
import java.util.List;
import okio.C3333e;

/* renamed from: com.squareup.okhttp.internal.spdy.j */
public interface C2180j {
    public static final C2180j f3441a;

    /* renamed from: com.squareup.okhttp.internal.spdy.j.1 */
    static class C21811 implements C2180j {
        C21811() {
        }

        public boolean m5495a(int i, List<C2162c> list) {
            return true;
        }

        public boolean m5496a(int i, List<C2162c> list, boolean z) {
            return true;
        }

        public boolean m5497a(int i, C3333e c3333e, int i2, boolean z) throws IOException {
            c3333e.m10184g((long) i2);
            return true;
        }

        public void m5494a(int i, ErrorCode errorCode) {
        }
    }

    void m5490a(int i, ErrorCode errorCode);

    boolean m5491a(int i, List<C2162c> list);

    boolean m5492a(int i, List<C2162c> list, boolean z);

    boolean m5493a(int i, C3333e c3333e, int i2, boolean z) throws IOException;

    static {
        f3441a = new C21811();
    }
}
