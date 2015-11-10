package com.google.android.m4b.maps.ay;

import java.io.DataInput;

public class ab {
    public static final ab f996b;
    protected final int f997a;

    /* renamed from: com.google.android.m4b.maps.ay.ab.a */
    public static class C1392a extends ab {
        public static final C1392a f998c;

        static {
            f998c = new C1392a(5, 0);
        }

        private C1392a(int i) {
            super(i);
        }

        private C1392a(int i, int i2) {
            super(80);
        }

        public static C1392a m1431b(DataInput dataInput) {
            return new C1392a(dataInput.readUnsignedByte());
        }

        public final int m1432d() {
            return (this.a >> 4) & 15;
        }
    }

    static {
        f996b = new ab(5);
    }

    public ab(int i) {
        this.f997a = i;
    }

    public static ab m1427a(DataInput dataInput) {
        return new ab(dataInput.readUnsignedByte());
    }

    public final int m1429a() {
        return this.f997a & 3;
    }

    public final int m1430b() {
        return (this.f997a >> 2) & 3;
    }

    public int hashCode() {
        return this.f997a + 31;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (this.f997a != ((ab) obj).f997a) {
            return false;
        }
        return true;
    }

    public static int m1428c() {
        return 16;
    }
}
