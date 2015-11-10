package com.google.android.m4b.maps.au;

import com.google.android.m4b.maps.au.C1344a.C1343b;
import com.google.android.m4b.maps.au.C1357e.C1353a;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.google.android.m4b.maps.au.b */
final class C1346b {
    private final C1347m f860a;
    private final C1347m f861b;
    private final C1347m f862c;
    private final C1347m f863d;

    /* renamed from: com.google.android.m4b.maps.au.b.1 */
    static /* synthetic */ class C13451 {
        static final /* synthetic */ int[] f859a;

        static {
            f859a = new int[C1343b.values().length];
            try {
                f859a[C1343b.RIGHT_VERTEX.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f859a[C1343b.MERGE_VERTEX.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public C1346b(C1361g c1361g) {
        this.f860a = c1361g.m1238b();
        this.f861b = c1361g.m1238b();
        this.f862c = c1361g.m1238b();
        this.f863d = c1361g.m1238b();
    }

    public C1346b(C1347m c1347m) {
        this.f860a = c1347m.m1176c();
        this.f861b = c1347m.m1176c();
        this.f862c = c1347m.m1176c();
        this.f863d = c1347m.m1176c();
    }

    private C1346b(C1347m c1347m, C1347m c1347m2, C1347m c1347m3, C1347m c1347m4) {
        this.f860a = c1347m;
        this.f861b = c1347m2;
        this.f862c = c1347m3;
        this.f863d = c1347m4;
    }

    public final void m1154a(int i, int i2, int i3) {
        int i4 = 0;
        if (this.f860a.f866c != 0) {
            i4 = m1144d(i2, i3, i2);
        }
        m1140a(i4, i2, i3, i2, -1);
        m1140a(i4 + 1, i2, i, -1, -1);
    }

    public final int m1152a(int i, int i2, C1343b c1343b) {
        if (this.f860a.m1186g(i, i2) < 0) {
            int d = m1144d(i, i2, i);
            switch (C13451.f859a[c1343b.ordinal()]) {
                case C3374b.SmoothProgressBar_spb_color /*1*/:
                    m1140a(d, i, i2, m1145e(this.f860a.m1178d(i), i, i), -1);
                    return -1;
                default:
                    throw new C1353a("Impossible EdgeList start case.");
            }
        }
        m1140a(m1144d(i2, i, i2), i2, i, -1, -1);
        return m1147f(m1143d(i2), i2);
    }

    public final int m1157b(int i, int i2, C1343b c1343b) {
        int g;
        int i3 = -1;
        int d;
        if (this.f860a.m1186g(i, i2) < 0) {
            g = m1148g(i, i2);
            if (!this.f863d.m1189i(g)) {
                i3 = this.f863d.m1191j(g);
            }
            switch (C13451.f859a[c1343b.ordinal()]) {
                case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                    d = m1143d(i2);
                    if (!this.f863d.m1189i(d)) {
                        i3 = this.f863d.m1191j(d);
                    }
                    this.f862c.m1184f(d, i2);
                    this.f863d.m1184f(d, i2);
                    break;
            }
        }
        d = m1148g(i2, i);
        int d2 = m1143d(i);
        if (!this.f863d.m1189i(d2)) {
            g = this.f863d.m1191j(d2);
            this.f863d.m1184f(d2, -1);
            i3 = g;
        }
        this.f862c.m1184f(d2, i);
        g = d;
        m1142c(g);
        return i3;
    }

    public final void m1158b(int i, int i2, int i3) {
        int d = m1144d(i2, i3, i2);
        int e = m1145e(this.f860a.m1191j(d - 1), this.f861b.m1191j(d - 1), i2);
        m1147f(m1143d(i2), i2);
        m1140a(d, i2, i3, e, -1);
        m1140a(d, i2, i, -1, -1);
    }

    public final boolean m1155a(int i, int i2) {
        int i3;
        int i4;
        if (this.f860a.m1186g(i2, i) < 0) {
            i3 = i;
            i4 = i2;
        } else {
            i3 = i2;
            i4 = i;
        }
        int d = m1144d(i4, i3, i4);
        m1140a(d, i4, i3, -1, -1);
        return m1146e(d + -1, d) || m1146e(d, d + 1);
    }

    public final boolean m1159b(int i, int i2) {
        int g;
        if (this.f860a.m1186g(i, i2) < 0) {
            g = m1148g(i, i2);
        } else {
            g = m1148g(i2, i);
        }
        m1142c(g);
        return m1146e(g + -1, g) || m1146e(g, g + 1);
    }

    private boolean m1146e(int i, int i2) {
        if (i < 0 || i >= this.f860a.f866c || i2 < 0 || i2 >= this.f860a.f866c) {
            return false;
        }
        double g = this.f860a.m1185g(i);
        double h = this.f860a.m1187h(i);
        double g2 = this.f861b.m1185g(i);
        double h2 = this.f861b.m1187h(i);
        double g3 = this.f860a.m1185g(i2);
        double h3 = this.f860a.m1187h(i2);
        double g4 = this.f861b.m1185g(i2);
        double h4 = this.f861b.m1187h(i2);
        if ((g == g4 && h == h4) || (g3 == g2 && h3 == h2)) {
            return false;
        }
        if ((g != g3 || h != h3) && (g2 != g4 || h2 != h4)) {
            if (C1366l.m1284a(g, h, g2, h2, g4, h4) * C1366l.m1284a(g, h, g2, h2, g3, h3) > 0.0d) {
                return false;
            }
            if (C1366l.m1284a(g3, h3, g4, h4, g, h) * C1366l.m1284a(g3, h3, g4, h4, g2, h2) > 0.0d) {
                return false;
            }
            return true;
        } else if (g != g3 || h != h3 || g2 != g4 || h2 != h4) {
            return false;
        } else {
            return (this.f860a.m1178d(this.f860a.m1191j(i)) == this.f861b.m1191j(i) ? 1 : null) == (this.f860a.m1178d(this.f860a.m1191j(i2)) == this.f861b.m1191j(i2) ? 1 : null);
        }
    }

    public final int m1151a(int i) {
        return m1149h(m1143d(i), i);
    }

    public final int m1156b(int i) {
        int h;
        int d = m1143d(i);
        if (this.f863d.m1189i(d)) {
            h = m1149h(d, i);
        } else {
            h = this.f863d.m1191j(d);
        }
        this.f863d.m1184f(d, -1);
        return h;
    }

    public final boolean m1160c(int i, int i2) {
        int h = this.f861b.m1188h(i2, 0);
        while (h != -1 && !m1150i(h, i)) {
            h = this.f861b.m1188h(i2, h + 1);
        }
        if (h != -1) {
            return true;
        }
        return false;
    }

    public final C1346b m1153a(C1348j c1348j, int i, int i2) {
        C1347m c = c1348j.m1176c();
        C1347m c2 = c1348j.m1176c();
        C1347m c3 = c1348j.m1176c();
        C1347m c4 = c1348j.m1176c();
        int i3;
        int i4;
        int j;
        int j2;
        int j3;
        if (i > i2) {
            i3 = (i - i2) - 1;
            for (i4 = 0; i4 < this.f860a.f866c; i4++) {
                j = this.f860a.m1191j(i4);
                if (j <= i2 || j >= i) {
                    j2 = this.f861b.m1191j(i4);
                    if (j2 <= i2 || j2 >= i) {
                        j3 = this.f862c.m1191j(i4);
                        int j4 = this.f863d.m1191j(i4);
                        c.m1173b(C1346b.m1141c(j, i2, i3));
                        c2.m1173b(C1346b.m1141c(j2, i2, i3));
                        if (j3 <= i2 || j3 >= i) {
                            c3.m1173b(C1346b.m1141c(j3, i2, i3));
                        } else {
                            c3.m1173b(C1346b.m1141c(j, i2, i3));
                        }
                        if (j4 <= i2 || j4 >= i) {
                            c4.m1173b(C1346b.m1141c(j4, i2, i3));
                        } else {
                            throw new C1353a("When cutting edge list, we lost a merge vertex.");
                        }
                    }
                }
            }
        } else {
            for (i4 = 0; i4 < this.f860a.f866c; i4++) {
                i3 = this.f860a.m1191j(i4);
                if (i3 >= i && i3 <= i2) {
                    j = this.f861b.m1191j(i4);
                    if (j >= i && j <= i2) {
                        j2 = this.f862c.m1191j(i4);
                        j3 = this.f863d.m1191j(i4);
                        c.m1173b(i3 - i);
                        c2.m1173b(j - i);
                        if (j2 == -1) {
                            c3.m1173b(j2);
                        } else if (j2 < i || j2 > i2) {
                            c3.m1173b(i3 - i);
                        } else {
                            c3.m1173b(j2 - i);
                        }
                        if (j3 == -1) {
                            c4.m1173b(j3);
                        } else if (j3 < i || j3 > i2) {
                            throw new C1353a("When cutting edge list, we lost a merge vertex.");
                        } else {
                            c4.m1173b(j3 - i);
                        }
                    }
                }
            }
        }
        return new C1346b(c, c2, c3, c4);
    }

    private static int m1141c(int i, int i2, int i3) {
        return i <= i2 ? i : i - i3;
    }

    public final void m1161d(int i, int i2) {
        m1140a(m1144d(i, i2, i2), i, i2, i, -1);
    }

    private void m1140a(int i, int i2, int i3, int i4, int i5) {
        this.f860a.m1181e(i, i2);
        this.f861b.m1181e(i, i3);
        this.f862c.m1181e(i, i4);
        this.f863d.m1181e(i, -1);
    }

    private void m1142c(int i) {
        this.f860a.m1168a(i);
        this.f861b.m1168a(i);
        this.f862c.m1168a(i);
        this.f863d.m1168a(i);
    }

    private int m1147f(int i, int i2) {
        this.f862c.m1184f(i, i2);
        int j = this.f863d.m1191j(i);
        if (j != -1) {
            this.f863d.m1184f(i, -1);
        }
        return j;
    }

    private int m1148g(int i, int i2) {
        int h = this.f861b.m1188h(i2, 0);
        while (h != -1 && !m1150i(h, i)) {
            h = this.f861b.m1188h(i2, h + 1);
        }
        if (h != -1) {
            return h;
        }
        throw new NullPointerException("Could not find egde in EdgeList.");
    }

    private int m1143d(int i) {
        double b = this.f860a.m1170b(i);
        double c = this.f860a.m1174c(i);
        int i2 = 0;
        while (m1139a(i2, b) < c && i2 < this.f860a.f866c) {
            i2++;
        }
        if (i2 > 0) {
            return i2 - 1;
        }
        return 0;
    }

    private int m1144d(int i, int i2, int i3) {
        double b = this.f860a.m1170b(i3);
        double c = this.f860a.m1174c(i3);
        int i4 = 0;
        while (i4 < this.f860a.f866c) {
            double a = m1139a(i4, b);
            if (a > c) {
                return i4;
            }
            if (a == c) {
                double g = this.f861b.m1185g(i4);
                double h = this.f861b.m1187h(i4);
                a = this.f860a.m1170b(i);
                double c2 = this.f860a.m1174c(i);
                double b2 = this.f860a.m1170b(i2);
                double c3 = this.f860a.m1174c(i2);
                if (C1366l.m1284a(a, c2, b2, c3, g, h) > 0.0d) {
                    return i4;
                }
                if (C1366l.m1285a(g, h, b2, c3) == 0 && i4 % 2 == 0) {
                    return i4;
                }
            }
            i4++;
        }
        return this.f860a.f866c;
    }

    private int m1149h(int i, int i2) {
        int j = this.f862c.m1191j(i);
        double b = this.f860a.m1170b(j);
        double c = this.f860a.m1174c(j);
        double g = this.f860a.m1185g(i);
        double h = this.f860a.m1187h(i);
        if (C1366l.m1284a(g, h, this.f861b.m1185g(i), this.f861b.m1187h(i), b, c) <= 0.0d) {
            if (C1366l.m1284a(b, c, g, h, this.f860a.m1170b(i2), this.f860a.m1174c(i2)) <= 0.0d) {
                return this.f860a.m1191j(i);
            }
        }
        return j;
    }

    private int m1145e(int i, int i2, int i3) {
        return m1149h(m1148g(i, i2), i3);
    }

    private boolean m1150i(int i, int i2) {
        return this.f860a.m1190i(i2, i);
    }

    private double m1139a(int i, double d) {
        double g = this.f860a.m1185g(i);
        double h = this.f860a.m1187h(i);
        if (g == d) {
            return h;
        }
        double g2 = this.f861b.m1185g(i);
        double h2 = this.f861b.m1187h(i);
        if (g2 == d) {
            return h2;
        }
        g2 -= g;
        if (g2 != 0.0d) {
            return h + (((h2 - h) * (d - g)) / g2);
        }
        if (h <= h2) {
            return h2;
        }
        return h;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{start:  ");
        stringBuilder.append(this.f860a.m1194m(3));
        stringBuilder.append("\n end:    ");
        stringBuilder.append(this.f861b.m1194m(3));
        stringBuilder.append("\n helper: ");
        stringBuilder.append(this.f862c.m1194m(3));
        stringBuilder.append("\n merge:  ");
        stringBuilder.append(this.f863d.m1194m(3));
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
