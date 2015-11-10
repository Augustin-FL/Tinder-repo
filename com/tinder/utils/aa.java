package com.tinder.utils;

import android.support.v7.widget.RecyclerView.SmoothScroller.Action;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.view.View.MeasureSpec;
import android.widget.EditText;

public class aa implements TextWatcher {
    private EditText f6518a;
    private float f6519b;
    private float f6520c;
    private C2266a f6521d;

    /* renamed from: com.tinder.utils.aa.a */
    public interface C2266a {
        void m5978a(float f, float f2);
    }

    public aa(float f, EditText editText, C2266a c2266a) {
        this.f6519b = f;
        this.f6518a = editText;
        this.f6521d = c2266a;
        m9209a();
        this.f6520c = (float) this.f6518a.getMeasuredHeight();
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        CharSequence text = this.f6518a.getText();
        m9209a();
        float measuredHeight = (float) this.f6518a.getMeasuredHeight();
        this.f6518a.removeTextChangedListener(this);
        while (measuredHeight > this.f6519b) {
            int selectionEnd = Selection.getSelectionEnd(text);
            String obj = text.toString();
            this.f6518a.setText(obj.substring(0, obj.length() - 1));
            text = this.f6518a.getText();
            if (selectionEnd > text.length()) {
                selectionEnd = text.length();
            }
            Selection.setSelection(text, selectionEnd);
            m9209a();
            measuredHeight = (float) this.f6518a.getMeasuredHeight();
        }
        if (measuredHeight != this.f6520c) {
            this.f6521d.m5978a(this.f6520c, measuredHeight);
            this.f6520c = measuredHeight;
        }
        this.f6518a.addTextChangedListener(this);
    }

    private void m9209a() {
        this.f6518a.measure(MeasureSpec.makeMeasureSpec(al.m9262a(this.f6518a.getContext()), Action.UNDEFINED_DURATION), MeasureSpec.makeMeasureSpec(0, 0));
    }
}
