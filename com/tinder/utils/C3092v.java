package com.tinder.utils;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;

/* renamed from: com.tinder.utils.v */
public class C3092v {
    public static void m9460a(ListView listView, float f) {
        ListAdapter adapter = listView.getAdapter();
        if (adapter != null) {
            int i = 0;
            for (int i2 = 0; i2 < adapter.getCount(); i2++) {
                View view = adapter.getView(i2, null, listView);
                if (view == null) {
                    view = listView.getChildAt(0);
                }
                view.measure(-2, -2);
                i = (int) (((float) i) + (((float) view.getMeasuredHeight()) * f));
            }
            LayoutParams layoutParams = listView.getLayoutParams();
            layoutParams.height = (listView.getDividerHeight() * (adapter.getCount() - 1)) + i;
            listView.setLayoutParams(layoutParams);
            listView.requestLayout();
        }
    }
}
