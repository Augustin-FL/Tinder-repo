package com.mixpanel.android.surveys;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.facebook.stetho.BuildConfig;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.mixpanel.android.C1993a.C1988c;
import com.mixpanel.android.C1993a.C1989d;
import com.mixpanel.android.mpmetrics.Survey.C2006a;
import com.mixpanel.android.mpmetrics.Survey.QuestionType;
import java.util.ArrayList;
import java.util.List;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class CardCarouselLayout extends ViewGroup {
    private static int f2939a;
    private static float f2940b;
    private static float f2941c;
    private static float f2942d;
    private final List<View> f2943e;
    private C2058c f2944f;
    private C2058c f2945g;
    private C2054b f2946h;

    /* renamed from: com.mixpanel.android.surveys.CardCarouselLayout.1 */
    class C20511 implements AnimationListener {
        final /* synthetic */ View f2919a;
        final /* synthetic */ CardCarouselLayout f2920b;

        C20511(CardCarouselLayout cardCarouselLayout, View view) {
            this.f2920b = cardCarouselLayout;
            this.f2919a = view;
        }

        public void onAnimationEnd(Animation animation) {
            this.f2919a.setVisibility(8);
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: com.mixpanel.android.surveys.CardCarouselLayout.2 */
    static /* synthetic */ class C20522 {
        static final /* synthetic */ int[] f2921a;

        static {
            f2921a = new int[Direction.values().length];
            try {
                f2921a[Direction.FORWARD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2921a[Direction.BACKWARD.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public enum Direction {
        FORWARD,
        BACKWARD
    }

    public static class UnrecognizedAnswerTypeException extends Exception {
        private static final long serialVersionUID = -6040399928243560328L;

        private UnrecognizedAnswerTypeException(String str) {
            super(str);
        }
    }

    /* renamed from: com.mixpanel.android.surveys.CardCarouselLayout.a */
    private static class C2053a implements ListAdapter {
        private final List<String> f2925a;
        private final LayoutInflater f2926b;

        public /* synthetic */ Object getItem(int i) {
            return m4827a(i);
        }

        public C2053a(List<String> list, LayoutInflater layoutInflater) {
            this.f2925a = list;
            this.f2926b = layoutInflater;
        }

        public int getCount() {
            return this.f2925a.size();
        }

        public String m4827a(int i) {
            return (String) this.f2925a.get(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public int getItemViewType(int i) {
            if (i == 0) {
                return 0;
            }
            if (i == this.f2925a.size() - 1) {
                return 1;
            }
            return 2;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            int i2 = -1;
            if (view == null) {
                switch (getItemViewType(i)) {
                    case C3374b.SmoothProgressBar_spbStyle /*0*/:
                        i2 = C1989d.com_mixpanel_android_first_choice_answer;
                        break;
                    case C3374b.SmoothProgressBar_spb_color /*1*/:
                        i2 = C1989d.com_mixpanel_android_last_choice_answer;
                        break;
                    case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                        i2 = C1989d.com_mixpanel_android_middle_choice_answer;
                        break;
                }
                view = this.f2926b.inflate(i2, viewGroup, false);
            }
            ((TextView) view.findViewById(C1988c.com_mixpanel_android_multiple_choice_answer_text)).setText((String) this.f2925a.get(i));
            return view;
        }

        public int getViewTypeCount() {
            return 3;
        }

        public boolean hasStableIds() {
            return true;
        }

        public boolean isEmpty() {
            return this.f2925a.isEmpty();
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        }

        public boolean areAllItemsEnabled() {
            return true;
        }

        public boolean isEnabled(int i) {
            return true;
        }
    }

    /* renamed from: com.mixpanel.android.surveys.CardCarouselLayout.b */
    public interface C2054b {
        void m4828a(C2006a c2006a, String str);
    }

    /* renamed from: com.mixpanel.android.surveys.CardCarouselLayout.c */
    private class C2058c {
        final /* synthetic */ CardCarouselLayout f2933a;
        private C2006a f2934b;
        private final View f2935c;
        private final TextView f2936d;
        private final TextView f2937e;
        private final ListView f2938f;

        /* renamed from: com.mixpanel.android.surveys.CardCarouselLayout.c.1 */
        class C20551 implements OnEditorActionListener {
            final /* synthetic */ CardCarouselLayout f2927a;
            final /* synthetic */ C2058c f2928b;

            C20551(C2058c c2058c, CardCarouselLayout cardCarouselLayout) {
                this.f2928b = c2058c;
                this.f2927a = cardCarouselLayout;
            }

            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean z = keyEvent != null && keyEvent.getKeyCode() == 66 && keyEvent.getAction() == 0 && (keyEvent.getFlags() & 32) == 0;
                if (!z && i != 6) {
                    return false;
                }
                textView.clearComposingText();
                if (this.f2928b.f2933a.f2946h != null) {
                    this.f2928b.f2933a.f2946h.m4828a(this.f2928b.f2934b, textView.getText().toString());
                }
                return true;
            }
        }

        /* renamed from: com.mixpanel.android.surveys.CardCarouselLayout.c.2 */
        class C20572 implements OnItemClickListener {
            final /* synthetic */ CardCarouselLayout f2931a;
            final /* synthetic */ C2058c f2932b;

            /* renamed from: com.mixpanel.android.surveys.CardCarouselLayout.c.2.1 */
            class C20561 implements Runnable {
                final /* synthetic */ String f2929a;
                final /* synthetic */ C20572 f2930b;

                C20561(C20572 c20572, String str) {
                    this.f2930b = c20572;
                    this.f2929a = str;
                }

                public void run() {
                    this.f2930b.f2932b.f2933a.f2946h.m4828a(this.f2930b.f2932b.f2934b, this.f2929a);
                }
            }

            C20572(C2058c c2058c, CardCarouselLayout cardCarouselLayout) {
                this.f2932b = c2058c;
                this.f2931a = cardCarouselLayout;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.f2932b.f2933a.f2946h != null) {
                    this.f2932b.f2933a.postDelayed(new C20561(this, adapterView.getItemAtPosition(i).toString()), 165);
                }
            }
        }

        public C2058c(CardCarouselLayout cardCarouselLayout, View view) {
            this.f2933a = cardCarouselLayout;
            this.f2935c = view;
            this.f2936d = (TextView) view.findViewWithTag("com_mixpanel_android_TAG_prompt_text");
            this.f2937e = (EditText) view.findViewWithTag("com_mixpanel_android_TAG_text_answer");
            this.f2938f = (ListView) view.findViewWithTag("com_mixpanel_android_TAG_choice_list");
            this.f2937e.setText(BuildConfig.FLAVOR);
            this.f2937e.setOnEditorActionListener(new C20551(this, cardCarouselLayout));
            this.f2938f.setOnItemClickListener(new C20572(this, cardCarouselLayout));
        }

        public View m4830a() {
            return this.f2935c;
        }

        public void m4831a(C2006a c2006a, String str) throws UnrecognizedAnswerTypeException {
            this.f2934b = c2006a;
            this.f2936d.setText(this.f2934b.m4628b());
            InputMethodManager inputMethodManager = (InputMethodManager) this.f2935c.getContext().getSystemService("input_method");
            QuestionType d = c2006a.m4630d();
            if (QuestionType.TEXT == d) {
                this.f2938f.setVisibility(8);
                this.f2937e.setVisibility(0);
                if (str != null) {
                    this.f2937e.setText(str);
                }
                if (this.f2933a.getResources().getConfiguration().orientation == 1) {
                    this.f2937e.requestFocus();
                    inputMethodManager.showSoftInput(this.f2937e, 0);
                } else {
                    inputMethodManager.hideSoftInputFromWindow(this.f2935c.getWindowToken(), 0);
                }
            } else if (QuestionType.MULTIPLE_CHOICE == d) {
                inputMethodManager.hideSoftInputFromWindow(this.f2935c.getWindowToken(), 0);
                this.f2938f.setVisibility(0);
                this.f2937e.setVisibility(8);
                C2053a c2053a = new C2053a(c2006a.m4629c(), LayoutInflater.from(this.f2933a.getContext()));
                this.f2938f.setAdapter(c2053a);
                this.f2938f.clearChoices();
                if (str != null) {
                    for (int i = 0; i < c2053a.getCount(); i++) {
                        if (c2053a.m4827a(i).equals(str)) {
                            this.f2938f.setItemChecked(i, true);
                        }
                    }
                }
            } else {
                throw new UnrecognizedAnswerTypeException(null);
            }
            this.f2935c.invalidate();
        }
    }

    public CardCarouselLayout(Context context) {
        super(context);
        this.f2943e = new ArrayList(1);
        this.f2946h = null;
        m4834a(context);
    }

    public CardCarouselLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2943e = new ArrayList(1);
        this.f2946h = null;
        m4834a(context);
    }

    public CardCarouselLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2943e = new ArrayList(1);
        this.f2946h = null;
        m4834a(context);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void setOnQuestionAnsweredListener(C2054b c2054b) {
        this.f2946h = c2054b;
    }

    public void m4839a(C2006a c2006a, String str, Direction direction) throws UnrecognizedAnswerTypeException {
        Animation d;
        Animation animation = null;
        C2058c c2058c = this.f2945g;
        this.f2945g = this.f2944f;
        this.f2944f = c2058c;
        this.f2944f.m4831a(c2006a, str);
        View a = this.f2945g.m4830a();
        View a2 = this.f2944f.m4830a();
        a.setVisibility(0);
        a2.setVisibility(0);
        switch (C20522.f2921a[direction.ordinal()]) {
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                d = m4837d();
                animation = m4832a();
                break;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                d = m4835b();
                animation = m4836c();
                break;
            default:
                d = null;
                break;
        }
        d.setAnimationListener(new C20511(this, a));
        a.startAnimation(d);
        a2.startAnimation(animation);
        invalidate();
    }

    public void m4838a(C2006a c2006a, String str) throws UnrecognizedAnswerTypeException {
        this.f2944f.m4831a(c2006a, str);
        removeAllViews();
        addView(this.f2944f.m4830a());
        addView(this.f2945g.m4830a());
        invalidate();
    }

    protected void onMeasure(int i, int i2) {
        int childCount = getChildCount();
        int i3 = (MeasureSpec.getMode(i) == 1073741824 && MeasureSpec.getMode(i2) == 1073741824) ? 0 : 1;
        this.f2943e.clear();
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = childAt.getLayoutParams();
                childAt.measure(getChildMeasureSpec(i, 0, layoutParams.width), getChildMeasureSpec(i2, 0, layoutParams.height));
                i4 = Math.max(i4, childAt.getMeasuredWidth());
                i5 = Math.max(i5, childAt.getMeasuredHeight());
                if (i3 != 0 && (layoutParams.width == -1 || layoutParams.height == -1)) {
                    this.f2943e.add(childAt);
                }
            }
        }
        setMeasuredDimension(resolveSize(Math.max(i4, getSuggestedMinimumWidth()), i), resolveSize(Math.max(i5, getSuggestedMinimumHeight()), i2));
        for (View view : this.f2943e) {
            LayoutParams layoutParams2 = view.getLayoutParams();
            if (layoutParams2.width == -1) {
                i4 = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
            } else {
                i4 = getChildMeasureSpec(i, 0, layoutParams2.width);
            }
            if (layoutParams2.height == -1) {
                i5 = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
            } else {
                i5 = getChildMeasureSpec(i2, 0, layoutParams2.height);
            }
            view.measure(i4, i5);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        View a = this.f2944f.m4830a();
        if (a.getVisibility() != 8) {
            measuredWidth = a.getMeasuredWidth();
            a.layout(0, 0, measuredWidth, a.getMeasuredHeight());
        } else {
            measuredWidth = 0;
        }
        a = this.f2945g.m4830a();
        if (a.getVisibility() != 8) {
            a.layout(measuredWidth, 0, a.getMeasuredWidth() + measuredWidth, a.getMeasuredHeight());
        }
    }

    private void m4834a(Context context) {
        LayoutInflater from = LayoutInflater.from(context);
        View inflate = from.inflate(C1989d.com_mixpanel_android_question_card, this, false);
        this.f2944f = new C2058c(this, inflate);
        View inflate2 = from.inflate(C1989d.com_mixpanel_android_question_card, this, false);
        this.f2945g = new C2058c(this, inflate2);
        addView(inflate);
        addView(inflate2);
    }

    static {
        f2939a = 45;
        f2940b = 0.8f;
        f2941c = 0.5f;
        f2942d = 0.5f;
    }

    private Animation m4832a() {
        Animation animationSet = new AnimationSet(false);
        Animation rotateAnimation = new RotateAnimation((float) f2939a, 0.0f, 1, f2941c, 1, f2942d);
        rotateAnimation.setDuration(198);
        animationSet.addAnimation(rotateAnimation);
        rotateAnimation = new ScaleAnimation(f2940b, 1.0f, f2940b, 1.0f, 1, f2941c, 1, f2942d);
        rotateAnimation.setDuration(198);
        animationSet.addAnimation(rotateAnimation);
        rotateAnimation = new TranslateAnimation(2, 1.3f, 2, 0.0f, 2, 0.0f, 2, 0.0f);
        rotateAnimation.setDuration(330);
        animationSet.addAnimation(rotateAnimation);
        return animationSet;
    }

    private Animation m4835b() {
        Animation animationSet = new AnimationSet(false);
        Animation rotateAnimation = new RotateAnimation(0.0f, (float) f2939a, 1, f2941c, 1, f2942d);
        rotateAnimation.setDuration(198);
        rotateAnimation.setStartOffset(132);
        animationSet.addAnimation(rotateAnimation);
        rotateAnimation = new ScaleAnimation(1.0f, f2940b, 1.0f, f2940b, 1, f2941c, 1, f2942d);
        rotateAnimation.setDuration(198);
        rotateAnimation.setStartOffset(132);
        animationSet.addAnimation(rotateAnimation);
        rotateAnimation = new TranslateAnimation(2, GroundOverlayOptions.NO_DIMENSION, 2, 0.3f, 2, 0.0f, 2, 0.0f);
        rotateAnimation.setInterpolator(new AccelerateInterpolator());
        rotateAnimation.setDuration(330);
        animationSet.addAnimation(rotateAnimation);
        return animationSet;
    }

    private Animation m4836c() {
        Animation animationSet = new AnimationSet(false);
        Animation rotateAnimation = new RotateAnimation((float) (-f2939a), 0.0f, 1, f2941c, 1, f2942d);
        rotateAnimation.setDuration(198);
        animationSet.addAnimation(rotateAnimation);
        rotateAnimation = new ScaleAnimation(f2940b, 1.0f, f2940b, 1.0f, 1, f2941c, 1, f2942d);
        rotateAnimation.setDuration(198);
        animationSet.addAnimation(rotateAnimation);
        rotateAnimation = new TranslateAnimation(2, -1.3f, 2, 0.0f, 2, 0.0f, 2, 0.0f);
        rotateAnimation.setDuration(330);
        animationSet.addAnimation(rotateAnimation);
        return animationSet;
    }

    private Animation m4837d() {
        Animation animationSet = new AnimationSet(false);
        Animation rotateAnimation = new RotateAnimation(0.0f, (float) (-f2939a), 1, f2941c, 1, f2942d);
        rotateAnimation.setDuration(330);
        rotateAnimation.setStartOffset(132);
        animationSet.addAnimation(rotateAnimation);
        rotateAnimation = new ScaleAnimation(1.0f, f2940b, 1.0f, f2940b, 1, f2941c, 1, f2942d);
        rotateAnimation.setDuration(330);
        rotateAnimation.setStartOffset(132);
        animationSet.addAnimation(rotateAnimation);
        rotateAnimation = new TranslateAnimation(2, GroundOverlayOptions.NO_DIMENSION, 2, -2.3f, 2, 0.0f, 2, 0.0f);
        rotateAnimation.setInterpolator(new AccelerateInterpolator());
        rotateAnimation.setDuration(330);
        animationSet.addAnimation(rotateAnimation);
        return animationSet;
    }
}
