package com.tinder.picassowebp.picasso;

import android.graphics.Bitmap;
import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;

public interface Downloader {

    public static class ResponseException extends IOException {
        public ResponseException(String str) {
            super(str);
        }
    }

    /* renamed from: com.tinder.picassowebp.picasso.Downloader.a */
    public static class C2982a {
        final InputStream f6284a;
        final Bitmap f6285b;
        final boolean f6286c;
        final long f6287d;

        public C2982a(InputStream inputStream, boolean z, long j) {
            if (inputStream == null) {
                throw new IllegalArgumentException("Stream may not be null.");
            }
            this.f6284a = inputStream;
            this.f6285b = null;
            this.f6286c = z;
            this.f6287d = j;
        }

        public InputStream m8940a() {
            return this.f6284a;
        }

        public Bitmap m8941b() {
            return this.f6285b;
        }

        public long m8942c() {
            return this.f6287d;
        }
    }

    C2982a m8943a(Uri uri, boolean z) throws IOException;
}
