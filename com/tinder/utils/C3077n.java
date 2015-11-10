package com.tinder.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Collection;

/* renamed from: com.tinder.utils.n */
public class C3077n {
    public static <T> int m9401a(T[] tArr) {
        int i = 0;
        for (T t : tArr) {
            if (t != null) {
                i++;
            }
        }
        return i;
    }

    public static float m9399a(float f, float f2, float f3, float f4, float f5) {
        return (((f5 - f3) / (f4 - f2)) * (f - f2)) + f3;
    }

    public static String m9402a(@NonNull Context context, int i, String... strArr) {
        return String.format(context.getString(i), (Object[]) strArr);
    }

    public static int m9400a(@NonNull Activity activity) {
        return ((ActivityManager) activity.getSystemService("activity")).getMemoryClass();
    }

    public static void m9403a(Fragment fragment) {
        try {
            Field declaredField = Fragment.class.getDeclaredField("mSavedFragmentState");
            declaredField.setAccessible(true);
            Bundle bundle = (Bundle) declaredField.get(fragment);
            if (bundle != null) {
                bundle.setClassLoader(Fragment.class.getClassLoader());
            }
        } catch (Exception e) {
            C3095y.m9471a("Could not get mSavedFragmentState field: " + e);
        }
    }

    public static boolean m9406a(@Nullable SoftReference softReference) {
        return (softReference == null || softReference.get() == null) ? false : true;
    }

    public static boolean m9407a(@Nullable WeakReference weakReference) {
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    public static boolean m9405a() {
        return VERSION.SDK_INT >= 21;
    }

    public static boolean m9409b() {
        return VERSION.SDK_INT >= 19;
    }

    public static boolean m9410c() {
        return VERSION.SDK_INT >= 17;
    }

    public static boolean m9411d() {
        return VERSION.SDK_INT >= 16;
    }

    public static boolean m9412e() {
        return VERSION.SDK_INT >= 21;
    }

    public static boolean m9408a(@Nullable Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static void m9404a(@NonNull Fragment fragment, int i, int i2, Intent intent) {
        for (Fragment onActivityResult : fragment.getChildFragmentManager().getFragments()) {
            onActivityResult.onActivityResult(i, i2, intent);
        }
    }
}
