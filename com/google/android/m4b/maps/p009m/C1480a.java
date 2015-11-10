package com.google.android.m4b.maps.p009m;

import com.facebook.stetho.BuildConfig;
import com.google.common.p024c.C1664c;
import java.io.DataInput;
import java.util.regex.Pattern;

/* renamed from: com.google.android.m4b.maps.m.a */
public abstract class C1480a {
    public static final C1480a f1436a;

    /* renamed from: com.google.android.m4b.maps.m.a.a */
    public static class C1481a extends C1480a {
        protected final long f1437b;
        protected final long f1438c;
        protected final long f1439d;

        C1481a(long j) {
            this(0, j);
        }

        C1481a(long j, long j2) {
            this.f1437b = C1480a.m2292a(j, j2);
            this.f1438c = j;
            this.f1439d = j2;
        }

        public final String m2299a() {
            return "0x" + Long.toHexString(this.f1438c) + ":0x" + Long.toHexString(this.f1439d);
        }

        public String toString() {
            return m2299a();
        }

        public int hashCode() {
            return (int) (this.f1437b ^ (this.f1437b >>> 32));
        }

        public boolean equals(Object obj) {
            if (obj instanceof C1482b) {
                return ((C1482b) obj).f1440b == this.f1437b;
            } else {
                return m2300a(obj);
            }
        }

        public final boolean m2300a(Object obj) {
            if (!(obj instanceof C1481a)) {
                return false;
            }
            C1481a c1481a = (C1481a) obj;
            if (c1481a.f1438c == this.f1438c && c1481a.f1439d == this.f1439d && c1481a.f1437b == this.f1437b) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: com.google.android.m4b.maps.m.a.b */
    public static class C1482b extends C1480a {
        protected final long f1440b;

        C1482b(long j) {
            this.f1440b = j;
        }

        public final String m2301a() {
            return BuildConfig.FLAVOR;
        }

        public final String toString() {
            return "[hash:" + this.f1440b + "]";
        }

        public final int hashCode() {
            return (int) (this.f1440b ^ (this.f1440b >>> 32));
        }

        public final boolean equals(Object obj) {
            if (obj instanceof C1481a) {
                return ((C1481a) obj).f1437b == this.f1440b;
            } else {
                return m2302a(obj);
            }
        }

        public final boolean m2302a(Object obj) {
            if ((obj instanceof C1482b) && ((C1482b) obj).f1440b == this.f1440b) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: com.google.android.m4b.maps.m.a.c */
    public static final class C1483c extends C1481a {
        public C1483c(long j, long j2) {
            super(j, j2);
        }

        public static C1483c m2303b(String str) {
            try {
                C1480a a = C1480a.m2294a(str);
                if (a instanceof C1481a) {
                    return new C1483c(((C1481a) a).f1438c, ((C1481a) a).f1439d);
                }
            } catch (IllegalArgumentException e) {
            }
            return null;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof C1483c) {
                if (this.d != ((C1483c) obj).d) {
                    return false;
                }
                return true;
            } else if (!(obj instanceof C1486c)) {
                return false;
            } else {
                if (this.d != ((C1486c) obj).m2309a().d) {
                    return false;
                }
                return true;
            }
        }

        public final int hashCode() {
            return (int) (this.d ^ (this.d >>> 32));
        }

        public final String m2304c() {
            return Long.toHexString(this.d);
        }
    }

    /* renamed from: com.google.android.m4b.maps.m.a.d */
    public static class C1484d extends C1480a {
        private C1485b f1441b;
        private int f1442c;

        C1484d(C1485b c1485b, int i) {
            this.f1441b = c1485b;
            this.f1442c = i;
        }

        public final String m2305a() {
            return this.f1441b.m2307a() + "|" + this.f1441b.m2308b() + "|" + Integer.toString(this.f1442c);
        }

        public final int hashCode() {
            return m2305a().hashCode();
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof C1484d)) {
                return false;
            }
            C1484d c1484d = (C1484d) obj;
            if (c1484d.f1441b.equals(this.f1441b) && c1484d.f1442c == this.f1442c) {
                return true;
            }
            return false;
        }

        public final boolean m2306a(Object obj) {
            return equals(obj);
        }
    }

    public abstract String m2297a();

    static /* synthetic */ long m2292a(long j, long j2) {
        long j3 = j >>> 16;
        j3 = (((j3 >>> 44) ^ (j3 << 4)) & 281474976710655L) ^ (((j << 32) & 281474976710655L) | (j2 >>> 32));
        return (((j3 >>> 44) ^ (j3 << 4)) & 281474976710655L) ^ (4294967295L & j2);
    }

    static {
        f1436a = new C1481a(0, 0);
    }

    public static C1481a m2293a(DataInput dataInput) {
        return new C1481a(dataInput.readLong(), dataInput.readLong());
    }

    public static C1482b m2296b(DataInput dataInput) {
        return new C1482b(((((long) dataInput.readShort()) & 65535) << 32) | (((long) dataInput.readInt()) & 4294967295L));
    }

    public static C1480a m2294a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("null feature id");
        }
        String[] split = str.split(":");
        String[] split2 = str.split("\\|");
        if (split.length == 2) {
            if (split[0].startsWith("0x") && split[1].startsWith("0x")) {
                return new C1481a(C1487d.m2311a(split[0].substring(2)), C1487d.m2311a(split[1].substring(2)));
            }
            throw new IllegalArgumentException("malformed feature id " + str);
        } else if (split2.length == 3) {
            int parseInt = Integer.parseInt(split2[0]);
            int parseInt2 = Integer.parseInt(split2[1]);
            return new C1484d(new C1485b(parseInt, parseInt2), Integer.parseInt(split2[2]));
        } else if (str.startsWith("0x")) {
            return new C1482b(C1487d.m2311a(str.substring(2)));
        } else {
            if (Pattern.matches("[0-9]{1,20}", str)) {
                return new C1481a(C1664c.m3127a(str));
            }
            throw new IllegalArgumentException("malformed feature id " + str);
        }
    }

    boolean m2298a(Object obj) {
        return false;
    }

    public static int m2295b() {
        return 40;
    }
}
