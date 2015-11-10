package com.tinder.utils;

import java.util.Locale;

/* renamed from: com.tinder.utils.w */
public class C3093w {
    public static String m9461a() {
        Locale locale = Locale.getDefault();
        if (locale.getLanguage().equals("ms")) {
            return "ml";
        }
        if (locale.toString().startsWith(Locale.CHINESE.toString())) {
            return locale.toString().replace("_", "-");
        }
        return locale.getLanguage();
    }

    public static String m9462b() {
        Locale locale = Locale.getDefault();
        if (locale.getLanguage().equals("ms")) {
            return "ml".toUpperCase();
        }
        return locale.getCountry();
    }
}
