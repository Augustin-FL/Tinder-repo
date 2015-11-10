package com.tinder.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tinder.R;
import com.tinder.picassowebp.picasso.Picasso;
import java.util.List;

/* renamed from: com.tinder.adapters.u */
public class C2372u extends PagerAdapter {
    private List<String> f4224a;
    private Context f4225b;
    private OnClickListener f4226c;
    private int f4227d;
    private boolean f4228e;

    /* renamed from: com.tinder.adapters.u.1 */
    class C23711 implements OnClickListener {
        final /* synthetic */ C2372u f4223a;

        C23711(C2372u c2372u) {
            this.f4223a = c2372u;
        }

        public void onClick(View view) {
            if (this.f4223a.f4226c != null) {
                this.f4223a.f4226c.onClick(view);
            }
        }
    }

    public C2372u(Context context) {
        this.f4227d = 6;
        this.f4225b = context;
    }

    public void m6466a(OnClickListener onClickListener) {
        this.f4226c = onClickListener;
    }

    public void m6467a(List<String> list) {
        this.f4224a = list;
        notifyDataSetChanged();
    }

    public int getCount() {
        if (this.f4224a == null) {
            return 0;
        }
        return this.f4224a.size() <= this.f4227d ? this.f4224a.size() : this.f4227d;
    }

    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
        String str = (String) this.f4224a.get(i);
        View inflate = ViewGroup.inflate(this.f4225b, R.layout.view_user_profile_page, null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.profile_page_image);
        viewGroup.addView(inflate);
        Picasso.m8982a(this.f4225b).m8990a(str).m9124a(imageView);
        imageView.setClickable(true);
        imageView.setOnClickListener(new C23711(this));
        return inflate;
    }

    public void destroyItem(@NonNull ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public int getItemPosition(Object obj) {
        return this.f4228e ? -2 : -1;
    }

    public void m6468a(boolean z) {
        this.f4228e = z;
    }

    public List<String> m6465a() {
        return this.f4224a;
    }
}
