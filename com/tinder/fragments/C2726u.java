package com.tinder.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tinder.R;
import com.tinder.activities.ActivityVerification;
import com.tinder.managers.C2821b;
import com.tinder.p030d.af;
import com.tinder.p030d.br;
import com.tinder.utils.C3095y;
import com.tinder.utils.al;

/* renamed from: com.tinder.fragments.u */
public class C2726u extends Fragment implements OnClickListener, af {
    @Nullable
    private String f5382a;
    private EditText f5383b;
    private ImageView f5384c;
    private ImageView f5385d;
    private TextView f5386e;
    private TextView f5387f;

    /* renamed from: com.tinder.fragments.u.1 */
    class C27211 implements TextWatcher {
        final /* synthetic */ C2726u f5377a;

        C27211(C2726u c2726u) {
            this.f5377a = c2726u;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(@NonNull Editable editable) {
            C3095y.m9471a("enteredCode=" + editable.toString());
            if (this.f5377a.m7712d()) {
                this.f5377a.f5386e.setEnabled(true);
                this.f5377a.f5386e.setAlpha(1.0f);
                al.m9287b(this.f5377a.f5386e);
                return;
            }
            this.f5377a.f5386e.setEnabled(false);
            this.f5377a.f5386e.setAlpha(0.8f);
        }
    }

    /* renamed from: com.tinder.fragments.u.2 */
    class C27222 implements OnEditorActionListener {
        final /* synthetic */ C2726u f5378a;

        C27222(C2726u c2726u) {
            this.f5378a = c2726u;
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (textView != this.f5378a.f5383b || i != 2) {
                return false;
            }
            C3095y.m9471a("ENTER KEY");
            this.f5378a.m7716b();
            return true;
        }
    }

    /* renamed from: com.tinder.fragments.u.3 */
    class C27233 implements br {
        final /* synthetic */ C2726u f5379a;

        C27233(C2726u c2726u) {
            this.f5379a = c2726u;
        }

        public void m7703a() {
            C3095y.m9469a();
            if (this.f5379a.getActivity() != null) {
                ((ActivityVerification) this.f5379a.getActivity()).m6284f();
                Toast.makeText(this.f5379a.getActivity(), String.format(this.f5379a.getResources().getString(R.string.code_sent), new Object[]{this.f5379a.f5382a}), 1).show();
            }
        }

        public void m7704b() {
            C3095y.m9469a();
            if (this.f5379a.getActivity() != null) {
                ((ActivityVerification) this.f5379a.getActivity()).m6284f();
                Toast.makeText(this.f5379a.getActivity(), R.string.error_fetching_code, 1).show();
            }
        }
    }

    /* renamed from: com.tinder.fragments.u.4 */
    class C27254 implements br {
        final /* synthetic */ C2726u f5381a;

        /* renamed from: com.tinder.fragments.u.4.1 */
        class C27241 implements Runnable {
            final /* synthetic */ C27254 f5380a;

            C27241(C27254 c27254) {
                this.f5380a = c27254;
            }

            public void run() {
                ((ActivityVerification) this.f5380a.f5381a.getActivity()).m6285g();
            }
        }

        C27254(C2726u c2726u) {
            this.f5381a = c2726u;
        }

        public void m7705a() {
            C3095y.m9469a();
            this.f5381a.f5384c.setVisibility(0);
            this.f5381a.f5384c.setImageResource(R.drawable.phoneverification_success_icon);
            if (this.f5381a.getActivity() != null) {
                ((ActivityVerification) this.f5381a.getActivity()).m6284f();
                int color = this.f5381a.getResources().getColor(R.color.green);
                this.f5381a.f5383b.setTextColor(color);
                this.f5381a.f5385d.setColorFilter(color);
                ((ActivityVerification) this.f5381a.getActivity()).m6279a(false);
                this.f5381a.f5383b.postDelayed(new C27241(this), 200);
                return;
            }
            C3095y.m9476b("Not doing shit, activity null");
        }

        public void m7706b() {
            C3095y.m9469a();
            this.f5381a.f5384c.setVisibility(0);
            this.f5381a.f5384c.setImageResource(R.drawable.phoneverification_error_icon);
            if (this.f5381a.getActivity() != null) {
                ((ActivityVerification) this.f5381a.getActivity()).m6284f();
                this.f5381a.f5383b.setTextColor(this.f5381a.getResources().getColor(R.color.text_dark));
                this.f5381a.f5385d.setColorFilter(null);
                Toast.makeText(this.f5381a.getActivity(), R.string.error_entering_code, 1).show();
                return;
            }
            C3095y.m9476b("Not doing shit, activity null");
        }
    }

    public void onCreate(Bundle bundle) {
        C3095y.m9471a("bundle=" + bundle);
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f5382a = arguments.getString("phone_number");
            C3095y.m9471a("mPhoneNumber=" + this.f5382a);
        }
        ((ActivityVerification) getActivity()).ab().setMenu(this);
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return layoutInflater.inflate(R.layout.view_verification_code, null);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f5383b = (EditText) view.findViewById(R.id.editText_code);
        this.f5384c = (ImageView) view.findViewById(R.id.imageView_validity_indicator);
        this.f5386e = (TextView) view.findViewById(R.id.textView_confirm);
        this.f5387f = (TextView) view.findViewById(R.id.textView_resend_code);
        this.f5385d = (ImageView) view.findViewById(R.id.edittext_code_underline);
        m7710c();
    }

    private void m7710c() {
        C3095y.m9469a();
        this.f5386e.setOnClickListener(this);
        this.f5387f.setOnClickListener(this);
        al.m9287b(this.f5386e);
        al.m9287b(this.f5387f);
        this.f5383b.addTextChangedListener(new C27211(this));
        this.f5383b.setOnEditorActionListener(new C27222(this));
    }

    private boolean m7712d() {
        return this.f5383b.getText().length() > 5;
    }

    public void m7715a() {
        C3095y.m9469a();
        ((ActivityVerification) getActivity()).m6283e();
        C2821b.m8121a(this.f5382a, new C27233(this));
    }

    public void m7716b() {
        C3095y.m9469a();
        String obj = this.f5383b.getText().toString();
        ((ActivityVerification) getActivity()).m6283e();
        C2821b.m8126b(obj, new C27254(this));
    }

    public void onMenuItemClick(int i) {
        C3095y.m9471a("resId=" + i);
        getActivity().onBackPressed();
    }

    public void onClick(@NonNull View view) {
        switch (view.getId()) {
            case R.id.item_text_centerLeft:
                getActivity().onBackPressed();
            case R.id.textView_resend_code:
                m7715a();
            case R.id.textView_confirm:
                m7716b();
            default:
        }
    }
}
