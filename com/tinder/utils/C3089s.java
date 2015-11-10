package com.tinder.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.support.annotation.NonNull;
import com.android.volley.C0294c;
import com.android.volley.C0301g;
import com.android.volley.C0307i;
import com.android.volley.C0307i.C0305a;
import com.android.volley.C0307i.C0306b;
import com.android.volley.C0310l;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Request.Priority;
import com.android.volley.toolbox.C0324d;
import com.google.android.gms.location.LocationStatusCodes;

/* renamed from: com.tinder.utils.s */
public class C3089s extends Request<Bitmap> {
    private static final Object f6654a;
    private final C0306b<Bitmap> f6655b;
    private final Config f6656c;
    private final int f6657d;
    private final int f6658e;
    private boolean f6659f;

    protected /* synthetic */ void m9456b(Object obj) {
        m9455a((Bitmap) obj);
    }

    static {
        f6654a = new Object();
    }

    public C3089s(@NonNull String str, C0306b<Bitmap> c0306b, int i, int i2, Config config, C0305a c0305a) {
        super(0, str, c0305a);
        this.f6655b = c0306b;
        this.f6656c = config;
        this.f6657d = i;
        this.f6658e = i2;
        this.f6659f = C3075l.m9394c(str);
        m219a(new C0294c(LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, 2, 2.0f));
    }

    private static int m9452b(int i, int i2, int i3, int i4) {
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

    static int m9451a(int i, int i2, int i3, int i4) {
        float f = 1.0f;
        while (((double) (f * 2.0f)) <= Math.min(((double) i) / ((double) i3), ((double) i2) / ((double) i4))) {
            f *= 2.0f;
        }
        return (int) f;
    }

    @NonNull
    public Priority m9457s() {
        return Priority.LOW;
    }

    protected C0307i<Bitmap> m9454a(@NonNull C0301g c0301g) {
        C0307i<Bitmap> b;
        synchronized (f6654a) {
            try {
                b = m9453b(c0301g);
            } catch (Throwable e) {
                C0310l.m289c("Caught OOM for %d byte image, url=%s", Integer.valueOf(c0301g.f244b.length), m228d());
                b = C0307i.m280a(new ParseError(e));
            }
        }
        return b;
    }

    protected void m9455a(Bitmap bitmap) {
        this.f6655b.m279a(bitmap);
    }

    private C0307i<Bitmap> m9453b(@NonNull C0301g c0301g) {
        Object a;
        byte[] bArr = c0301g.f244b;
        Options options = new Options();
        if (this.f6657d == 0 && this.f6658e == 0) {
            options.inPreferredConfig = this.f6656c;
            a = C3075l.m9384a(bArr, options, this.f6659f);
        } else {
            options.inJustDecodeBounds = true;
            C3075l.m9384a(bArr, options, this.f6659f);
            int i = options.outWidth;
            int i2 = options.outHeight;
            int b = C3089s.m9452b(this.f6657d, this.f6658e, i, i2);
            int b2 = C3089s.m9452b(this.f6658e, this.f6657d, i2, i);
            options.inJustDecodeBounds = false;
            options.inSampleSize = C3089s.m9451a(i, i2, b, b2);
            Bitmap a2 = C3075l.m9384a(bArr, options, this.f6659f);
            if (a2 == null || (a2.getWidth() <= b && a2.getHeight() <= b2)) {
                Bitmap bitmap = a2;
            } else {
                a = Bitmap.createScaledBitmap(a2, b, b2, true);
                a2.recycle();
            }
        }
        if (a == null) {
            return C0307i.m280a(new ParseError());
        }
        return C0307i.m281a(a, C0324d.m328a(c0301g));
    }
}
