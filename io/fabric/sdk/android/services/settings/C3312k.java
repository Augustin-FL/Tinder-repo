package io.fabric.sdk.android.services.settings;

import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.tinder.views.RangeSeekBar;
import io.fabric.sdk.android.services.common.C3254j;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: io.fabric.sdk.android.services.settings.k */
class C3312k implements C3311u {
    C3312k() {
    }

    public C3322s m10125a(C3254j c3254j, JSONObject jSONObject) throws JSONException {
        int optInt = jSONObject.optInt("settings_version", 0);
        int optInt2 = jSONObject.optInt("cache_duration", 3600);
        return new C3322s(m10117a(c3254j, (long) optInt2, jSONObject), m10118a(jSONObject.getJSONObject("app")), m10122e(jSONObject.getJSONObject("session")), m10123f(jSONObject.getJSONObject("prompt")), m10120c(jSONObject.getJSONObject("features")), m10121d(jSONObject.getJSONObject("analytics")), m10124g(jSONObject.getJSONObject("beta")), optInt, optInt2);
    }

    private C3304e m10118a(JSONObject jSONObject) throws JSONException {
        String string = jSONObject.getString("identifier");
        String string2 = jSONObject.getString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
        String string3 = jSONObject.getString(NativeProtocol.WEB_DIALOG_URL);
        String string4 = jSONObject.getString("reports_url");
        boolean optBoolean = jSONObject.optBoolean("update_required", false);
        C3302c c3302c = null;
        if (jSONObject.has("icon") && jSONObject.getJSONObject("icon").has("hash")) {
            c3302c = m10119b(jSONObject.getJSONObject("icon"));
        }
        return new C3304e(string, string2, string3, string4, optBoolean, c3302c);
    }

    private C3302c m10119b(JSONObject jSONObject) throws JSONException {
        return new C3302c(jSONObject.getString("hash"), jSONObject.getInt("width"), jSONObject.getInt("height"));
    }

    private C3315m m10120c(JSONObject jSONObject) {
        return new C3315m(jSONObject.optBoolean("prompt_enabled", false), jSONObject.optBoolean("collect_logged_exceptions", true), jSONObject.optBoolean("collect_reports", true), jSONObject.optBoolean("collect_analytics", false));
    }

    private C3301b m10121d(JSONObject jSONObject) {
        return new C3301b(jSONObject.optString(NativeProtocol.WEB_DIALOG_URL, "https://e.crashlytics.com/spi/v2/events"), jSONObject.optInt("flush_interval_secs", 600), jSONObject.optInt("max_byte_size_per_file", 8000), jSONObject.optInt("max_file_count_per_send", 1), jSONObject.optInt("max_pending_send_file_count", 100), jSONObject.optBoolean("track_custom_events", true), jSONObject.optBoolean("track_predefined_events", true), jSONObject.optInt("sampling_rate", 1));
    }

    private C3318p m10122e(JSONObject jSONObject) throws JSONException {
        return new C3318p(jSONObject.optInt("log_buffer_size", 64000), jSONObject.optInt("max_chained_exception_depth", 8), jSONObject.optInt("max_custom_exception_events", 64), jSONObject.optInt("max_custom_key_value_pairs", 64), jSONObject.optInt("identifier_mask", RangeSeekBar.INVALID_POINTER_ID), jSONObject.optBoolean("send_session_without_crash", false));
    }

    private C3317o m10123f(JSONObject jSONObject) throws JSONException {
        return new C3317o(jSONObject.optString(ShareConstants.WEB_DIALOG_PARAM_TITLE, "Send Crash Report?"), jSONObject.optString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "Looks like we crashed! Please help us fix the problem by sending a crash report."), jSONObject.optString("send_button_title", "Send"), jSONObject.optBoolean("show_cancel_button", true), jSONObject.optString("cancel_button_title", "Don't Send"), jSONObject.optBoolean("show_always_send_button", true), jSONObject.optString("always_send_button_title", "Always Send"));
    }

    private C3305f m10124g(JSONObject jSONObject) throws JSONException {
        return new C3305f(jSONObject.optString("update_endpoint", C3323t.f7257a), jSONObject.optInt("update_suspend_duration", 3600));
    }

    private long m10117a(C3254j c3254j, long j, JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("expires_at")) {
            return jSONObject.getLong("expires_at");
        }
        return c3254j.m9935a() + (1000 * j);
    }
}
