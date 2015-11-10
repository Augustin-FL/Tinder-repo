package com.crashlytics.android.core;

import com.crashlytics.android.core.p005a.p006a.C0397a;
import com.crashlytics.android.core.p005a.p006a.C0398b;
import com.crashlytics.android.core.p005a.p006a.C0399c;
import com.crashlytics.android.core.p005a.p006a.C0400d;
import com.crashlytics.android.core.p005a.p006a.C0401e;
import com.crashlytics.android.core.p005a.p006a.C0403f;
import com.crashlytics.android.core.p005a.p006a.C0403f.C0402a;
import com.facebook.stetho.BuildConfig;
import io.fabric.sdk.android.C3218c;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/* renamed from: com.crashlytics.android.core.r */
class C0471r {
    private static final C0401e f666a;
    private static final C0458j[] f667b;
    private static final C0470m[] f668c;
    private static final C0465g[] f669d;
    private static final C0460b[] f670e;
    private static final C0461c[] f671f;

    /* renamed from: com.crashlytics.android.core.r.j */
    private static abstract class C0458j {
        private final int f638a;
        private final C0458j[] f639b;

        public C0458j(int i, C0458j... c0458jArr) {
            this.f638a = i;
            if (c0458jArr == null) {
                c0458jArr = C0471r.f667b;
            }
            this.f639b = c0458jArr;
        }

        public int m827b() {
            int c = m829c();
            return (c + CodedOutputStream.m586l(c)) + CodedOutputStream.m585j(this.f638a);
        }

        public int m829c() {
            int a = m825a();
            for (C0458j b : this.f639b) {
                a += b.m827b();
            }
            return a;
        }

        public void m828b(CodedOutputStream codedOutputStream) throws IOException {
            codedOutputStream.m611g(this.f638a, 2);
            codedOutputStream.m613k(m829c());
            m826a(codedOutputStream);
            for (C0458j b : this.f639b) {
                b.m828b(codedOutputStream);
            }
        }

        public int m825a() {
            return 0;
        }

        public void m826a(CodedOutputStream codedOutputStream) throws IOException {
        }
    }

    /* renamed from: com.crashlytics.android.core.r.a */
    private static final class C0459a extends C0458j {
        public C0459a(C0464f c0464f, C0468k c0468k) {
            super(3, c0464f, c0468k);
        }
    }

    /* renamed from: com.crashlytics.android.core.r.b */
    private static final class C0460b extends C0458j {
        private final long f640a;
        private final long f641b;
        private final String f642c;
        private final String f643d;

        public C0460b(C0397a c0397a) {
            super(4, new C0458j[0]);
            this.f640a = c0397a.f489a;
            this.f641b = c0397a.f490b;
            this.f642c = c0397a.f491c;
            this.f643d = c0397a.f492d;
        }

        public int m830a() {
            int b = CodedOutputStream.m571b(1, this.f640a);
            return ((b + CodedOutputStream.m572b(3, C0406b.m620a(this.f642c))) + CodedOutputStream.m571b(2, this.f641b)) + CodedOutputStream.m572b(4, C0406b.m620a(this.f643d));
        }

        public void m831a(CodedOutputStream codedOutputStream) throws IOException {
            codedOutputStream.m593a(1, this.f640a);
            codedOutputStream.m593a(2, this.f641b);
            codedOutputStream.m594a(3, C0406b.m620a(this.f642c));
            codedOutputStream.m594a(4, C0406b.m620a(this.f643d));
        }
    }

    /* renamed from: com.crashlytics.android.core.r.c */
    private static final class C0461c extends C0458j {
        private final String f644a;
        private final String f645b;

        public C0461c(C0398b c0398b) {
            super(2, new C0458j[0]);
            this.f644a = c0398b.f493a;
            this.f645b = c0398b.f494b;
        }

        public int m832a() {
            return CodedOutputStream.m572b(2, C0406b.m620a(this.f645b == null ? BuildConfig.FLAVOR : this.f645b)) + CodedOutputStream.m572b(1, C0406b.m620a(this.f644a));
        }

        public void m833a(CodedOutputStream codedOutputStream) throws IOException {
            codedOutputStream.m594a(1, C0406b.m620a(this.f644a));
            codedOutputStream.m594a(2, C0406b.m620a(this.f645b == null ? BuildConfig.FLAVOR : this.f645b));
        }
    }

    /* renamed from: com.crashlytics.android.core.r.d */
    private static final class C0462d extends C0458j {
        private final float f646a;
        private final int f647b;
        private final boolean f648c;
        private final int f649d;
        private final long f650e;
        private final long f651f;

        public C0462d(float f, int i, boolean z, int i2, long j, long j2) {
            super(5, new C0458j[0]);
            this.f646a = f;
            this.f647b = i;
            this.f648c = z;
            this.f649d = i2;
            this.f650e = j;
            this.f651f = j2;
        }

        public int m834a() {
            return (((((0 + CodedOutputStream.m570b(1, this.f646a)) + CodedOutputStream.m582f(2, this.f647b)) + CodedOutputStream.m573b(3, this.f648c)) + CodedOutputStream.m577d(4, this.f649d)) + CodedOutputStream.m571b(5, this.f650e)) + CodedOutputStream.m571b(6, this.f651f);
        }

        public void m835a(CodedOutputStream codedOutputStream) throws IOException {
            codedOutputStream.m591a(1, this.f646a);
            codedOutputStream.m607c(2, this.f647b);
            codedOutputStream.m596a(3, this.f648c);
            codedOutputStream.m592a(4, this.f649d);
            codedOutputStream.m593a(5, this.f650e);
            codedOutputStream.m593a(6, this.f651f);
        }
    }

    /* renamed from: com.crashlytics.android.core.r.e */
    private static final class C0463e extends C0458j {
        private final long f652a;
        private final String f653b;

        public C0463e(long j, String str, C0458j... c0458jArr) {
            super(10, c0458jArr);
            this.f652a = j;
            this.f653b = str;
        }

        public int m836a() {
            return CodedOutputStream.m571b(1, this.f652a) + CodedOutputStream.m572b(2, C0406b.m620a(this.f653b));
        }

        public void m837a(CodedOutputStream codedOutputStream) throws IOException {
            codedOutputStream.m593a(1, this.f652a);
            codedOutputStream.m594a(2, C0406b.m620a(this.f653b));
        }
    }

    /* renamed from: com.crashlytics.android.core.r.f */
    private static final class C0464f extends C0458j {
        public C0464f(C0469l c0469l, C0468k c0468k, C0468k c0468k2) {
            super(1, c0468k, c0469l, c0468k2);
        }
    }

    /* renamed from: com.crashlytics.android.core.r.g */
    private static final class C0465g extends C0458j {
        private final long f654a;
        private final String f655b;
        private final String f656c;
        private final long f657d;
        private final int f658e;

        public C0465g(C0402a c0402a) {
            super(3, new C0458j[0]);
            this.f654a = c0402a.f512a;
            this.f655b = c0402a.f513b;
            this.f656c = c0402a.f514c;
            this.f657d = c0402a.f515d;
            this.f658e = c0402a.f516e;
        }

        public int m838a() {
            return (((CodedOutputStream.m571b(1, this.f654a) + CodedOutputStream.m572b(2, C0406b.m620a(this.f655b))) + CodedOutputStream.m572b(3, C0406b.m620a(this.f656c))) + CodedOutputStream.m571b(4, this.f657d)) + CodedOutputStream.m577d(5, this.f658e);
        }

        public void m839a(CodedOutputStream codedOutputStream) throws IOException {
            codedOutputStream.m593a(1, this.f654a);
            codedOutputStream.m594a(2, C0406b.m620a(this.f655b));
            codedOutputStream.m594a(3, C0406b.m620a(this.f656c));
            codedOutputStream.m593a(4, this.f657d);
            codedOutputStream.m592a(5, this.f658e);
        }
    }

    /* renamed from: com.crashlytics.android.core.r.h */
    private static final class C0466h extends C0458j {
        C0406b f659a;

        public C0466h(C0406b c0406b) {
            super(6, new C0458j[0]);
            this.f659a = c0406b;
        }

        public int m840a() {
            return CodedOutputStream.m572b(1, this.f659a);
        }

        public void m841a(CodedOutputStream codedOutputStream) throws IOException {
            codedOutputStream.m594a(1, this.f659a);
        }
    }

    /* renamed from: com.crashlytics.android.core.r.i */
    private static final class C0467i extends C0458j {
        public C0467i() {
            super(0, new C0458j[0]);
        }

        public void m842b(CodedOutputStream codedOutputStream) throws IOException {
        }
    }

    /* renamed from: com.crashlytics.android.core.r.k */
    private static final class C0468k extends C0458j {
        private final C0458j[] f660a;

        public C0468k(C0458j... c0458jArr) {
            super(0, new C0458j[0]);
            this.f660a = c0458jArr;
        }

        public void m844b(CodedOutputStream codedOutputStream) throws IOException {
            for (C0458j b : this.f660a) {
                b.m828b(codedOutputStream);
            }
        }

        public int m843b() {
            int i = 0;
            C0458j[] c0458jArr = this.f660a;
            int i2 = 0;
            while (i < c0458jArr.length) {
                i2 += c0458jArr[i].m827b();
                i++;
            }
            return i2;
        }
    }

    /* renamed from: com.crashlytics.android.core.r.l */
    private static final class C0469l extends C0458j {
        private final String f661a;
        private final String f662b;
        private final long f663c;

        public C0469l(C0401e c0401e) {
            super(3, new C0458j[0]);
            this.f661a = c0401e.f509a;
            this.f662b = c0401e.f510b;
            this.f663c = c0401e.f511c;
        }

        public int m845a() {
            return (CodedOutputStream.m572b(1, C0406b.m620a(this.f661a)) + CodedOutputStream.m572b(2, C0406b.m620a(this.f662b))) + CodedOutputStream.m571b(3, this.f663c);
        }

        public void m846a(CodedOutputStream codedOutputStream) throws IOException {
            codedOutputStream.m594a(1, C0406b.m620a(this.f661a));
            codedOutputStream.m594a(2, C0406b.m620a(this.f662b));
            codedOutputStream.m593a(3, this.f663c);
        }
    }

    /* renamed from: com.crashlytics.android.core.r.m */
    private static final class C0470m extends C0458j {
        private final String f664a;
        private final int f665b;

        public C0470m(C0403f c0403f, C0468k c0468k) {
            super(1, c0468k);
            this.f664a = c0403f.f517a;
            this.f665b = c0403f.f518b;
        }

        public int m848a() {
            return (m847d() ? CodedOutputStream.m572b(1, C0406b.m620a(this.f664a)) : 0) + CodedOutputStream.m577d(2, this.f665b);
        }

        public void m849a(CodedOutputStream codedOutputStream) throws IOException {
            if (m847d()) {
                codedOutputStream.m594a(1, C0406b.m620a(this.f664a));
            }
            codedOutputStream.m592a(2, this.f665b);
        }

        private boolean m847d() {
            return this.f664a != null && this.f664a.length() > 0;
        }
    }

    static {
        f666a = new C0401e(BuildConfig.FLAVOR, BuildConfig.FLAVOR, 0);
        f667b = new C0458j[0];
        f668c = new C0470m[0];
        f669d = new C0465g[0];
        f670e = new C0460b[0];
        f671f = new C0461c[0];
    }

    private static C0463e m851a(C0400d c0400d, C0455p c0455p, Map<String, String> map) throws IOException {
        C0459a c0459a = new C0459a(new C0464f(new C0469l(c0400d.f504b != null ? c0400d.f504b : f666a), C0471r.m855a(c0400d.f505c), C0471r.m852a(c0400d.f506d)), C0471r.m853a(C0471r.m857a(c0400d.f507e, map)));
        C0462d a = C0471r.m850a(c0400d.f508f);
        C0406b a2 = c0455p.m810a();
        if (a2 == null) {
            C3218c.m9728h().m9687a("CrashlyticsCore", "No log data to include with this event.");
        }
        c0455p.m815b();
        C0466h c0466h = a2 != null ? new C0466h(a2) : new C0467i();
        return new C0463e(c0400d.f503a, "ndk-crash", c0459a, a, c0466h);
    }

    private static C0398b[] m857a(C0398b[] c0398bArr, Map<String, String> map) {
        int i;
        Map treeMap = new TreeMap(map);
        if (c0398bArr != null) {
            for (C0398b c0398b : c0398bArr) {
                treeMap.put(c0398b.f493a, c0398b.f494b);
            }
        }
        Entry[] entryArr = (Entry[]) treeMap.entrySet().toArray(new Entry[treeMap.size()]);
        C0398b[] c0398bArr2 = new C0398b[entryArr.length];
        for (i = 0; i < c0398bArr2.length; i++) {
            c0398bArr2[i] = new C0398b((String) entryArr[i].getKey(), (String) entryArr[i].getValue());
        }
        return c0398bArr2;
    }

    private static C0462d m850a(C0399c c0399c) {
        return new C0462d(((float) c0399c.f500f) / 100.0f, c0399c.f501g, c0399c.f502h, c0399c.f495a, c0399c.f496b - c0399c.f498d, c0399c.f497c - c0399c.f499e);
    }

    private static C0468k m855a(C0403f[] c0403fArr) {
        C0458j[] c0458jArr = c0403fArr != null ? new C0470m[c0403fArr.length] : f668c;
        for (int i = 0; i < c0458jArr.length; i++) {
            C0403f c0403f = c0403fArr[i];
            c0458jArr[i] = new C0470m(c0403f, C0471r.m854a(c0403f.f519c));
        }
        return new C0468k(c0458jArr);
    }

    private static C0468k m854a(C0402a[] c0402aArr) {
        C0458j[] c0458jArr = c0402aArr != null ? new C0465g[c0402aArr.length] : f669d;
        for (int i = 0; i < c0458jArr.length; i++) {
            c0458jArr[i] = new C0465g(c0402aArr[i]);
        }
        return new C0468k(c0458jArr);
    }

    private static C0468k m852a(C0397a[] c0397aArr) {
        C0458j[] c0458jArr = c0397aArr != null ? new C0460b[c0397aArr.length] : f670e;
        for (int i = 0; i < c0458jArr.length; i++) {
            c0458jArr[i] = new C0460b(c0397aArr[i]);
        }
        return new C0468k(c0458jArr);
    }

    private static C0468k m853a(C0398b[] c0398bArr) {
        C0458j[] c0458jArr = c0398bArr != null ? new C0461c[c0398bArr.length] : f671f;
        for (int i = 0; i < c0458jArr.length; i++) {
            c0458jArr[i] = new C0461c(c0398bArr[i]);
        }
        return new C0468k(c0458jArr);
    }

    public static void m856a(C0400d c0400d, C0455p c0455p, Map<String, String> map, CodedOutputStream codedOutputStream) throws IOException {
        C0471r.m851a(c0400d, c0455p, map).m828b(codedOutputStream);
    }
}
