package com.tinder.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tinder.R;
import com.tinder.enums.PhotoSizeUser;
import com.tinder.managers.ManagerApp;
import com.tinder.views.BaseScroller;
import com.tinder.views.PeekStack;
import com.tinder.views.RangeSeekBar;
import java.lang.ref.SoftReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class al {
    public static final boolean f6563a;
    private static final Hashtable<String, SoftReference<Typeface>> f6564b;
    @Nullable
    private static PhotoSizeUser f6565c;
    private static int f6566d;
    private static int f6567e;
    private static float f6568f;
    private static float f6569g;
    private static int f6570h;
    private static float f6571i;
    private static float f6572j;
    private static int f6573k;

    /* renamed from: com.tinder.utils.al.1 */
    static class C30531 implements OnTouchListener {
        final /* synthetic */ float f6561a;

        C30531(float f) {
            this.f6561a = f;
        }

        public boolean onTouch(@NonNull View view, @NonNull MotionEvent motionEvent) {
            switch (motionEvent.getActionMasked()) {
                case C3374b.SmoothProgressBar_spbStyle /*0*/:
                    view.setAlpha(this.f6561a);
                    break;
                case C3374b.SmoothProgressBar_spb_color /*1*/:
                case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                    view.setAlpha(1.0f);
                    break;
                default:
                    C3095y.m9471a("motion event not recognized");
                    break;
            }
            return false;
        }
    }

    /* renamed from: com.tinder.utils.al.a */
    public static class C3054a extends TouchDelegate {
        private final List<TouchDelegate> f6562a;

        public C3054a(@NonNull View view) {
            super(new Rect(), view);
            this.f6562a = new ArrayList();
        }

        public void m9258a(@Nullable TouchDelegate touchDelegate) {
            if (touchDelegate != null) {
                this.f6562a.add(touchDelegate);
            }
        }

        public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
            boolean z = false;
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            for (TouchDelegate touchDelegate : this.f6562a) {
                motionEvent.setLocation(x, y);
                z = touchDelegate.onTouchEvent(motionEvent);
                if (z) {
                    break;
                }
            }
            return z;
        }
    }

    static {
        boolean z;
        if (VERSION.SDK_INT >= 16) {
            z = true;
        } else {
            z = false;
        }
        f6563a = z;
        f6564b = new Hashtable();
        f6565c = null;
        f6570h = -1;
        f6573k = -1;
    }

    public static boolean m9278a(@NonNull View view, int i, int i2) {
        return m9279a(view, i, i2, 0, 0, 0, 0);
    }

    public static boolean m9279a(@NonNull View view, int i, int i2, int i3, int i4, int i5, int i6) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        if (i <= iArr[0] - i3 || i >= (iArr[0] + view.getWidth()) + i4 || i2 <= iArr[1] - i5 || i2 >= (iArr[1] + view.getHeight()) + i6) {
            return false;
        }
        return true;
    }

    @NonNull
    public static Point m9263a(@NonNull View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return new Point(iArr[0], iArr[1]);
    }

    @Nullable
    public static PhotoSizeUser m9265a(@NonNull Activity activity) {
        if (f6565c == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.densityDpi;
            if (i == 213 || i == 320 || i == 480 || i == 640 || activity.getResources().getBoolean(R.bool.isTablet)) {
                f6565c = PhotoSizeUser.LARGE;
            } else if (i == 120) {
                f6565c = PhotoSizeUser.SMALL;
            } else {
                f6565c = PhotoSizeUser.MED;
            }
        }
        return f6565c;
    }

    public static void m9274a(@NonNull ImageView imageView, float f) {
        if (f6563a) {
            imageView.setImageAlpha((int) C3077n.m9399a(f, 0.0f, 0.0f, 1.0f, 255.0f));
        } else {
            imageView.setAlpha(f);
        }
    }

    public static void m9266a(@NonNull Dialog dialog) {
        if (VERSION.SDK_INT <= 10) {
            LayoutParams attributes = dialog.getWindow().getAttributes();
            attributes.dimAmount = PeekStack.HEIGHT_PERCENT_OF_SCREEN;
            dialog.getWindow().setAttributes(attributes);
            dialog.getWindow().addFlags(2);
        }
    }

    public static void m9287b(@NonNull View view) {
        m9270a(view, 0.5f);
    }

    public static void m9270a(@NonNull View view, float f) {
        view.setOnTouchListener(new C30531(f));
    }

    public static boolean m9280a(View view, @NonNull Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Typeface a = m9264a(context, str);
            if (view instanceof TextView) {
                ((TextView) view).setTypeface(a);
            }
            return true;
        } catch (Exception e) {
            C3095y.m9485e("Could not get typeface: " + str);
            return false;
        }
    }

    public static Typeface m9264a(@NonNull Context context, String str) {
        Typeface typeface;
        synchronized (f6564b) {
            if (f6564b.get(str) != null) {
                SoftReference softReference = (SoftReference) f6564b.get(str);
                if (softReference.get() != null) {
                    typeface = (Typeface) softReference.get();
                }
            }
            typeface = Typeface.createFromAsset(context.getAssets(), "fonts/" + str);
            f6564b.put(str, new SoftReference(typeface));
        }
        return typeface;
    }

    @NonNull
    public static Point m9286b(@Nullable Activity activity) {
        Point point = new Point();
        if (activity != null) {
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            point.set(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        }
        return point;
    }

    public static void m9267a(@NonNull Context context, @Nullable View view) {
        if (view == null) {
            C3095y.m9476b("View is null, can't show keyboard");
            return;
        }
        view.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(view, 2);
        } else {
            C3095y.m9476b("inputMethodManager or view null, can't show keyboard");
        }
    }

    public static void m9295c(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
        IBinder windowToken = view.getWindowToken();
        if (inputMethodManager == null || windowToken == null) {
            C3095y.m9476b("inputMethodManager or view null, can't hide keyboard");
        } else {
            inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        }
    }

    public static void m9268a(@Nullable IBinder iBinder, @NonNull Activity activity) {
        C3095y.m9471a("windowToken=" + iBinder);
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager == null || iBinder == null) {
            C3095y.m9476b("inputMethodManager or view null, can't hide keyboard");
        } else {
            inputMethodManager.hideSoftInputFromWindow(iBinder, 0);
        }
    }

    public static void m9272a(@NonNull View view, boolean z) {
        C3095y.m9471a("view=" + view);
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    public static double m9259a(@NonNull MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (motionEvent.getPointerCount() == 0) {
            return Double.MIN_VALUE;
        }
        switch (actionMasked) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                f6570h = motionEvent.getPointerId(0);
                actionMasked = motionEvent.findPointerIndex(f6570h);
                f6568f = motionEvent.getX(actionMasked);
                f6569g = motionEvent.getY(actionMasked);
                return Double.MIN_VALUE;
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                f6570h = -1;
                return Double.MIN_VALUE;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                actionMasked = motionEvent.findPointerIndex(f6570h);
                if (actionMasked == -1) {
                    C3095y.m9479c("Invalid pointerId=" + f6570h + " in getMovementAngle");
                    return Double.MIN_VALUE;
                }
                float x = motionEvent.getX(actionMasked);
                return (Math.atan2((double) (f6569g - motionEvent.getY(actionMasked)), (double) (f6568f - x)) * 180.0d) / 3.141592653589793d;
            default:
                return Double.MIN_VALUE;
        }
    }

    public static boolean m9277a(@NonNull MotionEvent motionEvent, int i, int i2, int i3, boolean z, boolean z2) {
        double a = m9259a(motionEvent);
        switch (motionEvent.getActionMasked()) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                f6573k = motionEvent.getPointerId(0);
                int findPointerIndex = motionEvent.findPointerIndex(f6573k);
                f6571i = motionEvent.getX(findPointerIndex);
                f6572j = motionEvent.getY(findPointerIndex);
                a = Double.MIN_VALUE;
                break;
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                f6573k = -1;
                break;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                break;
        }
        if (a != Double.MIN_VALUE) {
            if (z) {
                a = Math.abs(a);
                i2 = Math.abs(i2);
                i3 = Math.abs(i3);
            }
            int findPointerIndex2 = motionEvent.findPointerIndex(f6573k);
            if (findPointerIndex2 == -1) {
                C3095y.m9479c("Invalid pointerId=" + f6573k + " in getMovementAngle");
                return false;
            }
            float x = motionEvent.getX(findPointerIndex2);
            x = f6571i - x;
            float y = f6572j - motionEvent.getY(findPointerIndex2);
            if (!z2) {
                y = x;
            }
            if (Math.abs(y) <= ((float) i) || r0 < ((double) r10) || r0 > ((double) r9)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static boolean m9291b(@NonNull MotionEvent motionEvent) {
        return m9277a(motionEvent, 0, (int) TransportMediator.KEYCODE_MEDIA_RECORD, 50, true, true);
    }

    public static boolean m9276a() {
        return VERSION.SDK_INT < 11;
    }

    public static boolean m9289b() {
        return VERSION.SDK_INT >= 16;
    }

    public static void m9288b(@NonNull View view, float f) {
        Animation alphaAnimation = new AlphaAnimation(view.getAlpha(), (float) Math.min(RangeSeekBar.INVALID_POINTER_ID, (int) (255.0f * f)));
        alphaAnimation.setDuration(0);
        alphaAnimation.setFillAfter(true);
        view.startAnimation(alphaAnimation);
    }

    public static void m9296c(@NonNull View view, float f) {
        view.setScaleX(f);
        view.setScaleY(f);
    }

    public static float m9261a(float f, @NonNull Context context) {
        return f / (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f);
    }

    public static float m9284b(float f, @NonNull Context context) {
        return (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f) * f;
    }

    public static int m9262a(@NonNull Context context) {
        if (f6566d == 0) {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            f6566d = displayMetrics.widthPixels;
        }
        return f6566d;
    }

    public static float m9260a(float f) {
        return ((float) m9262a(ManagerApp.m7917h())) * f;
    }

    public static float m9283b(float f) {
        return ((float) m9285b(ManagerApp.m7917h())) * f;
    }

    public static int m9292c() {
        return m9285b(ManagerApp.m7917h());
    }

    public static int m9285b(@NonNull Context context) {
        if (f6567e == 0) {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            f6567e = displayMetrics.heightPixels;
        }
        return f6567e;
    }

    public static int m9293c(@NonNull Activity activity) {
        if (m9300d(activity)) {
            return 0;
        }
        int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return activity.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int m9294c(@NonNull Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static boolean m9290b(@NonNull Dialog dialog) {
        return dialog != null && dialog.isShowing();
    }

    public static boolean m9282a(@NonNull Dialog... dialogArr) {
        boolean z = true;
        for (Dialog c : dialogArr) {
            if (m9297c(c) && z) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public static boolean m9297c(@Nullable Dialog dialog) {
        if (dialog == null || !dialog.isShowing()) {
            return false;
        }
        dialog.dismiss();
        return true;
    }

    private static boolean m9300d(@NonNull Activity activity) {
        int intValue;
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        try {
            intValue = ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
        } catch (Exception e) {
            C3095y.m9479c("exception=" + e.getMessage());
            intValue = 0;
        }
        if (intValue - defaultDisplay.getHeight() > 0) {
            return true;
        }
        return false;
    }

    @NonNull
    public static String m9298d(@NonNull Context context) {
        float f = context.getResources().getDisplayMetrics().density;
        if (((double) f) <= 0.75d) {
            return "ldpi";
        }
        if (f <= 1.0f) {
            return "mdpi";
        }
        if (((double) f) <= 1.5d) {
            return "hdpi";
        }
        if (((double) f) <= 2.0d) {
            return "xhdpi";
        }
        if (((double) f) <= 3.0d) {
            return "xxhdpi";
        }
        return "xxxhdpi";
    }

    public static boolean m9281a(@Nullable EditText editText) {
        return (editText == null || TextUtils.isEmpty(editText.getText().toString().trim())) ? false : true;
    }

    public static void m9269a(@NonNull ViewPager viewPager, int i) {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            Field declaredField2 = ViewPager.class.getDeclaredField("sInterpolator");
            declaredField2.setAccessible(true);
            BaseScroller baseScroller = new BaseScroller(viewPager.getContext(), (Interpolator) declaredField2.get(null));
            if (i > 0) {
                baseScroller.setDuration(i);
            }
            declaredField.set(viewPager, baseScroller);
        } catch (Throwable e) {
            C3095y.m9474a("Parent ViewPager implementation does not contain either mScroller or sInterpolator", e);
        } catch (Throwable e2) {
            C3095y.m9474a("Failed to set value of found variables, wrong data type", e2);
        } catch (Throwable e22) {
            C3095y.m9474a("Failed to set value of found variable", e22);
        }
    }

    public static void m9275a(@NonNull C3054a c3054a, @NonNull View view, int i, int i2, int i3, int i4) {
        Rect rect = new Rect();
        view.getHitRect(rect);
        rect.top -= i3;
        rect.bottom += i4;
        rect.left -= i;
        rect.right += i2;
        c3054a.m9258a(new TouchDelegate(rect, view));
    }

    public static void m9271a(@NonNull View view, Drawable drawable) {
        if (m9289b()) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static void m9273a(@NonNull Window window, @NonNull Context context, @NonNull View view) {
        int a = m9262a(context);
        int b = m9285b(context);
        LayoutParams attributes = window.getAttributes();
        attributes.width = a;
        attributes.height = b;
        window.setAttributes(attributes);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.addRule(14);
        view.setLayoutParams(layoutParams);
    }

    public static boolean m9299d() {
        return ("5.0.2".equals(VERSION.RELEASE) || "4.3".equals(VERSION.RELEASE) || "4.1.1".equals(VERSION.RELEASE) || "5.1.1".equals(VERSION.RELEASE)) ? false : true;
    }

    public static boolean m9301e() {
        return (!C3077n.m9412e() || "5.0.2".equals(VERSION.RELEASE) || "5.1.1".equals(VERSION.RELEASE)) ? false : true;
    }
}
