package com.tinder.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.stetho.BuildConfig;
import com.google.i18n.phonenumbers.C1981a;
import com.google.i18n.phonenumbers.C1983c;
import com.tinder.R;
import com.tinder.activities.ActivityVerification;
import com.tinder.managers.C2821b;
import com.tinder.p030d.af;
import com.tinder.p030d.br;
import com.tinder.utils.C3094x;
import com.tinder.utils.C3095y;
import com.tinder.utils.al;
import java.util.Locale;

/* renamed from: com.tinder.fragments.w */
public class C2731w extends Fragment implements OnClickListener, af, br {
    public TextView f5393a;
    public EditText f5394b;
    public TextView f5395c;
    @Nullable
    private String f5396d;
    @Nullable
    private String f5397e;
    @Nullable
    private String f5398f;
    @Nullable
    private String f5399g;
    private C1983c f5400h;
    private C1981a f5401i;
    private boolean f5402j;
    private int f5403k;
    private int f5404l;

    /* renamed from: com.tinder.fragments.w.1 */
    class C27291 implements OnEditorActionListener {
        final /* synthetic */ C2731w f5391a;

        C27291(C2731w c2731w) {
            this.f5391a = c2731w;
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (textView != this.f5391a.f5394b || i != 2) {
                return false;
            }
            this.f5391a.f5395c.performClick();
            return true;
        }
    }

    /* renamed from: com.tinder.fragments.w.2 */
    class C27302 implements TextWatcher {
        final /* synthetic */ C2731w f5392a;

        C27302(C2731w c2731w) {
            this.f5392a = c2731w;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(@NonNull Editable editable) {
            C3095y.m9471a(editable.toString());
            if (this.f5392a.f5402j) {
                this.f5392a.f5402j = false;
            } else {
                CharSequence a;
                String obj = editable.toString();
                C3095y.m9471a("enteredNumber=" + obj);
                String a2 = this.f5392a.m7727b(obj);
                this.f5392a.f5403k = a2.length();
                if (this.f5392a.f5403k > this.f5392a.f5404l) {
                    a = this.f5392a.f5401i.m4560a(obj.charAt(obj.length() - 1));
                } else {
                    this.f5392a.f5401i.m4561a();
                    a = this.f5392a.m7721a(a2);
                }
                this.f5392a.f5404l = this.f5392a.f5403k;
                C3095y.m9471a("formattedNumber=" + a);
                this.f5392a.f5402j = true;
                this.f5392a.f5394b.setText(a);
            }
            this.f5392a.f5394b.setSelection(this.f5392a.f5394b.getText().length());
        }
    }

    public C2731w() {
        this.f5399g = AppEventsConstants.EVENT_PARAM_VALUE_YES;
    }

    public void onCreate(Bundle bundle) {
        C3095y.m9471a("bundle=" + bundle);
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f5396d = arguments.getString("country_name");
            this.f5399g = arguments.getString("country_code");
            C3095y.m9471a("mCountryName=" + this.f5396d + ", mCountryCode=" + this.f5399g);
        }
        ((ActivityVerification) getActivity()).ab().setMenu(this);
        this.f5400h = C1983c.m4565a();
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return layoutInflater.inflate(R.layout.view_verification_phone, null);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f5395c = (TextView) view.findViewById(R.id.textView_request_code);
        this.f5394b = (EditText) view.findViewById(R.id.editText_phone);
        this.f5393a = (TextView) view.findViewById(R.id.textView_country);
        this.f5395c.setOnClickListener(this);
        al.m9287b(this.f5395c);
        m7730d();
    }

    public void onPause() {
        super.onPause();
        ((ActivityVerification) getActivity()).m6280b(m7727b(this.f5394b.getText().toString()));
    }

    private void m7730d() {
        C3095y.m9469a();
        if (this.f5396d == null || TextUtils.isEmpty(this.f5399g)) {
            this.f5396d = Locale.getDefault().getDisplayCountry();
            this.f5397e = Locale.getDefault().getCountry();
            C3095y.m9471a("mCountryName=" + this.f5396d + ", mRegionCode=" + this.f5397e);
            try {
                this.f5399g = C3094x.m9464a(getActivity());
            } catch (NumberFormatException e) {
                this.f5396d = Locale.US.getDisplayCountry();
                this.f5399g = AppEventsConstants.EVENT_PARAM_VALUE_YES;
                this.f5397e = "US";
                C3095y.m9479c(String.valueOf(e));
            }
        }
        if (this.f5397e == null) {
            this.f5397e = this.f5400h.m4575b(Integer.parseInt(this.f5399g));
        }
        C3095y.m9471a("mCountryName=" + this.f5396d + ", mRegionCode=" + this.f5397e + ", mcountryCode=" + this.f5399g);
        this.f5401i = this.f5400h.m4577d(this.f5397e);
        this.f5393a.setText(this.f5396d + " (+" + this.f5399g + ")");
        String h = ((ActivityVerification) getActivity()).m6286h();
        if (h == null) {
            String c = C3094x.m9467c(getActivity());
            ((ActivityVerification) getActivity()).m6280b(c);
            h = c;
        }
        this.f5404l = h.length();
        this.f5394b.setOnEditorActionListener(new C27291(this));
        this.f5394b.addTextChangedListener(new C27302(this));
        if (h != null && !h.equals(BuildConfig.FLAVOR) && !h.equals("0000000000")) {
            this.f5402j = true;
            this.f5394b.setText(m7721a(h));
        }
    }

    @Nullable
    private String m7721a(@NonNull String str) {
        C3095y.m9471a("unformattedPhoneNumber=" + str);
        String str2 = null;
        for (int i = 0; i < str.length(); i++) {
            str2 = this.f5401i.m4560a(str.charAt(i));
        }
        C3095y.m9471a("formattedNumber=" + str2);
        return str2;
    }

    public void m7733c() {
        C3095y.m9469a();
        String b = m7727b(this.f5394b.getText().toString());
        if (C3094x.m9465a(b)) {
            this.f5398f = "+" + this.f5399g + b;
            C2821b.m8121a(this.f5398f, (br) this);
            ((ActivityVerification) getActivity()).m6283e();
            return;
        }
        Toast.makeText(getActivity(), R.string.error_invalid_phone, 1).show();
    }

    private String m7727b(@NonNull String str) {
        return str.replace(" ", BuildConfig.FLAVOR).replace("-", BuildConfig.FLAVOR).replace("(", BuildConfig.FLAVOR).replace(")", BuildConfig.FLAVOR);
    }

    public void m7731a() {
        C3095y.m9469a();
        if (getActivity() != null) {
            ((ActivityVerification) getActivity()).m6284f();
            ((ActivityVerification) getActivity()).m6277a(this.f5398f);
        }
    }

    public void m7732b() {
        C3095y.m9469a();
        if (getActivity() != null) {
            ((ActivityVerification) getActivity()).m6284f();
            Toast.makeText(getActivity(), R.string.error_fetching_code, 1).show();
        }
    }

    public void onMenuItemClick(int i) {
        C3095y.m9471a("resId=" + i);
        getActivity().onBackPressed();
    }

    public void onClick(@NonNull View view) {
        C3095y.m9471a("view=" + view);
        switch (view.getId()) {
            case R.id.item_text_centerLeft:
                getActivity().onBackPressed();
            case R.id.textView_request_code:
                m7733c();
            default:
        }
    }
}
