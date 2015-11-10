package com.facebook.stetho.common.android;

import android.content.res.Resources;
import android.view.View;

public interface FragmentAccessor {
    public static final int NO_ID = -1;

    Object getFragmentManager(Object obj);

    int getId(Object obj);

    Resources getResources(Object obj);

    String getTag(Object obj);

    View getView(Object obj);

    Object peekChildFragmentManager(Object obj);
}
