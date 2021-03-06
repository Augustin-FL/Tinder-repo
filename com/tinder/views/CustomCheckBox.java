package com.tinder.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatCheckBox;
import android.util.AttributeSet;
import android.view.View;
import com.tinder.utils.CustomFont;
import com.tinder.utils.al;

public class CustomCheckBox extends AppCompatCheckBox {
    public CustomCheckBox(Context context) {
        super(context);
    }

    public CustomCheckBox(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        al.m9280a((View) this, context, CustomFont.m9193a(context, attributeSet));
    }
}
