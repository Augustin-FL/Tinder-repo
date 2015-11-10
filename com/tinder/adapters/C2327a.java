package com.tinder.adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tinder.R;
import com.tinder.model.FacebookPhoto;
import com.tinder.picassowebp.picasso.Picasso;
import com.tinder.utils.al;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tinder.adapters.a */
public class C2327a extends BaseAdapter {
    @NonNull
    private final Activity f4047a;
    @NonNull
    private final LayoutInflater f4048b;
    private final int f4049c;
    private List<FacebookPhoto> f4050d;

    /* renamed from: com.tinder.adapters.a.a */
    static class C2326a {
        @Nullable
        View f4045a;
        ImageView f4046b;

        C2326a() {
        }
    }

    public C2327a(@NonNull Activity activity) {
        this.f4047a = activity;
        this.f4048b = LayoutInflater.from(activity);
        this.f4050d = new ArrayList();
        this.f4049c = al.m9286b(activity).x / 3;
    }

    public void m6363a(@NonNull List<FacebookPhoto> list) {
        this.f4050d.addAll(list);
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.f4050d.size();
    }

    public Object getItem(int i) {
        return Integer.valueOf(this.f4050d.indexOf(Integer.valueOf(i)));
    }

    public long getItemId(int i) {
        return (long) this.f4050d.indexOf(Integer.valueOf(i));
    }

    @Nullable
    public View getView(int i, @Nullable View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f4048b.inflate(R.layout.griditem_photo, null);
            C2326a c2326a = new C2326a();
            c2326a.f4045a = view;
            c2326a.f4046b = (ImageView) view.findViewById(R.id.gridphoto);
            view.setTag(c2326a);
        }
        C2326a c2326a2 = (C2326a) view.getTag();
        Picasso.m8982a(this.f4047a).m8990a(((FacebookPhoto) this.f4050d.get(i)).getThumb()).m9129b(this.f4049c, this.f4049c).m9127b().m9124a(c2326a2.f4046b);
        c2326a2.f4045a.setMinimumHeight(this.f4049c);
        c2326a2.f4045a.setMinimumWidth(this.f4049c);
        c2326a2.f4046b.setMinimumWidth(this.f4049c);
        c2326a2.f4046b.setMinimumHeight(this.f4049c);
        c2326a2.f4046b.setBackgroundResource(R.color.gray_very_light);
        return view;
    }

    public String m6362a(int i) {
        return ((FacebookPhoto) this.f4050d.get(i)).getSourceUrl();
    }

    public String m6364b(int i) {
        return ((FacebookPhoto) this.f4050d.get(i)).getId();
    }
}
