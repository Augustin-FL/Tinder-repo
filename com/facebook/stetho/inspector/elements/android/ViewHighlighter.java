package com.facebook.stetho.inspector.elements.android;

import android.annotation.TargetApi;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.Util;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

abstract class ViewHighlighter {

    private static final class NoopHighlighter extends ViewHighlighter {
        private NoopHighlighter() {
        }

        public void clearHighlight() {
        }

        public void setHighlightedView(View view, int i) {
        }
    }

    @TargetApi(18)
    private static final class OverlayHighlighter extends ViewHighlighter {
        private AtomicInteger mContentColor;
        private final Handler mHandler;
        private final ColorDrawable mHighlightDrawable;
        private final Runnable mHighlightViewOnUiThreadRunnable;
        private View mHighlightedView;
        private AtomicReference<View> mViewToHighlight;

        /* renamed from: com.facebook.stetho.inspector.elements.android.ViewHighlighter.OverlayHighlighter.1 */
        class C06741 implements Runnable {
            C06741() {
            }

            public void run() {
                OverlayHighlighter.this.highlightViewOnUiThread();
            }
        }

        public OverlayHighlighter() {
            this.mViewToHighlight = new AtomicReference();
            this.mContentColor = new AtomicInteger();
            this.mHighlightViewOnUiThreadRunnable = new C06741();
            this.mHandler = new Handler(Looper.getMainLooper());
            this.mHighlightDrawable = new ColorDrawable();
        }

        public void clearHighlight() {
            setHighlightedViewImpl(null, 0);
        }

        public void setHighlightedView(View view, int i) {
            setHighlightedViewImpl((View) Util.throwIfNull(view), i);
        }

        private void setHighlightedViewImpl(View view, int i) {
            this.mHandler.removeCallbacks(this.mHighlightViewOnUiThreadRunnable);
            this.mViewToHighlight.set(view);
            this.mContentColor.set(i);
            this.mHandler.postDelayed(this.mHighlightViewOnUiThreadRunnable, 100);
        }

        private void highlightViewOnUiThread() {
            View view = (View) this.mViewToHighlight.getAndSet(null);
            if (view != this.mHighlightedView) {
                if (this.mHighlightedView != null) {
                    this.mHighlightedView.getOverlay().remove(this.mHighlightDrawable);
                }
                if (view != null) {
                    this.mHighlightDrawable.setColor(this.mContentColor.get());
                    this.mHighlightDrawable.setBounds(0, 0, view.getWidth(), view.getHeight());
                    view.getOverlay().add(this.mHighlightDrawable);
                    this.mHighlightedView = view;
                }
            }
        }
    }

    public abstract void clearHighlight();

    public abstract void setHighlightedView(View view, int i);

    public static ViewHighlighter newInstance() {
        if (VERSION.SDK_INT >= 18) {
            return new OverlayHighlighter();
        }
        LogUtil.m947w("Running on pre-JBMR2: View highlighting is not supported");
        return new NoopHighlighter();
    }

    protected ViewHighlighter() {
    }
}
