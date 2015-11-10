package com.tinder.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import com.tinder.C2241a.C2233a;

public class CustomFont {

    public enum Font {
        LIGHT("proximanovasoft-regular.otf"),
        REGULAR("proximanovasoft-regular.otf"),
        SEMI_BOLD("proximanovasoft-semibold.otf"),
        BOLD("proximanovasoft-bold.otf"),
        MOMENTS("OpenSans-Bold.ttf");
        
        private String f6508f;

        private Font(String str) {
            this.f6508f = str;
        }

        public String m9192a() {
            return this.f6508f;
        }

        public String toString() {
            return this.f6508f;
        }
    }

    public static String m9193a(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        String string;
        Font font = Font.REGULAR;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2233a.com_tinder_views_CustomTextView);
        int i = obtainStyledAttributes.getInt(1, -1);
        if (i == -1) {
            string = obtainStyledAttributes.getString(0);
            if (string == null) {
                string = font.m9192a();
            }
        } else {
            string = Font.values()[i].m9192a();
        }
        obtainStyledAttributes.recycle();
        return string;
    }
}
