package com.google.common.p022a;

import com.google.common.cache.C1685e;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.reflect.TypeToken;
import java.util.Set;

/* renamed from: com.google.common.a.a */
public class C1615a {
    private static final C1685e<Class<?>, Set<Class<?>>> f1900a;

    /* renamed from: com.google.common.a.a.1 */
    static class C16141 extends CacheLoader<Class<?>, Set<Class<?>>> {
        C16141() {
        }

        public Set<Class<?>> m2976a(Class<?> cls) {
            return TypeToken.m4360a((Class) cls).m4373e().m4381d();
        }
    }

    static {
        f1900a = CacheBuilder.m3149a().m3172h().m3161a(new C16141());
    }
}
