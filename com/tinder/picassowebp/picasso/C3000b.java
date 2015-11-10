package com.tinder.picassowebp.picasso;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tinder.picassowebp.picasso.Picasso.LoadedFrom;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.tinder.picassowebp.picasso.b */
class C3000b extends C2983c {
    private static final int f6361o;
    private final AssetManager f6362p;

    static {
        f6361o = "file:///android_asset/".length();
    }

    public C3000b(Context context, Picasso picasso, C3014i c3014i, C3005d c3005d, C3033v c3033v, C2993a c2993a) {
        super(picasso, c3014i, c3005d, c3033v, c2993a);
        this.f6362p = context.getAssets();
    }

    Bitmap m9036a(C3026s c3026s) throws IOException {
        return m9037a(c3026s.f6427a.toString().substring(f6361o));
    }

    LoadedFrom m9038a() {
        return LoadedFrom.DISK;
    }

    Bitmap m9037a(String str) throws IOException {
        InputStream inputStream = null;
        Options c = C2983c.m8951c(this.f);
        if (C2983c.m8949a(c)) {
            try {
                inputStream = this.f6362p.open(str);
                BitmapFactory.decodeStream(inputStream, null, c);
                C2983c.m8948a(this.f.f6430d, this.f.f6431e, c);
            } finally {
                ab.m9025a(inputStream);
            }
        }
        inputStream = this.f6362p.open(str);
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, c);
            return decodeStream;
        } finally {
            ab.m9025a(inputStream);
        }
    }
}
