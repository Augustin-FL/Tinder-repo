package p000a;

import android.content.Intent;
import android.os.Bundle;

/* renamed from: a.c */
public final class C0005c {
    public static Bundle m3a(Intent intent) {
        return intent.getBundleExtra("al_applink_data");
    }

    public static Bundle m4b(Intent intent) {
        Bundle a = C0005c.m3a(intent);
        if (a == null) {
            return null;
        }
        return a.getBundle("extras");
    }
}
