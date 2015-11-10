package com.tinder.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tinder.utils.C3095y;

/* renamed from: com.tinder.adapters.i */
public class C2345i extends PagerAdapter {
    boolean f4117a;
    @NonNull
    private Bitmap[] f4118b;
    private Context f4119c;

    public C2345i(Context context) {
        this.f4118b = new Bitmap[4];
        this.f4119c = context;
    }

    public void m6390a(Bitmap bitmap) {
        this.f4118b[0] = bitmap;
    }

    public void m6391b(Bitmap bitmap) {
        this.f4118b[1] = bitmap;
    }

    public void m6392c(Bitmap bitmap) {
        this.f4118b[2] = bitmap;
    }

    public void m6393d(Bitmap bitmap) {
        this.f4118b[3] = bitmap;
    }

    public Bitmap m6389a(int i) {
        return this.f4118b[i];
    }

    public int getCount() {
        return 4;
    }

    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
        C3095y.m9471a("position " + i);
        View relativeLayout = new RelativeLayout(this.f4119c);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        relativeLayout.addView(new ProgressBar(this.f4119c), layoutParams);
        View imageView = new ImageView(this.f4119c);
        Bitmap bitmap = this.f4118b[i];
        if (bitmap != null) {
            if (this.f4117a) {
                imageView.setScaleType(ScaleType.CENTER_CROP);
            } else {
                imageView.setScaleType(ScaleType.FIT_XY);
            }
            imageView.setImageBitmap(bitmap);
            viewGroup.addView(imageView);
            return imageView;
        }
        viewGroup.addView(relativeLayout);
        return relativeLayout;
    }

    public void destroyItem(@NonNull ViewGroup viewGroup, int i, Object obj) {
        C3095y.m9471a("position " + i);
        viewGroup.removeView((View) obj);
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public int getItemPosition(Object obj) {
        return -2;
    }
}
