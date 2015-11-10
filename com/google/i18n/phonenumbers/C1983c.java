package com.google.i18n.phonenumbers;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.stetho.BuildConfig;
import com.google.i18n.phonenumbers.Phonemetadata.PhoneMetadata;
import com.google.i18n.phonenumbers.Phonemetadata.PhoneMetadataCollection;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/* renamed from: com.google.i18n.phonenumbers.c */
public class C1983c {
    private static C1983c f2688A;
    static final Pattern f2689a;
    static final Pattern f2690b;
    static final Pattern f2691c;
    static final String f2692d;
    static final Pattern f2693e;
    private static final Logger f2694f;
    private static final Map<Integer, String> f2695g;
    private static final Map<Character, Character> f2696h;
    private static final Map<Character, Character> f2697i;
    private static final Map<Character, Character> f2698j;
    private static final Map<Character, Character> f2699k;
    private static final Pattern f2700l;
    private static final String f2701m;
    private static final Pattern f2702n;
    private static final Pattern f2703o;
    private static final Pattern f2704p;
    private static final Pattern f2705q;
    private static final String f2706r;
    private static final String f2707s;
    private static final Pattern f2708t;
    private static final Pattern f2709u;
    private static final Pattern f2710v;
    private static final Pattern f2711w;
    private static final Pattern f2712x;
    private static final Pattern f2713y;
    private static final Pattern f2714z;
    private final Map<Integer, List<String>> f2715B;
    private final Set<String> f2716C;
    private final Map<String, PhoneMetadata> f2717D;
    private final Map<Integer, PhoneMetadata> f2718E;
    private final C1985d f2719F;
    private final Set<String> f2720G;
    private final Set<Integer> f2721H;
    private final String f2722I;

    static {
        f2694f = Logger.getLogger(C1983c.class.getName());
        Map hashMap = new HashMap();
        hashMap.put(Integer.valueOf(52), AppEventsConstants.EVENT_PARAM_VALUE_YES);
        hashMap.put(Integer.valueOf(54), "9");
        f2695g = Collections.unmodifiableMap(hashMap);
        Map hashMap2 = new HashMap();
        hashMap2.put(Character.valueOf('0'), Character.valueOf('0'));
        hashMap2.put(Character.valueOf('1'), Character.valueOf('1'));
        hashMap2.put(Character.valueOf('2'), Character.valueOf('2'));
        hashMap2.put(Character.valueOf('3'), Character.valueOf('3'));
        hashMap2.put(Character.valueOf('4'), Character.valueOf('4'));
        hashMap2.put(Character.valueOf('5'), Character.valueOf('5'));
        hashMap2.put(Character.valueOf('6'), Character.valueOf('6'));
        hashMap2.put(Character.valueOf('7'), Character.valueOf('7'));
        hashMap2.put(Character.valueOf('8'), Character.valueOf('8'));
        hashMap2.put(Character.valueOf('9'), Character.valueOf('9'));
        hashMap = new HashMap(40);
        hashMap.put(Character.valueOf('A'), Character.valueOf('2'));
        hashMap.put(Character.valueOf('B'), Character.valueOf('2'));
        hashMap.put(Character.valueOf('C'), Character.valueOf('2'));
        hashMap.put(Character.valueOf('D'), Character.valueOf('3'));
        hashMap.put(Character.valueOf('E'), Character.valueOf('3'));
        hashMap.put(Character.valueOf('F'), Character.valueOf('3'));
        hashMap.put(Character.valueOf('G'), Character.valueOf('4'));
        hashMap.put(Character.valueOf('H'), Character.valueOf('4'));
        hashMap.put(Character.valueOf('I'), Character.valueOf('4'));
        hashMap.put(Character.valueOf('J'), Character.valueOf('5'));
        hashMap.put(Character.valueOf('K'), Character.valueOf('5'));
        hashMap.put(Character.valueOf('L'), Character.valueOf('5'));
        hashMap.put(Character.valueOf('M'), Character.valueOf('6'));
        hashMap.put(Character.valueOf('N'), Character.valueOf('6'));
        hashMap.put(Character.valueOf('O'), Character.valueOf('6'));
        hashMap.put(Character.valueOf('P'), Character.valueOf('7'));
        hashMap.put(Character.valueOf('Q'), Character.valueOf('7'));
        hashMap.put(Character.valueOf('R'), Character.valueOf('7'));
        hashMap.put(Character.valueOf('S'), Character.valueOf('7'));
        hashMap.put(Character.valueOf('T'), Character.valueOf('8'));
        hashMap.put(Character.valueOf('U'), Character.valueOf('8'));
        hashMap.put(Character.valueOf('V'), Character.valueOf('8'));
        hashMap.put(Character.valueOf('W'), Character.valueOf('9'));
        hashMap.put(Character.valueOf('X'), Character.valueOf('9'));
        hashMap.put(Character.valueOf('Y'), Character.valueOf('9'));
        hashMap.put(Character.valueOf('Z'), Character.valueOf('9'));
        f2697i = Collections.unmodifiableMap(hashMap);
        hashMap = new HashMap(100);
        hashMap.putAll(f2697i);
        hashMap.putAll(hashMap2);
        f2698j = Collections.unmodifiableMap(hashMap);
        hashMap = new HashMap();
        hashMap.putAll(hashMap2);
        hashMap.put(Character.valueOf('+'), Character.valueOf('+'));
        hashMap.put(Character.valueOf('*'), Character.valueOf('*'));
        f2696h = Collections.unmodifiableMap(hashMap);
        Map hashMap3 = new HashMap();
        for (Character charValue : f2697i.keySet()) {
            char charValue2 = charValue.charValue();
            hashMap3.put(Character.valueOf(Character.toLowerCase(charValue2)), Character.valueOf(charValue2));
            hashMap3.put(Character.valueOf(charValue2), Character.valueOf(charValue2));
        }
        hashMap3.putAll(hashMap2);
        hashMap3.put(Character.valueOf('-'), Character.valueOf('-'));
        hashMap3.put(Character.valueOf('\uff0d'), Character.valueOf('-'));
        hashMap3.put(Character.valueOf('\u2010'), Character.valueOf('-'));
        hashMap3.put(Character.valueOf('\u2011'), Character.valueOf('-'));
        hashMap3.put(Character.valueOf('\u2012'), Character.valueOf('-'));
        hashMap3.put(Character.valueOf('\u2013'), Character.valueOf('-'));
        hashMap3.put(Character.valueOf('\u2014'), Character.valueOf('-'));
        hashMap3.put(Character.valueOf('\u2015'), Character.valueOf('-'));
        hashMap3.put(Character.valueOf('\u2212'), Character.valueOf('-'));
        hashMap3.put(Character.valueOf('/'), Character.valueOf('/'));
        hashMap3.put(Character.valueOf('\uff0f'), Character.valueOf('/'));
        hashMap3.put(Character.valueOf(' '), Character.valueOf(' '));
        hashMap3.put(Character.valueOf('\u3000'), Character.valueOf(' '));
        hashMap3.put(Character.valueOf('\u2060'), Character.valueOf(' '));
        hashMap3.put(Character.valueOf('.'), Character.valueOf('.'));
        hashMap3.put(Character.valueOf('\uff0e'), Character.valueOf('.'));
        f2699k = Collections.unmodifiableMap(hashMap3);
        f2700l = Pattern.compile("[\\d]+(?:[~\u2053\u223c\uff5e][\\d]+)?");
        f2701m = Arrays.toString(f2697i.keySet().toArray()).replaceAll("[, \\[\\]]", BuildConfig.FLAVOR) + Arrays.toString(f2697i.keySet().toArray()).toLowerCase().replaceAll("[, \\[\\]]", BuildConfig.FLAVOR);
        f2689a = Pattern.compile("[+\uff0b]+");
        f2702n = Pattern.compile("[-x\u2010-\u2015\u2212\u30fc\uff0d-\uff0f \u00a0\u00ad\u200b\u2060\u3000()\uff08\uff09\uff3b\uff3d.\\[\\]/~\u2053\u223c\uff5e]+");
        f2703o = Pattern.compile("(\\p{Nd})");
        f2704p = Pattern.compile("[+\uff0b\\p{Nd}]");
        f2690b = Pattern.compile("[\\\\/] *x");
        f2691c = Pattern.compile("[[\\P{N}&&\\P{L}]&&[^#]]+$");
        f2705q = Pattern.compile("(?:.*?[A-Za-z]){3}.*");
        f2706r = "\\p{Nd}{2}|[+\uff0b]*+(?:[-x\u2010-\u2015\u2212\u30fc\uff0d-\uff0f \u00a0\u00ad\u200b\u2060\u3000()\uff08\uff09\uff3b\uff3d.\\[\\]/~\u2053\u223c\uff5e*]*\\p{Nd}){3,}[-x\u2010-\u2015\u2212\u30fc\uff0d-\uff0f \u00a0\u00ad\u200b\u2060\u3000()\uff08\uff09\uff3b\uff3d.\\[\\]/~\u2053\u223c\uff5e*" + f2701m + "\\p{Nd}" + "]*";
        String str = "x\uff58#\uff03~\uff5e";
        f2707s = C1983c.m4568e("," + str);
        f2692d = C1983c.m4568e(str);
        f2708t = Pattern.compile("(?:" + f2707s + ")$", 66);
        f2709u = Pattern.compile(f2706r + "(?:" + f2707s + ")?", 66);
        f2693e = Pattern.compile("(\\D+)");
        f2710v = Pattern.compile("(\\$\\d)");
        f2711w = Pattern.compile("\\$NP");
        f2712x = Pattern.compile("\\$FG");
        f2713y = Pattern.compile("\\$CC");
        f2714z = Pattern.compile("\\(?\\$1\\)?");
        f2688A = null;
    }

    private static String m4568e(String str) {
        return ";ext=(\\p{Nd}{1,7})|[ \u00a0\\t,]*(?:e?xt(?:ensi(?:o\u0301?|\u00f3))?n?|\uff45?\uff58\uff54\uff4e?|[" + str + "]|int|anexo|\uff49\uff4e\uff54)" + "[:\\.\uff0e]?[ \u00a0\\t,-]*" + "(\\p{Nd}{1,7})" + "#?|" + "[- ]+(" + "\\p{Nd}" + "{1,5})#";
    }

    private C1983c(String str, Map<Integer, List<String>> map) {
        this.f2716C = new HashSet(35);
        this.f2717D = Collections.synchronizedMap(new HashMap());
        this.f2718E = Collections.synchronizedMap(new HashMap());
        this.f2719F = new C1985d(100);
        this.f2720G = new HashSet(320);
        this.f2721H = new HashSet();
        this.f2722I = str;
        this.f2715B = map;
        for (Entry entry : map.entrySet()) {
            List list = (List) entry.getValue();
            if (list.size() == 1 && "001".equals(list.get(0))) {
                this.f2721H.add(entry.getKey());
            } else {
                this.f2720G.addAll(list);
            }
        }
        if (this.f2720G.remove("001")) {
            f2694f.log(Level.WARNING, "invalid metadata (country calling code was mapped to the non-geo entity as well as specific region(s))");
        }
        this.f2716C.addAll((Collection) map.get(Integer.valueOf(1)));
    }

    void m4573a(String str, String str2, int i) {
        boolean equals = "001".equals(str2);
        String str3 = str + "_" + (equals ? String.valueOf(i) : str2);
        InputStream resourceAsStream = C1983c.class.getResourceAsStream(str3);
        if (resourceAsStream == null) {
            f2694f.log(Level.SEVERE, "missing metadata: " + str3);
            throw new IllegalStateException("missing metadata: " + str3);
        }
        try {
            List a = C1983c.m4564a(new ObjectInputStream(resourceAsStream)).m4535a();
            if (a.isEmpty()) {
                f2694f.log(Level.SEVERE, "empty metadata: " + str3);
                throw new IllegalStateException("empty metadata: " + str3);
            }
            if (a.size() > 1) {
                f2694f.log(Level.WARNING, "invalid metadata (too many entries): " + str3);
            }
            PhoneMetadata phoneMetadata = (PhoneMetadata) a.get(0);
            if (equals) {
                this.f2718E.put(Integer.valueOf(i), phoneMetadata);
            } else {
                this.f2717D.put(str2, phoneMetadata);
            }
        } catch (Throwable e) {
            f2694f.log(Level.SEVERE, "cannot load/parse metadata: " + str3, e);
            throw new RuntimeException("cannot load/parse metadata: " + str3, e);
        }
    }

    private static PhoneMetadataCollection m4564a(ObjectInput objectInput) {
        PhoneMetadataCollection phoneMetadataCollection = new PhoneMetadataCollection();
        try {
            phoneMetadataCollection.readExternal(objectInput);
            try {
                objectInput.close();
            } catch (Throwable e) {
                f2694f.log(Level.WARNING, "error closing input stream (ignored)", e);
            } catch (Throwable th) {
            }
        } catch (Throwable e2) {
            f2694f.log(Level.WARNING, "error reading input (ignored)", e2);
            try {
                objectInput.close();
            } catch (Throwable e22) {
                f2694f.log(Level.WARNING, "error closing input stream (ignored)", e22);
            } catch (Throwable th2) {
            }
        } catch (Throwable th3) {
            try {
                objectInput.close();
            } catch (Throwable e222) {
                f2694f.log(Level.WARNING, "error closing input stream (ignored)", e222);
            } catch (Throwable th4) {
            }
        }
        return phoneMetadataCollection;
    }

    static synchronized C1983c m4566a(String str, Map<Integer, List<String>> map) {
        C1983c c1983c;
        synchronized (C1983c.class) {
            if (f2688A != null) {
                throw new IllegalStateException("PhoneNumberUtil instance is already set (you should call resetInstance() first)");
            }
            f2688A = new C1983c(str, map);
            c1983c = f2688A;
        }
        return c1983c;
    }

    public static synchronized C1983c m4565a() {
        C1983c a;
        synchronized (C1983c.class) {
            if (f2688A == null) {
                a = C1983c.m4566a("/com/google/i18n/phonenumbers/data/PhoneNumberMetadataProto", C1982b.m4563a());
            } else {
                a = f2688A;
            }
        }
        return a;
    }

    static boolean m4567a(String str) {
        return str.length() == 0 || f2714z.matcher(str).matches();
    }

    private boolean m4569f(String str) {
        return str != null && this.f2720G.contains(str);
    }

    PhoneMetadata m4574b(String str) {
        if (!m4569f(str)) {
            return null;
        }
        synchronized (this.f2717D) {
            if (!this.f2717D.containsKey(str)) {
                m4573a(this.f2722I, str, 0);
            }
        }
        return (PhoneMetadata) this.f2717D.get(str);
    }

    PhoneMetadata m4572a(int i) {
        synchronized (this.f2718E) {
            if (this.f2715B.containsKey(Integer.valueOf(i))) {
                if (!this.f2718E.containsKey(Integer.valueOf(i))) {
                    m4573a(this.f2722I, "001", i);
                }
                return (PhoneMetadata) this.f2718E.get(Integer.valueOf(i));
            }
            return null;
        }
    }

    public String m4575b(int i) {
        List list = (List) this.f2715B.get(Integer.valueOf(i));
        return list == null ? "ZZ" : (String) list.get(0);
    }

    public int m4576c(String str) {
        if (m4569f(str)) {
            return m4570g(str);
        }
        Logger logger = f2694f;
        Level level = Level.WARNING;
        StringBuilder append = new StringBuilder().append("Invalid or missing region code (");
        if (str == null) {
            str = "null";
        }
        logger.log(level, append.append(str).append(") provided.").toString());
        return 0;
    }

    private int m4570g(String str) {
        PhoneMetadata b = m4574b(str);
        if (b != null) {
            return b.m4497a();
        }
        throw new IllegalArgumentException("Invalid region code: " + str);
    }

    public C1981a m4577d(String str) {
        return new C1981a(str);
    }

    int m4571a(StringBuilder stringBuilder, StringBuilder stringBuilder2) {
        if (stringBuilder.length() == 0 || stringBuilder.charAt(0) == '0') {
            return 0;
        }
        int length = stringBuilder.length();
        int i = 1;
        while (i <= 3 && i <= length) {
            int parseInt = Integer.parseInt(stringBuilder.substring(0, i));
            if (this.f2715B.containsKey(Integer.valueOf(parseInt))) {
                stringBuilder2.append(stringBuilder.substring(i));
                return parseInt;
            }
            i++;
        }
        return 0;
    }
}
