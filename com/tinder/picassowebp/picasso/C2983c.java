package com.tinder.picassowebp.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.net.NetworkInfo;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import com.facebook.internal.AnalyticsEvents;
import com.tinder.picassowebp.picasso.Picasso.LoadedFrom;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/* renamed from: com.tinder.picassowebp.picasso.c */
abstract class C2983c implements Runnable {
    private static final Object f6295o;
    private static final ThreadLocal<StringBuilder> f6296p;
    final Picasso f6297a;
    final C3014i f6298b;
    final C3005d f6299c;
    final C3033v f6300d;
    final String f6301e;
    final C3026s f6302f;
    final boolean f6303g;
    C2993a f6304h;
    List<C2993a> f6305i;
    Bitmap f6306j;
    Future<?> f6307k;
    LoadedFrom f6308l;
    Exception f6309m;
    int f6310n;

    /* renamed from: com.tinder.picassowebp.picasso.c.1 */
    static class C30011 extends ThreadLocal<StringBuilder> {
        C30011() {
        }

        protected /* synthetic */ Object initialValue() {
            return m9039a();
        }

        protected StringBuilder m9039a() {
            return new StringBuilder("Picasso-");
        }
    }

    /* renamed from: com.tinder.picassowebp.picasso.c.2 */
    static class C30022 implements Runnable {
        final /* synthetic */ StringBuilder f6363a;

        C30022(StringBuilder stringBuilder) {
            this.f6363a = stringBuilder;
        }

        public void run() {
            throw new NullPointerException(this.f6363a.toString());
        }
    }

    /* renamed from: com.tinder.picassowebp.picasso.c.3 */
    static class C30033 implements Runnable {
        final /* synthetic */ C3036z f6364a;

        C30033(C3036z c3036z) {
            this.f6364a = c3036z;
        }

        public void run() {
            throw new IllegalStateException("Transformation " + this.f6364a.key() + " returned input Bitmap but recycled it.");
        }
    }

    /* renamed from: com.tinder.picassowebp.picasso.c.4 */
    static class C30044 implements Runnable {
        final /* synthetic */ C3036z f6365a;

        C30044(C3036z c3036z) {
            this.f6365a = c3036z;
        }

        public void run() {
            throw new IllegalStateException("Transformation " + this.f6365a.key() + " mutated input Bitmap but failed to recycle the original.");
        }
    }

    abstract Bitmap m8952a(C3026s c3026s) throws IOException;

    static {
        f6295o = new Object();
        f6296p = new C30011();
    }

    C2983c(Picasso picasso, C3014i c3014i, C3005d c3005d, C3033v c3033v, C2993a c2993a) {
        this.f6297a = picasso;
        this.f6298b = c3014i;
        this.f6299c = c3005d;
        this.f6300d = c3033v;
        this.f6301e = c2993a.m9003e();
        this.f6302f = c2993a.m9001c();
        this.f6303g = c2993a.f6350d;
        this.f6304h = c2993a;
    }

    static void m8950b(C3026s c3026s) {
        String c = c3026s.m9111c();
        StringBuilder stringBuilder = (StringBuilder) f6296p.get();
        stringBuilder.ensureCapacity("Picasso-".length() + c.length());
        stringBuilder.replace("Picasso-".length(), stringBuilder.length(), c);
        Thread.currentThread().setName(stringBuilder.toString());
    }

    static C2983c m8946a(Context context, Picasso picasso, C3014i c3014i, C3005d c3005d, C3033v c3033v, C2993a c2993a, Downloader downloader) {
        if (c2993a.m9001c().f6428b != 0) {
            return new C3030u(context, picasso, c3014i, c3005d, c3033v, c2993a);
        }
        Uri uri = c2993a.m9001c().f6427a;
        String scheme = uri.getScheme();
        if ("content".equals(scheme)) {
            if (Contacts.CONTENT_URI.getHost().equals(uri.getHost()) && !uri.getPathSegments().contains(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO)) {
                return new C3008f(context, picasso, c3014i, c3005d, c3033v, c2993a);
            }
            if ("media".equals(uri.getAuthority())) {
                return new MediaStoreBitmapHunter(context, picasso, c3014i, c3005d, c3033v, c2993a);
            }
            return new C2984g(context, picasso, c3014i, c3005d, c3033v, c2993a);
        } else if ("file".equals(scheme)) {
            if (uri.getPathSegments().isEmpty() || !"android_asset".equals(uri.getPathSegments().get(0))) {
                return new C3016k(context, picasso, c3014i, c3005d, c3033v, c2993a);
            }
            return new C3000b(context, picasso, c3014i, c3005d, c3033v, c2993a);
        } else if ("android.resource".equals(scheme)) {
            return new C3030u(context, picasso, c3014i, c3005d, c3033v, c2993a);
        } else {
            return new C3020o(picasso, c3014i, c3005d, c3033v, c2993a, downloader);
        }
    }

    static Options m8951c(C3026s c3026s) {
        boolean d = c3026s.m9112d();
        Object obj = c3026s.f6438l != null ? 1 : null;
        Options options = null;
        if (d || obj != null) {
            options = new Options();
            options.inJustDecodeBounds = d;
            if (obj != null) {
                options.inPreferredConfig = c3026s.f6438l;
            }
        }
        return options;
    }

    static boolean m8949a(Options options) {
        return options != null && options.inJustDecodeBounds;
    }

    static void m8948a(int i, int i2, Options options) {
        C2983c.m8947a(i, i2, options.outWidth, options.outHeight, options);
    }

    static void m8947a(int i, int i2, int i3, int i4, Options options) {
        int i5 = 1;
        if (i4 > i2 || i3 > i) {
            i5 = Math.round(((float) i4) / ((float) i2));
            int round = Math.round(((float) i3) / ((float) i));
            if (i5 >= round) {
                i5 = round;
            }
        }
        options.inSampleSize = i5;
        options.inJustDecodeBounds = false;
    }

    static Bitmap m8945a(List<C3036z> list, Bitmap bitmap) {
        int size = list.size();
        int i = 0;
        Bitmap bitmap2 = bitmap;
        while (i < size) {
            C3036z c3036z = (C3036z) list.get(i);
            bitmap = c3036z.transform(bitmap2);
            if (bitmap == null) {
                StringBuilder append = new StringBuilder().append("Transformation ").append(c3036z.key()).append(" returned null after ").append(i).append(" previous transformation(s).\n\nTransformation list:\n");
                for (C3036z c3036z2 : list) {
                    append.append(c3036z2.key()).append('\n');
                }
                Picasso.f6331a.post(new C30022(append));
                return null;
            } else if (bitmap == bitmap2 && bitmap2.isRecycled()) {
                Picasso.f6331a.post(new C30033(c3036z2));
                return null;
            } else if (bitmap == bitmap2 || bitmap2.isRecycled()) {
                i++;
                bitmap2 = bitmap;
            } else {
                Picasso.f6331a.post(new C30044(c3036z2));
                return null;
            }
        }
        return bitmap2;
    }

    static Bitmap m8944a(C3026s c3026s, Bitmap bitmap, int i) {
        int i2;
        Bitmap createBitmap;
        int i3 = 0;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        if (c3026s.m9114f()) {
            int i4 = c3026s.f6430d;
            i2 = c3026s.f6431e;
            float f = c3026s.f6434h;
            if (f != 0.0f) {
                if (c3026s.f6437k) {
                    matrix.setRotate(f, c3026s.f6435i, c3026s.f6436j);
                } else {
                    matrix.setRotate(f);
                }
            }
            float f2;
            float f3;
            if (c3026s.f6432f) {
                int i5;
                f2 = ((float) i4) / ((float) width);
                f3 = ((float) i2) / ((float) height);
                if (f2 > f3) {
                    i2 = (int) Math.ceil((double) ((f3 / f2) * ((float) height)));
                    i5 = width;
                    width = (height - i2) / 2;
                    height = i5;
                } else {
                    i4 = (int) Math.ceil((double) ((f2 / f3) * ((float) width)));
                    float f4 = f3;
                    i2 = height;
                    height = i4;
                    f2 = f4;
                    i3 = (width - i4) / 2;
                    width = 0;
                }
                matrix.preScale(f2, f2);
                i5 = i2;
                i2 = i3;
                i3 = i5;
                int i6 = width;
                width = height;
                height = i6;
            } else if (c3026s.f6433g) {
                f2 = ((float) i4) / ((float) width);
                f3 = ((float) i2) / ((float) height);
                if (f2 >= f3) {
                    f2 = f3;
                }
                matrix.preScale(f2, f2);
                i2 = 0;
                i3 = height;
                height = 0;
            } else if (!(i4 == 0 || i2 == 0 || (i4 == width && i2 == height))) {
                matrix.preScale(((float) i4) / ((float) width), ((float) i2) / ((float) height));
            }
            if (i != 0) {
                matrix.preRotate((float) i);
            }
            createBitmap = Bitmap.createBitmap(bitmap, i2, height, width, i3, matrix, true);
            if (createBitmap != bitmap) {
                return bitmap;
            }
            bitmap.recycle();
            return createBitmap;
        }
        i2 = 0;
        i3 = height;
        height = 0;
        if (i != 0) {
            matrix.preRotate((float) i);
        }
        createBitmap = Bitmap.createBitmap(bitmap, i2, height, width, i3, matrix, true);
        if (createBitmap != bitmap) {
            return bitmap;
        }
        bitmap.recycle();
        return createBitmap;
    }

    protected void m8954a(int i) {
        this.f6310n = i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r4 = this;
        r0 = r4.f6302f;	 Catch:{ ResponseException -> 0x0035, IOException -> 0x0047, OutOfMemoryError -> 0x0059, Exception -> 0x0087 }
        com.tinder.picassowebp.picasso.C2983c.m8950b(r0);	 Catch:{ ResponseException -> 0x0035, IOException -> 0x0047, OutOfMemoryError -> 0x0059, Exception -> 0x0087 }
        r0 = r4.f6297a;	 Catch:{ ResponseException -> 0x0035, IOException -> 0x0047, OutOfMemoryError -> 0x0059, Exception -> 0x0087 }
        r0 = r0.f6341k;	 Catch:{ ResponseException -> 0x0035, IOException -> 0x0047, OutOfMemoryError -> 0x0059, Exception -> 0x0087 }
        if (r0 == 0) goto L_0x0016;
    L_0x000b:
        r0 = "Hunter";
        r1 = "executing";
        r2 = com.tinder.picassowebp.picasso.ab.m9020a(r4);	 Catch:{ ResponseException -> 0x0035, IOException -> 0x0047, OutOfMemoryError -> 0x0059, Exception -> 0x0087 }
        com.tinder.picassowebp.picasso.ab.m9026a(r0, r1, r2);	 Catch:{ ResponseException -> 0x0035, IOException -> 0x0047, OutOfMemoryError -> 0x0059, Exception -> 0x0087 }
    L_0x0016:
        r0 = r4.m8957b();	 Catch:{ ResponseException -> 0x0035, IOException -> 0x0047, OutOfMemoryError -> 0x0059, Exception -> 0x0087 }
        r4.f6306j = r0;	 Catch:{ ResponseException -> 0x0035, IOException -> 0x0047, OutOfMemoryError -> 0x0059, Exception -> 0x0087 }
        r0 = r4.f6306j;	 Catch:{ ResponseException -> 0x0035, IOException -> 0x0047, OutOfMemoryError -> 0x0059, Exception -> 0x0087 }
        if (r0 != 0) goto L_0x002f;
    L_0x0020:
        r0 = r4.f6298b;	 Catch:{ ResponseException -> 0x0035, IOException -> 0x0047, OutOfMemoryError -> 0x0059, Exception -> 0x0087 }
        r0.m9071c(r4);	 Catch:{ ResponseException -> 0x0035, IOException -> 0x0047, OutOfMemoryError -> 0x0059, Exception -> 0x0087 }
    L_0x0025:
        r0 = java.lang.Thread.currentThread();
        r1 = "Picasso-Idle";
        r0.setName(r1);
    L_0x002e:
        return;
    L_0x002f:
        r0 = r4.f6298b;	 Catch:{ ResponseException -> 0x0035, IOException -> 0x0047, OutOfMemoryError -> 0x0059, Exception -> 0x0087 }
        r0.m9063a(r4);	 Catch:{ ResponseException -> 0x0035, IOException -> 0x0047, OutOfMemoryError -> 0x0059, Exception -> 0x0087 }
        goto L_0x0025;
    L_0x0035:
        r0 = move-exception;
        r4.f6309m = r0;	 Catch:{ all -> 0x0099 }
        r0 = r4.f6298b;	 Catch:{ all -> 0x0099 }
        r0.m9071c(r4);	 Catch:{ all -> 0x0099 }
        r0 = java.lang.Thread.currentThread();
        r1 = "Picasso-Idle";
        r0.setName(r1);
        goto L_0x002e;
    L_0x0047:
        r0 = move-exception;
        r4.f6309m = r0;	 Catch:{ all -> 0x0099 }
        r0 = r4.f6298b;	 Catch:{ all -> 0x0099 }
        r0.m9068b(r4);	 Catch:{ all -> 0x0099 }
        r0 = java.lang.Thread.currentThread();
        r1 = "Picasso-Idle";
        r0.setName(r1);
        goto L_0x002e;
    L_0x0059:
        r0 = move-exception;
        r1 = new java.io.StringWriter;	 Catch:{ all -> 0x0099 }
        r1.<init>();	 Catch:{ all -> 0x0099 }
        r2 = r4.f6300d;	 Catch:{ all -> 0x0099 }
        r2 = r2.m9147e();	 Catch:{ all -> 0x0099 }
        r3 = new java.io.PrintWriter;	 Catch:{ all -> 0x0099 }
        r3.<init>(r1);	 Catch:{ all -> 0x0099 }
        r2.m9148a(r3);	 Catch:{ all -> 0x0099 }
        r2 = new java.lang.RuntimeException;	 Catch:{ all -> 0x0099 }
        r1 = r1.toString();	 Catch:{ all -> 0x0099 }
        r2.<init>(r1, r0);	 Catch:{ all -> 0x0099 }
        r4.f6309m = r2;	 Catch:{ all -> 0x0099 }
        r0 = r4.f6298b;	 Catch:{ all -> 0x0099 }
        r0.m9071c(r4);	 Catch:{ all -> 0x0099 }
        r0 = java.lang.Thread.currentThread();
        r1 = "Picasso-Idle";
        r0.setName(r1);
        goto L_0x002e;
    L_0x0087:
        r0 = move-exception;
        r4.f6309m = r0;	 Catch:{ all -> 0x0099 }
        r0 = r4.f6298b;	 Catch:{ all -> 0x0099 }
        r0.m9071c(r4);	 Catch:{ all -> 0x0099 }
        r0 = java.lang.Thread.currentThread();
        r1 = "Picasso-Idle";
        r0.setName(r1);
        goto L_0x002e;
    L_0x0099:
        r0 = move-exception;
        r1 = java.lang.Thread.currentThread();
        r2 = "Picasso-Idle";
        r1.setName(r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tinder.picassowebp.picasso.c.run():void");
    }

    Bitmap m8957b() throws IOException {
        Bitmap a;
        if (!this.f6303g) {
            a = this.f6299c.m9041a(this.f6301e);
            if (a != null) {
                this.f6300d.m9137a();
                this.f6308l = LoadedFrom.MEMORY;
                if (this.f6297a.f6341k) {
                    ab.m9027a("Hunter", "decoded", this.f6302f.m9109a(), "from cache");
                }
                return a;
            }
        }
        a = m8952a(this.f6302f);
        if (a != null) {
            if (this.f6297a.f6341k) {
                ab.m9026a("Hunter", "decoded", this.f6302f.m9109a());
            }
            this.f6300d.m9139a(a);
            if (this.f6302f.m9113e() || this.f6310n != 0) {
                synchronized (f6295o) {
                    if (this.f6302f.m9114f() || this.f6310n != 0) {
                        a = C2983c.m8944a(this.f6302f, a, this.f6310n);
                        if (this.f6297a.f6341k) {
                            ab.m9026a("Hunter", "transformed", this.f6302f.m9109a());
                        }
                    }
                    if (this.f6302f.m9115g()) {
                        a = C2983c.m8945a(this.f6302f.f6429c, a);
                        if (this.f6297a.f6341k) {
                            ab.m9027a("Hunter", "transformed", this.f6302f.m9109a(), "from custom transformations");
                        }
                    }
                }
                if (a != null) {
                    this.f6300d.m9143b(a);
                }
            }
        }
        return a;
    }

    void m8955a(C2993a c2993a) {
        boolean z = this.f6297a.f6341k;
        C3026s c3026s = c2993a.f6348b;
        if (this.f6304h == null) {
            this.f6304h = c2993a;
            if (!z) {
                return;
            }
            if (this.f6305i == null || this.f6305i.isEmpty()) {
                ab.m9027a("Hunter", "joined", c3026s.m9109a(), "to empty hunter");
                return;
            } else {
                ab.m9027a("Hunter", "joined", c3026s.m9109a(), ab.m9021a(this, "to "));
                return;
            }
        }
        if (this.f6305i == null) {
            this.f6305i = new ArrayList(3);
        }
        this.f6305i.add(c2993a);
        if (z) {
            ab.m9027a("Hunter", "joined", c3026s.m9109a(), ab.m9021a(this, "to "));
        }
    }

    void m8958b(C2993a c2993a) {
        if (this.f6304h == c2993a) {
            this.f6304h = null;
        } else if (this.f6305i != null) {
            this.f6305i.remove(c2993a);
        }
        if (this.f6297a.f6341k) {
            ab.m9027a("Hunter", "removed", c2993a.f6348b.m9109a(), ab.m9021a(this, "from "));
        }
    }

    boolean m8959c() {
        if (this.f6304h != null) {
            return false;
        }
        if ((this.f6305i == null || this.f6305i.isEmpty()) && this.f6307k != null && this.f6307k.cancel(false)) {
            return true;
        }
        return false;
    }

    boolean m8960d() {
        return this.f6307k != null && this.f6307k.isCancelled();
    }

    boolean m8961e() {
        return this.f6303g;
    }

    boolean m8956a(boolean z, NetworkInfo networkInfo) {
        return false;
    }

    boolean m8962f() {
        return false;
    }

    Bitmap m8963g() {
        return this.f6306j;
    }

    String m8964h() {
        return this.f6301e;
    }

    C3026s m8965i() {
        return this.f6302f;
    }

    C2993a m8966j() {
        return this.f6304h;
    }

    Picasso m8967k() {
        return this.f6297a;
    }

    List<C2993a> m8968l() {
        return this.f6305i;
    }

    Exception m8969m() {
        return this.f6309m;
    }

    LoadedFrom m8953a() {
        return this.f6308l;
    }
}
