package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v7.appcompat.C0159R;
import android.support.v7.internal.view.menu.C0172m.C0170a;
import android.support.v7.internal.view.menu.C0174l.C0156a;
import android.support.v7.widget.ListPopupWindow;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import java.util.ArrayList;

/* renamed from: android.support.v7.internal.view.menu.k */
public class C0192k implements C0174l, OnKeyListener, OnGlobalLayoutListener, OnItemClickListener, OnDismissListener {
    static final int ITEM_LAYOUT;
    private static final String TAG = "MenuPopupHelper";
    private final C0191a mAdapter;
    private View mAnchorView;
    private int mContentWidth;
    private final Context mContext;
    private int mDropDownGravity;
    boolean mForceShowIcon;
    private boolean mHasContentWidth;
    private final LayoutInflater mInflater;
    private ViewGroup mMeasureParent;
    private final C0180f mMenu;
    private final boolean mOverflowOnly;
    private ListPopupWindow mPopup;
    private final int mPopupMaxWidth;
    private final int mPopupStyleAttr;
    private final int mPopupStyleRes;
    private C0156a mPresenterCallback;
    private ViewTreeObserver mTreeObserver;

    /* renamed from: android.support.v7.internal.view.menu.k.a */
    private class C0191a extends BaseAdapter {
        final /* synthetic */ C0192k f183a;
        private C0180f f184b;
        private int f185c;

        public /* synthetic */ Object getItem(int i) {
            return m184a(i);
        }

        public C0191a(C0192k c0192k, C0180f c0180f) {
            this.f183a = c0192k;
            this.f185c = -1;
            this.f184b = c0180f;
            m185a();
        }

        public int getCount() {
            ArrayList l = this.f183a.mOverflowOnly ? this.f184b.m145l() : this.f184b.m142i();
            if (this.f185c < 0) {
                return l.size();
            }
            return l.size() - 1;
        }

        public C0183h m184a(int i) {
            ArrayList l = this.f183a.mOverflowOnly ? this.f184b.m145l() : this.f184b.m142i();
            if (this.f185c >= 0 && i >= this.f185c) {
                i++;
            }
            return (C0183h) l.get(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View inflate;
            if (view == null) {
                inflate = this.f183a.mInflater.inflate(C0192k.ITEM_LAYOUT, viewGroup, false);
            } else {
                inflate = view;
            }
            C0170a c0170a = (C0170a) inflate;
            if (this.f183a.mForceShowIcon) {
                ((ListMenuItemView) inflate).setForceShowIcon(true);
            }
            c0170a.m64a(m184a(i), C0192k.ITEM_LAYOUT);
            return inflate;
        }

        void m185a() {
            C0183h r = this.f183a.mMenu.m151r();
            if (r != null) {
                ArrayList l = this.f183a.mMenu.m145l();
                int size = l.size();
                for (int i = C0192k.ITEM_LAYOUT; i < size; i++) {
                    if (((C0183h) l.get(i)) == r) {
                        this.f185c = i;
                        return;
                    }
                }
            }
            this.f185c = -1;
        }

        public void notifyDataSetChanged() {
            m185a();
            super.notifyDataSetChanged();
        }
    }

    static {
        ITEM_LAYOUT = C0159R.layout.abc_popup_menu_item_layout;
    }

    public C0192k(Context context, C0180f c0180f) {
        this(context, c0180f, null, false, C0159R.attr.popupMenuStyle);
    }

    public C0192k(Context context, C0180f c0180f, View view) {
        this(context, c0180f, view, false, C0159R.attr.popupMenuStyle);
    }

    public C0192k(Context context, C0180f c0180f, View view, boolean z, int i) {
        this(context, c0180f, view, z, i, ITEM_LAYOUT);
    }

    public C0192k(Context context, C0180f c0180f, View view, boolean z, int i, int i2) {
        this.mDropDownGravity = ITEM_LAYOUT;
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mMenu = c0180f;
        this.mAdapter = new C0191a(this, this.mMenu);
        this.mOverflowOnly = z;
        this.mPopupStyleAttr = i;
        this.mPopupStyleRes = i2;
        Resources resources = context.getResources();
        this.mPopupMaxWidth = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C0159R.dimen.abc_config_prefDialogWidth));
        this.mAnchorView = view;
        c0180f.m117a((C0174l) this, context);
    }

    public void setAnchorView(View view) {
        this.mAnchorView = view;
    }

    public void setForceShowIcon(boolean z) {
        this.mForceShowIcon = z;
    }

    public void setGravity(int i) {
        this.mDropDownGravity = i;
    }

    public void show() {
        if (!tryShow()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public ListPopupWindow getPopup() {
        return this.mPopup;
    }

    public boolean tryShow() {
        boolean z = false;
        this.mPopup = new ListPopupWindow(this.mContext, null, this.mPopupStyleAttr, this.mPopupStyleRes);
        this.mPopup.setOnDismissListener(this);
        this.mPopup.setOnItemClickListener(this);
        this.mPopup.setAdapter(this.mAdapter);
        this.mPopup.setModal(true);
        View view = this.mAnchorView;
        if (view == null) {
            return false;
        }
        if (this.mTreeObserver == null) {
            z = true;
        }
        this.mTreeObserver = view.getViewTreeObserver();
        if (z) {
            this.mTreeObserver.addOnGlobalLayoutListener(this);
        }
        this.mPopup.setAnchorView(view);
        this.mPopup.setDropDownGravity(this.mDropDownGravity);
        if (!this.mHasContentWidth) {
            this.mContentWidth = measureContentWidth();
            this.mHasContentWidth = true;
        }
        this.mPopup.setContentWidth(this.mContentWidth);
        this.mPopup.setInputMethodMode(2);
        this.mPopup.show();
        this.mPopup.getListView().setOnKeyListener(this);
        return true;
    }

    public void dismiss() {
        if (isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void onDismiss() {
        this.mPopup = null;
        this.mMenu.close();
        if (this.mTreeObserver != null) {
            if (!this.mTreeObserver.isAlive()) {
                this.mTreeObserver = this.mAnchorView.getViewTreeObserver();
            }
            this.mTreeObserver.removeGlobalOnLayoutListener(this);
            this.mTreeObserver = null;
        }
    }

    public boolean isShowing() {
        return this.mPopup != null && this.mPopup.isShowing();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C0191a c0191a = this.mAdapter;
        c0191a.f184b.m122a(c0191a.m184a(i), (int) ITEM_LAYOUT);
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    private int measureContentWidth() {
        ListAdapter listAdapter = this.mAdapter;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(ITEM_LAYOUT, ITEM_LAYOUT);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(ITEM_LAYOUT, ITEM_LAYOUT);
        int count = listAdapter.getCount();
        int i = ITEM_LAYOUT;
        int i2 = ITEM_LAYOUT;
        View view = null;
        int i3 = ITEM_LAYOUT;
        while (i < count) {
            View view2;
            int itemViewType = listAdapter.getItemViewType(i);
            if (itemViewType != i2) {
                i2 = itemViewType;
                view2 = null;
            } else {
                view2 = view;
            }
            if (this.mMeasureParent == null) {
                this.mMeasureParent = new FrameLayout(this.mContext);
            }
            view = listAdapter.getView(i, view2, this.mMeasureParent);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            itemViewType = view.getMeasuredWidth();
            if (itemViewType >= this.mPopupMaxWidth) {
                return this.mPopupMaxWidth;
            }
            if (itemViewType <= i3) {
                itemViewType = i3;
            }
            i++;
            i3 = itemViewType;
        }
        return i3;
    }

    public void onGlobalLayout() {
        if (isShowing()) {
            View view = this.mAnchorView;
            if (view == null || !view.isShown()) {
                dismiss();
            } else if (isShowing()) {
                this.mPopup.show();
            }
        }
    }

    public void initForMenu(Context context, C0180f c0180f) {
    }

    public C0172m getMenuView(ViewGroup viewGroup) {
        throw new UnsupportedOperationException("MenuPopupHelpers manage their own views");
    }

    public void updateMenuView(boolean z) {
        this.mHasContentWidth = false;
        if (this.mAdapter != null) {
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public void setCallback(C0156a c0156a) {
        this.mPresenterCallback = c0156a;
    }

    public boolean onSubMenuSelected(C0195p c0195p) {
        if (c0195p.hasVisibleItems()) {
            boolean z;
            C0192k c0192k = new C0192k(this.mContext, c0195p, this.mAnchorView);
            c0192k.setCallback(this.mPresenterCallback);
            int size = c0195p.size();
            for (int i = ITEM_LAYOUT; i < size; i++) {
                MenuItem item = c0195p.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
            }
            z = false;
            c0192k.setForceShowIcon(z);
            if (c0192k.tryShow()) {
                if (this.mPresenterCallback == null) {
                    return true;
                }
                this.mPresenterCallback.onOpenSubMenu(c0195p);
                return true;
            }
        }
        return false;
    }

    public void onCloseMenu(C0180f c0180f, boolean z) {
        if (c0180f == this.mMenu) {
            dismiss();
            if (this.mPresenterCallback != null) {
                this.mPresenterCallback.onCloseMenu(c0180f, z);
            }
        }
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
        return ITEM_LAYOUT;
    }

    public Parcelable onSaveInstanceState() {
        return null;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
    }
}
