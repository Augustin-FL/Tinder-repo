package com.tinder.utils;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.io.InputStream;
import java.net.URL;
import org.apache.http.HttpHost;

/* renamed from: com.tinder.utils.f */
public class C3066f {
    public static Bitmap m9347a(Drawable drawable, int i, int i2) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, i, i2);
        drawable.draw(canvas);
        return createBitmap;
    }

    @Nullable
    public static Bitmap m9349a(@NonNull String str, Options options) {
        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeStream(new URL(str.substring(str.indexOf(HttpHost.DEFAULT_SCHEME_NAME))).openConnection().getInputStream(), new Rect(), options);
        } catch (Exception e) {
            C3095y.m9471a(e.getMessage());
        }
        return bitmap;
    }

    @Nullable
    public static Bitmap m9345a(@NonNull Context context, Uri uri, Options options) {
        Cursor query = context.getContentResolver().query(uri, new String[]{"_data", "_display_name"}, null, null, null);
        Uri parse = Uri.parse(C3066f.m9350a(uri.toString()));
        if (query != null) {
            query.moveToFirst();
            int columnIndex = query.getColumnIndex("_data");
            if (!parse.toString().startsWith("content://com.google.android.gallery3d")) {
                String string = query.getString(columnIndex);
                query.close();
                return BitmapFactory.decodeFile(string, options);
            } else if (query.getColumnIndex("_display_name") == -1) {
                return null;
            } else {
                C3095y.m9471a("uri.getPath " + parse.getPath());
                C3095y.m9471a("uri.toString() " + parse.toString());
                try {
                    InputStream openInputStream;
                    if (parse.toString().startsWith("content://com.google.android.gallery3d")) {
                        openInputStream = context.getContentResolver().openInputStream(parse);
                    } else {
                        openInputStream = new URL(parse.toString()).openStream();
                    }
                    return BitmapFactory.decodeStream(openInputStream, new Rect(), options);
                } catch (Exception e) {
                    C3095y.m9471a("Exception: " + e.getMessage());
                    return null;
                }
            }
        } else if (parse == null || parse.toString().length() <= 0) {
            return null;
        } else {
            return C3066f.m9349a(parse.getPath(), options);
        }
    }

    public static Bitmap m9348a(String str, int i, int i2) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = C3066f.m9344a(options, i, i2);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    @Nullable
    public static Bitmap m9352b(@NonNull String str, int i, int i2) {
        Bitmap bitmap = null;
        Options options = new Options();
        options.inJustDecodeBounds = true;
        try {
            URL url = new URL(str.substring(str.indexOf(HttpHost.DEFAULT_SCHEME_NAME)));
            BitmapFactory.decodeStream(url.openConnection().getInputStream(), new Rect(), options);
            options.inSampleSize = C3066f.m9344a(options, i, i2);
            options.inJustDecodeBounds = false;
            bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream(), new Rect(), options);
        } catch (Exception e) {
            C3095y.m9471a(e.getMessage());
        }
        return bitmap;
    }

    public static int m9344a(@NonNull Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            i3 /= 2;
            i4 /= 2;
            while (i3 / i5 > i2 && i4 / i5 > i) {
                i5 *= 2;
            }
        }
        return i5;
    }

    @Nullable
    public static Bitmap m9346a(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
        int[] iArr = new int[(width * height)];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        bitmap.recycle();
        return createBitmap;
    }

    @NonNull
    public static String m9350a(@NonNull String str) {
        return (TextUtils.isEmpty(str) || !str.startsWith("content://com.android.gallery3d.provider")) ? str : str.replace("content://com.android.gallery3d", "content://com.google.android.gallery3d");
    }

    public static boolean m9351a(@NonNull Bitmap... bitmapArr) {
        boolean z = true;
        for (Bitmap bitmap : bitmapArr) {
            if (!z || bitmap == null || bitmap.isRecycled()) {
                z = false;
            } else {
                z = true;
            }
        }
        return z;
    }
}
