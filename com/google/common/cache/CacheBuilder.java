package com.google.common.cache;

import com.google.common.base.C1625l;
import com.google.common.base.C1626a;
import com.google.common.base.C1647e;
import com.google.common.base.C1647e.C1646a;
import com.google.common.base.C1650g;
import com.google.common.base.C1660m;
import com.google.common.base.Equivalence;
import com.google.common.base.Suppliers;
import com.google.common.cache.C1734a.C1665b;
import com.google.common.cache.C1734a.C1733a;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class CacheBuilder<K, V> {
    static final C1625l<? extends C1665b> f1985a;
    static final C1735c f1986b;
    static final C1625l<C1665b> f1987c;
    static final C1660m f1988d;
    private static final Logger f1989u;
    boolean f1990e;
    int f1991f;
    int f1992g;
    long f1993h;
    long f1994i;
    C1670i<? super K, ? super V> f1995j;
    Strength f1996k;
    Strength f1997l;
    long f1998m;
    long f1999n;
    long f2000o;
    Equivalence<Object> f2001p;
    Equivalence<Object> f2002q;
    C1669g<? super K, ? super V> f2003r;
    C1660m f2004s;
    C1625l<? extends C1665b> f2005t;

    /* renamed from: com.google.common.cache.CacheBuilder.1 */
    static class C16661 implements C1665b {
        C16661() {
        }

        public void m3138a(int i) {
        }

        public void m3140b(int i) {
        }

        public void m3139a(long j) {
        }

        public void m3141b(long j) {
        }

        public void m3137a() {
        }
    }

    /* renamed from: com.google.common.cache.CacheBuilder.2 */
    static class C16672 implements C1625l<C1665b> {
        C16672() {
        }

        public /* synthetic */ Object m3142a() {
            return m3143b();
        }

        public C1665b m3143b() {
            return new C1733a();
        }
    }

    /* renamed from: com.google.common.cache.CacheBuilder.3 */
    static class C16683 extends C1660m {
        C16683() {
        }

        public long m3144a() {
            return 0;
        }
    }

    enum NullListener implements C1669g<Object, Object> {
        INSTANCE;

        public void m3146a(C1736h<Object, Object> c1736h) {
        }
    }

    enum OneWeigher implements C1670i<Object, Object> {
        INSTANCE;

        public int m3148a(Object obj, Object obj2) {
            return 1;
        }
    }

    static {
        f1985a = Suppliers.m3005a(new C16661());
        f1986b = new C1735c(0, 0, 0, 0, 0, 0);
        f1987c = new C16672();
        f1988d = new C16683();
        f1989u = Logger.getLogger(CacheBuilder.class.getName());
    }

    CacheBuilder() {
        this.f1990e = true;
        this.f1991f = -1;
        this.f1992g = -1;
        this.f1993h = -1;
        this.f1994i = -1;
        this.f1998m = -1;
        this.f1999n = -1;
        this.f2000o = -1;
        this.f2005t = f1985a;
    }

    public static CacheBuilder<Object, Object> m3149a() {
        return new CacheBuilder();
    }

    CacheBuilder<K, V> m3156a(Equivalence<Object> equivalence) {
        boolean z;
        if (this.f2001p == null) {
            z = true;
        } else {
            z = false;
        }
        C1650g.m3093b(z, "key equivalence was already set to %s", this.f2001p);
        this.f2001p = (Equivalence) C1650g.m3080a((Object) equivalence);
        return this;
    }

    Equivalence<Object> m3162b() {
        return (Equivalence) C1647e.m3075b(this.f2001p, m3173i().m3317a());
    }

    CacheBuilder<K, V> m3165b(Equivalence<Object> equivalence) {
        boolean z;
        if (this.f2002q == null) {
            z = true;
        } else {
            z = false;
        }
        C1650g.m3093b(z, "value equivalence was already set to %s", this.f2002q);
        this.f2002q = (Equivalence) C1650g.m3080a((Object) equivalence);
        return this;
    }

    Equivalence<Object> m3167c() {
        return (Equivalence) C1647e.m3075b(this.f2002q, m3174j().m3317a());
    }

    int m3168d() {
        return this.f1991f == -1 ? 16 : this.f1991f;
    }

    public CacheBuilder<K, V> m3153a(int i) {
        boolean z;
        boolean z2 = true;
        if (this.f1992g == -1) {
            z = true;
        } else {
            z = false;
        }
        C1650g.m3093b(z, "concurrency level was already set to %s", Integer.valueOf(this.f1992g));
        if (i <= 0) {
            z2 = false;
        }
        C1650g.m3085a(z2);
        this.f1992g = i;
        return this;
    }

    int m3169e() {
        return this.f1992g == -1 ? 4 : this.f1992g;
    }

    public CacheBuilder<K, V> m3154a(long j) {
        boolean z;
        boolean z2 = true;
        C1650g.m3093b(this.f1993h == -1, "maximum size was already set to %s", Long.valueOf(this.f1993h));
        if (this.f1994i == -1) {
            z = true;
        } else {
            z = false;
        }
        C1650g.m3093b(z, "maximum weight was already set to %s", Long.valueOf(this.f1994i));
        if (this.f1995j == null) {
            z = true;
        } else {
            z = false;
        }
        C1650g.m3092b(z, (Object) "maximum size can not be combined with weigher");
        if (j < 0) {
            z2 = false;
        }
        C1650g.m3086a(z2, (Object) "maximum size must not be negative");
        this.f1993h = j;
        return this;
    }

    public CacheBuilder<K, V> m3163b(long j) {
        boolean z;
        boolean z2 = true;
        C1650g.m3093b(this.f1994i == -1, "maximum weight was already set to %s", Long.valueOf(this.f1994i));
        if (this.f1993h == -1) {
            z = true;
        } else {
            z = false;
        }
        C1650g.m3093b(z, "maximum size was already set to %s", Long.valueOf(this.f1993h));
        this.f1994i = j;
        if (j < 0) {
            z2 = false;
        }
        C1650g.m3086a(z2, (Object) "maximum weight must not be negative");
        return this;
    }

    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> m3160a(C1670i<? super K1, ? super V1> c1670i) {
        C1650g.m3091b(this.f1995j == null);
        if (this.f1990e) {
            boolean z;
            if (this.f1993h == -1) {
                z = true;
            } else {
                z = false;
            }
            C1650g.m3093b(z, "weigher can not be combined with maximum size", Long.valueOf(this.f1993h));
        }
        this.f1995j = (C1670i) C1650g.m3080a((Object) c1670i);
        return this;
    }

    long m3170f() {
        if (this.f1998m == 0 || this.f1999n == 0) {
            return 0;
        }
        return this.f1995j == null ? this.f1993h : this.f1994i;
    }

    <K1 extends K, V1 extends V> C1670i<K1, V1> m3171g() {
        return (C1670i) C1647e.m3075b(this.f1995j, OneWeigher.INSTANCE);
    }

    public CacheBuilder<K, V> m3172h() {
        return m3158a(Strength.WEAK);
    }

    CacheBuilder<K, V> m3158a(Strength strength) {
        boolean z;
        if (this.f1996k == null) {
            z = true;
        } else {
            z = false;
        }
        C1650g.m3093b(z, "Key strength was already set to %s", this.f1996k);
        this.f1996k = (Strength) C1650g.m3080a((Object) strength);
        return this;
    }

    Strength m3173i() {
        return (Strength) C1647e.m3075b(this.f1996k, Strength.STRONG);
    }

    CacheBuilder<K, V> m3166b(Strength strength) {
        boolean z;
        if (this.f1997l == null) {
            z = true;
        } else {
            z = false;
        }
        C1650g.m3093b(z, "Value strength was already set to %s", this.f1997l);
        this.f1997l = (Strength) C1650g.m3080a((Object) strength);
        return this;
    }

    Strength m3174j() {
        return (Strength) C1647e.m3075b(this.f1997l, Strength.STRONG);
    }

    public CacheBuilder<K, V> m3155a(long j, TimeUnit timeUnit) {
        boolean z;
        if (this.f1998m == -1) {
            z = true;
        } else {
            z = false;
        }
        C1650g.m3093b(z, "expireAfterWrite was already set to %s ns", Long.valueOf(this.f1998m));
        if (j >= 0) {
            z = true;
        } else {
            z = false;
        }
        C1650g.m3087a(z, "duration cannot be negative: %s %s", Long.valueOf(j), timeUnit);
        this.f1998m = timeUnit.toNanos(j);
        return this;
    }

    long m3175k() {
        return this.f1998m == -1 ? 0 : this.f1998m;
    }

    public CacheBuilder<K, V> m3164b(long j, TimeUnit timeUnit) {
        boolean z;
        if (this.f1999n == -1) {
            z = true;
        } else {
            z = false;
        }
        C1650g.m3093b(z, "expireAfterAccess was already set to %s ns", Long.valueOf(this.f1999n));
        if (j >= 0) {
            z = true;
        } else {
            z = false;
        }
        C1650g.m3087a(z, "duration cannot be negative: %s %s", Long.valueOf(j), timeUnit);
        this.f1999n = timeUnit.toNanos(j);
        return this;
    }

    long m3176l() {
        return this.f1999n == -1 ? 0 : this.f1999n;
    }

    long m3177m() {
        return this.f2000o == -1 ? 0 : this.f2000o;
    }

    public CacheBuilder<K, V> m3157a(C1660m c1660m) {
        C1650g.m3091b(this.f2004s == null);
        this.f2004s = (C1660m) C1650g.m3080a((Object) c1660m);
        return this;
    }

    C1660m m3152a(boolean z) {
        if (this.f2004s != null) {
            return this.f2004s;
        }
        return z ? C1660m.m3120b() : f1988d;
    }

    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> m3159a(C1669g<? super K1, ? super V1> c1669g) {
        C1650g.m3091b(this.f2003r == null);
        this.f2003r = (C1669g) C1650g.m3080a((Object) c1669g);
        return this;
    }

    <K1 extends K, V1 extends V> C1669g<K1, V1> m3178n() {
        return (C1669g) C1647e.m3075b(this.f2003r, NullListener.INSTANCE);
    }

    C1625l<? extends C1665b> m3179o() {
        return this.f2005t;
    }

    public <K1 extends K, V1 extends V> C1685e<K1, V1> m3161a(CacheLoader<? super K1, V1> cacheLoader) {
        m3151r();
        return new LocalLoadingCache(this, cacheLoader);
    }

    public <K1 extends K, V1 extends V> C1683b<K1, V1> m3180p() {
        m3151r();
        m3150q();
        return new LocalManualCache(this);
    }

    private void m3150q() {
        C1650g.m3092b(this.f2000o == -1, (Object) "refreshAfterWrite requires a LoadingCache");
    }

    private void m3151r() {
        boolean z = true;
        if (this.f1995j == null) {
            if (this.f1994i != -1) {
                z = false;
            }
            C1650g.m3092b(z, (Object) "maximumWeight requires weigher");
        } else if (this.f1990e) {
            if (this.f1994i == -1) {
                z = false;
            }
            C1650g.m3092b(z, (Object) "weigher requires maximumWeight");
        } else if (this.f1994i == -1) {
            f1989u.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
        }
    }

    public String toString() {
        C1646a a = C1647e.m3072a((Object) this);
        if (this.f1991f != -1) {
            a.m3067a("initialCapacity", this.f1991f);
        }
        if (this.f1992g != -1) {
            a.m3067a("concurrencyLevel", this.f1992g);
        }
        if (this.f1993h != -1) {
            a.m3068a("maximumSize", this.f1993h);
        }
        if (this.f1994i != -1) {
            a.m3068a("maximumWeight", this.f1994i);
        }
        if (this.f1998m != -1) {
            a.m3069a("expireAfterWrite", this.f1998m + "ns");
        }
        if (this.f1999n != -1) {
            a.m3069a("expireAfterAccess", this.f1999n + "ns");
        }
        if (this.f1996k != null) {
            a.m3069a("keyStrength", C1626a.m3008a(this.f1996k.toString()));
        }
        if (this.f1997l != null) {
            a.m3069a("valueStrength", C1626a.m3008a(this.f1997l.toString()));
        }
        if (this.f2001p != null) {
            a.m3065a("keyEquivalence");
        }
        if (this.f2002q != null) {
            a.m3065a("valueEquivalence");
        }
        if (this.f2003r != null) {
            a.m3065a("removalListener");
        }
        return a.toString();
    }
}
