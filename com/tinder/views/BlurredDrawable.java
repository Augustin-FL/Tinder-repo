package com.tinder.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import com.tinder.utils.C3095y;

public class BlurredDrawable extends Drawable {
    private static final int ALPHA_MAX = 255;
    private static final int HORIZ_EDGE_OFFSET = 12;
    public static final int MEDIUM_BLUR = 9;
    public static final int SLIGHT_BLUR = 5;
    public static final int SUCH_BLUR = 24;
    private static final int VERT_EDGE_OFFSET = 24;
    private int mAlpha;
    private BitmapWorkerTask mBitmapWorkerTask;
    private int mBlurRadius;
    @Nullable
    private Bitmap mBmpToDraw;
    @NonNull
    private final Rect mCanvasRect;
    @NonNull
    private final Rect mImageRect;
    @NonNull
    private final Paint mPaint;

    class BitmapWorkerTask extends AsyncTask<Void, Void, Bitmap> {
        private final Bitmap mManipulatedBitmap;

        protected BitmapWorkerTask(Bitmap bitmap) {
            this.mManipulatedBitmap = bitmap;
        }

        @Nullable
        protected Bitmap doInBackground(Void... voidArr) {
            if (this.mManipulatedBitmap.isRecycled()) {
                C3095y.m9479c("Bitmap was recycled before blurring");
                return null;
            }
            BlurredDrawable.applyBlur(this.mManipulatedBitmap, BlurredDrawable.this.mBlurRadius);
            return this.mManipulatedBitmap;
        }

        protected void onPostExecute(@Nullable Bitmap bitmap) {
            if (bitmap == null) {
                C3095y.m9479c("Final bitmap was null after processing..must have been recycled.");
                return;
            }
            BlurredDrawable.this.mBmpToDraw = bitmap;
            BlurredDrawable.this.invalidateSelf();
        }
    }

    public BlurredDrawable(Context context) {
        this.mAlpha = ALPHA_MAX;
        this.mPaint = new Paint();
        this.mImageRect = new Rect();
        this.mCanvasRect = new Rect();
    }

    public static void applyBlur(@NonNull Bitmap bitmap, int i) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[(width * height)];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        for (int i2 = i; i2 >= 1; i2 /= 2) {
            for (int i3 = i2; i3 < height - i2; i3++) {
                for (int i4 = i2; i4 < width - i2; i4++) {
                    int i5 = iArr[(((i3 - i2) * width) + i4) - i2];
                    int i6 = iArr[(((i3 - i2) * width) + i4) + i2];
                    int i7 = iArr[((i3 - i2) * width) + i4];
                    int i8 = iArr[(((i3 + i2) * width) + i4) - i2];
                    int i9 = iArr[(((i3 + i2) * width) + i4) + i2];
                    int i10 = iArr[((i3 + i2) * width) + i4];
                    int i11 = iArr[((i3 * width) + i4) - i2];
                    int i12 = iArr[((i3 * width) + i4) + i2];
                    int i13 = i7 & ALPHA_MAX;
                    i13 = i8 & ALPHA_MAX;
                    i13 = i9 & ALPHA_MAX;
                    i13 = i10 & ALPHA_MAX;
                    i13 = i11 & ALPHA_MAX;
                    i13 = i12 & ALPHA_MAX;
                    i5 = (((((((((i5 & 16711680) + (i6 & 16711680)) + (16711680 & i7)) + (16711680 & i8)) + (16711680 & i9)) + (16711680 & i10)) + (16711680 & i11)) + (16711680 & i12)) >> 3) & 16711680;
                    iArr[(i3 * width) + i4] = i5 | ((ViewCompat.MEASURED_STATE_MASK | ((((((((((i5 & ALPHA_MAX) + (i6 & ALPHA_MAX)) + r0) + r0) + r0) + r0) + r0) + r0) >> 3) & ALPHA_MAX)) | ((((((((((RangeSeekBar.ACTION_POINTER_INDEX_MASK & i5) + (RangeSeekBar.ACTION_POINTER_INDEX_MASK & i6)) + (RangeSeekBar.ACTION_POINTER_INDEX_MASK & i7)) + (RangeSeekBar.ACTION_POINTER_INDEX_MASK & i8)) + (RangeSeekBar.ACTION_POINTER_INDEX_MASK & i9)) + (RangeSeekBar.ACTION_POINTER_INDEX_MASK & i10)) + (RangeSeekBar.ACTION_POINTER_INDEX_MASK & i11)) + (RangeSeekBar.ACTION_POINTER_INDEX_MASK & i12)) >> 3) & RangeSeekBar.ACTION_POINTER_INDEX_MASK));
                }
            }
        }
        bitmap.setPixels(iArr, 0, width, 0, 0, width, height);
    }

    public void blurBitmap(Bitmap bitmap, int i) {
        this.mBlurRadius = i;
        make(bitmap);
    }

    private void make(Bitmap bitmap) {
        if (this.mBitmapWorkerTask != null) {
            this.mBitmapWorkerTask.cancel(true);
        }
        this.mBitmapWorkerTask = new BitmapWorkerTask(bitmap);
        this.mBitmapWorkerTask.execute(new Void[0]);
    }

    public void draw(@NonNull Canvas canvas) {
        if (this.mBmpToDraw != null && !this.mBmpToDraw.isRecycled()) {
            this.mPaint.setFilterBitmap(true);
            canvas.saveLayerAlpha(null, this.mAlpha, 31);
            this.mCanvasRect.set(0, 0, canvas.getWidth(), canvas.getHeight());
            this.mImageRect.set(HORIZ_EDGE_OFFSET, VERT_EDGE_OFFSET, this.mBmpToDraw.getWidth() - 12, this.mBmpToDraw.getHeight() - 24);
            canvas.drawBitmap(this.mBmpToDraw, this.mImageRect, this.mCanvasRect, this.mPaint);
        }
    }

    public void setAlpha(int i) {
        this.mAlpha = Math.min(ALPHA_MAX, i);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return this.mAlpha;
    }
}
