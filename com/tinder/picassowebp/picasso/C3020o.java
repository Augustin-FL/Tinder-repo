package com.tinder.picassowebp.picasso;

import android.backport.webp.WebPFactory;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.NetworkInfo;
import com.facebook.internal.NativeProtocol;
import com.tinder.picassowebp.picasso.Downloader.C2982a;
import com.tinder.picassowebp.picasso.Picasso.LoadedFrom;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.tinder.picassowebp.picasso.o */
class C3020o extends C2983c {
    int f6403o;
    private final Downloader f6404p;

    public C3020o(Picasso picasso, C3014i c3014i, C3005d c3005d, C3033v c3033v, C2993a c2993a, Downloader downloader) {
        super(picasso, c3014i, c3005d, c3033v, c2993a);
        this.f6404p = downloader;
        this.f6403o = 2;
    }

    Bitmap m9092a(C3026s c3026s) throws IOException {
        C2982a a = this.f6404p.m8943a(c3026s.f6427a, this.f6403o == 0);
        if (a == null) {
            return null;
        }
        this.l = a.f6286c ? LoadedFrom.DISK : LoadedFrom.NETWORK;
        Bitmap b = a.m8941b();
        if (b != null) {
            return b;
        }
        InputStream a2 = a.m8940a();
        if (a2 == null) {
            return null;
        }
        if (this.l == LoadedFrom.NETWORK && a.m8942c() > 0) {
            this.d.m9138a(a.m8942c());
        }
        try {
            b = m9091a(a2, c3026s);
            return b;
        } finally {
            ab.m9025a(a2);
        }
    }

    boolean m9093a(boolean z, NetworkInfo networkInfo) {
        if (!(this.f6403o > 0)) {
            return false;
        }
        this.f6403o--;
        if (networkInfo == null || networkInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }

    boolean m9094f() {
        return true;
    }

    private Bitmap m9091a(InputStream inputStream, C3026s c3026s) throws IOException {
        InputStream c3019n = new C3019n(inputStream);
        long a = c3019n.m9089a((int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        Options c = C2983c.m8951c(c3026s);
        boolean a2 = C2983c.m8949a(c);
        boolean c2 = ab.m9034c(c3019n);
        c3019n.m9090a(a);
        if (c2) {
            byte[] b = ab.m9032b(c3019n);
            if (a2) {
                C2983c.m8948a(c3026s.f6430d, c3026s.f6431e, c);
            }
            return WebPFactory.nativeDecodeByteArray(b, c);
        }
        if (a2) {
            C2983c.m8948a(c3026s.f6430d, c3026s.f6431e, c);
            c3019n.m9090a(a);
        }
        return BitmapFactory.decodeStream(c3019n);
    }
}
