package com.tinder.p029a;

import android.backport.webp.WebPFactory;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tinder.utils.C3095y;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.protocol.HTTP;

/* renamed from: com.tinder.a.f */
public class C2240f extends AsyncTask<String, String, String> {
    private Bitmap f3710a;
    private String f3711b;
    private String f3712c;
    private boolean f3713d;

    @Nullable
    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m5904a((String[]) objArr);
    }

    public C2240f(Bitmap bitmap, String str, String str2, boolean z) {
        C3095y.m9471a("url=" + str + ", authToken=" + str2);
        this.f3710a = bitmap;
        this.f3711b = str;
        this.f3712c = str2;
        this.f3713d = z;
    }

    @Nullable
    protected String m5904a(String... strArr) {
        Exception exception;
        Throwable th;
        C3095y.m9469a();
        String str = "--";
        AndroidHttpClient newInstance = AndroidHttpClient.newInstance(C2239e.f3684a);
        ByteArrayOutputStream byteArrayOutputStream = null;
        ByteArrayOutputStream byteArrayOutputStream2;
        try {
            byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                byte[] nativeEncodeBitmap;
                String str2;
                if (this.f3713d) {
                    nativeEncodeBitmap = WebPFactory.nativeEncodeBitmap(this.f3710a, 65);
                    str2 = "moment.webp";
                } else {
                    this.f3710a.compress(CompressFormat.JPEG, 90, byteArrayOutputStream2);
                    str2 = "moment.jpg";
                    nativeEncodeBitmap = byteArrayOutputStream2.toByteArray();
                }
                HttpUriRequest httpPost = new HttpPost(this.f3711b);
                httpPost.setHeader("X-Auth-Token", this.f3712c);
                httpPost.setHeader(HTTP.CONTENT_TYPE, "multipart/form-data; boundary=--");
                MultipartEntityBuilder create = MultipartEntityBuilder.create();
                create.setBoundary("--");
                create.addBinaryBody("image", nativeEncodeBitmap, ContentType.DEFAULT_BINARY, str2);
                httpPost.setEntity(create.build());
                HttpResponse execute = newInstance.execute(httpPost);
                C3095y.m9471a("response=" + execute.toString() + ' ' + execute.getStatusLine().getReasonPhrase() + ' ' + execute.getStatusLine().toString());
                StatusLine statusLine = execute.getStatusLine();
                int statusCode = statusLine.getStatusCode();
                C3095y.m9471a("status code=" + statusCode);
                if (statusCode == HttpStatus.SC_OK) {
                    OutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                    execute.getEntity().writeTo(byteArrayOutputStream3);
                    str = byteArrayOutputStream3.toString();
                    if (str == null || TextUtils.isEmpty(str)) {
                        str = String.valueOf(statusCode);
                    }
                } else if (statusCode == HttpStatus.SC_NOT_FOUND || statusCode == HttpStatus.SC_BAD_GATEWAY) {
                    str = String.valueOf(statusCode);
                } else {
                    execute.getEntity().getContent().close();
                    throw new IOException(statusLine.getReasonPhrase());
                }
                newInstance.close();
                try {
                    byteArrayOutputStream2.close();
                } catch (IOException e) {
                    C3095y.m9479c(e.toString());
                }
            } catch (Exception e2) {
                byteArrayOutputStream = byteArrayOutputStream2;
                exception = e2;
                try {
                    str = exception.getMessage();
                    C3095y.m9472a(exception.getClass().getName(), exception.getMessage());
                    if (str.contains("Unable to resolve host")) {
                        str = String.valueOf(HttpStatus.SC_NOT_FOUND);
                    }
                    newInstance.close();
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e3) {
                        C3095y.m9479c(e3.toString());
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    newInstance.close();
                    try {
                        byteArrayOutputStream2.close();
                    } catch (IOException e32) {
                        C3095y.m9479c(e32.toString());
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                newInstance.close();
                byteArrayOutputStream2.close();
                throw th;
            }
        } catch (Exception e22) {
            exception = e22;
            str = exception.getMessage();
            C3095y.m9472a(exception.getClass().getName(), exception.getMessage());
            if (str.contains("Unable to resolve host")) {
                str = String.valueOf(HttpStatus.SC_NOT_FOUND);
            }
            newInstance.close();
            byteArrayOutputStream.close();
            return str;
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream2 = null;
            newInstance.close();
            byteArrayOutputStream2.close();
            throw th;
        }
        return str;
    }
}
