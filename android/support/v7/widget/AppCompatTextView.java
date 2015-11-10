package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.appcompat.C0159R;
import android.support.v7.internal.text.AllCapsTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

public class AppCompatTextView extends TextView {
    public AppCompatTextView(Context context) {
        this(context, null);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0159R.styleable.AppCompatTextView, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(C0159R.styleable.AppCompatTextView_android_textAppearance, -1);
        obtainStyledAttributes.recycle();
        if (resourceId != -1) {
            obtainStyledAttributes = context.obtainStyledAttributes(resourceId, C0159R.styleable.TextAppearance);
            if (obtainStyledAttributes.hasValue(C0159R.styleable.TextAppearance_textAllCaps)) {
                setAllCaps(obtainStyledAttributes.getBoolean(C0159R.styleable.TextAppearance_textAllCaps, false));
            }
            obtainStyledAttributes.recycle();
        }
        obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0159R.styleable.AppCompatTextView, i, 0);
        if (obtainStyledAttributes.hasValue(C0159R.styleable.AppCompatTextView_textAllCaps)) {
            setAllCaps(obtainStyledAttributes.getBoolean(C0159R.styleable.AppCompatTextView_textAllCaps, false));
        }
        obtainStyledAttributes.recycle();
    }

    public void setAllCaps(boolean z) {
        setTransformationMethod(z ? new AllCapsTransformationMethod(getContext()) : null);
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, C0159R.styleable.TextAppearance);
        if (obtainStyledAttributes.hasValue(C0159R.styleable.TextAppearance_textAllCaps)) {
            setAllCaps(obtainStyledAttributes.getBoolean(C0159R.styleable.TextAppearance_textAllCaps, false));
        }
        obtainStyledAttributes.recycle();
    }
}
