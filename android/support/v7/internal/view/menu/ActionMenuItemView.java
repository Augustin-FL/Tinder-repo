package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.C0159R;
import android.support.v7.internal.view.menu.C0172m.C0170a;
import android.support.v7.internal.view.menu.C0180f.C0171b;
import android.support.v7.widget.ActionMenuView.ActionMenuChildView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.ListPopupWindow.ForwardingListener;
import android.support.v7.widget.RecyclerView.SmoothScroller.Action;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Toast;

public class ActionMenuItemView extends AppCompatTextView implements C0170a, ActionMenuChildView, OnClickListener, OnLongClickListener {
    private C0183h f61a;
    private CharSequence f62b;
    private Drawable f63c;
    private C0171b f64d;
    private ForwardingListener f65e;
    private C0169b f66f;
    private boolean f67g;
    private boolean f68h;
    private int f69i;
    private int f70j;
    private int f71k;

    /* renamed from: android.support.v7.internal.view.menu.ActionMenuItemView.a */
    private class C0168a extends ForwardingListener {
        final /* synthetic */ ActionMenuItemView f60a;

        public C0168a(ActionMenuItemView actionMenuItemView) {
            this.f60a = actionMenuItemView;
            super(actionMenuItemView);
        }

        public ListPopupWindow getPopup() {
            if (this.f60a.f66f != null) {
                return this.f60a.f66f.getPopup();
            }
            return null;
        }

        protected boolean onForwardingStarted() {
            if (this.f60a.f64d == null || !this.f60a.f64d.invokeItem(this.f60a.f61a)) {
                return false;
            }
            ListPopupWindow popup = getPopup();
            if (popup == null || !popup.isShowing()) {
                return false;
            }
            return true;
        }
    }

    /* renamed from: android.support.v7.internal.view.menu.ActionMenuItemView.b */
    public static abstract class C0169b {
        public abstract ListPopupWindow getPopup();
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.f67g = resources.getBoolean(C0159R.bool.abc_config_allowActionMenuItemTextWithIcon);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0159R.styleable.ActionMenuItemView, i, 0);
        this.f69i = obtainStyledAttributes.getDimensionPixelSize(C0159R.styleable.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.f71k = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        setOnLongClickListener(this);
        this.f70j = -1;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        this.f67g = getContext().getResources().getBoolean(C0159R.bool.abc_config_allowActionMenuItemTextWithIcon);
        m69c();
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.f70j = i;
        super.setPadding(i, i2, i3, i4);
    }

    public C0183h getItemData() {
        return this.f61a;
    }

    public void m70a(C0183h c0183h, int i) {
        this.f61a = c0183h;
        setIcon(c0183h.getIcon());
        setTitle(c0183h.m157a((C0170a) this));
        setId(c0183h.getItemId());
        setVisibility(c0183h.isVisible() ? 0 : 8);
        setEnabled(c0183h.isEnabled());
        if (c0183h.hasSubMenu() && this.f65e == null) {
            this.f65e = new C0168a(this);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f61a.hasSubMenu() && this.f65e != null && this.f65e.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void onClick(View view) {
        if (this.f64d != null) {
            this.f64d.invokeItem(this.f61a);
        }
    }

    public void setItemInvoker(C0171b c0171b) {
        this.f64d = c0171b;
    }

    public void setPopupCallback(C0169b c0169b) {
        this.f66f = c0169b;
    }

    public boolean m71a() {
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.f68h != z) {
            this.f68h = z;
            if (this.f61a != null) {
                this.f61a.m172g();
            }
        }
    }

    private void m69c() {
        int i = 0;
        int i2 = !TextUtils.isEmpty(this.f62b) ? 1 : 0;
        if (this.f63c == null || (this.f61a.m177l() && (this.f67g || this.f68h))) {
            i = 1;
        }
        setText((i2 & i) != 0 ? this.f62b : null);
    }

    public void setIcon(Drawable drawable) {
        this.f63c = drawable;
        if (drawable != null) {
            float f;
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > this.f71k) {
                f = ((float) this.f71k) / ((float) intrinsicWidth);
                intrinsicWidth = this.f71k;
                intrinsicHeight = (int) (((float) intrinsicHeight) * f);
            }
            if (intrinsicHeight > this.f71k) {
                f = ((float) this.f71k) / ((float) intrinsicHeight);
                intrinsicHeight = this.f71k;
                intrinsicWidth = (int) (((float) intrinsicWidth) * f);
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, null, null, null);
        m69c();
    }

    public boolean m72b() {
        return !TextUtils.isEmpty(getText());
    }

    public void setTitle(CharSequence charSequence) {
        this.f62b = charSequence;
        setContentDescription(this.f62b);
        m69c();
    }

    public boolean needsDividerBefore() {
        return m72b() && this.f61a.getIcon() == null;
    }

    public boolean needsDividerAfter() {
        return m72b();
    }

    public boolean onLongClick(View view) {
        if (m72b()) {
            return false;
        }
        int[] iArr = new int[2];
        Rect rect = new Rect();
        getLocationOnScreen(iArr);
        getWindowVisibleDisplayFrame(rect);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i = iArr[1] + (height / 2);
        int i2 = iArr[0] + (width / 2);
        if (ViewCompat.getLayoutDirection(view) == 0) {
            i2 = context.getResources().getDisplayMetrics().widthPixels - i2;
        }
        Toast makeText = Toast.makeText(context, this.f61a.getTitle(), 0);
        if (i < rect.height()) {
            makeText.setGravity(8388661, i2, height);
        } else {
            makeText.setGravity(81, 0, height);
        }
        makeText.show();
        return true;
    }

    protected void onMeasure(int i, int i2) {
        boolean b = m72b();
        if (b && this.f70j >= 0) {
            super.setPadding(this.f70j, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        size = mode == Action.UNDEFINED_DURATION ? Math.min(size, this.f69i) : this.f69i;
        if (mode != 1073741824 && this.f69i > 0 && measuredWidth < size) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), i2);
        }
        if (!b && this.f63c != null) {
            super.setPadding((getMeasuredWidth() - this.f63c.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }
}
