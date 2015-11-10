package com.tinder.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tinder.R;
import com.tinder.enums.PhotoSizeMoment;
import com.tinder.managers.ManagerApp;
import com.tinder.model.Moment;
import com.tinder.p030d.ar;
import com.tinder.p030d.as;
import com.tinder.picassowebp.picasso.C2281x;
import com.tinder.picassowebp.picasso.C3029t;
import com.tinder.picassowebp.picasso.Picasso;
import com.tinder.picassowebp.picasso.Picasso.LoadedFrom;
import com.tinder.utils.C3066f;
import com.tinder.utils.C3075l;
import com.tinder.utils.C3095y;
import com.tinder.utils.al;
import com.tinder.views.DarkenTransformation;
import com.tinder.views.LinearGradientTransformation;
import com.tinder.views.RoundImageView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tinder.adapters.k */
public class C2354k extends BaseAdapter implements as {
    private static int f4152a;
    @NonNull
    private final Context f4153b;
    private final ar f4154c;
    private LayoutInflater f4155d;
    private List<Moment> f4156e;
    private boolean f4157f;
    private int f4158g;
    private DarkenTransformation f4159h;
    private LinearGradientTransformation f4160i;
    private int f4161j;
    @Nullable
    private Drawable f4162k;
    private Bitmap f4163l;

    /* renamed from: com.tinder.adapters.k.1 */
    class C23501 implements OnClickListener {
        final /* synthetic */ Moment f4141a;
        final /* synthetic */ C2354k f4142b;

        C23501(C2354k c2354k, Moment moment) {
            this.f4142b = c2354k;
            this.f4141a = moment;
        }

        public void onClick(View view) {
            this.f4142b.f4154c.m6678a(this.f4141a);
        }
    }

    /* renamed from: com.tinder.adapters.k.2 */
    class C23512 implements C2281x {
        final /* synthetic */ C2353a f4143a;
        final /* synthetic */ Moment f4144b;
        final /* synthetic */ C2354k f4145c;

        C23512(C2354k c2354k, C2353a c2353a, Moment moment) {
            this.f4145c = c2354k;
            this.f4143a = c2353a;
            this.f4144b = moment;
        }

        public void onBitmapLoaded(Bitmap bitmap, LoadedFrom loadedFrom) {
            this.f4143a.f4150c.setImageBitmap(bitmap);
            m6400a();
        }

        public void onBitmapFailed(Drawable drawable) {
            m6400a();
        }

        public void onPrepareLoad(Drawable drawable) {
            this.f4143a.f4150c.setImageBitmap(this.f4145c.f4163l);
        }

        private void m6400a() {
            if (this.f4144b.hasFailed()) {
                this.f4143a.f4148a.setVisibility(8);
            } else {
                this.f4143a.f4148a.setVisibility(0);
            }
        }
    }

    /* renamed from: com.tinder.adapters.k.3 */
    class C23523 implements OnClickListener {
        final /* synthetic */ Moment f4146a;
        final /* synthetic */ C2354k f4147b;

        C23523(C2354k c2354k, Moment moment) {
            this.f4147b = c2354k;
            this.f4146a = moment;
        }

        public void onClick(View view) {
            this.f4147b.f4154c.m6679b(this.f4146a);
        }
    }

    /* renamed from: com.tinder.adapters.k.a */
    private static class C2353a {
        TextView f4148a;
        TextView f4149b;
        RoundImageView f4150c;
        ImageButton f4151d;

        private C2353a() {
        }
    }

    public C2354k(@NonNull Context context, ar arVar) {
        this.f4156e = new ArrayList();
        this.f4153b = context;
        this.f4155d = LayoutInflater.from(context);
        this.f4154c = arVar;
        this.f4159h = new DarkenTransformation(context);
        this.f4160i = new LinearGradientTransformation(this.f4153b, 0.3d, 0.3d);
        f4152a = m6408c();
        this.f4161j = f4152a + this.f4153b.getResources().getDimensionPixelSize(R.dimen.my_moment_cell_image_bottom_padding);
        this.f4162k = context.getResources().getDrawable(R.drawable.rounded_white_bg);
        this.f4163l = C3066f.m9347a(this.f4162k, f4152a, f4152a);
    }

    private int m6408c() {
        return ((int) ((((float) al.m9262a(this.f4153b)) - (2.0f * this.f4153b.getResources().getDimension(R.dimen.padding_med))) - (3.0f * this.f4153b.getResources().getDimension(R.dimen.margin_med)))) / 3;
    }

    public int getCount() {
        if (this.f4156e.isEmpty()) {
            return this.f4158g;
        }
        return this.f4156e.size();
    }

    public Object getItem(int i) {
        return this.f4156e.get(i);
    }

    public long getItemId(int i) {
        return 0;
    }

    @Nullable
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (this.f4156e.isEmpty()) {
            return m6404a(viewGroup);
        }
        return m6403a(i, view, viewGroup);
    }

    public boolean isEnabled(int i) {
        return false;
    }

    public int getItemViewType(int i) {
        if (this.f4156e.isEmpty()) {
            return 0;
        }
        return 1;
    }

    public int getViewTypeCount() {
        return 2;
    }

    public void m6411a(List<Moment> list) {
        this.f4156e = list;
    }

    public void m6410a(int i) {
        this.f4158g = i;
    }

    private View m6404a(ViewGroup viewGroup) {
        View inflate = this.f4155d.inflate(R.layout.cell_view_fake_my_moment, viewGroup, false);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.imageView_moment);
        LayoutParams layoutParams = (LayoutParams) imageView.getLayoutParams();
        layoutParams.width = f4152a;
        layoutParams.height = f4152a;
        imageView.setLayoutParams(layoutParams);
        imageView.setBackgroundResource(R.drawable.dummy_moment_bg);
        return inflate;
    }

    @Nullable
    private View m6403a(int i, @Nullable View view, ViewGroup viewGroup) {
        String b;
        C2353a c2353a;
        Moment moment = (Moment) this.f4156e.get(i);
        if (moment.isPending() || moment.hasFailed()) {
            b = C3075l.m9393b(String.valueOf(moment.getCreatedTime()));
        } else {
            b = moment.getMomentPhoto().getProcessedFile(PhotoSizeMoment.MED);
        }
        int numLikes = moment.getNumLikes();
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C2353a)) {
            c2353a = new C2353a();
            view = this.f4155d.inflate(R.layout.cell_view_my_moment, viewGroup, false);
            c2353a.f4148a = (TextView) view.findViewById(R.id.textView_likes);
            c2353a.f4150c = (RoundImageView) view.findViewById(R.id.imageView_moment);
            c2353a.f4151d = (ImageButton) view.findViewById(R.id.btn_retry);
            c2353a.f4149b = (TextView) view.findViewById(R.id.textView_time_left);
            view.setTag(c2353a);
        } else {
            c2353a = (C2353a) view.getTag();
        }
        c2353a.f4150c.setOnClickListener(new C23501(this, moment));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c2353a.f4150c.getLayoutParams();
        if (layoutParams.height != this.f4161j) {
            layoutParams.height = this.f4161j;
        }
        c2353a.f4150c.setLayoutParams(layoutParams);
        if (!TextUtils.isEmpty(b)) {
            C3029t b2 = Picasso.m8982a(this.f4153b).m8990a(b).m9122a(this.f4162k).m9129b(f4152a, f4152a).m9127b();
            if (moment.hasFailed()) {
                b2 = b2.m9123a(this.f4159h);
            } else {
                b2 = b2.m9123a(this.f4160i);
            }
            C2281x c23512 = new C23512(this, c2353a, moment);
            c2353a.f4150c.setTag(c23512);
            b2.m9126a(c23512);
        }
        c2353a.f4148a.setText(String.valueOf(numLikes));
        if (moment.isExpired()) {
            c2353a.f4150c.setAlpha(0.3f);
            c2353a.f4151d.setVisibility(8);
            c2353a.f4149b.setVisibility(8);
        } else if (moment.hasFailed()) {
            c2353a.f4151d.setOnClickListener(new C23523(this, moment));
            c2353a.f4151d.setVisibility(0);
            c2353a.f4149b.setVisibility(8);
        } else {
            c2353a.f4150c.setAlpha(1.0f);
            c2353a.f4151d.setVisibility(8);
            c2353a.f4149b.setVisibility(0);
            Pair hoursMinutesLeft = moment.getHoursMinutesLeft();
            c2353a.f4149b.setText(String.format("%d:%02d", new Object[]{hoursMinutesLeft.first, hoursMinutesLeft.second}));
        }
        if (!this.f4157f && m6407b(i)) {
            this.f4157f = true;
            ManagerApp.m7926q().m8458a((as) this, this.f4157f);
        }
        return view;
    }

    private boolean m6407b(int i) {
        return ManagerApp.m7926q().m8489n() && this.f4156e.size() - i < 50;
    }

    public void m6409a() {
        C3095y.m9469a();
        this.f4157f = false;
        notifyDataSetChanged();
    }

    public void m6412b() {
        C3095y.m9469a();
        this.f4157f = false;
    }
}
