package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.MenuItemCompat;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

/* renamed from: android.support.v7.internal.view.menu.a */
public class C0173a implements SupportMenuItem {
    private final int f89a;
    private final int f90b;
    private final int f91c;
    private final int f92d;
    private CharSequence f93e;
    private CharSequence f94f;
    private Intent f95g;
    private char f96h;
    private char f97i;
    private Drawable f98j;
    private int f99k;
    private Context f100l;
    private OnMenuItemClickListener f101m;
    private int f102n;

    public /* synthetic */ MenuItem setActionView(int i) {
        return m79a(i);
    }

    public /* synthetic */ MenuItem setActionView(View view) {
        return m80a(view);
    }

    public /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        return m81b(i);
    }

    public C0173a(Context context, int i, int i2, int i3, int i4, CharSequence charSequence) {
        this.f99k = 0;
        this.f102n = 16;
        this.f100l = context;
        this.f89a = i2;
        this.f90b = i;
        this.f91c = i3;
        this.f92d = i4;
        this.f93e = charSequence;
    }

    public char getAlphabeticShortcut() {
        return this.f97i;
    }

    public int getGroupId() {
        return this.f90b;
    }

    public Drawable getIcon() {
        return this.f98j;
    }

    public Intent getIntent() {
        return this.f95g;
    }

    public int getItemId() {
        return this.f89a;
    }

    public ContextMenuInfo getMenuInfo() {
        return null;
    }

    public char getNumericShortcut() {
        return this.f96h;
    }

    public int getOrder() {
        return this.f92d;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return this.f93e;
    }

    public CharSequence getTitleCondensed() {
        return this.f94f != null ? this.f94f : this.f93e;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isCheckable() {
        return (this.f102n & 1) != 0;
    }

    public boolean isChecked() {
        return (this.f102n & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.f102n & 16) != 0;
    }

    public boolean isVisible() {
        return (this.f102n & 8) == 0;
    }

    public MenuItem setAlphabeticShortcut(char c) {
        this.f97i = c;
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.f102n = (z ? 1 : 0) | (this.f102n & -2);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.f102n = (z ? 2 : 0) | (this.f102n & -3);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.f102n = (z ? 16 : 0) | (this.f102n & -17);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f98j = drawable;
        this.f99k = 0;
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f99k = i;
        this.f98j = ContextCompat.getDrawable(this.f100l, i);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f95g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        this.f96h = c;
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f101m = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f96h = c;
        this.f97i = c2;
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f93e = charSequence;
        return this;
    }

    public MenuItem setTitle(int i) {
        this.f93e = this.f100l.getResources().getString(i);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f94f = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean z) {
        this.f102n = (z ? 0 : 8) | (this.f102n & 8);
        return this;
    }

    public void setShowAsAction(int i) {
    }

    public SupportMenuItem m80a(View view) {
        throw new UnsupportedOperationException();
    }

    public View getActionView() {
        return null;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public SupportMenuItem m79a(int i) {
        throw new UnsupportedOperationException();
    }

    public android.support.v4.view.ActionProvider getSupportActionProvider() {
        return null;
    }

    public SupportMenuItem setSupportActionProvider(android.support.v4.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public SupportMenuItem m81b(int i) {
        setShowAsAction(i);
        return this;
    }

    public boolean expandActionView() {
        return false;
    }

    public boolean collapseActionView() {
        return false;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public SupportMenuItem setSupportOnActionExpandListener(MenuItemCompat.OnActionExpandListener onActionExpandListener) {
        return this;
    }
}
