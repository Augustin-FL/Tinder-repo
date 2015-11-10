package com.tinder.activities;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.facebook.stetho.BuildConfig;
import com.google.android.gms.location.places.Place;
import com.tinder.R;
import com.tinder.adapters.C2345i;
import com.tinder.base.ActivitySignedInBase;
import com.tinder.dialogs.C2469b;
import com.tinder.dialogs.C2472h;
import com.tinder.dialogs.ImageFiltersDialog;
import com.tinder.dialogs.ImageFiltersDialog.FilterType;
import com.tinder.drawing.C2553d;
import com.tinder.drawing.DrawingSurface;
import com.tinder.enums.MomentAction;
import com.tinder.managers.C2807a;
import com.tinder.managers.ManagerApp;
import com.tinder.model.Moment;
import com.tinder.model.Person;
import com.tinder.model.SparksEvent;
import com.tinder.model.User;
import com.tinder.p030d.C2263f;
import com.tinder.p030d.C2264j;
import com.tinder.p030d.C2265k;
import com.tinder.p030d.an;
import com.tinder.p030d.bh;
import com.tinder.utils.C3070i;
import com.tinder.utils.C3075l;
import com.tinder.utils.C3077n;
import com.tinder.utils.C3095y;
import com.tinder.utils.C3096z;
import com.tinder.utils.aa;
import com.tinder.utils.aa.C2266a;
import com.tinder.utils.ab;
import com.tinder.utils.ab.C2267a;
import com.tinder.utils.al;
import com.tinder.views.DraggableEditText;
import com.tinder.views.PermissiveEditText;
import com.viewpagerindicator.C3169d.C3168f;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class ActivityEditMoment extends ActivitySignedInBase implements OnPageChangeListener, OnClickListener, OnLongClickListener, OnGlobalLayoutListener, OnEditorActionListener, C2263f, C2264j, C2265k, C2266a, C2267a {
    private static final float f3810b;
    private static final float f3811c;
    private static final int f3812e;
    private static final int f3813f;
    private DraggableEditText f3814A;
    private PermissiveEditText f3815B;
    private Drawable f3816C;
    private AnimatorSet f3817D;
    private AnimatorSet f3818E;
    private AnimatorSet f3819F;
    private AnimatorSet f3820G;
    private AnimatorListener f3821H;
    private Interpolator f3822I;
    private Interpolator f3823J;
    private Interpolator f3824K;
    private Interpolator f3825L;
    private C3096z f3826M;
    private ab f3827N;
    private aa f3828O;
    private C2553d f3829P;
    @Nullable
    private String f3830Q;
    @Nullable
    private Uri f3831R;
    private boolean f3832S;
    private int f3833T;
    private int f3834U;
    private GestureDetector f3835V;
    private RectF f3836W;
    private float f3837X;
    private boolean f3838Y;
    private int f3839Z;
    boolean f3840a;
    private int aa;
    @NonNull
    private String ab;
    private boolean ac;
    @Nullable
    private C2261a ad;
    @Nullable
    private C2262b ae;
    @Nullable
    private Bitmap af;
    @Nullable
    private Bitmap ag;
    @Nullable
    private Bitmap ah;
    @Nullable
    private Bitmap ai;
    private ImageFiltersDialog aj;
    private C2469b ak;
    private C2345i al;
    private boolean am;
    private boolean an;
    private C2472h ao;
    private Uri ap;
    private ColorPickerType f3841g;
    @NonNull
    private TextSizeMode f3842h;
    private ViewPager f3843i;
    private View f3844j;
    private ImageView f3845k;
    private LinearLayout f3846l;
    private RelativeLayout f3847m;
    private RelativeLayout f3848n;
    private RelativeLayout f3849o;
    private DrawingSurface f3850p;
    private ImageButton f3851q;
    private ImageButton f3852r;
    private ImageButton f3853s;
    private ImageButton f3854t;
    private ImageButton f3855u;
    private ImageButton f3856v;
    private ImageButton f3857w;
    private ImageButton f3858x;
    private ImageButton f3859y;
    private ImageButton f3860z;

    /* renamed from: com.tinder.activities.ActivityEditMoment.13 */
    static /* synthetic */ class AnonymousClass13 {
        static final /* synthetic */ int[] f3764a;
        static final /* synthetic */ int[] f3765b;

        static {
            f3765b = new int[FilterType.values().length];
            try {
                f3765b[FilterType.ORIGINAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3765b[FilterType.GLOW.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f3765b[FilterType.CHILL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f3765b[FilterType.COAL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            f3764a = new int[ColorPickerType.values().length];
            try {
                f3764a[ColorPickerType.PEN.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f3764a[ColorPickerType.TEXT.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    /* renamed from: com.tinder.activities.ActivityEditMoment.1 */
    class C22521 implements OnTouchListener {
        final /* synthetic */ GestureDetector f3772a;
        final /* synthetic */ ActivityEditMoment f3773b;

        C22521(ActivityEditMoment activityEditMoment, GestureDetector gestureDetector) {
            this.f3773b = activityEditMoment;
            this.f3772a = gestureDetector;
        }

        public boolean onTouch(View view, @NonNull MotionEvent motionEvent) {
            this.f3772a.onTouchEvent(motionEvent);
            return false;
        }
    }

    /* renamed from: com.tinder.activities.ActivityEditMoment.2 */
    class C22532 implements OnCancelListener {
        final /* synthetic */ ActivityEditMoment f3775a;

        C22532(ActivityEditMoment activityEditMoment) {
            this.f3775a = activityEditMoment;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f3775a.f3858x.setVisibility(0);
            this.f3775a.f3857w.setVisibility(0);
            this.f3775a.f3855u.setVisibility(0);
        }
    }

    /* renamed from: com.tinder.activities.ActivityEditMoment.3 */
    class C22543 implements OnCancelListener {
        final /* synthetic */ ActivityEditMoment f3776a;

        C22543(ActivityEditMoment activityEditMoment) {
            this.f3776a = activityEditMoment;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f3776a.f3854t.setVisibility(0);
            this.f3776a.f3847m.setVisibility(0);
        }
    }

    /* renamed from: com.tinder.activities.ActivityEditMoment.4 */
    class C22554 implements Runnable {
        final /* synthetic */ ActivityEditMoment f3777a;

        C22554(ActivityEditMoment activityEditMoment) {
            this.f3777a = activityEditMoment;
        }

        public void run() {
            this.f3777a.f3857w.setVisibility(0);
            this.f3777a.f3858x.setVisibility(0);
            this.f3777a.f3855u.setVisibility(0);
        }
    }

    /* renamed from: com.tinder.activities.ActivityEditMoment.5 */
    class C22565 implements Runnable {
        final /* synthetic */ ActivityEditMoment f3778a;

        C22565(ActivityEditMoment activityEditMoment) {
            this.f3778a = activityEditMoment;
        }

        public void run() {
            if (al.m9276a()) {
                al.m9267a(this.f3778a, this.f3778a.f3815B);
            } else {
                al.m9267a(this.f3778a, this.f3778a.f3814A);
            }
        }
    }

    /* renamed from: com.tinder.activities.ActivityEditMoment.6 */
    class C22576 implements Runnable {
        final /* synthetic */ ActivityEditMoment f3779a;

        C22576(ActivityEditMoment activityEditMoment) {
            this.f3779a = activityEditMoment;
        }

        public void run() {
            this.f3779a.f3854t.setVisibility(0);
            this.f3779a.f3847m.setVisibility(0);
        }
    }

    /* renamed from: com.tinder.activities.ActivityEditMoment.7 */
    class C22587 implements an {
        final /* synthetic */ Moment f3780a;
        final /* synthetic */ ActivityEditMoment f3781b;

        C22587(ActivityEditMoment activityEditMoment, Moment moment) {
            this.f3781b = activityEditMoment;
            this.f3780a = moment;
        }

        public void m5966a(String str) {
            C3095y.m9469a();
            this.f3780a.clearBitmap();
            this.f3780a.setIsPending(false);
            this.f3781b.m6047w();
            C2807a.m8056a(this.f3781b.m5992a("Moments.Publish", str));
        }

        public void m5965a() {
            C3095y.m9469a();
            this.f3780a.clearBitmap();
            this.f3781b.m6047w();
            Toast.makeText(this.f3781b, R.string.error_moment_send, 1).show();
        }
    }

    /* renamed from: com.tinder.activities.ActivityEditMoment.8 */
    class C22598 implements bh {
        final /* synthetic */ Context f3782a;
        final /* synthetic */ ActivityEditMoment f3783b;

        C22598(ActivityEditMoment activityEditMoment, Context context) {
            this.f3783b = activityEditMoment;
            this.f3782a = context;
        }

        public void m5969a() {
            Toast.makeText(this.f3782a, R.string.moment_bitmap_saved, 0).show();
        }

        public void m5970b() {
            Toast.makeText(this.f3782a, R.string.moment_bitmap_not_saved, 0).show();
        }
    }

    /* renamed from: com.tinder.activities.ActivityEditMoment.9 */
    class C22609 implements AnimatorListener {
        final /* synthetic */ ActivityEditMoment f3784a;

        C22609(ActivityEditMoment activityEditMoment) {
            this.f3784a = activityEditMoment;
        }

        public void onAnimationStart(Animator animator) {
            this.f3784a.f3860z.setClickable(false);
            this.f3784a.f3860z.getDrawable().setColorFilter(this.f3784a.getResources().getColor(R.color.btn_like_green), Mode.SRC_ATOP);
        }

        public void onAnimationEnd(Animator animator) {
            this.f3784a.f3860z.setClickable(true);
            this.f3784a.f3860z.getDrawable().setColorFilter(null);
            this.f3784a.f3845k.setVisibility(8);
            this.f3784a.f3844j.setVisibility(8);
            this.f3784a.f3844j.animate().alpha(0.0f).start();
            this.f3784a.m6051y();
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    private enum ColorPickerType {
        PEN,
        TEXT
    }

    private enum TextSizeMode {
        SMALL,
        LARGE
    }

    /* renamed from: com.tinder.activities.ActivityEditMoment.a */
    class C2261a extends AsyncTask<Void, Object, Void> {
        String f3791a;
        Options f3792b;
        @Nullable
        Bitmap f3793c;
        @Nullable
        Bitmap f3794d;
        @Nullable
        Bitmap f3795e;
        @Nullable
        Bitmap f3796f;
        boolean f3797g;
        boolean f3798h;
        final /* synthetic */ ActivityEditMoment f3799i;
        private Uri f3800j;

        @Nullable
        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m5971a((Void[]) objArr);
        }

        public C2261a(ActivityEditMoment activityEditMoment, String str, Options options, boolean z) {
            this.f3799i = activityEditMoment;
            this.f3791a = str;
            this.f3792b = options;
            this.f3798h = z;
            this.f3797g = z;
            C3095y.m9471a("fromGallery? " + z);
        }

        public C2261a(ActivityEditMoment activityEditMoment, Uri uri, Options options, boolean z) {
            this.f3799i = activityEditMoment;
            this.f3800j = uri;
            this.f3792b = options;
            this.f3798h = z;
            this.f3797g = z;
            C3095y.m9471a("fromGallery? " + z);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        @android.support.annotation.Nullable
        protected java.lang.Void m5971a(java.lang.Void... r6) {
            /*
            r5 = this;
            r4 = 1;
            r3 = 0;
            r0 = r5.f3799i;
            r0 = r0.f3830Q;
            if (r0 == 0) goto L_0x00dd;
        L_0x000a:
            r0 = r5.f3799i;
            r0 = r0.f3830Q;
            r1 = "http";
            r0 = r0.contains(r1);
            if (r0 != 0) goto L_0x0034;
        L_0x0018:
            r0 = r5.f3799i;
            r0 = r0.f3830Q;
            r1 = "content://com.google.android.gallery3d";
            r0 = r0.contains(r1);
            if (r0 != 0) goto L_0x0034;
        L_0x0026:
            r0 = r5.f3799i;
            r0 = r0.f3830Q;
            r1 = "picasa/item";
            r0 = r0.contains(r1);
            if (r0 == 0) goto L_0x00dd;
        L_0x0034:
            r0 = "Applying filters in background";
            com.tinder.utils.C3095y.m9471a(r0);
            r0 = r5.f3799i;	 Catch:{ Exception -> 0x00d4 }
            r0 = r0.f3830Q;	 Catch:{ Exception -> 0x00d4 }
            r1 = "picasa/item";
            r0 = r0.contains(r1);	 Catch:{ Exception -> 0x00d4 }
            if (r0 == 0) goto L_0x00c5;
        L_0x0047:
            r0 = r5.f3799i;	 Catch:{ Exception -> 0x00d4 }
            r1 = r5.f3799i;	 Catch:{ Exception -> 0x00d4 }
            r1 = r1.f3831R;	 Catch:{ Exception -> 0x00d4 }
            r2 = r5.f3792b;	 Catch:{ Exception -> 0x00d4 }
            r0 = com.tinder.utils.C3066f.m9345a(r0, r1, r2);	 Catch:{ Exception -> 0x00d4 }
            r5.f3793c = r0;	 Catch:{ Exception -> 0x00d4 }
        L_0x0057:
            r0 = r5.f3793c;	 Catch:{ Exception -> 0x00d4 }
            r0 = com.tinder.utils.C3066f.m9346a(r0);	 Catch:{ Exception -> 0x00d4 }
            r5.f3793c = r0;	 Catch:{ Exception -> 0x00d4 }
            r0 = r5.f3793c;	 Catch:{ Exception -> 0x00d4 }
            r1 = r5.f3799i;	 Catch:{ Exception -> 0x00d4 }
            r1 = r1.getResources();	 Catch:{ Exception -> 0x00d4 }
            r1 = r1.getDisplayMetrics();	 Catch:{ Exception -> 0x00d4 }
            r1 = r1.widthPixels;	 Catch:{ Exception -> 0x00d4 }
            r2 = r5.f3799i;	 Catch:{ Exception -> 0x00d4 }
            r2 = r2.getResources();	 Catch:{ Exception -> 0x00d4 }
            r2 = r2.getDisplayMetrics();	 Catch:{ Exception -> 0x00d4 }
            r2 = r2.heightPixels;	 Catch:{ Exception -> 0x00d4 }
            r0 = android.media.ThumbnailUtils.extractThumbnail(r0, r1, r2);	 Catch:{ Exception -> 0x00d4 }
            r5.f3793c = r0;	 Catch:{ Exception -> 0x00d4 }
            r0 = 1;
            r0 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x00d4 }
            r1 = 0;
            r2 = r5.f3793c;	 Catch:{ Exception -> 0x00d4 }
            r0[r1] = r2;	 Catch:{ Exception -> 0x00d4 }
            r5.publishProgress(r0);	 Catch:{ Exception -> 0x00d4 }
            r0 = r5.f3793c;	 Catch:{ Exception -> 0x00d4 }
            r0 = com.tinder.utils.ImageFilters.m9194a(r0);	 Catch:{ Exception -> 0x00d4 }
            r5.f3794d = r0;	 Catch:{ Exception -> 0x00d4 }
            r0 = 1;
            r0 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x00d4 }
            r1 = 0;
            r2 = r5.f3794d;	 Catch:{ Exception -> 0x00d4 }
            r0[r1] = r2;	 Catch:{ Exception -> 0x00d4 }
            r5.publishProgress(r0);	 Catch:{ Exception -> 0x00d4 }
            r0 = r5.f3793c;	 Catch:{ Exception -> 0x00d4 }
            r0 = com.tinder.utils.ImageFilters.m9198c(r0);	 Catch:{ Exception -> 0x00d4 }
            r5.f3796f = r0;	 Catch:{ Exception -> 0x00d4 }
            r0 = 1;
            r0 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x00d4 }
            r1 = 0;
            r2 = r5.f3796f;	 Catch:{ Exception -> 0x00d4 }
            r0[r1] = r2;	 Catch:{ Exception -> 0x00d4 }
            r5.publishProgress(r0);	 Catch:{ Exception -> 0x00d4 }
            r0 = r5.f3793c;	 Catch:{ Exception -> 0x00d4 }
            r0 = com.tinder.utils.ImageFilters.m9197b(r0);	 Catch:{ Exception -> 0x00d4 }
            r5.f3795e = r0;	 Catch:{ Exception -> 0x00d4 }
            r0 = 1;
            r0 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x00d4 }
            r1 = 0;
            r2 = r5.f3795e;	 Catch:{ Exception -> 0x00d4 }
            r0[r1] = r2;	 Catch:{ Exception -> 0x00d4 }
            r5.publishProgress(r0);	 Catch:{ Exception -> 0x00d4 }
        L_0x00c3:
            r0 = 0;
            return r0;
        L_0x00c5:
            r0 = r5.f3799i;	 Catch:{ Exception -> 0x00d4 }
            r0 = r0.f3830Q;	 Catch:{ Exception -> 0x00d4 }
            r1 = r5.f3792b;	 Catch:{ Exception -> 0x00d4 }
            r0 = com.tinder.utils.C3066f.m9349a(r0, r1);	 Catch:{ Exception -> 0x00d4 }
            r5.f3793c = r0;	 Catch:{ Exception -> 0x00d4 }
            goto L_0x0057;
        L_0x00d4:
            r0 = move-exception;
            r0 = r0.getMessage();
            com.tinder.utils.C3095y.m9479c(r0);
            goto L_0x00c3;
        L_0x00dd:
            r0 = r5.f3798h;
            if (r0 == 0) goto L_0x01b2;
        L_0x00e1:
            r0 = "Image from gallery";
            com.tinder.utils.C3095y.m9471a(r0);
            r0 = r5.f3800j;
            if (r0 == 0) goto L_0x016d;
        L_0x00ea:
            r0 = r5.f3799i;
            r0 = r0.getApplicationContext();
            r1 = r5.f3800j;
            r2 = r5.f3792b;
            r0 = com.tinder.utils.C3066f.m9345a(r0, r1, r2);
            r0 = com.tinder.utils.C3066f.m9346a(r0);
            r5.f3793c = r0;
        L_0x00fe:
            r0 = new android.media.ExifInterface;	 Catch:{ Exception -> 0x0187 }
            r1 = r5.f3791a;	 Catch:{ Exception -> 0x0187 }
            r0.<init>(r1);	 Catch:{ Exception -> 0x0187 }
            r1 = "Orientation";
            r2 = -1;
            r0 = r0.getAttributeInt(r1, r2);	 Catch:{ Exception -> 0x0187 }
            switch(r0) {
                case 1: goto L_0x010f;
                case 2: goto L_0x010f;
                case 3: goto L_0x0190;
                case 4: goto L_0x010f;
                case 5: goto L_0x010f;
                case 6: goto L_0x017c;
                case 7: goto L_0x010f;
                case 8: goto L_0x019c;
                default: goto L_0x010f;
            };
        L_0x010f:
            r0 = r5.f3793c;	 Catch:{ OutOfMemoryError -> 0x01a8 }
            r1 = r5.f3799i;	 Catch:{ OutOfMemoryError -> 0x01a8 }
            r1 = r1.getResources();	 Catch:{ OutOfMemoryError -> 0x01a8 }
            r1 = r1.getDisplayMetrics();	 Catch:{ OutOfMemoryError -> 0x01a8 }
            r1 = r1.widthPixels;	 Catch:{ OutOfMemoryError -> 0x01a8 }
            r2 = r5.f3799i;	 Catch:{ OutOfMemoryError -> 0x01a8 }
            r2 = r2.getResources();	 Catch:{ OutOfMemoryError -> 0x01a8 }
            r2 = r2.getDisplayMetrics();	 Catch:{ OutOfMemoryError -> 0x01a8 }
            r2 = r2.heightPixels;	 Catch:{ OutOfMemoryError -> 0x01a8 }
            r0 = android.media.ThumbnailUtils.extractThumbnail(r0, r1, r2);	 Catch:{ OutOfMemoryError -> 0x01a8 }
            r5.f3793c = r0;	 Catch:{ OutOfMemoryError -> 0x01a8 }
        L_0x012f:
            r0 = new java.lang.Object[r4];
            r1 = r5.f3793c;
            r0[r3] = r1;
            r5.publishProgress(r0);
            r0 = r5.f3793c;
            r0 = com.tinder.utils.ImageFilters.m9194a(r0);
            r5.f3794d = r0;
            r0 = new java.lang.Object[r4];
            r1 = r5.f3794d;
            r0[r3] = r1;
            r5.publishProgress(r0);
            r0 = r5.f3793c;
            r0 = com.tinder.utils.ImageFilters.m9198c(r0);
            r5.f3796f = r0;
            r0 = new java.lang.Object[r4];
            r1 = r5.f3796f;
            r0[r3] = r1;
            r5.publishProgress(r0);
            r0 = r5.f3793c;
            r0 = com.tinder.utils.ImageFilters.m9197b(r0);
            r5.f3795e = r0;
            r0 = new java.lang.Object[r4];
            r1 = r5.f3795e;
            r0[r3] = r1;
            r5.publishProgress(r0);
            goto L_0x00c3;
        L_0x016d:
            r0 = r5.f3791a;
            r1 = r5.f3792b;
            r0 = android.graphics.BitmapFactory.decodeFile(r0, r1);
            r0 = com.tinder.utils.C3066f.m9346a(r0);
            r5.f3793c = r0;
            goto L_0x00fe;
        L_0x017c:
            r0 = r5.f3793c;	 Catch:{ Exception -> 0x0187 }
            r1 = 1119092736; // 0x42b40000 float:90.0 double:5.529052754E-315;
            r0 = com.tinder.activities.ActivityEditMoment.m5989a(r0, r1);	 Catch:{ Exception -> 0x0187 }
            r5.f3793c = r0;	 Catch:{ Exception -> 0x0187 }
            goto L_0x010f;
        L_0x0187:
            r0 = move-exception;
            r0 = r0.getMessage();
            com.tinder.utils.C3095y.m9479c(r0);
            goto L_0x010f;
        L_0x0190:
            r0 = r5.f3793c;	 Catch:{ Exception -> 0x0187 }
            r1 = 1127481344; // 0x43340000 float:180.0 double:5.570497984E-315;
            r0 = com.tinder.activities.ActivityEditMoment.m5989a(r0, r1);	 Catch:{ Exception -> 0x0187 }
            r5.f3793c = r0;	 Catch:{ Exception -> 0x0187 }
            goto L_0x010f;
        L_0x019c:
            r0 = r5.f3793c;	 Catch:{ Exception -> 0x0187 }
            r1 = 1132920832; // 0x43870000 float:270.0 double:5.597372625E-315;
            r0 = com.tinder.activities.ActivityEditMoment.m5989a(r0, r1);	 Catch:{ Exception -> 0x0187 }
            r5.f3793c = r0;	 Catch:{ Exception -> 0x0187 }
            goto L_0x010f;
        L_0x01a8:
            r0 = move-exception;
            r0 = r0.getMessage();
            com.tinder.utils.C3095y.m9471a(r0);
            goto L_0x012f;
        L_0x01b2:
            r0 = "Image from capture";
            com.tinder.utils.C3095y.m9471a(r0);
            r0 = r5.f3791a;
            r1 = r5.f3792b;
            r0 = android.graphics.BitmapFactory.decodeFile(r0, r1);
            r5.f3793c = r0;
            goto L_0x012f;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tinder.activities.ActivityEditMoment.a.a(java.lang.Void[]):java.lang.Void");
        }

        public void onProgressUpdate(@NonNull Object... objArr) {
            for (Bitmap bitmap : objArr) {
                if (bitmap == this.f3793c) {
                    C3095y.m9471a("Original");
                    this.f3799i.af = this.f3793c;
                    this.f3799i.al.m6390a(this.f3799i.af);
                    if (this.f3799i.aj != null && this.f3799i.aj.isShowing()) {
                        this.f3799i.aj.m6783a(this.f3799i.af);
                    }
                } else if (bitmap == this.f3796f) {
                    C3095y.m9471a("coal");
                    this.f3799i.ai = this.f3796f;
                    this.f3799i.al.m6393d(this.f3799i.ai);
                    if (this.f3799i.aj != null && this.f3799i.aj.isShowing()) {
                        this.f3799i.aj.m6785c(this.f3799i.ai);
                    }
                } else if (bitmap == this.f3794d) {
                    C3095y.m9471a("chill");
                    this.f3799i.ah = this.f3794d;
                    this.f3799i.al.m6392c(this.f3799i.ah);
                    if (this.f3799i.aj != null && this.f3799i.aj.isShowing()) {
                        this.f3799i.aj.m6784b(this.f3799i.ah);
                    }
                } else if (bitmap == this.f3795e) {
                    C3095y.m9471a("glow");
                    this.f3799i.ag = this.f3795e;
                    this.f3799i.al.m6391b(this.f3799i.ag);
                    if (this.f3799i.aj != null && this.f3799i.aj.isShowing()) {
                        this.f3799i.aj.m6786d(this.f3799i.ag);
                    }
                }
                this.f3799i.al.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: com.tinder.activities.ActivityEditMoment.b */
    class C2262b extends AsyncTask<Void, Object, Void> {
        String f3801a;
        Options f3802b;
        @Nullable
        Bitmap f3803c;
        @Nullable
        Bitmap f3804d;
        @Nullable
        Bitmap f3805e;
        @Nullable
        Bitmap f3806f;
        boolean f3807g;
        Uri f3808h;
        final /* synthetic */ ActivityEditMoment f3809i;

        @Nullable
        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m5972a((Void[]) objArr);
        }

        public C2262b(ActivityEditMoment activityEditMoment, String str, Options options, boolean z) {
            this.f3809i = activityEditMoment;
            this.f3801a = str;
            this.f3802b = options;
            this.f3807g = z;
        }

        public C2262b(ActivityEditMoment activityEditMoment, Uri uri, Options options, boolean z) {
            this.f3809i = activityEditMoment;
            this.f3808h = uri;
            this.f3802b = options;
            this.f3807g = z;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        @android.support.annotation.Nullable
        protected java.lang.Void m5972a(java.lang.Void... r8) {
            /*
            r7 = this;
            r6 = 1;
            r5 = 0;
            r0 = r7.f3809i;
            r0 = r0.f3830Q;
            if (r0 == 0) goto L_0x0075;
        L_0x000a:
            r0 = r7.f3809i;
            r0 = r0.f3830Q;
            r1 = "http";
            r0 = r0.contains(r1);
            if (r0 != 0) goto L_0x0026;
        L_0x0018:
            r0 = r7.f3809i;
            r0 = r0.f3830Q;
            r1 = "content://com.google.android";
            r0 = r0.contains(r1);
            if (r0 == 0) goto L_0x0075;
        L_0x0026:
            r0 = r7.f3809i;	 Catch:{ Exception -> 0x006c }
            r0 = r0.getResources();	 Catch:{ Exception -> 0x006c }
            r0 = r0.getDisplayMetrics();	 Catch:{ Exception -> 0x006c }
            r0 = r0.widthPixels;	 Catch:{ Exception -> 0x006c }
            r0 = r0 / 2;
            r1 = r7.f3809i;	 Catch:{ Exception -> 0x006c }
            r1 = r1.getResources();	 Catch:{ Exception -> 0x006c }
            r1 = r1.getDisplayMetrics();	 Catch:{ Exception -> 0x006c }
            r1 = r1.heightPixels;	 Catch:{ Exception -> 0x006c }
            r1 = r1 / 2;
            r2 = r7.f3809i;	 Catch:{ Exception -> 0x006c }
            r2 = r2.f3830Q;	 Catch:{ Exception -> 0x006c }
            r2 = com.tinder.utils.C3066f.m9352b(r2, r0, r1);	 Catch:{ Exception -> 0x006c }
            r7.f3803c = r2;	 Catch:{ Exception -> 0x006c }
            r2 = r7.f3803c;	 Catch:{ OutOfMemoryError -> 0x0063 }
            r0 = android.media.ThumbnailUtils.extractThumbnail(r2, r0, r1);	 Catch:{ OutOfMemoryError -> 0x0063 }
            r7.f3803c = r0;	 Catch:{ OutOfMemoryError -> 0x0063 }
        L_0x0056:
            r0 = 1;
            r0 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x006c }
            r1 = 0;
            r2 = r7.f3803c;	 Catch:{ Exception -> 0x006c }
            r0[r1] = r2;	 Catch:{ Exception -> 0x006c }
            r7.publishProgress(r0);	 Catch:{ Exception -> 0x006c }
        L_0x0061:
            r0 = 0;
            return r0;
        L_0x0063:
            r0 = move-exception;
            r0 = r0.getMessage();	 Catch:{ Exception -> 0x006c }
            com.tinder.utils.C3095y.m9471a(r0);	 Catch:{ Exception -> 0x006c }
            goto L_0x0056;
        L_0x006c:
            r0 = move-exception;
            r0 = r0.getMessage();
            com.tinder.utils.C3095y.m9479c(r0);
            goto L_0x0061;
        L_0x0075:
            r0 = r7.f3809i;
            r0 = r0.getResources();
            r0 = r0.getDisplayMetrics();
            r0 = r0.widthPixels;
            r1 = r0 / 2;
            r0 = r7.f3809i;
            r0 = r0.getResources();
            r0 = r0.getDisplayMetrics();
            r0 = r0.heightPixels;
            r2 = r0 / 2;
            r0 = r7.f3808h;
            if (r0 == 0) goto L_0x00c8;
        L_0x0095:
            r0 = r7.f3809i;
            r0 = r0.getApplicationContext();
            r3 = r7.f3808h;
            r4 = r7.f3802b;
            r0 = com.tinder.utils.C3066f.m9345a(r0, r3, r4);
            r7.f3803c = r0;
        L_0x00a5:
            r0 = new android.media.ExifInterface;	 Catch:{ Exception -> 0x00dc }
            r3 = r7.f3801a;	 Catch:{ Exception -> 0x00dc }
            r0.<init>(r3);	 Catch:{ Exception -> 0x00dc }
            r3 = "Orientation";
            r4 = -1;
            r0 = r0.getAttributeInt(r3, r4);	 Catch:{ Exception -> 0x00dc }
            switch(r0) {
                case 1: goto L_0x00b6;
                case 2: goto L_0x00b6;
                case 3: goto L_0x00e5;
                case 4: goto L_0x00b6;
                case 5: goto L_0x00b6;
                case 6: goto L_0x00d1;
                case 7: goto L_0x00b6;
                case 8: goto L_0x00f0;
                default: goto L_0x00b6;
            };
        L_0x00b6:
            r0 = r7.f3803c;	 Catch:{ OutOfMemoryError -> 0x00fb }
            r0 = android.media.ThumbnailUtils.extractThumbnail(r0, r1, r2);	 Catch:{ OutOfMemoryError -> 0x00fb }
            r7.f3803c = r0;	 Catch:{ OutOfMemoryError -> 0x00fb }
        L_0x00be:
            r0 = new java.lang.Object[r6];
            r1 = r7.f3803c;
            r0[r5] = r1;
            r7.publishProgress(r0);
            goto L_0x0061;
        L_0x00c8:
            r0 = r7.f3801a;
            r0 = com.tinder.utils.C3066f.m9348a(r0, r1, r2);
            r7.f3803c = r0;
            goto L_0x00a5;
        L_0x00d1:
            r0 = r7.f3803c;	 Catch:{ Exception -> 0x00dc }
            r3 = 1119092736; // 0x42b40000 float:90.0 double:5.529052754E-315;
            r0 = com.tinder.activities.ActivityEditMoment.m5989a(r0, r3);	 Catch:{ Exception -> 0x00dc }
            r7.f3803c = r0;	 Catch:{ Exception -> 0x00dc }
            goto L_0x00b6;
        L_0x00dc:
            r0 = move-exception;
            r0 = r0.getMessage();
            com.tinder.utils.C3095y.m9479c(r0);
            goto L_0x00b6;
        L_0x00e5:
            r0 = r7.f3803c;	 Catch:{ Exception -> 0x00dc }
            r3 = 1127481344; // 0x43340000 float:180.0 double:5.570497984E-315;
            r0 = com.tinder.activities.ActivityEditMoment.m5989a(r0, r3);	 Catch:{ Exception -> 0x00dc }
            r7.f3803c = r0;	 Catch:{ Exception -> 0x00dc }
            goto L_0x00b6;
        L_0x00f0:
            r0 = r7.f3803c;	 Catch:{ Exception -> 0x00dc }
            r3 = 1132920832; // 0x43870000 float:270.0 double:5.597372625E-315;
            r0 = com.tinder.activities.ActivityEditMoment.m5989a(r0, r3);	 Catch:{ Exception -> 0x00dc }
            r7.f3803c = r0;	 Catch:{ Exception -> 0x00dc }
            goto L_0x00b6;
        L_0x00fb:
            r0 = move-exception;
            r0 = r0.getMessage();
            com.tinder.utils.C3095y.m9471a(r0);
            goto L_0x00be;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tinder.activities.ActivityEditMoment.b.a(java.lang.Void[]):java.lang.Void");
        }

        public void onProgressUpdate(@NonNull Object... objArr) {
            for (Bitmap bitmap : objArr) {
                if (bitmap == this.f3803c) {
                    C3095y.m9471a("Original");
                    this.f3809i.af = this.f3803c;
                    this.f3809i.al.m6390a(this.f3809i.af);
                    if (this.f3809i.aj != null && this.f3809i.aj.isShowing()) {
                        this.f3809i.aj.m6783a(this.f3809i.af);
                    }
                } else if (bitmap == this.f3806f) {
                    C3095y.m9471a("coal");
                    this.f3809i.ai = this.f3806f;
                    this.f3809i.al.m6393d(this.f3809i.ai);
                    if (this.f3809i.aj != null && this.f3809i.aj.isShowing()) {
                        this.f3809i.aj.m6785c(this.f3809i.ai);
                    }
                } else if (bitmap == this.f3804d) {
                    C3095y.m9471a("chill");
                    this.f3809i.ah = this.f3804d;
                    this.f3809i.al.m6392c(this.f3809i.ah);
                    if (this.f3809i.aj != null && this.f3809i.aj.isShowing()) {
                        this.f3809i.aj.m6784b(this.f3809i.ah);
                    }
                } else if (bitmap == this.f3805e) {
                    C3095y.m9471a("glow");
                    this.f3809i.ag = this.f3805e;
                    this.f3809i.al.m6391b(this.f3809i.ag);
                    if (this.f3809i.aj != null && this.f3809i.aj.isShowing()) {
                        this.f3809i.aj.m6786d(this.f3809i.ag);
                    }
                }
                this.f3809i.al.notifyDataSetChanged();
            }
        }
    }

    public ActivityEditMoment() {
        this.f3842h = TextSizeMode.SMALL;
        this.f3832S = true;
        this.ab = "Original";
    }

    static {
        f3810b = (float) ManagerApp.m7917h().getResources().getDimensionPixelSize(R.dimen.moment_edit_text_small);
        f3811c = (float) ManagerApp.m7917h().getResources().getDimensionPixelSize(R.dimen.moment_edit_text_large);
        f3812e = (int) TypedValue.applyDimension(1, 1000.0f, ManagerApp.m7917h().getResources().getDisplayMetrics());
        f3813f = (int) TypedValue.applyDimension(1, 400.0f, ManagerApp.m7917h().getResources().getDisplayMetrics());
    }

    public static Bitmap m5989a(@NonNull Bitmap bitmap, float f) {
        Matrix matrix = new Matrix();
        matrix.postRotate(f);
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            bitmap.recycle();
            return createBitmap;
        } catch (OutOfMemoryError e) {
            C3095y.m9479c(e.getMessage());
            return bitmap;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if ("android.intent.action.SEND".equals(intent.getAction())) {
            if (ManagerApp.m7911b().m8144e()) {
                this.ap = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM");
            } else {
                Toast.makeText(this, R.string.must_log_in_to_share, 1).show();
                intent = new Intent(this, ActivityLogin.class);
                intent.putExtras(new Bundle());
                startActivity(intent);
                finish();
            }
        }
        C3095y.m9469a();
        m6014h();
    }

    public void onPause() {
        super.onPause();
        if (this.f3840a) {
            al.m9268a(this.f3815B.getWindowToken(), (Activity) this);
        } else {
            al.m9268a(this.f3814A.getWindowToken(), (Activity) this);
        }
    }

    public void onDestroy() {
        al.m9297c(this.aj);
        al.m9297c(this.ak);
        al.m9297c(this.ao);
        super.onDestroy();
    }

    private void m6014h() {
        getWindow().setFlags(Place.TYPE_SUBLOCALITY_LEVEL_2, Place.TYPE_SUBLOCALITY_LEVEL_2);
        setContentView(R.layout.view_edit_moment);
        this.aa = getResources().getColor(R.color.white);
        this.f3827N = new ab(this);
        this.al = new C2345i(this);
        this.f3843i = (ViewPager) findViewById(R.id.pager);
        this.f3843i.setPageMargin(0);
        this.f3843i.setAdapter(this.al);
        this.f3843i.setOnPageChangeListener(this);
        this.f3848n = (RelativeLayout) findViewById(R.id.moment_edit_layout_parent);
        this.f3849o = (RelativeLayout) findViewById(R.id.layout_moment_send);
        this.f3846l = (LinearLayout) findViewById(R.id.layout_pen_options);
        this.f3847m = (RelativeLayout) findViewById(R.id.layout_undo);
        this.f3850p = (DrawingSurface) findViewById(R.id.surface_moment);
        this.f3840a = al.m9276a();
        this.f3815B = (PermissiveEditText) findViewById(R.id.moment_edittext_legacy);
        this.f3814A = (DraggableEditText) findViewById(R.id.moment_edittext);
        this.f3851q = (ImageButton) findViewById(R.id.btn_undo);
        this.f3852r = (ImageButton) findViewById(R.id.btn_pen);
        this.f3855u = (ImageButton) findViewById(R.id.btn_text_color);
        this.f3854t = (ImageButton) findViewById(R.id.btn_choose_color);
        this.f3856v = (ImageButton) findViewById(R.id.btn_add_text);
        this.f3857w = (ImageButton) findViewById(R.id.btn_text_size);
        this.f3858x = (ImageButton) findViewById(R.id.btn_text_align);
        this.f3853s = (ImageButton) findViewById(R.id.btn_add_filter);
        this.f3859y = (ImageButton) findViewById(R.id.btn_moment_send);
        this.f3860z = (ImageButton) findViewById(R.id.btn_moment_save);
        this.f3816C = findViewById(R.id.layout_undo_background).getBackground();
        this.f3845k = (ImageView) findViewById(R.id.moment_editor_img_copy);
        this.f3844j = findViewById(R.id.moment_editor_img_copy_bg);
        this.f3848n.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.f3848n.setOnClickListener(this);
        this.f3851q.setOnClickListener(this);
        this.f3851q.setOnLongClickListener(this);
        this.f3852r.setOnClickListener(this);
        this.f3855u.setOnClickListener(this);
        this.f3856v.setOnClickListener(this);
        this.f3853s.setOnClickListener(this);
        this.f3858x.setOnClickListener(this);
        this.f3857w.setOnClickListener(this);
        this.f3854t.setOnClickListener(this);
        this.f3859y.setOnClickListener(this);
        this.f3860z.setOnClickListener(this);
        this.ac = "DROIDX".equals(Build.MODEL);
        this.f3826M = new C3096z(140, m6041t());
        m6041t().addTextChangedListener(this.f3826M);
        int b = al.m9285b((Context) this);
        this.f3828O = new aa(((((float) b) * 0.75f) - (((float) b) * 0.25f)) * 0.9f, m6041t(), this);
        m6041t().addTextChangedListener(this.f3828O);
        this.f3843i.setOnTouchListener(new C22521(this, m6016i()));
        if (this.ac) {
            this.f3853s.setVisibility(8);
            this.f3843i.setOnTouchListener(new OnTouchListener() {
                final /* synthetic */ ActivityEditMoment f3763a;

                {
                    this.f3763a = r1;
                }

                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return true;
                }
            });
        }
        if (this.f3840a) {
            this.f3815B.setOnClickListener(this);
            this.f3815B.setOnTouchListener(new OnTouchListener() {
                final /* synthetic */ ActivityEditMoment f3766a;

                {
                    this.f3766a = r1;
                }

                public boolean onTouch(View view, @NonNull MotionEvent motionEvent) {
                    return this.f3766a.f3838Y ? this.f3766a.f3835V.onTouchEvent(motionEvent) : true;
                }
            });
            this.f3835V = new GestureDetector(this, new OnGestureListener() {
                final /* synthetic */ ActivityEditMoment f3767a;

                {
                    this.f3767a = r1;
                }

                public boolean onDown(MotionEvent motionEvent) {
                    return true;
                }

                public void onShowPress(MotionEvent motionEvent) {
                }

                public boolean onSingleTapUp(MotionEvent motionEvent) {
                    this.f3767a.f3815B.performClick();
                    return true;
                }

                public boolean onScroll(MotionEvent motionEvent, @NonNull MotionEvent motionEvent2, float f, float f2) {
                    this.f3767a.m6006d(Math.round(motionEvent2.getRawY() + f) - (this.f3767a.f3815B.getHeight() / 2));
                    return true;
                }

                public void onLongPress(MotionEvent motionEvent) {
                }

                public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                    return false;
                }
            });
            this.f3815B.addTextChangedListener(this.f3827N);
        } else {
            this.f3814A.setOnClickListener(this);
            this.f3814A.addTextChangedListener(this.f3827N);
        }
        this.an = ManagerApp.m7926q().m8488m().isEmpty();
        this.f3834U = getIntent().getExtras().getInt("captured_camera_index", 1);
        al.m9287b(this.f3859y);
        m6035q();
        m6033p();
        m6036r();
    }

    @NonNull
    private GestureDetector m6016i() {
        return new GestureDetector(this, new OnGestureListener() {
            final /* synthetic */ ActivityEditMoment f3768a;

            {
                this.f3768a = r1;
            }

            public boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            public void onShowPress(MotionEvent motionEvent) {
            }

            public boolean onSingleTapUp(MotionEvent motionEvent) {
                if (this.f3768a.f3857w.getVisibility() == 0) {
                    this.f3768a.m6027m();
                } else {
                    this.f3768a.m6025l();
                }
                return false;
            }

            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            public void onLongPress(MotionEvent motionEvent) {
            }

            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }
        });
    }

    private void m6006d(int i) {
        int a = al.m9262a((Context) this);
        int b = al.m9285b((Context) this);
        this.f3836W = new RectF(0.0f, ((float) b) * 0.25f, (float) a, ((float) b) * 0.75f);
        if (this.f3836W.bottom - ((float) this.f3815B.getMeasuredHeight()) >= ((float) i) && this.f3836W.top - ((float) this.f3815B.getMeasuredHeight()) <= ((float) i)) {
            LayoutParams layoutParams = (LayoutParams) this.f3815B.getLayoutParams();
            layoutParams.topMargin = i;
            this.f3815B.setLayoutParams(layoutParams);
            this.f3815B.invalidate();
            this.f3837X = (float) i;
        }
    }

    public void t_() {
        if (this.f3837X != 0.0f) {
            this.f3815B.measure(0, 0);
            this.f3815B.animate().y(this.f3837X).setInterpolator(new DecelerateInterpolator()).setDuration(400).start();
        }
    }

    public void u_() {
        this.f3852r.setSelected(true);
        if (this.f3840a) {
            this.f3838Y = false;
        } else {
            this.f3814A.setDraggable(false);
            this.f3814A.setIsEditable(false);
        }
        m6041t().setShouldTouchesBePassedOn(true);
        this.f3850p.setEnabled(true);
        this.f3817D.start();
        m5993a(1, this.f3856v, this.f3853s);
        this.f3854t.setEnabled(true);
        this.f3851q.setEnabled(true);
        this.f3854t.setVisibility(0);
        this.f3847m.setVisibility(0);
        this.f3846l.setVisibility(0);
        this.f3854t.animate().scaleX(1.0f).scaleY(1.0f).setStartDelay(80).setInterpolator(this.f3822I).start();
        this.f3847m.animate().scaleX(1.0f).scaleY(1.0f).setStartDelay(80).setInterpolator(this.f3822I).start();
    }

    public void m6059e() {
        if (this.f3840a) {
            this.f3838Y = true;
        } else {
            this.f3814A.setDraggable(true);
        }
        m6041t().setShouldTouchesBePassedOn(false);
        this.f3850p.setEnabled(false);
        this.f3818E.start();
        if (this.ac) {
            m5998a(this.f3856v);
        } else {
            m5998a(this.f3853s, this.f3856v);
        }
        this.f3854t.animate().scaleX(0.0f).scaleY(0.0f).setDuration(200).setInterpolator(this.f3823J).start();
        this.f3854t.setEnabled(false);
        this.f3851q.setEnabled(false);
        this.f3847m.animate().scaleX(0.0f).scaleY(0.0f).setDuration(200).setInterpolator(this.f3823J).start();
        this.f3854t.postDelayed(new Runnable() {
            final /* synthetic */ ActivityEditMoment f3769a;

            {
                this.f3769a = r1;
            }

            public void run() {
                this.f3769a.f3854t.setVisibility(8);
                this.f3769a.f3847m.setVisibility(8);
                this.f3769a.f3846l.setVisibility(8);
            }
        }, 350);
        al.m9297c(this.ak);
    }

    private void m6020j() {
        int i = -f3813f;
        if (!al.m9276a()) {
            this.f3852r.animate().translationYBy((float) i).alphaBy(-5.0f).setInterpolator(this.f3824K).setDuration(350).start();
            this.f3846l.animate().alpha(0.0f).setInterpolator(this.f3824K).setDuration(200).start();
            this.f3849o.animate().translationYBy((float) f3813f).alphaBy(-5.0f).setInterpolator(this.f3824K).setDuration(350).start();
        }
    }

    private void m6023k() {
        if (!al.m9276a()) {
            this.f3852r.animate().translationY(0.0f).alpha(1.0f).setDuration(400).setInterpolator(this.f3825L).start();
            this.f3846l.animate().alpha(1.0f).setDuration(400).setStartDelay(80).setInterpolator(this.f3825L).start();
            this.f3849o.animate().translationY(0.0f).alpha(1.0f).setDuration(400).setInterpolator(this.f3825L).start();
        }
    }

    private void m6025l() {
        if (this.f3840a) {
            this.f3815B.setFocusable(true);
            this.f3815B.setFocusableInTouchMode(true);
            this.f3815B.setVisibility(0);
            this.f3815B.setInputType(180225);
            this.f3815B.setOnClickListener(null);
            this.f3815B.setText(this.f3815B.getText());
            this.f3815B.setSelection(this.f3815B.getText().length());
            al.m9267a((Context) this, this.f3815B);
            if (!al.m9281a(this.f3815B)) {
                this.f3815B.setTextSize(0, f3810b);
                this.f3815B.setCursorVisible(true);
            }
            this.f3838Y = false;
        } else {
            this.f3814A.setVisibility(0);
            this.f3814A.setInputType(180225);
            this.f3814A.setOnClickListener(null);
            this.f3814A.setText(this.f3814A.getText());
            this.f3814A.setSelection(this.f3814A.getText().length());
            this.f3814A.setCursorVisible(true);
            this.f3814A.setDraggable(false);
            this.f3814A.setIsEditable(true);
            al.m9267a((Context) this, this.f3814A);
            if (!al.m9281a(this.f3814A)) {
                this.f3814A.setTextSize(0, f3810b);
            }
            if (this.f3814A.knowsKeyboardLocation()) {
                getWindow().setSoftInputMode(48);
                this.f3814A.postDelayed(new Runnable() {
                    final /* synthetic */ ActivityEditMoment f3770a;

                    {
                        this.f3770a = r1;
                    }

                    public void run() {
                        this.f3770a.f3814A.moveAboveKeyboard(true);
                    }
                }, 150);
            }
        }
        this.f3856v.setSelected(true);
        this.f3856v.setEnabled(true);
        this.f3819F.start();
        m5993a(-1, this.f3852r, this.f3853s);
        this.f3857w.setVisibility(0);
        this.f3858x.setVisibility(0);
        this.f3855u.setVisibility(0);
        this.f3857w.animate().scaleX(1.0f).scaleY(1.0f).setStartDelay(80).setInterpolator(this.f3822I).start();
        this.f3858x.animate().scaleX(1.0f).scaleY(1.0f).setStartDelay(80).setInterpolator(this.f3822I).start();
        this.f3855u.animate().scaleX(1.0f).scaleY(1.0f).setStartDelay(80).setInterpolator(this.f3822I).start();
    }

    private void m6027m() {
        if (this.f3840a) {
            if (!al.m9281a(this.f3815B)) {
                this.f3815B.setVisibility(4);
            }
            this.f3815B.setInputType(655361);
            this.f3815B.setOnClickListener(this);
            t_();
            this.f3815B.setCursorVisible(false);
            this.f3815B.clearFocus();
            this.f3815B.setSelected(false);
            this.f3815B.setFocusable(false);
            al.m9268a(this.f3815B.getWindowToken(), (Activity) this);
            this.f3838Y = true;
        } else {
            if (!al.m9281a(this.f3814A)) {
                this.f3814A.setVisibility(4);
            }
            this.f3814A.setOnClickListener(this);
            this.f3814A.setIsEditable(false);
            this.f3814A.setInputType(655361);
            this.f3814A.resetToLastPosition();
            this.f3814A.setCursorVisible(false);
            this.f3814A.clearFocus();
            this.f3814A.setDraggable(true);
            this.f3814A.setSelected(false);
            al.m9268a(this.f3814A.getWindowToken(), (Activity) this);
        }
        this.f3820G.start();
        if (this.ac) {
            m5998a(this.f3852r);
        } else {
            m5998a(this.f3852r, this.f3853s);
        }
        this.f3857w.animate().scaleX(0.0f).scaleY(0.0f).setDuration(200).setInterpolator(this.f3823J).start();
        this.f3858x.animate().scaleX(0.0f).scaleY(0.0f).setDuration(200).setInterpolator(this.f3823J).start();
        this.f3855u.animate().scaleX(0.0f).scaleY(0.0f).setDuration(200).setInterpolator(this.f3823J).start();
        this.f3857w.postDelayed(new Runnable() {
            final /* synthetic */ ActivityEditMoment f3771a;

            {
                this.f3771a = r1;
            }

            public void run() {
                this.f3771a.f3857w.setVisibility(8);
                this.f3771a.f3858x.setVisibility(8);
                this.f3771a.f3855u.setVisibility(8);
            }
        }, 350);
    }

    private void m6029n() {
        float f = 0.0f;
        if (this.f3840a) {
            if (al.m9281a(this.f3815B)) {
                float textSize = this.f3815B.getTextSize();
                int selectionStart = this.f3815B.getSelectionStart();
                if (textSize == f3810b) {
                    f = f3811c;
                    this.f3842h = TextSizeMode.LARGE;
                } else if (textSize == f3811c) {
                    f = f3810b;
                    this.f3815B.setTextSize(0, f);
                    this.f3815B.setText(this.f3815B.getText());
                    this.f3815B.setSelection(this.f3815B.getText().length());
                    this.f3842h = TextSizeMode.SMALL;
                }
                this.f3815B.setSelected(true);
                this.f3815B.setTextSize(0, f);
                m6007e(this.f3815B.length());
                this.f3815B.invalidate();
                this.f3815B.setSelection(selectionStart);
            }
        } else if (al.m9281a(this.f3814A)) {
            if (this.f3842h == TextSizeMode.SMALL) {
                f = f3811c;
                this.f3842h = TextSizeMode.LARGE;
            } else if (this.f3842h == TextSizeMode.LARGE) {
                f = f3810b;
                this.f3814A.setTextSize(0, f);
                this.f3814A.setText(this.f3814A.getText());
                this.f3814A.setSelection(this.f3814A.getText().length());
                this.f3842h = TextSizeMode.SMALL;
            }
            this.f3814A.setSelected(true);
            this.f3814A.setTextSize(0, f);
            int length = this.f3814A.getText().length();
            C3095y.m9471a("MODE IS NOW " + this.f3842h);
            m6007e(this.f3814A.length());
            this.f3814A.setText(this.f3814A.getText());
            this.f3814A.setSelection(length);
            this.f3814A.moveAboveKeyboard(false);
            this.f3814A.invalidate();
        }
        ManagerApp.m7914e().m8842f(this.f3842h == TextSizeMode.SMALL);
    }

    private void m6031o() {
        m5996a(this.f3840a ? this.f3815B : this.f3814A);
    }

    public void m6055a(int i) {
        C3095y.m9471a("num chars yo: " + i);
        m6007e(i);
    }

    private void m6007e(int i) {
        float textSize = this.f3814A.getTextSize();
        if (this.f3842h != TextSizeMode.SMALL) {
            if (this.f3842h == TextSizeMode.LARGE) {
                float f = m6009f(i);
                if (textSize == f) {
                    return;
                }
                if (al.m9276a()) {
                    this.f3815B.setTextSize(0, f);
                    this.f3815B.invalidate();
                    return;
                }
                this.f3814A.setTextSize(0, f);
                this.f3814A.invalidate();
                return;
            }
            C3095y.m9479c("unknown text mode, SOMETHING IS WRONG!");
            throw new IllegalStateException("Unknown text mode for mTextSizeMode!");
        }
    }

    private float m6009f(int i) {
        if (i <= 20) {
            return (float) getResources().getDimensionPixelSize(R.dimen.moment_edit_text_large);
        }
        if (i <= 40) {
            return (float) getResources().getDimensionPixelSize(R.dimen.moment_edit_text_large_mode_size_two);
        }
        if (i <= 60) {
            return (float) getResources().getDimensionPixelSize(R.dimen.moment_edit_text_large_mode_size_three);
        }
        return (float) getResources().getDimensionPixelSize(R.dimen.moment_edit_text_small);
    }

    private void m6012g(int i) {
        this.f3829P.m7032a(i);
        this.f3854t.getDrawable().setColorFilter(i, Mode.SRC_ATOP);
    }

    private void m6015h(int i) {
        this.aa = i;
        if (al.m9276a()) {
            this.f3815B.setTextColor(this.aa);
        } else {
            this.f3814A.setTextColor(this.aa);
        }
        if (i == -1) {
            this.f3855u.getDrawable().setColorFilter(null);
            this.f3855u.setImageResource(R.drawable.rounded_stroked_white_oval);
            return;
        }
        this.f3855u.getDrawable().setColorFilter(i, Mode.SRC_ATOP);
    }

    private void m6033p() {
        boolean z;
        int color = getResources().getColor(R.color.orange);
        int color2 = getResources().getColor(R.color.white);
        this.f3829P = new C2553d(color);
        this.f3850p.setDrawingTool(this.f3829P);
        m6012g(color);
        m6015h(color2);
        Bundle extras = getIntent().getExtras();
        boolean z2 = extras != null && extras.containsKey("captured_photo_path");
        if (extras == null || !extras.containsKey("gallery_photo_path")) {
            z = false;
        } else {
            z = true;
        }
        boolean z3;
        if (this.ap != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z2 || r0 || r4) {
            if (this.ap != null) {
                z = true;
            } else if (extras.containsKey("gallery_photo_path")) {
                this.f3830Q = extras.getString("gallery_photo_path");
                this.f3831R = (Uri) extras.getParcelable("gallery_photo_uri");
                z = true;
            } else {
                this.f3830Q = extras.getString("captured_photo_path");
                z = false;
            }
            Options options = new Options();
            options.outWidth = al.m9262a((Context) this);
            options.outHeight = al.m9285b((Context) this);
            if (C3077n.m9400a((Activity) this) <= AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) {
                options.inSampleSize = 2;
            }
            if (!al.m9276a()) {
                options.inMutable = true;
            }
            if (this.ac) {
                if (this.ap != null) {
                    this.ae = new C2262b(this, this.ap, options, z);
                } else {
                    this.ae = new C2262b(this, this.f3830Q, options, z);
                }
                if (VERSION.SDK_INT >= 11) {
                    this.ae.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Void[]) null);
                } else {
                    this.ae.execute((Void[]) null);
                }
            } else {
                if (this.ap != null) {
                    this.ad = new C2261a(this, this.ap, options, z);
                } else {
                    this.ad = new C2261a(this, this.f3830Q, options, z);
                }
                if (VERSION.SDK_INT >= 11) {
                    this.ad.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Void[]) null);
                } else {
                    this.ad.execute((Void[]) null);
                }
            }
        } else {
            m6043u();
        }
        this.f3850p.setEnabled(false);
        this.f3850p.setListener(this);
    }

    private void m6035q() {
        this.f3821H = new AnimatorListener() {
            final /* synthetic */ ActivityEditMoment f3774a;

            {
                this.f3774a = r1;
            }

            public void onAnimationStart(Animator animator) {
                this.f3774a.f3852r.setClickable(false);
                this.f3774a.f3851q.setClickable(false);
                this.f3774a.f3846l.setClickable(false);
            }

            public void onAnimationEnd(Animator animator) {
                this.f3774a.f3852r.setClickable(true);
                this.f3774a.f3851q.setClickable(true);
                this.f3774a.f3846l.setClickable(true);
                if (animator == this.f3774a.f3818E) {
                    this.f3774a.f3852r.setSelected(false);
                } else if (animator == this.f3774a.f3820G) {
                    this.f3774a.f3856v.setSelected(false);
                }
            }

            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }
        };
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f3852r, "scaleX", new float[]{1.2f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f3852r, "scaleY", new float[]{1.2f});
        TimeInterpolator overshootInterpolator = new OvershootInterpolator(5.0f);
        this.f3817D = new AnimatorSet();
        this.f3817D.playTogether(new Animator[]{ofFloat, ofFloat2});
        this.f3817D.setInterpolator(overshootInterpolator);
        this.f3817D.setDuration(300);
        this.f3817D.addListener(this.f3821H);
        ofFloat = ObjectAnimator.ofFloat(this.f3852r, "scaleX", new float[]{1.2f});
        ofFloat2 = ObjectAnimator.ofFloat(this.f3852r, "scaleY", new float[]{1.2f});
        this.f3819F = new AnimatorSet();
        this.f3819F.playTogether(new Animator[]{ofFloat, ofFloat2});
        this.f3819F.setTarget(this.f3856v);
        this.f3819F.setInterpolator(overshootInterpolator);
        this.f3819F.setDuration(300);
        this.f3819F.addListener(this.f3821H);
        ofFloat = ObjectAnimator.ofFloat(this.f3852r, "scaleX", new float[]{1.0f});
        ofFloat2 = ObjectAnimator.ofFloat(this.f3852r, "scaleY", new float[]{1.0f});
        overshootInterpolator = new AnticipateInterpolator(5.0f);
        this.f3818E = new AnimatorSet();
        this.f3818E.playTogether(new Animator[]{ofFloat, ofFloat2});
        this.f3818E.setInterpolator(overshootInterpolator);
        this.f3818E.setDuration(400);
        this.f3818E.addListener(this.f3821H);
        ofFloat = ObjectAnimator.ofFloat(this.f3856v, "scaleX", new float[]{1.0f});
        ofFloat2 = ObjectAnimator.ofFloat(this.f3856v, "scaleY", new float[]{1.0f});
        this.f3820G = new AnimatorSet();
        this.f3820G.playTogether(new Animator[]{ofFloat, ofFloat2});
        this.f3820G.setTarget(this.f3856v);
        this.f3820G.setInterpolator(overshootInterpolator);
        this.f3820G.setDuration(400);
        this.f3820G.addListener(this.f3821H);
        al.m9296c(this.f3854t, 0.0f);
        al.m9296c(this.f3857w, 0.0f);
        al.m9296c(this.f3855u, 0.0f);
        al.m9296c(this.f3858x, 0.0f);
        al.m9296c(this.f3847m, 0.0f);
        this.f3847m.setVisibility(4);
        this.f3822I = new OvershootInterpolator(3.0f);
        this.f3823J = new AnticipateInterpolator(2.0f);
        this.f3825L = new DecelerateInterpolator();
        this.f3824K = new AccelerateInterpolator();
    }

    private void m6036r() {
        int a = al.m9262a((Context) this);
        int b = al.m9285b((Context) this);
        boolean j = ManagerApp.m7914e().m8854j();
        if (this.f3840a) {
            this.f3815B.setMaxWidth(a);
            this.f3815B.setInputType(180225);
            this.f3815B.setImeOptions(6);
            this.f3815B.setOnEditorActionListener(this);
            this.f3815B.setDrawingCacheEnabled(true);
            LayoutParams layoutParams = (LayoutParams) this.f3815B.getLayoutParams();
            layoutParams.topMargin = b / 4;
            this.f3815B.setLayoutParams(layoutParams);
            this.f3815B.setGravity(49);
            this.f3815B.requestFocus();
            this.f3815B.clearFocus();
            if (j) {
                this.f3815B.setTextSize(0, f3810b);
            } else {
                this.f3815B.setTextSize(0, f3811c);
            }
        } else {
            this.f3814A.setDragBounds(new RectF(0.0f, ((float) b) * 0.25f, (float) a, ((float) b) * 0.75f));
            this.f3814A.setMaxWidth(a);
            this.f3814A.setLines(1);
            this.f3814A.setInputType(180225);
            this.f3814A.setImeOptions(6);
            this.f3814A.setOnEditorActionListener(this);
            this.f3814A.setDrawingCacheEnabled(true);
            this.f3814A.setTranslationY((float) (-b));
            this.f3814A.setGravity(49);
            this.f3814A.requestFocus();
            this.f3814A.clearFocus();
            if (j) {
                this.f3814A.setTextSize(0, f3810b);
            } else {
                this.f3814A.setTextSize(0, f3811c);
            }
            this.f3814A.invalidate();
        }
        if (j) {
            this.f3842h = TextSizeMode.SMALL;
        } else {
            this.f3842h = TextSizeMode.LARGE;
        }
    }

    private void m5993a(int i, @NonNull View... viewArr) {
        int i2 = i * f3812e;
        for (View animate : viewArr) {
            animate.animate().translationX((float) i2).alphaBy(-5.0f).setDuration(480).setInterpolator(this.f3824K).start();
        }
    }

    private void m5998a(@NonNull View... viewArr) {
        for (View animate : viewArr) {
            animate.animate().translationX(0.0f).alpha(1.0f).setDuration(400).setInterpolator(this.f3825L).start();
        }
    }

    private void m6039s() {
        int lastColor = this.f3850p.getLastColor();
        if (lastColor != 0) {
            this.f3816C.setColorFilter(lastColor, Mode.SRC_ATOP);
        }
    }

    private PermissiveEditText m6041t() {
        if (al.m9276a()) {
            return this.f3815B;
        }
        return this.f3814A;
    }

    private void m5995a(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", new float[]{1.2f, 1.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", new float[]{1.2f, 1.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.setDuration(200);
        animatorSet.start();
    }

    public void onClick(@NonNull View view) {
        SparksEvent sparksEvent;
        switch (view.getId()) {
            case R.id.btn_add_filter:
                this.aj = new ImageFiltersDialog(this, this.af, this.ag, this.ah, this.ai, this.al.m6389a(this.f3839Z), this);
                this.aj.show();
            case R.id.moment_edit_layout_parent:
                if (this.f3856v.isSelected()) {
                    m6027m();
                    return;
                }
                m6025l();
                sparksEvent = new SparksEvent("Moments.Text");
                sparksEvent.put("fromTap", Boolean.valueOf(true));
                C2807a.m8056a(sparksEvent);
            case R.id.moment_edittext_legacy:
            case R.id.moment_edittext:
                m6025l();
                sparksEvent = new SparksEvent("Moments.Text");
                sparksEvent.put("fromTap", Boolean.valueOf(false));
                C2807a.m8056a(sparksEvent);
            case R.id.btn_pen:
                if (this.f3852r.isSelected()) {
                    m6059e();
                    return;
                }
                u_();
                C2807a.m8058a("Moments.Draw");
            case R.id.btn_add_text:
                if (this.f3856v.isSelected()) {
                    m6027m();
                    return;
                }
                m6025l();
                sparksEvent = new SparksEvent("Moments.Text");
                sparksEvent.put("fromTap", Boolean.valueOf(false));
                C2807a.m8056a(sparksEvent);
            case R.id.btn_choose_color:
                this.f3841g = ColorPickerType.PEN;
                this.ak = new C2469b(this, this.f3830Q, false, false, this.f3829P.m7034c(), this);
                this.ak.setOnCancelListener(new C22543(this));
                this.ak.show();
                this.f3854t.setVisibility(8);
                this.f3847m.setVisibility(8);
            case R.id.btn_undo:
                m5995a(this.f3847m);
                this.f3850p.m7018a(false);
            case R.id.btn_text_size:
                m5995a(this.f3857w);
                m6029n();
            case R.id.btn_text_align:
                m6031o();
            case R.id.btn_text_color:
                if (al.m9276a()) {
                    al.m9268a(this.f3815B.getWindowToken(), (Activity) this);
                } else {
                    al.m9268a(this.f3814A.getWindowToken(), (Activity) this);
                }
                this.f3841g = ColorPickerType.TEXT;
                this.ak = new C2469b(this, this.f3830Q, true, true, this.aa, this);
                this.ak.setOnCancelListener(new C22532(this));
                this.ak.show();
                this.f3858x.setVisibility(8);
                this.f3857w.setVisibility(8);
                this.f3855u.setVisibility(8);
            case R.id.btn_moment_send:
                m6044v();
            case R.id.btn_moment_save:
                m6053z();
                C2807a.m8056a(m5992a("Moments.Save", null));
            default:
        }
    }

    public boolean onLongClick(@NonNull View view) {
        switch (view.getId()) {
            case R.id.btn_undo:
                this.f3850p.m7018a(true);
                return true;
            default:
                return false;
        }
    }

    public void m6060f() {
        int i = this.f3833T;
        this.f3833T = i + 1;
        if (i == 5 && this.f3832S) {
            m6020j();
        }
    }

    public void m6061g() {
        this.f3847m.setVisibility(0);
        if (this.f3847m.getScaleX() == 0.0f) {
            this.f3847m.animate().scaleX(1.0f).scaleY(1.0f).setInterpolator(this.f3822I).setStartDelay(120).start();
        }
        m6039s();
        m6023k();
        this.f3833T = 0;
    }

    public void m6057a(boolean z) {
        if (z) {
            this.f3847m.animate().scaleX(0.0f).scaleY(0.0f).setDuration(150).setInterpolator(this.f3823J).start();
        }
        m6039s();
    }

    public void m6058b(int i) {
        switch (AnonymousClass13.f3764a[this.f3841g.ordinal()]) {
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                m6021j(i);
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                m6018i(i);
            default:
        }
    }

    private void m6018i(int i) {
        this.f3855u.postDelayed(new C22554(this), 200);
        this.f3855u.postDelayed(new C22565(this), 350);
        if (al.m9276a()) {
            this.f3855u.invalidate();
        }
        if (i != 0) {
            m6015h(i);
        }
    }

    private void m6021j(int i) {
        this.f3854t.postDelayed(new C22576(this), 200);
        if (al.m9276a()) {
            this.f3854t.invalidate();
        }
        if (i != 0) {
            m6012g(i);
        }
    }

    private void m6043u() {
        finish();
    }

    private void m6044v() {
        C3095y.m9469a();
        if (!this.an || ManagerApp.m7926q().m8490o()) {
            Bitmap a = this.al.m6389a(this.f3839Z);
            if (a == null) {
                C3095y.m9476b("Not sending because the filtered image hasn't loaded yet");
                return;
            }
            String obj;
            this.ad.cancel(true);
            m6048x();
            long currentTimeMillis = System.currentTimeMillis();
            String str = BuildConfig.FLAVOR;
            if (this.f3840a) {
                obj = this.f3815B.getText().toString();
            } else {
                obj = this.f3814A.getText().toString();
            }
            Moment moment = new Moment(String.valueOf(currentTimeMillis), ManagerApp.m7922m().m8599d().getId(), currentTimeMillis, obj, null, this.ab, BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, null, true, MomentAction.CREATE);
            m5983B();
            moment.setBitmap(this.f3850p.getPicture());
            User d = ManagerApp.m7922m().m8599d();
            moment.setPerson(new Person(d.getId(), d.getName(), d.getGender(), d.isVerified()));
            ManagerApp.m7926q().m8461a(moment, new C22587(this, moment));
            this.f3850p.setVisibility(8);
            m5994a(a);
            setResult(80085, new Intent());
            finish();
            return;
        }
        m5985C();
    }

    private void m5994a(Bitmap bitmap) {
        C3095y.m9469a();
        if (!(this.af == null || this.af == bitmap || this.af.isRecycled())) {
            this.af.recycle();
            this.af = null;
        }
        if (!(this.ag == null || this.ag == bitmap || this.ag.isRecycled())) {
            this.ag.recycle();
            this.ag = null;
        }
        if (!(this.ah == null || this.ah == bitmap || this.ah.isRecycled())) {
            this.ah.recycle();
            this.ah = null;
        }
        if (this.ai != null && this.ai != bitmap && !this.ai.isRecycled()) {
            this.ai.recycle();
            this.ai = null;
        }
    }

    private void m6047w() {
        C3095y.m9469a();
        m5994a(null);
    }

    private void m6048x() {
        C3095y.m9469a();
        this.f3850p.setPicture(new BitmapDrawable(getResources(), this.al.m6389a(this.f3839Z)));
    }

    private void m6051y() {
        this.f3850p.setViewToComposite(null);
        this.f3850p.m7017a();
    }

    private void m6053z() {
        C3095y.m9469a();
        m6048x();
        m5983B();
        C3075l.m9388a(this, this.f3850p.getPicture(), 90, "Tinder", C3070i.m9370c(), new C22598(this, this));
        m5981A();
    }

    private void m5981A() {
        this.f3845k.setImageBitmap(this.f3850p.getPicture());
        this.f3845k.setVisibility(0);
        al.m9296c(this.f3845k, 1.0f);
        this.f3844j.setVisibility(0);
        this.f3844j.setAlpha(1.0f);
        int[] iArr = new int[2];
        this.f3860z.getLocationOnScreen(iArr);
        int width = iArr[0] + (this.f3860z.getWidth() / 2);
        int height = iArr[1] + (this.f3860z.getHeight() / 2);
        this.f3845k.setPivotX((float) width);
        this.f3845k.setPivotY((float) height);
        this.f3845k.animate().scaleX(0.0f).scaleY(0.0f).setDuration(300).setInterpolator(new AccelerateInterpolator()).setListener(new C22609(this)).start();
    }

    private void m5983B() {
        if (this.f3840a) {
            if (al.m9281a(this.f3815B)) {
                this.f3850p.setViewToComposite(this.f3815B);
            } else {
                this.f3850p.setViewToComposite(null);
            }
        } else if (al.m9281a(this.f3814A)) {
            this.f3850p.setViewToComposite(this.f3814A);
        } else {
            this.f3850p.setViewToComposite(null);
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.f3856v.isSelected()) {
                m6027m();
                return true;
            } else if (this.f3852r.isSelected()) {
                m6059e();
                return true;
            } else {
                onBackPressed();
            }
        }
        return false;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6 && i != 4) {
            return false;
        }
        m6027m();
        return true;
    }

    public void onBackPressed() {
        super.onBackPressed();
        C3095y.m9469a();
        C2807a.m8058a("Moments.CancelEdit");
    }

    public void onGlobalLayout() {
        Rect rect = new Rect();
        this.f3848n.getWindowVisibleDisplayFrame(rect);
        if (!this.f3840a && this.f3848n.getRootView().getHeight() - rect.height() > 100) {
            DraggableEditText draggableEditText = this.f3814A;
            boolean z = this.f3814A.getText().length() > 0 && !this.f3814A.isSelected();
            draggableEditText.moveAboveKeyboard(z);
        }
    }

    public void finish() {
        super.finish();
        C3095y.m9469a();
        if (this.f3850p != null) {
            this.f3850p.m7020c();
        }
    }

    @NonNull
    private SparksEvent m5992a(String str, @Nullable String str2) {
        SparksEvent sparksEvent = new SparksEvent(str);
        sparksEvent.put("camera", Integer.valueOf(this.f3834U));
        sparksEvent.put("filter", this.ab);
        if (str2 != null) {
            sparksEvent.put("momentId", str2);
        }
        if (this.f3840a) {
            if (al.m9281a(this.f3815B)) {
                sparksEvent.put("edits", this.f3815B.getText().toString());
            }
        } else if (al.m9281a(this.f3814A)) {
            sparksEvent.put("edits", this.f3814A.getText().toString());
        }
        return sparksEvent;
    }

    public void m6056a(@NonNull FilterType filterType) {
        this.am = true;
        String str = BuildConfig.FLAVOR;
        switch (AnonymousClass13.f3765b[filterType.ordinal()]) {
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                str = "Original";
                this.f3843i.setCurrentItem(0, true);
                break;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                str = "Glow";
                this.f3843i.setCurrentItem(1, true);
                break;
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                str = "Chill";
                this.f3843i.setCurrentItem(2, true);
                break;
            case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                str = "Coal";
                this.f3843i.setCurrentItem(3, true);
                break;
        }
        this.ab = str;
        SparksEvent sparksEvent = new SparksEvent("Moments.Filter");
        sparksEvent.put("filter", str);
        sparksEvent.put("method", Integer.valueOf(1));
        C2807a.m8056a(sparksEvent);
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageSelected(int i) {
        this.f3839Z = i;
        if (!this.am) {
            String str = BuildConfig.FLAVOR;
            if (i == 0) {
                str = "Original";
            } else if (i == 1) {
                str = "Glow";
            } else if (i == 2) {
                str = "Chill";
            } else if (i == 3) {
                str = "Coal";
            }
            this.ab = str;
            SparksEvent sparksEvent = new SparksEvent("Moments.Filter");
            sparksEvent.put("filter", str);
            sparksEvent.put("method", Integer.valueOf(0));
            C2807a.m8056a(sparksEvent);
        }
        this.am = false;
    }

    public void onPageScrollStateChanged(int i) {
    }

    public void m6054a(float f, float f2) {
        if (!al.m9276a()) {
            this.f3814A.moveAboveKeyboard(false);
        }
    }

    private void m5996a(@NonNull EditText editText) {
        switch (editText.getGravity()) {
            case C3168f.Theme_actionButtonStyle /*49*/:
                this.f3858x.setImageResource(R.drawable.editmoment_texttool_right_alignment_icon);
                editText.setGravity(53);
            case C3168f.Theme_buttonBarButtonStyle /*51*/:
                this.f3858x.setImageResource(R.drawable.editmoment_texttool_center_alignment_icon);
                editText.setGravity(49);
            case C3168f.Theme_selectableItemBackgroundBorderless /*53*/:
                this.f3858x.setImageResource(R.drawable.editmoment_texttool_left_alignment_icon);
                editText.setGravity(51);
            default:
        }
    }

    private void m5985C() {
        if (this.ao == null || !this.ao.isShowing()) {
            this.ao = new C2472h((Context) this, 0, (int) R.string.share_moment_prompt, (int) R.string.share_moment_body);
            this.ao.m6872a(R.string.cancel, new OnClickListener() {
                final /* synthetic */ ActivityEditMoment f3761a;

                {
                    this.f3761a = r1;
                }

                public void onClick(View view) {
                    al.m9297c(this.f3761a.ao);
                }
            });
            this.ao.m6876b(R.string.share, new OnClickListener() {
                final /* synthetic */ ActivityEditMoment f3762a;

                {
                    this.f3762a = r1;
                }

                public void onClick(View view) {
                    this.f3762a.m6044v();
                }
            });
            this.ao.show();
            ManagerApp.m7926q().m8474c(true);
        }
    }
}
