package com.google.common.cache;

import com.google.common.base.C1650g;
import com.google.common.util.concurrent.C1908e;
import com.google.common.util.concurrent.C1919d;

public abstract class CacheLoader<K, V> {

    public static final class InvalidCacheLoadException extends RuntimeException {
        public InvalidCacheLoadException(String str) {
            super(str);
        }
    }

    public abstract V m2974a(K k) throws Exception;

    protected CacheLoader() {
    }

    public C1908e<V> m2973a(K k, V v) throws Exception {
        C1650g.m3080a((Object) k);
        C1650g.m3080a((Object) v);
        return C1919d.m4473a(m2974a(k));
    }
}
