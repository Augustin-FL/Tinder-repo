package com.tinder.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;

public class aa extends Dialog {
    public aa(@NonNull Context context, int i) {
        super(context, i);
        m6775a();
    }

    private void m6775a() {
        requestWindowFeature(1);
        getWindow().setFormat(-3);
        getWindow().setFlags(1152, 1152);
        getWindow().clearFlags(2);
        setCanceledOnTouchOutside(true);
    }
}
