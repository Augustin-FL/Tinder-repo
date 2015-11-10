package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.TimeUnit;

public final class BatchResult implements Result {
    private final Status zzQA;
    private final PendingResult<?>[] zzYS;

    BatchResult(Status status, PendingResult<?>[] pendingResultArr) {
        this.zzQA = status;
        this.zzYS = pendingResultArr;
    }

    public Status getStatus() {
        return this.zzQA;
    }

    public <R extends Result> R take(BatchResultToken<R> batchResultToken) {
        zzx.zzb(batchResultToken.mId < this.zzYS.length, (Object) "The result token does not belong to this batch");
        return this.zzYS[batchResultToken.mId].await(0, TimeUnit.MILLISECONDS);
    }
}
