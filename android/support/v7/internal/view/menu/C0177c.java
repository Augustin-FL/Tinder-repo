package android.support.v7.internal.view.menu;

import android.content.Context;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.internal.view.SupportSubMenu;
import android.support.v4.util.ArrayMap;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;

/* renamed from: android.support.v7.internal.view.menu.c */
abstract class C0177c<T> extends C0176d<T> {
    final Context f104a;
    private Map<SupportMenuItem, MenuItem> f105c;
    private Map<SupportSubMenu, SubMenu> f106d;

    C0177c(Context context, T t) {
        super(t);
        this.f104a = context;
    }

    final MenuItem m82a(MenuItem menuItem) {
        if (!(menuItem instanceof SupportMenuItem)) {
            return menuItem;
        }
        SupportMenuItem supportMenuItem = (SupportMenuItem) menuItem;
        if (this.f105c == null) {
            this.f105c = new ArrayMap();
        }
        MenuItem menuItem2 = (MenuItem) this.f105c.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        menuItem2 = C0193n.m187a(this.f104a, supportMenuItem);
        this.f105c.put(supportMenuItem, menuItem2);
        return menuItem2;
    }

    final SubMenu m83a(SubMenu subMenu) {
        if (!(subMenu instanceof SupportSubMenu)) {
            return subMenu;
        }
        SupportSubMenu supportSubMenu = (SupportSubMenu) subMenu;
        if (this.f106d == null) {
            this.f106d = new ArrayMap();
        }
        SubMenu subMenu2 = (SubMenu) this.f106d.get(supportSubMenu);
        if (subMenu2 != null) {
            return subMenu2;
        }
        subMenu2 = C0193n.m188a(this.f104a, supportSubMenu);
        this.f106d.put(supportSubMenu, subMenu2);
        return subMenu2;
    }

    final void m84a() {
        if (this.f105c != null) {
            this.f105c.clear();
        }
        if (this.f106d != null) {
            this.f106d.clear();
        }
    }

    final void m85a(int i) {
        if (this.f105c != null) {
            Iterator it = this.f105c.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getGroupId()) {
                    it.remove();
                }
            }
        }
    }

    final void m86b(int i) {
        if (this.f105c != null) {
            Iterator it = this.f105c.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getItemId()) {
                    it.remove();
                    return;
                }
            }
        }
    }
}
