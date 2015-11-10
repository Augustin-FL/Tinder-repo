package io.fabric.sdk.android.services.common;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import com.facebook.stetho.BuildConfig;
import com.google.android.gms.location.places.Place;
import com.tinder.views.RangeSeekBar;
import io.fabric.sdk.android.C3218c;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class CommonUtils {
    public static final Comparator<File> f7031a;
    private static Boolean f7032b;
    private static final char[] f7033c;
    private static long f7034d;
    private static Boolean f7035e;

    /* renamed from: io.fabric.sdk.android.services.common.CommonUtils.1 */
    static class C32401 implements Comparator<File> {
        C32401() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m9833a((File) obj, (File) obj2);
        }

        public int m9833a(File file, File file2) {
            return (int) (file.lastModified() - file2.lastModified());
        }
    }

    enum Architecture {
        X86_32,
        X86_64,
        ARM_UNKNOWN,
        PPC,
        PPC64,
        ARMV6,
        ARMV7,
        UNKNOWN,
        ARMV7S,
        ARM64;
        
        private static final Map<String, Architecture> f7029k;

        static {
            f7029k = new HashMap(4);
            f7029k.put("armeabi-v7a", ARMV7);
            f7029k.put("armeabi", ARMV6);
            f7029k.put("x86", X86_32);
        }

        static Architecture m9834a() {
            Object obj = Build.CPU_ABI;
            if (TextUtils.isEmpty(obj)) {
                C3218c.m9728h().m9687a("Fabric", "Architecture#getValue()::Build.CPU_ABI returned null or empty");
                return UNKNOWN;
            }
            Architecture architecture = (Architecture) f7029k.get(obj.toLowerCase(Locale.US));
            if (architecture == null) {
                return UNKNOWN;
            }
            return architecture;
        }
    }

    static {
        f7032b = null;
        f7033c = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        f7034d = -1;
        f7035e = null;
        f7031a = new C32401();
    }

    public static SharedPreferences m9840a(Context context) {
        return context.getSharedPreferences("com.crashlytics.prefs", 0);
    }

    public static String m9842a(File file, String str) {
        Closeable bufferedReader;
        Throwable e;
        Throwable th;
        String str2 = null;
        if (file.exists()) {
            try {
                String[] split;
                bufferedReader = new BufferedReader(new FileReader(file), Place.TYPE_SUBLOCALITY_LEVEL_2);
                while (true) {
                    try {
                        CharSequence readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        split = Pattern.compile("\\s*:\\s*").split(readLine, 2);
                        if (split.length > 1 && split[0].equals(str)) {
                            break;
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                }
                str2 = split[1];
                m9855a(bufferedReader, "Failed to close system file reader.");
            } catch (Exception e3) {
                e = e3;
                bufferedReader = null;
                try {
                    C3218c.m9728h().m9695e("Fabric", "Error parsing " + file, e);
                    m9855a(bufferedReader, "Failed to close system file reader.");
                    return str2;
                } catch (Throwable th2) {
                    th = th2;
                    m9855a(bufferedReader, "Failed to close system file reader.");
                    throw th;
                }
            } catch (Throwable e4) {
                bufferedReader = null;
                th = e4;
                m9855a(bufferedReader, "Failed to close system file reader.");
                throw th;
            }
        }
        return str2;
    }

    public static int m9835a() {
        return Architecture.m9834a().ordinal();
    }

    public static synchronized long m9859b() {
        long j;
        synchronized (CommonUtils.class) {
            if (f7034d == -1) {
                j = 0;
                Object a = m9842a(new File("/proc/meminfo"), "MemTotal");
                if (!TextUtils.isEmpty(a)) {
                    String toUpperCase = a.toUpperCase(Locale.US);
                    try {
                        if (toUpperCase.endsWith("KB")) {
                            j = m9838a(toUpperCase, "KB", (int) Place.TYPE_SUBLOCALITY_LEVEL_2);
                        } else if (toUpperCase.endsWith("MB")) {
                            j = m9838a(toUpperCase, "MB", (int) AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START);
                        } else if (toUpperCase.endsWith("GB")) {
                            j = m9838a(toUpperCase, "GB", 1073741824);
                        } else {
                            C3218c.m9728h().m9687a("Fabric", "Unexpected meminfo format while computing RAM: " + toUpperCase);
                        }
                    } catch (Throwable e) {
                        C3218c.m9728h().m9695e("Fabric", "Unexpected meminfo format while computing RAM: " + toUpperCase, e);
                    }
                }
                f7034d = j;
            }
            j = f7034d;
        }
        return j;
    }

    static long m9838a(String str, String str2, int i) {
        return Long.parseLong(str.split(str2)[0].trim()) * ((long) i);
    }

    public static RunningAppProcessInfo m9839a(String str, Context context) {
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    return runningAppProcessInfo;
                }
            }
        }
        return null;
    }

    public static String m9843a(InputStream inputStream) throws IOException {
        Scanner useDelimiter = new Scanner(inputStream).useDelimiter("\\A");
        return useDelimiter.hasNext() ? useDelimiter.next() : BuildConfig.FLAVOR;
    }

    public static String m9845a(String str) {
        return m9846a(str, "SHA-1");
    }

    public static String m9864b(InputStream inputStream) {
        return m9844a(inputStream, "SHA-1");
    }

    private static String m9844a(InputStream inputStream, String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            byte[] bArr = new byte[Place.TYPE_SUBLOCALITY_LEVEL_2];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return m9847a(instance.digest());
                }
                instance.update(bArr, 0, read);
            }
        } catch (Throwable e) {
            C3218c.m9728h().m9695e("Fabric", "Could not calculate hash for app icon.", e);
            return BuildConfig.FLAVOR;
        }
    }

    private static String m9848a(byte[] bArr, String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.update(bArr);
            return m9847a(instance.digest());
        } catch (Throwable e) {
            C3218c.m9728h().m9695e("Fabric", "Could not create hashing algorithm: " + str + ", returning empty string.", e);
            return BuildConfig.FLAVOR;
        }
    }

    private static String m9846a(String str, String str2) {
        return m9848a(str.getBytes(), str2);
    }

    public static String m9849a(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        List<String> arrayList = new ArrayList();
        for (String str : strArr) {
            if (str != null) {
                arrayList.add(str.replace("-", BuildConfig.FLAVOR).toLowerCase(Locale.US));
            }
        }
        Collections.sort(arrayList);
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : arrayList) {
            stringBuilder.append(append);
        }
        String append2 = stringBuilder.toString();
        return append2.length() > 0 ? m9845a(append2) : null;
    }

    public static long m9860b(Context context) {
        MemoryInfo memoryInfo = new MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static long m9861b(String str) {
        StatFs statFs = new StatFs(str);
        long blockSize = (long) statFs.getBlockSize();
        return (((long) statFs.getBlockCount()) * blockSize) - (((long) statFs.getAvailableBlocks()) * blockSize);
    }

    public static float m9865c(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        return ((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
    }

    public static boolean m9869d(Context context) {
        if (m9871f(context)) {
            return false;
        }
        return ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(8) != null;
    }

    public static void m9852a(Context context, String str) {
        if (m9870e(context)) {
            C3218c.m9728h().m9687a("Fabric", str);
        }
    }

    public static void m9853a(Context context, String str, Throwable th) {
        if (m9870e(context)) {
            C3218c.m9728h().m9694e("Fabric", str);
        }
    }

    public static void m9851a(Context context, int i, String str, String str2) {
        if (m9870e(context)) {
            C3218c.m9728h().m9685a(i, "Fabric", str2);
        }
    }

    public static boolean m9870e(Context context) {
        if (f7032b == null) {
            f7032b = Boolean.valueOf(m9858a(context, "com.crashlytics.Trace", false));
        }
        return f7032b.booleanValue();
    }

    public static boolean m9858a(Context context, String str, boolean z) {
        if (context == null) {
            return z;
        }
        Resources resources = context.getResources();
        if (resources == null) {
            return z;
        }
        int a = m9836a(context, str, "bool");
        if (a > 0) {
            return resources.getBoolean(a);
        }
        int a2 = m9836a(context, str, "string");
        if (a2 > 0) {
            return Boolean.parseBoolean(context.getString(a2));
        }
        return z;
    }

    public static int m9836a(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, m9875j(context));
    }

    public static boolean m9871f(Context context) {
        return ServerProtocol.DIALOG_PARAM_SDK_VERSION.equals(Build.PRODUCT) || "google_sdk".equals(Build.PRODUCT) || Secure.getString(context.getContentResolver(), "android_id") == null;
    }

    public static boolean m9872g(Context context) {
        boolean f = m9871f(context);
        String str = Build.TAGS;
        if ((!f && str != null && str.contains("test-keys")) || new File("/system/app/Superuser.apk").exists()) {
            return true;
        }
        File file = new File("/system/xbin/su");
        if (f || !file.exists()) {
            return false;
        }
        return true;
    }

    public static boolean m9866c() {
        return Debug.isDebuggerConnected() || Debug.waitingForDebugger();
    }

    public static int m9873h(Context context) {
        int i = 0;
        if (m9871f(context)) {
            i = 1;
        }
        if (m9872g(context)) {
            i |= 2;
        }
        if (m9866c()) {
            return i | 4;
        }
        return i;
    }

    public static int m9837a(Context context, boolean z) {
        float c = m9865c(context);
        if (!z) {
            return 1;
        }
        if (z && ((double) c) >= 99.0d) {
            return 3;
        }
        if (!z || ((double) c) >= 99.0d) {
            return 0;
        }
        return 2;
    }

    @SuppressLint({"GetInstance"})
    public static Cipher m9850a(int i, String str) throws InvalidKeyException {
        if (str.length() < 32) {
            throw new InvalidKeyException("Key must be at least 32 bytes.");
        }
        Key secretKeySpec = new SecretKeySpec(str.getBytes(), 0, 32, "AES/ECB/PKCS7Padding");
        try {
            Cipher instance = Cipher.getInstance("AES/ECB/PKCS7Padding");
            instance.init(i, secretKeySpec);
            return instance;
        } catch (Throwable e) {
            C3218c.m9728h().m9695e("Fabric", "Could not create Cipher for AES/ECB/PKCS7Padding - should never happen.", e);
            throw new RuntimeException(e);
        }
    }

    public static String m9847a(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & RangeSeekBar.INVALID_POINTER_ID;
            cArr[i * 2] = f7033c[i2 >>> 4];
            cArr[(i * 2) + 1] = f7033c[i2 & 15];
        }
        return new String(cArr);
    }

    public static boolean m9874i(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    public static String m9863b(Context context, String str) {
        int a = m9836a(context, str, "string");
        if (a > 0) {
            return context.getString(a);
        }
        return BuildConfig.FLAVOR;
    }

    public static void m9855a(Closeable closeable, String str) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable e) {
                C3218c.m9728h().m9695e("Fabric", str, e);
            }
        }
    }

    public static void m9856a(Flushable flushable, String str) {
        if (flushable != null) {
            try {
                flushable.flush();
            } catch (Throwable e) {
                C3218c.m9728h().m9695e("Fabric", str, e);
            }
        }
    }

    public static boolean m9868c(String str) {
        return str == null || str.length() == 0;
    }

    public static String m9841a(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("value must be zero or greater");
        }
        return String.format(Locale.US, "%1$10s", new Object[]{Integer.valueOf(i)}).replace(' ', '0');
    }

    public static String m9875j(Context context) {
        int i = context.getApplicationContext().getApplicationInfo().icon;
        if (i > 0) {
            return context.getResources().getResourcePackageName(i);
        }
        return context.getPackageName();
    }

    public static void m9857a(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static String m9862b(int i) {
        switch (i) {
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                return "V";
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                return "D";
            case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                return "I";
            case C3374b.SmoothProgressBar_spb_speed /*5*/:
                return "W";
            case C3374b.SmoothProgressBar_spb_progressiveStart_speed /*6*/:
                return "E";
            case C3374b.SmoothProgressBar_spb_progressiveStop_speed /*7*/:
                return "A";
            default:
                return "?";
        }
    }

    public static String m9876k(Context context) {
        Closeable openRawResource;
        Throwable e;
        Throwable th;
        String str = null;
        try {
            openRawResource = context.getResources().openRawResource(m9877l(context));
            try {
                String b = m9864b((InputStream) openRawResource);
                if (!m9868c(b)) {
                    str = b;
                }
                m9855a(openRawResource, "Failed to close icon input stream.");
            } catch (Exception e2) {
                e = e2;
                try {
                    C3218c.m9728h().m9695e("Fabric", "Could not calculate hash for app icon.", e);
                    m9855a(openRawResource, "Failed to close icon input stream.");
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    m9855a(openRawResource, "Failed to close icon input stream.");
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            openRawResource = null;
            C3218c.m9728h().m9695e("Fabric", "Could not calculate hash for app icon.", e);
            m9855a(openRawResource, "Failed to close icon input stream.");
            return str;
        } catch (Throwable e4) {
            openRawResource = null;
            th = e4;
            m9855a(openRawResource, "Failed to close icon input stream.");
            throw th;
        }
        return str;
    }

    public static int m9877l(Context context) {
        return context.getApplicationContext().getApplicationInfo().icon;
    }

    public static String m9878m(Context context) {
        int a = m9836a(context, "io.fabric.android.build_id", "string");
        if (a == 0) {
            a = m9836a(context, "com.crashlytics.android.build_id", "string");
        }
        if (a == 0) {
            return null;
        }
        String string = context.getResources().getString(a);
        C3218c.m9728h().m9687a("Fabric", "Build ID is: " + string);
        return string;
    }

    public static void m9854a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    public static boolean m9867c(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    public static boolean m9879n(Context context) {
        if (!m9867c(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return true;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }
}
