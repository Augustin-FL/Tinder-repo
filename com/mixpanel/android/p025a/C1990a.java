package com.mixpanel.android.p025a;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v4.view.ViewCompat;
import android.view.View;

/* renamed from: com.mixpanel.android.a.a */
public class C1990a {
    public static Bitmap m4585a(Activity activity, int i, int i2, boolean z) {
        View rootView = activity.findViewById(16908290).getRootView();
        boolean isDrawingCacheEnabled = rootView.isDrawingCacheEnabled();
        rootView.setDrawingCacheEnabled(true);
        rootView.buildDrawingCache(true);
        Bitmap drawingCache = rootView.getDrawingCache();
        Bitmap bitmap = null;
        if (drawingCache != null && drawingCache.getWidth() > 0 && drawingCache.getHeight() > 0) {
            if (z) {
                i = drawingCache.getWidth() / i;
                i2 = drawingCache.getHeight() / i2;
            }
            if (i > 0 && i2 > 0) {
                bitmap = Bitmap.createScaledBitmap(drawingCache, i, i2, false);
            }
        }
        if (!isDrawingCacheEnabled) {
            rootView.setDrawingCacheEnabled(false);
        }
        return bitmap;
    }

    public static int m4583a(Activity activity) {
        int i = ViewCompat.MEASURED_STATE_MASK;
        Bitmap a = C1990a.m4585a(activity, 1, 1, false);
        if (a != null) {
            i = a.getPixel(0, 0);
        }
        return C1990a.m4582a(i);
    }

    public static int m4584a(Bitmap bitmap) {
        int i = ViewCompat.MEASURED_STATE_MASK;
        if (bitmap != null) {
            i = Bitmap.createScaledBitmap(bitmap, 1, 1, false).getPixel(0, 0);
        }
        return C1990a.m4582a(i);
    }

    public static int m4582a(int i) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        fArr[2] = 0.3f;
        return Color.HSVToColor(242, fArr);
    }
}
