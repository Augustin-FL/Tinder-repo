package com.squareup.okhttp.internal.spdy;

import com.google.android.gms.location.places.Place;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import okio.ByteString;
import okio.C2076r;
import okio.C2077h;
import okio.C3333e;
import okio.C3334c;
import okio.C3338k;
import okio.C3342l;

/* renamed from: com.squareup.okhttp.internal.spdy.h */
class C2178h {
    private final C3338k f3435a;
    private int f3436b;
    private final C3333e f3437c;

    /* renamed from: com.squareup.okhttp.internal.spdy.h.1 */
    class C21761 extends C2077h {
        final /* synthetic */ C2178h f3433a;

        C21761(C2178h c2178h, C2076r c2076r) {
            this.f3433a = c2178h;
            super(c2076r);
        }

        public long m5480a(C3334c c3334c, long j) throws IOException {
            if (this.f3433a.f3436b == 0) {
                return -1;
            }
            long a = super.m4903a(c3334c, Math.min(j, (long) this.f3433a.f3436b));
            if (a == -1) {
                return -1;
            }
            this.f3433a.f3436b = (int) (((long) this.f3433a.f3436b) - a);
            return a;
        }
    }

    /* renamed from: com.squareup.okhttp.internal.spdy.h.2 */
    class C21772 extends Inflater {
        final /* synthetic */ C2178h f3434a;

        C21772(C2178h c2178h) {
            this.f3434a = c2178h;
        }

        public int inflate(byte[] bArr, int i, int i2) throws DataFormatException {
            int inflate = super.inflate(bArr, i, i2);
            if (inflate != 0 || !needsDictionary()) {
                return inflate;
            }
            setDictionary(C2185l.f3454a);
            return super.inflate(bArr, i, i2);
        }
    }

    public C2178h(C3333e c3333e) {
        this.f3435a = new C3338k(new C21761(this, c3333e), new C21772(this));
        this.f3437c = C3342l.m10280a(this.f3435a);
    }

    public List<C2162c> m5485a(int i) throws IOException {
        this.f3436b += i;
        int l = this.f3437c.m10189l();
        if (l < 0) {
            throw new IOException("numberOfPairs < 0: " + l);
        } else if (l > Place.TYPE_SUBLOCALITY_LEVEL_2) {
            throw new IOException("numberOfPairs > 1024: " + l);
        } else {
            List<C2162c> arrayList = new ArrayList(l);
            for (int i2 = 0; i2 < l; i2++) {
                ByteString e = m5483b().m10156e();
                ByteString b = m5483b();
                if (e.m10157f() == 0) {
                    throw new IOException("name.size == 0");
                }
                arrayList.add(new C2162c(e, b));
            }
            m5484c();
            return arrayList;
        }
    }

    private ByteString m5483b() throws IOException {
        return this.f3437c.m10181c((long) this.f3437c.m10189l());
    }

    private void m5484c() throws IOException {
        if (this.f3436b > 0) {
            this.f3435a.m10273b();
            if (this.f3436b != 0) {
                throw new IOException("compressedLimit > 0: " + this.f3436b);
            }
        }
    }

    public void m5486a() throws IOException {
        this.f3437c.close();
    }
}
