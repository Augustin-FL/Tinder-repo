package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.common.Util;

public abstract class Descriptor implements NodeDescriptor {
    private Host mHost;

    public interface Host {
        Descriptor getDescriptor(Object obj);

        void onAttributeModified(Object obj, String str, String str2);

        void onAttributeRemoved(Object obj, String str);

        void onChildInserted(Object obj, Object obj2, Object obj3);

        void onChildRemoved(Object obj, Object obj2);
    }

    protected Descriptor() {
    }

    void initialize(Host host) {
        Util.throwIfNull(host);
        Util.throwIfNotNull(this.mHost);
        this.mHost = host;
    }

    boolean isInitialized() {
        return this.mHost != null;
    }

    protected final Host getHost() {
        return this.mHost;
    }
}
