package com.mixpanel.android.surveys;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

@TargetApi(14)
public class FadeOnPressButton extends Button {
    private boolean f2947a;

    public FadeOnPressButton(Context context) {
        super(context);
    }

    public FadeOnPressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FadeOnPressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void drawableStateChanged() {
        boolean z = false;
        for (int i : getDrawableState()) {
            if (i == 16842919) {
                if (!this.f2947a) {
                    setAlphaBySDK(0.5f);
                }
                z = true;
                if (this.f2947a && !r0) {
                    setAlphaBySDK(1.0f);
                    this.f2947a = true;
                }
                super.drawableStateChanged();
            }
        }
        setAlphaBySDK(1.0f);
        this.f2947a = true;
        super.drawableStateChanged();
    }

    private void setAlphaBySDK(float f) {
        setAlpha(f);
    }
}
