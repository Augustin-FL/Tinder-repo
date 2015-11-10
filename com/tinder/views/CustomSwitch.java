package com.tinder.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.SwitchCompat;
import android.util.AttributeSet;
import android.view.View;
import com.tinder.utils.CustomFont;
import com.tinder.utils.al;

public class CustomSwitch extends SwitchCompat {
    public CustomSwitch(@NonNull Context context) {
        super(context);
    }

    public CustomSwitch(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        if (!isInEditMode()) {
            al.m9280a((View) this, context, CustomFont.m9193a(context, attributeSet));
        }
    }
}
