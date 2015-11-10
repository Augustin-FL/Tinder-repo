package com.squareup.okhttp.internal.http;

/* renamed from: com.squareup.okhttp.internal.http.h */
public final class C2138h {
    public static boolean m5238a(String str) {
        return str.equals("POST") || str.equals("PATCH") || str.equals("PUT") || str.equals("DELETE");
    }

    public static boolean m5239b(String str) {
        return str.equals("POST") || str.equals("PUT") || str.equals("PATCH");
    }

    public static boolean m5240c(String str) {
        return C2138h.m5239b(str) || str.equals("DELETE");
    }
}
