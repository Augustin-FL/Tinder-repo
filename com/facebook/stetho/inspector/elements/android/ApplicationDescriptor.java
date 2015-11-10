package com.facebook.stetho.inspector.elements.android;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.common.android.ApplicationUtil;
import com.facebook.stetho.inspector.elements.ChainedDescriptor;
import com.facebook.stetho.inspector.elements.NodeType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

final class ApplicationDescriptor extends ChainedDescriptor<Application> {
    private final Map<Application, ElementContext> mElementToContextMap;

    private abstract class ElementContext {
        public abstract List<Activity> getActivitiesList();

        public abstract void hook(Application application);

        public abstract void unhook();

        private ElementContext() {
        }
    }

    @TargetApi(14)
    private final class ElementContextICS extends ElementContext {
        private List<Activity> mActivities;
        private ActivityLifecycleCallbacks mCallbacks;
        private Application mElement;

        /* renamed from: com.facebook.stetho.inspector.elements.android.ApplicationDescriptor.ElementContextICS.1 */
        class C06701 implements ActivityLifecycleCallbacks {
            C06701() {
            }

            public void onActivityCreated(Activity activity, Bundle bundle) {
                ElementContextICS.this.mActivities.add(0, activity);
                ApplicationDescriptor.this.getHost().onChildInserted(ElementContextICS.this.mElement, null, activity);
            }

            public void onActivityStarted(Activity activity) {
            }

            public void onActivityResumed(Activity activity) {
            }

            public void onActivityPaused(Activity activity) {
            }

            public void onActivityStopped(Activity activity) {
            }

            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            public void onActivityDestroyed(Activity activity) {
                ElementContextICS.this.mActivities.remove(activity);
                ApplicationDescriptor.this.getHost().onChildRemoved(ElementContextICS.this.mElement, activity);
            }
        }

        private ElementContextICS() {
            super(null);
        }

        public void hook(Application application) {
            this.mElement = (Application) Util.throwIfNull(application);
            this.mCallbacks = new C06701();
            this.mElement.registerActivityLifecycleCallbacks(this.mCallbacks);
            this.mActivities = new ArrayList(ApplicationUtil.getAllActivities());
        }

        public void unhook() {
            if (this.mElement != null) {
                if (this.mCallbacks != null) {
                    this.mElement.unregisterActivityLifecycleCallbacks(this.mCallbacks);
                    this.mCallbacks = null;
                }
                this.mElement = null;
            }
        }

        public List<Activity> getActivitiesList() {
            return this.mActivities;
        }
    }

    private final class ElementContextPreICS extends ElementContext {
        private ElementContextPreICS() {
            super(null);
        }

        public void hook(Application application) {
        }

        public void unhook() {
        }

        public List<Activity> getActivitiesList() {
            return ApplicationUtil.getAllActivities();
        }
    }

    ApplicationDescriptor() {
        this.mElementToContextMap = Collections.synchronizedMap(new IdentityHashMap());
    }

    private ElementContext getContext(Application application) {
        return (ElementContext) this.mElementToContextMap.get(application);
    }

    protected void onHook(Application application) {
        ElementContext newElementContext = newElementContext();
        newElementContext.hook(application);
        this.mElementToContextMap.put(application, newElementContext);
    }

    protected void onUnhook(Application application) {
        ((ElementContext) this.mElementToContextMap.remove(application)).unhook();
    }

    protected NodeType onGetNodeType(Application application) {
        return NodeType.ELEMENT_NODE;
    }

    protected int onGetChildCount(Application application) {
        return getContext(application).getActivitiesList().size();
    }

    protected Object onGetChildAt(Application application, int i) {
        return getContext(application).getActivitiesList().get(i);
    }

    private ElementContext newElementContext() {
        if (VERSION.SDK_INT >= 14) {
            return new ElementContextICS();
        }
        LogUtil.m947w("Running on pre-ICS: must manually reload inspector when Activity changes");
        return new ElementContextPreICS();
    }
}
