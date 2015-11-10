package android.support.v7.internal.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.view.CollapsibleActionView;
import android.util.Log;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

@TargetApi(14)
/* renamed from: android.support.v7.internal.view.menu.i */
public class C0188i extends C0177c<SupportMenuItem> implements MenuItem {
    private Method f180c;

    /* renamed from: android.support.v7.internal.view.menu.i.a */
    class C0184a extends ActionProvider {
        final android.view.ActionProvider f175a;
        final /* synthetic */ C0188i f176b;

        public C0184a(C0188i c0188i, Context context, android.view.ActionProvider actionProvider) {
            this.f176b = c0188i;
            super(context);
            this.f175a = actionProvider;
        }

        public View onCreateActionView() {
            return this.f175a.onCreateActionView();
        }

        public boolean onPerformDefaultAction() {
            return this.f175a.onPerformDefaultAction();
        }

        public boolean hasSubMenu() {
            return this.f175a.hasSubMenu();
        }

        public void onPrepareSubMenu(SubMenu subMenu) {
            this.f175a.onPrepareSubMenu(this.f176b.m83a(subMenu));
        }
    }

    /* renamed from: android.support.v7.internal.view.menu.i.b */
    static class C0185b extends FrameLayout implements CollapsibleActionView {
        final android.view.CollapsibleActionView f177a;

        C0185b(View view) {
            super(view.getContext());
            this.f177a = (android.view.CollapsibleActionView) view;
            addView(view);
        }

        public void onActionViewExpanded() {
            this.f177a.onActionViewExpanded();
        }

        public void onActionViewCollapsed() {
            this.f177a.onActionViewCollapsed();
        }

        View m179a() {
            return (View) this.f177a;
        }
    }

    /* renamed from: android.support.v7.internal.view.menu.i.c */
    private class C0186c extends C0176d<OnActionExpandListener> implements MenuItemCompat.OnActionExpandListener {
        final /* synthetic */ C0188i f178a;

        C0186c(C0188i c0188i, OnActionExpandListener onActionExpandListener) {
            this.f178a = c0188i;
            super(onActionExpandListener);
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return ((OnActionExpandListener) this.b).onMenuItemActionExpand(this.f178a.m82a(menuItem));
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return ((OnActionExpandListener) this.b).onMenuItemActionCollapse(this.f178a.m82a(menuItem));
        }
    }

    /* renamed from: android.support.v7.internal.view.menu.i.d */
    private class C0187d extends C0176d<OnMenuItemClickListener> implements OnMenuItemClickListener {
        final /* synthetic */ C0188i f179a;

        C0187d(C0188i c0188i, OnMenuItemClickListener onMenuItemClickListener) {
            this.f179a = c0188i;
            super(onMenuItemClickListener);
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return ((OnMenuItemClickListener) this.b).onMenuItemClick(this.f179a.m82a(menuItem));
        }
    }

    C0188i(Context context, SupportMenuItem supportMenuItem) {
        super(context, supportMenuItem);
    }

    public int getItemId() {
        return ((SupportMenuItem) this.b).getItemId();
    }

    public int getGroupId() {
        return ((SupportMenuItem) this.b).getGroupId();
    }

    public int getOrder() {
        return ((SupportMenuItem) this.b).getOrder();
    }

    public MenuItem setTitle(CharSequence charSequence) {
        ((SupportMenuItem) this.b).setTitle(charSequence);
        return this;
    }

    public MenuItem setTitle(int i) {
        ((SupportMenuItem) this.b).setTitle(i);
        return this;
    }

    public CharSequence getTitle() {
        return ((SupportMenuItem) this.b).getTitle();
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((SupportMenuItem) this.b).setTitleCondensed(charSequence);
        return this;
    }

    public CharSequence getTitleCondensed() {
        return ((SupportMenuItem) this.b).getTitleCondensed();
    }

    public MenuItem setIcon(Drawable drawable) {
        ((SupportMenuItem) this.b).setIcon(drawable);
        return this;
    }

    public MenuItem setIcon(int i) {
        ((SupportMenuItem) this.b).setIcon(i);
        return this;
    }

    public Drawable getIcon() {
        return ((SupportMenuItem) this.b).getIcon();
    }

    public MenuItem setIntent(Intent intent) {
        ((SupportMenuItem) this.b).setIntent(intent);
        return this;
    }

    public Intent getIntent() {
        return ((SupportMenuItem) this.b).getIntent();
    }

    public MenuItem setShortcut(char c, char c2) {
        ((SupportMenuItem) this.b).setShortcut(c, c2);
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        ((SupportMenuItem) this.b).setNumericShortcut(c);
        return this;
    }

    public char getNumericShortcut() {
        return ((SupportMenuItem) this.b).getNumericShortcut();
    }

    public MenuItem setAlphabeticShortcut(char c) {
        ((SupportMenuItem) this.b).setAlphabeticShortcut(c);
        return this;
    }

    public char getAlphabeticShortcut() {
        return ((SupportMenuItem) this.b).getAlphabeticShortcut();
    }

    public MenuItem setCheckable(boolean z) {
        ((SupportMenuItem) this.b).setCheckable(z);
        return this;
    }

    public boolean isCheckable() {
        return ((SupportMenuItem) this.b).isCheckable();
    }

    public MenuItem setChecked(boolean z) {
        ((SupportMenuItem) this.b).setChecked(z);
        return this;
    }

    public boolean isChecked() {
        return ((SupportMenuItem) this.b).isChecked();
    }

    public MenuItem setVisible(boolean z) {
        return ((SupportMenuItem) this.b).setVisible(z);
    }

    public boolean isVisible() {
        return ((SupportMenuItem) this.b).isVisible();
    }

    public MenuItem setEnabled(boolean z) {
        ((SupportMenuItem) this.b).setEnabled(z);
        return this;
    }

    public boolean isEnabled() {
        return ((SupportMenuItem) this.b).isEnabled();
    }

    public boolean hasSubMenu() {
        return ((SupportMenuItem) this.b).hasSubMenu();
    }

    public SubMenu getSubMenu() {
        return m83a(((SupportMenuItem) this.b).getSubMenu());
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        ((SupportMenuItem) this.b).setOnMenuItemClickListener(onMenuItemClickListener != null ? new C0187d(this, onMenuItemClickListener) : null);
        return this;
    }

    public ContextMenuInfo getMenuInfo() {
        return ((SupportMenuItem) this.b).getMenuInfo();
    }

    public void setShowAsAction(int i) {
        ((SupportMenuItem) this.b).setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        ((SupportMenuItem) this.b).setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof android.view.CollapsibleActionView) {
            view = new C0185b(view);
        }
        ((SupportMenuItem) this.b).setActionView(view);
        return this;
    }

    public MenuItem setActionView(int i) {
        ((SupportMenuItem) this.b).setActionView(i);
        View actionView = ((SupportMenuItem) this.b).getActionView();
        if (actionView instanceof android.view.CollapsibleActionView) {
            ((SupportMenuItem) this.b).setActionView(new C0185b(actionView));
        }
        return this;
    }

    public View getActionView() {
        View actionView = ((SupportMenuItem) this.b).getActionView();
        if (actionView instanceof C0185b) {
            return ((C0185b) actionView).m179a();
        }
        return actionView;
    }

    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        ((SupportMenuItem) this.b).setSupportActionProvider(actionProvider != null ? m180a(actionProvider) : null);
        return this;
    }

    public android.view.ActionProvider getActionProvider() {
        ActionProvider supportActionProvider = ((SupportMenuItem) this.b).getSupportActionProvider();
        if (supportActionProvider instanceof C0184a) {
            return ((C0184a) supportActionProvider).f175a;
        }
        return null;
    }

    public boolean expandActionView() {
        return ((SupportMenuItem) this.b).expandActionView();
    }

    public boolean collapseActionView() {
        return ((SupportMenuItem) this.b).collapseActionView();
    }

    public boolean isActionViewExpanded() {
        return ((SupportMenuItem) this.b).isActionViewExpanded();
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        ((SupportMenuItem) this.b).setSupportOnActionExpandListener(onActionExpandListener != null ? new C0186c(this, onActionExpandListener) : null);
        return this;
    }

    public void m181a(boolean z) {
        try {
            if (this.f180c == null) {
                this.f180c = ((SupportMenuItem) this.b).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.f180c.invoke(this.b, new Object[]{Boolean.valueOf(z)});
        } catch (Throwable e) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
        }
    }

    C0184a m180a(android.view.ActionProvider actionProvider) {
        return new C0184a(this, this.a, actionProvider);
    }
}
