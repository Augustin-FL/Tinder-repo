package com.google.common.base;

import java.io.IOException;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.google.common.base.d */
public class C1640d {
    private final String f1943a;

    /* renamed from: com.google.common.base.d.1 */
    class C16411 extends C1640d {
        final /* synthetic */ String f1944a;
        final /* synthetic */ C1640d f1945b;

        C16411(C1640d c1640d, C1640d c1640d2, String str) {
            this.f1945b = c1640d;
            this.f1944a = str;
            super(null);
        }

        CharSequence m3056a(Object obj) {
            return obj == null ? this.f1944a : this.f1945b.m3047a(obj);
        }

        public C1640d m3057b(String str) {
            C1650g.m3080a((Object) str);
            throw new UnsupportedOperationException("already specified useForNull");
        }
    }

    /* renamed from: com.google.common.base.d.2 */
    static class C16422 extends AbstractList<Object> {
        final /* synthetic */ Object[] f1946a;
        final /* synthetic */ Object f1947b;
        final /* synthetic */ Object f1948c;

        C16422(Object[] objArr, Object obj, Object obj2) {
            this.f1946a = objArr;
            this.f1947b = obj;
            this.f1948c = obj2;
        }

        public int size() {
            return this.f1946a.length + 2;
        }

        public Object get(int i) {
            switch (i) {
                case C3374b.SmoothProgressBar_spbStyle /*0*/:
                    return this.f1947b;
                case C3374b.SmoothProgressBar_spb_color /*1*/:
                    return this.f1948c;
                default:
                    return this.f1946a[i - 2];
            }
        }
    }

    /* renamed from: com.google.common.base.d.a */
    public static final class C1643a {
        private final C1640d f1949a;
        private final String f1950b;

        private C1643a(C1640d c1640d, String str) {
            this.f1949a = c1640d;
            this.f1950b = (String) C1650g.m3080a((Object) str);
        }

        public StringBuilder m3061a(StringBuilder stringBuilder, Map<?, ?> map) {
            return m3059a(stringBuilder, map.entrySet());
        }

        public <A extends Appendable> A m3058a(A a, Iterator<? extends Entry<?, ?>> it) throws IOException {
            C1650g.m3080a((Object) a);
            if (it.hasNext()) {
                Entry entry = (Entry) it.next();
                a.append(this.f1949a.m3047a(entry.getKey()));
                a.append(this.f1950b);
                a.append(this.f1949a.m3047a(entry.getValue()));
                while (it.hasNext()) {
                    a.append(this.f1949a.f1943a);
                    entry = (Entry) it.next();
                    a.append(this.f1949a.m3047a(entry.getKey()));
                    a.append(this.f1950b);
                    a.append(this.f1949a.m3047a(entry.getValue()));
                }
            }
            return a;
        }

        public StringBuilder m3059a(StringBuilder stringBuilder, Iterable<? extends Entry<?, ?>> iterable) {
            return m3060a(stringBuilder, iterable.iterator());
        }

        public StringBuilder m3060a(StringBuilder stringBuilder, Iterator<? extends Entry<?, ?>> it) {
            try {
                m3058a((Appendable) stringBuilder, (Iterator) it);
                return stringBuilder;
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }
    }

    public static C1640d m3043a(String str) {
        return new C1640d(str);
    }

    public static C1640d m3042a(char c) {
        return new C1640d(String.valueOf(c));
    }

    private C1640d(String str) {
        this.f1943a = (String) C1650g.m3080a((Object) str);
    }

    private C1640d(C1640d c1640d) {
        this.f1943a = c1640d.f1943a;
    }

    public <A extends Appendable> A m3046a(A a, Iterator<?> it) throws IOException {
        C1650g.m3080a((Object) a);
        if (it.hasNext()) {
            a.append(m3047a(it.next()));
            while (it.hasNext()) {
                a.append(this.f1943a);
                a.append(m3047a(it.next()));
            }
        }
        return a;
    }

    public final StringBuilder m3052a(StringBuilder stringBuilder, Iterable<?> iterable) {
        return m3053a(stringBuilder, iterable.iterator());
    }

    public final StringBuilder m3053a(StringBuilder stringBuilder, Iterator<?> it) {
        try {
            m3046a((Appendable) stringBuilder, (Iterator) it);
            return stringBuilder;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public final String m3048a(Iterable<?> iterable) {
        return m3050a(iterable.iterator());
    }

    public final String m3050a(Iterator<?> it) {
        return m3053a(new StringBuilder(), (Iterator) it).toString();
    }

    public final String m3051a(Object[] objArr) {
        return m3048a(Arrays.asList(objArr));
    }

    public final String m3049a(Object obj, Object obj2, Object... objArr) {
        return m3048a(C1640d.m3045b(obj, obj2, objArr));
    }

    public C1640d m3054b(String str) {
        C1650g.m3080a((Object) str);
        return new C16411(this, this, str);
    }

    public C1643a m3055c(String str) {
        return new C1643a(str, null);
    }

    CharSequence m3047a(Object obj) {
        C1650g.m3080a(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    private static Iterable<Object> m3045b(Object obj, Object obj2, Object[] objArr) {
        C1650g.m3080a((Object) objArr);
        return new C16422(objArr, obj, obj2);
    }
}
