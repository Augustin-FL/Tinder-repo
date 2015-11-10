package com.tinder.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.media.ThumbnailUtils;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import com.android.volley.VolleyError;
import com.facebook.stetho.BuildConfig;
import com.tinder.utils.C3088r;
import com.tinder.utils.C3088r.C3086c;
import com.tinder.utils.C3088r.C3087d;

public class NetworkImageViewCompat extends ImageView {
    @Nullable
    private AsyncTask mCropTask;
    private int mDefaultImageId;
    private int mErrorImageId;
    @Nullable
    private C3086c mImageContainer;
    private C3088r mImageLoader;
    private ListenerNetworkImageLoad mListenerNetworkImageLoad;
    private boolean mShouldCrop;
    private String mUrl;

    /* renamed from: com.tinder.views.NetworkImageViewCompat.1 */
    class C31251 implements C3087d {
        final /* synthetic */ boolean val$isInLayoutPass;

        /* renamed from: com.tinder.views.NetworkImageViewCompat.1.1 */
        class C31241 implements Runnable {
            final /* synthetic */ C3086c val$response;

            C31241(C3086c c3086c) {
                this.val$response = c3086c;
            }

            public void run() {
                C31251.this.onResponse(this.val$response, false);
            }
        }

        C31251(boolean z) {
            this.val$isInLayoutPass = z;
        }

        public void onErrorResponse(VolleyError volleyError) {
            if (NetworkImageViewCompat.this.mErrorImageId != 0) {
                NetworkImageViewCompat.this.setImageResource(NetworkImageViewCompat.this.mErrorImageId);
            }
        }

        public void onResponse(@NonNull C3086c c3086c, boolean z) {
            if (z && this.val$isInLayoutPass) {
                NetworkImageViewCompat.this.post(new C31241(c3086c));
            } else if (c3086c.m9437b() != null) {
                if (!NetworkImageViewCompat.this.mShouldCrop) {
                    NetworkImageViewCompat.this.setImageBitmap(c3086c.m9437b());
                } else if (VERSION.SDK_INT >= 11) {
                    NetworkImageViewCompat.this.mCropTask = new BitmapCropTask(c3086c.m9437b(), NetworkImageViewCompat.this.mUrl).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                } else {
                    NetworkImageViewCompat.this.mCropTask = new BitmapCropTask(c3086c.m9437b(), NetworkImageViewCompat.this.mUrl).execute(new Void[0]);
                }
            } else if (NetworkImageViewCompat.this.mDefaultImageId != 0) {
                NetworkImageViewCompat.this.setImageResource(NetworkImageViewCompat.this.mDefaultImageId);
            }
        }
    }

    class BitmapCropTask extends AsyncTask<Void, Void, Bitmap> {
        @Nullable
        private Bitmap mBitmapSource;
        @Nullable
        private String mSourceUrl;

        protected BitmapCropTask(Bitmap bitmap, String str) {
            this.mBitmapSource = null;
            this.mSourceUrl = null;
            this.mBitmapSource = bitmap;
            this.mSourceUrl = str;
        }

        @Nullable
        protected Bitmap doInBackground(Void... voidArr) {
            if (this.mBitmapSource.isRecycled()) {
                return null;
            }
            try {
                this.mBitmapSource = ThumbnailUtils.extractThumbnail(this.mBitmapSource, NetworkImageViewCompat.this.getWidth(), NetworkImageViewCompat.this.getHeight(), 0);
                return this.mBitmapSource;
            } catch (OutOfMemoryError e) {
                return null;
            } catch (RuntimeException e2) {
                Log.e("NetworkImageView", BuildConfig.FLAVOR + e2);
                return null;
            }
        }

        protected void onPostExecute(@Nullable Bitmap bitmap) {
            if (bitmap != null && this.mSourceUrl.equals(NetworkImageViewCompat.this.mUrl)) {
                NetworkImageViewCompat.this.setImageBitmap(this.mBitmapSource);
            }
        }
    }

    public interface ListenerNetworkImageLoad {
        void onImageHasLoaded();
    }

    public NetworkImageViewCompat(@NonNull Context context) {
        this(context, null);
    }

    public NetworkImageViewCompat(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NetworkImageViewCompat(@NonNull Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setImageUrl(String str, C3088r c3088r) {
        this.mUrl = str;
        this.mImageLoader = c3088r;
        loadImageIfNecessary(false);
    }

    public void setDefaultImageResId(int i) {
        this.mDefaultImageId = i;
    }

    public void setErrorImageResId(int i) {
        this.mErrorImageId = i;
    }

    private void loadImageIfNecessary(boolean z) {
        int width = getWidth();
        int height = getHeight();
        if (width != 0 || height != 0) {
            if (TextUtils.isEmpty(this.mUrl)) {
                if (this.mImageContainer != null) {
                    this.mImageContainer.m9436a();
                    this.mImageContainer = null;
                }
                if (this.mCropTask != null) {
                    this.mCropTask.cancel(true);
                    this.mCropTask = null;
                }
                setImageBitmap(null);
                return;
            }
            if (!(this.mImageContainer == null || this.mImageContainer.m9438c() == null)) {
                if (!this.mImageContainer.m9438c().equals(this.mUrl)) {
                    this.mImageContainer.m9436a();
                    setImageBitmap(null);
                    if (this.mCropTask != null) {
                        this.mCropTask.cancel(true);
                        this.mCropTask = null;
                    }
                } else {
                    return;
                }
            }
            this.mImageContainer = this.mImageLoader.m9449a(this.mUrl, new C31251(z));
        }
    }

    public void recycleImage() {
        if (this.mImageContainer != null) {
            this.mImageContainer.m9436a();
            setImageBitmap(null);
            this.mImageContainer = null;
        }
        invalidate();
    }

    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        loadImageIfNecessary(true);
    }

    public void setShouldCrop(boolean z) {
        this.mShouldCrop = true;
    }

    public void setListenerNetworkImageLoad(ListenerNetworkImageLoad listenerNetworkImageLoad) {
        this.mListenerNetworkImageLoad = listenerNetworkImageLoad;
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.mListenerNetworkImageLoad != null) {
            this.mListenerNetworkImageLoad.onImageHasLoaded();
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
