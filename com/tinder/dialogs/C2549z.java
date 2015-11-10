package com.tinder.dialogs;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.tinder.R;
import com.tinder.adapters.C2344h;
import com.tinder.enums.PhotoSizeMoment;
import com.tinder.managers.C2807a;
import com.tinder.managers.ManagerApp;
import com.tinder.model.Moment;
import com.tinder.model.SparksEvent;
import com.tinder.p030d.ak;
import com.tinder.p030d.aq;
import com.tinder.p030d.bh;
import com.tinder.picassowebp.picasso.C2281x;
import com.tinder.picassowebp.picasso.Picasso;
import com.tinder.picassowebp.picasso.Picasso.LoadedFrom;
import com.tinder.utils.C3070i;
import com.tinder.utils.C3075l;
import com.tinder.utils.C3095y;
import com.tinder.utils.al;
import com.tinder.views.RoundedRelativeLayout;

/* renamed from: com.tinder.dialogs.z */
public class C2549z extends Dialog implements OnClickListener, ak, aq, C2281x {
    private RoundedRelativeLayout f4646a;
    private ImageView f4647b;
    private ImageView f4648c;
    private ListView f4649d;
    private TextView f4650e;
    private ImageButton f4651f;
    private ImageButton f4652g;
    private View f4653h;
    private View f4654i;
    private View f4655j;
    private View f4656k;
    private PopupWindow f4657l;
    private Drawable f4658m;
    private Context f4659n;
    @Nullable
    private Moment f4660o;
    private int f4661p;
    private int f4662q;
    private boolean f4663r;
    private boolean f4664s;

    /* renamed from: com.tinder.dialogs.z.1 */
    class C25441 implements Runnable {
        final /* synthetic */ DecelerateInterpolator f4638a;
        final /* synthetic */ OvershootInterpolator f4639b;
        final /* synthetic */ C2549z f4640c;

        C25441(C2549z c2549z, DecelerateInterpolator decelerateInterpolator, OvershootInterpolator overshootInterpolator) {
            this.f4640c = c2549z;
            this.f4638a = decelerateInterpolator;
            this.f4639b = overshootInterpolator;
        }

        public void run() {
            this.f4640c.f4646a.animate().setInterpolator(this.f4638a).scaleXBy(0.06999999f).scaleYBy(0.06999999f).setStartDelay(0).setInterpolator(this.f4638a);
            this.f4640c.f4656k.animate().alpha(0.0f).setStartDelay(0).setInterpolator(this.f4638a).start();
            this.f4640c.f4655j.animate().alpha(1.0f).setStartDelay(0).setInterpolator(this.f4638a).start();
            this.f4640c.f4649d.animate().y(0.0f).alpha(1.0f).setInterpolator(this.f4639b).start();
        }
    }

    /* renamed from: com.tinder.dialogs.z.2 */
    class C25452 implements AnimatorListener {
        final /* synthetic */ ImageButton f4641a;
        final /* synthetic */ C2549z f4642b;

        C25452(C2549z c2549z, ImageButton imageButton) {
            this.f4642b = c2549z;
            this.f4641a = imageButton;
        }

        public void onAnimationStart(Animator animator) {
            this.f4642b.f4652g.setVisibility(4);
            this.f4642b.f4658m.setColorFilter(this.f4642b.getContext().getResources().getColor(R.color.btn_pass_red), Mode.SRC_ATOP);
            this.f4641a.animate().translationYBy(-15.0f).scaleXBy(0.15f).scaleYBy(0.15f).setDuration(50).start();
        }

        public void onAnimationEnd(Animator animator) {
            this.f4642b.m7000m();
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* renamed from: com.tinder.dialogs.z.3 */
    class C25463 implements bh {
        final /* synthetic */ C2549z f4643a;

        C25463(C2549z c2549z) {
            this.f4643a = c2549z;
        }

        public void m6982a() {
            if (this.f4643a.f4659n != null) {
                Toast.makeText(this.f4643a.f4659n, R.string.moment_bitmap_saved, 0).show();
            }
        }

        public void m6983b() {
            if (this.f4643a.f4659n != null) {
                Toast.makeText(this.f4643a.f4659n, R.string.moment_bitmap_not_saved, 0).show();
            }
        }
    }

    /* renamed from: com.tinder.dialogs.z.4 */
    class C25474 implements AnimatorListener {
        final /* synthetic */ C2549z f4644a;

        C25474(C2549z c2549z) {
            this.f4644a = c2549z;
        }

        public void onAnimationStart(Animator animator) {
            this.f4644a.f4651f.getDrawable().setColorFilter(this.f4644a.getContext().getResources().getColor(R.color.btn_like_green), Mode.SRC_ATOP);
        }

        public void onAnimationEnd(Animator animator) {
            this.f4644a.f4651f.getDrawable().setColorFilter(null);
            this.f4644a.f4654i.animate().alpha(0.0f).start();
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* renamed from: com.tinder.dialogs.z.5 */
    class C25485 implements Runnable {
        final /* synthetic */ C2549z f4645a;

        C25485(C2549z c2549z) {
            this.f4645a = c2549z;
        }

        public void run() {
            this.f4645a.f4657l.dismiss();
            this.f4645a.f4658m.setColorFilter(null);
            this.f4645a.dismiss();
        }
    }

    public C2549z(@NonNull Context context, @Nullable Moment moment, boolean z, int i) {
        String b;
        super(context, R.style.Theme.FloatingDialog);
        setContentView(R.layout.view_dialog_moment_metrics);
        getWindow().setWindowAnimations(R.style.dialog_up_down_animation);
        if (moment == null) {
            dismiss();
        }
        this.f4664s = al.m9276a();
        LayoutParams attributes = getWindow().getAttributes();
        attributes.dimAmount = 0.75f;
        attributes.width = -1;
        attributes.height = -1;
        getWindow().setAttributes(attributes);
        this.f4646a = (RoundedRelativeLayout) findViewById(R.id.dialog_moment_metric_rounded_layout);
        this.f4656k = findViewById(R.id.dialog_moment_metric_layout_ui);
        this.f4649d = (ListView) findViewById(R.id.dialog_moment_metric_listview);
        this.f4655j = findViewById(R.id.dialog_moment_metric_overlay);
        this.f4650e = (TextView) findViewById(R.id.dialog_moment_metric_txt_likes);
        this.f4651f = (ImageButton) findViewById(R.id.dialog_moment_metric_btn_save);
        this.f4652g = (ImageButton) findViewById(R.id.dialog_moment_metric_btn_delete);
        this.f4648c = (ImageView) findViewById(R.id.dialog_moment_metric_img_copy);
        this.f4647b = (ImageView) findViewById(R.id.dialog_moment_metric_img);
        this.f4654i = findViewById(R.id.dialog_moment_metric_img_copy_bg);
        this.f4653h = findViewById(R.id.frame_layout_moment_metric_progress);
        TextView textView = (TextView) findViewById(R.id.dialog_moment_metric_txt_timeLeft);
        this.f4659n = context;
        this.f4660o = moment;
        this.f4655j.setAlpha(0.0f);
        this.f4654i.setAlpha(0.0f);
        this.f4653h.setVisibility(0);
        if (moment.isPending() || moment.hasFailed()) {
            b = C3075l.m9393b(String.valueOf(moment.getCreatedTime()));
        } else {
            b = this.f4660o.getMomentPhoto().getProcessedFile(PhotoSizeMoment.ORIG);
        }
        C3095y.m9471a("pathImage=" + b);
        int a = al.m9262a(context);
        this.f4661p = al.m9285b(context);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f4646a.getLayoutParams();
        a = Math.round(((float) a) * 0.94f);
        int round = Math.round(((float) this.f4661p) * 0.94f);
        C3095y.m9471a("Getting image from Picasso");
        Picasso.m8982a(context).m8990a(b).m9129b(a, round).m9130c().m9126a((C2281x) this);
        layoutParams.width = a;
        layoutParams.height = round;
        this.f4646a.setLayoutParams(layoutParams);
        if (this.f4664s) {
            this.f4649d.setVisibility(4);
            this.f4655j.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        } else {
            this.f4649d.setY((float) this.f4661p);
        }
        if (!this.f4660o.isExpired()) {
            Pair hoursMinutesLeft = moment.getHoursMinutesLeft();
            if (((Integer) hoursMinutesLeft.first).intValue() < 1) {
                textView.setText(String.format(context.getResources().getQuantityString(R.plurals.minutes_left_plural, ((Integer) hoursMinutesLeft.second).intValue()), new Object[]{hoursMinutesLeft.second}));
            } else {
                textView.setText(String.format(context.getResources().getQuantityString(R.plurals.hours_left_plural, ((Integer) hoursMinutesLeft.first).intValue()), new Object[]{hoursMinutesLeft.first}));
            }
            textView.setVisibility(0);
        }
        int numLikes = this.f4660o.getNumLikes();
        this.f4650e.setText(String.format(context.getResources().getQuantityString(R.plurals.likes_plural, numLikes), new Object[]{Integer.valueOf(numLikes)}));
        this.f4651f.setOnClickListener(this);
        this.f4652g.setOnClickListener(this);
        if (numLikes > 0) {
            this.f4650e.setOnClickListener(this);
        }
        if (z) {
            Object c2344h = new C2344h(context);
            c2344h.m6388a(this.f4660o.getMomentLikes());
            this.f4649d.setAdapter(c2344h);
            c2344h.notifyDataSetChanged();
        } else {
            this.f4652g.setVisibility(8);
            this.f4650e.setVisibility(8);
            this.f4651f.setVisibility(8);
            this.f4649d.setVisibility(8);
        }
        this.f4662q = i;
        ManagerApp.m7926q().m8478e(moment.getId());
    }

    public void show() {
        ManagerApp.m7926q().m8457a((aq) this);
        super.show();
    }

    public void dismiss() {
        ManagerApp.m7926q().m8469b((aq) this);
        super.dismiss();
    }

    public void onBackPressed() {
        if (this.f4663r) {
            m7002b();
        } else {
            super.onBackPressed();
        }
    }

    public void m7001a() {
        this.f4663r = true;
        this.f4649d.setSelection(0);
        OvershootInterpolator overshootInterpolator = new OvershootInterpolator(1.1f);
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        if (this.f4664s) {
            this.f4649d.setVisibility(0);
            this.f4656k.setVisibility(4);
            this.f4655j.setAlpha(1.0f);
        } else {
            this.f4647b.post(new C25441(this, decelerateInterpolator, overshootInterpolator));
        }
        SparksEvent sparksEvent = new SparksEvent("Moments.ViewLikes");
        sparksEvent.put("momentId", this.f4660o.getId());
        C2807a.m8056a(sparksEvent);
    }

    public void m7002b() {
        TimeInterpolator anticipateInterpolator = new AnticipateInterpolator();
        TimeInterpolator decelerateInterpolator = new DecelerateInterpolator();
        if (this.f4664s) {
            this.f4649d.setVisibility(4);
            this.f4656k.setVisibility(0);
            this.f4655j.setAlpha(0.0f);
        } else {
            this.f4649d.animate().y((float) this.f4661p).alphaBy(GroundOverlayOptions.NO_DIMENSION).setInterpolator(anticipateInterpolator).setStartDelay(0).start();
            this.f4646a.animate().setInterpolator(anticipateInterpolator).scaleXBy(-0.07f).scaleYBy(-0.07f).setStartDelay(200).setInterpolator(decelerateInterpolator).start();
            this.f4655j.animate().alpha(0.0f).setStartDelay(200).setInterpolator(decelerateInterpolator).start();
            this.f4656k.animate().alpha(1.0f).setStartDelay(0).start();
        }
        this.f4663r = false;
    }

    private void m6992h() {
        if (this.f4660o.hasFailed()) {
            ManagerApp.m7926q().m8459a(this.f4660o);
            m6994i();
            return;
        }
        this.f4653h.setVisibility(0);
        ManagerApp.m7926q().m8460a(this.f4660o, (ak) this);
    }

    private void m6994i() {
        int[] iArr = new int[2];
        this.f4652g.getLocationInWindow(iArr);
        View imageButton = new ImageButton(getContext());
        imageButton.setBackgroundResource(0);
        imageButton.setImageDrawable(this.f4652g.getDrawable());
        this.f4658m = imageButton.getDrawable();
        this.f4657l = new PopupWindow();
        this.f4657l.setContentView(imageButton);
        this.f4657l.setAnimationStyle(R.style.dialog_animation_fade);
        this.f4657l.setWindowLayoutMode(-2, -2);
        float dimensionPixelSize = (float) getContext().getResources().getDimensionPixelSize(R.dimen.margin_med);
        this.f4657l.showAtLocation(this.f4646a, 3, (int) (((float) iArr[0]) - dimensionPixelSize), (int) (((float) iArr[1]) - dimensionPixelSize));
        this.f4646a.setPivotX((float) iArr[0]);
        this.f4646a.setPivotY((float) iArr[1]);
        imageButton.setPivotX((float) this.f4658m.getIntrinsicWidth());
        imageButton.setPivotX((float) (this.f4658m.getIntrinsicHeight() / 2));
        this.f4646a.animate().scaleX(0.0f).scaleY(0.0f).setDuration(370).setInterpolator(new AnticipateInterpolator()).setListener(new C25452(this, imageButton)).start();
    }

    private void m6996j() {
        String a = C3070i.m9363a(this.f4660o.getCreatedTime());
        this.f4647b.buildDrawingCache();
        C3075l.m9388a(getContext(), this.f4647b.getDrawingCache(), 100, "Tinder", a, new C25463(this));
        m6998k();
    }

    private void m6998k() {
        m6999l();
        int[] iArr = new int[2];
        this.f4651f.getLocationInWindow(iArr);
        this.f4648c.setPivotX((float) iArr[0]);
        this.f4648c.setPivotY((float) iArr[1]);
        this.f4648c.animate().scaleX(0.0f).scaleY(0.0f).setDuration(270).setInterpolator(new AccelerateInterpolator()).setListener(new C25474(this)).start();
    }

    private void m6999l() {
        this.f4648c.setImageBitmap(this.f4647b.getDrawingCache());
        al.m9296c(this.f4648c, 1.0f);
        if (VERSION.SDK_INT >= 16) {
            this.f4648c.setImageAlpha(1);
        } else {
            this.f4648c.setAlpha(1);
        }
        this.f4654i.setAlpha(1.0f);
    }

    private void m7000m() {
        getWindow().setWindowAnimations(R.style.dialog_animation_fade);
        this.f4646a.postDelayed(new C25485(this), 250);
    }

    public void onClick(@NonNull View view) {
        switch (view.getId()) {
            case R.id.dialog_moment_metric_txt_likes:
                m7001a();
            case R.id.dialog_moment_metric_btn_save:
                m6996j();
            case R.id.dialog_moment_metric_btn_delete:
                m6992h();
            default:
        }
    }

    public void m7003c() {
        SparksEvent sparksEvent = new SparksEvent("Moments.Delete");
        sparksEvent.put("momentId", this.f4660o.getId());
        sparksEvent.put("from", Integer.valueOf(this.f4662q));
        C2807a.m8056a(sparksEvent);
        this.f4653h.setVisibility(8);
        m6994i();
    }

    public void m7004d() {
        this.f4653h.setVisibility(8);
        Context context = getContext();
        if (context != null) {
            Toast.makeText(context, R.string.failed_delete_moment, 0).show();
        }
    }

    public void onBitmapLoaded(Bitmap bitmap, LoadedFrom loadedFrom) {
        C3095y.m9469a();
        this.f4647b.setImageBitmap(bitmap);
        this.f4653h.setVisibility(8);
    }

    public void onBitmapFailed(Drawable drawable) {
        C3095y.m9469a();
        this.f4653h.setVisibility(8);
    }

    public void onPrepareLoad(Drawable drawable) {
        C3095y.m9469a();
    }

    public void m7005e() {
    }

    public void m7006f() {
        Moment a = ManagerApp.m7926q().m8452a(this.f4660o.getId());
        if (a != null) {
            this.f4660o = a;
            int numLikes = this.f4660o.getNumLikes();
            this.f4650e.setText(String.format(this.f4659n.getResources().getQuantityString(R.plurals.likes_plural, numLikes), new Object[]{Integer.valueOf(numLikes)}));
        }
    }

    public void m7007g() {
    }
}
