package com.tinder.dialogs;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import com.facebook.internal.WebDialog;
import com.tinder.R;
import com.tinder.p030d.C2265k;
import com.tinder.utils.al;

public class ImageFiltersDialog extends aa {
    private ImageView f4340a;
    private ImageView f4341b;
    private ImageView f4342c;
    private ImageView f4343d;

    /* renamed from: com.tinder.dialogs.ImageFiltersDialog.1 */
    class C24401 implements Runnable {
        final /* synthetic */ View f4321a;
        final /* synthetic */ int f4322b;
        final /* synthetic */ int f4323c;
        final /* synthetic */ Bitmap f4324d;
        final /* synthetic */ Bitmap f4325e;
        final /* synthetic */ Bitmap f4326f;
        final /* synthetic */ Bitmap f4327g;
        final /* synthetic */ ImageFiltersDialog f4328h;

        C24401(ImageFiltersDialog imageFiltersDialog, View view, int i, int i2, Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4) {
            this.f4328h = imageFiltersDialog;
            this.f4321a = view;
            this.f4322b = i;
            this.f4323c = i2;
            this.f4324d = bitmap;
            this.f4325e = bitmap2;
            this.f4326f = bitmap3;
            this.f4327g = bitmap4;
        }

        public void run() {
            this.f4321a.animate().scaleX(1.2f).scaleY(1.2f).setInterpolator(new OvershootInterpolator()).start();
            this.f4328h.m6778a(this.f4328h.f4340a, this.f4322b, this.f4323c);
            this.f4328h.m6778a(this.f4328h.f4341b, this.f4322b, this.f4323c);
            this.f4328h.m6778a(this.f4328h.f4342c, this.f4322b, this.f4323c);
            this.f4328h.m6778a(this.f4328h.f4343d, this.f4322b, this.f4323c);
            this.f4328h.f4340a.setImageBitmap(this.f4324d);
            this.f4328h.f4341b.setImageBitmap(this.f4325e);
            this.f4328h.f4342c.setImageBitmap(this.f4326f);
            this.f4328h.f4343d.setImageBitmap(this.f4327g);
        }
    }

    /* renamed from: com.tinder.dialogs.ImageFiltersDialog.2 */
    class C24422 implements OnClickListener {
        final /* synthetic */ View f4330a;
        final /* synthetic */ ImageFiltersDialog f4331b;

        /* renamed from: com.tinder.dialogs.ImageFiltersDialog.2.1 */
        class C24411 extends AnimatorListenerAdapter {
            final /* synthetic */ C24422 f4329a;

            C24411(C24422 c24422) {
                this.f4329a = c24422;
            }

            public void onAnimationEnd(Animator animator) {
                this.f4329a.f4331b.dismiss();
            }
        }

        C24422(ImageFiltersDialog imageFiltersDialog, View view) {
            this.f4331b = imageFiltersDialog;
            this.f4330a = view;
        }

        public void onClick(View view) {
            this.f4330a.animate().scaleX(1.0f).scaleY(1.0f).setInterpolator(new OvershootInterpolator()).setListener(new C24411(this)).start();
        }
    }

    /* renamed from: com.tinder.dialogs.ImageFiltersDialog.3 */
    class C24433 implements OnClickListener {
        final /* synthetic */ C2265k f4332a;
        final /* synthetic */ FilterType f4333b;
        final /* synthetic */ ImageFiltersDialog f4334c;

        C24433(ImageFiltersDialog imageFiltersDialog, C2265k c2265k, FilterType filterType) {
            this.f4334c = imageFiltersDialog;
            this.f4332a = c2265k;
            this.f4333b = filterType;
        }

        public void onClick(View view) {
            this.f4334c.dismiss();
            this.f4332a.m5977a(this.f4333b);
        }
    }

    public enum FilterType {
        ORIGINAL,
        COAL,
        CHILL,
        GLOW
    }

    public ImageFiltersDialog(@NonNull Context context, Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, @NonNull C2265k c2265k) {
        super(context, WebDialog.DEFAULT_THEME);
        setContentView(R.layout.dialog_image_filters);
        View findViewById = findViewById(R.id.btn_add_filter);
        this.f4340a = (ImageView) findViewById(R.id.img_filter_original);
        this.f4341b = (ImageView) findViewById(R.id.img_filter_coal);
        this.f4342c = (ImageView) findViewById(R.id.img_filter_chill);
        this.f4343d = (ImageView) findViewById(R.id.img_filter_glow);
        Point b = al.m9286b((Activity) context);
        this.f4340a.post(new C24401(this, findViewById, (b.x - (context.getResources().getDimensionPixelOffset(R.dimen.margin_med) * 4)) / 2, ((b.y - (context.getResources().getDimensionPixelSize(R.dimen.actionbar_size) * 2)) - context.getResources().getDimensionPixelOffset(R.dimen.padding_med)) / 2, bitmap, bitmap4, bitmap3, bitmap2));
        findViewById.setOnClickListener(new C24422(this, findViewById));
        this.f4340a.setOnClickListener(m6776a(c2265k, FilterType.ORIGINAL));
        this.f4342c.setOnClickListener(m6776a(c2265k, FilterType.CHILL));
        this.f4341b.setOnClickListener(m6776a(c2265k, FilterType.COAL));
        this.f4343d.setOnClickListener(m6776a(c2265k, FilterType.GLOW));
    }

    public void m6783a(Bitmap bitmap) {
        this.f4340a.setImageBitmap(bitmap);
    }

    public void m6784b(Bitmap bitmap) {
        this.f4342c.setImageBitmap(bitmap);
    }

    public void m6785c(Bitmap bitmap) {
        this.f4341b.setImageBitmap(bitmap);
    }

    public void m6786d(Bitmap bitmap) {
        this.f4343d.setImageBitmap(bitmap);
    }

    @NonNull
    private OnClickListener m6776a(@NonNull C2265k c2265k, FilterType filterType) {
        return new C24433(this, c2265k, filterType);
    }

    private void m6778a(@NonNull View view, int i, int i2) {
        LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        view.setLayoutParams(layoutParams);
    }
}
