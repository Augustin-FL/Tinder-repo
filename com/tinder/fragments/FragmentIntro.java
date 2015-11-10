package com.tinder.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.text.Layout;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.tinder.R;
import com.tinder.adapters.C2385x;
import com.tinder.managers.ManagerApp;
import com.tinder.utils.C3095y;
import com.viewpagerindicator.CirclePageIndicator;

public class FragmentIntro extends Fragment {
    protected ViewPager f4747a;
    protected LoginButton f4748b;
    TextView f4749c;
    C2276b f4750d;
    C2275a f4751e;

    /* renamed from: com.tinder.fragments.FragmentIntro.a */
    public interface C2275a extends FacebookCallback<LoginResult> {
        void m6074d();

        @Nullable
        CallbackManager v_();
    }

    /* renamed from: com.tinder.fragments.FragmentIntro.b */
    public interface C2276b {
        void m6075p();

        void m6076q();
    }

    /* renamed from: com.tinder.fragments.FragmentIntro.1 */
    class C25681 implements OnClickListener {
        final /* synthetic */ FragmentIntro f4745a;

        C25681(FragmentIntro fragmentIntro) {
            this.f4745a = fragmentIntro;
        }

        public void onClick(View view) {
            if (this.f4745a.f4751e != null) {
                this.f4745a.f4751e.m6074d();
            }
            this.f4745a.f4748b.setLoginBehavior(ManagerApp.f5579b ? LoginBehavior.NATIVE_WITH_FALLBACK : LoginBehavior.WEB_ONLY);
            this.f4745a.f4748b.performClick();
        }
    }

    private static class TinderURLSpan extends URLSpan {
        public TinderURLSpan(String str) {
            super(str);
        }

        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(true);
        }
    }

    /* renamed from: com.tinder.fragments.FragmentIntro.c */
    private class C2569c extends LinkMovementMethod {
        final /* synthetic */ FragmentIntro f4746a;

        private C2569c(FragmentIntro fragmentIntro) {
            this.f4746a = fragmentIntro;
        }

        public boolean onTouchEvent(@NonNull TextView textView, @NonNull Spannable spannable, @NonNull MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                int x = (((int) motionEvent.getX()) - textView.getTotalPaddingLeft()) + textView.getScrollX();
                int y = (((int) motionEvent.getY()) - textView.getTotalPaddingTop()) + textView.getScrollY();
                Layout layout = textView.getLayout();
                x = layout.getOffsetForHorizontal(layout.getLineForVertical(y), (float) x);
                URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(x, x, URLSpan.class);
                if (uRLSpanArr.length != 0) {
                    String url = uRLSpanArr[0].getURL();
                    if (url.endsWith("#terms")) {
                        textView.clearFocus();
                        if (this.f4746a.f4750d != null) {
                            this.f4746a.f4750d.m6075p();
                            return true;
                        }
                    } else if (!url.endsWith("#privacy")) {
                        return false;
                    } else {
                        textView.clearFocus();
                        if (this.f4746a.f4750d != null) {
                            this.f4746a.f4750d.m6076q();
                        }
                    }
                    return true;
                }
            }
            return super.onTouchEvent(textView, spannable, motionEvent);
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof C2276b) {
            this.f4750d = (C2276b) activity;
        }
        if (activity instanceof C2275a) {
            this.f4751e = (C2275a) activity;
        }
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.view_intro, viewGroup, false);
        this.f4747a = (ViewPager) inflate.findViewById(R.id.viewPager_intro);
        CirclePageIndicator circlePageIndicator = (CirclePageIndicator) inflate.findViewById(R.id.intro_indicator);
        this.f4748b = (LoginButton) inflate.findViewById(R.id.button_facebook_login);
        this.f4748b.setReadPermissions(ManagerApp.m7912c().m8169e());
        this.f4748b.setFragment(this);
        this.f4749c = (TextView) inflate.findViewById(R.id.textView_terms_of_service_prompt);
        this.f4749c.setText(Html.fromHtml(getString(R.string.terms_and_privacy)));
        this.f4749c.setMovementMethod(new C2569c());
        this.f4749c.setHighlightColor(getResources().getColor(R.color.transparent));
        m7074a(this.f4749c);
        inflate.findViewById(R.id.button_login_real).setOnClickListener(new C25681(this));
        this.f4747a.setAdapter(new C2385x(getChildFragmentManager(), 4));
        circlePageIndicator.setFillColor(getResources().getColor(R.color.gray));
        circlePageIndicator.setPageColor(getResources().getColor(R.color.white));
        circlePageIndicator.setStrokeColor(getResources().getColor(R.color.gray));
        circlePageIndicator.setViewPager(this.f4747a);
        circlePageIndicator.setCurrentItem(0);
        m7075a();
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (this.f4751e != null) {
            this.f4748b.registerCallback(this.f4751e.v_(), this.f4751e);
        }
    }

    public void m7075a() {
        C3095y.m9469a();
    }

    private void m7074a(@NonNull TextView textView) {
        Spannable spannable = (Spannable) textView.getText();
        for (URLSpan uRLSpan : (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class)) {
            int spanStart = spannable.getSpanStart(uRLSpan);
            int spanEnd = spannable.getSpanEnd(uRLSpan);
            spannable.removeSpan(uRLSpan);
            spannable.setSpan(new TinderURLSpan(uRLSpan.getURL()), spanStart, spanEnd, 0);
        }
        textView.setText(spannable);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        CallbackManager v_ = this.f4751e.v_();
        if (v_ != null) {
            v_.onActivityResult(i, i2, intent);
        }
    }
}
