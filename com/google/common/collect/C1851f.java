package com.google.common.collect;

import com.google.common.base.C1430c;
import com.google.common.base.C1640d;
import com.google.common.base.C1650g;
import java.util.Collection;

/* renamed from: com.google.common.collect.f */
public final class C1851f {
    static final C1640d f2500a;

    /* renamed from: com.google.common.collect.f.1 */
    static class C18501 implements C1430c<Object, Object> {
        final /* synthetic */ Collection f2499a;

        C18501(Collection collection) {
            this.f2499a = collection;
        }

        public Object m4262a(Object obj) {
            return obj == this.f2499a ? "(this Collection)" : obj;
        }
    }

    static boolean m4266a(Collection<?> collection, Object obj) {
        boolean z = false;
        C1650g.m3080a((Object) collection);
        try {
            z = collection.contains(obj);
        } catch (ClassCastException e) {
        } catch (NullPointerException e2) {
        }
        return z;
    }

    static boolean m4267a(Collection<?> collection, Collection<?> collection2) {
        C1650g.m3080a((Object) collection);
        for (Object contains : collection2) {
            if (!collection.contains(contains)) {
                return false;
            }
        }
        return true;
    }

    static String m4263a(Collection<?> collection) {
        StringBuilder append = C1851f.m4264a(collection.size()).append('[');
        f2500a.m3052a(append, C1859n.m4278a((Iterable) collection, new C18501(collection)));
        return append.append(']').toString();
    }

    static StringBuilder m4264a(int i) {
        C1650g.m3086a(i >= 0, (Object) "size must be non-negative");
        return new StringBuilder((int) Math.min(((long) i) * 8, 1073741824));
    }

    static <T> Collection<T> m4265a(Iterable<T> iterable) {
        return (Collection) iterable;
    }

    static {
        f2500a = C1640d.m3043a(", ").m3054b("null");
    }
}
