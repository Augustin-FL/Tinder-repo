package com.tinder.dialogs;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.internal.WebDialog;
import com.facebook.stetho.BuildConfig;
import com.google.android.gms.ads.AdRequest;
import com.tinder.R;
import com.tinder.p030d.C2321d;
import com.tinder.utils.C3095y;
import com.tinder.utils.al;
import java.util.List;

/* renamed from: com.tinder.dialogs.a */
public class C2453a extends aa {
    @NonNull
    private final Context f4356a;
    private final C2321d f4357b;
    private View f4358c;
    private TextView f4359d;
    private TextView f4360e;
    private ImageView f4361f;
    private View f4362g;
    private View f4363h;
    private View f4364i;
    private View f4365j;
    private View f4366k;

    /* renamed from: com.tinder.dialogs.a.1 */
    class C24441 implements OnClickListener {
        final /* synthetic */ C2453a f4344a;

        C24441(C2453a c2453a) {
            this.f4344a = c2453a;
        }

        public void onClick(View view) {
            this.f4344a.m6789a((int) R.string.flash_none);
            this.f4344a.f4357b.m6295a("off");
            this.f4344a.m6788a();
        }
    }

    /* renamed from: com.tinder.dialogs.a.2 */
    class C24452 implements OnClickListener {
        final /* synthetic */ C2453a f4345a;

        C24452(C2453a c2453a) {
            this.f4345a = c2453a;
        }

        public void onClick(View view) {
            this.f4345a.m6789a((int) R.string.flash_auto);
            this.f4345a.f4357b.m6295a("auto");
            this.f4345a.m6788a();
        }
    }

    /* renamed from: com.tinder.dialogs.a.3 */
    class C24463 implements OnClickListener {
        final /* synthetic */ C2453a f4346a;

        C24463(C2453a c2453a) {
            this.f4346a = c2453a;
        }

        public void onClick(View view) {
            this.f4346a.m6789a((int) R.string.flash_on);
            this.f4346a.f4357b.m6295a("on");
            this.f4346a.m6788a();
        }
    }

    /* renamed from: com.tinder.dialogs.a.4 */
    class C24474 implements OnClickListener {
        final /* synthetic */ C2453a f4347a;

        C24474(C2453a c2453a) {
            this.f4347a = c2453a;
        }

        public void onClick(View view) {
            this.f4347a.m6789a((int) R.string.camera_flash_mode);
            if (this.f4347a.f4358c.getVisibility() == 0) {
                this.f4347a.f4358c.setVisibility(4);
                this.f4347a.f4365j.setVisibility(4);
                return;
            }
            this.f4347a.f4358c.setVisibility(0);
            this.f4347a.f4365j.setVisibility(0);
        }
    }

    /* renamed from: com.tinder.dialogs.a.5 */
    class C24485 implements OnClickListener {
        final /* synthetic */ C2453a f4348a;

        C24485(C2453a c2453a) {
            this.f4348a = c2453a;
        }

        public void onClick(View view) {
            this.f4348a.m6792b((int) R.string.switch_camera);
            this.f4348a.f4357b.m6296e();
            this.f4348a.m6788a();
        }
    }

    /* renamed from: com.tinder.dialogs.a.6 */
    class C24496 implements Runnable {
        final /* synthetic */ int f4349a;
        final /* synthetic */ View f4350b;
        final /* synthetic */ int f4351c;
        final /* synthetic */ C2453a f4352d;

        C24496(C2453a c2453a, int i, View view, int i2) {
            this.f4352d = c2453a;
            this.f4349a = i;
            this.f4350b = view;
            this.f4351c = i2;
        }

        public void run() {
            LayoutParams attributes = this.f4352d.getWindow().getAttributes();
            attributes.gravity = 8388659;
            attributes.flags = AdRequest.MAX_CONTENT_URL_LENGTH;
            attributes.x = this.f4349a - ((int) (((double) this.f4350b.getWidth()) * 0.5d));
            attributes.y = this.f4351c - ((int) (((double) this.f4350b.getHeight()) * 0.8d));
            Point b = al.m9286b((Activity) this.f4352d.f4356a);
            if (attributes.x < 0) {
                attributes.x = 0;
            } else if (attributes.x + this.f4350b.getWidth() > b.x) {
                attributes.x = b.x - this.f4350b.getWidth();
            }
            attributes.width = this.f4350b.getWidth();
            attributes.height = this.f4350b.getHeight();
            this.f4352d.getWindow().setAttributes(attributes);
        }
    }

    /* renamed from: com.tinder.dialogs.a.7 */
    class C24507 implements Runnable {
        final /* synthetic */ C2453a f4353a;

        C24507(C2453a c2453a) {
            this.f4353a = c2453a;
        }

        public void run() {
            this.f4353a.f4359d.setText(BuildConfig.FLAVOR);
        }
    }

    /* renamed from: com.tinder.dialogs.a.8 */
    class C24518 implements Runnable {
        final /* synthetic */ C2453a f4354a;

        C24518(C2453a c2453a) {
            this.f4354a = c2453a;
        }

        public void run() {
            this.f4354a.f4360e.setText(BuildConfig.FLAVOR);
        }
    }

    /* renamed from: com.tinder.dialogs.a.9 */
    class C24529 implements Runnable {
        final /* synthetic */ C2453a f4355a;

        C24529(C2453a c2453a) {
            this.f4355a = c2453a;
        }

        public void run() {
            if (this.f4355a.isShowing()) {
                this.f4355a.dismiss();
            }
        }
    }

    public C2453a(@NonNull Context context, C2321d c2321d, boolean z, boolean z2, @NonNull List<String> list, String str, int i, int i2, int i3) {
        super(context, WebDialog.DEFAULT_THEME);
        C3095y.m9471a("x: " + i2 + " y: " + i3);
        this.f4356a = context;
        this.f4357b = c2321d;
        m6791a(list, str, i, z, z2, i2, i3);
    }

    private void m6791a(@NonNull List<String> list, String str, int i, boolean z, boolean z2, int i2, int i3) {
        setContentView(R.layout.popup_camera_options);
        View findViewById = findViewById(R.id.relative);
        this.f4365j = findViewById(R.id.view_flash_overlay);
        this.f4359d = (TextView) findViewById(R.id.txt_camera_option);
        this.f4360e = (TextView) findViewById(R.id.txt_camera_toggle_option);
        this.f4358c = findViewById(R.id.linear_flash);
        this.f4362g = findViewById(R.id.view_flash_none);
        this.f4363h = findViewById(R.id.view_flash_auto);
        this.f4364i = findViewById(R.id.view_flash_on);
        this.f4361f = (ImageView) findViewById(R.id.view_toggle_flash);
        if ("auto".equals(str)) {
            this.f4361f.setImageResource(R.drawable.selector_flash_auto);
        } else if ("on".equals(str)) {
            this.f4361f.setImageResource(R.drawable.selector_flash_on);
        } else {
            this.f4361f.setImageResource(R.drawable.selector_flash_off);
        }
        if (z) {
            this.f4362g.setOnClickListener(new C24441(this));
            this.f4363h.setOnClickListener(new C24452(this));
            this.f4364i.setOnClickListener(new C24463(this));
            this.f4361f.setOnClickListener(new C24474(this));
            if (!list.contains("auto")) {
                this.f4363h.setVisibility(4);
            }
            if (!list.contains("off")) {
                this.f4362g.setVisibility(4);
            }
            if (!list.contains("on")) {
                this.f4364i.setVisibility(4);
            }
        } else {
            this.f4361f.setVisibility(4);
        }
        this.f4366k = findViewById(R.id.view_toggle_camera);
        if (z2) {
            this.f4366k.setOnClickListener(new C24485(this));
        } else {
            this.f4366k.setVisibility(4);
        }
        this.f4366k.post(new C24496(this, i2, findViewById, i3));
    }

    private void m6789a(int i) {
        this.f4359d.setText(i);
        this.f4359d.postDelayed(new C24507(this), 300);
    }

    private void m6792b(int i) {
        this.f4360e.setText(i);
        this.f4360e.postDelayed(new C24518(this), 300);
    }

    private void m6788a() {
        this.f4366k.postDelayed(new C24529(this), 300);
    }

    public void m6800a(int i, int i2) {
        if (al.m9278a(this.f4366k, i, i2)) {
            this.f4366k.performClick();
        } else if (al.m9278a(this.f4362g, i, i2)) {
            this.f4362g.performClick();
        } else if (al.m9278a(this.f4363h, i, i2)) {
            this.f4363h.performClick();
        } else if (al.m9278a(this.f4364i, i, i2)) {
            this.f4364i.performClick();
        }
    }

    public void m6801b(int i, int i2) {
        this.f4366k.setPressed(false);
        this.f4361f.setPressed(false);
        this.f4364i.setPressed(false);
        this.f4363h.setPressed(false);
        this.f4362g.setPressed(false);
        this.f4359d.setText(BuildConfig.FLAVOR);
        this.f4360e.setText(BuildConfig.FLAVOR);
        if (al.m9278a(this.f4366k, i, i2)) {
            this.f4360e.setText(R.string.switch_camera);
            this.f4358c.setVisibility(4);
            this.f4365j.setVisibility(4);
            this.f4366k.setPressed(true);
        } else if (al.m9279a(this.f4361f, i, i2, 0, 0, 0, 10)) {
            this.f4359d.setText(R.string.camera_flash_mode);
            this.f4361f.setPressed(true);
            this.f4358c.setVisibility(0);
            this.f4365j.setVisibility(0);
        } else if (al.m9278a(this.f4364i, i, i2) && this.f4358c.getVisibility() == 0) {
            this.f4359d.setText(R.string.on);
            this.f4364i.setPressed(true);
        } else if (al.m9278a(this.f4363h, i, i2) && this.f4358c.getVisibility() == 0) {
            this.f4359d.setText(R.string.flash_auto);
            this.f4363h.setPressed(true);
        } else if (al.m9278a(this.f4362g, i, i2) && this.f4358c.getVisibility() == 0) {
            this.f4359d.setText(R.string.flash_none);
            this.f4362g.setPressed(true);
        } else if (!al.m9278a(this.f4358c, i, i2)) {
            this.f4358c.setVisibility(4);
            this.f4365j.setVisibility(4);
        }
    }
}
