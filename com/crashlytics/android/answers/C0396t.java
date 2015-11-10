package com.crashlytics.android.answers;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.common.IdManager.DeviceIdentifierType;
import java.util.Map;
import java.util.UUID;

/* renamed from: com.crashlytics.android.answers.t */
class C0396t {
    private final Context f481a;
    private final IdManager f482b;
    private final String f483c;
    private final String f484d;

    public C0396t(Context context, IdManager idManager, String str, String str2) {
        this.f481a = context;
        this.f482b = idManager;
        this.f483c = str;
        this.f484d = str2;
    }

    public C0393r m565a() {
        Map g = this.f482b.m9898g();
        return new C0393r(this.f481a.getPackageName(), UUID.randomUUID().toString(), this.f482b.m9893b(), (String) g.get(DeviceIdentifierType.ANDROID_ID), (String) g.get(DeviceIdentifierType.ANDROID_ADVERTISING_ID), this.f482b.m9901j(), (String) g.get(DeviceIdentifierType.FONT_TOKEN), CommonUtils.m9878m(this.f481a), this.f482b.m9895d(), this.f482b.m9896e(), this.f483c, this.f484d);
    }
}
