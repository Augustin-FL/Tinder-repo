package android.support.v7.internal.view.menu;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v7.internal.view.menu.C0172m.C0170a;
import android.support.v7.internal.view.menu.C0174l.C0156a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* renamed from: android.support.v7.internal.view.menu.b */
public abstract class C0175b implements C0174l {
    private C0156a mCallback;
    protected Context mContext;
    private int mId;
    protected LayoutInflater mInflater;
    private int mItemLayoutRes;
    protected C0180f mMenu;
    private int mMenuLayoutRes;
    protected C0172m mMenuView;
    protected Context mSystemContext;
    protected LayoutInflater mSystemInflater;

    public abstract void bindItemView(C0183h c0183h, C0170a c0170a);

    public C0175b(Context context, int i, int i2) {
        this.mSystemContext = context;
        this.mSystemInflater = LayoutInflater.from(context);
        this.mMenuLayoutRes = i;
        this.mItemLayoutRes = i2;
    }

    public void initForMenu(Context context, C0180f c0180f) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(this.mContext);
        this.mMenu = c0180f;
    }

    public C0172m getMenuView(ViewGroup viewGroup) {
        if (this.mMenuView == null) {
            this.mMenuView = (C0172m) this.mSystemInflater.inflate(this.mMenuLayoutRes, viewGroup, false);
            this.mMenuView.initialize(this.mMenu);
            updateMenuView(true);
        }
        return this.mMenuView;
    }

    public void updateMenuView(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.mMenuView;
        if (viewGroup != null) {
            int i;
            if (this.mMenu != null) {
                this.mMenu.m143j();
                ArrayList i2 = this.mMenu.m142i();
                int size = i2.size();
                int i3 = 0;
                i = 0;
                while (i3 < size) {
                    int i4;
                    C0183h c0183h = (C0183h) i2.get(i3);
                    if (shouldIncludeItem(i, c0183h)) {
                        View childAt = viewGroup.getChildAt(i);
                        C0183h itemData = childAt instanceof C0170a ? ((C0170a) childAt).getItemData() : null;
                        View itemView = getItemView(c0183h, childAt, viewGroup);
                        if (c0183h != itemData) {
                            itemView.setPressed(false);
                            ViewCompat.jumpDrawablesToCurrentState(itemView);
                        }
                        if (itemView != childAt) {
                            addItemView(itemView, i);
                        }
                        i4 = i + 1;
                    } else {
                        i4 = i;
                    }
                    i3++;
                    i = i4;
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (!filterLeftoverView(viewGroup, i)) {
                    i++;
                }
            }
        }
    }

    protected void addItemView(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.mMenuView).addView(view, i);
    }

    protected boolean filterLeftoverView(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    public void setCallback(C0156a c0156a) {
        this.mCallback = c0156a;
    }

    public C0156a getCallback() {
        return this.mCallback;
    }

    public C0170a createItemView(ViewGroup viewGroup) {
        return (C0170a) this.mSystemInflater.inflate(this.mItemLayoutRes, viewGroup, false);
    }

    public View getItemView(C0183h c0183h, View view, ViewGroup viewGroup) {
        C0170a c0170a;
        if (view instanceof C0170a) {
            c0170a = (C0170a) view;
        } else {
            c0170a = createItemView(viewGroup);
        }
        bindItemView(c0183h, c0170a);
        return (View) c0170a;
    }

    public boolean shouldIncludeItem(int i, C0183h c0183h) {
        return true;
    }

    public void onCloseMenu(C0180f c0180f, boolean z) {
        if (this.mCallback != null) {
            this.mCallback.onCloseMenu(c0180f, z);
        }
    }

    public boolean onSubMenuSelected(C0195p c0195p) {
        if (this.mCallback != null) {
            return this.mCallback.onOpenSubMenu(c0195p);
        }
        return false;
    }

    public boolean flagActionItems() {
        return false;
    }

    public boolean expandItemActionView(C0180f c0180f, C0183h c0183h) {
        return false;
    }

    public boolean collapseItemActionView(C0180f c0180f, C0183h c0183h) {
        return false;
    }

    public int getId() {
        return this.mId;
    }

    public void setId(int i) {
        this.mId = i;
    }
}
