package com.tinder.dialogs;

import android.animation.TimeInterpolator;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.stetho.BuildConfig;
import com.tinder.R;
import com.tinder.adapters.C2366s;
import com.tinder.enums.UserType;
import com.tinder.managers.C2807a;
import com.tinder.model.InstagramDataSet;
import com.tinder.model.InstagramPhoto;
import com.tinder.model.SparksEvent;
import com.tinder.picassowebp.picasso.Picasso;
import com.tinder.picassowebp.picasso.Picasso.LoadedFrom;
import com.tinder.utils.C2508e;
import com.tinder.utils.C3045a;
import com.tinder.utils.C3077n;
import com.tinder.utils.C3095y;
import com.tinder.utils.al;
import com.tinder.views.RoundImageView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tinder.dialogs.q */
public class C2514q extends Dialog implements OnPageChangeListener, OnClickListener {
    boolean f4547a;
    private Context f4548b;
    private View f4549c;
    private ViewPager f4550d;
    private C2366s f4551e;
    private RelativeLayout f4552f;
    private RoundImageView f4553g;
    private TextView f4554h;
    private TextView f4555i;
    private TextView f4556j;
    @Nullable
    private C2512a f4557k;
    private ImageView f4558l;
    private C2513b f4559m;
    private InstagramDataSet f4560n;
    private int f4561o;
    private int f4562p;
    private int f4563q;
    private int f4564r;
    private int f4565s;
    private float f4566t;
    private float f4567u;
    private float f4568v;
    private String f4569w;
    private UserType f4570x;
    private long f4571y;

    /* renamed from: com.tinder.dialogs.q.1 */
    class C25051 implements OnClickListener {
        final /* synthetic */ C2514q f4521a;

        C25051(C2514q c2514q) {
            this.f4521a = c2514q;
        }

        public void onClick(View view) {
            this.f4521a.m6938e();
        }
    }

    /* renamed from: com.tinder.dialogs.q.2 */
    class C25062 implements Runnable {
        final /* synthetic */ boolean f4522a;
        final /* synthetic */ C2514q f4523b;

        C25062(C2514q c2514q, boolean z) {
            this.f4523b = c2514q;
            this.f4522a = z;
        }

        public void run() {
            if (this.f4522a) {
                this.f4523b.f4558l.setVisibility(4);
            }
        }
    }

    /* renamed from: com.tinder.dialogs.q.3 */
    class C25073 extends SimpleSpringListener {
        final /* synthetic */ float f4524a;
        final /* synthetic */ float f4525b;
        final /* synthetic */ float f4526c;
        final /* synthetic */ float f4527d;
        final /* synthetic */ float f4528e;
        final /* synthetic */ float f4529f;
        final /* synthetic */ int f4530g;
        final /* synthetic */ int f4531h;
        final /* synthetic */ boolean f4532i;
        final /* synthetic */ C2514q f4533j;

        C25073(C2514q c2514q, float f, float f2, float f3, float f4, float f5, float f6, int i, int i2, boolean z) {
            this.f4533j = c2514q;
            this.f4524a = f;
            this.f4525b = f2;
            this.f4526c = f3;
            this.f4527d = f4;
            this.f4528e = f5;
            this.f4529f = f6;
            this.f4530g = i;
            this.f4531h = i2;
            this.f4532i = z;
        }

        public void onSpringUpdate(@NonNull Spring spring) {
            float currentValue = (float) spring.getCurrentValue();
            al.m9296c(this.f4533j.f4558l, C3077n.m9399a(currentValue, 0.0f, this.f4524a, 1.0f, this.f4525b));
            this.f4533j.f4558l.setTranslationX(C3077n.m9399a(currentValue, 0.0f, this.f4526c, 1.0f, this.f4527d));
            this.f4533j.f4558l.setTranslationY(C3077n.m9399a(currentValue, 0.0f, this.f4528e, 1.0f, this.f4529f));
            this.f4533j.f4552f.setAlpha(C3077n.m9399a(currentValue, 0.0f, (float) this.f4530g, 1.0f, (float) this.f4531h));
        }

        public void onSpringAtRest(Spring spring) {
            if (this.f4532i) {
                this.f4533j.m6932b(true);
            } else {
                this.f4533j.dismiss();
            }
        }
    }

    /* renamed from: com.tinder.dialogs.q.4 */
    class C25094 extends C2508e {
        final /* synthetic */ C2514q f4535a;

        C25094(C2514q c2514q, ImageView imageView) {
            this.f4535a = c2514q;
            super(imageView);
        }

        public void onBitmapLoaded(Bitmap bitmap, LoadedFrom loadedFrom) {
            super.onBitmapLoaded(bitmap, loadedFrom);
            this.f4535a.m6928a(true, this.f4535a.f4568v);
            this.f4535a.m6927a(true);
        }

        public void onBitmapFailed(Drawable drawable) {
            super.onBitmapFailed(drawable);
            this.f4535a.dismiss();
        }
    }

    /* renamed from: com.tinder.dialogs.q.5 */
    class C25105 implements Runnable {
        final /* synthetic */ Context f4536a;
        final /* synthetic */ C2514q f4537b;

        C25105(C2514q c2514q, Context context) {
            this.f4537b = c2514q;
            this.f4536a = context;
        }

        public void run() {
            float b = al.m9284b(10.0f, this.f4536a);
            float e = this.f4537b.f4567u;
            float f = this.f4537b.f4566t;
            e = ((e / 2.0f) - (f / 2.0f)) + this.f4537b.f4559m.m6915e();
            this.f4537b.f4552f.setY(((((float) (this.f4537b.f4550d.getHeight() / 2)) - (f / 2.0f)) - ((float) this.f4537b.f4552f.getHeight())) - b);
        }
    }

    /* renamed from: com.tinder.dialogs.q.6 */
    class C25116 extends C2508e {
        final /* synthetic */ C2514q f4538a;

        C25116(C2514q c2514q, ImageView imageView) {
            this.f4538a = c2514q;
            super(imageView);
        }

        public void onBitmapLoaded(Bitmap bitmap, LoadedFrom loadedFrom) {
            super.onBitmapLoaded(bitmap, loadedFrom);
            this.f4538a.f4558l.setVisibility(0);
            this.f4538a.m6932b(false);
        }

        public void onBitmapFailed(Drawable drawable) {
            super.onBitmapFailed(drawable);
            this.f4538a.f4558l.setAlpha(0);
            this.f4538a.m6932b(false);
        }
    }

    /* renamed from: com.tinder.dialogs.q.a */
    public interface C2512a {
        void m6903a();

        void m6904a(int i);
    }

    /* renamed from: com.tinder.dialogs.q.b */
    public static class C2513b {
        private float f4539a;
        private float f4540b;
        private float f4541c;
        private float f4542d;
        private float f4543e;
        private int f4544f;
        private int f4545g;
        private float f4546h;

        public float m6905a() {
            return this.f4539a;
        }

        public void m6906a(float f) {
            this.f4539a = f;
        }

        public float m6908b() {
            return this.f4540b;
        }

        public void m6909b(float f) {
            this.f4540b = f;
        }

        public float m6911c() {
            return this.f4541c;
        }

        public void m6912c(float f) {
            this.f4541c = f;
        }

        public float m6913d() {
            return this.f4542d;
        }

        public void m6914d(float f) {
            this.f4542d = f;
        }

        public String toString() {
            return String.format("thumbail width[%s] height[%s], x[%s] y[%s], statusbarheight [%s]", new Object[]{Float.valueOf(m6905a()), Float.valueOf(m6908b()), Float.valueOf(m6911c()), Float.valueOf(m6913d())});
        }

        public float m6915e() {
            return this.f4543e;
        }

        public void m6916e(float f) {
            this.f4543e = f;
        }

        public int m6917f() {
            return this.f4544f;
        }

        public void m6907a(int i) {
            this.f4544f = i;
        }

        public int m6919g() {
            return this.f4545g;
        }

        public void m6910b(int i) {
            this.f4545g = i;
        }

        public float m6920h() {
            return this.f4546h;
        }

        public void m6918f(float f) {
            this.f4546h = f;
        }
    }

    public C2514q(@NonNull Context context, int i, int i2, InstagramDataSet instagramDataSet, C2513b c2513b, String str, UserType userType, C2512a c2512a) {
        super(context, R.style.photo_viewer);
        this.f4563q = -1;
        this.f4571y = 700;
        setContentView(R.layout.instagram_photo_viewer);
        this.f4566t = (float) al.m9262a(this.f4548b);
        this.f4567u = (float) al.m9285b(this.f4548b);
        this.f4559m = c2513b;
        this.f4569w = str;
        this.f4570x = userType;
        this.f4568v = this.f4559m.m6905a() / this.f4566t;
        this.f4548b = context;
        this.f4561o = i;
        this.f4562p = i;
        this.f4564r = i2;
        this.f4560n = instagramDataSet;
        this.f4557k = c2512a;
        this.f4565s = (int) this.f4548b.getResources().getDimension(R.dimen.instagram_view_avatar_size);
        this.f4549c = findViewById(R.id.photo_background);
        this.f4553g = (RoundImageView) findViewById(R.id.profile_thumb);
        this.f4554h = (TextView) findViewById(R.id.username);
        this.f4555i = (TextView) findViewById(R.id.time);
        this.f4556j = (TextView) findViewById(R.id.nexttime);
        this.f4550d = (ViewPager) findViewById(R.id.photo_viewpager);
        this.f4552f = (RelativeLayout) findViewById(R.id.row_photo_details);
        this.f4558l = (ImageView) findViewById(R.id.photo_scale);
        List arrayList = new ArrayList(this.f4564r);
        for (int i3 = 0; i3 < this.f4564r; i3++) {
            arrayList.add(this.f4560n.getInstagramPhotos().get(i3));
        }
        this.f4551e = new C2366s(context, arrayList, new C25051(this));
        this.f4550d.setOffscreenPageLimit(0);
        this.f4550d.setAdapter(this.f4551e);
        this.f4550d.setCurrentItem(this.f4561o);
        this.f4550d.setOnPageChangeListener(this);
        this.f4550d.setPageMargin((int) this.f4548b.getResources().getDimension(R.dimen.ig_photoviewer_page_margin));
        this.f4553g.setOnClickListener(this);
        this.f4547a = C3077n.m9412e();
        m6936d();
        this.f4554h.setText(this.f4560n.getUserName());
        this.f4555i.setText(m6942a(((InstagramPhoto) this.f4560n.getInstagramPhotos().get(this.f4561o)).getTimestamp()));
        if (this.f4557k != null) {
            this.f4557k.m6904a(this.f4561o);
        }
        m6921a();
        m6922a(this.f4561o);
    }

    private void m6921a() {
        m6930b();
        m6934c();
    }

    private void m6927a(boolean z) {
        float f = 1.0f;
        float f2 = z ? 0.0f : 1.0f;
        if (!z) {
            f = 0.0f;
        }
        this.f4549c.setAlpha(f2);
        this.f4549c.animate().alpha(f).setDuration(225).start();
    }

    private void m6930b() {
        this.f4549c.setAlpha(0.0f);
        this.f4552f.setAlpha(0.0f);
        this.f4550d.setAlpha(0.0f);
    }

    private void m6932b(boolean z) {
        int i = 1;
        int i2 = z ? 0 : 1;
        if (!z) {
            i = 0;
        }
        TimeInterpolator decelerateInterpolator = new DecelerateInterpolator();
        this.f4550d.setAlpha((float) i2);
        this.f4550d.animate().alpha((float) i).setInterpolator(decelerateInterpolator).withEndAction(new C25062(this, z)).start();
        if (!z) {
            m6927a(false);
            m6928a(false, this.f4568v);
        }
    }

    private void m6928a(boolean z, float f) {
        float f2;
        float f3 = this.f4566t / 2.0f;
        float f4 = this.f4567u;
        if (this.f4547a) {
            f2 = 0.0f;
        } else {
            f2 = this.f4559m.m6915e();
        }
        float a = this.f4559m.m6905a() / 2.0f;
        float b = ((f2 + f4) / 2.0f) - (this.f4559m.m6908b() / 2.0f);
        f4 = this.f4559m.m6911c();
        f2 = this.f4559m.m6913d();
        if (!z) {
            int f5 = this.f4559m.m6917f();
            int g = this.f4559m.m6919g();
            f5 *= g;
            float a2 = (this.f4559m.m6905a() + (this.f4559m.m6920h() * 2.0f)) * ((float) ((this.f4561o % g) - (this.f4562p % g)));
            C3095y.m9471a(String.format("photo row - origin[%s],dest:[%s], offset[%s], translationY[%s]", new Object[]{Integer.valueOf((this.f4562p % f5) / g), Integer.valueOf((this.f4561o % f5) / g), Integer.valueOf(r15), Float.valueOf(((float) (r13 - ((this.f4562p % f5) / g))) * (this.f4559m.m6908b() + (this.f4559m.m6920h() * 2.0f)))}));
            C3095y.m9471a(String.format("photo column - origin[%s],dest:[%s]), offset[%s], translationX[%s]", new Object[]{Integer.valueOf(r14), Integer.valueOf(g), Float.valueOf(r16), Float.valueOf(a2)}));
            f4 += a2;
            f2 += r17;
            C3095y.m9471a(String.format("photo position origin:[%s] destination:[%s] ", new Object[]{Integer.valueOf(r8), Integer.valueOf(f5)}));
        }
        float f6 = f4 - (f3 - a);
        float e = (f2 - b) - (al.m9301e() ? this.f4559m.m6915e() : 0.0f);
        f3 = z ? f : 1.0f;
        if (z) {
            a = 1.0f;
        } else {
            a = f;
        }
        float f7 = z ? f6 : 0.0f;
        if (z) {
            f6 = 0.0f;
        }
        float f8 = z ? e : 0.0f;
        if (z) {
            e = 0.0f;
        }
        C3095y.m9471a(String.format("instagram thumb translation \n- transXStart [%s]\n- transXEnd [%s]\n- transYStart [%s]\n- transYEnd [%s] = original thumb top[%s] - photoTop[%s]\n- startXScale [%s]\n- endXScale [%s]\n\n- screenHeight [%s]\n- midpointScreenHeight[%s]\n- thumbnailHeight[%s]- midpoint thumbnailHeight[%s]\n- statusbar height[%s]", new Object[]{Float.valueOf(f7), Float.valueOf(f6), Float.valueOf(f8), Float.valueOf(e), Float.valueOf(f2), Float.valueOf(b), Float.valueOf(f3), Float.valueOf(a), Float.valueOf(this.f4567u), Float.valueOf(r10), Float.valueOf(this.f4559m.m6908b()), Float.valueOf(r11), Float.valueOf(this.f4559m.m6915e())}));
        int i = z ? 0 : 1;
        int i2 = z ? 1 : 0;
        if (!z) {
            this.f4558l.setVisibility(0);
            this.f4550d.setVisibility(4);
        }
        al.m9296c(this.f4558l, f3);
        this.f4558l.setTranslationX(f7);
        this.f4558l.setTranslationY(f8);
        Spring a3 = C3045a.m9201a();
        a3.setOvershootClampingEnabled(!z);
        a3.setVelocity(80.0d);
        a3.addListener(new C25073(this, f3, a, f7, f6, f8, e, i, i2, z));
        a3.setCurrentValue(0.0d);
        a3.setEndValue(1.0d);
    }

    public void dismiss() {
        this.f4557k = null;
        super.dismiss();
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageSelected(int i) {
        this.f4561o = i;
        if (this.f4557k != null) {
            this.f4557k.m6904a(i);
        }
        this.f4555i.setText(m6942a(((InstagramPhoto) this.f4560n.getInstagramPhotos().get(i)).getTimestamp()));
        m6922a(i);
    }

    public void onPageScrollStateChanged(int i) {
    }

    protected String m6942a(long j) {
        int i;
        String str = BuildConfig.FLAVOR;
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = currentTimeMillis - j;
        if (j2 == currentTimeMillis) {
            str = "%sh";
            i = 0;
        } else if (j2 >= ((long) 604800000)) {
            str = "%sw";
            i = (int) (j2 / ((long) 604800000));
        } else if (j2 >= ((long) 86400000)) {
            str = "%sd";
            i = (int) (j2 / ((long) 86400000));
        } else if (j2 >= ((long) 3600000)) {
            str = "%sh";
            i = (int) (j2 / ((long) 3600000));
        } else {
            str = "%sm";
            i = (int) (j2 / ((long) 60000));
        }
        return String.format(str, new Object[]{Integer.valueOf(i)});
    }

    private void m6934c() {
        C3095y.m9471a("downloadAndSetTempImage");
        InstagramPhoto instagramPhoto = (InstagramPhoto) this.f4560n.getInstagramPhotos().get(this.f4561o);
        Picasso.m8982a(this.f4548b).m8990a(instagramPhoto.getUrl()).m9126a(new C25094(this, this.f4558l));
    }

    private void m6936d() {
        C3095y.m9471a("setProfilePhoto");
        String profilePictureUrl = this.f4560n.getProfilePictureUrl();
        if (!TextUtils.isEmpty(profilePictureUrl)) {
            Picasso.m8982a(this.f4548b).m8990a(profilePictureUrl).m9129b(this.f4565s, this.f4565s).m9127b().m9126a(this.f4553g);
        }
        m6923a(this.f4548b);
    }

    private void m6923a(@NonNull Context context) {
        C3095y.m9471a("setProfilePhotoPosition");
        this.f4552f.post(new C25105(this, context));
    }

    private void m6938e() {
        if (this.f4562p != this.f4561o) {
            InstagramPhoto instagramPhoto = (InstagramPhoto) this.f4560n.getInstagramPhotos().get(this.f4561o);
            Picasso.m8982a(this.f4548b).m8990a(instagramPhoto.getUrl()).m9126a(new C25116(this, this.f4558l));
            return;
        }
        m6932b(false);
    }

    public void onClick(@NonNull View view) {
        switch (view.getId()) {
            case R.id.profile_thumb:
            case R.id.username:
                this.f4557k.m6903a();
            default:
        }
    }

    public void onBackPressed() {
        m6938e();
    }

    private void m6922a(int i) {
        boolean z = true;
        C3095y.m9471a("track visible photo: " + i);
        if (this.f4570x != UserType.ME) {
            SparksEvent sparksEvent = null;
            int i2 = this.f4563q < i ? 1 : 2;
            if (i != this.f4560n.getInstagramPhotos().size() - 1) {
                z = false;
            }
            if (this.f4570x == UserType.REC) {
                sparksEvent = new SparksEvent("Recs.ProfileInstagramPhotoViewerPage");
            } else if (this.f4570x == UserType.MATCH) {
                sparksEvent = new SparksEvent("Chat.ProfileInstagramPhotoViewerPage");
            }
            if (this.f4563q != -1) {
                sparksEvent.put("direction", Integer.valueOf(i2));
            }
            sparksEvent.put("otherId", this.f4569w);
            sparksEvent.put("instagramName", this.f4560n.getUserName());
            sparksEvent.put("endOfPhotos", Boolean.valueOf(z));
            C2807a.m8056a(sparksEvent);
        }
        this.f4563q = i;
    }
}
