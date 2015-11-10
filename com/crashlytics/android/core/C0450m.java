package com.crashlytics.android.core;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.settings.C3317o;

/* renamed from: com.crashlytics.android.core.m */
class C0450m {
    private final Context f629a;
    private final C3317o f630b;

    public C0450m(Context context, C3317o c3317o) {
        this.f629a = context;
        this.f630b = c3317o;
    }

    public String m789a() {
        return m786a("com.crashlytics.CrashSubmissionPromptTitle", this.f630b.f7230a);
    }

    public String m790b() {
        return m786a("com.crashlytics.CrashSubmissionPromptMessage", this.f630b.f7231b);
    }

    public String m791c() {
        return m786a("com.crashlytics.CrashSubmissionSendTitle", this.f630b.f7232c);
    }

    public String m792d() {
        return m786a("com.crashlytics.CrashSubmissionAlwaysSendTitle", this.f630b.f7236g);
    }

    public String m793e() {
        return m786a("com.crashlytics.CrashSubmissionCancelTitle", this.f630b.f7234e);
    }

    private String m786a(String str, String str2) {
        return m788b(CommonUtils.m9863b(this.f629a, str), str2);
    }

    private String m788b(String str, String str2) {
        return m787a(str) ? str2 : str;
    }

    private boolean m787a(String str) {
        return str == null || str.length() == 0;
    }
}
