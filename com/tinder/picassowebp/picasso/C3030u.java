package com.tinder.picassowebp.picasso;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tinder.picassowebp.picasso.Picasso.LoadedFrom;
import java.io.IOException;

/* renamed from: com.tinder.picassowebp.picasso.u */
class C3030u extends C2983c {
    private final Context f6454o;

    C3030u(Context context, Picasso picasso, C3014i c3014i, C3005d c3005d, C3033v c3033v, C2993a c2993a) {
        super(picasso, c3014i, c3005d, c3033v, c2993a);
        this.f6454o = context;
    }

    Bitmap m9133a(C3026s c3026s) throws IOException {
        Resources a = ab.m9017a(this.f6454o, c3026s);
        return m9132a(a, ab.m9014a(a, c3026s), c3026s);
    }

    LoadedFrom m9134a() {
        return LoadedFrom.DISK;
    }

    private Bitmap m9132a(Resources resources, int i, C3026s c3026s) {
        Options c = C2983c.m8951c(c3026s);
        if (C2983c.m8949a(c)) {
            BitmapFactory.decodeResource(resources, i, c);
            C2983c.m8948a(c3026s.f6430d, c3026s.f6431e, c);
        }
        return BitmapFactory.decodeResource(resources, i, c);
    }
}
