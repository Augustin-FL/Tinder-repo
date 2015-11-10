package android.support.v7.internal.widget;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.C0159R;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.ListPopupWindow.ForwardingListener;
import android.support.v7.widget.RecyclerView.SmoothScroller.Action;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.SpinnerAdapter;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

class SpinnerCompat extends AbsSpinnerCompat implements OnClickListener {
    private static final int MAX_ITEMS_MEASURED = 15;
    public static final int MODE_DIALOG = 0;
    public static final int MODE_DROPDOWN = 1;
    private static final int MODE_THEME = -1;
    private static final String TAG = "Spinner";
    private boolean mDisableChildrenWhenDisabled;
    int mDropDownWidth;
    private ForwardingListener mForwardingListener;
    private int mGravity;
    private SpinnerPopup mPopup;
    private DropDownAdapter mTempAdapter;
    private Rect mTempRect;
    private final TintManager mTintManager;

    /* renamed from: android.support.v7.internal.widget.SpinnerCompat.1 */
    class C02121 extends ForwardingListener {
        final /* synthetic */ DropdownPopup val$popup;

        C02121(View view, DropdownPopup dropdownPopup) {
            this.val$popup = dropdownPopup;
            super(view);
        }

        public ListPopupWindow getPopup() {
            return this.val$popup;
        }

        public boolean onForwardingStarted() {
            if (!SpinnerCompat.this.mPopup.isShowing()) {
                SpinnerCompat.this.mPopup.show();
            }
            return true;
        }
    }

    /* renamed from: android.support.v7.internal.widget.SpinnerCompat.2 */
    class C02132 implements OnGlobalLayoutListener {
        C02132() {
        }

        public void onGlobalLayout() {
            if (!SpinnerCompat.this.mPopup.isShowing()) {
                SpinnerCompat.this.mPopup.show();
            }
            ViewTreeObserver viewTreeObserver = SpinnerCompat.this.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeGlobalOnLayoutListener(this);
            }
        }
    }

    private interface SpinnerPopup {
        void dismiss();

        Drawable getBackground();

        CharSequence getHintText();

        int getHorizontalOffset();

        int getVerticalOffset();

        boolean isShowing();

        void setAdapter(ListAdapter listAdapter);

        void setBackgroundDrawable(Drawable drawable);

        void setHorizontalOffset(int i);

        void setPromptText(CharSequence charSequence);

        void setVerticalOffset(int i);

        void show();
    }

    private class DialogPopup implements OnClickListener, SpinnerPopup {
        private ListAdapter mListAdapter;
        private AlertDialog mPopup;
        private CharSequence mPrompt;

        private DialogPopup() {
        }

        public void dismiss() {
            if (this.mPopup != null) {
                this.mPopup.dismiss();
                this.mPopup = null;
            }
        }

        public boolean isShowing() {
            return this.mPopup != null ? this.mPopup.isShowing() : false;
        }

        public void setAdapter(ListAdapter listAdapter) {
            this.mListAdapter = listAdapter;
        }

        public void setPromptText(CharSequence charSequence) {
            this.mPrompt = charSequence;
        }

        public CharSequence getHintText() {
            return this.mPrompt;
        }

        public void show() {
            if (this.mListAdapter != null) {
                Builder builder = new Builder(SpinnerCompat.this.getContext());
                if (this.mPrompt != null) {
                    builder.setTitle(this.mPrompt);
                }
                this.mPopup = builder.setSingleChoiceItems(this.mListAdapter, SpinnerCompat.this.getSelectedItemPosition(), this).create();
                this.mPopup.show();
            }
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            SpinnerCompat.this.setSelection(i);
            if (SpinnerCompat.this.mOnItemClickListener != null) {
                SpinnerCompat.this.performItemClick(null, i, this.mListAdapter.getItemId(i));
            }
            dismiss();
        }

        public void setBackgroundDrawable(Drawable drawable) {
            Log.e(SpinnerCompat.TAG, "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        public void setVerticalOffset(int i) {
            Log.e(SpinnerCompat.TAG, "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        public void setHorizontalOffset(int i) {
            Log.e(SpinnerCompat.TAG, "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        public Drawable getBackground() {
            return null;
        }

        public int getVerticalOffset() {
            return SpinnerCompat.MODE_DIALOG;
        }

        public int getHorizontalOffset() {
            return SpinnerCompat.MODE_DIALOG;
        }
    }

    private static class DropDownAdapter implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter mAdapter;
        private ListAdapter mListAdapter;

        public DropDownAdapter(SpinnerAdapter spinnerAdapter) {
            this.mAdapter = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.mListAdapter = (ListAdapter) spinnerAdapter;
            }
        }

        public int getCount() {
            return this.mAdapter == null ? SpinnerCompat.MODE_DIALOG : this.mAdapter.getCount();
        }

        public Object getItem(int i) {
            return this.mAdapter == null ? null : this.mAdapter.getItem(i);
        }

        public long getItemId(int i) {
            return this.mAdapter == null ? -1 : this.mAdapter.getItemId(i);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            return this.mAdapter == null ? null : this.mAdapter.getDropDownView(i, view, viewGroup);
        }

        public boolean hasStableIds() {
            return this.mAdapter != null && this.mAdapter.hasStableIds();
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.mAdapter != null) {
                this.mAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.mAdapter != null) {
                this.mAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.mListAdapter;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.mListAdapter;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        public int getItemViewType(int i) {
            return SpinnerCompat.MODE_DIALOG;
        }

        public int getViewTypeCount() {
            return SpinnerCompat.MODE_DROPDOWN;
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }
    }

    private class DropdownPopup extends ListPopupWindow implements SpinnerPopup {
        private ListAdapter mAdapter;
        private CharSequence mHintText;

        /* renamed from: android.support.v7.internal.widget.SpinnerCompat.DropdownPopup.1 */
        class C02141 implements OnItemClickListener {
            final /* synthetic */ SpinnerCompat val$this$0;

            C02141(SpinnerCompat spinnerCompat) {
                this.val$this$0 = spinnerCompat;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                SpinnerCompat.this.setSelection(i);
                if (SpinnerCompat.this.mOnItemClickListener != null) {
                    SpinnerCompat.this.performItemClick(view, i, DropdownPopup.this.mAdapter.getItemId(i));
                }
                DropdownPopup.this.dismiss();
            }
        }

        /* renamed from: android.support.v7.internal.widget.SpinnerCompat.DropdownPopup.2 */
        class C02152 implements OnGlobalLayoutListener {
            C02152() {
            }

            public void onGlobalLayout() {
                DropdownPopup.this.computeContentWidth();
                super.show();
            }
        }

        /* renamed from: android.support.v7.internal.widget.SpinnerCompat.DropdownPopup.3 */
        class C02163 implements OnDismissListener {
            final /* synthetic */ OnGlobalLayoutListener val$layoutListener;

            C02163(OnGlobalLayoutListener onGlobalLayoutListener) {
                this.val$layoutListener = onGlobalLayoutListener;
            }

            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = SpinnerCompat.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.val$layoutListener);
                }
            }
        }

        public DropdownPopup(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            setAnchorView(SpinnerCompat.this);
            setModal(true);
            setPromptPosition(SpinnerCompat.MODE_DIALOG);
            setOnItemClickListener(new C02141(SpinnerCompat.this));
        }

        public void setAdapter(ListAdapter listAdapter) {
            super.setAdapter(listAdapter);
            this.mAdapter = listAdapter;
        }

        public CharSequence getHintText() {
            return this.mHintText;
        }

        public void setPromptText(CharSequence charSequence) {
            this.mHintText = charSequence;
        }

        void computeContentWidth() {
            int i;
            int i2;
            Drawable background = getBackground();
            if (background != null) {
                background.getPadding(SpinnerCompat.this.mTempRect);
                i = ViewUtils.isLayoutRtl(SpinnerCompat.this) ? SpinnerCompat.this.mTempRect.right : -SpinnerCompat.this.mTempRect.left;
            } else {
                Rect access$400 = SpinnerCompat.this.mTempRect;
                SpinnerCompat.this.mTempRect.right = SpinnerCompat.MODE_DIALOG;
                access$400.left = SpinnerCompat.MODE_DIALOG;
                i = SpinnerCompat.MODE_DIALOG;
            }
            int paddingLeft = SpinnerCompat.this.getPaddingLeft();
            int paddingRight = SpinnerCompat.this.getPaddingRight();
            int width = SpinnerCompat.this.getWidth();
            if (SpinnerCompat.this.mDropDownWidth == -2) {
                int measureContentWidth = SpinnerCompat.this.measureContentWidth((SpinnerAdapter) this.mAdapter, getBackground());
                i2 = (SpinnerCompat.this.getContext().getResources().getDisplayMetrics().widthPixels - SpinnerCompat.this.mTempRect.left) - SpinnerCompat.this.mTempRect.right;
                if (measureContentWidth <= i2) {
                    i2 = measureContentWidth;
                }
                setContentWidth(Math.max(i2, (width - paddingLeft) - paddingRight));
            } else if (SpinnerCompat.this.mDropDownWidth == SpinnerCompat.MODE_THEME) {
                setContentWidth((width - paddingLeft) - paddingRight);
            } else {
                setContentWidth(SpinnerCompat.this.mDropDownWidth);
            }
            if (ViewUtils.isLayoutRtl(SpinnerCompat.this)) {
                i2 = ((width - paddingRight) - getWidth()) + i;
            } else {
                i2 = i + paddingLeft;
            }
            setHorizontalOffset(i2);
        }

        public void show(int i, int i2) {
            boolean isShowing = isShowing();
            computeContentWidth();
            setInputMethodMode(2);
            super.show();
            getListView().setChoiceMode(SpinnerCompat.MODE_DROPDOWN);
            setSelection(SpinnerCompat.this.getSelectedItemPosition());
            if (!isShowing) {
                ViewTreeObserver viewTreeObserver = SpinnerCompat.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    OnGlobalLayoutListener c02152 = new C02152();
                    viewTreeObserver.addOnGlobalLayoutListener(c02152);
                    setOnDismissListener(new C02163(c02152));
                }
            }
        }
    }

    static class SavedState extends SavedState {
        public static final Creator<SavedState> CREATOR;
        boolean showDropdown;

        /* renamed from: android.support.v7.internal.widget.SpinnerCompat.SavedState.1 */
        static class C02171 implements Creator<SavedState> {
            C02171() {
            }

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(null);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.showDropdown = parcel.readByte() != null;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte((byte) (this.showDropdown ? SpinnerCompat.MODE_DROPDOWN : SpinnerCompat.MODE_DIALOG));
        }

        static {
            CREATOR = new C02171();
        }
    }

    SpinnerCompat(Context context) {
        this(context, null);
    }

    SpinnerCompat(Context context, int i) {
        this(context, null, C0159R.attr.spinnerStyle, i);
    }

    SpinnerCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0159R.attr.spinnerStyle);
    }

    SpinnerCompat(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, MODE_THEME);
    }

    SpinnerCompat(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.mTempRect = new Rect();
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, C0159R.styleable.Spinner, i, MODE_DIALOG);
        if (obtainStyledAttributes.hasValue(C0159R.styleable.Spinner_android_background)) {
            setBackgroundDrawable(obtainStyledAttributes.getDrawable(C0159R.styleable.Spinner_android_background));
        }
        if (i2 == MODE_THEME) {
            i2 = obtainStyledAttributes.getInt(C0159R.styleable.Spinner_spinnerMode, MODE_DIALOG);
        }
        switch (i2) {
            case MODE_DIALOG /*0*/:
                this.mPopup = new DialogPopup();
                break;
            case MODE_DROPDOWN /*1*/:
                Object dropdownPopup = new DropdownPopup(context, attributeSet, i);
                this.mDropDownWidth = obtainStyledAttributes.getLayoutDimension(C0159R.styleable.Spinner_android_dropDownWidth, -2);
                dropdownPopup.setBackgroundDrawable(obtainStyledAttributes.getDrawable(C0159R.styleable.Spinner_android_popupBackground));
                this.mPopup = dropdownPopup;
                this.mForwardingListener = new C02121(this, dropdownPopup);
                break;
        }
        this.mGravity = obtainStyledAttributes.getInt(C0159R.styleable.Spinner_android_gravity, 17);
        this.mPopup.setPromptText(obtainStyledAttributes.getString(C0159R.styleable.Spinner_prompt));
        this.mDisableChildrenWhenDisabled = obtainStyledAttributes.getBoolean(C0159R.styleable.Spinner_disableChildrenWhenDisabled, false);
        obtainStyledAttributes.recycle();
        if (this.mTempAdapter != null) {
            this.mPopup.setAdapter(this.mTempAdapter);
            this.mTempAdapter = null;
        }
        this.mTintManager = obtainStyledAttributes.getTintManager();
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        if (this.mPopup instanceof DropdownPopup) {
            ((DropdownPopup) this.mPopup).setBackgroundDrawable(drawable);
        } else {
            Log.e(TAG, "setPopupBackgroundDrawable: incompatible spinner mode; ignoring...");
        }
    }

    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(this.mTintManager.getDrawable(i));
    }

    public Drawable getPopupBackground() {
        return this.mPopup.getBackground();
    }

    public void setDropDownVerticalOffset(int i) {
        this.mPopup.setVerticalOffset(i);
    }

    public int getDropDownVerticalOffset() {
        return this.mPopup.getVerticalOffset();
    }

    public void setDropDownHorizontalOffset(int i) {
        this.mPopup.setHorizontalOffset(i);
    }

    public int getDropDownHorizontalOffset() {
        return this.mPopup.getHorizontalOffset();
    }

    public void setDropDownWidth(int i) {
        if (this.mPopup instanceof DropdownPopup) {
            this.mDropDownWidth = i;
        } else {
            Log.e(TAG, "Cannot set dropdown width for MODE_DIALOG, ignoring");
        }
    }

    public int getDropDownWidth() {
        return this.mDropDownWidth;
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (this.mDisableChildrenWhenDisabled) {
            int childCount = getChildCount();
            for (int i = MODE_DIALOG; i < childCount; i += MODE_DROPDOWN) {
                getChildAt(i).setEnabled(z);
            }
        }
    }

    public void setGravity(int i) {
        if (this.mGravity != i) {
            if ((i & 7) == 0) {
                i |= GravityCompat.START;
            }
            this.mGravity = i;
            requestLayout();
        }
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        super.setAdapter(spinnerAdapter);
        this.mRecycler.clear();
        if (getContext().getApplicationInfo().targetSdkVersion >= 21 && spinnerAdapter != null && spinnerAdapter.getViewTypeCount() != MODE_DROPDOWN) {
            throw new IllegalArgumentException("Spinner adapter view type count must be 1");
        } else if (this.mPopup != null) {
            this.mPopup.setAdapter(new DropDownAdapter(spinnerAdapter));
        } else {
            this.mTempAdapter = new DropDownAdapter(spinnerAdapter);
        }
    }

    public int getBaseline() {
        View view = null;
        if (getChildCount() > 0) {
            view = getChildAt(MODE_DIALOG);
        } else if (this.mAdapter != null && this.mAdapter.getCount() > 0) {
            view = makeView(MODE_DIALOG, false);
            this.mRecycler.put(MODE_DIALOG, view);
        }
        if (view == null) {
            return MODE_THEME;
        }
        int baseline = view.getBaseline();
        if (baseline >= 0) {
            return view.getTop() + baseline;
        }
        return MODE_THEME;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void setOnItemClickListener(AdapterViewCompat.OnItemClickListener onItemClickListener) {
        throw new RuntimeException("setOnItemClickListener cannot be used with a spinner.");
    }

    void setOnItemClickListenerInt(AdapterViewCompat.OnItemClickListener onItemClickListener) {
        super.setOnItemClickListener(onItemClickListener);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mForwardingListener == null || !this.mForwardingListener.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mPopup != null && MeasureSpec.getMode(i) == Action.UNDEFINED_DURATION) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), measureContentWidth(getAdapter(), getBackground())), MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mInLayout = true;
        layout(MODE_DIALOG, false);
        this.mInLayout = false;
    }

    void layout(int i, boolean z) {
        int i2 = this.mSpinnerPadding.left;
        int right = ((getRight() - getLeft()) - this.mSpinnerPadding.left) - this.mSpinnerPadding.right;
        if (this.mDataChanged) {
            handleDataChanged();
        }
        if (this.mItemCount == 0) {
            resetList();
            return;
        }
        if (this.mNextSelectedPosition >= 0) {
            setSelectedPositionInt(this.mNextSelectedPosition);
        }
        recycleAllViews();
        removeAllViewsInLayout();
        this.mFirstPosition = this.mSelectedPosition;
        if (this.mAdapter != null) {
            View makeView = makeView(this.mSelectedPosition, true);
            int measuredWidth = makeView.getMeasuredWidth();
            switch (GravityCompat.getAbsoluteGravity(this.mGravity, ViewCompat.getLayoutDirection(this)) & 7) {
                case MODE_DROPDOWN /*1*/:
                    i2 = (i2 + (right / 2)) - (measuredWidth / 2);
                    break;
                case C3374b.SmoothProgressBar_spb_speed /*5*/:
                    i2 = (i2 + right) - measuredWidth;
                    break;
            }
            makeView.offsetLeftAndRight(i2);
        }
        this.mRecycler.clear();
        invalidate();
        checkSelectionChanged();
        this.mDataChanged = false;
        this.mNeedSync = false;
        setNextSelectedPositionInt(this.mSelectedPosition);
    }

    private View makeView(int i, boolean z) {
        View view;
        if (!this.mDataChanged) {
            view = this.mRecycler.get(i);
            if (view != null) {
                setUpChild(view, z);
                return view;
            }
        }
        view = this.mAdapter.getView(i, null, this);
        setUpChild(view, z);
        return view;
    }

    private void setUpChild(View view, boolean z) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
        }
        if (z) {
            addViewInLayout(view, MODE_DIALOG, layoutParams);
        }
        view.setSelected(hasFocus());
        if (this.mDisableChildrenWhenDisabled) {
            view.setEnabled(isEnabled());
        }
        view.measure(ViewGroup.getChildMeasureSpec(this.mWidthMeasureSpec, this.mSpinnerPadding.left + this.mSpinnerPadding.right, layoutParams.width), ViewGroup.getChildMeasureSpec(this.mHeightMeasureSpec, this.mSpinnerPadding.top + this.mSpinnerPadding.bottom, layoutParams.height));
        int measuredHeight = this.mSpinnerPadding.top + ((((getMeasuredHeight() - this.mSpinnerPadding.bottom) - this.mSpinnerPadding.top) - view.getMeasuredHeight()) / 2);
        view.layout(MODE_DIALOG, measuredHeight, view.getMeasuredWidth() + MODE_DIALOG, view.getMeasuredHeight() + measuredHeight);
    }

    public boolean performClick() {
        boolean performClick = super.performClick();
        if (!performClick) {
            performClick = true;
            if (!this.mPopup.isShowing()) {
                this.mPopup.show();
            }
        }
        return performClick;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        setSelection(i);
        dialogInterface.dismiss();
    }

    public void setPrompt(CharSequence charSequence) {
        this.mPopup.setPromptText(charSequence);
    }

    public void setPromptId(int i) {
        setPrompt(getContext().getText(i));
    }

    public CharSequence getPrompt() {
        return this.mPopup.getHintText();
    }

    int measureContentWidth(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        if (spinnerAdapter == null) {
            return MODE_DIALOG;
        }
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(MODE_DIALOG, MODE_DIALOG);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(MODE_DIALOG, MODE_DIALOG);
        int max = Math.max(MODE_DIALOG, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + MAX_ITEMS_MEASURED);
        int max2 = Math.max(MODE_DIALOG, max - (15 - (min - max)));
        View view = null;
        int i = MODE_DIALOG;
        max = MODE_DIALOG;
        while (max2 < min) {
            View view2;
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != max) {
                view2 = null;
            } else {
                itemViewType = max;
                view2 = view;
            }
            view = spinnerAdapter.getView(max2, view2, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i = Math.max(i, view.getMeasuredWidth());
            max2 += MODE_DROPDOWN;
            max = itemViewType;
        }
        if (drawable == null) {
            return i;
        }
        drawable.getPadding(this.mTempRect);
        return (this.mTempRect.left + this.mTempRect.right) + i;
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        boolean z = this.mPopup != null && this.mPopup.isShowing();
        savedState.showDropdown = z;
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.showDropdown) {
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener(new C02132());
            }
        }
    }
}
