package com.tinder.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.util.AttributeSet;
import android.view.View;

public class DividerItemDecoration extends ItemDecoration {
    private Drawable mDivider;

    public DividerItemDecoration(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16843284});
        this.mDivider = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
    }

    public DividerItemDecoration(Drawable drawable) {
        this.mDivider = drawable;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        if (this.mDivider == null || recyclerView.getChildAdapterPosition(view) < 1) {
            return;
        }
        if (getOrientation(recyclerView) == 1) {
            rect.top = this.mDivider.getIntrinsicHeight();
        } else {
            rect.left = this.mDivider.getIntrinsicWidth();
        }
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, State state) {
        if (this.mDivider == null) {
            super.onDrawOver(canvas, recyclerView, state);
        } else if (getOrientation(recyclerView) == 1) {
            r2 = recyclerView.getPaddingLeft();
            r3 = recyclerView.getWidth() - recyclerView.getPaddingRight();
            r4 = recyclerView.getChildCount();
            for (r1 = 1; r1 < r4; r1++) {
                r5 = recyclerView.getChildAt(r1);
                r0 = (LayoutParams) r5.getLayoutParams();
                r0 = r5.getTop() - r0.topMargin;
                this.mDivider.setBounds(r2, r0, r3, r0 + this.mDivider.getIntrinsicHeight());
                this.mDivider.draw(canvas);
            }
        } else {
            r2 = recyclerView.getPaddingTop();
            r3 = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            r4 = recyclerView.getChildCount();
            for (r1 = 1; r1 < r4; r1++) {
                r5 = recyclerView.getChildAt(r1);
                r0 = (LayoutParams) r5.getLayoutParams();
                r0 = r5.getLeft() - r0.leftMargin;
                this.mDivider.setBounds(r0, r2, r0 + this.mDivider.getIntrinsicWidth(), r3);
                this.mDivider.draw(canvas);
            }
        }
    }

    private int getOrientation(RecyclerView recyclerView) {
        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) recyclerView.getLayoutManager()).getOrientation();
        }
        throw new IllegalStateException("DividerItemDecoration can only be used with a LinearLayoutManager.");
    }
}
