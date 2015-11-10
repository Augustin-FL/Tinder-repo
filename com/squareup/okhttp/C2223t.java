package com.squareup.okhttp;

import com.squareup.okhttp.internal.C2157k;
import java.io.IOException;
import okio.C3332d;

/* renamed from: com.squareup.okhttp.t */
public abstract class C2223t {

    /* renamed from: com.squareup.okhttp.t.1 */
    static class C22241 extends C2223t {
        final /* synthetic */ C2215p f3625a;
        final /* synthetic */ int f3626b;
        final /* synthetic */ byte[] f3627c;
        final /* synthetic */ int f3628d;

        C22241(C2215p c2215p, int i, byte[] bArr, int i2) {
            this.f3625a = c2215p;
            this.f3626b = i;
            this.f3627c = bArr;
            this.f3628d = i2;
        }

        public long m5824a() {
            return (long) this.f3626b;
        }

        public void m5825a(C3332d c3332d) throws IOException {
            c3332d.m10170c(this.f3627c, this.f3628d, this.f3626b);
        }
    }

    public abstract void m5823a(C3332d c3332d) throws IOException;

    public long m5822a() throws IOException {
        return -1;
    }

    public static C2223t m5820a(C2215p c2215p, byte[] bArr) {
        return C2223t.m5821a(c2215p, bArr, 0, bArr.length);
    }

    public static C2223t m5821a(C2215p c2215p, byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("content == null");
        }
        C2157k.m5354a((long) bArr.length, (long) i, (long) i2);
        return new C22241(c2215p, i2, bArr, i);
    }
}
