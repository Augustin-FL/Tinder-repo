package com.facebook.stetho.inspector.elements;

public final class ObjectDescriptor extends Descriptor {
    public void hook(Object obj) {
    }

    public void unhook(Object obj) {
    }

    public NodeType getNodeType(Object obj) {
        return NodeType.ELEMENT_NODE;
    }

    public String getNodeName(Object obj) {
        return obj.getClass().getName();
    }

    public String getLocalName(Object obj) {
        return getNodeName(obj);
    }

    public String getNodeValue(Object obj) {
        return null;
    }

    public int getChildCount(Object obj) {
        return 0;
    }

    public Object getChildAt(Object obj, int i) {
        throw new IndexOutOfBoundsException();
    }

    public void copyAttributes(Object obj, AttributeAccumulator attributeAccumulator) {
    }
}
