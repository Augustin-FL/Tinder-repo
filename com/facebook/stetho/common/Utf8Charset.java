package com.facebook.stetho.common;

import java.nio.charset.Charset;

public class Utf8Charset {
    public static final Charset INSTANCE;
    public static final String NAME = "UTF-8";

    static {
        INSTANCE = Charset.forName(NAME);
    }

    public static byte[] encodeUTF8(String str) {
        try {
            return str.getBytes(NAME);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
