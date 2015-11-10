package com.squareup.okhttp.internal.http;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.http.protocol.HttpDateGenerator;

/* renamed from: com.squareup.okhttp.internal.http.f */
public final class C2132f {
    private static final TimeZone f3263a;
    private static final ThreadLocal<DateFormat> f3264b;
    private static final String[] f3265c;
    private static final DateFormat[] f3266d;

    /* renamed from: com.squareup.okhttp.internal.http.f.1 */
    static class C21311 extends ThreadLocal<DateFormat> {
        C21311() {
        }

        protected /* synthetic */ Object initialValue() {
            return m5187a();
        }

        protected DateFormat m5187a() {
            DateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(C2132f.f3263a);
            return simpleDateFormat;
        }
    }

    static {
        f3263a = TimeZone.getTimeZone("GMT");
        f3264b = new C21311();
        f3265c = new String[]{HttpDateGenerator.PATTERN_RFC1123, "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
        f3266d = new DateFormat[f3265c.length];
    }

    public static Date m5189a(String str) {
        int i = 0;
        if (str.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date parse = ((DateFormat) f3264b.get()).parse(str, parsePosition);
        if (parsePosition.getIndex() == str.length()) {
            return parse;
        }
        synchronized (f3265c) {
            int length = f3265c.length;
            while (i < length) {
                DateFormat dateFormat = f3266d[i];
                if (dateFormat == null) {
                    dateFormat = new SimpleDateFormat(f3265c[i], Locale.US);
                    dateFormat.setTimeZone(f3263a);
                    f3266d[i] = dateFormat;
                }
                parsePosition.setIndex(0);
                parse = dateFormat.parse(str, parsePosition);
                if (parsePosition.getIndex() != 0) {
                    return parse;
                }
                i++;
            }
            return null;
        }
    }

    public static String m5188a(Date date) {
        return ((DateFormat) f3264b.get()).format(date);
    }
}
