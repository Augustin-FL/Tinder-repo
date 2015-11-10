package android.support.v7.internal.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.internal.view.SupportSubMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: android.support.v7.internal.view.menu.q */
class C0196q extends C0194o implements SubMenu {
    C0196q(Context context, SupportSubMenu supportSubMenu) {
        super(context, supportSubMenu);
    }

    public SupportSubMenu m198b() {
        return (SupportSubMenu) this.b;
    }

    public SubMenu setHeaderTitle(int i) {
        m198b().setHeaderTitle(i);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        m198b().setHeaderTitle(charSequence);
        return this;
    }

    public SubMenu setHeaderIcon(int i) {
        m198b().setHeaderIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        m198b().setHeaderIcon(drawable);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        m198b().setHeaderView(view);
        return this;
    }

    public void clearHeader() {
        m198b().clearHeader();
    }

    public SubMenu setIcon(int i) {
        m198b().setIcon(i);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        m198b().setIcon(drawable);
        return this;
    }

    public MenuItem getItem() {
        return m82a(m198b().getItem());
    }
}
