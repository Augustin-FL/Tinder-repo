package com.tinder.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
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
import com.tinder.activities.ActivityMatch;
import com.tinder.managers.ManagerApp;
import com.tinder.model.Match;
import com.tinder.model.MomentLike;
import com.tinder.picassowebp.picasso.Picasso;
import com.tinder.utils.C3070i;
import com.tinder.utils.C3095y;
import com.tinder.utils.al;
import com.tinder.views.RoundImageView;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* renamed from: com.tinder.adapters.h */
public class C2344h extends BaseAdapter {
    private final Context f4113a;
    @NonNull
    private final DateFormat f4114b;
    @Nullable
    private List<MomentLike> f4115c;
    private boolean f4116d;

    /* renamed from: com.tinder.adapters.h.1 */
    class C23421 implements OnClickListener {
        final /* synthetic */ Match f4104a;
        final /* synthetic */ MomentLike f4105b;
        final /* synthetic */ C2344h f4106c;

        C23421(C2344h c2344h, Match match, MomentLike momentLike) {
            this.f4106c = c2344h;
            this.f4104a = match;
            this.f4105b = momentLike;
        }

        public void onClick(View view) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("match", this.f4104a);
            bundle.putString("moment-id", this.f4105b.getMomentId());
            Intent intent = new Intent(this.f4106c.f4113a, ActivityMatch.class);
            intent.putExtras(bundle);
            this.f4106c.f4113a.startActivity(intent);
        }
    }

    /* renamed from: com.tinder.adapters.h.a */
    private static class C2343a {
        RelativeLayout f4107a;
        RelativeLayout f4108b;
        TextView f4109c;
        TextView f4110d;
        TextView f4111e;
        RoundImageView f4112f;

        private C2343a() {
        }
    }

    public C2344h(Context context) {
        this.f4115c = new ArrayList();
        this.f4113a = context;
        this.f4114b = C3070i.m9369b();
        this.f4116d = al.m9276a();
    }

    public void m6388a(@Nullable List<MomentLike> list) {
        if (list != null) {
            this.f4115c = list;
        }
    }

    public int getCount() {
        return this.f4115c.size();
    }

    public Object getItem(int i) {
        return this.f4115c.get(i);
    }

    public long getItemId(int i) {
        return 0;
    }

    @Nullable
    public View getView(int i, @Nullable View view, ViewGroup viewGroup) {
        MomentLike momentLike = (MomentLike) this.f4115c.get(i);
        Match b = ManagerApp.m7925p().m8279b(momentLike.getLikedbyId());
        if (b == null) {
            return null;
        }
        String thumbnailUrl = b.getThumbnailUrl();
        if (view == null) {
            C2343a c2343a = new C2343a();
            view = LayoutInflater.from(this.f4113a).inflate(R.layout.row_moment_metrics_moment_like, viewGroup, false);
            c2343a.f4107a = (RelativeLayout) view.findViewById(R.id.relativeLayout_container);
            c2343a.f4108b = (RelativeLayout) view.findViewById(R.id.relativeLayout_text_container);
            if (this.f4116d) {
                c2343a.f4107a.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                c2343a.f4108b.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            }
            c2343a.f4109c = (TextView) view.findViewById(R.id.textView_name);
            c2343a.f4111e = (TextView) view.findViewById(R.id.textView_day);
            c2343a.f4110d = (TextView) view.findViewById(R.id.textView_time);
            c2343a.f4112f = (RoundImageView) view.findViewById(R.id.imageView_match);
            view.setTag(c2343a);
        }
        C2343a c2343a2 = (C2343a) view.getTag();
        if (!TextUtils.isEmpty(thumbnailUrl)) {
            Picasso.m8982a(this.f4113a).m8990a(thumbnailUrl).m9120a((int) R.drawable.addaphoto_loader_icon).m9121a((int) R.dimen.dialog_moment_metrics_avatar_length, (int) R.dimen.dialog_moment_metrics_avatar_length).m9127b().m9126a(c2343a2.f4112f);
        }
        c2343a2.f4109c.setText(b.getName());
        view.setOnClickListener(new C23421(this, b, momentLike));
        try {
            Date parse = this.f4114b.parse(momentLike.getCreationDate());
            if (parse.getTime() > System.currentTimeMillis()) {
                parse = new Date(System.currentTimeMillis());
            }
            m6387a(c2343a2, parse);
            return view;
        } catch (ParseException e) {
            C3095y.m9479c(e.toString());
            return view;
        }
    }

    public boolean isEnabled(int i) {
        return false;
    }

    private void m6387a(@NonNull C2343a c2343a, @NonNull Date date) {
        CharSequence charSequence;
        CharSequence string;
        Date date2 = new Date();
        long time = date2.getTime() - date.getTime();
        if (time < 60000) {
            charSequence = BuildConfig.FLAVOR;
            string = this.f4113a.getString(R.string.now);
        } else if (time < 3600000) {
            String str = BuildConfig.FLAVOR;
            string = DateUtils.getRelativeTimeSpanString(date.getTime(), date2.getTime(), 60000, 393216).toString();
            Object obj = str;
        } else if (C3070i.m9367a(date2, date)) {
            charSequence = BuildConfig.FLAVOR;
            string = DateUtils.formatDateTime(this.f4113a, date.getTime(), 1);
        } else if (time < 604800000) {
            charSequence = DateUtils.formatDateTime(this.f4113a, date.getTime(), 32770);
            string = DateUtils.formatDateTime(this.f4113a, date.getTime(), 1);
        } else {
            charSequence = DateUtils.formatDateTime(this.f4113a, date.getTime(), AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
            string = DateUtils.formatDateTime(this.f4113a, date.getTime(), 1);
        }
        if (charSequence.length() != 0) {
            c2343a.f4111e.setVisibility(0);
            c2343a.f4111e.setText(charSequence);
        } else {
            c2343a.f4111e.setVisibility(8);
            c2343a.f4111e.setText(charSequence);
        }
        c2343a.f4110d.setText(string);
    }
}
