package com.facebook.stetho.inspector.elements.android;

import android.app.Application;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.elements.DOMProvider;
import com.facebook.stetho.inspector.elements.DOMProvider.Factory;

public class AndroidDOMProviderFactory implements Factory {
    private final Application mApplication;

    public AndroidDOMProviderFactory(Application application) {
        this.mApplication = (Application) Util.throwIfNull(application);
    }

    public DOMProvider create() {
        return new AndroidDOMProvider(this.mApplication);
    }
}
