package com.tinder.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.support.annotation.NonNull;
import com.tinder.R;
import com.tinder.managers.ManagerApp;

public class ImageFilters {
    @NonNull
    private static native Bitmap jniApplyBrightnessAndContrast(Bitmap bitmap, int i, int i2);

    @NonNull
    private static native Bitmap jniApplyGrayscale(Bitmap bitmap);

    static {
        System.loadLibrary("ImageFilters");
    }

    public static Bitmap m9194a(Bitmap bitmap) {
        Bitmap a = m9196a(bitmap, 40, 2);
        Bitmap a2 = m9195a(a, R.color.chill_color);
        if (!(a == bitmap || a == a2)) {
            a.recycle();
        }
        return a2;
    }

    public static Bitmap m9197b(Bitmap bitmap) {
        Bitmap a = m9196a(bitmap, 40, 30);
        Bitmap a2 = m9195a(a, R.color.glow_color);
        if (!(a == bitmap || a == a2)) {
            a.recycle();
        }
        return a2;
    }

    private static Bitmap m9195a(@NonNull Bitmap bitmap, int i) {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            paint.setColorFilter(new PorterDuffColorFilter(ManagerApp.m7917h().getResources().getColor(i), Mode.LIGHTEN));
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            return createBitmap;
        } catch (OutOfMemoryError e) {
            C3095y.m9471a(e.getMessage());
            return bitmap;
        }
    }

    private static synchronized Bitmap m9196a(Bitmap bitmap, int i, int i2) {
        synchronized (ImageFilters.class) {
            C3095y.m9469a();
            try {
                bitmap = jniApplyBrightnessAndContrast(bitmap, i, i2);
            } catch (OutOfMemoryError e) {
                C3095y.m9479c(e.getMessage());
            }
        }
        return bitmap;
    }

    public static Bitmap m9198c(Bitmap bitmap) {
        try {
            bitmap = jniApplyGrayscale(bitmap);
        } catch (OutOfMemoryError e) {
            C3095y.m9479c(e.getMessage());
        }
        return bitmap;
    }
}
