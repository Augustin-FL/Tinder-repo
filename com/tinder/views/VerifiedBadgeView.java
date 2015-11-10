package com.tinder.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tinder.R;
import com.tinder.p032c.C2423e;
import com.tinder.utils.C3095y;

public class VerifiedBadgeView extends ImageView {
    private boolean mBordered;
    private boolean mFiltered;

    public VerifiedBadgeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFiltered = false;
        this.mBordered = false;
    }

    public VerifiedBadgeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFiltered = false;
        this.mBordered = false;
    }

    public void setFiltered(boolean z) {
        this.mFiltered = z;
        invalidate();
    }

    public void setBordered(boolean z) {
        this.mBordered = z;
    }

    public void displayBadge(C2423e c2423e) {
        if (c2423e == null) {
            C3095y.m9479c("Null user, cannot show verified badge because we can't tell if they're verified.");
            return;
        }
        int i = c2423e.isVerified() ? this.mBordered ? R.drawable.verification_badge_bordered : R.drawable.verification_badge : 17170445;
        setImageResource(i);
        if (this.mFiltered) {
            setColorFilter(-1);
        } else {
            clearColorFilter();
        }
    }
}
