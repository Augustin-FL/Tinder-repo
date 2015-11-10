package com.google.i18n.phonenumbers;

import com.facebook.stetho.BuildConfig;
import com.google.i18n.phonenumbers.Phonemetadata.NumberFormat;
import com.google.i18n.phonenumbers.Phonemetadata.PhoneMetadata;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.google.i18n.phonenumbers.a */
public class C1981a {
    private static final PhoneMetadata f2660l;
    private static final Pattern f2661o;
    private static final Pattern f2662p;
    private static final Pattern f2663q;
    private static final Pattern f2664r;
    private static final Pattern f2665s;
    private List<NumberFormat> f2666A;
    private C1985d f2667B;
    private String f2668a;
    private StringBuilder f2669b;
    private String f2670c;
    private StringBuilder f2671d;
    private StringBuilder f2672e;
    private boolean f2673f;
    private boolean f2674g;
    private boolean f2675h;
    private boolean f2676i;
    private final C1983c f2677j;
    private String f2678k;
    private PhoneMetadata f2679m;
    private PhoneMetadata f2680n;
    private int f2681t;
    private int f2682u;
    private int f2683v;
    private StringBuilder f2684w;
    private boolean f2685x;
    private String f2686y;
    private StringBuilder f2687z;

    static {
        f2660l = new PhoneMetadata().m4503b("NA");
        f2661o = Pattern.compile("\\[([^\\[\\]])*\\]");
        f2662p = Pattern.compile("\\d(?=[^,}][^,}])");
        f2663q = Pattern.compile("[-x\u2010-\u2015\u2212\u30fc\uff0d-\uff0f \u00a0\u00ad\u200b\u2060\u3000()\uff08\uff09\uff3b\uff3d.\\[\\]/~\u2053\u223c\uff5e]*(\\$\\d[-x\u2010-\u2015\u2212\u30fc\uff0d-\uff0f \u00a0\u00ad\u200b\u2060\u3000()\uff08\uff09\uff3b\uff3d.\\[\\]/~\u2053\u223c\uff5e]*)+");
        f2664r = Pattern.compile("[- ]");
        f2665s = Pattern.compile("\u2008");
    }

    C1981a(String str) {
        this.f2668a = BuildConfig.FLAVOR;
        this.f2669b = new StringBuilder();
        this.f2670c = BuildConfig.FLAVOR;
        this.f2671d = new StringBuilder();
        this.f2672e = new StringBuilder();
        this.f2673f = true;
        this.f2674g = false;
        this.f2675h = false;
        this.f2676i = false;
        this.f2677j = C1983c.m4565a();
        this.f2681t = 0;
        this.f2682u = 0;
        this.f2683v = 0;
        this.f2684w = new StringBuilder();
        this.f2685x = false;
        this.f2686y = BuildConfig.FLAVOR;
        this.f2687z = new StringBuilder();
        this.f2666A = new ArrayList();
        this.f2667B = new C1985d(64);
        this.f2678k = str;
        this.f2680n = m4540a(this.f2678k);
        this.f2679m = this.f2680n;
    }

    private PhoneMetadata m4540a(String str) {
        PhoneMetadata b = this.f2677j.m4574b(this.f2677j.m4575b(this.f2677j.m4576c(str)));
        return b != null ? b : f2660l;
    }

    private boolean m4548c() {
        Iterator it = this.f2666A.iterator();
        while (it.hasNext()) {
            NumberFormat numberFormat = (NumberFormat) it.next();
            String a = numberFormat.m4488a();
            if (this.f2670c.equals(a)) {
                return false;
            }
            if (m4543a(numberFormat)) {
                this.f2670c = a;
                this.f2685x = f2664r.matcher(numberFormat.m4495d()).find();
                this.f2681t = 0;
                return true;
            }
            it.remove();
        }
        this.f2673f = false;
        return false;
    }

    private void m4545b(String str) {
        List f;
        if (!this.f2675h || this.f2680n.m4526i() <= 0) {
            f = this.f2680n.m4519f();
        } else {
            f = this.f2680n.m4525h();
        }
        boolean c = this.f2680n.m4509c();
        for (NumberFormat numberFormat : r0) {
            if (!(!c || this.f2675h || numberFormat.m4496e())) {
                C1983c c1983c = this.f2677j;
                if (!C1983c.m4567a(numberFormat.m4495d())) {
                }
            }
            if (m4549c(numberFormat.m4491b())) {
                this.f2666A.add(numberFormat);
            }
        }
        m4551d(str);
    }

    private boolean m4549c(String str) {
        return f2663q.matcher(str).matches();
    }

    private void m4551d(String str) {
        int length = str.length() - 3;
        Iterator it = this.f2666A.iterator();
        while (it.hasNext()) {
            NumberFormat numberFormat = (NumberFormat) it.next();
            if (numberFormat.m4492c() > length && !this.f2667B.m4581a(numberFormat.m4489a(length)).matcher(str).lookingAt()) {
                it.remove();
            }
        }
    }

    private boolean m4543a(NumberFormat numberFormat) {
        CharSequence a = numberFormat.m4488a();
        if (a.indexOf(124) != -1) {
            return false;
        }
        String replaceAll = f2662p.matcher(f2661o.matcher(a).replaceAll("\\\\d")).replaceAll("\\\\d");
        this.f2669b.setLength(0);
        replaceAll = m4542a(replaceAll, numberFormat.m4491b());
        if (replaceAll.length() <= 0) {
            return false;
        }
        this.f2669b.append(replaceAll);
        return true;
    }

    private String m4542a(String str, String str2) {
        Matcher matcher = this.f2667B.m4581a(str).matcher("999999999999999");
        matcher.find();
        String group = matcher.group();
        if (group.length() < this.f2687z.length()) {
            return BuildConfig.FLAVOR;
        }
        return group.replaceAll(str, str2).replaceAll("9", "\u2008");
    }

    public void m4561a() {
        this.f2668a = BuildConfig.FLAVOR;
        this.f2671d.setLength(0);
        this.f2672e.setLength(0);
        this.f2669b.setLength(0);
        this.f2681t = 0;
        this.f2670c = BuildConfig.FLAVOR;
        this.f2684w.setLength(0);
        this.f2686y = BuildConfig.FLAVOR;
        this.f2687z.setLength(0);
        this.f2673f = true;
        this.f2674g = false;
        this.f2683v = 0;
        this.f2682u = 0;
        this.f2675h = false;
        this.f2676i = false;
        this.f2666A.clear();
        this.f2685x = false;
        if (!this.f2680n.equals(this.f2679m)) {
            this.f2680n = m4540a(this.f2678k);
        }
    }

    public String m4560a(char c) {
        this.f2668a = m4541a(c, false);
        return this.f2668a;
    }

    private String m4541a(char c, boolean z) {
        this.f2671d.append(c);
        if (z) {
            this.f2682u = this.f2671d.length();
        }
        if (m4546b(c)) {
            c = m4544b(c, z);
        } else {
            this.f2673f = false;
            this.f2674g = true;
        }
        if (this.f2673f) {
            switch (this.f2672e.length()) {
                case C3374b.SmoothProgressBar_spbStyle /*0*/:
                case C3374b.SmoothProgressBar_spb_color /*1*/:
                case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                    return this.f2671d.toString();
                case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                    if (m4558j()) {
                        this.f2676i = true;
                        break;
                    }
                    this.f2686y = m4557i();
                    return m4554f();
            }
            if (this.f2676i) {
                if (m4559k()) {
                    this.f2676i = false;
                }
                return this.f2684w + this.f2687z.toString();
            } else if (this.f2666A.size() <= 0) {
                return m4554f();
            } else {
                String c2 = m4547c(c);
                String b = m4562b();
                if (b.length() > 0) {
                    return b;
                }
                m4551d(this.f2687z.toString());
                if (m4548c()) {
                    return m4555g();
                }
                return this.f2673f ? m4552e(c2) : this.f2671d.toString();
            }
        } else if (this.f2674g) {
            return this.f2671d.toString();
        } else {
            if (m4558j()) {
                if (m4559k()) {
                    return m4550d();
                }
            } else if (m4553e()) {
                this.f2684w.append(' ');
                return m4550d();
            }
            return this.f2671d.toString();
        }
    }

    private String m4550d() {
        this.f2673f = true;
        this.f2676i = false;
        this.f2666A.clear();
        return m4554f();
    }

    private boolean m4553e() {
        if (this.f2686y.length() > 0) {
            this.f2687z.insert(0, this.f2686y);
            this.f2684w.setLength(this.f2684w.lastIndexOf(this.f2686y));
        }
        if (this.f2686y.equals(m4557i())) {
            return false;
        }
        return true;
    }

    private boolean m4546b(char c) {
        if (Character.isDigit(c)) {
            return true;
        }
        return this.f2671d.length() == 1 && C1983c.f2689a.matcher(Character.toString(c)).matches();
    }

    String m4562b() {
        for (NumberFormat numberFormat : this.f2666A) {
            Matcher matcher = this.f2667B.m4581a(numberFormat.m4488a()).matcher(this.f2687z);
            if (matcher.matches()) {
                this.f2685x = f2664r.matcher(numberFormat.m4495d()).find();
                return m4552e(matcher.replaceAll(numberFormat.m4491b()));
            }
        }
        return BuildConfig.FLAVOR;
    }

    private String m4552e(String str) {
        int length = this.f2684w.length();
        if (!this.f2685x || length <= 0 || this.f2684w.charAt(length - 1) == ' ') {
            return this.f2684w + str;
        }
        return new String(this.f2684w) + ' ' + str;
    }

    private String m4554f() {
        if (this.f2687z.length() < 3) {
            return m4552e(this.f2687z.toString());
        }
        m4545b(this.f2687z.substring(0, 3));
        String b = m4562b();
        if (b.length() > 0) {
            return b;
        }
        return m4548c() ? m4555g() : this.f2671d.toString();
    }

    private String m4555g() {
        int length = this.f2687z.length();
        if (length <= 0) {
            return this.f2684w.toString();
        }
        String str = BuildConfig.FLAVOR;
        for (int i = 0; i < length; i++) {
            str = m4547c(this.f2687z.charAt(i));
        }
        return this.f2673f ? m4552e(str) : this.f2671d.toString();
    }

    private boolean m4556h() {
        return this.f2680n.m4497a() == 1 && this.f2687z.charAt(0) == '1' && this.f2687z.charAt(1) != '0' && this.f2687z.charAt(1) != '1';
    }

    private String m4557i() {
        int i = 1;
        if (m4556h()) {
            this.f2684w.append('1').append(' ');
            this.f2675h = true;
        } else {
            if (this.f2680n.m4513d()) {
                Matcher matcher = this.f2667B.m4581a(this.f2680n.m4516e()).matcher(this.f2687z);
                if (matcher.lookingAt() && matcher.end() > 0) {
                    this.f2675h = true;
                    i = matcher.end();
                    this.f2684w.append(this.f2687z.substring(0, i));
                }
            }
            i = 0;
        }
        String substring = this.f2687z.substring(0, i);
        this.f2687z.delete(0, i);
        return substring;
    }

    private boolean m4558j() {
        Matcher matcher = this.f2667B.m4581a("\\+|" + this.f2680n.m4505b()).matcher(this.f2672e);
        if (!matcher.lookingAt()) {
            return false;
        }
        this.f2675h = true;
        int end = matcher.end();
        this.f2687z.setLength(0);
        this.f2687z.append(this.f2672e.substring(end));
        this.f2684w.setLength(0);
        this.f2684w.append(this.f2672e.substring(0, end));
        if (this.f2672e.charAt(0) == '+') {
            return true;
        }
        this.f2684w.append(' ');
        return true;
    }

    private boolean m4559k() {
        if (this.f2687z.length() == 0) {
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int a = this.f2677j.m4571a(this.f2687z, stringBuilder);
        if (a == 0) {
            return false;
        }
        this.f2687z.setLength(0);
        this.f2687z.append(stringBuilder);
        String b = this.f2677j.m4575b(a);
        if ("001".equals(b)) {
            this.f2680n = this.f2677j.m4572a(a);
        } else if (!b.equals(this.f2678k)) {
            this.f2680n = m4540a(b);
        }
        this.f2684w.append(Integer.toString(a)).append(' ');
        return true;
    }

    private char m4544b(char c, boolean z) {
        if (c == '+') {
            this.f2672e.append(c);
        } else {
            c = Character.forDigit(Character.digit(c, 10), 10);
            this.f2672e.append(c);
            this.f2687z.append(c);
        }
        if (z) {
            this.f2683v = this.f2672e.length();
        }
        return c;
    }

    private String m4547c(char c) {
        Matcher matcher = f2665s.matcher(this.f2669b);
        if (matcher.find(this.f2681t)) {
            String replaceFirst = matcher.replaceFirst(Character.toString(c));
            this.f2669b.replace(0, replaceFirst.length(), replaceFirst);
            this.f2681t = matcher.start();
            return this.f2669b.substring(0, this.f2681t + 1);
        }
        if (this.f2666A.size() == 1) {
            this.f2673f = false;
        }
        this.f2670c = BuildConfig.FLAVOR;
        return this.f2671d.toString();
    }
}
