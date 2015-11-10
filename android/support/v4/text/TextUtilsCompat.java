package android.support.v4.text;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.facebook.stetho.BuildConfig;
import com.viewpagerindicator.C3169d.C3168f;
import java.util.Locale;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class TextUtilsCompat {
    private static String ARAB_SCRIPT_SUBTAG;
    private static String HEBR_SCRIPT_SUBTAG;
    public static final Locale ROOT;

    @NonNull
    public static String htmlEncode(@NonNull String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            switch (charAt) {
                case C3168f.Theme_actionModePasteDrawable /*34*/:
                    stringBuilder.append("&quot;");
                    break;
                case C3168f.Theme_actionModeWebSearchDrawable /*38*/:
                    stringBuilder.append("&amp;");
                    break;
                case C3168f.Theme_actionModePopupWindowStyle /*39*/:
                    stringBuilder.append("&#39;");
                    break;
                case C3168f.Theme_popupMenuStyle /*60*/:
                    stringBuilder.append("&lt;");
                    break;
                case C3168f.Theme_editTextColor /*62*/:
                    stringBuilder.append("&gt;");
                    break;
                default:
                    stringBuilder.append(charAt);
                    break;
            }
        }
        return stringBuilder.toString();
    }

    public static int getLayoutDirectionFromLocale(@Nullable Locale locale) {
        if (!(locale == null || locale.equals(ROOT))) {
            String script = ICUCompat.getScript(ICUCompat.addLikelySubtags(locale.toString()));
            if (script == null) {
                return getLayoutDirectionFromFirstChar(locale);
            }
            if (script.equalsIgnoreCase(ARAB_SCRIPT_SUBTAG) || script.equalsIgnoreCase(HEBR_SCRIPT_SUBTAG)) {
                return 1;
            }
        }
        return 0;
    }

    private static int getLayoutDirectionFromFirstChar(Locale locale) {
        switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
            case C3374b.SmoothProgressBar_spb_color /*1*/:
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                return 1;
            default:
                return 0;
        }
    }

    static {
        ROOT = new Locale(BuildConfig.FLAVOR, BuildConfig.FLAVOR);
        ARAB_SCRIPT_SUBTAG = "Arab";
        HEBR_SCRIPT_SUBTAG = "Hebr";
    }
}
