package com.facebook.stetho.common.android;

import android.app.Activity;
import com.facebook.stetho.common.LogUtil;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class ApplicationUtil {
    private ApplicationUtil() {
    }

    public static List<Activity> getAllActivities() {
        try {
            return getAllActivitiesHack();
        } catch (Throwable e) {
            LogUtil.m949w(e, "Cannot retrieve list of Activity instances. UI inspection may not work!");
            return Collections.emptyList();
        }
    }

    private static List<Activity> getAllActivitiesHack() throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException, IllegalAccessException, InvocationTargetException {
        Class cls = Class.forName("android.app.ActivityThread");
        Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
        Field declaredField = cls.getDeclaredField("mActivities");
        declaredField.setAccessible(true);
        Map map = (Map) declaredField.get(invoke);
        List<Activity> arrayList = new ArrayList(map.size());
        for (Object next : map.values()) {
            Field declaredField2 = next.getClass().getDeclaredField("activity");
            declaredField2.setAccessible(true);
            arrayList.add((Activity) declaredField2.get(next));
        }
        return arrayList;
    }
}
