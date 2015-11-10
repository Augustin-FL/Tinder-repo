package com.squareup.okhttp;

import java.util.regex.Pattern;

/* renamed from: com.squareup.okhttp.p */
public final class C2215p {
    private static final Pattern f3579a;
    private static final Pattern f3580b;
    private final String f3581c;

    static {
        f3579a = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
        f3580b = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    }

    public String toString() {
        return this.f3581c;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C2215p) && ((C2215p) obj).f3581c.equals(this.f3581c);
    }

    public int hashCode() {
        return this.f3581c.hashCode();
    }
}
