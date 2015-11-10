package io.fabric.sdk.android.services.p035c;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import io.fabric.sdk.android.C0347h;

/* renamed from: io.fabric.sdk.android.services.c.d */
public class C3239d implements C3238c {
    private final SharedPreferences f7016a;
    private final String f7017b;
    private final Context f7018c;

    public C3239d(Context context, String str) {
        if (context == null) {
            throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
        }
        this.f7018c = context;
        this.f7017b = str;
        this.f7016a = this.f7018c.getSharedPreferences(this.f7017b, 0);
    }

    @Deprecated
    public C3239d(C0347h c0347h) {
        this(c0347h.m402B(), c0347h.getClass().getName());
    }

    public SharedPreferences m9830a() {
        return this.f7016a;
    }

    public Editor m9832b() {
        return this.f7016a.edit();
    }

    @TargetApi(9)
    public boolean m9831a(Editor editor) {
        if (VERSION.SDK_INT < 9) {
            return editor.commit();
        }
        editor.apply();
        return true;
    }
}
