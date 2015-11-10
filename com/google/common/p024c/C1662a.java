package com.google.common.p024c;

import android.support.v7.widget.RecyclerView.SmoothScroller.Action;

/* renamed from: com.google.common.c.a */
public final class C1662a {
    public static int m3123a(long j) {
        if (j > 2147483647L) {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
        if (j < -2147483648L) {
            return Action.UNDEFINED_DURATION;
        }
        return (int) j;
    }
}
