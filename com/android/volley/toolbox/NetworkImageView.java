package com.android.volley.toolbox;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.media.ThumbnailUtils;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.C0333g.C0312d;
import com.android.volley.toolbox.C0333g.C0332c;
import com.facebook.stetho.BuildConfig;

public class NetworkImageView extends ImageView {
    private String f277a;
    private int f278b;
    private int f279c;
    private C0333g f280d;
    private C0332c f281e;
    private boolean f282f;
    private C0315b f283g;

    /* renamed from: com.android.volley.toolbox.NetworkImageView.1 */
    class C03131 implements C0312d {
        final /* synthetic */ boolean f273a;
        final /* synthetic */ NetworkImageView f274b;

        /* renamed from: com.android.volley.toolbox.NetworkImageView.1.1 */
        class C03111 implements Runnable {
            final /* synthetic */ C0332c f271a;
            final /* synthetic */ C03131 f272b;

            C03111(C03131 c03131, C0332c c0332c) {
                this.f272b = c03131;
                this.f271a = c0332c;
            }

            public void run() {
                this.f272b.m293a(this.f271a, false);
            }
        }

        C03131(NetworkImageView networkImageView, boolean z) {
            this.f274b = networkImageView;
            this.f273a = z;
        }

        public void onErrorResponse(VolleyError volleyError) {
            if (this.f274b.f279c != 0) {
                this.f274b.setImageResource(this.f274b.f279c);
            }
        }

        public void m293a(C0332c c0332c, boolean z) {
            if (z && this.f273a) {
                this.f274b.post(new C03111(this, c0332c));
            } else if (c0332c.m349b() != null) {
                if (!this.f274b.f282f) {
                    this.f274b.setImageBitmap(c0332c.m349b());
                } else if (VERSION.SDK_INT >= 11) {
                    new C0314a(this.f274b, c0332c.m349b()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                } else {
                    new C0314a(this.f274b, c0332c.m349b()).execute(new Void[0]);
                }
            } else if (this.f274b.f278b != 0) {
                this.f274b.setImageResource(this.f274b.f278b);
            }
        }
    }

    /* renamed from: com.android.volley.toolbox.NetworkImageView.a */
    class C0314a extends AsyncTask<Void, Void, Bitmap> {
        final /* synthetic */ NetworkImageView f275a;
        private Bitmap f276b;

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m294a((Void[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m295a((Bitmap) obj);
        }

        protected C0314a(NetworkImageView networkImageView, Bitmap bitmap) {
            this.f275a = networkImageView;
            this.f276b = null;
            this.f276b = bitmap;
        }

        protected Bitmap m294a(Void... voidArr) {
            if (this.f276b.isRecycled()) {
                return null;
            }
            try {
                this.f276b = ThumbnailUtils.extractThumbnail(this.f276b, this.f275a.getWidth(), this.f275a.getHeight(), 2);
                return this.f276b;
            } catch (OutOfMemoryError e) {
                return null;
            } catch (RuntimeException e2) {
                Log.e("NetworkImageView", BuildConfig.FLAVOR + e2);
                return null;
            }
        }

        protected void m295a(Bitmap bitmap) {
            if (bitmap != null) {
                this.f275a.setImageBitmap(this.f276b);
            }
        }
    }

    /* renamed from: com.android.volley.toolbox.NetworkImageView.b */
    public interface C0315b {
        void m296a();
    }

    public NetworkImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NetworkImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setDefaultImageResId(int i) {
        this.f278b = i;
    }

    public void setErrorImageResId(int i) {
        this.f279c = i;
    }

    private void m298a(boolean z) {
        int width = getWidth();
        int height = getHeight();
        if (width != 0 || height != 0) {
            if (TextUtils.isEmpty(this.f277a)) {
                if (this.f281e != null) {
                    this.f281e.m348a();
                    this.f281e = null;
                }
                setImageBitmap(null);
                return;
            }
            if (!(this.f281e == null || this.f281e.m350c() == null)) {
                if (!this.f281e.m350c().equals(this.f277a)) {
                    this.f281e.m348a();
                    setImageBitmap(null);
                } else {
                    return;
                }
            }
            this.f281e = this.f280d.m361a(this.f277a, new C03131(this, z));
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m298a(true);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public void setShouldCrop(boolean z) {
        this.f282f = true;
    }

    public void setListenerNetworkImageLoad(C0315b c0315b) {
        this.f283g = c0315b;
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.f283g != null) {
            this.f283g.m296a();
        }
    }
}
