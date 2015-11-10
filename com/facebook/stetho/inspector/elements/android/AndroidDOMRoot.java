package com.facebook.stetho.inspector.elements.android;

import android.app.Application;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.elements.ChainedDescriptor;
import com.facebook.stetho.inspector.elements.NodeType;

final class AndroidDOMRoot extends ChainedDescriptor<AndroidDOMRoot> {
    private final Application mApplication;

    public AndroidDOMRoot(Application application) {
        this.mApplication = (Application) Util.throwIfNull(application);
    }

    protected NodeType onGetNodeType(AndroidDOMRoot androidDOMRoot) {
        return NodeType.DOCUMENT_NODE;
    }

    protected String onGetNodeName(AndroidDOMRoot androidDOMRoot) {
        return "root";
    }

    protected int onGetChildCount(AndroidDOMRoot androidDOMRoot) {
        return 1;
    }

    protected Object onGetChildAt(AndroidDOMRoot androidDOMRoot, int i) {
        if (i == 0) {
            return this.mApplication;
        }
        throw new IndexOutOfBoundsException();
    }
}
