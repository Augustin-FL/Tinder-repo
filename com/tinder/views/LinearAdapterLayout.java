package com.tinder.views;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

public class LinearAdapterLayout extends LinearLayout {
    private BaseAdapter mAdapter;
    private View mFooter;
    private View mHeader;
    private DataSetObserver mObserver;
    private OnClickListener mOnClickListenerExternal;
    private OnClickListener mOnClickListenerInternal;

    /* renamed from: com.tinder.views.LinearAdapterLayout.1 */
    class C31171 implements OnClickListener {
        C31171() {
        }

        public void onClick(View view) {
            LinearAdapterLayout.this.mOnClickListenerExternal.onClick(view);
        }
    }

    private class Observer extends DataSetObserver {
        private Observer() {
        }

        public void onChanged() {
            super.onChanged();
            LinearAdapterLayout.this.layoutFromAdapter();
        }
    }

    public LinearAdapterLayout(Context context) {
        super(context);
        init();
    }

    public LinearAdapterLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public LinearAdapterLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public LinearAdapterLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init();
    }

    private void init() {
        this.mObserver = new Observer();
    }

    public void setOnClickListenerForItems(OnClickListener onClickListener) {
        this.mOnClickListenerExternal = onClickListener;
        this.mOnClickListenerInternal = new C31171();
    }

    public void setAdapter(BaseAdapter baseAdapter) {
        this.mAdapter = baseAdapter;
        this.mAdapter.registerDataSetObserver(this.mObserver);
        this.mObserver.onChanged();
    }

    public BaseAdapter getAdapter() {
        return this.mAdapter;
    }

    public void setHeader(View view) {
        this.mHeader = view;
        if (this.mAdapter != null) {
            this.mObserver.onChanged();
        }
    }

    public View getHeader() {
        return this.mHeader;
    }

    public void setFooter(View view) {
        this.mFooter = view;
        if (this.mAdapter != null) {
            this.mObserver.onChanged();
        }
    }

    private void layoutFromAdapter() {
        int i = 1;
        int i2 = 0;
        int count = this.mAdapter.getCount();
        int i3 = this.mHeader != null ? 1 : 0;
        if (this.mFooter == null) {
            i = 0;
        }
        removeAllViews();
        if (i3 != 0) {
            addView(this.mHeader);
        }
        for (i3 = 0; i3 < count; i3++) {
            addView(this.mAdapter.getView(i3, null, this));
        }
        if (i != 0) {
            addView(this.mFooter);
        }
        while (i2 < getChildCount()) {
            getChildAt(i2).setOnClickListener(this.mOnClickListenerInternal);
            i2++;
        }
    }

    public View getFooter() {
        return this.mFooter;
    }
}
