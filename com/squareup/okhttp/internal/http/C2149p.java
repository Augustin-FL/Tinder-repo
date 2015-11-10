package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.C2079v;
import com.squareup.okhttp.C2210m;
import com.squareup.okhttp.C2210m.C2209a;
import com.squareup.okhttp.C2222s;
import com.squareup.okhttp.C2227u;
import com.squareup.okhttp.C2227u.C2226a;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.C2157k;
import com.squareup.okhttp.internal.spdy.C2162c;
import com.squareup.okhttp.internal.spdy.C2197m;
import com.squareup.okhttp.internal.spdy.C2204n;
import com.squareup.okhttp.internal.spdy.ErrorCode;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okio.ByteString;
import okio.C2071q;
import okio.C3342l;

/* renamed from: com.squareup.okhttp.internal.http.p */
public final class C2149p implements C2139r {
    private static final List<ByteString> f3327a;
    private static final List<ByteString> f3328b;
    private final C2137g f3329c;
    private final C2197m f3330d;
    private C2204n f3331e;

    static {
        f3327a = C2157k.m5349a(ByteString.m10145a("connection"), ByteString.m10145a("host"), ByteString.m10145a("keep-alive"), ByteString.m10145a("proxy-connection"), ByteString.m10145a("transfer-encoding"));
        f3328b = C2157k.m5349a(ByteString.m10145a("connection"), ByteString.m10145a("host"), ByteString.m10145a("keep-alive"), ByteString.m10145a("proxy-connection"), ByteString.m10145a("te"), ByteString.m10145a("transfer-encoding"), ByteString.m10145a("encoding"), ByteString.m10145a("upgrade"));
    }

    public C2149p(C2137g c2137g, C2197m c2197m) {
        this.f3329c = c2137g;
        this.f3330d = c2197m;
    }

    public C2071q m5310a(C2222s c2222s, long j) throws IOException {
        return this.f3331e.m5668g();
    }

    public void m5314a(C2222s c2222s) throws IOException {
        if (this.f3331e == null) {
            this.f3329c.m5223b();
            this.f3331e = this.f3330d.m5601a(C2149p.m5307a(c2222s, this.f3330d.m5599a(), C2144l.m5280a(this.f3329c.m5231i().m4975l())), this.f3329c.m5225c(), true);
            this.f3331e.m5666e().m5627a((long) this.f3329c.f3277a.m5764b(), TimeUnit.MILLISECONDS);
        }
    }

    public void m5313a(C2145m c2145m) throws IOException {
        c2145m.m5285a(this.f3331e.m5668g());
    }

    public void m5311a() throws IOException {
        this.f3331e.m5668g().close();
    }

    public C2226a m5315b() throws IOException {
        return C2149p.m5305a(this.f3331e.m5665d(), this.f3330d.m5599a());
    }

    public static List<C2162c> m5307a(C2222s c2222s, Protocol protocol, String str) {
        C2210m e = c2222s.m5815e();
        List<C2162c> arrayList = new ArrayList(e.m5687a() + 10);
        arrayList.add(new C2162c(C2162c.f3384b, c2222s.m5814d()));
        arrayList.add(new C2162c(C2162c.f3385c, C2144l.m5282a(c2222s.m5810a())));
        String a = C2137g.m5203a(c2222s.m5810a());
        if (Protocol.SPDY_3 == protocol) {
            arrayList.add(new C2162c(C2162c.f3389g, str));
            arrayList.add(new C2162c(C2162c.f3388f, a));
        } else if (Protocol.HTTP_2 == protocol) {
            arrayList.add(new C2162c(C2162c.f3387e, a));
        } else {
            throw new AssertionError();
        }
        arrayList.add(new C2162c(C2162c.f3386d, c2222s.m5810a().getProtocol()));
        Set linkedHashSet = new LinkedHashSet();
        int a2 = e.m5687a();
        for (int i = 0; i < a2; i++) {
            ByteString a3 = ByteString.m10145a(e.m5688a(i).toLowerCase(Locale.US));
            String b = e.m5691b(i);
            if (!(C2149p.m5308a(protocol, a3) || a3.equals(C2162c.f3384b) || a3.equals(C2162c.f3385c) || a3.equals(C2162c.f3386d) || a3.equals(C2162c.f3387e) || a3.equals(C2162c.f3388f) || a3.equals(C2162c.f3389g))) {
                if (linkedHashSet.add(a3)) {
                    arrayList.add(new C2162c(a3, b));
                } else {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        if (((C2162c) arrayList.get(i2)).f3390h.equals(a3)) {
                            arrayList.set(i2, new C2162c(a3, C2149p.m5306a(((C2162c) arrayList.get(i2)).f3391i.m10150a(), b)));
                            break;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private static String m5306a(String str, String str2) {
        return '\u0000' + str2;
    }

    public static C2226a m5305a(List<C2162c> list, Protocol protocol) throws IOException {
        String str = null;
        String str2 = "HTTP/1.1";
        C2209a c2209a = new C2209a();
        c2209a.m5684c(C2142j.f3302d, protocol.toString());
        int size = list.size();
        int i = 0;
        while (i < size) {
            ByteString byteString = ((C2162c) list.get(i)).f3390h;
            String a = ((C2162c) list.get(i)).f3391i.m10150a();
            String str3 = str2;
            int i2 = 0;
            while (i2 < a.length()) {
                int indexOf = a.indexOf(0, i2);
                if (indexOf == -1) {
                    indexOf = a.length();
                }
                str2 = a.substring(i2, indexOf);
                if (!byteString.equals(C2162c.f3383a)) {
                    if (byteString.equals(C2162c.f3389g)) {
                        str3 = str2;
                        str2 = str;
                    } else {
                        if (!C2149p.m5308a(protocol, byteString)) {
                            c2209a.m5680a(byteString.m10150a(), str2);
                        }
                        str2 = str;
                    }
                }
                str = str2;
                i2 = indexOf + 1;
            }
            i++;
            str2 = str3;
        }
        if (str == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        C2150q a2 = C2150q.m5319a(str2 + " " + str);
        return new C2226a().m5839a(protocol).m5838a(a2.f3333b).m5845a(a2.f3334c).m5841a(c2209a.m5681a());
    }

    public C2079v m5309a(C2227u c2227u) throws IOException {
        return new C2143k(c2227u.m5868f(), C3342l.m10280a(this.f3331e.m5667f()));
    }

    public void m5316c() {
    }

    public void m5312a(C2137g c2137g) throws IOException {
        if (this.f3331e != null) {
            this.f3331e.m5658a(ErrorCode.CANCEL);
        }
    }

    public boolean m5317d() {
        return true;
    }

    private static boolean m5308a(Protocol protocol, ByteString byteString) {
        if (protocol == Protocol.SPDY_3) {
            return f3327a.contains(byteString);
        }
        if (protocol == Protocol.HTTP_2) {
            return f3328b.contains(byteString);
        }
        throw new AssertionError(protocol);
    }
}
