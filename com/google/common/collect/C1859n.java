package com.google.common.collect;

import com.google.common.base.C1430c;
import com.google.common.base.C1620h;
import com.google.common.base.C1650g;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: com.google.common.collect.n */
public final class C1859n {

    /* renamed from: com.google.common.collect.n.1 */
    static class C18571 extends C1852g<T> {
        final /* synthetic */ Iterable f2504a;
        final /* synthetic */ C1620h f2505b;

        C18571(Iterable iterable, C1620h c1620h) {
            this.f2504a = iterable;
            this.f2505b = c1620h;
        }

        public Iterator<T> iterator() {
            return C1868o.m4292a(this.f2504a.iterator(), this.f2505b);
        }
    }

    /* renamed from: com.google.common.collect.n.2 */
    static class C18582 extends C1852g<T> {
        final /* synthetic */ Iterable f2506a;
        final /* synthetic */ C1430c f2507b;

        C18582(Iterable iterable, C1430c c1430c) {
            this.f2506a = iterable;
            this.f2507b = c1430c;
        }

        public Iterator<T> iterator() {
            return C1868o.m4295a(this.f2506a.iterator(), this.f2507b);
        }
    }

    public static String m4280a(Iterable<?> iterable) {
        return C1868o.m4301b(iterable.iterator());
    }

    public static <T> T m4282b(Iterable<T> iterable) {
        return C1868o.m4302c(iterable.iterator());
    }

    static Object[] m4283c(Iterable<?> iterable) {
        return C1859n.m4284d(iterable).toArray();
    }

    private static <E> Collection<E> m4284d(Iterable<E> iterable) {
        return iterable instanceof Collection ? (Collection) iterable : C1872p.m4311a(iterable.iterator());
    }

    public static <T> boolean m4281a(Collection<T> collection, Iterable<? extends T> iterable) {
        if (iterable instanceof Collection) {
            return collection.addAll(C1851f.m4265a((Iterable) iterable));
        }
        return C1868o.m4297a((Collection) collection, iterable.iterator());
    }

    public static <T> Iterable<T> m4279a(Iterable<T> iterable, C1620h<? super T> c1620h) {
        C1650g.m3080a((Object) iterable);
        C1650g.m3080a((Object) c1620h);
        return new C18571(iterable, c1620h);
    }

    public static <F, T> Iterable<T> m4278a(Iterable<F> iterable, C1430c<? super F, ? extends T> c1430c) {
        C1650g.m3080a((Object) iterable);
        C1650g.m3080a((Object) c1430c);
        return new C18582(iterable, c1430c);
    }
}
