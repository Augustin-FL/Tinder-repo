package com.tinder.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tinder.R;
import com.tinder.model.InstagramPhoto;
import com.tinder.picassowebp.picasso.Picasso;
import com.tinder.utils.al;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tinder.adapters.s */
public class C2366s extends PagerAdapter {
    int f4193a;
    int f4194b;
    private Context f4195c;
    private List<InstagramPhoto> f4196d;
    private OnClickListener f4197e;

    public /* synthetic */ Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
        return m6449a(viewGroup, i);
    }

    public C2366s(Context context, List<InstagramPhoto> list, OnClickListener onClickListener) {
        this.f4196d = new ArrayList();
        this.f4195c = context;
        this.f4196d = list;
        this.f4193a = al.m9262a(this.f4195c);
        this.f4194b = this.f4193a;
        this.f4197e = onClickListener;
    }

    public int getCount() {
        return this.f4196d != null ? this.f4196d.size() : 0;
    }

    public View m6449a(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(this.f4195c).inflate(R.layout.instagram_photo_full, viewGroup, false);
        m6448a(inflate, i);
        ((ViewPager) viewGroup).addView(inflate, 0);
        return inflate;
    }

    public void destroyItem(@NonNull ViewGroup viewGroup, int i, Object obj) {
        ((ViewPager) viewGroup).removeView((View) obj);
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    private void m6448a(View view, int i) {
        InstagramPhoto instagramPhoto = (InstagramPhoto) this.f4196d.get(i);
        ImageView imageView = (ImageView) view;
        imageView.setOnClickListener(this.f4197e);
        Picasso.m8982a(this.f4195c).m8990a(instagramPhoto.getUrl()).m9129b(this.f4193a, this.f4194b).m9127b().m9124a(imageView);
    }
}
