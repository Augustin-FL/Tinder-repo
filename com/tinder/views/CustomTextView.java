package com.tinder.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.View;
import com.tinder.utils.CustomFont;
import com.tinder.utils.al;

public class CustomTextView extends AppCompatTextView {
    public CustomTextView(@NonNull Context context) {
        super(context);
    }

    public CustomTextView(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        if (!isInEditMode()) {
            al.m9280a((View) this, context, CustomFont.m9193a(context, attributeSet));
        }
    }
}
