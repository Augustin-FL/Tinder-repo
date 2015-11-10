package com.tinder.picassowebp.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.net.Uri;
import java.io.IOException;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.tinder.picassowebp.picasso.k */
class C3016k extends C2984g {
    C3016k(Context context, Picasso picasso, C3014i c3014i, C3005d c3005d, C3033v c3033v, C2993a c2993a) {
        super(context, picasso, c3014i, c3005d, c3033v, c2993a);
    }

    static int m9077a(Uri uri) throws IOException {
        switch (new ExifInterface(uri.getPath()).getAttributeInt("Orientation", 1)) {
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                return 180;
            case C3374b.SmoothProgressBar_spb_progressiveStart_speed /*6*/:
                return 90;
            case C3374b.SmoothProgressBar_spb_interpolator /*8*/:
                return 270;
            default:
                return 0;
        }
    }

    Bitmap m9078a(C3026s c3026s) throws IOException {
        m8954a(C3016k.m9077a(c3026s.f6427a));
        return super.m8970a(c3026s);
    }
}
