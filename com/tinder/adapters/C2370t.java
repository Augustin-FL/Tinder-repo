package com.tinder.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridLayout;
import android.widget.ImageView.ScaleType;
import com.tinder.R;
import com.tinder.model.InstagramPhoto;
import com.tinder.picassowebp.picasso.C2281x;
import com.tinder.picassowebp.picasso.Picasso;
import com.tinder.utils.C3095y;
import com.tinder.utils.al;
import com.tinder.views.RoundImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tinder.adapters.t */
public class C2370t extends PagerAdapter {
    private int f4200a;
    private int f4201b;
    private int f4202c;
    private int f4203d;
    private int f4204e;
    private int f4205f;
    @Nullable
    private List<InstagramPhoto> f4206g;
    private Context f4207h;
    private int f4208i;
    private int f4209j;
    private int f4210k;
    private int f4211l;
    private int f4212m;
    private int f4213n;
    private int f4214o;
    private int f4215p;
    private int f4216q;
    private int f4217r;
    private boolean f4218s;
    private boolean f4219t;
    private C2369a f4220u;
    @NonNull
    private OnClickListener f4221v;
    private Map<Integer, Integer> f4222w;

    /* renamed from: com.tinder.adapters.t.1 */
    class C23671 implements OnClickListener {
        final /* synthetic */ C2370t f4198a;

        C23671(C2370t c2370t) {
            this.f4198a = c2370t;
        }

        public void onClick(View view) {
            int size = this.f4198a.f4206g.size();
            if (size > this.f4198a.f4202c) {
                size = this.f4198a.f4202c;
            }
            this.f4198a.f4220u.m6451a(view, size);
        }
    }

    /* renamed from: com.tinder.adapters.t.2 */
    class C23682 implements OnClickListener {
        final /* synthetic */ C2370t f4199a;

        C23682(C2370t c2370t) {
            this.f4199a = c2370t;
        }

        public void onClick(View view) {
            this.f4199a.f4220u.m6450a();
        }
    }

    /* renamed from: com.tinder.adapters.t.a */
    public interface C2369a {
        void m6450a();

        void m6451a(View view, int i);
    }

    public C2370t(Context context, C2369a c2369a) {
        this.f4200a = 2;
        this.f4201b = 3;
        this.f4202c = 29;
        this.f4218s = true;
        this.f4221v = new C23671(this);
        this.f4207h = context;
        this.f4220u = c2369a;
        m6457e();
    }

    public void m6460a(@Nullable List<InstagramPhoto> list) {
        this.f4206g = list;
        if (list != null && list.size() > 0) {
            int size = this.f4206g.size();
            C3095y.m9471a("LTSMOOTH total# of photos we're working with: " + size);
            C3095y.m9471a("LTSMOOTH photos per page determined by rows * columns: " + this.f4204e);
            if (size > this.f4202c) {
                size = this.f4202c;
            }
            C3095y.m9471a("LTSMOOTH number of photos to allow after comparing the total# of photos to the max# photos set " + size);
            int i = size / this.f4204e;
            C3095y.m9471a("LTSMOOTH number of pages by dividing number of photos by photos per page " + i);
            if (size % this.f4204e == 0) {
                String.format("LTSMOOTH modulus operation for %s mod %s came out to 0", new Object[]{Integer.valueOf(size), Integer.valueOf(this.f4204e)});
                if (this.f4218s) {
                    C3095y.m9471a("LTSMOOTH checked mAddAViewMoreButton true, adding 1");
                    i++;
                }
            } else {
                C3095y.m9471a("LTSMOOTH modulus operation did not equal 0, add 1 page for the remaining photos");
                i++;
            }
            this.f4203d = i;
            C3095y.m9471a("LTSMOOTH after all that, we wind up with [" + i + "] pages");
            i = this.f4217r + (this.f4208i * 2);
            if (size <= this.f4204e) {
                this.f4215p = (((size % this.f4200a) + (size / this.f4200a)) * i) + this.f4211l;
            } else {
                this.f4215p = (this.f4200a * i) + this.f4211l;
            }
        }
        notifyDataSetChanged();
    }

    public int m6458a() {
        return this.f4215p;
    }

    private void m6457e() {
        this.f4208i = (int) al.m9284b(5.0f, this.f4207h);
        this.f4210k = (int) this.f4207h.getResources().getDimension(R.dimen.ig_padding_photo_placeholder);
        this.f4212m = (int) this.f4207h.getResources().getDimension(R.dimen.ig_grid_top_padding);
        this.f4213n = (int) this.f4207h.getResources().getDimension(R.dimen.ig_grid_bottom_padding);
        this.f4211l = this.f4212m + this.f4213n;
        this.f4214o = this.f4208i * 2;
        this.f4209j = (((this.f4201b - 1) * this.f4214o) + (this.f4210k * 2)) + (this.f4208i * 2);
        this.f4206g = new ArrayList();
        this.f4216q = (al.m9262a(this.f4207h) - this.f4209j) / this.f4201b;
        this.f4217r = this.f4216q;
        this.f4204e = this.f4200a * this.f4201b;
        this.f4222w = new HashMap();
    }

    public int m6461b() {
        return this.f4200a;
    }

    public int m6462c() {
        return this.f4201b;
    }

    public int getCount() {
        return this.f4203d;
    }

    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(this.f4207h).inflate(R.layout.grid_photos, null);
        GridLayout gridLayout = (GridLayout) inflate.findViewById(R.id.grid_instagram);
        gridLayout.setUseDefaultMargins(true);
        gridLayout.setColumnCount(this.f4201b);
        gridLayout.setRowCount(this.f4200a);
        gridLayout.setRowOrderPreserved(true);
        m6454a(gridLayout, i, this.f4203d);
        ((ViewPager) viewGroup).addView(inflate, 0);
        return inflate;
    }

    public void destroyItem(@NonNull ViewGroup viewGroup, int i, Object obj) {
        ((ViewPager) viewGroup).removeView((GridLayout) obj);
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public int getItemPosition(Object obj) {
        return 0;
    }

    public int m6459a(int i) {
        boolean z = true;
        C3095y.m9471a("getPageIndexByPhotoIndex pos: " + i);
        String str = "mMapPositionPage != null? [%s] ";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.f4222w != null);
        C3095y.m9471a(String.format(str, objArr));
        if (this.f4222w != null) {
            StringBuilder append = new StringBuilder().append("!mMapPositionPage.isEmpty():");
            if (this.f4222w.isEmpty()) {
                z = false;
            }
            C3095y.m9471a(append.append(z).toString());
            if (!this.f4222w.isEmpty()) {
                C3095y.m9471a("mapposition page size:" + this.f4222w.size());
            }
        }
        if (this.f4222w == null || this.f4222w.isEmpty()) {
            return 0;
        }
        return ((Integer) this.f4222w.get(Integer.valueOf(i))).intValue();
    }

    private void m6454a(@NonNull GridLayout gridLayout, int i, int i2) {
        int i3;
        this.f4219t = false;
        if (this.f4206g.size() > this.f4202c) {
            i3 = this.f4202c;
        } else {
            i3 = this.f4206g.size();
        }
        this.f4205f = i3;
        if (this.f4205f > 0) {
            int i4;
            int i5;
            int i6;
            C2281x roundImageView;
            LayoutParams layoutParams;
            String urlSmall;
            int i7 = i * this.f4204e;
            i3 = this.f4204e + i7;
            if (i + 1 == i2) {
                C3095y.m9471a("projectZ on last page");
                this.f4219t = true;
                i3 = (this.f4205f % this.f4204e) + i7;
                if (this.f4218s) {
                    i4 = i3 + 1;
                    i3 = 0;
                    i5 = 0;
                    while (i7 < i4) {
                        C3095y.m9471a("i:" + i7);
                        this.f4222w.put(Integer.valueOf(i7), Integer.valueOf(i));
                        i6 = i3 + 1;
                        if (!this.f4219t && i7 + 1 == i4 && this.f4218s) {
                            C3095y.m9471a("projectZ on last photo, adding button");
                            m6453a(gridLayout);
                            return;
                        }
                        roundImageView = new RoundImageView(this.f4207h);
                        roundImageView.setScaleType(ScaleType.CENTER_CROP);
                        roundImageView.setStyle("barely_rounded");
                        roundImageView.setOnClickListener(this.f4221v);
                        roundImageView.setTag(Integer.valueOf(i7));
                        layoutParams = new GridLayout.LayoutParams();
                        layoutParams.height = this.f4217r;
                        layoutParams.width = this.f4216q;
                        layoutParams.setMargins(m6463d(), m6463d(), m6463d(), m6463d());
                        roundImageView.setLayoutParams(layoutParams);
                        gridLayout.addView(roundImageView);
                        gridLayout.setPadding(this.f4210k, this.f4212m, this.f4210k, this.f4213n);
                        C3095y.m9471a("LTSMOOTH getting url from object=" + i7);
                        urlSmall = ((InstagramPhoto) this.f4206g.get(i7)).getUrlSmall();
                        if (!TextUtils.isEmpty(urlSmall)) {
                            Picasso.m8982a(this.f4207h).m8990a(urlSmall).m9129b(this.f4216q, this.f4217r).m9126a(roundImageView);
                        }
                        i5++;
                        i7++;
                        i3 = i6;
                    }
                }
            }
            i4 = i3;
            i3 = 0;
            i5 = 0;
            while (i7 < i4) {
                C3095y.m9471a("i:" + i7);
                this.f4222w.put(Integer.valueOf(i7), Integer.valueOf(i));
                i6 = i3 + 1;
                if (!this.f4219t) {
                }
                roundImageView = new RoundImageView(this.f4207h);
                roundImageView.setScaleType(ScaleType.CENTER_CROP);
                roundImageView.setStyle("barely_rounded");
                roundImageView.setOnClickListener(this.f4221v);
                roundImageView.setTag(Integer.valueOf(i7));
                layoutParams = new GridLayout.LayoutParams();
                layoutParams.height = this.f4217r;
                layoutParams.width = this.f4216q;
                layoutParams.setMargins(m6463d(), m6463d(), m6463d(), m6463d());
                roundImageView.setLayoutParams(layoutParams);
                gridLayout.addView(roundImageView);
                gridLayout.setPadding(this.f4210k, this.f4212m, this.f4210k, this.f4213n);
                C3095y.m9471a("LTSMOOTH getting url from object=" + i7);
                urlSmall = ((InstagramPhoto) this.f4206g.get(i7)).getUrlSmall();
                if (!TextUtils.isEmpty(urlSmall)) {
                    Picasso.m8982a(this.f4207h).m8990a(urlSmall).m9129b(this.f4216q, this.f4217r).m9126a(roundImageView);
                }
                i5++;
                i7++;
                i3 = i6;
            }
        }
    }

    private void m6453a(@NonNull GridLayout gridLayout) {
        View inflate = LayoutInflater.from(this.f4207h).inflate(R.layout.instagram_view_more, null);
        LayoutParams layoutParams = new GridLayout.LayoutParams();
        layoutParams.width = this.f4216q;
        layoutParams.height = this.f4217r;
        inflate.setLayoutParams(layoutParams);
        inflate.setOnClickListener(new C23682(this));
        gridLayout.addView(inflate);
    }

    public int m6463d() {
        return this.f4208i;
    }
}
