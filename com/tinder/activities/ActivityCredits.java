package com.tinder.activities;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Html;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tinder.R;

public class ActivityCredits extends Activity {
    private TextView f3758a;
    private TextView f3759b;
    private ScrollView f3760c;

    /* renamed from: com.tinder.activities.ActivityCredits.1 */
    class C22511 extends CountDownTimer {
        final /* synthetic */ ActivityCredits f3757a;

        C22511(ActivityCredits activityCredits, long j, long j2) {
            this.f3757a = activityCredits;
            super(j, j2);
        }

        public void onTick(long j) {
            this.f3757a.f3760c.scrollBy(0, 1);
        }

        public void onFinish() {
            if (VERSION.SDK_INT > 14) {
                this.f3757a.f3760c.setScrollY(0);
            }
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.view_credits);
        this.f3758a = (TextView) findViewById(R.id.textView_android_team);
        this.f3759b = (TextView) findViewById(R.id.textView_android_support);
        this.f3760c = (ScrollView) findViewById(R.id.scrollView_credits);
        m5962a();
    }

    public void m5962a() {
        this.f3758a.setText(Html.fromHtml("<br><b>Director of Android</b><br>Karim Varela<br><br><b>Android Developers</b><br>Paul Cafardo &<br>Jose \"King of the Jungle\" Pons Vega<br>Louis \"LTSmooth\" Tang <br>Matthew Runo<br><br><b>Android Designer</b><br>Mike Gottschalk<br><br><b>Android QA Lead</b><br>Rob Holsinger<br>"));
        this.f3759b.setText(Html.fromHtml("<br><b>Chief Executive Officer</b><br>Sean Rad<br><br><b>Chief Technical Officer</b><br>Ryan Ogle<br><br><b>Vice President, Engineering</b><br>Jonathan \"The Digital Pimp\" Badeen<br><br><b>Director of Quality Assurance</b><br>Justin Stefek<br><br><b>Director of Operations</b><br>Brandon Beveridge<br><br><b>Back-end Engineers</b><br>Gabe Lipson & Aaron Miller<br><br><b>Dev Ops Engineers</b><br>Patrick Albert, Brian Haney, & Tor Solli-Nowlan<br><br><b>Mascot</b><br>Coco the Dog"));
        new C22511(this, 40000, 25).start();
    }
}
