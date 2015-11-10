package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.ActionProvider.SubUiVisibilityListener;
import android.support.v4.view.GravityCompat;
import android.support.v7.appcompat.C0159R;
import android.support.v7.internal.transition.ActionBarTransition;
import android.support.v7.internal.view.ActionBarPolicy;
import android.support.v7.internal.view.menu.ActionMenuItemView;
import android.support.v7.internal.view.menu.ActionMenuItemView.C0169b;
import android.support.v7.internal.view.menu.C0172m;
import android.support.v7.internal.view.menu.C0172m.C0170a;
import android.support.v7.internal.view.menu.C0174l.C0156a;
import android.support.v7.internal.view.menu.C0175b;
import android.support.v7.internal.view.menu.C0180f;
import android.support.v7.internal.view.menu.C0183h;
import android.support.v7.internal.view.menu.C0192k;
import android.support.v7.internal.view.menu.C0195p;
import android.support.v7.internal.widget.TintImageView;
import android.support.v7.widget.ActionMenuView.ActionMenuChildView;
import android.support.v7.widget.ListPopupWindow.ForwardingListener;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;

public class ActionMenuPresenter extends C0175b implements SubUiVisibilityListener {
    private static final String TAG = "ActionMenuPresenter";
    private final SparseBooleanArray mActionButtonGroups;
    private ActionButtonSubmenu mActionButtonPopup;
    private int mActionItemWidthLimit;
    private boolean mExpandedActionViewsExclusive;
    private int mMaxItems;
    private boolean mMaxItemsSet;
    private int mMinCellSize;
    int mOpenSubMenuId;
    private View mOverflowButton;
    private OverflowPopup mOverflowPopup;
    private ActionMenuPopupCallback mPopupCallback;
    final PopupPresenterCallback mPopupPresenterCallback;
    private OpenOverflowRunnable mPostedOpenRunnable;
    private boolean mReserveOverflow;
    private boolean mReserveOverflowSet;
    private View mScrapActionButtonView;
    private boolean mStrictWidthLimit;
    private int mWidthLimit;
    private boolean mWidthLimitSet;

    private class ActionButtonSubmenu extends C0192k {
        private C0195p mSubMenu;
        final /* synthetic */ ActionMenuPresenter this$0;

        public ActionButtonSubmenu(ActionMenuPresenter actionMenuPresenter, Context context, C0195p c0195p) {
            boolean z = false;
            this.this$0 = actionMenuPresenter;
            super(context, c0195p, null, false, C0159R.attr.actionOverflowMenuStyle);
            this.mSubMenu = c0195p;
            if (!((C0183h) c0195p.getItem()).m174i()) {
                setAnchorView(actionMenuPresenter.mOverflowButton == null ? (View) actionMenuPresenter.mMenuView : actionMenuPresenter.mOverflowButton);
            }
            setCallback(actionMenuPresenter.mPopupPresenterCallback);
            int size = c0195p.size();
            for (int i = 0; i < size; i++) {
                MenuItem item = c0195p.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
            }
            setForceShowIcon(z);
        }

        public void onDismiss() {
            super.onDismiss();
            this.this$0.mActionButtonPopup = null;
            this.this$0.mOpenSubMenuId = 0;
        }
    }

    private class ActionMenuPopupCallback extends C0169b {
        private ActionMenuPopupCallback() {
        }

        public ListPopupWindow getPopup() {
            return ActionMenuPresenter.this.mActionButtonPopup != null ? ActionMenuPresenter.this.mActionButtonPopup.getPopup() : null;
        }
    }

    private class OpenOverflowRunnable implements Runnable {
        private OverflowPopup mPopup;

        public OpenOverflowRunnable(OverflowPopup overflowPopup) {
            this.mPopup = overflowPopup;
        }

        public void run() {
            ActionMenuPresenter.this.mMenu.m139f();
            View view = (View) ActionMenuPresenter.this.mMenuView;
            if (!(view == null || view.getWindowToken() == null || !this.mPopup.tryShow())) {
                ActionMenuPresenter.this.mOverflowPopup = this.mPopup;
            }
            ActionMenuPresenter.this.mPostedOpenRunnable = null;
        }
    }

    private class OverflowMenuButton extends TintImageView implements ActionMenuChildView {
        private final float[] mTempPts;

        /* renamed from: android.support.v7.widget.ActionMenuPresenter.OverflowMenuButton.1 */
        class C02231 extends ForwardingListener {
            final /* synthetic */ ActionMenuPresenter val$this$0;

            C02231(View view, ActionMenuPresenter actionMenuPresenter) {
                this.val$this$0 = actionMenuPresenter;
                super(view);
            }

            public ListPopupWindow getPopup() {
                if (ActionMenuPresenter.this.mOverflowPopup == null) {
                    return null;
                }
                return ActionMenuPresenter.this.mOverflowPopup.getPopup();
            }

            public boolean onForwardingStarted() {
                ActionMenuPresenter.this.showOverflowMenu();
                return true;
            }

            public boolean onForwardingStopped() {
                if (ActionMenuPresenter.this.mPostedOpenRunnable != null) {
                    return false;
                }
                ActionMenuPresenter.this.hideOverflowMenu();
                return true;
            }
        }

        public OverflowMenuButton(Context context) {
            super(context, null, C0159R.attr.actionOverflowButtonStyle);
            this.mTempPts = new float[2];
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            setOnTouchListener(new C02231(this, ActionMenuPresenter.this));
        }

        public boolean performClick() {
            if (!super.performClick()) {
                playSoundEffect(0);
                ActionMenuPresenter.this.showOverflowMenu();
            }
            return true;
        }

        public boolean needsDividerBefore() {
            return false;
        }

        public boolean needsDividerAfter() {
            return false;
        }

        protected boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                width = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                height = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                DrawableCompat.setHotspotBounds(background, width - max, height - max, width + max, height + max);
            }
            return frame;
        }
    }

    private class OverflowPopup extends C0192k {
        public OverflowPopup(Context context, C0180f c0180f, View view, boolean z) {
            super(context, c0180f, view, z, C0159R.attr.actionOverflowMenuStyle);
            setGravity(GravityCompat.END);
            setCallback(ActionMenuPresenter.this.mPopupPresenterCallback);
        }

        public void onDismiss() {
            super.onDismiss();
            ActionMenuPresenter.this.mMenu.close();
            ActionMenuPresenter.this.mOverflowPopup = null;
        }
    }

    private class PopupPresenterCallback implements C0156a {
        private PopupPresenterCallback() {
        }

        public boolean onOpenSubMenu(C0180f c0180f) {
            if (c0180f == null) {
                return false;
            }
            ActionMenuPresenter.this.mOpenSubMenuId = ((C0195p) c0180f).getItem().getItemId();
            C0156a callback = ActionMenuPresenter.this.getCallback();
            return callback != null ? callback.onOpenSubMenu(c0180f) : false;
        }

        public void onCloseMenu(C0180f c0180f, boolean z) {
            if (c0180f instanceof C0195p) {
                ((C0195p) c0180f).m196p().m120a(false);
            }
            C0156a callback = ActionMenuPresenter.this.getCallback();
            if (callback != null) {
                callback.onCloseMenu(c0180f, z);
            }
        }
    }

    private static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR;
        public int openSubMenuId;

        /* renamed from: android.support.v7.widget.ActionMenuPresenter.SavedState.1 */
        static class C02241 implements Creator<SavedState> {
            C02241() {
            }

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.openSubMenuId = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.openSubMenuId);
        }

        static {
            CREATOR = new C02241();
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, C0159R.layout.abc_action_menu_layout, C0159R.layout.abc_action_menu_item_layout);
        this.mActionButtonGroups = new SparseBooleanArray();
        this.mPopupPresenterCallback = new PopupPresenterCallback();
    }

    public void initForMenu(Context context, C0180f c0180f) {
        super.initForMenu(context, c0180f);
        Resources resources = context.getResources();
        ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(context);
        if (!this.mReserveOverflowSet) {
            this.mReserveOverflow = actionBarPolicy.showsOverflowMenuButton();
        }
        if (!this.mWidthLimitSet) {
            this.mWidthLimit = actionBarPolicy.getEmbeddedMenuWidthLimit();
        }
        if (!this.mMaxItemsSet) {
            this.mMaxItems = actionBarPolicy.getMaxActionButtons();
        }
        int i = this.mWidthLimit;
        if (this.mReserveOverflow) {
            if (this.mOverflowButton == null) {
                this.mOverflowButton = new OverflowMenuButton(this.mSystemContext);
                int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
                this.mOverflowButton.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.mOverflowButton.getMeasuredWidth();
        } else {
            this.mOverflowButton = null;
        }
        this.mActionItemWidthLimit = i;
        this.mMinCellSize = (int) (56.0f * resources.getDisplayMetrics().density);
        this.mScrapActionButtonView = null;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!this.mMaxItemsSet) {
            this.mMaxItems = this.mContext.getResources().getInteger(C0159R.integer.abc_max_action_buttons);
        }
        if (this.mMenu != null) {
            this.mMenu.m128b(true);
        }
    }

    public void setWidthLimit(int i, boolean z) {
        this.mWidthLimit = i;
        this.mStrictWidthLimit = z;
        this.mWidthLimitSet = true;
    }

    public void setReserveOverflow(boolean z) {
        this.mReserveOverflow = z;
        this.mReserveOverflowSet = true;
    }

    public void setItemLimit(int i) {
        this.mMaxItems = i;
        this.mMaxItemsSet = true;
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.mExpandedActionViewsExclusive = z;
    }

    public C0172m getMenuView(ViewGroup viewGroup) {
        C0172m menuView = super.getMenuView(viewGroup);
        ((ActionMenuView) menuView).setPresenter(this);
        return menuView;
    }

    public View getItemView(C0183h c0183h, View view, ViewGroup viewGroup) {
        View actionView = c0183h.getActionView();
        if (actionView == null || c0183h.m178m()) {
            actionView = super.getItemView(c0183h, view, viewGroup);
        }
        actionView.setVisibility(c0183h.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    public void bindItemView(C0183h c0183h, C0170a c0170a) {
        c0170a.m64a(c0183h, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) c0170a;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.mMenuView);
        if (this.mPopupCallback == null) {
            this.mPopupCallback = new ActionMenuPopupCallback();
        }
        actionMenuItemView.setPopupCallback(this.mPopupCallback);
    }

    public boolean shouldIncludeItem(int i, C0183h c0183h) {
        return c0183h.m174i();
    }

    public void updateMenuView(boolean z) {
        int i;
        int i2 = 1;
        int i3 = 0;
        ViewGroup viewGroup = (ViewGroup) ((View) this.mMenuView).getParent();
        if (viewGroup != null) {
            ActionBarTransition.beginDelayedTransition(viewGroup);
        }
        super.updateMenuView(z);
        ((View) this.mMenuView).requestLayout();
        if (this.mMenu != null) {
            ArrayList k = this.mMenu.m144k();
            int size = k.size();
            for (i = 0; i < size; i++) {
                ActionProvider supportActionProvider = ((C0183h) k.get(i)).getSupportActionProvider();
                if (supportActionProvider != null) {
                    supportActionProvider.setSubUiVisibilityListener(this);
                }
            }
        }
        ArrayList l = this.mMenu != null ? this.mMenu.m145l() : null;
        if (this.mReserveOverflow && l != null) {
            i = l.size();
            if (i == 1) {
                int i4;
                if (((C0183h) l.get(0)).isActionViewExpanded()) {
                    i4 = 0;
                } else {
                    i4 = 1;
                }
                i3 = i4;
            } else {
                if (i <= 0) {
                    i2 = 0;
                }
                i3 = i2;
            }
        }
        if (i3 != 0) {
            if (this.mOverflowButton == null) {
                this.mOverflowButton = new OverflowMenuButton(this.mSystemContext);
            }
            viewGroup = (ViewGroup) this.mOverflowButton.getParent();
            if (viewGroup != this.mMenuView) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.mOverflowButton);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.mMenuView;
                actionMenuView.addView(this.mOverflowButton, actionMenuView.generateOverflowButtonLayoutParams());
            }
        } else if (this.mOverflowButton != null && this.mOverflowButton.getParent() == this.mMenuView) {
            ((ViewGroup) this.mMenuView).removeView(this.mOverflowButton);
        }
        ((ActionMenuView) this.mMenuView).setOverflowReserved(this.mReserveOverflow);
    }

    public boolean filterLeftoverView(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.mOverflowButton) {
            return false;
        }
        return super.filterLeftoverView(viewGroup, i);
    }

    public boolean onSubMenuSelected(C0195p c0195p) {
        if (!c0195p.hasVisibleItems()) {
            return false;
        }
        C0195p c0195p2 = c0195p;
        while (c0195p2.m197s() != this.mMenu) {
            c0195p2 = (C0195p) c0195p2.m197s();
        }
        View findViewForItem = findViewForItem(c0195p2.getItem());
        if (findViewForItem == null) {
            if (this.mOverflowButton == null) {
                return false;
            }
            findViewForItem = this.mOverflowButton;
        }
        this.mOpenSubMenuId = c0195p.getItem().getItemId();
        this.mActionButtonPopup = new ActionButtonSubmenu(this, this.mContext, c0195p);
        this.mActionButtonPopup.setAnchorView(findViewForItem);
        this.mActionButtonPopup.show();
        super.onSubMenuSelected(c0195p);
        return true;
    }

    private View findViewForItem(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.mMenuView;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof C0170a) && ((C0170a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public boolean showOverflowMenu() {
        if (!this.mReserveOverflow || isOverflowMenuShowing() || this.mMenu == null || this.mMenuView == null || this.mPostedOpenRunnable != null || this.mMenu.m145l().isEmpty()) {
            return false;
        }
        this.mPostedOpenRunnable = new OpenOverflowRunnable(new OverflowPopup(this.mContext, this.mMenu, this.mOverflowButton, true));
        ((View) this.mMenuView).post(this.mPostedOpenRunnable);
        super.onSubMenuSelected(null);
        return true;
    }

    public boolean hideOverflowMenu() {
        if (this.mPostedOpenRunnable == null || this.mMenuView == null) {
            C0192k c0192k = this.mOverflowPopup;
            if (c0192k == null) {
                return false;
            }
            c0192k.dismiss();
            return true;
        }
        ((View) this.mMenuView).removeCallbacks(this.mPostedOpenRunnable);
        this.mPostedOpenRunnable = null;
        return true;
    }

    public boolean dismissPopupMenus() {
        return hideOverflowMenu() | hideSubMenus();
    }

    public boolean hideSubMenus() {
        if (this.mActionButtonPopup == null) {
            return false;
        }
        this.mActionButtonPopup.dismiss();
        return true;
    }

    public boolean isOverflowMenuShowing() {
        return this.mOverflowPopup != null && this.mOverflowPopup.isShowing();
    }

    public boolean isOverflowMenuShowPending() {
        return this.mPostedOpenRunnable != null || isOverflowMenuShowing();
    }

    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }

    public boolean flagActionItems() {
        int i;
        ArrayList i2 = this.mMenu.m142i();
        int size = i2.size();
        int i3 = this.mMaxItems;
        int i4 = this.mActionItemWidthLimit;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.mMenuView;
        int i5 = 0;
        int i6 = 0;
        Object obj = null;
        int i7 = 0;
        while (i7 < size) {
            C0183h c0183h = (C0183h) i2.get(i7);
            if (c0183h.m176k()) {
                i5++;
            } else if (c0183h.m175j()) {
                i6++;
            } else {
                obj = 1;
            }
            if (this.mExpandedActionViewsExclusive && c0183h.isActionViewExpanded()) {
                i = 0;
            } else {
                i = i3;
            }
            i7++;
            i3 = i;
        }
        if (this.mReserveOverflow && (r4 != null || i5 + i6 > i3)) {
            i3--;
        }
        i7 = i3 - i5;
        SparseBooleanArray sparseBooleanArray = this.mActionButtonGroups;
        sparseBooleanArray.clear();
        i = 0;
        if (this.mStrictWidthLimit) {
            i = i4 / this.mMinCellSize;
            i6 = ((i4 % this.mMinCellSize) / i) + this.mMinCellSize;
        } else {
            i6 = 0;
        }
        int i8 = 0;
        i3 = 0;
        int i9 = i;
        while (i8 < size) {
            c0183h = (C0183h) i2.get(i8);
            int i10;
            if (c0183h.m176k()) {
                View itemView = getItemView(c0183h, this.mScrapActionButtonView, viewGroup);
                if (this.mScrapActionButtonView == null) {
                    this.mScrapActionButtonView = itemView;
                }
                if (this.mStrictWidthLimit) {
                    i9 -= ActionMenuView.measureChildForCells(itemView, i6, i9, makeMeasureSpec, 0);
                } else {
                    itemView.measure(makeMeasureSpec, makeMeasureSpec);
                }
                i5 = itemView.getMeasuredWidth();
                i10 = i4 - i5;
                if (i3 != 0) {
                    i5 = i3;
                }
                i3 = c0183h.getGroupId();
                if (i3 != 0) {
                    sparseBooleanArray.put(i3, true);
                }
                c0183h.m168d(true);
                i = i10;
                i3 = i7;
            } else if (c0183h.m175j()) {
                boolean z;
                int groupId = c0183h.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId);
                boolean z3 = (i7 > 0 || z2) && i4 > 0 && (!this.mStrictWidthLimit || i9 > 0);
                if (z3) {
                    View itemView2 = getItemView(c0183h, this.mScrapActionButtonView, viewGroup);
                    if (this.mScrapActionButtonView == null) {
                        this.mScrapActionButtonView = itemView2;
                    }
                    boolean z4;
                    if (this.mStrictWidthLimit) {
                        int measureChildForCells = ActionMenuView.measureChildForCells(itemView2, i6, i9, makeMeasureSpec, 0);
                        i10 = i9 - measureChildForCells;
                        if (measureChildForCells == 0) {
                            i9 = 0;
                        } else {
                            z4 = z3;
                        }
                        i5 = i10;
                    } else {
                        itemView2.measure(makeMeasureSpec, makeMeasureSpec);
                        boolean z5 = z3;
                        i5 = i9;
                        z4 = z5;
                    }
                    i10 = itemView2.getMeasuredWidth();
                    i4 -= i10;
                    if (i3 == 0) {
                        i3 = i10;
                    }
                    if (this.mStrictWidthLimit) {
                        z = i9 & (i4 >= 0 ? 1 : 0);
                        i10 = i3;
                        i3 = i5;
                    } else {
                        z = i9 & (i4 + i3 > 0 ? 1 : 0);
                        i10 = i3;
                        i3 = i5;
                    }
                } else {
                    z = z3;
                    i10 = i3;
                    i3 = i9;
                }
                if (z && groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                    i9 = i7;
                } else if (z2) {
                    sparseBooleanArray.put(groupId, false);
                    i5 = i7;
                    for (i7 = 0; i7 < i8; i7++) {
                        C0183h c0183h2 = (C0183h) i2.get(i7);
                        if (c0183h2.getGroupId() == groupId) {
                            if (c0183h2.m174i()) {
                                i5++;
                            }
                            c0183h2.m168d(false);
                        }
                    }
                    i9 = i5;
                } else {
                    i9 = i7;
                }
                if (z) {
                    i9--;
                }
                c0183h.m168d(z);
                i5 = i10;
                i = i4;
                int i11 = i3;
                i3 = i9;
                i9 = i11;
            } else {
                c0183h.m168d(false);
                i5 = i3;
                i = i4;
                i3 = i7;
            }
            i8++;
            i4 = i;
            i7 = i3;
            i3 = i5;
        }
        return true;
    }

    public void onCloseMenu(C0180f c0180f, boolean z) {
        dismissPopupMenus();
        super.onCloseMenu(c0180f, z);
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState();
        savedState.openSubMenuId = this.mOpenSubMenuId;
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        if (savedState.openSubMenuId > 0) {
            MenuItem findItem = this.mMenu.findItem(savedState.openSubMenuId);
            if (findItem != null) {
                onSubMenuSelected((C0195p) findItem.getSubMenu());
            }
        }
    }

    public void onSubUiVisibilityChanged(boolean z) {
        if (z) {
            super.onSubMenuSelected(null);
        } else {
            this.mMenu.m120a(false);
        }
    }

    public void setMenuView(ActionMenuView actionMenuView) {
        this.mMenuView = actionMenuView;
        actionMenuView.initialize(this.mMenu);
    }
}
