package com.google.common.base;

/* renamed from: com.google.common.base.a */
public final class C1626a {
    public static String m3008a(String str) {
        return C1626a.m3007a((CharSequence) str);
    }

    public static String m3007a(CharSequence charSequence) {
        int length = charSequence.length();
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            stringBuilder.append(C1626a.m3006a(charSequence.charAt(i)));
        }
        return stringBuilder.toString();
    }

    public static char m3006a(char c) {
        return C1626a.m3009b(c) ? (char) (c ^ 32) : c;
    }

    public static boolean m3009b(char c) {
        return c >= 'A' && c <= 'Z';
    }
}
