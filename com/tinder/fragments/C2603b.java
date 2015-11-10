package com.tinder.fragments;

import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tinder.R;
import com.tinder.activities.ActivityVerification;
import com.tinder.dialogs.C2486i;
import com.tinder.dialogs.C2489k;
import com.tinder.enums.Gender;
import com.tinder.managers.ManagerApp;
import com.tinder.p030d.af;
import com.tinder.p030d.bi;
import com.tinder.p030d.bq;
import com.tinder.utils.C3095y;
import com.tinder.utils.al;
import com.tinder.views.PeekStack;
import java.util.Calendar;
import java.util.Locale;

/* renamed from: com.tinder.fragments.b */
public class C2603b extends Fragment implements OnDateSetListener, OnClickListener, af, bi, bq {
    @NonNull
    public static String f4854a;
    private Button f4855b;
    private TextView f4856c;
    private TextView f4857d;
    private EditText f4858e;
    private TextView f4859f;
    private C2489k f4860g;
    private C2486i f4861h;
    private Gender f4862i;
    private long f4863j;
    private boolean f4864k;
    private boolean f4865l;

    static {
        f4854a = "fragment verifyGenderAge";
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.view_gender_age, null);
        this.f4855b = (Button) inflate.findViewById(R.id.btn_confirm);
        this.f4856c = (TextView) inflate.findViewById(R.id.txt_birthdate);
        this.f4857d = (TextView) inflate.findViewById(R.id.txt_gender);
        this.f4855b = (Button) inflate.findViewById(R.id.btn_confirm);
        this.f4859f = (TextView) inflate.findViewById(R.id.editText_gender);
        this.f4858e = (EditText) inflate.findViewById(R.id.editText_birthdate);
        return inflate;
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        m7153a(view);
    }

    private void m7153a(View view) {
        al.m9287b(this.f4855b);
        this.f4857d.setText(this.f4857d.getText() + ":");
        this.f4860g = new C2489k(getActivity(), this);
        this.f4861h = new C2486i(getActivity(), this);
        this.f4855b.setOnClickListener(this);
        al.m9287b(this.f4855b);
        this.f4858e.setOnClickListener(this);
        this.f4859f.setOnClickListener(this);
        this.f4857d.setOnClickListener(this);
        this.f4856c.setOnClickListener(this);
        Bundle arguments = getArguments();
        this.f4864k = arguments.getBoolean("is_age_verification_needed");
        this.f4865l = arguments.getBoolean("is_gender_verification_needed");
        if (!this.f4864k) {
            this.f4858e.setVisibility(8);
            this.f4856c.setVisibility(8);
            view.findViewById(R.id.birthdate_underline).setVisibility(8);
        }
        if (!this.f4865l) {
            this.f4859f.setVisibility(8);
            this.f4857d.setVisibility(8);
            view.findViewById(R.id.gender_underline).setVisibility(8);
        }
        this.f4863j = 0;
        m7156e();
    }

    private void m7154c() {
        if (m7155d()) {
            ManagerApp.m7922m().m8591a(this.f4862i, this.f4863j, (bq) this);
        }
    }

    private boolean m7155d() {
        if (this.f4864k && this.f4865l) {
            if (TextUtils.isEmpty(this.f4858e.getText()) || TextUtils.isEmpty(this.f4859f.getText())) {
                return false;
            }
            return true;
        } else if (this.f4864k) {
            if (TextUtils.isEmpty(this.f4858e.getText())) {
                return false;
            }
            return true;
        } else if (!this.f4865l) {
            return false;
        } else {
            if (TextUtils.isEmpty(this.f4859f.getText())) {
                return false;
            }
            return true;
        }
    }

    public void onClick(@NonNull View view) {
        switch (view.getId()) {
            case R.id.item_text_centerLeft:
                getActivity().onBackPressed();
            case R.id.btn_confirm:
                m7154c();
            case R.id.txt_birthdate:
            case R.id.editText_birthdate:
                this.f4861h.show();
            case R.id.txt_gender:
            case R.id.editText_gender:
                this.f4860g.show();
            default:
        }
    }

    private void m7156e() {
        if (m7155d()) {
            this.f4855b.setEnabled(true);
            this.f4855b.setAlpha(1.0f);
            return;
        }
        this.f4855b.setEnabled(false);
        this.f4855b.setAlpha(PeekStack.HEIGHT_PERCENT_OF_SCREEN);
    }

    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        Calendar instance = Calendar.getInstance(Locale.getDefault());
        instance.set(i, i2, i3);
        this.f4858e.setText(DateFormat.getLongDateFormat(getActivity()).format(instance.getTime()));
        C3095y.m9471a("Date set " + i + " " + i2);
        this.f4863j = instance.getTime().getTime();
        m7156e();
    }

    public void m7159a() {
        this.f4859f.setText(R.string.male);
        this.f4862i = Gender.MALE;
        m7156e();
    }

    public void m7160b() {
        this.f4859f.setText(R.string.female);
        this.f4862i = Gender.FEMALE;
        m7156e();
    }

    public void m7157E() {
        if (getActivity() != null) {
            ActivityVerification activityVerification = (ActivityVerification) getActivity();
            activityVerification.m6282c(false);
            activityVerification.m6281b(false);
            activityVerification.m6285g();
        }
    }

    public void m7158F() {
        if (getActivity() != null) {
            Toast.makeText(getActivity(), R.string.error_profile_info_update, 1).show();
        }
    }

    public void onMenuItemClick(int i) {
        getActivity().onBackPressed();
    }
}
