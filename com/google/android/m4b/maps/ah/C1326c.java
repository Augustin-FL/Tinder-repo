package com.google.android.m4b.maps.ah;

import com.google.android.m4b.maps.ag.e;
import com.google.android.m4b.maps.ag.k;
import com.google.android.m4b.maps.ag.r;
import java.io.DataInput;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.m4b.maps.ah.c */
public final class C1326c {
    private static final String[] f805a;
    private static List<C1326c> f806b;
    private int f807c;
    private int f808d;
    private int f809e;
    private int f810f;
    private int f811g;
    private int f812h;
    private final String f813i;

    static {
        f805a = new String[]{"c", "v"};
    }

    private C1326c(String str) {
        this.f807c = 0;
        this.f808d = 0;
        this.f810f = 0;
        this.f811g = 0;
        this.f809e = 0;
        this.f812h = 0;
        this.f813i = str;
    }

    public static synchronized C1326c m1071a(byte b) {
        C1326c c1326c;
        synchronized (C1326c.class) {
            if (f806b == null) {
                f806b = C1326c.m1073d();
            }
            if (1 >= f806b.size()) {
                c1326c = null;
            } else {
                c1326c = (C1326c) f806b.get(1);
            }
        }
        return c1326c;
    }

    public final void m1074a() {
        synchronized (this) {
            this.f809e++;
            this.f812h++;
        }
    }

    public final void m1075b() {
        synchronized (this) {
            this.f807c++;
            this.f810f++;
        }
        m1072a(false);
    }

    public final void m1076c() {
        synchronized (this) {
            this.f808d++;
            this.f811g++;
        }
        m1072a(false);
    }

    private static List<C1326c> m1073d() {
        int i;
        int i2 = 0;
        DataInput b = e.a().d().b("CacheHitStats");
        List<C1326c> arrayList = new ArrayList();
        if (b != null) {
            try {
                if (b.readInt() == 2) {
                    i = 0;
                    while (true) {
                        String[] strArr = f805a;
                        if (i >= 2) {
                            break;
                        }
                        C1326c c1326c = new C1326c(f805a[i]);
                        c1326c.f807c = b.readInt();
                        c1326c.f808d = b.readInt();
                        b.readInt();
                        b.readInt();
                        c1326c.f809e = b.readInt();
                        arrayList.add(c1326c);
                        i++;
                    }
                }
            } catch (Throwable e) {
                k.a("STATS", e);
                e.a().q().b("CacheHitStats");
            }
        }
        i = arrayList.size();
        String[] strArr2 = f805a;
        if (i != 2) {
            arrayList.clear();
            while (true) {
                String[] strArr3 = f805a;
                if (i2 >= 2) {
                    break;
                }
                arrayList.add(new C1326c(f805a[i2]));
                i2++;
            }
        }
        return arrayList;
    }

    private void m1072a(boolean z) {
        synchronized (this) {
            int i = this.f810f;
            int i2 = this.f811g;
            int i3 = this.f812h;
            if (i + i2 <= 50) {
                return;
            }
            this.f810f = 0;
            this.f811g = 0;
            this.f812h = 0;
            StringBuilder stringBuilder = new StringBuilder();
            if (i > 0) {
                stringBuilder.append("|");
                stringBuilder.append("f");
                stringBuilder.append("=");
                stringBuilder.append(i);
            }
            if (i2 > 0) {
                stringBuilder.append("|");
                stringBuilder.append("m");
                stringBuilder.append("=");
                stringBuilder.append(i2);
            }
            if (i3 > 0) {
                stringBuilder.append("|");
                stringBuilder.append("r");
                stringBuilder.append("=");
                stringBuilder.append(i3);
            }
            stringBuilder.append("|");
            r.a(22, this.f813i, stringBuilder.toString());
        }
    }
}
