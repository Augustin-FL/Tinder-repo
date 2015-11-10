package com.google.android.m4b.maps.ay;

import android.support.v7.widget.RecyclerView.SmoothScroller.Action;
import com.google.android.m4b.maps.ay.C1453r.C1452a;
import com.google.android.m4b.maps.ay.aj.C1409a;
import com.google.android.m4b.maps.ay.at.C1417a;
import com.google.android.m4b.maps.ay.be.C1429a;
import com.google.android.m4b.maps.ch.a;
import com.google.android.m4b.maps.p009m.C1480a;
import com.google.android.m4b.maps.p009m.C1480a.C1483c;
import com.google.android.m4b.maps.p009m.C1486c;

public interface bd extends Comparable<bd> {

    /* renamed from: com.google.android.m4b.maps.ay.bd.a */
    public enum C1421a {
        SPOTLIGHT {
            public final bd m1764a(a aVar) {
                if (ah.m1497a(aVar.d(1)) == ah.f1050r && aVar.i(10)) {
                    return new C1452a().m2075a(aVar.g(10)).m2076a();
                }
                return null;
            }
        },
        SPOTLIGHT_DIFFTILE {
            public final bd m1766a(a aVar) {
                if (ah.m1497a(aVar.d(1)) == ah.f1054v && aVar.i(27)) {
                    return new C1451q(aVar.f(27));
                }
                return null;
            }

            public final ah m1765a() {
                return ah.f1054v;
            }
        },
        HIGHLIGHT {
            public final bd m1767a(a aVar) {
                if (ah.m1497a(aVar.d(1)) == ah.f1051s && aVar.i(9)) {
                    return new C1429a().m1772a(aVar.g(9)).m1773a();
                }
                return null;
            }
        },
        INDOOR {
            public final bd m1768a(a aVar) {
                if (ah.m1497a(aVar.d(1)) == ah.f1046n && aVar.i(6)) {
                    return bj.m1816a(new C1486c(C1483c.m2303b(aVar.g(6)), Action.UNDEFINED_DURATION));
                }
                return null;
            }
        },
        TRANSIT {
            public final bd m1769a(a aVar) {
                if (ah.m1497a(aVar.d(1)) != ah.f1045m) {
                    return null;
                }
                C1409a c1409a = new C1409a();
                if (aVar.i(9)) {
                    c1409a.m1558a(C1480a.m2294a(aVar.g(9)));
                }
                int j = aVar.j(12);
                for (int i = 0; i < j; i++) {
                    c1409a.m1557a(aVar.b(12, i));
                }
                bd a = c1409a.m1559a();
                return a.m1566a(ah.f1045m) ? a : null;
            }
        },
        MAPS_ENGINE {
            public final bd m1770a(a aVar) {
                ah a = ah.m1497a(aVar.d(1));
                if (a != ah.f1056x && a != ah.f1055w) {
                    return null;
                }
                br brVar = new br(aVar.f(29));
                if (brVar.m1877a(a)) {
                    return brVar;
                }
                return null;
            }
        },
        ALTERNATE_PAINTFE {
            public final bd m1771a(a aVar) {
                ah.m1497a(aVar.d(1));
                if (aVar.i(13)) {
                    return new C1417a().m1685a(aVar.g(13)).m1686a();
                }
                return null;
            }
        };

        public abstract bd m1763a(a aVar);

        public ah m1762a() {
            return null;
        }
    }

    C1421a m1560a();

    void m1561a(a aVar);

    boolean m1562a(ah ahVar);

    boolean m1563a(bd bdVar);
}
