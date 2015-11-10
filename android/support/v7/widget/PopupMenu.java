package android.support.v7.widget;

import android.content.Context;
import android.support.annotation.MenuRes;
import android.support.v7.appcompat.C0159R;
import android.support.v7.internal.view.SupportMenuInflater;
import android.support.v7.internal.view.menu.C0174l.C0156a;
import android.support.v7.internal.view.menu.C0180f;
import android.support.v7.internal.view.menu.C0180f.C0151a;
import android.support.v7.internal.view.menu.C0192k;
import android.support.v7.internal.view.menu.C0195p;
import android.support.v7.widget.ListPopupWindow.ForwardingListener;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnTouchListener;

public class PopupMenu implements C0151a, C0156a {
    private View mAnchor;
    private Context mContext;
    private OnDismissListener mDismissListener;
    private OnTouchListener mDragListener;
    private C0180f mMenu;
    private OnMenuItemClickListener mMenuItemClickListener;
    private C0192k mPopup;

    /* renamed from: android.support.v7.widget.PopupMenu.1 */
    class C02531 extends ForwardingListener {
        C02531(View view) {
            super(view);
        }

        protected boolean onForwardingStarted() {
            PopupMenu.this.show();
            return true;
        }

        protected boolean onForwardingStopped() {
            PopupMenu.this.dismiss();
            return true;
        }

        public ListPopupWindow getPopup() {
            return PopupMenu.this.mPopup.getPopup();
        }
    }

    public interface OnDismissListener {
        void onDismiss(PopupMenu popupMenu);
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public PopupMenu(Context context, View view) {
        this(context, view, 0);
    }

    public PopupMenu(Context context, View view, int i) {
        this(context, view, i, C0159R.attr.popupMenuStyle, 0);
    }

    public PopupMenu(Context context, View view, int i, int i2, int i3) {
        this.mContext = context;
        this.mMenu = new C0180f(context);
        this.mMenu.m114a((C0151a) this);
        this.mAnchor = view;
        this.mPopup = new C0192k(context, this.mMenu, view, false, i2, i3);
        this.mPopup.setGravity(i);
        this.mPopup.setCallback(this);
    }

    public OnTouchListener getDragToOpenListener() {
        if (this.mDragListener == null) {
            this.mDragListener = new C02531(this.mAnchor);
        }
        return this.mDragListener;
    }

    public Menu getMenu() {
        return this.mMenu;
    }

    public MenuInflater getMenuInflater() {
        return new SupportMenuInflater(this.mContext);
    }

    public void inflate(@MenuRes int i) {
        getMenuInflater().inflate(i, this.mMenu);
    }

    public void show() {
        this.mPopup.show();
    }

    public void dismiss() {
        this.mPopup.dismiss();
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.mMenuItemClickListener = onMenuItemClickListener;
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.mDismissListener = onDismissListener;
    }

    public boolean onMenuItemSelected(C0180f c0180f, MenuItem menuItem) {
        if (this.mMenuItemClickListener != null) {
            return this.mMenuItemClickListener.onMenuItemClick(menuItem);
        }
        return false;
    }

    public void onCloseMenu(C0180f c0180f, boolean z) {
        if (this.mDismissListener != null) {
            this.mDismissListener.onDismiss(this);
        }
    }

    public boolean onOpenSubMenu(C0180f c0180f) {
        if (c0180f == null) {
            return false;
        }
        if (!c0180f.hasVisibleItems()) {
            return true;
        }
        new C0192k(this.mContext, c0180f, this.mAnchor).show();
        return true;
    }

    public void onCloseSubMenu(C0195p c0195p) {
    }

    public void onMenuModeChange(C0180f c0180f) {
    }
}
