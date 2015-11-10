package com.tinder.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.stetho.BuildConfig;
import com.tinder.R;
import com.tinder.managers.ManagerApp;
import com.tinder.model.Match;
import com.tinder.model.MomentLike;
import com.tinder.p030d.al;
import com.tinder.picassowebp.picasso.Picasso;
import com.tinder.utils.C3070i;
import com.tinder.utils.C3095y;
import com.tinder.views.RoundImageView;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* renamed from: com.tinder.adapters.j */
public class C2349j extends BaseAdapter {
    private final Context f4134a;
    @NonNull
    private final DateFormat f4135b;
    private final al f4136c;
    private List<MomentLike> f4137d;
    private int f4138e;
    private boolean f4139f;
    private int f4140g;

    /* renamed from: com.tinder.adapters.j.1 */
    class C23461 implements OnClickListener {
        final /* synthetic */ Match f4120a;
        final /* synthetic */ C2349j f4121b;

        C23461(C2349j c2349j, Match match) {
            this.f4121b = c2349j;
            this.f4120a = match;
        }

        public void onClick(View view) {
            this.f4121b.f4136c.m6663a(this.f4120a);
        }
    }

    /* renamed from: com.tinder.adapters.j.2 */
    class C23472 implements OnClickListener {
        final /* synthetic */ String f4122a;
        final /* synthetic */ C2349j f4123b;

        C23472(C2349j c2349j, String str) {
            this.f4123b = c2349j;
            this.f4122a = str;
        }

        public void onClick(View view) {
            this.f4123b.f4136c.m6664a(ManagerApp.m7926q().m8452a(this.f4122a));
        }
    }

    /* renamed from: com.tinder.adapters.j.a */
    private static class C2348a {
        RelativeLayout f4124a;
        TextView f4125b;
        TextView f4126c;
        TextView f4127d;
        TextView f4128e;
        TextView f4129f;
        RoundImageView f4130g;
        RoundImageView f4131h;
        View f4132i;
        View f4133j;

        private C2348a() {
        }
    }

    public C2349j(Context context, al alVar, int i, boolean z) {
        this.f4137d = new ArrayList();
        C3095y.m9471a("numLikesUnseen=" + i);
        this.f4134a = context;
        this.f4136c = alVar;
        this.f4135b = C3070i.m9369b();
        this.f4138e = i;
        this.f4139f = z;
    }

    public void m6399a(List<MomentLike> list) {
        this.f4137d = list;
    }

    public int getCount() {
        if (this.f4137d.isEmpty()) {
            return this.f4140g;
        }
        return this.f4137d.size();
    }

    public Object getItem(int i) {
        return this.f4137d.get(i);
    }

    public long getItemId(int i) {
        return 0;
    }

    @Nullable
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (this.f4137d.isEmpty()) {
            return m6395a(viewGroup);
        }
        return m6394a(i, view, viewGroup);
    }

    public boolean isEnabled(int i) {
        return false;
    }

    public int getItemViewType(int i) {
        if (this.f4137d.isEmpty()) {
            return 0;
        }
        return 1;
    }

    public int getViewTypeCount() {
        return 2;
    }

    private View m6395a(ViewGroup viewGroup) {
        return LayoutInflater.from(this.f4134a).inflate(R.layout.row_view_moment_like_dummy, viewGroup, false);
    }

    @Nullable
    private View m6394a(int i, @Nullable View view, ViewGroup viewGroup) {
        C3095y.m9471a("Not dummy moment like");
        MomentLike momentLike = (MomentLike) this.f4137d.get(i);
        if (view == null) {
            C2348a c2348a = new C2348a();
            view = LayoutInflater.from(this.f4134a).inflate(R.layout.row_view_moment_like, viewGroup, false);
            c2348a.f4124a = (RelativeLayout) view.findViewById(R.id.relativeLayout_container);
            c2348a.f4125b = (TextView) view.findViewById(R.id.textView_name);
            c2348a.f4127d = (TextView) view.findViewById(R.id.textView_day);
            c2348a.f4126c = (TextView) view.findViewById(R.id.textView_time);
            c2348a.f4129f = (TextView) view.findViewById(R.id.textView_liked_your_moment);
            c2348a.f4130g = (RoundImageView) view.findViewById(R.id.imageView_match);
            c2348a.f4131h = (RoundImageView) view.findViewById(R.id.imageView_moment);
            c2348a.f4128e = (TextView) view.findViewById(R.id.textView_older_activity);
            c2348a.f4132i = view.findViewById(R.id.view_separator_older_activity);
            c2348a.f4133j = view.findViewById(R.id.view_separator_item);
            view.setTag(c2348a);
        }
        C2348a c2348a2 = (C2348a) view.getTag();
        String likedbyId = momentLike.getLikedbyId();
        String thumbUrl = momentLike.getThumbUrl();
        String momentId = momentLike.getMomentId();
        Match b = ManagerApp.m7925p().m8279b(likedbyId);
        String str = null;
        CharSequence charSequence = null;
        if (b != null) {
            str = b.getThumbnailUrl();
            charSequence = b.getName();
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
            C3095y.m9476b("Couldn't find match!--position=" + i + ", likedById=" + likedbyId);
        }
        view.setOnClickListener(new C23461(this, b));
        c2348a2.f4131h.setOnClickListener(new C23472(this, momentId));
        if (TextUtils.isEmpty(str)) {
            Picasso.m8982a(this.f4134a).m8987a((int) R.drawable.addaphoto_loader_icon).m9121a((int) R.dimen.avatar_length_my_moments_activity, (int) R.dimen.avatar_length_my_moments_activity).m9127b().m9126a(c2348a2.f4130g);
        } else {
            Picasso.m8982a(this.f4134a).m8990a(str).m9120a((int) R.drawable.addaphoto_loader_icon).m9121a((int) R.dimen.avatar_length_my_moments_activity, (int) R.dimen.avatar_length_my_moments_activity).m9127b().m9126a(c2348a2.f4130g);
        }
        if (this.f4139f) {
            c2348a2.f4131h.setVisibility(0);
            if (!(thumbUrl == null || thumbUrl.trim().length() == 0)) {
                Picasso.m8982a(this.f4134a).m8990a(thumbUrl).m9120a((int) R.drawable.addaphoto_loader_icon).m9121a((int) R.dimen.avatar_length_my_moments_activity, (int) R.dimen.avatar_length_my_moments_activity).m9127b().m9126a(c2348a2.f4131h);
            }
        } else {
            c2348a2.f4131h.setVisibility(4);
        }
        c2348a2.f4125b.setText(charSequence);
        try {
            Date parse = this.f4135b.parse(momentLike.getCreationDate());
            if (parse.getTime() > System.currentTimeMillis()) {
                parse = new Date(System.currentTimeMillis());
            }
            m6397a(c2348a2, parse);
        } catch (ParseException e) {
            C3095y.m9479c(e.toString());
        }
        if (i == this.f4138e && this.f4138e != 0) {
            c2348a2.f4128e.setVisibility(0);
            c2348a2.f4132i.setVisibility(0);
            c2348a2.f4133j.setVisibility(0);
        } else if (i == this.f4138e - 1) {
            c2348a2.f4128e.setVisibility(8);
            c2348a2.f4132i.setVisibility(8);
            c2348a2.f4133j.setVisibility(4);
        } else {
            c2348a2.f4128e.setVisibility(8);
            c2348a2.f4132i.setVisibility(8);
            c2348a2.f4133j.setVisibility(0);
        }
        return view;
    }

    private void m6397a(@NonNull C2348a c2348a, @NonNull Date date) {
        CharSequence charSequence;
        CharSequence string;
        Date date2 = new Date();
        long time = date2.getTime() - date.getTime();
        if (time < 60000) {
            charSequence = BuildConfig.FLAVOR;
            string = this.f4134a.getString(R.string.now);
        } else if (time < 3600000) {
            String str = BuildConfig.FLAVOR;
            string = DateUtils.getRelativeTimeSpanString(date.getTime(), date2.getTime(), 60000, 393216).toString();
            Object obj = str;
        } else if (C3070i.m9367a(date2, date)) {
            charSequence = BuildConfig.FLAVOR;
            string = DateUtils.formatDateTime(this.f4134a, date.getTime(), 1);
        } else if (time < 604800000) {
            charSequence = DateUtils.formatDateTime(this.f4134a, date.getTime(), 32770);
            string = DateUtils.formatDateTime(this.f4134a, date.getTime(), 1);
        } else {
            charSequence = DateUtils.formatDateTime(this.f4134a, date.getTime(), AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
            string = DateUtils.formatDateTime(this.f4134a, date.getTime(), 1);
        }
        if (charSequence.length() != 0) {
            c2348a.f4127d.setVisibility(0);
            c2348a.f4127d.setText(charSequence);
        } else {
            c2348a.f4127d.setVisibility(8);
            c2348a.f4127d.setText(charSequence);
        }
        c2348a.f4126c.setText(string);
    }

    public void m6398a(int i) {
        this.f4140g = i;
    }
}
