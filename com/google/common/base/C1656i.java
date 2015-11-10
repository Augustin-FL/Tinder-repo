package com.google.common.base;

import java.util.Iterator;

/* renamed from: com.google.common.base.i */
public final class C1656i {
    private final C1627b f1968a;
    private final boolean f1969b;
    private final C1653b f1970c;
    private final int f1971d;

    /* renamed from: com.google.common.base.i.a */
    private static abstract class C1651a extends AbstractIterator<String> {
        final CharSequence f1959b;
        final C1627b f1960c;
        final boolean f1961d;
        int f1962e;
        int f1963f;

        abstract int m3096a(int i);

        abstract int m3098b(int i);

        protected /* synthetic */ Object m3097a() {
            return m3099c();
        }

        protected C1651a(C1656i c1656i, CharSequence charSequence) {
            this.f1962e = 0;
            this.f1960c = c1656i.f1968a;
            this.f1961d = c1656i.f1969b;
            this.f1963f = c1656i.f1971d;
            this.f1959b = charSequence;
        }

        protected String m3099c() {
            int i = this.f1962e;
            while (this.f1962e != -1) {
                int a = m3096a(this.f1962e);
                if (a == -1) {
                    a = this.f1959b.length();
                    this.f1962e = -1;
                } else {
                    this.f1962e = m3098b(a);
                }
                if (this.f1962e == i) {
                    this.f1962e++;
                    if (this.f1962e >= this.f1959b.length()) {
                        this.f1962e = -1;
                    }
                } else {
                    int i2 = i;
                    while (i2 < a && this.f1960c.m3015a(this.f1959b.charAt(i2))) {
                        i2++;
                    }
                    i = a;
                    while (i > i2 && this.f1960c.m3015a(this.f1959b.charAt(i - 1))) {
                        i--;
                    }
                    if (this.f1961d && i2 == i) {
                        i = this.f1962e;
                    } else {
                        if (this.f1963f == 1) {
                            i = this.f1959b.length();
                            this.f1962e = -1;
                            while (i > i2 && this.f1960c.m3015a(this.f1959b.charAt(i - 1))) {
                                i--;
                            }
                        } else {
                            this.f1963f--;
                        }
                        return this.f1959b.subSequence(i2, i).toString();
                    }
                }
            }
            return (String) m2981b();
        }
    }

    /* renamed from: com.google.common.base.i.b */
    private interface C1653b {
        Iterator<String> m3102b(C1656i c1656i, CharSequence charSequence);
    }

    /* renamed from: com.google.common.base.i.1 */
    static class C16541 implements C1653b {
        final /* synthetic */ int f1965a;

        /* renamed from: com.google.common.base.i.1.1 */
        class C16521 extends C1651a {
            final /* synthetic */ C16541 f1964a;

            C16521(C16541 c16541, C1656i c1656i, CharSequence charSequence) {
                this.f1964a = c16541;
                super(c1656i, charSequence);
            }

            public int m3100a(int i) {
                int i2 = this.f1964a.f1965a + i;
                return i2 < this.b.length() ? i2 : -1;
            }

            public int m3101b(int i) {
                return i;
            }
        }

        C16541(int i) {
            this.f1965a = i;
        }

        public /* synthetic */ Iterator m3104b(C1656i c1656i, CharSequence charSequence) {
            return m3103a(c1656i, charSequence);
        }

        public C1651a m3103a(C1656i c1656i, CharSequence charSequence) {
            return new C16521(this, c1656i, charSequence);
        }
    }

    /* renamed from: com.google.common.base.i.2 */
    class C16552 implements Iterable<String> {
        final /* synthetic */ CharSequence f1966a;
        final /* synthetic */ C1656i f1967b;

        C16552(C1656i c1656i, CharSequence charSequence) {
            this.f1967b = c1656i;
            this.f1966a = charSequence;
        }

        public Iterator<String> iterator() {
            return this.f1967b.m3108b(this.f1966a);
        }

        public String toString() {
            return C1640d.m3043a(", ").m3052a(new StringBuilder().append('['), (Iterable) this).append(']').toString();
        }
    }

    private C1656i(C1653b c1653b) {
        this(c1653b, false, C1627b.f1933m, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    private C1656i(C1653b c1653b, boolean z, C1627b c1627b, int i) {
        this.f1970c = c1653b;
        this.f1969b = z;
        this.f1968a = c1627b;
        this.f1971d = i;
    }

    public static C1656i m3106a(int i) {
        C1650g.m3086a(i > 0, (Object) "The length may not be less than 1");
        return new C1656i(new C16541(i));
    }

    public Iterable<String> m3111a(CharSequence charSequence) {
        C1650g.m3080a((Object) charSequence);
        return new C16552(this, charSequence);
    }

    private Iterator<String> m3108b(CharSequence charSequence) {
        return this.f1970c.m3102b(this, charSequence);
    }
}
