package com.facebook.stetho.inspector.elements;

public interface NodeDescriptor {
    void copyAttributes(Object obj, AttributeAccumulator attributeAccumulator);

    Object getChildAt(Object obj, int i);

    int getChildCount(Object obj);

    String getLocalName(Object obj);

    String getNodeName(Object obj);

    NodeType getNodeType(Object obj);

    String getNodeValue(Object obj);

    void hook(Object obj);

    void unhook(Object obj);
}
