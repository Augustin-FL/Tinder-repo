package com.tinder.adapters;

import android.animation.ObjectAnimator;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v7.util.SortedList;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.util.SortedListAdapterCallback;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.stetho.BuildConfig;
import com.tinder.R;
import com.tinder.enums.PhotoSizeMoment;
import com.tinder.fragments.FragmentMessages.FailedMessage;
import com.tinder.managers.ManagerApp;
import com.tinder.model.BaseMessage;
import com.tinder.model.Message;
import com.tinder.model.Moment;
import com.tinder.model.MomentLike;
import com.tinder.model.Person;
import com.tinder.model.User;
import com.tinder.picassowebp.picasso.C2281x;
import com.tinder.picassowebp.picasso.Picasso;
import com.tinder.picassowebp.picasso.Picasso.LoadedFrom;
import com.tinder.utils.C3070i;
import com.tinder.utils.C3077n;
import com.tinder.utils.C3095y;
import com.tinder.utils.al;
import com.tinder.views.GrayscaleTransformation;
import com.tinder.views.MessageMomentBackgroundDrawable;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.tinder.adapters.v */
public class C2382v extends Adapter<ViewHolder> {
    @NonNull
    private final Context f4253a;
    private final String f4254b;
    private final C2379b f4255c;
    @NonNull
    private SortedList<BaseMessage> f4256d;
    private GrayscaleTransformation f4257e;
    private LayoutInflater f4258f;
    private Person f4259g;
    private String f4260h;
    private int f4261i;
    private int f4262j;

    /* renamed from: com.tinder.adapters.v.1 */
    class C23731 extends SortedListAdapterCallback<BaseMessage> {
        final /* synthetic */ C2382v f4229a;

        C23731(C2382v c2382v, Adapter adapter) {
            this.f4229a = c2382v;
            super(adapter);
        }

        public /* synthetic */ boolean areContentsTheSame(Object obj, Object obj2) {
            return m6470b((BaseMessage) obj, (BaseMessage) obj2);
        }

        public /* synthetic */ boolean areItemsTheSame(Object obj, Object obj2) {
            return m6471c((BaseMessage) obj, (BaseMessage) obj2);
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m6469a((BaseMessage) obj, (BaseMessage) obj2);
        }

        public int m6469a(BaseMessage baseMessage, BaseMessage baseMessage2) {
            return baseMessage.compareTo(baseMessage2);
        }

        public boolean m6470b(BaseMessage baseMessage, BaseMessage baseMessage2) {
            if (!baseMessage.getClass().equals(baseMessage2.getClass())) {
                return false;
            }
            String fromUserId;
            String text;
            if (baseMessage instanceof Message) {
                boolean z;
                fromUserId = ((Message) baseMessage).getFromUserId();
                String fromUserId2 = ((Message) baseMessage2).getFromUserId();
                String text2 = ((Message) baseMessage).getText();
                text = ((Message) baseMessage2).getText();
                if (((Message) baseMessage).isPending() == ((Message) baseMessage2).isPending() && fromUserId.equals(fromUserId2) && text2.equals(text)) {
                    z = true;
                } else {
                    z = false;
                }
                return z;
            } else if (!(baseMessage instanceof MomentLike)) {
                return false;
            } else {
                text = ((MomentLike) baseMessage).getMixedId();
                fromUserId = ((MomentLike) baseMessage2).getMixedId();
                if (text == null || fromUserId == null) {
                    return false;
                }
                return text.equals(fromUserId);
            }
        }

        public boolean m6471c(BaseMessage baseMessage, BaseMessage baseMessage2) {
            return baseMessage.getId().equals(baseMessage2.getId());
        }
    }

    /* renamed from: com.tinder.adapters.v.2 */
    class C23742 implements OnClickListener {
        final /* synthetic */ MomentLike f4230a;
        final /* synthetic */ C2382v f4231b;

        C23742(C2382v c2382v, MomentLike momentLike) {
            this.f4231b = c2382v;
            this.f4230a = momentLike;
        }

        public void onClick(View view) {
            this.f4231b.f4255c.m6474a(this.f4230a);
        }
    }

    /* renamed from: com.tinder.adapters.v.3 */
    class C23753 implements OnClickListener {
        final /* synthetic */ Message f4232a;
        final /* synthetic */ C2382v f4233b;

        C23753(C2382v c2382v, Message message) {
            this.f4233b = c2382v;
            this.f4232a = message;
        }

        public void onClick(View view) {
            this.f4233b.f4255c.m6473a(this.f4232a);
        }
    }

    /* renamed from: com.tinder.adapters.v.4 */
    class C23764 implements OnLongClickListener {
        final /* synthetic */ C2380c f4234a;
        final /* synthetic */ C2382v f4235b;

        C23764(C2382v c2382v, C2380c c2380c) {
            this.f4235b = c2382v;
            this.f4234a = c2380c;
        }

        public boolean onLongClick(View view) {
            Toast.makeText(this.f4235b.f4253a, R.string.copied, 1).show();
            CharSequence charSequence = this.f4234a.f4239c.getText().toString();
            ((ClipboardManager) this.f4235b.f4253a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(charSequence, charSequence));
            return true;
        }
    }

    /* renamed from: com.tinder.adapters.v.5 */
    class C23775 implements OnClickListener {
        final /* synthetic */ C2382v f4236a;

        C23775(C2382v c2382v) {
            this.f4236a = c2382v;
        }

        public void onClick(View view) {
            this.f4236a.f4255c.m6472a();
        }
    }

    /* renamed from: com.tinder.adapters.v.a */
    public static class C2378a extends ViewHolder {
        public C2378a(@NonNull View view) {
            super(view);
        }
    }

    /* renamed from: com.tinder.adapters.v.b */
    public interface C2379b {
        void m6472a();

        void m6473a(Message message);

        void m6474a(MomentLike momentLike);
    }

    /* renamed from: com.tinder.adapters.v.c */
    public static class C2380c extends ViewHolder implements C2281x {
        RelativeLayout f4237a;
        RelativeLayout f4238b;
        TextView f4239c;
        TextView f4240d;
        TextView f4241e;
        ImageView f4242f;
        LinearLayout f4243g;
        int f4244h;

        public C2380c(@NonNull View view) {
            super(view);
            view.setEnabled(false);
            this.f4237a = (RelativeLayout) view.findViewById(R.id.relativeLayout_message);
            this.f4238b = (RelativeLayout) view.findViewById(R.id.relativeLayout_container);
            this.f4239c = (TextView) view.findViewById(R.id.textView_message);
            this.f4240d = (TextView) view.findViewById(R.id.textView_day);
            this.f4241e = (TextView) view.findViewById(R.id.textView_time);
            this.f4243g = (LinearLayout) view.findViewById(R.id.linear_likes);
            this.f4242f = (ImageView) view.findViewById(R.id.imageView_image);
        }

        public void m6475a(int i) {
            this.f4244h = i;
        }

        public void onBitmapLoaded(Bitmap bitmap, LoadedFrom loadedFrom) {
            this.f4242f.setImageBitmap(bitmap);
        }

        public void onBitmapFailed(Drawable drawable) {
        }

        public void onPrepareLoad(Drawable drawable) {
        }
    }

    /* renamed from: com.tinder.adapters.v.d */
    private static class C2381d extends ViewHolder implements C2281x {
        View f4245a;
        RelativeLayout f4246b;
        ImageView f4247c;
        TextView f4248d;
        TextView f4249e;
        TextView f4250f;
        int f4251g;
        int f4252h;

        public C2381d(@NonNull View view) {
            super(view);
            this.f4245a = view;
            this.f4246b = (RelativeLayout) view.findViewById(R.id.moment_like_message_layout);
            this.f4247c = (ImageView) view.findViewById(R.id.moment_like_avatar);
            this.f4248d = (TextView) view.findViewById(R.id.moment_like_message);
            this.f4249e = (TextView) view.findViewById(R.id.moment_like_day);
            this.f4250f = (TextView) view.findViewById(R.id.moment_like_time);
            this.f4252h = view.getContext().getResources().getDimensionPixelSize(R.dimen.msgs_moment_image_height);
        }

        public void m6476a(int i) {
            this.f4251g = i;
        }

        public void onBitmapLoaded(Bitmap bitmap, LoadedFrom loadedFrom) {
            al.m9271a(this.f4246b, new MessageMomentBackgroundDrawable(bitmap, this.f4252h, (float) this.f4245a.getContext().getResources().getDimensionPixelOffset(R.dimen.margin_small), this.f4251g, getItemViewType() == 3));
        }

        public void onBitmapFailed(Drawable drawable) {
        }

        public void onPrepareLoad(Drawable drawable) {
        }
    }

    public C2382v(@NonNull Context context, BaseMessage[] baseMessageArr, Person person, String str, C2379b c2379b) {
        this.f4253a = context;
        this.f4259g = person;
        this.f4255c = c2379b;
        this.f4254b = str;
        this.f4257e = new GrayscaleTransformation();
        this.f4262j = this.f4253a.getResources().getDimensionPixelSize(R.dimen.padding_large);
        this.f4261i = this.f4253a.getResources().getDimensionPixelSize(R.dimen.padding_small);
        this.f4258f = LayoutInflater.from(context);
        User d = ManagerApp.m7922m().m8599d();
        if (d != null) {
            this.f4260h = d.getId();
        }
        this.f4256d = new SortedList(BaseMessage.class, new C23731(this, this), baseMessageArr.length);
        try {
            this.f4256d.addAll(baseMessageArr, true);
        } catch (Throwable e) {
            C3095y.m9474a("Message/like data array invalid!", e);
            m6479a();
        } catch (Throwable e2) {
            C3095y.m9474a("Message/like data array inconsistent?", e2);
            m6479a();
        }
    }

    @UiThread
    public void m6487a(@NonNull TreeSet<Message> treeSet, List<MomentLike> list) {
        this.f4256d.beginBatchedUpdates();
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            try {
                this.f4256d.add((Message) it.next());
            } catch (Throwable e) {
                C3095y.m9474a("Trying to add messages. Message data sort invalid!", e);
                m6479a();
            } catch (Throwable e2) {
                C3095y.m9474a("Trying to add messages. Message data inconsistent?", e2);
                m6479a();
            } catch (Throwable th) {
                this.f4256d.endBatchedUpdates();
            }
        }
        for (MomentLike add : list) {
            try {
                this.f4256d.add(add);
            } catch (Throwable e22) {
                C3095y.m9474a("Trying to add like. Message data sort invalid!", e22);
                m6479a();
            } catch (Throwable e222) {
                C3095y.m9474a("Trying to add like. Message data inconsistent?", e222);
                m6479a();
            }
        }
        this.f4256d.endBatchedUpdates();
    }

    private int m6477a(Object obj) {
        if (obj instanceof MomentLike) {
            if (this.f4260h.equals(((MomentLike) obj).getLikedbyId())) {
                return 3;
            }
            return 2;
        }
        if (this.f4260h.equals(((Message) obj).getFromUserId())) {
            return 1;
        }
        return 0;
    }

    @UiThread
    public void m6485a(Message message) {
        try {
            this.f4256d.add(message);
        } catch (Throwable e) {
            C3095y.m9474a("Trying to add pending message. Message data sort invalid!", e);
            m6479a();
        } catch (Throwable e2) {
            C3095y.m9474a("Trying to add pending message. Message data inconsistent?", e2);
            m6479a();
        }
    }

    @UiThread
    public void m6488b(@NonNull Message message) {
        int indexOf = this.f4256d.indexOf(message);
        if (indexOf != -1) {
            try {
                this.f4256d.updateItemAt(indexOf, new FailedMessage(message.getMatchId(), message.getCreationDate(), message.getFromUserId(), message.getText()));
            } catch (Throwable e) {
                C3095y.m9474a("Trying to update failed message. Message data sort invalid!", e);
                m6479a();
            } catch (Throwable e2) {
                C3095y.m9474a("Trying to update failed message. Message data inconsistent?", e2);
                m6479a();
            }
        }
    }

    @UiThread
    public void m6489c(Message message) {
        int indexOf = this.f4256d.indexOf(message);
        if (indexOf != -1) {
            try {
                this.f4256d.updateItemAt(indexOf, message);
            } catch (Throwable e) {
                C3095y.m9474a("Trying to update retried message. Message data sort invalid!", e);
                m6479a();
            } catch (Throwable e2) {
                C3095y.m9474a("Trying to update retried message. Message data inconsistent?", e2);
                m6479a();
            }
        }
    }

    @UiThread
    public void m6486a(Message message, @NonNull Message message2) {
        int indexOf = this.f4256d.indexOf(message);
        if (indexOf != -1) {
            try {
                this.f4256d.updateItemAt(indexOf, message2);
            } catch (Throwable e) {
                C3095y.m9474a("Trying to update sent message. Message data sort invalid!", e);
                m6479a();
            } catch (Throwable e2) {
                C3095y.m9474a("Trying to update sent message. Message data inconsistent?", e2);
                m6479a();
            }
        }
    }

    @NonNull
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        C3095y.m9471a("Creating view holder for type: " + i);
        switch (i) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                return new C2380c(this.f4258f.inflate(R.layout.row_view_message_from_other, viewGroup, false));
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                return new C2380c(this.f4258f.inflate(R.layout.row_view_message_from_me, viewGroup, false));
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                return new C2381d(this.f4258f.inflate(R.layout.item_chat_like_from_other, viewGroup, false));
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                return new C2381d(this.f4258f.inflate(R.layout.item_chat_like_from_me, viewGroup, false));
            case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                return new C2378a(this.f4258f.inflate(R.layout.view_message_empty_view, viewGroup, false));
            default:
                C3095y.m9479c("Unknown view type for messages, could not set up view holder.");
                throw new IllegalStateException("Unable to resolve view type. Check that it exists.");
        }
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        switch (getItemViewType(i)) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                m6481a((C2380c) viewHolder, i);
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                m6481a((C2380c) viewHolder, i);
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                m6482a((C2381d) viewHolder, i);
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                m6482a((C2381d) viewHolder, i);
            default:
        }
    }

    public BaseMessage m6484a(int i) {
        return (BaseMessage) this.f4256d.get(i);
    }

    public long getItemId(int i) {
        BaseMessage a = m6484a(i);
        if (a != null) {
            return (long) a.getId().hashCode();
        }
        return 0;
    }

    public int getItemCount() {
        return this.f4256d.size();
    }

    public int getItemViewType(int i) {
        return m6477a(m6484a(i));
    }

    private void m6482a(@NonNull C2381d c2381d, int i) {
        MomentLike momentLike = (MomentLike) m6484a(i);
        if (momentLike == null) {
            C3095y.m9479c("Tried to bind a moment like to a view holder, but moment like did not exist in list.");
            return;
        }
        boolean equals;
        String likedbyId = momentLike.getLikedbyId();
        if (likedbyId != null) {
            equals = likedbyId.equals(this.f4260h);
        } else {
            equals = false;
        }
        c2381d.f4248d.setText(C3077n.m9402a(this.f4253a, equals ? R.string.liked_moment_text_theirs : R.string.liked_moment_text_mine, this.f4259g.getName()));
        c2381d.m6476a(this.f4253a.getResources().getColor(equals ? R.color.chat_bubble_green : R.color.chat_bubble_gray));
        Moment a = ManagerApp.m7926q().m8452a(momentLike.getMomentId());
        if (c2381d.f4247c != null) {
            Picasso.m8982a(this.f4253a).m8990a(this.f4254b).m9120a((int) R.drawable.addaphoto_loader_icon).m9121a((int) R.dimen.avatar_length_messages, (int) R.dimen.avatar_length_messages).m9127b().m9124a(c2381d.f4247c);
        }
        String processedFile = a.getMomentPhoto().getProcessedFile(PhotoSizeMoment.LARGE);
        if (a.isExpired()) {
            Picasso.m8982a(this.f4253a).m8990a(processedFile).m9123a(this.f4257e).m9121a((int) R.dimen.msgs_moment_image_width, (int) R.dimen.msgs_moment_image_height).m9127b().m9126a((C2281x) c2381d);
        } else {
            Picasso.m8982a(this.f4253a).m8990a(processedFile).m9121a((int) R.dimen.msgs_moment_image_width, (int) R.dimen.msgs_moment_image_height).m9127b().m9126a((C2281x) c2381d);
        }
        try {
            likedbyId = momentLike.getCreationDate();
            if (likedbyId != null) {
                m6480a(c2381d.f4250f, c2381d.f4249e, C3070i.m9366a().parse(likedbyId));
            }
        } catch (Throwable e) {
            C3095y.m9474a("Unable to parse date string from moment like", e);
        }
        c2381d.f4245a.setOnClickListener(new C23742(this, momentLike));
    }

    private void m6481a(@NonNull C2380c c2380c, int i) {
        int i2 = 0;
        Message message = (Message) m6484a(i);
        if (message == null) {
            C3095y.m9479c("Tried to bind a message to a view holder, but message did not exist in list.");
            return;
        }
        String str;
        int color = this.f4253a.getResources().getColor(message.isFromMe() ? R.color.chat_bubble_green : R.color.chat_bubble_gray);
        c2380c.m6475a(color);
        al.m9271a(c2380c.f4237a, new MessageMomentBackgroundDrawable(null, 0, (float) this.f4253a.getResources().getDimensionPixelOffset(R.dimen.margin_small), color, message.isFromMe()));
        int paddingRight = c2380c.f4238b.getPaddingRight();
        int paddingLeft = c2380c.f4238b.getPaddingLeft();
        if (i == 0) {
            c2380c.f4238b.setPadding(paddingLeft, this.f4262j, paddingRight, this.f4261i);
        } else if (this.f4261i != c2380c.f4238b.getPaddingTop()) {
            c2380c.f4238b.setPadding(paddingLeft, this.f4261i, paddingRight, this.f4261i);
        }
        if (message instanceof FailedMessage) {
            OnClickListener c23753 = new C23753(this, message);
            c2380c.f4239c.setOnClickListener(c23753);
            c2380c.f4240d.setOnClickListener(c23753);
            c2380c.f4241e.setOnClickListener(c23753);
        } else {
            c2380c.f4239c.setOnLongClickListener(new C23764(this, c2380c));
        }
        if (message.isFromMe()) {
            str = null;
        } else {
            c2380c.f4242f.setOnClickListener(new C23775(this));
            str = this.f4254b;
        }
        if (!(str == null || str.trim().length() == 0)) {
            C3095y.m9471a("Getting image from Picasso");
            Picasso.m8982a(this.f4253a).m8990a(str).m9120a((int) R.drawable.addaphoto_loader_icon).m9121a((int) R.dimen.avatar_length_messages, (int) R.dimen.avatar_length_messages).m9127b().m9126a((C2281x) c2380c);
        }
        c2380c.f4239c.setText(message.getText());
        if (message.isPending()) {
            c2380c.f4240d.setText(BuildConfig.FLAVOR);
            c2380c.f4241e.setText(R.string.sending);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(c2380c.f4240d, "alpha", new float[]{0.2f, 1.0f});
            ofFloat.setDuration(1000);
            ofFloat.setRepeatMode(2);
            ofFloat.setRepeatCount(-1);
            ofFloat.start();
            c2380c.f4241e.setTag(ofFloat);
        } else if (message instanceof FailedMessage) {
            c2380c.f4240d.setVisibility(8);
            c2380c.f4241e.setText(R.string.failed_msg);
            i2 = 1;
        } else {
            c2380c.f4240d.setVisibility(0);
            try {
                m6480a(c2380c.f4241e, c2380c.f4240d, C3070i.m9366a().parse(message.getCreationDate()));
            } catch (ParseException e) {
                C3095y.m9479c(e.toString());
            }
            i2 = 1;
        }
        if (i2 != 0 && c2380c.f4241e.getTag() != null) {
            ((ObjectAnimator) c2380c.f4241e.getTag()).cancel();
            c2380c.f4241e.setTag(null);
        }
    }

    private void m6480a(@NonNull TextView textView, @NonNull TextView textView2, @NonNull Date date) {
        CharSequence string;
        CharSequence charSequence;
        Date date2 = new Date();
        long time = date2.getTime() - date.getTime();
        if (time < 60000) {
            string = this.f4253a.getString(R.string.now);
            charSequence = null;
        } else if (time < 3600000) {
            string = C3070i.getRelativeTimeSpanString(date.getTime(), date2.getTime(), 60000, 393216).toString();
            charSequence = null;
        } else if (C3070i.m9367a(date2, date)) {
            string = C3070i.formatDateTime(this.f4253a, date.getTime(), 1);
            charSequence = null;
        } else if (time < 604800000) {
            charSequence = C3070i.formatDateTime(this.f4253a, date.getTime(), 32770);
            string = C3070i.formatDateTime(this.f4253a, date.getTime(), 1);
        } else {
            charSequence = C3070i.formatDateTime(this.f4253a, date.getTime(), AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
            string = C3070i.formatDateTime(this.f4253a, date.getTime(), 1);
        }
        if (TextUtils.isEmpty(charSequence)) {
            textView2.setVisibility(8);
            textView2.setText(charSequence);
        } else {
            textView2.setVisibility(0);
            textView2.setText(charSequence);
        }
        textView.setText(string);
    }

    private void m6479a() {
        int i = 0;
        while (i < this.f4256d.size()) {
            try {
                C3095y.m9479c("idx: " + i + ", " + ((BaseMessage) this.f4256d.get(i)).toString());
                i++;
            } catch (Throwable e) {
                C3095y.m9474a("Cannot print sorted list contents to logs!", e);
                return;
            }
        }
    }
}
