package com.tinder.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.tinder.R;
import com.tinder.managers.C2807a;
import com.tinder.managers.C2958p;
import com.tinder.managers.ManagerApp;
import com.tinder.model.PhotoUser;
import com.tinder.model.SparksEvent;
import com.tinder.model.User;
import com.tinder.picassowebp.picasso.Picasso;
import com.tinder.utils.C3070i;
import com.tinder.utils.C3095y;
import com.tinder.utils.al;
import com.tinder.views.CircleTransformation;
import com.tinder.views.CircleWithImage;
import java.util.Date;

public class ae extends Dialog implements OnClickListener {
    private C2460a f4421a;
    private String f4422b;
    private Button f4423c;
    private Button f4424d;
    private Button f4425e;
    private User f4426f;
    private CountDownTimer f4427g;
    private TextView f4428h;

    /* renamed from: com.tinder.dialogs.ae.1 */
    class C24591 extends CountDownTimer {
        final /* synthetic */ TextView f4419a;
        final /* synthetic */ ae f4420b;

        C24591(ae aeVar, long j, long j2, TextView textView) {
            this.f4420b = aeVar;
            this.f4419a = textView;
            super(j, j2);
        }

        public void onTick(long j) {
            this.f4419a.setText(C3070i.m9368b(j - 1000));
        }

        public void onFinish() {
            this.f4420b.dismiss();
        }
    }

    /* renamed from: com.tinder.dialogs.ae.a */
    public interface C2460a {
        void m6837a(View view);

        void m6838b(View view);

        void m6839c(View view);
    }

    public ae(Context context, User user, int i) {
        super(context);
        this.f4426f = user;
        this.f4422b = ((PhotoUser) this.f4426f.getPhotos().get(i)).getImageUrl();
        m6840a();
    }

    public void m6844a(C2460a c2460a) {
        this.f4421a = c2460a;
    }

    private void m6840a() {
        getWindow().getAttributes().windowAnimations = R.style.dialog_up_down_animation;
        requestWindowFeature(1);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setContentView(R.layout.dialog_superlike_drained);
        int a = al.m9262a(getContext()) / 2;
        Picasso.m8982a(getContext()).m8990a(this.f4422b).m9123a(new CircleTransformation()).m9127b().m9129b(a, a).m9124a((CircleWithImage) findViewById(R.id.rec_photo));
        TextView textView = (TextView) findViewById(R.id.superlike_countdown);
        TextView textView2 = (TextView) findViewById(R.id.superlike_details);
        this.f4428h = (TextView) findViewById(R.id.superlike_countdown_details);
        this.f4423c = (Button) findViewById(R.id.btn_okay);
        this.f4424d = (Button) findViewById(R.id.btn_cancel);
        this.f4425e = (Button) findViewById(R.id.btn_getplus);
        ManagerApp.m7914e();
        if (C2958p.aj()) {
            textView2.setText(R.string.superlike_out_body_has_plus);
            this.f4423c.setVisibility(0);
            this.f4423c.setOnClickListener(this);
            this.f4424d.setVisibility(8);
            this.f4425e.setVisibility(8);
        } else {
            String name = this.f4426f.getName();
            textView2.setText(String.format(getContext().getResources().getString(R.string.superlike_out_body_upgrade), new Object[]{name}));
            this.f4424d.setVisibility(0);
            this.f4425e.setVisibility(0);
            this.f4424d.setOnClickListener(this);
            this.f4425e.setOnClickListener(this);
            this.f4423c.setVisibility(8);
        }
        m6841a(textView);
    }

    private long m6842b() {
        String resetDate = ManagerApp.m7924o().m8720g().getResetDate();
        if (resetDate == null || resetDate.equalsIgnoreCase("null")) {
            return -1;
        }
        try {
            Date parse = C3070i.m9369b().parse(resetDate);
            if (parse == null) {
                return -1;
            }
            return (parse.getTime() + 1000) - System.currentTimeMillis();
        } catch (Throwable e) {
            C3095y.m9474a("parse superlike reset date in dialog:", e);
            return -1;
        }
    }

    private void m6841a(TextView textView) {
        long b = m6842b();
        if (b == -1) {
            dismiss();
        }
        long j = b / 1000;
        if (b <= 1000) {
            textView.setText(R.string.superlike_out_countdown_generic);
            this.f4428h.setVisibility(8);
            if (!ManagerApp.m7924o().m8736w()) {
                ManagerApp.m7911b().m8143d();
                ManagerApp.m7924o().m8715c(true);
            }
        } else {
            textView.setText(C3070i.m9368b(b));
            this.f4428h.setVisibility(0);
            this.f4427g = new C24591(this, b, 1000, textView);
            this.f4427g.start();
        }
        SparksEvent sparksEvent = new SparksEvent("SuperLikeRoadblock.View");
        sparksEvent.put("timeRemaining", Long.valueOf(j));
        sparksEvent.put("roadblockVersion", Integer.valueOf(1));
        sparksEvent.put("otherId", this.f4426f.getId());
        C2807a.m8056a(sparksEvent);
    }

    private void m6843c() {
        if (this.f4427g != null) {
            this.f4427g.cancel();
        }
    }

    public void onClick(View view) {
        long b;
        SparksEvent sparksEvent;
        switch (view.getId()) {
            case R.id.btn_cancel:
                b = m6842b() / 1000;
                sparksEvent = new SparksEvent("SuperLikeRoadblock.Select");
                sparksEvent.put("timeRemaining", Long.valueOf(b));
                sparksEvent.put("roadblockVersion", Integer.valueOf(1));
                sparksEvent.put("otherId", this.f4426f.getId());
                sparksEvent.put(NativeProtocol.WEB_DIALOG_ACTION, Integer.valueOf(1));
                C2807a.m8056a(sparksEvent);
                if (this.f4421a != null) {
                    this.f4421a.m6837a(view);
                    break;
                }
                break;
            case R.id.btn_getplus:
                b = m6842b() / 1000;
                sparksEvent = new SparksEvent("SuperLikeRoadblock.Select");
                sparksEvent.put("timeRemaining", Long.valueOf(b));
                sparksEvent.put("roadblockVersion", Integer.valueOf(1));
                sparksEvent.put("otherId", this.f4426f.getId());
                sparksEvent.put(NativeProtocol.WEB_DIALOG_ACTION, Integer.valueOf(2));
                C2807a.m8056a(sparksEvent);
                if (this.f4421a != null) {
                    this.f4421a.m6838b(view);
                    break;
                }
                break;
            case R.id.btn_okay:
                b = m6842b() / 1000;
                sparksEvent = new SparksEvent("SuperLikeRoadblock.Select");
                sparksEvent.put("timeRemaining", Long.valueOf(b));
                sparksEvent.put("roadblockVersion", Integer.valueOf(1));
                sparksEvent.put("otherId", this.f4426f.getId());
                sparksEvent.put(NativeProtocol.WEB_DIALOG_ACTION, Integer.valueOf(3));
                C2807a.m8056a(sparksEvent);
                if (this.f4421a != null) {
                    this.f4421a.m6839c(view);
                    break;
                }
                break;
        }
        m6843c();
        dismiss();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            m6843c();
        }
        return super.onKeyUp(i, keyEvent);
    }
}
