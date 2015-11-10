package com.google.common.cache;

/* renamed from: com.google.common.cache.a */
public abstract class C1734a<K, V> implements C1683b<K, V> {

    /* renamed from: com.google.common.cache.a.b */
    public interface C1665b {
        void m3132a();

        void m3133a(int i);

        void m3134a(long j);

        void m3135b(int i);

        void m3136b(long j);
    }

    /* renamed from: com.google.common.cache.a.a */
    public static final class C1733a implements C1665b {
        private final C1722f f2172a;
        private final C1722f f2173b;
        private final C1722f f2174c;
        private final C1722f f2175d;
        private final C1722f f2176e;
        private final C1722f f2177f;

        public C1733a() {
            this.f2172a = LongAddables.m3535a();
            this.f2173b = LongAddables.m3535a();
            this.f2174c = LongAddables.m3535a();
            this.f2175d = LongAddables.m3535a();
            this.f2176e = LongAddables.m3535a();
            this.f2177f = LongAddables.m3535a();
        }

        public void m3557a(int i) {
            this.f2172a.m3532a((long) i);
        }

        public void m3559b(int i) {
            this.f2173b.m3532a((long) i);
        }

        public void m3558a(long j) {
            this.f2174c.m3531a();
            this.f2176e.m3532a(j);
        }

        public void m3560b(long j) {
            this.f2175d.m3531a();
            this.f2176e.m3532a(j);
        }

        public void m3556a() {
            this.f2177f.m3531a();
        }
    }
}
