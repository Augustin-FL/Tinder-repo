package com.tinder.picassowebp.picasso;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.provider.MediaStore.Images;
import android.provider.MediaStore.Video.Thumbnails;
import com.google.android.gms.ads.AdRequest;
import java.io.IOException;

class MediaStoreBitmapHunter extends C2984g {
    private static final String[] f6312p;

    enum PicassoKind {
        MICRO(3, 96, 96),
        MINI(1, AdRequest.MAX_CONTENT_URL_LENGTH, 384),
        FULL(2, -1, -1);
        
        final int f6292d;
        final int f6293e;
        final int f6294f;

        private PicassoKind(int i, int i2, int i3) {
            this.f6292d = i;
            this.f6293e = i2;
            this.f6294f = i3;
        }
    }

    static {
        f6312p = new String[]{"orientation"};
    }

    MediaStoreBitmapHunter(Context context, Picasso picasso, C3014i c3014i, C3005d c3005d, C3033v c3033v, C2993a c2993a) {
        super(context, picasso, c3014i, c3005d, c3033v, c2993a);
    }

    static PicassoKind m8974a(int i, int i2) {
        if (i <= PicassoKind.MICRO.f6293e && i2 <= PicassoKind.MICRO.f6294f) {
            return PicassoKind.MICRO;
        }
        if (i > PicassoKind.MINI.f6293e || i2 > PicassoKind.MINI.f6294f) {
            return PicassoKind.FULL;
        }
        return PicassoKind.MINI;
    }

    static int m8973a(ContentResolver contentResolver, Uri uri) {
        Cursor query;
        Cursor cursor;
        Throwable th;
        try {
            query = contentResolver.query(uri, f6312p, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        int i = query.getInt(0);
                        if (query == null) {
                            return i;
                        }
                        query.close();
                        return i;
                    }
                } catch (RuntimeException e) {
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    return 0;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            return 0;
        } catch (RuntimeException e2) {
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            return 0;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    Bitmap m8975a(C3026s c3026s) throws IOException {
        int i = 1;
        ContentResolver contentResolver = this.o.getContentResolver();
        m8954a(m8973a(contentResolver, c3026s.f6427a));
        String type = contentResolver.getType(c3026s.f6427a);
        int i2 = (type == null || !type.startsWith("video/")) ? 0 : 1;
        if (c3026s.m9112d()) {
            PicassoKind a = m8974a(c3026s.f6430d, c3026s.f6431e);
            if (i2 == 0 && a == PicassoKind.FULL) {
                return super.m8970a(c3026s);
            }
            Bitmap thumbnail;
            long parseId = ContentUris.parseId(c3026s.f6427a);
            Options c = C2983c.m8951c(c3026s);
            c.inJustDecodeBounds = true;
            C2983c.m8947a(c3026s.f6430d, c3026s.f6431e, a.f6293e, a.f6294f, c);
            if (i2 != 0) {
                if (a != PicassoKind.FULL) {
                    i = a.f6292d;
                }
                thumbnail = Thumbnails.getThumbnail(contentResolver, parseId, i, c);
            } else {
                thumbnail = Images.Thumbnails.getThumbnail(contentResolver, parseId, a.f6292d, c);
            }
            if (thumbnail != null) {
                return thumbnail;
            }
        }
        return super.m8970a(c3026s);
    }
}
