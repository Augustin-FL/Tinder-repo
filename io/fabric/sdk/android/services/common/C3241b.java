package io.fabric.sdk.android.services.common;

/* renamed from: io.fabric.sdk.android.services.common.b */
class C3241b {
    public final String f7064a;
    public final boolean f7065b;

    C3241b(String str, boolean z) {
        this.f7064a = str;
        this.f7065b = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C3241b c3241b = (C3241b) obj;
        if (this.f7065b != c3241b.f7065b) {
            return false;
        }
        if (this.f7064a != null) {
            if (this.f7064a.equals(c3241b.f7064a)) {
                return true;
            }
        } else if (c3241b.f7064a == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        if (this.f7064a != null) {
            hashCode = this.f7064a.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode *= 31;
        if (this.f7065b) {
            i = 1;
        }
        return hashCode + i;
    }
}
