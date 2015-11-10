package com.tinder.utils;

import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;

/* renamed from: com.tinder.utils.z */
public class C3096z implements TextWatcher {
    private EditText f6660a;
    private int f6661b;
    private boolean f6662c;
    private int f6663d;

    public C3096z(int i, EditText editText) {
        this.f6661b = i;
        this.f6660a = editText;
    }

    public void beforeTextChanged(@NonNull CharSequence charSequence, int i, int i2, int i3) {
        this.f6663d = charSequence.length();
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(@NonNull Editable editable) {
        if (this.f6663d != editable.length()) {
            this.f6662c = true;
        }
        CharSequence text = this.f6660a.getText();
        int length = text.length();
        this.f6660a.removeTextChangedListener(this);
        if (length > this.f6661b) {
            length = Selection.getSelectionEnd(text);
            this.f6660a.setText(text.toString().substring(0, this.f6661b));
            Spannable text2 = this.f6660a.getText();
            if (length > text2.length()) {
                length = text2.length();
            }
            Selection.setSelection(text2, length);
        }
        this.f6660a.addTextChangedListener(this);
    }
}
