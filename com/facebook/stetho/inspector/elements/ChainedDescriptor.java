package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.common.Util;

public abstract class ChainedDescriptor<E> extends Descriptor {
    private Descriptor mSuper;

    final void setSuper(Descriptor descriptor) {
        Util.throwIfNull(descriptor);
        if (descriptor == this.mSuper) {
            return;
        }
        if (this.mSuper != null) {
            throw new IllegalStateException();
        }
        this.mSuper = descriptor;
    }

    public final Descriptor getSuper() {
        return this.mSuper;
    }

    public final void hook(Object obj) {
        this.mSuper.hook(obj);
        onHook(obj);
    }

    protected void onHook(E e) {
    }

    public final void unhook(Object obj) {
        onUnhook(obj);
        this.mSuper.unhook(obj);
    }

    protected void onUnhook(E e) {
    }

    public final NodeType getNodeType(Object obj) {
        return onGetNodeType(obj);
    }

    protected NodeType onGetNodeType(E e) {
        return this.mSuper.getNodeType(e);
    }

    public final String getNodeName(Object obj) {
        return onGetNodeName(obj);
    }

    protected String onGetNodeName(E e) {
        return this.mSuper.getNodeName(e);
    }

    public final String getLocalName(Object obj) {
        return onGetLocalName(obj);
    }

    protected String onGetLocalName(E e) {
        return this.mSuper.getLocalName(e);
    }

    public final String getNodeValue(Object obj) {
        return onGetNodeValue(obj);
    }

    public String onGetNodeValue(E e) {
        return this.mSuper.getNodeValue(e);
    }

    public final int getChildCount(Object obj) {
        return this.mSuper.getChildCount(obj) + onGetChildCount(obj);
    }

    protected int onGetChildCount(E e) {
        return 0;
    }

    public final Object getChildAt(Object obj, int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException();
        }
        int childCount = this.mSuper.getChildCount(obj);
        if (i < childCount) {
            return this.mSuper.getChildAt(obj, i);
        }
        int onGetChildCount = onGetChildCount(obj);
        childCount = i - childCount;
        if (childCount >= 0 && childCount < onGetChildCount) {
            return onGetChildAt(obj, childCount);
        }
        throw new IndexOutOfBoundsException();
    }

    protected Object onGetChildAt(E e, int i) {
        throw new IndexOutOfBoundsException();
    }

    public final void copyAttributes(Object obj, AttributeAccumulator attributeAccumulator) {
        this.mSuper.copyAttributes(obj, attributeAccumulator);
        onCopyAttributes(obj, attributeAccumulator);
    }

    protected void onCopyAttributes(E e, AttributeAccumulator attributeAccumulator) {
    }
}
