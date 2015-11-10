package com.tinder.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tinder.R;
import com.tinder.fragments.C2668m;
import com.tinder.managers.ManagerApp;
import com.tinder.model.Match;
import com.tinder.model.Message;
import com.tinder.picassowebp.picasso.Picasso;
import com.tinder.picassowebp.picasso.Picasso.C2986a;
import com.tinder.utils.C3070i;
import com.tinder.utils.C3076m;
import com.tinder.utils.C3095y;
import com.tinder.utils.al;
import com.tinder.views.RoundImageView;
import com.tinder.views.VerifiedBadgeView;
import java.text.ParseException;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.Executors;

/* renamed from: com.tinder.adapters.g */
public class C2341g extends BaseAdapter {
    private static Picasso f4100a;
    private final Context f4101b;
    private final C2668m f4102c;
    private List<Match> f4103d;

    /* renamed from: com.tinder.adapters.g.1 */
    static class C23371 implements OnClickListener {
        final /* synthetic */ C2668m f4087a;
        final /* synthetic */ Match f4088b;

        C23371(C2668m c2668m, Match match) {
            this.f4087a = c2668m;
            this.f4088b = match;
        }

        public void onClick(View view) {
            this.f4087a.m7462b(this.f4088b);
        }
    }

    /* renamed from: com.tinder.adapters.g.2 */
    static class C23382 implements OnClickListener {
        final /* synthetic */ C2668m f4089a;
        final /* synthetic */ Match f4090b;

        C23382(C2668m c2668m, Match match) {
            this.f4089a = c2668m;
            this.f4090b = match;
        }

        public void onClick(View view) {
            this.f4089a.m7459a(this.f4090b);
        }
    }

    /* renamed from: com.tinder.adapters.g.3 */
    static class C23393 implements OnClickListener {
        final /* synthetic */ C2668m f4091a;
        final /* synthetic */ Match f4092b;

        C23393(C2668m c2668m, Match match) {
            this.f4091a = c2668m;
            this.f4092b = match;
        }

        public void onClick(View view) {
            this.f4091a.m7462b(this.f4092b);
        }
    }

    /* renamed from: com.tinder.adapters.g.a */
    public static class C2340a {
        RoundImageView f4093a;
        ImageView f4094b;
        TextView f4095c;
        TextView f4096d;
        ImageView f4097e;
        ImageView f4098f;
        VerifiedBadgeView f4099g;
    }

    public C2341g(Context context, C2668m c2668m) {
        this.f4103d = ManagerApp.m7925p().m8287c();
        this.f4101b = context;
        this.f4102c = c2668m;
        f4100a = new C2986a(context).m8977a(Executors.newSingleThreadExecutor()).m8976a(new C3076m(20)).m8978a();
    }

    @Nullable
    public static View m6384a(@NonNull Context context, @NonNull Match match, @Nullable View view, ViewGroup viewGroup, @NonNull C2668m c2668m) {
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(context).inflate(R.layout.row_view_match, viewGroup, false);
            ((VerifiedBadgeView) view.findViewById(R.id.verified_badge)).displayBadge(match);
            C2340a c2340a = new C2340a();
            c2340a.f4093a = (RoundImageView) view.findViewById(R.id.match_thumb);
            c2340a.f4094b = (ImageView) view.findViewById(R.id.imageView_unviewed_indicator);
            c2340a.f4095c = (TextView) view.findViewById(R.id.nameText);
            c2340a.f4096d = (TextView) view.findViewById(R.id.subtext);
            c2340a.f4097e = (ImageView) view.findViewById(R.id.img_moments_follow);
            c2340a.f4098f = (ImageView) view.findViewById(R.id.img_superlike);
            c2340a.f4099g = (VerifiedBadgeView) view.findViewById(R.id.verified_badge);
            view.setTag(c2340a);
        }
        C2340a c2340a2 = (C2340a) view.getTag();
        c2340a2.f4093a.setOnClickListener(new C23371(c2668m, match));
        al.m9287b(c2340a2.f4093a);
        String thumbnailUrl = match.getThumbnailUrl();
        if (TextUtils.isEmpty(thumbnailUrl)) {
            C3095y.m9471a("Match has no image. Person may be null");
        } else {
            f4100a.m8990a(thumbnailUrl).m9120a((int) R.drawable.friends_searchresults_avatar_icon).m9121a((int) R.dimen.avatar_length_matches, (int) R.dimen.avatar_length_matches).m9127b().m9126a(c2340a2.f4093a);
        }
        if (match.isFollowed()) {
            c2340a2.f4097e.setVisibility(8);
        } else {
            c2340a2.f4097e.setVisibility(0);
            c2340a2.f4097e.setOnClickListener(new C23382(c2668m, match));
        }
        ImageView imageView = c2340a2.f4098f;
        int i = (ManagerApp.m7914e().at() && match.isSuperlike()) ? 0 : 8;
        imageView.setVisibility(i);
        if (match.isVerified()) {
            c2340a2.f4099g.displayBadge(match);
            c2340a2.f4099g.setVisibility(0);
        } else {
            c2340a2.f4099g.setVisibility(8);
        }
        c2340a2.f4095c.setText(match.getName());
        TreeSet messages = match.getMessages();
        if (messages.isEmpty()) {
            try {
                Object createdDate = match.getCreatedDate();
                if (TextUtils.isEmpty(createdDate)) {
                    c2340a2.f4096d.setText(context.getString(R.string.matched));
                } else {
                    match.setFormattedCreatedDate(C3070i.formatDateTime(context, C3070i.m9366a().parse(createdDate).getTime(), 65544));
                    c2340a2.f4096d.setText(context.getResources().getString(R.string.matched_on_text, new Object[]{thumbnailUrl}));
                }
                if (match.wasTouched()) {
                    c2340a2.f4094b.setVisibility(8);
                } else {
                    c2340a2.f4094b.setVisibility(0);
                    c2340a2.f4094b.setImageResource(R.drawable.matches_newmatch_icon);
                }
            } catch (ParseException e) {
                c2340a2.f4096d.setText(context.getString(R.string.matched));
            }
        } else {
            Message message = (Message) messages.last();
            c2340a2.f4096d.setText(message.getText());
            if (match.wasTouched() || message.isFromMe() || message.isViewed()) {
                c2340a2.f4094b.setVisibility(8);
            } else {
                c2340a2.f4094b.setVisibility(0);
                c2340a2.f4094b.setImageResource(R.drawable.matches_newmatch_icon);
            }
        }
        view.setOnClickListener(new C23393(c2668m, match));
        return view;
    }

    public void m6385a(List<Match> list) {
        this.f4103d = list;
    }

    public int getCount() {
        return this.f4103d.size();
    }

    public Object getItem(int i) {
        return this.f4103d.get(i);
    }

    public long getItemId(int i) {
        return 0;
    }

    @Nullable
    public View getView(int i, View view, ViewGroup viewGroup) {
        return C2341g.m6384a(this.f4101b, (Match) this.f4103d.get(i), view, viewGroup, this.f4102c);
    }

    public boolean hasStableIds() {
        return false;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        C3095y.m9469a();
    }

    public int getItemViewType(int i) {
        return 0;
    }

    public int getViewTypeCount() {
        return 1;
    }

    public boolean isEmpty() {
        return this.f4103d.isEmpty();
    }
}
