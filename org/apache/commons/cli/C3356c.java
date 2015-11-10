package org.apache.commons.cli;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* renamed from: org.apache.commons.cli.c */
public class C3356c {
    public int f7345a;
    public int f7346b;
    public int f7347c;
    public String f7348d;
    public String f7349e;
    public String f7350f;
    public String f7351g;
    public String f7352h;
    protected Comparator f7353i;

    /* renamed from: org.apache.commons.cli.c.1 */
    static class C33541 {
    }

    /* renamed from: org.apache.commons.cli.c.a */
    private static class C3355a implements Comparator {
        private C3355a() {
        }

        C3355a(C33541 c33541) {
            this();
        }

        public int compare(Object obj, Object obj2) {
            return ((Option) obj).m10353a().compareToIgnoreCase(((Option) obj2).m10353a());
        }
    }

    public C3356c() {
        this.f7345a = 74;
        this.f7346b = 1;
        this.f7347c = 3;
        this.f7348d = "usage: ";
        this.f7349e = System.getProperty("line.separator");
        this.f7350f = "-";
        this.f7351g = "--";
        this.f7352h = "arg";
        this.f7353i = new C3355a(null);
    }

    public int m10391a() {
        return this.f7345a;
    }

    public int m10398b() {
        return this.f7346b;
    }

    public int m10399c() {
        return this.f7347c;
    }

    public Comparator m10400d() {
        return this.f7353i;
    }

    public void m10397a(PrintWriter printWriter, int i, Options options, int i2, int i3) {
        StringBuffer stringBuffer = new StringBuffer();
        m10396a(stringBuffer, i, options, i2, i3);
        printWriter.println(stringBuffer.toString());
    }

    protected StringBuffer m10396a(StringBuffer stringBuffer, int i, Options options, int i2, int i3) {
        String a = m10393a(i2);
        String a2 = m10393a(i3);
        List arrayList = new ArrayList();
        List<Option> a3 = options.m10373a();
        Collections.sort(a3, m10400d());
        int i4 = 0;
        for (Option option : a3) {
            Option option2;
            int length;
            StringBuffer stringBuffer2 = new StringBuffer(8);
            if (option2.m10355b() == null) {
                stringBuffer2.append(a).append(new StringBuffer().append("   ").append(this.f7351g).toString()).append(option2.m10356c());
            } else {
                stringBuffer2.append(a).append(this.f7350f).append(option2.m10355b());
                if (option2.m10358e()) {
                    stringBuffer2.append(',').append(this.f7351g).append(option2.m10356c());
                }
            }
            if (option2.m10359f()) {
                if (option2.m10363j()) {
                    stringBuffer2.append(" <").append(option2.m10362i()).append(">");
                } else {
                    stringBuffer2.append(' ');
                }
            }
            arrayList.add(stringBuffer2);
            if (stringBuffer2.length() > i4) {
                length = stringBuffer2.length();
            } else {
                length = i4;
            }
            i4 = length;
        }
        Iterator it = a3.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            option2 = (Option) it.next();
            int i6 = i5 + 1;
            stringBuffer2 = new StringBuffer(arrayList.get(i5).toString());
            if (stringBuffer2.length() < i4) {
                stringBuffer2.append(m10393a(i4 - stringBuffer2.length()));
            }
            stringBuffer2.append(a2);
            i5 = i4 + i3;
            if (option2.m10360g() != null) {
                stringBuffer2.append(option2.m10360g());
            }
            m10395a(stringBuffer, i, i5, stringBuffer2.toString());
            if (it.hasNext()) {
                stringBuffer.append(this.f7349e);
            }
            i5 = i6;
        }
        return stringBuffer;
    }

    protected StringBuffer m10395a(StringBuffer stringBuffer, int i, int i2, String str) {
        int a = m10392a(str, i, 0);
        if (a == -1) {
            stringBuffer.append(m10394a(str));
        } else {
            stringBuffer.append(m10394a(str.substring(0, a))).append(this.f7349e);
            if (i2 >= i) {
                i2 = 1;
            }
            String a2 = m10393a(i2);
            while (true) {
                str = new StringBuffer().append(a2).append(str.substring(a).trim()).toString();
                a = m10392a(str, i, 0);
                if (a == -1) {
                    break;
                }
                if (str.length() > i && a == i2 - 1) {
                    a = i;
                }
                stringBuffer.append(m10394a(str.substring(0, a))).append(this.f7349e);
            }
            stringBuffer.append(str);
        }
        return stringBuffer;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected int m10392a(java.lang.String r7, int r8, int r9) {
        /*
        r6 = this;
        r5 = 32;
        r4 = 13;
        r3 = 10;
        r1 = -1;
        r0 = r7.indexOf(r3, r9);
        if (r0 == r1) goto L_0x000f;
    L_0x000d:
        if (r0 <= r8) goto L_0x0019;
    L_0x000f:
        r0 = 9;
        r0 = r7.indexOf(r0, r9);
        if (r0 == r1) goto L_0x001c;
    L_0x0017:
        if (r0 > r8) goto L_0x001c;
    L_0x0019:
        r1 = r0 + 1;
    L_0x001b:
        return r1;
    L_0x001c:
        r0 = r9 + r8;
        r2 = r7.length();
        if (r0 >= r2) goto L_0x001b;
    L_0x0024:
        r0 = r9 + r8;
    L_0x0026:
        if (r0 < r9) goto L_0x0035;
    L_0x0028:
        r2 = r7.charAt(r0);
        if (r2 == r5) goto L_0x0035;
    L_0x002e:
        if (r2 == r3) goto L_0x0035;
    L_0x0030:
        if (r2 == r4) goto L_0x0035;
    L_0x0032:
        r0 = r0 + -1;
        goto L_0x0026;
    L_0x0035:
        if (r0 <= r9) goto L_0x0039;
    L_0x0037:
        r1 = r0;
        goto L_0x001b;
    L_0x0039:
        r0 = r9 + r8;
    L_0x003b:
        r2 = r7.length();
        if (r0 > r2) goto L_0x004e;
    L_0x0041:
        r2 = r7.charAt(r0);
        if (r2 == r5) goto L_0x004e;
    L_0x0047:
        if (r2 == r3) goto L_0x004e;
    L_0x0049:
        if (r2 == r4) goto L_0x004e;
    L_0x004b:
        r0 = r0 + 1;
        goto L_0x003b;
    L_0x004e:
        r2 = r7.length();
        if (r0 != r2) goto L_0x0055;
    L_0x0054:
        r0 = r1;
    L_0x0055:
        r1 = r0;
        goto L_0x001b;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.cli.c.a(java.lang.String, int, int):int");
    }

    protected String m10393a(int i) {
        StringBuffer stringBuffer = new StringBuffer(i);
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append(' ');
        }
        return stringBuffer.toString();
    }

    protected String m10394a(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        int length = str.length();
        while (length > 0 && Character.isWhitespace(str.charAt(length - 1))) {
            length--;
        }
        return str.substring(0, length);
    }
}
