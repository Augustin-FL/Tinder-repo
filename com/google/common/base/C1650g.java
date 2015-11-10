package com.google.common.base;

/* renamed from: com.google.common.base.g */
public final class C1650g {
    public static void m3085a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void m3086a(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void m3087a(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(C1650g.m3083a(str, objArr));
        }
    }

    public static void m3091b(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void m3092b(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void m3093b(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalStateException(C1650g.m3083a(str, objArr));
        }
    }

    public static <T> T m3080a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    public static <T> T m3081a(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static <T> T m3082a(T t, String str, Object... objArr) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(C1650g.m3083a(str, objArr));
    }

    public static int m3078a(int i, int i2) {
        return C1650g.m3079a(i, i2, "index");
    }

    public static int m3079a(int i, int i2, String str) {
        if (i >= 0 && i < i2) {
            return i;
        }
        throw new IndexOutOfBoundsException(C1650g.m3094c(i, i2, str));
    }

    private static String m3094c(int i, int i2, String str) {
        if (i < 0) {
            return C1650g.m3083a("%s (%s) must not be negative", str, Integer.valueOf(i));
        } else if (i2 < 0) {
            throw new IllegalArgumentException("negative size: " + i2);
        } else {
            return C1650g.m3083a("%s (%s) must be less than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    public static int m3088b(int i, int i2) {
        return C1650g.m3089b(i, i2, "index");
    }

    public static int m3089b(int i, int i2, String str) {
        if (i >= 0 && i <= i2) {
            return i;
        }
        throw new IndexOutOfBoundsException(C1650g.m3095d(i, i2, str));
    }

    private static String m3095d(int i, int i2, String str) {
        if (i < 0) {
            return C1650g.m3083a("%s (%s) must not be negative", str, Integer.valueOf(i));
        } else if (i2 < 0) {
            throw new IllegalArgumentException("negative size: " + i2);
        } else {
            return C1650g.m3083a("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    public static void m3084a(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            throw new IndexOutOfBoundsException(C1650g.m3090b(i, i2, i3));
        }
    }

    private static String m3090b(int i, int i2, int i3) {
        if (i < 0 || i > i3) {
            return C1650g.m3095d(i, i3, "start index");
        }
        if (i2 < 0 || i2 > i3) {
            return C1650g.m3095d(i2, i3, "end index");
        }
        return C1650g.m3083a("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
    }

    static String m3083a(String str, Object... objArr) {
        int i = 0;
        String valueOf = String.valueOf(str);
        StringBuilder stringBuilder = new StringBuilder(valueOf.length() + (objArr.length * 16));
        int i2 = 0;
        while (i < objArr.length) {
            int indexOf = valueOf.indexOf("%s", i2);
            if (indexOf == -1) {
                break;
            }
            stringBuilder.append(valueOf.substring(i2, indexOf));
            i2 = i + 1;
            stringBuilder.append(objArr[i]);
            int i3 = i2;
            i2 = indexOf + 2;
            i = i3;
        }
        stringBuilder.append(valueOf.substring(i2));
        if (i < objArr.length) {
            stringBuilder.append(" [");
            i2 = i + 1;
            stringBuilder.append(objArr[i]);
            i = i2;
            while (i < objArr.length) {
                stringBuilder.append(", ");
                i2 = i + 1;
                stringBuilder.append(objArr[i]);
                i = i2;
            }
            stringBuilder.append(']');
        }
        return stringBuilder.toString();
    }
}
