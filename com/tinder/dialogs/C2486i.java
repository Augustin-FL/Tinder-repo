package com.tinder.dialogs;

import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TextView;
import com.tinder.R;
import com.tinder.utils.al;
import java.util.Calendar;
import java.util.Locale;

/* renamed from: com.tinder.dialogs.i */
public class C2486i extends Dialog implements OnClickListener, OnDateChangedListener {
    private final int f4485a;
    @NonNull
    private final DatePicker f4486b;
    private final OnDateSetListener f4487c;
    private Calendar f4488d;

    public C2486i(@NonNull Context context, OnDateSetListener onDateSetListener) {
        super(context, R.style.Theme.FloatingDialog);
        this.f4485a = 125;
        requestWindowFeature(1);
        setContentView(R.layout.view_dialog_datepicker);
        Window window = getWindow();
        window.setLayout(-2, -2);
        window.setGravity(17);
        al.m9266a((Dialog) this);
        this.f4486b = (DatePicker) findViewById(R.id.datepicker);
        View view = (TextView) findViewById(R.id.btn_set);
        view.setOnClickListener(this);
        al.m9287b(view);
        this.f4486b.setCalendarViewShown(false);
        Calendar instance = Calendar.getInstance(Locale.getDefault());
        instance.set(1, instance.get(1) - 13);
        Calendar instance2 = Calendar.getInstance(Locale.getDefault());
        instance2.set(1, instance.get(1) - 125);
        this.f4486b.setMinDate(instance2.getTimeInMillis());
        this.f4486b.setMaxDate(instance.getTimeInMillis());
        this.f4486b.init(instance.get(1), instance.get(2), instance.get(5), this);
        this.f4487c = onDateSetListener;
    }

    public void onDateChanged(@NonNull DatePicker datePicker, int i, int i2, int i3) {
        if (this.f4488d == null) {
            this.f4488d = Calendar.getInstance(Locale.getDefault());
        }
        this.f4488d.set(i, i2, i3);
    }

    public void onClick(@NonNull View view) {
        switch (view.getId()) {
            case R.id.btn_set:
                this.f4487c.onDateSet(this.f4486b, this.f4488d.get(1), this.f4488d.get(2), this.f4488d.get(5));
                dismiss();
            default:
        }
    }
}
