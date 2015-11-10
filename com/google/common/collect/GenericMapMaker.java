package com.google.common.collect;

import com.google.common.base.C1647e;
import com.google.common.collect.MapMaker.C1761a;

public abstract class GenericMapMaker<K0, V0> {
    C1761a<K0, V0> f2251a;

    enum NullListener implements C1761a<Object, Object> {
        INSTANCE;

        public void m3759a(RemovalNotification<Object, Object> removalNotification) {
        }
    }

    GenericMapMaker() {
    }

    <K extends K0, V extends V0> C1761a<K, V> m3760a() {
        return (C1761a) C1647e.m3075b(this.f2251a, NullListener.INSTANCE);
    }
}
