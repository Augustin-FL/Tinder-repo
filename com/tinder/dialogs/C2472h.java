package com.tinder.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tinder.R;
import com.tinder.utils.C3045a;
import com.tinder.utils.al;

/* renamed from: com.tinder.dialogs.h */
public class C2472h extends Dialog {
    @NonNull
    private final Context f4466a;
    private LayoutInflater f4467b;
    private LinearLayout f4468c;
    private ImageView f4469d;
    private TextView f4470e;
    private TextView f4471f;
    private TextView f4472g;
    private TextView f4473h;
    private View f4474i;
    private ScrollView f4475j;

    /* renamed from: com.tinder.dialogs.h.1 */
    class C24841 implements OnClickListener {
        final /* synthetic */ C2472h f4483a;

        C24841(C2472h c2472h) {
            this.f4483a = c2472h;
        }

        public void onClick(View view) {
            this.f4483a.dismiss();
        }
    }

    /* renamed from: com.tinder.dialogs.h.2 */
    class C24852 implements OnClickListener {
        final /* synthetic */ C2472h f4484a;

        C24852(C2472h c2472h) {
            this.f4484a = c2472h;
        }

        public void onClick(View view) {
            this.f4484a.dismiss();
        }
    }

    public C2472h(@NonNull Context context, @DrawableRes int i, @StringRes int i2, @StringRes int i3) {
        super(context, R.style.DialogBinary);
        this.f4466a = context;
        m6869b();
        m6871a(i);
        setTitle(i2);
        m6875b(i3);
    }

    public C2472h(@NonNull Context context, @DrawableRes int i, @StringRes int i2, String str) {
        super(context, R.style.DialogBinary);
        this.f4466a = context;
        m6869b();
        m6871a(i);
        setTitle(i2);
        m6873a(str);
    }

    private void m6869b() {
        this.f4467b = LayoutInflater.from(this.f4466a);
        setContentView(R.layout.view_dialog_binary_base);
        al.m9266a((Dialog) this);
        Window window = getWindow();
        window.setLayout(-2, -2);
        window.setGravity(17);
        this.f4468c = (LinearLayout) findViewById(R.id.linear_container);
        this.f4469d = (ImageView) findViewById(R.id.img_dialog_icon);
        this.f4470e = (TextView) findViewById(R.id.txt_dialog_title);
        this.f4471f = (TextView) findViewById(R.id.txt_dialog_txt);
        this.f4472g = (TextView) findViewById(R.id.txt_choice_one);
        this.f4473h = (TextView) findViewById(R.id.txt_choice_two);
        this.f4474i = findViewById(R.id.linear_binary_choices);
        this.f4475j = (ScrollView) findViewById(R.id.scroll_txt);
        C3045a.m9203a(this.f4472g, 1.0f, 0.95f, 275, 275);
        C3045a.m9203a(this.f4473h, 1.0f, 0.95f, 275, 275);
        m6872a(R.string.cancel, new C24841(this));
        m6876b(R.string.cancel, new C24852(this));
        setCanceledOnTouchOutside(true);
    }

    public void setTitle(int i) {
        this.f4470e.setText(i);
    }

    public void m6871a(@DrawableRes int i) {
        if (i == 0) {
            this.f4469d.setVisibility(8);
        } else {
            this.f4469d.setImageResource(i);
        }
    }

    public void m6875b(@StringRes int i) {
        this.f4471f.setText(i);
    }

    public void m6873a(String str) {
        this.f4471f.setText(str);
    }

    public void m6872a(int i, OnClickListener onClickListener) {
        this.f4472g.setText(i);
        this.f4472g.setOnClickListener(onClickListener);
    }

    public void m6876b(int i, OnClickListener onClickListener) {
        this.f4473h.setText(i);
        this.f4473h.setOnClickListener(onClickListener);
    }

    public TextView m6870a() {
        return this.f4472g;
    }

    public void m6874a(boolean z) {
        if (z) {
            this.f4475j.getLayoutParams().height = (int) this.f4466a.getResources().getDimension(R.dimen.dialog_txt_max_height);
            return;
        }
        this.f4475j.getLayoutParams().height = -2;
    }

    public void m6877c(@StringRes int i, OnClickListener onClickListener) {
        this.f4474i.setVisibility(8);
        View view = (TextView) findViewById(R.id.txt_mono_choice);
        view.setOnClickListener(onClickListener);
        view.setText(i);
        C3045a.m9203a(view, 1.0f, 0.95f, 275, 275);
        view.setVisibility(0);
    }
}
