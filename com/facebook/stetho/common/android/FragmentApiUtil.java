package com.facebook.stetho.common.android;

import android.app.Activity;
import android.view.View;
import java.util.List;

public final class FragmentApiUtil {
    private FragmentApiUtil() {
    }

    public static Object findFragmentForView(View view) {
        Activity tryGetActivity = ViewUtil.tryGetActivity(view);
        if (tryGetActivity == null) {
            return null;
        }
        return findFragmentForViewInActivity(tryGetActivity, view);
    }

    private static Object findFragmentForViewInActivity(Activity activity, View view) {
        FragmentActivityAccessor tryGetFragmentActivityAccessorFor = FragmentApi.tryGetFragmentActivityAccessorFor(activity);
        if (tryGetFragmentActivityAccessorFor == null) {
            return null;
        }
        Object supportFragmentManager = tryGetFragmentActivityAccessorFor.getSupportFragmentManager(activity);
        if (supportFragmentManager != null) {
            supportFragmentManager = findFragmentForViewInFragmentManager(supportFragmentManager, view);
            if (supportFragmentManager != null) {
                return supportFragmentManager;
            }
        }
        supportFragmentManager = tryGetFragmentActivityAccessorFor.getFragmentManager(activity);
        if (supportFragmentManager == null) {
            return null;
        }
        supportFragmentManager = findFragmentForViewInFragmentManager(supportFragmentManager, view);
        if (supportFragmentManager != null) {
            return supportFragmentManager;
        }
        return null;
    }

    private static Object findFragmentForViewInFragmentManager(Object obj, View view) {
        List addedFragments = FragmentApi.getFragmentManagerAccessorFor(obj).getAddedFragments(obj);
        if (addedFragments != null) {
            for (int i = 0; i < addedFragments.size(); i++) {
                Object findFragmentForViewInFragment = findFragmentForViewInFragment(addedFragments.get(i), view);
                if (findFragmentForViewInFragment != null) {
                    return findFragmentForViewInFragment;
                }
            }
        }
        return null;
    }

    private static Object findFragmentForViewInFragment(Object obj, View view) {
        FragmentAccessor fragmentAccessorFor = FragmentApi.getFragmentAccessorFor(obj);
        if (fragmentAccessorFor.getView(obj) == view) {
            return obj;
        }
        Object peekChildFragmentManager = fragmentAccessorFor.peekChildFragmentManager(obj);
        if (peekChildFragmentManager != null) {
            return findFragmentForViewInFragmentManager(peekChildFragmentManager, view);
        }
        return null;
    }
}
