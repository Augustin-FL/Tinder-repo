package com.android.volley.toolbox;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.android.volley.C0294c;
import com.android.volley.C0301g;
import com.android.volley.C0307i;
import com.android.volley.C0307i.C0305a;
import com.android.volley.C0307i.C0306b;
import com.android.volley.C0310l;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Request.Priority;
import com.google.android.gms.location.LocationStatusCodes;

/* renamed from: com.android.volley.toolbox.h */
public class C0334h extends Request<Bitmap> {
    private static final Object f327e;
    private final C0306b<Bitmap> f328a;
    private final Config f329b;
    private final int f330c;
    private final int f331d;

    protected /* synthetic */ void m368b(Object obj) {
        m367a((Bitmap) obj);
    }

    static {
        f327e = new Object();
    }

    public C0334h(String str, C0306b<Bitmap> c0306b, int i, int i2, Config config, C0305a c0305a) {
        super(0, str, c0305a);
        m219a(new C0294c(LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, 2, 2.0f));
        this.f328a = c0306b;
        this.f329b = config;
        this.f330c = i;
        this.f331d = i2;
    }

    public Priority m369s() {
        return Priority.LOW;
    }

    private static int m364b(int i, int i2, int i3, int i4) {
        if (i == 0 && i2 == 0) {
            return i3;
        }
        if (i == 0) {
            return (int) ((((double) i2) / ((double) i4)) * ((double) i3));
        }
        if (i2 == 0) {
            return i;
        }
        double d = ((double) i4) / ((double) i3);
        if (((double) i) * d > ((double) i2)) {
            return (int) (((double) i2) / d);
        }
        return i;
    }

    protected C0307i<Bitmap> m366a(C0301g c0301g) {
        C0307i<Bitmap> b;
        synchronized (f327e) {
            try {
                b = m365b(c0301g);
            } catch (Throwable e) {
                C0310l.m289c("Caught OOM for %d byte image, url=%s", Integer.valueOf(c0301g.f244b.length), m228d());
                b = C0307i.m280a(new ParseError(e));
            }
        }
        return b;
    }

    private C0307i<Bitmap> m365b(C0301g c0301g) {
        Object decodeByteArray;
        byte[] bArr = c0301g.f244b;
        Options options = new Options();
        if (this.f330c == 0 && this.f331d == 0) {
            options.inPreferredConfig = this.f329b;
            decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            int b = C0334h.m364b(this.f330c, this.f331d, i, i2);
            int b2 = C0334h.m364b(this.f331d, this.f330c, i2, i);
            options.inJustDecodeBounds = false;
            options.inSampleSize = C0334h.m363a(i, i2, b, b2);
            Bitmap decodeByteArray2 = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (decodeByteArray2 == null || (decodeByteArray2.getWidth() <= b && decodeByteArray2.getHeight() <= b2)) {
                Bitmap bitmap = decodeByteArray2;
            } else {
                decodeByteArray = Bitmap.createScaledBitmap(decodeByteArray2, b, b2, true);
                decodeByteArray2.recycle();
            }
        }
        if (decodeByteArray == null) {
            return C0307i.m280a(new ParseError());
        }
        return C0307i.m281a(decodeByteArray, C0324d.m328a(c0301g));
    }

    protected void m367a(Bitmap bitmap) {
        this.f328a.m279a(bitmap);
    }

    static int m363a(int i, int i2, int i3, int i4) {
        float f = 1.0f;
        while (((double) (f * 2.0f)) <= Math.min(((double) i) / ((double) i3), ((double) i2) / ((double) i4))) {
            f *= 2.0f;
        }
        return (int) f;
    }
}
