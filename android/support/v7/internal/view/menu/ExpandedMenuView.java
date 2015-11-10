package android.support.v7.internal.view.menu;

import android.content.Context;
import android.support.v7.internal.view.menu.C0180f.C0171b;
import android.support.v7.internal.widget.TintTypedArray;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public final class ExpandedMenuView extends ListView implements C0171b, C0172m, OnItemClickListener {
    private static final int[] f72a;
    private C0180f f73b;
    private int f74c;

    static {
        f72a = new int[]{16842964, 16843049};
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, f72a, i, 0);
        if (obtainStyledAttributes.hasValue(0)) {
            setBackgroundDrawable(obtainStyledAttributes.getDrawable(0));
        }
        if (obtainStyledAttributes.hasValue(1)) {
            setDivider(obtainStyledAttributes.getDrawable(1));
        }
        obtainStyledAttributes.recycle();
    }

    public void initialize(C0180f c0180f) {
        this.f73b = c0180f;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public boolean invokeItem(C0183h c0183h) {
        return this.f73b.m122a((MenuItem) c0183h, 0);
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        invokeItem((C0183h) getAdapter().getItem(i));
    }

    public int getWindowAnimations() {
        return this.f74c;
    }
}
