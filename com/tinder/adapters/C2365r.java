package com.tinder.adapters;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tinder.R;
import com.tinder.picassowebp.picasso.Picasso;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/* renamed from: com.tinder.adapters.r */
public class C2365r extends PagerAdapter {
    private static final HashMap<String, C2364a> f4190c;
    private Context f4191a;
    private List<C2364a> f4192b;

    /* renamed from: com.tinder.adapters.r.a */
    private static class C2364a {
        private int f4187a;
        private int f4188b;
        private int f4189c;

        public C2364a(@DrawableRes int i, @StringRes int i2, @StringRes int i3) {
            this.f4187a = i;
            this.f4188b = i2;
            this.f4189c = i3;
        }

        public int m6444a() {
            return this.f4187a;
        }

        public int m6445b() {
            return this.f4188b;
        }

        public int m6446c() {
            return this.f4189c;
        }
    }

    static {
        f4190c = new HashMap(5);
        f4190c.put("unlimited_likes", new C2364a(R.drawable.paywall_like, R.string.paywall_title_likes, R.string.paywall_byline_likes));
        f4190c.put("undo", new C2364a(R.drawable.paywall_undo, R.string.paywall_title_undo, R.string.paywall_byline_undo));
        f4190c.put("no_ads", new C2364a(R.drawable.paywall_ads, R.string.paywall_title_ads, R.string.paywall_byline_ads));
        f4190c.put("passport", new C2364a(R.drawable.paywall_passport, R.string.paywall_title_passport, R.string.paywall_byline_passport));
        f4190c.put("super_like", new C2364a(R.drawable.paywall_super, R.string.paywall_title_superlike, R.string.paywall_byline_superlike));
    }

    public C2365r(@NonNull Context context, @Nullable List<String> list) {
        this.f4191a = context;
        if (list != null) {
            this.f4192b = new ArrayList(list.size());
            for (String str : list) {
                if (f4190c.containsKey(str)) {
                    this.f4192b.add(f4190c.get(str));
                }
            }
        }
        if (this.f4192b == null || this.f4192b.isEmpty()) {
            this.f4192b = new ArrayList(f4190c.size());
            for (Entry value : f4190c.entrySet()) {
                this.f4192b.add(value.getValue());
            }
        }
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        C2364a a = m6447a(i);
        View inflate = LayoutInflater.from(this.f4191a).inflate(R.layout.paywall_perk, viewGroup, false);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.paywall_perk_image);
        TextView textView = (TextView) inflate.findViewById(R.id.paywall_perk_byline);
        ((TextView) inflate.findViewById(R.id.paywall_perk_title)).setText(a.m6445b());
        textView.setText(a.m6446c());
        imageView.setContentDescription(this.f4191a.getResources().getString(a.m6446c()));
        viewGroup.addView(inflate);
        Picasso.m8982a(this.f4191a).m8987a(a.m6444a()).m9124a(imageView);
        return inflate;
    }

    public C2364a m6447a(int i) {
        return (C2364a) this.f4192b.get(i);
    }

    public int getCount() {
        return this.f4192b.size();
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
