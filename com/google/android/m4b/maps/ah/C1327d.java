package com.google.android.m4b.maps.ah;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Environment;
import android.os.StatFs;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.Log;
import android.util.Pair;
import com.facebook.stetho.BuildConfig;
import com.google.android.gms.ads.AdRequest;
import com.google.android.m4b.maps.ag.h;
import com.google.android.m4b.maps.ag.i;
import com.google.android.m4b.maps.ay.ac;
import com.google.android.m4b.maps.ay.af;
import com.google.android.m4b.maps.ay.ah;
import com.google.android.m4b.maps.ch.a;
import com.google.android.m4b.maps.ch.b;
import com.google.android.m4b.maps.p020y.C1589a;
import com.google.android.m4b.maps.p020y.C1589a.C1587c;
import com.google.android.m4b.maps.p020y.C1589a.C1588d;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.zip.CRC32;
import org.apache.http.protocol.HTTP;

/* renamed from: com.google.android.m4b.maps.ah.d */
public final class C1327d {
    private static boolean f814a;
    private static int f815b;
    private static final long[] f816c;
    private static int f817d;

    static {
        int i = 0;
        f814a = false;
        f815b = 0;
        long[] jArr = new long[22];
        long j = 0;
        for (int i2 = 0; i2 < 22; i2++) {
            j += 1 << (i2 * 2);
            jArr[i2] = j - 1;
        }
        f816c = jArr;
        j = jArr[21];
        if (j < 0) {
            i = 64;
        } else {
            while (j != 0) {
                j >>= 1;
                i++;
            }
        }
        f817d = i;
    }

    public static void m1086a(String str, Throwable th) {
        if (!f814a) {
            System.err.println(str);
            System.err.println(Log.getStackTraceString(th));
        }
        C1589a.m2848b(new C1588d(th));
    }

    public static void m1084a(String str, String str2) {
        if (!f814a) {
            System.err.println(str2);
        }
        C1589a.m2848b(new C1587c(str, str2));
    }

    private static void m1085a(String str, String str2, boolean z) {
        i b = h.b();
        if (b != null && str != null && str2 != null) {
            int i = f815b + 1;
            f815b = i;
            if (i <= 10) {
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream(AdRequest.MAX_CONTENT_URL_LENGTH);
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                try {
                    dataOutputStream.writeUTF(new StringBuilder(AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS).append("DA:").append(str).toString());
                    dataOutputStream.writeUTF("DA");
                    dataOutputStream.writeUTF(str2);
                } catch (IOException e) {
                }
                b.a(8, byteArrayOutputStream.toByteArray(), z, false);
            }
        }
    }

    public static void m1089b(String str, String str2) {
        C1327d.m1085a(str, str2, true);
    }

    public static void m1093c(String str, String str2) {
        C1327d.m1085a(str, str2, false);
    }

    public static void m1083a() {
        f814a = true;
    }

    public static boolean m1090b() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static a m1081a(Context context, String str, b bVar) {
        DataInputStream dataInputStream;
        DataInputStream dataInputStream2;
        String str2;
        Throwable th;
        String str3;
        try {
            dataInputStream = new DataInputStream(new BufferedInputStream(context.openFileInput(str), AccessibilityNodeInfoCompat.ACTION_SCROLL_FORWARD));
            try {
                a aVar = new a(bVar);
                aVar.a(dataInputStream);
                try {
                    dataInputStream.close();
                    return aVar;
                } catch (IOException e) {
                    return aVar;
                }
            } catch (IOException e2) {
                dataInputStream2 = dataInputStream;
                try {
                    str2 = "MapsNavigation";
                    "readProtoFromFile failed: " + str;
                    if (dataInputStream2 != null) {
                        try {
                            dataInputStream2.close();
                        } catch (IOException e3) {
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    dataInputStream = dataInputStream2;
                    th = th2;
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            } catch (RuntimeException e5) {
                try {
                    str3 = "MapsNavigation";
                    "readProtoFromFile failed: " + str;
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (IOException e6) {
                        }
                    }
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    if (dataInputStream != null) {
                        dataInputStream.close();
                    }
                    throw th;
                }
            }
        } catch (IOException e7) {
            dataInputStream2 = null;
            str2 = "MapsNavigation";
            "readProtoFromFile failed: " + str;
            if (dataInputStream2 != null) {
                dataInputStream2.close();
            }
            return null;
        } catch (RuntimeException e8) {
            dataInputStream = null;
            str3 = "MapsNavigation";
            "readProtoFromFile failed: " + str;
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            dataInputStream = null;
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            throw th;
        }
    }

    public static boolean m1087a(Context context, a aVar, String str) {
        DataOutputStream dataOutputStream;
        IOException e;
        String str2;
        try {
            dataOutputStream = new DataOutputStream(context.openFileOutput(str, 0));
            try {
                aVar.b(dataOutputStream);
                dataOutputStream.close();
                return true;
            } catch (IOException e2) {
                e = e2;
                str2 = "MapsNavigation";
                "writeProtoToFile failed: " + e.getMessage();
                if (dataOutputStream != null) {
                    return false;
                }
                try {
                    dataOutputStream.close();
                } catch (IOException e3) {
                }
                context.getFileStreamPath(str).delete();
                return false;
            }
        } catch (IOException e4) {
            e = e4;
            dataOutputStream = null;
            str2 = "MapsNavigation";
            "writeProtoToFile failed: " + e.getMessage();
            if (dataOutputStream != null) {
                return false;
            }
            dataOutputStream.close();
            context.getFileStreamPath(str).delete();
            return false;
        }
    }

    private static File m1094d(Context context) {
        if (!C1327d.m1090b()) {
            return context.getDir(BuildConfig.FLAVOR, 0);
        }
        return new File(Environment.getExternalStorageDirectory(), "Android/data/" + context.getPackageName());
    }

    public static File m1082a(Context context) {
        return new File(C1327d.m1094d(context), "testdata");
    }

    public static File m1088b(Context context) {
        return new File(C1327d.m1094d(context), "debug");
    }

    public static File m1092c(Context context) {
        return new File(C1327d.m1094d(context), "cache");
    }

    public static long m1091c() {
        long j = 0;
        if (!C1327d.m1090b()) {
            return j;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (IllegalArgumentException e) {
            return j;
        }
    }

    public static Pair<Long, String> m1079a(ah ahVar, ac acVar) {
        long b;
        ac a = acVar.m1444a(acVar.m1457j().m1466a(ahVar));
        af j = a.m1457j();
        if (j.m1471b()) {
            b = ((((long) (a.m1449b() & 31)) << 58) | (((long) (a.m1450c() & 536870911)) << 29)) | ((long) (a.m1451d() & 536870911));
        } else {
            int b2 = a.m1449b();
            b = ((b2 == 0 ? 0 : f816c[b2 - 1] + 1) + ((((long) a.m1451d()) << b2) + ((long) a.m1450c()))) | (Long.MIN_VALUE | (((long) j.hashCode()) << f817d));
        }
        Long valueOf = Long.valueOf(b);
        af j2 = a.m1457j();
        return new Pair(valueOf, j2.m1471b() ? null : j2.toString());
    }

    public static ac m1080a(long j) {
        if (j < 0) {
            return null;
        }
        return new ac(((int) (j >> 58)) & 31, ((int) (j >> 29)) & 536870911, ((int) j) & 536870911);
    }

    public static long m1077a(String str) {
        CRC32 crc32 = new CRC32();
        try {
            crc32.update(str.getBytes(HTTP.UTF_8));
        } catch (UnsupportedEncodingException e) {
        }
        return (crc32.getValue() << 32) | (((long) str.hashCode()) & 4294967295L);
    }

    public static Bitmap m1078a(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        matrix.setPolyToPoly(new float[]{0.0f, 0.0f, 0.0f, (float) height, (float) width, 0.0f, (float) width, (float) height}, 0, new float[]{0.0f, (float) height, 0.0f, 0.0f, (float) width, (float) height, (float) width, 0.0f}, 0, 4);
        ColorMatrix colorMatrix = new ColorMatrix(new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        new Canvas(bitmap).drawBitmap(Bitmap.createBitmap(bitmap), matrix, paint);
        return bitmap;
    }
}
