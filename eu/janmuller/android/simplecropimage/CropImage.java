package eu.janmuller.android.simplecropimage;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.FaceDetector;
import android.media.FaceDetector.Face;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.StatFs;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import com.facebook.stetho.BuildConfig;
import com.google.android.gms.location.places.Place;
import eu.janmuller.android.simplecropimage.BitmapManager.C3171a;
import eu.janmuller.android.simplecropimage.C3188a.C3185b;
import eu.janmuller.android.simplecropimage.C3188a.C3186c;
import eu.janmuller.android.simplecropimage.C3188a.C3187d;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.CountDownLatch;

public class CropImage extends MonitoredActivity {
    final int f6803a;
    boolean f6804b;
    boolean f6805c;
    HighlightView f6806d;
    Runnable f6807e;
    private CompressFormat f6808f;
    private Uri f6809g;
    private boolean f6810h;
    private final Handler f6811i;
    private int f6812j;
    private int f6813k;
    private int f6814l;
    private int f6815m;
    private CropImageView f6816n;
    private ContentResolver f6817o;
    private Bitmap f6818p;
    private String f6819q;
    private boolean f6820r;
    private final C3171a f6821s;

    /* renamed from: eu.janmuller.android.simplecropimage.CropImage.1 */
    class C31731 implements OnClickListener {
        final /* synthetic */ CropImage f6790a;

        C31731(CropImage cropImage) {
            this.f6790a = cropImage;
        }

        public void onClick(View view) {
            this.f6790a.setResult(0);
            this.f6790a.finish();
        }
    }

    /* renamed from: eu.janmuller.android.simplecropimage.CropImage.2 */
    class C31742 implements OnClickListener {
        final /* synthetic */ CropImage f6791a;

        C31742(CropImage cropImage) {
            this.f6791a = cropImage;
        }

        public void onClick(View view) {
            try {
                this.f6791a.m9555b();
            } catch (Exception e) {
                this.f6791a.finish();
            }
        }
    }

    /* renamed from: eu.janmuller.android.simplecropimage.CropImage.3 */
    class C31763 implements Runnable {
        final /* synthetic */ CropImage f6795a;

        /* renamed from: eu.janmuller.android.simplecropimage.CropImage.3.1 */
        class C31751 implements Runnable {
            final /* synthetic */ Bitmap f6792a;
            final /* synthetic */ CountDownLatch f6793b;
            final /* synthetic */ C31763 f6794c;

            C31751(C31763 c31763, Bitmap bitmap, CountDownLatch countDownLatch) {
                this.f6794c = c31763;
                this.f6792a = bitmap;
                this.f6793b = countDownLatch;
            }

            public void run() {
                if (!(this.f6792a == this.f6794c.f6795a.f6818p || this.f6792a == null)) {
                    this.f6794c.f6795a.f6816n.m9571a(this.f6792a, true);
                    this.f6794c.f6795a.f6818p.recycle();
                    this.f6794c.f6795a.f6818p = this.f6792a;
                }
                if (this.f6794c.f6795a.f6816n.m9564a() == 1.0f) {
                    this.f6794c.f6795a.f6816n.m9573a(true, true);
                }
                this.f6793b.countDown();
            }
        }

        C31763(CropImage cropImage) {
            this.f6795a = cropImage;
        }

        public void run() {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.f6795a.f6811i.post(new C31751(this, this.f6795a.f6818p, countDownLatch));
            try {
                countDownLatch.await();
                this.f6795a.f6807e.run();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* renamed from: eu.janmuller.android.simplecropimage.CropImage.4 */
    class C31784 implements Runnable {
        float f6797a;
        Matrix f6798b;
        Face[] f6799c;
        int f6800d;
        final /* synthetic */ CropImage f6801e;

        /* renamed from: eu.janmuller.android.simplecropimage.CropImage.4.1 */
        class C31771 implements Runnable {
            final /* synthetic */ C31784 f6796a;

            C31771(C31784 c31784) {
                this.f6796a = c31784;
            }

            public void run() {
                boolean z;
                CropImage cropImage = this.f6796a.f6801e;
                if (this.f6796a.f6800d > 1) {
                    z = true;
                } else {
                    z = false;
                }
                cropImage.f6804b = z;
                if (this.f6796a.f6800d > 0) {
                    for (int i = 0; i < this.f6796a.f6800d; i++) {
                        this.f6796a.m9540a(this.f6796a.f6799c[i]);
                    }
                } else {
                    this.f6796a.m9539a();
                }
                this.f6796a.f6801e.f6816n.invalidate();
                if (this.f6796a.f6801e.f6816n.f6837a.size() == 1) {
                    this.f6796a.f6801e.f6806d = (HighlightView) this.f6796a.f6801e.f6816n.f6837a.get(0);
                    this.f6796a.f6801e.f6806d.m9590a(true);
                }
                if (this.f6796a.f6800d > 1) {
                    Toast.makeText(this.f6796a.f6801e, "Multi face crop help", 0).show();
                }
            }
        }

        C31784(CropImage cropImage) {
            this.f6801e = cropImage;
            this.f6797a = 1.0f;
            this.f6799c = new Face[3];
        }

        private void m9540a(Face face) {
            boolean z;
            PointF pointF = new PointF();
            int eyesDistance = ((int) (face.eyesDistance() * this.f6797a)) * 2;
            face.getMidPoint(pointF);
            pointF.x *= this.f6797a;
            pointF.y *= this.f6797a;
            int i = (int) pointF.x;
            int i2 = (int) pointF.y;
            HighlightView highlightView = new HighlightView(this.f6801e.f6816n);
            Rect rect = new Rect(0, 0, this.f6801e.f6818p.getWidth(), this.f6801e.f6818p.getHeight());
            RectF rectF = new RectF((float) i, (float) i2, (float) i, (float) i2);
            rectF.inset((float) (-eyesDistance), (float) (-eyesDistance));
            if (rectF.left < 0.0f) {
                rectF.inset(-rectF.left, -rectF.left);
            }
            if (rectF.top < 0.0f) {
                rectF.inset(-rectF.top, -rectF.top);
            }
            if (rectF.right > ((float) rect.right)) {
                rectF.inset(rectF.right - ((float) rect.right), rectF.right - ((float) rect.right));
            }
            if (rectF.bottom > ((float) rect.bottom)) {
                rectF.inset(rectF.bottom - ((float) rect.bottom), rectF.bottom - ((float) rect.bottom));
            }
            Matrix matrix = this.f6798b;
            if (this.f6801e.f6812j == 0 || this.f6801e.f6813k == 0) {
                z = false;
            } else {
                z = true;
            }
            highlightView.m9588a(matrix, rect, rectF, false, z);
            this.f6801e.f6816n.m9582a(highlightView);
        }

        private void m9539a() {
            int i;
            int i2;
            boolean z;
            HighlightView highlightView = new HighlightView(this.f6801e.f6816n);
            int width = this.f6801e.f6818p.getWidth();
            int height = this.f6801e.f6818p.getHeight();
            Rect rect = new Rect(0, 0, width, height);
            int min = (Math.min(width, height) * 4) / 5;
            if (this.f6801e.f6812j == 0 || this.f6801e.f6813k == 0) {
                i = min;
                i2 = min;
            } else if (this.f6801e.f6812j > this.f6801e.f6813k) {
                i = (this.f6801e.f6813k * min) / this.f6801e.f6812j;
                i2 = min;
            } else {
                i2 = (this.f6801e.f6812j * min) / this.f6801e.f6813k;
                i = min;
            }
            width = (width - i2) / 2;
            height = (height - i) / 2;
            RectF rectF = new RectF((float) width, (float) height, (float) (i2 + width), (float) (i + height));
            Matrix matrix = this.f6798b;
            if (this.f6801e.f6812j == 0 || this.f6801e.f6813k == 0) {
                z = false;
            } else {
                z = true;
            }
            highlightView.m9588a(matrix, rect, rectF, false, z);
            this.f6801e.f6816n.f6837a.clear();
            this.f6801e.f6816n.m9582a(highlightView);
        }

        private Bitmap m9543b() {
            if (this.f6801e.f6818p == null) {
                return null;
            }
            if (this.f6801e.f6818p.getWidth() > AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY) {
                this.f6797a = 256.0f / ((float) this.f6801e.f6818p.getWidth());
            }
            Matrix matrix = new Matrix();
            matrix.setScale(this.f6797a, this.f6797a);
            return Bitmap.createBitmap(this.f6801e.f6818p, 0, 0, this.f6801e.f6818p.getWidth(), this.f6801e.f6818p.getHeight(), matrix, true);
        }

        public void run() {
            this.f6798b = this.f6801e.f6816n.getImageMatrix();
            Bitmap b = m9543b();
            this.f6797a = 1.0f / this.f6797a;
            if (b != null && this.f6801e.f6810h) {
                this.f6800d = new FaceDetector(b.getWidth(), b.getHeight(), this.f6799c.length).findFaces(b, this.f6799c);
            }
            if (!(b == null || b == this.f6801e.f6818p)) {
                b.recycle();
            }
            this.f6801e.f6811i.post(new C31771(this));
        }
    }

    public CropImage() {
        this.f6803a = Place.TYPE_SUBLOCALITY_LEVEL_2;
        this.f6808f = CompressFormat.JPEG;
        this.f6809g = null;
        this.f6810h = true;
        this.f6811i = new Handler();
        this.f6812j = 1;
        this.f6813k = 1;
        this.f6820r = false;
        this.f6821s = new C3171a();
        this.f6807e = new C31784(this);
    }

    public void onCreate(Bundle bundle) {
        int i = 0;
        super.onCreate(bundle);
        Log.d("Tinder", "ENTER");
        this.f6817o = getContentResolver();
        setContentView(C3186c.cropimage);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
        this.f6816n = (CropImageView) findViewById(C3185b.image);
        m9549a((Activity) this);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f6819q = extras.getString("image-path");
            Log.d("Tinder", "mImagePath=" + this.f6819q);
            this.f6809g = m9547a(this.f6819q);
            this.f6818p = m9554b(this.f6819q);
            this.f6814l = extras.getInt("outputX");
            this.f6815m = extras.getInt("outputY");
            this.f6820r = extras.getBoolean("scaleUpIfNeeded", false);
            Log.d("Tinder", "mOutputX=" + this.f6814l);
            Log.d("Tinder", "mOutputY=" + this.f6815m);
            Log.d("Tinder", "mScaleUp=" + this.f6820r);
        }
        if (this.f6818p == null) {
            Log.d("Tinder", "finish!!!");
            finish();
            return;
        }
        int intExtra;
        getWindow().addFlags(Place.TYPE_SUBLOCALITY_LEVEL_2);
        Button button = (Button) findViewById(C3185b.discard);
        button.setOnClickListener(new C31731(this));
        Button button2 = (Button) findViewById(C3185b.save);
        button2.setOnClickListener(new C31742(this));
        if (getIntent() != null) {
            intExtra = getIntent().getIntExtra("cancel res id", 0);
            i = getIntent().getIntExtra("save res id", 0);
        } else {
            intExtra = 0;
        }
        button.setText(intExtra);
        button2.setText(i);
        m9548a();
    }

    private Uri m9547a(String str) {
        return Uri.fromFile(new File(str));
    }

    private Bitmap m9554b(String str) {
        int i = 1;
        Uri a = m9547a(str);
        try {
            InputStream openInputStream = this.f6817o.openInputStream(a);
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(openInputStream, null, options);
            openInputStream.close();
            if (options.outHeight > Place.TYPE_SUBLOCALITY_LEVEL_2 || options.outWidth > Place.TYPE_SUBLOCALITY_LEVEL_2) {
                i = (int) Math.pow(2.0d, (double) ((int) Math.round(Math.log(1024.0d / ((double) Math.max(options.outHeight, options.outWidth))) / Math.log(0.5d))));
            }
            Options options2 = new Options();
            options2.inSampleSize = i;
            InputStream openInputStream2 = this.f6817o.openInputStream(a);
            Bitmap decodeStream = BitmapFactory.decodeStream(openInputStream2, null, options2);
            openInputStream2.close();
            return decodeStream;
        } catch (FileNotFoundException e) {
            Log.e("Tinder", "file " + str + " not found");
            return null;
        } catch (IOException e2) {
            Log.e("Tinder", "file " + str + " not found");
            return null;
        }
    }

    private void m9548a() {
        Log.e("Tinder", "startFaceDetection");
        if (!isFinishing()) {
            this.f6816n.m9571a(this.f6818p, true);
            C3192c.m9620a(this, null, "Please wait\u2026", new C31763(this), this.f6811i);
        }
    }

    private void m9555b() throws Exception {
        Log.e("Tinder", "onSaveClicked");
        if (!this.f6805c && this.f6806d != null) {
            this.f6805c = true;
            Rect b = this.f6806d.m9592b();
            RectF d = this.f6806d.m9597d();
            float width = (float) b.width();
            float height = (float) b.height();
            float f = (float) b.left;
            float f2 = (float) b.top;
            float width2 = d.width();
            float height2 = d.height();
            Log.e("Tinder", "rect=" + b);
            Intent intent = new Intent();
            intent.putExtra("rect_crop_x", f);
            intent.putExtra("rect_crop_y", f2);
            intent.putExtra("rect_crop_width", width);
            intent.putExtra("rect_crop_height", height);
            intent.putExtra("image_width", width2);
            intent.putExtra("image_height", height2);
            setResult(-1, intent);
            finish();
        }
    }

    protected void onPause() {
        super.onPause();
        BitmapManager.m9535a().m9537a(this.f6821s);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.f6818p != null) {
            this.f6818p.recycle();
        }
    }

    public static void m9549a(Activity activity) {
        m9550a(activity, m9552b(activity));
    }

    public static void m9550a(Activity activity, int i) {
        CharSequence charSequence = null;
        if (i == -1) {
            if (Environment.getExternalStorageState().equals("checking")) {
                charSequence = activity.getString(C3187d.preparing_card);
            } else {
                charSequence = activity.getString(C3187d.no_storage_card);
            }
        } else if (i < 1) {
            charSequence = activity.getString(C3187d.not_enough_space);
        }
        if (charSequence != null) {
            Toast.makeText(activity, charSequence, 5000).show();
        }
    }

    public static int m9552b(Activity activity) {
        try {
            String str = BuildConfig.FLAVOR;
            if ("mounted".equals(Environment.getExternalStorageState())) {
                str = Environment.getExternalStorageDirectory().toString();
            } else {
                str = activity.getFilesDir().toString();
            }
            StatFs statFs = new StatFs(str);
            return (int) ((((float) statFs.getAvailableBlocks()) * ((float) statFs.getBlockSize())) / 400000.0f);
        } catch (Exception e) {
            return -2;
        }
    }
}
