package com.facebook.stetho.inspector.elements;

public interface DOMProvider {

    public interface Factory {
        DOMProvider create();
    }

    public interface Listener {
        void onAttributeModified(Object obj, String str, String str2);

        void onAttributeRemoved(Object obj, String str);

        void onChildInserted(Object obj, Object obj2, Object obj3);

        void onChildRemoved(Object obj, Object obj2);

        void onInspectRequested(Object obj);
    }

    void dispose();

    NodeDescriptor getNodeDescriptor(Object obj);

    Object getRootElement();

    void hideHighlight();

    void highlightElement(Object obj, int i);

    boolean postAndWait(Runnable runnable);

    void setInspectModeEnabled(boolean z);

    void setListener(Listener listener);
}
