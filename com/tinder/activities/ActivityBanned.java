package com.tinder.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.internal.ServerProtocol;
import com.facebook.stetho.BuildConfig;
import com.tinder.R;
import com.tinder.managers.C2807a;
import com.tinder.managers.ManagerApp;
import com.tinder.model.SparksEvent;
import com.tinder.p030d.C2243y;

public class ActivityBanned extends Activity {

    /* renamed from: com.tinder.activities.ActivityBanned.1 */
    class C22451 implements OnClickListener {
        final /* synthetic */ ActivityBanned f3726a;

        /* renamed from: com.tinder.activities.ActivityBanned.1.1 */
        class C22441 implements C2243y {
            final /* synthetic */ C22451 f3725a;

            C22441(C22451 c22451) {
                this.f3725a = c22451;
            }

            public void m5936a() {
                Intent intent = new Intent(this.f3725a.f3726a, ActivityLogin.class);
                intent.setFlags(268435456);
                intent.putExtra("extra_show_intro", BuildConfig.FLAVOR);
                this.f3725a.f3726a.startActivity(intent);
                this.f3725a.f3726a.finish();
            }
        }

        C22451(ActivityBanned activityBanned) {
            this.f3726a = activityBanned;
        }

        public void onClick(View view) {
            SparksEvent sparksEvent = new SparksEvent("Warning.Logout");
            sparksEvent.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, Integer.valueOf(1));
            sparksEvent.put("banned", Boolean.valueOf(true));
            C2807a.m8056a(sparksEvent);
            ManagerApp.m7911b().m8135a(new C22441(this));
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_banned);
        ((TextView) findViewById(R.id.report_title)).setText(R.string.reporting_account_under_review_title);
        ((TextView) findViewById(R.id.report_details)).setText(R.string.reporting_account_under_review_details);
        findViewById(R.id.btn_divider).setVisibility(0);
        Button button = (Button) findViewById(R.id.btn_report_one);
        button.setText(getString(R.string.logout));
        button.setOnClickListener(new C22451(this));
        button.setVisibility(0);
        findViewById(R.id.addtional_info_container).setVisibility(8);
        findViewById(R.id.report_additional_info).setVisibility(8);
        findViewById(R.id.progress_other).setVisibility(8);
        findViewById(R.id.report_types_container).setVisibility(8);
        findViewById(R.id.report_unmatch_container).setVisibility(8);
        findViewById(R.id.report_report_frame).setVisibility(8);
        findViewById(R.id.report_unmatch_frame).setVisibility(8);
        findViewById(R.id.report_checkbox).setVisibility(8);
        findViewById(R.id.warning_beginning).setVisibility(8);
        findViewById(R.id.warning_middle).setVisibility(8);
        findViewById(R.id.warning_end).setVisibility(8);
        SparksEvent sparksEvent = new SparksEvent("Warning.View");
        sparksEvent.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, Integer.valueOf(1));
        sparksEvent.put("banned", Boolean.valueOf(true));
        C2807a.m8056a(sparksEvent);
    }
}
