package com.mixpanel.android.surveys;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.stetho.BuildConfig;
import com.mixpanel.android.C1993a.C1986a;
import com.mixpanel.android.C1993a.C1987b;
import com.mixpanel.android.C1993a.C1988c;
import com.mixpanel.android.C1993a.C1989d;
import com.mixpanel.android.mpmetrics.C2031g;
import com.mixpanel.android.mpmetrics.C2042h;
import com.mixpanel.android.mpmetrics.C2042h.C2036b;
import com.mixpanel.android.mpmetrics.InAppNotification;
import com.mixpanel.android.mpmetrics.Survey;
import com.mixpanel.android.mpmetrics.Survey.C2006a;
import com.mixpanel.android.mpmetrics.UpdateDisplayState;
import com.mixpanel.android.mpmetrics.UpdateDisplayState.AnswerMap;
import com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState;
import com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.InAppNotificationState;
import com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.SurveyState;
import com.mixpanel.android.surveys.CardCarouselLayout.C2054b;
import com.mixpanel.android.surveys.CardCarouselLayout.Direction;
import com.mixpanel.android.surveys.CardCarouselLayout.UnrecognizedAnswerTypeException;
import com.tinder.views.PeekStack;
import com.tinder.views.RangeSeekBar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.json.JSONObject;

@SuppressLint({"ClickableViewAccessibility"})
@TargetApi(14)
public class SurveyActivity extends Activity {
    private static final int f2965k;
    private AlertDialog f2966a;
    private CardCarouselLayout f2967b;
    private C2042h f2968c;
    private View f2969d;
    private View f2970e;
    private TextView f2971f;
    private UpdateDisplayState f2972g;
    private boolean f2973h;
    private int f2974i;
    private int f2975j;

    /* renamed from: com.mixpanel.android.surveys.SurveyActivity.1 */
    class C20591 implements OnClickListener {
        final /* synthetic */ InAppNotification f2958a;
        final /* synthetic */ SurveyActivity f2959b;

        C20591(SurveyActivity surveyActivity, InAppNotification inAppNotification) {
            this.f2959b = surveyActivity;
            this.f2958a = inAppNotification;
        }

        public void onClick(View view) {
            String j = this.f2958a.m4611j();
            if (j != null && j.length() > 0) {
                try {
                    try {
                        this.f2959b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(j)));
                    } catch (ActivityNotFoundException e) {
                        Log.i("MixpanelAPI SurveyActivity", "User doesn't have an activity for notification URI");
                    }
                } catch (Throwable e2) {
                    Log.i("MixpanelAPI SurveyActivity", "Can't parse notification URI, will not take any action", e2);
                    return;
                }
            }
            this.f2959b.finish();
            UpdateDisplayState.m4659a(this.f2959b.f2975j);
        }
    }

    /* renamed from: com.mixpanel.android.surveys.SurveyActivity.2 */
    class C20602 implements OnTouchListener {
        final /* synthetic */ SurveyActivity f2960a;

        C20602(SurveyActivity surveyActivity) {
            this.f2960a = surveyActivity;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                view.setBackgroundResource(C1987b.com_mixpanel_android_cta_button_highlight);
            } else {
                view.setBackgroundResource(C1987b.com_mixpanel_android_cta_button);
            }
            return false;
        }
    }

    /* renamed from: com.mixpanel.android.surveys.SurveyActivity.3 */
    class C20613 implements OnClickListener {
        final /* synthetic */ SurveyActivity f2961a;

        C20613(SurveyActivity surveyActivity) {
            this.f2961a = surveyActivity;
        }

        public void onClick(View view) {
            this.f2961a.finish();
            UpdateDisplayState.m4659a(this.f2961a.f2975j);
        }
    }

    /* renamed from: com.mixpanel.android.surveys.SurveyActivity.4 */
    class C20624 implements C2054b {
        final /* synthetic */ SurveyActivity f2962a;

        C20624(SurveyActivity surveyActivity) {
            this.f2962a = surveyActivity;
        }

        public void m4842a(C2006a c2006a, String str) {
            this.f2962a.m4848a(c2006a, str);
            this.f2962a.goToNextQuestion();
        }
    }

    /* renamed from: com.mixpanel.android.surveys.SurveyActivity.5 */
    class C20635 implements DialogInterface.OnClickListener {
        final /* synthetic */ SurveyActivity f2963a;

        C20635(SurveyActivity surveyActivity) {
            this.f2963a = surveyActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f2963a.findViewById(C1988c.com_mixpanel_android_activity_survey_id).setVisibility(0);
            this.f2963a.f2973h = true;
            this.f2963a.m4845a(this.f2963a.f2974i);
        }
    }

    /* renamed from: com.mixpanel.android.surveys.SurveyActivity.6 */
    class C20646 implements DialogInterface.OnClickListener {
        final /* synthetic */ SurveyActivity f2964a;

        C20646(SurveyActivity surveyActivity) {
            this.f2964a = surveyActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f2964a.finish();
        }
    }

    public SurveyActivity() {
        this.f2973h = false;
        this.f2974i = 0;
        this.f2975j = -1;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2975j = getIntent().getIntExtra("com.mixpanel.android.surveys.SurveyActivity.INTENT_ID_KEY", ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.f2972g = UpdateDisplayState.m4660b(this.f2975j);
        if (this.f2972g == null) {
            Log.e("MixpanelAPI SurveyActivity", "SurveyActivity intent received, but nothing was found to show.");
            finish();
            return;
        }
        this.f2968c = C2042h.m4769a((Context) this, this.f2972g.m4664e());
        if (m4859e()) {
            m4846a(bundle);
        } else if (m4858d()) {
            m4853b(bundle);
        } else {
            finish();
        }
    }

    private void m4846a(Bundle bundle) {
        setContentView(C1989d.com_mixpanel_android_activity_notification_full);
        View view = (ImageView) findViewById(C1988c.com_mixpanel_android_notification_gradient);
        FadingImageView fadingImageView = (FadingImageView) findViewById(C1988c.com_mixpanel_android_notification_image);
        TextView textView = (TextView) findViewById(C1988c.com_mixpanel_android_notification_title);
        TextView textView2 = (TextView) findViewById(C1988c.com_mixpanel_android_notification_subtext);
        Button button = (Button) findViewById(C1988c.com_mixpanel_android_notification_button);
        LinearLayout linearLayout = (LinearLayout) findViewById(C1988c.com_mixpanel_android_button_exit_wrapper);
        InAppNotification c = ((InAppNotificationState) this.f2972g.m4662c()).m4648c();
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        if (getResources().getConfiguration().orientation == 1) {
            LayoutParams layoutParams = (LayoutParams) linearLayout.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, (int) (((float) point.y) * 0.06f));
            linearLayout.setLayoutParams(layoutParams);
        }
        Drawable gradientDrawable = new GradientDrawable(Orientation.LEFT_RIGHT, new int[]{-446668676, -448247715, -451405793, -451405793});
        gradientDrawable.setGradientType(1);
        if (getResources().getConfiguration().orientation == 2) {
            gradientDrawable.setGradientCenter(0.25f, 0.5f);
            gradientDrawable.setGradientRadius(((float) Math.min(point.x, point.y)) * 0.8f);
        } else {
            gradientDrawable.setGradientCenter(0.5f, 0.33f);
            gradientDrawable.setGradientRadius(((float) Math.min(point.x, point.y)) * PeekStack.HEIGHT_PERCENT_OF_SCREEN);
        }
        m4847a(view, gradientDrawable);
        textView.setText(c.m4606e());
        textView2.setText(c.m4607f());
        Bitmap k = c.m4612k();
        fadingImageView.setBackgroundResource(C1987b.com_mixpanel_android_square_dropshadow);
        if (k.getWidth() < 100 || k.getHeight() < 100) {
            fadingImageView.setBackgroundResource(C1987b.com_mixpanel_android_square_nodropshadow);
        } else if (Color.alpha(Bitmap.createScaledBitmap(k, 1, 1, false).getPixel(0, 0)) < RangeSeekBar.INVALID_POINTER_ID) {
            fadingImageView.setBackgroundResource(C1987b.com_mixpanel_android_square_nodropshadow);
        }
        fadingImageView.setImageBitmap(k);
        String j = c.m4611j();
        if (j != null && j.length() > 0) {
            button.setText(c.m4610i());
        }
        button.setOnClickListener(new C20591(this, c));
        button.setOnTouchListener(new C20602(this));
        linearLayout.setOnClickListener(new C20613(this));
        Animation scaleAnimation = new ScaleAnimation(0.95f, 1.0f, 0.95f, 1.0f, 1, 0.5f, 1, 1.0f);
        scaleAnimation.setDuration(200);
        fadingImageView.startAnimation(scaleAnimation);
        scaleAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.5f, 1, 0.0f);
        scaleAnimation.setInterpolator(new DecelerateInterpolator());
        scaleAnimation.setDuration(200);
        textView.startAnimation(scaleAnimation);
        textView2.startAnimation(scaleAnimation);
        button.startAnimation(scaleAnimation);
        linearLayout.startAnimation(AnimationUtils.loadAnimation(this, C1986a.com_mixpanel_android_fade_in));
    }

    private void m4853b(Bundle bundle) {
        m4861g();
        if (bundle != null) {
            this.f2974i = bundle.getInt("com.mixpanel.android.surveys.SurveyActivity.CURRENT_QUESTION_BUNDLE_KEY", 0);
            this.f2973h = bundle.getBoolean("com.mixpanel.android.surveys.SurveyActivity.SURVEY_BEGIN_BUNDLE_KEY");
        }
        if (this.f2972g.m4663d() == null) {
            Log.i("MixpanelAPI SurveyActivity", "Can't show a survey to a user with no distinct id set");
            finish();
            return;
        }
        setContentView(C1989d.com_mixpanel_android_activity_survey);
        Bitmap b = m4856c().m4654b();
        if (b == null) {
            findViewById(C1988c.com_mixpanel_android_activity_survey_id).setBackgroundColor(f2965k);
        } else {
            getWindow().setBackgroundDrawable(new BitmapDrawable(getResources(), b));
        }
        this.f2969d = findViewById(C1988c.com_mixpanel_android_button_previous);
        this.f2970e = findViewById(C1988c.com_mixpanel_android_button_next);
        this.f2971f = (TextView) findViewById(C1988c.com_mixpanel_android_progress_text);
        this.f2967b = (CardCarouselLayout) findViewById(C1988c.com_mixpanel_android_question_card_holder);
        this.f2967b.setOnQuestionAnsweredListener(new C20624(this));
    }

    protected void onStart() {
        super.onStart();
        DisplayState c = this.f2972g.m4662c();
        if (c != null && c.m4645a() == "SurveyState") {
            m4844a();
        }
    }

    private void m4844a() {
        if (!this.f2973h) {
            if (!C2031g.m4728a(this).m4734e()) {
                m4860f();
            }
            Builder builder = new Builder(this);
            builder.setTitle("We'd love your feedback!");
            builder.setMessage("Mind taking a quick survey?");
            builder.setPositiveButton("Sure", new C20635(this));
            builder.setNegativeButton("No, Thanks", new C20646(this));
            builder.setCancelable(false);
            this.f2966a = builder.create();
            this.f2966a.show();
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.f2966a != null) {
            this.f2966a.dismiss();
            this.f2966a = null;
        }
    }

    protected void onDestroy() {
        if (m4858d()) {
            m4852b();
        }
        super.onDestroy();
    }

    @SuppressLint({"SimpleDateFormat"})
    private void m4852b() {
        if (this.f2968c != null) {
            if (this.f2972g != null) {
                SurveyState c = m4856c();
                Survey d = c.m4656d();
                List<C2006a> d2 = d.m4634d();
                C2036b b = this.f2968c.m4788c().m4748b(this.f2972g.m4663d());
                b.m4747a("$responses", Integer.valueOf(d.m4633c()));
                AnswerMap c2 = c.m4655c();
                for (C2006a c2006a : d2) {
                    String a = c2.m4639a(Integer.valueOf(c2006a.m4627a()));
                    if (a != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("$survey_id", d.m4632b());
                            jSONObject.put("$collection_id", d.m4633c());
                            jSONObject.put("$question_id", c2006a.m4627a());
                            jSONObject.put("$question_type", c2006a.m4630d().toString());
                            DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                            jSONObject.put("$time", simpleDateFormat.format(new Date()));
                            jSONObject.put("$value", a);
                            b.m4747a("$answers", jSONObject);
                        } catch (Throwable e) {
                            Log.e("MixpanelAPI SurveyActivity", "Couldn't record user's answer.", e);
                        }
                    }
                }
            }
            this.f2968c.m4784a();
        }
        UpdateDisplayState.m4659a(this.f2975j);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (m4858d()) {
            m4857c(bundle);
        }
    }

    private void m4857c(Bundle bundle) {
        bundle.putBoolean("com.mixpanel.android.surveys.SurveyActivity.SURVEY_BEGIN_BUNDLE_KEY", this.f2973h);
        bundle.putInt("com.mixpanel.android.surveys.SurveyActivity.CURRENT_QUESTION_BUNDLE_KEY", this.f2974i);
        bundle.putParcelable("com.mixpanel.android.surveys.SurveyActivity.SURVEY_STATE_BUNDLE_KEY", this.f2972g);
    }

    public void onBackPressed() {
        if (!m4858d() || this.f2974i <= 0) {
            if (m4859e()) {
                UpdateDisplayState.m4659a(this.f2975j);
            }
            super.onBackPressed();
            return;
        }
        goToPreviousQuestion();
    }

    public void goToPreviousQuestion(View view) {
        goToPreviousQuestion();
    }

    public void goToNextQuestion(View view) {
        goToNextQuestion();
    }

    public void completeSurvey(View view) {
        completeSurvey();
    }

    private SurveyState m4856c() {
        return (SurveyState) this.f2972g.m4662c();
    }

    private boolean m4858d() {
        DisplayState c = this.f2972g.m4662c();
        return c != null && c.m4645a() == "SurveyState";
    }

    private boolean m4859e() {
        DisplayState c = this.f2972g.m4662c();
        return c != null && c.m4645a() == "InAppNotificationState";
    }

    private void m4860f() {
        Survey d = m4856c().m4656d();
        C2036b b = this.f2968c.m4788c().m4748b(this.f2972g.m4663d());
        b.m4747a("$surveys", Integer.valueOf(d.m4632b()));
        b.m4747a("$collections", Integer.valueOf(d.m4633c()));
    }

    private void goToPreviousQuestion() {
        if (this.f2974i > 0) {
            m4845a(this.f2974i - 1);
        } else {
            completeSurvey();
        }
    }

    private void goToNextQuestion() {
        if (this.f2974i < m4856c().m4656d().m4634d().size() - 1) {
            m4845a(this.f2974i + 1);
        } else {
            completeSurvey();
        }
    }

    private void m4845a(int i) {
        SurveyState c = m4856c();
        List d = c.m4656d().m4634d();
        if (i == 0 || d.size() == 0) {
            this.f2969d.setEnabled(false);
        } else {
            this.f2969d.setEnabled(true);
        }
        if (i >= d.size() - 1) {
            this.f2970e.setEnabled(false);
        } else {
            this.f2970e.setEnabled(true);
        }
        int i2 = this.f2974i;
        this.f2974i = i;
        C2006a c2006a = (C2006a) d.get(i);
        String a = c.m4655c().m4639a(Integer.valueOf(c2006a.m4627a()));
        if (i2 < i) {
            try {
                this.f2967b.m4839a(c2006a, a, Direction.FORWARD);
            } catch (UnrecognizedAnswerTypeException e) {
                goToNextQuestion();
                return;
            }
        } else if (i2 > i) {
            this.f2967b.m4839a(c2006a, a, Direction.BACKWARD);
        } else {
            this.f2967b.m4838a(c2006a, a);
        }
        if (d.size() > 1) {
            this.f2971f.setText(BuildConfig.FLAVOR + (i + 1) + " of " + d.size());
        } else {
            this.f2971f.setText(BuildConfig.FLAVOR);
        }
    }

    private void m4848a(C2006a c2006a, String str) {
        m4856c().m4655c().m4640a(Integer.valueOf(c2006a.m4627a()), str.toString());
    }

    @SuppressLint({"NewApi"})
    private void m4847a(View view, Drawable drawable) {
        if (VERSION.SDK_INT < 16) {
            view.setBackgroundDrawable(drawable);
        } else {
            view.setBackground(drawable);
        }
    }

    @SuppressLint({"NewApi"})
    private void m4861g() {
        if (VERSION.SDK_INT >= 18) {
            setRequestedOrientation(14);
            return;
        }
        int i = getResources().getConfiguration().orientation;
        if (i == 2) {
            setRequestedOrientation(0);
        } else if (i == 1) {
            setRequestedOrientation(1);
        }
    }

    private void completeSurvey() {
        finish();
    }

    static {
        f2965k = Color.argb(RangeSeekBar.INVALID_POINTER_ID, 90, 90, 90);
    }
}
