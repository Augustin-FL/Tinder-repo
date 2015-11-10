package android.support.v7.internal.view.menu;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.internal.view.SupportSubMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* renamed from: android.support.v7.internal.view.menu.n */
public final class C0193n {
    public static Menu m186a(Context context, SupportMenu supportMenu) {
        if (VERSION.SDK_INT >= 14) {
            return new C0194o(context, supportMenu);
        }
        throw new UnsupportedOperationException();
    }

    public static MenuItem m187a(Context context, SupportMenuItem supportMenuItem) {
        if (VERSION.SDK_INT >= 16) {
            return new C0190j(context, supportMenuItem);
        }
        if (VERSION.SDK_INT >= 14) {
            return new C0188i(context, supportMenuItem);
        }
        throw new UnsupportedOperationException();
    }

    public static SubMenu m188a(Context context, SupportSubMenu supportSubMenu) {
        if (VERSION.SDK_INT >= 14) {
            return new C0196q(context, supportSubMenu);
        }
        throw new UnsupportedOperationException();
    }
}
