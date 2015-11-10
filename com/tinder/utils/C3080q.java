package com.tinder.utils;

import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import com.tinder.iap.util.C2770g;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.tinder.utils.q */
public class C3080q {
    public static final Pattern f6629a;
    public static final Pattern f6630b;
    private static ArrayMap<String, Integer> f6631c;

    static {
        f6629a = Pattern.compile("^plus_subscription.*$");
        f6630b = Pattern.compile("^.*_(\\d+)m$");
        f6631c = null;
    }

    public static int m9421a(String str) {
        int i = 1;
        if (f6631c == null) {
            f6631c = new ArrayMap(3);
        } else if (f6631c.containsKey(str)) {
            return ((Integer) f6631c.get(str)).intValue();
        }
        Matcher matcher = f6630b.matcher(str);
        if (matcher.matches() && matcher.groupCount() == 1) {
            i = Integer.parseInt(matcher.group(1));
        }
        f6631c.put(str, Integer.valueOf(i));
        return i;
    }

    @Nullable
    public static C2770g m9422a(List<C2770g> list) {
        C2770g c2770g = null;
        if (!(list == null || list.isEmpty())) {
            int i = 0;
            for (C2770g c2770g2 : list) {
                C2770g c2770g3;
                int i2;
                int a = C3080q.m9421a(c2770g2.m7888b());
                if (a > i) {
                    int i3 = a;
                    c2770g3 = c2770g2;
                    i2 = i3;
                } else {
                    i2 = i;
                    c2770g3 = c2770g;
                }
                i = i2;
                c2770g = c2770g3;
            }
        }
        return c2770g;
    }

    @Nullable
    public static C2770g m9424b(List<C2770g> list) {
        C2770g c2770g = null;
        if (!(list == null || list.isEmpty())) {
            for (C2770g c2770g2 : list) {
                C2770g c2770g22;
                if (C3080q.m9421a(c2770g22.m7888b()) != 1) {
                    c2770g22 = c2770g;
                }
                c2770g = c2770g22;
            }
        }
        return c2770g;
    }

    public static String m9423a(BigDecimal bigDecimal, String str) {
        C3095y.m9471a("Formatting " + bigDecimal.toPlainString() + " into currency type: " + str);
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        currencyInstance.setCurrency(Currency.getInstance(str));
        currencyInstance.setMinimumFractionDigits(2);
        String format = currencyInstance.format((double) bigDecimal.floatValue());
        C3095y.m9471a("Formatted: " + format);
        return format;
    }
}
