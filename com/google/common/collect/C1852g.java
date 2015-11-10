package com.google.common.collect;

import com.google.common.base.C1620h;
import com.google.common.base.C1650g;
import java.util.Iterator;

/* renamed from: com.google.common.collect.g */
public abstract class C1852g<E> implements Iterable<E> {
    private final Iterable<E> f2501a;

    /* renamed from: com.google.common.collect.g.1 */
    static class C18531 extends C1852g<E> {
        final /* synthetic */ Iterable f2502a;

        C18531(Iterable iterable, Iterable iterable2) {
            this.f2502a = iterable2;
            super(iterable);
        }

        public Iterator<E> iterator() {
            return this.f2502a.iterator();
        }
    }

    protected C1852g() {
        this.f2501a = this;
    }

    C1852g(Iterable<E> iterable) {
        this.f2501a = (Iterable) C1650g.m3080a((Object) iterable);
    }

    public static <E> C1852g<E> m4268a(Iterable<E> iterable) {
        return iterable instanceof C1852g ? (C1852g) iterable : new C18531(iterable, iterable);
    }

    public String toString() {
        return C1859n.m4280a(this.f2501a);
    }

    public final C1852g<E> m4270a(C1620h<? super E> c1620h) {
        return C1852g.m4268a(C1859n.m4279a(this.f2501a, (C1620h) c1620h));
    }

    public final ImmutableSet<E> m4269a() {
        return ImmutableSet.m3671a(this.f2501a);
    }
}
