package com.facebook.stetho.inspector.elements.android;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import com.facebook.stetho.common.StringUtil;
import com.facebook.stetho.inspector.elements.ChainedDescriptor;

final class ActivityDescriptor extends ChainedDescriptor<Activity> implements HighlightableDescriptor {
    ActivityDescriptor() {
    }

    protected String onGetNodeName(Activity activity) {
        return StringUtil.removePrefix(activity.getClass().getName(), "android.app.");
    }

    protected int onGetChildCount(Activity activity) {
        return activity.getWindow() != null ? 1 : 0;
    }

    protected Object onGetChildAt(Activity activity, int i) {
        Window window = activity.getWindow();
        if (window != null) {
            return window;
        }
        throw new IndexOutOfBoundsException();
    }

    public View getViewForHighlighting(Object obj) {
        if (getHost() instanceof AndroidDescriptorHost) {
            return ((AndroidDescriptorHost) getHost()).getHighlightingView(((Activity) obj).getWindow());
        }
        return null;
    }
}
