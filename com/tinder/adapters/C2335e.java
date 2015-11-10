package com.tinder.adapters;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tinder.R;
import com.tinder.managers.ManagerApp;
import com.tinder.model.TinderLocation;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tinder.adapters.e */
public class C2335e extends BaseAdapter {
    private List<TinderLocation> f4084a;

    /* renamed from: com.tinder.adapters.e.a */
    private class C2334a {
        TextView f4081a;
        TextView f4082b;
        final /* synthetic */ C2335e f4083c;

        private C2334a(C2335e c2335e) {
            this.f4083c = c2335e;
        }
    }

    public C2335e() {
        this.f4084a = new ArrayList();
    }

    public void m6377a(List<TinderLocation> list) {
        this.f4084a = list;
    }

    public void m6376a() {
        this.f4084a = new ArrayList();
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.f4084a.size();
    }

    public Object getItem(int i) {
        return this.f4084a.get(i);
    }

    public long getItemId(int i) {
        return 0;
    }

    @Nullable
    public View getView(int i, @Nullable View view, @NonNull ViewGroup viewGroup) {
        int i2 = 0;
        if (view == null || view.getTag() == null) {
            view = ViewGroup.inflate(ManagerApp.m7917h(), R.layout.cell_location_search_result, null);
            C2334a c2334a = new C2334a();
            c2334a.f4081a = (TextView) view.findViewById(R.id.search_result_txtView_primary);
            c2334a.f4082b = (TextView) view.findViewById(R.id.search_result_txtView_secondary);
            view.setTag(c2334a);
        }
        Pair labels = ((TinderLocation) this.f4084a.get(i)).getLabels();
        int i3 = !TextUtils.isEmpty((CharSequence) labels.second) ? 1 : 0;
        C2334a c2334a2 = (C2334a) view.getTag();
        c2334a2.f4081a.setText((CharSequence) labels.first);
        TextView textView = c2334a2.f4082b;
        if (i3 == 0) {
            i2 = 8;
        }
        textView.setVisibility(i2);
        c2334a2.f4082b.setText((CharSequence) labels.second);
        return view;
    }
}
