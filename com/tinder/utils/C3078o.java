package com.tinder.utils;

import android.support.annotation.NonNull;
import com.facebook.appevents.AppEventsConstants;
import com.tinder.views.RangeSeekBar;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.tinder.utils.o */
public class C3078o {
    public static String m9413a(@NonNull String str) {
        String str2 = "MD5";
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : digest) {
                str2 = Integer.toHexString(b & RangeSeekBar.INVALID_POINTER_ID);
                while (str2.length() < 2) {
                    str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO + str2;
                }
                stringBuilder.append(str2);
            }
            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
