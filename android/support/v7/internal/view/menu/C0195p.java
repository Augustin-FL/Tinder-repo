package android.support.v7.internal.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.internal.view.menu.C0180f.C0151a;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: android.support.v7.internal.view.menu.p */
public class C0195p extends C0180f implements SubMenu {
    private C0180f f186d;
    private C0183h f187e;

    public C0195p(Context context, C0180f c0180f, C0183h c0183h) {
        super(context);
        this.f186d = c0180f;
        this.f187e = c0183h;
    }

    public void setQwertyMode(boolean z) {
        this.f186d.setQwertyMode(z);
    }

    public boolean m192b() {
        return this.f186d.m129b();
    }

    public boolean m193c() {
        return this.f186d.m133c();
    }

    public Menu m197s() {
        return this.f186d;
    }

    public MenuItem getItem() {
        return this.f187e;
    }

    public void m190a(C0151a c0151a) {
        this.f186d.m114a(c0151a);
    }

    public C0180f m196p() {
        return this.f186d;
    }

    boolean m191a(C0180f c0180f, MenuItem menuItem) {
        return super.m121a(c0180f, menuItem) || this.f186d.m121a(c0180f, menuItem);
    }

    public SubMenu setIcon(Drawable drawable) {
        this.f187e.setIcon(drawable);
        return this;
    }

    public SubMenu setIcon(int i) {
        this.f187e.setIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        super.m108a(drawable);
        return this;
    }

    public SubMenu setHeaderIcon(int i) {
        super.m108a(ContextCompat.getDrawable(m138e(), i));
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        super.m110a(charSequence);
        return this;
    }

    public SubMenu setHeaderTitle(int i) {
        super.m110a(m138e().getResources().getString(i));
        return this;
    }

    public SubMenu setHeaderView(View view) {
        super.m109a(view);
        return this;
    }

    public boolean m194c(C0183h c0183h) {
        return this.f186d.m134c(c0183h);
    }

    public boolean m195d(C0183h c0183h) {
        return this.f186d.m137d(c0183h);
    }

    public String m189a() {
        int itemId = this.f187e != null ? this.f187e.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.m112a() + ":" + itemId;
    }
}
