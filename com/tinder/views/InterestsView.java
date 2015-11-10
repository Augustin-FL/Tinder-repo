package com.tinder.views;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tinder.R;
import com.tinder.model.Interest;
import com.tinder.model.User;
import com.tinder.utils.al;
import java.util.List;

public class InterestsView extends LinearLayout {
    private int mCellMargin;
    private LayoutParams mCellParams;
    private LayoutParams mRowParams;
    private Paint mTextPaint;
    private User mUser;

    public InterestsView(Context context) {
        super(context);
        init();
    }

    public InterestsView(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.mTextPaint = new Paint();
        this.mCellMargin = (int) al.m9284b(5.0f, getContext());
        this.mCellParams = new LayoutParams(-2, -2);
        this.mCellParams.leftMargin = this.mCellMargin;
        this.mRowParams = new LayoutParams(-2, -2);
        this.mRowParams.bottomMargin = this.mCellMargin;
    }

    public void setUser(User user) {
        this.mUser = user;
        addInterestCells(this.mUser.getCommonInterests(), true);
        addInterestCells(this.mUser.getUncommonInterests(), false);
    }

    private void addInterestCells(@NonNull List<Interest> list, boolean z) {
        LinearLayout linearLayout;
        Context context = getContext();
        int a = al.m9262a(context) - (context.getResources().getDimensionPixelSize(R.dimen.margin_large) * 2);
        int childCount = getChildCount();
        LinearLayout createRow = childCount > 0 ? (LinearLayout) getChildAt(getChildCount() - 1) : createRow();
        if (childCount > 0) {
            linearLayout = createRow;
        } else {
            ViewGroup viewGroup = null;
        }
        LinearLayout linearLayout2 = linearLayout;
        LinearLayout linearLayout3 = createRow;
        for (Interest interest : list) {
            TextView textView = (TextView) View.inflate(context, R.layout.cell_profile_interest, null);
            textView.setMaxWidth(a);
            textView.setText(interest.getName());
            if (!z) {
                textView.setTextColor(getResources().getColor(R.color.z_profile_body_text));
                textView.setBackgroundResource(R.drawable.cell_uncommon_interest_background);
            }
            int i = 0;
            for (int i2 = 0; i2 < linearLayout3.getChildCount(); i2++) {
                i += getInterestCellWidth((TextView) linearLayout3.getChildAt(i2));
            }
            if (getInterestCellWidth(textView) + i > a && linearLayout3.getChildCount() > 0) {
                linearLayout3 = createRow();
            }
            if (linearLayout3.getChildCount() == 0) {
                linearLayout3.addView(textView);
            } else {
                linearLayout3.addView(textView, this.mCellParams);
            }
            if (linearLayout3 != linearLayout2) {
                addView(linearLayout3, this.mRowParams);
                linearLayout = linearLayout3;
            } else {
                linearLayout = linearLayout2;
            }
            linearLayout2 = linearLayout;
        }
    }

    @NonNull
    private LinearLayout createRow() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        return linearLayout;
    }

    private int getInterestCellWidth(@NonNull TextView textView) {
        this.mTextPaint.setTextSize(textView.getTextSize());
        this.mTextPaint.setTypeface(textView.getTypeface());
        return (int) (((float) ((int) (((float) (textView.getPaddingLeft() + textView.getPaddingRight())) + this.mTextPaint.measureText(textView.getText().toString())))) + al.m9284b(2.5f, getContext()));
    }
}
