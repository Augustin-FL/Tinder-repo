package com.tinder.dialogs;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;
import com.facebook.internal.ServerProtocol;
import com.facebook.stetho.BuildConfig;
import com.tinder.R;
import com.tinder.managers.C2807a;
import com.tinder.managers.C2956n;
import com.tinder.managers.ManagerApp;
import com.tinder.model.SparksEvent;
import com.tinder.model.TinderReportNotification;
import com.tinder.p030d.C2426b;
import com.tinder.utils.C3095y;

public class ad extends ab {
    private TinderReportNotification f4416F;
    private Context f4417G;
    private C2515r f4418H;

    /* renamed from: com.tinder.dialogs.ad.1 */
    class C24561 implements OnCheckedChangeListener {
        final /* synthetic */ ad f4413a;

        C24561(ad adVar) {
            this.f4413a = adVar;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.f4413a.m6804a(z);
        }
    }

    /* renamed from: com.tinder.dialogs.ad.2 */
    class C24582 implements OnClickListener {
        final /* synthetic */ ad f4415a;

        /* renamed from: com.tinder.dialogs.ad.2.1 */
        class C24571 implements C2426b {
            final /* synthetic */ C24582 f4414a;

            C24571(C24582 c24582) {
                this.f4414a = c24582;
            }

            public void m6831a() {
                C3095y.m9471a("agree success");
                ManagerApp.m7911b().m8143d();
                this.f4414a.f4415a.f4418H.dismiss();
                this.f4414a.f4415a.dismiss();
            }

            public void m6832b() {
                C3095y.m9471a("agree failure");
                this.f4414a.f4415a.f4418H.dismiss();
                Toast.makeText(this.f4414a.f4415a.a, R.string.reported_warning_accept_agreement_error, 1).show();
            }
        }

        C24582(ad adVar) {
            this.f4415a = adVar;
        }

        public void onClick(View view) {
            if (this.f4415a.d.isChecked()) {
                this.f4415a.f4418H.show();
                SparksEvent sparksEvent = new SparksEvent("Warning.Acknowledge");
                sparksEvent.put("warningLevel", this.f4415a.f4416F.getTier());
                sparksEvent.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, Integer.valueOf(1));
                C2807a.m8056a(sparksEvent);
                ManagerApp.m7929t().m8748a(new C24571(this));
            }
        }
    }

    public ad(@NonNull Context context, TinderReportNotification tinderReportNotification) {
        super(context, 16973935);
        setCancelable(false);
        this.f4416F = tinderReportNotification;
        this.f4417G = context;
        m6834a(this.f4416F);
        this.f4418H = new C2515r(this.f4417G);
    }

    public void m6836m() {
        this.d.setText(R.string.reported_warning_agreement);
        this.f.setText(R.string.reported_warning_button);
        this.f.setVisibility(0);
        this.c.setVisibility(8);
        m6815l();
        m6806c();
        m6810g();
        m6808e();
        m6804a(false);
        this.d.setOnCheckedChangeListener(new C24561(this));
        this.f.setOnClickListener(new C24582(this));
    }

    private void m6834a(@NonNull TinderReportNotification tinderReportNotification) {
        String str = BuildConfig.FLAVOR;
        str = BuildConfig.FLAVOR;
        str = BuildConfig.FLAVOR;
        String str2 = "&#8226";
        Object obj = tinderReportNotification.getTier().intValue() > 0 ? 1 : null;
        this.b.setText(this.a.getString(obj != null ? R.string.reported_multiple_warnings_title : R.string.reported_warning_title));
        CharSequence string = this.a.getString(obj != null ? R.string.reported_multiple_warnings_details : R.string.reported_warning_details);
        CharSequence string2 = this.a.getString(obj != null ? R.string.reported_multiple_warnings_consequences : R.string.reported_warning_consequences);
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer num : tinderReportNotification.getReasons()) {
            if (stringBuilder.length() > 1) {
                stringBuilder.append("<br />");
            }
            StringBuilder append = new StringBuilder().append(str2).append(" ");
            ManagerApp.m7929t();
            stringBuilder.append(append.append(C2956n.m8746a(this.a, num.intValue())).toString());
        }
        str = stringBuilder.toString();
        this.C.setText(string);
        this.D.setText(Html.fromHtml(str));
        this.E.setText(string2);
    }

    public void show() {
        super.show();
        SparksEvent sparksEvent = new SparksEvent("Warning.View");
        sparksEvent.put("warningLevel", this.f4416F.getTier());
        sparksEvent.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, Integer.valueOf(1));
        C2807a.m8056a(sparksEvent);
    }
}
