package android.backport.webp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;

public final class WebPFactory {
    public static native Bitmap nativeDecodeByteArray(byte[] bArr, Options options);

    public static native byte[] nativeEncodeBitmap(Bitmap bitmap, int i);

    static {
        System.loadLibrary("webpbackport");
    }
}
