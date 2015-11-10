package io.fabric.sdk.android.services.settings;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import io.fabric.sdk.android.C3218c;
import io.fabric.sdk.android.services.common.CommonUtils;

/* renamed from: io.fabric.sdk.android.services.settings.n */
public class C3316n {
    public final String f7226a;
    public final int f7227b;
    public final int f7228c;
    public final int f7229d;

    public C3316n(String str, int i, int i2, int i3) {
        this.f7226a = str;
        this.f7227b = i;
        this.f7228c = i2;
        this.f7229d = i3;
    }

    public static C3316n m10133a(Context context, String str) {
        if (str != null) {
            try {
                int l = CommonUtils.m9877l(context);
                C3218c.m9728h().m9687a("Fabric", "App icon resource ID is " + l);
                Options options = new Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeResource(context.getResources(), l, options);
                return new C3316n(str, l, options.outWidth, options.outHeight);
            } catch (Throwable e) {
                C3218c.m9728h().m9695e("Fabric", "Failed to load icon", e);
            }
        }
        return null;
    }
}
