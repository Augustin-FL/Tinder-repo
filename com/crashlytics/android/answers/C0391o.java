package com.crashlytics.android.answers;

import io.fabric.sdk.android.C0347h;
import io.fabric.sdk.android.C3218c;
import io.fabric.sdk.android.services.common.C0351a;
import io.fabric.sdk.android.services.common.C3265o;
import io.fabric.sdk.android.services.network.C3295c;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.p003b.C0373j;
import java.io.File;
import java.util.List;

/* renamed from: com.crashlytics.android.answers.o */
class C0391o extends C0351a implements C0373j {
    private final String f466b;

    public C0391o(C0347h c0347h, String str, String str2, C3295c c3295c, String str3) {
        super(c0347h, str, str2, c3295c, HttpMethod.POST);
        this.f466b = str3;
    }

    public boolean m554a(List<File> list) {
        HttpRequest a = m434b().m10041a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").m10041a("X-CRASHLYTICS-API-CLIENT-VERSION", this.a.m408a()).m10041a("X-CRASHLYTICS-API-KEY", this.f466b);
        int i = 0;
        for (File file : list) {
            a.m10044a("session_analytics_file_" + i, file.getName(), "application/vnd.crashlytics.android.events", file);
            i++;
        }
        C3218c.m9728h().m9687a("Answers", "Sending " + list.size() + " analytics files to " + m433a());
        int b = a.m10051b();
        C3218c.m9728h().m9687a("Answers", "Response code for analytics file send is " + b);
        if (C3265o.m9974a(b) == 0) {
            return true;
        }
        return false;
    }
}
