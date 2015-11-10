package io.fabric.sdk.android.services.p003b;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;

/* renamed from: io.fabric.sdk.android.services.b.m */
public class C3235m implements Runnable {
    private final Context f7011a;
    private final C0376i f7012b;

    public C3235m(Context context, C0376i c0376i) {
        this.f7011a = context;
        this.f7012b = c0376i;
    }

    public void run() {
        try {
            CommonUtils.m9852a(this.f7011a, "Performing time based file roll over.");
            if (!this.f7012b.m505e()) {
                this.f7012b.m504d();
            }
        } catch (Throwable e) {
            CommonUtils.m9853a(this.f7011a, "Failed to roll over file", e);
        }
    }
}
