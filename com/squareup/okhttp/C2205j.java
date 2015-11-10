package com.squareup.okhttp;

import java.io.UnsupportedEncodingException;
import okio.ByteString;
import org.apache.http.protocol.HTTP;

/* renamed from: com.squareup.okhttp.j */
public final class C2205j {
    public static String m5670a(String str, String str2) {
        try {
            return "Basic " + ByteString.m10146a((str + ":" + str2).getBytes(HTTP.ISO_8859_1)).m10153b();
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError();
        }
    }
}
