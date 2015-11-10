package com.tinder.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import com.google.android.gms.location.places.Place;
import com.tinder.R;
import com.tinder.utils.C3095y;

/* renamed from: com.tinder.dialogs.r */
public class C2515r extends Dialog {
    public C2515r(@NonNull Context context) {
        super(context, R.style.Theme.ProgressDialog);
        C3095y.m9469a();
        m6943a();
    }

    private void m6943a() {
        getWindow().setFlags(Place.TYPE_SUBLOCALITY_LEVEL_2, Place.TYPE_SUBLOCALITY_LEVEL_2);
        getWindow().setLayout(-1, -1);
        setContentView(R.layout.view_progress);
    }
}
