package org.apache.commons.cli;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.entity.ContentLengthStrategy;

public class Option implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    private String f7324a;
    private String f7325b;
    private String f7326c;
    private String f7327d;
    private boolean f7328e;
    private boolean f7329f;
    private int f7330g;
    private Object f7331h;
    private List f7332i;
    private char f7333j;

    public Option(String str, String str2, boolean z, String str3) throws IllegalArgumentException {
        this.f7326c = "arg";
        this.f7330g = -1;
        this.f7332i = new ArrayList();
        C3357d.m10401a(str);
        this.f7324a = str;
        this.f7325b = str2;
        if (z) {
            this.f7330g = 1;
        }
        this.f7327d = str3;
    }

    String m10353a() {
        if (this.f7324a == null) {
            return this.f7325b;
        }
        return this.f7324a;
    }

    public String m10355b() {
        return this.f7324a;
    }

    public String m10356c() {
        return this.f7325b;
    }

    public boolean m10357d() {
        return this.f7329f;
    }

    public boolean m10358e() {
        return this.f7325b != null;
    }

    public boolean m10359f() {
        return this.f7330g > 0 || this.f7330g == -2;
    }

    public String m10360g() {
        return this.f7327d;
    }

    public boolean m10361h() {
        return this.f7328e;
    }

    public String m10362i() {
        return this.f7326c;
    }

    public boolean m10363j() {
        return this.f7326c != null && this.f7326c.length() > 0;
    }

    public boolean m10364k() {
        return this.f7330g > 1 || this.f7330g == -2;
    }

    public char m10365l() {
        return this.f7333j;
    }

    public boolean m10366m() {
        return this.f7333j > '\u0000';
    }

    void m10354a(String str) {
        switch (this.f7330g) {
            case ContentLengthStrategy.IDENTITY /*-1*/:
                throw new RuntimeException("NO_ARGS_ALLOWED");
            default:
                m10350b(str);
        }
    }

    private void m10350b(String str) {
        if (m10366m()) {
            char l = m10365l();
            int indexOf = str.indexOf(l);
            while (indexOf != -1 && this.f7332i.size() != this.f7330g - 1) {
                m10351c(str.substring(0, indexOf));
                str = str.substring(indexOf + 1);
                indexOf = str.indexOf(l);
            }
        }
        m10351c(str);
    }

    private void m10351c(String str) {
        if (this.f7330g <= 0 || this.f7332i.size() <= this.f7330g - 1) {
            this.f7332i.add(str);
            return;
        }
        throw new RuntimeException("Cannot add value, list full.");
    }

    public String[] m10367n() {
        return m10352p() ? null : (String[]) this.f7332i.toArray(new String[this.f7332i.size()]);
    }

    public String toString() {
        StringBuffer append = new StringBuffer().append("[ option: ");
        append.append(this.f7324a);
        if (this.f7325b != null) {
            append.append(" ").append(this.f7325b);
        }
        append.append(" ");
        if (m10364k()) {
            append.append("[ARG...]");
        } else if (m10359f()) {
            append.append(" [ARG]");
        }
        append.append(" :: ").append(this.f7327d);
        if (this.f7331h != null) {
            append.append(" :: ").append(this.f7331h);
        }
        append.append(" ]");
        return append.toString();
    }

    private boolean m10352p() {
        return this.f7332i.isEmpty();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Option option = (Option) obj;
        if (this.f7324a == null ? option.f7324a != null : !this.f7324a.equals(option.f7324a)) {
            return false;
        }
        if (this.f7325b != null) {
            if (this.f7325b.equals(option.f7325b)) {
                return true;
            }
        } else if (option.f7325b == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        if (this.f7324a != null) {
            hashCode = this.f7324a.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode *= 31;
        if (this.f7325b != null) {
            i = this.f7325b.hashCode();
        }
        return hashCode + i;
    }

    public Object clone() {
        try {
            Option option = (Option) super.clone();
            option.f7332i = new ArrayList(this.f7332i);
            return option;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(new StringBuffer().append("A CloneNotSupportedException was thrown: ").append(e.getMessage()).toString());
        }
    }

    void m10368o() {
        this.f7332i.clear();
    }
}
