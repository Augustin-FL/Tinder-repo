package android.support.v7.internal.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;
import android.support.v7.appcompat.C0159R;
import android.support.v7.internal.view.ContextThemeWrapper;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatMultiAutoCompleteTextView;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.View;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.lang.reflect.Constructor;
import java.util.Map;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class AppCompatViewInflater {
    private static final String LOG_TAG = "AppCompatViewInflater";
    private static final Map<String, Constructor<? extends View>> sConstructorMap;
    static final Class<?>[] sConstructorSignature;
    private final Object[] mConstructorArgs;

    public AppCompatViewInflater() {
        this.mConstructorArgs = new Object[2];
    }

    static {
        sConstructorSignature = new Class[]{Context.class, AttributeSet.class};
        sConstructorMap = new ArrayMap();
    }

    public final View createView(View view, String str, @NonNull Context context, @NonNull AttributeSet attributeSet, boolean z, boolean z2, boolean z3) {
        Context context2;
        if (!z || view == null) {
            context2 = context;
        } else {
            context2 = view.getContext();
        }
        if (z2 || z3) {
            context2 = themifyContext(context2, attributeSet, z2, z3);
        }
        Object obj = -1;
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    obj = 7;
                    break;
                }
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    obj = 4;
                    break;
                }
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    obj = 6;
                    break;
                }
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    obj = 9;
                    break;
                }
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    obj = 1;
                    break;
                }
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    obj = 3;
                    break;
                }
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    obj = 5;
                    break;
                }
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    obj = 2;
                    break;
                }
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    obj = null;
                    break;
                }
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    obj = 8;
                    break;
                }
                break;
        }
        switch (obj) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                return new AppCompatEditText(context2, attributeSet);
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                return new AppCompatSpinner(context2, attributeSet);
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                return new AppCompatCheckBox(context2, attributeSet);
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                return new AppCompatRadioButton(context2, attributeSet);
            case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                return new AppCompatCheckedTextView(context2, attributeSet);
            case C3374b.SmoothProgressBar_spb_speed /*5*/:
                return new AppCompatAutoCompleteTextView(context2, attributeSet);
            case C3374b.SmoothProgressBar_spb_progressiveStart_speed /*6*/:
                return new AppCompatMultiAutoCompleteTextView(context2, attributeSet);
            case C3374b.SmoothProgressBar_spb_progressiveStop_speed /*7*/:
                return new AppCompatRatingBar(context2, attributeSet);
            case C3374b.SmoothProgressBar_spb_interpolator /*8*/:
                return new AppCompatButton(context2, attributeSet);
            case C3374b.SmoothProgressBar_spb_reversed /*9*/:
                return new AppCompatTextView(context2, attributeSet);
            default:
                if (context != context2) {
                    return createViewFromTag(context2, str, attributeSet);
                }
                return null;
        }
    }

    private View createViewFromTag(Context context, String str, AttributeSet attributeSet) {
        if (str.equals(Promotion.ACTION_VIEW)) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            this.mConstructorArgs[0] = context;
            this.mConstructorArgs[1] = attributeSet;
            View createView;
            if (-1 == str.indexOf(46)) {
                createView = createView(context, str, "android.widget.");
                return createView;
            }
            createView = createView(context, str, null);
            this.mConstructorArgs[0] = null;
            this.mConstructorArgs[1] = null;
            return createView;
        } catch (Exception e) {
            return null;
        } finally {
            this.mConstructorArgs[0] = null;
            this.mConstructorArgs[1] = null;
        }
    }

    private View createView(Context context, String str, String str2) throws ClassNotFoundException, InflateException {
        Constructor constructor = (Constructor) sConstructorMap.get(str);
        if (constructor == null) {
            try {
                constructor = context.getClassLoader().loadClass(str2 != null ? str2 + str : str).asSubclass(View.class).getConstructor(sConstructorSignature);
                sConstructorMap.put(str, constructor);
            } catch (Exception e) {
                return null;
            }
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.mConstructorArgs);
    }

    private static Context themifyContext(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        int resourceId;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0159R.styleable.View, 0, 0);
        if (z) {
            resourceId = obtainStyledAttributes.getResourceId(C0159R.styleable.View_android_theme, 0);
        } else {
            resourceId = 0;
        }
        if (z2 && r0 == 0) {
            resourceId = obtainStyledAttributes.getResourceId(C0159R.styleable.View_theme, 0);
            if (resourceId != 0) {
                Log.i(LOG_TAG, "app:theme is now deprecated. Please move to using android:theme instead.");
            }
        }
        int i = resourceId;
        obtainStyledAttributes.recycle();
        if (i == 0) {
            return context;
        }
        if ((context instanceof ContextThemeWrapper) && ((ContextThemeWrapper) context).getThemeResId() == i) {
            return context;
        }
        return new ContextThemeWrapper(context, i);
    }
}
