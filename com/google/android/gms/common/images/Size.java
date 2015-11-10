package com.google.android.gms.common.images;

public final class Size {
    private final int zznP;
    private final int zznQ;

    public Size(int i, int i2) {
        this.zznP = i;
        this.zznQ = i2;
    }

    public static Size parseSize(String str) throws NumberFormatException {
        if (str == null) {
            throw new IllegalArgumentException("string must not be null");
        }
        int indexOf = str.indexOf(42);
        if (indexOf < 0) {
            indexOf = str.indexOf(120);
        }
        if (indexOf < 0) {
            throw zzcg(str);
        }
        try {
            return new Size(Integer.parseInt(str.substring(0, indexOf)), Integer.parseInt(str.substring(indexOf + 1)));
        } catch (NumberFormatException e) {
            throw zzcg(str);
        }
    }

    private static NumberFormatException zzcg(String str) {
        throw new NumberFormatException("Invalid Size: \"" + str + "\"");
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        if (!(this.zznP == size.zznP && this.zznQ == size.zznQ)) {
            z = false;
        }
        return z;
    }

    public int getHeight() {
        return this.zznQ;
    }

    public int getWidth() {
        return this.zznP;
    }

    public int hashCode() {
        return this.zznQ ^ ((this.zznP << 16) | (this.zznP >>> 16));
    }

    public String toString() {
        return this.zznP + "x" + this.zznQ;
    }
}
