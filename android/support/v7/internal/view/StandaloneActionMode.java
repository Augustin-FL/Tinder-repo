package android.support.v7.internal.view;

import android.content.Context;
import android.support.v7.internal.view.menu.C0180f;
import android.support.v7.internal.view.menu.C0180f.C0151a;
import android.support.v7.internal.view.menu.C0192k;
import android.support.v7.internal.view.menu.C0195p;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

public class StandaloneActionMode extends ActionMode implements C0151a {
    private Callback mCallback;
    private Context mContext;
    private ActionBarContextView mContextView;
    private WeakReference<View> mCustomView;
    private boolean mFinished;
    private boolean mFocusable;
    private C0180f mMenu;

    public StandaloneActionMode(Context context, ActionBarContextView actionBarContextView, Callback callback, boolean z) {
        this.mContext = context;
        this.mContextView = actionBarContextView;
        this.mCallback = callback;
        this.mMenu = new C0180f(actionBarContextView.getContext()).m107a(1);
        this.mMenu.m114a((C0151a) this);
        this.mFocusable = z;
    }

    public void setTitle(CharSequence charSequence) {
        this.mContextView.setTitle(charSequence);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.mContextView.setSubtitle(charSequence);
    }

    public void setTitle(int i) {
        setTitle(this.mContext.getString(i));
    }

    public void setSubtitle(int i) {
        setSubtitle(this.mContext.getString(i));
    }

    public void setTitleOptionalHint(boolean z) {
        super.setTitleOptionalHint(z);
        this.mContextView.setTitleOptional(z);
    }

    public boolean isTitleOptional() {
        return this.mContextView.isTitleOptional();
    }

    public void setCustomView(View view) {
        this.mContextView.setCustomView(view);
        this.mCustomView = view != null ? new WeakReference(view) : null;
    }

    public void invalidate() {
        this.mCallback.onPrepareActionMode(this, this.mMenu);
    }

    public void finish() {
        if (!this.mFinished) {
            this.mFinished = true;
            this.mContextView.sendAccessibilityEvent(32);
            this.mCallback.onDestroyActionMode(this);
        }
    }

    public Menu getMenu() {
        return this.mMenu;
    }

    public CharSequence getTitle() {
        return this.mContextView.getTitle();
    }

    public CharSequence getSubtitle() {
        return this.mContextView.getSubtitle();
    }

    public View getCustomView() {
        return this.mCustomView != null ? (View) this.mCustomView.get() : null;
    }

    public MenuInflater getMenuInflater() {
        return new MenuInflater(this.mContextView.getContext());
    }

    public boolean onMenuItemSelected(C0180f c0180f, MenuItem menuItem) {
        return this.mCallback.onActionItemClicked(this, menuItem);
    }

    public void onCloseMenu(C0180f c0180f, boolean z) {
    }

    public boolean onSubMenuSelected(C0195p c0195p) {
        if (c0195p.hasVisibleItems()) {
            new C0192k(this.mContextView.getContext(), c0195p).show();
        }
        return true;
    }

    public void onCloseSubMenu(C0195p c0195p) {
    }

    public void onMenuModeChange(C0180f c0180f) {
        invalidate();
        this.mContextView.showOverflowMenu();
    }

    public boolean isUiFocusable() {
        return this.mFocusable;
    }
}
