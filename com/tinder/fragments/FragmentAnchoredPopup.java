package com.tinder.fragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.rebound.SpringListener;
import com.facebook.rebound.SpringSystem;
import com.tinder.R;
import com.tinder.managers.ManagerApp;
import com.tinder.utils.C3095y;
import com.tinder.utils.al;
import com.tinder.views.StackLayout;
import java.util.ArrayList;
import java.util.Iterator;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class FragmentAnchoredPopup extends Fragment {
    @Nullable
    private LinearLayout f4713A;
    @Nullable
    private LinearLayout f4714B;
    private int f4715C;
    private boolean f4716D;
    private Bitmap[] f4717E;
    private boolean f4718F;
    public Context f4719a;
    @NonNull
    protected Handler f4720b;
    @Nullable
    protected ImageView f4721c;
    @Nullable
    protected ImageView f4722d;
    protected SpringSystem f4723e;
    protected float f4724f;
    @Nullable
    protected RelativeLayout f4725g;
    protected boolean f4726h;
    protected int f4727i;
    protected View f4728j;
    protected float f4729k;
    @Nullable
    protected View f4730l;
    protected final Runnable f4731m;
    protected Strategy f4732n;
    protected Object[] f4733o;
    protected final Runnable f4734p;
    private C2720t f4735q;
    private Runnable f4736r;
    private Runnable f4737s;
    private Runnable f4738t;
    private Runnable f4739u;
    private ArrayList<ImageView> f4740v;
    private ArrayList<View> f4741w;
    private boolean f4742x;
    @Nullable
    private View f4743y;
    @Nullable
    private LinearLayout f4744z;

    /* renamed from: com.tinder.fragments.FragmentAnchoredPopup.1 */
    class C25601 implements Runnable {
        final /* synthetic */ FragmentAnchoredPopup f4704a;

        /* renamed from: com.tinder.fragments.FragmentAnchoredPopup.1.1 */
        class C25591 implements OnLayoutChangeListener {
            final /* synthetic */ Canvas[] f4696a;
            final /* synthetic */ ViewGroup f4697b;
            final /* synthetic */ Paint f4698c;
            final /* synthetic */ PorterDuffXfermode f4699d;
            final /* synthetic */ StackLayout f4700e;
            final /* synthetic */ View f4701f;
            final /* synthetic */ ArrayList f4702g;
            final /* synthetic */ C25601 f4703h;

            /* renamed from: com.tinder.fragments.FragmentAnchoredPopup.1.1.1 */
            class C25581 implements Runnable {
                final /* synthetic */ C25591 f4695a;

                C25581(C25591 c25591) {
                    this.f4695a = c25591;
                }

                public void run() {
                    if (!this.f4695a.f4703h.f4704a.f4726h) {
                        this.f4695a.f4703h.f4704a.f4726h = true;
                        this.f4695a.f4703h.f4704a.f4717E[0] = Bitmap.createBitmap(this.f4695a.f4703h.f4704a.f4722d.getWidth(), this.f4695a.f4703h.f4704a.f4722d.getHeight(), Config.ARGB_8888);
                        this.f4695a.f4696a[0] = new Canvas(this.f4695a.f4703h.f4704a.f4717E[0]);
                        this.f4695a.f4703h.f4704a.f4717E[0].eraseColor(0);
                        this.f4695a.f4696a[0].drawColor(this.f4695a.f4703h.f4704a.getResources().getColor(R.color.very_translucent_black));
                        Point a = al.m9263a(this.f4695a.f4697b);
                        this.f4695a.f4698c.setColor(-1);
                        this.f4695a.f4698c.setXfermode(this.f4695a.f4699d);
                        int i = -((al.m9263a(this.f4695a.f4703h.f4704a.m7066b((int) R.id.background)).y - (al.m9263a(this.f4695a.f4700e).y + this.f4695a.f4700e.getMeasuredHeight())) / 2);
                        this.f4695a.f4696a[0].drawCircle((float) (a.x + (this.f4695a.f4703h.f4704a.f4730l.getMeasuredWidth() / 2)), (((float) a.y) + this.f4695a.f4703h.f4704a.f4729k) + ((float) ((this.f4695a.f4697b.getMeasuredHeight() - this.f4695a.f4701f.getMeasuredHeight()) / 2)), (((float) this.f4695a.f4701f.getMeasuredWidth()) * this.f4695a.f4703h.f4704a.f4724f) / 2.0f, this.f4695a.f4698c);
                        this.f4695a.f4696a[0].drawBitmap(this.f4695a.f4703h.f4704a.f4717E[0], 0.0f, 0.0f, null);
                        this.f4695a.f4703h.f4704a.f4722d.setImageBitmap(this.f4695a.f4703h.f4704a.f4717E[0]);
                        Iterator it = this.f4695a.f4702g.iterator();
                        while (it.hasNext()) {
                            int intValue = ((Integer) it.next()).intValue();
                            if (intValue != this.f4695a.f4703h.f4704a.f4727i) {
                                this.f4695a.f4703h.f4704a.m7066b(intValue).setTranslationY((float) i);
                            }
                        }
                        LayoutParams layoutParams = (LayoutParams) this.f4695a.f4703h.f4704a.f4721c.getLayoutParams();
                        layoutParams.addRule(5, this.f4695a.f4703h.f4704a.f4727i);
                        layoutParams.addRule(7, this.f4695a.f4703h.f4704a.f4727i);
                        this.f4695a.f4703h.f4704a.f4721c.setLayoutParams(layoutParams);
                        this.f4695a.f4703h.f4704a.f4725g.setPivotY(((float) al.m9263a(this.f4695a.f4703h.f4704a.f4721c).y) - (this.f4695a.f4703h.f4704a.f4729k / 4.0f));
                        this.f4695a.f4703h.f4704a.f4725g.setPivotX((float) (al.m9263a(this.f4695a.f4703h.f4704a.f4730l).x + (this.f4695a.f4703h.f4704a.f4730l.getMeasuredWidth() / 2)));
                        this.f4695a.f4703h.f4704a.m7059h();
                        this.f4695a.f4703h.f4704a.f4716D = true;
                    }
                }
            }

            C25591(C25601 c25601, Canvas[] canvasArr, ViewGroup viewGroup, Paint paint, PorterDuffXfermode porterDuffXfermode, StackLayout stackLayout, View view, ArrayList arrayList) {
                this.f4703h = c25601;
                this.f4696a = canvasArr;
                this.f4697b = viewGroup;
                this.f4698c = paint;
                this.f4699d = porterDuffXfermode;
                this.f4700e = stackLayout;
                this.f4701f = view;
                this.f4702g = arrayList;
            }

            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                ManagerApp.m7919j().m7939E().post(new C25581(this));
            }
        }

        C25601(FragmentAnchoredPopup fragmentAnchoredPopup) {
            this.f4704a = fragmentAnchoredPopup;
        }

        public void run() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(R.id.passport));
            arrayList.add(Integer.valueOf(R.id.superlike));
            arrayList.add(Integer.valueOf(R.id.rewind));
            arrayList.add(Integer.valueOf(R.id.like));
            arrayList.add(Integer.valueOf(R.id.pass));
            arrayList.add(Integer.valueOf(R.id.background));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = ((Integer) it.next()).intValue();
                if (this.f4704a.m7066b(intValue) != null) {
                    this.f4704a.m7066b(intValue).setVisibility(4);
                }
            }
            arrayList.add(Integer.valueOf(R.id.dialog_corner_bottom));
            arrayList.add(Integer.valueOf(R.id.dialog_popup_card_content));
            this.f4704a.f4717E = new Bitmap[1];
            Canvas[] canvasArr = new Canvas[1];
            StackLayout c = this.f4704a.f4735q.m7674c();
            ViewGroup viewGroup = (ViewGroup) this.f4704a.f4735q.m7698v().findViewById(this.f4704a.f4727i);
            this.f4704a.f4728j.addOnLayoutChangeListener(new C25591(this, canvasArr, viewGroup, new Paint(), new PorterDuffXfermode(Mode.CLEAR), c, viewGroup.getChildAt(0), arrayList));
        }
    }

    /* renamed from: com.tinder.fragments.FragmentAnchoredPopup.2 */
    class C25612 implements Runnable {
        final /* synthetic */ FragmentAnchoredPopup f4705a;

        C25612(FragmentAnchoredPopup fragmentAnchoredPopup) {
            this.f4705a = fragmentAnchoredPopup;
        }

        public void run() {
            this.f4705a.f4735q = (C2720t) this.f4705a.f4733o[0];
            this.f4705a.f4724f = this.f4705a.f4735q.m7699w();
        }
    }

    /* renamed from: com.tinder.fragments.FragmentAnchoredPopup.3 */
    class C25623 implements OnClickListener {
        final /* synthetic */ FragmentAnchoredPopup f4706a;

        C25623(FragmentAnchoredPopup fragmentAnchoredPopup) {
            this.f4706a = fragmentAnchoredPopup;
        }

        public void onClick(View view) {
            this.f4706a.m7071d();
        }
    }

    /* renamed from: com.tinder.fragments.FragmentAnchoredPopup.4 */
    class C25644 implements Runnable {
        final /* synthetic */ FragmentAnchoredPopup f4708a;

        /* renamed from: com.tinder.fragments.FragmentAnchoredPopup.4.1 */
        class C25631 implements SpringListener {
            final /* synthetic */ C25644 f4707a;

            C25631(C25644 c25644) {
                this.f4707a = c25644;
            }

            public void onSpringUpdate(@NonNull Spring spring) {
                al.m9274a(this.f4707a.f4708a.f4722d, (float) Math.min(1.0d, spring.getCurrentValue()));
                al.m9296c(this.f4707a.f4708a.f4725g, (float) spring.getCurrentValue());
            }

            public void onSpringAtRest(Spring spring) {
                this.f4707a.f4708a.f4718F = false;
                if (this.f4707a.f4708a.f4738t != null) {
                    this.f4707a.f4708a.f4738t.run();
                }
            }

            public void onSpringActivate(Spring spring) {
                this.f4707a.f4708a.f4728j.setVisibility(0);
                this.f4707a.f4708a.f4726h = true;
            }

            public void onSpringEndStateChange(Spring spring) {
            }
        }

        C25644(FragmentAnchoredPopup fragmentAnchoredPopup) {
            this.f4708a = fragmentAnchoredPopup;
        }

        public void run() {
            this.f4708a.m7060i().setCurrentValue(0.0d).setEndValue(1.0d).addListener(new C25631(this));
        }
    }

    /* renamed from: com.tinder.fragments.FragmentAnchoredPopup.5 */
    class C25655 implements SpringListener {
        final /* synthetic */ FragmentAnchoredPopup f4709a;

        C25655(FragmentAnchoredPopup fragmentAnchoredPopup) {
            this.f4709a = fragmentAnchoredPopup;
        }

        public void onSpringUpdate(@NonNull Spring spring) {
            al.m9274a(this.f4709a.f4722d, (float) Math.min(1.0d, spring.getCurrentValue()));
            al.m9296c(this.f4709a.f4725g, (float) spring.getCurrentValue());
            al.m9296c(this.f4709a.f4730l, (float) spring.getCurrentValue());
        }

        public void onSpringAtRest(Spring spring) {
            this.f4709a.f4718F = false;
            this.f4709a.f4717E = null;
            this.f4709a.f4728j.setVisibility(8);
            if (this.f4709a.f4736r != null) {
                this.f4709a.f4736r.run();
            }
        }

        public void onSpringActivate(Spring spring) {
        }

        public void onSpringEndStateChange(Spring spring) {
        }
    }

    /* renamed from: com.tinder.fragments.FragmentAnchoredPopup.6 */
    static /* synthetic */ class C25666 {
        static final /* synthetic */ int[] f4710a;

        static {
            f4710a = new int[Strategy.values().length];
            try {
                f4710a[Strategy.GAMEPAD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    enum Strategy {
        GAMEPAD
    }

    /* renamed from: com.tinder.fragments.FragmentAnchoredPopup.a */
    public static abstract class C2567a {
    }

    public FragmentAnchoredPopup() {
        this.f4720b = new Handler();
        this.f4731m = new C25601(this);
        this.f4734p = new C25612(this);
    }

    protected Pair<Runnable, Runnable> m7061a() {
        switch (C25666.f4710a[this.f4732n.ordinal()]) {
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                C3095y.m9471a("strategy gamepad");
                return new Pair(this.f4734p, this.f4731m);
            default:
                C3095y.m9471a("strategy null");
                return null;
        }
    }

    public void m7065a(Runnable runnable) {
        this.f4736r = runnable;
    }

    public void m7068b(Runnable runnable) {
        this.f4739u = runnable;
    }

    public void m7070c(Runnable runnable) {
        this.f4737s = runnable;
    }

    public void m7063a(int i, int i2, Strategy strategy, Object... objArr) {
        this.f4742x = false;
        this.f4715C = i;
        this.f4719a = getActivity();
        this.f4727i = i2;
        this.f4730l = m7066b(i2);
        this.f4732n = strategy;
        this.f4733o = objArr;
        m7058g();
    }

    private void m7058g() {
        ((Runnable) m7061a().first).run();
    }

    public void m7064a(Drawable drawable) {
        if (this.f4730l != null) {
            al.m9271a(this.f4730l instanceof ViewGroup ? ((ViewGroup) this.f4730l).getChildAt(0) : this.f4730l, drawable);
        }
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dialog_anchored_template, viewGroup, false);
        inflate.setVisibility(8);
        this.f4728j = inflate;
        return inflate;
    }

    public void m7062a(int i) {
        m7067b();
        Iterator it = this.f4740v.iterator();
        while (it.hasNext()) {
            ImageView imageView = (ImageView) it.next();
            if (imageView != null) {
                imageView.setColorFilter(i);
            }
        }
        it = this.f4741w.iterator();
        while (it.hasNext()) {
            View view = (View) it.next();
            if (view != null) {
                view.setBackgroundColor(i);
            }
        }
    }

    private void m7049a(@NonNull ViewGroup viewGroup, @Nullable View view) {
        viewGroup.removeAllViews();
        if (view != null) {
            viewGroup.addView(view);
        }
    }

    public void setTopView(View view) {
        m7067b();
        m7049a(this.f4744z, view);
    }

    public void setBottomView(View view) {
        m7067b();
        m7049a(this.f4713A, view);
    }

    public void setCenterView(View view) {
        m7067b();
        m7049a(this.f4714B, view);
    }

    @Nullable
    public View m7066b(int i) {
        if (this.f4728j != null) {
            return this.f4728j.findViewById(i);
        }
        return null;
    }

    protected void m7067b() {
        if (this.f4742x) {
            C3095y.m9469a();
            return;
        }
        C3095y.m9469a();
        this.f4742x = true;
        this.f4744z = (LinearLayout) m7066b((int) R.id.dialog_top_view);
        this.f4714B = (LinearLayout) m7066b((int) R.id.dialog_center_view);
        this.f4713A = (LinearLayout) m7066b((int) R.id.dialog_top_bottom);
        this.f4743y = m7066b((int) R.id.dialog_root);
        this.f4725g = (RelativeLayout) m7066b((int) R.id.dialog_content_root);
        this.f4722d = (ImageView) m7066b((int) R.id.dialog_background);
        if (this.f4715C == 80) {
            this.f4721c = (ImageView) m7066b((int) R.id.dialog_corner_bottom);
            this.f4723e = SpringSystem.create();
            this.f4722d.setOnClickListener(new C25623(this));
            this.f4740v = new ArrayList();
            this.f4740v.add((ImageView) m7066b((int) R.id.dialog_corner_bottom));
            this.f4741w = new ArrayList();
            this.f4741w.add(m7066b((int) R.id.dialog_top_bottom));
            this.f4728j.measure(0, 0);
            this.f4721c.measure(0, 0);
            if (this.f4743y != null) {
                this.f4743y.measure(0, 0);
            }
            this.f4721c.measure(0, 0);
            ((Runnable) m7061a().second).run();
            if (this.f4716D) {
                m7059h();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Not implemented!");
    }

    private void m7059h() {
        this.f4720b.post(new C25644(this));
    }

    public void m7069c() {
        m7067b();
        if (!this.f4718F) {
            if (this.f4739u != null) {
                this.f4739u.run();
            }
            this.f4718F = true;
            this.f4728j.setVisibility(4);
        }
    }

    public void m7071d() {
        m7067b();
        if (!this.f4718F) {
            if (this.f4737s != null) {
                this.f4737s.run();
            }
            this.f4718F = true;
            Spring overshootClampingEnabled = m7060i().setCurrentValue(1.0d).setEndValue(0.0d).setOvershootClampingEnabled(true);
            this.f4728j.setVisibility(0);
            overshootClampingEnabled.addListener(new C25655(this));
        }
    }

    private Spring m7060i() {
        return this.f4723e.createSpring().setVelocity(200.0d).setSpringConfig(SpringConfig.fromOrigamiTensionAndFriction(42.0d, 7.0d));
    }

    public boolean m7072e() {
        return this.f4728j != null && this.f4728j.getVisibility() == 0;
    }

    public void m7073f() {
        if (this.f4728j != null) {
            this.f4728j.setVisibility(8);
        }
    }
}
