package com.tinder.fragments;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.share.internal.ShareConstants;
import com.facebook.stetho.BuildConfig;
import com.tinder.R;
import com.tinder.activities.ActivityMomentGame;
import com.tinder.adapters.C2382v;
import com.tinder.adapters.C2382v.C2379b;
import com.tinder.dialogs.C2549z;
import com.tinder.enums.PhotoSizeMoment;
import com.tinder.enums.PhotoSizeUser;
import com.tinder.managers.C2807a;
import com.tinder.managers.C2855f;
import com.tinder.managers.C2859g;
import com.tinder.managers.ManagerApp;
import com.tinder.managers.ManagerNotifications.NotificationType;
import com.tinder.model.BaseMessage;
import com.tinder.model.Match;
import com.tinder.model.Message;
import com.tinder.model.Moment;
import com.tinder.model.MomentLike;
import com.tinder.model.PhotoUser;
import com.tinder.model.ProcessedPhoto;
import com.tinder.model.SparksEvent;
import com.tinder.model.User;
import com.tinder.p030d.ab;
import com.tinder.p030d.ae;
import com.tinder.p030d.ag;
import com.tinder.p030d.aq;
import com.tinder.picassowebp.picasso.C2281x;
import com.tinder.picassowebp.picasso.Picasso;
import com.tinder.picassowebp.picasso.Picasso.LoadedFrom;
import com.tinder.utils.C2508e;
import com.tinder.utils.C3070i;
import com.tinder.utils.C3077n;
import com.tinder.utils.C3095y;
import com.tinder.utils.ad;
import com.tinder.utils.al;
import com.tinder.views.CustomEditText;
import com.tinder.views.CustomTextView;
import com.tinder.views.RoundImageView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.TreeSet;

public class FragmentMessages extends Fragment implements OnClickListener, C2379b, ae, ag, aq, C2281x {
    @Nullable
    private static String f4787a;
    private static final SimpleDateFormat f4788r;
    private String f4789b;
    private String f4790c;
    private LinearLayout f4791d;
    private EditText f4792e;
    private CustomTextView f4793f;
    private C2855f f4794g;
    private C2382v f4795h;
    private RecyclerView f4796i;
    private C2549z f4797j;
    private RoundImageView f4798k;
    private String[] f4799l;
    private Match f4800m;
    private boolean f4801n;
    private boolean f4802o;
    private View f4803p;
    private List<Moment> f4804q;

    /* renamed from: com.tinder.fragments.FragmentMessages.10 */
    class AnonymousClass10 implements Runnable {
        final /* synthetic */ Message f4772a;
        final /* synthetic */ FragmentMessages f4773b;

        AnonymousClass10(FragmentMessages fragmentMessages, Message message) {
            this.f4773b = fragmentMessages;
            this.f4772a = message;
        }

        public void run() {
            if (this.f4773b.f4795h != null) {
                this.f4773b.f4801n = true;
                this.f4773b.f4795h.m6489c(this.f4772a);
                this.f4773b.f4801n = false;
            }
        }
    }

    /* renamed from: com.tinder.fragments.FragmentMessages.1 */
    class C25761 implements OnClickListener {
        final /* synthetic */ FragmentMessages f4775a;

        C25761(FragmentMessages fragmentMessages) {
            this.f4775a = fragmentMessages;
        }

        public void onClick(View view) {
            this.f4775a.f4803p.setVisibility(8);
            FragmentActivity activity = this.f4775a.getActivity();
            if ((activity instanceof ActivityMomentGame) && ((ActivityMomentGame) activity).m6243h()) {
                C3095y.m9471a("is single match game -- exiting");
                ((C2657l) this.f4775a.getParentFragment()).m7433b();
                return;
            }
            C3095y.m9471a("NOT SINGLE GAME");
            this.f4775a.m7115d();
        }
    }

    /* renamed from: com.tinder.fragments.FragmentMessages.2 */
    class C25772 implements Runnable {
        final /* synthetic */ FragmentMessages f4776a;

        C25772(FragmentMessages fragmentMessages) {
            this.f4776a = fragmentMessages;
        }

        public void run() {
            this.f4776a.m7105l();
        }
    }

    /* renamed from: com.tinder.fragments.FragmentMessages.3 */
    class C25783 implements Runnable {
        final /* synthetic */ FragmentMessages f4777a;

        C25783(FragmentMessages fragmentMessages) {
            this.f4777a = fragmentMessages;
        }

        public void run() {
            this.f4777a.m7105l();
        }
    }

    /* renamed from: com.tinder.fragments.FragmentMessages.4 */
    class C25794 implements OnClickListener {
        final /* synthetic */ FragmentMessages f4778a;

        C25794(FragmentMessages fragmentMessages) {
            this.f4778a = fragmentMessages;
        }

        public void onClick(View view) {
            this.f4778a.m7103j();
        }
    }

    /* renamed from: com.tinder.fragments.FragmentMessages.5 */
    class C25805 implements OnTouchListener {
        final /* synthetic */ FragmentMessages f4779a;

        C25805(FragmentMessages fragmentMessages) {
            this.f4779a = fragmentMessages;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f4779a.f4801n) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: com.tinder.fragments.FragmentMessages.6 */
    class C25816 implements Runnable {
        final /* synthetic */ FragmentMessages f4780a;

        C25816(FragmentMessages fragmentMessages) {
            this.f4780a = fragmentMessages;
        }

        public void run() {
            this.f4780a.m7105l();
        }
    }

    /* renamed from: com.tinder.fragments.FragmentMessages.7 */
    class C25827 implements Runnable {
        final /* synthetic */ Message f4781a;
        final /* synthetic */ Message f4782b;
        final /* synthetic */ FragmentMessages f4783c;

        C25827(FragmentMessages fragmentMessages, Message message, Message message2) {
            this.f4783c = fragmentMessages;
            this.f4781a = message;
            this.f4782b = message2;
        }

        public void run() {
            if (this.f4783c.f4795h != null) {
                this.f4783c.f4801n = true;
                this.f4783c.f4795h.m6486a(this.f4781a, this.f4782b);
                this.f4783c.f4801n = false;
            }
        }
    }

    /* renamed from: com.tinder.fragments.FragmentMessages.8 */
    class C25838 implements Runnable {
        final /* synthetic */ Message f4784a;
        final /* synthetic */ FragmentMessages f4785b;

        C25838(FragmentMessages fragmentMessages, Message message) {
            this.f4785b = fragmentMessages;
            this.f4784a = message;
        }

        public void run() {
            if (this.f4785b.f4795h != null) {
                this.f4785b.f4801n = true;
                this.f4785b.f4795h.m6488b(this.f4784a);
                this.f4785b.f4801n = false;
            }
        }
    }

    /* renamed from: com.tinder.fragments.FragmentMessages.9 */
    class C25849 implements OnDismissListener {
        final /* synthetic */ FragmentMessages f4786a;

        C25849(FragmentMessages fragmentMessages) {
            this.f4786a = fragmentMessages;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            ManagerApp.m7926q().m8457a(this.f4786a);
        }
    }

    public static class FailedMessage extends Message {
        public FailedMessage(String str, String str2, String str3, String str4) {
            super(str, str2, str3, str4, true, System.currentTimeMillis());
        }
    }

    public FragmentMessages() {
        this.f4801n = false;
    }

    static {
        f4787a = null;
        f4788r = new SimpleDateFormat("M/d/yy");
    }

    @NonNull
    public static FragmentMessages m7094a(@Nullable String str) {
        FragmentMessages fragmentMessages = new FragmentMessages();
        Bundle bundle = new Bundle();
        bundle.putString("back-to-moments", str);
        fragmentMessages.setArguments(bundle);
        return fragmentMessages;
    }

    @Nullable
    public static String m7097b() {
        return f4787a;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4799l = getActivity().getResources().getStringArray(R.array.empty_message_suggestions);
        this.f4800m = ((ab) getActivity()).m6121p();
        f4788r.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C3095y.m9469a();
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f4802o = false;
        View inflate = layoutInflater.inflate(R.layout.view_messages, viewGroup, false);
        this.f4803p = inflate.findViewById(R.id.moment_stack);
        this.f4803p.setOnClickListener(new C25761(this));
        m7095a(inflate);
        m7119h();
        m7105l();
        this.f4794g.m8268a((ae) this);
        ManagerApp.m7926q().m8457a((aq) this);
        this.f4794g.m8290e();
        return inflate;
    }

    public void onResume() {
        super.onResume();
        f4787a = this.f4800m.getId();
        ManagerApp.m7928s().m8049d(f4787a);
        if (ManagerApp.m7925p().m8266a(this.f4800m.getId()) == null) {
            ((ab) getActivity()).m6127w();
        } else {
            m7102i();
            m7119h();
        }
        if (!(this.f4796i == null || this.f4795h == null)) {
            this.f4796i.scrollToPosition(this.f4795h.getItemCount() - 1);
        }
        this.f4792e.setText(BuildConfig.FLAVOR);
        this.f4792e.append(this.f4800m.getDraftMsg());
        this.f4792e.requestFocus();
    }

    public void onSaveInstanceState(Bundle bundle) {
        String obj = this.f4792e.getText().toString();
        this.f4800m.setDraftMsg(obj);
        ManagerApp.m7925p().m8273a(this.f4800m.getId(), obj);
        this.f4792e.setText(BuildConfig.FLAVOR);
        super.onSaveInstanceState(bundle);
    }

    public void onPause() {
        super.onPause();
        f4787a = null;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f4794g.m8280b((ae) this);
        ManagerApp.m7926q().m8469b((aq) this);
        this.f4802o = true;
        al.m9297c(this.f4797j);
        al.m9268a(this.f4792e.getWindowToken(), getActivity());
    }

    private void m7095a(@NonNull View view) {
        String string;
        TextView textView = (TextView) view.findViewById(R.id.txt_empty_message);
        this.f4791d = (LinearLayout) view.findViewById(R.id.view_empty_convo);
        ImageView imageView = (ImageView) view.findViewById(R.id.button_send);
        imageView.setOnClickListener(new C25794(this));
        imageView.requestFocus();
        this.f4792e = (CustomEditText) view.findViewById(R.id.editText_enter_text);
        if (VERSION.SDK_INT >= 16) {
            this.f4792e.setBackground(null);
        } else {
            this.f4792e.setBackgroundDrawable(null);
        }
        this.f4796i = (RecyclerView) view.findViewById(R.id.recyclerView_messages);
        LayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setStackFromEnd(true);
        this.f4796i.setOnTouchListener(new C25805(this));
        this.f4796i.setLayoutManager(linearLayoutManager);
        this.f4796i.setHasFixedSize(true);
        this.f4789b = this.f4800m.getName();
        this.f4790c = this.f4800m.getThumbnailUrl();
        if (!this.f4800m.hasMessageFromMe()) {
            textView.setText(this.f4799l[(int) Math.floor(Math.random() * ((double) this.f4799l.length))]);
        }
        CharSequence draftMsg = this.f4800m.getDraftMsg();
        if (draftMsg != null) {
            this.f4792e.append(draftMsg);
        }
        this.f4794g = ManagerApp.m7925p();
        this.f4793f = (CustomTextView) view.findViewById(R.id.matched_details);
        User d = ManagerApp.m7922m().m8599d();
        if (!this.f4800m.isSuperlike()) {
            string = getString(R.string.message_match_list_default);
        } else if (d == null || !TextUtils.equals(d.getId(), this.f4800m.getSuperLiker())) {
            string = getString(R.string.message_match_list_they_superliked_you);
        } else {
            string = getString(R.string.message_match_list_you_superliked_them);
        }
        String format = f4788r.format(Long.valueOf(C3070i.m9362a(this.f4800m.getCreatedDate())));
        this.f4793f.setText(String.format(string, new Object[]{this.f4800m.getName(), format}));
        m7114c();
    }

    private void m7102i() {
        if (this.f4791d != null && getActivity() != null) {
            TextView textView = (TextView) this.f4791d.findViewById(R.id.txt_matched_statement);
            TextView textView2 = (TextView) this.f4791d.findViewById(R.id.txt_matched_ago);
            this.f4798k = (RoundImageView) this.f4791d.findViewById(R.id.img_empty_convo);
            this.f4798k.setOnClickListener(this);
            if (this.f4800m.getMessages().size() > 0) {
                this.f4791d.setVisibility(8);
                this.f4796i.setVisibility(0);
                this.f4793f.setVisibility(0);
            } else if (this.f4795h == null || this.f4795h.getItemCount() <= 0) {
                String string;
                String imageUrl;
                this.f4796i.setVisibility(8);
                this.f4791d.setVisibility(0);
                this.f4793f.setVisibility(8);
                User d = ManagerApp.m7922m().m8599d();
                if (!this.f4800m.isSuperlike()) {
                    string = getString(R.string.matched_with);
                } else if (d == null || !TextUtils.equals(d.getId(), this.f4800m.getSuperLiker())) {
                    string = getString(R.string.superlike_liked_statement);
                } else {
                    string = getString(R.string.superlike_like_statement);
                }
                textView.setText(String.format(string, new Object[]{this.f4789b}));
                CharSequence charSequence = BuildConfig.FLAVOR;
                try {
                    charSequence = DateUtils.getRelativeTimeSpanString(C3070i.m9366a().parse(this.f4800m.getCreatedDate()).getTime());
                } catch (Throwable e) {
                    C3095y.m9474a("Failed to parse match creation date in order to get the time ago string", e);
                }
                textView2.setText(charSequence);
                List photos = this.f4800m.getPerson().getPhotos();
                if (photos.size() > 0) {
                    ProcessedPhoto processedPhoto = ((PhotoUser) photos.get(0)).getProcessedPhoto(PhotoSizeUser.MED);
                    if (processedPhoto != null) {
                        imageUrl = processedPhoto.getImageUrl();
                        if (imageUrl != null && imageUrl.trim().length() != 0) {
                            Picasso.m8982a(getActivity()).m8990a(imageUrl).m9120a((int) R.drawable.addaphoto_loader_icon).m9128b(R.drawable.addaphoto_loader_icon).m9121a((int) R.dimen.size_avatar_empty_convo, (int) R.dimen.size_avatar_empty_convo).m9127b().m9126a((C2281x) this);
                            return;
                        }
                    }
                }
                imageUrl = null;
                if (imageUrl != null) {
                }
            } else {
                this.f4791d.setVisibility(8);
                this.f4796i.setVisibility(0);
                this.f4793f.setVisibility(0);
            }
        }
    }

    public void m7114c() {
        C3095y.m9469a();
        ManagerApp.m7925p().m8268a((ae) this);
    }

    public void m7115d() {
        al.m9268a(this.f4792e.getWindowToken(), getActivity());
        Intent intent = new Intent(getActivity(), ActivityMomentGame.class);
        ad adVar = new ad(false);
        for (int i = 0; i < this.f4804q.size(); i++) {
            adVar.m9216a(((Moment) this.f4804q.get(i)).getId());
        }
        intent.putStringArrayListExtra("moment ids to play", adVar.m9222d());
        startActivity(intent);
    }

    private void m7103j() {
        C3095y.m9469a();
        String obj = this.f4792e.getText().toString();
        this.f4792e.setText(null);
        User d = ManagerApp.m7922m().m8599d();
        if (TextUtils.isEmpty(obj.trim()) || d == null) {
            C3095y.m9476b("message null or blank, not adding");
            return;
        }
        Date date = new Date();
        Message message = new Message(this.f4800m.getId(), C3070i.m9369b().format(date), d.getId(), obj, true, date.getTime());
        message.setIsPending(true);
        this.f4801n = true;
        this.f4795h.m6485a(message);
        this.f4801n = false;
        this.f4796i.scrollToPosition(this.f4795h.getItemCount() - 1);
        ManagerApp.m7927r();
        C2859g.m8304a((ag) this, message);
        m7102i();
    }

    @NonNull
    private List<MomentLike> m7104k() {
        return ManagerApp.m7926q().m8467b(this.f4800m.getPerson().getId());
    }

    public void m7107E() {
        C3095y.m9471a("On match cache modified called");
        new Handler(Looper.getMainLooper()).post(new C25816(this));
        m7102i();
    }

    public void onClick(@NonNull View view) {
        C3095y.m9471a("view=" + view);
        switch (view.getId()) {
            case R.id.img_empty_convo:
                m7108a();
            default:
                C3095y.m9476b("view not recognized");
        }
    }

    public void m7113b(boolean z) {
    }

    public void m7110a(Message message, @NonNull Message message2) {
        SparksEvent sparksEvent = new SparksEvent("Chat.SendMessage");
        sparksEvent.put("otherId", this.f4800m.getPerson().getId());
        sparksEvent.put("matchId", this.f4800m.getId());
        sparksEvent.put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, message2.getText());
        User d = ManagerApp.m7922m().m8599d();
        sparksEvent.put("superLike", Boolean.valueOf(d != null ? TextUtils.equals(d.getId(), this.f4800m.getSuperLiker()) : false));
        sparksEvent.put("didSuperLike", Boolean.valueOf(this.f4800m.superLikerIsThem()));
        C2807a.m8056a(sparksEvent);
        new Handler(Looper.getMainLooper()).post(new C25827(this, message, message2));
    }

    public void m7112b(@NonNull Message message) {
        C3095y.m9485e("Sending the message failed.");
        if (this.f4802o) {
            ManagerApp.m7928s().m8046b(null, NotificationType.MESSAGE_FAILED, null);
        }
        new Handler(Looper.getMainLooper()).post(new C25838(this, message));
    }

    public void m7111a(@NonNull MomentLike momentLike) {
        User d = ManagerApp.m7922m().m8599d();
        if (d == null) {
            C3095y.m9479c("Clicked on moment like, but my user is not set in manager profile!");
            return;
        }
        String id = d.getId();
        Moment a = ManagerApp.m7926q().m8452a(momentLike.getMomentId());
        if (a != null) {
            SparksEvent sparksEvent = new SparksEvent("Moments.View");
            sparksEvent.put("momentId", a.getId());
            sparksEvent.put("otherId", a.getUserId());
            sparksEvent.put("matchId", this.f4800m.getId());
            sparksEvent.put("viewedFrom", Integer.valueOf(4));
            C2807a.m8056a(sparksEvent);
            String string = getArguments().getString("back-to-moments");
            if (getActivity() == null || string == null || !string.equals(a.getId())) {
                if (getActivity() != null) {
                    this.f4797j = new C2549z(getActivity(), a, a.getUserId().equals(id), 4);
                    ManagerApp.m7926q().m8469b((aq) this);
                    this.f4797j.setOnDismissListener(new C25849(this));
                    this.f4797j.show();
                }
            } else if (C3077n.m9405a()) {
                getActivity().finishAndRemoveTask();
            } else {
                getActivity().finish();
            }
        }
    }

    public void m7108a() {
        ((ab) getActivity()).m6126u();
    }

    public void m7109a(@NonNull Message message) {
        Message message2 = new Message(message.getMatchId(), message.getCreationDate(), message.getFromUserId(), message.getText(), true, System.currentTimeMillis());
        message2.setIsPending(true);
        new Handler(Looper.getMainLooper()).post(new AnonymousClass10(this, message2));
        ManagerApp.m7927r();
        C2859g.m8304a((ag) this, message2);
    }

    public void m7119h() {
        List<Moment> g = ManagerApp.m7926q().m8481g();
        String id = this.f4800m.getPerson().getId();
        this.f4804q = new ArrayList(g.size());
        for (Moment moment : g) {
            if (id.equals(moment.getUserId())) {
                this.f4804q.add(moment);
            }
        }
        if ((!this.f4804q.isEmpty() ? 1 : null) != null) {
            m7106m();
        } else {
            this.f4803p.setVisibility(8);
        }
    }

    private void m7105l() {
        Match a = ManagerApp.m7925p().m8266a(this.f4800m.getId());
        if (a != null) {
            TreeSet messages = a.getMessages();
            Collection k = m7104k();
            int size = (messages.size() + 0) + k.size();
            List arrayList = new ArrayList(size);
            arrayList.addAll(messages);
            arrayList.addAll(k);
            BaseMessage[] baseMessageArr = (BaseMessage[]) arrayList.toArray(new BaseMessage[arrayList.size()]);
            if (this.f4795h == null) {
                this.f4795h = new C2382v(getActivity(), baseMessageArr, this.f4800m.getPerson(), this.f4790c, this);
                this.f4796i.setAdapter(this.f4795h);
            }
            this.f4801n = true;
            this.f4795h.m6487a(messages, m7104k());
            this.f4801n = false;
            if (size > 0) {
                C3095y.m9485e("Updated the recycler view adapter.");
                this.f4796i.scrollToPosition(this.f4795h.getItemCount() - 1);
            }
        }
    }

    private void m7106m() {
        if (this.f4804q.isEmpty()) {
            this.f4803p.setVisibility(8);
            return;
        }
        this.f4803p.setVisibility(0);
        TextView textView = (TextView) this.f4803p.findViewById(R.id.txt_num_moments);
        TextView textView2 = (TextView) this.f4803p.findViewById(R.id.txt_time_ago);
        Moment moment = (Moment) this.f4804q.get(0);
        Picasso.m8982a(getActivity()).m8990a(moment.getMomentPhoto().getProcessedFile(PhotoSizeMoment.LARGE)).m9121a((int) R.dimen.msgs_moment_stack_img_width, (int) R.dimen.msgs_moment_stack_img_height).m9127b().m9126a(new C2508e((ImageView) this.f4803p.findViewById(R.id.img_moment)));
        textView2.setText(moment.getTimeAgo(getActivity()));
        textView.setText(getResources().getQuantityString(R.plurals.num_moments, this.f4804q.size(), new Object[]{Integer.valueOf(this.f4804q.size())}));
    }

    public void m7116e() {
        C3095y.m9471a("On moments cache modified called");
        m7119h();
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            final /* synthetic */ FragmentMessages f4774a;

            {
                this.f4774a = r1;
            }

            public void run() {
                this.f4774a.m7105l();
            }
        });
    }

    public void m7117f() {
        C3095y.m9471a("On moment likes cache modified called");
        m7119h();
        new Handler(Looper.getMainLooper()).post(new C25772(this));
    }

    public void m7118g() {
        C3095y.m9471a("On my moments cache modified called");
        new Handler(Looper.getMainLooper()).post(new C25783(this));
    }

    public void onBitmapLoaded(Bitmap bitmap, LoadedFrom loadedFrom) {
        this.f4798k.setImageBitmap(bitmap);
    }

    public void onBitmapFailed(Drawable drawable) {
        C3095y.m9471a("Error getting avatar image");
    }

    public void onPrepareLoad(Drawable drawable) {
    }
}
