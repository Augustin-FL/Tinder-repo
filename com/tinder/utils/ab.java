package com.tinder.utils;

import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;

public class ab implements TextWatcher {
    private C2267a f6522a;

    /* renamed from: com.tinder.utils.ab.a */
    public interface C2267a {
        void m5979a(int i);
    }

    public ab(C2267a c2267a) {
        this.f6522a = c2267a;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(@NonNull Editable editable) {
        if (this.f6522a != null) {
            this.f6522a.m5979a(editable.length());
        }
    }
}
