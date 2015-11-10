package com.google.common.base;

import com.google.common.base.C1627b.C1628a;
import com.google.common.base.b.AnonymousClass10;
import java.util.Arrays;
import org.apache.http.protocol.HTTP;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.google.common.base.b */
public abstract class C1627b implements C1620h<Character> {
    public static final C1627b f1921a;
    public static final C1627b f1922b;
    public static final C1627b f1923c;
    public static final C1627b f1924d;
    public static final C1627b f1925e;
    public static final C1627b f1926f;
    public static final C1627b f1927g;
    public static final C1627b f1928h;
    public static final C1627b f1929i;
    public static final C1627b f1930j;
    public static final C1627b f1931k;
    public static final C1627b f1932l;
    public static final C1627b f1933m;
    public static final C1627b f1934o;
    private static final String f1935p;
    final String f1936n;

    /* renamed from: com.google.common.base.b.a */
    static abstract class C1628a extends C1627b {
        public /* bridge */ /* synthetic */ boolean m3018a(Object obj) {
            return super.m3016a((Character) obj);
        }

        C1628a(String str) {
            super(str);
        }
    }

    /* renamed from: com.google.common.base.b.10 */
    static class AnonymousClass10 extends C1628a {
        AnonymousClass10(String str) {
            super(str);
        }

        public boolean m3020a(char c) {
            return false;
        }

        public C1627b m3019a(C1627b c1627b) {
            return (C1627b) C1650g.m3080a((Object) c1627b);
        }
    }

    /* renamed from: com.google.common.base.b.1 */
    static class C16291 extends C1627b {
        C16291() {
        }

        public boolean m3021a(char c) {
            switch (c) {
                case C3374b.SmoothProgressBar_spb_reversed /*9*/:
                case C3374b.SmoothProgressBar_spb_mirror_mode /*10*/:
                case C3374b.SmoothProgressBar_spb_colors /*11*/:
                case C3374b.SmoothProgressBar_spb_progressiveStart_activated /*12*/:
                case C3374b.SmoothProgressBar_spb_background /*13*/:
                case HTTP.SP /*32*/:
                case '\u0085':
                case '\u1680':
                case '\u2028':
                case '\u2029':
                case '\u205f':
                case '\u3000':
                    return true;
                case '\u2007':
                    return false;
                default:
                    if (c < '\u2000' || c > '\u200a') {
                        return false;
                    }
                    return true;
            }
        }

        public String toString() {
            return "CharMatcher.BREAKING_WHITESPACE";
        }
    }

    /* renamed from: com.google.common.base.b.2 */
    static class C16302 extends C1628a {
        final /* synthetic */ char f1937p;
        final /* synthetic */ char f1938q;

        C16302(String str, char c, char c2) {
            this.f1937p = c;
            this.f1938q = c2;
            super(str);
        }

        public boolean m3023a(char c) {
            return this.f1937p <= c && c <= this.f1938q;
        }
    }

    /* renamed from: com.google.common.base.b.3 */
    static class C16313 extends C1628a {
        C16313(String str) {
            super(str);
        }

        public boolean m3024a(char c) {
            return "\u0001\u0000\u00a0\u0000\u0000\u0000\u0000\u0000\u0000\t\n\u000b\f\r\u0000\u0000\u2028\u2029\u0000\u0000\u0000\u0000\u0000\u202f\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000 \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u3000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0085\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u0000\u0000\u0000\u0000\u0000\u205f\u1680\u0000\u0000\u180e\u0000\u0000\u0000".charAt(c % 79) == c;
        }
    }

    /* renamed from: com.google.common.base.b.4 */
    static class C16324 extends C1627b {
        C16324(String str) {
            super(str);
        }

        public boolean m3025a(char c) {
            return Character.isDigit(c);
        }
    }

    /* renamed from: com.google.common.base.b.5 */
    static class C16335 extends C1627b {
        C16335(String str) {
            super(str);
        }

        public boolean m3027a(char c) {
            return Character.isLetter(c);
        }
    }

    /* renamed from: com.google.common.base.b.6 */
    static class C16346 extends C1627b {
        C16346(String str) {
            super(str);
        }

        public boolean m3029a(char c) {
            return Character.isLetterOrDigit(c);
        }
    }

    /* renamed from: com.google.common.base.b.7 */
    static class C16357 extends C1627b {
        C16357(String str) {
            super(str);
        }

        public boolean m3031a(char c) {
            return Character.isUpperCase(c);
        }
    }

    /* renamed from: com.google.common.base.b.8 */
    static class C16368 extends C1627b {
        C16368(String str) {
            super(str);
        }

        public boolean m3033a(char c) {
            return Character.isLowerCase(c);
        }
    }

    /* renamed from: com.google.common.base.b.9 */
    static class C16379 extends C1628a {
        C16379(String str) {
            super(str);
        }

        public boolean m3036a(char c) {
            return true;
        }

        public C1627b m3035a(C1627b c1627b) {
            C1650g.m3080a((Object) c1627b);
            return this;
        }
    }

    /* renamed from: com.google.common.base.b.b */
    private static class C1638b extends C1627b {
        final C1627b f1939p;
        final C1627b f1940q;

        C1638b(C1627b c1627b, C1627b c1627b2, String str) {
            super(str);
            this.f1939p = (C1627b) C1650g.m3080a((Object) c1627b);
            this.f1940q = (C1627b) C1650g.m3080a((Object) c1627b2);
        }

        C1638b(C1627b c1627b, C1627b c1627b2) {
            this(c1627b, c1627b2, "CharMatcher.or(" + c1627b + ", " + c1627b2 + ")");
        }

        public boolean m3038a(char c) {
            return this.f1939p.m3015a(c) || this.f1940q.m3015a(c);
        }

        C1627b m3037a(String str) {
            return new C1638b(this.f1939p, this.f1940q, str);
        }
    }

    /* renamed from: com.google.common.base.b.c */
    private static class C1639c extends C1627b {
        private final char[] f1941p;
        private final char[] f1942q;

        C1639c(String str, char[] cArr, char[] cArr2) {
            boolean z;
            super(str);
            this.f1941p = cArr;
            this.f1942q = cArr2;
            if (cArr.length == cArr2.length) {
                z = true;
            } else {
                z = false;
            }
            C1650g.m3085a(z);
            for (int i = 0; i < cArr.length; i++) {
                boolean z2;
                if (cArr[i] <= cArr2[i]) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                C1650g.m3085a(z2);
                if (i + 1 < cArr.length) {
                    if (cArr2[i] < cArr[i + 1]) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    C1650g.m3085a(z2);
                }
            }
        }

        public boolean m3040a(char c) {
            int binarySearch = Arrays.binarySearch(this.f1941p, c);
            if (binarySearch >= 0) {
                return true;
            }
            binarySearch = (binarySearch ^ -1) - 1;
            if (binarySearch < 0 || c > this.f1942q[binarySearch]) {
                return false;
            }
            return true;
        }
    }

    public abstract boolean m3015a(char c);

    static {
        f1921a = new C16291();
        f1922b = C1627b.m3011a('\u0000', '\u007f', "CharMatcher.ASCII");
        StringBuilder stringBuilder = new StringBuilder("0\u0660\u06f0\u07c0\u0966\u09e6\u0a66\u0ae6\u0b66\u0be6\u0c66\u0ce6\u0d66\u0e50\u0ed0\u0f20\u1040\u1090\u17e0\u1810\u1946\u19d0\u1b50\u1bb0\u1c40\u1c50\ua620\ua8d0\ua900\uaa50\uff10".length());
        for (int i = 0; i < "0\u0660\u06f0\u07c0\u0966\u09e6\u0a66\u0ae6\u0b66\u0be6\u0c66\u0ce6\u0d66\u0e50\u0ed0\u0f20\u1040\u1090\u17e0\u1810\u1946\u19d0\u1b50\u1bb0\u1c40\u1c50\ua620\ua8d0\ua900\uaa50\uff10".length(); i++) {
            stringBuilder.append((char) ("0\u0660\u06f0\u07c0\u0966\u09e6\u0a66\u0ae6\u0b66\u0be6\u0c66\u0ce6\u0d66\u0e50\u0ed0\u0f20\u1040\u1090\u17e0\u1810\u1946\u19d0\u1b50\u1bb0\u1c40\u1c50\ua620\ua8d0\ua900\uaa50\uff10".charAt(i) + 9));
        }
        f1935p = stringBuilder.toString();
        f1923c = new C1639c("CharMatcher.DIGIT", "0\u0660\u06f0\u07c0\u0966\u09e6\u0a66\u0ae6\u0b66\u0be6\u0c66\u0ce6\u0d66\u0e50\u0ed0\u0f20\u1040\u1090\u17e0\u1810\u1946\u19d0\u1b50\u1bb0\u1c40\u1c50\ua620\ua8d0\ua900\uaa50\uff10".toCharArray(), f1935p.toCharArray());
        f1924d = new C16324("CharMatcher.JAVA_DIGIT");
        f1925e = new C16335("CharMatcher.JAVA_LETTER");
        f1926f = new C16346("CharMatcher.JAVA_LETTER_OR_DIGIT");
        f1927g = new C16357("CharMatcher.JAVA_UPPER_CASE");
        f1928h = new C16368("CharMatcher.JAVA_LOWER_CASE");
        f1929i = C1627b.m3010a('\u0000', '\u001f').m3013a(C1627b.m3010a('\u007f', '\u009f')).m3014a("CharMatcher.JAVA_ISO_CONTROL");
        f1930j = new C1639c("CharMatcher.INVISIBLE", "\u0000\u007f\u00ad\u0600\u06dd\u070f\u1680\u180e\u2000\u2028\u205f\u206a\u3000\ud800\ufeff\ufff9\ufffa".toCharArray(), " \u00a0\u00ad\u0604\u06dd\u070f\u1680\u180e\u200f\u202f\u2064\u206f\u3000\uf8ff\ufeff\ufff9\ufffb".toCharArray());
        f1931k = new C1639c("CharMatcher.SINGLE_WIDTH", "\u0000\u05be\u05d0\u05f3\u0600\u0750\u0e00\u1e00\u2100\ufb50\ufe70\uff61".toCharArray(), "\u04f9\u05be\u05ea\u05f4\u06ff\u077f\u0e7f\u20af\u213a\ufdff\ufeff\uffdc".toCharArray());
        f1932l = new C16379("CharMatcher.ANY");
        f1933m = new AnonymousClass10("CharMatcher.NONE");
        f1934o = new C16313("CharMatcher.WHITESPACE");
    }

    private static String m3012b(char c) {
        String str = "0123456789ABCDEF";
        char[] cArr = new char[]{'\\', 'u', '\u0000', '\u0000', '\u0000', '\u0000'};
        for (int i = 0; i < 4; i++) {
            cArr[5 - i] = str.charAt(c & 15);
            c = (char) (c >> 4);
        }
        return String.copyValueOf(cArr);
    }

    public static C1627b m3010a(char c, char c2) {
        C1650g.m3085a(c2 >= c);
        return C1627b.m3011a(c, c2, "CharMatcher.inRange('" + C1627b.m3012b(c) + "', '" + C1627b.m3012b(c2) + "')");
    }

    static C1627b m3011a(char c, char c2, String str) {
        return new C16302(str, c, c2);
    }

    C1627b(String str) {
        this.f1936n = str;
    }

    protected C1627b() {
        this.f1936n = super.toString();
    }

    public C1627b m3013a(C1627b c1627b) {
        return new C1638b(this, (C1627b) C1650g.m3080a((Object) c1627b));
    }

    C1627b m3014a(String str) {
        throw new UnsupportedOperationException();
    }

    public boolean m3016a(Character ch) {
        return m3015a(ch.charValue());
    }

    public String toString() {
        return this.f1936n;
    }
}
