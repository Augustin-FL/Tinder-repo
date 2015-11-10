package com.google.common.collect;

import com.facebook.internal.NativeProtocol;
import com.google.common.base.C1650g;
import com.google.common.base.C1660m;
import com.google.common.base.Equivalence;
import com.google.common.collect.MapMaker.C1761a;
import com.google.common.p024c.C1662a;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
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
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

class MapMakerInternalMap<K, V> extends AbstractMap<K, V> implements Serializable, ConcurrentMap<K, V> {
    static final C1791q<Object, Object> f2425p;
    static final Queue<? extends Object> f2426q;
    private static final long serialVersionUID = 5;
    private static final Logger f2427u;
    final transient int f2428a;
    final transient int f2429b;
    final transient Segment<K, V>[] f2430c;
    final int f2431d;
    final Equivalence<Object> f2432e;
    final Equivalence<Object> f2433f;
    final Strength f2434g;
    final Strength f2435h;
    final int f2436i;
    final long f2437j;
    final long f2438k;
    final Queue<RemovalNotification<K, V>> f2439l;
    final C1761a<K, V> f2440m;
    final transient EntryFactory f2441n;
    final C1660m f2442o;
    transient Set<K> f2443r;
    transient Collection<V> f2444s;
    transient Set<Entry<K, V>> f2445t;

    /* renamed from: com.google.common.collect.MapMakerInternalMap.q */
    interface C1791q<K, V> {
        C1804i<K, V> m3888a();

        C1791q<K, V> m3889a(ReferenceQueue<V> referenceQueue, V v, C1804i<K, V> c1804i);

        void m3890a(C1791q<K, V> c1791q);

        boolean m3891b();

        V get();
    }

    /* renamed from: com.google.common.collect.MapMakerInternalMap.1 */
    static class C17921 implements C1791q<Object, Object> {
        C17921() {
        }

        public Object get() {
            return null;
        }

        public C1804i<Object, Object> m3892a() {
            return null;
        }

        public C1791q<Object, Object> m3893a(ReferenceQueue<Object> referenceQueue, Object obj, C1804i<Object, Object> c1804i) {
            return this;
        }

        public boolean m3895b() {
            return false;
        }

        public void m3894a(C1791q<Object, Object> c1791q) {
        }
    }

    /* renamed from: com.google.common.collect.MapMakerInternalMap.2 */
    static class C17932 extends AbstractQueue<Object> {
        C17932() {
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

    static abstract class AbstractSerializationProxy<K, V> extends C1795i<K, V> implements Serializable {
        private static final long serialVersionUID = 3;
        final Strength f2330a;
        final Strength f2331b;
        final Equivalence<Object> f2332c;
        final Equivalence<Object> f2333d;
        final long f2334e;
        final long f2335f;
        final int f2336g;
        final int f2337h;
        final C1761a<? super K, ? super V> f2338i;
        transient ConcurrentMap<K, V> f2339j;

        protected /* synthetic */ Object m3904b() {
            return m3902a();
        }

        protected /* synthetic */ Map m3906c() {
            return m3902a();
        }

        AbstractSerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, long j, long j2, int i, int i2, C1761a<? super K, ? super V> c1761a, ConcurrentMap<K, V> concurrentMap) {
            this.f2330a = strength;
            this.f2331b = strength2;
            this.f2332c = equivalence;
            this.f2333d = equivalence2;
            this.f2334e = j;
            this.f2335f = j2;
            this.f2336g = i;
            this.f2337h = i2;
            this.f2338i = c1761a;
            this.f2339j = concurrentMap;
        }

        protected ConcurrentMap<K, V> m3902a() {
            return this.f2339j;
        }

        void m3903a(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeInt(this.f2339j.size());
            for (Entry entry : this.f2339j.entrySet()) {
                objectOutputStream.writeObject(entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
            objectOutputStream.writeObject(null);
        }

        MapMaker m3901a(ObjectInputStream objectInputStream) throws IOException {
            MapMaker c = new MapMaker().m3871a(objectInputStream.readInt()).m3874a(this.f2330a).m3878b(this.f2331b).m3873a(this.f2332c).m3880c(this.f2337h);
            c.m3870a(this.f2338i);
            if (this.f2334e > 0) {
                c.m3872a(this.f2334e, TimeUnit.NANOSECONDS);
            }
            if (this.f2335f > 0) {
                c.m3877b(this.f2335f, TimeUnit.NANOSECONDS);
            }
            if (this.f2336g != -1) {
                c.m3876b(this.f2336g);
            }
            return c;
        }

        void m3905b(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            while (true) {
                Object readObject = objectInputStream.readObject();
                if (readObject != null) {
                    this.f2339j.put(readObject, objectInputStream.readObject());
                } else {
                    return;
                }
            }
        }
    }

    enum EntryFactory {
        STRONG {
            <K, V> C1804i<K, V> m3912a(Segment<K, V> segment, K k, int i, C1804i<K, V> c1804i) {
                return new C1821k(k, i, c1804i);
            }
        },
        STRONG_EXPIRABLE {
            <K, V> C1804i<K, V> m3914a(Segment<K, V> segment, K k, int i, C1804i<K, V> c1804i) {
                return new C1823m(k, i, c1804i);
            }

            <K, V> C1804i<K, V> m3913a(Segment<K, V> segment, C1804i<K, V> c1804i, C1804i<K, V> c1804i2) {
                C1804i<K, V> a = super.m3908a((Segment) segment, (C1804i) c1804i, (C1804i) c1804i2);
                m3910a(c1804i, a);
                return a;
            }
        },
        STRONG_EVICTABLE {
            <K, V> C1804i<K, V> m3916a(Segment<K, V> segment, K k, int i, C1804i<K, V> c1804i) {
                return new C1822l(k, i, c1804i);
            }

            <K, V> C1804i<K, V> m3915a(Segment<K, V> segment, C1804i<K, V> c1804i, C1804i<K, V> c1804i2) {
                C1804i<K, V> a = super.m3908a((Segment) segment, (C1804i) c1804i, (C1804i) c1804i2);
                m3911b(c1804i, a);
                return a;
            }
        },
        STRONG_EXPIRABLE_EVICTABLE {
            <K, V> C1804i<K, V> m3918a(Segment<K, V> segment, K k, int i, C1804i<K, V> c1804i) {
                return new C1824n(k, i, c1804i);
            }

            <K, V> C1804i<K, V> m3917a(Segment<K, V> segment, C1804i<K, V> c1804i, C1804i<K, V> c1804i2) {
                C1804i<K, V> a = super.m3908a((Segment) segment, (C1804i) c1804i, (C1804i) c1804i2);
                m3910a(c1804i, a);
                m3911b(c1804i, a);
                return a;
            }
        },
        WEAK {
            <K, V> C1804i<K, V> m3919a(Segment<K, V> segment, K k, int i, C1804i<K, V> c1804i) {
                return new C1828s(segment.f2358g, k, i, c1804i);
            }
        },
        WEAK_EXPIRABLE {
            <K, V> C1804i<K, V> m3921a(Segment<K, V> segment, K k, int i, C1804i<K, V> c1804i) {
                return new C1830u(segment.f2358g, k, i, c1804i);
            }

            <K, V> C1804i<K, V> m3920a(Segment<K, V> segment, C1804i<K, V> c1804i, C1804i<K, V> c1804i2) {
                C1804i<K, V> a = super.m3908a((Segment) segment, (C1804i) c1804i, (C1804i) c1804i2);
                m3910a(c1804i, a);
                return a;
            }
        },
        WEAK_EVICTABLE {
            <K, V> C1804i<K, V> m3923a(Segment<K, V> segment, K k, int i, C1804i<K, V> c1804i) {
                return new C1829t(segment.f2358g, k, i, c1804i);
            }

            <K, V> C1804i<K, V> m3922a(Segment<K, V> segment, C1804i<K, V> c1804i, C1804i<K, V> c1804i2) {
                C1804i<K, V> a = super.m3908a((Segment) segment, (C1804i) c1804i, (C1804i) c1804i2);
                m3911b(c1804i, a);
                return a;
            }
        },
        WEAK_EXPIRABLE_EVICTABLE {
            <K, V> C1804i<K, V> m3925a(Segment<K, V> segment, K k, int i, C1804i<K, V> c1804i) {
                return new C1831v(segment.f2358g, k, i, c1804i);
            }

            <K, V> C1804i<K, V> m3924a(Segment<K, V> segment, C1804i<K, V> c1804i, C1804i<K, V> c1804i2) {
                C1804i<K, V> a = super.m3908a((Segment) segment, (C1804i) c1804i, (C1804i) c1804i2);
                m3910a(c1804i, a);
                m3911b(c1804i, a);
                return a;
            }
        };
        
        static final EntryFactory[][] f2348i;

        abstract <K, V> C1804i<K, V> m3909a(Segment<K, V> segment, K k, int i, C1804i<K, V> c1804i);

        static {
            r0 = new EntryFactory[3][];
            r0[0] = new EntryFactory[]{STRONG, STRONG_EXPIRABLE, STRONG_EVICTABLE, STRONG_EXPIRABLE_EVICTABLE};
            r0[1] = new EntryFactory[0];
            r0[2] = new EntryFactory[]{WEAK, WEAK_EXPIRABLE, WEAK_EVICTABLE, WEAK_EXPIRABLE_EVICTABLE};
            f2348i = r0;
        }

        static EntryFactory m3907a(Strength strength, boolean z, boolean z2) {
            int i;
            int i2 = 0;
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            if (z2) {
                i2 = 2;
            }
            return f2348i[strength.ordinal()][i2 | i];
        }

        <K, V> C1804i<K, V> m3908a(Segment<K, V> segment, C1804i<K, V> c1804i, C1804i<K, V> c1804i2) {
            return m3909a(segment, c1804i.m3934d(), c1804i.m3932c(), c1804i2);
        }

        <K, V> void m3910a(C1804i<K, V> c1804i, C1804i<K, V> c1804i2) {
            c1804i2.m3927a(c1804i.m3936e());
            MapMakerInternalMap.m4135a(c1804i.m3938g(), (C1804i) c1804i2);
            MapMakerInternalMap.m4135a((C1804i) c1804i2, c1804i.m3937f());
            MapMakerInternalMap.m4137d(c1804i);
        }

        <K, V> void m3911b(C1804i<K, V> c1804i, C1804i<K, V> c1804i2) {
            MapMakerInternalMap.m4136b(c1804i.m3940i(), c1804i2);
            MapMakerInternalMap.m4136b(c1804i2, c1804i.m3939h());
            MapMakerInternalMap.m4138e(c1804i);
        }
    }

    /* renamed from: com.google.common.collect.MapMakerInternalMap.i */
    interface C1804i<K, V> {
        C1791q<K, V> m3926a();

        void m3927a(long j);

        void m3928a(C1804i<K, V> c1804i);

        void m3929a(C1791q<K, V> c1791q);

        C1804i<K, V> m3930b();

        void m3931b(C1804i<K, V> c1804i);

        int m3932c();

        void m3933c(C1804i<K, V> c1804i);

        K m3934d();

        void m3935d(C1804i<K, V> c1804i);

        long m3936e();

        C1804i<K, V> m3937f();

        C1804i<K, V> m3938g();

        C1804i<K, V> m3939h();

        C1804i<K, V> m3940i();
    }

    private enum NullEntry implements C1804i<Object, Object> {
        INSTANCE;

        public C1791q<Object, Object> m3941a() {
            return null;
        }

        public void m3944a(C1791q<Object, Object> c1791q) {
        }

        public C1804i<Object, Object> m3945b() {
            return null;
        }

        public int m3947c() {
            return 0;
        }

        public Object m3949d() {
            return null;
        }

        public long m3951e() {
            return 0;
        }

        public void m3942a(long j) {
        }

        public C1804i<Object, Object> m3952f() {
            return this;
        }

        public void m3943a(C1804i<Object, Object> c1804i) {
        }

        public C1804i<Object, Object> m3953g() {
            return this;
        }

        public void m3946b(C1804i<Object, Object> c1804i) {
        }

        public C1804i<Object, Object> m3954h() {
            return this;
        }

        public void m3948c(C1804i<Object, Object> c1804i) {
        }

        public C1804i<Object, Object> m3955i() {
            return this;
        }

        public void m3950d(C1804i<Object, Object> c1804i) {
        }
    }

    static class Segment<K, V> extends ReentrantLock {
        final MapMakerInternalMap<K, V> f2352a;
        volatile int f2353b;
        int f2354c;
        int f2355d;
        volatile AtomicReferenceArray<C1804i<K, V>> f2356e;
        final int f2357f;
        final ReferenceQueue<K> f2358g;
        final ReferenceQueue<V> f2359h;
        final Queue<C1804i<K, V>> f2360i;
        final AtomicInteger f2361j;
        final Queue<C1804i<K, V>> f2362k;
        final Queue<C1804i<K, V>> f2363l;

        Segment(MapMakerInternalMap<K, V> mapMakerInternalMap, int i, int i2) {
            ReferenceQueue referenceQueue = null;
            this.f2361j = new AtomicInteger();
            this.f2352a = mapMakerInternalMap;
            this.f2357f = i2;
            m3968a(m3961a(i));
            this.f2358g = mapMakerInternalMap.m4155e() ? new ReferenceQueue() : null;
            if (mapMakerInternalMap.m4156f()) {
                referenceQueue = new ReferenceQueue();
            }
            this.f2359h = referenceQueue;
            Queue concurrentLinkedQueue = (mapMakerInternalMap.m4146a() || mapMakerInternalMap.m4154d()) ? new ConcurrentLinkedQueue() : MapMakerInternalMap.m4141i();
            this.f2360i = concurrentLinkedQueue;
            this.f2362k = mapMakerInternalMap.m4146a() ? new C1814d() : MapMakerInternalMap.m4141i();
            this.f2363l = mapMakerInternalMap.m4150b() ? new C1817e() : MapMakerInternalMap.m4141i();
        }

        AtomicReferenceArray<C1804i<K, V>> m3961a(int i) {
            return new AtomicReferenceArray(i);
        }

        void m3968a(AtomicReferenceArray<C1804i<K, V>> atomicReferenceArray) {
            this.f2355d = (atomicReferenceArray.length() * 3) / 4;
            if (this.f2355d == this.f2357f) {
                this.f2355d++;
            }
            this.f2356e = atomicReferenceArray;
        }

        C1804i<K, V> m3958a(K k, int i, C1804i<K, V> c1804i) {
            return this.f2352a.f2441n.m3909a(this, k, i, c1804i);
        }

        C1804i<K, V> m3956a(C1804i<K, V> c1804i, C1804i<K, V> c1804i2) {
            if (c1804i.m3934d() == null) {
                return null;
            }
            C1791q a = c1804i.m3926a();
            Object obj = a.get();
            if (obj == null && !a.m3891b()) {
                return null;
            }
            C1804i<K, V> a2 = this.f2352a.f2441n.m3908a(this, (C1804i) c1804i, (C1804i) c1804i2);
            a2.m3929a(a.m3889a(this.f2359h, obj, a2));
            return a2;
        }

        void m3966a(C1804i<K, V> c1804i, V v) {
            c1804i.m3929a(this.f2352a.f2435h.m4004a(this, c1804i, v));
            m3982c(c1804i);
        }

        void m3962a() {
            if (tryLock()) {
                try {
                    m3977b();
                } finally {
                    unlock();
                }
            }
        }

        void m3977b() {
            if (this.f2352a.m4155e()) {
                m3981c();
            }
            if (this.f2352a.m4156f()) {
                m3983d();
            }
        }

        void m3981c() {
            int i = 0;
            while (true) {
                Reference poll = this.f2358g.poll();
                if (poll != null) {
                    this.f2352a.m4144a((C1804i) poll);
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

        void m3983d() {
            int i = 0;
            while (true) {
                Reference poll = this.f2359h.poll();
                if (poll != null) {
                    this.f2352a.m4145a((C1791q) poll);
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

        void m3988e() {
            if (this.f2352a.m4155e()) {
                m3989f();
            }
            if (this.f2352a.m4156f()) {
                m3990g();
            }
        }

        void m3989f() {
            do {
            } while (this.f2358g.poll() != null);
        }

        void m3990g() {
            do {
            } while (this.f2359h.poll() != null);
        }

        void m3963a(C1804i<K, V> c1804i) {
            if (this.f2352a.m4154d()) {
                m3964a((C1804i) c1804i, this.f2352a.f2437j);
            }
            this.f2360i.add(c1804i);
        }

        void m3978b(C1804i<K, V> c1804i) {
            this.f2362k.add(c1804i);
            if (this.f2352a.m4154d()) {
                m3964a((C1804i) c1804i, this.f2352a.f2437j);
                this.f2363l.add(c1804i);
            }
        }

        void m3982c(C1804i<K, V> c1804i) {
            m3991h();
            this.f2362k.add(c1804i);
            if (this.f2352a.m4150b()) {
                m3964a((C1804i) c1804i, this.f2352a.m4154d() ? this.f2352a.f2437j : this.f2352a.f2438k);
                this.f2363l.add(c1804i);
            }
        }

        void m3991h() {
            while (true) {
                C1804i c1804i = (C1804i) this.f2360i.poll();
                if (c1804i != null) {
                    if (this.f2362k.contains(c1804i)) {
                        this.f2362k.add(c1804i);
                    }
                    if (this.f2352a.m4154d() && this.f2363l.contains(c1804i)) {
                        this.f2363l.add(c1804i);
                    }
                } else {
                    return;
                }
            }
        }

        void m3964a(C1804i<K, V> c1804i, long j) {
            c1804i.m3927a(this.f2352a.f2442o.m3121a() + j);
        }

        void m3992i() {
            if (tryLock()) {
                try {
                    m3993j();
                } finally {
                    unlock();
                }
            }
        }

        void m3993j() {
            m3991h();
            if (!this.f2363l.isEmpty()) {
                long a = this.f2352a.f2442o.m3121a();
                C1804i c1804i;
                do {
                    c1804i = (C1804i) this.f2363l.peek();
                    if (c1804i == null || !this.f2352a.m4147a(c1804i, a)) {
                        return;
                    }
                } while (m3970a(c1804i, c1804i.m3932c(), RemovalCause.EXPIRED));
                throw new AssertionError();
            }
        }

        void m3965a(C1804i<K, V> c1804i, RemovalCause removalCause) {
            m3967a(c1804i.m3934d(), c1804i.m3932c(), c1804i.m3926a().get(), removalCause);
        }

        void m3967a(K k, int i, V v, RemovalCause removalCause) {
            if (this.f2352a.f2439l != MapMakerInternalMap.f2426q) {
                this.f2352a.f2439l.offer(new RemovalNotification(k, v, removalCause));
            }
        }

        boolean m3994k() {
            if (!this.f2352a.m4146a() || this.f2353b < this.f2357f) {
                return false;
            }
            m3991h();
            C1804i c1804i = (C1804i) this.f2362k.remove();
            if (m3970a(c1804i, c1804i.m3932c(), RemovalCause.SIZE)) {
                return true;
            }
            throw new AssertionError();
        }

        C1804i<K, V> m3974b(int i) {
            AtomicReferenceArray atomicReferenceArray = this.f2356e;
            return (C1804i) atomicReferenceArray.get((atomicReferenceArray.length() - 1) & i);
        }

        C1804i<K, V> m3957a(Object obj, int i) {
            if (this.f2353b != 0) {
                for (C1804i<K, V> b = m3974b(i); b != null; b = b.m3930b()) {
                    if (b.m3932c() == i) {
                        Object d = b.m3934d();
                        if (d == null) {
                            m3962a();
                        } else if (this.f2352a.f2432e.m2985a(obj, d)) {
                            return b;
                        }
                    }
                }
            }
            return null;
        }

        C1804i<K, V> m3976b(Object obj, int i) {
            C1804i<K, V> a = m3957a(obj, i);
            if (a == null) {
                return null;
            }
            if (!this.f2352a.m4150b() || !this.f2352a.m4152c((C1804i) a)) {
                return a;
            }
            m3992i();
            return null;
        }

        V m3980c(Object obj, int i) {
            try {
                C1804i b = m3976b(obj, i);
                if (b == null) {
                    return null;
                }
                V v = b.m3926a().get();
                if (v != null) {
                    m3963a(b);
                } else {
                    m3962a();
                }
                m3997n();
                return v;
            } finally {
                m3997n();
            }
        }

        boolean m3985d(Object obj, int i) {
            boolean z = false;
            try {
                if (this.f2353b != 0) {
                    C1804i b = m3976b(obj, i);
                    if (b != null) {
                        if (b.m3926a().get() != null) {
                            z = true;
                        }
                        m3997n();
                    }
                } else {
                    m3997n();
                }
                return z;
            } finally {
                m3997n();
            }
        }

        V m3960a(K k, int i, V v, boolean z) {
            V v2 = null;
            lock();
            try {
                int i2;
                m3998o();
                int i3 = this.f2353b + 1;
                if (i3 > this.f2355d) {
                    m3995l();
                    i3 = this.f2353b + 1;
                }
                AtomicReferenceArray atomicReferenceArray = this.f2356e;
                int length = i & (atomicReferenceArray.length() - 1);
                C1804i c1804i = (C1804i) atomicReferenceArray.get(length);
                for (C1804i c1804i2 = c1804i; c1804i2 != null; c1804i2 = c1804i2.m3930b()) {
                    Object d = c1804i2.m3934d();
                    if (c1804i2.m3932c() == i && d != null && this.f2352a.f2432e.m2985a(k, d)) {
                        C1791q a = c1804i2.m3926a();
                        Object obj = a.get();
                        if (obj == null) {
                            this.f2354c++;
                            m3966a(c1804i2, (Object) v);
                            if (!a.m3891b()) {
                                m3967a((Object) k, i, obj, RemovalCause.COLLECTED);
                                i3 = this.f2353b;
                            } else if (m3994k()) {
                                i3 = this.f2353b + 1;
                            }
                            this.f2353b = i3;
                            return v2;
                        } else if (z) {
                            m3978b(c1804i2);
                            unlock();
                            m3999p();
                            return obj;
                        } else {
                            this.f2354c++;
                            v2 = RemovalCause.REPLACED;
                            m3967a((Object) k, i, obj, (RemovalCause) v2);
                            m3966a(c1804i2, (Object) v);
                            unlock();
                            m3999p();
                            return obj;
                        }
                    }
                }
                this.f2354c++;
                c1804i = m3958a((Object) k, i, c1804i);
                m3966a(c1804i, (Object) v);
                atomicReferenceArray.set(length, c1804i);
                if (m3994k()) {
                    i2 = this.f2353b + 1;
                } else {
                    i2 = i3;
                }
                this.f2353b = i2;
                unlock();
                m3999p();
                return null;
            } finally {
                unlock();
                m3999p();
            }
        }

        void m3995l() {
            AtomicReferenceArray atomicReferenceArray = this.f2356e;
            int length = atomicReferenceArray.length();
            if (length < 1073741824) {
                int i = this.f2353b;
                AtomicReferenceArray a = m3961a(length << 1);
                this.f2355d = (a.length() * 3) / 4;
                int length2 = a.length() - 1;
                int i2 = 0;
                while (i2 < length) {
                    int i3;
                    C1804i c1804i = (C1804i) atomicReferenceArray.get(i2);
                    if (c1804i != null) {
                        C1804i b = c1804i.m3930b();
                        int c = c1804i.m3932c() & length2;
                        if (b == null) {
                            a.set(c, c1804i);
                            i3 = i;
                        } else {
                            C1804i c1804i2;
                            C1804i c1804i3 = c1804i;
                            while (b != null) {
                                i3 = b.m3932c() & length2;
                                if (i3 != c) {
                                    c1804i2 = b;
                                } else {
                                    i3 = c;
                                    c1804i2 = c1804i3;
                                }
                                b = b.m3930b();
                                c1804i3 = c1804i2;
                                c = i3;
                            }
                            a.set(c, c1804i3);
                            c1804i2 = c1804i;
                            i3 = i;
                            while (c1804i2 != c1804i3) {
                                int i4;
                                int c2 = c1804i2.m3932c() & length2;
                                c1804i = m3956a(c1804i2, (C1804i) a.get(c2));
                                if (c1804i != null) {
                                    a.set(c2, c1804i);
                                    i4 = i3;
                                } else {
                                    m3984d(c1804i2);
                                    i4 = i3 - 1;
                                }
                                c1804i2 = c1804i2.m3930b();
                                i3 = i4;
                            }
                        }
                    } else {
                        i3 = i;
                    }
                    i2++;
                    i = i3;
                }
                this.f2356e = a;
                this.f2353b = i;
            }
        }

        boolean m3973a(K k, int i, V v, V v2) {
            lock();
            try {
                m3998o();
                AtomicReferenceArray atomicReferenceArray = this.f2356e;
                int length = i & (atomicReferenceArray.length() - 1);
                C1804i c1804i = (C1804i) atomicReferenceArray.get(length);
                for (C1804i c1804i2 = c1804i; c1804i2 != null; c1804i2 = c1804i2.m3930b()) {
                    Object d = c1804i2.m3934d();
                    if (c1804i2.m3932c() == i && d != null && this.f2352a.f2432e.m2985a(k, d)) {
                        C1791q a = c1804i2.m3926a();
                        Object obj = a.get();
                        if (obj == null) {
                            if (m3971a(a)) {
                                int i2 = this.f2353b - 1;
                                this.f2354c++;
                                m3967a(d, i, obj, RemovalCause.COLLECTED);
                                c1804i = m3975b(c1804i, c1804i2);
                                int i3 = this.f2353b - 1;
                                atomicReferenceArray.set(length, c1804i);
                                this.f2353b = i3;
                            }
                            unlock();
                            m3999p();
                            return false;
                        } else if (this.f2352a.f2433f.m2985a(v, obj)) {
                            this.f2354c++;
                            m3967a((Object) k, i, obj, RemovalCause.REPLACED);
                            m3966a(c1804i2, (Object) v2);
                            unlock();
                            m3999p();
                            return true;
                        } else {
                            m3978b(c1804i2);
                            unlock();
                            m3999p();
                            return false;
                        }
                    }
                }
                unlock();
                m3999p();
                return false;
            } catch (Throwable th) {
                unlock();
                m3999p();
            }
        }

        V m3959a(K k, int i, V v) {
            lock();
            try {
                m3998o();
                AtomicReferenceArray atomicReferenceArray = this.f2356e;
                int length = i & (atomicReferenceArray.length() - 1);
                C1804i c1804i = (C1804i) atomicReferenceArray.get(length);
                for (C1804i c1804i2 = c1804i; c1804i2 != null; c1804i2 = c1804i2.m3930b()) {
                    Object d = c1804i2.m3934d();
                    if (c1804i2.m3932c() == i && d != null && this.f2352a.f2432e.m2985a(k, d)) {
                        C1791q a = c1804i2.m3926a();
                        V v2 = a.get();
                        if (v2 == null) {
                            if (m3971a(a)) {
                                int i2 = this.f2353b - 1;
                                this.f2354c++;
                                m3967a(d, i, (Object) v2, RemovalCause.COLLECTED);
                                int i3 = this.f2353b - 1;
                                atomicReferenceArray.set(length, m3975b(c1804i, c1804i2));
                                this.f2353b = i3;
                            }
                            unlock();
                            m3999p();
                            return null;
                        }
                        this.f2354c++;
                        m3967a((Object) k, i, (Object) v2, RemovalCause.REPLACED);
                        m3966a(c1804i2, (Object) v);
                        unlock();
                        m3999p();
                        return v2;
                    }
                }
                unlock();
                m3999p();
                return null;
            } catch (Throwable th) {
                unlock();
                m3999p();
            }
        }

        V m3987e(Object obj, int i) {
            lock();
            try {
                m3998o();
                int i2 = this.f2353b - 1;
                AtomicReferenceArray atomicReferenceArray = this.f2356e;
                int length = i & (atomicReferenceArray.length() - 1);
                C1804i c1804i = (C1804i) atomicReferenceArray.get(length);
                for (C1804i c1804i2 = c1804i; c1804i2 != null; c1804i2 = c1804i2.m3930b()) {
                    Object d = c1804i2.m3934d();
                    V c = c1804i2.m3932c();
                    if (c == i && d != null) {
                        c = this.f2352a.f2432e.m2985a(obj, d);
                        if (c != null) {
                            RemovalCause removalCause;
                            C1791q a = c1804i2.m3926a();
                            c = a.get();
                            if (c != null) {
                                removalCause = RemovalCause.EXPLICIT;
                            } else if (m3971a(a)) {
                                removalCause = RemovalCause.COLLECTED;
                            } else {
                                unlock();
                                m3999p();
                                return null;
                            }
                            this.f2354c++;
                            m3967a(d, i, (Object) c, removalCause);
                            int i3 = this.f2353b - 1;
                            atomicReferenceArray.set(length, m3975b(c1804i, c1804i2));
                            this.f2353b = i3;
                            return c;
                        }
                    }
                }
                unlock();
                m3999p();
                return null;
            } finally {
                unlock();
                m3999p();
            }
        }

        boolean m3979b(Object obj, int i, Object obj2) {
            lock();
            try {
                m3998o();
                int i2 = this.f2353b - 1;
                AtomicReferenceArray atomicReferenceArray = this.f2356e;
                int length = i & (atomicReferenceArray.length() - 1);
                C1804i c1804i = (C1804i) atomicReferenceArray.get(length);
                for (C1804i c1804i2 = c1804i; c1804i2 != null; c1804i2 = c1804i2.m3930b()) {
                    Object d = c1804i2.m3934d();
                    if (c1804i2.m3932c() == i && d != null && this.f2352a.f2432e.m2985a(obj, d)) {
                        RemovalCause removalCause;
                        C1791q a = c1804i2.m3926a();
                        Object obj3 = a.get();
                        if (this.f2352a.f2433f.m2985a(obj2, obj3)) {
                            removalCause = RemovalCause.EXPLICIT;
                        } else if (m3971a(a)) {
                            removalCause = RemovalCause.COLLECTED;
                        } else {
                            unlock();
                            m3999p();
                            return false;
                        }
                        this.f2354c++;
                        m3967a(d, i, obj3, removalCause);
                        c1804i = m3975b(c1804i, c1804i2);
                        int i3 = this.f2353b - 1;
                        atomicReferenceArray.set(length, c1804i);
                        this.f2353b = i3;
                        boolean z = removalCause == RemovalCause.EXPLICIT;
                        unlock();
                        m3999p();
                        return z;
                    }
                }
                unlock();
                m3999p();
                return false;
            } catch (Throwable th) {
                unlock();
                m3999p();
            }
        }

        void m3996m() {
            if (this.f2353b != 0) {
                lock();
                try {
                    AtomicReferenceArray atomicReferenceArray = this.f2356e;
                    if (this.f2352a.f2439l != MapMakerInternalMap.f2426q) {
                        for (int i = 0; i < atomicReferenceArray.length(); i++) {
                            for (C1804i c1804i = (C1804i) atomicReferenceArray.get(i); c1804i != null; c1804i = c1804i.m3930b()) {
                                if (!c1804i.m3926a().m3891b()) {
                                    m3965a(c1804i, RemovalCause.EXPLICIT);
                                }
                            }
                        }
                    }
                    for (int i2 = 0; i2 < atomicReferenceArray.length(); i2++) {
                        atomicReferenceArray.set(i2, null);
                    }
                    m3988e();
                    this.f2362k.clear();
                    this.f2363l.clear();
                    this.f2361j.set(0);
                    this.f2354c++;
                    this.f2353b = 0;
                } finally {
                    unlock();
                    m3999p();
                }
            }
        }

        C1804i<K, V> m3975b(C1804i<K, V> c1804i, C1804i<K, V> c1804i2) {
            this.f2362k.remove(c1804i2);
            this.f2363l.remove(c1804i2);
            int i = this.f2353b;
            C1804i<K, V> b = c1804i2.m3930b();
            C1804i b2;
            while (b2 != c1804i2) {
                int i2;
                C1804i<K, V> a = m3956a(b2, (C1804i) b);
                if (a != null) {
                    i2 = i;
                } else {
                    m3984d(b2);
                    C1804i<K, V> c1804i3 = b;
                    i2 = i - 1;
                    a = c1804i3;
                }
                b2 = b2.m3930b();
                i = i2;
                b = a;
            }
            this.f2353b = i;
            return b;
        }

        void m3984d(C1804i<K, V> c1804i) {
            m3965a((C1804i) c1804i, RemovalCause.COLLECTED);
            this.f2362k.remove(c1804i);
            this.f2363l.remove(c1804i);
        }

        boolean m3969a(C1804i<K, V> c1804i, int i) {
            lock();
            try {
                int i2 = this.f2353b - 1;
                AtomicReferenceArray atomicReferenceArray = this.f2356e;
                int length = i & (atomicReferenceArray.length() - 1);
                C1804i c1804i2 = (C1804i) atomicReferenceArray.get(length);
                for (C1804i c1804i3 = c1804i2; c1804i3 != null; c1804i3 = c1804i3.m3930b()) {
                    if (c1804i3 == c1804i) {
                        this.f2354c++;
                        m3967a(c1804i3.m3934d(), i, c1804i3.m3926a().get(), RemovalCause.COLLECTED);
                        c1804i2 = m3975b(c1804i2, c1804i3);
                        int i3 = this.f2353b - 1;
                        atomicReferenceArray.set(length, c1804i2);
                        this.f2353b = i3;
                        return true;
                    }
                }
                unlock();
                m3999p();
                return false;
            } finally {
                unlock();
                m3999p();
            }
        }

        boolean m3972a(K k, int i, C1791q<K, V> c1791q) {
            boolean z = false;
            lock();
            try {
                int i2 = this.f2353b - 1;
                AtomicReferenceArray atomicReferenceArray = this.f2356e;
                int length = i & (atomicReferenceArray.length() - 1);
                C1804i c1804i = (C1804i) atomicReferenceArray.get(length);
                C1804i c1804i2 = c1804i;
                while (c1804i2 != null) {
                    Object d = c1804i2.m3934d();
                    if (c1804i2.m3932c() != i || d == null || !this.f2352a.f2432e.m2985a(k, d)) {
                        c1804i2 = c1804i2.m3930b();
                    } else if (c1804i2.m3926a() != c1791q) {
                        return z;
                    } else {
                        this.f2354c++;
                        m3967a((Object) k, i, c1791q.get(), RemovalCause.COLLECTED);
                        int i3 = this.f2353b - 1;
                        atomicReferenceArray.set(length, m3975b(c1804i, c1804i2));
                        this.f2353b = i3;
                        unlock();
                        if (isHeldByCurrentThread()) {
                            return true;
                        }
                        m3999p();
                        return true;
                    }
                }
                unlock();
                if (!isHeldByCurrentThread()) {
                    m3999p();
                }
                return false;
            } finally {
                unlock();
                z = isHeldByCurrentThread();
                if (!z) {
                    m3999p();
                }
            }
        }

        boolean m3970a(C1804i<K, V> c1804i, int i, RemovalCause removalCause) {
            int i2 = this.f2353b - 1;
            AtomicReferenceArray atomicReferenceArray = this.f2356e;
            int length = i & (atomicReferenceArray.length() - 1);
            C1804i c1804i2 = (C1804i) atomicReferenceArray.get(length);
            for (C1804i c1804i3 = c1804i2; c1804i3 != null; c1804i3 = c1804i3.m3930b()) {
                if (c1804i3 == c1804i) {
                    this.f2354c++;
                    m3967a(c1804i3.m3934d(), i, c1804i3.m3926a().get(), removalCause);
                    c1804i2 = m3975b(c1804i2, c1804i3);
                    int i3 = this.f2353b - 1;
                    atomicReferenceArray.set(length, c1804i2);
                    this.f2353b = i3;
                    return true;
                }
            }
            return false;
        }

        boolean m3971a(C1791q<K, V> c1791q) {
            if (!c1791q.m3891b() && c1791q.get() == null) {
                return true;
            }
            return false;
        }

        V m3986e(C1804i<K, V> c1804i) {
            if (c1804i.m3934d() == null) {
                m3962a();
                return null;
            }
            V v = c1804i.m3926a().get();
            if (v == null) {
                m3962a();
                return null;
            } else if (!this.f2352a.m4150b() || !this.f2352a.m4152c((C1804i) c1804i)) {
                return v;
            } else {
                m3992i();
                return null;
            }
        }

        void m3997n() {
            if ((this.f2361j.incrementAndGet() & 63) == 0) {
                m4000q();
            }
        }

        void m3998o() {
            m4001r();
        }

        void m3999p() {
            m4002s();
        }

        void m4000q() {
            m4001r();
            m4002s();
        }

        void m4001r() {
            if (tryLock()) {
                try {
                    m3977b();
                    m3993j();
                    this.f2361j.set(0);
                } finally {
                    unlock();
                }
            }
        }

        void m4002s() {
            if (!isHeldByCurrentThread()) {
                this.f2352a.m4157j();
            }
        }
    }

    private static final class SerializationProxy<K, V> extends AbstractSerializationProxy<K, V> {
        private static final long serialVersionUID = 3;

        SerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, long j, long j2, int i, int i2, C1761a<? super K, ? super V> c1761a, ConcurrentMap<K, V> concurrentMap) {
            super(strength, strength2, equivalence, equivalence2, j, j2, i, i2, c1761a, concurrentMap);
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            m3903a(objectOutputStream);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.j = m3901a(objectInputStream).m3887j();
            m3905b(objectInputStream);
        }

        private Object readResolve() {
            return this.j;
        }
    }

    enum Strength {
        STRONG {
            <K, V> C1791q<K, V> m4006a(Segment<K, V> segment, C1804i<K, V> c1804i, V v) {
                return new C1825o(v);
            }

            Equivalence<Object> m4005a() {
                return Equivalence.m2982a();
            }
        },
        SOFT {
            <K, V> C1791q<K, V> m4008a(Segment<K, V> segment, C1804i<K, V> c1804i, V v) {
                return new C1820j(segment.f2359h, v, c1804i);
            }

            Equivalence<Object> m4007a() {
                return Equivalence.m2983b();
            }
        },
        WEAK {
            <K, V> C1791q<K, V> m4010a(Segment<K, V> segment, C1804i<K, V> c1804i, V v) {
                return new C1832w(segment.f2359h, v, c1804i);
            }

            Equivalence<Object> m4009a() {
                return Equivalence.m2983b();
            }
        };

        abstract Equivalence<Object> m4003a();

        abstract <K, V> C1791q<K, V> m4004a(Segment<K, V> segment, C1804i<K, V> c1804i, V v);
    }

    /* renamed from: com.google.common.collect.MapMakerInternalMap.a */
    static abstract class C1808a<K, V> implements C1804i<K, V> {
        C1808a() {
        }

        public C1791q<K, V> m4011a() {
            throw new UnsupportedOperationException();
        }

        public void m4014a(C1791q<K, V> c1791q) {
            throw new UnsupportedOperationException();
        }

        public C1804i<K, V> m4015b() {
            throw new UnsupportedOperationException();
        }

        public int m4017c() {
            throw new UnsupportedOperationException();
        }

        public K m4019d() {
            throw new UnsupportedOperationException();
        }

        public long m4021e() {
            throw new UnsupportedOperationException();
        }

        public void m4012a(long j) {
            throw new UnsupportedOperationException();
        }

        public C1804i<K, V> m4022f() {
            throw new UnsupportedOperationException();
        }

        public void m4013a(C1804i<K, V> c1804i) {
            throw new UnsupportedOperationException();
        }

        public C1804i<K, V> m4023g() {
            throw new UnsupportedOperationException();
        }

        public void m4016b(C1804i<K, V> c1804i) {
            throw new UnsupportedOperationException();
        }

        public C1804i<K, V> m4024h() {
            throw new UnsupportedOperationException();
        }

        public void m4018c(C1804i<K, V> c1804i) {
            throw new UnsupportedOperationException();
        }

        public C1804i<K, V> m4025i() {
            throw new UnsupportedOperationException();
        }

        public void m4020d(C1804i<K, V> c1804i) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: com.google.common.collect.MapMakerInternalMap.f */
    abstract class C1809f<E> implements Iterator<E> {
        int f2368b;
        int f2369c;
        Segment<K, V> f2370d;
        AtomicReferenceArray<C1804i<K, V>> f2371e;
        C1804i<K, V> f2372f;
        C1833x f2373g;
        C1833x f2374h;
        final /* synthetic */ MapMakerInternalMap f2375i;

        C1809f(MapMakerInternalMap mapMakerInternalMap) {
            this.f2375i = mapMakerInternalMap;
            this.f2368b = mapMakerInternalMap.f2430c.length - 1;
            this.f2369c = -1;
            m4027b();
        }

        final void m4027b() {
            this.f2373g = null;
            if (!m4028c() && !m4029d()) {
                while (this.f2368b >= 0) {
                    Segment[] segmentArr = this.f2375i.f2430c;
                    int i = this.f2368b;
                    this.f2368b = i - 1;
                    this.f2370d = segmentArr[i];
                    if (this.f2370d.f2353b != 0) {
                        this.f2371e = this.f2370d.f2356e;
                        this.f2369c = this.f2371e.length() - 1;
                        if (m4029d()) {
                            return;
                        }
                    }
                }
            }
        }

        boolean m4028c() {
            if (this.f2372f != null) {
                this.f2372f = this.f2372f.m3930b();
                while (this.f2372f != null) {
                    if (m4026a(this.f2372f)) {
                        return true;
                    }
                    this.f2372f = this.f2372f.m3930b();
                }
            }
            return false;
        }

        boolean m4029d() {
            while (this.f2369c >= 0) {
                AtomicReferenceArray atomicReferenceArray = this.f2371e;
                int i = this.f2369c;
                this.f2369c = i - 1;
                C1804i c1804i = (C1804i) atomicReferenceArray.get(i);
                this.f2372f = c1804i;
                if (c1804i != null && (m4026a(this.f2372f) || m4028c())) {
                    return true;
                }
            }
            return false;
        }

        boolean m4026a(C1804i<K, V> c1804i) {
            try {
                Object d = c1804i.m3934d();
                Object b = this.f2375i.m4149b((C1804i) c1804i);
                if (b != null) {
                    this.f2373g = new C1833x(this.f2375i, d, b);
                    return true;
                }
                this.f2370d.m3997n();
                return false;
            } finally {
                this.f2370d.m3997n();
            }
        }

        public boolean hasNext() {
            return this.f2373g != null;
        }

        C1833x m4030e() {
            if (this.f2373g == null) {
                throw new NoSuchElementException();
            }
            this.f2374h = this.f2373g;
            m4027b();
            return this.f2374h;
        }

        public void remove() {
            C1650g.m3091b(this.f2374h != null);
            this.f2375i.remove(this.f2374h.getKey());
            this.f2374h = null;
        }
    }

    /* renamed from: com.google.common.collect.MapMakerInternalMap.b */
    final class C1810b extends C1809f<Entry<K, V>> {
        final /* synthetic */ MapMakerInternalMap f2376a;

        C1810b(MapMakerInternalMap mapMakerInternalMap) {
            this.f2376a = mapMakerInternalMap;
            super(mapMakerInternalMap);
        }

        public /* synthetic */ Object next() {
            return m4031a();
        }

        public Entry<K, V> m4031a() {
            return m4030e();
        }
    }

    /* renamed from: com.google.common.collect.MapMakerInternalMap.c */
    final class C1811c extends AbstractSet<Entry<K, V>> {
        final /* synthetic */ MapMakerInternalMap f2377a;

        C1811c(MapMakerInternalMap mapMakerInternalMap) {
            this.f2377a = mapMakerInternalMap;
        }

        public Iterator<Entry<K, V>> iterator() {
            return new C1810b(this.f2377a);
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
            key = this.f2377a.get(key);
            if (key == null || !this.f2377a.f2433f.m2985a(entry.getValue(), key)) {
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
            if (key == null || !this.f2377a.remove(key, entry.getValue())) {
                return false;
            }
            return true;
        }

        public int size() {
            return this.f2377a.size();
        }

        public boolean isEmpty() {
            return this.f2377a.isEmpty();
        }

        public void clear() {
            this.f2377a.clear();
        }
    }

    /* renamed from: com.google.common.collect.MapMakerInternalMap.d */
    static final class C1814d<K, V> extends AbstractQueue<C1804i<K, V>> {
        final C1804i<K, V> f2382a;

        /* renamed from: com.google.common.collect.MapMakerInternalMap.d.1 */
        class C18121 extends C1808a<K, V> {
            C1804i<K, V> f2378a;
            C1804i<K, V> f2379b;
            final /* synthetic */ C1814d f2380c;

            C18121(C1814d c1814d) {
                this.f2380c = c1814d;
                this.f2378a = this;
                this.f2379b = this;
            }

            public C1804i<K, V> m4034h() {
                return this.f2378a;
            }

            public void m4032c(C1804i<K, V> c1804i) {
                this.f2378a = c1804i;
            }

            public C1804i<K, V> m4035i() {
                return this.f2379b;
            }

            public void m4033d(C1804i<K, V> c1804i) {
                this.f2379b = c1804i;
            }
        }

        /* renamed from: com.google.common.collect.MapMakerInternalMap.d.2 */
        class C18132 extends C1695d<C1804i<K, V>> {
            final /* synthetic */ C1814d f2381a;

            C18132(C1814d c1814d, C1804i c1804i) {
                this.f2381a = c1814d;
                super(c1804i);
            }

            protected C1804i<K, V> m4036a(C1804i<K, V> c1804i) {
                C1804i<K, V> h = c1804i.m3939h();
                return h == this.f2381a.f2382a ? null : h;
            }
        }

        C1814d() {
            this.f2382a = new C18121(this);
        }

        public /* synthetic */ boolean offer(Object obj) {
            return m4039a((C1804i) obj);
        }

        public /* synthetic */ Object peek() {
            return m4038a();
        }

        public /* synthetic */ Object poll() {
            return m4040b();
        }

        public boolean m4039a(C1804i<K, V> c1804i) {
            MapMakerInternalMap.m4136b(c1804i.m3940i(), c1804i.m3939h());
            MapMakerInternalMap.m4136b(this.f2382a.m3940i(), c1804i);
            MapMakerInternalMap.m4136b(c1804i, this.f2382a);
            return true;
        }

        public C1804i<K, V> m4038a() {
            C1804i<K, V> h = this.f2382a.m3939h();
            return h == this.f2382a ? null : h;
        }

        public C1804i<K, V> m4040b() {
            C1804i<K, V> h = this.f2382a.m3939h();
            if (h == this.f2382a) {
                return null;
            }
            remove(h);
            return h;
        }

        public boolean remove(Object obj) {
            C1804i c1804i = (C1804i) obj;
            C1804i i = c1804i.m3940i();
            C1804i h = c1804i.m3939h();
            MapMakerInternalMap.m4136b(i, h);
            MapMakerInternalMap.m4138e(c1804i);
            return h != NullEntry.INSTANCE;
        }

        public boolean contains(Object obj) {
            return ((C1804i) obj).m3939h() != NullEntry.INSTANCE;
        }

        public boolean isEmpty() {
            return this.f2382a.m3939h() == this.f2382a;
        }

        public int size() {
            int i = 0;
            for (C1804i h = this.f2382a.m3939h(); h != this.f2382a; h = h.m3939h()) {
                i++;
            }
            return i;
        }

        public void clear() {
            C1804i h = this.f2382a.m3939h();
            while (h != this.f2382a) {
                C1804i h2 = h.m3939h();
                MapMakerInternalMap.m4138e(h);
                h = h2;
            }
            this.f2382a.m3933c(this.f2382a);
            this.f2382a.m3935d(this.f2382a);
        }

        public Iterator<C1804i<K, V>> iterator() {
            return new C18132(this, m4038a());
        }
    }

    /* renamed from: com.google.common.collect.MapMakerInternalMap.e */
    static final class C1817e<K, V> extends AbstractQueue<C1804i<K, V>> {
        final C1804i<K, V> f2387a;

        /* renamed from: com.google.common.collect.MapMakerInternalMap.e.1 */
        class C18151 extends C1808a<K, V> {
            C1804i<K, V> f2383a;
            C1804i<K, V> f2384b;
            final /* synthetic */ C1817e f2385c;

            C18151(C1817e c1817e) {
                this.f2385c = c1817e;
                this.f2383a = this;
                this.f2384b = this;
            }

            public long m4044e() {
                return Long.MAX_VALUE;
            }

            public void m4041a(long j) {
            }

            public C1804i<K, V> m4045f() {
                return this.f2383a;
            }

            public void m4042a(C1804i<K, V> c1804i) {
                this.f2383a = c1804i;
            }

            public C1804i<K, V> m4046g() {
                return this.f2384b;
            }

            public void m4043b(C1804i<K, V> c1804i) {
                this.f2384b = c1804i;
            }
        }

        /* renamed from: com.google.common.collect.MapMakerInternalMap.e.2 */
        class C18162 extends C1695d<C1804i<K, V>> {
            final /* synthetic */ C1817e f2386a;

            C18162(C1817e c1817e, C1804i c1804i) {
                this.f2386a = c1817e;
                super(c1804i);
            }

            protected C1804i<K, V> m4047a(C1804i<K, V> c1804i) {
                C1804i<K, V> f = c1804i.m3937f();
                return f == this.f2386a.f2387a ? null : f;
            }
        }

        C1817e() {
            this.f2387a = new C18151(this);
        }

        public /* synthetic */ boolean offer(Object obj) {
            return m4050a((C1804i) obj);
        }

        public /* synthetic */ Object peek() {
            return m4049a();
        }

        public /* synthetic */ Object poll() {
            return m4051b();
        }

        public boolean m4050a(C1804i<K, V> c1804i) {
            MapMakerInternalMap.m4135a(c1804i.m3938g(), c1804i.m3937f());
            MapMakerInternalMap.m4135a(this.f2387a.m3938g(), (C1804i) c1804i);
            MapMakerInternalMap.m4135a((C1804i) c1804i, this.f2387a);
            return true;
        }

        public C1804i<K, V> m4049a() {
            C1804i<K, V> f = this.f2387a.m3937f();
            return f == this.f2387a ? null : f;
        }

        public C1804i<K, V> m4051b() {
            C1804i<K, V> f = this.f2387a.m3937f();
            if (f == this.f2387a) {
                return null;
            }
            remove(f);
            return f;
        }

        public boolean remove(Object obj) {
            C1804i c1804i = (C1804i) obj;
            C1804i g = c1804i.m3938g();
            C1804i f = c1804i.m3937f();
            MapMakerInternalMap.m4135a(g, f);
            MapMakerInternalMap.m4137d(c1804i);
            return f != NullEntry.INSTANCE;
        }

        public boolean contains(Object obj) {
            return ((C1804i) obj).m3937f() != NullEntry.INSTANCE;
        }

        public boolean isEmpty() {
            return this.f2387a.m3937f() == this.f2387a;
        }

        public int size() {
            int i = 0;
            for (C1804i f = this.f2387a.m3937f(); f != this.f2387a; f = f.m3937f()) {
                i++;
            }
            return i;
        }

        public void clear() {
            C1804i f = this.f2387a.m3937f();
            while (f != this.f2387a) {
                C1804i f2 = f.m3937f();
                MapMakerInternalMap.m4137d(f);
                f = f2;
            }
            this.f2387a.m3928a(this.f2387a);
            this.f2387a.m3931b(this.f2387a);
        }

        public Iterator<C1804i<K, V>> iterator() {
            return new C18162(this, m4049a());
        }
    }

    /* renamed from: com.google.common.collect.MapMakerInternalMap.g */
    final class C1818g extends C1809f<K> {
        final /* synthetic */ MapMakerInternalMap f2388a;

        C1818g(MapMakerInternalMap mapMakerInternalMap) {
            this.f2388a = mapMakerInternalMap;
            super(mapMakerInternalMap);
        }

        public K next() {
            return m4030e().getKey();
        }
    }

    /* renamed from: com.google.common.collect.MapMakerInternalMap.h */
    final class C1819h extends AbstractSet<K> {
        final /* synthetic */ MapMakerInternalMap f2389a;

        C1819h(MapMakerInternalMap mapMakerInternalMap) {
            this.f2389a = mapMakerInternalMap;
        }

        public Iterator<K> iterator() {
            return new C1818g(this.f2389a);
        }

        public int size() {
            return this.f2389a.size();
        }

        public boolean isEmpty() {
            return this.f2389a.isEmpty();
        }

        public boolean contains(Object obj) {
            return this.f2389a.containsKey(obj);
        }

        public boolean remove(Object obj) {
            return this.f2389a.remove(obj) != null;
        }

        public void clear() {
            this.f2389a.clear();
        }
    }

    /* renamed from: com.google.common.collect.MapMakerInternalMap.j */
    static final class C1820j<K, V> extends SoftReference<V> implements C1791q<K, V> {
        final C1804i<K, V> f2390a;

        C1820j(ReferenceQueue<V> referenceQueue, V v, C1804i<K, V> c1804i) {
            super(v, referenceQueue);
            this.f2390a = c1804i;
        }

        public C1804i<K, V> m4052a() {
            return this.f2390a;
        }

        public void m4054a(C1791q<K, V> c1791q) {
            clear();
        }

        public C1791q<K, V> m4053a(ReferenceQueue<V> referenceQueue, V v, C1804i<K, V> c1804i) {
            return new C1820j(referenceQueue, v, c1804i);
        }

        public boolean m4055b() {
            return false;
        }
    }

    /* renamed from: com.google.common.collect.MapMakerInternalMap.k */
    static class C1821k<K, V> implements C1804i<K, V> {
        final K f2391a;
        final int f2392b;
        final C1804i<K, V> f2393c;
        volatile C1791q<K, V> f2394d;

        C1821k(K k, int i, C1804i<K, V> c1804i) {
            this.f2394d = MapMakerInternalMap.m4139g();
            this.f2391a = k;
            this.f2392b = i;
            this.f2393c = c1804i;
        }

        public K m4064d() {
            return this.f2391a;
        }

        public long m4066e() {
            throw new UnsupportedOperationException();
        }

        public void m4057a(long j) {
            throw new UnsupportedOperationException();
        }

        public C1804i<K, V> m4067f() {
            throw new UnsupportedOperationException();
        }

        public void m4058a(C1804i<K, V> c1804i) {
            throw new UnsupportedOperationException();
        }

        public C1804i<K, V> m4068g() {
            throw new UnsupportedOperationException();
        }

        public void m4061b(C1804i<K, V> c1804i) {
            throw new UnsupportedOperationException();
        }

        public C1804i<K, V> m4069h() {
            throw new UnsupportedOperationException();
        }

        public void m4063c(C1804i<K, V> c1804i) {
            throw new UnsupportedOperationException();
        }

        public C1804i<K, V> m4070i() {
            throw new UnsupportedOperationException();
        }

        public void m4065d(C1804i<K, V> c1804i) {
            throw new UnsupportedOperationException();
        }

        public C1791q<K, V> m4056a() {
            return this.f2394d;
        }

        public void m4059a(C1791q<K, V> c1791q) {
            C1791q c1791q2 = this.f2394d;
            this.f2394d = c1791q;
            c1791q2.m3890a(c1791q);
        }

        public int m4062c() {
            return this.f2392b;
        }

        public C1804i<K, V> m4060b() {
            return this.f2393c;
        }
    }

    /* renamed from: com.google.common.collect.MapMakerInternalMap.l */
    static final class C1822l<K, V> extends C1821k<K, V> implements C1804i<K, V> {
        C1804i<K, V> f2395e;
        C1804i<K, V> f2396f;

        C1822l(K k, int i, C1804i<K, V> c1804i) {
            super(k, i, c1804i);
            this.f2395e = MapMakerInternalMap.m4140h();
            this.f2396f = MapMakerInternalMap.m4140h();
        }

        public C1804i<K, V> m4073h() {
            return this.f2395e;
        }

        public void m4071c(C1804i<K, V> c1804i) {
            this.f2395e = c1804i;
        }

        public C1804i<K, V> m4074i() {
            return this.f2396f;
        }

        public void m4072d(C1804i<K, V> c1804i) {
            this.f2396f = c1804i;
        }
    }

    /* renamed from: com.google.common.collect.MapMakerInternalMap.m */
    static final class C1823m<K, V> extends C1821k<K, V> implements C1804i<K, V> {
        volatile long f2397e;
        C1804i<K, V> f2398f;
        C1804i<K, V> f2399g;

        C1823m(K k, int i, C1804i<K, V> c1804i) {
            super(k, i, c1804i);
            this.f2397e = Long.MAX_VALUE;
            this.f2398f = MapMakerInternalMap.m4140h();
            this.f2399g = MapMakerInternalMap.m4140h();
        }

        public long m4078e() {
            return this.f2397e;
        }

        public void m4075a(long j) {
            this.f2397e = j;
        }

        public C1804i<K, V> m4079f() {
            return this.f2398f;
        }

        public void m4076a(C1804i<K, V> c1804i) {
            this.f2398f = c1804i;
        }

        public C1804i<K, V> m4080g() {
            return this.f2399g;
        }

        public void m4077b(C1804i<K, V> c1804i) {
            this.f2399g = c1804i;
        }
    }

    /* renamed from: com.google.common.collect.MapMakerInternalMap.n */
    static final class C1824n<K, V> extends C1821k<K, V> implements C1804i<K, V> {
        volatile long f2400e;
        C1804i<K, V> f2401f;
        C1804i<K, V> f2402g;
        C1804i<K, V> f2403h;
        C1804i<K, V> f2404i;

        C1824n(K k, int i, C1804i<K, V> c1804i) {
            super(k, i, c1804i);
            this.f2400e = Long.MAX_VALUE;
            this.f2401f = MapMakerInternalMap.m4140h();
            this.f2402g = MapMakerInternalMap.m4140h();
            this.f2403h = MapMakerInternalMap.m4140h();
            this.f2404i = MapMakerInternalMap.m4140h();
        }

        public long m4086e() {
            return this.f2400e;
        }

        public void m4081a(long j) {
            this.f2400e = j;
        }

        public C1804i<K, V> m4087f() {
            return this.f2401f;
        }

        public void m4082a(C1804i<K, V> c1804i) {
            this.f2401f = c1804i;
        }

        public C1804i<K, V> m4088g() {
            return this.f2402g;
        }

        public void m4083b(C1804i<K, V> c1804i) {
            this.f2402g = c1804i;
        }

        public C1804i<K, V> m4089h() {
            return this.f2403h;
        }

        public void m4084c(C1804i<K, V> c1804i) {
            this.f2403h = c1804i;
        }

        public C1804i<K, V> m4090i() {
            return this.f2404i;
        }

        public void m4085d(C1804i<K, V> c1804i) {
            this.f2404i = c1804i;
        }
    }

    /* renamed from: com.google.common.collect.MapMakerInternalMap.o */
    static final class C1825o<K, V> implements C1791q<K, V> {
        final V f2405a;

        C1825o(V v) {
            this.f2405a = v;
        }

        public V get() {
            return this.f2405a;
        }

        public C1804i<K, V> m4091a() {
            return null;
        }

        public C1791q<K, V> m4092a(ReferenceQueue<V> referenceQueue, V v, C1804i<K, V> c1804i) {
            return this;
        }

        public boolean m4094b() {
            return false;
        }

        public void m4093a(C1791q<K, V> c1791q) {
        }
    }

    /* renamed from: com.google.common.collect.MapMakerInternalMap.p */
    final class C1826p extends C1809f<V> {
        final /* synthetic */ MapMakerInternalMap f2406a;

        C1826p(MapMakerInternalMap mapMakerInternalMap) {
            this.f2406a = mapMakerInternalMap;
            super(mapMakerInternalMap);
        }

        public V next() {
            return m4030e().getValue();
        }
    }

    /* renamed from: com.google.common.collect.MapMakerInternalMap.r */
    final class C1827r extends AbstractCollection<V> {
        final /* synthetic */ MapMakerInternalMap f2407a;

        C1827r(MapMakerInternalMap mapMakerInternalMap) {
            this.f2407a = mapMakerInternalMap;
        }

        public Iterator<V> iterator() {
            return new C1826p(this.f2407a);
        }

        public int size() {
            return this.f2407a.size();
        }

        public boolean isEmpty() {
            return this.f2407a.isEmpty();
        }

        public boolean contains(Object obj) {
            return this.f2407a.containsValue(obj);
        }

        public void clear() {
            this.f2407a.clear();
        }
    }

    /* renamed from: com.google.common.collect.MapMakerInternalMap.s */
    static class C1828s<K, V> extends WeakReference<K> implements C1804i<K, V> {
        final int f2408a;
        final C1804i<K, V> f2409b;
        volatile C1791q<K, V> f2410c;

        C1828s(ReferenceQueue<K> referenceQueue, K k, int i, C1804i<K, V> c1804i) {
            super(k, referenceQueue);
            this.f2410c = MapMakerInternalMap.m4139g();
            this.f2408a = i;
            this.f2409b = c1804i;
        }

        public K m4103d() {
            return get();
        }

        public long m4105e() {
            throw new UnsupportedOperationException();
        }

        public void m4096a(long j) {
            throw new UnsupportedOperationException();
        }

        public C1804i<K, V> m4106f() {
            throw new UnsupportedOperationException();
        }

        public void m4097a(C1804i<K, V> c1804i) {
            throw new UnsupportedOperationException();
        }

        public C1804i<K, V> m4107g() {
            throw new UnsupportedOperationException();
        }

        public void m4100b(C1804i<K, V> c1804i) {
            throw new UnsupportedOperationException();
        }

        public C1804i<K, V> m4108h() {
            throw new UnsupportedOperationException();
        }

        public void m4102c(C1804i<K, V> c1804i) {
            throw new UnsupportedOperationException();
        }

        public C1804i<K, V> m4109i() {
            throw new UnsupportedOperationException();
        }

        public void m4104d(C1804i<K, V> c1804i) {
            throw new UnsupportedOperationException();
        }

        public C1791q<K, V> m4095a() {
            return this.f2410c;
        }

        public void m4098a(C1791q<K, V> c1791q) {
            C1791q c1791q2 = this.f2410c;
            this.f2410c = c1791q;
            c1791q2.m3890a(c1791q);
        }

        public int m4101c() {
            return this.f2408a;
        }

        public C1804i<K, V> m4099b() {
            return this.f2409b;
        }
    }

    /* renamed from: com.google.common.collect.MapMakerInternalMap.t */
    static final class C1829t<K, V> extends C1828s<K, V> implements C1804i<K, V> {
        C1804i<K, V> f2411d;
        C1804i<K, V> f2412e;

        C1829t(ReferenceQueue<K> referenceQueue, K k, int i, C1804i<K, V> c1804i) {
            super(referenceQueue, k, i, c1804i);
            this.f2411d = MapMakerInternalMap.m4140h();
            this.f2412e = MapMakerInternalMap.m4140h();
        }

        public C1804i<K, V> m4112h() {
            return this.f2411d;
        }

        public void m4110c(C1804i<K, V> c1804i) {
            this.f2411d = c1804i;
        }

        public C1804i<K, V> m4113i() {
            return this.f2412e;
        }

        public void m4111d(C1804i<K, V> c1804i) {
            this.f2412e = c1804i;
        }
    }

    /* renamed from: com.google.common.collect.MapMakerInternalMap.u */
    static final class C1830u<K, V> extends C1828s<K, V> implements C1804i<K, V> {
        volatile long f2413d;
        C1804i<K, V> f2414e;
        C1804i<K, V> f2415f;

        C1830u(ReferenceQueue<K> referenceQueue, K k, int i, C1804i<K, V> c1804i) {
            super(referenceQueue, k, i, c1804i);
            this.f2413d = Long.MAX_VALUE;
            this.f2414e = MapMakerInternalMap.m4140h();
            this.f2415f = MapMakerInternalMap.m4140h();
        }

        public long m4117e() {
            return this.f2413d;
        }

        public void m4114a(long j) {
            this.f2413d = j;
        }

        public C1804i<K, V> m4118f() {
            return this.f2414e;
        }

        public void m4115a(C1804i<K, V> c1804i) {
            this.f2414e = c1804i;
        }

        public C1804i<K, V> m4119g() {
            return this.f2415f;
        }

        public void m4116b(C1804i<K, V> c1804i) {
            this.f2415f = c1804i;
        }
    }

    /* renamed from: com.google.common.collect.MapMakerInternalMap.v */
    static final class C1831v<K, V> extends C1828s<K, V> implements C1804i<K, V> {
        volatile long f2416d;
        C1804i<K, V> f2417e;
        C1804i<K, V> f2418f;
        C1804i<K, V> f2419g;
        C1804i<K, V> f2420h;

        C1831v(ReferenceQueue<K> referenceQueue, K k, int i, C1804i<K, V> c1804i) {
            super(referenceQueue, k, i, c1804i);
            this.f2416d = Long.MAX_VALUE;
            this.f2417e = MapMakerInternalMap.m4140h();
            this.f2418f = MapMakerInternalMap.m4140h();
            this.f2419g = MapMakerInternalMap.m4140h();
            this.f2420h = MapMakerInternalMap.m4140h();
        }

        public long m4125e() {
            return this.f2416d;
        }

        public void m4120a(long j) {
            this.f2416d = j;
        }

        public C1804i<K, V> m4126f() {
            return this.f2417e;
        }

        public void m4121a(C1804i<K, V> c1804i) {
            this.f2417e = c1804i;
        }

        public C1804i<K, V> m4127g() {
            return this.f2418f;
        }

        public void m4122b(C1804i<K, V> c1804i) {
            this.f2418f = c1804i;
        }

        public C1804i<K, V> m4128h() {
            return this.f2419g;
        }

        public void m4123c(C1804i<K, V> c1804i) {
            this.f2419g = c1804i;
        }

        public C1804i<K, V> m4129i() {
            return this.f2420h;
        }

        public void m4124d(C1804i<K, V> c1804i) {
            this.f2420h = c1804i;
        }
    }

    /* renamed from: com.google.common.collect.MapMakerInternalMap.w */
    static final class C1832w<K, V> extends WeakReference<V> implements C1791q<K, V> {
        final C1804i<K, V> f2421a;

        C1832w(ReferenceQueue<V> referenceQueue, V v, C1804i<K, V> c1804i) {
            super(v, referenceQueue);
            this.f2421a = c1804i;
        }

        public C1804i<K, V> m4130a() {
            return this.f2421a;
        }

        public void m4132a(C1791q<K, V> c1791q) {
            clear();
        }

        public C1791q<K, V> m4131a(ReferenceQueue<V> referenceQueue, V v, C1804i<K, V> c1804i) {
            return new C1832w(referenceQueue, v, c1804i);
        }

        public boolean m4133b() {
            return false;
        }
    }

    /* renamed from: com.google.common.collect.MapMakerInternalMap.x */
    final class C1833x extends C1766b<K, V> {
        final K f2422a;
        V f2423b;
        final /* synthetic */ MapMakerInternalMap f2424c;

        C1833x(MapMakerInternalMap mapMakerInternalMap, K k, V v) {
            this.f2424c = mapMakerInternalMap;
            this.f2422a = k;
            this.f2423b = v;
        }

        public K getKey() {
            return this.f2422a;
        }

        public V getValue() {
            return this.f2423b;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            if (this.f2422a.equals(entry.getKey()) && this.f2423b.equals(entry.getValue())) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.f2422a.hashCode() ^ this.f2423b.hashCode();
        }

        public V setValue(V v) {
            V put = this.f2424c.put(this.f2422a, v);
            this.f2423b = v;
            return put;
        }
    }

    static {
        f2427u = Logger.getLogger(MapMakerInternalMap.class.getName());
        f2425p = new C17921();
        f2426q = new C17932();
    }

    MapMakerInternalMap(MapMaker mapMaker) {
        Queue i;
        int i2 = 1;
        int i3 = 0;
        this.f2431d = Math.min(mapMaker.m3881d(), NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        this.f2434g = mapMaker.m3882e();
        this.f2435h = mapMaker.m3883f();
        this.f2432e = mapMaker.m3875b();
        this.f2433f = this.f2435h.m4003a();
        this.f2436i = mapMaker.f2322e;
        this.f2437j = mapMaker.m3885h();
        this.f2438k = mapMaker.m3884g();
        this.f2441n = EntryFactory.m3907a(this.f2434g, m4150b(), m4146a());
        this.f2442o = mapMaker.m3886i();
        this.f2440m = mapMaker.m3760a();
        if (this.f2440m == NullListener.INSTANCE) {
            i = m4141i();
        } else {
            i = new ConcurrentLinkedQueue();
        }
        this.f2439l = i;
        int min = Math.min(mapMaker.m3879c(), 1073741824);
        if (m4146a()) {
            min = Math.min(min, this.f2436i);
        }
        int i4 = 1;
        int i5 = 0;
        while (i4 < this.f2431d && (!m4146a() || i4 * 2 <= this.f2436i)) {
            i5++;
            i4 <<= 1;
        }
        this.f2429b = 32 - i5;
        this.f2428a = i4 - 1;
        this.f2430c = m4153c(i4);
        i5 = min / i4;
        if (i5 * i4 < min) {
            min = i5 + 1;
        } else {
            min = i5;
        }
        while (i2 < min) {
            i2 <<= 1;
        }
        if (m4146a()) {
            min = (this.f2436i / i4) + 1;
            i4 = this.f2436i % i4;
            while (i3 < this.f2430c.length) {
                if (i3 == i4) {
                    min--;
                }
                this.f2430c[i3] = m4143a(i2, min);
                i3++;
            }
            return;
        }
        while (i3 < this.f2430c.length) {
            this.f2430c[i3] = m4143a(i2, -1);
            i3++;
        }
    }

    boolean m4146a() {
        return this.f2436i != -1;
    }

    boolean m4150b() {
        return m4151c() || m4154d();
    }

    boolean m4151c() {
        return this.f2438k > 0;
    }

    boolean m4154d() {
        return this.f2437j > 0;
    }

    boolean m4155e() {
        return this.f2434g != Strength.STRONG;
    }

    boolean m4156f() {
        return this.f2435h != Strength.STRONG;
    }

    static <K, V> C1791q<K, V> m4139g() {
        return f2425p;
    }

    static <K, V> C1804i<K, V> m4140h() {
        return NullEntry.INSTANCE;
    }

    static <E> Queue<E> m4141i() {
        return f2426q;
    }

    static int m4134a(int i) {
        int i2 = ((i << 15) ^ -12931) + i;
        i2 ^= i2 >>> 10;
        i2 += i2 << 3;
        i2 ^= i2 >>> 6;
        i2 += (i2 << 2) + (i2 << 14);
        return i2 ^ (i2 >>> 16);
    }

    int m4142a(Object obj) {
        return m4134a(this.f2432e.m2984a(obj));
    }

    void m4145a(C1791q<K, V> c1791q) {
        C1804i a = c1791q.m3888a();
        int c = a.m3932c();
        m4148b(c).m3972a(a.m3934d(), c, (C1791q) c1791q);
    }

    void m4144a(C1804i<K, V> c1804i) {
        int c = c1804i.m3932c();
        m4148b(c).m3969a((C1804i) c1804i, c);
    }

    Segment<K, V> m4148b(int i) {
        return this.f2430c[(i >>> this.f2429b) & this.f2428a];
    }

    Segment<K, V> m4143a(int i, int i2) {
        return new Segment(this, i, i2);
    }

    V m4149b(C1804i<K, V> c1804i) {
        if (c1804i.m3934d() == null) {
            return null;
        }
        V v = c1804i.m3926a().get();
        if (v == null) {
            return null;
        }
        if (m4150b() && m4152c((C1804i) c1804i)) {
            return null;
        }
        return v;
    }

    boolean m4152c(C1804i<K, V> c1804i) {
        return m4147a((C1804i) c1804i, this.f2442o.m3121a());
    }

    boolean m4147a(C1804i<K, V> c1804i, long j) {
        return j - c1804i.m3936e() > 0;
    }

    static <K, V> void m4135a(C1804i<K, V> c1804i, C1804i<K, V> c1804i2) {
        c1804i.m3928a((C1804i) c1804i2);
        c1804i2.m3931b(c1804i);
    }

    static <K, V> void m4137d(C1804i<K, V> c1804i) {
        C1804i h = m4140h();
        c1804i.m3928a(h);
        c1804i.m3931b(h);
    }

    void m4157j() {
        while (true) {
            RemovalNotification removalNotification = (RemovalNotification) this.f2439l.poll();
            if (removalNotification != null) {
                try {
                    this.f2440m.m3758a(removalNotification);
                } catch (Throwable e) {
                    f2427u.log(Level.WARNING, "Exception thrown by removal listener", e);
                }
            } else {
                return;
            }
        }
    }

    static <K, V> void m4136b(C1804i<K, V> c1804i, C1804i<K, V> c1804i2) {
        c1804i.m3933c(c1804i2);
        c1804i2.m3935d(c1804i);
    }

    static <K, V> void m4138e(C1804i<K, V> c1804i) {
        C1804i h = m4140h();
        c1804i.m3933c(h);
        c1804i.m3935d(h);
    }

    final Segment<K, V>[] m4153c(int i) {
        return new Segment[i];
    }

    public boolean isEmpty() {
        int i;
        Segment[] segmentArr = this.f2430c;
        long j = 0;
        for (i = 0; i < segmentArr.length; i++) {
            if (segmentArr[i].f2353b != 0) {
                return false;
            }
            j += (long) segmentArr[i].f2354c;
        }
        if (j != 0) {
            for (i = 0; i < segmentArr.length; i++) {
                if (segmentArr[i].f2353b != 0) {
                    return false;
                }
                j -= (long) segmentArr[i].f2354c;
            }
            if (j != 0) {
                return false;
            }
        }
        return true;
    }

    public int size() {
        long j = 0;
        for (Segment segment : this.f2430c) {
            j += (long) segment.f2353b;
        }
        return C1662a.m3123a(j);
    }

    public V get(Object obj) {
        if (obj == null) {
            return null;
        }
        int a = m4142a(obj);
        return m4148b(a).m3980c(obj, a);
    }

    public boolean containsKey(Object obj) {
        if (obj == null) {
            return false;
        }
        int a = m4142a(obj);
        return m4148b(a).m3985d(obj, a);
    }

    public boolean containsValue(Object obj) {
        if (obj == null) {
            return false;
        }
        Segment[] segmentArr = this.f2430c;
        int i = 0;
        long j = -1;
        while (i < 3) {
            long j2 = 0;
            for (Segment segment : segmentArr) {
                int i2 = segment.f2353b;
                AtomicReferenceArray atomicReferenceArray = segment.f2356e;
                for (int i3 = 0; i3 < atomicReferenceArray.length(); i3++) {
                    for (C1804i c1804i = (C1804i) atomicReferenceArray.get(i3); c1804i != null; c1804i = c1804i.m3930b()) {
                        Object e = segment.m3986e(c1804i);
                        if (e != null && this.f2433f.m2985a(obj, e)) {
                            return true;
                        }
                    }
                }
                j2 += (long) segment.f2354c;
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
        int a = m4142a((Object) k);
        return m4148b(a).m3960a((Object) k, a, (Object) v, false);
    }

    public V putIfAbsent(K k, V v) {
        C1650g.m3080a((Object) k);
        C1650g.m3080a((Object) v);
        int a = m4142a((Object) k);
        return m4148b(a).m3960a((Object) k, a, (Object) v, true);
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
        int a = m4142a(obj);
        return m4148b(a).m3987e(obj, a);
    }

    public boolean remove(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int a = m4142a(obj);
        return m4148b(a).m3979b(obj, a, obj2);
    }

    public boolean replace(K k, V v, V v2) {
        C1650g.m3080a((Object) k);
        C1650g.m3080a((Object) v2);
        if (v == null) {
            return false;
        }
        int a = m4142a((Object) k);
        return m4148b(a).m3973a((Object) k, a, (Object) v, (Object) v2);
    }

    public V replace(K k, V v) {
        C1650g.m3080a((Object) k);
        C1650g.m3080a((Object) v);
        int a = m4142a((Object) k);
        return m4148b(a).m3959a((Object) k, a, (Object) v);
    }

    public void clear() {
        for (Segment m : this.f2430c) {
            m.m3996m();
        }
    }

    public Set<K> keySet() {
        Set<K> set = this.f2443r;
        if (set != null) {
            return set;
        }
        set = new C1819h(this);
        this.f2443r = set;
        return set;
    }

    public Collection<V> values() {
        Collection<V> collection = this.f2444s;
        if (collection != null) {
            return collection;
        }
        collection = new C1827r(this);
        this.f2444s = collection;
        return collection;
    }

    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = this.f2445t;
        if (set != null) {
            return set;
        }
        set = new C1811c(this);
        this.f2445t = set;
        return set;
    }

    Object writeReplace() {
        return new SerializationProxy(this.f2434g, this.f2435h, this.f2432e, this.f2433f, this.f2438k, this.f2437j, this.f2436i, this.f2431d, this.f2440m, this);
    }
}
