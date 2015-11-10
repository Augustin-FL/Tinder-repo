package com.tinder.utils;

import android.text.InputFilter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import com.facebook.stetho.BuildConfig;

/* renamed from: com.tinder.utils.k */
public class C3072k implements InputFilter {
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        String obj = spanned.toString();
        boolean endsWith = obj.endsWith(" ");
        boolean endsWith2 = obj.endsWith("\n\n");
        if (charSequence.length() == 0) {
            return null;
        }
        CharSequence replaceFirst = (endsWith && charSequence.charAt(i) == ' ') ? charSequence.toString().replaceFirst(" ", BuildConfig.FLAVOR) : (endsWith2 && charSequence.charAt(i) == '\n') ? charSequence.toString().replaceAll(String.valueOf('\n'), BuildConfig.FLAVOR) : null;
        if (!(charSequence instanceof Spanned) || replaceFirst == null) {
            return replaceFirst;
        }
        Spannable spannableString = new SpannableString(replaceFirst);
        TextUtils.copySpansFrom((Spanned) charSequence, i, i2, null, spannableString, 0);
        return spannableString;
    }
}
