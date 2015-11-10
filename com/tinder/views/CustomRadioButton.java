package com.tinder.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RadioButton;
import com.tinder.utils.CustomFont;
import com.tinder.utils.al;

public class CustomRadioButton extends RadioButton {
    public CustomRadioButton(Context context) {
        super(context);
    }

    public CustomRadioButton(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        al.m9280a((View) this, context, CustomFont.m9193a(context, attributeSet));
    }
}
