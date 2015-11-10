package com.tinder.utils;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;
import com.android.volley.VolleyError;
import com.crashlytics.android.C0359a;
import com.facebook.stetho.BuildConfig;
import com.tinder.managers.ManagerApp;

/* renamed from: com.tinder.utils.y */
public class C3095y {
    @NonNull
    private static String m9482d(@NonNull String str, @NonNull String str2) {
        if (!str2.contains("\n")) {
            return str + str2;
        }
        String[] split = str2.split("\n");
        StringBuilder stringBuilder = new StringBuilder(str2.length() + (str.length() * split.length));
        for (int i = 0; i < split.length - 1; i++) {
            stringBuilder.append(str);
            stringBuilder.append(split[i]);
            if (i != split.length - 1) {
                stringBuilder.append('\n');
            }
        }
        return stringBuilder.toString();
    }

    public static void m9472a(String str, @NonNull String str2) {
        C0359a.m446a(str + ": " + str2);
        if (ManagerApp.f5578a) {
            Log.e(str, C3095y.m9482d(C3095y.m9486f(), str2));
        }
    }

    public static void m9473a(String str, @NonNull String str2, @NonNull Exception exception) {
        C0359a.m447a((Throwable) exception);
        C0359a.m446a(str + ": " + str2);
        if (ManagerApp.f5578a) {
            Log.e(str, C3095y.m9482d(C3095y.m9486f(), str2) + " [reason] " + exception.getMessage());
        }
    }

    public static void m9477b(String str, @NonNull String str2) {
        if (ManagerApp.f5578a) {
            Log.d(str, C3095y.m9482d(C3095y.m9486f(), str2));
        }
    }

    public static void m9471a(@NonNull String str) {
        if (ManagerApp.f5578a) {
            Log.d("Tinder", C3095y.m9482d(C3095y.m9486f(), str));
        }
    }

    public static void m9469a() {
        if (ManagerApp.f5578a) {
            Log.d("Tinder", C3095y.m9486f() + "ENTER");
        }
    }

    private static int m9478c() {
        return Thread.currentThread().getStackTrace()[5].getLineNumber();
    }

    private static String m9481d() {
        try {
            String fileName = Thread.currentThread().getStackTrace()[5].getFileName();
            return fileName.substring(0, fileName.length() - 5);
        } catch (OutOfMemoryError e) {
            C3095y.m9479c(e.getMessage());
            return BuildConfig.FLAVOR;
        }
    }

    private static String m9484e() {
        return Thread.currentThread().getStackTrace()[5].getMethodName();
    }

    @NonNull
    private static String m9486f() {
        return "[TID:" + Thread.currentThread().getId() + '-' + C3095y.m9481d() + '.' + C3095y.m9484e() + "()-" + C3095y.m9478c() + "]: ";
    }

    public static void m9476b(@NonNull String str) {
        C0359a.m446a(str);
        if (ManagerApp.f5578a) {
            Log.w("Tinder", C3095y.m9482d(C3095y.m9486f(), str));
        }
    }

    public static void m9480c(String str, @NonNull String str2) {
        if (ManagerApp.f5578a) {
            Log.w(str, C3095y.m9482d(C3095y.m9486f(), str2));
        }
    }

    public static void m9479c(@NonNull String str) {
        C0359a.m446a(str);
        if (ManagerApp.f5578a) {
            Log.e("Tinder", C3095y.m9482d(C3095y.m9486f(), str));
        }
    }

    public static void m9474a(String str, Throwable th) {
        C0359a.m447a(th);
        C0359a.m446a(str);
        if (ManagerApp.f5578a) {
            Log.e("Tinder", C3095y.m9486f() + str, th);
        }
    }

    public static void m9483d(@NonNull String str) {
        if (ManagerApp.f5578a) {
            Log.v("Tinder", C3095y.m9482d(C3095y.m9486f(), str));
        }
    }

    public static void m9485e(@NonNull String str) {
        if (ManagerApp.f5578a) {
            Log.i("Tinder", C3095y.m9482d(C3095y.m9486f(), str));
        }
    }

    public static void m9487f(@NonNull String str) {
        C3095y.m9485e(str);
        C0359a.m446a(str);
    }

    public static void m9475b() {
        if (ManagerApp.f5578a) {
            try {
                throw new ArithmeticException();
            } catch (ArithmeticException e) {
                e.printStackTrace();
            }
        }
    }

    public static void m9488g(@NonNull String str) {
        if (ManagerApp.f5578a) {
            C3095y.m9471a(str);
            Toast.makeText(ManagerApp.m7917h(), str, 0).show();
        }
    }

    public static void m9470a(@Nullable VolleyError volleyError, String str) {
    }

    @NonNull
    public static String m9468a(@Nullable VolleyError volleyError) {
        if (volleyError == null) {
            return BuildConfig.FLAVOR;
        }
        try {
            return new String(volleyError.f189a.f244b, "utf-8");
        } catch (Exception e) {
            return BuildConfig.FLAVOR;
        }
    }
}
