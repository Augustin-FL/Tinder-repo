package com.tinder.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import android.widget.OverScroller;

/* renamed from: com.tinder.utils.d */
public class C3065d extends OverScroller {
    private int f6607a;

    public C3065d(@NonNull Context context) {
        super(context);
        this.f6607a = Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
    }

    public void m9343a(int i) {
        this.f6607a = i;
    }

    public void startScroll(int i, int i2, int i3, int i4) {
        super.startScroll(i, i2, i3, i4, this.f6607a);
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        super.startScroll(i, i2, i3, i4, this.f6607a);
    }
}
