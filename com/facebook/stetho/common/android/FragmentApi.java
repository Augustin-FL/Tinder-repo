package com.facebook.stetho.common.android;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import com.facebook.stetho.common.ReflectionUtil;
import com.facebook.stetho.common.Util;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public final class FragmentApi {
    private static final FragmentActivityAccessor sActivityAccessor;
    private static final Class<?> sActivityClass;
    private static final FragmentAccessor sFragmentAccessor;
    private static final Class<?> sFragmentClass;
    private static final FragmentManagerAccessor sFragmentManagerAccessor;
    private static final Class<?> sFragmentManagerClass;
    private static final FragmentAccessor sSupportFragmentAccessor;
    private static final FragmentActivityAccessor sSupportFragmentActivityAccessor;
    private static final Class<?> sSupportFragmentActivityClass;
    private static final Class<?> sSupportFragmentClass;
    private static final FragmentManagerAccessor sSupportFragmentManagerAccessor;
    private static final Class<?> sSupportFragmentManagerClass;

    private static final class ReflectionFragmentAccessor implements FragmentAccessor {
        private final Field mFieldMChildFragmentManager;
        private final Method mMethodGetFragmentManager;
        private final Method mMethodGetId;
        private final Method mMethodGetResources;
        private final Method mMethodGetTag;
        private final Method mMethodGetView;

        public ReflectionFragmentAccessor(Class<?> cls) {
            Util.throwIfNull(cls);
            this.mFieldMChildFragmentManager = ReflectionUtil.tryGetDeclaredField(cls, "mChildFragmentManager");
            if (this.mFieldMChildFragmentManager != null) {
                this.mFieldMChildFragmentManager.setAccessible(true);
            }
            this.mMethodGetFragmentManager = ReflectionUtil.getMethod(cls, "getFragmentManager");
            this.mMethodGetResources = ReflectionUtil.getMethod(cls, "getResources");
            this.mMethodGetId = ReflectionUtil.getMethod(cls, "getId");
            this.mMethodGetTag = ReflectionUtil.getMethod(cls, "getTag");
            this.mMethodGetView = ReflectionUtil.getMethod(cls, "getView");
        }

        public Object getFragmentManager(Object obj) {
            return ReflectionUtil.invokeMethod(this.mMethodGetFragmentManager, obj);
        }

        public Resources getResources(Object obj) {
            return (Resources) ReflectionUtil.invokeMethod(this.mMethodGetResources, obj);
        }

        public int getId(Object obj) {
            return ((Integer) ReflectionUtil.invokeMethod(this.mMethodGetId, obj)).intValue();
        }

        public String getTag(Object obj) {
            return (String) ReflectionUtil.invokeMethod(this.mMethodGetTag, obj);
        }

        public View getView(Object obj) {
            return (View) ReflectionUtil.invokeMethod(this.mMethodGetView, obj);
        }

        public Object peekChildFragmentManager(Object obj) {
            return this.mFieldMChildFragmentManager != null ? ReflectionUtil.getFieldValue(this.mFieldMChildFragmentManager, obj) : null;
        }
    }

    private static final class ReflectionFragmentActivityAccessor implements FragmentActivityAccessor {
        private final Method mMethodGetFragmentManager;
        private final Method mMethodGetSupportFragmentManager;

        public ReflectionFragmentActivityAccessor(Class<?> cls) {
            this.mMethodGetFragmentManager = ReflectionUtil.tryGetMethod(cls, "getFragmentManager");
            this.mMethodGetSupportFragmentManager = ReflectionUtil.tryGetMethod(cls, "getSupportFragmentManager");
        }

        public Object getFragmentManager(Activity activity) {
            return this.mMethodGetFragmentManager != null ? ReflectionUtil.invokeMethod(this.mMethodGetFragmentManager, activity) : null;
        }

        public Object getSupportFragmentManager(Activity activity) {
            return this.mMethodGetSupportFragmentManager != null ? ReflectionUtil.invokeMethod(this.mMethodGetSupportFragmentManager, activity) : null;
        }
    }

    private static class ReflectionFragmentManagerAccessor implements FragmentManagerAccessor {
        private final Field mFieldMAdded;

        public ReflectionFragmentManagerAccessor(Class<?> cls) {
            Util.throwIfNull(cls);
            this.mFieldMAdded = ReflectionUtil.tryGetDeclaredField(cls, "mAdded");
            if (this.mFieldMAdded != null) {
                this.mFieldMAdded.setAccessible(true);
            }
        }

        public List<?> getAddedFragments(Object obj) {
            return this.mFieldMAdded != null ? (List) ReflectionUtil.getFieldValue(this.mFieldMAdded, obj) : null;
        }
    }

    static {
        FragmentActivityAccessor reflectionFragmentActivityAccessor;
        FragmentManagerAccessor reflectionFragmentManagerAccessor;
        FragmentAccessor reflectionFragmentAccessor;
        FragmentManagerAccessor fragmentManagerAccessor = null;
        sSupportFragmentClass = ReflectionUtil.tryGetClassForName("android.support.v4.app.Fragment");
        sSupportFragmentAccessor = sSupportFragmentClass != null ? new ReflectionFragmentAccessor(sSupportFragmentClass) : null;
        sSupportFragmentActivityClass = ReflectionUtil.tryGetClassForName("android.support.v4.app.FragmentActivity");
        if (sSupportFragmentActivityClass != null) {
            reflectionFragmentActivityAccessor = new ReflectionFragmentActivityAccessor(sSupportFragmentActivityClass);
        } else {
            reflectionFragmentActivityAccessor = null;
        }
        sSupportFragmentActivityAccessor = reflectionFragmentActivityAccessor;
        sSupportFragmentManagerClass = ReflectionUtil.tryGetClassForName("android.support.v4.app.FragmentManagerImpl");
        if (sSupportFragmentManagerClass != null) {
            reflectionFragmentManagerAccessor = new ReflectionFragmentManagerAccessor(sSupportFragmentManagerClass);
        } else {
            reflectionFragmentManagerAccessor = null;
        }
        sSupportFragmentManagerAccessor = reflectionFragmentManagerAccessor;
        sFragmentClass = ReflectionUtil.tryGetClassForName("android.app.Fragment");
        if (sFragmentClass != null) {
            reflectionFragmentAccessor = new ReflectionFragmentAccessor(sFragmentClass);
        } else {
            reflectionFragmentAccessor = null;
        }
        sFragmentAccessor = reflectionFragmentAccessor;
        sActivityClass = ReflectionUtil.tryGetClassForName("android.app.Activity");
        if (sActivityClass != null) {
            reflectionFragmentActivityAccessor = new ReflectionFragmentActivityAccessor(sActivityClass);
        } else {
            reflectionFragmentActivityAccessor = null;
        }
        sActivityAccessor = reflectionFragmentActivityAccessor;
        sFragmentManagerClass = ReflectionUtil.tryGetClassForName("android.app.FragmentManagerImpl");
        if (sFragmentManagerClass != null) {
            fragmentManagerAccessor = new ReflectionFragmentManagerAccessor(sFragmentManagerClass);
        }
        sFragmentManagerAccessor = fragmentManagerAccessor;
    }

    public static Class<?> tryGetFragmentClass() {
        return sFragmentClass;
    }

    public static Class<?> tryGetSupportFragmentClass() {
        return sSupportFragmentClass;
    }

    public static FragmentAccessor getFragmentAccessorFor(Object obj) {
        Util.throwIfNull(obj);
        if (sSupportFragmentClass != null && sSupportFragmentClass.isAssignableFrom(obj.getClass())) {
            return sSupportFragmentAccessor;
        }
        if (sFragmentClass != null && sFragmentClass.isAssignableFrom(obj.getClass())) {
            return sFragmentAccessor;
        }
        throw new IllegalArgumentException();
    }

    public static FragmentActivityAccessor tryGetFragmentActivityAccessorFor(Object obj) {
        Util.throwIfNull(obj);
        if (sSupportFragmentActivityClass != null && sSupportFragmentActivityClass.isAssignableFrom(obj.getClass())) {
            return sSupportFragmentActivityAccessor;
        }
        if (sActivityClass == null || !sActivityClass.isAssignableFrom(obj.getClass())) {
            return null;
        }
        return sActivityAccessor;
    }

    public static FragmentManagerAccessor getFragmentManagerAccessorFor(Object obj) {
        if (sSupportFragmentManagerClass != null && sSupportFragmentManagerClass.isAssignableFrom(obj.getClass())) {
            return sSupportFragmentManagerAccessor;
        }
        if (sFragmentManagerClass != null && sFragmentManagerClass.isAssignableFrom(obj.getClass())) {
            return sFragmentManagerAccessor;
        }
        throw new IllegalArgumentException();
    }
}
