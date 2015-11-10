package com.crashlytics.android.answers;

/* renamed from: com.crashlytics.android.answers.r */
final class C0393r {
    public final String f468a;
    public final String f469b;
    public final String f470c;
    public final String f471d;
    public final String f472e;
    public final Boolean f473f;
    public final String f474g;
    public final String f475h;
    public final String f476i;
    public final String f477j;
    public final String f478k;
    public final String f479l;
    private String f480m;

    public C0393r(String str, String str2, String str3, String str4, String str5, Boolean bool, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.f468a = str;
        this.f469b = str2;
        this.f470c = str3;
        this.f471d = str4;
        this.f472e = str5;
        this.f473f = bool;
        this.f474g = str6;
        this.f475h = str7;
        this.f476i = str8;
        this.f477j = str9;
        this.f478k = str10;
        this.f479l = str11;
    }

    public String toString() {
        if (this.f480m == null) {
            this.f480m = "appBundleId=" + this.f468a + ", executionId=" + this.f469b + ", installationId=" + this.f470c + ", androidId=" + this.f471d + ", advertisingId=" + this.f472e + ", limitAdTrackingEnabled=" + this.f473f + ", betaDeviceToken=" + this.f474g + ", buildId=" + this.f475h + ", osVersion=" + this.f476i + ", deviceModel=" + this.f477j + ", appVersionCode=" + this.f478k + ", appVersionName=" + this.f479l;
        }
        return this.f480m;
    }
}
