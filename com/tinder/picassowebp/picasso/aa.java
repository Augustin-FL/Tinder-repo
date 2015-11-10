package com.tinder.picassowebp.picasso;

import android.content.Context;
import android.net.Uri;
import android.net.http.HttpResponseCache;
import android.os.Build.VERSION;
import com.tinder.picassowebp.picasso.Downloader.C2982a;
import com.tinder.picassowebp.picasso.Downloader.ResponseException;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;

public class aa implements Downloader {
    static volatile Object f6357a;
    private static final Object f6358b;
    private final Context f6359c;

    /* renamed from: com.tinder.picassowebp.picasso.aa.a */
    private static class C2994a {
        static Object m9007a(Context context) throws IOException {
            File b = ab.m9029b(context);
            Object installed = HttpResponseCache.getInstalled();
            if (installed == null) {
                return HttpResponseCache.install(b, ab.m9016a(b));
            }
            return installed;
        }
    }

    static {
        f6358b = new Object();
    }

    public aa(Context context) {
        this.f6359c = context.getApplicationContext();
    }

    private static void m9008a(Context context) {
        if (f6357a == null) {
            try {
                synchronized (f6358b) {
                    if (f6357a == null) {
                        f6357a = C2994a.m9007a(context);
                    }
                }
            } catch (IOException e) {
            }
        }
    }

    protected HttpURLConnection m9010a(Uri uri) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(uri.toString()).openConnection();
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(20000);
        return httpURLConnection;
    }

    public C2982a m9009a(Uri uri, boolean z) throws IOException {
        if (VERSION.SDK_INT >= 14) {
            m9008a(this.f6359c);
        }
        HttpURLConnection a = m9010a(uri);
        a.setUseCaches(true);
        if (z) {
            a.setRequestProperty(HttpHeaders.CACHE_CONTROL, "only-if-cached,max-age=2147483647");
        }
        int responseCode = a.getResponseCode();
        if (responseCode >= HttpStatus.SC_MULTIPLE_CHOICES) {
            a.disconnect();
            throw new ResponseException(responseCode + " " + a.getResponseMessage());
        }
        long headerFieldInt = (long) a.getHeaderFieldInt(HTTP.CONTENT_LEN, -1);
        return new C2982a(a.getInputStream(), ab.m9028a(a.getHeaderField("X-Android-Response-Source")), headerFieldInt);
    }
}
