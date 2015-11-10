package com.google.android.m4b.maps.ay;

public final class bf {
    private final String f1184a;
    private final int f1185b;

    public bf(String str, int i) {
        this.f1184a = str;
        this.f1185b = i;
    }

    public final String m1778a() {
        return this.f1184a;
    }

    public final int m1779b() {
        return this.f1185b;
    }

    public final int hashCode() {
        return ((this.f1184a.hashCode() + 31) * 31) + this.f1185b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        bf bfVar = (bf) obj;
        if (this.f1184a == bfVar.f1184a && this.f1185b == bfVar.f1185b) {
            return true;
        }
        return false;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Icon{url=").append(this.f1184a).append(", , scaleDownFactor=").append(this.f1185b).append('}');
        return stringBuilder.toString();
    }
}
