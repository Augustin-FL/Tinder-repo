package com.facebook.stetho.inspector.elements.android;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.inspector.elements.ChainedDescriptor;
import com.facebook.stetho.inspector.elements.Descriptor;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;

final class WindowDescriptor extends ChainedDescriptor<Window> implements HighlightableDescriptor {
    private final Map<Window, ElementContext> mElementToContextMap;

    private class ElementContext {
        private ElementContext() {
        }

        public void hook(Window window) {
        }

        public void unhook() {
        }
    }

    @TargetApi(12)
    private final class ElementContextHCMR1 extends ElementContext implements Callback {
        private View mDecorView;
        private Callback mInnerCallback;
        private Window mWindow;

        private ElementContextHCMR1() {
            super(null);
        }

        public void hook(Window window) {
            this.mWindow = window;
            this.mInnerCallback = this.mWindow.getCallback();
            this.mWindow.setCallback(this);
            this.mDecorView = this.mWindow.peekDecorView();
        }

        public void unhook() {
            if (this.mWindow != null) {
                if (this.mInnerCallback != null) {
                    if (this.mWindow.getCallback() == this) {
                        this.mWindow.setCallback(this.mInnerCallback);
                    }
                    this.mInnerCallback = null;
                }
                this.mDecorView = null;
                this.mWindow = null;
            }
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return (this.mWindow == null || this.mInnerCallback == null) ? false : this.mInnerCallback.dispatchKeyEvent(keyEvent);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return (this.mWindow == null || this.mInnerCallback == null) ? false : this.mInnerCallback.dispatchKeyShortcutEvent(keyEvent);
        }

        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return (this.mWindow == null || this.mInnerCallback == null) ? false : this.mInnerCallback.dispatchTouchEvent(motionEvent);
        }

        public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
            return (this.mWindow == null || this.mInnerCallback == null) ? false : this.mInnerCallback.dispatchTrackballEvent(motionEvent);
        }

        public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
            return (this.mWindow == null || this.mInnerCallback == null) ? false : this.mInnerCallback.dispatchGenericMotionEvent(motionEvent);
        }

        public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            return (this.mWindow == null || this.mInnerCallback == null) ? false : this.mInnerCallback.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }

        public View onCreatePanelView(int i) {
            return (this.mWindow == null || this.mInnerCallback == null) ? null : this.mInnerCallback.onCreatePanelView(i);
        }

        public boolean onCreatePanelMenu(int i, Menu menu) {
            return (this.mWindow == null || this.mInnerCallback == null) ? false : this.mInnerCallback.onCreatePanelMenu(i, menu);
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            return (this.mWindow == null || this.mInnerCallback == null) ? false : this.mInnerCallback.onPreparePanel(i, view, menu);
        }

        public boolean onMenuOpened(int i, Menu menu) {
            return (this.mWindow == null || this.mInnerCallback == null) ? false : this.mInnerCallback.onMenuOpened(i, menu);
        }

        public boolean onMenuItemSelected(int i, MenuItem menuItem) {
            return (this.mWindow == null || this.mInnerCallback == null) ? false : this.mInnerCallback.onMenuItemSelected(i, menuItem);
        }

        public void onWindowAttributesChanged(LayoutParams layoutParams) {
            if (this.mWindow != null && this.mInnerCallback != null) {
                this.mInnerCallback.onWindowAttributesChanged(layoutParams);
            }
        }

        public void onContentChanged() {
            if (this.mWindow != null) {
                if (this.mInnerCallback != null) {
                    this.mInnerCallback.onContentChanged();
                }
                if (this.mDecorView == null) {
                    this.mDecorView = this.mWindow.peekDecorView();
                    if (this.mDecorView != null) {
                        WindowDescriptor.this.registerDecorView(this.mDecorView);
                        WindowDescriptor.this.getHost().onChildInserted(this.mWindow, null, this.mDecorView);
                    }
                }
            }
        }

        public void onWindowFocusChanged(boolean z) {
            if (this.mWindow != null && this.mInnerCallback != null) {
                this.mInnerCallback.onWindowFocusChanged(z);
            }
        }

        public void onAttachedToWindow() {
            if (this.mWindow != null && this.mInnerCallback != null) {
                this.mInnerCallback.onAttachedToWindow();
            }
        }

        public void onDetachedFromWindow() {
            if (this.mWindow != null && this.mInnerCallback != null) {
                this.mInnerCallback.onDetachedFromWindow();
            }
        }

        public void onPanelClosed(int i, Menu menu) {
            if (this.mWindow != null && this.mInnerCallback != null) {
                this.mInnerCallback.onPanelClosed(i, menu);
            }
        }

        public boolean onSearchRequested() {
            return (this.mWindow == null || this.mInnerCallback == null) ? false : this.mInnerCallback.onSearchRequested();
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return (this.mWindow == null || this.mInnerCallback == null) ? null : this.mInnerCallback.onWindowStartingActionMode(callback);
        }

        public void onActionModeStarted(ActionMode actionMode) {
            if (this.mWindow != null && this.mInnerCallback != null) {
                this.mInnerCallback.onActionModeStarted(actionMode);
            }
        }

        public void onActionModeFinished(ActionMode actionMode) {
            if (this.mWindow != null && this.mInnerCallback != null) {
                this.mInnerCallback.onActionModeFinished(actionMode);
            }
        }
    }

    WindowDescriptor() {
        this.mElementToContextMap = Collections.synchronizedMap(new IdentityHashMap());
    }

    protected void onHook(Window window) {
        ElementContext newElementContext = newElementContext();
        newElementContext.hook(window);
        this.mElementToContextMap.put(window, newElementContext);
    }

    protected void onUnhook(Window window) {
        ((ElementContext) this.mElementToContextMap.remove(window)).unhook();
    }

    protected int onGetChildCount(Window window) {
        return window.peekDecorView() != null ? 1 : 0;
    }

    protected Object onGetChildAt(Window window, int i) {
        View peekDecorView = window.peekDecorView();
        if (peekDecorView == null) {
            throw new IndexOutOfBoundsException();
        }
        registerDecorView(peekDecorView);
        return peekDecorView;
    }

    public View getViewForHighlighting(Object obj) {
        return ((Window) obj).peekDecorView();
    }

    private void registerDecorView(View view) {
        if (view instanceof ViewGroup) {
            Descriptor descriptor = getHost().getDescriptor(view);
            if (descriptor instanceof ViewGroupDescriptor) {
                ((ViewGroupDescriptor) descriptor).registerDecorView((ViewGroup) view);
            }
        }
    }

    private ElementContext newElementContext() {
        if (VERSION.SDK_INT >= 12) {
            return new ElementContextHCMR1();
        }
        LogUtil.m947w("Running on pre-HCMR1: must manually reload inspector after Window installs DecorView");
        return new ElementContext();
    }
}
