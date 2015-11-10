package com.mixpanel.android.mpmetrics;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.login.widget.ToolTipPopup;
import com.mixpanel.android.C1993a.C1986a;
import com.mixpanel.android.C1993a.C1988c;
import com.mixpanel.android.C1993a.C1989d;
import com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.InAppNotificationState;

@SuppressLint({"ClickableViewAccessibility"})
@TargetApi(14)
/* renamed from: com.mixpanel.android.mpmetrics.f */
public class C2030f extends Fragment {
    private Activity f2845a;
    private GestureDetector f2846b;
    private Handler f2847c;
    private int f2848d;
    private InAppNotificationState f2849e;
    private Runnable f2850f;
    private Runnable f2851g;
    private View f2852h;
    private boolean f2853i;

    /* renamed from: com.mixpanel.android.mpmetrics.f.1 */
    class C20251 implements Runnable {
        final /* synthetic */ C2030f f2840a;

        C20251(C2030f c2030f) {
            this.f2840a = c2030f;
        }

        public void run() {
            this.f2840a.m4723b();
        }
    }

    /* renamed from: com.mixpanel.android.mpmetrics.f.2 */
    class C20272 implements Runnable {
        final /* synthetic */ C2030f f2842a;

        /* renamed from: com.mixpanel.android.mpmetrics.f.2.1 */
        class C20261 implements OnTouchListener {
            final /* synthetic */ C20272 f2841a;

            C20261(C20272 c20272) {
                this.f2841a = c20272;
            }

            public boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f2841a.f2842a.f2846b.onTouchEvent(motionEvent);
            }
        }

        C20272(C2030f c2030f) {
            this.f2842a = c2030f;
        }

        public void run() {
            this.f2842a.f2852h.setVisibility(0);
            this.f2842a.f2852h.setBackgroundColor(this.f2842a.f2849e.m4647b());
            this.f2842a.f2852h.setOnTouchListener(new C20261(this));
            ImageView imageView = (ImageView) this.f2842a.f2852h.findViewById(C1988c.com_mixpanel_android_notification_image);
            float applyDimension = TypedValue.applyDimension(1, 75.0f, this.f2842a.f2845a.getResources().getDisplayMetrics());
            Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, applyDimension, 0.0f);
            translateAnimation.setInterpolator(new DecelerateInterpolator());
            translateAnimation.setDuration(200);
            this.f2842a.f2852h.startAnimation(translateAnimation);
            translateAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, applyDimension / 2.0f, applyDimension / 2.0f);
            translateAnimation.setInterpolator(new C2029a(this.f2842a));
            translateAnimation.setDuration(400);
            translateAnimation.setStartOffset(200);
            imageView.startAnimation(translateAnimation);
        }
    }

    /* renamed from: com.mixpanel.android.mpmetrics.f.3 */
    class C20283 implements OnGestureListener {
        final /* synthetic */ C2030f f2843a;

        C20283(C2030f c2030f) {
            this.f2843a = c2030f;
        }

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (f2 > 0.0f) {
                this.f2843a.m4723b();
            }
            return true;
        }

        public void onLongPress(MotionEvent motionEvent) {
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return false;
        }

        public void onShowPress(MotionEvent motionEvent) {
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            String j = this.f2843a.f2849e.m4648c().m4611j();
            if (j != null && j.length() > 0) {
                try {
                    try {
                        this.f2843a.f2845a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(j)));
                    } catch (ActivityNotFoundException e) {
                        Log.i("InAppFragment", "User doesn't have an activity for notification URI");
                    }
                } catch (Throwable e2) {
                    Log.i("InAppFragment", "Can't parse notification URI, will not take any action", e2);
                }
            }
            this.f2843a.m4723b();
            return true;
        }
    }

    /* renamed from: com.mixpanel.android.mpmetrics.f.a */
    private class C2029a implements Interpolator {
        final /* synthetic */ C2030f f2844a;

        public C2029a(C2030f c2030f) {
            this.f2844a = c2030f;
        }

        public float getInterpolation(float f) {
            return ((float) (-(Math.pow(2.718281828459045d, (double) (-8.0f * f)) * Math.cos((double) (12.0f * f))))) + 1.0f;
        }
    }

    public void m4727a(int i, InAppNotificationState inAppNotificationState) {
        this.f2848d = i;
        this.f2849e = inAppNotificationState;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f2845a = activity;
        this.f2847c = new Handler();
        this.f2850f = new C20251(this);
        this.f2851g = new C20272(this);
        this.f2846b = new GestureDetector(activity, new C20283(this));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2853i = false;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        if (this.f2849e == null) {
            m4720a();
        } else {
            this.f2852h = layoutInflater.inflate(C1989d.com_mixpanel_android_activity_notification_mini, viewGroup, false);
            TextView textView = (TextView) this.f2852h.findViewById(C1988c.com_mixpanel_android_notification_title);
            ImageView imageView = (ImageView) this.f2852h.findViewById(C1988c.com_mixpanel_android_notification_image);
            InAppNotification c = this.f2849e.m4648c();
            textView.setText(c.m4606e());
            imageView.setImageBitmap(c.m4612k());
            this.f2847c.postDelayed(this.f2850f, ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME);
        }
        return this.f2852h;
    }

    public void onStart() {
        super.onStart();
        if (this.f2853i) {
            this.f2845a.getFragmentManager().beginTransaction().remove(this).commit();
        }
    }

    public void onResume() {
        super.onResume();
        this.f2847c.postDelayed(this.f2851g, 500);
    }

    public void onSaveInstanceState(Bundle bundle) {
        m4720a();
        super.onSaveInstanceState(bundle);
    }

    public void onPause() {
        super.onPause();
        m4720a();
    }

    private void m4720a() {
        if (!this.f2853i) {
            this.f2847c.removeCallbacks(this.f2850f);
            this.f2847c.removeCallbacks(this.f2851g);
            UpdateDisplayState.m4659a(this.f2848d);
            this.f2845a.getFragmentManager().beginTransaction().remove(this).commit();
        }
        this.f2853i = true;
    }

    private void m4723b() {
        if (this.f2845a != null && !this.f2853i) {
            this.f2847c.removeCallbacks(this.f2850f);
            this.f2847c.removeCallbacks(this.f2851g);
            this.f2845a.getFragmentManager().beginTransaction().setCustomAnimations(0, C1986a.com_mixpanel_android_slide_down).remove(this).commit();
            this.f2853i = true;
        }
    }
}
