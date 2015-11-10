package com.facebook.stetho.common.android;

import android.app.Activity;

public interface FragmentActivityAccessor {
    Object getFragmentManager(Activity activity);

    Object getSupportFragmentManager(Activity activity);
}
