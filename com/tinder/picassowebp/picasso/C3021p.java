package com.tinder.picassowebp.picasso;

import android.content.Context;
import android.net.Uri;
import com.squareup.okhttp.C2082c;
import com.squareup.okhttp.C2217q;
import com.squareup.okhttp.C2219r;
import com.tinder.picassowebp.picasso.Downloader.C2982a;
import com.tinder.picassowebp.picasso.Downloader.ResponseException;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;

/* renamed from: com.tinder.picassowebp.picasso.p */
public class C3021p implements Downloader {
    private final C2219r f6405a;

    public C3021p(Context context) {
        this(ab.m9029b(context));
    }

    public C3021p(File file) {
        this(file, ab.m9016a(file));
    }

    public C3021p(File file, long j) {
        this(new C2217q());
        this.f6405a.m5786a().m5757a(new C2082c(file, j));
    }

    public C3021p(C2217q c2217q) {
        this.f6405a = new C2219r(c2217q);
    }

    protected HttpURLConnection m9096a(Uri uri) throws IOException {
        HttpURLConnection a = this.f6405a.m5787a(new URL(uri.toString()));
        a.setConnectTimeout(15000);
        a.setReadTimeout(20000);
        return a;
    }

    public C2982a m9095a(Uri uri, boolean z) throws IOException {
        HttpURLConnection a = m9096a(uri);
        a.setUseCaches(true);
        if (z) {
            a.setRequestProperty(HttpHeaders.CACHE_CONTROL, "only-if-cached,max-age=2147483647");
        }
        int responseCode = a.getResponseCode();
        if (responseCode >= HttpStatus.SC_MULTIPLE_CHOICES) {
            a.disconnect();
            throw new ResponseException(responseCode + " " + a.getResponseMessage());
        }
        String headerField = a.getHeaderField("OkHttp-Response-Source");
        if (headerField == null) {
            headerField = a.getHeaderField("X-Android-Response-Source");
        }
        long headerFieldInt = (long) a.getHeaderFieldInt(HTTP.CONTENT_LEN, -1);
        return new C2982a(a.getInputStream(), ab.m9028a(headerField), headerFieldInt);
    }
}
