package com.tinder.utils;

import android.backport.webp.WebPFactory;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.tinder.managers.ManagerApp;
import com.tinder.p030d.bh;
import com.tinder.utils.C3064c.C2316c;
import com.tinder.utils.C3064c.C2318a;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.tinder.utils.l */
public class C3075l {

    /* renamed from: com.tinder.utils.l.1 */
    static class C30731 implements C2316c {
        final /* synthetic */ bh f6614a;

        C30731(bh bhVar) {
            this.f6614a = bhVar;
        }

        public void m9380a(Object obj) {
            if (((Boolean) obj).booleanValue()) {
                this.f6614a.m5967a();
            } else {
                this.f6614a.m5968b();
            }
        }
    }

    /* renamed from: com.tinder.utils.l.2 */
    static class C30742 implements C2318a {
        final /* synthetic */ String f6615a;
        final /* synthetic */ String f6616b;
        final /* synthetic */ Bitmap f6617c;
        final /* synthetic */ int f6618d;
        final /* synthetic */ Context f6619e;

        C30742(String str, String str2, Bitmap bitmap, int i, Context context) {
            this.f6615a = str;
            this.f6616b = str2;
            this.f6617c = bitmap;
            this.f6618d = i;
            this.f6619e = context;
        }

        @NonNull
        public Object m9381a() {
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), this.f6615a);
            file.mkdirs();
            String str = ".jpeg";
            try {
                OutputStream fileOutputStream = new FileOutputStream(new File(file, this.f6616b + ".jpeg"));
                this.f6617c.compress(CompressFormat.JPEG, this.f6618d, fileOutputStream);
                fileOutputStream.close();
                String str2 = "image/jpeg";
                MediaScannerConnection.scanFile(this.f6619e, new String[]{r1.getPath()}, new String[]{"image/jpeg"}, null);
                return Boolean.valueOf(true);
            } catch (Exception e) {
                C3095y.m9479c(e.toString());
                return Boolean.valueOf(false);
            }
        }
    }

    public static Uri m9386a(@NonNull Context context) {
        return Uri.fromFile(C3075l.m9392b(context));
    }

    public static File m9392b(@NonNull Context context) {
        try {
            return File.createTempFile("img", ".jpeg", context.getCacheDir());
        } catch (IOException e) {
            C3095y.m9479c(String.valueOf(e));
            return null;
        }
    }

    public static String m9387a(@NonNull byte[] bArr, @NonNull Context context, int i, int i2, int i3) {
        Bitmap a = C3075l.m9383a(bArr, i2, i3);
        Uri a2 = C3075l.m9386a(context);
        if (a2 != null) {
            try {
                OutputStream openOutputStream = context.getContentResolver().openOutputStream(a2);
                a.compress(CompressFormat.JPEG, i, openOutputStream);
                a.recycle();
                openOutputStream.close();
                return a2.getPath();
            } catch (FileNotFoundException e) {
                C3095y.m9479c(String.valueOf(e));
            } catch (IOException e2) {
                C3095y.m9479c(String.valueOf(e2));
            }
        }
        return null;
    }

    public static boolean m9391a(String str) {
        boolean deleteFile = ManagerApp.m7917h().deleteFile(str);
        C3095y.m9471a("deleting " + str + " was " + deleteFile);
        return deleteFile;
    }

    public static boolean m9389a(@NonNull Bitmap bitmap, String str, int i, boolean z) {
        boolean z2;
        Object e;
        FileOutputStream fileOutputStream = null;
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            fileOutputStream = ManagerApp.m7917h().openFileOutput(str, 0);
        } catch (FileNotFoundException e2) {
            C3095y.m9479c("exception=" + e2);
        }
        try {
            bitmap.compress(CompressFormat.JPEG, i, byteArrayOutputStream);
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
            C3095y.m9471a("Image saved successfully");
            z2 = true;
            try {
                byteArrayOutputStream.close();
                fileOutputStream.close();
                if (z) {
                    bitmap.recycle();
                }
            } catch (IOException e3) {
                e = e3;
                try {
                    C3095y.m9479c("exception=" + e);
                    if (z) {
                        bitmap.recycle();
                    }
                } catch (Throwable th) {
                    if (z) {
                        bitmap.recycle();
                    }
                    return z2;
                }
                return z2;
            }
        } catch (IOException e4) {
            IOException iOException = e4;
            z2 = false;
            e = iOException;
            C3095y.m9479c("exception=" + e);
            if (z) {
                bitmap.recycle();
            }
            return z2;
        } catch (Throwable th2) {
            z2 = false;
            if (z) {
                bitmap.recycle();
            }
            return z2;
        }
        return z2;
    }

    public static Bitmap m9382a(String str, Options options) throws Exception {
        return BitmapFactory.decodeFile(ManagerApp.m7917h().getFilesDir() + "/" + str, options);
    }

    public static Bitmap m9383a(@NonNull byte[] bArr, int i, int i2) {
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        C3095y.m9471a("original bitmap has size w " + decodeByteArray.getWidth() + " h " + decodeByteArray.getHeight());
        int i3 = 0;
        Bitmap createBitmap = Bitmap.createBitmap(decodeByteArray, 0, i3, decodeByteArray.getWidth(), decodeByteArray.getHeight(), C3075l.m9385a(i, i2), true);
        if (decodeByteArray != createBitmap) {
            decodeByteArray.recycle();
        }
        return createBitmap;
    }

    @NonNull
    public static Matrix m9385a(int i, int i2) {
        Matrix matrix = new Matrix();
        if (i != 0) {
            Matrix matrix2 = new Matrix();
            matrix2.setValues(new float[]{GroundOverlayOptions.NO_DIMENSION, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f});
            matrix.postConcat(matrix2);
        }
        matrix.postRotate((float) i2);
        return matrix;
    }

    @NonNull
    public static String m9393b(String str) {
        return "file:" + ManagerApp.m7917h().getFilesDir() + '/' + str;
    }

    public static void m9388a(Context context, @NonNull Bitmap bitmap, int i, @NonNull String str, String str2, @NonNull bh bhVar) {
        C3064c.m9336a(new C30742(str, str2, bitmap, i, context)).m9340a(new C30731(bhVar)).m9341a();
    }

    public static Bitmap m9384a(@NonNull byte[] bArr, Options options, boolean z) {
        if (z) {
            return WebPFactory.nativeDecodeByteArray(bArr, options);
        }
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
    }

    public static boolean m9394c(@NonNull String str) {
        return str.endsWith("webp");
    }

    public static boolean m9390a(@Nullable File file) {
        if (file != null && file.isDirectory()) {
            String[] list = file.list();
            for (String file2 : list) {
                if (!C3075l.m9390a(new File(file, file2))) {
                    return false;
                }
            }
        }
        return file.delete();
    }
}
