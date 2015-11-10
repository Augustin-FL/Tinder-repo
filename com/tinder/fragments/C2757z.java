package com.tinder.fragments;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tinder.R;
import com.tinder.activities.ActivityMain;
import com.tinder.adapters.C2356l;
import com.tinder.fragments.FragmentAnchoredPopup.C2567a;
import com.tinder.managers.C2807a;
import com.tinder.managers.ManagerApp;
import com.tinder.model.Paywall;
import com.tinder.model.SparksEvent;
import com.tinder.model.TinderLocation;
import com.tinder.p030d.bk;
import com.tinder.utils.C3095y;
import com.tinder.utils.al;

/* renamed from: com.tinder.fragments.z */
public class C2757z extends C2567a implements OnClickListener, OnItemClickListener {
    public static float f5503a;
    private View f5504b;
    private ImageView f5505c;
    private TextView f5506d;
    private C2356l f5507e;
    private boolean f5508f;
    private FragmentAnchoredPopup f5509g;
    private int f5510h;
    private int f5511i;

    /* renamed from: com.tinder.fragments.z.1 */
    class C27511 implements bk {
        final /* synthetic */ C2757z f5492a;

        /* renamed from: com.tinder.fragments.z.1.1 */
        class C27491 implements Runnable {
            final /* synthetic */ C27511 f5490a;

            C27491(C27511 c27511) {
                this.f5490a = c27511;
            }

            public void run() {
                ((ActivityMain) this.f5490a.f5492a.f5509g.getActivity()).m6171L();
            }
        }

        /* renamed from: com.tinder.fragments.z.1.2 */
        class C27502 implements Runnable {
            final /* synthetic */ C27511 f5491a;

            C27502(C27511 c27511) {
                this.f5491a = c27511;
            }

            public void run() {
                this.f5491a.f5492a.f5509g.m7073f();
            }
        }

        C27511(C2757z c2757z) {
            this.f5492a = c2757z;
        }

        public void m7827a() {
            C3095y.m9471a("onSubscriptionStatusActive");
            this.f5492a.f5508f = false;
            SparksEvent sparksEvent = new SparksEvent("Passport.MapOpen");
            sparksEvent.put("from", Integer.valueOf(1));
            C2807a.m8056a(sparksEvent);
            this.f5492a.f5509g.f4720b.post(new C27491(this));
            this.f5492a.f5509g.f4720b.postDelayed(new C27502(this), 300);
        }

        public void m7828b() {
            C3095y.m9471a("onSubscriptionStatusInactive");
            this.f5492a.f5508f = false;
            SparksEvent sparksEvent = new SparksEvent("Passport.MapOpen");
            sparksEvent.put("from", Integer.valueOf(1));
            C2807a.m8056a(sparksEvent);
            ((Paywall) this.f5492a.f5509g.f4719a).launchPlusSubscriptionPaywall(1);
        }

        public void m7829c() {
            C3095y.m9471a("onSubscriptionStatusUnknown");
            this.f5492a.f5508f = false;
            Toast.makeText(this.f5492a.f5509g.f4719a, this.f5492a.f5509g.f4719a.getString(R.string.error_getting_plus_subscription_status), 1).show();
        }
    }

    /* renamed from: com.tinder.fragments.z.2 */
    class C27522 implements Runnable {
        final /* synthetic */ TinderLocation f5493a;
        final /* synthetic */ C2757z f5494b;

        C27522(C2757z c2757z, TinderLocation tinderLocation) {
            this.f5494b = c2757z;
            this.f5493a = tinderLocation;
        }

        public void run() {
            SparksEvent sparksEvent = new SparksEvent("Passport.MenuChooseLocation");
            sparksEvent.put("newLat", Double.valueOf(this.f5493a.getLatitude()));
            sparksEvent.put("newLon", Double.valueOf(this.f5493a.getLongitude()));
            C2807a.m8056a(sparksEvent);
        }
    }

    /* renamed from: com.tinder.fragments.z.3 */
    class C27533 implements Runnable {
        final /* synthetic */ C2757z f5495a;

        C27533(C2757z c2757z) {
            this.f5495a = c2757z;
        }

        public void run() {
            this.f5495a.f5508f = false;
            this.f5495a.f5509g.m7071d();
        }
    }

    /* renamed from: com.tinder.fragments.z.4 */
    class C27544 implements Runnable {
        final /* synthetic */ C2757z f5496a;

        C27544(C2757z c2757z) {
            this.f5496a = c2757z;
        }

        public void run() {
            this.f5496a.f5508f = false;
            C2807a.m8058a("Passport.MenuClose");
        }
    }

    /* renamed from: com.tinder.fragments.z.5 */
    class C27555 implements Runnable {
        final /* synthetic */ ImageView f5497a;
        final /* synthetic */ Context f5498b;
        final /* synthetic */ C2757z f5499c;

        C27555(C2757z c2757z, ImageView imageView, Context context) {
            this.f5499c = c2757z;
            this.f5497a = imageView;
            this.f5498b = context;
        }

        public void run() {
            al.m9271a(this.f5497a, ContextCompat.getDrawable(this.f5498b, R.drawable.recs_passport_close));
        }
    }

    /* renamed from: com.tinder.fragments.z.6 */
    class C27566 implements Runnable {
        final /* synthetic */ ImageView f5500a;
        final /* synthetic */ Context f5501b;
        final /* synthetic */ C2757z f5502c;

        C27566(C2757z c2757z, ImageView imageView, Context context) {
            this.f5502c = c2757z;
            this.f5500a = imageView;
            this.f5501b = context;
        }

        public void run() {
            al.m9271a(this.f5500a, ContextCompat.getDrawable(this.f5501b, R.drawable.recs_passport_available));
        }
    }

    static {
        f5503a = 0.75f;
    }

    private void m7831a(Context context) {
        this.f5504b = View.inflate(context, R.layout.cell_recent_passport, null);
        this.f5510h = context.getResources().getColor(R.color.premium_blue);
        this.f5511i = context.getResources().getColor(R.color.text_dark);
        ((ImageView) this.f5504b.findViewById(R.id.purchased_location_img)).setImageResource(R.drawable.recs_passport_list_mylocation);
        this.f5506d = (TextView) this.f5504b.findViewById(R.id.purchased_location_name);
        this.f5506d.setText(R.string.my_current_location);
        this.f5505c = (ImageView) this.f5504b.findViewById(R.id.purchased_location_check);
        m7833a();
    }

    public void m7833a() {
        if (this.f5505c != null) {
            boolean d = ManagerApp.m7916g().m8517d();
            this.f5505c.setVisibility(d ? 4 : 0);
            this.f5506d.setTextColor(d ? this.f5511i : this.f5510h);
        }
    }

    public void onClick(@NonNull View view) {
        if (!this.f5508f) {
            this.f5508f = true;
            switch (view.getId()) {
                case R.id.rec_passport_add_location_layout:
                    ManagerApp.m7921l().m8625a(new C27511(this));
                default:
                    this.f5508f = false;
            }
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (!this.f5508f) {
            this.f5508f = true;
            if (i == 0) {
                this.f5507e.m6413a(null);
                this.f5507e.notifyDataSetChanged();
                this.f5505c.setVisibility(0);
                ((ActivityMain) this.f5509g.getActivity()).m6170K();
                this.f5506d.setTextColor(this.f5510h);
                SparksEvent sparksEvent = new SparksEvent("Passport.MenuMyLocation");
                sparksEvent.put("from", Integer.valueOf(1));
                C2807a.m8056a(sparksEvent);
                m7833a();
                this.f5508f = false;
                this.f5509g.m7071d();
                return;
            }
            TinderLocation tinderLocation = (TinderLocation) this.f5507e.getItem(i - 1);
            this.f5505c.setVisibility(4);
            this.f5506d.setTextColor(this.f5511i);
            this.f5507e.m6413a(tinderLocation);
            ((ActivityMain) this.f5509g.getActivity()).m6189a(tinderLocation);
            this.f5507e.notifyDataSetChanged();
            m7833a();
            AsyncTask.execute(new C27522(this, tinderLocation));
            this.f5505c.post(new C27533(this));
        }
    }

    @Nullable
    public C2356l m7835b() {
        return this.f5507e;
    }

    public void m7834a(FragmentAnchoredPopup fragmentAnchoredPopup, @NonNull C2720t c2720t) {
        if (c2720t.getActivity() == null) {
            C3095y.m9479c("Cannot configure a dialog when the recomendation fragment does not have an activity");
            return;
        }
        this.f5509g = fragmentAnchoredPopup;
        this.f5509g.m7063a(80, R.id.passport, Strategy.GAMEPAD, c2720t);
        Context activity = c2720t.getActivity();
        this.f5509g.m7064a(ContextCompat.getDrawable(activity, R.drawable.recs_passport_close));
        this.f5509g.m7065a(new C27544(this));
        this.f5509g.setCenterView(LayoutInflater.from(this.f5509g.getActivity()).inflate(R.layout.dialog_passport_content, c2720t.m7698v(), false));
        this.f5509g.setBottomView(LayoutInflater.from(this.f5509g.getActivity()).inflate(R.layout.dialog_passport_bottom, c2720t.m7698v(), false));
        this.f5509g.m7062a(this.f5509g.getResources().getColor(R.color.passport));
        ImageView imageView = (ImageView) c2720t.m7698v().findViewById(R.id.btn_passport);
        this.f5509g.m7068b(new C27555(this, imageView, activity));
        this.f5509g.m7070c(new C27566(this, imageView, activity));
        ListView listView = (ListView) this.f5509g.m7066b((int) R.id.recs_passport_options_listview);
        m7831a(this.f5509g.getActivity());
        listView.addHeaderView(this.f5504b);
        listView.setOnItemClickListener(this);
        this.f5507e = new C2356l(ManagerApp.m7916g().m8510a(5));
        this.f5507e.m6413a(ManagerApp.m7916g().m8516c());
        m7833a();
        listView.setAdapter(this.f5507e);
        View b = this.f5509g.m7066b((int) R.id.rec_passport_add_location_layout);
        b.setClickable(true);
        b.setOnClickListener(this);
        al.m9270a(b, f5503a);
    }
}
