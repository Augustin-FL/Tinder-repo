package com.tinder.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridLayout;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tinder.R;
import com.tinder.model.CommonConnection;
import com.tinder.picassowebp.picasso.C2281x;
import com.tinder.picassowebp.picasso.Picasso;
import com.tinder.utils.HeightSizeSpan;
import com.tinder.utils.al;
import com.tinder.views.RoundImageView;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* renamed from: com.tinder.adapters.c */
public class C2330c extends PagerAdapter {
    private int f4057a;
    private int f4058b;
    private int f4059c;
    private int f4060d;
    private int f4061e;
    private int f4062f;
    private int f4063g;
    private int f4064h;
    private int f4065i;
    private int f4066j;
    private int f4067k;
    private int f4068l;
    private int f4069m;
    private int f4070n;
    private float f4071o;
    private boolean f4072p;
    private List<CommonConnection> f4073q;
    private HeightSizeSpan f4074r;
    private Context f4075s;

    public C2330c(@NonNull Context context) {
        this.f4057a = 2;
        this.f4058b = 3;
        this.f4059c = 29;
        this.f4075s = context;
        this.f4071o = context.getResources().getDisplayMetrics().density;
        m6369c();
    }

    public int m6370a() {
        return this.f4069m;
    }

    public void m6372a(List<CommonConnection> list) {
        this.f4073q = list;
        if (this.f4073q != null && this.f4073q.size() > 0) {
            int size = this.f4073q.size();
            if (size <= this.f4058b) {
                this.f4057a = 1;
            }
            if (size > this.f4059c) {
                size = this.f4059c;
            }
            this.f4060d = (int) Math.ceil((double) (((float) size) / ((float) this.f4061e)));
            this.f4066j = (this.f4057a * this.f4068l) + (this.f4064h * 2);
        }
    }

    private void m6369c() {
        this.f4073q = new ArrayList();
        Resources resources = this.f4075s.getResources();
        this.f4070n = (int) al.m9284b(5.0f, this.f4075s);
        this.f4063g = resources.getDimensionPixelSize(R.dimen.connection_page_padding);
        this.f4064h = (int) al.m9284b(10.0f, this.f4075s);
        this.f4065i = this.f4070n * 2;
        this.f4062f = (this.f4058b * this.f4065i) + (this.f4063g * 2);
        int a = al.m9262a(this.f4075s) - this.f4062f;
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize((float) resources.getDimensionPixelSize(R.dimen.connection_name_size));
        int measureText = (int) textPaint.measureText("TygO");
        this.f4067k = a / this.f4058b;
        this.f4069m = (int) (((float) this.f4067k) * 0.9f);
        this.f4068l = resources.getDimensionPixelSize(R.dimen.connection_name_padding) + (this.f4069m + measureText);
        this.f4061e = this.f4057a * this.f4058b;
        this.f4074r = new HeightSizeSpan(0.5f, 0.65f);
    }

    public void m6371a(int i) {
        this.f4059c = i;
    }

    public int m6373b() {
        return this.f4061e;
    }

    public int getCount() {
        return this.f4060d;
    }

    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
        View gridLayout = new GridLayout(this.f4075s);
        gridLayout.setUseDefaultMargins(false);
        gridLayout.setColumnCount(this.f4058b);
        gridLayout.setRowCount(this.f4057a);
        if (!this.f4072p) {
            this.f4072p = true;
            LayoutParams layoutParams = viewGroup.getLayoutParams();
            layoutParams.height = this.f4066j;
            viewGroup.setLayoutParams(layoutParams);
        }
        m6368a(gridLayout, i);
        viewGroup.addView(gridLayout);
        return gridLayout;
    }

    public void destroyItem(@NonNull ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((GridLayout) obj);
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public int getItemPosition(Object obj) {
        return 0;
    }

    private void m6368a(@NonNull GridLayout gridLayout, int i) {
        int i2;
        if (this.f4073q.size() > this.f4059c) {
            i2 = this.f4059c;
        } else {
            i2 = this.f4073q.size();
        }
        int i3 = this.f4061e * i;
        int min = i3 + Math.min(i2 - i3, this.f4061e);
        for (int i4 = i3; i4 < min; i4++) {
            CommonConnection commonConnection = (CommonConnection) this.f4073q.get(i4);
            View inflate = View.inflate(this.f4075s, R.layout.cell_common_connection, null);
            C2281x c2281x = (RoundImageView) inflate.findViewById(R.id.cell_connection_image);
            c2281x.setScaleType(ScaleType.CENTER_CROP);
            ((TextView) inflate.findViewById(R.id.cell_connection_text_name)).setText(commonConnection.getName());
            TextView textView = (TextView) inflate.findViewById(R.id.cell_connection_text_degree);
            CharSequence charSequence = this.f4075s.getResources().getStringArray(R.array.ordinals)[commonConnection.getDegree()];
            if (Locale.getDefault().getLanguage().contains("en")) {
                CharSequence spannableString = new SpannableString(charSequence);
                spannableString.setSpan(this.f4074r, 1, charSequence.length(), 17);
                textView.setText(spannableString);
            } else {
                textView.setText(charSequence);
            }
            LayoutParams layoutParams = new GridLayout.LayoutParams();
            layoutParams.width = this.f4067k;
            layoutParams.setMargins(this.f4070n, this.f4064h, this.f4070n, this.f4064h);
            inflate.setLayoutParams(layoutParams);
            layoutParams = c2281x.getLayoutParams();
            layoutParams.width = this.f4069m;
            layoutParams.height = this.f4069m;
            c2281x.setLayoutParams(layoutParams);
            gridLayout.addView(inflate);
            String imgForDensity = commonConnection.getImgForDensity(this.f4071o);
            if (TextUtils.isEmpty(imgForDensity)) {
                Drawable colorDrawable = new ColorDrawable(this.f4075s.getResources().getColor(R.color.gray_very_very_light));
                colorDrawable.setBounds(0, 0, this.f4069m, this.f4069m);
                c2281x.setBackground(colorDrawable);
            } else {
                Picasso.m8982a(this.f4075s).m8990a(imgForDensity).m9129b(this.f4069m, this.f4069m).m9126a(c2281x);
            }
        }
    }
}
