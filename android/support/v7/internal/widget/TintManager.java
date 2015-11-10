package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.ColorUtils;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.LruCache;
import android.support.v7.appcompat.C0159R;
import android.util.SparseArray;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class TintManager {
    private static final int[] COLORFILTER_COLOR_BACKGROUND_MULTIPLY;
    private static final int[] COLORFILTER_COLOR_CONTROL_ACTIVATED;
    private static final int[] COLORFILTER_TINT_COLOR_CONTROL_NORMAL;
    private static final ColorFilterLruCache COLOR_FILTER_CACHE;
    private static final boolean DEBUG = false;
    private static final Mode DEFAULT_MODE;
    private static final WeakHashMap<Context, TintManager> INSTANCE_CACHE;
    public static final boolean SHOULD_BE_USED;
    private static final String TAG = "TintManager";
    private static final int[] TINT_CHECKABLE_BUTTON_LIST;
    private static final int[] TINT_COLOR_CONTROL_NORMAL;
    private static final int[] TINT_COLOR_CONTROL_STATE_LIST;
    private final WeakReference<Context> mContextRef;
    private ColorStateList mDefaultColorStateList;
    private SparseArray<ColorStateList> mTintLists;

    private static class ColorFilterLruCache extends LruCache<Integer, PorterDuffColorFilter> {
        public ColorFilterLruCache(int i) {
            super(i);
        }

        PorterDuffColorFilter get(int i, Mode mode) {
            return (PorterDuffColorFilter) get(Integer.valueOf(generateCacheKey(i, mode)));
        }

        PorterDuffColorFilter put(int i, Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) put(Integer.valueOf(generateCacheKey(i, mode)), porterDuffColorFilter);
        }

        private static int generateCacheKey(int i, Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }
    }

    static {
        SHOULD_BE_USED = VERSION.SDK_INT < 21 ? true : SHOULD_BE_USED;
        DEFAULT_MODE = Mode.SRC_IN;
        INSTANCE_CACHE = new WeakHashMap();
        COLOR_FILTER_CACHE = new ColorFilterLruCache(6);
        COLORFILTER_TINT_COLOR_CONTROL_NORMAL = new int[]{C0159R.drawable.abc_textfield_search_default_mtrl_alpha, C0159R.drawable.abc_textfield_default_mtrl_alpha, C0159R.drawable.abc_ab_share_pack_mtrl_alpha};
        TINT_COLOR_CONTROL_NORMAL = new int[]{C0159R.drawable.abc_ic_ab_back_mtrl_am_alpha, C0159R.drawable.abc_ic_go_search_api_mtrl_alpha, C0159R.drawable.abc_ic_search_api_mtrl_alpha, C0159R.drawable.abc_ic_commit_search_api_mtrl_alpha, C0159R.drawable.abc_ic_clear_mtrl_alpha, C0159R.drawable.abc_ic_menu_share_mtrl_alpha, C0159R.drawable.abc_ic_menu_copy_mtrl_am_alpha, C0159R.drawable.abc_ic_menu_cut_mtrl_alpha, C0159R.drawable.abc_ic_menu_selectall_mtrl_alpha, C0159R.drawable.abc_ic_menu_paste_mtrl_am_alpha, C0159R.drawable.abc_ic_menu_moreoverflow_mtrl_alpha, C0159R.drawable.abc_ic_voice_search_api_mtrl_alpha};
        COLORFILTER_COLOR_CONTROL_ACTIVATED = new int[]{C0159R.drawable.abc_textfield_activated_mtrl_alpha, C0159R.drawable.abc_textfield_search_activated_mtrl_alpha, C0159R.drawable.abc_cab_background_top_mtrl_alpha, C0159R.drawable.abc_text_cursor_mtrl_alpha};
        COLORFILTER_COLOR_BACKGROUND_MULTIPLY = new int[]{C0159R.drawable.abc_popup_background_mtrl_mult, C0159R.drawable.abc_cab_background_internal_bg, C0159R.drawable.abc_menu_hardkey_panel_mtrl_mult};
        TINT_COLOR_CONTROL_STATE_LIST = new int[]{C0159R.drawable.abc_edit_text_material, C0159R.drawable.abc_tab_indicator_material, C0159R.drawable.abc_textfield_search_material, C0159R.drawable.abc_spinner_mtrl_am_alpha, C0159R.drawable.abc_spinner_textfield_background_material, C0159R.drawable.abc_ratingbar_full_material, C0159R.drawable.abc_switch_track_mtrl_alpha, C0159R.drawable.abc_switch_thumb_material, C0159R.drawable.abc_btn_default_mtrl_shape, C0159R.drawable.abc_btn_borderless_material};
        TINT_CHECKABLE_BUTTON_LIST = new int[]{C0159R.drawable.abc_btn_check_material, C0159R.drawable.abc_btn_radio_material};
    }

    public static Drawable getDrawable(Context context, int i) {
        if (isInTintList(i)) {
            return get(context).getDrawable(i);
        }
        return ContextCompat.getDrawable(context, i);
    }

    public static TintManager get(Context context) {
        TintManager tintManager = (TintManager) INSTANCE_CACHE.get(context);
        if (tintManager != null) {
            return tintManager;
        }
        tintManager = new TintManager(context);
        INSTANCE_CACHE.put(context, tintManager);
        return tintManager;
    }

    private TintManager(Context context) {
        this.mContextRef = new WeakReference(context);
    }

    public Drawable getDrawable(int i) {
        return getDrawable(i, (boolean) SHOULD_BE_USED);
    }

    public Drawable getDrawable(int i, boolean z) {
        Context context = (Context) this.mContextRef.get();
        if (context == null) {
            return null;
        }
        Drawable drawable = ContextCompat.getDrawable(context, i);
        if (drawable != null) {
            if (VERSION.SDK_INT >= 8) {
                drawable = drawable.mutate();
            }
            ColorStateList tintList = getTintList(i);
            if (tintList != null) {
                drawable = DrawableCompat.wrap(drawable);
                DrawableCompat.setTintList(drawable, tintList);
                Mode tintMode = getTintMode(i);
                if (tintMode != null) {
                    DrawableCompat.setTintMode(drawable, tintMode);
                }
            } else if (i == C0159R.drawable.abc_cab_background_top_material) {
                return new LayerDrawable(new Drawable[]{getDrawable(C0159R.drawable.abc_cab_background_internal_bg), getDrawable(C0159R.drawable.abc_cab_background_top_mtrl_alpha)});
            } else if (!tintDrawableUsingColorFilter(i, drawable) && z) {
                drawable = null;
            }
        }
        return drawable;
    }

    public final boolean tintDrawableUsingColorFilter(int i, Drawable drawable) {
        Context context = (Context) this.mContextRef.get();
        if (context == null) {
            return SHOULD_BE_USED;
        }
        int i2;
        Mode mode;
        Object obj;
        int i3;
        if (arrayContains(COLORFILTER_TINT_COLOR_CONTROL_NORMAL, i)) {
            i2 = C0159R.attr.colorControlNormal;
            mode = null;
            obj = 1;
            i3 = -1;
        } else if (arrayContains(COLORFILTER_COLOR_CONTROL_ACTIVATED, i)) {
            i2 = C0159R.attr.colorControlActivated;
            mode = null;
            r6 = 1;
            i3 = -1;
        } else if (arrayContains(COLORFILTER_COLOR_BACKGROUND_MULTIPLY, i)) {
            r6 = 1;
            mode = Mode.MULTIPLY;
            i2 = 16842801;
            i3 = -1;
        } else if (i == C0159R.drawable.abc_list_divider_mtrl_alpha) {
            i2 = 16842800;
            i3 = Math.round(40.8f);
            mode = null;
            r6 = 1;
        } else {
            i3 = -1;
            i2 = 0;
            mode = null;
            obj = null;
        }
        if (obj == null) {
            return SHOULD_BE_USED;
        }
        setPorterDuffColorFilter(drawable, ThemeUtils.getThemeAttrColor(context, i2), mode);
        if (i3 != -1) {
            drawable.setAlpha(i3);
        }
        return true;
    }

    private static boolean arrayContains(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return SHOULD_BE_USED;
    }

    private static boolean isInTintList(int i) {
        return (arrayContains(TINT_COLOR_CONTROL_NORMAL, i) || arrayContains(COLORFILTER_TINT_COLOR_CONTROL_NORMAL, i) || arrayContains(COLORFILTER_COLOR_CONTROL_ACTIVATED, i) || arrayContains(TINT_COLOR_CONTROL_STATE_LIST, i) || arrayContains(COLORFILTER_COLOR_BACKGROUND_MULTIPLY, i) || arrayContains(TINT_CHECKABLE_BUTTON_LIST, i) || i == C0159R.drawable.abc_cab_background_top_material) ? true : SHOULD_BE_USED;
    }

    final Mode getTintMode(int i) {
        if (i == C0159R.drawable.abc_switch_thumb_material) {
            return Mode.MULTIPLY;
        }
        return null;
    }

    public final ColorStateList getTintList(int i) {
        ColorStateList colorStateList = null;
        Context context = (Context) this.mContextRef.get();
        if (context == null) {
            return null;
        }
        if (this.mTintLists != null) {
            colorStateList = (ColorStateList) this.mTintLists.get(i);
        }
        if (colorStateList != null) {
            return colorStateList;
        }
        ColorStateList createEditTextColorStateList = i == C0159R.drawable.abc_edit_text_material ? createEditTextColorStateList(context) : i == C0159R.drawable.abc_switch_track_mtrl_alpha ? createSwitchTrackColorStateList(context) : i == C0159R.drawable.abc_switch_thumb_material ? createSwitchThumbColorStateList(context) : (i == C0159R.drawable.abc_btn_default_mtrl_shape || i == C0159R.drawable.abc_btn_borderless_material) ? createButtonColorStateList(context) : (i == C0159R.drawable.abc_spinner_mtrl_am_alpha || i == C0159R.drawable.abc_spinner_textfield_background_material) ? createSpinnerColorStateList(context) : arrayContains(TINT_COLOR_CONTROL_NORMAL, i) ? ThemeUtils.getThemeAttrColorStateList(context, C0159R.attr.colorControlNormal) : arrayContains(TINT_COLOR_CONTROL_STATE_LIST, i) ? getDefaultColorStateList(context) : arrayContains(TINT_CHECKABLE_BUTTON_LIST, i) ? createCheckableButtonColorStateList(context) : colorStateList;
        if (createEditTextColorStateList == null) {
            return createEditTextColorStateList;
        }
        if (this.mTintLists == null) {
            this.mTintLists = new SparseArray();
        }
        this.mTintLists.append(i, createEditTextColorStateList);
        return createEditTextColorStateList;
    }

    private ColorStateList getDefaultColorStateList(Context context) {
        if (this.mDefaultColorStateList == null) {
            int themeAttrColor = ThemeUtils.getThemeAttrColor(context, C0159R.attr.colorControlNormal);
            int themeAttrColor2 = ThemeUtils.getThemeAttrColor(context, C0159R.attr.colorControlActivated);
            r2 = new int[7][];
            int[] iArr = new int[]{ThemeUtils.DISABLED_STATE_SET, ThemeUtils.getDisabledThemeAttrColor(context, C0159R.attr.colorControlNormal), ThemeUtils.FOCUSED_STATE_SET, themeAttrColor2, ThemeUtils.ACTIVATED_STATE_SET, themeAttrColor2, ThemeUtils.PRESSED_STATE_SET};
            iArr[3] = themeAttrColor2;
            r2[4] = ThemeUtils.CHECKED_STATE_SET;
            iArr[4] = themeAttrColor2;
            r2[5] = ThemeUtils.SELECTED_STATE_SET;
            iArr[5] = themeAttrColor2;
            r2[6] = ThemeUtils.EMPTY_STATE_SET;
            iArr[6] = themeAttrColor;
            this.mDefaultColorStateList = new ColorStateList(r2, iArr);
        }
        return this.mDefaultColorStateList;
    }

    private ColorStateList createCheckableButtonColorStateList(Context context) {
        r0 = new int[3][];
        int[] iArr = new int[]{ThemeUtils.DISABLED_STATE_SET, ThemeUtils.getDisabledThemeAttrColor(context, C0159R.attr.colorControlNormal), ThemeUtils.CHECKED_STATE_SET};
        iArr[1] = ThemeUtils.getThemeAttrColor(context, C0159R.attr.colorControlActivated);
        r0[2] = ThemeUtils.EMPTY_STATE_SET;
        iArr[2] = ThemeUtils.getThemeAttrColor(context, C0159R.attr.colorControlNormal);
        return new ColorStateList(r0, iArr);
    }

    private ColorStateList createSwitchTrackColorStateList(Context context) {
        r0 = new int[3][];
        int[] iArr = new int[]{ThemeUtils.DISABLED_STATE_SET, ThemeUtils.getThemeAttrColor(context, 16842800, 0.1f), ThemeUtils.CHECKED_STATE_SET};
        iArr[1] = ThemeUtils.getThemeAttrColor(context, C0159R.attr.colorControlActivated, 0.3f);
        r0[2] = ThemeUtils.EMPTY_STATE_SET;
        iArr[2] = ThemeUtils.getThemeAttrColor(context, 16842800, 0.3f);
        return new ColorStateList(r0, iArr);
    }

    private ColorStateList createSwitchThumbColorStateList(Context context) {
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList themeAttrColorStateList = ThemeUtils.getThemeAttrColorStateList(context, C0159R.attr.colorSwitchThumbNormal);
        if (themeAttrColorStateList == null || !themeAttrColorStateList.isStateful()) {
            iArr[0] = ThemeUtils.DISABLED_STATE_SET;
            iArr2[0] = ThemeUtils.getDisabledThemeAttrColor(context, C0159R.attr.colorSwitchThumbNormal);
            iArr[1] = ThemeUtils.CHECKED_STATE_SET;
            iArr2[1] = ThemeUtils.getThemeAttrColor(context, C0159R.attr.colorControlActivated);
            iArr[2] = ThemeUtils.EMPTY_STATE_SET;
            iArr2[2] = ThemeUtils.getThemeAttrColor(context, C0159R.attr.colorSwitchThumbNormal);
        } else {
            iArr[0] = ThemeUtils.DISABLED_STATE_SET;
            iArr2[0] = themeAttrColorStateList.getColorForState(iArr[0], 0);
            iArr[1] = ThemeUtils.CHECKED_STATE_SET;
            iArr2[1] = ThemeUtils.getThemeAttrColor(context, C0159R.attr.colorControlActivated);
            iArr[2] = ThemeUtils.EMPTY_STATE_SET;
            iArr2[2] = themeAttrColorStateList.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    private ColorStateList createEditTextColorStateList(Context context) {
        r0 = new int[3][];
        int[] iArr = new int[]{ThemeUtils.DISABLED_STATE_SET, ThemeUtils.getDisabledThemeAttrColor(context, C0159R.attr.colorControlNormal), ThemeUtils.NOT_PRESSED_OR_FOCUSED_STATE_SET};
        iArr[1] = ThemeUtils.getThemeAttrColor(context, C0159R.attr.colorControlNormal);
        r0[2] = ThemeUtils.EMPTY_STATE_SET;
        iArr[2] = ThemeUtils.getThemeAttrColor(context, C0159R.attr.colorControlActivated);
        return new ColorStateList(r0, iArr);
    }

    private ColorStateList createButtonColorStateList(Context context) {
        r0 = new int[4][];
        r1 = new int[4];
        int themeAttrColor = ThemeUtils.getThemeAttrColor(context, C0159R.attr.colorButtonNormal);
        int themeAttrColor2 = ThemeUtils.getThemeAttrColor(context, C0159R.attr.colorControlHighlight);
        r0[0] = ThemeUtils.DISABLED_STATE_SET;
        r1[0] = ThemeUtils.getDisabledThemeAttrColor(context, C0159R.attr.colorButtonNormal);
        r0[1] = ThemeUtils.PRESSED_STATE_SET;
        r1[1] = ColorUtils.compositeColors(themeAttrColor2, themeAttrColor);
        r0[2] = ThemeUtils.FOCUSED_STATE_SET;
        r1[2] = ColorUtils.compositeColors(themeAttrColor2, themeAttrColor);
        r0[3] = ThemeUtils.EMPTY_STATE_SET;
        r1[3] = themeAttrColor;
        return new ColorStateList(r0, r1);
    }

    private ColorStateList createSpinnerColorStateList(Context context) {
        r0 = new int[3][];
        int[] iArr = new int[]{ThemeUtils.DISABLED_STATE_SET, ThemeUtils.getDisabledThemeAttrColor(context, C0159R.attr.colorControlNormal), ThemeUtils.NOT_PRESSED_OR_FOCUSED_STATE_SET};
        iArr[1] = ThemeUtils.getThemeAttrColor(context, C0159R.attr.colorControlNormal);
        r0[2] = ThemeUtils.EMPTY_STATE_SET;
        iArr[2] = ThemeUtils.getThemeAttrColor(context, C0159R.attr.colorControlActivated);
        return new ColorStateList(r0, iArr);
    }

    public static void tintViewBackground(View view, TintInfo tintInfo) {
        Drawable background = view.getBackground();
        if (tintInfo.mHasTintList) {
            setPorterDuffColorFilter(background, tintInfo.mTintList.getColorForState(view.getDrawableState(), tintInfo.mTintList.getDefaultColor()), tintInfo.mHasTintMode ? tintInfo.mTintMode : null);
        } else {
            background.clearColorFilter();
        }
        if (VERSION.SDK_INT <= 10) {
            view.invalidate();
        }
    }

    private static void setPorterDuffColorFilter(Drawable drawable, int i, Mode mode) {
        if (mode == null) {
            mode = DEFAULT_MODE;
        }
        ColorFilter colorFilter = COLOR_FILTER_CACHE.get(i, mode);
        if (colorFilter == null) {
            colorFilter = new PorterDuffColorFilter(i, mode);
            COLOR_FILTER_CACHE.put(i, mode, colorFilter);
        }
        drawable.setColorFilter(colorFilter);
    }
}
