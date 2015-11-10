package com.facebook.stetho.inspector.elements.android;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.OnHierarchyChangeListener;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.common.android.FragmentApiUtil;
import com.facebook.stetho.common.android.ViewGroupUtil;
import com.facebook.stetho.inspector.elements.ChainedDescriptor;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;

final class ViewGroupDescriptor extends ChainedDescriptor<ViewGroup> {
    private final Map<ViewGroup, ElementContext> mElementToContextMap;

    private final class ElementContext implements OnHierarchyChangeListener {
        private ViewGroup mElement;
        private OnHierarchyChangeListener mInnerListener;
        private boolean mIsDecorView;
        private final Map<View, Object> mViewToElementMap;

        private ElementContext() {
            this.mViewToElementMap = Collections.synchronizedMap(new IdentityHashMap());
        }

        public void hook(ViewGroup viewGroup) {
            if (this.mInnerListener != null) {
                throw new IllegalStateException();
            }
            this.mElement = (ViewGroup) Util.throwIfNull(viewGroup);
            this.mInnerListener = ViewGroupUtil.tryGetOnHierarchyChangeListenerHack(this.mElement);
            this.mElement.setOnHierarchyChangeListener(this);
        }

        public void unhook() {
            if (this.mElement != null) {
                if (ViewGroupUtil.tryGetOnHierarchyChangeListenerHack(this.mElement) == this) {
                    this.mElement.setOnHierarchyChangeListener(this.mInnerListener);
                } else {
                    this.mElement.setOnHierarchyChangeListener(null);
                }
                this.mInnerListener = null;
                this.mElement = null;
                this.mViewToElementMap.clear();
            }
        }

        public void markDecorView() {
            this.mIsDecorView = true;
        }

        public int getChildCount() {
            if (this.mIsDecorView) {
                return getDecorViewChildCount();
            }
            return this.mElement.getChildCount();
        }

        private boolean isChildVisible(View view) {
            return (this.mIsDecorView && (view instanceof DOMHiddenView)) ? false : true;
        }

        private int getDecorViewChildCount() {
            int i = 0;
            int childCount = this.mElement.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (isChildVisible(this.mElement.getChildAt(i2))) {
                    i++;
                }
            }
            return i;
        }

        public Object getChildAt(int i) {
            if (i < 0 || i >= this.mElement.getChildCount()) {
                throw new IndexOutOfBoundsException();
            } else if (this.mIsDecorView) {
                return getDecorViewChildAt(i);
            } else {
                return getElementForView(this.mElement.getChildAt(i));
            }
        }

        private Object getDecorViewChildAt(int i) {
            int i2 = 0;
            int childCount = this.mElement.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = this.mElement.getChildAt(i3);
                if (isChildVisible(childAt)) {
                    if (i2 == i) {
                        return getElementForView(childAt);
                    }
                    i2++;
                }
            }
            throw new IndexOutOfBoundsException();
        }

        private Object getElementForView(View view) {
            if (view == null) {
                return null;
            }
            View view2 = this.mViewToElementMap.get(view);
            if (view2 != null) {
                return view2;
            }
            view2 = FragmentApiUtil.findFragmentForView(view);
            if (view2 != null) {
                this.mViewToElementMap.put(view, view2);
                return view2;
            }
            this.mViewToElementMap.put(view, view);
            return view;
        }

        public void onChildViewAdded(View view, View view2) {
            if (this.mElement != null) {
                if (this.mInnerListener != null) {
                    this.mInnerListener.onChildViewAdded(view, view2);
                }
                if (isChildVisible(view2) && (view instanceof ViewGroup)) {
                    Object elementForView;
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int findChildIndex = ViewGroupUtil.findChildIndex(viewGroup, view2) - 1; findChildIndex >= 0; findChildIndex--) {
                        View childAt = viewGroup.getChildAt(findChildIndex);
                        if (isChildVisible(childAt)) {
                            elementForView = getElementForView(childAt);
                            break;
                        }
                    }
                    elementForView = null;
                    ViewGroupDescriptor.this.getHost().onChildInserted(view, elementForView, getElementForView(view2));
                }
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            if (this.mElement != null) {
                if (this.mInnerListener != null) {
                    this.mInnerListener.onChildViewRemoved(view, view2);
                }
                if (isChildVisible(view2)) {
                    ViewGroupDescriptor.this.getHost().onChildRemoved(view, getElementForView(view2));
                    this.mViewToElementMap.remove(view2);
                }
            }
        }
    }

    public ViewGroupDescriptor() {
        this.mElementToContextMap = Collections.synchronizedMap(new IdentityHashMap());
    }

    private ElementContext getOrCreateContext(ViewGroup viewGroup) {
        ElementContext elementContext = (ElementContext) this.mElementToContextMap.get(viewGroup);
        if (elementContext != null) {
            return elementContext;
        }
        elementContext = new ElementContext();
        this.mElementToContextMap.put(viewGroup, elementContext);
        return elementContext;
    }

    final void registerDecorView(ViewGroup viewGroup) {
        getOrCreateContext(viewGroup).markDecorView();
    }

    protected void onHook(ViewGroup viewGroup) {
        getOrCreateContext(viewGroup).hook(viewGroup);
    }

    protected void onUnhook(ViewGroup viewGroup) {
        ((ElementContext) this.mElementToContextMap.remove(viewGroup)).unhook();
    }

    protected int onGetChildCount(ViewGroup viewGroup) {
        return ((ElementContext) this.mElementToContextMap.get(viewGroup)).getChildCount();
    }

    protected Object onGetChildAt(ViewGroup viewGroup, int i) {
        return ((ElementContext) this.mElementToContextMap.get(viewGroup)).getChildAt(i);
    }
}
