package fr.castorflex.android.smoothprogressbar;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;

/* renamed from: fr.castorflex.android.smoothprogressbar.c */
public final class C3204c {
    public static Drawable m9627a(int[] iArr, float f) {
        if (iArr == null || iArr.length == 0) {
            return null;
        }
        return new ShapeDrawable(new C3195a(f, iArr));
    }
}
