package com.tinder.dialogs;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.facebook.internal.WebDialog;
import com.tinder.R;
import com.tinder.p030d.C2263f;
import com.tinder.picassowebp.picasso.C2281x;
import com.tinder.picassowebp.picasso.Picasso;
import com.tinder.picassowebp.picasso.Picasso.LoadedFrom;
import com.tinder.utils.C3095y;
import com.tinder.utils.al;
import com.tinder.views.BlurredDrawable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* renamed from: com.tinder.dialogs.b */
public class C2469b extends aa {
    private int[][] f4447a;
    private Context f4448b;
    private FrameLayout f4449c;
    private RelativeLayout f4450d;
    @NonNull
    private List<View> f4451e;
    private int f4452f;
    private int f4453g;
    private int f4454h;
    private int f4455i;
    private int f4456j;
    private int f4457k;
    private int f4458l;
    private int f4459m;
    private BlurredDrawable f4460n;
    private String f4461o;
    private C2263f f4462p;
    private boolean f4463q;

    /* renamed from: com.tinder.dialogs.b.1 */
    class C24631 implements C2281x {
        final /* synthetic */ ImageView f4435a;
        final /* synthetic */ int f4436b;
        final /* synthetic */ int f4437c;
        final /* synthetic */ C2469b f4438d;

        C24631(C2469b c2469b, ImageView imageView, int i, int i2) {
            this.f4438d = c2469b;
            this.f4435a = imageView;
            this.f4436b = i;
            this.f4437c = i2;
        }

        public void onBitmapLoaded(Bitmap bitmap, LoadedFrom loadedFrom) {
            this.f4435a.setImageDrawable(this.f4438d.f4460n);
            this.f4438d.f4460n.blurBitmap(ThumbnailUtils.extractThumbnail(bitmap, this.f4436b, this.f4437c), 24);
        }

        public void onBitmapFailed(Drawable drawable) {
        }

        public void onPrepareLoad(Drawable drawable) {
        }
    }

    /* renamed from: com.tinder.dialogs.b.2 */
    class C24642 implements OnClickListener {
        final /* synthetic */ int f4439a;
        final /* synthetic */ C2469b f4440b;

        C24642(C2469b c2469b, int i) {
            this.f4440b = c2469b;
            this.f4439a = i;
        }

        public void onClick(@NonNull View view) {
            if (!this.f4440b.f4463q) {
                this.f4440b.f4449c.removeView(view);
                this.f4440b.f4449c.addView(view);
                this.f4440b.f4463q = true;
                this.f4440b.m6866e();
                this.f4440b.f4462p.m5973b(this.f4439a);
            }
        }
    }

    /* renamed from: com.tinder.dialogs.b.3 */
    class C24653 implements Runnable {
        final /* synthetic */ AnimatorSet f4441a;
        final /* synthetic */ C2469b f4442b;

        C24653(C2469b c2469b, AnimatorSet animatorSet) {
            this.f4442b = c2469b;
            this.f4441a = animatorSet;
        }

        public void run() {
            this.f4441a.start();
        }
    }

    /* renamed from: com.tinder.dialogs.b.4 */
    class C24664 implements OnClickListener {
        final /* synthetic */ int f4443a;
        final /* synthetic */ C2469b f4444b;

        C24664(C2469b c2469b, int i) {
            this.f4444b = c2469b;
            this.f4443a = i;
        }

        public void onClick(@NonNull View view) {
            C3095y.m9471a("onClick");
            if (!this.f4444b.f4463q) {
                this.f4444b.f4450d.removeView(view);
                this.f4444b.f4450d.addView(view);
                this.f4444b.f4463q = true;
                this.f4444b.m6866e();
                this.f4444b.f4462p.m5973b(this.f4443a);
            }
        }
    }

    /* renamed from: com.tinder.dialogs.b.5 */
    class C24675 implements AnimatorListener {
        final /* synthetic */ C2469b f4445a;

        C24675(C2469b c2469b) {
            this.f4445a = c2469b;
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            this.f4445a.dismiss();
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* renamed from: com.tinder.dialogs.b.6 */
    class C24686 implements Runnable {
        final /* synthetic */ C2469b f4446a;

        C24686(C2469b c2469b) {
            this.f4446a = c2469b;
        }

        public void run() {
            this.f4446a.dismiss();
        }
    }

    public C2469b(@NonNull Context context, String str, boolean z, boolean z2, int i, C2263f c2263f) {
        super(context, WebDialog.DEFAULT_THEME);
        this.f4451e = new ArrayList();
        this.f4448b = context;
        this.f4461o = str;
        this.f4462p = c2263f;
        this.f4459m = i;
        m6854a(z, z2);
    }

    private void m6854a(boolean z, boolean z2) {
        if (al.m9276a()) {
            setContentView(R.layout.dialog_color_picker_legacy);
            this.f4450d = (RelativeLayout) findViewById(R.id.view_color_picker_legacy);
        } else {
            setContentView(R.layout.dialog_color_picker);
            this.f4449c = (FrameLayout) findViewById(R.id.view_color_picker);
        }
        int a = al.m9262a(this.f4448b);
        int b = al.m9285b(this.f4448b);
        ImageView imageView = (ImageView) findViewById(R.id.color_picker_bg_image);
        this.f4460n = new BlurredDrawable(this.f4448b);
        C2281x c24631 = new C24631(this, imageView, a, b);
        if (al.m9276a()) {
            this.f4450d.setTag(c24631);
        } else {
            this.f4449c.setTag(c24631);
        }
        Picasso.m8982a(this.f4448b).m8990a(this.f4461o).m9129b(a, b).m9127b().m9126a(c24631);
        this.f4453g = al.m9285b(this.f4448b);
        this.f4452f = al.m9262a(this.f4448b);
        this.f4458l = this.f4448b.getResources().getDimensionPixelSize(R.dimen.moment_btn_tool_size);
        this.f4454h = this.f4448b.getResources().getDimensionPixelOffset(R.dimen.color_picker_vertical_margin);
        this.f4455i = this.f4448b.getResources().getDimensionPixelOffset(R.dimen.color_picker_side_margin);
        int[][] iArr;
        if (z) {
            iArr = new int[7][];
            iArr[0] = new int[]{m6850a((int) R.color.black), m6850a((int) R.color.color_picker_gray), m6850a((int) R.color.white)};
            iArr[1] = new int[]{m6850a((int) R.color.cp_red_one), m6850a((int) R.color.cp_red_two), m6850a((int) R.color.cp_red_three)};
            iArr[2] = new int[]{m6850a((int) R.color.cp_oj_one), m6850a((int) R.color.cp_oj_two), m6850a((int) R.color.cp_oj_three)};
            iArr[3] = new int[]{m6850a((int) R.color.cp_yellow_one), m6850a((int) R.color.cp_yellow_two), m6850a((int) R.color.cp_yellow_three)};
            iArr[4] = new int[]{m6850a((int) R.color.cp_green_one), m6850a((int) R.color.cp_green_two), m6850a((int) R.color.cp_green_three)};
            iArr[5] = new int[]{m6850a((int) R.color.cp_blue_one), m6850a((int) R.color.cp_blue_two), m6850a((int) R.color.cp_blue_three)};
            iArr[6] = new int[]{m6850a((int) R.color.cp_pink_one), m6850a((int) R.color.cp_pink_two), m6850a((int) R.color.cp_pink_three)};
            this.f4447a = iArr;
        } else {
            iArr = new int[6][];
            iArr[0] = new int[]{m6850a((int) R.color.cp_red_one), m6850a((int) R.color.cp_red_two), m6850a((int) R.color.cp_red_three)};
            iArr[1] = new int[]{m6850a((int) R.color.cp_oj_one), m6850a((int) R.color.cp_oj_two), m6850a((int) R.color.cp_oj_three)};
            iArr[2] = new int[]{m6850a((int) R.color.cp_yellow_one), m6850a((int) R.color.cp_yellow_two), m6850a((int) R.color.cp_yellow_three)};
            iArr[3] = new int[]{m6850a((int) R.color.cp_green_one), m6850a((int) R.color.cp_green_two), m6850a((int) R.color.cp_green_three)};
            iArr[4] = new int[]{m6850a((int) R.color.cp_blue_one), m6850a((int) R.color.cp_blue_two), m6850a((int) R.color.cp_blue_three)};
            iArr[5] = new int[]{m6850a((int) R.color.cp_pink_one), m6850a((int) R.color.cp_pink_two), m6850a((int) R.color.cp_pink_three)};
            this.f4447a = iArr;
        }
        if (z2) {
            this.f4456j = m6857b(0);
            this.f4457k = m6859c(2);
        } else {
            this.f4456j = m6857b(m6856b() - 1);
            this.f4457k = m6859c(0);
        }
        C3095y.m9471a("activity (" + this.f4452f + ", " + this.f4453g + ')');
        C3095y.m9471a("initial (" + this.f4456j + " , " + this.f4457k + ')');
        if (al.m9276a()) {
            m6863d();
        } else {
            m6861c();
        }
    }

    private int m6849a() {
        return this.f4447a.length;
    }

    private int m6856b() {
        return this.f4447a[0].length;
    }

    private int m6850a(int i) {
        return this.f4448b.getResources().getColor(i);
    }

    private int m6857b(int i) {
        int b = (this.f4452f - (this.f4455i * 2)) / m6856b();
        return ((b / 2) - (this.f4458l / 2)) + (this.f4455i + (i * b));
    }

    private int m6859c(int i) {
        int a = (this.f4453g - (this.f4454h * 2)) / m6849a();
        return ((a / 2) - (this.f4458l / 2)) + (this.f4454h + (i * a));
    }

    private void m6861c() {
        AnimatorSet animatorSet = new AnimatorSet();
        Collection arrayList = new ArrayList();
        for (int i = 0; i < m6856b(); i++) {
            for (int i2 = 0; i2 < m6849a(); i2++) {
                View d = m6862d(this.f4447a[i2][i]);
                this.f4449c.addView(d, new LayoutParams(this.f4458l, this.f4458l));
                this.f4451e.add(d);
                d.setX((float) this.f4456j);
                d.setY((float) this.f4457k);
                d.setOnClickListener(new C24642(this, this.f4447a[i2][i]));
                arrayList.add(m6852a(d, i, i2));
            }
        }
        animatorSet.playTogether(arrayList);
        animatorSet.setDuration(250);
        animatorSet.setInterpolator(new OvershootInterpolator(0.9f));
        this.f4449c.post(new C24653(this, animatorSet));
    }

    @NonNull
    private View m6862d(int i) {
        View imageView;
        if (i == this.f4459m) {
            imageView = new ImageView(this.f4448b);
            imageView.setBackgroundResource(R.drawable.rounded_white_bg);
            int dimensionPixelSize = this.f4448b.getResources().getDimensionPixelSize(R.dimen.padding_xsmall);
            imageView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            if (i == -1) {
                imageView.setImageResource(R.drawable.rounded_stroked_white_oval);
                return imageView;
            }
            Drawable drawable = this.f4448b.getResources().getDrawable(R.drawable.rounded_orange_bg);
            drawable.setColorFilter(i, Mode.SRC_ATOP);
            imageView.setImageDrawable(drawable);
            return imageView;
        }
        imageView = new View(this.f4448b);
        imageView.setBackgroundResource(R.drawable.circle);
        imageView.getBackground().setColorFilter(i, Mode.SRC_ATOP);
        return imageView;
    }

    private void m6863d() {
        for (int i = 0; i < m6856b(); i++) {
            for (int i2 = 0; i2 < m6849a(); i2++) {
                View d = m6862d(this.f4447a[i2][i]);
                ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f4458l, this.f4458l);
                this.f4450d.addView(d, layoutParams);
                d.setOnClickListener(new C24664(this, this.f4447a[i2][i]));
                int b = m6857b(i);
                int c = m6859c(i2);
                layoutParams.leftMargin = b;
                layoutParams.topMargin = c;
                this.f4451e.add(d);
            }
        }
    }

    @NonNull
    private ObjectAnimator m6852a(View view, int i, int i2) {
        int b = m6857b(i);
        int c = m6859c(i2);
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("x", new float[]{(float) this.f4456j, (float) b});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("y", new float[]{(float) this.f4457k, (float) c});
        return ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{ofFloat, ofFloat2});
    }

    private void m6866e() {
        AnimatorSet animatorSet = new AnimatorSet();
        Collection arrayList = new ArrayList();
        for (int i = 0; i < this.f4451e.size(); i++) {
            arrayList.add(m6851a((View) this.f4451e.get(i)));
        }
        animatorSet.playTogether(arrayList);
        animatorSet.setDuration(200);
        animatorSet.addListener(new C24675(this));
        animatorSet.start();
    }

    public void onBackPressed() {
        m6866e();
        this.f4462p.m5973b(0);
        this.f4449c.postDelayed(new C24686(this), 200);
    }

    private ObjectAnimator m6851a(@NonNull View view) {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("x", new float[]{view.getX(), (float) this.f4456j});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("y", new float[]{view.getY(), (float) this.f4457k});
        return ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{ofFloat, ofFloat2});
    }
}
