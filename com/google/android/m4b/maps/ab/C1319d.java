package com.google.android.m4b.maps.ab;

import java.util.regex.Pattern;

/* renamed from: com.google.android.m4b.maps.ab.d */
public final class C1319d {
    private static final Pattern f780a;
    private final String f781b;
    private final String f782c;
    private final boolean f783d;

    static {
        f780a = Pattern.compile("[0-9]+[A-Z]?");
    }

    public C1319d(String str, String str2, boolean z) {
        boolean z2;
        this.f782c = str;
        this.f781b = str2;
        if (z) {
            if (f780a.matcher(this.f781b == null ? this.f782c : this.f781b).matches()) {
                z2 = true;
                this.f783d = z2;
            }
        }
        z2 = false;
        this.f783d = z2;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.f783d ? 1231 : 1237) + (((this.f781b == null ? 0 : this.f781b.hashCode()) + 31) * 31)) * 31;
        if (this.f782c != null) {
            i = this.f782c.hashCode();
        }
        return hashCode + i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1319d)) {
            return false;
        }
        C1319d c1319d = (C1319d) obj;
        if (this.f782c.equals(c1319d.f782c) && (((this.f781b == null && c1319d.f781b == null) || this.f781b.equals(c1319d.f781b)) && this.f783d == c1319d.f783d)) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return this.f782c;
    }
}
