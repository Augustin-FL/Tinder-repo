package com.tinder.adapters;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tinder.R;
import com.tinder.managers.ManagerApp;
import com.tinder.model.TinderLocation;
import java.util.List;

/* renamed from: com.tinder.adapters.l */
public class C2356l extends BaseAdapter {
    public static int f4167b;
    public static int f4168c;
    public TinderLocation f4169a;
    private List<TinderLocation> f4170d;

    /* renamed from: com.tinder.adapters.l.a */
    public static class C2355a {
        public TextView f4164a;
        public ImageView f4165b;
        public ImageView f4166c;
    }

    public C2356l(List<TinderLocation> list) {
        this.f4170d = list;
        f4167b = ManagerApp.m7917h().getResources().getColor(R.color.premium_blue);
        f4168c = ManagerApp.m7917h().getResources().getColor(R.color.gray_very_light);
    }

    public void m6414a(@NonNull List<TinderLocation> list) {
        this.f4170d = list;
    }

    public int getCount() {
        return this.f4170d.size();
    }

    public Object getItem(int i) {
        return this.f4170d.get(i);
    }

    public long getItemId(int i) {
        return 0;
    }

    @Nullable
    public View getView(int i, @Nullable View view, @NonNull ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = ViewGroup.inflate(viewGroup.getContext(), R.layout.cell_recent_passport, null);
            C2355a c2355a = new C2355a();
            c2355a.f4164a = (TextView) view.findViewById(R.id.purchased_location_name);
            c2355a.f4165b = (ImageView) view.findViewById(R.id.purchased_location_img);
            c2355a.f4166c = (ImageView) view.findViewById(R.id.purchased_location_check);
            view.setTag(c2355a);
        }
        C2355a c2355a2 = (C2355a) view.getTag();
        TinderLocation tinderLocation = (TinderLocation) this.f4170d.get(i);
        Pair labels = tinderLocation.getLabels();
        CharSequence charSequence = (String) labels.first;
        if (!TextUtils.isEmpty((CharSequence) labels.second)) {
            charSequence = charSequence + ", " + ((String) labels.second);
        }
        c2355a2.f4164a.setText(charSequence);
        if (this.f4169a == null || !tinderLocation.equals(this.f4169a)) {
            c2355a2.f4166c.setVisibility(4);
            c2355a2.f4165b.setColorFilter(f4168c);
        } else {
            c2355a2.f4166c.setVisibility(0);
            c2355a2.f4165b.setColorFilter(f4167b);
        }
        return view;
    }

    public void m6413a(TinderLocation tinderLocation) {
        this.f4169a = tinderLocation;
        notifyDataSetChanged();
    }
}
