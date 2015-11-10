package com.facebook;

import android.os.Handler;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphRequest.OnProgressCallback;

class RequestProgress {
    private final Handler callbackHandler;
    private long lastReportedProgress;
    private long maxProgress;
    private long progress;
    private final GraphRequest request;
    private final long threshold;

    /* renamed from: com.facebook.RequestProgress.1 */
    class C05091 implements Runnable {
        final /* synthetic */ OnProgressCallback val$callbackCopy;
        final /* synthetic */ long val$currentCopy;
        final /* synthetic */ long val$maxProgressCopy;

        C05091(OnProgressCallback onProgressCallback, long j, long j2) {
            this.val$callbackCopy = onProgressCallback;
            this.val$currentCopy = j;
            this.val$maxProgressCopy = j2;
        }

        public void run() {
            this.val$callbackCopy.onProgress(this.val$currentCopy, this.val$maxProgressCopy);
        }
    }

    RequestProgress(Handler handler, GraphRequest graphRequest) {
        this.request = graphRequest;
        this.callbackHandler = handler;
        this.threshold = FacebookSdk.getOnProgressThreshold();
    }

    long getProgress() {
        return this.progress;
    }

    long getMaxProgress() {
        return this.maxProgress;
    }

    void addProgress(long j) {
        this.progress += j;
        if (this.progress >= this.lastReportedProgress + this.threshold || this.progress >= this.maxProgress) {
            reportProgress();
        }
    }

    void addToMax(long j) {
        this.maxProgress += j;
    }

    void reportProgress() {
        if (this.progress > this.lastReportedProgress) {
            Callback callback = this.request.getCallback();
            if (this.maxProgress > 0 && (callback instanceof OnProgressCallback)) {
                long j = this.progress;
                long j2 = this.maxProgress;
                OnProgressCallback onProgressCallback = (OnProgressCallback) callback;
                if (this.callbackHandler == null) {
                    onProgressCallback.onProgress(j, j2);
                } else {
                    this.callbackHandler.post(new C05091(onProgressCallback, j, j2));
                }
                this.lastReportedProgress = this.progress;
            }
        }
    }
}
