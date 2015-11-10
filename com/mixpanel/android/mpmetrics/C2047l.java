package com.mixpanel.android.mpmetrics;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.facebook.internal.Utility;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.mixpanel.android.mpmetrics.l */
class C2047l {
    C2047l() {
    }

    public boolean m4814a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            boolean z = activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
            if (!C2031g.f2854a) {
                return z;
            }
            Log.d("MixpanelAPI", "ConnectivityManager says we " + (z ? "are" : "are not") + " online");
            return z;
        } catch (SecurityException e) {
            if (C2031g.f2854a) {
                Log.d("MixpanelAPI", "Don't have permission to check connectivity, assuming online");
            }
            return true;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] m4815a(android.content.Context r9, java.lang.String[] r10) {
        /*
        r8 = this;
        r0 = 0;
        r1 = r8.m4814a(r9);
        if (r1 != 0) goto L_0x0008;
    L_0x0007:
        return r0;
    L_0x0008:
        r2 = r10.length;
        r1 = 0;
    L_0x000a:
        if (r1 >= r2) goto L_0x0007;
    L_0x000c:
        r3 = r10[r1];
        r4 = 0;
        r0 = r8.m4816a(r3, r4);	 Catch:{ MalformedURLException -> 0x0014, IOException -> 0x0036, OutOfMemoryError -> 0x005a }
        goto L_0x0007;
    L_0x0014:
        r4 = move-exception;
        r5 = "MixpanelAPI";
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "Cannot interpret ";
        r6 = r6.append(r7);
        r3 = r6.append(r3);
        r6 = " as a URL.";
        r3 = r3.append(r6);
        r3 = r3.toString();
        android.util.Log.e(r5, r3, r4);
    L_0x0033:
        r1 = r1 + 1;
        goto L_0x000a;
    L_0x0036:
        r4 = move-exception;
        r5 = com.mixpanel.android.mpmetrics.C2031g.f2854a;
        if (r5 == 0) goto L_0x0033;
    L_0x003b:
        r5 = "MixpanelAPI";
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "Cannot get ";
        r6 = r6.append(r7);
        r3 = r6.append(r3);
        r6 = ".";
        r3 = r3.append(r6);
        r3 = r3.toString();
        android.util.Log.d(r5, r3, r4);
        goto L_0x0033;
    L_0x005a:
        r1 = move-exception;
        r2 = "MixpanelAPI";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "Out of memory when getting to ";
        r4 = r4.append(r5);
        r3 = r4.append(r3);
        r4 = ".";
        r3 = r3.append(r4);
        r3 = r3.toString();
        android.util.Log.e(r2, r3, r1);
        goto L_0x0007;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.l.a(android.content.Context, java.lang.String[]):byte[]");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] m4816a(java.lang.String r13, java.util.List<org.apache.http.NameValuePair> r14) throws java.io.IOException {
        /*
        r12 = this;
        r1 = 1;
        r2 = 0;
        r6 = 0;
        r0 = com.mixpanel.android.mpmetrics.C2031g.f2854a;
        if (r0 == 0) goto L_0x001f;
    L_0x0007:
        r0 = "MixpanelAPI";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Attempting request to ";
        r3 = r3.append(r4);
        r3 = r3.append(r13);
        r3 = r3.toString();
        android.util.Log.d(r0, r3);
    L_0x001f:
        r3 = r2;
        r7 = r6;
    L_0x0021:
        r0 = 3;
        if (r3 >= r0) goto L_0x00e6;
    L_0x0024:
        if (r2 != 0) goto L_0x00e6;
    L_0x0026:
        r0 = new java.net.URL;	 Catch:{ EOFException -> 0x0090, all -> 0x00e7 }
        r0.<init>(r13);	 Catch:{ EOFException -> 0x0090, all -> 0x00e7 }
        r0 = r0.openConnection();	 Catch:{ EOFException -> 0x0090, all -> 0x00e7 }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ EOFException -> 0x0090, all -> 0x00e7 }
        r4 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        r0.setConnectTimeout(r4);	 Catch:{ EOFException -> 0x0106, all -> 0x00ec }
        r4 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r0.setReadTimeout(r4);	 Catch:{ EOFException -> 0x0106, all -> 0x00ec }
        if (r14 == 0) goto L_0x012c;
    L_0x003d:
        r4 = 1;
        r0.setDoOutput(r4);	 Catch:{ EOFException -> 0x0106, all -> 0x00ec }
        r8 = new org.apache.http.client.entity.UrlEncodedFormEntity;	 Catch:{ EOFException -> 0x0106, all -> 0x00ec }
        r4 = "UTF-8";
        r8.<init>(r14, r4);	 Catch:{ EOFException -> 0x0106, all -> 0x00ec }
        r4 = "POST";
        r0.setRequestMethod(r4);	 Catch:{ EOFException -> 0x0106, all -> 0x00ec }
        r4 = r8.getContentLength();	 Catch:{ EOFException -> 0x0106, all -> 0x00ec }
        r4 = (int) r4;	 Catch:{ EOFException -> 0x0106, all -> 0x00ec }
        r0.setFixedLengthStreamingMode(r4);	 Catch:{ EOFException -> 0x0106, all -> 0x00ec }
        r5 = r0.getOutputStream();	 Catch:{ EOFException -> 0x0106, all -> 0x00ec }
        r4 = new java.io.BufferedOutputStream;	 Catch:{ EOFException -> 0x010d, all -> 0x00f3 }
        r4.<init>(r5);	 Catch:{ EOFException -> 0x010d, all -> 0x00f3 }
        r8.writeTo(r4);	 Catch:{ EOFException -> 0x0114, all -> 0x00f9 }
        r4.close();	 Catch:{ EOFException -> 0x0114, all -> 0x00f9 }
        r5.close();	 Catch:{ EOFException -> 0x010d, all -> 0x00f3 }
        r8 = r6;
        r9 = r6;
    L_0x0069:
        r5 = r0.getInputStream();	 Catch:{ EOFException -> 0x0106, all -> 0x00ec }
        r4 = r12.m4813a(r5);	 Catch:{ EOFException -> 0x011d, all -> 0x00ff }
        r5.close();	 Catch:{ EOFException -> 0x0125, all -> 0x00ff }
        r2 = 0;
        if (r6 == 0) goto L_0x007a;
    L_0x0077:
        r8.close();	 Catch:{ IOException -> 0x00d4 }
    L_0x007a:
        if (r6 == 0) goto L_0x007f;
    L_0x007c:
        r9.close();	 Catch:{ IOException -> 0x00d6 }
    L_0x007f:
        if (r6 == 0) goto L_0x0084;
    L_0x0081:
        r2.close();	 Catch:{ IOException -> 0x00d8 }
    L_0x0084:
        if (r0 == 0) goto L_0x0136;
    L_0x0086:
        r0.disconnect();
        r0 = r1;
        r2 = r3;
        r3 = r4;
    L_0x008c:
        r7 = r3;
        r3 = r2;
        r2 = r0;
        goto L_0x0021;
    L_0x0090:
        r0 = move-exception;
        r5 = r6;
        r8 = r6;
        r9 = r6;
        r4 = r7;
        r7 = r6;
    L_0x0096:
        r0 = com.mixpanel.android.mpmetrics.C2031g.f2854a;	 Catch:{ all -> 0x00bc }
        if (r0 == 0) goto L_0x00a1;
    L_0x009a:
        r0 = "MixpanelAPI";
        r10 = "Failure to connect, likely caused by a known issue with Android lib. Retrying.";
        android.util.Log.d(r0, r10);	 Catch:{ all -> 0x00bc }
    L_0x00a1:
        r0 = r3 + 1;
        if (r7 == 0) goto L_0x00a8;
    L_0x00a5:
        r7.close();	 Catch:{ IOException -> 0x00da }
    L_0x00a8:
        if (r8 == 0) goto L_0x00ad;
    L_0x00aa:
        r8.close();	 Catch:{ IOException -> 0x00dc }
    L_0x00ad:
        if (r9 == 0) goto L_0x00b2;
    L_0x00af:
        r9.close();	 Catch:{ IOException -> 0x00de }
    L_0x00b2:
        if (r5 == 0) goto L_0x0130;
    L_0x00b4:
        r5.disconnect();
        r3 = r4;
        r11 = r0;
        r0 = r2;
        r2 = r11;
        goto L_0x008c;
    L_0x00bc:
        r0 = move-exception;
        r6 = r5;
        r5 = r8;
    L_0x00bf:
        if (r7 == 0) goto L_0x00c4;
    L_0x00c1:
        r7.close();	 Catch:{ IOException -> 0x00e0 }
    L_0x00c4:
        if (r5 == 0) goto L_0x00c9;
    L_0x00c6:
        r5.close();	 Catch:{ IOException -> 0x00e2 }
    L_0x00c9:
        if (r9 == 0) goto L_0x00ce;
    L_0x00cb:
        r9.close();	 Catch:{ IOException -> 0x00e4 }
    L_0x00ce:
        if (r6 == 0) goto L_0x00d3;
    L_0x00d0:
        r6.disconnect();
    L_0x00d3:
        throw r0;
    L_0x00d4:
        r5 = move-exception;
        goto L_0x007a;
    L_0x00d6:
        r5 = move-exception;
        goto L_0x007f;
    L_0x00d8:
        r2 = move-exception;
        goto L_0x0084;
    L_0x00da:
        r3 = move-exception;
        goto L_0x00a8;
    L_0x00dc:
        r3 = move-exception;
        goto L_0x00ad;
    L_0x00de:
        r3 = move-exception;
        goto L_0x00b2;
    L_0x00e0:
        r1 = move-exception;
        goto L_0x00c4;
    L_0x00e2:
        r1 = move-exception;
        goto L_0x00c9;
    L_0x00e4:
        r1 = move-exception;
        goto L_0x00ce;
    L_0x00e6:
        return r7;
    L_0x00e7:
        r0 = move-exception;
        r7 = r6;
        r5 = r6;
        r9 = r6;
        goto L_0x00bf;
    L_0x00ec:
        r1 = move-exception;
        r7 = r6;
        r5 = r6;
        r9 = r6;
        r6 = r0;
        r0 = r1;
        goto L_0x00bf;
    L_0x00f3:
        r1 = move-exception;
        r7 = r6;
        r9 = r6;
        r6 = r0;
        r0 = r1;
        goto L_0x00bf;
    L_0x00f9:
        r1 = move-exception;
        r7 = r4;
        r9 = r6;
        r6 = r0;
        r0 = r1;
        goto L_0x00bf;
    L_0x00ff:
        r1 = move-exception;
        r7 = r6;
        r9 = r5;
        r5 = r6;
        r6 = r0;
        r0 = r1;
        goto L_0x00bf;
    L_0x0106:
        r4 = move-exception;
        r5 = r0;
        r8 = r6;
        r9 = r6;
        r4 = r7;
        r7 = r6;
        goto L_0x0096;
    L_0x010d:
        r4 = move-exception;
        r8 = r5;
        r9 = r6;
        r4 = r7;
        r7 = r6;
        r5 = r0;
        goto L_0x0096;
    L_0x0114:
        r8 = move-exception;
        r8 = r5;
        r9 = r6;
        r5 = r0;
        r11 = r4;
        r4 = r7;
        r7 = r11;
        goto L_0x0096;
    L_0x011d:
        r4 = move-exception;
        r8 = r6;
        r9 = r5;
        r4 = r7;
        r7 = r6;
        r5 = r0;
        goto L_0x0096;
    L_0x0125:
        r7 = move-exception;
        r7 = r6;
        r8 = r6;
        r9 = r5;
        r5 = r0;
        goto L_0x0096;
    L_0x012c:
        r8 = r6;
        r9 = r6;
        goto L_0x0069;
    L_0x0130:
        r3 = r4;
        r11 = r0;
        r0 = r2;
        r2 = r11;
        goto L_0x008c;
    L_0x0136:
        r0 = r1;
        r2 = r3;
        r3 = r4;
        goto L_0x008c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.l.a(java.lang.String, java.util.List):byte[]");
    }

    private byte[] m4813a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
        while (true) {
            int read = inputStream.read(bArr, 0, bArr.length);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}
