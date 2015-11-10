package com.tinder.picassowebp.picasso;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings.System;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.Log;
import com.facebook.stetho.BuildConfig;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ThreadFactory;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;

final class ab {
    static final StringBuilder f6360a;

    @TargetApi(11)
    /* renamed from: com.tinder.picassowebp.picasso.ab.a */
    private static class C2995a {
        static int m9011a(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    @TargetApi(12)
    /* renamed from: com.tinder.picassowebp.picasso.ab.b */
    private static class C2996b {
        static int m9012a(Bitmap bitmap) {
            return bitmap.getByteCount();
        }
    }

    /* renamed from: com.tinder.picassowebp.picasso.ab.c */
    private static class C2997c {
        static Downloader m9013a(Context context) {
            return new C3021p(context);
        }
    }

    /* renamed from: com.tinder.picassowebp.picasso.ab.d */
    private static class C2998d extends Thread {
        public C2998d(Runnable runnable) {
            super(runnable);
        }

        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    /* renamed from: com.tinder.picassowebp.picasso.ab.e */
    static class C2999e implements ThreadFactory {
        C2999e() {
        }

        public Thread newThread(Runnable runnable) {
            return new C2998d(runnable);
        }
    }

    static {
        f6360a = new StringBuilder();
    }

    static int m9015a(Bitmap bitmap) {
        int a;
        if (VERSION.SDK_INT >= 12) {
            a = C2996b.m9012a(bitmap);
        } else {
            a = bitmap.getRowBytes() * bitmap.getHeight();
        }
        if (a >= 0) {
            return a;
        }
        throw new IllegalStateException("Negative size: " + bitmap);
    }

    static void m9024a() {
        if (!m9030b()) {
            throw new IllegalStateException("Method call should happen from the main thread.");
        }
    }

    static boolean m9030b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    static String m9020a(C2983c c2983c) {
        return m9021a(c2983c, BuildConfig.FLAVOR);
    }

    static String m9021a(C2983c c2983c, String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        C2993a j = c2983c.m8966j();
        if (j != null) {
            stringBuilder.append(j.f6348b.m9109a());
        }
        List l = c2983c.m8968l();
        if (l != null) {
            int size = l.size();
            for (int i = 0; i < size; i++) {
                if (i > 0 || j != null) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(((C2993a) l.get(i)).f6348b.m9109a());
            }
        }
        return stringBuilder.toString();
    }

    static void m9026a(String str, String str2, String str3) {
        m9027a(str, str2, str3, BuildConfig.FLAVOR);
    }

    static void m9027a(String str, String str2, String str3, String str4) {
        Log.d("Picasso", String.format("%1$-11s %2$-12s %3$s %4$s", new Object[]{str, str2, str3, str4}));
    }

    static String m9022a(C3026s c3026s) {
        String a = m9023a(c3026s, f6360a);
        f6360a.setLength(0);
        return a;
    }

    static String m9023a(C3026s c3026s, StringBuilder stringBuilder) {
        if (c3026s.f6427a != null) {
            String uri = c3026s.f6427a.toString();
            stringBuilder.ensureCapacity(uri.length() + 50);
            stringBuilder.append(uri);
        } else {
            stringBuilder.ensureCapacity(50);
            stringBuilder.append(c3026s.f6428b);
        }
        stringBuilder.append('\n');
        if (c3026s.f6434h != 0.0f) {
            stringBuilder.append("rotation:").append(c3026s.f6434h);
            if (c3026s.f6437k) {
                stringBuilder.append('@').append(c3026s.f6435i).append('x').append(c3026s.f6436j);
            }
            stringBuilder.append('\n');
        }
        if (c3026s.f6430d != 0) {
            stringBuilder.append("resize:").append(c3026s.f6430d).append('x').append(c3026s.f6431e);
            stringBuilder.append('\n');
        }
        if (c3026s.f6432f) {
            stringBuilder.append("centerCrop\n");
        } else if (c3026s.f6433g) {
            stringBuilder.append("centerInside\n");
        }
        if (c3026s.f6429c != null) {
            int size = c3026s.f6429c.size();
            for (int i = 0; i < size; i++) {
                stringBuilder.append(((C3036z) c3026s.f6429c.get(i)).key());
                stringBuilder.append('\n');
            }
        }
        return stringBuilder.toString();
    }

    static void m9025a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
            }
        }
    }

    static boolean m9028a(String str) {
        boolean z = true;
        if (str == null) {
            return false;
        }
        String[] split = str.split(" ", 2);
        if ("CACHE".equals(split[0])) {
            return true;
        }
        if (split.length == 1) {
            return false;
        }
        try {
            if (!("CONDITIONAL_CACHE".equals(split[0]) && Integer.parseInt(split[1]) == HttpStatus.SC_NOT_MODIFIED)) {
                z = false;
            }
            return z;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    static Downloader m9018a(Context context) {
        Object obj;
        Object obj2 = 1;
        try {
            Class.forName("com.squareup.okhttp.r");
            obj = 1;
        } catch (ClassNotFoundException e) {
            obj = null;
        }
        try {
            Class.forName("com.squareup.okhttp.q");
        } catch (ClassNotFoundException e2) {
            obj2 = null;
        }
        if (obj2 == obj) {
            return obj2 != null ? C2997c.m9013a(context) : new aa(context);
        } else {
            throw new RuntimeException("Picasso detected an unsupported OkHttp on the classpath.\nTo use OkHttp with this version of Picasso, you'll need:\n1. com.squareup.okhttp:okhttp:1.6.0 (or newer)\n2. com.squareup.okhttp:okhttp-urlconnection:1.6.0 (or newer)\nNote that OkHttp 2.0.0+ is supported!");
        }
    }

    static File m9029b(Context context) {
        File file = new File(context.getApplicationContext().getCacheDir(), "picasso-cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    static long m9016a(File file) {
        long blockSize;
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            blockSize = (((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount())) / 50;
        } catch (IllegalArgumentException e) {
            blockSize = 5242880;
        }
        return Math.max(Math.min(blockSize, 52428800), 5242880);
    }

    static int m9033c(Context context) {
        int i;
        ActivityManager activityManager = (ActivityManager) m9019a(context, "activity");
        Object obj = (context.getApplicationInfo().flags & AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START) != 0 ? 1 : null;
        int memoryClass = activityManager.getMemoryClass();
        if (obj == null || VERSION.SDK_INT < 11) {
            i = memoryClass;
        } else {
            i = C2995a.m9011a(activityManager);
        }
        return (i * AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START) / 7;
    }

    static boolean m9035d(Context context) {
        if (System.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0) {
            return true;
        }
        return false;
    }

    static <T> T m9019a(Context context, String str) {
        return context.getSystemService(str);
    }

    static boolean m9031b(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    static byte[] m9032b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[AccessibilityNodeInfoCompat.ACTION_SCROLL_FORWARD];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    static boolean m9034c(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[12];
        if (inputStream.read(bArr, 0, 12) == 12 && "RIFF".equals(new String(bArr, 0, 4, HTTP.US_ASCII)) && "WEBP".equals(new String(bArr, 8, 4, HTTP.US_ASCII))) {
            return true;
        }
        return false;
    }

    static int m9014a(Resources resources, C3026s c3026s) throws FileNotFoundException {
        if (c3026s.f6428b != 0 || c3026s.f6427a == null) {
            return c3026s.f6428b;
        }
        String authority = c3026s.f6427a.getAuthority();
        if (authority == null) {
            throw new FileNotFoundException("No package provided: " + c3026s.f6427a);
        }
        List pathSegments = c3026s.f6427a.getPathSegments();
        if (pathSegments == null || pathSegments.isEmpty()) {
            throw new FileNotFoundException("No path segments: " + c3026s.f6427a);
        } else if (pathSegments.size() == 1) {
            try {
                return Integer.parseInt((String) pathSegments.get(0));
            } catch (NumberFormatException e) {
                throw new FileNotFoundException("Last path segment is not a resource ID: " + c3026s.f6427a);
            }
        } else if (pathSegments.size() == 2) {
            return resources.getIdentifier((String) pathSegments.get(1), (String) pathSegments.get(0), authority);
        } else {
            throw new FileNotFoundException("More than two path segments: " + c3026s.f6427a);
        }
    }

    static Resources m9017a(Context context, C3026s c3026s) throws FileNotFoundException {
        if (c3026s.f6428b != 0 || c3026s.f6427a == null) {
            return context.getResources();
        }
        String authority = c3026s.f6427a.getAuthority();
        if (authority == null) {
            throw new FileNotFoundException("No package provided: " + c3026s.f6427a);
        }
        try {
            return context.getPackageManager().getResourcesForApplication(authority);
        } catch (NameNotFoundException e) {
            throw new FileNotFoundException("Unable to obtain resources for package: " + c3026s.f6427a);
        }
    }
}
