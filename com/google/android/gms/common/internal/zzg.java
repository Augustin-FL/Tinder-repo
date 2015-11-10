package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import com.google.android.gms.C0708R;
import com.google.android.gms.internal.zzlp;
import com.viewpagerindicator.C3169d.C3168f;
import org.apache.http.util.LangUtils;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public final class zzg {
    public static String zzb(Context context, int i, String str) {
        Resources resources = context.getResources();
        switch (i) {
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                if (zzlp.zzb(resources)) {
                    return resources.getString(C0708R.string.common_google_play_services_install_text_tablet, new Object[]{str});
                }
                return resources.getString(C0708R.string.common_google_play_services_install_text_phone, new Object[]{str});
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                return resources.getString(C0708R.string.common_google_play_services_update_text, new Object[]{str});
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                return resources.getString(C0708R.string.common_google_play_services_enable_text, new Object[]{str});
            case C3374b.SmoothProgressBar_spb_speed /*5*/:
                return resources.getString(C0708R.string.common_google_play_services_invalid_account_text);
            case C3374b.SmoothProgressBar_spb_progressiveStop_speed /*7*/:
                return resources.getString(C0708R.string.common_google_play_services_network_error_text);
            case C3374b.SmoothProgressBar_spb_reversed /*9*/:
                return resources.getString(C0708R.string.common_google_play_services_unsupported_text, new Object[]{str});
            case C3168f.Toolbar_maxButtonHeight /*16*/:
                return resources.getString(C0708R.string.common_google_play_services_api_unavailable_text, new Object[]{str});
            case LangUtils.HASH_SEED /*17*/:
                return resources.getString(C0708R.string.common_google_play_services_sign_in_failed_text);
            case C3168f.Toolbar_collapseContentDescription /*18*/:
                return resources.getString(C0708R.string.common_google_play_services_updating_text, new Object[]{str});
            case C3168f.Theme_dialogTheme /*42*/:
                return resources.getString(C0708R.string.common_android_wear_update_text, new Object[]{str});
            default:
                return resources.getString(C0708R.string.common_google_play_services_unknown_issue);
        }
    }

    public static String zzc(Context context, int i, String str) {
        Resources resources = context.getResources();
        switch (i) {
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                if (zzlp.zzb(resources)) {
                    return resources.getString(C0708R.string.common_google_play_services_install_text_tablet, new Object[]{str});
                }
                return resources.getString(C0708R.string.common_google_play_services_install_text_phone, new Object[]{str});
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                return resources.getString(C0708R.string.common_google_play_services_update_text, new Object[]{str});
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                return resources.getString(C0708R.string.common_google_play_services_enable_text, new Object[]{str});
            case C3374b.SmoothProgressBar_spb_speed /*5*/:
                return resources.getString(C0708R.string.common_google_play_services_invalid_account_text);
            case C3374b.SmoothProgressBar_spb_progressiveStop_speed /*7*/:
                return resources.getString(C0708R.string.common_google_play_services_network_error_text);
            case C3374b.SmoothProgressBar_spb_reversed /*9*/:
                return resources.getString(C0708R.string.common_google_play_services_unsupported_text, new Object[]{str});
            case C3168f.Toolbar_maxButtonHeight /*16*/:
                return resources.getString(C0708R.string.common_google_play_services_api_unavailable_text, new Object[]{str});
            case LangUtils.HASH_SEED /*17*/:
                return resources.getString(C0708R.string.common_google_play_services_sign_in_failed_text);
            case C3168f.Toolbar_collapseContentDescription /*18*/:
                return resources.getString(C0708R.string.common_google_play_services_updating_text, new Object[]{str});
            case C3168f.Theme_dialogTheme /*42*/:
                return resources.getString(C0708R.string.common_android_wear_notification_needs_update_text, new Object[]{str});
            default:
                return resources.getString(C0708R.string.common_google_play_services_unknown_issue);
        }
    }

    public static final String zzg(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                return resources.getString(C0708R.string.common_google_play_services_install_title);
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                return resources.getString(C0708R.string.common_google_play_services_update_title);
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                return resources.getString(C0708R.string.common_google_play_services_enable_title);
            case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
            case C3374b.SmoothProgressBar_spb_progressiveStart_speed /*6*/:
                return null;
            case C3374b.SmoothProgressBar_spb_speed /*5*/:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return resources.getString(C0708R.string.common_google_play_services_invalid_account_title);
            case C3374b.SmoothProgressBar_spb_progressiveStop_speed /*7*/:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return resources.getString(C0708R.string.common_google_play_services_network_error_title);
            case C3374b.SmoothProgressBar_spb_interpolator /*8*/:
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                return null;
            case C3374b.SmoothProgressBar_spb_reversed /*9*/:
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return resources.getString(C0708R.string.common_google_play_services_unsupported_title);
            case C3374b.SmoothProgressBar_spb_mirror_mode /*10*/:
                Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                return null;
            case C3374b.SmoothProgressBar_spb_colors /*11*/:
                Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                return null;
            case C3168f.Toolbar_maxButtonHeight /*16*/:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            case LangUtils.HASH_SEED /*17*/:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return resources.getString(C0708R.string.common_google_play_services_sign_in_failed_title);
            case C3168f.Toolbar_collapseContentDescription /*18*/:
                return resources.getString(C0708R.string.common_google_play_services_updating_title);
            case C3168f.Theme_dialogTheme /*42*/:
                return resources.getString(C0708R.string.common_android_wear_update_title);
            default:
                Log.e("GoogleApiAvailability", "Unexpected error code " + i);
                return null;
        }
    }

    public static String zzh(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                return resources.getString(C0708R.string.common_google_play_services_install_button);
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
            case C3168f.Theme_dialogTheme /*42*/:
                return resources.getString(C0708R.string.common_google_play_services_update_button);
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                return resources.getString(C0708R.string.common_google_play_services_enable_button);
            default:
                return resources.getString(17039370);
        }
    }

    public static final String zzi(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                return resources.getString(C0708R.string.common_google_play_services_install_title);
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                return resources.getString(C0708R.string.common_google_play_services_update_title);
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                return resources.getString(C0708R.string.common_google_play_services_enable_title);
            case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
            case C3374b.SmoothProgressBar_spb_progressiveStart_speed /*6*/:
                return null;
            case C3374b.SmoothProgressBar_spb_speed /*5*/:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return resources.getString(C0708R.string.common_google_play_services_invalid_account_title);
            case C3374b.SmoothProgressBar_spb_progressiveStop_speed /*7*/:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return resources.getString(C0708R.string.common_google_play_services_network_error_title);
            case C3374b.SmoothProgressBar_spb_interpolator /*8*/:
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                return null;
            case C3374b.SmoothProgressBar_spb_reversed /*9*/:
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return resources.getString(C0708R.string.common_google_play_services_unsupported_title);
            case C3374b.SmoothProgressBar_spb_mirror_mode /*10*/:
                Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                return null;
            case C3374b.SmoothProgressBar_spb_colors /*11*/:
                Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                return null;
            case C3168f.Toolbar_maxButtonHeight /*16*/:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            case LangUtils.HASH_SEED /*17*/:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return resources.getString(C0708R.string.common_google_play_services_sign_in_failed_title);
            case C3168f.Toolbar_collapseContentDescription /*18*/:
                return resources.getString(C0708R.string.common_google_play_services_updating_title);
            case C3168f.Theme_dialogTheme /*42*/:
                return resources.getString(C0708R.string.common_android_wear_update_title);
            default:
                Log.e("GoogleApiAvailability", "Unexpected error code " + i);
                return null;
        }
    }
}
