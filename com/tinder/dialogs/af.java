package com.tinder.dialogs;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import com.tinder.R;
import com.tinder.enums.ReportCause;
import com.tinder.p030d.bp;
import com.tinder.utils.C3095y;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class af extends ab implements OnTouchListener, OnCheckedChangeListener {
    private final float f4430F;
    private bp f4431G;

    /* renamed from: com.tinder.dialogs.af.1 */
    class C24611 implements OnClickListener {
        final /* synthetic */ af f4429a;

        C24611(af afVar) {
            this.f4429a = afVar;
        }

        public void onClick(View view) {
            String str = null;
            ReportCause reportCause = this.f4429a.p.isChecked() ? ReportCause.ABUSIVE_CONTENT : this.f4429a.q.isChecked() ? ReportCause.INAPPROPRIATE_PHOTOS : this.f4429a.r.isChecked() ? ReportCause.OFFLINE_BEHAVIOR : this.f4429a.s.isChecked() ? ReportCause.SPAM : this.f4429a.t.isChecked() ? ReportCause.OTHER : null;
            String obj = this.f4429a.e.getText().toString();
            bp a = this.f4429a.f4431G;
            if (this.f4429a.t.isChecked()) {
                str = obj;
            }
            a.m6737a(reportCause, str);
            this.f4429a.dismiss();
        }
    }

    public af(@NonNull Context context, bp bpVar) {
        super(context, R.style.Theme.FloatingDialog);
        this.f4430F = 0.25f;
        this.f4431G = bpVar;
    }

    public void m6847m() {
        m6803a();
        m6805b();
        m6807d();
        m6808e();
        m6810g();
        m6813j();
        this.b.setText(R.string.reporting_unmatch_title);
        this.c.setText(R.string.reporting_unmatch_details);
        this.f.setText(R.string.reporting_unmatch_button);
        this.f.setOnClickListener(new C24611(this));
        this.o.setOnCheckedChangeListener(this);
        this.p.setOnCheckedChangeListener(this);
        this.r.setOnCheckedChangeListener(this);
        this.q.setOnCheckedChangeListener(this);
        this.s.setOnCheckedChangeListener(this);
        this.t.setOnCheckedChangeListener(this);
        this.o.setOnTouchListener(this);
        this.p.setOnTouchListener(this);
        this.r.setOnTouchListener(this);
        this.q.setOnTouchListener(this);
        this.s.setOnTouchListener(this);
        this.t.setOnTouchListener(this);
        this.o.setChecked(true);
    }

    private void m6846a(@NonNull CompoundButton compoundButton, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i;
        int i2 = R.color.orange;
        int i3 = 0;
        boolean z7 = compoundButton.getId() == R.id.unmatch_type_noreason && z;
        if (compoundButton.getId() == R.id.unmatch_type_offensive && z) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (compoundButton.getId() == R.id.unmatch_type_inappropriate_photos && z) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (compoundButton.getId() == R.id.unmatch_type_bad_offline_behavior && z) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (compoundButton.getId() == R.id.unmatch_type_spam && z) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (compoundButton.getId() == R.id.unmatch_type_other && z) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z7 || z2 || z3 || z4 || z5 || z6) {
            i = true;
        } else {
            i = 0;
        }
        if (i == 0) {
            compoundButton.setOnCheckedChangeListener(null);
            compoundButton.setChecked(true);
            compoundButton.getCompoundDrawables()[0].setColorFilter(this.a.getResources().getColor(R.color.orange), Mode.SRC_ATOP);
            compoundButton.setOnCheckedChangeListener(this);
            return;
        }
        int i4;
        this.o.setOnCheckedChangeListener(null);
        this.p.setOnCheckedChangeListener(null);
        this.q.setOnCheckedChangeListener(null);
        this.r.setOnCheckedChangeListener(null);
        this.s.setOnCheckedChangeListener(null);
        this.t.setOnCheckedChangeListener(null);
        this.o.setChecked(z7);
        this.p.setChecked(z2);
        this.q.setChecked(z3);
        this.r.setChecked(z4);
        this.s.setChecked(z5);
        this.t.setChecked(z6);
        this.o.setOnCheckedChangeListener(this);
        this.p.setOnCheckedChangeListener(this);
        this.q.setOnCheckedChangeListener(this);
        this.r.setOnCheckedChangeListener(this);
        this.s.setOnCheckedChangeListener(this);
        this.t.setOnCheckedChangeListener(this);
        this.o.getCompoundDrawables()[0].setColorFilter(this.a.getResources().getColor(z7 ? R.color.orange : R.color.reporting_item), Mode.SRC_ATOP);
        this.p.getCompoundDrawables()[0].setColorFilter(this.a.getResources().getColor(z2 ? R.color.orange : R.color.reporting_item), Mode.SRC_ATOP);
        this.q.getCompoundDrawables()[0].setColorFilter(this.a.getResources().getColor(z3 ? R.color.orange : R.color.reporting_item), Mode.SRC_ATOP);
        this.r.getCompoundDrawables()[0].setColorFilter(this.a.getResources().getColor(z4 ? R.color.orange : R.color.reporting_item), Mode.SRC_ATOP);
        this.s.getCompoundDrawables()[0].setColorFilter(this.a.getResources().getColor(z5 ? R.color.orange : R.color.reporting_item), Mode.SRC_ATOP);
        Drawable drawable = this.t.getCompoundDrawables()[0];
        Resources resources = this.a.getResources();
        if (!z6) {
            i2 = R.color.reporting_item;
        }
        drawable.setColorFilter(resources.getColor(i2), Mode.SRC_ATOP);
        ImageView imageView = this.u;
        if (z7) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        imageView.setVisibility(i4);
        imageView = this.v;
        if (z2) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        imageView.setVisibility(i4);
        imageView = this.w;
        if (z3) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        imageView.setVisibility(i4);
        imageView = this.x;
        if (z4) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        imageView.setVisibility(i4);
        imageView = this.y;
        if (z5) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        imageView.setVisibility(i4);
        ImageView imageView2 = this.z;
        if (!z6) {
            i3 = 8;
        }
        imageView2.setVisibility(i3);
    }

    public void onCheckedChanged(@NonNull CompoundButton compoundButton, boolean z) {
        switch (compoundButton.getId()) {
            case R.id.unmatch_type_noreason:
                m6846a(this.o, z);
            case R.id.unmatch_type_offensive:
                m6846a(this.p, z);
            case R.id.unmatch_type_inappropriate_photos:
                m6846a(this.q, z);
            case R.id.unmatch_type_bad_offline_behavior:
                m6846a(this.r, z);
            case R.id.unmatch_type_spam:
                m6846a(this.s, z);
            case R.id.unmatch_type_other:
                m6846a(this.t, z);
            default:
        }
    }

    public void dismiss() {
        this.a.getResources();
        this.o.getCompoundDrawables()[0].clearColorFilter();
        this.p.getCompoundDrawables()[0].clearColorFilter();
        this.q.getCompoundDrawables()[0].clearColorFilter();
        this.r.getCompoundDrawables()[0].clearColorFilter();
        this.s.getCompoundDrawables()[0].clearColorFilter();
        this.t.getCompoundDrawables()[0].clearColorFilter();
        super.dismiss();
    }

    public boolean onTouch(@NonNull View view, @NonNull MotionEvent motionEvent) {
        C3095y.m9471a("motionEvent: " + motionEvent.getAction());
        switch (motionEvent.getAction()) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                view.setAlpha(0.25f);
                break;
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                view.setAlpha(1.0f);
                break;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                view.setAlpha(0.25f);
                break;
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                view.setAlpha(1.0f);
                break;
        }
        return false;
    }
}
