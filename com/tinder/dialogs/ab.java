package com.tinder.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tinder.R;
import com.tinder.utils.al;

public abstract class ab extends Dialog {
    private static float f4367F;
    protected View f4368A;
    protected View f4369B;
    protected TextView f4370C;
    protected TextView f4371D;
    protected TextView f4372E;
    protected Context f4373a;
    protected TextView f4374b;
    protected TextView f4375c;
    protected CheckBox f4376d;
    protected EditText f4377e;
    protected Button f4378f;
    protected ScrollView f4379g;
    protected RelativeLayout f4380h;
    protected RelativeLayout f4381i;
    protected ProgressBar f4382j;
    protected ProgressBar f4383k;
    protected ProgressBar f4384l;
    protected ProgressBar f4385m;
    protected ProgressBar f4386n;
    protected CheckBox f4387o;
    protected CheckBox f4388p;
    protected CheckBox f4389q;
    protected CheckBox f4390r;
    protected CheckBox f4391s;
    protected CheckBox f4392t;
    protected ImageView f4393u;
    protected ImageView f4394v;
    protected ImageView f4395w;
    protected ImageView f4396x;
    protected ImageView f4397y;
    protected ImageView f4398z;

    public abstract void m6816m();

    static {
        f4367F = 0.88f;
    }

    public ab(@NonNull Context context, int i) {
        super(context, i);
        getWindow().getAttributes().windowAnimations = R.style.dialog_up_down_animation;
        this.f4373a = context;
        requestWindowFeature(1);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setContentView(R.layout.dialog_report);
        this.f4374b = (TextView) findViewById(R.id.report_title);
        this.f4375c = (TextView) findViewById(R.id.report_details);
        this.f4378f = (Button) findViewById(R.id.btn_report_one);
        this.f4376d = (CheckBox) findViewById(R.id.report_checkbox);
        this.f4377e = (EditText) findViewById(R.id.report_additional_info);
        this.f4381i = (RelativeLayout) findViewById(R.id.addtional_info_container);
        this.f4380h = (RelativeLayout) findViewById(R.id.report_types_container);
        this.f4369B = findViewById(R.id.report_report_frame);
        this.f4368A = findViewById(R.id.report_unmatch_frame);
        this.f4382j = (ProgressBar) findViewById(R.id.progress_offensive);
        this.f4383k = (ProgressBar) findViewById(R.id.progress_inappropriate);
        this.f4384l = (ProgressBar) findViewById(R.id.progress_bad_offline_behavior);
        this.f4385m = (ProgressBar) findViewById(R.id.progress_spam);
        this.f4386n = (ProgressBar) findViewById(R.id.progress_other);
        this.f4379g = (ScrollView) findViewById(R.id.report_unmatch_container);
        this.f4387o = (CheckBox) findViewById(R.id.unmatch_type_noreason);
        this.f4389q = (CheckBox) findViewById(R.id.unmatch_type_inappropriate_photos);
        this.f4388p = (CheckBox) findViewById(R.id.unmatch_type_offensive);
        this.f4390r = (CheckBox) findViewById(R.id.unmatch_type_bad_offline_behavior);
        this.f4391s = (CheckBox) findViewById(R.id.unmatch_type_spam);
        this.f4392t = (CheckBox) findViewById(R.id.unmatch_type_other);
        this.f4393u = (ImageView) findViewById(R.id.checkmark_noreason);
        this.f4394v = (ImageView) findViewById(R.id.checkmark_offensive);
        this.f4395w = (ImageView) findViewById(R.id.checkmark_inappropriate_photos);
        this.f4396x = (ImageView) findViewById(R.id.checkmark_bad_offline_behavior);
        this.f4397y = (ImageView) findViewById(R.id.checkmark_spam);
        this.f4398z = (ImageView) findViewById(R.id.checkmark_other);
        this.f4370C = (TextView) findViewById(R.id.warning_beginning);
        this.f4371D = (TextView) findViewById(R.id.warning_middle);
        this.f4372E = (TextView) findViewById(R.id.warning_end);
        ((LinearLayout) findViewById(R.id.report_container)).getLayoutTransition().setAnimateParentHierarchy(false);
        m6802n();
        m6816m();
    }

    protected void m6803a() {
        findViewById(R.id.report_icon).setVisibility(8);
        findViewById(R.id.transparent_top_portion).setVisibility(8);
    }

    protected void m6805b() {
        this.f4376d.setVisibility(8);
    }

    protected void m6806c() {
        this.f4376d.setVisibility(0);
    }

    protected void m6804a(boolean z) {
        this.f4378f.setAlpha(z ? 1.0f : 0.25f);
        this.f4378f.setEnabled(z);
    }

    protected void m6807d() {
        this.f4382j.setVisibility(8);
        this.f4383k.setVisibility(8);
        this.f4384l.setVisibility(8);
        this.f4385m.setVisibility(8);
        this.f4386n.setVisibility(8);
    }

    protected void m6808e() {
        this.f4381i.setVisibility(8);
        this.f4377e.setVisibility(8);
        this.f4386n.setVisibility(8);
    }

    protected void m6809f() {
        this.f4381i.setVisibility(0);
        this.f4377e.setVisibility(0);
        this.f4377e.requestFocus();
        al.m9267a(this.f4373a, this.f4377e);
    }

    protected void m6810g() {
        this.f4380h.setVisibility(8);
        this.f4369B.setVisibility(8);
    }

    protected void m6811h() {
        this.f4380h.setVisibility(0);
        this.f4369B.setVisibility(0);
    }

    protected void m6812i() {
        this.f4379g.setVisibility(8);
        this.f4368A.setVisibility(8);
    }

    protected void m6813j() {
        this.f4379g.setVisibility(0);
        this.f4368A.setVisibility(0);
    }

    protected void m6814k() {
        this.f4370C.setVisibility(8);
        this.f4371D.setVisibility(8);
        this.f4372E.setVisibility(8);
    }

    protected void m6815l() {
        this.f4370C.setVisibility(0);
        this.f4371D.setVisibility(0);
        this.f4372E.setVisibility(0);
    }

    private void m6802n() {
        Window window = getWindow();
        window.getAttributes().width = (int) al.m9260a(f4367F);
        window.setGravity(17);
        m6805b();
        m6807d();
        m6808e();
        m6810g();
        m6812i();
        m6808e();
        m6814k();
    }
}
