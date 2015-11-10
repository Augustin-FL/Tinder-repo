package com.tinder.picassowebp.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import com.tinder.picassowebp.picasso.Picasso.LoadedFrom;
import java.io.IOException;

/* renamed from: com.tinder.picassowebp.picasso.g */
class C2984g extends C2983c {
    final Context f6311o;

    C2984g(Context context, Picasso picasso, C3014i c3014i, C3005d c3005d, C3033v c3033v, C2993a c2993a) {
        super(picasso, c3014i, c3005d, c3033v, c2993a);
        this.f6311o = context;
    }

    Bitmap m8970a(C3026s c3026s) throws IOException {
        return m8972d(c3026s);
    }

    LoadedFrom m8971a() {
        return LoadedFrom.DISK;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected android.graphics.Bitmap m8972d(com.tinder.picassowebp.picasso.C3026s r10) throws java.io.IOException {
        /*
        r9 = this;
        r0 = 0;
        r1 = "Tinder";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "uri=";
        r2 = r2.append(r3);
        r3 = r10.f6427a;
        r2 = r2.append(r3);
        r2 = r2.toString();
        android.util.Log.d(r1, r2);
        r1 = r9.f6311o;
        r3 = r1.getContentResolver();
        r4 = com.tinder.picassowebp.picasso.C2983c.m8951c(r10);
        r1 = r10.f6427a;
        r1 = r1.toString();
        r2 = "file:";
        r5 = r1.contains(r2);
        r1 = com.tinder.picassowebp.picasso.C2983c.m8949a(r4);
        if (r1 == 0) goto L_0x0054;
    L_0x0037:
        r1 = r10.f6427a;	 Catch:{ Exception -> 0x00a8, all -> 0x00b7 }
        r2 = r3.openInputStream(r1);	 Catch:{ Exception -> 0x00a8, all -> 0x00b7 }
        r1 = com.tinder.picassowebp.picasso.ab.m9034c(r2);	 Catch:{ Exception -> 0x0113 }
        if (r1 == 0) goto L_0x006b;
    L_0x0043:
        r1 = com.tinder.picassowebp.picasso.ab.m9032b(r2);	 Catch:{ Exception -> 0x0113 }
        android.backport.webp.WebPFactory.nativeDecodeByteArray(r1, r4);	 Catch:{ Exception -> 0x0113 }
    L_0x004a:
        com.tinder.picassowebp.picasso.ab.m9025a(r2);
    L_0x004d:
        r1 = r10.f6430d;
        r2 = r10.f6431e;
        com.tinder.picassowebp.picasso.C2983c.m8948a(r1, r2, r4);
    L_0x0054:
        r1 = r10.f6427a;
        r2 = r3.openInputStream(r1);
        r1 = com.tinder.picassowebp.picasso.ab.m9034c(r2);	 Catch:{ Exception -> 0x00fd }
        if (r1 == 0) goto L_0x00be;
    L_0x0060:
        r1 = com.tinder.picassowebp.picasso.ab.m9032b(r2);	 Catch:{ Exception -> 0x00fd }
        android.backport.webp.WebPFactory.nativeDecodeByteArray(r1, r4);	 Catch:{ Exception -> 0x00fd }
    L_0x0067:
        com.tinder.picassowebp.picasso.ab.m9025a(r2);
    L_0x006a:
        return r0;
    L_0x006b:
        if (r5 == 0) goto L_0x00a2;
    L_0x006d:
        r1 = r10.f6427a;	 Catch:{ Exception -> 0x0113 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0113 }
        r6 = "file:";
        r6 = r6.length();	 Catch:{ Exception -> 0x0113 }
        r1 = r1.substring(r6);	 Catch:{ Exception -> 0x0113 }
        r6 = "%20";
        r7 = " ";
        r1 = r1.replace(r6, r7);	 Catch:{ Exception -> 0x0113 }
        r6 = "Tinder";
        r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0113 }
        r7.<init>();	 Catch:{ Exception -> 0x0113 }
        r8 = "path=";
        r7 = r7.append(r8);	 Catch:{ Exception -> 0x0113 }
        r7 = r7.append(r1);	 Catch:{ Exception -> 0x0113 }
        r7 = r7.toString();	 Catch:{ Exception -> 0x0113 }
        android.util.Log.d(r6, r7);	 Catch:{ Exception -> 0x0113 }
        r0 = android.graphics.BitmapFactory.decodeFile(r1, r4);	 Catch:{ Exception -> 0x0113 }
        goto L_0x004a;
    L_0x00a2:
        r1 = 0;
        r0 = android.graphics.BitmapFactory.decodeStream(r2, r1, r4);	 Catch:{ Exception -> 0x0113 }
        goto L_0x004a;
    L_0x00a8:
        r1 = move-exception;
        r2 = r0;
    L_0x00aa:
        r6 = "Tinder";
        r1 = r1.getMessage();	 Catch:{ all -> 0x0111 }
        android.util.Log.e(r6, r1);	 Catch:{ all -> 0x0111 }
        com.tinder.picassowebp.picasso.ab.m9025a(r2);
        goto L_0x004d;
    L_0x00b7:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
    L_0x00ba:
        com.tinder.picassowebp.picasso.ab.m9025a(r2);
        throw r0;
    L_0x00be:
        if (r5 == 0) goto L_0x00f6;
    L_0x00c0:
        r1 = r10.f6427a;	 Catch:{ Exception -> 0x00fd }
        r1 = r1.toString();	 Catch:{ Exception -> 0x00fd }
        r3 = "file:";
        r3 = r3.length();	 Catch:{ Exception -> 0x00fd }
        r1 = r1.substring(r3);	 Catch:{ Exception -> 0x00fd }
        r3 = "%20";
        r5 = " ";
        r1 = r1.replace(r3, r5);	 Catch:{ Exception -> 0x00fd }
        r3 = "Tinder";
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00fd }
        r5.<init>();	 Catch:{ Exception -> 0x00fd }
        r6 = "path=";
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x00fd }
        r5 = r5.append(r1);	 Catch:{ Exception -> 0x00fd }
        r5 = r5.toString();	 Catch:{ Exception -> 0x00fd }
        android.util.Log.d(r3, r5);	 Catch:{ Exception -> 0x00fd }
        r0 = android.graphics.BitmapFactory.decodeFile(r1, r4);	 Catch:{ Exception -> 0x00fd }
        goto L_0x0067;
    L_0x00f6:
        r1 = 0;
        r0 = android.graphics.BitmapFactory.decodeStream(r2, r1, r4);	 Catch:{ Exception -> 0x00fd }
        goto L_0x0067;
    L_0x00fd:
        r1 = move-exception;
        r3 = "Tinder";
        r1 = r1.getMessage();	 Catch:{ all -> 0x010c }
        android.util.Log.e(r3, r1);	 Catch:{ all -> 0x010c }
        com.tinder.picassowebp.picasso.ab.m9025a(r2);
        goto L_0x006a;
    L_0x010c:
        r0 = move-exception;
        com.tinder.picassowebp.picasso.ab.m9025a(r2);
        throw r0;
    L_0x0111:
        r0 = move-exception;
        goto L_0x00ba;
    L_0x0113:
        r1 = move-exception;
        goto L_0x00aa;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tinder.picassowebp.picasso.g.d(com.tinder.picassowebp.picasso.s):android.graphics.Bitmap");
    }
}
