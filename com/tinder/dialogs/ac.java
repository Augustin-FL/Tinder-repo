package com.tinder.dialogs;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.stetho.BuildConfig;
import com.tinder.R;
import com.tinder.enums.ReportCause;
import com.tinder.model.Match;
import com.tinder.p030d.bg;
import com.tinder.utils.C3095y;
import com.tinder.utils.al;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class ac extends ab implements OnClickListener, OnTouchListener {
    private TextView f4401F;
    private TextView f4402G;
    private TextView f4403H;
    private TextView f4404I;
    private TextView f4405J;
    private View f4406K;
    private View f4407L;
    private View f4408M;
    private View f4409N;
    private View f4410O;
    private View f4411P;
    private bg f4412Q;

    /* renamed from: com.tinder.dialogs.ac.1 */
    class C24541 implements OnClickListener {
        final /* synthetic */ ac f4399a;

        C24541(ac acVar) {
            this.f4399a = acVar;
        }

        public void onClick(View view) {
            this.f4399a.dismiss();
        }
    }

    /* renamed from: com.tinder.dialogs.ac.2 */
    class C24552 implements OnClickListener {
        final /* synthetic */ ac f4400a;

        C24552(ac acVar) {
            this.f4400a = acVar;
        }

        public void onClick(View view) {
            al.m9268a(this.f4400a.f.getWindowToken(), (Activity) this.f4400a.a);
            this.f4400a.m6825s();
            this.f4400a.f4412Q.m6716a(ReportCause.OTHER, this.f4400a.e.getText().toString());
        }
    }

    public ac(@NonNull Context context, bg bgVar, @Nullable Match match) {
        super(context, R.style.Theme.FloatingDialog);
        this.f4412Q = bgVar;
        if (match == null) {
            m6826t();
        }
    }

    public void m6827m() {
        this.f4401F = (TextView) findViewById(R.id.report_type_offensive);
        this.f4402G = (TextView) findViewById(R.id.report_type_inappropiate_photos);
        this.f4403H = (TextView) findViewById(R.id.report_type_bad_offline_behavior);
        this.f4404I = (TextView) findViewById(R.id.report_type_spam);
        this.f4405J = (TextView) findViewById(R.id.report_type_other);
        this.f4401F.setOnClickListener(this);
        this.f4402G.setOnClickListener(this);
        this.f4403H.setOnClickListener(this);
        this.f4404I.setOnClickListener(this);
        this.f4405J.setOnClickListener(this);
        this.f4401F.setOnTouchListener(this);
        this.f4402G.setOnTouchListener(this);
        this.f4403H.setOnTouchListener(this);
        this.f4404I.setOnTouchListener(this);
        this.f4405J.setOnTouchListener(this);
        this.f4406K = findViewById(R.id.line_one);
        this.f4407L = findViewById(R.id.line_two);
        this.f4408M = findViewById(R.id.line_three);
        this.f4409N = findViewById(R.id.line_four);
        this.f4410O = findViewById(R.id.line_five);
        this.f4411P = findViewById(R.id.line_six);
        m6812i();
        m6823q();
    }

    public void m6828n() {
        m6830p();
    }

    public void m6829o() {
        m6807d();
        m6804a(true);
        m6821c(true);
        m6820b(false);
    }

    private void m6823q() {
        this.b.setText(R.string.reporting_report_user_title);
        this.c.setText(R.string.reporting_report_user_details);
        this.e.setVisibility(8);
        this.f.setVisibility(8);
        this.d.setVisibility(8);
        m6807d();
        m6811h();
        m6821c(true);
    }

    private void m6817a(int i) {
        int i2;
        int i3 = 0;
        this.b.setText(R.string.reporting_report_user_progress_title);
        m6804a(false);
        m6821c(false);
        m6811h();
        m6820b(true);
        this.j.setVisibility(i == R.id.report_type_offensive ? 0 : 4);
        ProgressBar progressBar = this.k;
        if (i == R.id.report_type_inappropiate_photos) {
            i2 = 0;
        } else {
            i2 = 4;
        }
        progressBar.setVisibility(i2);
        progressBar = this.l;
        if (i == R.id.report_type_bad_offline_behavior) {
            i2 = 0;
        } else {
            i2 = 4;
        }
        progressBar.setVisibility(i2);
        progressBar = this.m;
        if (i == R.id.report_type_spam) {
            i2 = 0;
        } else {
            i2 = 4;
        }
        progressBar.setVisibility(i2);
        ProgressBar progressBar2 = this.n;
        if (i != R.id.report_type_other) {
            i3 = 4;
        }
        progressBar2.setVisibility(i3);
        m6822d(true);
    }

    private void m6820b(boolean z) {
        float f;
        float f2 = 0.25f;
        this.f4401F.setAlpha(z ? 0.25f : 1.0f);
        TextView textView = this.f4402G;
        if (z) {
            f = 0.25f;
        } else {
            f = 1.0f;
        }
        textView.setAlpha(f);
        textView = this.f4403H;
        if (z) {
            f = 0.25f;
        } else {
            f = 1.0f;
        }
        textView.setAlpha(f);
        textView = this.f4404I;
        if (z) {
            f = 0.25f;
        } else {
            f = 1.0f;
        }
        textView.setAlpha(f);
        TextView textView2 = this.f4405J;
        if (!z) {
            f2 = 1.0f;
        }
        textView2.setAlpha(f2);
    }

    private void m6821c(boolean z) {
        this.f4401F.setEnabled(z);
        this.f4402G.setEnabled(z);
        this.f4403H.setEnabled(z);
        this.f4404I.setEnabled(z);
        this.f4405J.setEnabled(z);
    }

    private void m6822d(boolean z) {
        float f;
        float f2 = 0.25f;
        this.f4406K.setAlpha(z ? 0.25f : 1.0f);
        View view = this.f4407L;
        if (z) {
            f = 0.25f;
        } else {
            f = 1.0f;
        }
        view.setAlpha(f);
        view = this.f4408M;
        if (z) {
            f = 0.25f;
        } else {
            f = 1.0f;
        }
        view.setAlpha(f);
        view = this.f4409N;
        if (z) {
            f = 0.25f;
        } else {
            f = 1.0f;
        }
        view.setAlpha(f);
        view = this.f4410O;
        if (z) {
            f = 0.25f;
        } else {
            f = 1.0f;
        }
        view.setAlpha(f);
        View view2 = this.f4411P;
        if (!z) {
            f2 = 1.0f;
        }
        view2.setAlpha(f2);
    }

    public void m6830p() {
        this.b.setText(R.string.reporting_confirmation_title);
        this.c.setText(BuildConfig.FLAVOR);
        this.c.setPadding(this.c.getPaddingLeft(), 0, this.c.getPaddingRight(), this.c.getPaddingBottom());
        this.f.setText(R.string.reporting_confirmation_button);
        this.e.setVisibility(8);
        this.n.setVisibility(8);
        this.f.setVisibility(0);
        m6810g();
        m6804a(true);
        this.f.setOnClickListener(new C24541(this));
    }

    private void m6824r() {
        m6810g();
        m6809f();
        m6804a(true);
        this.n.setVisibility(8);
        this.f.setVisibility(0);
        this.f.setText(R.string.reporting_report_user_title);
        this.f.setOnClickListener(new C24552(this));
    }

    private void m6825s() {
        this.b.setText(R.string.reporting_report_user_progress_title);
        this.n.setVisibility(0);
        this.e.setAlpha(0.5f);
    }

    private void m6826t() {
        this.f4401F.setVisibility(8);
        this.f4407L.setVisibility(8);
        this.f4403H.setVisibility(8);
        this.f4409N.setVisibility(8);
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
        }
        return false;
    }

    public void onClick(@NonNull View view) {
        switch (view.getId()) {
            case R.id.report_type_offensive:
                m6817a(view.getId());
                this.f4412Q.m6716a(ReportCause.ABUSIVE_CONTENT, null);
            case R.id.report_type_inappropiate_photos:
                m6817a(view.getId());
                this.f4412Q.m6716a(ReportCause.INAPPROPRIATE_PHOTOS, null);
            case R.id.report_type_bad_offline_behavior:
                m6817a(view.getId());
                this.f4412Q.m6716a(ReportCause.OFFLINE_BEHAVIOR, null);
            case R.id.report_type_spam:
                m6817a(view.getId());
                this.f4412Q.m6716a(ReportCause.SPAM, null);
            case R.id.report_type_other:
                m6824r();
            default:
        }
    }
}
