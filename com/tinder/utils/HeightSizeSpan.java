package com.tinder.utils;

import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.RelativeSizeSpan;

public class HeightSizeSpan extends RelativeSizeSpan {
    private float f6509a;

    public HeightSizeSpan(float f, float f2) {
        super(f);
        this.f6509a = f2;
    }

    public void updateDrawState(@NonNull TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.baselineShift += (int) (textPaint.ascent() * this.f6509a);
    }
}
