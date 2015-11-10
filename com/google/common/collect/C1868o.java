package com.google.common.collect;

import com.google.common.base.C1430c;
import com.google.common.base.C1620h;
import com.google.common.base.C1640d;
import com.google.common.base.C1647e;
import com.google.common.base.C1650g;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: com.google.common.collect.o */
public final class C1868o {
    static final ad<Object> f2517a;
    private static final Iterator<Object> f2518b;

    /* renamed from: com.google.common.collect.o.1 */
    static class C18601 extends ad<Object> {
        C18601() {
        }

        public boolean hasNext() {
            return false;
        }

        public Object next() {
            throw new NoSuchElementException();
        }

        public boolean hasPrevious() {
            return false;
        }

        public Object previous() {
            throw new NoSuchElementException();
        }

        public int nextIndex() {
            return 0;
        }

        public int previousIndex() {
            return -1;
        }
    }

    /* renamed from: com.google.common.collect.o.2 */
    static class C18612 extends C1771a<T> {
        final /* synthetic */ Object[] f2508a;

        C18612(int i, Object[] objArr) {
            this.f2508a = objArr;
            super(i);
        }

        protected T m4285a(int i) {
            return this.f2508a[i];
        }
    }

    /* renamed from: com.google.common.collect.o.3 */
    static class C18623 extends C1771a<T> {
        final /* synthetic */ Object[] f2509a;
        final /* synthetic */ int f2510b;

        C18623(int i, int i2, Object[] objArr, int i3) {
            this.f2509a = objArr;
            this.f2510b = i3;
            super(i, i2);
        }

        protected T m4286a(int i) {
            return this.f2509a[this.f2510b + i];
        }
    }

    /* renamed from: com.google.common.collect.o.4 */
    static class C18634 extends ac<T> {
        boolean f2511a;
        final /* synthetic */ Object f2512b;

        C18634(Object obj) {
            this.f2512b = obj;
        }

        public boolean hasNext() {
            return !this.f2511a;
        }

        public T next() {
            if (this.f2511a) {
                throw new NoSuchElementException();
            }
            this.f2511a = true;
            return this.f2512b;
        }
    }

    /* renamed from: com.google.common.collect.o.5 */
    static class C18645 implements Iterator<Object> {
        C18645() {
        }

        public boolean hasNext() {
            return false;
        }

        public Object next() {
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new IllegalStateException();
        }
    }

    /* renamed from: com.google.common.collect.o.6 */
    static class C18656 extends ac<T> {
        final /* synthetic */ Iterator f2513a;

        C18656(Iterator it) {
            this.f2513a = it;
        }

        public boolean hasNext() {
            return this.f2513a.hasNext();
        }

        public T next() {
            return this.f2513a.next();
        }
    }

    /* renamed from: com.google.common.collect.o.7 */
    static class C18667 extends AbstractIterator<T> {
        final /* synthetic */ Iterator f2514a;
        final /* synthetic */ C1620h f2515b;

        C18667(Iterator it, C1620h c1620h) {
            this.f2514a = it;
            this.f2515b = c1620h;
        }

        protected T m4287a() {
            while (this.f2514a.hasNext()) {
                T next = this.f2514a.next();
                if (this.f2515b.m2992a(next)) {
                    return next;
                }
            }
            return m3563b();
        }
    }

    /* renamed from: com.google.common.collect.o.8 */
    static class C18678 extends ab<F, T> {
        final /* synthetic */ C1430c f2516a;

        C18678(Iterator it, C1430c c1430c) {
            this.f2516a = c1430c;
            super(it);
        }

        T m4288a(F f) {
            return this.f2516a.m1805a(f);
        }
    }

    static {
        f2517a = new C18601();
        f2518b = new C18645();
    }

    public static <T> ac<T> m4289a() {
        return C1868o.m4300b();
    }

    static <T> ad<T> m4300b() {
        return f2517a;
    }

    public static <T> ac<T> m4291a(Iterator<T> it) {
        C1650g.m3080a((Object) it);
        if (it instanceof ac) {
            return (ac) it;
        }
        return new C18656(it);
    }

    public static boolean m4298a(Iterator<?> it, Object obj) {
        if (obj == null) {
            while (it.hasNext()) {
                if (it.next() == null) {
                    return true;
                }
            }
        }
        while (it.hasNext()) {
            if (obj.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean m4299a(Iterator<?> it, Iterator<?> it2) {
        while (it.hasNext()) {
            if (!it2.hasNext()) {
                return false;
            }
            if (!C1647e.m3074a(it.next(), it2.next())) {
                return false;
            }
        }
        if (it2.hasNext()) {
            return false;
        }
        return true;
    }

    public static String m4301b(Iterator<?> it) {
        return C1640d.m3043a(", ").m3054b("null").m3053a(new StringBuilder().append('['), (Iterator) it).append(']').toString();
    }

    public static <T> T m4302c(Iterator<T> it) {
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("expected one element but was: <" + next);
        for (int i = 0; i < 4 && it.hasNext(); i++) {
            stringBuilder.append(", " + it.next());
        }
        if (it.hasNext()) {
            stringBuilder.append(", ...");
        }
        stringBuilder.append('>');
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static <T> boolean m4297a(Collection<T> collection, Iterator<? extends T> it) {
        C1650g.m3080a((Object) collection);
        boolean z = false;
        while (it.hasNext()) {
            z |= collection.add(it.next());
        }
        return z;
    }

    public static <T> ac<T> m4292a(Iterator<T> it, C1620h<? super T> c1620h) {
        C1650g.m3080a((Object) it);
        C1650g.m3080a((Object) c1620h);
        return new C18667(it, c1620h);
    }

    public static <F, T> Iterator<T> m4295a(Iterator<F> it, C1430c<? super F, ? extends T> c1430c) {
        C1650g.m3080a((Object) c1430c);
        return new C18678(it, c1430c);
    }

    static void m4303d(Iterator<?> it) {
        C1650g.m3080a((Object) it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public static <T> ac<T> m4293a(T... tArr) {
        C1650g.m3080a((Object) tArr);
        return new C18612(tArr.length, tArr);
    }

    static <T> ad<T> m4294a(T[] tArr, int i, int i2, int i3) {
        C1650g.m3085a(i2 >= 0);
        C1650g.m3084a(i, i + i2, tArr.length);
        return new C18623(i2, i3, tArr, i);
    }

    public static <T> ac<T> m4290a(T t) {
        return new C18634(t);
    }

    static void m4296a(boolean z) {
        C1650g.m3092b(z, (Object) "no calls to next() since the last call to remove()");
    }
}
