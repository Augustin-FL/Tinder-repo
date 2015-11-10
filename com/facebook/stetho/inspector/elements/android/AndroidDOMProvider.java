package com.facebook.stetho.inspector.elements.android;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.facebook.stetho.common.Predicate;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.common.android.HandlerUtil;
import com.facebook.stetho.common.android.ViewUtil;
import com.facebook.stetho.inspector.elements.DOMProvider;
import com.facebook.stetho.inspector.elements.DOMProvider.Listener;
import com.facebook.stetho.inspector.elements.Descriptor;
import com.facebook.stetho.inspector.elements.DescriptorMap;
import com.facebook.stetho.inspector.elements.NodeDescriptor;
import com.facebook.stetho.inspector.elements.ObjectDescriptor;
import java.util.ArrayList;
import java.util.List;

final class AndroidDOMProvider implements DOMProvider, AndroidDescriptorHost {
    private static final int INSPECT_HOVER_COLOR = 1077952767;
    private static final int INSPECT_OVERLAY_COLOR = 1090519039;
    private final Application mApplication;
    private final AndroidDOMRoot mDOMRoot;
    private final DescriptorMap mDescriptorMap;
    private final Handler mHandler;
    private final ViewHighlighter mHighlighter;
    private final InspectModeHandler mInspectModeHandler;
    private Listener mListener;

    private final class InspectModeHandler {
        private final Runnable mDisableOnUiThreadRunnable;
        private final Runnable mEnableOnUiThreadRunnable;
        private List<View> mOverlays;
        private final Predicate<View> mViewSelector;

        /* renamed from: com.facebook.stetho.inspector.elements.android.AndroidDOMProvider.InspectModeHandler.1 */
        class C06661 implements Runnable {
            C06661() {
            }

            public void run() {
                InspectModeHandler.this.enableOnUiThread();
            }
        }

        /* renamed from: com.facebook.stetho.inspector.elements.android.AndroidDOMProvider.InspectModeHandler.2 */
        class C06672 implements Runnable {
            C06672() {
            }

            public void run() {
                InspectModeHandler.this.disableOnUiThread();
            }
        }

        /* renamed from: com.facebook.stetho.inspector.elements.android.AndroidDOMProvider.InspectModeHandler.3 */
        class C06683 implements Predicate<View> {
            C06683() {
            }

            public boolean apply(View view) {
                return !(view instanceof DOMHiddenView);
            }
        }

        private final class OverlayView extends DOMHiddenView {
            public OverlayView(Context context) {
                super(context);
            }

            protected void onDraw(Canvas canvas) {
                canvas.drawColor(AndroidDOMProvider.INSPECT_OVERLAY_COLOR);
                super.onDraw(canvas);
            }

            public boolean onTouchEvent(MotionEvent motionEvent) {
                if (getParent() instanceof View) {
                    View hitTest = ViewUtil.hitTest((View) getParent(), motionEvent.getX(), motionEvent.getY(), InspectModeHandler.this.mViewSelector);
                    if (!(motionEvent.getAction() == 3 || hitTest == null)) {
                        AndroidDOMProvider.this.mHighlighter.setHighlightedView(hitTest, AndroidDOMProvider.INSPECT_HOVER_COLOR);
                        if (motionEvent.getAction() == 1) {
                            AndroidDOMProvider.this.mListener.onInspectRequested(hitTest);
                        }
                    }
                }
                return true;
            }
        }

        private InspectModeHandler() {
            this.mEnableOnUiThreadRunnable = new C06661();
            this.mDisableOnUiThreadRunnable = new C06672();
            this.mViewSelector = new C06683();
        }

        public void enable() {
            AndroidDOMProvider.this.mHandler.post(this.mEnableOnUiThreadRunnable);
        }

        private void enableOnUiThread() {
            if (this.mOverlays != null) {
                disableOnUiThread();
            }
            this.mOverlays = new ArrayList();
            List access$400 = AndroidDOMProvider.this.collectWindows();
            for (int i = 0; i < access$400.size(); i++) {
                Window window = (Window) access$400.get(i);
                if (window.peekDecorView() instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) window.peekDecorView();
                    View overlayView = new OverlayView(AndroidDOMProvider.this.mApplication);
                    LayoutParams layoutParams = new WindowManager.LayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    viewGroup.addView(overlayView, layoutParams);
                    viewGroup.bringChildToFront(overlayView);
                    this.mOverlays.add(overlayView);
                }
            }
        }

        public void disable() {
            AndroidDOMProvider.this.mHandler.post(this.mDisableOnUiThreadRunnable);
        }

        private void disableOnUiThread() {
            if (this.mOverlays != null) {
                for (int i = 0; i < this.mOverlays.size(); i++) {
                    View view = (View) this.mOverlays.get(i);
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                this.mOverlays = null;
            }
        }
    }

    public AndroidDOMProvider(Application application) {
        this.mApplication = (Application) Util.throwIfNull(application);
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mDOMRoot = new AndroidDOMRoot(application);
        this.mDescriptorMap = new DescriptorMap().beginInit().register(Activity.class, new ActivityDescriptor()).register(AndroidDOMRoot.class, this.mDOMRoot).register(Application.class, new ApplicationDescriptor());
        FragmentDescriptor.register(this.mDescriptorMap).register(Object.class, new ObjectDescriptor()).register(TextView.class, new TextViewDescriptor()).register(View.class, new ViewDescriptor()).register(ViewGroup.class, new ViewGroupDescriptor()).register(Window.class, new WindowDescriptor()).setHost(this).endInit();
        this.mHighlighter = ViewHighlighter.newInstance();
        this.mInspectModeHandler = new InspectModeHandler();
    }

    public void dispose() {
        this.mHighlighter.clearHighlight();
        this.mInspectModeHandler.disable();
    }

    public void setListener(Listener listener) {
        this.mListener = listener;
    }

    public boolean postAndWait(Runnable runnable) {
        return HandlerUtil.postAndWait(this.mHandler, runnable);
    }

    public Object getRootElement() {
        return this.mDOMRoot;
    }

    public NodeDescriptor getNodeDescriptor(Object obj) {
        return getDescriptor(obj);
    }

    public void highlightElement(Object obj, int i) {
        View highlightingView = getHighlightingView(obj);
        if (highlightingView == null) {
            this.mHighlighter.clearHighlight();
        } else {
            this.mHighlighter.setHighlightedView(highlightingView, i);
        }
    }

    public void hideHighlight() {
        this.mHighlighter.clearHighlight();
    }

    public void setInspectModeEnabled(boolean z) {
        if (z) {
            this.mInspectModeHandler.enable();
        } else {
            this.mInspectModeHandler.disable();
        }
    }

    public Descriptor getDescriptor(Object obj) {
        return obj == null ? null : this.mDescriptorMap.get(obj.getClass());
    }

    public void onAttributeModified(Object obj, String str, String str2) {
        this.mListener.onAttributeModified(obj, str, str2);
    }

    public void onAttributeRemoved(Object obj, String str) {
        this.mListener.onAttributeRemoved(obj, str);
    }

    public void onChildInserted(Object obj, Object obj2, Object obj3) {
        this.mListener.onChildInserted(obj, obj2, obj3);
    }

    public void onChildRemoved(Object obj, Object obj2) {
        this.mListener.onChildRemoved(obj, obj2);
    }

    public View getHighlightingView(Object obj) {
        if (obj == null) {
            return null;
        }
        Descriptor descriptor = null;
        Class cls = obj.getClass();
        View view = null;
        while (view == null && cls != null) {
            Descriptor descriptor2 = this.mDescriptorMap.get(cls);
            if (descriptor2 == null) {
                return null;
            }
            if (descriptor2 != descriptor && (descriptor2 instanceof HighlightableDescriptor)) {
                view = ((HighlightableDescriptor) descriptor2).getViewForHighlighting(obj);
            }
            cls = cls.getSuperclass();
            descriptor = descriptor2;
        }
        return view;
    }

    private List<Window> collectWindows() {
        ArrayList arrayList = new ArrayList();
        Descriptor descriptor = getDescriptor(this.mApplication);
        if (descriptor == null) {
            return arrayList;
        }
        int childCount = descriptor.getChildCount(this.mApplication);
        for (int i = 0; i < childCount; i++) {
            Activity activity = (Activity) descriptor.getChildAt(this.mApplication, i);
            Descriptor descriptor2 = getDescriptor(activity);
            if (descriptor2 != null) {
                int childCount2 = descriptor2.getChildCount(activity);
                for (int i2 = 0; i2 < childCount2; i2++) {
                    arrayList.add((Window) descriptor2.getChildAt(activity, i2));
                }
            }
        }
        return arrayList;
    }
}
