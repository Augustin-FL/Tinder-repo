package com.squareup.okhttp;

import com.facebook.stetho.BuildConfig;
import com.squareup.okhttp.internal.http.C2132f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/* renamed from: com.squareup.okhttp.m */
public final class C2210m {
    private final String[] f3560a;

    /* renamed from: com.squareup.okhttp.m.a */
    public static final class C2209a {
        private final List<String> f3559a;

        public C2209a() {
            this.f3559a = new ArrayList(20);
        }

        C2209a m5679a(String str) {
            int indexOf = str.indexOf(":", 1);
            if (indexOf != -1) {
                return m5683b(str.substring(0, indexOf), str.substring(indexOf + 1));
            }
            if (str.startsWith(":")) {
                return m5683b(BuildConfig.FLAVOR, str.substring(1));
            }
            return m5683b(BuildConfig.FLAVOR, str);
        }

        public C2209a m5680a(String str, String str2) {
            if (str == null) {
                throw new IllegalArgumentException("name == null");
            } else if (str2 == null) {
                throw new IllegalArgumentException("value == null");
            } else if (str.length() != 0 && str.indexOf(0) == -1 && str2.indexOf(0) == -1) {
                return m5683b(str, str2);
            } else {
                throw new IllegalArgumentException("Unexpected header: " + str + ": " + str2);
            }
        }

        C2209a m5683b(String str, String str2) {
            this.f3559a.add(str);
            this.f3559a.add(str2.trim());
            return this;
        }

        public C2209a m5682b(String str) {
            int i = 0;
            while (i < this.f3559a.size()) {
                if (str.equalsIgnoreCase((String) this.f3559a.get(i))) {
                    this.f3559a.remove(i);
                    this.f3559a.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        public C2209a m5684c(String str, String str2) {
            m5682b(str);
            m5680a(str, str2);
            return this;
        }

        public String m5685c(String str) {
            for (int size = this.f3559a.size() - 2; size >= 0; size -= 2) {
                if (str.equalsIgnoreCase((String) this.f3559a.get(size))) {
                    return (String) this.f3559a.get(size + 1);
                }
            }
            return null;
        }

        public C2210m m5681a() {
            return new C2210m();
        }
    }

    private C2210m(C2209a c2209a) {
        this.f3560a = (String[]) c2209a.f3559a.toArray(new String[c2209a.f3559a.size()]);
    }

    public String m5689a(String str) {
        return C2210m.m5686a(this.f3560a, str);
    }

    public Date m5692b(String str) {
        String a = m5689a(str);
        return a != null ? C2132f.m5189a(a) : null;
    }

    public int m5687a() {
        return this.f3560a.length / 2;
    }

    public String m5688a(int i) {
        int i2 = i * 2;
        if (i2 < 0 || i2 >= this.f3560a.length) {
            return null;
        }
        return this.f3560a[i2];
    }

    public String m5691b(int i) {
        int i2 = (i * 2) + 1;
        if (i2 < 0 || i2 >= this.f3560a.length) {
            return null;
        }
        return this.f3560a[i2];
    }

    public List<String> m5693c(String str) {
        int a = m5687a();
        List list = null;
        for (int i = 0; i < a; i++) {
            if (str.equalsIgnoreCase(m5688a(i))) {
                if (list == null) {
                    list = new ArrayList(2);
                }
                list.add(m5691b(i));
            }
        }
        if (list != null) {
            return Collections.unmodifiableList(list);
        }
        return Collections.emptyList();
    }

    public C2209a m5690b() {
        C2209a c2209a = new C2209a();
        Collections.addAll(c2209a.f3559a, this.f3560a);
        return c2209a;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int a = m5687a();
        for (int i = 0; i < a; i++) {
            stringBuilder.append(m5688a(i)).append(": ").append(m5691b(i)).append("\n");
        }
        return stringBuilder.toString();
    }

    private static String m5686a(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }
}
