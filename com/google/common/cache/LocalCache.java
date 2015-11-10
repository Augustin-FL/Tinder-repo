package com.google.common.cache;

import com.facebook.internal.NativeProtocol;
import com.google.common.base.C1650g;
import com.google.common.base.C1658j;
import com.google.common.base.C1660m;
import com.google.common.base.Equivalence;
import com.google.common.cache.C1734a.C1665b;
import com.google.common.cache.CacheLoader.InvalidCacheLoadException;
import com.google.common.collect.C1695d;
import com.google.common.collect.C1868o;
import com.google.common.p024c.C1662a;
import com.google.common.util.concurrent.C1908e;
import com.google.common.util.concurrent.C1909g;
import com.google.common.util.concurrent.C1919d;
import com.google.common.util.concurrent.C1923h;
import com.google.common.util.concurrent.C1924i;
import com.google.common.util.concurrent.C1925j;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

class LocalCache<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V> {
    static final Logger f2126a;
    static final C1909g f2127b;
    static final C1671r<Object, Object> f2128v;
    static final Queue<? extends Object> f2129w;
    final int f2130c;
    final int f2131d;
    final Segment<K, V>[] f2132e;
    final int f2133f;
    final Equivalence<Object> f2134g;
    final Equivalence<Object> f2135h;
    final Strength f2136i;
    final Strength f2137j;
    final long f2138k;
    final C1670i<K, V> f2139l;
    final long f2140m;
    final long f2141n;
    final long f2142o;
    final Queue<C1736h<K, V>> f2143p;
    final C1669g<K, V> f2144q;
    final C1660m f2145r;
    final EntryFactory f2146s;
    final C1665b f2147t;
    final CacheLoader<? super K, V> f2148u;
    Set<K> f2149x;
    Collection<V> f2150y;
    Set<Entry<K, V>> f2151z;

    /* renamed from: com.google.common.cache.LocalCache.r */
    interface C1671r<K, V> {
        int m3181a();

        C1671r<K, V> m3182a(ReferenceQueue<V> referenceQueue, V v, C1686j<K, V> c1686j);

        void m3183a(V v);

        C1686j<K, V> m3184b();

        boolean m3185c();

        boolean m3186d();

        V m3187e() throws ExecutionException;

        V get();
    }

    /* renamed from: com.google.common.cache.LocalCache.1 */
    static class C16721 implements C1671r<Object, Object> {
        C16721() {
        }

        public Object get() {
            return null;
        }

        public int m3188a() {
            return 0;
        }

        public C1686j<Object, Object> m3191b() {
            return null;
        }

        public C1671r<Object, Object> m3189a(ReferenceQueue<Object> referenceQueue, Object obj, C1686j<Object, Object> c1686j) {
            return this;
        }

        public boolean m3192c() {
            return false;
        }

        public boolean m3193d() {
            return false;
        }

        public Object m3194e() {
            return null;
        }

        public void m3190a(Object obj) {
        }
    }

    /* renamed from: com.google.common.cache.LocalCache.2 */
    static class C16732 extends AbstractQueue<Object> {
        C16732() {
        }

        public boolean offer(Object obj) {
            return true;
        }

        public Object peek() {
            return null;
        }

        public Object poll() {
            return null;
        }

        public int size() {
            return 0;
        }

        public Iterator<Object> iterator() {
            return C1868o.m4289a();
        }
    }

    enum EntryFactory {
        STRONG {
            <K, V> C1686j<K, V> m3200a(Segment<K, V> segment, K k, int i, C1686j<K, V> c1686j) {
                return new C1707n(k, i, c1686j);
            }
        },
        STRONG_ACCESS {
            <K, V> C1686j<K, V> m3202a(Segment<K, V> segment, K k, int i, C1686j<K, V> c1686j) {
                return new C1708l(k, i, c1686j);
            }

            <K, V> C1686j<K, V> m3201a(Segment<K, V> segment, C1686j<K, V> c1686j, C1686j<K, V> c1686j2) {
                C1686j<K, V> a = super.m3196a((Segment) segment, (C1686j) c1686j, (C1686j) c1686j2);
                m3198a(c1686j, a);
                return a;
            }
        },
        STRONG_WRITE {
            <K, V> C1686j<K, V> m3204a(Segment<K, V> segment, K k, int i, C1686j<K, V> c1686j) {
                return new C1711p(k, i, c1686j);
            }

            <K, V> C1686j<K, V> m3203a(Segment<K, V> segment, C1686j<K, V> c1686j, C1686j<K, V> c1686j2) {
                C1686j<K, V> a = super.m3196a((Segment) segment, (C1686j) c1686j, (C1686j) c1686j2);
                m3199b(c1686j, a);
                return a;
            }
        },
        STRONG_ACCESS_WRITE {
            <K, V> C1686j<K, V> m3206a(Segment<K, V> segment, K k, int i, C1686j<K, V> c1686j) {
                return new C1709m(k, i, c1686j);
            }

            <K, V> C1686j<K, V> m3205a(Segment<K, V> segment, C1686j<K, V> c1686j, C1686j<K, V> c1686j2) {
                C1686j<K, V> a = super.m3196a((Segment) segment, (C1686j) c1686j, (C1686j) c1686j2);
                m3198a(c1686j, a);
                m3199b(c1686j, a);
                return a;
            }
        },
        WEAK {
            <K, V> C1686j<K, V> m3207a(Segment<K, V> segment, K k, int i, C1686j<K, V> c1686j) {
                return new C1714v(segment.f2045h, k, i, c1686j);
            }
        },
        WEAK_ACCESS {
            <K, V> C1686j<K, V> m3209a(Segment<K, V> segment, K k, int i, C1686j<K, V> c1686j) {
                return new C1715t(segment.f2045h, k, i, c1686j);
            }

            <K, V> C1686j<K, V> m3208a(Segment<K, V> segment, C1686j<K, V> c1686j, C1686j<K, V> c1686j2) {
                C1686j<K, V> a = super.m3196a((Segment) segment, (C1686j) c1686j, (C1686j) c1686j2);
                m3198a(c1686j, a);
                return a;
            }
        },
        WEAK_WRITE {
            <K, V> C1686j<K, V> m3211a(Segment<K, V> segment, K k, int i, C1686j<K, V> c1686j) {
                return new C1717x(segment.f2045h, k, i, c1686j);
            }

            <K, V> C1686j<K, V> m3210a(Segment<K, V> segment, C1686j<K, V> c1686j, C1686j<K, V> c1686j2) {
                C1686j<K, V> a = super.m3196a((Segment) segment, (C1686j) c1686j, (C1686j) c1686j2);
                m3199b(c1686j, a);
                return a;
            }
        },
        WEAK_ACCESS_WRITE {
            <K, V> C1686j<K, V> m3213a(Segment<K, V> segment, K k, int i, C1686j<K, V> c1686j) {
                return new C1716u(segment.f2045h, k, i, c1686j);
            }

            <K, V> C1686j<K, V> m3212a(Segment<K, V> segment, C1686j<K, V> c1686j, C1686j<K, V> c1686j2) {
                C1686j<K, V> a = super.m3196a((Segment) segment, (C1686j) c1686j, (C1686j) c1686j2);
                m3198a(c1686j, a);
                m3199b(c1686j, a);
                return a;
            }
        };
        
        static final EntryFactory[] f2014i;

        abstract <K, V> C1686j<K, V> m3197a(Segment<K, V> segment, K k, int i, C1686j<K, V> c1686j);

        static {
            f2014i = new EntryFactory[]{STRONG, STRONG_ACCESS, STRONG_WRITE, STRONG_ACCESS_WRITE, WEAK, WEAK_ACCESS, WEAK_WRITE, WEAK_ACCESS_WRITE};
        }

        static EntryFactory m3195a(Strength strength, boolean z, boolean z2) {
            int i;
            int i2 = 0;
            if (strength == Strength.WEAK) {
                i = 4;
            } else {
                i = 0;
            }
            int i3 = (z ? 1 : 0) | i;
            if (z2) {
                i2 = 2;
            }
            return f2014i[i2 | i3];
        }

        <K, V> C1686j<K, V> m3196a(Segment<K, V> segment, C1686j<K, V> c1686j, C1686j<K, V> c1686j2) {
            return m3197a(segment, c1686j.m3234d(), c1686j.m3232c(), c1686j2);
        }

        <K, V> void m3198a(C1686j<K, V> c1686j, C1686j<K, V> c1686j2) {
            c1686j2.m3226a(c1686j.m3236e());
            LocalCache.m3494a(c1686j.m3238g(), (C1686j) c1686j2);
            LocalCache.m3494a((C1686j) c1686j2, c1686j.m3237f());
            LocalCache.m3495b((C1686j) c1686j);
        }

        <K, V> void m3199b(C1686j<K, V> c1686j, C1686j<K, V> c1686j2) {
            c1686j2.m3230b(c1686j.m3239h());
            LocalCache.m3496b(c1686j.m3241j(), (C1686j) c1686j2);
            LocalCache.m3496b((C1686j) c1686j2, c1686j.m3240i());
            LocalCache.m3497c((C1686j) c1686j);
        }
    }

    static class ManualSerializationProxy<K, V> extends C1684d<K, V> implements Serializable {
        private static final long serialVersionUID = 1;
        final Strength f2016b;
        final Strength f2017c;
        final Equivalence<Object> f2018d;
        final Equivalence<Object> f2019e;
        final long f2020f;
        final long f2021g;
        final long f2022h;
        final C1670i<K, V> f2023i;
        final int f2024j;
        final C1669g<? super K, ? super V> f2025k;
        final C1660m f2026l;
        final CacheLoader<? super K, V> f2027m;
        transient C1683b<K, V> f2028n;

        protected /* synthetic */ Object m3218b() {
            return m3217a();
        }

        ManualSerializationProxy(LocalCache<K, V> localCache) {
            this(localCache.f2136i, localCache.f2137j, localCache.f2134g, localCache.f2135h, localCache.f2141n, localCache.f2140m, localCache.f2138k, localCache.f2139l, localCache.f2133f, localCache.f2144q, localCache.f2145r, localCache.f2148u);
        }

        private ManualSerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, long j, long j2, long j3, C1670i<K, V> c1670i, int i, C1669g<? super K, ? super V> c1669g, C1660m c1660m, CacheLoader<? super K, V> cacheLoader) {
            this.f2016b = strength;
            this.f2017c = strength2;
            this.f2018d = equivalence;
            this.f2019e = equivalence2;
            this.f2020f = j;
            this.f2021g = j2;
            this.f2022h = j3;
            this.f2023i = c1670i;
            this.f2024j = i;
            this.f2025k = c1669g;
            if (c1660m == C1660m.m3120b() || c1660m == CacheBuilder.f1988d) {
                c1660m = null;
            }
            this.f2026l = c1660m;
            this.f2027m = cacheLoader;
        }

        CacheBuilder<K, V> m3219c() {
            CacheBuilder<K, V> a = CacheBuilder.m3149a().m3158a(this.f2016b).m3166b(this.f2017c).m3156a(this.f2018d).m3165b(this.f2019e).m3153a(this.f2024j).m3159a(this.f2025k);
            a.f1990e = false;
            if (this.f2020f > 0) {
                a.m3155a(this.f2020f, TimeUnit.NANOSECONDS);
            }
            if (this.f2021g > 0) {
                a.m3164b(this.f2021g, TimeUnit.NANOSECONDS);
            }
            if (this.f2023i != OneWeigher.INSTANCE) {
                a.m3160a(this.f2023i);
                if (this.f2022h != -1) {
                    a.m3163b(this.f2022h);
                }
            } else if (this.f2022h != -1) {
                a.m3154a(this.f2022h);
            }
            if (this.f2026l != null) {
                a.m3157a(this.f2026l);
            }
            return a;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.f2028n = m3219c().m3180p();
        }

        private Object readResolve() {
            return this.f2028n;
        }

        protected C1683b<K, V> m3217a() {
            return this.f2028n;
        }
    }

    static final class LoadingSerializationProxy<K, V> extends ManualSerializationProxy<K, V> implements C1685e<K, V>, Serializable {
        private static final long serialVersionUID = 1;
        transient C1685e<K, V> f2029a;

        LoadingSerializationProxy(LocalCache<K, V> localCache) {
            super(localCache);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.f2029a = m3219c().m3161a(this.m);
        }

        public final V m3221a(K k) {
            return this.f2029a.m3220a(k);
        }

        private Object readResolve() {
            return this.f2029a;
        }
    }

    static class LocalManualCache<K, V> implements C1683b<K, V>, Serializable {
        private static final long serialVersionUID = 1;
        final LocalCache<K, V> f2030a;

        LocalManualCache(CacheBuilder<? super K, ? super V> cacheBuilder) {
            this(new LocalCache(cacheBuilder, null));
        }

        private LocalManualCache(LocalCache<K, V> localCache) {
            this.f2030a = localCache;
        }

        Object writeReplace() {
            return new ManualSerializationProxy(this.f2030a);
        }
    }

    static class LocalLoadingCache<K, V> extends LocalManualCache<K, V> implements C1685e<K, V> {
        private static final long serialVersionUID = 1;

        LocalLoadingCache(CacheBuilder<? super K, ? super V> cacheBuilder, CacheLoader<? super K, V> cacheLoader) {
            super(null);
        }

        public V m3223b(K k) throws ExecutionException {
            return this.a.m3509b((Object) k);
        }

        public V m3224c(K k) {
            try {
                return m3223b(k);
            } catch (ExecutionException e) {
                throw new UncheckedExecutionException(e.getCause());
            }
        }

        public final V m3222a(K k) {
            return m3224c(k);
        }

        Object writeReplace() {
            return new LoadingSerializationProxy(this.a);
        }
    }

    /* renamed from: com.google.common.cache.LocalCache.j */
    interface C1686j<K, V> {
        C1671r<K, V> m3225a();

        void m3226a(long j);

        void m3227a(C1686j<K, V> c1686j);

        void m3228a(C1671r<K, V> c1671r);

        C1686j<K, V> m3229b();

        void m3230b(long j);

        void m3231b(C1686j<K, V> c1686j);

        int m3232c();

        void m3233c(C1686j<K, V> c1686j);

        K m3234d();

        void m3235d(C1686j<K, V> c1686j);

        long m3236e();

        C1686j<K, V> m3237f();

        C1686j<K, V> m3238g();

        long m3239h();

        C1686j<K, V> m3240i();

        C1686j<K, V> m3241j();
    }

    private enum NullEntry implements C1686j<Object, Object> {
        INSTANCE;

        public C1671r<Object, Object> m3242a() {
            return null;
        }

        public void m3245a(C1671r<Object, Object> c1671r) {
        }

        public C1686j<Object, Object> m3246b() {
            return null;
        }

        public int m3249c() {
            return 0;
        }

        public Object m3251d() {
            return null;
        }

        public long m3253e() {
            return 0;
        }

        public void m3243a(long j) {
        }

        public C1686j<Object, Object> m3254f() {
            return this;
        }

        public void m3244a(C1686j<Object, Object> c1686j) {
        }

        public C1686j<Object, Object> m3255g() {
            return this;
        }

        public void m3248b(C1686j<Object, Object> c1686j) {
        }

        public long m3256h() {
            return 0;
        }

        public void m3247b(long j) {
        }

        public C1686j<Object, Object> m3257i() {
            return this;
        }

        public void m3250c(C1686j<Object, Object> c1686j) {
        }

        public C1686j<Object, Object> m3258j() {
            return this;
        }

        public void m3252d(C1686j<Object, Object> c1686j) {
        }
    }

    static class Segment<K, V> extends ReentrantLock {
        final LocalCache<K, V> f2038a;
        volatile int f2039b;
        int f2040c;
        int f2041d;
        int f2042e;
        volatile AtomicReferenceArray<C1686j<K, V>> f2043f;
        final long f2044g;
        final ReferenceQueue<K> f2045h;
        final ReferenceQueue<V> f2046i;
        final Queue<C1686j<K, V>> f2047j;
        final AtomicInteger f2048k;
        final Queue<C1686j<K, V>> f2049l;
        final Queue<C1686j<K, V>> f2050m;
        final C1665b f2051n;

        /* renamed from: com.google.common.cache.LocalCache.Segment.1 */
        class C16871 implements Runnable {
            final /* synthetic */ Object f2033a;
            final /* synthetic */ int f2034b;
            final /* synthetic */ C1705i f2035c;
            final /* synthetic */ C1908e f2036d;
            final /* synthetic */ Segment f2037e;

            C16871(Segment segment, Object obj, int i, C1705i c1705i, C1908e c1908e) {
                this.f2037e = segment;
                this.f2033a = obj;
                this.f2034b = i;
                this.f2035c = c1705i;
                this.f2036d = c1908e;
            }

            public void run() {
                try {
                    this.f2035c.m3388b(this.f2037e.m3270a(this.f2033a, this.f2034b, this.f2035c, this.f2036d));
                } catch (Throwable th) {
                    LocalCache.f2126a.log(Level.WARNING, "Exception thrown during refresh", th);
                    this.f2035c.m3386a(th);
                }
            }
        }

        Segment(LocalCache<K, V> localCache, int i, long j, C1665b c1665b) {
            ReferenceQueue referenceQueue = null;
            this.f2048k = new AtomicInteger();
            this.f2038a = localCache;
            this.f2044g = j;
            this.f2051n = (C1665b) C1650g.m3080a((Object) c1665b);
            m3282a(m3273a(i));
            this.f2045h = localCache.m3523m() ? new ReferenceQueue() : null;
            if (localCache.m3524n()) {
                referenceQueue = new ReferenceQueue();
            }
            this.f2046i = referenceQueue;
            this.f2047j = localCache.m3516f() ? new ConcurrentLinkedQueue() : LocalCache.m3500q();
            this.f2049l = localCache.m3517g() ? new ab() : LocalCache.m3500q();
            this.f2050m = localCache.m3516f() ? new C1699c() : LocalCache.m3500q();
        }

        AtomicReferenceArray<C1686j<K, V>> m3273a(int i) {
            return new AtomicReferenceArray(i);
        }

        void m3282a(AtomicReferenceArray<C1686j<K, V>> atomicReferenceArray) {
            this.f2042e = (atomicReferenceArray.length() * 3) / 4;
            if (!this.f2038a.m3510b() && ((long) this.f2042e) == this.f2044g) {
                this.f2042e++;
            }
            this.f2043f = atomicReferenceArray;
        }

        C1686j<K, V> m3264a(K k, int i, C1686j<K, V> c1686j) {
            return this.f2038a.f2146s.m3197a(this, C1650g.m3080a((Object) k), i, c1686j);
        }

        C1686j<K, V> m3260a(C1686j<K, V> c1686j, C1686j<K, V> c1686j2) {
            if (c1686j.m3234d() == null) {
                return null;
            }
            C1671r a = c1686j.m3225a();
            Object obj = a.get();
            if (obj == null && a.m3186d()) {
                return null;
            }
            C1686j<K, V> a2 = this.f2038a.f2146s.m3196a(this, (C1686j) c1686j, (C1686j) c1686j2);
            a2.m3228a(a.m3182a(this.f2046i, obj, a2));
            return a2;
        }

        void m3280a(C1686j<K, V> c1686j, K k, V v, long j) {
            C1671r a = c1686j.m3225a();
            int a2 = this.f2038a.f2139l.m3147a(k, v);
            C1650g.m3092b(a2 >= 0, (Object) "Weights must be non-negative");
            c1686j.m3228a(this.f2038a.f2137j.m3318a(this, c1686j, v, a2));
            m3277a((C1686j) c1686j, a2, j);
            a.m3183a(v);
        }

        V m3267a(K k, int i, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            C1650g.m3080a((Object) k);
            C1650g.m3080a((Object) cacheLoader);
            try {
                V a;
                if (this.f2039b != 0) {
                    C1686j a2 = m3262a((Object) k, i);
                    if (a2 != null) {
                        long a3 = this.f2038a.f2145r.m3121a();
                        Object c = m3298c(a2, a3);
                        if (c != null) {
                            m3278a(a2, a3);
                            this.f2051n.m3133a(1);
                            a = m3265a(a2, (Object) k, i, c, a3, (CacheLoader) cacheLoader);
                            m3313m();
                        } else {
                            C1671r a4 = a2.m3225a();
                            if (a4.m3185c()) {
                                a = m3266a(a2, (Object) k, a4);
                                m3313m();
                            }
                        }
                        return a;
                    }
                }
                a = m3293b((Object) k, i, (CacheLoader) cacheLoader);
                m3313m();
                return a;
            } catch (ExecutionException e) {
                ExecutionException executionException = e;
                Throwable cause = executionException.getCause();
                if (cause instanceof Error) {
                    throw new ExecutionError((Error) cause);
                } else if (cause instanceof RuntimeException) {
                    throw new UncheckedExecutionException(cause);
                } else {
                    throw executionException;
                }
            } catch (Throwable th) {
                m3313m();
            }
        }

        V m3293b(K k, int i, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            lock();
            try {
                Object obj;
                C1671r c1671r;
                int i2;
                C1671r c1705i;
                C1671r c1671r2;
                C1686j c1686j;
                C1705i c1705i2;
                C1671r c1671r3;
                V a;
                long a2 = this.f2038a.f2145r.m3121a();
                m3300c(a2);
                int i3 = this.f2039b - 1;
                AtomicReferenceArray atomicReferenceArray = this.f2043f;
                int length = i & (atomicReferenceArray.length() - 1);
                C1686j c1686j2 = (C1686j) atomicReferenceArray.get(length);
                C1686j c1686j3 = c1686j2;
                while (c1686j3 != null) {
                    Object d = c1686j3.m3234d();
                    if (c1686j3.m3232c() == i && d != null && this.f2038a.f2134g.m2985a(k, d)) {
                        C1671r a3 = c1686j3.m3225a();
                        if (a3.m3185c()) {
                            obj = null;
                            c1671r = a3;
                        } else {
                            V v = a3.get();
                            if (v == null) {
                                m3281a(d, i, a3, RemovalCause.COLLECTED);
                            } else {
                                if (this.f2038a.m3511b(c1686j3, a2)) {
                                    m3281a(d, i, a3, RemovalCause.EXPIRED);
                                } else {
                                    m3296b(c1686j3, a2);
                                    this.f2051n.m3133a(1);
                                    unlock();
                                    m3314n();
                                    return v;
                                }
                            }
                            this.f2049l.remove(c1686j3);
                            this.f2050m.remove(c1686j3);
                            this.f2039b = i3;
                            i2 = 1;
                            c1671r = a3;
                        }
                        if (obj == null) {
                            c1705i = new C1705i();
                            if (c1686j3 != null) {
                                c1686j2 = m3264a((Object) k, i, c1686j2);
                                c1686j2.m3228a(c1705i);
                                atomicReferenceArray.set(length, c1686j2);
                                c1671r2 = c1705i;
                                c1686j = c1686j2;
                                c1705i2 = c1671r2;
                            } else {
                                c1686j3.m3228a(c1705i);
                                c1671r3 = c1705i;
                                c1686j = c1686j3;
                            }
                        } else {
                            c1705i2 = null;
                            c1686j = c1686j3;
                        }
                        unlock();
                        m3314n();
                        if (obj != null) {
                            return m3266a(c1686j, (Object) k, c1671r);
                        }
                        try {
                            synchronized (c1686j) {
                                a = m3269a((Object) k, i, c1705i2, (CacheLoader) cacheLoader);
                            }
                            return a;
                        } finally {
                            this.f2051n.m3135b(1);
                        }
                    } else {
                        c1686j3 = c1686j3.m3229b();
                    }
                }
                c1671r = null;
                i2 = 1;
                if (obj == null) {
                    c1705i2 = null;
                    c1686j = c1686j3;
                } else {
                    c1705i = new C1705i();
                    if (c1686j3 != null) {
                        c1686j3.m3228a(c1705i);
                        c1671r3 = c1705i;
                        c1686j = c1686j3;
                    } else {
                        c1686j2 = m3264a((Object) k, i, c1686j2);
                        c1686j2.m3228a(c1705i);
                        atomicReferenceArray.set(length, c1686j2);
                        c1671r2 = c1705i;
                        c1686j = c1686j2;
                        c1705i2 = c1671r2;
                    }
                }
                unlock();
                m3314n();
                if (obj != null) {
                    return m3266a(c1686j, (Object) k, c1671r);
                }
                synchronized (c1686j) {
                    a = m3269a((Object) k, i, c1705i2, (CacheLoader) cacheLoader);
                }
                return a;
            } catch (Throwable th) {
                unlock();
                m3314n();
            }
        }

        V m3266a(C1686j<K, V> c1686j, K k, C1671r<K, V> c1671r) throws ExecutionException {
            if (c1671r.m3185c()) {
                C1650g.m3092b(!Thread.holdsLock(c1686j), (Object) "Recursive load");
                try {
                    V e = c1671r.m3187e();
                    if (e == null) {
                        throw new InvalidCacheLoadException("CacheLoader returned null for key " + k + ".");
                    }
                    m3278a((C1686j) c1686j, this.f2038a.f2145r.m3121a());
                    return e;
                } finally {
                    this.f2051n.m3135b(1);
                }
            } else {
                throw new AssertionError();
            }
        }

        V m3269a(K k, int i, C1705i<K, V> c1705i, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            return m3270a((Object) k, i, (C1705i) c1705i, c1705i.m3384a((Object) k, (CacheLoader) cacheLoader));
        }

        C1908e<V> m3291b(K k, int i, C1705i<K, V> c1705i, CacheLoader<? super K, V> cacheLoader) {
            C1908e<V> a = c1705i.m3384a((Object) k, (CacheLoader) cacheLoader);
            a.m4457a(new C16871(this, k, i, c1705i, a), LocalCache.f2127b);
            return a;
        }

        V m3270a(K k, int i, C1705i<K, V> c1705i, C1908e<V> c1908e) throws ExecutionException {
            V v = null;
            try {
                v = C1925j.m4485a(c1908e);
                if (v == null) {
                    throw new InvalidCacheLoadException("CacheLoader returned null for key " + k + ".");
                }
                this.f2051n.m3134a(c1705i.m3392f());
                m3286a((Object) k, i, (C1705i) c1705i, (Object) v);
                return v;
            } finally {
                if (v == null) {
                    v = this.f2051n;
                    v.m3136b(c1705i.m3392f());
                    m3285a((Object) k, i, (C1705i) c1705i);
                }
            }
        }

        V m3265a(C1686j<K, V> c1686j, K k, int i, V v, long j, CacheLoader<? super K, V> cacheLoader) {
            if (!this.f2038a.m3515e() || j - c1686j.m3239h() <= this.f2038a.f2142o || c1686j.m3225a().m3185c()) {
                return v;
            }
            V a = m3268a((Object) k, i, (CacheLoader) cacheLoader, true);
            if (a != null) {
                return a;
            }
            return v;
        }

        V m3268a(K k, int i, CacheLoader<? super K, V> cacheLoader, boolean z) {
            V v = null;
            C1705i a = m3259a((Object) k, i, z);
            if (a != null) {
                Future b = m3291b(k, i, a, cacheLoader);
                if (b.isDone()) {
                    try {
                        v = C1925j.m4485a(b);
                    } catch (Throwable th) {
                    }
                }
            }
            return v;
        }

        C1705i<K, V> m3259a(K k, int i, boolean z) {
            lock();
            long a = this.f2038a.f2145r.m3121a();
            m3300c(a);
            AtomicReferenceArray atomicReferenceArray = this.f2043f;
            int length = i & (atomicReferenceArray.length() - 1);
            C1686j c1686j = (C1686j) atomicReferenceArray.get(length);
            C1686j c1686j2 = c1686j;
            while (c1686j2 != null) {
                Object d = c1686j2.m3234d();
                if (c1686j2.m3232c() == i && d != null && this.f2038a.f2134g.m2985a(k, d)) {
                    C1671r a2 = c1686j2.m3225a();
                    if (a2.m3185c() || (z && a - c1686j2.m3239h() < this.f2038a.f2142o)) {
                        unlock();
                        m3314n();
                        return null;
                    }
                    this.f2041d++;
                    C1671r c1705i = new C1705i(a2);
                    c1686j2.m3228a(c1705i);
                    unlock();
                    m3314n();
                    return c1705i;
                }
                try {
                    c1686j2 = c1686j2.m3229b();
                } catch (Throwable th) {
                    unlock();
                    m3314n();
                }
            }
            this.f2041d++;
            C1671r c1705i2 = new C1705i();
            c1686j = m3264a((Object) k, i, c1686j);
            c1686j.m3228a(c1705i2);
            atomicReferenceArray.set(length, c1686j);
            unlock();
            m3314n();
            return c1705i2;
        }

        void m3274a() {
            if (tryLock()) {
                try {
                    m3294b();
                } finally {
                    unlock();
                }
            }
        }

        void m3294b() {
            if (this.f2038a.m3523m()) {
                m3299c();
            }
            if (this.f2038a.m3524n()) {
                m3303d();
            }
        }

        void m3299c() {
            int i = 0;
            while (true) {
                Reference poll = this.f2045h.poll();
                if (poll != null) {
                    this.f2038a.m3505a((C1686j) poll);
                    int i2 = i + 1;
                    if (i2 != 16) {
                        i = i2;
                    } else {
                        return;
                    }
                }
                return;
            }
        }

        void m3303d() {
            int i = 0;
            while (true) {
                Reference poll = this.f2046i.poll();
                if (poll != null) {
                    this.f2038a.m3506a((C1671r) poll);
                    int i2 = i + 1;
                    if (i2 != 16) {
                        i = i2;
                    } else {
                        return;
                    }
                }
                return;
            }
        }

        void m3305e() {
            if (this.f2038a.m3523m()) {
                m3306f();
            }
            if (this.f2038a.m3524n()) {
                m3307g();
            }
        }

        void m3306f() {
            do {
            } while (this.f2045h.poll() != null);
        }

        void m3307g() {
            do {
            } while (this.f2046i.poll() != null);
        }

        void m3278a(C1686j<K, V> c1686j, long j) {
            if (this.f2038a.m3519i()) {
                c1686j.m3226a(j);
            }
            this.f2047j.add(c1686j);
        }

        void m3296b(C1686j<K, V> c1686j, long j) {
            if (this.f2038a.m3519i()) {
                c1686j.m3226a(j);
            }
            this.f2050m.add(c1686j);
        }

        void m3277a(C1686j<K, V> c1686j, int i, long j) {
            m3308h();
            this.f2040c += i;
            if (this.f2038a.m3519i()) {
                c1686j.m3226a(j);
            }
            if (this.f2038a.m3518h()) {
                c1686j.m3230b(j);
            }
            this.f2050m.add(c1686j);
            this.f2049l.add(c1686j);
        }

        void m3308h() {
            while (true) {
                C1686j c1686j = (C1686j) this.f2047j.poll();
                if (c1686j == null) {
                    return;
                }
                if (this.f2050m.contains(c1686j)) {
                    this.f2050m.add(c1686j);
                }
            }
        }

        void m3275a(long j) {
            if (tryLock()) {
                try {
                    m3295b(j);
                } finally {
                    unlock();
                }
            }
        }

        void m3295b(long j) {
            m3308h();
            C1686j c1686j;
            do {
                c1686j = (C1686j) this.f2049l.peek();
                if (c1686j == null || !this.f2038a.m3511b(c1686j, j)) {
                    do {
                        c1686j = (C1686j) this.f2050m.peek();
                        if (c1686j == null || !this.f2038a.m3511b(c1686j, j)) {
                            return;
                        }
                    } while (m3284a(c1686j, c1686j.m3232c(), RemovalCause.EXPIRED));
                    throw new AssertionError();
                }
            } while (m3284a(c1686j, c1686j.m3232c(), RemovalCause.EXPIRED));
            throw new AssertionError();
        }

        void m3279a(C1686j<K, V> c1686j, RemovalCause removalCause) {
            m3281a(c1686j.m3234d(), c1686j.m3232c(), c1686j.m3225a(), removalCause);
        }

        void m3281a(K k, int i, C1671r<K, V> c1671r, RemovalCause removalCause) {
            this.f2040c -= c1671r.m3181a();
            if (removalCause.m3545a()) {
                this.f2051n.m3132a();
            }
            if (this.f2038a.f2143p != LocalCache.f2129w) {
                this.f2038a.f2143p.offer(new C1736h(k, c1671r.get(), removalCause));
            }
        }

        void m3309i() {
            if (this.f2038a.m3507a()) {
                m3308h();
                while (((long) this.f2040c) > this.f2044g) {
                    C1686j j = m3310j();
                    if (!m3284a(j, j.m3232c(), RemovalCause.SIZE)) {
                        throw new AssertionError();
                    }
                }
            }
        }

        C1686j<K, V> m3310j() {
            for (C1686j<K, V> c1686j : this.f2050m) {
                if (c1686j.m3225a().m3181a() > 0) {
                    return c1686j;
                }
            }
            throw new AssertionError();
        }

        C1686j<K, V> m3289b(int i) {
            AtomicReferenceArray atomicReferenceArray = this.f2043f;
            return (C1686j) atomicReferenceArray.get((atomicReferenceArray.length() - 1) & i);
        }

        C1686j<K, V> m3262a(Object obj, int i) {
            for (C1686j<K, V> b = m3289b(i); b != null; b = b.m3229b()) {
                if (b.m3232c() == i) {
                    Object d = b.m3234d();
                    if (d == null) {
                        m3274a();
                    } else if (this.f2038a.f2134g.m2985a(obj, d)) {
                        return b;
                    }
                }
            }
            return null;
        }

        C1686j<K, V> m3263a(Object obj, int i, long j) {
            C1686j<K, V> a = m3262a(obj, i);
            if (a == null) {
                return null;
            }
            if (!this.f2038a.m3511b((C1686j) a, j)) {
                return a;
            }
            m3275a(j);
            return null;
        }

        V m3298c(C1686j<K, V> c1686j, long j) {
            if (c1686j.m3234d() == null) {
                m3274a();
                return null;
            }
            V v = c1686j.m3225a().get();
            if (v == null) {
                m3274a();
                return null;
            } else if (!this.f2038a.m3511b((C1686j) c1686j, j)) {
                return v;
            } else {
                m3275a(j);
                return null;
            }
        }

        V m3292b(Object obj, int i) {
            V v = null;
            try {
                if (this.f2039b != 0) {
                    long a = this.f2038a.f2145r.m3121a();
                    C1686j a2 = m3263a(obj, i, a);
                    if (a2 != null) {
                        Object obj2 = a2.m3225a().get();
                        if (obj2 != null) {
                            m3278a(a2, a);
                            v = m3265a(a2, a2.m3234d(), i, obj2, a, this.f2038a.f2148u);
                            m3313m();
                        } else {
                            m3274a();
                        }
                    }
                    return v;
                }
                m3313m();
                return v;
            } finally {
                m3313m();
            }
        }

        boolean m3301c(Object obj, int i) {
            boolean z = false;
            try {
                if (this.f2039b != 0) {
                    C1686j a = m3263a(obj, i, this.f2038a.f2145r.m3121a());
                    if (a != null) {
                        if (a.m3225a().get() != null) {
                            z = true;
                        }
                        m3313m();
                    }
                } else {
                    m3313m();
                }
                return z;
            } finally {
                m3313m();
            }
        }

        V m3272a(K k, int i, V v, boolean z) {
            lock();
            try {
                int i2;
                C1686j c1686j;
                long a = this.f2038a.f2145r.m3121a();
                m3300c(a);
                if (this.f2039b + 1 > this.f2042e) {
                    m3311k();
                    i2 = this.f2039b + 1;
                }
                AtomicReferenceArray atomicReferenceArray = this.f2043f;
                int length = i & (atomicReferenceArray.length() - 1);
                C1686j c1686j2 = (C1686j) atomicReferenceArray.get(length);
                for (c1686j = c1686j2; c1686j != null; c1686j = c1686j.m3229b()) {
                    Object d = c1686j.m3234d();
                    if (c1686j.m3232c() == i && d != null && this.f2038a.f2134g.m2985a(k, d)) {
                        C1671r a2 = c1686j.m3225a();
                        V v2 = a2.get();
                        if (v2 == null) {
                            this.f2041d++;
                            if (a2.m3186d()) {
                                m3281a((Object) k, i, a2, RemovalCause.COLLECTED);
                                m3280a(c1686j, (Object) k, (Object) v, a);
                                i2 = this.f2039b;
                            } else {
                                m3280a(c1686j, (Object) k, (Object) v, a);
                                i2 = this.f2039b + 1;
                            }
                            this.f2039b = i2;
                            m3309i();
                            return null;
                        } else if (z) {
                            m3296b(c1686j, a);
                            unlock();
                            m3314n();
                            return v2;
                        } else {
                            this.f2041d++;
                            m3281a((Object) k, i, a2, RemovalCause.REPLACED);
                            m3280a(c1686j, (Object) k, (Object) v, a);
                            m3309i();
                            unlock();
                            m3314n();
                            return v2;
                        }
                    }
                }
                this.f2041d++;
                c1686j = m3264a((Object) k, i, c1686j2);
                m3280a(c1686j, (Object) k, (Object) v, a);
                atomicReferenceArray.set(length, c1686j);
                this.f2039b++;
                m3309i();
                unlock();
                m3314n();
                return null;
            } finally {
                unlock();
                m3314n();
            }
        }

        void m3311k() {
            AtomicReferenceArray atomicReferenceArray = this.f2043f;
            int length = atomicReferenceArray.length();
            if (length < 1073741824) {
                int i = this.f2039b;
                AtomicReferenceArray a = m3273a(length << 1);
                this.f2042e = (a.length() * 3) / 4;
                int length2 = a.length() - 1;
                int i2 = 0;
                while (i2 < length) {
                    int i3;
                    C1686j c1686j = (C1686j) atomicReferenceArray.get(i2);
                    if (c1686j != null) {
                        C1686j b = c1686j.m3229b();
                        int c = c1686j.m3232c() & length2;
                        if (b == null) {
                            a.set(c, c1686j);
                            i3 = i;
                        } else {
                            C1686j c1686j2;
                            C1686j c1686j3 = c1686j;
                            while (b != null) {
                                i3 = b.m3232c() & length2;
                                if (i3 != c) {
                                    c1686j2 = b;
                                } else {
                                    i3 = c;
                                    c1686j2 = c1686j3;
                                }
                                b = b.m3229b();
                                c1686j3 = c1686j2;
                                c = i3;
                            }
                            a.set(c, c1686j3);
                            c1686j2 = c1686j;
                            i3 = i;
                            while (c1686j2 != c1686j3) {
                                int i4;
                                int c2 = c1686j2.m3232c() & length2;
                                c1686j = m3260a(c1686j2, (C1686j) a.get(c2));
                                if (c1686j != null) {
                                    a.set(c2, c1686j);
                                    i4 = i3;
                                } else {
                                    m3276a(c1686j2);
                                    i4 = i3 - 1;
                                }
                                c1686j2 = c1686j2.m3229b();
                                i3 = i4;
                            }
                        }
                    } else {
                        i3 = i;
                    }
                    i2++;
                    i = i3;
                }
                this.f2043f = a;
                this.f2039b = i;
            }
        }

        boolean m3288a(K k, int i, V v, V v2) {
            lock();
            try {
                long a = this.f2038a.f2145r.m3121a();
                m3300c(a);
                AtomicReferenceArray atomicReferenceArray = this.f2043f;
                int length = i & (atomicReferenceArray.length() - 1);
                C1686j c1686j = (C1686j) atomicReferenceArray.get(length);
                for (C1686j c1686j2 = c1686j; c1686j2 != null; c1686j2 = c1686j2.m3229b()) {
                    Object d = c1686j2.m3234d();
                    if (c1686j2.m3232c() == i && d != null && this.f2038a.f2134g.m2985a(k, d)) {
                        C1671r a2 = c1686j2.m3225a();
                        Object obj = a2.get();
                        if (obj == null) {
                            if (a2.m3186d()) {
                                int i2 = this.f2039b - 1;
                                this.f2041d++;
                                C1686j a3 = m3261a(c1686j, c1686j2, d, i, a2, RemovalCause.COLLECTED);
                                int i3 = this.f2039b - 1;
                                atomicReferenceArray.set(length, a3);
                                this.f2039b = i3;
                            }
                            unlock();
                            m3314n();
                            return false;
                        } else if (this.f2038a.f2135h.m2985a(v, obj)) {
                            this.f2041d++;
                            m3281a((Object) k, i, a2, RemovalCause.REPLACED);
                            m3280a(c1686j2, (Object) k, (Object) v2, a);
                            m3309i();
                            unlock();
                            m3314n();
                            return true;
                        } else {
                            m3296b(c1686j2, a);
                            unlock();
                            m3314n();
                            return false;
                        }
                    }
                }
                unlock();
                m3314n();
                return false;
            } catch (Throwable th) {
                unlock();
                m3314n();
            }
        }

        V m3271a(K k, int i, V v) {
            lock();
            try {
                long a = this.f2038a.f2145r.m3121a();
                m3300c(a);
                AtomicReferenceArray atomicReferenceArray = this.f2043f;
                int length = i & (atomicReferenceArray.length() - 1);
                C1686j c1686j = (C1686j) atomicReferenceArray.get(length);
                for (C1686j c1686j2 = c1686j; c1686j2 != null; c1686j2 = c1686j2.m3229b()) {
                    Object d = c1686j2.m3234d();
                    if (c1686j2.m3232c() == i && d != null && this.f2038a.f2134g.m2985a(k, d)) {
                        C1671r a2 = c1686j2.m3225a();
                        V v2 = a2.get();
                        if (v2 == null) {
                            if (a2.m3186d()) {
                                int i2 = this.f2039b - 1;
                                this.f2041d++;
                                C1686j a3 = m3261a(c1686j, c1686j2, d, i, a2, RemovalCause.COLLECTED);
                                int i3 = this.f2039b - 1;
                                atomicReferenceArray.set(length, a3);
                                this.f2039b = i3;
                            }
                            unlock();
                            m3314n();
                            return null;
                        }
                        this.f2041d++;
                        m3281a((Object) k, i, a2, RemovalCause.REPLACED);
                        m3280a(c1686j2, (Object) k, (Object) v, a);
                        m3309i();
                        unlock();
                        m3314n();
                        return v2;
                    }
                }
                unlock();
                m3314n();
                return null;
            } catch (Throwable th) {
                unlock();
                m3314n();
            }
        }

        V m3302d(Object obj, int i) {
            lock();
            try {
                m3300c(this.f2038a.f2145r.m3121a());
                int i2 = this.f2039b - 1;
                AtomicReferenceArray atomicReferenceArray = this.f2043f;
                int length = i & (atomicReferenceArray.length() - 1);
                C1686j c1686j = (C1686j) atomicReferenceArray.get(length);
                for (C1686j c1686j2 = c1686j; c1686j2 != null; c1686j2 = c1686j2.m3229b()) {
                    Object d = c1686j2.m3234d();
                    if (c1686j2.m3232c() == i && d != null && this.f2038a.f2134g.m2985a(obj, d)) {
                        RemovalCause removalCause;
                        C1671r a = c1686j2.m3225a();
                        V v = a.get();
                        if (v != null) {
                            removalCause = RemovalCause.EXPLICIT;
                        } else if (a.m3186d()) {
                            removalCause = RemovalCause.COLLECTED;
                        } else {
                            unlock();
                            m3314n();
                            return null;
                        }
                        this.f2041d++;
                        C1686j a2 = m3261a(c1686j, c1686j2, d, i, a, removalCause);
                        i2 = this.f2039b - 1;
                        atomicReferenceArray.set(length, a2);
                        this.f2039b = i2;
                        return v;
                    }
                }
                unlock();
                m3314n();
                return null;
            } finally {
                unlock();
                m3314n();
            }
        }

        boolean m3286a(K k, int i, C1705i<K, V> c1705i, V v) {
            lock();
            try {
                C1686j c1686j;
                long a = this.f2038a.f2145r.m3121a();
                m3300c(a);
                int i2 = this.f2039b + 1;
                if (i2 > this.f2042e) {
                    m3311k();
                    i2 = this.f2039b + 1;
                }
                AtomicReferenceArray atomicReferenceArray = this.f2043f;
                int length = i & (atomicReferenceArray.length() - 1);
                C1686j c1686j2 = (C1686j) atomicReferenceArray.get(length);
                for (c1686j = c1686j2; c1686j != null; c1686j = c1686j.m3229b()) {
                    Object d = c1686j.m3234d();
                    if (c1686j.m3232c() == i && d != null && this.f2038a.f2134g.m2985a(k, d)) {
                        C1671r a2 = c1686j.m3225a();
                        d = a2.get();
                        if (c1705i == a2 || (d == null && a2 != LocalCache.f2128v)) {
                            this.f2041d++;
                            if (c1705i.m3390d()) {
                                m3281a((Object) k, i, (C1671r) c1705i, d == null ? RemovalCause.COLLECTED : RemovalCause.REPLACED);
                                i2--;
                            }
                            m3280a(c1686j, (Object) k, (Object) v, a);
                            this.f2039b = i2;
                            m3309i();
                            return true;
                        }
                        m3281a((Object) k, i, new C1719z(v, 0), RemovalCause.REPLACED);
                        unlock();
                        m3314n();
                        return false;
                    }
                }
                this.f2041d++;
                c1686j = m3264a((Object) k, i, c1686j2);
                m3280a(c1686j, (Object) k, (Object) v, a);
                atomicReferenceArray.set(length, c1686j);
                this.f2039b = i2;
                m3309i();
                unlock();
                m3314n();
                return true;
            } finally {
                unlock();
                m3314n();
            }
        }

        boolean m3297b(Object obj, int i, Object obj2) {
            lock();
            try {
                m3300c(this.f2038a.f2145r.m3121a());
                int i2 = this.f2039b - 1;
                AtomicReferenceArray atomicReferenceArray = this.f2043f;
                int length = i & (atomicReferenceArray.length() - 1);
                C1686j c1686j = (C1686j) atomicReferenceArray.get(length);
                for (C1686j c1686j2 = c1686j; c1686j2 != null; c1686j2 = c1686j2.m3229b()) {
                    Object d = c1686j2.m3234d();
                    if (c1686j2.m3232c() == i && d != null && this.f2038a.f2134g.m2985a(obj, d)) {
                        RemovalCause removalCause;
                        C1671r a = c1686j2.m3225a();
                        Object obj3 = a.get();
                        if (this.f2038a.f2135h.m2985a(obj2, obj3)) {
                            removalCause = RemovalCause.EXPLICIT;
                        } else {
                            if (obj3 == null) {
                                if (a.m3186d()) {
                                    removalCause = RemovalCause.COLLECTED;
                                }
                            }
                            unlock();
                            m3314n();
                            return false;
                        }
                        this.f2041d++;
                        C1686j a2 = m3261a(c1686j, c1686j2, d, i, a, removalCause);
                        int i3 = this.f2039b - 1;
                        atomicReferenceArray.set(length, a2);
                        this.f2039b = i3;
                        boolean z = removalCause == RemovalCause.EXPLICIT;
                        unlock();
                        m3314n();
                        return z;
                    }
                }
                unlock();
                m3314n();
                return false;
            } catch (Throwable th) {
                unlock();
                m3314n();
            }
        }

        void m3312l() {
            if (this.f2039b != 0) {
                lock();
                try {
                    AtomicReferenceArray atomicReferenceArray = this.f2043f;
                    for (int i = 0; i < atomicReferenceArray.length(); i++) {
                        for (C1686j c1686j = (C1686j) atomicReferenceArray.get(i); c1686j != null; c1686j = c1686j.m3229b()) {
                            if (c1686j.m3225a().m3186d()) {
                                m3279a(c1686j, RemovalCause.EXPLICIT);
                            }
                        }
                    }
                    for (int i2 = 0; i2 < atomicReferenceArray.length(); i2++) {
                        atomicReferenceArray.set(i2, null);
                    }
                    m3305e();
                    this.f2049l.clear();
                    this.f2050m.clear();
                    this.f2048k.set(0);
                    this.f2041d++;
                    this.f2039b = 0;
                } finally {
                    unlock();
                    m3314n();
                }
            }
        }

        C1686j<K, V> m3261a(C1686j<K, V> c1686j, C1686j<K, V> c1686j2, K k, int i, C1671r<K, V> c1671r, RemovalCause removalCause) {
            m3281a((Object) k, i, (C1671r) c1671r, removalCause);
            this.f2049l.remove(c1686j2);
            this.f2050m.remove(c1686j2);
            if (!c1671r.m3185c()) {
                return m3290b((C1686j) c1686j, (C1686j) c1686j2);
            }
            c1671r.m3183a(null);
            return c1686j;
        }

        C1686j<K, V> m3290b(C1686j<K, V> c1686j, C1686j<K, V> c1686j2) {
            int i = this.f2039b;
            C1686j<K, V> b = c1686j2.m3229b();
            C1686j b2;
            while (b2 != c1686j2) {
                int i2;
                C1686j<K, V> a = m3260a(b2, (C1686j) b);
                if (a != null) {
                    i2 = i;
                } else {
                    m3276a(b2);
                    C1686j<K, V> c1686j3 = b;
                    i2 = i - 1;
                    a = c1686j3;
                }
                b2 = b2.m3229b();
                i = i2;
                b = a;
            }
            this.f2039b = i;
            return b;
        }

        void m3276a(C1686j<K, V> c1686j) {
            m3279a((C1686j) c1686j, RemovalCause.COLLECTED);
            this.f2049l.remove(c1686j);
            this.f2050m.remove(c1686j);
        }

        boolean m3283a(C1686j<K, V> c1686j, int i) {
            lock();
            try {
                int i2 = this.f2039b - 1;
                AtomicReferenceArray atomicReferenceArray = this.f2043f;
                int length = i & (atomicReferenceArray.length() - 1);
                C1686j c1686j2 = (C1686j) atomicReferenceArray.get(length);
                for (C1686j c1686j3 = c1686j2; c1686j3 != null; c1686j3 = c1686j3.m3229b()) {
                    if (c1686j3 == c1686j) {
                        this.f2041d++;
                        C1686j a = m3261a(c1686j2, c1686j3, c1686j3.m3234d(), i, c1686j3.m3225a(), RemovalCause.COLLECTED);
                        int i3 = this.f2039b - 1;
                        atomicReferenceArray.set(length, a);
                        this.f2039b = i3;
                        return true;
                    }
                }
                unlock();
                m3314n();
                return false;
            } finally {
                unlock();
                m3314n();
            }
        }

        boolean m3287a(K k, int i, C1671r<K, V> c1671r) {
            boolean z = false;
            lock();
            try {
                int i2 = this.f2039b - 1;
                AtomicReferenceArray atomicReferenceArray = this.f2043f;
                int length = i & (atomicReferenceArray.length() - 1);
                C1686j c1686j = (C1686j) atomicReferenceArray.get(length);
                for (C1686j c1686j2 = c1686j; c1686j2 != null; c1686j2 = c1686j2.m3229b()) {
                    Object d = c1686j2.m3234d();
                    if (c1686j2.m3232c() == i && d != null && this.f2038a.f2134g.m2985a(k, d)) {
                        if (c1686j2.m3225a() == c1671r) {
                            this.f2041d++;
                            C1686j a = m3261a(c1686j, c1686j2, d, i, (C1671r) c1671r, RemovalCause.COLLECTED);
                            i2 = this.f2039b - 1;
                            atomicReferenceArray.set(length, a);
                            this.f2039b = i2;
                            z = true;
                        } else {
                            unlock();
                            if (!isHeldByCurrentThread()) {
                                m3314n();
                            }
                        }
                        return z;
                    }
                }
                unlock();
                if (!isHeldByCurrentThread()) {
                    m3314n();
                }
                return z;
            } finally {
                unlock();
                if (!isHeldByCurrentThread()) {
                    m3314n();
                }
            }
        }

        boolean m3285a(K k, int i, C1705i<K, V> c1705i) {
            lock();
            try {
                AtomicReferenceArray atomicReferenceArray = this.f2043f;
                int length = i & (atomicReferenceArray.length() - 1);
                C1686j c1686j = (C1686j) atomicReferenceArray.get(length);
                C1686j c1686j2 = c1686j;
                while (c1686j2 != null) {
                    Object d = c1686j2.m3234d();
                    if (c1686j2.m3232c() != i || d == null || !this.f2038a.f2134g.m2985a(k, d)) {
                        c1686j2 = c1686j2.m3229b();
                    } else if (c1686j2.m3225a() == c1705i) {
                        if (c1705i.m3390d()) {
                            c1686j2.m3228a(c1705i.m3393g());
                        } else {
                            atomicReferenceArray.set(length, m3290b(c1686j, c1686j2));
                        }
                        unlock();
                        m3314n();
                        return true;
                    } else {
                        unlock();
                        m3314n();
                        return false;
                    }
                }
                unlock();
                m3314n();
                return false;
            } catch (Throwable th) {
                unlock();
                m3314n();
            }
        }

        boolean m3284a(C1686j<K, V> c1686j, int i, RemovalCause removalCause) {
            int i2 = this.f2039b - 1;
            AtomicReferenceArray atomicReferenceArray = this.f2043f;
            int length = i & (atomicReferenceArray.length() - 1);
            C1686j c1686j2 = (C1686j) atomicReferenceArray.get(length);
            for (C1686j c1686j3 = c1686j2; c1686j3 != null; c1686j3 = c1686j3.m3229b()) {
                if (c1686j3 == c1686j) {
                    this.f2041d++;
                    C1686j a = m3261a(c1686j2, c1686j3, c1686j3.m3234d(), i, c1686j3.m3225a(), removalCause);
                    int i3 = this.f2039b - 1;
                    atomicReferenceArray.set(length, a);
                    this.f2039b = i3;
                    return true;
                }
            }
            return false;
        }

        void m3313m() {
            if ((this.f2048k.incrementAndGet() & 63) == 0) {
                m3315o();
            }
        }

        void m3300c(long j) {
            m3304d(j);
        }

        void m3314n() {
            m3316p();
        }

        void m3315o() {
            m3304d(this.f2038a.f2145r.m3121a());
            m3316p();
        }

        void m3304d(long j) {
            if (tryLock()) {
                try {
                    m3294b();
                    m3295b(j);
                    this.f2048k.set(0);
                } finally {
                    unlock();
                }
            }
        }

        void m3316p() {
            if (!isHeldByCurrentThread()) {
                this.f2038a.m3525r();
            }
        }
    }

    enum Strength {
        STRONG {
            <K, V> C1671r<K, V> m3320a(Segment<K, V> segment, C1686j<K, V> c1686j, V v, int i) {
                return i == 1 ? new C1710o(v) : new C1719z(v, i);
            }

            Equivalence<Object> m3319a() {
                return Equivalence.m2982a();
            }
        },
        SOFT {
            <K, V> C1671r<K, V> m3322a(Segment<K, V> segment, C1686j<K, V> c1686j, V v, int i) {
                return i == 1 ? new C1706k(segment.f2046i, v, c1686j) : new C1718y(segment.f2046i, v, c1686j, i);
            }

            Equivalence<Object> m3321a() {
                return Equivalence.m2983b();
            }
        },
        WEAK {
            <K, V> C1671r<K, V> m3324a(Segment<K, V> segment, C1686j<K, V> c1686j, V v, int i) {
                return i == 1 ? new C1692w(segment.f2046i, v, c1686j) : new aa(segment.f2046i, v, c1686j, i);
            }

            Equivalence<Object> m3323a() {
                return Equivalence.m2983b();
            }
        };

        abstract Equivalence<Object> m3317a();

        abstract <K, V> C1671r<K, V> m3318a(Segment<K, V> segment, C1686j<K, V> c1686j, V v, int i);
    }

    /* renamed from: com.google.common.cache.LocalCache.a */
    abstract class C1691a<T> extends AbstractSet<T> {
        final ConcurrentMap<?, ?> f2056a;
        final /* synthetic */ LocalCache f2057b;

        C1691a(LocalCache localCache, ConcurrentMap<?, ?> concurrentMap) {
            this.f2057b = localCache;
            this.f2056a = concurrentMap;
        }

        public int size() {
            return this.f2056a.size();
        }

        public boolean isEmpty() {
            return this.f2056a.isEmpty();
        }

        public void clear() {
            this.f2056a.clear();
        }
    }

    /* renamed from: com.google.common.cache.LocalCache.w */
    static class C1692w<K, V> extends WeakReference<V> implements C1671r<K, V> {
        final C1686j<K, V> f2058a;

        C1692w(ReferenceQueue<V> referenceQueue, V v, C1686j<K, V> c1686j) {
            super(v, referenceQueue);
            this.f2058a = c1686j;
        }

        public int m3325a() {
            return 1;
        }

        public C1686j<K, V> m3328b() {
            return this.f2058a;
        }

        public void m3327a(V v) {
        }

        public C1671r<K, V> m3326a(ReferenceQueue<V> referenceQueue, V v, C1686j<K, V> c1686j) {
            return new C1692w(referenceQueue, v, c1686j);
        }

        public boolean m3329c() {
            return false;
        }

        public boolean m3330d() {
            return true;
        }

        public V m3331e() {
            return get();
        }
    }

    static final class aa<K, V> extends C1692w<K, V> {
        final int f2059b;

        aa(ReferenceQueue<V> referenceQueue, V v, C1686j<K, V> c1686j, int i) {
            super(referenceQueue, v, c1686j);
            this.f2059b = i;
        }

        public int m3332a() {
            return this.f2059b;
        }

        public C1671r<K, V> m3333a(ReferenceQueue<V> referenceQueue, V v, C1686j<K, V> c1686j) {
            return new aa(referenceQueue, v, c1686j, this.f2059b);
        }
    }

    /* renamed from: com.google.common.cache.LocalCache.b */
    static abstract class C1693b<K, V> implements C1686j<K, V> {
        C1693b() {
        }

        public C1671r<K, V> m3334a() {
            throw new UnsupportedOperationException();
        }

        public void m3337a(C1671r<K, V> c1671r) {
            throw new UnsupportedOperationException();
        }

        public C1686j<K, V> m3338b() {
            throw new UnsupportedOperationException();
        }

        public int m3341c() {
            throw new UnsupportedOperationException();
        }

        public K m3343d() {
            throw new UnsupportedOperationException();
        }

        public long m3345e() {
            throw new UnsupportedOperationException();
        }

        public void m3335a(long j) {
            throw new UnsupportedOperationException();
        }

        public C1686j<K, V> m3346f() {
            throw new UnsupportedOperationException();
        }

        public void m3336a(C1686j<K, V> c1686j) {
            throw new UnsupportedOperationException();
        }

        public C1686j<K, V> m3347g() {
            throw new UnsupportedOperationException();
        }

        public void m3340b(C1686j<K, V> c1686j) {
            throw new UnsupportedOperationException();
        }

        public long m3348h() {
            throw new UnsupportedOperationException();
        }

        public void m3339b(long j) {
            throw new UnsupportedOperationException();
        }

        public C1686j<K, V> m3349i() {
            throw new UnsupportedOperationException();
        }

        public void m3342c(C1686j<K, V> c1686j) {
            throw new UnsupportedOperationException();
        }

        public C1686j<K, V> m3350j() {
            throw new UnsupportedOperationException();
        }

        public void m3344d(C1686j<K, V> c1686j) {
            throw new UnsupportedOperationException();
        }
    }

    static final class ab<K, V> extends AbstractQueue<C1686j<K, V>> {
        final C1686j<K, V> f2065a;

        /* renamed from: com.google.common.cache.LocalCache.ab.1 */
        class C16941 extends C1693b<K, V> {
            C1686j<K, V> f2060a;
            C1686j<K, V> f2061b;
            final /* synthetic */ ab f2062c;

            C16941(ab abVar) {
                this.f2062c = abVar;
                this.f2060a = this;
                this.f2061b = this;
            }

            public long m3354h() {
                return Long.MAX_VALUE;
            }

            public void m3351b(long j) {
            }

            public C1686j<K, V> m3355i() {
                return this.f2060a;
            }

            public void m3352c(C1686j<K, V> c1686j) {
                this.f2060a = c1686j;
            }

            public C1686j<K, V> m3356j() {
                return this.f2061b;
            }

            public void m3353d(C1686j<K, V> c1686j) {
                this.f2061b = c1686j;
            }
        }

        /* renamed from: com.google.common.cache.LocalCache.ab.2 */
        class C16962 extends C1695d<C1686j<K, V>> {
            final /* synthetic */ ab f2064a;

            C16962(ab abVar, C1686j c1686j) {
                this.f2064a = abVar;
                super(c1686j);
            }

            protected C1686j<K, V> m3358a(C1686j<K, V> c1686j) {
                C1686j<K, V> i = c1686j.m3240i();
                return i == this.f2064a.f2065a ? null : i;
            }
        }

        ab() {
            this.f2065a = new C16941(this);
        }

        public /* synthetic */ boolean offer(Object obj) {
            return m3361a((C1686j) obj);
        }

        public /* synthetic */ Object peek() {
            return m3360a();
        }

        public /* synthetic */ Object poll() {
            return m3362b();
        }

        public boolean m3361a(C1686j<K, V> c1686j) {
            LocalCache.m3496b(c1686j.m3241j(), c1686j.m3240i());
            LocalCache.m3496b(this.f2065a.m3241j(), (C1686j) c1686j);
            LocalCache.m3496b((C1686j) c1686j, this.f2065a);
            return true;
        }

        public C1686j<K, V> m3360a() {
            C1686j<K, V> i = this.f2065a.m3240i();
            return i == this.f2065a ? null : i;
        }

        public C1686j<K, V> m3362b() {
            C1686j<K, V> i = this.f2065a.m3240i();
            if (i == this.f2065a) {
                return null;
            }
            remove(i);
            return i;
        }

        public boolean remove(Object obj) {
            C1686j c1686j = (C1686j) obj;
            C1686j j = c1686j.m3241j();
            C1686j i = c1686j.m3240i();
            LocalCache.m3496b(j, i);
            LocalCache.m3497c(c1686j);
            return i != NullEntry.INSTANCE;
        }

        public boolean contains(Object obj) {
            return ((C1686j) obj).m3240i() != NullEntry.INSTANCE;
        }

        public boolean isEmpty() {
            return this.f2065a.m3240i() == this.f2065a;
        }

        public int size() {
            int i = 0;
            for (C1686j i2 = this.f2065a.m3240i(); i2 != this.f2065a; i2 = i2.m3240i()) {
                i++;
            }
            return i;
        }

        public void clear() {
            C1686j i = this.f2065a.m3240i();
            while (i != this.f2065a) {
                C1686j i2 = i.m3240i();
                LocalCache.m3497c(i);
                i = i2;
            }
            this.f2065a.m3233c(this.f2065a);
            this.f2065a.m3235d(this.f2065a);
        }

        public Iterator<C1686j<K, V>> iterator() {
            return new C16962(this, m3360a());
        }
    }

    final class ac implements Entry<K, V> {
        final K f2066a;
        V f2067b;
        final /* synthetic */ LocalCache f2068c;

        ac(LocalCache localCache, K k, V v) {
            this.f2068c = localCache;
            this.f2066a = k;
            this.f2067b = v;
        }

        public K getKey() {
            return this.f2066a;
        }

        public V getValue() {
            return this.f2067b;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            if (this.f2066a.equals(entry.getKey()) && this.f2067b.equals(entry.getValue())) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.f2066a.hashCode() ^ this.f2067b.hashCode();
        }

        public V setValue(V v) {
            throw new UnsupportedOperationException();
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* renamed from: com.google.common.cache.LocalCache.c */
    static final class C1699c<K, V> extends AbstractQueue<C1686j<K, V>> {
        final C1686j<K, V> f2073a;

        /* renamed from: com.google.common.cache.LocalCache.c.1 */
        class C16971 extends C1693b<K, V> {
            C1686j<K, V> f2069a;
            C1686j<K, V> f2070b;
            final /* synthetic */ C1699c f2071c;

            C16971(C1699c c1699c) {
                this.f2071c = c1699c;
                this.f2069a = this;
                this.f2070b = this;
            }

            public long m3366e() {
                return Long.MAX_VALUE;
            }

            public void m3363a(long j) {
            }

            public C1686j<K, V> m3367f() {
                return this.f2069a;
            }

            public void m3364a(C1686j<K, V> c1686j) {
                this.f2069a = c1686j;
            }

            public C1686j<K, V> m3368g() {
                return this.f2070b;
            }

            public void m3365b(C1686j<K, V> c1686j) {
                this.f2070b = c1686j;
            }
        }

        /* renamed from: com.google.common.cache.LocalCache.c.2 */
        class C16982 extends C1695d<C1686j<K, V>> {
            final /* synthetic */ C1699c f2072a;

            C16982(C1699c c1699c, C1686j c1686j) {
                this.f2072a = c1699c;
                super(c1686j);
            }

            protected C1686j<K, V> m3369a(C1686j<K, V> c1686j) {
                C1686j<K, V> f = c1686j.m3237f();
                return f == this.f2072a.f2073a ? null : f;
            }
        }

        C1699c() {
            this.f2073a = new C16971(this);
        }

        public /* synthetic */ boolean offer(Object obj) {
            return m3372a((C1686j) obj);
        }

        public /* synthetic */ Object peek() {
            return m3371a();
        }

        public /* synthetic */ Object poll() {
            return m3373b();
        }

        public boolean m3372a(C1686j<K, V> c1686j) {
            LocalCache.m3494a(c1686j.m3238g(), c1686j.m3237f());
            LocalCache.m3494a(this.f2073a.m3238g(), (C1686j) c1686j);
            LocalCache.m3494a((C1686j) c1686j, this.f2073a);
            return true;
        }

        public C1686j<K, V> m3371a() {
            C1686j<K, V> f = this.f2073a.m3237f();
            return f == this.f2073a ? null : f;
        }

        public C1686j<K, V> m3373b() {
            C1686j<K, V> f = this.f2073a.m3237f();
            if (f == this.f2073a) {
                return null;
            }
            remove(f);
            return f;
        }

        public boolean remove(Object obj) {
            C1686j c1686j = (C1686j) obj;
            C1686j g = c1686j.m3238g();
            C1686j f = c1686j.m3237f();
            LocalCache.m3494a(g, f);
            LocalCache.m3495b(c1686j);
            return f != NullEntry.INSTANCE;
        }

        public boolean contains(Object obj) {
            return ((C1686j) obj).m3237f() != NullEntry.INSTANCE;
        }

        public boolean isEmpty() {
            return this.f2073a.m3237f() == this.f2073a;
        }

        public int size() {
            int i = 0;
            for (C1686j f = this.f2073a.m3237f(); f != this.f2073a; f = f.m3237f()) {
                i++;
            }
            return i;
        }

        public void clear() {
            C1686j f = this.f2073a.m3237f();
            while (f != this.f2073a) {
                C1686j f2 = f.m3237f();
                LocalCache.m3495b(f);
                f = f2;
            }
            this.f2073a.m3227a(this.f2073a);
            this.f2073a.m3231b(this.f2073a);
        }

        public Iterator<C1686j<K, V>> iterator() {
            return new C16982(this, m3371a());
        }
    }

    /* renamed from: com.google.common.cache.LocalCache.f */
    abstract class C1700f<T> implements Iterator<T> {
        int f2074b;
        int f2075c;
        Segment<K, V> f2076d;
        AtomicReferenceArray<C1686j<K, V>> f2077e;
        C1686j<K, V> f2078f;
        ac f2079g;
        ac f2080h;
        final /* synthetic */ LocalCache f2081i;

        C1700f(LocalCache localCache) {
            this.f2081i = localCache;
            this.f2074b = localCache.f2132e.length - 1;
            this.f2075c = -1;
            m3375b();
        }

        final void m3375b() {
            this.f2079g = null;
            if (!m3376c() && !m3377d()) {
                while (this.f2074b >= 0) {
                    Segment[] segmentArr = this.f2081i.f2132e;
                    int i = this.f2074b;
                    this.f2074b = i - 1;
                    this.f2076d = segmentArr[i];
                    if (this.f2076d.f2039b != 0) {
                        this.f2077e = this.f2076d.f2043f;
                        this.f2075c = this.f2077e.length() - 1;
                        if (m3377d()) {
                            return;
                        }
                    }
                }
            }
        }

        boolean m3376c() {
            if (this.f2078f != null) {
                this.f2078f = this.f2078f.m3229b();
                while (this.f2078f != null) {
                    if (m3374a(this.f2078f)) {
                        return true;
                    }
                    this.f2078f = this.f2078f.m3229b();
                }
            }
            return false;
        }

        boolean m3377d() {
            while (this.f2075c >= 0) {
                AtomicReferenceArray atomicReferenceArray = this.f2077e;
                int i = this.f2075c;
                this.f2075c = i - 1;
                C1686j c1686j = (C1686j) atomicReferenceArray.get(i);
                this.f2078f = c1686j;
                if (c1686j != null && (m3374a(this.f2078f) || m3376c())) {
                    return true;
                }
            }
            return false;
        }

        boolean m3374a(C1686j<K, V> c1686j) {
            try {
                long a = this.f2081i.f2145r.m3121a();
                Object d = c1686j.m3234d();
                Object a2 = this.f2081i.m3503a((C1686j) c1686j, a);
                if (a2 != null) {
                    this.f2079g = new ac(this.f2081i, d, a2);
                    return true;
                }
                this.f2076d.m3313m();
                return false;
            } finally {
                this.f2076d.m3313m();
            }
        }

        public boolean hasNext() {
            return this.f2079g != null;
        }

        ac m3378e() {
            if (this.f2079g == null) {
                throw new NoSuchElementException();
            }
            this.f2080h = this.f2079g;
            m3375b();
            return this.f2080h;
        }

        public void remove() {
            C1650g.m3091b(this.f2080h != null);
            this.f2081i.remove(this.f2080h.getKey());
            this.f2080h = null;
        }
    }

    /* renamed from: com.google.common.cache.LocalCache.d */
    final class C1701d extends C1700f<Entry<K, V>> {
        final /* synthetic */ LocalCache f2082a;

        C1701d(LocalCache localCache) {
            this.f2082a = localCache;
            super(localCache);
        }

        public /* synthetic */ Object next() {
            return m3379a();
        }

        public Entry<K, V> m3379a() {
            return m3378e();
        }
    }

    /* renamed from: com.google.common.cache.LocalCache.e */
    final class C1702e extends C1691a<Entry<K, V>> {
        final /* synthetic */ LocalCache f2083c;

        C1702e(LocalCache localCache, ConcurrentMap<?, ?> concurrentMap) {
            this.f2083c = localCache;
            super(localCache, concurrentMap);
        }

        public Iterator<Entry<K, V>> iterator() {
            return new C1701d(this.f2083c);
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            Object key = entry.getKey();
            if (key == null) {
                return false;
            }
            key = this.f2083c.get(key);
            if (key == null || !this.f2083c.f2135h.m2985a(entry.getValue(), key)) {
                return false;
            }
            return true;
        }

        public boolean remove(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            Object key = entry.getKey();
            if (key == null || !this.f2083c.remove(key, entry.getValue())) {
                return false;
            }
            return true;
        }
    }

    /* renamed from: com.google.common.cache.LocalCache.g */
    final class C1703g extends C1700f<K> {
        final /* synthetic */ LocalCache f2084a;

        C1703g(LocalCache localCache) {
            this.f2084a = localCache;
            super(localCache);
        }

        public K next() {
            return m3378e().getKey();
        }
    }

    /* renamed from: com.google.common.cache.LocalCache.h */
    final class C1704h extends C1691a<K> {
        final /* synthetic */ LocalCache f2085c;

        C1704h(LocalCache localCache, ConcurrentMap<?, ?> concurrentMap) {
            this.f2085c = localCache;
            super(localCache, concurrentMap);
        }

        public Iterator<K> iterator() {
            return new C1703g(this.f2085c);
        }

        public boolean contains(Object obj) {
            return this.a.containsKey(obj);
        }

        public boolean remove(Object obj) {
            return this.a.remove(obj) != null;
        }
    }

    /* renamed from: com.google.common.cache.LocalCache.i */
    static class C1705i<K, V> implements C1671r<K, V> {
        volatile C1671r<K, V> f2086a;
        final C1924i<V> f2087b;
        final C1658j f2088c;

        public C1705i() {
            this(LocalCache.m3498o());
        }

        public C1705i(C1671r<K, V> c1671r) {
            this.f2087b = C1924i.m4482b();
            this.f2088c = new C1658j();
            this.f2086a = c1671r;
        }

        public boolean m3389c() {
            return true;
        }

        public boolean m3390d() {
            return this.f2086a.m3186d();
        }

        public int m3382a() {
            return this.f2086a.m3181a();
        }

        public boolean m3388b(V v) {
            return this.f2087b.m4483a((Object) v);
        }

        public boolean m3386a(Throwable th) {
            return C1705i.m3380a(this.f2087b, th);
        }

        private static boolean m3380a(C1924i<?> c1924i, Throwable th) {
            try {
                return c1924i.m4484a(th);
            } catch (Error e) {
                return false;
            }
        }

        private C1908e<V> m3381b(Throwable th) {
            C1924i b = C1924i.m4482b();
            C1705i.m3380a(b, th);
            return b;
        }

        public void m3385a(V v) {
            if (v != null) {
                m3388b((Object) v);
            } else {
                this.f2086a = LocalCache.m3498o();
            }
        }

        public C1908e<V> m3384a(K k, CacheLoader<? super K, V> cacheLoader) {
            this.f2088c.m3116a();
            Object obj = this.f2086a.get();
            if (obj == null) {
                try {
                    obj = cacheLoader.m2974a(k);
                    return m3388b(obj) ? this.f2087b : C1919d.m4473a(obj);
                } catch (Throwable th) {
                    if (th instanceof InterruptedException) {
                        Thread.currentThread().interrupt();
                    }
                    return m3386a(th) ? this.f2087b : m3381b(th);
                }
            } else {
                C1908e<V> a = cacheLoader.m2973a(k, obj);
                if (a == null) {
                    return C1919d.m4473a(null);
                }
                return a;
            }
        }

        public long m3392f() {
            return this.f2088c.m3115a(TimeUnit.NANOSECONDS);
        }

        public V m3391e() throws ExecutionException {
            return C1925j.m4485a(this.f2087b);
        }

        public V get() {
            return this.f2086a.get();
        }

        public C1671r<K, V> m3393g() {
            return this.f2086a;
        }

        public C1686j<K, V> m3387b() {
            return null;
        }

        public C1671r<K, V> m3383a(ReferenceQueue<V> referenceQueue, V v, C1686j<K, V> c1686j) {
            return this;
        }
    }

    /* renamed from: com.google.common.cache.LocalCache.k */
    static class C1706k<K, V> extends SoftReference<V> implements C1671r<K, V> {
        final C1686j<K, V> f2089a;

        C1706k(ReferenceQueue<V> referenceQueue, V v, C1686j<K, V> c1686j) {
            super(v, referenceQueue);
            this.f2089a = c1686j;
        }

        public int m3394a() {
            return 1;
        }

        public C1686j<K, V> m3397b() {
            return this.f2089a;
        }

        public void m3396a(V v) {
        }

        public C1671r<K, V> m3395a(ReferenceQueue<V> referenceQueue, V v, C1686j<K, V> c1686j) {
            return new C1706k(referenceQueue, v, c1686j);
        }

        public boolean m3398c() {
            return false;
        }

        public boolean m3399d() {
            return true;
        }

        public V m3400e() {
            return get();
        }
    }

    /* renamed from: com.google.common.cache.LocalCache.n */
    static class C1707n<K, V> implements C1686j<K, V> {
        final K f2090g;
        final int f2091h;
        final C1686j<K, V> f2092i;
        volatile C1671r<K, V> f2093j;

        C1707n(K k, int i, C1686j<K, V> c1686j) {
            this.f2093j = LocalCache.m3498o();
            this.f2090g = k;
            this.f2091h = i;
            this.f2092i = c1686j;
        }

        public K m3410d() {
            return this.f2090g;
        }

        public long m3412e() {
            throw new UnsupportedOperationException();
        }

        public void m3402a(long j) {
            throw new UnsupportedOperationException();
        }

        public C1686j<K, V> m3413f() {
            throw new UnsupportedOperationException();
        }

        public void m3403a(C1686j<K, V> c1686j) {
            throw new UnsupportedOperationException();
        }

        public C1686j<K, V> m3414g() {
            throw new UnsupportedOperationException();
        }

        public void m3407b(C1686j<K, V> c1686j) {
            throw new UnsupportedOperationException();
        }

        public long m3415h() {
            throw new UnsupportedOperationException();
        }

        public void m3406b(long j) {
            throw new UnsupportedOperationException();
        }

        public C1686j<K, V> m3416i() {
            throw new UnsupportedOperationException();
        }

        public void m3409c(C1686j<K, V> c1686j) {
            throw new UnsupportedOperationException();
        }

        public C1686j<K, V> m3417j() {
            throw new UnsupportedOperationException();
        }

        public void m3411d(C1686j<K, V> c1686j) {
            throw new UnsupportedOperationException();
        }

        public C1671r<K, V> m3401a() {
            return this.f2093j;
        }

        public void m3404a(C1671r<K, V> c1671r) {
            this.f2093j = c1671r;
        }

        public int m3408c() {
            return this.f2091h;
        }

        public C1686j<K, V> m3405b() {
            return this.f2092i;
        }
    }

    /* renamed from: com.google.common.cache.LocalCache.l */
    static final class C1708l<K, V> extends C1707n<K, V> implements C1686j<K, V> {
        volatile long f2094a;
        C1686j<K, V> f2095b;
        C1686j<K, V> f2096c;

        C1708l(K k, int i, C1686j<K, V> c1686j) {
            super(k, i, c1686j);
            this.f2094a = Long.MAX_VALUE;
            this.f2095b = LocalCache.m3499p();
            this.f2096c = LocalCache.m3499p();
        }

        public long m3421e() {
            return this.f2094a;
        }

        public void m3418a(long j) {
            this.f2094a = j;
        }

        public C1686j<K, V> m3422f() {
            return this.f2095b;
        }

        public void m3419a(C1686j<K, V> c1686j) {
            this.f2095b = c1686j;
        }

        public C1686j<K, V> m3423g() {
            return this.f2096c;
        }

        public void m3420b(C1686j<K, V> c1686j) {
            this.f2096c = c1686j;
        }
    }

    /* renamed from: com.google.common.cache.LocalCache.m */
    static final class C1709m<K, V> extends C1707n<K, V> implements C1686j<K, V> {
        volatile long f2097a;
        C1686j<K, V> f2098b;
        C1686j<K, V> f2099c;
        volatile long f2100d;
        C1686j<K, V> f2101e;
        C1686j<K, V> f2102f;

        C1709m(K k, int i, C1686j<K, V> c1686j) {
            super(k, i, c1686j);
            this.f2097a = Long.MAX_VALUE;
            this.f2098b = LocalCache.m3499p();
            this.f2099c = LocalCache.m3499p();
            this.f2100d = Long.MAX_VALUE;
            this.f2101e = LocalCache.m3499p();
            this.f2102f = LocalCache.m3499p();
        }

        public long m3430e() {
            return this.f2097a;
        }

        public void m3424a(long j) {
            this.f2097a = j;
        }

        public C1686j<K, V> m3431f() {
            return this.f2098b;
        }

        public void m3425a(C1686j<K, V> c1686j) {
            this.f2098b = c1686j;
        }

        public C1686j<K, V> m3432g() {
            return this.f2099c;
        }

        public void m3427b(C1686j<K, V> c1686j) {
            this.f2099c = c1686j;
        }

        public long m3433h() {
            return this.f2100d;
        }

        public void m3426b(long j) {
            this.f2100d = j;
        }

        public C1686j<K, V> m3434i() {
            return this.f2101e;
        }

        public void m3428c(C1686j<K, V> c1686j) {
            this.f2101e = c1686j;
        }

        public C1686j<K, V> m3435j() {
            return this.f2102f;
        }

        public void m3429d(C1686j<K, V> c1686j) {
            this.f2102f = c1686j;
        }
    }

    /* renamed from: com.google.common.cache.LocalCache.o */
    static class C1710o<K, V> implements C1671r<K, V> {
        final V f2103a;

        C1710o(V v) {
            this.f2103a = v;
        }

        public V get() {
            return this.f2103a;
        }

        public int m3436a() {
            return 1;
        }

        public C1686j<K, V> m3439b() {
            return null;
        }

        public C1671r<K, V> m3437a(ReferenceQueue<V> referenceQueue, V v, C1686j<K, V> c1686j) {
            return this;
        }

        public boolean m3440c() {
            return false;
        }

        public boolean m3441d() {
            return true;
        }

        public V m3442e() {
            return get();
        }

        public void m3438a(V v) {
        }
    }

    /* renamed from: com.google.common.cache.LocalCache.p */
    static final class C1711p<K, V> extends C1707n<K, V> implements C1686j<K, V> {
        volatile long f2104a;
        C1686j<K, V> f2105b;
        C1686j<K, V> f2106c;

        C1711p(K k, int i, C1686j<K, V> c1686j) {
            super(k, i, c1686j);
            this.f2104a = Long.MAX_VALUE;
            this.f2105b = LocalCache.m3499p();
            this.f2106c = LocalCache.m3499p();
        }

        public long m3446h() {
            return this.f2104a;
        }

        public void m3443b(long j) {
            this.f2104a = j;
        }

        public C1686j<K, V> m3447i() {
            return this.f2105b;
        }

        public void m3444c(C1686j<K, V> c1686j) {
            this.f2105b = c1686j;
        }

        public C1686j<K, V> m3448j() {
            return this.f2106c;
        }

        public void m3445d(C1686j<K, V> c1686j) {
            this.f2106c = c1686j;
        }
    }

    /* renamed from: com.google.common.cache.LocalCache.q */
    final class C1712q extends C1700f<V> {
        final /* synthetic */ LocalCache f2107a;

        C1712q(LocalCache localCache) {
            this.f2107a = localCache;
            super(localCache);
        }

        public V next() {
            return m3378e().getValue();
        }
    }

    /* renamed from: com.google.common.cache.LocalCache.s */
    final class C1713s extends C1691a<V> {
        final /* synthetic */ LocalCache f2108c;

        C1713s(LocalCache localCache, ConcurrentMap<?, ?> concurrentMap) {
            this.f2108c = localCache;
            super(localCache, concurrentMap);
        }

        public Iterator<V> iterator() {
            return new C1712q(this.f2108c);
        }

        public boolean contains(Object obj) {
            return this.a.containsValue(obj);
        }
    }

    /* renamed from: com.google.common.cache.LocalCache.v */
    static class C1714v<K, V> extends WeakReference<K> implements C1686j<K, V> {
        final int f2109g;
        final C1686j<K, V> f2110h;
        volatile C1671r<K, V> f2111i;

        C1714v(ReferenceQueue<K> referenceQueue, K k, int i, C1686j<K, V> c1686j) {
            super(k, referenceQueue);
            this.f2111i = LocalCache.m3498o();
            this.f2109g = i;
            this.f2110h = c1686j;
        }

        public K m3458d() {
            return get();
        }

        public long m3460e() {
            throw new UnsupportedOperationException();
        }

        public void m3450a(long j) {
            throw new UnsupportedOperationException();
        }

        public C1686j<K, V> m3461f() {
            throw new UnsupportedOperationException();
        }

        public void m3451a(C1686j<K, V> c1686j) {
            throw new UnsupportedOperationException();
        }

        public C1686j<K, V> m3462g() {
            throw new UnsupportedOperationException();
        }

        public void m3455b(C1686j<K, V> c1686j) {
            throw new UnsupportedOperationException();
        }

        public long m3463h() {
            throw new UnsupportedOperationException();
        }

        public void m3454b(long j) {
            throw new UnsupportedOperationException();
        }

        public C1686j<K, V> m3464i() {
            throw new UnsupportedOperationException();
        }

        public void m3457c(C1686j<K, V> c1686j) {
            throw new UnsupportedOperationException();
        }

        public C1686j<K, V> m3465j() {
            throw new UnsupportedOperationException();
        }

        public void m3459d(C1686j<K, V> c1686j) {
            throw new UnsupportedOperationException();
        }

        public C1671r<K, V> m3449a() {
            return this.f2111i;
        }

        public void m3452a(C1671r<K, V> c1671r) {
            this.f2111i = c1671r;
        }

        public int m3456c() {
            return this.f2109g;
        }

        public C1686j<K, V> m3453b() {
            return this.f2110h;
        }
    }

    /* renamed from: com.google.common.cache.LocalCache.t */
    static final class C1715t<K, V> extends C1714v<K, V> implements C1686j<K, V> {
        volatile long f2112a;
        C1686j<K, V> f2113b;
        C1686j<K, V> f2114c;

        C1715t(ReferenceQueue<K> referenceQueue, K k, int i, C1686j<K, V> c1686j) {
            super(referenceQueue, k, i, c1686j);
            this.f2112a = Long.MAX_VALUE;
            this.f2113b = LocalCache.m3499p();
            this.f2114c = LocalCache.m3499p();
        }

        public long m3469e() {
            return this.f2112a;
        }

        public void m3466a(long j) {
            this.f2112a = j;
        }

        public C1686j<K, V> m3470f() {
            return this.f2113b;
        }

        public void m3467a(C1686j<K, V> c1686j) {
            this.f2113b = c1686j;
        }

        public C1686j<K, V> m3471g() {
            return this.f2114c;
        }

        public void m3468b(C1686j<K, V> c1686j) {
            this.f2114c = c1686j;
        }
    }

    /* renamed from: com.google.common.cache.LocalCache.u */
    static final class C1716u<K, V> extends C1714v<K, V> implements C1686j<K, V> {
        volatile long f2115a;
        C1686j<K, V> f2116b;
        C1686j<K, V> f2117c;
        volatile long f2118d;
        C1686j<K, V> f2119e;
        C1686j<K, V> f2120f;

        C1716u(ReferenceQueue<K> referenceQueue, K k, int i, C1686j<K, V> c1686j) {
            super(referenceQueue, k, i, c1686j);
            this.f2115a = Long.MAX_VALUE;
            this.f2116b = LocalCache.m3499p();
            this.f2117c = LocalCache.m3499p();
            this.f2118d = Long.MAX_VALUE;
            this.f2119e = LocalCache.m3499p();
            this.f2120f = LocalCache.m3499p();
        }

        public long m3478e() {
            return this.f2115a;
        }

        public void m3472a(long j) {
            this.f2115a = j;
        }

        public C1686j<K, V> m3479f() {
            return this.f2116b;
        }

        public void m3473a(C1686j<K, V> c1686j) {
            this.f2116b = c1686j;
        }

        public C1686j<K, V> m3480g() {
            return this.f2117c;
        }

        public void m3475b(C1686j<K, V> c1686j) {
            this.f2117c = c1686j;
        }

        public long m3481h() {
            return this.f2118d;
        }

        public void m3474b(long j) {
            this.f2118d = j;
        }

        public C1686j<K, V> m3482i() {
            return this.f2119e;
        }

        public void m3476c(C1686j<K, V> c1686j) {
            this.f2119e = c1686j;
        }

        public C1686j<K, V> m3483j() {
            return this.f2120f;
        }

        public void m3477d(C1686j<K, V> c1686j) {
            this.f2120f = c1686j;
        }
    }

    /* renamed from: com.google.common.cache.LocalCache.x */
    static final class C1717x<K, V> extends C1714v<K, V> implements C1686j<K, V> {
        volatile long f2121a;
        C1686j<K, V> f2122b;
        C1686j<K, V> f2123c;

        C1717x(ReferenceQueue<K> referenceQueue, K k, int i, C1686j<K, V> c1686j) {
            super(referenceQueue, k, i, c1686j);
            this.f2121a = Long.MAX_VALUE;
            this.f2122b = LocalCache.m3499p();
            this.f2123c = LocalCache.m3499p();
        }

        public long m3487h() {
            return this.f2121a;
        }

        public void m3484b(long j) {
            this.f2121a = j;
        }

        public C1686j<K, V> m3488i() {
            return this.f2122b;
        }

        public void m3485c(C1686j<K, V> c1686j) {
            this.f2122b = c1686j;
        }

        public C1686j<K, V> m3489j() {
            return this.f2123c;
        }

        public void m3486d(C1686j<K, V> c1686j) {
            this.f2123c = c1686j;
        }
    }

    /* renamed from: com.google.common.cache.LocalCache.y */
    static final class C1718y<K, V> extends C1706k<K, V> {
        final int f2124b;

        C1718y(ReferenceQueue<V> referenceQueue, V v, C1686j<K, V> c1686j, int i) {
            super(referenceQueue, v, c1686j);
            this.f2124b = i;
        }

        public int m3490a() {
            return this.f2124b;
        }

        public C1671r<K, V> m3491a(ReferenceQueue<V> referenceQueue, V v, C1686j<K, V> c1686j) {
            return new C1718y(referenceQueue, v, c1686j, this.f2124b);
        }
    }

    /* renamed from: com.google.common.cache.LocalCache.z */
    static final class C1719z<K, V> extends C1710o<K, V> {
        final int f2125b;

        C1719z(V v, int i) {
            super(v);
            this.f2125b = i;
        }

        public int m3492a() {
            return this.f2125b;
        }
    }

    static {
        f2126a = Logger.getLogger(LocalCache.class.getName());
        f2127b = C1923h.m4480a();
        f2128v = new C16721();
        f2129w = new C16732();
    }

    LocalCache(CacheBuilder<? super K, ? super V> cacheBuilder, CacheLoader<? super K, V> cacheLoader) {
        Queue q;
        int i = 0;
        this.f2133f = Math.min(cacheBuilder.m3169e(), NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        this.f2136i = cacheBuilder.m3173i();
        this.f2137j = cacheBuilder.m3174j();
        this.f2134g = cacheBuilder.m3162b();
        this.f2135h = cacheBuilder.m3167c();
        this.f2138k = cacheBuilder.m3170f();
        this.f2139l = cacheBuilder.m3171g();
        this.f2140m = cacheBuilder.m3176l();
        this.f2141n = cacheBuilder.m3175k();
        this.f2142o = cacheBuilder.m3177m();
        this.f2144q = cacheBuilder.m3178n();
        if (this.f2144q == NullListener.INSTANCE) {
            q = m3500q();
        } else {
            q = new ConcurrentLinkedQueue();
        }
        this.f2143p = q;
        this.f2145r = cacheBuilder.m3152a(m3520j());
        this.f2146s = EntryFactory.m3195a(this.f2136i, m3522l(), m3521k());
        this.f2147t = (C1665b) cacheBuilder.m3179o().m3003a();
        this.f2148u = cacheLoader;
        int min = Math.min(cacheBuilder.m3168d(), 1073741824);
        if (m3507a() && !m3510b()) {
            min = Math.min(min, (int) this.f2138k);
        }
        int i2 = 1;
        int i3 = 0;
        while (i2 < this.f2133f && (!m3507a() || ((long) (i2 * 20)) <= this.f2138k)) {
            i3++;
            i2 <<= 1;
        }
        this.f2131d = 32 - i3;
        this.f2130c = i2 - 1;
        this.f2132e = m3513c(i2);
        i3 = min / i2;
        if (i3 * i2 < min) {
            min = i3 + 1;
        } else {
            min = i3;
        }
        int i4 = 1;
        while (i4 < min) {
            i4 <<= 1;
        }
        if (m3507a()) {
            long j = this.f2138k % ((long) i2);
            long j2 = (this.f2138k / ((long) i2)) + 1;
            while (i < this.f2132e.length) {
                long j3;
                if (((long) i) == j) {
                    j3 = j2 - 1;
                } else {
                    j3 = j2;
                }
                this.f2132e[i] = m3502a(i4, j3, (C1665b) cacheBuilder.m3179o().m3003a());
                i++;
                j2 = j3;
            }
            return;
        }
        while (i < this.f2132e.length) {
            this.f2132e[i] = m3502a(i4, -1, (C1665b) cacheBuilder.m3179o().m3003a());
            i++;
        }
    }

    boolean m3507a() {
        return this.f2138k >= 0;
    }

    boolean m3510b() {
        return this.f2139l != OneWeigher.INSTANCE;
    }

    boolean m3512c() {
        return this.f2141n > 0;
    }

    boolean m3514d() {
        return this.f2140m > 0;
    }

    boolean m3515e() {
        return this.f2142o > 0;
    }

    boolean m3516f() {
        return m3514d() || m3507a();
    }

    boolean m3517g() {
        return m3512c();
    }

    boolean m3518h() {
        return m3512c() || m3515e();
    }

    boolean m3519i() {
        return m3514d();
    }

    boolean m3520j() {
        return m3518h() || m3519i();
    }

    boolean m3521k() {
        return m3517g() || m3518h();
    }

    boolean m3522l() {
        return m3516f() || m3519i();
    }

    boolean m3523m() {
        return this.f2136i != Strength.STRONG;
    }

    boolean m3524n() {
        return this.f2137j != Strength.STRONG;
    }

    static <K, V> C1671r<K, V> m3498o() {
        return f2128v;
    }

    static <K, V> C1686j<K, V> m3499p() {
        return NullEntry.INSTANCE;
    }

    static <E> Queue<E> m3500q() {
        return f2129w;
    }

    static int m3493a(int i) {
        int i2 = ((i << 15) ^ -12931) + i;
        i2 ^= i2 >>> 10;
        i2 += i2 << 3;
        i2 ^= i2 >>> 6;
        i2 += (i2 << 2) + (i2 << 14);
        return i2 ^ (i2 >>> 16);
    }

    int m3501a(Object obj) {
        return m3493a(this.f2134g.m2984a(obj));
    }

    void m3506a(C1671r<K, V> c1671r) {
        C1686j b = c1671r.m3184b();
        int c = b.m3232c();
        m3508b(c).m3287a(b.m3234d(), c, (C1671r) c1671r);
    }

    void m3505a(C1686j<K, V> c1686j) {
        int c = c1686j.m3232c();
        m3508b(c).m3283a((C1686j) c1686j, c);
    }

    Segment<K, V> m3508b(int i) {
        return this.f2132e[(i >>> this.f2131d) & this.f2130c];
    }

    Segment<K, V> m3502a(int i, long j, C1665b c1665b) {
        return new Segment(this, i, j, c1665b);
    }

    V m3503a(C1686j<K, V> c1686j, long j) {
        if (c1686j.m3234d() == null) {
            return null;
        }
        V v = c1686j.m3225a().get();
        if (v == null || m3511b((C1686j) c1686j, j)) {
            return null;
        }
        return v;
    }

    boolean m3511b(C1686j<K, V> c1686j, long j) {
        C1650g.m3080a((Object) c1686j);
        if (m3514d() && j - c1686j.m3236e() >= this.f2140m) {
            return true;
        }
        if (!m3512c() || j - c1686j.m3239h() < this.f2141n) {
            return false;
        }
        return true;
    }

    static <K, V> void m3494a(C1686j<K, V> c1686j, C1686j<K, V> c1686j2) {
        c1686j.m3227a((C1686j) c1686j2);
        c1686j2.m3231b((C1686j) c1686j);
    }

    static <K, V> void m3495b(C1686j<K, V> c1686j) {
        C1686j p = m3499p();
        c1686j.m3227a(p);
        c1686j.m3231b(p);
    }

    static <K, V> void m3496b(C1686j<K, V> c1686j, C1686j<K, V> c1686j2) {
        c1686j.m3233c(c1686j2);
        c1686j2.m3235d(c1686j);
    }

    static <K, V> void m3497c(C1686j<K, V> c1686j) {
        C1686j p = m3499p();
        c1686j.m3233c(p);
        c1686j.m3235d(p);
    }

    void m3525r() {
        while (true) {
            C1736h c1736h = (C1736h) this.f2143p.poll();
            if (c1736h != null) {
                try {
                    this.f2144q.m3145a(c1736h);
                } catch (Throwable th) {
                    f2126a.log(Level.WARNING, "Exception thrown by removal listener", th);
                }
            } else {
                return;
            }
        }
    }

    final Segment<K, V>[] m3513c(int i) {
        return new Segment[i];
    }

    public boolean isEmpty() {
        int i;
        Segment[] segmentArr = this.f2132e;
        long j = 0;
        for (i = 0; i < segmentArr.length; i++) {
            if (segmentArr[i].f2039b != 0) {
                return false;
            }
            j += (long) segmentArr[i].f2041d;
        }
        if (j != 0) {
            for (i = 0; i < segmentArr.length; i++) {
                if (segmentArr[i].f2039b != 0) {
                    return false;
                }
                j -= (long) segmentArr[i].f2041d;
            }
            if (j != 0) {
                return false;
            }
        }
        return true;
    }

    long m3526s() {
        long j = 0;
        for (Segment segment : this.f2132e) {
            j += (long) segment.f2039b;
        }
        return j;
    }

    public int size() {
        return C1662a.m3123a(m3526s());
    }

    public V get(Object obj) {
        if (obj == null) {
            return null;
        }
        int a = m3501a(obj);
        return m3508b(a).m3292b(obj, a);
    }

    V m3504a(K k, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
        int a = m3501a(C1650g.m3080a((Object) k));
        return m3508b(a).m3267a((Object) k, a, (CacheLoader) cacheLoader);
    }

    V m3509b(K k) throws ExecutionException {
        return m3504a((Object) k, this.f2148u);
    }

    public boolean containsKey(Object obj) {
        if (obj == null) {
            return false;
        }
        int a = m3501a(obj);
        return m3508b(a).m3301c(obj, a);
    }

    public boolean containsValue(Object obj) {
        if (obj == null) {
            return false;
        }
        long a = this.f2145r.m3121a();
        Segment[] segmentArr = this.f2132e;
        int i = 0;
        long j = -1;
        while (i < 3) {
            long j2 = 0;
            for (Segment segment : segmentArr) {
                int i2 = segment.f2039b;
                AtomicReferenceArray atomicReferenceArray = segment.f2043f;
                for (int i3 = 0; i3 < atomicReferenceArray.length(); i3++) {
                    for (C1686j c1686j = (C1686j) atomicReferenceArray.get(i3); c1686j != null; c1686j = c1686j.m3229b()) {
                        Object c = segment.m3298c(c1686j, a);
                        if (c != null) {
                            if (this.f2135h.m2985a(obj, c)) {
                                return true;
                            }
                        }
                    }
                }
                j2 += (long) segment.f2041d;
            }
            if (j2 == j) {
                break;
            }
            i++;
            j = j2;
        }
        return false;
    }

    public V put(K k, V v) {
        C1650g.m3080a((Object) k);
        C1650g.m3080a((Object) v);
        int a = m3501a((Object) k);
        return m3508b(a).m3272a((Object) k, a, (Object) v, false);
    }

    public V putIfAbsent(K k, V v) {
        C1650g.m3080a((Object) k);
        C1650g.m3080a((Object) v);
        int a = m3501a((Object) k);
        return m3508b(a).m3272a((Object) k, a, (Object) v, true);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public V remove(Object obj) {
        if (obj == null) {
            return null;
        }
        int a = m3501a(obj);
        return m3508b(a).m3302d(obj, a);
    }

    public boolean remove(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int a = m3501a(obj);
        return m3508b(a).m3297b(obj, a, obj2);
    }

    public boolean replace(K k, V v, V v2) {
        C1650g.m3080a((Object) k);
        C1650g.m3080a((Object) v2);
        if (v == null) {
            return false;
        }
        int a = m3501a((Object) k);
        return m3508b(a).m3288a((Object) k, a, (Object) v, (Object) v2);
    }

    public V replace(K k, V v) {
        C1650g.m3080a((Object) k);
        C1650g.m3080a((Object) v);
        int a = m3501a((Object) k);
        return m3508b(a).m3271a((Object) k, a, (Object) v);
    }

    public void clear() {
        for (Segment l : this.f2132e) {
            l.m3312l();
        }
    }

    public Set<K> keySet() {
        Set<K> set = this.f2149x;
        if (set != null) {
            return set;
        }
        set = new C1704h(this, this);
        this.f2149x = set;
        return set;
    }

    public Collection<V> values() {
        Collection<V> collection = this.f2150y;
        if (collection != null) {
            return collection;
        }
        collection = new C1713s(this, this);
        this.f2150y = collection;
        return collection;
    }

    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = this.f2151z;
        if (set != null) {
            return set;
        }
        set = new C1702e(this, this);
        this.f2151z = set;
        return set;
    }
}
