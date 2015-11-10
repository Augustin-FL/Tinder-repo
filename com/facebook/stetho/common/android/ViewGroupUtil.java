package com.facebook.stetho.common.android;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.OnHierarchyChangeListener;
import com.facebook.stetho.common.ReflectionUtil;
import java.lang.reflect.Field;

public final class ViewGroupUtil {
    private static final Field sOnHierarchyChangeListenerField;

    static {
        sOnHierarchyChangeListenerField = tryGetOnHierarchyChangeListenerField();
    }

    private static Field tryGetOnHierarchyChangeListenerField() {
        Field tryGetDeclaredField = ReflectionUtil.tryGetDeclaredField(ViewGroup.class, "mOnHierarchyChangeListener");
        if (tryGetDeclaredField != null) {
            tryGetDeclaredField.setAccessible(true);
        }
        return tryGetDeclaredField;
    }

    private ViewGroupUtil() {
    }

    public static int findChildIndex(ViewGroup viewGroup, View view) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (viewGroup.getChildAt(i) == view) {
                return i;
            }
        }
        return -1;
    }

    public static OnHierarchyChangeListener tryGetOnHierarchyChangeListenerHack(ViewGroup viewGroup) {
        if (sOnHierarchyChangeListenerField == null) {
            return null;
        }
        return (OnHierarchyChangeListener) ReflectionUtil.getFieldValue(sOnHierarchyChangeListenerField, viewGroup);
    }
}
