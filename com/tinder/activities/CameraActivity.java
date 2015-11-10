package com.tinder.activities;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.AutoFocusMoveCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.ShutterCallback;
import android.hardware.Camera.Size;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore.Images.Media;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tinder.R;
import com.tinder.base.ActivityBase;
import com.tinder.dialogs.C2453a;
import com.tinder.enums.CameraIndex;
import com.tinder.managers.C2807a;
import com.tinder.managers.ManagerApp;
import com.tinder.model.SparksEvent;
import com.tinder.p030d.C2321d;
import com.tinder.picassowebp.picasso.C2311e;
import com.tinder.picassowebp.picasso.Picasso;
import com.tinder.utils.C3064c;
import com.tinder.utils.C3064c.C2316c;
import com.tinder.utils.C3064c.C2318a;
import com.tinder.utils.C3070i;
import com.tinder.utils.C3075l;
import com.tinder.utils.C3095y;
import com.tinder.utils.al;
import com.tinder.views.RoundImageView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CameraActivity extends ActivityBase implements AutoFocusCallback, PictureCallback, ShutterCallback, Callback, OnClickListener, C2321d {
    private boolean f4001A;
    private RelativeLayout f4002a;
    private SurfaceView f4003b;
    private SurfaceHolder f4004c;
    @Nullable
    private View f4005e;
    private ImageView f4006f;
    private RoundImageView f4007g;
    @Nullable
    private C2453a f4008h;
    @Nullable
    private Camera f4009i;
    private ObjectAnimator f4010j;
    @Nullable
    private String f4011k;
    private boolean f4012l;
    private boolean f4013m;
    private boolean f4014n;
    private boolean f4015o;
    private int f4016p;
    private int f4017q;
    private int f4018r;
    private int f4019s;
    private int f4020t;
    @Nullable
    private GestureDetector f4021u;
    @NonNull
    private Handler f4022v;
    @Nullable
    private Runnable f4023w;
    @Nullable
    private Rect f4024x;
    @Nullable
    private Size f4025y;
    @Nullable
    private Size f4026z;

    /* renamed from: com.tinder.activities.CameraActivity.1 */
    class C23081 extends SimpleOnGestureListener {
        final /* synthetic */ CameraActivity f3986a;

        C23081(CameraActivity cameraActivity) {
            this.f3986a = cameraActivity;
        }

        public boolean onSingleTapUp(@NonNull MotionEvent motionEvent) {
            if (VERSION.SDK_INT >= 14 && this.f3986a.f4009i != null && !this.f3986a.f4013m && !this.f3986a.f4012l && this.f3986a.f4016p == 0 && this.f3986a.f4005e == null) {
                Parameters parameters = this.f3986a.f4009i.getParameters();
                parameters.setFocusMode("auto");
                this.f3986a.f4009i.setParameters(parameters);
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                float touchMajor = motionEvent.getTouchMajor();
                float touchMinor = motionEvent.getTouchMinor();
                Rect rect = new Rect((int) (x - (touchMajor / 2.0f)), (int) (y - (touchMinor / 2.0f)), (int) (x + (touchMajor / 2.0f)), (int) (y + (touchMinor / 2.0f)));
                if (this.f3986a.f4023w != null) {
                    this.f3986a.f4022v.removeCallbacks(this.f3986a.f4023w);
                }
                this.f3986a.m6342a(rect);
            } else if (this.f3986a.f4009i != null && this.f3986a.f4005e == null) {
                this.f3986a.f4009i.autoFocus(null);
            }
            return false;
        }

        public void onLongPress(@NonNull MotionEvent motionEvent) {
            if (this.f3986a.f4005e != null) {
                this.f3986a.f4005e.setVisibility(8);
            }
            this.f3986a.m6306a((int) (motionEvent.getX() - (motionEvent.getTouchMajor() / 2.0f)), ((int) motionEvent.getY()) - this.f3986a.f4020t);
        }
    }

    /* renamed from: com.tinder.activities.CameraActivity.2 */
    class C23102 implements AnimatorListener {
        final /* synthetic */ boolean f3988a;
        final /* synthetic */ CameraActivity f3989b;

        /* renamed from: com.tinder.activities.CameraActivity.2.1 */
        class C23091 implements Runnable {
            final /* synthetic */ C23102 f3987a;

            C23091(C23102 c23102) {
                this.f3987a = c23102;
            }

            public void run() {
                this.f3987a.f3989b.f4002a.removeView(this.f3987a.f3989b.f4005e);
                this.f3987a.f3989b.f4005e = null;
            }
        }

        C23102(CameraActivity cameraActivity, boolean z) {
            this.f3989b = cameraActivity;
            this.f3988a = z;
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            if (this.f3989b.f4005e != null) {
                if (this.f3988a) {
                    this.f3989b.f4005e.setBackgroundResource(R.drawable.camerafocused_icon);
                } else {
                    this.f3989b.f4005e.setBackgroundResource(R.drawable.camerafailedfocusing_icon);
                }
                this.f3989b.f4005e.postDelayed(new C23091(this), 300);
            }
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* renamed from: com.tinder.activities.CameraActivity.3 */
    class C23123 implements C2311e {
        final /* synthetic */ String f3990a;
        final /* synthetic */ CameraActivity f3991b;

        C23123(CameraActivity cameraActivity, String str) {
            this.f3991b = cameraActivity;
            this.f3990a = str;
        }

        public void m6289a() {
            C3095y.m9471a("loaded image with Picasso");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void m6290b() {
            /*
            r4 = this;
            r0 = "error loading image with Picasso";
            com.tinder.utils.C3095y.m9471a(r0);
            r0 = 1;
            r1 = 1108606976; // 0x42140000 float:37.0 double:5.477246216E-315;
            r2 = r4.f3991b;
            r2 = r2.getResources();
            r2 = r2.getDisplayMetrics();
            r0 = android.util.TypedValue.applyDimension(r0, r1, r2);
            r0 = (int) r0;
            r1 = r4.f3990a;
            r0 = com.tinder.utils.C3066f.m9348a(r1, r0, r0);
            r1 = new android.media.ExifInterface;	 Catch:{ Exception -> 0x004d }
            r2 = r4.f3990a;	 Catch:{ Exception -> 0x004d }
            r1.<init>(r2);	 Catch:{ Exception -> 0x004d }
            r2 = "Orientation";
            r3 = -1;
            r1 = r1.getAttributeInt(r2, r3);	 Catch:{ Exception -> 0x004d }
            switch(r1) {
                case 1: goto L_0x002e;
                case 2: goto L_0x002e;
                case 3: goto L_0x003f;
                case 4: goto L_0x002e;
                case 5: goto L_0x002e;
                case 6: goto L_0x0038;
                case 7: goto L_0x002e;
                case 8: goto L_0x0046;
                default: goto L_0x002e;
            };
        L_0x002e:
            r1 = r4.f3991b;
            r1 = r1.f4007g;
            r1.setImageBitmap(r0);
            return;
        L_0x0038:
            r1 = 1119092736; // 0x42b40000 float:90.0 double:5.529052754E-315;
            r0 = com.tinder.activities.CameraActivity.m6298a(r0, r1);	 Catch:{ Exception -> 0x004d }
            goto L_0x002e;
        L_0x003f:
            r1 = 1127481344; // 0x43340000 float:180.0 double:5.570497984E-315;
            r0 = com.tinder.activities.CameraActivity.m6298a(r0, r1);	 Catch:{ Exception -> 0x004d }
            goto L_0x002e;
        L_0x0046:
            r1 = 1132920832; // 0x43870000 float:270.0 double:5.597372625E-315;
            r0 = com.tinder.activities.CameraActivity.m6298a(r0, r1);	 Catch:{ Exception -> 0x004d }
            goto L_0x002e;
        L_0x004d:
            r1 = move-exception;
            r1 = r1.getMessage();
            com.tinder.utils.C3095y.m9471a(r1);
            goto L_0x002e;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tinder.activities.CameraActivity.3.b():void");
        }
    }

    /* renamed from: com.tinder.activities.CameraActivity.4 */
    class C23134 implements OnTouchListener {
        final /* synthetic */ CameraActivity f3992a;

        C23134(CameraActivity cameraActivity) {
            this.f3992a = cameraActivity;
        }

        public boolean onTouch(View view, @NonNull MotionEvent motionEvent) {
            this.f3992a.f4021u.onTouchEvent(motionEvent);
            if (motionEvent.getAction() == 1) {
                if (this.f3992a.f4008h != null && this.f3992a.f4008h.isShowing()) {
                    this.f3992a.f4008h.m6800a((int) motionEvent.getX(), (int) motionEvent.getY());
                }
            } else if (motionEvent.getAction() == 2 && this.f3992a.f4008h != null && this.f3992a.f4008h.isShowing()) {
                this.f3992a.f4008h.m6801b((int) motionEvent.getX(), (int) motionEvent.getY());
            }
            return true;
        }
    }

    /* renamed from: com.tinder.activities.CameraActivity.5 */
    class C23145 implements Runnable {
        final /* synthetic */ View f3993a;
        final /* synthetic */ CameraActivity f3994b;

        C23145(CameraActivity cameraActivity, View view) {
            this.f3994b = cameraActivity;
            this.f3993a = view;
        }

        public void run() {
            Point a = al.m9263a(this.f3993a);
            this.f3994b.f4018r = a.x + (this.f3993a.getWidth() / 2);
            this.f3994b.f4019s = a.y - (this.f3993a.getHeight() / 2);
        }
    }

    /* renamed from: com.tinder.activities.CameraActivity.6 */
    class C23156 implements Runnable {
        final /* synthetic */ View f3995a;
        final /* synthetic */ CameraActivity f3996b;

        C23156(CameraActivity cameraActivity, View view) {
            this.f3996b = cameraActivity;
            this.f3995a = view;
        }

        public void run() {
            this.f3995a.getBackground().setColorFilter(null);
        }
    }

    /* renamed from: com.tinder.activities.CameraActivity.7 */
    class C23177 implements C2316c {
        final /* synthetic */ CameraActivity f3997a;

        C23177(CameraActivity cameraActivity) {
            this.f3997a = cameraActivity;
        }

        public void m6292a(@Nullable Object obj) {
            C3095y.m9469a();
            if (this.f3997a.f4001A) {
                this.f3997a.f4009i = (Camera) obj;
                if (this.f3997a.f4009i != null) {
                    this.f3997a.m6329h();
                    return;
                }
                Toast.makeText(this.f3997a, R.string.camera_not_available, 1).show();
                this.f3997a.finish();
            }
        }
    }

    /* renamed from: com.tinder.activities.CameraActivity.8 */
    class C23198 implements C2318a {
        final /* synthetic */ int f3998a;
        final /* synthetic */ CameraActivity f3999b;

        C23198(CameraActivity cameraActivity, int i) {
            this.f3999b = cameraActivity;
            this.f3998a = i;
        }

        @Nullable
        public Object m6294a() {
            C3095y.m9469a();
            try {
                return Camera.open(this.f3998a);
            } catch (Throwable e) {
                C3095y.m9474a("Failed to open camera service, likely another process is using the camera", e);
                return null;
            }
        }
    }

    /* renamed from: com.tinder.activities.CameraActivity.9 */
    class C23209 implements AutoFocusMoveCallback {
        final /* synthetic */ CameraActivity f4000a;

        C23209(CameraActivity cameraActivity) {
            this.f4000a = cameraActivity;
        }

        public void onAutoFocusMoving(boolean z, Camera camera) {
            if (!z) {
                if (this.f4000a.f4024x == null) {
                    this.f4000a.m6317b(true);
                }
                this.f4000a.f4024x = null;
            } else if (this.f4000a.f4024x != null) {
                this.f4000a.m6315b(this.f4000a.f4024x);
            } else {
                this.f4000a.m6315b(this.f4000a.m6326g());
            }
        }
    }

    public CameraActivity() {
        this.f4011k = "off";
        this.f4016p = CameraIndex.REAR_FACING.ordinal();
        this.f4022v = new Handler();
    }

    public static Bitmap m6298a(@NonNull Bitmap bitmap, float f) {
        Matrix matrix = new Matrix();
        matrix.postRotate(f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    @SuppressLint({"NewApi"})
    public void onCreate(Bundle bundle) {
        boolean z = true;
        super.onCreate(bundle);
        C3095y.m9469a();
        getWindow().setFormat(-3);
        getWindow().setFlags(1152, 1152);
        setRequestedOrientation(1);
        setContentView(R.layout.view_camera);
        this.f4017q = getResources().getDimensionPixelSize(R.dimen.crosshair_length);
        if (Camera.getNumberOfCameras() <= 1) {
            z = false;
        }
        this.f4015o = z;
        this.f4020t = getResources().getDimensionPixelOffset(R.dimen.options_y_offset);
        this.f4002a = (RelativeLayout) findViewById(R.id.relative);
        this.f4003b = (SurfaceView) findViewById(R.id.surface);
        this.f4004c = this.f4003b.getHolder();
        this.f4004c.addCallback(this);
        this.f4021u = new GestureDetector(this, new C23081(this));
        this.f4003b.setOnTouchListener(new C23134(this));
        if (VERSION.SDK_INT < 14) {
            this.f4004c.setType(3);
        }
        View findViewById = findViewById(R.id.btn_shoot);
        al.m9287b(findViewById);
        findViewById.setOnClickListener(this);
        this.f4003b.post(new C23145(this, findViewById));
        this.f4006f = (ImageView) findViewById(R.id.btn_camera_options);
        al.m9287b(this.f4006f);
        this.f4006f.setOnClickListener(this);
        this.f4007g = (RoundImageView) findViewById(R.id.btn_gallery);
        this.f4007g.setOnClickListener(this);
        m6336l();
        m5908T();
        C2807a.m8058a("Moments.Create");
    }

    public void onPause() {
        C3095y.m9469a();
        this.f4001A = false;
        if (this.f4009i != null) {
            this.f4009i.release();
            this.f4009i = null;
        }
        this.f4013m = true;
        al.m9297c(this.f4008h);
        ManagerApp.m7926q().m8468b();
        if (this.f4023w != null) {
            this.f4022v.removeCallbacks(this.f4023w);
        }
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f4001A = true;
        C3095y.m9469a();
        ManagerApp.m7926q().m8453a();
    }

    private void m6306a(int i, int i2) {
        if (this.f4009i != null && this.f4009i.getParameters() != null) {
            this.f4008h = new C2453a(this, this, this.f4014n, this.f4015o, this.f4009i.getParameters().getSupportedFlashModes(), this.f4011k, this.f4016p, i, i2);
            this.f4008h.show();
        }
    }

    @SuppressLint({"NewApi"})
    private void m6325f() {
        int i = 0;
        if (this.f4016p + 1 < Camera.getNumberOfCameras()) {
            this.f4016p++;
        } else {
            this.f4016p = 0;
        }
        if (this.f4009i != null) {
            this.f4009i.release();
            this.f4009i = null;
        }
        this.f4025y = null;
        this.f4026z = null;
        this.f4011k = "off";
        m6305a(this.f4016p);
        if (this.f4016p != 0) {
            i = 1;
        }
        SparksEvent sparksEvent = new SparksEvent("Moments.SwitchCamera");
        sparksEvent.put("camera", Integer.valueOf(i));
        C2807a.m8056a(sparksEvent);
    }

    @SuppressLint({"NewApi"})
    public void m6342a(@NonNull Rect rect) {
        int width = ((rect.left * 2000) / this.f4003b.getWidth()) - 1000;
        int height = ((rect.top * 2000) / this.f4003b.getHeight()) - 1000;
        int width2 = ((rect.right * 2000) / this.f4003b.getWidth()) - 1000;
        int height2 = ((rect.bottom * 2000) / this.f4003b.getHeight()) - 1000;
        if (width == width2) {
            width2 += 10;
        }
        if (height == height2) {
            height2 += 10;
        }
        if (width >= -1000 && height2 >= -1000 && width2 <= LocationStatusCodes.GEOFENCE_NOT_AVAILABLE && height <= LocationStatusCodes.GEOFENCE_NOT_AVAILABLE) {
            this.f4024x = rect;
            m6315b(rect);
            Rect rect2 = new Rect(width, height, width2, height2);
            C3095y.m9471a("touchRect " + rect + " targetFocusRect " + rect2);
            List arrayList = new ArrayList();
            arrayList.add(new Area(rect2, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE));
            Parameters parameters = this.f4009i.getParameters();
            if (parameters.getMaxNumFocusAreas() > 0) {
                parameters.setFocusAreas(arrayList);
                parameters.setMeteringAreas(arrayList);
                this.f4009i.setParameters(parameters);
                this.f4009i.cancelAutoFocus();
                this.f4009i.autoFocus(this);
            }
        }
    }

    @NonNull
    private Rect m6326g() {
        Point b = al.m9286b((Activity) this);
        int i = b.x / 2;
        int i2 = b.y / 2;
        Rect rect = new Rect();
        rect.left = i;
        rect.right = i + this.f4017q;
        rect.top = i2;
        rect.bottom = i2 + this.f4017q;
        return rect;
    }

    private void m6315b(@NonNull Rect rect) {
        if (this.f4005e == null) {
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f4017q, this.f4017q);
            layoutParams.leftMargin = rect.left - (this.f4017q / 2);
            layoutParams.topMargin = rect.top - (this.f4017q / 2);
            Point b = al.m9286b((Activity) this);
            if (layoutParams.leftMargin < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.f4017q > b.x) {
                layoutParams.leftMargin -= (layoutParams.leftMargin + this.f4017q) - b.x;
            }
            if (layoutParams.topMargin < 0) {
                layoutParams.topMargin = 0;
            }
            if (layoutParams.topMargin + this.f4017q > b.y) {
                layoutParams.topMargin -= (layoutParams.topMargin - layoutParams.topMargin) + this.f4017q;
            }
            View view = new View(this);
            view.setBackgroundResource(R.drawable.camerafocusing_icon);
            view.post(new C23156(this, view));
            this.f4002a.addView(view, layoutParams);
            this.f4005e = view;
            m6333j();
        }
    }

    private void m6305a(int i) {
        C3095y.m9471a("cameraIndex=" + i);
        if (this.f4009i == null) {
            this.f4013m = false;
            if (checkCallingOrSelfPermission("android.permission.CAMERA") != 0) {
                Toast.makeText(this, R.string.error_camera_permission, 0).show();
                finish();
                return;
            }
            C3064c.m9336a(new C23198(this, i)).m9340a(new C23177(this)).m9341a();
            return;
        }
        C3095y.m9471a("Camera already obtained");
    }

    private Size m6299a(@NonNull List<Size> list, int i, int i2) {
        for (Size size : list) {
            if (size.width == i && size.height == i2) {
                return size;
            }
        }
        return null;
    }

    private void m6329h() {
        int i;
        C3095y.m9471a("MODEL IS " + Build.MODEL);
        Parameters parameters = this.f4009i.getParameters();
        parameters.setJpegQuality(80);
        Point b = al.m9286b((Activity) this);
        List supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        List supportedPictureSizes = parameters.getSupportedPictureSizes();
        if ("DROIDX".equals(Build.MODEL)) {
            this.f4025y = (Size) supportedPreviewSizes.get(5);
            this.f4026z = (Size) supportedPreviewSizes.get(1);
        } else if ("Nexus 4".equals(Build.MODEL)) {
            i = 1280;
            int i2 = 720;
            if (this.f4016p != CameraIndex.REAR_FACING.ordinal()) {
                i = 800;
                i2 = 480;
            }
            this.f4025y = m6299a(supportedPreviewSizes, i, i2);
            this.f4026z = m6299a(supportedPictureSizes, i, i2);
        }
        if (this.f4026z == null || this.f4025y == null) {
            i = b.x;
            int i3 = b.y;
            C3095y.m9471a("getting optimal picture size");
            this.f4026z = m6300a(supportedPictureSizes, i, i3, 0.15d);
            C3095y.m9471a("getting optimal preview size");
            this.f4025y = m6300a(supportedPreviewSizes, i, i3, 0.15d);
        }
        C3095y.m9471a("optimal picture size: " + this.f4026z.width + ' ' + this.f4026z.height);
        C3095y.m9471a("optimal preview size: " + this.f4025y.width + ' ' + this.f4025y.height);
        parameters.setPictureSize(this.f4026z.width, this.f4026z.height);
        parameters.setPreviewSize(this.f4025y.width, this.f4025y.height);
        if (parameters.getSupportedFlashModes() == null || parameters.getSupportedFlashModes().size() <= 0) {
            this.f4014n = false;
        } else {
            this.f4014n = true;
        }
        if (VERSION.SDK_INT < 14) {
            parameters.set("orientation", "portrait");
            parameters.set("rotation", 90);
        }
        if (parameters.getSupportedFocusModes() != null && parameters.getSupportedFocusModes().contains("continuous-picture")) {
            parameters.setFocusMode("continuous-picture");
            if (VERSION.SDK_INT >= 16) {
                this.f4009i.setAutoFocusMoveCallback(new C23209(this));
            }
        }
        this.f4009i.setDisplayOrientation(90);
        this.f4009i.setParameters(parameters);
        m6316b(this.f4011k);
        m6331i();
    }

    private void m6331i() {
        C3095y.m9469a();
        try {
            this.f4009i.setPreviewDisplay(this.f4004c);
            this.f4009i.startPreview();
        } catch (Exception e) {
            C3095y.m9479c(String.valueOf(e));
            if (this.f4009i != null) {
                this.f4009i.release();
                this.f4009i = null;
            }
            finish();
        }
    }

    private Size m6300a(@Nullable List<Size> list, int i, int i2, double d) {
        double d2 = ((double) i2) / ((double) i);
        if (list == null) {
            C3095y.m9476b("No pictureSizes sent in");
            return null;
        }
        Size size;
        Size size2;
        Size size3 = null;
        int i3 = 0;
        for (Size size4 : list) {
            int i4 = size4.height;
            int i5 = size4.width;
            C3095y.m9471a(i5 + "x" + i4);
            if (Math.abs((((double) i5) / ((double) i4)) - d2) <= d) {
                if (m6312a(size4)) {
                    size = size4;
                    break;
                }
                int i6;
                if (i4 >= LocationStatusCodes.GEOFENCE_NOT_AVAILABLE || i4 <= i3) {
                    i6 = i3;
                    size2 = size3;
                } else {
                    int i7 = i4;
                    size2 = size4;
                    i6 = i7;
                }
                i3 = i6;
                size3 = size2;
            }
        }
        size = size3;
        if (size != null) {
            return size;
        }
        size2 = size;
        double d3 = Double.MAX_VALUE;
        for (Size size42 : list) {
            double d4;
            int i8 = size42.height;
            C3095y.m9471a(size42.width + "x" + i8);
            i8 = Math.abs(i8 - i2);
            if (((double) i8) < d3) {
                size = size42;
                d4 = (double) i8;
            } else {
                double d5 = d3;
                size = size2;
                d4 = d5;
            }
            size2 = size;
            d3 = d4;
        }
        return size2;
    }

    private boolean m6312a(@NonNull Size size) {
        if (size.height < 720 || size.height > LocationStatusCodes.GEOFENCE_NOT_AVAILABLE) {
            return false;
        }
        return true;
    }

    private void m6316b(@Nullable String str) {
        C3095y.m9471a("flash mode to set " + str);
        if (str != null) {
            Parameters parameters = this.f4009i.getParameters();
            parameters.setFlashMode(str);
            this.f4009i.setParameters(parameters);
            this.f4011k = str;
            if ("auto".equals(str)) {
                this.f4006f.setImageResource(R.drawable.settingstoggle_withautoflash_icon);
            } else if ("on".equals(str)) {
                this.f4006f.setImageResource(R.drawable.settingstoggle_withflash_icon);
            } else {
                this.f4006f.setImageResource(R.drawable.settingstoggle_icon);
            }
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        C3095y.m9469a();
        if (this.f4009i == null) {
            m6305a(this.f4016p);
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        C3095y.m9469a();
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        C3095y.m9469a();
        if (this.f4009i != null) {
            this.f4009i.stopPreview();
            this.f4009i.release();
            this.f4009i = null;
        }
    }

    public void onPictureTaken(@NonNull byte[] bArr, Camera camera) {
        C3095y.m9471a("number of bytes returned by camera " + bArr.length);
        try {
            System.gc();
            String a = C3075l.m9387a(bArr, this, 100, this.f4016p, 90);
            if (a != null) {
                m6310a(a, null, true);
            }
            new Handler().postDelayed(new Runnable() {
                final /* synthetic */ CameraActivity f3984a;

                {
                    this.f3984a = r1;
                }

                public void run() {
                    this.f3984a.f4012l = false;
                }
            }, 500);
        } catch (OutOfMemoryError e) {
            C3095y.m9479c(String.valueOf(e));
            Toast.makeText(this, R.string.error_taking_pic, 1).show();
            this.f4012l = false;
            m6331i();
        }
    }

    public void onShutter() {
        C3095y.m9469a();
    }

    public void m6344e() {
        C3095y.m9469a();
        if (this.f4009i != null) {
            m6325f();
        }
    }

    public void m6343a(String str) {
        if (this.f4009i != null) {
            m6316b(str);
        }
    }

    private void m6311a(boolean z) {
        if (this.f4005e != null) {
            if (this.f4010j != null) {
                this.f4010j.cancel();
            }
            m6317b(z);
        }
    }

    public void onAutoFocus(boolean z, @NonNull Camera camera) {
        C3095y.m9471a("autofocus returned " + z);
        camera.cancelAutoFocus();
        m6311a(z);
        if (camera.getParameters().getSupportedFocusModes().contains("continuous-picture")) {
            this.f4023w = new Runnable() {
                final /* synthetic */ CameraActivity f3985a;

                {
                    this.f3985a = r1;
                }

                public void run() {
                    this.f3985a.f4024x = null;
                    this.f3985a.f4009i.getParameters().setFocusMode("continuous-picture");
                }
            };
            this.f4022v.postDelayed(this.f4023w, 5000);
        }
    }

    private void m6333j() {
        this.f4010j = ObjectAnimator.ofFloat(this.f4005e, "rotation", new float[]{0.0f, BitmapDescriptorFactory.HUE_YELLOW});
        this.f4010j.setDuration(600);
        this.f4010j.setInterpolator(new DecelerateInterpolator());
        this.f4010j.start();
    }

    private void m6317b(boolean z) {
        if (this.f4005e != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f4005e, "rotation", new float[]{BitmapDescriptorFactory.HUE_YELLOW, 0.0f});
            ofFloat.setDuration(200);
            ofFloat.addListener(new C23102(this, z));
            ofFloat.start();
        }
    }

    public void onClick(@NonNull View view) {
        switch (view.getId()) {
            case R.id.btn_shoot:
                if (this.f4009i != null && !this.f4012l) {
                    C3095y.m9471a("processing pic: " + this.f4012l);
                    this.f4012l = true;
                    this.f4009i.takePicture(null, null, this);
                    SparksEvent sparksEvent = new SparksEvent("Moments.Capture");
                    sparksEvent.put("camera", Integer.valueOf(this.f4016p));
                    C2807a.m8056a(sparksEvent);
                }
            case R.id.btn_gallery:
                C3095y.m9471a("launch gallery");
                m6334k();
                C2807a.m8058a("Moments.OpenCameraRoll");
            case R.id.btn_camera_options:
                if (this.f4008h == null || !this.f4008h.isShowing()) {
                    m6306a(this.f4018r, this.f4019s);
                } else {
                    this.f4008h.dismiss();
                }
            default:
        }
    }

    private void m6334k() {
        startActivityForResult(new Intent("android.intent.action.PICK", Media.EXTERNAL_CONTENT_URI), 1);
    }

    public void onActivityResult(int i, int i2, @NonNull Intent intent) {
        super.onActivityResult(i, i2, intent);
        C3095y.m9469a();
        if (i2 == 80085) {
            finish();
        }
        if (i != 1) {
            return;
        }
        if (i2 == -1) {
            C3095y.m9471a("result from gallery pick");
            Uri data = intent.getData();
            String a = m6304a(data);
            C3095y.m9471a("imgPath = " + a);
            C2807a.m8056a(m6322d(a));
            m6310a(a, data, false);
            return;
        }
        C2807a.m8058a("Moments.CloseCameraRoll");
    }

    private String m6304a(@NonNull Uri uri) {
        Cursor query = getContentResolver().query(uri, null, null, null, null);
        if (query == null || query.getColumnIndex("_data") == -1) {
            return uri.getPath();
        }
        query.moveToFirst();
        String string = query.getString(query.getColumnIndex("_data"));
        query.close();
        return string;
    }

    private void m6336l() {
        Cursor query = getContentResolver().query(Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "_data", "bucket_display_name", "datetaken", "mime_type"}, null, null, "datetaken DESC");
        if (query != null && query.moveToFirst()) {
            String string = query.getString(1);
            File file = new File(string);
            if (file.exists()) {
                Picasso.m8982a((Context) this).m8989a(file).m9121a((int) R.dimen.camera_gallery_size, (int) R.dimen.camera_gallery_size).m9127b().m9125a(this.f4007g, new C23123(this, string));
            }
        }
    }

    private void m6310a(String str, @Nullable Uri uri, boolean z) {
        Intent intent = new Intent(this, ActivityEditMoment.class);
        intent.putExtra(z ? "captured_photo_path" : "gallery_photo_path", str);
        intent.putExtra("captured_camera_index", z ? this.f4016p : -1);
        if (uri != null) {
            intent.putExtra("gallery_photo_uri", uri);
        }
        intent.setFlags(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        startActivityForResult(intent, 0);
    }

    @NonNull
    private SparksEvent m6322d(String str) {
        SparksEvent sparksEvent = new SparksEvent("Moments.CameraRollSelect");
        try {
            ExifInterface exifInterface = new ExifInterface(str);
            float[] fArr = new float[2];
            exifInterface.getLatLong(fArr);
            String attribute = exifInterface.getAttribute("DateTime");
            C3095y.m9471a(String.format("coords [%s, %s] datetime [%s]", new Object[]{Float.valueOf(fArr[0]), Float.valueOf(fArr[1]), attribute}));
            float f = fArr[0];
            float f2 = fArr[1];
            if (!(((double) f) == 0.0d || ((double) f2) == 0.0d)) {
                sparksEvent.put("photoLat", Float.valueOf(f));
                sparksEvent.put("photoLon", Float.valueOf(f2));
            }
            if (!TextUtils.isEmpty(attribute)) {
                sparksEvent.put("photoTimestamp", Long.valueOf(C3070i.m9362a(attribute)));
            }
        } catch (Exception e) {
            C3095y.m9471a(e.getMessage());
        }
        return sparksEvent;
    }

    public void onBackPressed() {
        C3095y.m9469a();
        C2807a.m8058a("Moments.CancelCreate");
        super.onBackPressed();
    }
}
