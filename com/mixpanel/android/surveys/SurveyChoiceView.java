package com.mixpanel.android.surveys;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.CheckedTextView;
import com.viewpagerindicator.C3169d.C3168f;

public class SurveyChoiceView extends CheckedTextView {
    private Drawable f2977a;
    private float f2978b;
    private float f2979c;

    /* renamed from: com.mixpanel.android.surveys.SurveyChoiceView.a */
    private class C2066a extends Animation {
        final /* synthetic */ SurveyChoiceView f2976a;

        private C2066a(SurveyChoiceView surveyChoiceView) {
            this.f2976a = surveyChoiceView;
        }

        public boolean willChangeTransformationMatrix() {
            return false;
        }

        public boolean willChangeBounds() {
            return false;
        }

        protected void applyTransformation(float f, Transformation transformation) {
            float f2 = 0.0f;
            float f3 = 1.0f;
            if (f <= 0.5f) {
                f2 = f - 0.5f;
            } else {
                f3 = 1.0f + ((f - 0.5f) * 2.0f);
            }
            this.f2976a.f2978b = f2;
            this.f2976a.f2979c = f3;
            this.f2976a.requestLayout();
        }
    }

    public SurveyChoiceView(Context context) {
        super(context);
        m4863a();
    }

    public SurveyChoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4863a();
    }

    public SurveyChoiceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4863a();
    }

    public void setCheckMarkDrawable(Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        this.f2977a = drawable;
    }

    public void setChecked(boolean z) {
        boolean isChecked = isChecked();
        super.setChecked(z);
        if (isChecked() && !isChecked) {
            Animation c2066a = new C2066a();
            c2066a.setDuration(300);
            startAnimation(c2066a);
        }
    }

    protected void onDraw(Canvas canvas) {
        int i;
        int i2 = 0;
        Drawable drawable = this.f2977a;
        float f = getResources().getDisplayMetrics().density;
        if (drawable == null || !isChecked()) {
            i = 0;
        } else {
            i = (int) (14.0f * f);
        }
        int i3 = (int) (12.0f * f);
        int i4 = (int) (f * 22.0f);
        setCheckMarkDrawable(null);
        setPadding((int) (((float) i4) + (this.f2979c * ((float) i))), i3, i4, i3);
        super.onDraw(canvas);
        int i5 = (int) (((float) i4) + (this.f2978b * ((float) i)));
        setPadding(i5, i3, i4, i3);
        setCheckMarkDrawable(drawable);
        if (drawable != null) {
            switch (getGravity() & 112) {
                case C3168f.Toolbar_maxButtonHeight /*16*/:
                    i2 = (getHeight() - i) / 2;
                    break;
                case C3168f.Theme_listChoiceBackgroundIndicator /*80*/:
                    i2 = getHeight() - i;
                    break;
            }
            drawable.setBounds(i5 + getScrollX(), i2, (i + i5) + getScrollX(), i2 + i);
            drawable.draw(canvas);
        }
        setPadding(i4, i3, i4, i3);
    }

    private void m4863a() {
        this.f2978b = 0.0f;
        this.f2979c = 1.5f;
    }
}
