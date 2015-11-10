package com.tinder.utils;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.format.DateUtils;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

@SuppressLint({"SimpleDateFormat"})
/* renamed from: com.tinder.utils.i */
public class C3070i extends DateUtils {
    private static final SimpleDateFormat f6612a;

    static {
        f6612a = new SimpleDateFormat("yy-MM-dd'T'HH:mm:ss.SSS'Z'");
        f6612a.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
    }

    public static synchronized long m9362a(@Nullable String str) {
        long currentTimeMillis;
        synchronized (C3070i.class) {
            currentTimeMillis = System.currentTimeMillis();
            if (str != null) {
                try {
                    currentTimeMillis = f6612a.parse(str).getTime();
                } catch (Throwable e) {
                    C3095y.m9474a("Failed to get time from String date " + str, e);
                }
            }
        }
        return currentTimeMillis;
    }

    public static String m9364a(String str, Date date) {
        return C3070i.m9365a(str, new Date(), date);
    }

    public static String m9365a(String str, Date date, Date date2) {
        long time = date.getTime() - date2.getTime();
        if (time < 60000) {
            return str;
        }
        if (time < 3600000) {
            return C3070i.getRelativeTimeSpanString(date2.getTime(), date.getTime(), 60000, 393216).toString();
        }
        return DateUtils.getRelativeTimeSpanString(date2.getTime(), date.getTime(), 3600000, 393216).toString();
    }

    public static boolean m9367a(Date date, Date date2) {
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance.setTime(date);
        instance2.setTime(date2);
        if (instance.get(1) == instance2.get(1) && instance.get(6) == instance2.get(6)) {
            return true;
        }
        return false;
    }

    public static int m9361a(@NonNull Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        Calendar instance2 = Calendar.getInstance();
        int i = instance2.get(1) - instance.get(1);
        if (instance2.get(2) < instance.get(2)) {
            i--;
        } else if (instance2.get(2) == instance.get(2) && instance2.get(5) < instance.get(5)) {
            i--;
        }
        if (i < 0) {
            return 0;
        }
        return i;
    }

    @NonNull
    public static DateFormat m9366a() {
        DateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd'T'HH:mm:ss.SSS'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
        return simpleDateFormat;
    }

    @NonNull
    public static DateFormat m9369b() {
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
        return simpleDateFormat;
    }

    @SuppressLint({"SimpleDateFormat"})
    public static String m9370c() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM d, yyyy hh:mm:ss aaa");
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        return simpleDateFormat.format(Calendar.getInstance(Locale.getDefault()).getTime());
    }

    @SuppressLint({"SimpleDateFormat"})
    public static String m9363a(long j) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM d, yyyy hh:mm:ss aaa");
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        return simpleDateFormat.format(new Date(j));
    }

    public static String m9368b(long j) {
        int toHours = ((int) TimeUnit.MILLISECONDS.toHours(j)) % 24;
        int toMinutes = ((int) TimeUnit.MILLISECONDS.toMinutes(j)) % 60;
        int toSeconds = ((int) TimeUnit.MILLISECONDS.toSeconds(j)) % 60;
        return String.format("%02d:%02d:%02d", new Object[]{Integer.valueOf(toHours), Integer.valueOf(toMinutes), Integer.valueOf(toSeconds)});
    }

    public static int m9360a(@Nullable String str, @Nullable String str2) throws ParseException {
        if (str == null || str.length() == 0) {
            if (str2 == null || str2.length() == 0) {
                return 0;
            }
            return -1;
        } else if (str2 == null || str2.length() == 0) {
            return 1;
        } else {
            return f6612a.parse(str).compareTo(f6612a.parse(str2));
        }
    }
}
