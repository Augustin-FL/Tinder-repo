package com.tinder.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.tinder.R;
import com.tinder.p030d.bi;
import com.tinder.utils.al;

/* renamed from: com.tinder.dialogs.k */
public class C2489k extends Dialog implements OnClickListener {
    @NonNull
    private final RadioGroup f4490a;
    private bi f4491b;

    public C2489k(@NonNull Context context, bi biVar) {
        super(context, R.style.Theme.FloatingDialog);
        setContentView(R.layout.view_dialog_gender);
        Window window = getWindow();
        window.setLayout(-2, -2);
        window.setGravity(17);
        al.m9266a((Dialog) this);
        this.f4490a = (RadioGroup) findViewById(R.id.radiogroup_gender);
        View view = (TextView) findViewById(R.id.btn_confirm);
        view.setOnClickListener(this);
        al.m9287b(view);
        this.f4491b = biVar;
    }

    public void onClick(@NonNull View view) {
        switch (view.getId()) {
            case R.id.btn_confirm:
                int checkedRadioButtonId = this.f4490a.getCheckedRadioButtonId();
                if (checkedRadioButtonId == R.id.radio_male) {
                    this.f4491b.m6717a();
                } else if (checkedRadioButtonId == R.id.radio_female) {
                    this.f4491b.m6718b();
                }
                dismiss();
            default:
        }
    }
}
